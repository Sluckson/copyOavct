package com.lowagie.text.pdf;

import com.lowagie.text.ExceptionConverter;
import com.lowagie.text.factories.RomanAlphabetFactory;
import com.lowagie.text.factories.RomanNumberFactory;
import com.lowagie.text.html.HtmlTags;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class PdfPageLabels {
    public static final int DECIMAL_ARABIC_NUMERALS = 0;
    public static final int EMPTY = 5;
    public static final int LOWERCASE_LETTERS = 4;
    public static final int LOWERCASE_ROMAN_NUMERALS = 2;
    public static final int UPPERCASE_LETTERS = 3;
    public static final int UPPERCASE_ROMAN_NUMERALS = 1;
    static PdfName[] numberingStyle = {PdfName.f661D, PdfName.f715R, new PdfName("r"), PdfName.f641A, new PdfName((String) HtmlTags.ANCHOR)};
    private HashMap map = new HashMap();

    public PdfPageLabels() {
        addPageLabel(1, 0, (String) null, 1);
    }

    public void addPageLabel(int i, int i2, String str, int i3) {
        if (i < 1 || i3 < 1) {
            throw new IllegalArgumentException("In a page label the page numbers must be greater or equal to 1.");
        }
        PdfDictionary pdfDictionary = new PdfDictionary();
        if (i2 >= 0 && i2 < numberingStyle.length) {
            pdfDictionary.put(PdfName.f719S, numberingStyle[i2]);
        }
        if (str != null) {
            pdfDictionary.put(PdfName.f707P, new PdfString(str, PdfObject.TEXT_UNICODE));
        }
        if (i3 != 1) {
            pdfDictionary.put(PdfName.f720ST, new PdfNumber(i3));
        }
        this.map.put(new Integer(i - 1), pdfDictionary);
    }

    public void addPageLabel(int i, int i2, String str) {
        addPageLabel(i, i2, str, 1);
    }

    public void addPageLabel(int i, int i2) {
        addPageLabel(i, i2, (String) null, 1);
    }

    public void addPageLabel(PdfPageLabelFormat pdfPageLabelFormat) {
        addPageLabel(pdfPageLabelFormat.physicalPage, pdfPageLabelFormat.numberStyle, pdfPageLabelFormat.prefix, pdfPageLabelFormat.logicalPage);
    }

    public void removePageLabel(int i) {
        if (i > 1) {
            this.map.remove(new Integer(i - 1));
        }
    }

    /* access modifiers changed from: package-private */
    public PdfDictionary getDictionary(PdfWriter pdfWriter) {
        try {
            return PdfNumberTree.writeTree(this.map, pdfWriter);
        } catch (IOException e) {
            throw new ExceptionConverter(e);
        }
    }

    public static String[] getPageLabels(PdfReader pdfReader) {
        int i;
        int numberOfPages = pdfReader.getNumberOfPages();
        PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.getPdfObjectRelease(pdfReader.getCatalog().get(PdfName.PAGELABELS));
        if (pdfDictionary == null) {
            return null;
        }
        String[] strArr = new String[numberOfPages];
        HashMap readTree = PdfNumberTree.readTree(pdfDictionary);
        String str = "";
        int i2 = 1;
        char c = 'D';
        for (int i3 = 0; i3 < numberOfPages; i3++) {
            Integer num = new Integer(i3);
            if (readTree.containsKey(num)) {
                PdfDictionary pdfDictionary2 = (PdfDictionary) PdfReader.getPdfObjectRelease((PdfObject) readTree.get(num));
                i = pdfDictionary2.contains(PdfName.f720ST) ? ((PdfNumber) pdfDictionary2.get(PdfName.f720ST)).intValue() : 1;
                if (pdfDictionary2.contains(PdfName.f707P)) {
                    str = ((PdfString) pdfDictionary2.get(PdfName.f707P)).toUnicodeString();
                }
                if (pdfDictionary2.contains(PdfName.f719S)) {
                    c = ((PdfName) pdfDictionary2.get(PdfName.f719S)).toString().charAt(1);
                }
            } else {
                i = i2;
            }
            if (c == 'A') {
                strArr[i3] = String.valueOf(str) + RomanAlphabetFactory.getUpperCaseString(i);
            } else if (c == 'R') {
                strArr[i3] = String.valueOf(str) + RomanNumberFactory.getUpperCaseString(i);
            } else if (c == 'a') {
                strArr[i3] = String.valueOf(str) + RomanAlphabetFactory.getLowerCaseString(i);
            } else if (c != 'r') {
                strArr[i3] = String.valueOf(str) + i;
            } else {
                strArr[i3] = String.valueOf(str) + RomanNumberFactory.getLowerCaseString(i);
            }
            i2 = i + 1;
        }
        return strArr;
    }

    public static PdfPageLabelFormat[] getPageLabelFormats(PdfReader pdfReader) {
        int i;
        PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.getPdfObjectRelease(pdfReader.getCatalog().get(PdfName.PAGELABELS));
        if (pdfDictionary == null) {
            return null;
        }
        HashMap readTree = PdfNumberTree.readTree(pdfDictionary);
        Integer[] numArr = (Integer[]) readTree.keySet().toArray(new Integer[readTree.size()]);
        Arrays.sort(numArr);
        PdfPageLabelFormat[] pdfPageLabelFormatArr = new PdfPageLabelFormat[readTree.size()];
        for (int i2 = 0; i2 < numArr.length; i2++) {
            Integer num = numArr[i2];
            PdfDictionary pdfDictionary2 = (PdfDictionary) PdfReader.getPdfObjectRelease((PdfObject) readTree.get(num));
            int intValue = pdfDictionary2.contains(PdfName.f720ST) ? ((PdfNumber) pdfDictionary2.get(PdfName.f720ST)).intValue() : 1;
            String unicodeString = pdfDictionary2.contains(PdfName.f707P) ? ((PdfString) pdfDictionary2.get(PdfName.f707P)).toUnicodeString() : "";
            if (pdfDictionary2.contains(PdfName.f719S)) {
                char charAt = ((PdfName) pdfDictionary2.get(PdfName.f719S)).toString().charAt(1);
                i = charAt != 'A' ? charAt != 'R' ? charAt != 'a' ? charAt != 'r' ? 0 : 2 : 4 : 1 : 3;
            } else {
                i = 5;
            }
            pdfPageLabelFormatArr[i2] = new PdfPageLabelFormat(num.intValue() + 1, i, unicodeString, intValue);
        }
        return pdfPageLabelFormatArr;
    }

    public static class PdfPageLabelFormat {
        public int logicalPage;
        public int numberStyle;
        public int physicalPage;
        public String prefix;

        public PdfPageLabelFormat(int i, int i2, String str, int i3) {
            this.physicalPage = i;
            this.numberStyle = i2;
            this.prefix = str;
            this.logicalPage = i3;
        }
    }
}
