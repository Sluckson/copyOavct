package com.lowagie.text.pdf.collection;

import com.lowagie.text.pdf.PdfDictionary;
import com.lowagie.text.pdf.PdfName;
import com.lowagie.text.pdf.PdfNumber;
import com.lowagie.text.pdf.PdfObject;
import com.lowagie.text.pdf.PdfString;

public class PdfTargetDictionary extends PdfDictionary {
    public PdfTargetDictionary(PdfTargetDictionary pdfTargetDictionary) {
        put(PdfName.f715R, PdfName.f707P);
        if (pdfTargetDictionary != null) {
            setAdditionalPath(pdfTargetDictionary);
        }
    }

    public PdfTargetDictionary(boolean z) {
        if (z) {
            put(PdfName.f715R, PdfName.f652C);
        } else {
            put(PdfName.f715R, PdfName.f707P);
        }
    }

    public void setEmbeddedFileName(String str) {
        put(PdfName.f696N, new PdfString(str, (String) null));
    }

    public void setFileAttachmentPagename(String str) {
        put(PdfName.f707P, new PdfString(str, (String) null));
    }

    public void setFileAttachmentPage(int i) {
        put(PdfName.f707P, new PdfNumber(i));
    }

    public void setFileAttachmentName(String str) {
        put(PdfName.f641A, new PdfString(str, PdfObject.TEXT_UNICODE));
    }

    public void setFileAttachmentIndex(int i) {
        put(PdfName.f641A, new PdfNumber(i));
    }

    public void setAdditionalPath(PdfTargetDictionary pdfTargetDictionary) {
        put(PdfName.f723T, pdfTargetDictionary);
    }
}
