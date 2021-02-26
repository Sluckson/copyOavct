package com.lowagie.text.xml;

import com.lowagie.text.ElementTags;
import java.util.Properties;
import org.xml.sax.Attributes;

public class XmlPeer {
    protected Properties attributeAliases = new Properties();
    protected Properties attributeValues = new Properties();
    protected String customTagname;
    protected String defaultContent = null;
    protected String tagname;

    public XmlPeer(String str, String str2) {
        this.tagname = str;
        this.customTagname = str2;
    }

    public String getTag() {
        return this.tagname;
    }

    public String getAlias() {
        return this.customTagname;
    }

    public Properties getAttributes(Attributes attributes) {
        Properties properties = new Properties();
        properties.putAll(this.attributeValues);
        String str = this.defaultContent;
        if (str != null) {
            properties.put(ElementTags.ITEXT, str);
        }
        if (attributes != null) {
            for (int i = 0; i < attributes.getLength(); i++) {
                properties.setProperty(getName(attributes.getQName(i)), attributes.getValue(i));
            }
        }
        return properties;
    }

    public void addAlias(String str, String str2) {
        this.attributeAliases.put(str2, str);
    }

    public void addValue(String str, String str2) {
        this.attributeValues.put(str, str2);
    }

    public void setContent(String str) {
        this.defaultContent = str;
    }

    public String getName(String str) {
        String property = this.attributeAliases.getProperty(str);
        return property != null ? property : str;
    }

    public Properties getDefaultValues() {
        return this.attributeValues;
    }
}
