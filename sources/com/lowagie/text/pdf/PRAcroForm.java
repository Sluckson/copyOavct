package com.lowagie.text.pdf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.ListIterator;

public class PRAcroForm extends PdfDictionary {
    HashMap fieldByName = new HashMap();
    ArrayList fields = new ArrayList();
    PdfReader reader;
    ArrayList stack = new ArrayList();

    public static class FieldInformation {
        PdfDictionary info;
        String name;
        PRIndirectReference ref;

        FieldInformation(String str, PdfDictionary pdfDictionary, PRIndirectReference pRIndirectReference) {
            this.name = str;
            this.info = pdfDictionary;
            this.ref = pRIndirectReference;
        }

        public String getName() {
            return this.name;
        }

        public PdfDictionary getInfo() {
            return this.info;
        }

        public PRIndirectReference getRef() {
            return this.ref;
        }
    }

    public PRAcroForm(PdfReader pdfReader) {
        this.reader = pdfReader;
    }

    public int size() {
        return this.fields.size();
    }

    public ArrayList getFields() {
        return this.fields;
    }

    public FieldInformation getField(String str) {
        return (FieldInformation) this.fieldByName.get(str);
    }

    public PRIndirectReference getRefByName(String str) {
        FieldInformation fieldInformation = (FieldInformation) this.fieldByName.get(str);
        if (fieldInformation == null) {
            return null;
        }
        return fieldInformation.getRef();
    }

    public void readAcroForm(PdfDictionary pdfDictionary) {
        if (pdfDictionary != null) {
            this.hashMap = pdfDictionary.hashMap;
            pushAttrib(pdfDictionary);
            iterateFields((PdfArray) PdfReader.getPdfObjectRelease(pdfDictionary.get(PdfName.FIELDS)), (PRIndirectReference) null, (String) null);
        }
    }

    /* access modifiers changed from: protected */
    public void iterateFields(PdfArray pdfArray, PRIndirectReference pRIndirectReference, String str) {
        String str2;
        ListIterator listIterator = pdfArray.listIterator();
        while (listIterator.hasNext()) {
            PRIndirectReference pRIndirectReference2 = (PRIndirectReference) listIterator.next();
            PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.getPdfObjectRelease((PdfObject) pRIndirectReference2);
            PdfString pdfString = (PdfString) pdfDictionary.get(PdfName.f723T);
            boolean z = pdfString != null;
            if (!z) {
                pRIndirectReference2 = pRIndirectReference;
                str2 = str;
            } else if (str == null) {
                str2 = pdfString.toString();
            } else {
                str2 = String.valueOf(str) + '.' + pdfString.toString();
            }
            PdfArray pdfArray2 = (PdfArray) pdfDictionary.get(PdfName.KIDS);
            if (pdfArray2 != null) {
                pushAttrib(pdfDictionary);
                iterateFields(pdfArray2, pRIndirectReference2, str2);
                ArrayList arrayList = this.stack;
                arrayList.remove(arrayList.size() - 1);
            } else if (pRIndirectReference2 != null) {
                ArrayList arrayList2 = this.stack;
                PdfDictionary pdfDictionary2 = (PdfDictionary) arrayList2.get(arrayList2.size() - 1);
                if (z) {
                    pdfDictionary2 = mergeAttrib(pdfDictionary2, pdfDictionary);
                }
                pdfDictionary2.put(PdfName.f723T, new PdfString(str2));
                FieldInformation fieldInformation = new FieldInformation(str2, pdfDictionary2, pRIndirectReference2);
                this.fields.add(fieldInformation);
                this.fieldByName.put(str2, fieldInformation);
            }
        }
    }

    /* access modifiers changed from: protected */
    public PdfDictionary mergeAttrib(PdfDictionary pdfDictionary, PdfDictionary pdfDictionary2) {
        PdfDictionary pdfDictionary3 = new PdfDictionary();
        if (pdfDictionary != null) {
            pdfDictionary3.putAll(pdfDictionary);
        }
        for (PdfName pdfName : pdfDictionary2.getKeys()) {
            if (pdfName.equals(PdfName.f667DR) || pdfName.equals(PdfName.f662DA) || pdfName.equals(PdfName.f714Q) || pdfName.equals(PdfName.f675FF) || pdfName.equals(PdfName.f669DV) || pdfName.equals(PdfName.f736V) || pdfName.equals(PdfName.f678FT) || pdfName.equals(PdfName.f673F)) {
                pdfDictionary3.put(pdfName, pdfDictionary2.get(pdfName));
            }
        }
        return pdfDictionary3;
    }

    /* access modifiers changed from: protected */
    public void pushAttrib(PdfDictionary pdfDictionary) {
        PdfDictionary pdfDictionary2;
        if (!this.stack.isEmpty()) {
            ArrayList arrayList = this.stack;
            pdfDictionary2 = (PdfDictionary) arrayList.get(arrayList.size() - 1);
        } else {
            pdfDictionary2 = null;
        }
        this.stack.add(mergeAttrib(pdfDictionary2, pdfDictionary));
    }
}
