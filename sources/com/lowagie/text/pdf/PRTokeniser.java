package com.lowagie.text.pdf;

import java.io.IOException;

public class PRTokeniser {
    static final String EMPTY = "";
    public static final int TK_COMMENT = 4;
    public static final int TK_END_ARRAY = 6;
    public static final int TK_END_DIC = 8;
    public static final int TK_NAME = 3;
    public static final int TK_NUMBER = 1;
    public static final int TK_OTHER = 10;
    public static final int TK_REF = 9;
    public static final int TK_START_ARRAY = 5;
    public static final int TK_START_DIC = 7;
    public static final int TK_STRING = 2;
    public static final boolean[] delims;
    protected RandomAccessFileOrArray file;
    protected int generation;
    protected boolean hexString;
    protected int reference;
    protected String stringValue;
    protected int type;

    public static int getHex(int i) {
        if (i >= 48 && i <= 57) {
            return i - 48;
        }
        int i2 = 65;
        if (i < 65 || i > 70) {
            i2 = 97;
            if (i < 97 || i > 102) {
                return -1;
            }
        }
        return (i - i2) + 10;
    }

    public static final boolean isDelimiter(int i) {
        return i == 40 || i == 41 || i == 60 || i == 62 || i == 91 || i == 93 || i == 47 || i == 37;
    }

    public static final boolean isWhitespace(int i) {
        return i == 0 || i == 9 || i == 10 || i == 12 || i == 13 || i == 32;
    }

    static {
        boolean[] zArr = new boolean[257];
        zArr[0] = true;
        zArr[1] = true;
        zArr[10] = true;
        zArr[11] = true;
        zArr[13] = true;
        zArr[14] = true;
        zArr[33] = true;
        zArr[38] = true;
        zArr[41] = true;
        zArr[42] = true;
        zArr[48] = true;
        zArr[61] = true;
        zArr[63] = true;
        zArr[92] = true;
        zArr[94] = true;
        delims = zArr;
    }

    public PRTokeniser(String str) throws IOException {
        this.file = new RandomAccessFileOrArray(str);
    }

    public PRTokeniser(byte[] bArr) {
        this.file = new RandomAccessFileOrArray(bArr);
    }

    public PRTokeniser(RandomAccessFileOrArray randomAccessFileOrArray) {
        this.file = randomAccessFileOrArray;
    }

    public void seek(int i) throws IOException {
        this.file.seek(i);
    }

    public int getFilePointer() throws IOException {
        return this.file.getFilePointer();
    }

    public void close() throws IOException {
        this.file.close();
    }

    public int length() throws IOException {
        return this.file.length();
    }

    public int read() throws IOException {
        return this.file.read();
    }

    public RandomAccessFileOrArray getSafeFile() {
        return new RandomAccessFileOrArray(this.file);
    }

    public RandomAccessFileOrArray getFile() {
        return this.file;
    }

    public String readString(int i) throws IOException {
        int read;
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            int i2 = i - 1;
            if (i > 0 && (read = this.file.read()) != -1) {
                stringBuffer.append((char) read);
                i = i2;
            }
        }
        return stringBuffer.toString();
    }

    public static final boolean isDelimiterWhitespace(int i) {
        return delims[i + 1];
    }

    public int getTokenType() {
        return this.type;
    }

    public String getStringValue() {
        return this.stringValue;
    }

    public int getReference() {
        return this.reference;
    }

    public int getGeneration() {
        return this.generation;
    }

    public void backOnePosition(int i) {
        if (i != -1) {
            this.file.pushBack((byte) i);
        }
    }

    public void throwError(String str) throws IOException {
        throw new IOException(String.valueOf(str) + " at file pointer " + this.file.getFilePointer());
    }

    public char checkPdfHeader() throws IOException {
        this.file.setStartOffset(0);
        String readString = readString(1024);
        int indexOf = readString.indexOf("%PDF-");
        if (indexOf >= 0) {
            this.file.setStartOffset(indexOf);
            return readString.charAt(indexOf + 7);
        }
        throw new IOException("PDF header signature not found.");
    }

    public void checkFdfHeader() throws IOException {
        this.file.setStartOffset(0);
        int indexOf = readString(1024).indexOf("%FDF-1.2");
        if (indexOf >= 0) {
            this.file.setStartOffset(indexOf);
            return;
        }
        throw new IOException("FDF header signature not found.");
    }

    public int getStartxref() throws IOException {
        int length = this.file.length() - Math.min(1024, this.file.length());
        this.file.seek(length);
        int lastIndexOf = readString(1024).lastIndexOf("startxref");
        if (lastIndexOf >= 0) {
            return length + lastIndexOf;
        }
        throw new IOException("PDF startxref not found.");
    }

    public void nextValidToken() throws IOException {
        int i = 0;
        String str = null;
        String str2 = null;
        int i2 = 0;
        while (nextToken()) {
            int i3 = this.type;
            if (i3 != 4) {
                if (i != 0) {
                    if (i != 1) {
                        if (i3 != 10 || !this.stringValue.equals("R")) {
                            this.file.seek(i2);
                            this.type = 1;
                            this.stringValue = str;
                            return;
                        }
                        this.type = 9;
                        this.reference = Integer.parseInt(str);
                        this.generation = Integer.parseInt(str2);
                        return;
                    } else if (i3 != 1) {
                        this.file.seek(i2);
                        this.type = 1;
                        this.stringValue = str;
                        return;
                    } else {
                        str2 = this.stringValue;
                    }
                } else if (i3 == 1) {
                    i2 = this.file.getFilePointer();
                    str = this.stringValue;
                } else {
                    return;
                }
                i++;
            }
        }
    }

    /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public boolean nextToken() throws java.io.IOException {
        /*
            r13 = this;
        L_0x0000:
            com.lowagie.text.pdf.RandomAccessFileOrArray r0 = r13.file
            int r0 = r0.read()
            r1 = -1
            if (r0 == r1) goto L_0x000f
            boolean r2 = isWhitespace(r0)
            if (r2 != 0) goto L_0x0000
        L_0x000f:
            r2 = 0
            if (r0 != r1) goto L_0x0013
            return r2
        L_0x0013:
            r3 = 0
            java.lang.String r4 = ""
            r13.stringValue = r4
            r4 = 37
            r5 = 13
            r6 = 4
            r7 = 10
            r8 = 1
            if (r0 == r4) goto L_0x021a
            r4 = 8
            r9 = 2
            r10 = 40
            r11 = 48
            if (r0 == r10) goto L_0x0145
            r5 = 47
            if (r0 == r5) goto L_0x010b
            r5 = 60
            r10 = 62
            if (r0 == r5) goto L_0x00a2
            if (r0 == r10) goto L_0x0091
            r2 = 91
            if (r0 == r2) goto L_0x008c
            r2 = 93
            if (r0 == r2) goto L_0x0087
            java.lang.StringBuffer r3 = new java.lang.StringBuffer
            r3.<init>()
            r2 = 45
            r4 = 46
            if (r0 == r2) goto L_0x006c
            r2 = 43
            if (r0 == r2) goto L_0x006c
            if (r0 == r4) goto L_0x006c
            if (r0 < r11) goto L_0x0057
            r2 = 57
            if (r0 > r2) goto L_0x0057
            goto L_0x006c
        L_0x0057:
            r13.type = r7
        L_0x0059:
            char r0 = (char) r0
            r3.append(r0)
            com.lowagie.text.pdf.RandomAccessFileOrArray r0 = r13.file
            int r0 = r0.read()
            boolean[] r1 = delims
            int r2 = r0 + 1
            boolean r1 = r1[r2]
            if (r1 == 0) goto L_0x0059
            goto L_0x0082
        L_0x006c:
            r13.type = r8
        L_0x006e:
            char r0 = (char) r0
            r3.append(r0)
            com.lowagie.text.pdf.RandomAccessFileOrArray r0 = r13.file
            int r0 = r0.read()
            if (r0 == r1) goto L_0x0082
            if (r0 < r11) goto L_0x0080
            r2 = 57
            if (r0 <= r2) goto L_0x006e
        L_0x0080:
            if (r0 == r4) goto L_0x006e
        L_0x0082:
            r13.backOnePosition(r0)
            goto L_0x0228
        L_0x0087:
            r0 = 6
            r13.type = r0
            goto L_0x0228
        L_0x008c:
            r0 = 5
            r13.type = r0
            goto L_0x0228
        L_0x0091:
            com.lowagie.text.pdf.RandomAccessFileOrArray r0 = r13.file
            int r0 = r0.read()
            if (r0 == r10) goto L_0x009e
            java.lang.String r0 = "'>' not expected"
            r13.throwError(r0)
        L_0x009e:
            r13.type = r4
            goto L_0x0228
        L_0x00a2:
            com.lowagie.text.pdf.RandomAccessFileOrArray r0 = r13.file
            int r0 = r0.read()
            if (r0 != r5) goto L_0x00af
            r0 = 7
            r13.type = r0
            goto L_0x0228
        L_0x00af:
            java.lang.StringBuffer r3 = new java.lang.StringBuffer
            r3.<init>()
            r13.type = r9
            r13.hexString = r8
        L_0x00b8:
            boolean r1 = isWhitespace(r0)
            if (r1 != 0) goto L_0x0104
            if (r0 != r10) goto L_0x00c1
            goto L_0x00e4
        L_0x00c1:
            int r0 = getHex(r0)
            if (r0 >= 0) goto L_0x00c8
            goto L_0x00e4
        L_0x00c8:
            com.lowagie.text.pdf.RandomAccessFileOrArray r1 = r13.file
            int r1 = r1.read()
            r2 = r1
        L_0x00cf:
            boolean r1 = isWhitespace(r2)
            if (r1 != 0) goto L_0x00fd
            if (r2 != r10) goto L_0x00de
            int r1 = r0 << 4
            char r1 = (char) r1
            r3.append(r1)
            goto L_0x00e4
        L_0x00de:
            int r2 = getHex(r2)
            if (r2 >= 0) goto L_0x00ef
        L_0x00e4:
            if (r0 < 0) goto L_0x00e8
            if (r2 >= 0) goto L_0x0228
        L_0x00e8:
            java.lang.String r0 = "Error reading string"
            r13.throwError(r0)
            goto L_0x0228
        L_0x00ef:
            int r0 = r0 << 4
            int r0 = r0 + r2
            char r0 = (char) r0
            r3.append(r0)
            com.lowagie.text.pdf.RandomAccessFileOrArray r0 = r13.file
            int r0 = r0.read()
            goto L_0x00b8
        L_0x00fd:
            com.lowagie.text.pdf.RandomAccessFileOrArray r1 = r13.file
            int r2 = r1.read()
            goto L_0x00cf
        L_0x0104:
            com.lowagie.text.pdf.RandomAccessFileOrArray r0 = r13.file
            int r0 = r0.read()
            goto L_0x00b8
        L_0x010b:
            java.lang.StringBuffer r3 = new java.lang.StringBuffer
            r3.<init>()
            r0 = 3
            r13.type = r0
        L_0x0113:
            com.lowagie.text.pdf.RandomAccessFileOrArray r0 = r13.file
            int r0 = r0.read()
            boolean[] r1 = delims
            int r2 = r0 + 1
            boolean r1 = r1[r2]
            if (r1 == 0) goto L_0x0126
            r13.backOnePosition(r0)
            goto L_0x0228
        L_0x0126:
            r1 = 35
            if (r0 != r1) goto L_0x0140
            com.lowagie.text.pdf.RandomAccessFileOrArray r0 = r13.file
            int r0 = r0.read()
            int r0 = getHex(r0)
            int r0 = r0 << r6
            com.lowagie.text.pdf.RandomAccessFileOrArray r1 = r13.file
            int r1 = r1.read()
            int r1 = getHex(r1)
            int r0 = r0 + r1
        L_0x0140:
            char r0 = (char) r0
            r3.append(r0)
            goto L_0x0113
        L_0x0145:
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            r13.type = r9
            r13.hexString = r2
            r3 = 0
        L_0x014f:
            com.lowagie.text.pdf.RandomAccessFileOrArray r6 = r13.file
            int r6 = r6.read()
            if (r6 != r1) goto L_0x0159
            goto L_0x020b
        L_0x0159:
            if (r6 != r10) goto L_0x015f
            int r3 = r3 + 1
            goto L_0x0209
        L_0x015f:
            r9 = 41
            if (r6 != r9) goto L_0x0167
            int r3 = r3 + -1
            goto L_0x0209
        L_0x0167:
            r9 = 92
            if (r6 != r9) goto L_0x01f7
            com.lowagie.text.pdf.RandomAccessFileOrArray r6 = r13.file
            int r6 = r6.read()
            if (r6 == r7) goto L_0x01eb
            if (r6 == r5) goto L_0x01e0
            r9 = 92
            if (r6 == r9) goto L_0x01dd
            r9 = 98
            if (r6 == r9) goto L_0x01d9
            r9 = 102(0x66, float:1.43E-43)
            if (r6 == r9) goto L_0x01d3
            r9 = 110(0x6e, float:1.54E-43)
            if (r6 == r9) goto L_0x01cf
            r9 = 114(0x72, float:1.6E-43)
            if (r6 == r9) goto L_0x01cb
            r9 = 116(0x74, float:1.63E-43)
            if (r6 == r9) goto L_0x01c5
            if (r6 == r10) goto L_0x01dd
            r9 = 41
            if (r6 == r9) goto L_0x01dd
            if (r6 < r11) goto L_0x01dd
            r9 = 55
            if (r6 <= r9) goto L_0x019a
            goto L_0x01dd
        L_0x019a:
            int r6 = r6 + -48
            com.lowagie.text.pdf.RandomAccessFileOrArray r12 = r13.file
            int r12 = r12.read()
            if (r12 < r11) goto L_0x01c1
            if (r12 <= r9) goto L_0x01a7
            goto L_0x01c1
        L_0x01a7:
            int r6 = r6 << 3
            int r6 = r6 + r12
            int r6 = r6 - r11
            com.lowagie.text.pdf.RandomAccessFileOrArray r12 = r13.file
            int r12 = r12.read()
            if (r12 < r11) goto L_0x01bd
            if (r12 <= r9) goto L_0x01b6
            goto L_0x01bd
        L_0x01b6:
            int r6 = r6 << 3
            int r6 = r6 + r12
            int r6 = r6 - r11
            r6 = r6 & 255(0xff, float:3.57E-43)
            goto L_0x01dd
        L_0x01bd:
            r13.backOnePosition(r12)
            goto L_0x01dd
        L_0x01c1:
            r13.backOnePosition(r12)
            goto L_0x01dd
        L_0x01c5:
            r6 = 9
            r6 = 0
            r9 = 9
            goto L_0x01ed
        L_0x01cb:
            r6 = 0
            r9 = 13
            goto L_0x01ed
        L_0x01cf:
            r6 = 0
            r9 = 10
            goto L_0x01ed
        L_0x01d3:
            r6 = 12
            r6 = 0
            r9 = 12
            goto L_0x01ed
        L_0x01d9:
            r6 = 0
            r9 = 8
            goto L_0x01ed
        L_0x01dd:
            r9 = r6
            r6 = 0
            goto L_0x01ed
        L_0x01e0:
            com.lowagie.text.pdf.RandomAccessFileOrArray r6 = r13.file
            int r6 = r6.read()
            if (r6 == r7) goto L_0x01eb
            r13.backOnePosition(r6)
        L_0x01eb:
            r9 = r6
            r6 = 1
        L_0x01ed:
            if (r6 == 0) goto L_0x01f1
            goto L_0x014f
        L_0x01f1:
            if (r9 >= 0) goto L_0x01f5
            r6 = r9
            goto L_0x020b
        L_0x01f5:
            r6 = r9
            goto L_0x0209
        L_0x01f7:
            if (r6 != r5) goto L_0x0209
            com.lowagie.text.pdf.RandomAccessFileOrArray r6 = r13.file
            int r6 = r6.read()
            if (r6 >= 0) goto L_0x0202
            goto L_0x020b
        L_0x0202:
            if (r6 == r7) goto L_0x0209
            r13.backOnePosition(r6)
            r6 = 10
        L_0x0209:
            if (r3 != r1) goto L_0x0214
        L_0x020b:
            if (r6 != r1) goto L_0x0212
            java.lang.String r1 = "Error reading string"
            r13.throwError(r1)
        L_0x0212:
            r3 = r0
            goto L_0x0228
        L_0x0214:
            char r6 = (char) r6
            r0.append(r6)
            goto L_0x014f
        L_0x021a:
            r13.type = r6
        L_0x021c:
            com.lowagie.text.pdf.RandomAccessFileOrArray r0 = r13.file
            int r0 = r0.read()
            if (r0 == r1) goto L_0x0228
            if (r0 == r5) goto L_0x0228
            if (r0 != r7) goto L_0x021c
        L_0x0228:
            if (r3 == 0) goto L_0x0230
            java.lang.String r0 = r3.toString()
            r13.stringValue = r0
        L_0x0230:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.PRTokeniser.nextToken():boolean");
    }

    public int intValue() {
        return Integer.parseInt(this.stringValue);
    }

    public boolean readLineSegment(byte[] bArr) throws IOException {
        int i;
        int i2;
        boolean z;
        int read;
        int length = bArr.length;
        if (length > 0) {
            do {
                read = read();
            } while (isWhitespace(read));
            i = read;
            z = false;
            i2 = 0;
        } else {
            z = false;
            i2 = 0;
            i = -1;
        }
        while (!z && i2 < length) {
            if (!(i == -1 || i == 10)) {
                if (i != 13) {
                    bArr[i2] = (byte) i;
                    i2++;
                    if (z || length <= i2) {
                        break;
                    }
                    i = read();
                } else {
                    int filePointer = getFilePointer();
                    if (read() != 10) {
                        seek(filePointer);
                    }
                }
            }
            z = true;
            i = read();
        }
        if (i2 >= length) {
            boolean z2 = false;
            while (!z2) {
                i = read();
                if (!(i == -1 || i == 10)) {
                    if (i == 13) {
                        int filePointer2 = getFilePointer();
                        if (read() != 10) {
                            seek(filePointer2);
                        }
                    }
                }
                z2 = true;
            }
        }
        if (i == -1 && i2 == 0) {
            return false;
        }
        if (i2 + 2 <= length) {
            bArr[i2] = 32;
            bArr[i2 + 1] = 88;
        }
        return true;
    }

    public static int[] checkObjectStart(byte[] bArr) {
        try {
            PRTokeniser pRTokeniser = new PRTokeniser(bArr);
            if (pRTokeniser.nextToken()) {
                if (pRTokeniser.getTokenType() == 1) {
                    int intValue = pRTokeniser.intValue();
                    if (pRTokeniser.nextToken()) {
                        if (pRTokeniser.getTokenType() == 1) {
                            int intValue2 = pRTokeniser.intValue();
                            if (!pRTokeniser.nextToken() || !pRTokeniser.getStringValue().equals("obj")) {
                                return null;
                            }
                            return new int[]{intValue, intValue2};
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public boolean isHexString() {
        return this.hexString;
    }
}
