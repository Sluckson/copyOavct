package com.lowagie.text.pdf.events;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.ExceptionConverter;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfFormField;
import com.lowagie.text.pdf.PdfName;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPCellEvent;
import com.lowagie.text.pdf.PdfPageEventHelper;
import com.lowagie.text.pdf.PdfRectangle;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.TextField;
import java.io.IOException;
import java.util.HashMap;

public class FieldPositioningEvents extends PdfPageEventHelper implements PdfPCellEvent {
    protected PdfFormField cellField = null;
    protected PdfWriter fieldWriter = null;
    protected HashMap genericChunkFields = new HashMap();
    public float padding;
    protected PdfFormField parent = null;

    public FieldPositioningEvents() {
    }

    public void addField(String str, PdfFormField pdfFormField) {
        this.genericChunkFields.put(str, pdfFormField);
    }

    public FieldPositioningEvents(PdfWriter pdfWriter, PdfFormField pdfFormField) {
        this.cellField = pdfFormField;
        this.fieldWriter = pdfWriter;
    }

    public FieldPositioningEvents(PdfFormField pdfFormField, PdfFormField pdfFormField2) {
        this.cellField = pdfFormField2;
        this.parent = pdfFormField;
    }

    public FieldPositioningEvents(PdfWriter pdfWriter, String str) throws IOException, DocumentException {
        this.fieldWriter = pdfWriter;
        TextField textField = new TextField(pdfWriter, new Rectangle(0.0f, 0.0f), str);
        textField.setFontSize(14.0f);
        this.cellField = textField.getTextField();
    }

    public FieldPositioningEvents(PdfWriter pdfWriter, PdfFormField pdfFormField, String str) throws IOException, DocumentException {
        this.parent = pdfFormField;
        TextField textField = new TextField(pdfWriter, new Rectangle(0.0f, 0.0f), str);
        textField.setFontSize(14.0f);
        this.cellField = textField.getTextField();
    }

    public void setPadding(float f) {
        this.padding = f;
    }

    public void setParent(PdfFormField pdfFormField) {
        this.parent = pdfFormField;
    }

    public void onGenericTag(PdfWriter pdfWriter, Document document, Rectangle rectangle, String str) {
        rectangle.setBottom(rectangle.getBottom() - 3.0f);
        PdfFormField pdfFormField = (PdfFormField) this.genericChunkFields.get(str);
        if (pdfFormField == null) {
            TextField textField = new TextField(pdfWriter, new Rectangle(rectangle.getLeft(this.padding), rectangle.getBottom(this.padding), rectangle.getRight(this.padding), rectangle.getTop(this.padding)), str);
            textField.setFontSize(14.0f);
            try {
                pdfFormField = textField.getTextField();
            } catch (Exception e) {
                throw new ExceptionConverter(e);
            }
        } else {
            pdfFormField.put(PdfName.RECT, new PdfRectangle(rectangle.getLeft(this.padding), rectangle.getBottom(this.padding), rectangle.getRight(this.padding), rectangle.getTop(this.padding)));
        }
        PdfFormField pdfFormField2 = this.parent;
        if (pdfFormField2 == null) {
            pdfWriter.addAnnotation(pdfFormField);
        } else {
            pdfFormField2.addKid(pdfFormField);
        }
    }

    public void cellLayout(PdfPCell pdfPCell, Rectangle rectangle, PdfContentByte[] pdfContentByteArr) {
        if (this.cellField == null || (this.fieldWriter == null && this.parent == null)) {
            throw new ExceptionConverter(new IllegalArgumentException("You have used the wrong constructor for this FieldPositioningEvents class."));
        }
        this.cellField.put(PdfName.RECT, new PdfRectangle(rectangle.getLeft(this.padding), rectangle.getBottom(this.padding), rectangle.getRight(this.padding), rectangle.getTop(this.padding)));
        PdfFormField pdfFormField = this.parent;
        if (pdfFormField == null) {
            this.fieldWriter.addAnnotation(this.cellField);
        } else {
            pdfFormField.addKid(this.cellField);
        }
    }
}
