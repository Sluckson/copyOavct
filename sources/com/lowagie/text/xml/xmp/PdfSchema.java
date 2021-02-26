package com.lowagie.text.xml.xmp;

import com.lowagie.text.Document;

public class PdfSchema extends XmpSchema {
    public static final String DEFAULT_XPATH_ID = "pdf";
    public static final String DEFAULT_XPATH_URI = "http://ns.adobe.com/pdf/1.3/";
    public static final String KEYWORDS = "pdf:keywords";
    public static final String PRODUCER = "pdf:Producer";
    public static final String VERSION = "pdf:PDFVersion";
    private static final long serialVersionUID = -1541148669123992185L;

    public PdfSchema() {
        super("xmlns:pdf=\"http://ns.adobe.com/pdf/1.3/\"");
        addProducer(Document.getVersion());
    }

    public void addKeywords(String str) {
        setProperty(KEYWORDS, str);
    }

    public void addProducer(String str) {
        setProperty(PRODUCER, str);
    }

    public void addVersion(String str) {
        setProperty(VERSION, str);
    }
}
