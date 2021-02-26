package com.google.android.exoplayer2.extractor.p008ts;

import com.google.android.exoplayer2.C1119C;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.p008ts.TsPayloadReader;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;

/* renamed from: com.google.android.exoplayer2.extractor.ts.Ac4Extractor */
public final class Ac4Extractor implements Extractor {
    public static final ExtractorsFactory FACTORY = $$Lambda$Ac4Extractor$zjW7KSyjAevbDDyNCjGHEbZskt8.INSTANCE;
    private static final int FRAME_HEADER_SIZE = 7;
    private static final int ID3_TAG = Util.getIntegerCodeForString("ID3");
    private static final int MAX_SNIFF_BYTES = 8192;
    private static final int READ_BUFFER_SIZE = 16384;
    private final long firstSampleTimestampUs;
    private final Ac4Reader reader;
    private final ParsableByteArray sampleData;
    private boolean startedPacket;

    public void release() {
    }

    static /* synthetic */ Extractor[] lambda$static$0() {
        return new Extractor[]{new Ac4Extractor()};
    }

    public Ac4Extractor() {
        this(0);
    }

    public Ac4Extractor(long j) {
        this.firstSampleTimestampUs = j;
        this.reader = new Ac4Reader();
        this.sampleData = new ParsableByteArray(16384);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0041, code lost:
        if ((r4 - r3) < 8192) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0043, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0038, code lost:
        r9.resetPeekPosition();
        r4 = r4 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean sniff(com.google.android.exoplayer2.extractor.ExtractorInput r9) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r8 = this;
            com.google.android.exoplayer2.util.ParsableByteArray r0 = new com.google.android.exoplayer2.util.ParsableByteArray
            r1 = 10
            r0.<init>((int) r1)
            r2 = 0
            r3 = 0
        L_0x0009:
            byte[] r4 = r0.data
            r9.peekFully(r4, r2, r1)
            r0.setPosition(r2)
            int r4 = r0.readUnsignedInt24()
            int r5 = ID3_TAG
            if (r4 == r5) goto L_0x005e
            r9.resetPeekPosition()
            r9.advancePeekPosition(r3)
            r4 = r3
        L_0x0020:
            r1 = 0
        L_0x0021:
            byte[] r5 = r0.data
            r6 = 7
            r9.peekFully(r5, r2, r6)
            r0.setPosition(r2)
            int r5 = r0.readUnsignedShort()
            r6 = 44096(0xac40, float:6.1792E-41)
            if (r5 == r6) goto L_0x0048
            r6 = 44097(0xac41, float:6.1793E-41)
            if (r5 == r6) goto L_0x0048
            r9.resetPeekPosition()
            int r4 = r4 + 1
            int r1 = r4 - r3
            r5 = 8192(0x2000, float:1.14794E-41)
            if (r1 < r5) goto L_0x0044
            return r2
        L_0x0044:
            r9.advancePeekPosition(r4)
            goto L_0x0020
        L_0x0048:
            r6 = 1
            int r1 = r1 + r6
            r7 = 4
            if (r1 < r7) goto L_0x004e
            return r6
        L_0x004e:
            byte[] r6 = r0.data
            int r5 = com.google.android.exoplayer2.audio.Ac4Util.parseAc4SyncframeSize(r6, r5)
            r6 = -1
            if (r5 != r6) goto L_0x0058
            return r2
        L_0x0058:
            int r5 = r5 + -7
            r9.advancePeekPosition(r5)
            goto L_0x0021
        L_0x005e:
            r4 = 3
            r0.skipBytes(r4)
            int r4 = r0.readSynchSafeInt()
            int r5 = r4 + 10
            int r3 = r3 + r5
            r9.advancePeekPosition(r4)
            goto L_0x0009
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.p008ts.Ac4Extractor.sniff(com.google.android.exoplayer2.extractor.ExtractorInput):boolean");
    }

    public void init(ExtractorOutput extractorOutput) {
        this.reader.createTracks(extractorOutput, new TsPayloadReader.TrackIdGenerator(0, 1));
        extractorOutput.endTracks();
        extractorOutput.seekMap(new SeekMap.Unseekable(C1119C.TIME_UNSET));
    }

    public void seek(long j, long j2) {
        this.startedPacket = false;
        this.reader.seek();
    }

    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException, InterruptedException {
        int read = extractorInput.read(this.sampleData.data, 0, 16384);
        if (read == -1) {
            return -1;
        }
        this.sampleData.setPosition(0);
        this.sampleData.setLimit(read);
        if (!this.startedPacket) {
            this.reader.packetStarted(this.firstSampleTimestampUs, 4);
            this.startedPacket = true;
        }
        this.reader.consume(this.sampleData);
        return 0;
    }
}
