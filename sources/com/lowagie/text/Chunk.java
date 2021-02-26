package com.lowagie.text;

import com.lowagie.text.pdf.HyphenationEvent;
import com.lowagie.text.pdf.PdfAction;
import com.lowagie.text.pdf.PdfAnnotation;
import com.lowagie.text.pdf.draw.DrawInterface;
import harmony.java.awt.Color;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class Chunk implements Element {
    public static final String ACTION = "ACTION";
    public static final String BACKGROUND = "BACKGROUND";
    public static final String COLOR = "COLOR";
    public static final String ENCODING = "ENCODING";
    public static final String GENERICTAG = "GENERICTAG";
    public static final String HSCALE = "HSCALE";
    public static final String HYPHENATION = "HYPHENATION";
    public static final String IMAGE = "IMAGE";
    public static final String LOCALDESTINATION = "LOCALDESTINATION";
    public static final String LOCALGOTO = "LOCALGOTO";
    public static final Chunk NEWLINE = new Chunk("\n");
    public static final String NEWPAGE = "NEWPAGE";
    public static final Chunk NEXTPAGE = new Chunk("");
    public static final String OBJECT_REPLACEMENT_CHARACTER = "￼";
    public static final String PDFANNOTATION = "PDFANNOTATION";
    public static final String REMOTEGOTO = "REMOTEGOTO";
    public static final String SEPARATOR = "SEPARATOR";
    public static final String SKEW = "SKEW";
    public static final String SPLITCHARACTER = "SPLITCHARACTER";
    public static final String SUBSUPSCRIPT = "SUBSUPSCRIPT";
    public static final String TAB = "TAB";
    public static final String TEXTRENDERMODE = "TEXTRENDERMODE";
    public static final String UNDERLINE = "UNDERLINE";
    protected HashMap attributes;
    protected StringBuffer content;
    protected Font font;

    public boolean isContent() {
        return true;
    }

    public boolean isNestable() {
        return true;
    }

    public int type() {
        return 10;
    }

    static {
        NEXTPAGE.setNewPage();
    }

    public Chunk() {
        this.content = null;
        this.font = null;
        this.attributes = null;
        this.content = new StringBuffer();
        this.font = new Font();
    }

    public Chunk(Chunk chunk) {
        this.content = null;
        this.font = null;
        this.attributes = null;
        StringBuffer stringBuffer = chunk.content;
        if (stringBuffer != null) {
            this.content = new StringBuffer(stringBuffer.toString());
        }
        Font font2 = chunk.font;
        if (font2 != null) {
            this.font = new Font(font2);
        }
        HashMap hashMap = chunk.attributes;
        if (hashMap != null) {
            this.attributes = new HashMap(hashMap);
        }
    }

    public Chunk(String str, Font font2) {
        this.content = null;
        this.font = null;
        this.attributes = null;
        this.content = new StringBuffer(str);
        this.font = font2;
    }

    public Chunk(String str) {
        this(str, new Font());
    }

    public Chunk(char c, Font font2) {
        this.content = null;
        this.font = null;
        this.attributes = null;
        this.content = new StringBuffer();
        this.content.append(c);
        this.font = font2;
    }

    public Chunk(char c) {
        this(c, new Font());
    }

    public Chunk(Image image, float f, float f2) {
        this(OBJECT_REPLACEMENT_CHARACTER, new Font());
        Image instance = Image.getInstance(image);
        instance.setAbsolutePosition(Float.NaN, Float.NaN);
        setAttribute(IMAGE, new Object[]{instance, new Float(f), new Float(f2), Boolean.FALSE});
    }

    public Chunk(DrawInterface drawInterface) {
        this(drawInterface, false);
    }

    public Chunk(DrawInterface drawInterface, boolean z) {
        this(OBJECT_REPLACEMENT_CHARACTER, new Font());
        setAttribute(SEPARATOR, new Object[]{drawInterface, Boolean.valueOf(z)});
    }

    public Chunk(DrawInterface drawInterface, float f) {
        this(drawInterface, f, false);
    }

    public Chunk(DrawInterface drawInterface, float f, boolean z) {
        this(OBJECT_REPLACEMENT_CHARACTER, new Font());
        if (f >= 0.0f) {
            setAttribute(TAB, new Object[]{drawInterface, new Float(f), Boolean.valueOf(z), new Float(0.0f)});
            return;
        }
        throw new IllegalArgumentException("A tab position may not be lower than 0; yours is " + f);
    }

    public Chunk(Image image, float f, float f2, boolean z) {
        this(OBJECT_REPLACEMENT_CHARACTER, new Font());
        setAttribute(IMAGE, new Object[]{image, new Float(f), new Float(f2), Boolean.valueOf(z)});
    }

    public boolean process(ElementListener elementListener) {
        try {
            return elementListener.add(this);
        } catch (DocumentException unused) {
            return false;
        }
    }

    public ArrayList getChunks() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        return arrayList;
    }

    public StringBuffer append(String str) {
        StringBuffer stringBuffer = this.content;
        stringBuffer.append(str);
        return stringBuffer;
    }

    public void setFont(Font font2) {
        this.font = font2;
    }

    public Font getFont() {
        return this.font;
    }

    public String getContent() {
        return this.content.toString();
    }

    public String toString() {
        return getContent();
    }

    public boolean isEmpty() {
        return this.content.toString().trim().length() == 0 && this.content.toString().indexOf("\n") == -1 && this.attributes == null;
    }

    public float getWidthPoint() {
        if (getImage() != null) {
            return getImage().getScaledWidth();
        }
        return this.font.getCalculatedBaseFont(true).getWidthPoint(getContent(), this.font.getCalculatedSize()) * getHorizontalScaling();
    }

    public boolean hasAttributes() {
        return this.attributes != null;
    }

    public HashMap getAttributes() {
        return this.attributes;
    }

    public void setAttributes(HashMap hashMap) {
        this.attributes = hashMap;
    }

    private Chunk setAttribute(String str, Object obj) {
        if (this.attributes == null) {
            this.attributes = new HashMap();
        }
        this.attributes.put(str, obj);
        return this;
    }

    public Chunk setHorizontalScaling(float f) {
        return setAttribute(HSCALE, new Float(f));
    }

    public float getHorizontalScaling() {
        Float f;
        HashMap hashMap = this.attributes;
        if (hashMap == null || (f = (Float) hashMap.get(HSCALE)) == null) {
            return 1.0f;
        }
        return f.floatValue();
    }

    public Chunk setUnderline(float f, float f2) {
        return setUnderline((Color) null, f, 0.0f, f2, 0.0f, 0);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.lowagie.text.Chunk setUnderline(harmony.java.awt.Color r4, float r5, float r6, float r7, float r8, int r9) {
        /*
            r3 = this;
            java.util.HashMap r0 = r3.attributes
            if (r0 != 0) goto L_0x000b
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            r3.attributes = r0
        L_0x000b:
            r0 = 2
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r2 = 0
            r1[r2] = r4
            r4 = 5
            float[] r4 = new float[r4]
            r4[r2] = r5
            r5 = 1
            r4[r5] = r6
            r4[r0] = r7
            r6 = 3
            r4[r6] = r8
            r6 = 4
            float r7 = (float) r9
            r4[r6] = r7
            r1[r5] = r4
            java.util.HashMap r4 = r3.attributes
            java.lang.String r5 = "UNDERLINE"
            java.lang.Object r4 = r4.get(r5)
            java.lang.Object[][] r4 = (java.lang.Object[][]) r4
            java.lang.Object[][] r4 = com.lowagie.text.Utilities.addToArray(r4, r1)
            com.lowagie.text.Chunk r4 = r3.setAttribute(r5, r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.Chunk.setUnderline(harmony.java.awt.Color, float, float, float, float, int):com.lowagie.text.Chunk");
    }

    public Chunk setTextRise(float f) {
        return setAttribute(SUBSUPSCRIPT, new Float(f));
    }

    public float getTextRise() {
        HashMap hashMap = this.attributes;
        if (hashMap == null || !hashMap.containsKey(SUBSUPSCRIPT)) {
            return 0.0f;
        }
        return ((Float) this.attributes.get(SUBSUPSCRIPT)).floatValue();
    }

    public Chunk setSkew(float f, float f2) {
        return setAttribute(SKEW, new float[]{(float) Math.tan((((double) f) * 3.141592653589793d) / 180.0d), (float) Math.tan((((double) f2) * 3.141592653589793d) / 180.0d)});
    }

    public Chunk setBackground(Color color) {
        return setBackground(color, 0.0f, 0.0f, 0.0f, 0.0f);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.lowagie.text.Chunk setBackground(harmony.java.awt.Color r4, float r5, float r6, float r7, float r8) {
        /*
            r3 = this;
            r0 = 2
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r2 = 0
            r1[r2] = r4
            r4 = 4
            float[] r4 = new float[r4]
            r4[r2] = r5
            r5 = 1
            r4[r5] = r6
            r4[r0] = r7
            r6 = 3
            r4[r6] = r8
            r1[r5] = r4
            java.lang.String r4 = "BACKGROUND"
            com.lowagie.text.Chunk r4 = r3.setAttribute(r4, r1)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.Chunk.setBackground(harmony.java.awt.Color, float, float, float, float):com.lowagie.text.Chunk");
    }

    public Chunk setTextRenderMode(int i, float f, Color color) {
        return setAttribute(TEXTRENDERMODE, new Object[]{new Integer(i), new Float(f), color});
    }

    public Chunk setSplitCharacter(SplitCharacter splitCharacter) {
        return setAttribute(SPLITCHARACTER, splitCharacter);
    }

    public Chunk setHyphenation(HyphenationEvent hyphenationEvent) {
        return setAttribute(HYPHENATION, hyphenationEvent);
    }

    public Chunk setRemoteGoto(String str, String str2) {
        return setAttribute(REMOTEGOTO, new Object[]{str, str2});
    }

    public Chunk setRemoteGoto(String str, int i) {
        return setAttribute(REMOTEGOTO, new Object[]{str, new Integer(i)});
    }

    public Chunk setLocalGoto(String str) {
        return setAttribute(LOCALGOTO, str);
    }

    public Chunk setLocalDestination(String str) {
        return setAttribute(LOCALDESTINATION, str);
    }

    public Chunk setGenericTag(String str) {
        return setAttribute(GENERICTAG, str);
    }

    public Image getImage() {
        Object[] objArr;
        HashMap hashMap = this.attributes;
        if (hashMap == null || (objArr = (Object[]) hashMap.get(IMAGE)) == null) {
            return null;
        }
        return (Image) objArr[0];
    }

    public Chunk setAction(PdfAction pdfAction) {
        return setAttribute(ACTION, pdfAction);
    }

    public Chunk setAnchor(URL url) {
        return setAttribute(ACTION, new PdfAction(url.toExternalForm()));
    }

    public Chunk setAnchor(String str) {
        return setAttribute(ACTION, new PdfAction(str));
    }

    public Chunk setNewPage() {
        return setAttribute(NEWPAGE, (Object) null);
    }

    public Chunk setAnnotation(PdfAnnotation pdfAnnotation) {
        return setAttribute(PDFANNOTATION, pdfAnnotation);
    }

    public HyphenationEvent getHyphenation() {
        HashMap hashMap = this.attributes;
        if (hashMap == null) {
            return null;
        }
        return (HyphenationEvent) hashMap.get(HYPHENATION);
    }
}
