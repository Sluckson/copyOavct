package com.lowagie.tools;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfCopy;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.SimpleBookmark;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ConcatPdf {
    public static void main(String[] strArr) {
        String[] strArr2 = strArr;
        if (strArr2.length < 2) {
            System.err.println("arguments: file1 [file2 ...] destfile");
            return;
        }
        try {
            ArrayList arrayList = new ArrayList();
            String str = strArr2[strArr2.length - 1];
            PdfCopy pdfCopy = null;
            Document document = null;
            int i = 0;
            for (int i2 = 0; i2 < strArr2.length - 1; i2++) {
                PdfReader pdfReader = new PdfReader(strArr2[i2]);
                pdfReader.consolidateNamedDestinations();
                int numberOfPages = pdfReader.getNumberOfPages();
                List bookmark = SimpleBookmark.getBookmark(pdfReader);
                if (bookmark != null) {
                    if (i != 0) {
                        SimpleBookmark.shiftPageNumbers(bookmark, i, (int[]) null);
                    }
                    arrayList.addAll(bookmark);
                }
                i += numberOfPages;
                System.out.println("There are " + numberOfPages + " pages in " + strArr2[i2]);
                if (i2 == 0) {
                    Document document2 = new Document(pdfReader.getPageSizeWithRotation(1));
                    PdfCopy pdfCopy2 = new PdfCopy(document2, new FileOutputStream(str));
                    document2.open();
                    PdfCopy pdfCopy3 = pdfCopy2;
                    document = document2;
                    pdfCopy = pdfCopy3;
                }
                int i3 = 0;
                while (i3 < numberOfPages) {
                    i3++;
                    pdfCopy.addPage(pdfCopy.getImportedPage(pdfReader, i3));
                    System.out.println("Processed page " + i3);
                }
                pdfCopy.freeReader(pdfReader);
            }
            if (!arrayList.isEmpty()) {
                pdfCopy.setOutlines(arrayList);
            }
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
