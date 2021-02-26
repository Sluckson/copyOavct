package com.lowagie.text.pdf.collection;

import com.lowagie.text.pdf.PdfBoolean;
import com.lowagie.text.pdf.PdfDate;
import com.lowagie.text.pdf.PdfDictionary;
import com.lowagie.text.pdf.PdfName;
import com.lowagie.text.pdf.PdfNumber;
import com.lowagie.text.pdf.PdfObject;
import com.lowagie.text.pdf.PdfString;

public class PdfCollectionField extends PdfDictionary {
    public static final int CREATIONDATE = 6;
    public static final int DATE = 1;
    public static final int DESC = 4;
    public static final int FILENAME = 3;
    public static final int MODDATE = 5;
    public static final int NUMBER = 2;
    public static final int SIZE = 7;
    public static final int TEXT = 0;
    protected int fieldType;

    public PdfCollectionField(String str, int i) {
        super(PdfName.COLLECTIONFIELD);
        put(PdfName.f696N, new PdfString(str, PdfObject.TEXT_UNICODE));
        this.fieldType = i;
        switch (i) {
            case 1:
                put(PdfName.SUBTYPE, PdfName.f661D);
                return;
            case 2:
                put(PdfName.SUBTYPE, PdfName.f696N);
                return;
            case 3:
                put(PdfName.SUBTYPE, PdfName.f673F);
                return;
            case 4:
                put(PdfName.SUBTYPE, PdfName.DESC);
                return;
            case 5:
                put(PdfName.SUBTYPE, PdfName.MODDATE);
                return;
            case 6:
                put(PdfName.SUBTYPE, PdfName.CREATIONDATE);
                return;
            case 7:
                put(PdfName.SUBTYPE, PdfName.SIZE);
                return;
            default:
                put(PdfName.SUBTYPE, PdfName.f719S);
                return;
        }
    }

    public void setOrder(int i) {
        put(PdfName.f703O, new PdfNumber(i));
    }

    public void setVisible(boolean z) {
        put(PdfName.f736V, new PdfBoolean(z));
    }

    public void setEditable(boolean z) {
        put(PdfName.f671E, new PdfBoolean(z));
    }

    public boolean isCollectionItem() {
        int i = this.fieldType;
        return i == 0 || i == 1 || i == 2;
    }

    public PdfObject getValue(String str) {
        int i = this.fieldType;
        if (i == 0) {
            return new PdfString(str, PdfObject.TEXT_UNICODE);
        }
        if (i == 1) {
            return new PdfDate(PdfDate.decode(str));
        }
        if (i == 2) {
            return new PdfNumber(str);
        }
        throw new IllegalArgumentException(String.valueOf(str) + " is not an acceptable value for the field " + get(PdfName.f696N).toString());
    }
}
