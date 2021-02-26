package com.lowagie.text.pdf.collection;

import com.lowagie.text.pdf.PdfDictionary;
import com.lowagie.text.pdf.PdfName;
import com.lowagie.text.pdf.PdfString;

public class PdfCollection extends PdfDictionary {
    public static final int DETAILS = 0;
    public static final int HIDDEN = 2;
    public static final int TILE = 1;

    public PdfCollection(int i) {
        super(PdfName.COLLECTION);
        if (i == 1) {
            put(PdfName.VIEW, PdfName.f723T);
        } else if (i != 2) {
            put(PdfName.VIEW, PdfName.f661D);
        } else {
            put(PdfName.VIEW, PdfName.f679H);
        }
    }

    public void setInitialDocument(String str) {
        put(PdfName.f661D, new PdfString(str, (String) null));
    }

    public void setSchema(PdfCollectionSchema pdfCollectionSchema) {
        put(PdfName.SCHEMA, pdfCollectionSchema);
    }

    public PdfCollectionSchema getSchema() {
        return (PdfCollectionSchema) get(PdfName.SCHEMA);
    }

    public void setSort(PdfCollectionSort pdfCollectionSort) {
        put(PdfName.SORT, pdfCollectionSort);
    }
}
