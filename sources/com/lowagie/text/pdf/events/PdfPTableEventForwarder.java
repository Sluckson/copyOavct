package com.lowagie.text.pdf.events;

import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfPTableEvent;
import java.util.ArrayList;
import java.util.Iterator;

public class PdfPTableEventForwarder implements PdfPTableEvent {
    protected ArrayList events = new ArrayList();

    public void addTableEvent(PdfPTableEvent pdfPTableEvent) {
        this.events.add(pdfPTableEvent);
    }

    public void tableLayout(PdfPTable pdfPTable, float[][] fArr, float[] fArr2, int i, int i2, PdfContentByte[] pdfContentByteArr) {
        Iterator it = this.events.iterator();
        while (it.hasNext()) {
            ((PdfPTableEvent) it.next()).tableLayout(pdfPTable, fArr, fArr2, i, i2, pdfContentByteArr);
        }
    }
}
