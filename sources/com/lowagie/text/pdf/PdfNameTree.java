package com.lowagie.text.pdf;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class PdfNameTree {
    private static final int leafSize = 64;

    public static PdfDictionary writeTree(HashMap hashMap, PdfWriter pdfWriter) throws IOException {
        HashMap hashMap2 = hashMap;
        PdfWriter pdfWriter2 = pdfWriter;
        if (hashMap.isEmpty()) {
            return null;
        }
        String[] strArr = (String[]) hashMap.keySet().toArray(new String[hashMap.size()]);
        Arrays.sort(strArr);
        int i = 64;
        if (strArr.length <= 64) {
            PdfDictionary pdfDictionary = new PdfDictionary();
            PdfArray pdfArray = new PdfArray();
            for (int i2 = 0; i2 < strArr.length; i2++) {
                pdfArray.add((PdfObject) new PdfString(strArr[i2], (String) null));
                pdfArray.add((PdfObject) hashMap2.get(strArr[i2]));
            }
            pdfDictionary.put(PdfName.NAMES, pdfArray);
            return pdfDictionary;
        }
        PdfIndirectReference[] pdfIndirectReferenceArr = new PdfIndirectReference[(((strArr.length + 64) - 1) / 64)];
        int i3 = 0;
        while (i3 < pdfIndirectReferenceArr.length) {
            int i4 = i3 * 64;
            int min = Math.min(i4 + 64, strArr.length);
            PdfDictionary pdfDictionary2 = new PdfDictionary();
            PdfArray pdfArray2 = new PdfArray();
            pdfArray2.add((PdfObject) new PdfString(strArr[i4], (String) null));
            pdfArray2.add((PdfObject) new PdfString(strArr[min - 1], (String) null));
            pdfDictionary2.put(PdfName.LIMITS, pdfArray2);
            PdfArray pdfArray3 = new PdfArray();
            while (i4 < min) {
                pdfArray3.add((PdfObject) new PdfString(strArr[i4], (String) null));
                pdfArray3.add((PdfObject) hashMap2.get(strArr[i4]));
                i4++;
            }
            pdfDictionary2.put(PdfName.NAMES, pdfArray3);
            pdfIndirectReferenceArr[i3] = pdfWriter2.addToBody(pdfDictionary2).getIndirectReference();
            i3++;
            i = 64;
        }
        int length = pdfIndirectReferenceArr.length;
        int i5 = 64;
        while (length > i) {
            int i6 = i5 * 64;
            int length2 = ((strArr.length + i6) - 1) / i6;
            int i7 = 0;
            while (i7 < length2) {
                int i8 = i7 * 64;
                int min2 = Math.min(i8 + 64, length);
                PdfDictionary pdfDictionary3 = new PdfDictionary();
                PdfArray pdfArray4 = new PdfArray();
                pdfArray4.add((PdfObject) new PdfString(strArr[i7 * i6], (String) null));
                int i9 = i7 + 1;
                pdfArray4.add((PdfObject) new PdfString(strArr[Math.min(i9 * i6, strArr.length) - 1], (String) null));
                pdfDictionary3.put(PdfName.LIMITS, pdfArray4);
                PdfArray pdfArray5 = new PdfArray();
                while (i8 < min2) {
                    pdfArray5.add((PdfObject) pdfIndirectReferenceArr[i8]);
                    i8++;
                }
                pdfDictionary3.put(PdfName.KIDS, pdfArray5);
                pdfIndirectReferenceArr[i7] = pdfWriter2.addToBody(pdfDictionary3).getIndirectReference();
                i7 = i9;
                i = 64;
            }
            i5 = i6;
            length = length2;
        }
        PdfArray pdfArray6 = new PdfArray();
        for (int i10 = 0; i10 < length; i10++) {
            pdfArray6.add((PdfObject) pdfIndirectReferenceArr[i10]);
        }
        PdfDictionary pdfDictionary4 = new PdfDictionary();
        pdfDictionary4.put(PdfName.KIDS, pdfArray6);
        return pdfDictionary4;
    }

    private static void iterateItems(PdfDictionary pdfDictionary, HashMap hashMap) {
        PdfArray pdfArray = (PdfArray) PdfReader.getPdfObjectRelease(pdfDictionary.get(PdfName.NAMES));
        int i = 0;
        if (pdfArray != null) {
            while (i < pdfArray.size()) {
                int i2 = i + 1;
                hashMap.put(PdfEncodings.convertToString(((PdfString) PdfReader.getPdfObjectRelease(pdfArray.getPdfObject(i))).getBytes(), (String) null), pdfArray.getPdfObject(i2));
                i = i2 + 1;
            }
            return;
        }
        PdfArray pdfArray2 = (PdfArray) PdfReader.getPdfObjectRelease(pdfDictionary.get(PdfName.KIDS));
        if (pdfArray2 != null) {
            while (i < pdfArray2.size()) {
                iterateItems((PdfDictionary) PdfReader.getPdfObjectRelease(pdfArray2.getPdfObject(i)), hashMap);
                i++;
            }
        }
    }

    public static HashMap readTree(PdfDictionary pdfDictionary) {
        HashMap hashMap = new HashMap();
        if (pdfDictionary != null) {
            iterateItems(pdfDictionary, hashMap);
        }
        return hashMap;
    }
}
