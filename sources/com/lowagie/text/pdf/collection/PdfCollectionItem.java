package com.lowagie.text.pdf.collection;

import com.lowagie.text.pdf.PdfDate;
import com.lowagie.text.pdf.PdfDictionary;
import com.lowagie.text.pdf.PdfName;
import com.lowagie.text.pdf.PdfNumber;
import com.lowagie.text.pdf.PdfObject;
import com.lowagie.text.pdf.PdfString;
import java.util.Calendar;

public class PdfCollectionItem extends PdfDictionary {
    PdfCollectionSchema schema;

    public PdfCollectionItem(PdfCollectionSchema pdfCollectionSchema) {
        super(PdfName.COLLECTIONITEM);
        this.schema = pdfCollectionSchema;
    }

    public void addItem(String str, String str2) {
        PdfName pdfName = new PdfName(str);
        put(pdfName, ((PdfCollectionField) this.schema.get(pdfName)).getValue(str2));
    }

    public void addItem(String str, PdfString pdfString) {
        PdfName pdfName = new PdfName(str);
        if (((PdfCollectionField) this.schema.get(pdfName)).fieldType == 0) {
            put(pdfName, pdfString);
        }
    }

    public void addItem(String str, PdfDate pdfDate) {
        PdfName pdfName = new PdfName(str);
        if (((PdfCollectionField) this.schema.get(pdfName)).fieldType == 1) {
            put(pdfName, pdfDate);
        }
    }

    public void addItem(String str, PdfNumber pdfNumber) {
        PdfName pdfName = new PdfName(str);
        if (((PdfCollectionField) this.schema.get(pdfName)).fieldType == 2) {
            put(pdfName, pdfNumber);
        }
    }

    public void addItem(String str, Calendar calendar) {
        addItem(str, new PdfDate(calendar));
    }

    public void addItem(String str, int i) {
        addItem(str, new PdfNumber(i));
    }

    public void addItem(String str, float f) {
        addItem(str, new PdfNumber(f));
    }

    public void addItem(String str, double d) {
        addItem(str, new PdfNumber(d));
    }

    public void setPrefix(String str, String str2) {
        PdfName pdfName = new PdfName(str);
        PdfObject pdfObject = get(pdfName);
        if (pdfObject != null) {
            PdfDictionary pdfDictionary = new PdfDictionary(PdfName.COLLECTIONSUBITEM);
            pdfDictionary.put(PdfName.f661D, pdfObject);
            pdfDictionary.put(PdfName.f707P, new PdfString(str2, PdfObject.TEXT_UNICODE));
            put(pdfName, pdfDictionary);
            return;
        }
        throw new IllegalArgumentException("You must set a value before adding a prefix.");
    }
}
