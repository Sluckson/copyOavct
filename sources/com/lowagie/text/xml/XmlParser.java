package com.lowagie.text.xml;

import com.lowagie.text.DocListener;
import com.lowagie.text.ExceptionConverter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.HashMap;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XmlParser {
    protected SAXParser parser;

    public XmlParser() {
        try {
            this.parser = SAXParserFactory.newInstance().newSAXParser();
        } catch (ParserConfigurationException e) {
            throw new ExceptionConverter(e);
        } catch (SAXException e2) {
            throw new ExceptionConverter(e2);
        }
    }

    /* renamed from: go */
    public void mo52046go(DocListener docListener, InputSource inputSource) {
        try {
            this.parser.parse(inputSource, new SAXiTextHandler(docListener));
        } catch (SAXException e) {
            throw new ExceptionConverter(e);
        } catch (IOException e2) {
            throw new ExceptionConverter(e2);
        }
    }

    /* renamed from: go */
    public void mo54730go(DocListener docListener, InputSource inputSource, String str) {
        try {
            this.parser.parse(inputSource, new SAXmyHandler(docListener, new TagMap(str)));
        } catch (SAXException e) {
            throw new ExceptionConverter(e);
        } catch (IOException e2) {
            throw new ExceptionConverter(e2);
        }
    }

    /* renamed from: go */
    public void mo54729go(DocListener docListener, InputSource inputSource, InputStream inputStream) {
        try {
            this.parser.parse(inputSource, new SAXmyHandler(docListener, new TagMap(inputStream)));
        } catch (SAXException e) {
            throw new ExceptionConverter(e);
        } catch (IOException e2) {
            throw new ExceptionConverter(e2);
        }
    }

    /* renamed from: go */
    public void mo54731go(DocListener docListener, InputSource inputSource, HashMap hashMap) {
        try {
            this.parser.parse(inputSource, new SAXmyHandler(docListener, hashMap));
        } catch (SAXException e) {
            throw new ExceptionConverter(e);
        } catch (IOException e2) {
            throw new ExceptionConverter(e2);
        }
    }

    /* renamed from: go */
    public void mo52045go(DocListener docListener, String str) {
        try {
            this.parser.parse(str, new SAXiTextHandler(docListener));
        } catch (SAXException e) {
            throw new ExceptionConverter(e);
        } catch (IOException e2) {
            throw new ExceptionConverter(e2);
        }
    }

    /* renamed from: go */
    public void mo54727go(DocListener docListener, String str, String str2) {
        try {
            this.parser.parse(str, new SAXmyHandler(docListener, new TagMap(str2)));
        } catch (SAXException e) {
            throw new ExceptionConverter(e);
        } catch (IOException e2) {
            throw new ExceptionConverter(e2);
        }
    }

    /* renamed from: go */
    public void mo54728go(DocListener docListener, String str, HashMap hashMap) {
        try {
            this.parser.parse(str, new SAXmyHandler(docListener, hashMap));
        } catch (SAXException e) {
            throw new ExceptionConverter(e);
        } catch (IOException e2) {
            throw new ExceptionConverter(e2);
        }
    }

    public static void parse(DocListener docListener, InputSource inputSource) {
        new XmlParser().mo52046go(docListener, inputSource);
    }

    public static void parse(DocListener docListener, InputSource inputSource, String str) {
        new XmlParser().mo54730go(docListener, inputSource, str);
    }

    public static void parse(DocListener docListener, InputSource inputSource, HashMap hashMap) {
        new XmlParser().mo54731go(docListener, inputSource, hashMap);
    }

    public static void parse(DocListener docListener, String str) {
        new XmlParser().mo52045go(docListener, str);
    }

    public static void parse(DocListener docListener, String str, String str2) {
        new XmlParser().mo54727go(docListener, str, str2);
    }

    public static void parse(DocListener docListener, String str, HashMap hashMap) {
        new XmlParser().mo54728go(docListener, str, hashMap);
    }

    public static void parse(DocListener docListener, InputStream inputStream) {
        new XmlParser().mo52046go(docListener, new InputSource(inputStream));
    }

    public static void parse(DocListener docListener, InputStream inputStream, String str) {
        new XmlParser().mo54730go(docListener, new InputSource(inputStream), str);
    }

    public static void parse(DocListener docListener, InputStream inputStream, HashMap hashMap) {
        new XmlParser().mo54731go(docListener, new InputSource(inputStream), hashMap);
    }

    public static void parse(DocListener docListener, Reader reader) {
        new XmlParser().mo52046go(docListener, new InputSource(reader));
    }

    public static void parse(DocListener docListener, Reader reader, String str) {
        new XmlParser().mo54730go(docListener, new InputSource(reader), str);
    }

    public static void parse(DocListener docListener, Reader reader, HashMap hashMap) {
        new XmlParser().mo54731go(docListener, new InputSource(reader), hashMap);
    }
}
