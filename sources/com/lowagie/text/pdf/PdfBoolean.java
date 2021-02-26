package com.lowagie.text.pdf;

public class PdfBoolean extends PdfObject {
    public static final String FALSE = "false";
    public static final PdfBoolean PDFFALSE = new PdfBoolean(false);
    public static final PdfBoolean PDFTRUE = new PdfBoolean(true);
    public static final String TRUE = "true";
    private boolean value;

    public PdfBoolean(boolean z) {
        super(1);
        if (z) {
            setContent("true");
        } else {
            setContent(FALSE);
        }
        this.value = z;
    }

    public PdfBoolean(String str) throws BadPdfFormatException {
        super(1, str);
        if (str.equals("true")) {
            this.value = true;
        } else if (str.equals(FALSE)) {
            this.value = false;
        } else {
            throw new BadPdfFormatException("The value has to be 'true' of 'false', instead of '" + str + "'.");
        }
    }

    public boolean booleanValue() {
        return this.value;
    }

    public String toString() {
        return this.value ? "true" : FALSE;
    }
}
