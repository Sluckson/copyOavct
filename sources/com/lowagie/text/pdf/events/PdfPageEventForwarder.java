package com.lowagie.text.pdf.events;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPageEvent;
import com.lowagie.text.pdf.PdfWriter;
import java.util.ArrayList;
import java.util.Iterator;

public class PdfPageEventForwarder implements PdfPageEvent {
    protected ArrayList events = new ArrayList();

    public void addPageEvent(PdfPageEvent pdfPageEvent) {
        this.events.add(pdfPageEvent);
    }

    public void onOpenDocument(PdfWriter pdfWriter, Document document) {
        Iterator it = this.events.iterator();
        while (it.hasNext()) {
            ((PdfPageEvent) it.next()).onOpenDocument(pdfWriter, document);
        }
    }

    public void onStartPage(PdfWriter pdfWriter, Document document) {
        Iterator it = this.events.iterator();
        while (it.hasNext()) {
            ((PdfPageEvent) it.next()).onStartPage(pdfWriter, document);
        }
    }

    public void onEndPage(PdfWriter pdfWriter, Document document) {
        Iterator it = this.events.iterator();
        while (it.hasNext()) {
            ((PdfPageEvent) it.next()).onEndPage(pdfWriter, document);
        }
    }

    public void onCloseDocument(PdfWriter pdfWriter, Document document) {
        Iterator it = this.events.iterator();
        while (it.hasNext()) {
            ((PdfPageEvent) it.next()).onCloseDocument(pdfWriter, document);
        }
    }

    public void onParagraph(PdfWriter pdfWriter, Document document, float f) {
        Iterator it = this.events.iterator();
        while (it.hasNext()) {
            ((PdfPageEvent) it.next()).onParagraph(pdfWriter, document, f);
        }
    }

    public void onParagraphEnd(PdfWriter pdfWriter, Document document, float f) {
        Iterator it = this.events.iterator();
        while (it.hasNext()) {
            ((PdfPageEvent) it.next()).onParagraphEnd(pdfWriter, document, f);
        }
    }

    public void onChapter(PdfWriter pdfWriter, Document document, float f, Paragraph paragraph) {
        Iterator it = this.events.iterator();
        while (it.hasNext()) {
            ((PdfPageEvent) it.next()).onChapter(pdfWriter, document, f, paragraph);
        }
    }

    public void onChapterEnd(PdfWriter pdfWriter, Document document, float f) {
        Iterator it = this.events.iterator();
        while (it.hasNext()) {
            ((PdfPageEvent) it.next()).onChapterEnd(pdfWriter, document, f);
        }
    }

    public void onSection(PdfWriter pdfWriter, Document document, float f, int i, Paragraph paragraph) {
        Iterator it = this.events.iterator();
        while (it.hasNext()) {
            ((PdfPageEvent) it.next()).onSection(pdfWriter, document, f, i, paragraph);
        }
    }

    public void onSectionEnd(PdfWriter pdfWriter, Document document, float f) {
        Iterator it = this.events.iterator();
        while (it.hasNext()) {
            ((PdfPageEvent) it.next()).onSectionEnd(pdfWriter, document, f);
        }
    }

    public void onGenericTag(PdfWriter pdfWriter, Document document, Rectangle rectangle, String str) {
        Iterator it = this.events.iterator();
        while (it.hasNext()) {
            ((PdfPageEvent) it.next()).onGenericTag(pdfWriter, document, rectangle, str);
        }
    }
}
