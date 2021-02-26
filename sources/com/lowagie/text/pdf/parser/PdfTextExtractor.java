package com.lowagie.text.pdf.parser;

import com.lowagie.text.pdf.PdfName;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.RandomAccessFileOrArray;
import java.io.IOException;

public class PdfTextExtractor {
    private final SimpleTextExtractingPdfContentStreamProcessor extractionProcessor = new SimpleTextExtractingPdfContentStreamProcessor();
    private final PdfReader reader;

    public PdfTextExtractor(PdfReader pdfReader) {
        this.reader = pdfReader;
    }

    private byte[] getContentBytesForPage(int i) throws IOException {
        RandomAccessFileOrArray safeFile = this.reader.getSafeFile();
        byte[] pageContent = this.reader.getPageContent(i, safeFile);
        safeFile.close();
        return pageContent;
    }

    public String getTextFromPage(int i) throws IOException {
        this.extractionProcessor.processContent(getContentBytesForPage(i), this.reader.getPageN(i).getAsDict(PdfName.RESOURCES));
        return this.extractionProcessor.getResultantText();
    }
}
