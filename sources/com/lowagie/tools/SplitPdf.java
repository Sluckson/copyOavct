package com.lowagie.tools;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.codec.TIFFConstants;
import java.io.FileOutputStream;

public class SplitPdf {
    public static void main(String[] strArr) {
        int i;
        int i2;
        String[] strArr2 = strArr;
        if (strArr2.length != 4) {
            System.err.println("arguments: srcfile destfile1 destfile2 pagenumber");
            return;
        }
        try {
            int parseInt = Integer.parseInt(strArr2[3]);
            int i3 = 0;
            PdfReader pdfReader = new PdfReader(strArr2[0]);
            int numberOfPages = pdfReader.getNumberOfPages();
            System.out.println("There are " + numberOfPages + " pages in the original file.");
            if (parseInt < 2 || parseInt > numberOfPages) {
                throw new DocumentException("You can't split this document at page " + parseInt + "; there is no such page.");
            }
            Document document = new Document(pdfReader.getPageSizeWithRotation(1));
            Document document2 = new Document(pdfReader.getPageSizeWithRotation(parseInt));
            PdfWriter instance = PdfWriter.getInstance(document, new FileOutputStream(strArr2[1]));
            PdfWriter instance2 = PdfWriter.getInstance(document2, new FileOutputStream(strArr2[2]));
            document.open();
            PdfContentByte directContent = instance.getDirectContent();
            document2.open();
            PdfContentByte directContent2 = instance2.getDirectContent();
            while (true) {
                int i4 = parseInt - 1;
                i = TIFFConstants.TIFFTAG_IMAGEDESCRIPTION;
                i2 = 90;
                if (i3 >= i4) {
                    break;
                }
                i3++;
                document.setPageSize(pdfReader.getPageSizeWithRotation(i3));
                document.newPage();
                PdfImportedPage importedPage = instance.getImportedPage(pdfReader, i3);
                int pageRotation = pdfReader.getPageRotation(i3);
                if (pageRotation != 90) {
                    if (pageRotation != 270) {
                        directContent.addTemplate(importedPage, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f);
                    }
                }
                directContent.addTemplate(importedPage, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, pdfReader.getPageSizeWithRotation(i3).getHeight());
            }
            while (i3 < numberOfPages) {
                i3++;
                document2.setPageSize(pdfReader.getPageSizeWithRotation(i3));
                document2.newPage();
                PdfImportedPage importedPage2 = instance2.getImportedPage(pdfReader, i3);
                int pageRotation2 = pdfReader.getPageRotation(i3);
                if (pageRotation2 != i2) {
                    if (pageRotation2 != i) {
                        directContent2.addTemplate(importedPage2, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f);
                        System.out.println("Processed page " + i3);
                        i2 = 90;
                        i = TIFFConstants.TIFFTAG_IMAGEDESCRIPTION;
                    }
                }
                directContent2.addTemplate(importedPage2, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, pdfReader.getPageSizeWithRotation(i3).getHeight());
                System.out.println("Processed page " + i3);
                i2 = 90;
                i = TIFFConstants.TIFFTAG_IMAGEDESCRIPTION;
            }
            document.close();
            document2.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
