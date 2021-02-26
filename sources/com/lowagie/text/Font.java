package com.lowagie.text;

import com.lowagie.text.html.Markup;
import com.lowagie.text.pdf.BaseFont;
import harmony.java.awt.Color;

public class Font implements Comparable {
    public static final int BOLD = 1;
    public static final int BOLDITALIC = 3;
    public static final int COURIER = 0;
    public static final int DEFAULTSIZE = 12;
    public static final int HELVETICA = 1;
    public static final int ITALIC = 2;
    public static final int NORMAL = 0;
    public static final int STRIKETHRU = 8;
    public static final int SYMBOL = 3;
    public static final int TIMES_ROMAN = 2;
    public static final int UNDEFINED = -1;
    public static final int UNDERLINE = 4;
    public static final int ZAPFDINGBATS = 4;
    private BaseFont baseFont;
    private Color color;
    private int family;
    private float size;
    private int style;

    public Font(Font font) {
        this.family = -1;
        this.size = -1.0f;
        this.style = -1;
        this.color = null;
        this.baseFont = null;
        this.family = font.family;
        this.size = font.size;
        this.style = font.style;
        this.color = font.color;
        this.baseFont = font.baseFont;
    }

    public Font(int i, float f, int i2, Color color2) {
        this.family = -1;
        this.size = -1.0f;
        this.style = -1;
        this.color = null;
        this.baseFont = null;
        this.family = i;
        this.size = f;
        this.style = i2;
        this.color = color2;
    }

    public Font(BaseFont baseFont2, float f, int i, Color color2) {
        this.family = -1;
        this.size = -1.0f;
        this.style = -1;
        this.color = null;
        this.baseFont = null;
        this.baseFont = baseFont2;
        this.size = f;
        this.style = i;
        this.color = color2;
    }

    public Font(BaseFont baseFont2, float f, int i) {
        this(baseFont2, f, i, (Color) null);
    }

    public Font(BaseFont baseFont2, float f) {
        this(baseFont2, f, -1, (Color) null);
    }

    public Font(BaseFont baseFont2) {
        this(baseFont2, -1.0f, -1, (Color) null);
    }

    public Font(int i, float f, int i2) {
        this(i, f, i2, (Color) null);
    }

    public Font(int i, float f) {
        this(i, f, -1, (Color) null);
    }

    public Font(int i) {
        this(i, -1.0f, -1, (Color) null);
    }

    public Font() {
        this(-1, -1.0f, -1, (Color) null);
    }

    public int compareTo(Object obj) {
        if (obj == null) {
            return -1;
        }
        try {
            Font font = (Font) obj;
            if (this.baseFont != null && !this.baseFont.equals(font.getBaseFont())) {
                return -2;
            }
            if (this.family != font.getFamily()) {
                return 1;
            }
            if (this.size != font.getSize()) {
                return 2;
            }
            if (this.style != font.getStyle()) {
                return 3;
            }
            return this.color == null ? font.color == null ? 0 : 4 : (font.color != null && this.color.equals(font.getColor())) ? 0 : 4;
        } catch (ClassCastException unused) {
            return -3;
        }
    }

    public int getFamily() {
        return this.family;
    }

    public String getFamilyname() {
        int family2 = getFamily();
        if (family2 == 0) {
            return "Courier";
        }
        if (family2 == 1) {
            return "Helvetica";
        }
        if (family2 == 2) {
            return "Times-Roman";
        }
        if (family2 == 3) {
            return "Symbol";
        }
        if (family2 == 4) {
            return "ZapfDingbats";
        }
        BaseFont baseFont2 = this.baseFont;
        String str = "unknown";
        if (baseFont2 != null) {
            String[][] familyFontName = baseFont2.getFamilyFontName();
            for (int i = 0; i < familyFontName.length; i++) {
                if ("0".equals(familyFontName[i][2])) {
                    return familyFontName[i][3];
                }
                if ("1033".equals(familyFontName[i][2])) {
                    str = familyFontName[i][3];
                }
                if ("".equals(familyFontName[i][2])) {
                    str = familyFontName[i][3];
                }
            }
        }
        return str;
    }

    public void setFamily(String str) {
        this.family = getFamilyIndex(str);
    }

    public static int getFamilyIndex(String str) {
        if (str.equalsIgnoreCase("Courier")) {
            return 0;
        }
        if (str.equalsIgnoreCase("Helvetica")) {
            return 1;
        }
        if (str.equalsIgnoreCase("Times-Roman")) {
            return 2;
        }
        if (str.equalsIgnoreCase("Symbol")) {
            return 3;
        }
        return str.equalsIgnoreCase("ZapfDingbats") ? 4 : -1;
    }

    public float getSize() {
        return this.size;
    }

    public float getCalculatedSize() {
        float f = this.size;
        if (f == -1.0f) {
            return 12.0f;
        }
        return f;
    }

    public float getCalculatedLeading(float f) {
        return f * getCalculatedSize();
    }

    public void setSize(float f) {
        this.size = f;
    }

    public int getStyle() {
        return this.style;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000b, code lost:
        r1 = r3.family;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getCalculatedStyle() {
        /*
            r3 = this;
            int r0 = r3.style
            r1 = -1
            if (r0 != r1) goto L_0x0006
            r0 = 0
        L_0x0006:
            com.lowagie.text.pdf.BaseFont r1 = r3.baseFont
            if (r1 == 0) goto L_0x000b
            return r0
        L_0x000b:
            int r1 = r3.family
            r2 = 3
            if (r1 == r2) goto L_0x0016
            r2 = 4
            if (r1 != r2) goto L_0x0014
            goto L_0x0016
        L_0x0014:
            r0 = r0 & -4
        L_0x0016:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.Font.getCalculatedStyle():int");
    }

    public boolean isBold() {
        int i = this.style;
        return i != -1 && (i & 1) == 1;
    }

    public boolean isItalic() {
        int i = this.style;
        return i != -1 && (i & 2) == 2;
    }

    public boolean isUnderlined() {
        int i = this.style;
        return i != -1 && (i & 4) == 4;
    }

    public boolean isStrikethru() {
        int i = this.style;
        return i != -1 && (i & 8) == 8;
    }

    public void setStyle(int i) {
        this.style = i;
    }

    public void setStyle(String str) {
        if (this.style == -1) {
            this.style = 0;
        }
        this.style = getStyleValue(str) | this.style;
    }

    public static int getStyleValue(String str) {
        int indexOf = str.indexOf(Markup.CSS_VALUE_NORMAL);
        int i = 0;
        if (str.indexOf("bold") != -1) {
            i = 1;
        }
        if (str.indexOf("italic") != -1) {
            i |= 2;
        }
        if (str.indexOf(Markup.CSS_VALUE_OBLIQUE) != -1) {
            i |= 2;
        }
        if (str.indexOf("underline") != -1) {
            i |= 4;
        }
        return str.indexOf(Markup.CSS_VALUE_LINETHROUGH) != -1 ? i | 8 : i;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color2) {
        this.color = color2;
    }

    public void setColor(int i, int i2, int i3) {
        this.color = new Color(i, i2, i3);
    }

    public BaseFont getBaseFont() {
        return this.baseFont;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0034, code lost:
        if (r10 != false) goto L_0x003a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.lowagie.text.pdf.BaseFont getCalculatedBaseFont(boolean r10) {
        /*
            r9 = this;
            com.lowagie.text.pdf.BaseFont r0 = r9.baseFont
            if (r0 == 0) goto L_0x0005
            return r0
        L_0x0005:
            int r0 = r9.style
            r1 = -1
            r2 = 0
            if (r0 != r1) goto L_0x000c
            r0 = 0
        L_0x000c:
            int r1 = r9.family
            java.lang.String r3 = "ZapfDingbats"
            java.lang.String r4 = "Symbol"
            r5 = 1
            r6 = 2
            r7 = 3
            java.lang.String r8 = "Cp1252"
            if (r1 == 0) goto L_0x0052
            if (r1 == r6) goto L_0x003e
            if (r1 == r7) goto L_0x0037
            r4 = 4
            if (r1 == r4) goto L_0x0034
            r10 = r0 & 3
            if (r10 == r5) goto L_0x0031
            if (r10 == r6) goto L_0x002e
            if (r10 == r7) goto L_0x002b
            java.lang.String r3 = "Helvetica"
            goto L_0x0065
        L_0x002b:
            java.lang.String r3 = "Helvetica-BoldOblique"
            goto L_0x0065
        L_0x002e:
            java.lang.String r3 = "Helvetica-Oblique"
            goto L_0x0065
        L_0x0031:
            java.lang.String r3 = "Helvetica-Bold"
            goto L_0x0065
        L_0x0034:
            if (r10 == 0) goto L_0x0065
            goto L_0x003a
        L_0x0037:
            if (r10 == 0) goto L_0x003c
            r3 = r4
        L_0x003a:
            r8 = r3
            goto L_0x0065
        L_0x003c:
            r3 = r4
            goto L_0x0065
        L_0x003e:
            r10 = r0 & 3
            if (r10 == r5) goto L_0x004f
            if (r10 == r6) goto L_0x004c
            if (r10 == r7) goto L_0x0049
            java.lang.String r3 = "Times-Roman"
            goto L_0x0065
        L_0x0049:
            java.lang.String r3 = "Times-BoldItalic"
            goto L_0x0065
        L_0x004c:
            java.lang.String r3 = "Times-Italic"
            goto L_0x0065
        L_0x004f:
            java.lang.String r3 = "Times-Bold"
            goto L_0x0065
        L_0x0052:
            r10 = r0 & 3
            if (r10 == r5) goto L_0x0063
            if (r10 == r6) goto L_0x0060
            if (r10 == r7) goto L_0x005d
            java.lang.String r3 = "Courier"
            goto L_0x0065
        L_0x005d:
            java.lang.String r3 = "Courier-BoldOblique"
            goto L_0x0065
        L_0x0060:
            java.lang.String r3 = "Courier-Oblique"
            goto L_0x0065
        L_0x0063:
            java.lang.String r3 = "Courier-Bold"
        L_0x0065:
            com.lowagie.text.pdf.BaseFont r10 = com.lowagie.text.pdf.BaseFont.createFont(r3, r8, r2)     // Catch:{ Exception -> 0x006a }
            return r10
        L_0x006a:
            r10 = move-exception
            com.lowagie.text.ExceptionConverter r0 = new com.lowagie.text.ExceptionConverter
            r0.<init>(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.Font.getCalculatedBaseFont(boolean):com.lowagie.text.pdf.BaseFont");
    }

    public boolean isStandardFont() {
        return this.family == -1 && this.size == -1.0f && this.style == -1 && this.color == null && this.baseFont == null;
    }

    public Font difference(Font font) {
        int i;
        if (font == null) {
            return this;
        }
        float f = font.size;
        if (f == -1.0f) {
            f = this.size;
        }
        int i2 = this.style;
        int style2 = font.getStyle();
        if (i2 == -1 && style2 == -1) {
            i = -1;
        } else {
            if (i2 == -1) {
                i2 = 0;
            }
            if (style2 == -1) {
                style2 = 0;
            }
            i = style2 | i2;
        }
        Color color2 = font.color;
        if (color2 == null) {
            color2 = this.color;
        }
        BaseFont baseFont2 = font.baseFont;
        if (baseFont2 != null) {
            return new Font(baseFont2, f, i, color2);
        }
        if (font.getFamily() != -1) {
            return new Font(font.family, f, i, color2);
        }
        BaseFont baseFont3 = this.baseFont;
        if (baseFont3 == null) {
            return new Font(this.family, f, i, color2);
        }
        if (i == i2) {
            return new Font(baseFont3, f, i, color2);
        }
        return FontFactory.getFont(getFamilyname(), f, i, color2);
    }
}
