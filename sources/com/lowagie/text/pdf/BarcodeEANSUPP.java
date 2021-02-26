package com.lowagie.text.pdf;

import com.lowagie.text.Rectangle;
import harmony.java.awt.Color;

public class BarcodeEANSUPP extends Barcode {
    protected Barcode ean;
    protected Barcode supp;

    public BarcodeEANSUPP(Barcode barcode, Barcode barcode2) {
        this.f610n = 8.0f;
        this.ean = barcode;
        this.supp = barcode2;
    }

    public Rectangle getBarcodeSize() {
        Rectangle barcodeSize = this.ean.getBarcodeSize();
        barcodeSize.setRight(barcodeSize.getWidth() + this.supp.getBarcodeSize().getWidth() + this.f610n);
        return barcodeSize;
    }

    public Rectangle placeBarcode(PdfContentByte pdfContentByte, Color color, Color color2) {
        if (this.supp.getFont() != null) {
            this.supp.setBarHeight((this.ean.getBarHeight() + this.supp.getBaseline()) - this.supp.getFont().getFontDescriptor(2, this.supp.getSize()));
        } else {
            this.supp.setBarHeight(this.ean.getBarHeight());
        }
        Rectangle barcodeSize = this.ean.getBarcodeSize();
        pdfContentByte.saveState();
        this.ean.placeBarcode(pdfContentByte, color, color2);
        pdfContentByte.restoreState();
        pdfContentByte.saveState();
        pdfContentByte.concatCTM(1.0f, 0.0f, 0.0f, 1.0f, barcodeSize.getWidth() + this.f610n, barcodeSize.getHeight() - this.ean.getBarHeight());
        this.supp.placeBarcode(pdfContentByte, color, color2);
        pdfContentByte.restoreState();
        return getBarcodeSize();
    }
}
