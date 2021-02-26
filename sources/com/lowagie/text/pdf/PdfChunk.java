package com.lowagie.text.pdf;

import com.lowagie.text.Chunk;
import com.lowagie.text.Image;
import com.lowagie.text.SplitCharacter;
import com.lowagie.text.Utilities;
import harmony.java.awt.Color;
import java.util.HashMap;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

public class PdfChunk {
    private static final float ITALIC_ANGLE = 0.21256f;
    private static final HashMap keysAttributes = new HashMap();
    private static final HashMap keysNoStroke = new HashMap();
    private static final char[] singleSpace = {' '};
    private static final PdfChunk[] thisChunk = new PdfChunk[1];
    protected HashMap attributes = new HashMap();
    protected BaseFont baseFont;
    protected boolean changeLeading = false;
    protected String encoding = "Cp1252";
    protected PdfFont font;
    protected Image image;
    protected boolean newlineSplit;
    protected HashMap noStroke = new HashMap();
    protected float offsetX;
    protected float offsetY;
    protected SplitCharacter splitCharacter;
    protected String value = "";

    public static boolean noPrint(int i) {
        if (i < 8203 || i > 8207) {
            return i >= 8234 && i <= 8238;
        }
        return true;
    }

    static {
        keysAttributes.put(Chunk.ACTION, (Object) null);
        keysAttributes.put(Chunk.UNDERLINE, (Object) null);
        keysAttributes.put(Chunk.REMOTEGOTO, (Object) null);
        keysAttributes.put(Chunk.LOCALGOTO, (Object) null);
        keysAttributes.put(Chunk.LOCALDESTINATION, (Object) null);
        keysAttributes.put(Chunk.GENERICTAG, (Object) null);
        keysAttributes.put(Chunk.NEWPAGE, (Object) null);
        keysAttributes.put(Chunk.IMAGE, (Object) null);
        keysAttributes.put(Chunk.BACKGROUND, (Object) null);
        keysAttributes.put(Chunk.PDFANNOTATION, (Object) null);
        keysAttributes.put(Chunk.SKEW, (Object) null);
        keysAttributes.put(Chunk.HSCALE, (Object) null);
        keysAttributes.put(Chunk.SEPARATOR, (Object) null);
        keysAttributes.put(Chunk.TAB, (Object) null);
        keysNoStroke.put(Chunk.SUBSUPSCRIPT, (Object) null);
        keysNoStroke.put(Chunk.SPLITCHARACTER, (Object) null);
        keysNoStroke.put(Chunk.HYPHENATION, (Object) null);
        keysNoStroke.put(Chunk.TEXTRENDERMODE, (Object) null);
    }

    PdfChunk(String str, PdfChunk pdfChunk) {
        thisChunk[0] = this;
        this.value = str;
        this.font = pdfChunk.font;
        this.attributes = pdfChunk.attributes;
        this.noStroke = pdfChunk.noStroke;
        this.baseFont = pdfChunk.baseFont;
        Object[] objArr = (Object[]) this.attributes.get(Chunk.IMAGE);
        if (objArr == null) {
            this.image = null;
        } else {
            this.image = (Image) objArr[0];
            this.offsetX = ((Float) objArr[1]).floatValue();
            this.offsetY = ((Float) objArr[2]).floatValue();
            this.changeLeading = ((Boolean) objArr[3]).booleanValue();
        }
        this.encoding = this.font.getFont().getEncoding();
        this.splitCharacter = (SplitCharacter) this.noStroke.get(Chunk.SPLITCHARACTER);
        if (this.splitCharacter == null) {
            this.splitCharacter = DefaultSplitCharacter.DEFAULT;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v26, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v28, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    PdfChunk(com.lowagie.text.Chunk r13, com.lowagie.text.pdf.PdfAction r14) {
        /*
            r12 = this;
            r12.<init>()
            java.lang.String r0 = ""
            r12.value = r0
            java.lang.String r1 = "Cp1252"
            r12.encoding = r1
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            r12.attributes = r1
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            r12.noStroke = r1
            r1 = 0
            r12.changeLeading = r1
            com.lowagie.text.pdf.PdfChunk[] r2 = thisChunk
            r2[r1] = r12
            java.lang.String r2 = r13.getContent()
            r12.value = r2
            com.lowagie.text.Font r2 = r13.getFont()
            float r3 = r2.getSize()
            r4 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r4 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r4 != 0) goto L_0x0036
            r3 = 1094713344(0x41400000, float:12.0)
        L_0x0036:
            com.lowagie.text.pdf.BaseFont r4 = r2.getBaseFont()
            r12.baseFont = r4
            int r4 = r2.getStyle()
            r5 = -1
            if (r4 != r5) goto L_0x0044
            r4 = 0
        L_0x0044:
            com.lowagie.text.pdf.BaseFont r5 = r12.baseFont
            r6 = 3
            r7 = 1
            r8 = 2
            if (r5 != 0) goto L_0x0052
            com.lowagie.text.pdf.BaseFont r4 = r2.getCalculatedBaseFont(r1)
            r12.baseFont = r4
            goto L_0x0080
        L_0x0052:
            r5 = r4 & 1
            if (r5 == 0) goto L_0x0071
            java.util.HashMap r5 = r12.attributes
            java.lang.Object[] r9 = new java.lang.Object[r6]
            java.lang.Integer r10 = new java.lang.Integer
            r10.<init>(r8)
            r9[r1] = r10
            java.lang.Float r10 = new java.lang.Float
            r11 = 1106247680(0x41f00000, float:30.0)
            float r11 = r3 / r11
            r10.<init>(r11)
            r9[r7] = r10
            java.lang.String r10 = "TEXTRENDERMODE"
            r5.put(r10, r9)
        L_0x0071:
            r4 = r4 & r8
            if (r4 == 0) goto L_0x0080
            java.util.HashMap r4 = r12.attributes
            float[] r5 = new float[r8]
            r5 = {0, 1046063444} // fill-array
            java.lang.String r9 = "SKEW"
            r4.put(r9, r5)
        L_0x0080:
            com.lowagie.text.pdf.PdfFont r4 = new com.lowagie.text.pdf.PdfFont
            com.lowagie.text.pdf.BaseFont r5 = r12.baseFont
            r4.<init>(r5, r3)
            r12.font = r4
            java.util.HashMap r3 = r13.getAttributes()
            if (r3 == 0) goto L_0x00e1
            java.util.Set r4 = r3.entrySet()
            java.util.Iterator r4 = r4.iterator()
        L_0x0097:
            boolean r5 = r4.hasNext()
            if (r5 != 0) goto L_0x00b3
            java.lang.String r4 = "GENERICTAG"
            java.lang.Object r3 = r3.get(r4)
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x00e1
            java.util.HashMap r0 = r12.attributes
            java.lang.String r13 = r13.getContent()
            r0.put(r4, r13)
            goto L_0x00e1
        L_0x00b3:
            java.lang.Object r5 = r4.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            java.lang.Object r9 = r5.getKey()
            java.util.HashMap r10 = keysAttributes
            boolean r10 = r10.containsKey(r9)
            if (r10 == 0) goto L_0x00cf
            java.util.HashMap r10 = r12.attributes
            java.lang.Object r5 = r5.getValue()
            r10.put(r9, r5)
            goto L_0x0097
        L_0x00cf:
            java.util.HashMap r10 = keysNoStroke
            boolean r10 = r10.containsKey(r9)
            if (r10 == 0) goto L_0x0097
            java.util.HashMap r10 = r12.noStroke
            java.lang.Object r5 = r5.getValue()
            r10.put(r9, r5)
            goto L_0x0097
        L_0x00e1:
            boolean r13 = r2.isUnderlined()
            r0 = 5
            java.lang.String r3 = "UNDERLINE"
            if (r13 == 0) goto L_0x0104
            java.lang.Object[] r13 = new java.lang.Object[r8]
            float[] r4 = new float[r0]
            r4 = {0, 1032358025, 0, -1096111445, 0} // fill-array
            r13[r7] = r4
            java.util.HashMap r4 = r12.attributes
            java.lang.Object r4 = r4.get(r3)
            java.lang.Object[][] r4 = (java.lang.Object[][]) r4
            java.lang.Object[][] r13 = com.lowagie.text.Utilities.addToArray(r4, r13)
            java.util.HashMap r4 = r12.attributes
            r4.put(r3, r13)
        L_0x0104:
            boolean r13 = r2.isStrikethru()
            if (r13 == 0) goto L_0x0124
            java.lang.Object[] r13 = new java.lang.Object[r8]
            float[] r0 = new float[r0]
            r0 = {0, 1032358025, 0, 1051372203, 0} // fill-array
            r13[r7] = r0
            java.util.HashMap r0 = r12.attributes
            java.lang.Object r0 = r0.get(r3)
            java.lang.Object[][] r0 = (java.lang.Object[][]) r0
            java.lang.Object[][] r13 = com.lowagie.text.Utilities.addToArray(r0, r13)
            java.util.HashMap r0 = r12.attributes
            r0.put(r3, r13)
        L_0x0124:
            if (r14 == 0) goto L_0x012d
            java.util.HashMap r13 = r12.attributes
            java.lang.String r0 = "ACTION"
            r13.put(r0, r14)
        L_0x012d:
            java.util.HashMap r13 = r12.noStroke
            harmony.java.awt.Color r14 = r2.getColor()
            java.lang.String r0 = "COLOR"
            r13.put(r0, r14)
            java.util.HashMap r13 = r12.noStroke
            com.lowagie.text.pdf.PdfFont r14 = r12.font
            com.lowagie.text.pdf.BaseFont r14 = r14.getFont()
            java.lang.String r14 = r14.getEncoding()
            java.lang.String r0 = "ENCODING"
            r13.put(r0, r14)
            java.util.HashMap r13 = r12.attributes
            java.lang.String r14 = "IMAGE"
            java.lang.Object r13 = r13.get(r14)
            java.lang.Object[] r13 = (java.lang.Object[]) r13
            java.lang.String r14 = "HSCALE"
            if (r13 != 0) goto L_0x015b
            r13 = 0
            r12.image = r13
            goto L_0x0184
        L_0x015b:
            java.util.HashMap r0 = r12.attributes
            r0.remove(r14)
            r0 = r13[r1]
            com.lowagie.text.Image r0 = (com.lowagie.text.Image) r0
            r12.image = r0
            r0 = r13[r7]
            java.lang.Float r0 = (java.lang.Float) r0
            float r0 = r0.floatValue()
            r12.offsetX = r0
            r0 = r13[r8]
            java.lang.Float r0 = (java.lang.Float) r0
            float r0 = r0.floatValue()
            r12.offsetY = r0
            r13 = r13[r6]
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            r12.changeLeading = r13
        L_0x0184:
            com.lowagie.text.pdf.PdfFont r13 = r12.font
            com.lowagie.text.Image r0 = r12.image
            r13.setImage(r0)
            java.util.HashMap r13 = r12.attributes
            java.lang.Object r13 = r13.get(r14)
            java.lang.Float r13 = (java.lang.Float) r13
            if (r13 == 0) goto L_0x019e
            com.lowagie.text.pdf.PdfFont r14 = r12.font
            float r13 = r13.floatValue()
            r14.setHorizontalScaling(r13)
        L_0x019e:
            com.lowagie.text.pdf.PdfFont r13 = r12.font
            com.lowagie.text.pdf.BaseFont r13 = r13.getFont()
            java.lang.String r13 = r13.getEncoding()
            r12.encoding = r13
            java.util.HashMap r13 = r12.noStroke
            java.lang.String r14 = "SPLITCHARACTER"
            java.lang.Object r13 = r13.get(r14)
            com.lowagie.text.SplitCharacter r13 = (com.lowagie.text.SplitCharacter) r13
            r12.splitCharacter = r13
            com.lowagie.text.SplitCharacter r13 = r12.splitCharacter
            if (r13 != 0) goto L_0x01be
            com.lowagie.text.SplitCharacter r13 = com.lowagie.text.pdf.DefaultSplitCharacter.DEFAULT
            r12.splitCharacter = r13
        L_0x01be:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.PdfChunk.<init>(com.lowagie.text.Chunk, com.lowagie.text.pdf.PdfAction):void");
    }

    public int getUnicodeEquivalent(int i) {
        return this.baseFont.getUnicodeEquivalent(i);
    }

    /* access modifiers changed from: protected */
    public int getWord(String str, int i) {
        int length = str.length();
        while (i < length && Character.isLetter(str.charAt(i))) {
            i++;
        }
        return i;
    }

    /* JADX WARNING: type inference failed for: r10v0 */
    /* JADX WARNING: type inference failed for: r10v4, types: [boolean] */
    /* JADX WARNING: type inference failed for: r10v7 */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x01ed, code lost:
        r2 = r4 + 1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0124 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0127  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.lowagie.text.pdf.PdfChunk split(float r25) {
        /*
            r24 = this;
            r0 = r24
            r1 = 0
            r0.newlineSplit = r1
            com.lowagie.text.Image r2 = r0.image
            java.lang.String r3 = ""
            r4 = 0
            if (r2 == 0) goto L_0x002f
            float r1 = r2.getScaledWidth()
            int r1 = (r1 > r25 ? 1 : (r1 == r25 ? 0 : -1))
            if (r1 <= 0) goto L_0x002e
            com.lowagie.text.pdf.PdfChunk r1 = new com.lowagie.text.pdf.PdfChunk
            java.lang.String r2 = "￼"
            r1.<init>((java.lang.String) r2, (com.lowagie.text.pdf.PdfChunk) r0)
            r0.value = r3
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            r0.attributes = r2
            r0.image = r4
            com.lowagie.text.pdf.PdfFont r2 = com.lowagie.text.pdf.PdfFont.getDefaultFont()
            r0.font = r2
            return r1
        L_0x002e:
            return r4
        L_0x002f:
            java.util.HashMap r2 = r0.noStroke
            java.lang.String r5 = "HYPHENATION"
            java.lang.Object r2 = r2.get(r5)
            com.lowagie.text.pdf.HyphenationEvent r2 = (com.lowagie.text.pdf.HyphenationEvent) r2
            java.lang.String r5 = r0.value
            int r5 = r5.length()
            java.lang.String r6 = r0.value
            char[] r12 = r6.toCharArray()
            com.lowagie.text.pdf.PdfFont r6 = r0.font
            com.lowagie.text.pdf.BaseFont r13 = r6.getFont()
            int r6 = r13.getFontType()
            r14 = 2
            r7 = 0
            r8 = -1
            r15 = 10
            r11 = 32
            r10 = 1
            if (r6 != r14) goto L_0x00d4
            int r6 = r13.getUnicodeEquivalent(r11)
            if (r6 == r11) goto L_0x00d4
            r6 = 0
            r14 = 0
            r16 = -1
        L_0x0063:
            if (r14 < r5) goto L_0x0067
            goto L_0x00dd
        L_0x0067:
            char r9 = r12[r14]
            int r4 = r13.getUnicodeEquivalent(r9)
            char r4 = (char) r4
            if (r4 != r15) goto L_0x0094
            r0.newlineSplit = r10
            java.lang.String r2 = r0.value
            int r3 = r14 + 1
            java.lang.String r2 = r2.substring(r3)
            java.lang.String r3 = r0.value
            java.lang.String r1 = r3.substring(r1, r14)
            r0.value = r1
            java.lang.String r1 = r0.value
            int r1 = r1.length()
            if (r1 >= r10) goto L_0x008e
            java.lang.String r1 = "\u0001"
            r0.value = r1
        L_0x008e:
            com.lowagie.text.pdf.PdfChunk r1 = new com.lowagie.text.pdf.PdfChunk
            r1.<init>((java.lang.String) r2, (com.lowagie.text.pdf.PdfChunk) r0)
            return r1
        L_0x0094:
            com.lowagie.text.pdf.PdfFont r10 = r0.font
            float r9 = r10.width((int) r9)
            float r18 = r7 + r9
            if (r4 != r11) goto L_0x00a3
            int r4 = r14 + 1
            r19 = r18
            goto L_0x00a6
        L_0x00a3:
            r19 = r6
            r4 = r8
        L_0x00a6:
            int r6 = (r18 > r25 ? 1 : (r18 == r25 ? 0 : -1))
            if (r6 <= 0) goto L_0x00b1
            r8 = r4
            r1 = r16
            r6 = r19
            goto L_0x0122
        L_0x00b1:
            com.lowagie.text.SplitCharacter r6 = r0.splitCharacter
            r7 = 0
            com.lowagie.text.pdf.PdfChunk[] r20 = thisChunk
            r8 = r14
            r9 = r5
            r10 = r12
            r1 = 32
            r11 = r20
            boolean r6 = r6.isSplitCharacter(r7, r8, r9, r10, r11)
            if (r6 == 0) goto L_0x00c7
            int r6 = r14 + 1
            r16 = r6
        L_0x00c7:
            int r14 = r14 + 1
            r8 = r4
            r7 = r18
            r6 = r19
            r1 = 0
            r4 = 0
            r10 = 1
            r11 = 32
            goto L_0x0063
        L_0x00d4:
            r1 = 32
            r4 = 0
            r6 = 0
            r16 = -1
        L_0x00da:
            if (r4 < r5) goto L_0x00e0
            r14 = r4
        L_0x00dd:
            r1 = r16
            goto L_0x0122
        L_0x00e0:
            char r9 = r12[r4]
            r10 = 13
            if (r9 == r10) goto L_0x01e8
            if (r9 != r15) goto L_0x00ea
            goto L_0x01e8
        L_0x00ea:
            boolean r10 = com.lowagie.text.Utilities.isSurrogatePair((char[]) r12, (int) r4)
            if (r10 == 0) goto L_0x0101
            com.lowagie.text.pdf.PdfFont r11 = r0.font
            char r13 = r12[r4]
            int r18 = r4 + 1
            char r14 = r12[r18]
            int r13 = com.lowagie.text.Utilities.convertToUtf32((char) r13, (char) r14)
            float r11 = r11.width((int) r13)
            goto L_0x0107
        L_0x0101:
            com.lowagie.text.pdf.PdfFont r11 = r0.font
            float r11 = r11.width((int) r9)
        L_0x0107:
            float r7 = r7 + r11
            r13 = r7
            if (r9 != r1) goto L_0x0111
            int r6 = r4 + 1
            r14 = r6
            r18 = r13
            goto L_0x0114
        L_0x0111:
            r18 = r6
            r14 = r8
        L_0x0114:
            if (r10 == 0) goto L_0x0118
            int r4 = r4 + 1
        L_0x0118:
            int r6 = (r13 > r25 ? 1 : (r13 == r25 ? 0 : -1))
            if (r6 <= 0) goto L_0x01cc
            r8 = r14
            r1 = r16
            r6 = r18
            r14 = r4
        L_0x0122:
            if (r14 != r5) goto L_0x0127
            r17 = 0
            return r17
        L_0x0127:
            if (r1 >= 0) goto L_0x0133
            java.lang.String r1 = r0.value
            r0.value = r3
            com.lowagie.text.pdf.PdfChunk r2 = new com.lowagie.text.pdf.PdfChunk
            r2.<init>((java.lang.String) r1, (com.lowagie.text.pdf.PdfChunk) r0)
            return r2
        L_0x0133:
            if (r8 <= r1) goto L_0x014a
            com.lowagie.text.SplitCharacter r3 = r0.splitCharacter
            r19 = 0
            r20 = 0
            r21 = 1
            char[] r22 = singleSpace
            r23 = 0
            r18 = r3
            boolean r3 = r18.isSplitCharacter(r19, r20, r21, r22, r23)
            if (r3 == 0) goto L_0x014a
            r1 = r8
        L_0x014a:
            if (r2 == 0) goto L_0x01b3
            if (r8 < 0) goto L_0x01b3
            if (r8 >= r14) goto L_0x01b3
            java.lang.String r3 = r0.value
            int r3 = r0.getWord(r3, r8)
            if (r3 <= r8) goto L_0x01b3
            java.lang.String r4 = r0.value
            java.lang.String r4 = r4.substring(r8, r3)
            com.lowagie.text.pdf.PdfFont r5 = r0.font
            com.lowagie.text.pdf.BaseFont r5 = r5.getFont()
            com.lowagie.text.pdf.PdfFont r7 = r0.font
            float r7 = r7.size()
            float r6 = r25 - r6
            java.lang.String r4 = r2.getHyphenatedWordPre(r4, r5, r7, r6)
            java.lang.String r2 = r2.getHyphenatedWordPost()
            int r5 = r4.length()
            if (r5 <= 0) goto L_0x01b3
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r1.<init>(r2)
            java.lang.String r2 = r0.value
            java.lang.String r2 = r2.substring(r3)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = r0.value
            r5 = 0
            java.lang.String r3 = r3.substring(r5, r8)
            java.lang.String r3 = java.lang.String.valueOf(r3)
            r2.<init>(r3)
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            java.lang.String r2 = r0.trim(r2)
            r0.value = r2
            com.lowagie.text.pdf.PdfChunk r2 = new com.lowagie.text.pdf.PdfChunk
            r2.<init>((java.lang.String) r1, (com.lowagie.text.pdf.PdfChunk) r0)
            return r2
        L_0x01b3:
            java.lang.String r2 = r0.value
            java.lang.String r2 = r2.substring(r1)
            java.lang.String r3 = r0.value
            r4 = 0
            java.lang.String r1 = r3.substring(r4, r1)
            java.lang.String r1 = r0.trim(r1)
            r0.value = r1
            com.lowagie.text.pdf.PdfChunk r1 = new com.lowagie.text.pdf.PdfChunk
            r1.<init>((java.lang.String) r2, (com.lowagie.text.pdf.PdfChunk) r0)
            return r1
        L_0x01cc:
            r17 = 0
            com.lowagie.text.SplitCharacter r6 = r0.splitCharacter
            r7 = 0
            r11 = 0
            r8 = r4
            r9 = r5
            r10 = r12
            boolean r6 = r6.isSplitCharacter(r7, r8, r9, r10, r11)
            if (r6 == 0) goto L_0x01df
            int r6 = r4 + 1
            r16 = r6
        L_0x01df:
            int r4 = r4 + 1
            r7 = r13
            r8 = r14
            r6 = r18
            r14 = 2
            goto L_0x00da
        L_0x01e8:
            r1 = 1
            r0.newlineSplit = r1
            if (r9 != r10) goto L_0x01f8
            int r2 = r4 + 1
            if (r2 >= r5) goto L_0x01f8
            char r2 = r12[r2]
            if (r2 != r15) goto L_0x01f8
            r19 = 2
            goto L_0x01fa
        L_0x01f8:
            r19 = 1
        L_0x01fa:
            java.lang.String r2 = r0.value
            int r3 = r4 + r19
            java.lang.String r2 = r2.substring(r3)
            java.lang.String r3 = r0.value
            r5 = 0
            java.lang.String r3 = r3.substring(r5, r4)
            r0.value = r3
            java.lang.String r3 = r0.value
            int r3 = r3.length()
            if (r3 >= r1) goto L_0x0217
            java.lang.String r1 = " "
            r0.value = r1
        L_0x0217:
            com.lowagie.text.pdf.PdfChunk r1 = new com.lowagie.text.pdf.PdfChunk
            r1.<init>((java.lang.String) r2, (com.lowagie.text.pdf.PdfChunk) r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.PdfChunk.split(float):com.lowagie.text.pdf.PdfChunk");
    }

    /* access modifiers changed from: package-private */
    public PdfChunk truncate(float f) {
        float f2;
        Image image2 = this.image;
        if (image2 == null) {
            int i = 1;
            if (f < this.font.width()) {
                String substring = this.value.substring(1);
                this.value = this.value.substring(0, 1);
                return new PdfChunk(substring, this);
            }
            int length = this.value.length();
            int i2 = 0;
            float f3 = 0.0f;
            boolean z = false;
            while (i2 < length) {
                z = Utilities.isSurrogatePair(this.value, i2);
                if (z) {
                    f2 = this.font.width(Utilities.convertToUtf32(this.value, i2));
                } else {
                    f2 = this.font.width((int) this.value.charAt(i2));
                }
                f3 += f2;
                if (f3 > f) {
                    break;
                }
                if (z) {
                    i2++;
                }
                i2++;
            }
            if (i2 == length) {
                return null;
            }
            if (i2 != 0) {
                i = i2;
            } else if (z) {
                i = 2;
            }
            String substring2 = this.value.substring(i);
            this.value = this.value.substring(0, i);
            return new PdfChunk(substring2, this);
        } else if (image2.getScaledWidth() <= f) {
            return null;
        } else {
            PdfChunk pdfChunk = new PdfChunk("", this);
            this.value = "";
            this.attributes.remove(Chunk.IMAGE);
            this.image = null;
            this.font = PdfFont.getDefaultFont();
            return pdfChunk;
        }
    }

    /* access modifiers changed from: package-private */
    public PdfFont font() {
        return this.font;
    }

    /* access modifiers changed from: package-private */
    public Color color() {
        return (Color) this.noStroke.get(Chunk.COLOR);
    }

    /* access modifiers changed from: package-private */
    public float width() {
        return this.font.width(this.value);
    }

    public boolean isNewlineSplit() {
        return this.newlineSplit;
    }

    public float getWidthCorrected(float f, float f2) {
        Image image2 = this.image;
        if (image2 != null) {
            return image2.getScaledWidth() + f;
        }
        int i = 0;
        int i2 = -1;
        while (true) {
            i2 = this.value.indexOf(32, i2 + 1);
            if (i2 < 0) {
                return width() + (((float) this.value.length()) * f) + (((float) i) * f2);
            }
            i++;
        }
    }

    public float getTextRise() {
        Float f = (Float) getAttribute(Chunk.SUBSUPSCRIPT);
        if (f != null) {
            return f.floatValue();
        }
        return 0.0f;
    }

    public float trimLastSpace() {
        BaseFont font2 = this.font.getFont();
        if (font2.getFontType() != 2 || font2.getUnicodeEquivalent(32) == 32) {
            if (this.value.length() <= 1 || !this.value.endsWith(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR)) {
                return 0.0f;
            }
            String str = this.value;
            this.value = str.substring(0, str.length() - 1);
            return this.font.width(32);
        } else if (this.value.length() <= 1 || !this.value.endsWith("\u0001")) {
            return 0.0f;
        } else {
            String str2 = this.value;
            this.value = str2.substring(0, str2.length() - 1);
            return this.font.width(1);
        }
    }

    public float trimFirstSpace() {
        BaseFont font2 = this.font.getFont();
        if (font2.getFontType() != 2 || font2.getUnicodeEquivalent(32) == 32) {
            if (this.value.length() <= 1 || !this.value.startsWith(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR)) {
                return 0.0f;
            }
            this.value = this.value.substring(1);
            return this.font.width(32);
        } else if (this.value.length() <= 1 || !this.value.startsWith("\u0001")) {
            return 0.0f;
        } else {
            this.value = this.value.substring(1);
            return this.font.width(1);
        }
    }

    /* access modifiers changed from: package-private */
    public Object getAttribute(String str) {
        if (this.attributes.containsKey(str)) {
            return this.attributes.get(str);
        }
        return this.noStroke.get(str);
    }

    /* access modifiers changed from: package-private */
    public boolean isAttribute(String str) {
        if (this.attributes.containsKey(str)) {
            return true;
        }
        return this.noStroke.containsKey(str);
    }

    /* access modifiers changed from: package-private */
    public boolean isStroked() {
        return !this.attributes.isEmpty();
    }

    /* access modifiers changed from: package-private */
    public boolean isSeparator() {
        return isAttribute(Chunk.SEPARATOR);
    }

    /* access modifiers changed from: package-private */
    public boolean isHorizontalSeparator() {
        if (isAttribute(Chunk.SEPARATOR)) {
            return !((Boolean) ((Object[]) getAttribute(Chunk.SEPARATOR))[1]).booleanValue();
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean isTab() {
        return isAttribute(Chunk.TAB);
    }

    /* access modifiers changed from: package-private */
    public void adjustLeft(float f) {
        Object[] objArr = (Object[]) this.attributes.get(Chunk.TAB);
        if (objArr != null) {
            this.attributes.put(Chunk.TAB, new Object[]{objArr[0], objArr[1], objArr[2], new Float(f)});
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isImage() {
        return this.image != null;
    }

    /* access modifiers changed from: package-private */
    public Image getImage() {
        return this.image;
    }

    /* access modifiers changed from: package-private */
    public void setImageOffsetX(float f) {
        this.offsetX = f;
    }

    /* access modifiers changed from: package-private */
    public float getImageOffsetX() {
        return this.offsetX;
    }

    /* access modifiers changed from: package-private */
    public void setImageOffsetY(float f) {
        this.offsetY = f;
    }

    /* access modifiers changed from: package-private */
    public float getImageOffsetY() {
        return this.offsetY;
    }

    /* access modifiers changed from: package-private */
    public void setValue(String str) {
        this.value = str;
    }

    public String toString() {
        return this.value;
    }

    /* access modifiers changed from: package-private */
    public boolean isSpecialEncoding() {
        return this.encoding.equals("UnicodeBigUnmarked") || this.encoding.equals(BaseFont.IDENTITY_H);
    }

    /* access modifiers changed from: package-private */
    public String getEncoding() {
        return this.encoding;
    }

    /* access modifiers changed from: package-private */
    public int length() {
        return this.value.length();
    }

    /* access modifiers changed from: package-private */
    public int lengthUtf32() {
        if (!BaseFont.IDENTITY_H.equals(this.encoding)) {
            return this.value.length();
        }
        int length = this.value.length();
        int i = 0;
        int i2 = 0;
        while (i < length) {
            if (Utilities.isSurrogateHigh(this.value.charAt(i))) {
                i++;
            }
            i2++;
            i++;
        }
        return i2;
    }

    /* access modifiers changed from: package-private */
    public boolean isExtSplitCharacter(int i, int i2, int i3, char[] cArr, PdfChunk[] pdfChunkArr) {
        return this.splitCharacter.isSplitCharacter(i, i2, i3, cArr, pdfChunkArr);
    }

    /* access modifiers changed from: package-private */
    public String trim(String str) {
        BaseFont font2 = this.font.getFont();
        if (font2.getFontType() != 2 || font2.getUnicodeEquivalent(32) == 32) {
            while (true) {
                if (!str.endsWith(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR) && !str.endsWith("\t")) {
                    break;
                }
                str = str.substring(0, str.length() - 1);
            }
        } else {
            while (str.endsWith("\u0001")) {
                str = str.substring(0, str.length() - 1);
            }
        }
        return str;
    }

    public boolean changeLeading() {
        return this.changeLeading;
    }

    /* access modifiers changed from: package-private */
    public float getCharWidth(int i) {
        if (noPrint(i)) {
            return 0.0f;
        }
        return this.font.width(i);
    }
}
