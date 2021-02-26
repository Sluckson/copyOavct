package com.lowagie.text.xml;

import com.lowagie.text.ExceptionConverter;
import java.io.InputStream;
import java.util.HashMap;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.helpers.DefaultHandler;

public class TagMap extends HashMap {
    private static final long serialVersionUID = -6809383366554350820L;

    class AttributeHandler extends DefaultHandler {
        public static final String ALIAS = "alias";
        public static final String ATTRIBUTE = "attribute";
        public static final String CONTENT = "content";
        public static final String NAME = "name";
        public static final String TAG = "tag";
        public static final String VALUE = "value";
        private XmlPeer currentPeer;
        private HashMap tagMap;

        public void characters(char[] cArr, int i, int i2) {
        }

        public void ignorableWhitespace(char[] cArr, int i, int i2) {
        }

        public AttributeHandler(HashMap hashMap) {
            this.tagMap = hashMap;
        }

        public void startElement(String str, String str2, String str3, Attributes attributes) {
            String value = attributes.getValue("name");
            String value2 = attributes.getValue(ALIAS);
            String value3 = attributes.getValue("value");
            if (value != null) {
                if ("tag".equals(str3)) {
                    this.currentPeer = new XmlPeer(value, value2);
                } else if (ATTRIBUTE.equals(str3)) {
                    if (value2 != null) {
                        this.currentPeer.addAlias(value, value2);
                    }
                    if (value3 != null) {
                        this.currentPeer.addValue(value, value3);
                    }
                }
            }
            String value4 = attributes.getValue("content");
            if (value4 != null) {
                this.currentPeer.setContent(value4);
            }
        }

        public void endElement(String str, String str2, String str3) {
            if ("tag".equals(str3)) {
                this.tagMap.put(this.currentPeer.getAlias(), this.currentPeer);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0011 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TagMap(java.lang.String r2) {
        /*
            r1 = this;
            r1.<init>()
            java.lang.Class<com.lowagie.text.xml.TagMap> r0 = com.lowagie.text.xml.TagMap.class
            java.lang.ClassLoader r0 = r0.getClassLoader()     // Catch:{ Exception -> 0x0011 }
            java.io.InputStream r0 = r0.getResourceAsStream(r2)     // Catch:{ Exception -> 0x0011 }
            r1.init(r0)     // Catch:{ Exception -> 0x0011 }
            goto L_0x0019
        L_0x0011:
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x001a }
            r0.<init>(r2)     // Catch:{ FileNotFoundException -> 0x001a }
            r1.init(r0)     // Catch:{ FileNotFoundException -> 0x001a }
        L_0x0019:
            return
        L_0x001a:
            r2 = move-exception
            com.lowagie.text.ExceptionConverter r0 = new com.lowagie.text.ExceptionConverter
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.xml.TagMap.<init>(java.lang.String):void");
    }

    public TagMap(InputStream inputStream) {
        init(inputStream);
    }

    /* access modifiers changed from: protected */
    public void init(InputStream inputStream) {
        try {
            SAXParserFactory.newInstance().newSAXParser().parse(new InputSource(inputStream), new AttributeHandler(this));
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }
}
