package com.lowagie.text.html;

import com.lowagie.text.DocListener;
import com.lowagie.text.ExceptionConverter;
import com.lowagie.text.xml.XmlParser;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class HtmlParser extends XmlParser {
    /* renamed from: go */
    public void mo52046go(DocListener docListener, InputSource inputSource) {
        try {
            this.parser.parse(inputSource, new SAXmyHtmlHandler(docListener));
        } catch (SAXException e) {
            throw new ExceptionConverter(e);
        } catch (IOException e2) {
            throw new ExceptionConverter(e2);
        }
    }

    public static void parse(DocListener docListener, InputSource inputSource) {
        new HtmlParser().mo52046go(docListener, inputSource);
    }

    /* renamed from: go */
    public void mo52045go(DocListener docListener, String str) {
        try {
            this.parser.parse(str, new SAXmyHtmlHandler(docListener));
        } catch (SAXException e) {
            throw new ExceptionConverter(e);
        } catch (IOException e2) {
            throw new ExceptionConverter(e2);
        }
    }

    public static void parse(DocListener docListener, String str) {
        new HtmlParser().mo52045go(docListener, str);
    }

    /* renamed from: go */
    public void mo52043go(DocListener docListener, InputStream inputStream) {
        try {
            this.parser.parse(new InputSource(inputStream), new SAXmyHtmlHandler(docListener));
        } catch (SAXException e) {
            throw new ExceptionConverter(e);
        } catch (IOException e2) {
            throw new ExceptionConverter(e2);
        }
    }

    public static void parse(DocListener docListener, InputStream inputStream) {
        new HtmlParser().mo52046go(docListener, new InputSource(inputStream));
    }

    /* renamed from: go */
    public void mo52044go(DocListener docListener, Reader reader) {
        try {
            this.parser.parse(new InputSource(reader), new SAXmyHtmlHandler(docListener));
        } catch (SAXException e) {
            throw new ExceptionConverter(e);
        } catch (IOException e2) {
            throw new ExceptionConverter(e2);
        }
    }

    public static void parse(DocListener docListener, Reader reader) {
        new HtmlParser().mo52046go(docListener, new InputSource(reader));
    }
}
