package com.lowagie.text.html;

import com.lowagie.text.ElementTags;
import com.lowagie.text.xml.XmlPeer;
import java.util.Properties;
import org.xml.sax.Attributes;

public class HtmlPeer extends XmlPeer {
    public HtmlPeer(String str, String str2) {
        super(str, str2.toLowerCase());
    }

    public void addAlias(String str, String str2) {
        this.attributeAliases.put(str2.toLowerCase(), str);
    }

    public Properties getAttributes(Attributes attributes) {
        Properties properties = new Properties();
        properties.putAll(this.attributeValues);
        if (this.defaultContent != null) {
            properties.put(ElementTags.ITEXT, this.defaultContent);
        }
        if (attributes != null) {
            for (int i = 0; i < attributes.getLength(); i++) {
                properties.setProperty(getName(attributes.getQName(i).toLowerCase()), attributes.getValue(i));
            }
        }
        return properties;
    }
}
