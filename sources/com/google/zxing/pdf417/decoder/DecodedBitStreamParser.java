package com.google.zxing.pdf417.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.pdf417.PDF417ResultMetadata;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

final class DecodedBitStreamParser {

    /* renamed from: AL */
    private static final int f460AL = 28;

    /* renamed from: AS */
    private static final int f461AS = 27;
    private static final int BEGIN_MACRO_PDF417_CONTROL_BLOCK = 928;
    private static final int BEGIN_MACRO_PDF417_OPTIONAL_FIELD = 923;
    private static final int BYTE_COMPACTION_MODE_LATCH = 901;
    private static final int BYTE_COMPACTION_MODE_LATCH_6 = 924;
    private static final Charset DEFAULT_ENCODING = Charset.forName("ISO-8859-1");
    private static final int ECI_CHARSET = 927;
    private static final int ECI_GENERAL_PURPOSE = 926;
    private static final int ECI_USER_DEFINED = 925;
    private static final BigInteger[] EXP900;

    /* renamed from: LL */
    private static final int f462LL = 27;
    private static final int MACRO_PDF417_TERMINATOR = 922;
    private static final int MAX_NUMERIC_CODEWORDS = 15;
    private static final char[] MIXED_CHARS = "0123456789&\r\t,:#-.$/+%*=^".toCharArray();

    /* renamed from: ML */
    private static final int f463ML = 28;
    private static final int MODE_SHIFT_TO_BYTE_COMPACTION_MODE = 913;
    private static final int NUMBER_OF_SEQUENCE_CODEWORDS = 2;
    private static final int NUMERIC_COMPACTION_MODE_LATCH = 902;
    private static final int PAL = 29;

    /* renamed from: PL */
    private static final int f464PL = 25;

    /* renamed from: PS */
    private static final int f465PS = 29;
    private static final char[] PUNCT_CHARS = ";<>@[\\]_`~!\r\t,:\n-.$/\"|*()?{}'".toCharArray();
    private static final int TEXT_COMPACTION_MODE_LATCH = 900;

    private enum Mode {
        ALPHA,
        LOWER,
        MIXED,
        PUNCT,
        ALPHA_SHIFT,
        PUNCT_SHIFT
    }

    static {
        BigInteger[] bigIntegerArr = new BigInteger[16];
        EXP900 = bigIntegerArr;
        bigIntegerArr[0] = BigInteger.ONE;
        BigInteger valueOf = BigInteger.valueOf(900);
        EXP900[1] = valueOf;
        int i = 2;
        while (true) {
            BigInteger[] bigIntegerArr2 = EXP900;
            if (i < bigIntegerArr2.length) {
                bigIntegerArr2[i] = bigIntegerArr2[i - 1].multiply(valueOf);
                i++;
            } else {
                return;
            }
        }
    }

    private DecodedBitStreamParser() {
    }

    static DecoderResult decode(int[] iArr, String str) throws FormatException {
        int i;
        StringBuilder sb = new StringBuilder(iArr.length << 1);
        Charset charset = DEFAULT_ENCODING;
        int i2 = iArr[1];
        PDF417ResultMetadata pDF417ResultMetadata = new PDF417ResultMetadata();
        int i3 = 2;
        while (i3 < iArr[0]) {
            if (i2 != MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                switch (i2) {
                    case 900:
                        i = textCompaction(iArr, i3, sb);
                        break;
                    case BYTE_COMPACTION_MODE_LATCH /*901*/:
                        i = byteCompaction(i2, iArr, charset, i3, sb);
                        break;
                    case NUMERIC_COMPACTION_MODE_LATCH /*902*/:
                        i = numericCompaction(iArr, i3, sb);
                        break;
                    default:
                        switch (i2) {
                            case MACRO_PDF417_TERMINATOR /*922*/:
                            case BEGIN_MACRO_PDF417_OPTIONAL_FIELD /*923*/:
                                throw FormatException.getFormatInstance();
                            case BYTE_COMPACTION_MODE_LATCH_6 /*924*/:
                                break;
                            case ECI_USER_DEFINED /*925*/:
                                i = i3 + 1;
                                break;
                            case ECI_GENERAL_PURPOSE /*926*/:
                                i = i3 + 2;
                                break;
                            case ECI_CHARSET /*927*/:
                                i = i3 + 1;
                                charset = Charset.forName(CharacterSetECI.getCharacterSetECIByValue(iArr[i3]).name());
                                break;
                            case 928:
                                i = decodeMacroBlock(iArr, i3, pDF417ResultMetadata);
                                break;
                            default:
                                i = textCompaction(iArr, i3 - 1, sb);
                                break;
                        }
                        i = byteCompaction(i2, iArr, charset, i3, sb);
                        break;
                }
            } else {
                i = i3 + 1;
                sb.append((char) iArr[i3]);
            }
            if (i < iArr.length) {
                i3 = i + 1;
                i2 = iArr[i];
            } else {
                throw FormatException.getFormatInstance();
            }
        }
        if (sb.length() != 0) {
            DecoderResult decoderResult = new DecoderResult((byte[]) null, sb.toString(), (List<byte[]>) null, str);
            decoderResult.setOther(pDF417ResultMetadata);
            return decoderResult;
        }
        throw FormatException.getFormatInstance();
    }

    private static int decodeMacroBlock(int[] iArr, int i, PDF417ResultMetadata pDF417ResultMetadata) throws FormatException {
        if (i + 2 <= iArr[0]) {
            int[] iArr2 = new int[2];
            int i2 = i;
            int i3 = 0;
            while (i3 < 2) {
                iArr2[i3] = iArr[i2];
                i3++;
                i2++;
            }
            pDF417ResultMetadata.setSegmentIndex(Integer.parseInt(decodeBase900toBase10(iArr2, 2)));
            StringBuilder sb = new StringBuilder();
            int textCompaction = textCompaction(iArr, i2, sb);
            pDF417ResultMetadata.setFileId(sb.toString());
            if (iArr[textCompaction] == BEGIN_MACRO_PDF417_OPTIONAL_FIELD) {
                int i4 = textCompaction + 1;
                int[] iArr3 = new int[(iArr[0] - i4)];
                boolean z = false;
                int i5 = 0;
                while (i4 < iArr[0] && !z) {
                    int i6 = i4 + 1;
                    int i7 = iArr[i4];
                    if (i7 < 900) {
                        iArr3[i5] = i7;
                        i4 = i6;
                        i5++;
                    } else if (i7 == MACRO_PDF417_TERMINATOR) {
                        pDF417ResultMetadata.setLastSegment(true);
                        i4 = i6 + 1;
                        z = true;
                    } else {
                        throw FormatException.getFormatInstance();
                    }
                }
                pDF417ResultMetadata.setOptionalData(Arrays.copyOf(iArr3, i5));
                return i4;
            } else if (iArr[textCompaction] != MACRO_PDF417_TERMINATOR) {
                return textCompaction;
            } else {
                pDF417ResultMetadata.setLastSegment(true);
                return textCompaction + 1;
            }
        } else {
            throw FormatException.getFormatInstance();
        }
    }

    private static int textCompaction(int[] iArr, int i, StringBuilder sb) {
        int[] iArr2 = new int[((iArr[0] - i) << 1)];
        int[] iArr3 = new int[((iArr[0] - i) << 1)];
        boolean z = false;
        int i2 = 0;
        while (i < iArr[0] && !z) {
            int i3 = i + 1;
            int i4 = iArr[i];
            if (i4 < 900) {
                iArr2[i2] = i4 / 30;
                iArr2[i2 + 1] = i4 % 30;
                i2 += 2;
            } else if (i4 != MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                if (i4 != 928) {
                    switch (i4) {
                        case 900:
                            iArr2[i2] = 900;
                            i2++;
                            break;
                        case BYTE_COMPACTION_MODE_LATCH /*901*/:
                        case NUMERIC_COMPACTION_MODE_LATCH /*902*/:
                            break;
                        default:
                            switch (i4) {
                                case MACRO_PDF417_TERMINATOR /*922*/:
                                case BEGIN_MACRO_PDF417_OPTIONAL_FIELD /*923*/:
                                case BYTE_COMPACTION_MODE_LATCH_6 /*924*/:
                                    break;
                            }
                    }
                }
                i = i3 - 1;
                z = true;
            } else {
                iArr2[i2] = MODE_SHIFT_TO_BYTE_COMPACTION_MODE;
                i = i3 + 1;
                iArr3[i2] = iArr[i3];
                i2++;
            }
            i = i3;
        }
        decodeTextCompaction(iArr2, iArr3, i2, sb);
        return i;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004c, code lost:
        r6 = r4;
        r4 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005b, code lost:
        r4 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00bc, code lost:
        r6 = 0;
        r15 = r5;
        r5 = r4;
        r4 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00dd, code lost:
        r6 = (char) r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00e1, code lost:
        r6 = ' ';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0101, code lost:
        if (r6 == 0) goto L_0x0106;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0103, code lost:
        r0.append(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0106, code lost:
        r2 = r2 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void decodeTextCompaction(int[] r16, int[] r17, int r18, java.lang.StringBuilder r19) {
        /*
            r0 = r19
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r1 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r2 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            r3 = 0
            r4 = r1
            r5 = r2
            r2 = 0
            r1 = r18
        L_0x000c:
            if (r2 >= r1) goto L_0x010a
            r6 = r16[r2]
            int[] r7 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.C27051.f466x45bba1d
            int r8 = r4.ordinal()
            r7 = r7[r8]
            r8 = 28
            r9 = 27
            r10 = 32
            r11 = 913(0x391, float:1.28E-42)
            r12 = 900(0x384, float:1.261E-42)
            r13 = 29
            r14 = 26
            switch(r7) {
                case 1: goto L_0x00d9;
                case 2: goto L_0x00b0;
                case 3: goto L_0x007c;
                case 4: goto L_0x005e;
                case 5: goto L_0x0047;
                case 6: goto L_0x002b;
                default: goto L_0x0029;
            }
        L_0x0029:
            goto L_0x0100
        L_0x002b:
            if (r6 >= r13) goto L_0x0032
            char[] r4 = PUNCT_CHARS
            char r4 = r4[r6]
            goto L_0x004c
        L_0x0032:
            if (r6 != r13) goto L_0x0038
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r4 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x0100
        L_0x0038:
            if (r6 != r11) goto L_0x0041
            r4 = r17[r2]
            char r4 = (char) r4
            r0.append(r4)
            goto L_0x005b
        L_0x0041:
            if (r6 != r12) goto L_0x005b
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r4 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x0100
        L_0x0047:
            if (r6 >= r14) goto L_0x0050
            int r6 = r6 + 65
            char r4 = (char) r6
        L_0x004c:
            r6 = r4
            r4 = r5
            goto L_0x0101
        L_0x0050:
            if (r6 != r14) goto L_0x0055
            r4 = r5
            goto L_0x00e1
        L_0x0055:
            if (r6 != r12) goto L_0x005b
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r4 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x0100
        L_0x005b:
            r4 = r5
            goto L_0x0100
        L_0x005e:
            if (r6 >= r13) goto L_0x0066
            char[] r7 = PUNCT_CHARS
            char r6 = r7[r6]
            goto L_0x0101
        L_0x0066:
            if (r6 != r13) goto L_0x006c
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r4 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x0100
        L_0x006c:
            if (r6 != r11) goto L_0x0076
            r6 = r17[r2]
            char r6 = (char) r6
            r0.append(r6)
            goto L_0x0100
        L_0x0076:
            if (r6 != r12) goto L_0x0100
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r4 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x0100
        L_0x007c:
            r7 = 25
            if (r6 >= r7) goto L_0x0086
            char[] r7 = MIXED_CHARS
            char r6 = r7[r6]
            goto L_0x0101
        L_0x0086:
            if (r6 != r7) goto L_0x008c
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r4 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.PUNCT
            goto L_0x0100
        L_0x008c:
            if (r6 != r14) goto L_0x008f
            goto L_0x00e1
        L_0x008f:
            if (r6 != r9) goto L_0x0095
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r4 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.LOWER
            goto L_0x0100
        L_0x0095:
            if (r6 != r8) goto L_0x009b
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r4 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x0100
        L_0x009b:
            if (r6 != r13) goto L_0x00a0
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r5 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.PUNCT_SHIFT
            goto L_0x00bc
        L_0x00a0:
            if (r6 != r11) goto L_0x00aa
            r6 = r17[r2]
            char r6 = (char) r6
            r0.append(r6)
            goto L_0x0100
        L_0x00aa:
            if (r6 != r12) goto L_0x0100
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r4 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x0100
        L_0x00b0:
            if (r6 >= r14) goto L_0x00b5
            int r6 = r6 + 97
            goto L_0x00dd
        L_0x00b5:
            if (r6 != r14) goto L_0x00b8
            goto L_0x00e1
        L_0x00b8:
            if (r6 != r9) goto L_0x00c1
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r5 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA_SHIFT
        L_0x00bc:
            r6 = 0
            r15 = r5
            r5 = r4
            r4 = r15
            goto L_0x0101
        L_0x00c1:
            if (r6 != r8) goto L_0x00c6
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r4 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.MIXED
            goto L_0x0100
        L_0x00c6:
            if (r6 != r13) goto L_0x00cb
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r5 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.PUNCT_SHIFT
            goto L_0x00bc
        L_0x00cb:
            if (r6 != r11) goto L_0x00d4
            r6 = r17[r2]
            char r6 = (char) r6
            r0.append(r6)
            goto L_0x0100
        L_0x00d4:
            if (r6 != r12) goto L_0x0100
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r4 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            goto L_0x0100
        L_0x00d9:
            if (r6 >= r14) goto L_0x00df
            int r6 = r6 + 65
        L_0x00dd:
            char r6 = (char) r6
            goto L_0x0101
        L_0x00df:
            if (r6 != r14) goto L_0x00e4
        L_0x00e1:
            r6 = 32
            goto L_0x0101
        L_0x00e4:
            if (r6 != r9) goto L_0x00e9
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r4 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.LOWER
            goto L_0x0100
        L_0x00e9:
            if (r6 != r8) goto L_0x00ee
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r4 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.MIXED
            goto L_0x0100
        L_0x00ee:
            if (r6 != r13) goto L_0x00f3
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r5 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.PUNCT_SHIFT
            goto L_0x00bc
        L_0x00f3:
            if (r6 != r11) goto L_0x00fc
            r6 = r17[r2]
            char r6 = (char) r6
            r0.append(r6)
            goto L_0x0100
        L_0x00fc:
            if (r6 != r12) goto L_0x0100
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r4 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
        L_0x0100:
            r6 = 0
        L_0x0101:
            if (r6 == 0) goto L_0x0106
            r0.append(r6)
        L_0x0106:
            int r2 = r2 + 1
            goto L_0x000c
        L_0x010a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.DecodedBitStreamParser.decodeTextCompaction(int[], int[], int, java.lang.StringBuilder):void");
    }

    private static int byteCompaction(int i, int[] iArr, Charset charset, int i2, StringBuilder sb) {
        int i3;
        long j;
        int i4;
        int i5;
        int i6 = i;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i7 = MACRO_PDF417_TERMINATOR;
        int i8 = BEGIN_MACRO_PDF417_OPTIONAL_FIELD;
        int i9 = 928;
        long j2 = 900;
        if (i6 == BYTE_COMPACTION_MODE_LATCH) {
            int[] iArr2 = new int[6];
            int i10 = i2 + 1;
            int i11 = iArr[i2];
            boolean z = false;
            loop0:
            while (true) {
                i4 = 0;
                long j3 = 0;
                while (i3 < iArr[0] && !z) {
                    int i12 = i4 + 1;
                    iArr2[i4] = i11;
                    j3 = (j3 * j) + ((long) i11);
                    int i13 = i3 + 1;
                    i11 = iArr[i3];
                    if (i11 == 900 || i11 == BYTE_COMPACTION_MODE_LATCH || i11 == NUMERIC_COMPACTION_MODE_LATCH || i11 == BYTE_COMPACTION_MODE_LATCH_6 || i11 == 928 || i11 == i8 || i11 == i7) {
                        i3 = i13 - 1;
                        i4 = i12;
                        i7 = MACRO_PDF417_TERMINATOR;
                        i8 = BEGIN_MACRO_PDF417_OPTIONAL_FIELD;
                        j = 900;
                        z = true;
                    } else if (i12 % 5 != 0 || i12 <= 0) {
                        i3 = i13;
                        i4 = i12;
                        i7 = MACRO_PDF417_TERMINATOR;
                        i8 = BEGIN_MACRO_PDF417_OPTIONAL_FIELD;
                        j = 900;
                    } else {
                        int i14 = 0;
                        while (i14 < 6) {
                            byteArrayOutputStream.write((byte) ((int) (j3 >> ((5 - i14) * 8))));
                            i14++;
                            i7 = MACRO_PDF417_TERMINATOR;
                            i8 = BEGIN_MACRO_PDF417_OPTIONAL_FIELD;
                        }
                        i10 = i13;
                        j2 = 900;
                    }
                }
            }
            if (i3 != iArr[0] || i11 >= 900) {
                i5 = i4;
            } else {
                i5 = i4 + 1;
                iArr2[i4] = i11;
            }
            for (int i15 = 0; i15 < i5; i15++) {
                byteArrayOutputStream.write((byte) iArr2[i15]);
            }
        } else if (i6 == BYTE_COMPACTION_MODE_LATCH_6) {
            int i16 = i2;
            int i17 = 0;
            long j4 = 0;
            boolean z2 = false;
            while (i16 < iArr[0] && !z2) {
                int i18 = i16 + 1;
                int i19 = iArr[i16];
                if (i19 < 900) {
                    i17++;
                    j4 = (j4 * 900) + ((long) i19);
                    i16 = i18;
                } else {
                    if (i19 != 900 && i19 != BYTE_COMPACTION_MODE_LATCH && i19 != NUMERIC_COMPACTION_MODE_LATCH && i19 != BYTE_COMPACTION_MODE_LATCH_6 && i19 != i9) {
                        if (i19 != BEGIN_MACRO_PDF417_OPTIONAL_FIELD) {
                            if (i19 != MACRO_PDF417_TERMINATOR) {
                                i16 = i18;
                            }
                            i16 = i18 - 1;
                            z2 = true;
                        }
                    }
                    i16 = i18 - 1;
                    z2 = true;
                }
                if (i17 % 5 == 0 && i17 > 0) {
                    int i20 = 0;
                    for (int i21 = 6; i20 < i21; i21 = 6) {
                        byteArrayOutputStream.write((byte) ((int) (j4 >> ((5 - i20) * 8))));
                        i20++;
                    }
                    i17 = 0;
                    j4 = 0;
                }
                i9 = 928;
            }
            i3 = i16;
        } else {
            i3 = i2;
        }
        sb.append(new String(byteArrayOutputStream.toByteArray(), charset));
        return i3;
    }

    private static int numericCompaction(int[] iArr, int i, StringBuilder sb) throws FormatException {
        int[] iArr2 = new int[15];
        boolean z = false;
        int i2 = 0;
        while (i < iArr[0] && !z) {
            int i3 = i + 1;
            int i4 = iArr[i];
            if (i3 == iArr[0]) {
                z = true;
            }
            if (i4 < 900) {
                iArr2[i2] = i4;
                i2++;
            } else if (i4 == 900 || i4 == BYTE_COMPACTION_MODE_LATCH || i4 == BYTE_COMPACTION_MODE_LATCH_6 || i4 == 928 || i4 == BEGIN_MACRO_PDF417_OPTIONAL_FIELD || i4 == MACRO_PDF417_TERMINATOR) {
                i3--;
                z = true;
            }
            if ((i2 % 15 == 0 || i4 == NUMERIC_COMPACTION_MODE_LATCH || z) && i2 > 0) {
                sb.append(decodeBase900toBase10(iArr2, i2));
                i2 = 0;
            }
            i = i3;
        }
        return i;
    }

    private static String decodeBase900toBase10(int[] iArr, int i) throws FormatException {
        BigInteger bigInteger = BigInteger.ZERO;
        for (int i2 = 0; i2 < i; i2++) {
            bigInteger = bigInteger.add(EXP900[(i - i2) - 1].multiply(BigInteger.valueOf((long) iArr[i2])));
        }
        String bigInteger2 = bigInteger.toString();
        if (bigInteger2.charAt(0) == '1') {
            return bigInteger2.substring(1);
        }
        throw FormatException.getFormatInstance();
    }
}
