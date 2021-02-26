package com.lowagie.text.pdf;

import com.lowagie.text.DocumentException;
import java.io.OutputStream;

class PdfCopyFormsImp extends PdfCopyFieldsImp {
    PdfCopyFormsImp(OutputStream outputStream) throws DocumentException {
        super(outputStream);
    }

    public void copyDocumentFields(PdfReader pdfReader) throws DocumentException {
        if (pdfReader.isOpenedWithFullPermissions()) {
            if (this.readers2intrefs.containsKey(pdfReader)) {
                pdfReader = new PdfReader(pdfReader);
            } else if (!pdfReader.isTampered()) {
                pdfReader.consolidateNamedDestinations();
                pdfReader.setTampered(true);
            } else {
                throw new DocumentException("The document was reused.");
            }
            pdfReader.shuffleSubsetNames();
            this.readers2intrefs.put(pdfReader, new IntHashtable());
            this.fields.add(pdfReader.getAcroFields());
            updateCalculationOrder(pdfReader);
            return;
        }
        throw new IllegalArgumentException("PdfReader not opened with owner password");
    }

    /* access modifiers changed from: package-private */
    public void mergeFields() {
        for (int i = 0; i < this.fields.size(); i++) {
            mergeWithMaster(((AcroFields) this.fields.get(i)).getFields());
        }
    }
}
