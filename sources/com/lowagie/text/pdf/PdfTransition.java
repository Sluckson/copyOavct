package com.lowagie.text.pdf;

import com.lowagie.text.pdf.codec.TIFFConstants;

public class PdfTransition {
    public static final int BLINDH = 6;
    public static final int BLINDV = 5;
    public static final int BTWIPE = 11;
    public static final int DGLITTER = 16;
    public static final int DISSOLVE = 13;
    public static final int INBOX = 7;
    public static final int LRGLITTER = 14;
    public static final int LRWIPE = 9;
    public static final int OUTBOX = 8;
    public static final int RLWIPE = 10;
    public static final int SPLITHIN = 4;
    public static final int SPLITHOUT = 2;
    public static final int SPLITVIN = 3;
    public static final int SPLITVOUT = 1;
    public static final int TBGLITTER = 15;
    public static final int TBWIPE = 12;
    protected int duration;
    protected int type;

    public PdfTransition() {
        this(6);
    }

    public PdfTransition(int i) {
        this(i, 1);
    }

    public PdfTransition(int i, int i2) {
        this.duration = i2;
        this.type = i;
    }

    public int getDuration() {
        return this.duration;
    }

    public int getType() {
        return this.type;
    }

    public PdfDictionary getTransitionDictionary() {
        PdfDictionary pdfDictionary = new PdfDictionary(PdfName.TRANS);
        switch (this.type) {
            case 1:
                pdfDictionary.put(PdfName.f719S, PdfName.SPLIT);
                pdfDictionary.put(PdfName.f661D, new PdfNumber(this.duration));
                pdfDictionary.put(PdfName.f665DM, PdfName.f736V);
                pdfDictionary.put(PdfName.f694M, PdfName.f703O);
                break;
            case 2:
                pdfDictionary.put(PdfName.f719S, PdfName.SPLIT);
                pdfDictionary.put(PdfName.f661D, new PdfNumber(this.duration));
                pdfDictionary.put(PdfName.f665DM, PdfName.f679H);
                pdfDictionary.put(PdfName.f694M, PdfName.f703O);
                break;
            case 3:
                pdfDictionary.put(PdfName.f719S, PdfName.SPLIT);
                pdfDictionary.put(PdfName.f661D, new PdfNumber(this.duration));
                pdfDictionary.put(PdfName.f665DM, PdfName.f736V);
                pdfDictionary.put(PdfName.f694M, PdfName.f686I);
                break;
            case 4:
                pdfDictionary.put(PdfName.f719S, PdfName.SPLIT);
                pdfDictionary.put(PdfName.f661D, new PdfNumber(this.duration));
                pdfDictionary.put(PdfName.f665DM, PdfName.f679H);
                pdfDictionary.put(PdfName.f694M, PdfName.f686I);
                break;
            case 5:
                pdfDictionary.put(PdfName.f719S, PdfName.BLINDS);
                pdfDictionary.put(PdfName.f661D, new PdfNumber(this.duration));
                pdfDictionary.put(PdfName.f665DM, PdfName.f736V);
                break;
            case 6:
                pdfDictionary.put(PdfName.f719S, PdfName.BLINDS);
                pdfDictionary.put(PdfName.f661D, new PdfNumber(this.duration));
                pdfDictionary.put(PdfName.f665DM, PdfName.f679H);
                break;
            case 7:
                pdfDictionary.put(PdfName.f719S, PdfName.BOX);
                pdfDictionary.put(PdfName.f661D, new PdfNumber(this.duration));
                pdfDictionary.put(PdfName.f694M, PdfName.f686I);
                break;
            case 8:
                pdfDictionary.put(PdfName.f719S, PdfName.BOX);
                pdfDictionary.put(PdfName.f661D, new PdfNumber(this.duration));
                pdfDictionary.put(PdfName.f694M, PdfName.f703O);
                break;
            case 9:
                pdfDictionary.put(PdfName.f719S, PdfName.WIPE);
                pdfDictionary.put(PdfName.f661D, new PdfNumber(this.duration));
                pdfDictionary.put(PdfName.f664DI, new PdfNumber(0));
                break;
            case 10:
                pdfDictionary.put(PdfName.f719S, PdfName.WIPE);
                pdfDictionary.put(PdfName.f661D, new PdfNumber(this.duration));
                pdfDictionary.put(PdfName.f664DI, new PdfNumber(180));
                break;
            case 11:
                pdfDictionary.put(PdfName.f719S, PdfName.WIPE);
                pdfDictionary.put(PdfName.f661D, new PdfNumber(this.duration));
                pdfDictionary.put(PdfName.f664DI, new PdfNumber(90));
                break;
            case 12:
                pdfDictionary.put(PdfName.f719S, PdfName.WIPE);
                pdfDictionary.put(PdfName.f661D, new PdfNumber(this.duration));
                pdfDictionary.put(PdfName.f664DI, new PdfNumber((int) TIFFConstants.TIFFTAG_IMAGEDESCRIPTION));
                break;
            case 13:
                pdfDictionary.put(PdfName.f719S, PdfName.DISSOLVE);
                pdfDictionary.put(PdfName.f661D, new PdfNumber(this.duration));
                break;
            case 14:
                pdfDictionary.put(PdfName.f719S, PdfName.GLITTER);
                pdfDictionary.put(PdfName.f661D, new PdfNumber(this.duration));
                pdfDictionary.put(PdfName.f664DI, new PdfNumber(0));
                break;
            case 15:
                pdfDictionary.put(PdfName.f719S, PdfName.GLITTER);
                pdfDictionary.put(PdfName.f661D, new PdfNumber(this.duration));
                pdfDictionary.put(PdfName.f664DI, new PdfNumber((int) TIFFConstants.TIFFTAG_IMAGEDESCRIPTION));
                break;
            case 16:
                pdfDictionary.put(PdfName.f719S, PdfName.GLITTER);
                pdfDictionary.put(PdfName.f661D, new PdfNumber(this.duration));
                pdfDictionary.put(PdfName.f664DI, new PdfNumber((int) TIFFConstants.TIFFTAG_ARTIST));
                break;
        }
        return pdfDictionary;
    }
}
