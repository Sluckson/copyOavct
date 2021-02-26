package com.lowagie.text.pdf;

import androidx.recyclerview.widget.ItemTouchHelper;
import com.google.android.exoplayer2.extractor.p008ts.PsExtractor;
import com.lowagie.text.ExceptionConverter;
import com.lowagie.text.Rectangle;
import p052cz.msebera.android.httpclient.HttpStatus;

public class Barcode128 extends Barcode {
    private static final byte[][] BARS = {new byte[]{2, 1, 2, 2, 2, 2}, new byte[]{2, 2, 2, 1, 2, 2}, new byte[]{2, 2, 2, 2, 2, 1}, new byte[]{1, 2, 1, 2, 2, 3}, new byte[]{1, 2, 1, 3, 2, 2}, new byte[]{1, 3, 1, 2, 2, 2}, new byte[]{1, 2, 2, 2, 1, 3}, new byte[]{1, 2, 2, 3, 1, 2}, new byte[]{1, 3, 2, 2, 1, 2}, new byte[]{2, 2, 1, 2, 1, 3}, new byte[]{2, 2, 1, 3, 1, 2}, new byte[]{2, 3, 1, 2, 1, 2}, new byte[]{1, 1, 2, 2, 3, 2}, new byte[]{1, 2, 2, 1, 3, 2}, new byte[]{1, 2, 2, 2, 3, 1}, new byte[]{1, 1, 3, 2, 2, 2}, new byte[]{1, 2, 3, 1, 2, 2}, new byte[]{1, 2, 3, 2, 2, 1}, new byte[]{2, 2, 3, 2, 1, 1}, new byte[]{2, 2, 1, 1, 3, 2}, new byte[]{2, 2, 1, 2, 3, 1}, new byte[]{2, 1, 3, 2, 1, 2}, new byte[]{2, 2, 3, 1, 1, 2}, new byte[]{3, 1, 2, 1, 3, 1}, new byte[]{3, 1, 1, 2, 2, 2}, new byte[]{3, 2, 1, 1, 2, 2}, new byte[]{3, 2, 1, 2, 2, 1}, new byte[]{3, 1, 2, 2, 1, 2}, new byte[]{3, 2, 2, 1, 1, 2}, new byte[]{3, 2, 2, 2, 1, 1}, new byte[]{2, 1, 2, 1, 2, 3}, new byte[]{2, 1, 2, 3, 2, 1}, new byte[]{2, 3, 2, 1, 2, 1}, new byte[]{1, 1, 1, 3, 2, 3}, new byte[]{1, 3, 1, 1, 2, 3}, new byte[]{1, 3, 1, 3, 2, 1}, new byte[]{1, 1, 2, 3, 1, 3}, new byte[]{1, 3, 2, 1, 1, 3}, new byte[]{1, 3, 2, 3, 1, 1}, new byte[]{2, 1, 1, 3, 1, 3}, new byte[]{2, 3, 1, 1, 1, 3}, new byte[]{2, 3, 1, 3, 1, 1}, new byte[]{1, 1, 2, 1, 3, 3}, new byte[]{1, 1, 2, 3, 3, 1}, new byte[]{1, 3, 2, 1, 3, 1}, new byte[]{1, 1, 3, 1, 2, 3}, new byte[]{1, 1, 3, 3, 2, 1}, new byte[]{1, 3, 3, 1, 2, 1}, new byte[]{3, 1, 3, 1, 2, 1}, new byte[]{2, 1, 1, 3, 3, 1}, new byte[]{2, 3, 1, 1, 3, 1}, new byte[]{2, 1, 3, 1, 1, 3}, new byte[]{2, 1, 3, 3, 1, 1}, new byte[]{2, 1, 3, 1, 3, 1}, new byte[]{3, 1, 1, 1, 2, 3}, new byte[]{3, 1, 1, 3, 2, 1}, new byte[]{3, 3, 1, 1, 2, 1}, new byte[]{3, 1, 2, 1, 1, 3}, new byte[]{3, 1, 2, 3, 1, 1}, new byte[]{3, 3, 2, 1, 1, 1}, new byte[]{3, 1, 4, 1, 1, 1}, new byte[]{2, 2, 1, 4, 1, 1}, new byte[]{4, 3, 1, 1, 1, 1}, new byte[]{1, 1, 1, 2, 2, 4}, new byte[]{1, 1, 1, 4, 2, 2}, new byte[]{1, 2, 1, 1, 2, 4}, new byte[]{1, 2, 1, 4, 2, 1}, new byte[]{1, 4, 1, 1, 2, 2}, new byte[]{1, 4, 1, 2, 2, 1}, new byte[]{1, 1, 2, 2, 1, 4}, new byte[]{1, 1, 2, 4, 1, 2}, new byte[]{1, 2, 2, 1, 1, 4}, new byte[]{1, 2, 2, 4, 1, 1}, new byte[]{1, 4, 2, 1, 1, 2}, new byte[]{1, 4, 2, 2, 1, 1}, new byte[]{2, 4, 1, 2, 1, 1}, new byte[]{2, 2, 1, 1, 1, 4}, new byte[]{4, 1, 3, 1, 1, 1}, new byte[]{2, 4, 1, 1, 1, 2}, new byte[]{1, 3, 4, 1, 1, 1}, new byte[]{1, 1, 1, 2, 4, 2}, new byte[]{1, 2, 1, 1, 4, 2}, new byte[]{1, 2, 1, 2, 4, 1}, new byte[]{1, 1, 4, 2, 1, 2}, new byte[]{1, 2, 4, 1, 1, 2}, new byte[]{1, 2, 4, 2, 1, 1}, new byte[]{4, 1, 1, 2, 1, 2}, new byte[]{4, 2, 1, 1, 1, 2}, new byte[]{4, 2, 1, 2, 1, 1}, new byte[]{2, 1, 2, 1, 4, 1}, new byte[]{2, 1, 4, 1, 2, 1}, new byte[]{4, 1, 2, 1, 2, 1}, new byte[]{1, 1, 1, 1, 4, 3}, new byte[]{1, 1, 1, 3, 4, 1}, new byte[]{1, 3, 1, 1, 4, 1}, new byte[]{1, 1, 4, 1, 1, 3}, new byte[]{1, 1, 4, 3, 1, 1}, new byte[]{4, 1, 1, 1, 1, 3}, new byte[]{4, 1, 1, 3, 1, 1}, new byte[]{1, 1, 3, 1, 4, 1}, new byte[]{1, 1, 4, 1, 3, 1}, new byte[]{3, 1, 1, 1, 4, 1}, new byte[]{4, 1, 1, 1, 3, 1}, new byte[]{2, 1, 1, 4, 1, 2}, new byte[]{2, 1, 1, 2, 1, 4}, new byte[]{2, 1, 1, 2, 3, 2}};
    private static final byte[] BARS_STOP = {2, 3, 3, 1, 1, 1, 2};
    public static final char CODE_A = 'È';
    public static final char CODE_AB_TO_C = 'c';
    public static final char CODE_AC_TO_B = 'd';
    public static final char CODE_BC_TO_A = 'e';
    public static final char CODE_C = 'Ç';
    public static final char DEL = 'Ã';
    public static final char FNC1 = 'Ê';
    public static final char FNC1_INDEX = 'f';
    public static final char FNC2 = 'Å';
    public static final char FNC3 = 'Ä';
    public static final char FNC4 = 'È';
    public static final char SHIFT = 'Æ';
    public static final char STARTA = 'Ë';
    public static final char STARTB = 'Ì';
    public static final char STARTC = 'Í';
    public static final char START_A = 'g';
    public static final char START_B = 'h';
    public static final char START_C = 'i';
    private static final IntHashtable ais = new IntHashtable();

    static {
        ais.put(0, 20);
        ais.put(1, 16);
        ais.put(2, 16);
        ais.put(10, -1);
        ais.put(11, 9);
        ais.put(12, 8);
        ais.put(13, 8);
        ais.put(15, 8);
        ais.put(17, 8);
        ais.put(20, 4);
        ais.put(21, -1);
        ais.put(22, -1);
        ais.put(23, -1);
        ais.put(PsExtractor.VIDEO_STREAM_MASK, -1);
        ais.put(241, -1);
        ais.put(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, -1);
        ais.put(251, -1);
        ais.put(252, -1);
        ais.put(30, -1);
        for (int i = 3100; i < 3700; i++) {
            ais.put(i, 10);
        }
        ais.put(37, -1);
        for (int i2 = 3900; i2 < 3940; i2++) {
            ais.put(i2, -1);
        }
        ais.put(400, -1);
        ais.put(401, -1);
        ais.put(402, 20);
        ais.put(HttpStatus.SC_FORBIDDEN, -1);
        for (int i3 = HttpStatus.SC_GONE; i3 < 416; i3++) {
            ais.put(i3, 16);
        }
        ais.put(HttpStatus.SC_METHOD_FAILURE, -1);
        ais.put(421, -1);
        ais.put(HttpStatus.SC_UNPROCESSABLE_ENTITY, 6);
        ais.put(HttpStatus.SC_LOCKED, -1);
        ais.put(HttpStatus.SC_FAILED_DEPENDENCY, 6);
        ais.put(425, 6);
        ais.put(426, 6);
        ais.put(7001, 17);
        ais.put(7002, -1);
        for (int i4 = 7030; i4 < 7040; i4++) {
            ais.put(i4, -1);
        }
        ais.put(8001, 18);
        ais.put(8002, -1);
        ais.put(8003, -1);
        ais.put(8004, -1);
        ais.put(8005, 10);
        ais.put(8006, 22);
        ais.put(8007, -1);
        ais.put(8008, -1);
        ais.put(8018, 22);
        ais.put(8020, -1);
        ais.put(8100, 10);
        ais.put(8101, 14);
        ais.put(8102, 6);
        for (int i5 = 90; i5 < 100; i5++) {
            ais.put(i5, -1);
        }
    }

    public Barcode128() {
        try {
            this.f611x = 0.8f;
            this.font = BaseFont.createFont("Helvetica", "winansi", false);
            this.size = 8.0f;
            this.baseline = this.size;
            this.barHeight = this.size * 3.0f;
            this.textAlignment = 1;
            this.codeType = 9;
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public static String removeFNC1(String str) {
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer(length);
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt >= ' ' && charAt <= '~') {
                stringBuffer.append(charAt);
            }
        }
        return stringBuffer.toString();
    }

    public static String getHumanReadableUCCEAN(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        String valueOf = String.valueOf(FNC1);
        while (true) {
            try {
                if (str.startsWith(valueOf)) {
                    str = str.substring(1);
                } else {
                    int i = 2;
                    int i2 = 0;
                    while (true) {
                        if (i >= 5) {
                            break;
                        } else if (str.length() < i) {
                            break;
                        } else {
                            i2 = ais.get(Integer.parseInt(str.substring(0, i)));
                            if (i2 != 0) {
                                break;
                            }
                            i++;
                        }
                    }
                    i = 0;
                    if (i == 0) {
                        break;
                    }
                    stringBuffer.append('(');
                    stringBuffer.append(str.substring(0, i));
                    stringBuffer.append(')');
                    str = str.substring(i);
                    if (i2 > 0) {
                        int i3 = i2 - i;
                        if (str.length() <= i3) {
                            break;
                        }
                        stringBuffer.append(removeFNC1(str.substring(0, i3)));
                        str = str.substring(i3);
                    } else {
                        int indexOf = str.indexOf(202);
                        if (indexOf < 0) {
                            break;
                        }
                        stringBuffer.append(str.substring(0, indexOf));
                        str = str.substring(indexOf + 1);
                    }
                }
            } catch (Exception unused) {
            }
        }
        stringBuffer.append(removeFNC1(str));
        return stringBuffer.toString();
    }

    static boolean isNextDigits(String str, int i, int i2) {
        int length = str.length();
        loop0:
        while (i < length && i2 > 0) {
            if (str.charAt(i) == 202) {
                i++;
            } else {
                int min = Math.min(2, i2);
                if (i + min > length) {
                    return false;
                }
                while (true) {
                    int i3 = min - 1;
                    if (min <= 0) {
                        continue;
                        break;
                    }
                    int i4 = i + 1;
                    char charAt = str.charAt(i);
                    if (charAt < '0' || charAt > '9') {
                        return false;
                    }
                    i2--;
                    i = i4;
                    min = i3;
                }
                return false;
            }
        }
        if (i2 == 0) {
            return true;
        }
        return false;
    }

    static String getPackedRawDigits(String str, int i, int i2) {
        String str2 = "";
        int i3 = i;
        while (i2 > 0) {
            if (str.charAt(i3) == 202) {
                str2 = String.valueOf(str2) + FNC1_INDEX;
                i3++;
            } else {
                i2 -= 2;
                int i4 = i3 + 1;
                str2 = String.valueOf(str2) + ((char) (((str.charAt(i3) - '0') * 10) + (str.charAt(i4) - '0')));
                i3 = i4 + 1;
            }
        }
        return String.valueOf((char) (i3 - i)) + str2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0214, code lost:
        r9 = r2;
        r4 = START_A;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0262, code lost:
        r4 = START_C;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0280, code lost:
        r9 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x02aa, code lost:
        r9 = r2;
        r4 = START_B;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getRawText(java.lang.String r16, boolean r17) {
        /*
            r0 = r16
            int r1 = r16.length()
            r2 = 104(0x68, float:1.46E-43)
            r3 = 102(0x66, float:1.43E-43)
            java.lang.String r4 = ""
            if (r1 != 0) goto L_0x002d
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r4)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            if (r17 == 0) goto L_0x002c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r1.<init>(r0)
            r1.append(r3)
            java.lang.String r0 = r1.toString()
        L_0x002c:
            return r0
        L_0x002d:
            r5 = 0
            r6 = 0
        L_0x002f:
            r7 = 202(0xca, float:2.83E-43)
            if (r6 < r1) goto L_0x02db
            char r6 = r0.charAt(r5)
            r8 = 2
            boolean r9 = isNextDigits(r0, r5, r8)
            r10 = 103(0x67, float:1.44E-43)
            r11 = 105(0x69, float:1.47E-43)
            r12 = 32
            r13 = 1
            if (r9 == 0) goto L_0x0085
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r4)
            r6.append(r11)
            java.lang.String r4 = r6.toString()
            if (r17 == 0) goto L_0x0063
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r4 = java.lang.String.valueOf(r4)
            r6.<init>(r4)
            r6.append(r3)
            java.lang.String r4 = r6.toString()
        L_0x0063:
            java.lang.String r6 = getPackedRawDigits(r0, r5, r8)
            char r9 = r6.charAt(r5)
            int r9 = r9 + r5
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            java.lang.String r4 = java.lang.String.valueOf(r4)
            r14.<init>(r4)
            java.lang.String r4 = r6.substring(r13)
            r14.append(r4)
            java.lang.String r4 = r14.toString()
            r6 = r4
            r4 = 105(0x69, float:1.47E-43)
            goto L_0x0104
        L_0x0085:
            if (r6 >= r12) goto L_0x00bd
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>(r4)
            r9.append(r10)
            java.lang.String r4 = r9.toString()
            if (r17 == 0) goto L_0x00a5
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r4 = java.lang.String.valueOf(r4)
            r9.<init>(r4)
            r9.append(r3)
            java.lang.String r4 = r9.toString()
        L_0x00a5:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r4 = java.lang.String.valueOf(r4)
            r9.<init>(r4)
            int r6 = r6 + 64
            char r4 = (char) r6
            r9.append(r4)
            java.lang.String r4 = r9.toString()
            r6 = r4
            r4 = 103(0x67, float:1.44E-43)
        L_0x00bb:
            r9 = 1
            goto L_0x0104
        L_0x00bd:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>(r4)
            r9.append(r2)
            java.lang.String r4 = r9.toString()
            if (r17 == 0) goto L_0x00db
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r4 = java.lang.String.valueOf(r4)
            r9.<init>(r4)
            r9.append(r3)
            java.lang.String r4 = r9.toString()
        L_0x00db:
            if (r6 != r7) goto L_0x00ee
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r4 = java.lang.String.valueOf(r4)
            r6.<init>(r4)
            r6.append(r3)
            java.lang.String r4 = r6.toString()
            goto L_0x0100
        L_0x00ee:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r4 = java.lang.String.valueOf(r4)
            r9.<init>(r4)
            int r6 = r6 - r12
            char r4 = (char) r6
            r9.append(r4)
            java.lang.String r4 = r9.toString()
        L_0x0100:
            r6 = r4
            r4 = 104(0x68, float:1.46E-43)
            goto L_0x00bb
        L_0x0104:
            if (r9 < r1) goto L_0x0107
            return r6
        L_0x0107:
            r14 = 101(0x65, float:1.42E-43)
            r15 = 100
            r2 = 99
            r10 = 4
            switch(r4) {
                case 103: goto L_0x022f;
                case 104: goto L_0x01a0;
                case 105: goto L_0x0116;
                default: goto L_0x0111;
            }
        L_0x0111:
            r2 = 104(0x68, float:1.46E-43)
        L_0x0113:
            r10 = 103(0x67, float:1.44E-43)
            goto L_0x0104
        L_0x0116:
            boolean r2 = isNextDigits(r0, r9, r8)
            if (r2 == 0) goto L_0x013a
            java.lang.String r2 = getPackedRawDigits(r0, r9, r8)
            char r10 = r2.charAt(r5)
            int r9 = r9 + r10
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r6 = java.lang.String.valueOf(r6)
            r10.<init>(r6)
            java.lang.String r2 = r2.substring(r13)
            r10.append(r2)
            java.lang.String r6 = r10.toString()
            goto L_0x0111
        L_0x013a:
            int r2 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 != r7) goto L_0x0154
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r6 = java.lang.String.valueOf(r6)
            r9.<init>(r6)
            r9.append(r3)
            java.lang.String r6 = r9.toString()
            goto L_0x0280
        L_0x0154:
            if (r9 >= r12) goto L_0x017b
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r6 = java.lang.String.valueOf(r6)
            r4.<init>(r6)
            r4.append(r14)
            java.lang.String r4 = r4.toString()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r4 = java.lang.String.valueOf(r4)
            r6.<init>(r4)
            int r9 = r9 + 64
            char r4 = (char) r9
            r6.append(r4)
            java.lang.String r6 = r6.toString()
            goto L_0x0214
        L_0x017b:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r6 = java.lang.String.valueOf(r6)
            r4.<init>(r6)
            r4.append(r15)
            java.lang.String r4 = r4.toString()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r4 = java.lang.String.valueOf(r4)
            r6.<init>(r4)
            int r9 = r9 + -32
            char r4 = (char) r9
            r6.append(r4)
            java.lang.String r6 = r6.toString()
            goto L_0x02aa
        L_0x01a0:
            boolean r15 = isNextDigits(r0, r9, r10)
            if (r15 == 0) goto L_0x01d5
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r6 = java.lang.String.valueOf(r6)
            r4.<init>(r6)
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            java.lang.String r4 = getPackedRawDigits(r0, r9, r10)
            char r6 = r4.charAt(r5)
            int r9 = r9 + r6
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r6.<init>(r2)
            java.lang.String r2 = r4.substring(r13)
            r6.append(r2)
            java.lang.String r6 = r6.toString()
            goto L_0x0262
        L_0x01d5:
            int r2 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 != r7) goto L_0x01ef
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r6 = java.lang.String.valueOf(r6)
            r9.<init>(r6)
            r9.append(r3)
            java.lang.String r6 = r9.toString()
            goto L_0x0280
        L_0x01ef:
            if (r9 >= r12) goto L_0x021b
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r6 = java.lang.String.valueOf(r6)
            r4.<init>(r6)
            r4.append(r14)
            java.lang.String r4 = r4.toString()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r4 = java.lang.String.valueOf(r4)
            r6.<init>(r4)
            int r9 = r9 + 64
            char r4 = (char) r9
            r6.append(r4)
            java.lang.String r6 = r6.toString()
        L_0x0214:
            r9 = r2
            r2 = 104(0x68, float:1.46E-43)
            r4 = 103(0x67, float:1.44E-43)
            goto L_0x0113
        L_0x021b:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r6 = java.lang.String.valueOf(r6)
            r10.<init>(r6)
            int r9 = r9 + -32
            char r6 = (char) r9
            r10.append(r6)
            java.lang.String r6 = r10.toString()
            goto L_0x0280
        L_0x022f:
            boolean r14 = isNextDigits(r0, r9, r10)
            if (r14 == 0) goto L_0x0268
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r6 = java.lang.String.valueOf(r6)
            r4.<init>(r6)
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            java.lang.String r4 = getPackedRawDigits(r0, r9, r10)
            char r6 = r4.charAt(r5)
            int r9 = r9 + r6
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r6.<init>(r2)
            java.lang.String r2 = r4.substring(r13)
            r6.append(r2)
            java.lang.String r6 = r6.toString()
        L_0x0262:
            r2 = 104(0x68, float:1.46E-43)
            r4 = 105(0x69, float:1.47E-43)
            goto L_0x0113
        L_0x0268:
            int r2 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 != r7) goto L_0x0283
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r6 = java.lang.String.valueOf(r6)
            r9.<init>(r6)
            r9.append(r3)
            java.lang.String r6 = r9.toString()
        L_0x0280:
            r9 = r2
            goto L_0x0111
        L_0x0283:
            r10 = 95
            if (r9 <= r10) goto L_0x02b1
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r6 = java.lang.String.valueOf(r6)
            r4.<init>(r6)
            r4.append(r15)
            java.lang.String r4 = r4.toString()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r4 = java.lang.String.valueOf(r4)
            r6.<init>(r4)
            int r9 = r9 + -32
            char r4 = (char) r9
            r6.append(r4)
            java.lang.String r6 = r6.toString()
        L_0x02aa:
            r9 = r2
            r2 = 104(0x68, float:1.46E-43)
            r4 = 104(0x68, float:1.46E-43)
            goto L_0x0113
        L_0x02b1:
            if (r9 >= r12) goto L_0x02c7
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r6 = java.lang.String.valueOf(r6)
            r10.<init>(r6)
            int r9 = r9 + 64
            char r6 = (char) r9
            r10.append(r6)
            java.lang.String r6 = r10.toString()
            goto L_0x0280
        L_0x02c7:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r6 = java.lang.String.valueOf(r6)
            r10.<init>(r6)
            int r9 = r9 + -32
            char r6 = (char) r9
            r10.append(r6)
            java.lang.String r6 = r10.toString()
            goto L_0x0280
        L_0x02db:
            char r2 = r0.charAt(r6)
            r8 = 127(0x7f, float:1.78E-43)
            if (r2 <= r8) goto L_0x02ff
            if (r2 != r7) goto L_0x02e6
            goto L_0x02ff
        L_0x02e6:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "There are illegal characters for barcode 128 in '"
            r2.<init>(r3)
            r2.append(r0)
            java.lang.String r0 = "'."
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x02ff:
            int r6 = r6 + 1
            r2 = 104(0x68, float:1.46E-43)
            goto L_0x002f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.Barcode128.getRawText(java.lang.String, boolean):java.lang.String");
    }

    public static byte[] getBarsCode128Raw(String str) {
        int indexOf = str.indexOf(65535);
        if (indexOf >= 0) {
            str = str.substring(0, indexOf);
        }
        int charAt = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            charAt += str.charAt(i) * i;
        }
        String str2 = String.valueOf(str) + ((char) (charAt % 103));
        byte[] bArr = new byte[(((str2.length() + 1) * 6) + 7)];
        int i2 = 0;
        while (i2 < str2.length()) {
            System.arraycopy(BARS[str2.charAt(i2)], 0, bArr, i2 * 6, 6);
            i2++;
        }
        System.arraycopy(BARS_STOP, 0, bArr, i2 * 6, 7);
        return bArr;
    }

    public Rectangle getBarcodeSize() {
        float f;
        String str;
        float f2;
        String str2;
        boolean z = true;
        float f3 = 0.0f;
        if (this.font != null) {
            if (this.baseline > 0.0f) {
                f2 = this.baseline - this.font.getFontDescriptor(3, this.size);
            } else {
                f2 = (-this.baseline) + this.size;
            }
            f3 = f2;
            if (this.codeType == 11) {
                int indexOf = this.code.indexOf(65535);
                if (indexOf < 0) {
                    str2 = "";
                } else {
                    str2 = this.code.substring(indexOf + 1);
                }
            } else if (this.codeType == 10) {
                str2 = getHumanReadableUCCEAN(this.code);
            } else {
                str2 = removeFNC1(this.code);
            }
            BaseFont baseFont = this.font;
            if (this.altText != null) {
                str2 = this.altText;
            }
            f = baseFont.getWidthPoint(str2, this.size);
        } else {
            f = 0.0f;
        }
        if (this.codeType == 11) {
            int indexOf2 = this.code.indexOf(65535);
            if (indexOf2 >= 0) {
                str = this.code.substring(0, indexOf2);
            } else {
                str = this.code;
            }
        } else {
            String str3 = this.code;
            if (this.codeType != 10) {
                z = false;
            }
            str = getRawText(str3, z);
        }
        return new Rectangle(Math.max((((float) ((str.length() + 2) * 11)) * this.f611x) + (this.f611x * 2.0f), f), this.barHeight + f3);
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00ed  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.lowagie.text.Rectangle placeBarcode(com.lowagie.text.pdf.PdfContentByte r12, harmony.java.awt.Color r13, harmony.java.awt.Color r14) {
        /*
            r11 = this;
            int r0 = r11.codeType
            r1 = 65535(0xffff, float:9.1834E-41)
            r2 = 10
            r3 = 11
            r4 = 1
            if (r0 != r3) goto L_0x001f
            java.lang.String r0 = r11.code
            int r0 = r0.indexOf(r1)
            if (r0 >= 0) goto L_0x0017
            java.lang.String r0 = ""
            goto L_0x0030
        L_0x0017:
            java.lang.String r5 = r11.code
            int r0 = r0 + r4
            java.lang.String r0 = r5.substring(r0)
            goto L_0x0030
        L_0x001f:
            int r0 = r11.codeType
            if (r0 != r2) goto L_0x002a
            java.lang.String r0 = r11.code
            java.lang.String r0 = getHumanReadableUCCEAN(r0)
            goto L_0x0030
        L_0x002a:
            java.lang.String r0 = r11.code
            java.lang.String r0 = removeFNC1(r0)
        L_0x0030:
            com.lowagie.text.pdf.BaseFont r5 = r11.font
            r6 = 0
            if (r5 == 0) goto L_0x0044
            com.lowagie.text.pdf.BaseFont r5 = r11.font
            java.lang.String r7 = r11.altText
            if (r7 == 0) goto L_0x003d
            java.lang.String r0 = r11.altText
        L_0x003d:
            float r7 = r11.size
            float r5 = r5.getWidthPoint((java.lang.String) r0, (float) r7)
            goto L_0x0045
        L_0x0044:
            r5 = 0
        L_0x0045:
            int r7 = r11.codeType
            r8 = 0
            if (r7 != r3) goto L_0x005c
            java.lang.String r2 = r11.code
            int r1 = r2.indexOf(r1)
            if (r1 < 0) goto L_0x0059
            java.lang.String r2 = r11.code
            java.lang.String r1 = r2.substring(r8, r1)
            goto L_0x0069
        L_0x0059:
            java.lang.String r1 = r11.code
            goto L_0x0069
        L_0x005c:
            java.lang.String r1 = r11.code
            int r7 = r11.codeType
            if (r7 != r2) goto L_0x0064
            r2 = 1
            goto L_0x0065
        L_0x0064:
            r2 = 0
        L_0x0065:
            java.lang.String r1 = getRawText(r1, r2)
        L_0x0069:
            int r2 = r1.length()
            r7 = 2
            int r2 = r2 + r7
            int r2 = r2 * 11
            float r2 = (float) r2
            float r3 = r11.f611x
            float r2 = r2 * r3
            float r3 = r11.f611x
            r9 = 1073741824(0x40000000, float:2.0)
            float r3 = r3 * r9
            float r2 = r2 + r3
            int r3 = r11.textAlignment
            if (r3 == 0) goto L_0x0099
            if (r3 == r7) goto L_0x0090
            int r3 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r3 <= 0) goto L_0x008b
            float r5 = r5 - r2
            float r2 = r5 / r9
            goto L_0x009a
        L_0x008b:
            float r2 = r2 - r5
            float r2 = r2 / r9
        L_0x008d:
            r3 = r2
            r2 = 0
            goto L_0x009b
        L_0x0090:
            int r3 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r3 <= 0) goto L_0x0097
            float r2 = r5 - r2
            goto L_0x009a
        L_0x0097:
            float r2 = r2 - r5
            goto L_0x008d
        L_0x0099:
            r2 = 0
        L_0x009a:
            r3 = 0
        L_0x009b:
            com.lowagie.text.pdf.BaseFont r5 = r11.font
            if (r5 == 0) goto L_0x00bc
            float r5 = r11.baseline
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 > 0) goto L_0x00ab
            float r5 = r11.barHeight
            float r7 = r11.baseline
            float r5 = r5 - r7
            goto L_0x00bd
        L_0x00ab:
            com.lowagie.text.pdf.BaseFont r5 = r11.font
            r6 = 3
            float r7 = r11.size
            float r5 = r5.getFontDescriptor(r6, r7)
            float r6 = -r5
            float r5 = r11.baseline
            float r5 = r5 + r6
            r10 = r6
            r6 = r5
            r5 = r10
            goto L_0x00bd
        L_0x00bc:
            r5 = 0
        L_0x00bd:
            byte[] r1 = getBarsCode128Raw(r1)
            if (r13 == 0) goto L_0x00c6
            r12.setColorFill(r13)
        L_0x00c6:
            int r13 = r1.length
            if (r8 < r13) goto L_0x00ed
            r12.fill()
            com.lowagie.text.pdf.BaseFont r13 = r11.font
            if (r13 == 0) goto L_0x00e8
            if (r14 == 0) goto L_0x00d5
            r12.setColorFill(r14)
        L_0x00d5:
            r12.beginText()
            com.lowagie.text.pdf.BaseFont r13 = r11.font
            float r14 = r11.size
            r12.setFontAndSize(r13, r14)
            r12.setTextMatrix(r3, r5)
            r12.showText((java.lang.String) r0)
            r12.endText()
        L_0x00e8:
            com.lowagie.text.Rectangle r12 = r11.getBarcodeSize()
            return r12
        L_0x00ed:
            byte r13 = r1[r8]
            float r13 = (float) r13
            float r7 = r11.f611x
            float r13 = r13 * r7
            if (r4 == 0) goto L_0x00ff
            float r7 = r11.inkSpreading
            float r7 = r13 - r7
            float r9 = r11.barHeight
            r12.rectangle(r2, r6, r7, r9)
        L_0x00ff:
            r4 = r4 ^ 1
            float r2 = r2 + r13
            int r8 = r8 + 1
            goto L_0x00c6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.Barcode128.placeBarcode(com.lowagie.text.pdf.PdfContentByte, harmony.java.awt.Color, harmony.java.awt.Color):com.lowagie.text.Rectangle");
    }

    public void setCode(String str) {
        if (getCodeType() != 10 || !str.startsWith("(")) {
            super.setCode(str);
            return;
        }
        int i = 0;
        String str2 = "";
        while (i >= 0) {
            int indexOf = str.indexOf(41, i);
            if (indexOf >= 0) {
                String substring = str.substring(i + 1, indexOf);
                if (substring.length() >= 2) {
                    int parseInt = Integer.parseInt(substring);
                    int i2 = ais.get(parseInt);
                    if (i2 != 0) {
                        String valueOf = String.valueOf(parseInt);
                        if (valueOf.length() == 1) {
                            valueOf = "0" + valueOf;
                        }
                        int indexOf2 = str.indexOf(40, indexOf);
                        int length = indexOf2 < 0 ? str.length() : indexOf2;
                        str2 = String.valueOf(str2) + valueOf + str.substring(indexOf + 1, length);
                        if (i2 < 0) {
                            if (indexOf2 >= 0) {
                                str2 = String.valueOf(str2) + FNC1;
                            }
                        } else if (((length - indexOf) - 1) + valueOf.length() != i2) {
                            throw new IllegalArgumentException("Invalid AI length: (" + valueOf + ")");
                        }
                        i = indexOf2;
                    } else {
                        throw new IllegalArgumentException("AI not found: (" + substring + ")");
                    }
                } else {
                    throw new IllegalArgumentException("AI too short: (" + substring + ")");
                }
            } else {
                throw new IllegalArgumentException("Badly formed UCC string: " + str);
            }
        }
        super.setCode(str2);
    }
}
