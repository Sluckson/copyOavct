package com.lowagie.text.xml;

import com.lowagie.text.DocListener;
import java.util.HashMap;
import java.util.Properties;
import org.xml.sax.Attributes;

public class SAXmyHandler extends SAXiTextHandler {
    public SAXmyHandler(DocListener docListener, HashMap hashMap) {
        super(docListener, hashMap);
    }

    public void startElement(String str, String str2, String str3, Attributes attributes) {
        if (this.myTags.containsKey(str3)) {
            XmlPeer xmlPeer = (XmlPeer) this.myTags.get(str3);
            handleStartingTags(xmlPeer.getTag(), xmlPeer.getAttributes(attributes));
            return;
        }
        Properties properties = new Properties();
        if (attributes != null) {
            for (int i = 0; i < attributes.getLength(); i++) {
                properties.setProperty(attributes.getQName(i), attributes.getValue(i));
            }
        }
        handleStartingTags(str3, properties);
    }

    public void endElement(String str, String str2, String str3) {
        if (this.myTags.containsKey(str3)) {
            handleEndingTags(((XmlPeer) this.myTags.get(str3)).getTag());
        } else {
            handleEndingTags(str3);
        }
    }
}
