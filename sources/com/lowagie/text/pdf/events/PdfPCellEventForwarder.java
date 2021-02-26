package com.lowagie.text.pdf.events;

import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPCellEvent;
import java.util.ArrayList;
import java.util.Iterator;

public class PdfPCellEventForwarder implements PdfPCellEvent {
    protected ArrayList events = new ArrayList();

    public void addCellEvent(PdfPCellEvent pdfPCellEvent) {
        this.events.add(pdfPCellEvent);
    }

    public void cellLayout(PdfPCell pdfPCell, Rectangle rectangle, PdfContentByte[] pdfContentByteArr) {
        Iterator it = this.events.iterator();
        while (it.hasNext()) {
            ((PdfPCellEvent) it.next()).cellLayout(pdfPCell, rectangle, pdfContentByteArr);
        }
    }
}
