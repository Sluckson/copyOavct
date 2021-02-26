package com.lowagie.text.xml.xmp;

import com.google.android.exoplayer2.metadata.icy.IcyHeaders;

public class PdfA1Schema extends XmpSchema {
    public static final String CONFORMANCE = "pdfaid:conformance";
    public static final String DEFAULT_XPATH_ID = "pdfaid";
    public static final String DEFAULT_XPATH_URI = "http://www.aiim.org/pdfa/ns/id/";
    public static final String PART = "pdfaid:part";
    private static final long serialVersionUID = 5300646133692948168L;

    public PdfA1Schema() {
        super("xmlns:pdfaid=\"http://www.aiim.org/pdfa/ns/id/\"");
        addPart(IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE);
    }

    public void addPart(String str) {
        setProperty(PART, str);
    }

    public void addConformance(String str) {
        setProperty(CONFORMANCE, str);
    }
}
