package com.lowagie.text.pdf.fonts.cmaps;

import com.lowagie.text.xml.xmp.XmpWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.PushbackInputStream;
import java.util.List;

public class CMapParser {
    private static final String BEGIN_BASE_FONT_CHAR = "beginbfchar";
    private static final String BEGIN_BASE_FONT_RANGE = "beginbfrange";
    private static final String BEGIN_CODESPACE_RANGE = "begincodespacerange";
    private static final String MARK_END_OF_ARRAY = "]";
    private static final String MARK_END_OF_DICTIONARY = ">>";
    private byte[] tokenParserByteBuffer = new byte[512];

    private boolean isWhitespaceOrEOF(int i) {
        return i == -1 || i == 32 || i == 13 || i == 10;
    }

    public CMap parse(InputStream inputStream) throws IOException {
        byte[] bArr;
        List list;
        PushbackInputStream pushbackInputStream = new PushbackInputStream(inputStream);
        CMap cMap = new CMap();
        Number number = null;
        while (true) {
            Object parseNextToken = parseNextToken(pushbackInputStream);
            if (parseNextToken == null) {
                return cMap;
            }
            if (parseNextToken instanceof Operator) {
                Operator operator = (Operator) parseNextToken;
                int i = 0;
                if (operator.f796op.equals(BEGIN_CODESPACE_RANGE)) {
                    Number number2 = number;
                    while (i < number2.intValue()) {
                        CodespaceRange codespaceRange = new CodespaceRange();
                        codespaceRange.setStart((byte[]) parseNextToken(pushbackInputStream));
                        codespaceRange.setEnd((byte[]) parseNextToken(pushbackInputStream));
                        cMap.addCodespaceRange(codespaceRange);
                        i++;
                    }
                } else if (operator.f796op.equals(BEGIN_BASE_FONT_CHAR)) {
                    Number number3 = number;
                    while (i < number3.intValue()) {
                        byte[] bArr2 = (byte[]) parseNextToken(pushbackInputStream);
                        Object parseNextToken2 = parseNextToken(pushbackInputStream);
                        if (parseNextToken2 instanceof byte[]) {
                            cMap.addMapping(bArr2, createStringFromBytes((byte[]) parseNextToken2));
                        } else if (parseNextToken2 instanceof LiteralName) {
                            cMap.addMapping(bArr2, ((LiteralName) parseNextToken2).name);
                        } else {
                            throw new IOException("Error parsing CMap beginbfchar, expected{COSString or COSName} and not " + parseNextToken2);
                        }
                        i++;
                    }
                    continue;
                } else if (operator.f796op.equals(BEGIN_BASE_FONT_RANGE)) {
                    Number number4 = number;
                    for (int i2 = 0; i2 < number4.intValue(); i2++) {
                        byte[] bArr3 = (byte[]) parseNextToken(pushbackInputStream);
                        byte[] bArr4 = (byte[]) parseNextToken(pushbackInputStream);
                        Object parseNextToken3 = parseNextToken(pushbackInputStream);
                        if (parseNextToken3 instanceof List) {
                            list = (List) parseNextToken3;
                            bArr = (byte[]) list.get(0);
                        } else {
                            bArr = (byte[]) parseNextToken3;
                            list = null;
                        }
                        byte[] bArr5 = bArr;
                        boolean z = false;
                        int i3 = 0;
                        while (!z) {
                            if (compare(bArr3, bArr4) >= 0) {
                                z = true;
                            }
                            cMap.addMapping(bArr3, createStringFromBytes(bArr5));
                            increment(bArr3);
                            if (list == null) {
                                increment(bArr5);
                            } else {
                                i3++;
                                if (i3 < list.size()) {
                                    bArr5 = (byte[]) list.get(i3);
                                }
                            }
                        }
                    }
                }
            }
            number = parseNextToken;
        }
    }

    /* JADX WARNING: type inference failed for: r0v18, types: [java.util.List, java.util.ArrayList] */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x00d5, code lost:
        r0 = r0;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x009a  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.Object parseNextToken(java.io.PushbackInputStream r11) throws java.io.IOException {
        /*
            r10 = this;
            int r0 = r11.read()
        L_0x0004:
            r1 = 9
            if (r0 == r1) goto L_0x01b6
            r1 = 32
            if (r0 == r1) goto L_0x01b6
            r1 = 13
            if (r0 == r1) goto L_0x01b6
            r1 = 10
            if (r0 == r1) goto L_0x01b6
            java.lang.String r1 = ">>"
            java.lang.String r2 = "]"
            r3 = 0
            r4 = -1
            if (r0 == r4) goto L_0x01b4
            r5 = 37
            if (r0 == r5) goto L_0x01a3
            r5 = 40
            if (r0 == r5) goto L_0x0185
            r5 = 60
            r6 = 62
            if (r0 == r5) goto L_0x00f0
            if (r0 == r6) goto L_0x00e0
            r1 = 91
            if (r0 == r1) goto L_0x00ca
            r1 = 93
            if (r0 == r1) goto L_0x00c7
            switch(r0) {
                case 47: goto L_0x00a4;
                case 48: goto L_0x005f;
                case 49: goto L_0x005f;
                case 50: goto L_0x005f;
                case 51: goto L_0x005f;
                case 52: goto L_0x005f;
                case 53: goto L_0x005f;
                case 54: goto L_0x005f;
                case 55: goto L_0x005f;
                case 56: goto L_0x005f;
                case 57: goto L_0x005f;
                default: goto L_0x0037;
            }
        L_0x0037:
            java.lang.StringBuffer r1 = new java.lang.StringBuffer
            r1.<init>()
            char r0 = (char) r0
            r1.append(r0)
            int r0 = r11.read()
        L_0x0044:
            boolean r2 = r10.isWhitespaceOrEOF(r0)
            if (r2 == 0) goto L_0x0056
            com.lowagie.text.pdf.fonts.cmaps.CMapParser$Operator r11 = new com.lowagie.text.pdf.fonts.cmaps.CMapParser$Operator
            java.lang.String r0 = r1.toString()
            r11.<init>(r10, r0, r3)
        L_0x0053:
            r1 = r11
            goto L_0x01b5
        L_0x0056:
            char r0 = (char) r0
            r1.append(r0)
            int r0 = r11.read()
            goto L_0x0044
        L_0x005f:
            java.lang.StringBuffer r1 = new java.lang.StringBuffer
            r1.<init>()
            char r0 = (char) r0
            r1.append(r0)
            int r0 = r11.read()
        L_0x006c:
            boolean r2 = r10.isWhitespaceOrEOF(r0)
            r3 = 46
            if (r2 != 0) goto L_0x0086
            char r2 = (char) r0
            boolean r4 = java.lang.Character.isDigit(r2)
            if (r4 != 0) goto L_0x007e
            if (r0 == r3) goto L_0x007e
            goto L_0x0086
        L_0x007e:
            r1.append(r2)
            int r0 = r11.read()
            goto L_0x006c
        L_0x0086:
            r11.unread(r0)
            java.lang.String r11 = r1.toString()
            int r0 = r11.indexOf(r3)
            if (r0 < 0) goto L_0x009a
            java.lang.Double r1 = new java.lang.Double
            r1.<init>(r11)
            goto L_0x01b5
        L_0x009a:
            java.lang.Integer r11 = new java.lang.Integer
            java.lang.String r0 = r1.toString()
            r11.<init>(r0)
            goto L_0x0053
        L_0x00a4:
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            int r1 = r11.read()
        L_0x00ad:
            boolean r2 = r10.isWhitespaceOrEOF(r1)
            if (r2 == 0) goto L_0x00be
            com.lowagie.text.pdf.fonts.cmaps.CMapParser$LiteralName r1 = new com.lowagie.text.pdf.fonts.cmaps.CMapParser$LiteralName
            java.lang.String r11 = r0.toString()
            r1.<init>(r10, r11, r3)
            goto L_0x01b5
        L_0x00be:
            char r1 = (char) r1
            r0.append(r1)
            int r1 = r11.read()
            goto L_0x00ad
        L_0x00c7:
            r1 = r2
            goto L_0x01b5
        L_0x00ca:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.Object r1 = r10.parseNextToken(r11)
        L_0x00d3:
            if (r1 != r2) goto L_0x00d8
        L_0x00d5:
            r1 = r0
            goto L_0x01b5
        L_0x00d8:
            r0.add(r1)
            java.lang.Object r1 = r10.parseNextToken(r11)
            goto L_0x00d3
        L_0x00e0:
            int r11 = r11.read()
            if (r11 != r6) goto L_0x00e8
            goto L_0x01b5
        L_0x00e8:
            java.io.IOException r11 = new java.io.IOException
            java.lang.String r0 = "Error: expected the end of a dictionary."
            r11.<init>(r0)
            throw r11
        L_0x00f0:
            int r0 = r11.read()
            if (r0 != r5) goto L_0x0118
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.Object r2 = r10.parseNextToken(r11)
        L_0x00ff:
            boolean r3 = r2 instanceof com.lowagie.text.pdf.fonts.cmaps.CMapParser.LiteralName
            if (r3 == 0) goto L_0x00d5
            if (r2 != r1) goto L_0x0106
            goto L_0x00d5
        L_0x0106:
            java.lang.Object r3 = r10.parseNextToken(r11)
            com.lowagie.text.pdf.fonts.cmaps.CMapParser$LiteralName r2 = (com.lowagie.text.pdf.fonts.cmaps.CMapParser.LiteralName) r2
            java.lang.String r2 = r2.name
            r0.put(r2, r3)
            java.lang.Object r2 = r10.parseNextToken(r11)     // Catch:{ Throwable -> 0x01bc }
            goto L_0x00ff
        L_0x0118:
            r1 = 16
            r2 = -1
            r3 = 16
        L_0x011d:
            r5 = 0
            r7 = 1
            if (r0 == r4) goto L_0x017c
            if (r0 != r6) goto L_0x0124
            goto L_0x017c
        L_0x0124:
            r8 = 48
            if (r0 < r8) goto L_0x012f
            r8 = 57
            if (r0 > r8) goto L_0x012f
            int r0 = r0 + -48
            goto L_0x0144
        L_0x012f:
            r8 = 65
            if (r0 < r8) goto L_0x013b
            r9 = 70
            if (r0 > r9) goto L_0x013b
        L_0x0137:
            int r0 = r0 + 10
            int r0 = r0 - r8
            goto L_0x0144
        L_0x013b:
            r8 = 97
            if (r0 < r8) goto L_0x015f
            r9 = 102(0x66, float:1.43E-43)
            if (r0 > r9) goto L_0x015f
            goto L_0x0137
        L_0x0144:
            int r0 = r0 * r3
            if (r3 != r1) goto L_0x0150
            int r2 = r2 + 1
            byte[] r3 = r10.tokenParserByteBuffer
            r3[r2] = r5
            r3 = 1
            goto L_0x0152
        L_0x0150:
            r3 = 16
        L_0x0152:
            byte[] r5 = r10.tokenParserByteBuffer
            byte r7 = r5[r2]
            int r7 = r7 + r0
            byte r0 = (byte) r7
            r5[r2] = r0
            int r0 = r11.read()
            goto L_0x011d
        L_0x015f:
            java.io.IOException r11 = new java.io.IOException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Error: expected hex character and not "
            r1.<init>(r2)
            char r2 = (char) r0
            r1.append(r2)
            java.lang.String r2 = ":"
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r11.<init>(r0)
            throw r11
        L_0x017c:
            int r2 = r2 + r7
            byte[] r1 = new byte[r2]
            byte[] r11 = r10.tokenParserByteBuffer
            java.lang.System.arraycopy(r11, r5, r1, r5, r2)
            goto L_0x01b5
        L_0x0185:
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            int r1 = r11.read()
        L_0x018e:
            if (r1 == r4) goto L_0x019e
            r2 = 41
            if (r1 != r2) goto L_0x0195
            goto L_0x019e
        L_0x0195:
            char r1 = (char) r1
            r0.append(r1)
            int r1 = r11.read()
            goto L_0x018e
        L_0x019e:
            java.lang.String r1 = r0.toString()
            goto L_0x01b5
        L_0x01a3:
            java.lang.StringBuffer r1 = new java.lang.StringBuffer
            r1.<init>()
            char r0 = (char) r0
            r1.append(r0)
            r10.readUntilEndOfLine(r11, r1)
            java.lang.String r1 = r1.toString()
            goto L_0x01b5
        L_0x01b4:
            r1 = r3
        L_0x01b5:
            return r1
        L_0x01b6:
            int r0 = r11.read()
            goto L_0x0004
        L_0x01bc:
            r11 = move-exception
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.fonts.cmaps.CMapParser.parseNextToken(java.io.PushbackInputStream):java.lang.Object");
    }

    private void readUntilEndOfLine(InputStream inputStream, StringBuffer stringBuffer) throws IOException {
        int read = inputStream.read();
        while (read != -1 && read != 13 && read != 10) {
            stringBuffer.append((char) read);
            read = inputStream.read();
        }
    }

    private void increment(byte[] bArr) {
        increment(bArr, bArr.length - 1);
    }

    private void increment(byte[] bArr, int i) {
        if (i <= 0 || (bArr[i] + 256) % 256 != 255) {
            bArr[i] = (byte) (bArr[i] + 1);
            return;
        }
        bArr[i] = 0;
        increment(bArr, i - 1);
    }

    private String createStringFromBytes(byte[] bArr) throws IOException {
        if (bArr.length == 1) {
            return new String(bArr);
        }
        return new String(bArr, XmpWriter.UTF16BE);
    }

    private int compare(byte[] bArr, byte[] bArr2) {
        boolean z = false;
        int i = 1;
        for (int i2 = 0; i2 < bArr.length && !z; i2++) {
            if (bArr[i2] != bArr2[i2]) {
                if ((bArr[i2] + 256) % 256 < (bArr2[i2] + 256) % 256) {
                    z = true;
                    i = -1;
                } else {
                    z = true;
                    i = 1;
                }
            }
        }
        return i;
    }

    private class LiteralName {
        /* access modifiers changed from: private */
        public String name;

        /* synthetic */ LiteralName(CMapParser cMapParser, String str, LiteralName literalName) {
            this(str);
        }

        private LiteralName(String str) {
            this.name = str;
        }
    }

    private class Operator {
        /* access modifiers changed from: private */

        /* renamed from: op */
        public String f796op;

        /* synthetic */ Operator(CMapParser cMapParser, String str, Operator operator) {
            this(str);
        }

        private Operator(String str) {
            this.f796op = str;
        }
    }

    public static void main(String[] strArr) throws Exception {
        if (strArr.length != 1) {
            System.err.println("usage: java org.pdfbox.cmapparser.CMapParser <CMAP File>");
            System.exit(-1);
        }
        CMap parse = new CMapParser().parse(new FileInputStream(strArr[0]));
        PrintStream printStream = System.out;
        printStream.println("Result:" + parse);
    }
}
