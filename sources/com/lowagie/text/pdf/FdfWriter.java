package com.lowagie.text.pdf;

import com.lowagie.text.DocWriter;
import com.lowagie.text.pdf.AcroFields;
import com.lowagie.text.pdf.PdfWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class FdfWriter {
    /* access modifiers changed from: private */
    public static final byte[] HEADER_FDF = DocWriter.getISOBytes("%FDF-1.2\n%âãÏÓ\n");
    HashMap fields = new HashMap();
    /* access modifiers changed from: private */
    public String file;

    public void writeTo(OutputStream outputStream) throws IOException {
        new Wrt(outputStream, this).writeTo();
    }

    /* access modifiers changed from: package-private */
    public boolean setField(String str, PdfObject pdfObject) {
        HashMap hashMap = this.fields;
        StringTokenizer stringTokenizer = new StringTokenizer(str, ".");
        if (!stringTokenizer.hasMoreTokens()) {
            return false;
        }
        while (true) {
            String nextToken = stringTokenizer.nextToken();
            Object obj = hashMap.get(nextToken);
            if (stringTokenizer.hasMoreTokens()) {
                if (obj == null) {
                    HashMap hashMap2 = new HashMap();
                    hashMap.put(nextToken, hashMap2);
                    hashMap = hashMap2;
                } else if (!(obj instanceof HashMap)) {
                    return false;
                } else {
                    hashMap = (HashMap) obj;
                }
            } else if (obj instanceof HashMap) {
                return false;
            } else {
                hashMap.put(nextToken, pdfObject);
                return true;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void iterateFields(HashMap hashMap, HashMap hashMap2, String str) {
        for (Map.Entry entry : hashMap2.entrySet()) {
            String str2 = (String) entry.getKey();
            Object value = entry.getValue();
            if (value instanceof HashMap) {
                iterateFields(hashMap, (HashMap) value, String.valueOf(str) + "." + str2);
            } else {
                hashMap.put((String.valueOf(str) + "." + str2).substring(1), value);
            }
        }
    }

    public boolean removeField(String str) {
        HashMap hashMap = this.fields;
        StringTokenizer stringTokenizer = new StringTokenizer(str, ".");
        if (!stringTokenizer.hasMoreTokens()) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        while (true) {
            String nextToken = stringTokenizer.nextToken();
            Object obj = hashMap.get(nextToken);
            if (obj == null) {
                return false;
            }
            arrayList.add(hashMap);
            arrayList.add(nextToken);
            if (stringTokenizer.hasMoreTokens()) {
                if (!(obj instanceof HashMap)) {
                    return false;
                }
                hashMap = (HashMap) obj;
            } else if (obj instanceof HashMap) {
                return false;
            } else {
                for (int size = arrayList.size() - 2; size >= 0; size -= 2) {
                    HashMap hashMap2 = (HashMap) arrayList.get(size);
                    hashMap2.remove((String) arrayList.get(size + 1));
                    if (!hashMap2.isEmpty()) {
                        return true;
                    }
                }
                return true;
            }
        }
    }

    public HashMap getFields() {
        HashMap hashMap = new HashMap();
        iterateFields(hashMap, this.fields, "");
        return hashMap;
    }

    public String getField(String str) {
        HashMap hashMap = this.fields;
        StringTokenizer stringTokenizer = new StringTokenizer(str, ".");
        if (!stringTokenizer.hasMoreTokens()) {
            return null;
        }
        while (true) {
            Object obj = hashMap.get(stringTokenizer.nextToken());
            if (obj == null) {
                return null;
            }
            if (stringTokenizer.hasMoreTokens()) {
                if (!(obj instanceof HashMap)) {
                    return null;
                }
                hashMap = (HashMap) obj;
            } else if (obj instanceof HashMap) {
                return null;
            } else {
                if (((PdfObject) obj).isString()) {
                    return ((PdfString) obj).toUnicodeString();
                }
                return PdfName.decodeName(obj.toString());
            }
        }
    }

    public boolean setFieldAsName(String str, String str2) {
        return setField(str, new PdfName(str2));
    }

    public boolean setFieldAsString(String str, String str2) {
        return setField(str, new PdfString(str2, PdfObject.TEXT_UNICODE));
    }

    public boolean setFieldAsAction(String str, PdfAction pdfAction) {
        return setField(str, pdfAction);
    }

    public void setFields(FdfReader fdfReader) {
        for (Map.Entry entry : fdfReader.getFields().entrySet()) {
            String str = (String) entry.getKey();
            PdfDictionary pdfDictionary = (PdfDictionary) entry.getValue();
            PdfObject pdfObject = pdfDictionary.get(PdfName.f736V);
            if (pdfObject != null) {
                setField(str, pdfObject);
            }
            PdfObject pdfObject2 = pdfDictionary.get(PdfName.f641A);
            if (pdfObject2 != null) {
                setField(str, pdfObject2);
            }
        }
    }

    public void setFields(PdfReader pdfReader) {
        setFields(pdfReader.getAcroFields());
    }

    public void setFields(AcroFields acroFields) {
        PdfObject pdfObjectRelease;
        for (Map.Entry entry : acroFields.getFields().entrySet()) {
            String str = (String) entry.getKey();
            PdfDictionary merged = ((AcroFields.Item) entry.getValue()).getMerged(0);
            PdfObject pdfObjectRelease2 = PdfReader.getPdfObjectRelease(merged.get(PdfName.f736V));
            if (!(pdfObjectRelease2 == null || (pdfObjectRelease = PdfReader.getPdfObjectRelease(merged.get(PdfName.f678FT))) == null || PdfName.SIG.equals(pdfObjectRelease))) {
                setField(str, pdfObjectRelease2);
            }
        }
    }

    public String getFile() {
        return this.file;
    }

    public void setFile(String str) {
        this.file = str;
    }

    static class Wrt extends PdfWriter {
        private FdfWriter fdf;

        Wrt(OutputStream outputStream, FdfWriter fdfWriter) throws IOException {
            super(new PdfDocument(), outputStream);
            this.fdf = fdfWriter;
            this.f571os.write(FdfWriter.HEADER_FDF);
            this.body = new PdfWriter.PdfBody(this);
        }

        /* access modifiers changed from: package-private */
        public void writeTo() throws IOException {
            PdfDictionary pdfDictionary = new PdfDictionary();
            pdfDictionary.put(PdfName.FIELDS, calculate(this.fdf.fields));
            if (this.fdf.file != null) {
                pdfDictionary.put(PdfName.f673F, new PdfString(this.fdf.file, PdfObject.TEXT_UNICODE));
            }
            PdfDictionary pdfDictionary2 = new PdfDictionary();
            pdfDictionary2.put(PdfName.FDF, pdfDictionary);
            PdfIndirectReference indirectReference = addToBody(pdfDictionary2).getIndirectReference();
            this.f571os.write(getISOBytes("trailer\n"));
            PdfDictionary pdfDictionary3 = new PdfDictionary();
            pdfDictionary3.put(PdfName.ROOT, indirectReference);
            pdfDictionary3.toPdf((PdfWriter) null, this.f571os);
            this.f571os.write(getISOBytes("\n%%EOF\n"));
            this.f571os.close();
        }

        /* access modifiers changed from: package-private */
        public PdfArray calculate(HashMap hashMap) throws IOException {
            PdfArray pdfArray = new PdfArray();
            for (Map.Entry entry : hashMap.entrySet()) {
                Object value = entry.getValue();
                PdfDictionary pdfDictionary = new PdfDictionary();
                pdfDictionary.put(PdfName.f723T, new PdfString((String) entry.getKey(), PdfObject.TEXT_UNICODE));
                if (value instanceof HashMap) {
                    pdfDictionary.put(PdfName.KIDS, calculate((HashMap) value));
                } else if (value instanceof PdfAction) {
                    pdfDictionary.put(PdfName.f641A, (PdfAction) value);
                } else {
                    pdfDictionary.put(PdfName.f736V, (PdfObject) value);
                }
                pdfArray.add((PdfObject) pdfDictionary);
            }
            return pdfArray;
        }
    }
}
