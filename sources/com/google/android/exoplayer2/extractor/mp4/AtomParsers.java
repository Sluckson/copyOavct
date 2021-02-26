package com.google.android.exoplayer2.extractor.mp4;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C1119C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.GaplessInfoHolder;
import com.google.android.exoplayer2.extractor.mp4.Atom;
import com.google.android.exoplayer2.extractor.mp4.FixedSampleSizeRechunker;
import com.google.android.exoplayer2.extractor.p008ts.PsExtractor;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.lowagie.text.html.HtmlTags;
import com.lowagie.text.pdf.codec.TIFFConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class AtomParsers {
    private static final int MAX_GAPLESS_TRIM_SIZE_SAMPLES = 4;
    private static final String TAG = "AtomParsers";
    private static final int TYPE_clcp = Util.getIntegerCodeForString("clcp");
    private static final int TYPE_mdta = Util.getIntegerCodeForString("mdta");
    private static final int TYPE_meta = Util.getIntegerCodeForString(HtmlTags.META);
    private static final int TYPE_sbtl = Util.getIntegerCodeForString("sbtl");
    private static final int TYPE_soun = Util.getIntegerCodeForString("soun");
    private static final int TYPE_subt = Util.getIntegerCodeForString("subt");
    private static final int TYPE_text = Util.getIntegerCodeForString("text");
    private static final int TYPE_vide = Util.getIntegerCodeForString("vide");
    private static final byte[] opusMagic = Util.getUtf8Bytes("OpusHead");

    private interface SampleSizeBox {
        int getSampleCount();

        boolean isFixedSampleSize();

        int readNextSampleSize();
    }

    public static Track parseTrak(Atom.ContainerAtom containerAtom, Atom.LeafAtom leafAtom, long j, DrmInitData drmInitData, boolean z, boolean z2) throws ParserException {
        long j2;
        Atom.LeafAtom leafAtom2;
        long[] jArr;
        long[] jArr2;
        Atom.ContainerAtom containerAtom2 = containerAtom;
        Atom.ContainerAtom containerAtomOfType = containerAtom2.getContainerAtomOfType(Atom.TYPE_mdia);
        int trackTypeForHdlr = getTrackTypeForHdlr(parseHdlr(containerAtomOfType.getLeafAtomOfType(Atom.TYPE_hdlr).data));
        if (trackTypeForHdlr == -1) {
            return null;
        }
        TkhdData parseTkhd = parseTkhd(containerAtom2.getLeafAtomOfType(Atom.TYPE_tkhd).data);
        long j3 = C1119C.TIME_UNSET;
        if (j == C1119C.TIME_UNSET) {
            j2 = parseTkhd.duration;
            leafAtom2 = leafAtom;
        } else {
            leafAtom2 = leafAtom;
            j2 = j;
        }
        long parseMvhd = parseMvhd(leafAtom2.data);
        if (j2 != C1119C.TIME_UNSET) {
            j3 = Util.scaleLargeTimestamp(j2, 1000000, parseMvhd);
        }
        long j4 = j3;
        Atom.ContainerAtom containerAtomOfType2 = containerAtomOfType.getContainerAtomOfType(Atom.TYPE_minf).getContainerAtomOfType(Atom.TYPE_stbl);
        Pair<Long, String> parseMdhd = parseMdhd(containerAtomOfType.getLeafAtomOfType(Atom.TYPE_mdhd).data);
        StsdData parseStsd = parseStsd(containerAtomOfType2.getLeafAtomOfType(Atom.TYPE_stsd).data, parseTkhd.f124id, parseTkhd.rotationDegrees, (String) parseMdhd.second, drmInitData, z2);
        if (!z) {
            Pair<long[], long[]> parseEdts = parseEdts(containerAtom2.getContainerAtomOfType(Atom.TYPE_edts));
            jArr = (long[]) parseEdts.second;
            jArr2 = (long[]) parseEdts.first;
        } else {
            jArr2 = null;
            jArr = null;
        }
        if (parseStsd.format == null) {
            return null;
        }
        return new Track(parseTkhd.f124id, trackTypeForHdlr, ((Long) parseMdhd.first).longValue(), parseMvhd, j4, parseStsd.format, parseStsd.requiredSampleTransformation, parseStsd.trackEncryptionBoxes, parseStsd.nalUnitLengthFieldLength, jArr2, jArr);
    }

    public static TrackSampleTable parseStbl(Track track, Atom.ContainerAtom containerAtom, GaplessInfoHolder gaplessInfoHolder) throws ParserException {
        SampleSizeBox sampleSizeBox;
        boolean z;
        int i;
        int i2;
        int i3;
        long j;
        int[] iArr;
        long[] jArr;
        int i4;
        int[] iArr2;
        long[] jArr2;
        int i5;
        int[] iArr3;
        long[] jArr3;
        int[] iArr4;
        int[] iArr5;
        int i6;
        boolean z2;
        int i7;
        boolean z3;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        Track track2 = track;
        Atom.ContainerAtom containerAtom2 = containerAtom;
        GaplessInfoHolder gaplessInfoHolder2 = gaplessInfoHolder;
        Atom.LeafAtom leafAtomOfType = containerAtom2.getLeafAtomOfType(Atom.TYPE_stsz);
        if (leafAtomOfType != null) {
            sampleSizeBox = new StszSampleSizeBox(leafAtomOfType);
        } else {
            Atom.LeafAtom leafAtomOfType2 = containerAtom2.getLeafAtomOfType(Atom.TYPE_stz2);
            if (leafAtomOfType2 != null) {
                sampleSizeBox = new Stz2SampleSizeBox(leafAtomOfType2);
            } else {
                throw new ParserException("Track has no sample table size information");
            }
        }
        int sampleCount = sampleSizeBox.getSampleCount();
        if (sampleCount == 0) {
            return new TrackSampleTable(track, new long[0], new int[0], 0, new long[0], new int[0], C1119C.TIME_UNSET);
        }
        Atom.LeafAtom leafAtomOfType3 = containerAtom2.getLeafAtomOfType(Atom.TYPE_stco);
        if (leafAtomOfType3 == null) {
            leafAtomOfType3 = containerAtom2.getLeafAtomOfType(Atom.TYPE_co64);
            z = true;
        } else {
            z = false;
        }
        ParsableByteArray parsableByteArray = leafAtomOfType3.data;
        ParsableByteArray parsableByteArray2 = containerAtom2.getLeafAtomOfType(Atom.TYPE_stsc).data;
        ParsableByteArray parsableByteArray3 = containerAtom2.getLeafAtomOfType(Atom.TYPE_stts).data;
        Atom.LeafAtom leafAtomOfType4 = containerAtom2.getLeafAtomOfType(Atom.TYPE_stss);
        ParsableByteArray parsableByteArray4 = leafAtomOfType4 != null ? leafAtomOfType4.data : null;
        Atom.LeafAtom leafAtomOfType5 = containerAtom2.getLeafAtomOfType(Atom.TYPE_ctts);
        ParsableByteArray parsableByteArray5 = leafAtomOfType5 != null ? leafAtomOfType5.data : null;
        ChunkIterator chunkIterator = new ChunkIterator(parsableByteArray2, parsableByteArray, z);
        parsableByteArray3.setPosition(12);
        int readUnsignedIntToInt = parsableByteArray3.readUnsignedIntToInt() - 1;
        int readUnsignedIntToInt2 = parsableByteArray3.readUnsignedIntToInt();
        int readUnsignedIntToInt3 = parsableByteArray3.readUnsignedIntToInt();
        if (parsableByteArray5 != null) {
            parsableByteArray5.setPosition(12);
            i = parsableByteArray5.readUnsignedIntToInt();
        } else {
            i = 0;
        }
        int i15 = -1;
        if (parsableByteArray4 != null) {
            parsableByteArray4.setPosition(12);
            i2 = parsableByteArray4.readUnsignedIntToInt();
            if (i2 > 0) {
                i15 = parsableByteArray4.readUnsignedIntToInt() - 1;
            } else {
                parsableByteArray4 = null;
            }
        } else {
            i2 = 0;
        }
        if (!(sampleSizeBox.isFixedSampleSize() && MimeTypes.AUDIO_RAW.equals(track2.format.sampleMimeType) && readUnsignedIntToInt == 0 && i == 0 && i2 == 0)) {
            long[] jArr4 = new long[sampleCount];
            int[] iArr6 = new int[sampleCount];
            long[] jArr5 = new long[sampleCount];
            int i16 = i2;
            iArr = new int[sampleCount];
            int i17 = readUnsignedIntToInt;
            ParsableByteArray parsableByteArray6 = parsableByteArray3;
            int i18 = readUnsignedIntToInt3;
            int i19 = i15;
            long j2 = 0;
            long j3 = 0;
            int i20 = 0;
            int i21 = 0;
            int i22 = 0;
            int i23 = 0;
            int i24 = 0;
            int i25 = i;
            int i26 = i16;
            int i27 = i25;
            while (true) {
                if (i21 >= sampleCount) {
                    i3 = sampleCount;
                    i7 = readUnsignedIntToInt2;
                    break;
                }
                long j4 = j3;
                boolean z4 = true;
                while (i22 == 0) {
                    z4 = chunkIterator.moveNext();
                    if (!z4) {
                        break;
                    }
                    int i28 = readUnsignedIntToInt2;
                    long j5 = chunkIterator.offset;
                    i22 = chunkIterator.numSamples;
                    j4 = j5;
                    readUnsignedIntToInt2 = i28;
                    i18 = i18;
                    sampleCount = sampleCount;
                }
                int i29 = sampleCount;
                i7 = readUnsignedIntToInt2;
                int i30 = i18;
                if (!z4) {
                    Log.m54w(TAG, "Unexpected end of chunk data");
                    jArr4 = Arrays.copyOf(jArr4, i21);
                    iArr6 = Arrays.copyOf(iArr6, i21);
                    jArr5 = Arrays.copyOf(jArr5, i21);
                    iArr = Arrays.copyOf(iArr, i21);
                    i3 = i21;
                    break;
                }
                if (parsableByteArray5 != null) {
                    int i31 = i27;
                    while (i23 == 0 && i31 > 0) {
                        i23 = parsableByteArray5.readUnsignedIntToInt();
                        i24 = parsableByteArray5.readInt();
                        i31--;
                    }
                    i23--;
                    i10 = i31;
                } else {
                    i10 = i27;
                }
                int i32 = i24;
                jArr4[i21] = j4;
                iArr6[i21] = sampleSizeBox.readNextSampleSize();
                if (iArr6[i21] > i20) {
                    i20 = iArr6[i21];
                }
                jArr5[i21] = j2 + ((long) i32);
                iArr[i21] = parsableByteArray4 == null ? 1 : 0;
                if (i21 == i19) {
                    iArr[i21] = 1;
                    i26--;
                    if (i26 > 0) {
                        i12 = parsableByteArray4.readUnsignedIntToInt() - 1;
                        i11 = i20;
                        i13 = i32;
                        int i33 = i30;
                        j2 += (long) i33;
                        i14 = i7 - 1;
                        if (i14 == 0 && i17 > 0) {
                            i14 = parsableByteArray6.readUnsignedIntToInt();
                            i17--;
                            i33 = parsableByteArray6.readInt();
                        }
                        i22--;
                        i21++;
                        i24 = i13;
                        readUnsignedIntToInt2 = i14;
                        j3 = j4 + ((long) iArr6[i21]);
                        i20 = i11;
                        i27 = i10;
                        sampleCount = i29;
                        int i34 = i33;
                        i19 = i12;
                        i18 = i34;
                    }
                }
                i11 = i20;
                i13 = i32;
                i12 = i19;
                int i332 = i30;
                j2 += (long) i332;
                i14 = i7 - 1;
                i14 = parsableByteArray6.readUnsignedIntToInt();
                i17--;
                i332 = parsableByteArray6.readInt();
                i22--;
                i21++;
                i24 = i13;
                readUnsignedIntToInt2 = i14;
                j3 = j4 + ((long) iArr6[i21]);
                i20 = i11;
                i27 = i10;
                sampleCount = i29;
                int i342 = i332;
                i19 = i12;
                i18 = i342;
            }
            int i35 = i22;
            j = j2 + ((long) i24);
            int i36 = i27;
            while (true) {
                if (i36 <= 0) {
                    z3 = true;
                    break;
                } else if (parsableByteArray5.readUnsignedIntToInt() != 0) {
                    z3 = false;
                    break;
                } else {
                    parsableByteArray5.readInt();
                    i36--;
                }
            }
            if (i26 == 0 && i7 == 0 && i35 == 0 && i17 == 0) {
                i9 = i23;
                if (i9 == 0 && z3) {
                    i8 = i20;
                    track2 = track;
                    jArr2 = jArr4;
                    jArr = jArr5;
                    i4 = i8;
                    iArr2 = iArr6;
                }
            } else {
                i9 = i23;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Inconsistent stbl box for track ");
            i8 = i20;
            track2 = track;
            sb.append(track2.f125id);
            sb.append(": remainingSynchronizationSamples ");
            sb.append(i26);
            sb.append(", remainingSamplesAtTimestampDelta ");
            sb.append(i7);
            sb.append(", remainingSamplesInChunk ");
            sb.append(i35);
            sb.append(", remainingTimestampDeltaChanges ");
            sb.append(i17);
            sb.append(", remainingSamplesAtTimestampOffset ");
            sb.append(i9);
            sb.append(!z3 ? ", ctts invalid" : "");
            Log.m54w(TAG, sb.toString());
            jArr2 = jArr4;
            jArr = jArr5;
            i4 = i8;
            iArr2 = iArr6;
        } else {
            i3 = sampleCount;
            long[] jArr6 = new long[chunkIterator.length];
            int[] iArr7 = new int[chunkIterator.length];
            while (chunkIterator.moveNext()) {
                jArr6[chunkIterator.index] = chunkIterator.offset;
                iArr7[chunkIterator.index] = chunkIterator.numSamples;
            }
            FixedSampleSizeRechunker.Results rechunk = FixedSampleSizeRechunker.rechunk(Util.getPcmFrameSize(track2.format.pcmEncoding, track2.format.channelCount), jArr6, iArr7, (long) readUnsignedIntToInt3);
            jArr2 = rechunk.offsets;
            iArr2 = rechunk.sizes;
            i4 = rechunk.maximumSize;
            jArr = rechunk.timestamps;
            iArr = rechunk.flags;
            j = rechunk.duration;
        }
        int i37 = i3;
        long scaleLargeTimestamp = Util.scaleLargeTimestamp(j, 1000000, track2.timescale);
        if (track2.editListDurations == null || gaplessInfoHolder.hasGaplessInfo()) {
            long[] jArr7 = jArr2;
            long[] jArr8 = jArr;
            Util.scaleLargeTimestampsInPlace(jArr8, 1000000, track2.timescale);
            return new TrackSampleTable(track, jArr7, iArr2, i4, jArr8, iArr, scaleLargeTimestamp);
        }
        if (track2.editListDurations.length == 1 && track2.type == 1 && jArr.length >= 2) {
            long j6 = track2.editListMediaTimes[0];
            long scaleLargeTimestamp2 = j6 + Util.scaleLargeTimestamp(track2.editListDurations[0], track2.timescale, track2.movieTimescale);
            iArr3 = iArr2;
            i5 = i4;
            if (canApplyEditWithGaplessInfo(jArr, j, j6, scaleLargeTimestamp2)) {
                long j7 = j - scaleLargeTimestamp2;
                long scaleLargeTimestamp3 = Util.scaleLargeTimestamp(j6 - jArr[0], (long) track2.format.sampleRate, track2.timescale);
                long scaleLargeTimestamp4 = Util.scaleLargeTimestamp(j7, (long) track2.format.sampleRate, track2.timescale);
                if (!(scaleLargeTimestamp3 == 0 && scaleLargeTimestamp4 == 0) && scaleLargeTimestamp3 <= 2147483647L && scaleLargeTimestamp4 <= 2147483647L) {
                    int i38 = (int) scaleLargeTimestamp3;
                    GaplessInfoHolder gaplessInfoHolder3 = gaplessInfoHolder;
                    gaplessInfoHolder3.encoderDelay = i38;
                    gaplessInfoHolder3.encoderPadding = (int) scaleLargeTimestamp4;
                    Util.scaleLargeTimestampsInPlace(jArr, 1000000, track2.timescale);
                    return new TrackSampleTable(track, jArr2, iArr3, i5, jArr, iArr, Util.scaleLargeTimestamp(track2.editListDurations[0], 1000000, track2.movieTimescale));
                }
            }
        } else {
            iArr3 = iArr2;
            i5 = i4;
        }
        if (track2.editListDurations.length == 1 && track2.editListDurations[0] == 0) {
            long j8 = track2.editListMediaTimes[0];
            for (int i39 = 0; i39 < jArr.length; i39++) {
                jArr[i39] = Util.scaleLargeTimestamp(jArr[i39] - j8, 1000000, track2.timescale);
            }
            return new TrackSampleTable(track, jArr2, iArr3, i5, jArr, iArr, Util.scaleLargeTimestamp(j - j8, 1000000, track2.timescale));
        }
        boolean z5 = track2.type == 1;
        int[] iArr8 = new int[track2.editListDurations.length];
        int[] iArr9 = new int[track2.editListDurations.length];
        int i40 = 0;
        boolean z6 = false;
        int i41 = 0;
        int i42 = 0;
        while (i40 < track2.editListDurations.length) {
            long j9 = track2.editListMediaTimes[i40];
            if (j9 != -1) {
                int i43 = i42;
                boolean z7 = z6;
                int i44 = i41;
                long scaleLargeTimestamp5 = Util.scaleLargeTimestamp(track2.editListDurations[i40], track2.timescale, track2.movieTimescale);
                iArr8[i40] = Util.binarySearchCeil(jArr, j9, true, true);
                iArr9[i40] = Util.binarySearchCeil(jArr, j9 + scaleLargeTimestamp5, z5, false);
                while (iArr8[i40] < iArr9[i40] && (iArr[iArr8[i40]] & 1) == 0) {
                    iArr8[i40] = iArr8[i40] + 1;
                }
                i41 = i44 + (iArr9[i40] - iArr8[i40]);
                z2 = z7 | (i43 != iArr8[i40]);
                i6 = iArr9[i40];
            } else {
                int i45 = i41;
                i6 = i42;
                z2 = z6;
            }
            i40++;
            z6 = z2;
            i42 = i6;
        }
        boolean z8 = z6;
        int i46 = 0;
        boolean z9 = true;
        if (i41 == i37) {
            z9 = false;
        }
        boolean z10 = z8 | z9;
        long[] jArr9 = z10 ? new long[i41] : jArr2;
        int[] iArr10 = z10 ? new int[i41] : iArr3;
        int i47 = z10 ? 0 : i5;
        int[] iArr11 = z10 ? new int[i41] : iArr;
        long[] jArr10 = new long[i41];
        int i48 = i47;
        long j10 = 0;
        int i49 = 0;
        while (i46 < track2.editListDurations.length) {
            long j11 = track2.editListMediaTimes[i46];
            int i50 = iArr8[i46];
            int[] iArr12 = iArr8;
            int i51 = iArr9[i46];
            if (z10) {
                iArr4 = iArr9;
                int i52 = i51 - i50;
                System.arraycopy(jArr2, i50, jArr9, i49, i52);
                jArr3 = jArr2;
                iArr5 = iArr3;
                System.arraycopy(iArr5, i50, iArr10, i49, i52);
                System.arraycopy(iArr, i50, iArr11, i49, i52);
            } else {
                jArr3 = jArr2;
                iArr4 = iArr9;
                iArr5 = iArr3;
            }
            int i53 = i48;
            while (i50 < i51) {
                long[] jArr11 = jArr9;
                int i54 = i51;
                long[] jArr12 = jArr;
                int[] iArr13 = iArr;
                jArr10[i49] = Util.scaleLargeTimestamp(j10, 1000000, track2.movieTimescale) + Util.scaleLargeTimestamp(jArr[i50] - j11, 1000000, track2.timescale);
                if (z10 && iArr10[i49] > i53) {
                    i53 = iArr5[i50];
                }
                i49++;
                i50++;
                i51 = i54;
                jArr9 = jArr11;
                jArr = jArr12;
                iArr = iArr13;
            }
            int[] iArr14 = iArr;
            j10 += track2.editListDurations[i46];
            i46++;
            i48 = i53;
            jArr9 = jArr9;
            jArr = jArr;
            iArr8 = iArr12;
            iArr9 = iArr4;
            iArr3 = iArr5;
            jArr2 = jArr3;
        }
        return new TrackSampleTable(track, jArr9, iArr10, i48, jArr10, iArr11, Util.scaleLargeTimestamp(j10, 1000000, track2.movieTimescale));
    }

    @Nullable
    public static Metadata parseUdta(Atom.LeafAtom leafAtom, boolean z) {
        if (z) {
            return null;
        }
        ParsableByteArray parsableByteArray = leafAtom.data;
        parsableByteArray.setPosition(8);
        while (parsableByteArray.bytesLeft() >= 8) {
            int position = parsableByteArray.getPosition();
            int readInt = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == Atom.TYPE_meta) {
                parsableByteArray.setPosition(position);
                return parseUdtaMeta(parsableByteArray, position + readInt);
            }
            parsableByteArray.setPosition(position + readInt);
        }
        return null;
    }

    @Nullable
    public static Metadata parseMdtaFromMeta(Atom.ContainerAtom containerAtom) {
        Atom.LeafAtom leafAtomOfType = containerAtom.getLeafAtomOfType(Atom.TYPE_hdlr);
        Atom.LeafAtom leafAtomOfType2 = containerAtom.getLeafAtomOfType(Atom.TYPE_keys);
        Atom.LeafAtom leafAtomOfType3 = containerAtom.getLeafAtomOfType(Atom.TYPE_ilst);
        if (leafAtomOfType == null || leafAtomOfType2 == null || leafAtomOfType3 == null || parseHdlr(leafAtomOfType.data) != TYPE_mdta) {
            return null;
        }
        ParsableByteArray parsableByteArray = leafAtomOfType2.data;
        parsableByteArray.setPosition(12);
        int readInt = parsableByteArray.readInt();
        String[] strArr = new String[readInt];
        for (int i = 0; i < readInt; i++) {
            int readInt2 = parsableByteArray.readInt();
            parsableByteArray.skipBytes(4);
            strArr[i] = parsableByteArray.readString(readInt2 - 8);
        }
        ParsableByteArray parsableByteArray2 = leafAtomOfType3.data;
        parsableByteArray2.setPosition(8);
        ArrayList arrayList = new ArrayList();
        while (parsableByteArray2.bytesLeft() > 8) {
            int position = parsableByteArray2.getPosition();
            int readInt3 = parsableByteArray2.readInt();
            int readInt4 = parsableByteArray2.readInt() - 1;
            if (readInt4 < 0 || readInt4 >= strArr.length) {
                Log.m54w(TAG, "Skipped metadata with unknown key index: " + readInt4);
            } else {
                MdtaMetadataEntry parseMdtaMetadataEntryFromIlst = MetadataUtil.parseMdtaMetadataEntryFromIlst(parsableByteArray2, position + readInt3, strArr[readInt4]);
                if (parseMdtaMetadataEntryFromIlst != null) {
                    arrayList.add(parseMdtaMetadataEntryFromIlst);
                }
            }
            parsableByteArray2.setPosition(position + readInt3);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata((List<? extends Metadata.Entry>) arrayList);
    }

    @Nullable
    private static Metadata parseUdtaMeta(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.skipBytes(12);
        while (parsableByteArray.getPosition() < i) {
            int position = parsableByteArray.getPosition();
            int readInt = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == Atom.TYPE_ilst) {
                parsableByteArray.setPosition(position);
                return parseIlst(parsableByteArray, position + readInt);
            }
            parsableByteArray.setPosition(position + readInt);
        }
        return null;
    }

    @Nullable
    private static Metadata parseIlst(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.skipBytes(8);
        ArrayList arrayList = new ArrayList();
        while (parsableByteArray.getPosition() < i) {
            Metadata.Entry parseIlstElement = MetadataUtil.parseIlstElement(parsableByteArray);
            if (parseIlstElement != null) {
                arrayList.add(parseIlstElement);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata((List<? extends Metadata.Entry>) arrayList);
    }

    private static long parseMvhd(ParsableByteArray parsableByteArray) {
        int i = 8;
        parsableByteArray.setPosition(8);
        if (Atom.parseFullAtomVersion(parsableByteArray.readInt()) != 0) {
            i = 16;
        }
        parsableByteArray.skipBytes(i);
        return parsableByteArray.readUnsignedInt();
    }

    private static TkhdData parseTkhd(ParsableByteArray parsableByteArray) {
        boolean z;
        int i = 8;
        parsableByteArray.setPosition(8);
        int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        parsableByteArray.skipBytes(parseFullAtomVersion == 0 ? 8 : 16);
        int readInt = parsableByteArray.readInt();
        parsableByteArray.skipBytes(4);
        int position = parsableByteArray.getPosition();
        if (parseFullAtomVersion == 0) {
            i = 4;
        }
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i3 >= i) {
                z = true;
                break;
            } else if (parsableByteArray.data[position + i3] != -1) {
                z = false;
                break;
            } else {
                i3++;
            }
        }
        long j = C1119C.TIME_UNSET;
        if (z) {
            parsableByteArray.skipBytes(i);
        } else {
            long readUnsignedInt = parseFullAtomVersion == 0 ? parsableByteArray.readUnsignedInt() : parsableByteArray.readUnsignedLongToLong();
            if (readUnsignedInt != 0) {
                j = readUnsignedInt;
            }
        }
        parsableByteArray.skipBytes(16);
        int readInt2 = parsableByteArray.readInt();
        int readInt3 = parsableByteArray.readInt();
        parsableByteArray.skipBytes(4);
        int readInt4 = parsableByteArray.readInt();
        int readInt5 = parsableByteArray.readInt();
        if (readInt2 == 0 && readInt3 == 65536 && readInt4 == -65536 && readInt5 == 0) {
            i2 = 90;
        } else if (readInt2 == 0 && readInt3 == -65536 && readInt4 == 65536 && readInt5 == 0) {
            i2 = TIFFConstants.TIFFTAG_IMAGEDESCRIPTION;
        } else if (readInt2 == -65536 && readInt3 == 0 && readInt4 == 0 && readInt5 == -65536) {
            i2 = 180;
        }
        return new TkhdData(readInt, j, i2);
    }

    private static int parseHdlr(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(16);
        return parsableByteArray.readInt();
    }

    private static int getTrackTypeForHdlr(int i) {
        if (i == TYPE_soun) {
            return 1;
        }
        if (i == TYPE_vide) {
            return 2;
        }
        if (i == TYPE_text || i == TYPE_sbtl || i == TYPE_subt || i == TYPE_clcp) {
            return 3;
        }
        return i == TYPE_meta ? 4 : -1;
    }

    private static Pair<Long, String> parseMdhd(ParsableByteArray parsableByteArray) {
        int i = 8;
        parsableByteArray.setPosition(8);
        int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        parsableByteArray.skipBytes(parseFullAtomVersion == 0 ? 8 : 16);
        long readUnsignedInt = parsableByteArray.readUnsignedInt();
        if (parseFullAtomVersion == 0) {
            i = 4;
        }
        parsableByteArray.skipBytes(i);
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        return Pair.create(Long.valueOf(readUnsignedInt), "" + ((char) (((readUnsignedShort >> 10) & 31) + 96)) + ((char) (((readUnsignedShort >> 5) & 31) + 96)) + ((char) ((readUnsignedShort & 31) + 96)));
    }

    private static StsdData parseStsd(ParsableByteArray parsableByteArray, int i, int i2, String str, DrmInitData drmInitData, boolean z) throws ParserException {
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        parsableByteArray2.setPosition(12);
        int readInt = parsableByteArray.readInt();
        StsdData stsdData = new StsdData(readInt);
        for (int i3 = 0; i3 < readInt; i3++) {
            int position = parsableByteArray.getPosition();
            int readInt2 = parsableByteArray.readInt();
            Assertions.checkArgument(readInt2 > 0, "childAtomSize should be positive");
            int readInt3 = parsableByteArray.readInt();
            if (readInt3 == Atom.TYPE_avc1 || readInt3 == Atom.TYPE_avc3 || readInt3 == Atom.TYPE_encv || readInt3 == Atom.TYPE_mp4v || readInt3 == Atom.TYPE_hvc1 || readInt3 == Atom.TYPE_hev1 || readInt3 == Atom.TYPE_s263 || readInt3 == Atom.TYPE_vp08 || readInt3 == Atom.TYPE_vp09 || readInt3 == Atom.TYPE_av01 || readInt3 == Atom.TYPE_dvav || readInt3 == Atom.TYPE_dva1 || readInt3 == Atom.TYPE_dvhe || readInt3 == Atom.TYPE_dvh1) {
                parseVideoSampleEntry(parsableByteArray, readInt3, position, readInt2, i, i2, drmInitData, stsdData, i3);
            } else if (readInt3 == Atom.TYPE_mp4a || readInt3 == Atom.TYPE_enca || readInt3 == Atom.TYPE_ac_3 || readInt3 == Atom.TYPE_ec_3 || readInt3 == Atom.TYPE_ac_4 || readInt3 == Atom.TYPE_dtsc || readInt3 == Atom.TYPE_dtse || readInt3 == Atom.TYPE_dtsh || readInt3 == Atom.TYPE_dtsl || readInt3 == Atom.TYPE_samr || readInt3 == Atom.TYPE_sawb || readInt3 == Atom.TYPE_lpcm || readInt3 == Atom.TYPE_sowt || readInt3 == Atom.TYPE__mp3 || readInt3 == Atom.TYPE_alac || readInt3 == Atom.TYPE_alaw || readInt3 == Atom.TYPE_ulaw || readInt3 == Atom.TYPE_Opus || readInt3 == Atom.TYPE_fLaC) {
                parseAudioSampleEntry(parsableByteArray, readInt3, position, readInt2, i, str, z, drmInitData, stsdData, i3);
            } else if (readInt3 == Atom.TYPE_TTML || readInt3 == Atom.TYPE_tx3g || readInt3 == Atom.TYPE_wvtt || readInt3 == Atom.TYPE_stpp || readInt3 == Atom.TYPE_c608) {
                parseTextSampleEntry(parsableByteArray, readInt3, position, readInt2, i, str, stsdData);
            } else if (readInt3 == Atom.TYPE_camm) {
                stsdData.format = Format.createSampleFormat(Integer.toString(i), MimeTypes.APPLICATION_CAMERA_MOTION, (String) null, -1, (DrmInitData) null);
            }
            parsableByteArray2.setPosition(position + readInt2);
        }
        return stsdData;
    }

    private static void parseTextSampleEntry(ParsableByteArray parsableByteArray, int i, int i2, int i3, int i4, String str, StsdData stsdData) throws ParserException {
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        int i5 = i;
        StsdData stsdData2 = stsdData;
        parsableByteArray2.setPosition(i2 + 8 + 8);
        int i6 = Atom.TYPE_TTML;
        String str2 = MimeTypes.APPLICATION_TTML;
        List list = null;
        long j = Long.MAX_VALUE;
        if (i5 != i6) {
            if (i5 == Atom.TYPE_tx3g) {
                int i7 = (i3 - 8) - 8;
                byte[] bArr = new byte[i7];
                parsableByteArray2.readBytes(bArr, 0, i7);
                list = Collections.singletonList(bArr);
                str2 = MimeTypes.APPLICATION_TX3G;
            } else if (i5 == Atom.TYPE_wvtt) {
                str2 = MimeTypes.APPLICATION_MP4VTT;
            } else if (i5 == Atom.TYPE_stpp) {
                j = 0;
            } else if (i5 == Atom.TYPE_c608) {
                stsdData2.requiredSampleTransformation = 1;
                str2 = MimeTypes.APPLICATION_MP4CEA608;
            } else {
                throw new IllegalStateException();
            }
        }
        stsdData2.format = Format.createTextSampleFormat(Integer.toString(i4), str2, (String) null, -1, 0, str, -1, (DrmInitData) null, j, list);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void parseVideoSampleEntry(com.google.android.exoplayer2.util.ParsableByteArray r21, int r22, int r23, int r24, int r25, int r26, com.google.android.exoplayer2.drm.DrmInitData r27, com.google.android.exoplayer2.extractor.mp4.AtomParsers.StsdData r28, int r29) throws com.google.android.exoplayer2.ParserException {
        /*
            r0 = r21
            r1 = r23
            r2 = r24
            r3 = r27
            r4 = r28
            int r5 = r1 + 8
            int r5 = r5 + 8
            r0.setPosition(r5)
            r5 = 16
            r0.skipBytes(r5)
            int r11 = r21.readUnsignedShort()
            int r12 = r21.readUnsignedShort()
            r5 = 50
            r0.skipBytes(r5)
            int r5 = r21.getPosition()
            int r6 = com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_encv
            r7 = 0
            r8 = r22
            if (r8 != r6) goto L_0x0055
            android.util.Pair r6 = parseSampleEntryEncryptionData(r0, r1, r2)
            if (r6 == 0) goto L_0x0052
            java.lang.Object r8 = r6.first
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            if (r3 != 0) goto L_0x0040
            r3 = r7
            goto L_0x004a
        L_0x0040:
            java.lang.Object r9 = r6.second
            com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox r9 = (com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox) r9
            java.lang.String r9 = r9.schemeType
            com.google.android.exoplayer2.drm.DrmInitData r3 = r3.copyWithSchemeType(r9)
        L_0x004a:
            com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox[] r9 = r4.trackEncryptionBoxes
            java.lang.Object r6 = r6.second
            com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox r6 = (com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox) r6
            r9[r29] = r6
        L_0x0052:
            r0.setPosition(r5)
        L_0x0055:
            r20 = r3
            r3 = -1
            r9 = 1065353216(0x3f800000, float:1.0)
            r3 = r7
            r14 = r3
            r17 = r14
            r9 = 0
            r16 = 1065353216(0x3f800000, float:1.0)
            r18 = -1
        L_0x0063:
            int r10 = r5 - r1
            if (r10 >= r2) goto L_0x017d
            r0.setPosition(r5)
            int r10 = r21.getPosition()
            int r13 = r21.readInt()
            if (r13 != 0) goto L_0x007d
            int r15 = r21.getPosition()
            int r15 = r15 - r1
            if (r15 != r2) goto L_0x007d
            goto L_0x017d
        L_0x007d:
            if (r13 <= 0) goto L_0x0081
            r6 = 1
            goto L_0x0082
        L_0x0081:
            r6 = 0
        L_0x0082:
            java.lang.String r15 = "childAtomSize should be positive"
            com.google.android.exoplayer2.util.Assertions.checkArgument(r6, r15)
            int r6 = r21.readInt()
            int r15 = com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_avcC
            r1 = 3
            if (r6 != r15) goto L_0x00b1
            if (r7 != 0) goto L_0x0094
            r1 = 1
            goto L_0x0095
        L_0x0094:
            r1 = 0
        L_0x0095:
            com.google.android.exoplayer2.util.Assertions.checkState(r1)
            int r10 = r10 + 8
            r0.setPosition(r10)
            com.google.android.exoplayer2.video.AvcConfig r1 = com.google.android.exoplayer2.video.AvcConfig.parse(r21)
            java.util.List<byte[]> r14 = r1.initializationData
            int r6 = r1.nalUnitLengthFieldLength
            r4.nalUnitLengthFieldLength = r6
            if (r9 != 0) goto L_0x00ad
            float r1 = r1.pixelWidthAspectRatio
            r16 = r1
        L_0x00ad:
            java.lang.String r7 = "video/avc"
            goto L_0x0178
        L_0x00b1:
            int r15 = com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_hvcC
            if (r6 != r15) goto L_0x00d0
            if (r7 != 0) goto L_0x00b9
            r1 = 1
            goto L_0x00ba
        L_0x00b9:
            r1 = 0
        L_0x00ba:
            com.google.android.exoplayer2.util.Assertions.checkState(r1)
            int r10 = r10 + 8
            r0.setPosition(r10)
            com.google.android.exoplayer2.video.HevcConfig r1 = com.google.android.exoplayer2.video.HevcConfig.parse(r21)
            java.util.List<byte[]> r14 = r1.initializationData
            int r1 = r1.nalUnitLengthFieldLength
            r4.nalUnitLengthFieldLength = r1
            java.lang.String r7 = "video/hevc"
            goto L_0x0178
        L_0x00d0:
            int r15 = com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_dvcC
            if (r6 == r15) goto L_0x0169
            int r15 = com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_dvvC
            if (r6 != r15) goto L_0x00da
            goto L_0x0169
        L_0x00da:
            int r15 = com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_vpcC
            if (r6 != r15) goto L_0x00f2
            if (r7 != 0) goto L_0x00e2
            r1 = 1
            goto L_0x00e3
        L_0x00e2:
            r1 = 0
        L_0x00e3:
            com.google.android.exoplayer2.util.Assertions.checkState(r1)
            int r1 = com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_vp08
            if (r8 != r1) goto L_0x00ed
            java.lang.String r1 = "video/x-vnd.on2.vp8"
            goto L_0x00ef
        L_0x00ed:
            java.lang.String r1 = "video/x-vnd.on2.vp9"
        L_0x00ef:
            r7 = r1
            goto L_0x0178
        L_0x00f2:
            int r15 = com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_av1C
            if (r6 != r15) goto L_0x0102
            if (r7 != 0) goto L_0x00fa
            r1 = 1
            goto L_0x00fb
        L_0x00fa:
            r1 = 0
        L_0x00fb:
            com.google.android.exoplayer2.util.Assertions.checkState(r1)
            java.lang.String r7 = "video/av01"
            goto L_0x0178
        L_0x0102:
            int r15 = com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_d263
            if (r6 != r15) goto L_0x0112
            if (r7 != 0) goto L_0x010a
            r1 = 1
            goto L_0x010b
        L_0x010a:
            r1 = 0
        L_0x010b:
            com.google.android.exoplayer2.util.Assertions.checkState(r1)
            java.lang.String r7 = "video/3gpp"
            goto L_0x0178
        L_0x0112:
            int r15 = com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_esds
            if (r6 != r15) goto L_0x012e
            if (r7 != 0) goto L_0x011a
            r1 = 1
            goto L_0x011b
        L_0x011a:
            r1 = 0
        L_0x011b:
            com.google.android.exoplayer2.util.Assertions.checkState(r1)
            android.util.Pair r1 = parseEsdsFromParent(r0, r10)
            java.lang.Object r6 = r1.first
            r7 = r6
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r1 = r1.second
            java.util.List r14 = java.util.Collections.singletonList(r1)
            goto L_0x0178
        L_0x012e:
            int r15 = com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_pasp
            if (r6 != r15) goto L_0x0138
            float r16 = parsePaspFromParent(r0, r10)
            r9 = 1
            goto L_0x0178
        L_0x0138:
            int r15 = com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_sv3d
            if (r6 != r15) goto L_0x0141
            byte[] r17 = parseProjFromParent(r0, r10, r13)
            goto L_0x0178
        L_0x0141:
            int r10 = com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_st3d
            if (r6 != r10) goto L_0x0178
            int r6 = r21.readUnsignedByte()
            r0.skipBytes(r1)
            if (r6 != 0) goto L_0x0178
            int r6 = r21.readUnsignedByte()
            if (r6 == 0) goto L_0x0166
            r10 = 1
            if (r6 == r10) goto L_0x0163
            r15 = 2
            if (r6 == r15) goto L_0x0160
            if (r6 == r1) goto L_0x015d
            goto L_0x0178
        L_0x015d:
            r18 = 3
            goto L_0x0178
        L_0x0160:
            r18 = 2
            goto L_0x0178
        L_0x0163:
            r18 = 1
            goto L_0x0178
        L_0x0166:
            r18 = 0
            goto L_0x0178
        L_0x0169:
            com.google.android.exoplayer2.video.DolbyVisionConfig r1 = com.google.android.exoplayer2.video.DolbyVisionConfig.parse(r21)
            if (r1 == 0) goto L_0x0178
            int r6 = r1.profile
            r10 = 5
            if (r6 != r10) goto L_0x0178
            java.lang.String r3 = r1.codecs
            java.lang.String r7 = "video/dolby-vision"
        L_0x0178:
            int r5 = r5 + r13
            r1 = r23
            goto L_0x0063
        L_0x017d:
            if (r7 != 0) goto L_0x0180
            return
        L_0x0180:
            java.lang.String r6 = java.lang.Integer.toString(r25)
            r9 = -1
            r10 = -1
            r13 = -1082130432(0xffffffffbf800000, float:-1.0)
            r19 = 0
            r8 = r3
            r15 = r26
            com.google.android.exoplayer2.Format r0 = com.google.android.exoplayer2.Format.createVideoSampleFormat(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            r4.format = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mp4.AtomParsers.parseVideoSampleEntry(com.google.android.exoplayer2.util.ParsableByteArray, int, int, int, int, int, com.google.android.exoplayer2.drm.DrmInitData, com.google.android.exoplayer2.extractor.mp4.AtomParsers$StsdData, int):void");
    }

    private static Pair<long[], long[]> parseEdts(Atom.ContainerAtom containerAtom) {
        Atom.LeafAtom leafAtomOfType;
        if (containerAtom == null || (leafAtomOfType = containerAtom.getLeafAtomOfType(Atom.TYPE_elst)) == null) {
            return Pair.create((Object) null, (Object) null);
        }
        ParsableByteArray parsableByteArray = leafAtomOfType.data;
        parsableByteArray.setPosition(8);
        int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
        long[] jArr = new long[readUnsignedIntToInt];
        long[] jArr2 = new long[readUnsignedIntToInt];
        int i = 0;
        while (i < readUnsignedIntToInt) {
            jArr[i] = parseFullAtomVersion == 1 ? parsableByteArray.readUnsignedLongToLong() : parsableByteArray.readUnsignedInt();
            jArr2[i] = parseFullAtomVersion == 1 ? parsableByteArray.readLong() : (long) parsableByteArray.readInt();
            if (parsableByteArray.readShort() == 1) {
                parsableByteArray.skipBytes(2);
                i++;
            } else {
                throw new IllegalArgumentException("Unsupported media rate.");
            }
        }
        return Pair.create(jArr, jArr2);
    }

    private static float parsePaspFromParent(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.setPosition(i + 8);
        return ((float) parsableByteArray.readUnsignedIntToInt()) / ((float) parsableByteArray.readUnsignedIntToInt());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v4, resolved type: byte[]} */
    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x026b: MOVE  (r3v5 java.lang.String) = (r25v0 java.lang.String)
        	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:122)
        	at jadx.core.dex.visitors.regions.TernaryMod.visitRegion(TernaryMod.java:34)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:73)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:31)
        */
    /* JADX WARNING: Multi-variable type inference failed */
    private static void parseAudioSampleEntry(com.google.android.exoplayer2.util.ParsableByteArray r28, int r29, int r30, int r31, int r32, java.lang.String r33, boolean r34, com.google.android.exoplayer2.drm.DrmInitData r35, com.google.android.exoplayer2.extractor.mp4.AtomParsers.StsdData r36, int r37) throws com.google.android.exoplayer2.ParserException {
        /*
            r0 = r28
            r1 = r30
            r2 = r31
            r14 = r33
            r3 = r35
            r15 = r36
            int r4 = r1 + 8
            r5 = 8
            int r4 = r4 + r5
            r0.setPosition(r4)
            r4 = 6
            r13 = 0
            if (r34 == 0) goto L_0x0020
            int r5 = r28.readUnsignedShort()
            r0.skipBytes(r4)
            goto L_0x0024
        L_0x0020:
            r0.skipBytes(r5)
            r5 = 0
        L_0x0024:
            r12 = 2
            r6 = 16
            r11 = 1
            if (r5 == 0) goto L_0x0048
            if (r5 != r11) goto L_0x002d
            goto L_0x0048
        L_0x002d:
            if (r5 != r12) goto L_0x0047
            r0.skipBytes(r6)
            double r4 = r28.readDouble()
            long r4 = java.lang.Math.round(r4)
            int r5 = (int) r4
            int r4 = r28.readUnsignedIntToInt()
            r6 = 20
            r0.skipBytes(r6)
            r7 = r4
            r4 = r5
            goto L_0x0058
        L_0x0047:
            return
        L_0x0048:
            int r7 = r28.readUnsignedShort()
            r0.skipBytes(r4)
            int r4 = r28.readUnsignedFixedPoint1616()
            if (r5 != r11) goto L_0x0058
            r0.skipBytes(r6)
        L_0x0058:
            int r5 = r28.getPosition()
            int r6 = com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_enca
            r16 = 0
            r8 = r29
            if (r8 != r6) goto L_0x008c
            android.util.Pair r6 = parseSampleEntryEncryptionData(r0, r1, r2)
            if (r6 == 0) goto L_0x0089
            java.lang.Object r8 = r6.first
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            if (r3 != 0) goto L_0x0077
            r3 = r16
            goto L_0x0081
        L_0x0077:
            java.lang.Object r9 = r6.second
            com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox r9 = (com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox) r9
            java.lang.String r9 = r9.schemeType
            com.google.android.exoplayer2.drm.DrmInitData r3 = r3.copyWithSchemeType(r9)
        L_0x0081:
            com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox[] r9 = r15.trackEncryptionBoxes
            java.lang.Object r6 = r6.second
            com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox r6 = (com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox) r6
            r9[r37] = r6
        L_0x0089:
            r0.setPosition(r5)
        L_0x008c:
            r10 = r3
            int r3 = com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_ac_3
            java.lang.String r9 = "audio/raw"
            if (r8 != r3) goto L_0x0097
            java.lang.String r3 = "audio/ac3"
            goto L_0x0107
        L_0x0097:
            int r3 = com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_ec_3
            if (r8 != r3) goto L_0x009f
            java.lang.String r3 = "audio/eac3"
            goto L_0x0107
        L_0x009f:
            int r3 = com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_ac_4
            if (r8 != r3) goto L_0x00a7
            java.lang.String r3 = "audio/ac4"
            goto L_0x0107
        L_0x00a7:
            int r3 = com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_dtsc
            if (r8 != r3) goto L_0x00af
            java.lang.String r3 = "audio/vnd.dts"
            goto L_0x0107
        L_0x00af:
            int r3 = com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_dtsh
            if (r8 == r3) goto L_0x0105
            int r3 = com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_dtsl
            if (r8 != r3) goto L_0x00b8
            goto L_0x0105
        L_0x00b8:
            int r3 = com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_dtse
            if (r8 != r3) goto L_0x00bf
            java.lang.String r3 = "audio/vnd.dts.hd;profile=lbr"
            goto L_0x0107
        L_0x00bf:
            int r3 = com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_samr
            if (r8 != r3) goto L_0x00c6
            java.lang.String r3 = "audio/3gpp"
            goto L_0x0107
        L_0x00c6:
            int r3 = com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_sawb
            if (r8 != r3) goto L_0x00cd
            java.lang.String r3 = "audio/amr-wb"
            goto L_0x0107
        L_0x00cd:
            int r3 = com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_lpcm
            if (r8 == r3) goto L_0x0103
            int r3 = com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_sowt
            if (r8 != r3) goto L_0x00d6
            goto L_0x0103
        L_0x00d6:
            int r3 = com.google.android.exoplayer2.extractor.mp4.Atom.TYPE__mp3
            if (r8 != r3) goto L_0x00dd
            java.lang.String r3 = "audio/mpeg"
            goto L_0x0107
        L_0x00dd:
            int r3 = com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_alac
            if (r8 != r3) goto L_0x00e4
            java.lang.String r3 = "audio/alac"
            goto L_0x0107
        L_0x00e4:
            int r3 = com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_alaw
            if (r8 != r3) goto L_0x00eb
            java.lang.String r3 = "audio/g711-alaw"
            goto L_0x0107
        L_0x00eb:
            int r3 = com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_ulaw
            if (r8 != r3) goto L_0x00f2
            java.lang.String r3 = "audio/g711-mlaw"
            goto L_0x0107
        L_0x00f2:
            int r3 = com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_Opus
            if (r8 != r3) goto L_0x00f9
            java.lang.String r3 = "audio/opus"
            goto L_0x0107
        L_0x00f9:
            int r3 = com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_fLaC
            if (r8 != r3) goto L_0x0100
            java.lang.String r3 = "audio/flac"
            goto L_0x0107
        L_0x0100:
            r3 = r16
            goto L_0x0107
        L_0x0103:
            r3 = r9
            goto L_0x0107
        L_0x0105:
            java.lang.String r3 = "audio/vnd.dts.hd"
        L_0x0107:
            r18 = r4
            r8 = r5
            r17 = r7
            r19 = r16
            r7 = r3
        L_0x010f:
            int r3 = r8 - r1
            r4 = -1
            if (r3 >= r2) goto L_0x025f
            r0.setPosition(r8)
            int r6 = r28.readInt()
            if (r6 <= 0) goto L_0x011f
            r3 = 1
            goto L_0x0120
        L_0x011f:
            r3 = 0
        L_0x0120:
            java.lang.String r5 = "childAtomSize should be positive"
            com.google.android.exoplayer2.util.Assertions.checkArgument(r3, r5)
            int r3 = r28.readInt()
            int r5 = com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_esds
            if (r3 == r5) goto L_0x0208
            if (r34 == 0) goto L_0x0135
            int r5 = com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_wave
            if (r3 != r5) goto L_0x0135
            goto L_0x0208
        L_0x0135:
            int r4 = com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_dac3
            if (r3 != r4) goto L_0x0157
            int r3 = r8 + 8
            r0.setPosition(r3)
            java.lang.String r3 = java.lang.Integer.toString(r32)
            com.google.android.exoplayer2.Format r3 = com.google.android.exoplayer2.audio.Ac3Util.parseAc3AnnexFFormat(r0, r3, r14, r10)
            r15.format = r3
        L_0x0148:
            r5 = r6
            r25 = r7
            r7 = r8
            r27 = r9
            r20 = r10
            r1 = 0
            r21 = 1
            r22 = 2
            goto L_0x0250
        L_0x0157:
            int r4 = com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_dec3
            if (r3 != r4) goto L_0x016b
            int r3 = r8 + 8
            r0.setPosition(r3)
            java.lang.String r3 = java.lang.Integer.toString(r32)
            com.google.android.exoplayer2.Format r3 = com.google.android.exoplayer2.audio.Ac3Util.parseEAc3AnnexFFormat(r0, r3, r14, r10)
            r15.format = r3
            goto L_0x0148
        L_0x016b:
            int r4 = com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_dac4
            if (r3 != r4) goto L_0x017f
            int r3 = r8 + 8
            r0.setPosition(r3)
            java.lang.String r3 = java.lang.Integer.toString(r32)
            com.google.android.exoplayer2.Format r3 = com.google.android.exoplayer2.audio.Ac4Util.parseAc4AnnexEFormat(r0, r3, r14, r10)
            r15.format = r3
            goto L_0x0148
        L_0x017f:
            int r4 = com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_ddts
            if (r3 != r4) goto L_0x01bc
            java.lang.String r3 = java.lang.Integer.toString(r32)
            r5 = 0
            r20 = -1
            r21 = -1
            r22 = 0
            r23 = 0
            r4 = r7
            r24 = r6
            r6 = r20
            r25 = r7
            r7 = r21
            r26 = r8
            r8 = r17
            r27 = r9
            r9 = r18
            r20 = r10
            r10 = r22
            r21 = 1
            r11 = r20
            r22 = 2
            r12 = r23
            r1 = 0
            r13 = r33
            com.google.android.exoplayer2.Format r3 = com.google.android.exoplayer2.Format.createAudioSampleFormat(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            r15.format = r3
            r5 = r24
            r7 = r26
            goto L_0x0250
        L_0x01bc:
            r24 = r6
            r25 = r7
            r26 = r8
            r27 = r9
            r20 = r10
            r1 = 0
            r21 = 1
            r22 = 2
            int r4 = com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_dOps
            if (r3 != r4) goto L_0x01ed
            r5 = r24
            int r6 = r5 + -8
            byte[] r3 = opusMagic
            int r4 = r3.length
            int r4 = r4 + r6
            byte[] r4 = new byte[r4]
            int r7 = r3.length
            java.lang.System.arraycopy(r3, r1, r4, r1, r7)
            r7 = r26
            int r8 = r7 + 8
            r0.setPosition(r8)
            byte[] r3 = opusMagic
            int r3 = r3.length
            r0.readBytes(r4, r3, r6)
            r19 = r4
            goto L_0x0250
        L_0x01ed:
            r5 = r24
            r7 = r26
            int r4 = com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_dfLa
            if (r5 == r4) goto L_0x01f9
            int r4 = com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_alac
            if (r3 != r4) goto L_0x0250
        L_0x01f9:
            int r6 = r5 + -12
            byte[] r3 = new byte[r6]
            int r8 = r7 + 12
            r0.setPosition(r8)
            r0.readBytes(r3, r1, r6)
            r19 = r3
            goto L_0x0250
        L_0x0208:
            r5 = r6
            r25 = r7
            r7 = r8
            r27 = r9
            r20 = r10
            r1 = 0
            r21 = 1
            r22 = 2
            int r6 = com.google.android.exoplayer2.extractor.mp4.Atom.TYPE_esds
            if (r3 != r6) goto L_0x021b
            r8 = r7
            goto L_0x021f
        L_0x021b:
            int r8 = findEsdsPosition(r0, r7, r5)
        L_0x021f:
            if (r8 == r4) goto L_0x024c
            android.util.Pair r3 = parseEsdsFromParent(r0, r8)
            java.lang.Object r4 = r3.first
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r3 = r3.second
            r19 = r3
            byte[] r19 = (byte[]) r19
            java.lang.String r3 = "audio/mp4a-latm"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x024e
            android.util.Pair r3 = com.google.android.exoplayer2.util.CodecSpecificDataUtil.parseAacAudioSpecificConfig(r19)
            java.lang.Object r6 = r3.first
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r18 = r6.intValue()
            java.lang.Object r3 = r3.second
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r17 = r3.intValue()
            goto L_0x024e
        L_0x024c:
            r4 = r25
        L_0x024e:
            r25 = r4
        L_0x0250:
            int r8 = r7 + r5
            r1 = r30
            r10 = r20
            r7 = r25
            r9 = r27
            r11 = 1
            r12 = 2
            r13 = 0
            goto L_0x010f
        L_0x025f:
            r25 = r7
            r27 = r9
            r20 = r10
            r22 = 2
            com.google.android.exoplayer2.Format r0 = r15.format
            if (r0 != 0) goto L_0x029d
            r3 = r25
            if (r3 == 0) goto L_0x029d
            r0 = r27
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0279
            r7 = 2
            goto L_0x027a
        L_0x0279:
            r7 = -1
        L_0x027a:
            java.lang.String r0 = java.lang.Integer.toString(r32)
            r2 = 0
            r4 = -1
            r5 = -1
            if (r19 != 0) goto L_0x0286
            r8 = r16
            goto L_0x028b
        L_0x0286:
            java.util.List r1 = java.util.Collections.singletonList(r19)
            r8 = r1
        L_0x028b:
            r10 = 0
            r1 = r3
            r3 = r4
            r4 = r5
            r5 = r17
            r6 = r18
            r9 = r20
            r11 = r33
            com.google.android.exoplayer2.Format r0 = com.google.android.exoplayer2.Format.createAudioSampleFormat(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r15.format = r0
        L_0x029d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mp4.AtomParsers.parseAudioSampleEntry(com.google.android.exoplayer2.util.ParsableByteArray, int, int, int, int, java.lang.String, boolean, com.google.android.exoplayer2.drm.DrmInitData, com.google.android.exoplayer2.extractor.mp4.AtomParsers$StsdData, int):void");
    }

    private static int findEsdsPosition(ParsableByteArray parsableByteArray, int i, int i2) {
        int position = parsableByteArray.getPosition();
        while (position - i < i2) {
            parsableByteArray.setPosition(position);
            int readInt = parsableByteArray.readInt();
            Assertions.checkArgument(readInt > 0, "childAtomSize should be positive");
            if (parsableByteArray.readInt() == Atom.TYPE_esds) {
                return position;
            }
            position += readInt;
        }
        return -1;
    }

    private static Pair<String, byte[]> parseEsdsFromParent(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.setPosition(i + 8 + 4);
        parsableByteArray.skipBytes(1);
        parseExpandableClassSize(parsableByteArray);
        parsableByteArray.skipBytes(2);
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        if ((readUnsignedByte & 128) != 0) {
            parsableByteArray.skipBytes(2);
        }
        if ((readUnsignedByte & 64) != 0) {
            parsableByteArray.skipBytes(parsableByteArray.readUnsignedShort());
        }
        if ((readUnsignedByte & 32) != 0) {
            parsableByteArray.skipBytes(2);
        }
        parsableByteArray.skipBytes(1);
        parseExpandableClassSize(parsableByteArray);
        String mimeTypeFromMp4ObjectType = MimeTypes.getMimeTypeFromMp4ObjectType(parsableByteArray.readUnsignedByte());
        if (MimeTypes.AUDIO_MPEG.equals(mimeTypeFromMp4ObjectType) || MimeTypes.AUDIO_DTS.equals(mimeTypeFromMp4ObjectType) || MimeTypes.AUDIO_DTS_HD.equals(mimeTypeFromMp4ObjectType)) {
            return Pair.create(mimeTypeFromMp4ObjectType, (Object) null);
        }
        parsableByteArray.skipBytes(12);
        parsableByteArray.skipBytes(1);
        int parseExpandableClassSize = parseExpandableClassSize(parsableByteArray);
        byte[] bArr = new byte[parseExpandableClassSize];
        parsableByteArray.readBytes(bArr, 0, parseExpandableClassSize);
        return Pair.create(mimeTypeFromMp4ObjectType, bArr);
    }

    private static Pair<Integer, TrackEncryptionBox> parseSampleEntryEncryptionData(ParsableByteArray parsableByteArray, int i, int i2) {
        Pair<Integer, TrackEncryptionBox> parseCommonEncryptionSinfFromParent;
        int position = parsableByteArray.getPosition();
        while (position - i < i2) {
            parsableByteArray.setPosition(position);
            int readInt = parsableByteArray.readInt();
            Assertions.checkArgument(readInt > 0, "childAtomSize should be positive");
            if (parsableByteArray.readInt() == Atom.TYPE_sinf && (parseCommonEncryptionSinfFromParent = parseCommonEncryptionSinfFromParent(parsableByteArray, position, readInt)) != null) {
                return parseCommonEncryptionSinfFromParent;
            }
            position += readInt;
        }
        return null;
    }

    static Pair<Integer, TrackEncryptionBox> parseCommonEncryptionSinfFromParent(ParsableByteArray parsableByteArray, int i, int i2) {
        int i3 = i + 8;
        String str = null;
        Integer num = null;
        int i4 = -1;
        int i5 = 0;
        while (i3 - i < i2) {
            parsableByteArray.setPosition(i3);
            int readInt = parsableByteArray.readInt();
            int readInt2 = parsableByteArray.readInt();
            if (readInt2 == Atom.TYPE_frma) {
                num = Integer.valueOf(parsableByteArray.readInt());
            } else if (readInt2 == Atom.TYPE_schm) {
                parsableByteArray.skipBytes(4);
                str = parsableByteArray.readString(4);
            } else if (readInt2 == Atom.TYPE_schi) {
                i4 = i3;
                i5 = readInt;
            }
            i3 += readInt;
        }
        if (!C1119C.CENC_TYPE_cenc.equals(str) && !C1119C.CENC_TYPE_cbc1.equals(str) && !C1119C.CENC_TYPE_cens.equals(str) && !C1119C.CENC_TYPE_cbcs.equals(str)) {
            return null;
        }
        boolean z = true;
        Assertions.checkArgument(num != null, "frma atom is mandatory");
        Assertions.checkArgument(i4 != -1, "schi atom is mandatory");
        TrackEncryptionBox parseSchiFromParent = parseSchiFromParent(parsableByteArray, i4, i5, str);
        if (parseSchiFromParent == null) {
            z = false;
        }
        Assertions.checkArgument(z, "tenc atom is mandatory");
        return Pair.create(num, parseSchiFromParent);
    }

    private static TrackEncryptionBox parseSchiFromParent(ParsableByteArray parsableByteArray, int i, int i2, String str) {
        int i3;
        int i4;
        int i5 = i + 8;
        while (true) {
            byte[] bArr = null;
            if (i5 - i >= i2) {
                return null;
            }
            parsableByteArray.setPosition(i5);
            int readInt = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == Atom.TYPE_tenc) {
                int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
                parsableByteArray.skipBytes(1);
                if (parseFullAtomVersion == 0) {
                    parsableByteArray.skipBytes(1);
                    i4 = 0;
                    i3 = 0;
                } else {
                    int readUnsignedByte = parsableByteArray.readUnsignedByte();
                    i3 = readUnsignedByte & 15;
                    i4 = (readUnsignedByte & PsExtractor.VIDEO_STREAM_MASK) >> 4;
                }
                boolean z = parsableByteArray.readUnsignedByte() == 1;
                int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                byte[] bArr2 = new byte[16];
                parsableByteArray.readBytes(bArr2, 0, bArr2.length);
                if (z && readUnsignedByte2 == 0) {
                    int readUnsignedByte3 = parsableByteArray.readUnsignedByte();
                    bArr = new byte[readUnsignedByte3];
                    parsableByteArray.readBytes(bArr, 0, readUnsignedByte3);
                }
                return new TrackEncryptionBox(z, str, readUnsignedByte2, bArr2, i4, i3, bArr);
            }
            i5 += readInt;
        }
    }

    private static byte[] parseProjFromParent(ParsableByteArray parsableByteArray, int i, int i2) {
        int i3 = i + 8;
        while (i3 - i < i2) {
            parsableByteArray.setPosition(i3);
            int readInt = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == Atom.TYPE_proj) {
                return Arrays.copyOfRange(parsableByteArray.data, i3, readInt + i3);
            }
            i3 += readInt;
        }
        return null;
    }

    private static int parseExpandableClassSize(ParsableByteArray parsableByteArray) {
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        int i = readUnsignedByte & 127;
        while ((readUnsignedByte & 128) == 128) {
            readUnsignedByte = parsableByteArray.readUnsignedByte();
            i = (i << 7) | (readUnsignedByte & 127);
        }
        return i;
    }

    private static boolean canApplyEditWithGaplessInfo(long[] jArr, long j, long j2, long j3) {
        int length = jArr.length - 1;
        int constrainValue = Util.constrainValue(4, 0, length);
        int constrainValue2 = Util.constrainValue(jArr.length - 4, 0, length);
        if (jArr[0] > j2 || j2 >= jArr[constrainValue] || jArr[constrainValue2] >= j3 || j3 > j) {
            return false;
        }
        return true;
    }

    private AtomParsers() {
    }

    private static final class ChunkIterator {
        private final ParsableByteArray chunkOffsets;
        private final boolean chunkOffsetsAreLongs;
        public int index;
        public final int length;
        private int nextSamplesPerChunkChangeIndex;
        public int numSamples;
        public long offset;
        private int remainingSamplesPerChunkChanges;
        private final ParsableByteArray stsc;

        public ChunkIterator(ParsableByteArray parsableByteArray, ParsableByteArray parsableByteArray2, boolean z) {
            this.stsc = parsableByteArray;
            this.chunkOffsets = parsableByteArray2;
            this.chunkOffsetsAreLongs = z;
            parsableByteArray2.setPosition(12);
            this.length = parsableByteArray2.readUnsignedIntToInt();
            parsableByteArray.setPosition(12);
            this.remainingSamplesPerChunkChanges = parsableByteArray.readUnsignedIntToInt();
            Assertions.checkState(parsableByteArray.readInt() != 1 ? false : true, "first_chunk must be 1");
            this.index = -1;
        }

        public boolean moveNext() {
            long j;
            int i = this.index + 1;
            this.index = i;
            if (i == this.length) {
                return false;
            }
            if (this.chunkOffsetsAreLongs) {
                j = this.chunkOffsets.readUnsignedLongToLong();
            } else {
                j = this.chunkOffsets.readUnsignedInt();
            }
            this.offset = j;
            if (this.index == this.nextSamplesPerChunkChangeIndex) {
                this.numSamples = this.stsc.readUnsignedIntToInt();
                this.stsc.skipBytes(4);
                int i2 = this.remainingSamplesPerChunkChanges - 1;
                this.remainingSamplesPerChunkChanges = i2;
                this.nextSamplesPerChunkChangeIndex = i2 > 0 ? this.stsc.readUnsignedIntToInt() - 1 : -1;
            }
            return true;
        }
    }

    private static final class TkhdData {
        /* access modifiers changed from: private */
        public final long duration;
        /* access modifiers changed from: private */

        /* renamed from: id */
        public final int f124id;
        /* access modifiers changed from: private */
        public final int rotationDegrees;

        public TkhdData(int i, long j, int i2) {
            this.f124id = i;
            this.duration = j;
            this.rotationDegrees = i2;
        }
    }

    private static final class StsdData {
        public static final int STSD_HEADER_SIZE = 8;
        public Format format;
        public int nalUnitLengthFieldLength;
        public int requiredSampleTransformation = 0;
        public final TrackEncryptionBox[] trackEncryptionBoxes;

        public StsdData(int i) {
            this.trackEncryptionBoxes = new TrackEncryptionBox[i];
        }
    }

    static final class StszSampleSizeBox implements SampleSizeBox {
        private final ParsableByteArray data;
        private final int fixedSampleSize = this.data.readUnsignedIntToInt();
        private final int sampleCount = this.data.readUnsignedIntToInt();

        public StszSampleSizeBox(Atom.LeafAtom leafAtom) {
            this.data = leafAtom.data;
            this.data.setPosition(12);
        }

        public int getSampleCount() {
            return this.sampleCount;
        }

        public int readNextSampleSize() {
            int i = this.fixedSampleSize;
            return i == 0 ? this.data.readUnsignedIntToInt() : i;
        }

        public boolean isFixedSampleSize() {
            return this.fixedSampleSize != 0;
        }
    }

    static final class Stz2SampleSizeBox implements SampleSizeBox {
        private int currentByte;
        private final ParsableByteArray data;
        private final int fieldSize = (this.data.readUnsignedIntToInt() & 255);
        private final int sampleCount = this.data.readUnsignedIntToInt();
        private int sampleIndex;

        public boolean isFixedSampleSize() {
            return false;
        }

        public Stz2SampleSizeBox(Atom.LeafAtom leafAtom) {
            this.data = leafAtom.data;
            this.data.setPosition(12);
        }

        public int getSampleCount() {
            return this.sampleCount;
        }

        public int readNextSampleSize() {
            int i = this.fieldSize;
            if (i == 8) {
                return this.data.readUnsignedByte();
            }
            if (i == 16) {
                return this.data.readUnsignedShort();
            }
            int i2 = this.sampleIndex;
            this.sampleIndex = i2 + 1;
            if (i2 % 2 != 0) {
                return this.currentByte & 15;
            }
            this.currentByte = this.data.readUnsignedByte();
            return (this.currentByte & PsExtractor.VIDEO_STREAM_MASK) >> 4;
        }
    }
}
