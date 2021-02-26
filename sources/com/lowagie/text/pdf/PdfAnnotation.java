package com.lowagie.text.pdf;

import com.lowagie.text.Rectangle;
import harmony.java.awt.Color;
import java.io.IOException;
import java.util.HashMap;

public class PdfAnnotation extends PdfDictionary {
    public static final PdfName AA_BLUR = PdfName.f649BL;
    public static final PdfName AA_DOWN = PdfName.f661D;
    public static final PdfName AA_ENTER = PdfName.f671E;
    public static final PdfName AA_EXIT = PdfName.f743X;
    public static final PdfName AA_FOCUS = PdfName.f676FO;
    public static final PdfName AA_JS_CHANGE = PdfName.f736V;
    public static final PdfName AA_JS_FORMAT = PdfName.f673F;
    public static final PdfName AA_JS_KEY = PdfName.f691K;
    public static final PdfName AA_JS_OTHER_CHANGE = PdfName.f652C;
    public static final PdfName AA_UP = PdfName.f733U;
    public static final PdfName APPEARANCE_DOWN = PdfName.f661D;
    public static final PdfName APPEARANCE_NORMAL = PdfName.f696N;
    public static final PdfName APPEARANCE_ROLLOVER = PdfName.f715R;
    public static final int FLAGS_HIDDEN = 2;
    public static final int FLAGS_INVISIBLE = 1;
    public static final int FLAGS_LOCKED = 128;
    public static final int FLAGS_NOROTATE = 16;
    public static final int FLAGS_NOVIEW = 32;
    public static final int FLAGS_NOZOOM = 8;
    public static final int FLAGS_PRINT = 4;
    public static final int FLAGS_READONLY = 64;
    public static final int FLAGS_TOGGLENOVIEW = 256;
    public static final PdfName HIGHLIGHT_INVERT = PdfName.f686I;
    public static final PdfName HIGHLIGHT_NONE = PdfName.f696N;
    public static final PdfName HIGHLIGHT_OUTLINE = PdfName.f703O;
    public static final PdfName HIGHLIGHT_PUSH = PdfName.f707P;
    public static final PdfName HIGHLIGHT_TOGGLE = PdfName.f723T;
    public static final int MARKUP_HIGHLIGHT = 0;
    public static final int MARKUP_SQUIGGLY = 3;
    public static final int MARKUP_STRIKEOUT = 2;
    public static final int MARKUP_UNDERLINE = 1;
    protected boolean annotation = true;
    protected boolean form = false;
    private int placeInPage = -1;
    protected PdfIndirectReference reference;
    protected HashMap templates;
    protected boolean used = false;
    protected PdfWriter writer;

    public PdfAnnotation(PdfWriter pdfWriter, Rectangle rectangle) {
        this.writer = pdfWriter;
        if (rectangle != null) {
            put(PdfName.RECT, new PdfRectangle(rectangle));
        }
    }

    public PdfAnnotation(PdfWriter pdfWriter, float f, float f2, float f3, float f4, PdfString pdfString, PdfString pdfString2) {
        this.writer = pdfWriter;
        put(PdfName.SUBTYPE, PdfName.TEXT);
        put(PdfName.f723T, pdfString);
        put(PdfName.RECT, new PdfRectangle(f, f2, f3, f4));
        put(PdfName.CONTENTS, pdfString2);
    }

    public PdfAnnotation(PdfWriter pdfWriter, float f, float f2, float f3, float f4, PdfAction pdfAction) {
        this.writer = pdfWriter;
        put(PdfName.SUBTYPE, PdfName.LINK);
        put(PdfName.RECT, new PdfRectangle(f, f2, f3, f4));
        put(PdfName.f641A, pdfAction);
        put(PdfName.BORDER, new PdfBorderArray(0.0f, 0.0f, 0.0f));
        put(PdfName.f652C, new PdfColor(0, 0, 255));
    }

    public static PdfAnnotation createScreen(PdfWriter pdfWriter, Rectangle rectangle, String str, PdfFileSpecification pdfFileSpecification, String str2, boolean z) throws IOException {
        PdfAnnotation pdfAnnotation = new PdfAnnotation(pdfWriter, rectangle);
        pdfAnnotation.put(PdfName.SUBTYPE, PdfName.SCREEN);
        pdfAnnotation.put(PdfName.f673F, new PdfNumber(4));
        pdfAnnotation.put(PdfName.TYPE, PdfName.ANNOT);
        pdfAnnotation.setPage();
        PdfIndirectReference indirectReference = pdfWriter.addToBody(PdfAction.rendition(str, pdfFileSpecification, str2, pdfAnnotation.getIndirectReference())).getIndirectReference();
        if (z) {
            PdfDictionary pdfDictionary = new PdfDictionary();
            pdfDictionary.put(new PdfName("PV"), indirectReference);
            pdfAnnotation.put(PdfName.f642AA, pdfDictionary);
        }
        pdfAnnotation.put(PdfName.f641A, indirectReference);
        return pdfAnnotation;
    }

    public PdfIndirectReference getIndirectReference() {
        if (this.reference == null) {
            this.reference = this.writer.getPdfIndirectReference();
        }
        return this.reference;
    }

    public static PdfAnnotation createText(PdfWriter pdfWriter, Rectangle rectangle, String str, String str2, boolean z, String str3) {
        PdfAnnotation pdfAnnotation = new PdfAnnotation(pdfWriter, rectangle);
        pdfAnnotation.put(PdfName.SUBTYPE, PdfName.TEXT);
        if (str != null) {
            pdfAnnotation.put(PdfName.f723T, new PdfString(str, PdfObject.TEXT_UNICODE));
        }
        if (str2 != null) {
            pdfAnnotation.put(PdfName.CONTENTS, new PdfString(str2, PdfObject.TEXT_UNICODE));
        }
        if (z) {
            pdfAnnotation.put(PdfName.OPEN, PdfBoolean.PDFTRUE);
        }
        if (str3 != null) {
            pdfAnnotation.put(PdfName.NAME, new PdfName(str3));
        }
        return pdfAnnotation;
    }

    protected static PdfAnnotation createLink(PdfWriter pdfWriter, Rectangle rectangle, PdfName pdfName) {
        PdfAnnotation pdfAnnotation = new PdfAnnotation(pdfWriter, rectangle);
        pdfAnnotation.put(PdfName.SUBTYPE, PdfName.LINK);
        if (!pdfName.equals(HIGHLIGHT_INVERT)) {
            pdfAnnotation.put(PdfName.f679H, pdfName);
        }
        return pdfAnnotation;
    }

    public static PdfAnnotation createLink(PdfWriter pdfWriter, Rectangle rectangle, PdfName pdfName, PdfAction pdfAction) {
        PdfAnnotation createLink = createLink(pdfWriter, rectangle, pdfName);
        createLink.putEx(PdfName.f641A, pdfAction);
        return createLink;
    }

    public static PdfAnnotation createLink(PdfWriter pdfWriter, Rectangle rectangle, PdfName pdfName, String str) {
        PdfAnnotation createLink = createLink(pdfWriter, rectangle, pdfName);
        createLink.put(PdfName.DEST, new PdfString(str));
        return createLink;
    }

    public static PdfAnnotation createLink(PdfWriter pdfWriter, Rectangle rectangle, PdfName pdfName, int i, PdfDestination pdfDestination) {
        PdfAnnotation createLink = createLink(pdfWriter, rectangle, pdfName);
        pdfDestination.addPage(pdfWriter.getPageReference(i));
        createLink.put(PdfName.DEST, pdfDestination);
        return createLink;
    }

    public static PdfAnnotation createFreeText(PdfWriter pdfWriter, Rectangle rectangle, String str, PdfContentByte pdfContentByte) {
        PdfAnnotation pdfAnnotation = new PdfAnnotation(pdfWriter, rectangle);
        pdfAnnotation.put(PdfName.SUBTYPE, PdfName.FREETEXT);
        pdfAnnotation.put(PdfName.CONTENTS, new PdfString(str, PdfObject.TEXT_UNICODE));
        pdfAnnotation.setDefaultAppearanceString(pdfContentByte);
        return pdfAnnotation;
    }

    public static PdfAnnotation createLine(PdfWriter pdfWriter, Rectangle rectangle, String str, float f, float f2, float f3, float f4) {
        PdfAnnotation pdfAnnotation = new PdfAnnotation(pdfWriter, rectangle);
        pdfAnnotation.put(PdfName.SUBTYPE, PdfName.LINE);
        pdfAnnotation.put(PdfName.CONTENTS, new PdfString(str, PdfObject.TEXT_UNICODE));
        PdfArray pdfArray = new PdfArray((PdfObject) new PdfNumber(f));
        pdfArray.add((PdfObject) new PdfNumber(f2));
        pdfArray.add((PdfObject) new PdfNumber(f3));
        pdfArray.add((PdfObject) new PdfNumber(f4));
        pdfAnnotation.put(PdfName.f692L, pdfArray);
        return pdfAnnotation;
    }

    public static PdfAnnotation createSquareCircle(PdfWriter pdfWriter, Rectangle rectangle, String str, boolean z) {
        PdfAnnotation pdfAnnotation = new PdfAnnotation(pdfWriter, rectangle);
        if (z) {
            pdfAnnotation.put(PdfName.SUBTYPE, PdfName.SQUARE);
        } else {
            pdfAnnotation.put(PdfName.SUBTYPE, PdfName.CIRCLE);
        }
        pdfAnnotation.put(PdfName.CONTENTS, new PdfString(str, PdfObject.TEXT_UNICODE));
        return pdfAnnotation;
    }

    public static PdfAnnotation createMarkup(PdfWriter pdfWriter, Rectangle rectangle, String str, int i, float[] fArr) {
        PdfAnnotation pdfAnnotation = new PdfAnnotation(pdfWriter, rectangle);
        PdfName pdfName = PdfName.HIGHLIGHT;
        if (i == 1) {
            pdfName = PdfName.UNDERLINE;
        } else if (i == 2) {
            pdfName = PdfName.STRIKEOUT;
        } else if (i == 3) {
            pdfName = PdfName.SQUIGGLY;
        }
        pdfAnnotation.put(PdfName.SUBTYPE, pdfName);
        pdfAnnotation.put(PdfName.CONTENTS, new PdfString(str, PdfObject.TEXT_UNICODE));
        PdfArray pdfArray = new PdfArray();
        for (float pdfNumber : fArr) {
            pdfArray.add((PdfObject) new PdfNumber(pdfNumber));
        }
        pdfAnnotation.put(PdfName.QUADPOINTS, pdfArray);
        return pdfAnnotation;
    }

    public static PdfAnnotation createStamp(PdfWriter pdfWriter, Rectangle rectangle, String str, String str2) {
        PdfAnnotation pdfAnnotation = new PdfAnnotation(pdfWriter, rectangle);
        pdfAnnotation.put(PdfName.SUBTYPE, PdfName.STAMP);
        pdfAnnotation.put(PdfName.CONTENTS, new PdfString(str, PdfObject.TEXT_UNICODE));
        pdfAnnotation.put(PdfName.NAME, new PdfName(str2));
        return pdfAnnotation;
    }

    public static PdfAnnotation createInk(PdfWriter pdfWriter, Rectangle rectangle, String str, float[][] fArr) {
        PdfAnnotation pdfAnnotation = new PdfAnnotation(pdfWriter, rectangle);
        pdfAnnotation.put(PdfName.SUBTYPE, PdfName.INK);
        pdfAnnotation.put(PdfName.CONTENTS, new PdfString(str, PdfObject.TEXT_UNICODE));
        PdfArray pdfArray = new PdfArray();
        for (float[] fArr2 : fArr) {
            PdfArray pdfArray2 = new PdfArray();
            for (float pdfNumber : fArr2) {
                pdfArray2.add((PdfObject) new PdfNumber(pdfNumber));
            }
            pdfArray.add((PdfObject) pdfArray2);
        }
        pdfAnnotation.put(PdfName.INKLIST, pdfArray);
        return pdfAnnotation;
    }

    public static PdfAnnotation createFileAttachment(PdfWriter pdfWriter, Rectangle rectangle, String str, byte[] bArr, String str2, String str3) throws IOException {
        return createFileAttachment(pdfWriter, rectangle, str, PdfFileSpecification.fileEmbedded(pdfWriter, str2, str3, bArr));
    }

    public static PdfAnnotation createFileAttachment(PdfWriter pdfWriter, Rectangle rectangle, String str, PdfFileSpecification pdfFileSpecification) throws IOException {
        PdfAnnotation pdfAnnotation = new PdfAnnotation(pdfWriter, rectangle);
        pdfAnnotation.put(PdfName.SUBTYPE, PdfName.FILEATTACHMENT);
        if (str != null) {
            pdfAnnotation.put(PdfName.CONTENTS, new PdfString(str, PdfObject.TEXT_UNICODE));
        }
        pdfAnnotation.put(PdfName.f677FS, pdfFileSpecification.getReference());
        return pdfAnnotation;
    }

    public static PdfAnnotation createPopup(PdfWriter pdfWriter, Rectangle rectangle, String str, boolean z) {
        PdfAnnotation pdfAnnotation = new PdfAnnotation(pdfWriter, rectangle);
        pdfAnnotation.put(PdfName.SUBTYPE, PdfName.POPUP);
        if (str != null) {
            pdfAnnotation.put(PdfName.CONTENTS, new PdfString(str, PdfObject.TEXT_UNICODE));
        }
        if (z) {
            pdfAnnotation.put(PdfName.OPEN, PdfBoolean.PDFTRUE);
        }
        return pdfAnnotation;
    }

    public void setDefaultAppearanceString(PdfContentByte pdfContentByte) {
        byte[] byteArray = pdfContentByte.getInternalBuffer().toByteArray();
        int length = byteArray.length;
        for (int i = 0; i < length; i++) {
            if (byteArray[i] == 10) {
                byteArray[i] = 32;
            }
        }
        put(PdfName.f662DA, new PdfString(byteArray));
    }

    public void setFlags(int i) {
        if (i == 0) {
            remove(PdfName.f673F);
        } else {
            put(PdfName.f673F, new PdfNumber(i));
        }
    }

    public void setBorder(PdfBorderArray pdfBorderArray) {
        put(PdfName.BORDER, pdfBorderArray);
    }

    public void setBorderStyle(PdfBorderDictionary pdfBorderDictionary) {
        put(PdfName.f651BS, pdfBorderDictionary);
    }

    public void setHighlighting(PdfName pdfName) {
        if (pdfName.equals(HIGHLIGHT_INVERT)) {
            remove(PdfName.f679H);
        } else {
            put(PdfName.f679H, pdfName);
        }
    }

    public void setAppearance(PdfName pdfName, PdfTemplate pdfTemplate) {
        PdfDictionary pdfDictionary = (PdfDictionary) get(PdfName.f644AP);
        if (pdfDictionary == null) {
            pdfDictionary = new PdfDictionary();
        }
        pdfDictionary.put(pdfName, pdfTemplate.getIndirectReference());
        put(PdfName.f644AP, pdfDictionary);
        if (this.form) {
            if (this.templates == null) {
                this.templates = new HashMap();
            }
            this.templates.put(pdfTemplate, (Object) null);
        }
    }

    public void setAppearance(PdfName pdfName, String str, PdfTemplate pdfTemplate) {
        PdfDictionary pdfDictionary;
        PdfDictionary pdfDictionary2 = (PdfDictionary) get(PdfName.f644AP);
        if (pdfDictionary2 == null) {
            pdfDictionary2 = new PdfDictionary();
        }
        PdfObject pdfObject = pdfDictionary2.get(pdfName);
        if (pdfObject == null || !pdfObject.isDictionary()) {
            pdfDictionary = new PdfDictionary();
        } else {
            pdfDictionary = (PdfDictionary) pdfObject;
        }
        pdfDictionary.put(new PdfName(str), pdfTemplate.getIndirectReference());
        pdfDictionary2.put(pdfName, pdfDictionary);
        put(PdfName.f644AP, pdfDictionary2);
        if (this.form) {
            if (this.templates == null) {
                this.templates = new HashMap();
            }
            this.templates.put(pdfTemplate, (Object) null);
        }
    }

    public void setAppearanceState(String str) {
        if (str == null) {
            remove(PdfName.f645AS);
        } else {
            put(PdfName.f645AS, new PdfName(str));
        }
    }

    public void setColor(Color color) {
        put(PdfName.f652C, new PdfColor(color));
    }

    public void setTitle(String str) {
        if (str == null) {
            remove(PdfName.f723T);
        } else {
            put(PdfName.f723T, new PdfString(str, PdfObject.TEXT_UNICODE));
        }
    }

    public void setPopup(PdfAnnotation pdfAnnotation) {
        put(PdfName.POPUP, pdfAnnotation.getIndirectReference());
        pdfAnnotation.put(PdfName.PARENT, getIndirectReference());
    }

    public void setAction(PdfAction pdfAction) {
        put(PdfName.f641A, pdfAction);
    }

    public void setAdditionalActions(PdfName pdfName, PdfAction pdfAction) {
        PdfDictionary pdfDictionary;
        PdfObject pdfObject = get(PdfName.f642AA);
        if (pdfObject == null || !pdfObject.isDictionary()) {
            pdfDictionary = new PdfDictionary();
        } else {
            pdfDictionary = (PdfDictionary) pdfObject;
        }
        pdfDictionary.put(pdfName, pdfAction);
        put(PdfName.f642AA, pdfDictionary);
    }

    public boolean isUsed() {
        return this.used;
    }

    public void setUsed() {
        this.used = true;
    }

    public HashMap getTemplates() {
        return this.templates;
    }

    public boolean isForm() {
        return this.form;
    }

    public boolean isAnnotation() {
        return this.annotation;
    }

    public void setPage(int i) {
        put(PdfName.f707P, this.writer.getPageReference(i));
    }

    public void setPage() {
        put(PdfName.f707P, this.writer.getCurrentPage());
    }

    public int getPlaceInPage() {
        return this.placeInPage;
    }

    public void setPlaceInPage(int i) {
        this.placeInPage = i;
    }

    public void setRotate(int i) {
        put(PdfName.ROTATE, new PdfNumber(i));
    }

    /* access modifiers changed from: package-private */
    public PdfDictionary getMK() {
        PdfDictionary pdfDictionary = (PdfDictionary) get(PdfName.f695MK);
        if (pdfDictionary != null) {
            return pdfDictionary;
        }
        PdfDictionary pdfDictionary2 = new PdfDictionary();
        put(PdfName.f695MK, pdfDictionary2);
        return pdfDictionary2;
    }

    public void setMKRotation(int i) {
        getMK().put(PdfName.f715R, new PdfNumber(i));
    }

    public static PdfArray getMKColor(Color color) {
        PdfArray pdfArray = new PdfArray();
        int type = ExtendedColor.getType(color);
        if (type == 1) {
            pdfArray.add((PdfObject) new PdfNumber(((GrayColor) color).getGray()));
        } else if (type == 2) {
            CMYKColor cMYKColor = (CMYKColor) color;
            pdfArray.add((PdfObject) new PdfNumber(cMYKColor.getCyan()));
            pdfArray.add((PdfObject) new PdfNumber(cMYKColor.getMagenta()));
            pdfArray.add((PdfObject) new PdfNumber(cMYKColor.getYellow()));
            pdfArray.add((PdfObject) new PdfNumber(cMYKColor.getBlack()));
        } else if (type == 3 || type == 4 || type == 5) {
            throw new RuntimeException("Separations, patterns and shadings are not allowed in MK dictionary.");
        } else {
            pdfArray.add((PdfObject) new PdfNumber(((float) color.getRed()) / 255.0f));
            pdfArray.add((PdfObject) new PdfNumber(((float) color.getGreen()) / 255.0f));
            pdfArray.add((PdfObject) new PdfNumber(((float) color.getBlue()) / 255.0f));
        }
        return pdfArray;
    }

    public void setMKBorderColor(Color color) {
        if (color == null) {
            getMK().remove(PdfName.f647BC);
        } else {
            getMK().put(PdfName.f647BC, getMKColor(color));
        }
    }

    public void setMKBackgroundColor(Color color) {
        if (color == null) {
            getMK().remove(PdfName.f648BG);
        } else {
            getMK().put(PdfName.f648BG, getMKColor(color));
        }
    }

    public void setMKNormalCaption(String str) {
        getMK().put(PdfName.f655CA, new PdfString(str, PdfObject.TEXT_UNICODE));
    }

    public void setMKRolloverCaption(String str) {
        getMK().put(PdfName.f716RC, new PdfString(str, PdfObject.TEXT_UNICODE));
    }

    public void setMKAlternateCaption(String str) {
        getMK().put(PdfName.f643AC, new PdfString(str, PdfObject.TEXT_UNICODE));
    }

    public void setMKNormalIcon(PdfTemplate pdfTemplate) {
        getMK().put(PdfName.f686I, pdfTemplate.getIndirectReference());
    }

    public void setMKRolloverIcon(PdfTemplate pdfTemplate) {
        getMK().put(PdfName.f717RI, pdfTemplate.getIndirectReference());
    }

    public void setMKAlternateIcon(PdfTemplate pdfTemplate) {
        getMK().put(PdfName.f689IX, pdfTemplate.getIndirectReference());
    }

    public void setMKIconFit(PdfName pdfName, PdfName pdfName2, float f, float f2, boolean z) {
        PdfDictionary pdfDictionary = new PdfDictionary();
        if (!pdfName.equals(PdfName.f641A)) {
            pdfDictionary.put(PdfName.f722SW, pdfName);
        }
        if (!pdfName2.equals(PdfName.f707P)) {
            pdfDictionary.put(PdfName.f719S, pdfName2);
        }
        if (!(f == 0.5f && f2 == 0.5f)) {
            PdfArray pdfArray = new PdfArray((PdfObject) new PdfNumber(f));
            pdfArray.add((PdfObject) new PdfNumber(f2));
            pdfDictionary.put(PdfName.f641A, pdfArray);
        }
        if (z) {
            pdfDictionary.put(PdfName.f674FB, PdfBoolean.PDFTRUE);
        }
        getMK().put(PdfName.f688IF, pdfDictionary);
    }

    public void setMKTextPosition(int i) {
        getMK().put(PdfName.f730TP, new PdfNumber(i));
    }

    public void setLayer(PdfOCG pdfOCG) {
        put(PdfName.f704OC, pdfOCG.getRef());
    }

    public void setName(String str) {
        put(PdfName.f702NM, new PdfString(str));
    }

    public static class PdfImportedLink {
        PdfArray destination = null;
        float llx;
        float lly;
        int newPage = 0;
        HashMap parameters = new HashMap();
        float urx;
        float ury;

        PdfImportedLink(PdfDictionary pdfDictionary) {
            this.parameters.putAll(pdfDictionary.hashMap);
            try {
                this.destination = (PdfArray) this.parameters.remove(PdfName.DEST);
                PdfArray pdfArray = this.destination;
                if (pdfArray != null) {
                    this.destination = new PdfArray(pdfArray);
                }
                PdfArray pdfArray2 = (PdfArray) this.parameters.remove(PdfName.RECT);
                this.llx = pdfArray2.getAsNumber(0).floatValue();
                this.lly = pdfArray2.getAsNumber(1).floatValue();
                this.urx = pdfArray2.getAsNumber(2).floatValue();
                this.ury = pdfArray2.getAsNumber(3).floatValue();
            } catch (ClassCastException unused) {
                throw new IllegalArgumentException("You have to consolidate the named destinations of your reader.");
            }
        }

        public boolean isInternal() {
            return this.destination != null;
        }

        public int getDestinationPage() {
            if (!isInternal()) {
                return 0;
            }
            PRIndirectReference pRIndirectReference = (PRIndirectReference) this.destination.getAsIndirectObject(0);
            PdfReader reader = pRIndirectReference.getReader();
            for (int i = 1; i <= reader.getNumberOfPages(); i++) {
                PRIndirectReference pageOrigRef = reader.getPageOrigRef(i);
                if (pageOrigRef.getGeneration() == pRIndirectReference.getGeneration() && pageOrigRef.getNumber() == pRIndirectReference.getNumber()) {
                    return i;
                }
            }
            throw new IllegalArgumentException("Page not found.");
        }

        public void setDestinationPage(int i) {
            if (isInternal()) {
                this.newPage = i;
                return;
            }
            throw new IllegalArgumentException("Cannot change destination of external link");
        }

        public void transformDestination(float f, float f2, float f3, float f4, float f5, float f6) {
            if (!isInternal()) {
                throw new IllegalArgumentException("Cannot change destination of external link");
            } else if (this.destination.getAsName(1).equals(PdfName.XYZ)) {
                float floatValue = this.destination.getAsNumber(2).floatValue();
                float floatValue2 = this.destination.getAsNumber(3).floatValue();
                this.destination.set(2, new PdfNumber((f * floatValue) + (f3 * floatValue2) + f5));
                this.destination.set(3, new PdfNumber((floatValue * f2) + (floatValue2 * f4) + f6));
            }
        }

        public void transformRect(float f, float f2, float f3, float f4, float f5, float f6) {
            float f7 = this.llx;
            float f8 = this.lly;
            this.llx = (f7 * f) + (f8 * f3) + f5;
            this.lly = (f7 * f2) + (f8 * f4) + f6;
            float f9 = this.urx;
            float f10 = this.ury;
            this.urx = (f * f9) + (f3 * f10) + f5;
            this.ury = (f9 * f2) + (f10 * f4) + f6;
        }

        public PdfAnnotation createAnnotation(PdfWriter pdfWriter) {
            PdfAnnotation pdfAnnotation = new PdfAnnotation(pdfWriter, new Rectangle(this.llx, this.lly, this.urx, this.ury));
            int i = this.newPage;
            if (i != 0) {
                this.destination.set(0, pdfWriter.getPageReference(i));
            }
            if (this.destination != null) {
                pdfAnnotation.put(PdfName.DEST, this.destination);
            }
            pdfAnnotation.hashMap.putAll(this.parameters);
            return pdfAnnotation;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer("Imported link: location [");
            stringBuffer.append(this.llx);
            stringBuffer.append(' ');
            stringBuffer.append(this.lly);
            stringBuffer.append(' ');
            stringBuffer.append(this.urx);
            stringBuffer.append(' ');
            stringBuffer.append(this.ury);
            stringBuffer.append("] destination ");
            stringBuffer.append(this.destination);
            stringBuffer.append(" parameters ");
            stringBuffer.append(this.parameters);
            return stringBuffer.toString();
        }
    }
}
