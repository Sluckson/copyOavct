package com.lowagie.text.pdf.collection;

import com.lowagie.text.pdf.PdfArray;
import com.lowagie.text.pdf.PdfBoolean;
import com.lowagie.text.pdf.PdfDictionary;
import com.lowagie.text.pdf.PdfName;
import com.lowagie.text.pdf.PdfObject;

public class PdfCollectionSort extends PdfDictionary {
    public PdfCollectionSort(String str) {
        super(PdfName.COLLECTIONSORT);
        put(PdfName.f719S, new PdfName(str));
    }

    public PdfCollectionSort(String[] strArr) {
        super(PdfName.COLLECTIONSORT);
        PdfArray pdfArray = new PdfArray();
        for (String pdfName : strArr) {
            pdfArray.add((PdfObject) new PdfName(pdfName));
        }
        put(PdfName.f719S, pdfArray);
    }

    public void setSortOrder(boolean z) {
        if (get(PdfName.f719S) instanceof PdfName) {
            put(PdfName.f641A, new PdfBoolean(z));
            return;
        }
        throw new IllegalArgumentException("You have to define a boolean array for this collection sort dictionary.");
    }

    public void setSortOrder(boolean[] zArr) {
        PdfObject pdfObject = get(PdfName.f719S);
        if (!(pdfObject instanceof PdfArray)) {
            throw new IllegalArgumentException("You need a single boolean for this collection sort dictionary.");
        } else if (((PdfArray) pdfObject).size() == zArr.length) {
            PdfArray pdfArray = new PdfArray();
            for (boolean pdfBoolean : zArr) {
                pdfArray.add((PdfObject) new PdfBoolean(pdfBoolean));
            }
            put(PdfName.f641A, pdfArray);
        } else {
            throw new IllegalArgumentException("The number of booleans in this array doesn't correspond with the number of fields.");
        }
    }
}
