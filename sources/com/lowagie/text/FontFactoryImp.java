package com.lowagie.text;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.lowagie.text.pdf.BaseFont;
import harmony.java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Set;

public class FontFactoryImp {
    private static String[] TTFamilyOrder = {ExifInterface.GPS_MEASUREMENT_3D, IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, "1033", ExifInterface.GPS_MEASUREMENT_3D, "0", "1033", IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, "0", "0", "0", ExifInterface.GPS_MEASUREMENT_3D, "0"};
    public boolean defaultEmbedding = false;
    public String defaultEncoding = "Cp1252";
    private Hashtable fontFamilies = new Hashtable();
    private Properties trueTypeFonts = new Properties();

    public FontFactoryImp() {
        this.trueTypeFonts.setProperty("Courier".toLowerCase(), "Courier");
        this.trueTypeFonts.setProperty("Courier-Bold".toLowerCase(), "Courier-Bold");
        this.trueTypeFonts.setProperty("Courier-Oblique".toLowerCase(), "Courier-Oblique");
        this.trueTypeFonts.setProperty("Courier-BoldOblique".toLowerCase(), "Courier-BoldOblique");
        this.trueTypeFonts.setProperty("Helvetica".toLowerCase(), "Helvetica");
        this.trueTypeFonts.setProperty("Helvetica-Bold".toLowerCase(), "Helvetica-Bold");
        this.trueTypeFonts.setProperty("Helvetica-Oblique".toLowerCase(), "Helvetica-Oblique");
        this.trueTypeFonts.setProperty("Helvetica-BoldOblique".toLowerCase(), "Helvetica-BoldOblique");
        this.trueTypeFonts.setProperty("Symbol".toLowerCase(), "Symbol");
        this.trueTypeFonts.setProperty("Times-Roman".toLowerCase(), "Times-Roman");
        this.trueTypeFonts.setProperty("Times-Bold".toLowerCase(), "Times-Bold");
        this.trueTypeFonts.setProperty("Times-Italic".toLowerCase(), "Times-Italic");
        this.trueTypeFonts.setProperty("Times-BoldItalic".toLowerCase(), "Times-BoldItalic");
        this.trueTypeFonts.setProperty("ZapfDingbats".toLowerCase(), "ZapfDingbats");
        ArrayList arrayList = new ArrayList();
        arrayList.add("Courier");
        arrayList.add("Courier-Bold");
        arrayList.add("Courier-Oblique");
        arrayList.add("Courier-BoldOblique");
        this.fontFamilies.put("Courier".toLowerCase(), arrayList);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add("Helvetica");
        arrayList2.add("Helvetica-Bold");
        arrayList2.add("Helvetica-Oblique");
        arrayList2.add("Helvetica-BoldOblique");
        this.fontFamilies.put("Helvetica".toLowerCase(), arrayList2);
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add("Symbol");
        this.fontFamilies.put("Symbol".toLowerCase(), arrayList3);
        ArrayList arrayList4 = new ArrayList();
        arrayList4.add("Times-Roman");
        arrayList4.add("Times-Bold");
        arrayList4.add("Times-Italic");
        arrayList4.add("Times-BoldItalic");
        this.fontFamilies.put(FontFactory.TIMES.toLowerCase(), arrayList4);
        this.fontFamilies.put("Times-Roman".toLowerCase(), arrayList4);
        ArrayList arrayList5 = new ArrayList();
        arrayList5.add("ZapfDingbats");
        this.fontFamilies.put("ZapfDingbats".toLowerCase(), arrayList5);
    }

    public Font getFont(String str, String str2, boolean z, float f, int i, Color color) {
        return getFont(str, str2, z, f, i, color, true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00ae, code lost:
        return new com.lowagie.text.Font(-1, r0, r2, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00b4, code lost:
        return new com.lowagie.text.Font(-1, r0, r2, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00b5, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00bb, code lost:
        throw new com.lowagie.text.ExceptionConverter(r0);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:44:? A[ExcHandler: NullPointerException (unused java.lang.NullPointerException), SYNTHETIC, Splitter:B:33:0x0084] */
    /* JADX WARNING: Removed duplicated region for block: B:47:? A[ExcHandler: IOException (unused java.io.IOException), SYNTHETIC, Splitter:B:33:0x0084] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.lowagie.text.Font getFont(java.lang.String r15, java.lang.String r16, boolean r17, float r18, int r19, harmony.java.awt.Color r20, boolean r21) {
        /*
            r14 = this;
            r1 = r14
            r0 = r18
            r2 = r19
            r3 = r20
            r4 = -1
            if (r15 != 0) goto L_0x0010
            com.lowagie.text.Font r5 = new com.lowagie.text.Font
            r5.<init>((int) r4, (float) r0, (int) r2, (harmony.java.awt.Color) r3)
            return r5
        L_0x0010:
            java.lang.String r5 = r15.toLowerCase()
            java.util.Hashtable r6 = r1.fontFamilies
            java.lang.Object r5 = r6.get(r5)
            java.util.ArrayList r5 = (java.util.ArrayList) r5
            if (r5 == 0) goto L_0x0078
            r6 = 0
            if (r2 != r4) goto L_0x0023
            r7 = 0
            goto L_0x0024
        L_0x0023:
            r7 = r2
        L_0x0024:
            java.util.Iterator r5 = r5.iterator()
            r8 = 0
        L_0x0029:
            boolean r9 = r5.hasNext()
            r10 = 1
            if (r9 != 0) goto L_0x0033
            r5 = r15
            r10 = 0
            goto L_0x006f
        L_0x0033:
            java.lang.Object r8 = r5.next()
            java.lang.String r8 = (java.lang.String) r8
            java.lang.String r9 = r8.toLowerCase()
            java.lang.String r11 = r9.toLowerCase()
            java.lang.String r12 = "bold"
            int r11 = r11.indexOf(r12)
            if (r11 == r4) goto L_0x004b
            r11 = 1
            goto L_0x004c
        L_0x004b:
            r11 = 0
        L_0x004c:
            java.lang.String r12 = r9.toLowerCase()
            java.lang.String r13 = "italic"
            int r12 = r12.indexOf(r13)
            if (r12 != r4) goto L_0x0067
            java.lang.String r9 = r9.toLowerCase()
            java.lang.String r12 = "oblique"
            int r9 = r9.indexOf(r12)
            if (r9 == r4) goto L_0x0065
            goto L_0x0067
        L_0x0065:
            r9 = r11
            goto L_0x0069
        L_0x0067:
            r9 = r11 | 2
        L_0x0069:
            r11 = r7 & 3
            if (r11 != r9) goto L_0x0076
            r5 = r8
            r8 = r9
        L_0x006f:
            if (r2 == r4) goto L_0x0079
            if (r10 == 0) goto L_0x0079
            int r6 = ~r8
            r2 = r2 & r6
            goto L_0x0079
        L_0x0076:
            r8 = r9
            goto L_0x0029
        L_0x0078:
            r5 = r15
        L_0x0079:
            r13 = 0
            r10 = 0
            r11 = 0
            r12 = 1
            r6 = r5
            r7 = r16
            r8 = r17
            r9 = r21
            com.lowagie.text.pdf.BaseFont r13 = com.lowagie.text.pdf.BaseFont.createFont(r6, r7, r8, r9, r10, r11, r12)     // Catch:{ DocumentException -> 0x0088, IOException -> 0x00af, NullPointerException -> 0x00a9 }
        L_0x0088:
            if (r13 != 0) goto L_0x00bc
            java.util.Properties r6 = r1.trueTypeFonts     // Catch:{ DocumentException -> 0x00b5, IOException -> 0x00af, NullPointerException -> 0x00a9 }
            java.lang.String r5 = r5.toLowerCase()     // Catch:{ DocumentException -> 0x00b5, IOException -> 0x00af, NullPointerException -> 0x00a9 }
            java.lang.String r7 = r6.getProperty(r5)     // Catch:{ DocumentException -> 0x00b5, IOException -> 0x00af, NullPointerException -> 0x00a9 }
            if (r7 != 0) goto L_0x009c
            com.lowagie.text.Font r5 = new com.lowagie.text.Font     // Catch:{ DocumentException -> 0x00b5, IOException -> 0x00af, NullPointerException -> 0x00a9 }
            r5.<init>((int) r4, (float) r0, (int) r2, (harmony.java.awt.Color) r3)     // Catch:{ DocumentException -> 0x00b5, IOException -> 0x00af, NullPointerException -> 0x00a9 }
            return r5
        L_0x009c:
            r11 = 0
            r12 = 0
            r8 = r16
            r9 = r17
            r10 = r21
            com.lowagie.text.pdf.BaseFont r13 = com.lowagie.text.pdf.BaseFont.createFont(r7, r8, r9, r10, r11, r12)     // Catch:{ DocumentException -> 0x00b5, IOException -> 0x00af, NullPointerException -> 0x00a9 }
            goto L_0x00bc
        L_0x00a9:
            com.lowagie.text.Font r5 = new com.lowagie.text.Font
            r5.<init>((int) r4, (float) r0, (int) r2, (harmony.java.awt.Color) r3)
            return r5
        L_0x00af:
            com.lowagie.text.Font r5 = new com.lowagie.text.Font
            r5.<init>((int) r4, (float) r0, (int) r2, (harmony.java.awt.Color) r3)
            return r5
        L_0x00b5:
            r0 = move-exception
            com.lowagie.text.ExceptionConverter r2 = new com.lowagie.text.ExceptionConverter
            r2.<init>(r0)
            throw r2
        L_0x00bc:
            com.lowagie.text.Font r4 = new com.lowagie.text.Font
            r4.<init>((com.lowagie.text.pdf.BaseFont) r13, (float) r0, (int) r2, (harmony.java.awt.Color) r3)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.FontFactoryImp.getFont(java.lang.String, java.lang.String, boolean, float, int, harmony.java.awt.Color, boolean):com.lowagie.text.Font");
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0149  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.lowagie.text.Font getFont(java.util.Properties r17) {
        /*
            r16 = this;
            r7 = r16
            r0 = r17
            java.lang.String r1 = r7.defaultEncoding
            boolean r2 = r7.defaultEmbedding
            java.lang.String r3 = "style"
            java.lang.String r4 = r0.getProperty(r3)
            java.lang.String r5 = "color"
            r6 = 1
            r8 = 0
            r9 = 0
            r10 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r4 == 0) goto L_0x00ab
            int r11 = r4.length()
            if (r11 <= 0) goto L_0x00ab
            java.util.Properties r11 = com.lowagie.text.html.Markup.parseAttributes(r4)
            boolean r12 = r11.isEmpty()
            if (r12 == 0) goto L_0x002c
            r0.put(r3, r4)
            goto L_0x00ab
        L_0x002c:
            java.lang.String r4 = "font-family"
            java.lang.String r4 = r11.getProperty(r4)
            if (r4 == 0) goto L_0x0058
        L_0x0034:
            r12 = 44
            int r13 = r4.indexOf(r12)
            r14 = -1
            if (r13 != r14) goto L_0x003e
            goto L_0x0058
        L_0x003e:
            int r13 = r4.indexOf(r12)
            java.lang.String r13 = r4.substring(r9, r13)
            boolean r14 = r7.isRegistered(r13)
            if (r14 == 0) goto L_0x004e
            r4 = r13
            goto L_0x0034
        L_0x004e:
            int r12 = r4.indexOf(r12)
            int r12 = r12 + r6
            java.lang.String r4 = r4.substring(r12)
            goto L_0x0034
        L_0x0058:
            java.lang.String r12 = "font-size"
            java.lang.String r12 = r11.getProperty(r12)
            if (r12 == 0) goto L_0x0066
            float r10 = com.lowagie.text.html.Markup.parseLength(r12)
            r12 = r10
            goto L_0x0068
        L_0x0066:
            r12 = -1082130432(0xffffffffbf800000, float:-1.0)
        L_0x0068:
            java.lang.String r10 = "font-weight"
            java.lang.String r10 = r11.getProperty(r10)
            if (r10 == 0) goto L_0x0076
            int r10 = com.lowagie.text.Font.getStyleValue(r10)
            r10 = r10 | r9
            goto L_0x0077
        L_0x0076:
            r10 = 0
        L_0x0077:
            java.lang.String r13 = "font-style"
            java.lang.String r13 = r11.getProperty(r13)
            if (r13 == 0) goto L_0x0084
            int r13 = com.lowagie.text.Font.getStyleValue(r13)
            r10 = r10 | r13
        L_0x0084:
            r13 = r10
            java.lang.String r10 = r11.getProperty(r5)
            if (r10 == 0) goto L_0x008f
            harmony.java.awt.Color r8 = com.lowagie.text.html.Markup.decodeColor(r10)
        L_0x008f:
            r14 = r8
            r0.putAll(r11)
            java.util.Enumeration r15 = r11.keys()
        L_0x0097:
            boolean r8 = r15.hasMoreElements()
            if (r8 != 0) goto L_0x009f
            r10 = r12
            goto L_0x00ae
        L_0x009f:
            java.lang.Object r8 = r15.nextElement()
            java.lang.Object r10 = r11.get(r8)
            r0.put(r8, r10)
            goto L_0x0097
        L_0x00ab:
            r4 = r8
            r14 = r4
            r13 = 0
        L_0x00ae:
            java.lang.String r8 = "encoding"
            java.lang.String r8 = r0.getProperty(r8)
            if (r8 == 0) goto L_0x00b7
            goto L_0x00b8
        L_0x00b7:
            r8 = r1
        L_0x00b8:
            java.lang.String r1 = "embedded"
            java.lang.String r1 = r0.getProperty(r1)
            java.lang.String r11 = "true"
            boolean r1 = r11.equals(r1)
            if (r1 == 0) goto L_0x00c7
            goto L_0x00c8
        L_0x00c7:
            r6 = r2
        L_0x00c8:
            java.lang.String r1 = "font"
            java.lang.String r1 = r0.getProperty(r1)
            if (r1 == 0) goto L_0x00d1
            goto L_0x00d2
        L_0x00d1:
            r1 = r4
        L_0x00d2:
            java.lang.String r2 = "size"
            java.lang.String r2 = r0.getProperty(r2)
            if (r2 == 0) goto L_0x00e0
            float r2 = com.lowagie.text.html.Markup.parseLength(r2)
            r4 = r2
            goto L_0x00e1
        L_0x00e0:
            r4 = r10
        L_0x00e1:
            java.lang.String r2 = r0.getProperty(r3)
            if (r2 == 0) goto L_0x00ec
            int r2 = com.lowagie.text.Font.getStyleValue(r2)
            r13 = r13 | r2
        L_0x00ec:
            java.lang.String r2 = "fontstyle"
            java.lang.String r2 = r0.getProperty(r2)
            if (r2 == 0) goto L_0x00fa
            int r2 = com.lowagie.text.Font.getStyleValue(r2)
            r2 = r2 | r13
            r13 = r2
        L_0x00fa:
            java.lang.String r2 = "red"
            java.lang.String r2 = r0.getProperty(r2)
            java.lang.String r3 = "green"
            java.lang.String r3 = r0.getProperty(r3)
            java.lang.String r10 = "blue"
            java.lang.String r10 = r0.getProperty(r10)
            if (r2 != 0) goto L_0x011f
            if (r3 != 0) goto L_0x011f
            if (r10 == 0) goto L_0x0113
            goto L_0x011f
        L_0x0113:
            java.lang.String r0 = r0.getProperty(r5)
            if (r0 == 0) goto L_0x013b
            harmony.java.awt.Color r0 = com.lowagie.text.html.Markup.decodeColor(r0)
            r14 = r0
            goto L_0x013b
        L_0x011f:
            if (r2 == 0) goto L_0x0126
            int r0 = java.lang.Integer.parseInt(r2)
            goto L_0x0127
        L_0x0126:
            r0 = 0
        L_0x0127:
            if (r3 == 0) goto L_0x012e
            int r2 = java.lang.Integer.parseInt(r3)
            goto L_0x012f
        L_0x012e:
            r2 = 0
        L_0x012f:
            if (r10 == 0) goto L_0x0135
            int r9 = java.lang.Integer.parseInt(r10)
        L_0x0135:
            harmony.java.awt.Color r3 = new harmony.java.awt.Color
            r3.<init>((int) r0, (int) r2, (int) r9)
            r14 = r3
        L_0x013b:
            if (r1 != 0) goto L_0x0149
            r1 = 0
            r0 = r16
            r2 = r8
            r3 = r6
            r5 = r13
            r6 = r14
            com.lowagie.text.Font r0 = r0.getFont(r1, r2, r3, r4, r5, r6)
            return r0
        L_0x0149:
            r0 = r16
            r2 = r8
            r3 = r6
            r5 = r13
            r6 = r14
            com.lowagie.text.Font r0 = r0.getFont(r1, r2, r3, r4, r5, r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.FontFactoryImp.getFont(java.util.Properties):com.lowagie.text.Font");
    }

    public Font getFont(String str, String str2, boolean z, float f, int i) {
        return getFont(str, str2, z, f, i, (Color) null);
    }

    public Font getFont(String str, String str2, boolean z, float f) {
        return getFont(str, str2, z, f, -1, (Color) null);
    }

    public Font getFont(String str, String str2, boolean z) {
        return getFont(str, str2, z, -1.0f, -1, (Color) null);
    }

    public Font getFont(String str, String str2, float f, int i, Color color) {
        return getFont(str, str2, this.defaultEmbedding, f, i, color);
    }

    public Font getFont(String str, String str2, float f, int i) {
        return getFont(str, str2, this.defaultEmbedding, f, i, (Color) null);
    }

    public Font getFont(String str, String str2, float f) {
        return getFont(str, str2, this.defaultEmbedding, f, -1, (Color) null);
    }

    public Font getFont(String str, float f, Color color) {
        return getFont(str, this.defaultEncoding, this.defaultEmbedding, f, -1, color);
    }

    public Font getFont(String str, String str2) {
        return getFont(str, str2, this.defaultEmbedding, -1.0f, -1, (Color) null);
    }

    public Font getFont(String str, float f, int i, Color color) {
        return getFont(str, this.defaultEncoding, this.defaultEmbedding, f, i, color);
    }

    public Font getFont(String str, float f, int i) {
        return getFont(str, this.defaultEncoding, this.defaultEmbedding, f, i, (Color) null);
    }

    public Font getFont(String str, float f) {
        return getFont(str, this.defaultEncoding, this.defaultEmbedding, f, -1, (Color) null);
    }

    public Font getFont(String str) {
        return getFont(str, this.defaultEncoding, this.defaultEmbedding, -1.0f, -1, (Color) null);
    }

    public void registerFamily(String str, String str2, String str3) {
        if (str3 != null) {
            this.trueTypeFonts.setProperty(str2, str3);
        }
        ArrayList arrayList = (ArrayList) this.fontFamilies.get(str);
        if (arrayList == null) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(str2);
            this.fontFamilies.put(str, arrayList2);
            return;
        }
        int length = str2.length();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= arrayList.size()) {
                break;
            } else if (((String) arrayList.get(i)).length() >= length) {
                arrayList.add(i, str2);
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (!z) {
            arrayList.add(str2);
        }
    }

    public void register(String str) {
        register(str, (String) null);
    }

    public void register(String str, String str2) {
        try {
            if (!str.toLowerCase().endsWith(".ttf")) {
                if (!str.toLowerCase().endsWith(".otf")) {
                    if (str.toLowerCase().indexOf(".ttc,") <= 0) {
                        if (str.toLowerCase().endsWith(".ttc")) {
                            if (str2 != null) {
                                System.err.println("class FontFactory: You can't define an alias for a true type collection.");
                            }
                            String[] enumerateTTCNames = BaseFont.enumerateTTCNames(str);
                            for (int i = 0; i < enumerateTTCNames.length; i++) {
                                register(String.valueOf(str) + "," + i);
                            }
                            return;
                        } else if (str.toLowerCase().endsWith(".afm") || str.toLowerCase().endsWith(".pfm")) {
                            BaseFont createFont = BaseFont.createFont(str, "Cp1252", false);
                            String lowerCase = createFont.getFullFontName()[0][3].toLowerCase();
                            String lowerCase2 = createFont.getFamilyFontName()[0][3].toLowerCase();
                            String lowerCase3 = createFont.getPostscriptFontName().toLowerCase();
                            registerFamily(lowerCase2, lowerCase, (String) null);
                            this.trueTypeFonts.setProperty(lowerCase3, str);
                            this.trueTypeFonts.setProperty(lowerCase, str);
                            return;
                        } else {
                            return;
                        }
                    }
                }
            }
            Object[] allFontNames = BaseFont.getAllFontNames(str, "Cp1252", (byte[]) null);
            this.trueTypeFonts.setProperty(((String) allFontNames[0]).toLowerCase(), str);
            if (str2 != null) {
                this.trueTypeFonts.setProperty(str2.toLowerCase(), str);
            }
            String[][] strArr = (String[][]) allFontNames[2];
            for (String[] strArr2 : strArr) {
                this.trueTypeFonts.setProperty(strArr2[3].toLowerCase(), str);
            }
            String[][] strArr3 = (String[][]) allFontNames[1];
            String str3 = null;
            int i2 = 0;
            while (i2 < TTFamilyOrder.length) {
                int i3 = 0;
                while (true) {
                    if (i3 < strArr3.length) {
                        if (TTFamilyOrder[i2].equals(strArr3[i3][0]) && TTFamilyOrder[i2 + 1].equals(strArr3[i3][1]) && TTFamilyOrder[i2 + 2].equals(strArr3[i3][2])) {
                            str3 = strArr3[i3][3].toLowerCase();
                            i2 = TTFamilyOrder.length;
                            break;
                        }
                        i3++;
                    } else {
                        break;
                    }
                }
                i2 += 3;
            }
            if (str3 != null) {
                String[][] strArr4 = (String[][]) allFontNames[2];
                String str4 = "";
                for (int i4 = 0; i4 < strArr4.length; i4++) {
                    int i5 = 0;
                    while (true) {
                        if (i5 >= TTFamilyOrder.length) {
                            break;
                        }
                        if (TTFamilyOrder[i5].equals(strArr4[i4][0]) && TTFamilyOrder[i5 + 1].equals(strArr4[i4][1]) && TTFamilyOrder[i5 + 2].equals(strArr4[i4][2])) {
                            String str5 = strArr4[i4][3];
                            if (!str5.equals(str4)) {
                                registerFamily(str3, str5, (String) null);
                                str4 = str5;
                                break;
                            }
                        }
                        i5 += 3;
                    }
                }
            }
        } catch (DocumentException e) {
            throw new ExceptionConverter(e);
        } catch (IOException e2) {
            throw new ExceptionConverter(e2);
        }
    }

    public int registerDirectory(String str) {
        return registerDirectory(str, false);
    }

    public int registerDirectory(String str, boolean z) {
        try {
            File file = new File(str);
            if (file.exists()) {
                if (file.isDirectory()) {
                    String[] list = file.list();
                    if (list == null) {
                        return 0;
                    }
                    int i = 0;
                    int i2 = 0;
                    while (i < list.length) {
                        try {
                            try {
                                File file2 = new File(str, list[i]);
                                if (!file2.isDirectory()) {
                                    String path = file2.getPath();
                                    String lowerCase = path.length() < 4 ? null : path.substring(path.length() - 4).toLowerCase();
                                    if (!".afm".equals(lowerCase)) {
                                        if (!".pfm".equals(lowerCase)) {
                                            if (".ttf".equals(lowerCase) || ".otf".equals(lowerCase) || ".ttc".equals(lowerCase)) {
                                                register(path, (String) null);
                                                i2++;
                                            }
                                        }
                                    }
                                    if (new File(String.valueOf(path.substring(0, path.length() - 4)) + ".pfb").exists()) {
                                        register(path, (String) null);
                                        i2++;
                                    }
                                } else if (z) {
                                    i2 += registerDirectory(file2.getAbsolutePath(), true);
                                }
                            } catch (Exception unused) {
                            }
                            i++;
                        } catch (Exception unused2) {
                            return i2;
                        }
                    }
                    return i2;
                }
            }
            return 0;
        } catch (Exception unused3) {
            return 0;
        }
    }

    public int registerDirectories() {
        return registerDirectory("c:/windows/fonts") + 0 + registerDirectory("c:/winnt/fonts") + registerDirectory("d:/windows/fonts") + registerDirectory("d:/winnt/fonts") + registerDirectory("/usr/share/X11/fonts", true) + registerDirectory("/usr/X/lib/X11/fonts", true) + registerDirectory("/usr/openwin/lib/X11/fonts", true) + registerDirectory("/usr/share/fonts", true) + registerDirectory("/usr/X11R6/lib/X11/fonts", true) + registerDirectory("/Library/Fonts") + registerDirectory("/System/Library/Fonts");
    }

    public Set getRegisteredFonts() {
        return Utilities.getKeySet(this.trueTypeFonts);
    }

    public Set getRegisteredFamilies() {
        return Utilities.getKeySet(this.fontFamilies);
    }

    public boolean isRegistered(String str) {
        return this.trueTypeFonts.containsKey(str.toLowerCase());
    }
}
