package com.lowagie.text.xml.xmp;

import androidx.exifinterface.media.ExifInterface;
import com.lowagie.text.pdf.PdfDate;
import com.lowagie.text.pdf.PdfDictionary;
import com.lowagie.text.pdf.PdfName;
import com.lowagie.text.pdf.PdfObject;
import com.lowagie.text.pdf.PdfString;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Map;

public class XmpWriter {
    public static final String EXTRASPACE = "                                                                                                   \n";
    public static final String UTF16 = "UTF-16";
    public static final String UTF16BE = "UTF-16BE";
    public static final String UTF16LE = "UTF-16LE";
    public static final String UTF8 = "UTF-8";
    public static final String XPACKET_PI_BEGIN = "<?xpacket begin=\"﻿\" id=\"W5M0MpCehiHzreSzNTczkc9d\"?>\n";
    public static final String XPACKET_PI_END_R = "<?xpacket end=\"r\"?>";
    public static final String XPACKET_PI_END_W = "<?xpacket end=\"w\"?>";
    protected String about;
    protected char end;
    protected int extraSpace;
    protected OutputStreamWriter writer;

    public XmpWriter(OutputStream outputStream, String str, int i) throws IOException {
        this.end = 'w';
        this.extraSpace = i;
        this.writer = new OutputStreamWriter(outputStream, str);
        this.writer.write(XPACKET_PI_BEGIN);
        this.writer.write("<x:xmpmeta xmlns:x=\"adobe:ns:meta/\">\n");
        this.writer.write("<rdf:RDF xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\">\n");
        this.about = "";
    }

    public XmpWriter(OutputStream outputStream) throws IOException {
        this(outputStream, "UTF-8", 20);
    }

    public void setReadOnly() {
        this.end = 'r';
    }

    public void setAbout(String str) {
        this.about = str;
    }

    public void addRdfDescription(String str, String str2) throws IOException {
        this.writer.write("<rdf:Description rdf:about=\"");
        this.writer.write(this.about);
        this.writer.write("\" ");
        this.writer.write(str);
        this.writer.write(">");
        this.writer.write(str2);
        this.writer.write("</rdf:Description>\n");
    }

    public void addRdfDescription(XmpSchema xmpSchema) throws IOException {
        this.writer.write("<rdf:Description rdf:about=\"");
        this.writer.write(this.about);
        this.writer.write("\" ");
        this.writer.write(xmpSchema.getXmlns());
        this.writer.write(">");
        this.writer.write(xmpSchema.toString());
        this.writer.write("</rdf:Description>\n");
    }

    public void close() throws IOException {
        this.writer.write("</rdf:RDF>");
        this.writer.write("</x:xmpmeta>\n");
        for (int i = 0; i < this.extraSpace; i++) {
            this.writer.write(EXTRASPACE);
        }
        this.writer.write(this.end == 'r' ? XPACKET_PI_END_R : XPACKET_PI_END_W);
        this.writer.flush();
        this.writer.close();
    }

    public XmpWriter(OutputStream outputStream, PdfDictionary pdfDictionary, int i) throws IOException {
        this(outputStream);
        if (pdfDictionary != null) {
            DublinCoreSchema dublinCoreSchema = new DublinCoreSchema();
            PdfSchema pdfSchema = new PdfSchema();
            XmpBasicSchema xmpBasicSchema = new XmpBasicSchema();
            for (PdfName pdfName : pdfDictionary.getKeys()) {
                PdfObject pdfObject = pdfDictionary.get(pdfName);
                if (pdfObject != null) {
                    if (PdfName.TITLE.equals(pdfName)) {
                        dublinCoreSchema.addTitle(((PdfString) pdfObject).toUnicodeString());
                    }
                    if (PdfName.AUTHOR.equals(pdfName)) {
                        dublinCoreSchema.addAuthor(((PdfString) pdfObject).toUnicodeString());
                    }
                    if (PdfName.SUBJECT.equals(pdfName)) {
                        PdfString pdfString = (PdfString) pdfObject;
                        dublinCoreSchema.addSubject(pdfString.toUnicodeString());
                        dublinCoreSchema.addDescription(pdfString.toUnicodeString());
                    }
                    if (PdfName.KEYWORDS.equals(pdfName)) {
                        pdfSchema.addKeywords(((PdfString) pdfObject).toUnicodeString());
                    }
                    if (PdfName.CREATOR.equals(pdfName)) {
                        xmpBasicSchema.addCreatorTool(((PdfString) pdfObject).toUnicodeString());
                    }
                    if (PdfName.PRODUCER.equals(pdfName)) {
                        pdfSchema.addProducer(((PdfString) pdfObject).toUnicodeString());
                    }
                    if (PdfName.CREATIONDATE.equals(pdfName)) {
                        xmpBasicSchema.addCreateDate(((PdfDate) pdfObject).getW3CDate());
                    }
                    if (PdfName.MODDATE.equals(pdfName)) {
                        xmpBasicSchema.addModDate(((PdfDate) pdfObject).getW3CDate());
                    }
                }
            }
            if (dublinCoreSchema.size() > 0) {
                addRdfDescription(dublinCoreSchema);
            }
            if (pdfSchema.size() > 0) {
                addRdfDescription(pdfSchema);
            }
            if (xmpBasicSchema.size() > 0) {
                addRdfDescription(xmpBasicSchema);
            }
            if (i == 3 || i == 4) {
                PdfA1Schema pdfA1Schema = new PdfA1Schema();
                if (i == 3) {
                    pdfA1Schema.addConformance(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS);
                } else {
                    pdfA1Schema.addConformance("B");
                }
                addRdfDescription(pdfA1Schema);
            }
        }
    }

    public XmpWriter(OutputStream outputStream, Map map) throws IOException {
        this(outputStream);
        if (map != null) {
            DublinCoreSchema dublinCoreSchema = new DublinCoreSchema();
            PdfSchema pdfSchema = new PdfSchema();
            XmpBasicSchema xmpBasicSchema = new XmpBasicSchema();
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                String str2 = (String) entry.getValue();
                if (str2 != null) {
                    if ("Title".equals(str)) {
                        dublinCoreSchema.addTitle(str2);
                    }
                    if ("Author".equals(str)) {
                        dublinCoreSchema.addAuthor(str2);
                    }
                    if ("Subject".equals(str)) {
                        dublinCoreSchema.addSubject(str2);
                        dublinCoreSchema.addDescription(str2);
                    }
                    if ("Keywords".equals(str)) {
                        pdfSchema.addKeywords(str2);
                    }
                    if ("Creator".equals(str)) {
                        xmpBasicSchema.addCreatorTool(str2);
                    }
                    if ("Producer".equals(str)) {
                        pdfSchema.addProducer(str2);
                    }
                    if ("CreationDate".equals(str)) {
                        xmpBasicSchema.addCreateDate(PdfDate.getW3CDate(str2));
                    }
                    if ("ModDate".equals(str)) {
                        xmpBasicSchema.addModDate(PdfDate.getW3CDate(str2));
                    }
                }
            }
            if (dublinCoreSchema.size() > 0) {
                addRdfDescription(dublinCoreSchema);
            }
            if (pdfSchema.size() > 0) {
                addRdfDescription(pdfSchema);
            }
            if (xmpBasicSchema.size() > 0) {
                addRdfDescription(xmpBasicSchema);
            }
        }
    }
}
