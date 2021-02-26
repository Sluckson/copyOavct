package com.lowagie.text.pdf.internal;

import com.lowagie.text.Annotation;
import com.lowagie.text.ExceptionConverter;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfAcroForm;
import com.lowagie.text.pdf.PdfAction;
import com.lowagie.text.pdf.PdfAnnotation;
import com.lowagie.text.pdf.PdfArray;
import com.lowagie.text.pdf.PdfFileSpecification;
import com.lowagie.text.pdf.PdfFormField;
import com.lowagie.text.pdf.PdfName;
import com.lowagie.text.pdf.PdfObject;
import com.lowagie.text.pdf.PdfRectangle;
import com.lowagie.text.pdf.PdfString;
import com.lowagie.text.pdf.PdfWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class PdfAnnotationsImp {
    protected PdfAcroForm acroForm;
    protected ArrayList annotations;
    protected ArrayList delayedAnnotations = new ArrayList();

    public PdfAnnotationsImp(PdfWriter pdfWriter) {
        this.acroForm = new PdfAcroForm(pdfWriter);
    }

    public boolean hasValidAcroForm() {
        return this.acroForm.isValid();
    }

    public PdfAcroForm getAcroForm() {
        return this.acroForm;
    }

    public void setSigFlags(int i) {
        this.acroForm.setSigFlags(i);
    }

    public void addCalculationOrder(PdfFormField pdfFormField) {
        this.acroForm.addCalculationOrder(pdfFormField);
    }

    public void addAnnotation(PdfAnnotation pdfAnnotation) {
        if (pdfAnnotation.isForm()) {
            PdfFormField pdfFormField = (PdfFormField) pdfAnnotation;
            if (pdfFormField.getParent() == null) {
                addFormFieldRaw(pdfFormField);
                return;
            }
            return;
        }
        this.annotations.add(pdfAnnotation);
    }

    public void addPlainAnnotation(PdfAnnotation pdfAnnotation) {
        this.annotations.add(pdfAnnotation);
    }

    /* access modifiers changed from: package-private */
    public void addFormFieldRaw(PdfFormField pdfFormField) {
        this.annotations.add(pdfFormField);
        ArrayList kids = pdfFormField.getKids();
        if (kids != null) {
            for (int i = 0; i < kids.size(); i++) {
                addFormFieldRaw((PdfFormField) kids.get(i));
            }
        }
    }

    public boolean hasUnusedAnnotations() {
        return !this.annotations.isEmpty();
    }

    public void resetAnnotations() {
        this.annotations = this.delayedAnnotations;
        this.delayedAnnotations = new ArrayList();
    }

    public PdfArray rotateAnnotations(PdfWriter pdfWriter, Rectangle rectangle) {
        PdfRectangle pdfRectangle;
        HashMap templates;
        PdfArray pdfArray = new PdfArray();
        int rotation = rectangle.getRotation() % 360;
        int currentPageNumber = pdfWriter.getCurrentPageNumber();
        for (int i = 0; i < this.annotations.size(); i++) {
            PdfAnnotation pdfAnnotation = (PdfAnnotation) this.annotations.get(i);
            if (pdfAnnotation.getPlaceInPage() > currentPageNumber) {
                this.delayedAnnotations.add(pdfAnnotation);
            } else {
                if (pdfAnnotation.isForm()) {
                    if (!pdfAnnotation.isUsed() && (templates = pdfAnnotation.getTemplates()) != null) {
                        this.acroForm.addFieldTemplates(templates);
                    }
                    PdfFormField pdfFormField = (PdfFormField) pdfAnnotation;
                    if (pdfFormField.getParent() == null) {
                        this.acroForm.addDocumentField(pdfFormField.getIndirectReference());
                    }
                }
                if (pdfAnnotation.isAnnotation()) {
                    pdfArray.add((PdfObject) pdfAnnotation.getIndirectReference());
                    if (!pdfAnnotation.isUsed() && (pdfRectangle = (PdfRectangle) pdfAnnotation.get(PdfName.RECT)) != null) {
                        if (rotation == 90) {
                            pdfAnnotation.put(PdfName.RECT, new PdfRectangle(rectangle.getTop() - pdfRectangle.bottom(), pdfRectangle.left(), rectangle.getTop() - pdfRectangle.top(), pdfRectangle.right()));
                        } else if (rotation == 180) {
                            pdfAnnotation.put(PdfName.RECT, new PdfRectangle(rectangle.getRight() - pdfRectangle.left(), rectangle.getTop() - pdfRectangle.bottom(), rectangle.getRight() - pdfRectangle.right(), rectangle.getTop() - pdfRectangle.top()));
                        } else if (rotation == 270) {
                            pdfAnnotation.put(PdfName.RECT, new PdfRectangle(pdfRectangle.bottom(), rectangle.getRight() - pdfRectangle.left(), pdfRectangle.top(), rectangle.getRight() - pdfRectangle.right()));
                        }
                    }
                }
                if (!pdfAnnotation.isUsed()) {
                    pdfAnnotation.setUsed();
                    try {
                        pdfWriter.addToBody((PdfObject) pdfAnnotation, pdfAnnotation.getIndirectReference());
                    } catch (IOException e) {
                        throw new ExceptionConverter(e);
                    }
                }
            }
        }
        return pdfArray;
    }

    public static PdfAnnotation convertAnnotation(PdfWriter pdfWriter, Annotation annotation, Rectangle rectangle) throws IOException {
        PdfFileSpecification pdfFileSpecification;
        switch (annotation.annotationType()) {
            case 1:
                return new PdfAnnotation(pdfWriter, annotation.llx(), annotation.lly(), annotation.urx(), annotation.ury(), new PdfAction((URL) annotation.attributes().get("url")));
            case 2:
                return new PdfAnnotation(pdfWriter, annotation.llx(), annotation.lly(), annotation.urx(), annotation.ury(), new PdfAction((String) annotation.attributes().get("file")));
            case 3:
                return new PdfAnnotation(pdfWriter, annotation.llx(), annotation.lly(), annotation.urx(), annotation.ury(), new PdfAction((String) annotation.attributes().get("file"), (String) annotation.attributes().get("destination")));
            case 4:
                return new PdfAnnotation(pdfWriter, annotation.llx(), annotation.lly(), annotation.urx(), annotation.ury(), new PdfAction((String) annotation.attributes().get("file"), ((Integer) annotation.attributes().get("page")).intValue()));
            case 5:
                return new PdfAnnotation(pdfWriter, annotation.llx(), annotation.lly(), annotation.urx(), annotation.ury(), new PdfAction(((Integer) annotation.attributes().get("named")).intValue()));
            case 6:
                return new PdfAnnotation(pdfWriter, annotation.llx(), annotation.lly(), annotation.urx(), annotation.ury(), new PdfAction((String) annotation.attributes().get("application"), (String) annotation.attributes().get("parameters"), (String) annotation.attributes().get("operation"), (String) annotation.attributes().get("defaultdir")));
            case 7:
                boolean[] zArr = (boolean[]) annotation.attributes().get("parameters");
                String str = (String) annotation.attributes().get("file");
                String str2 = (String) annotation.attributes().get(Annotation.MIMETYPE);
                if (zArr[0]) {
                    pdfFileSpecification = PdfFileSpecification.fileEmbedded(pdfWriter, str, str, (byte[]) null);
                } else {
                    pdfFileSpecification = PdfFileSpecification.fileExtern(pdfWriter, str);
                }
                return PdfAnnotation.createScreen(pdfWriter, new Rectangle(annotation.llx(), annotation.lly(), annotation.urx(), annotation.ury()), str, pdfFileSpecification, str2, zArr[1]);
            default:
                return new PdfAnnotation(pdfWriter, rectangle.getLeft(), rectangle.getBottom(), rectangle.getRight(), rectangle.getTop(), new PdfString(annotation.title(), PdfObject.TEXT_UNICODE), new PdfString(annotation.content(), PdfObject.TEXT_UNICODE));
        }
    }
}
