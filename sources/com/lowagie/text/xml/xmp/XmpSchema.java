package com.lowagie.text.xml.xmp;

import java.util.Enumeration;
import java.util.Properties;
import kotlin.text.Typography;

public abstract class XmpSchema extends Properties {
    private static final long serialVersionUID = -176374295948945272L;
    protected String xmlns;

    public XmpSchema(String str) {
        this.xmlns = str;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        Enumeration propertyNames = propertyNames();
        while (propertyNames.hasMoreElements()) {
            process(stringBuffer, propertyNames.nextElement());
        }
        return stringBuffer.toString();
    }

    /* access modifiers changed from: protected */
    public void process(StringBuffer stringBuffer, Object obj) {
        stringBuffer.append(Typography.less);
        stringBuffer.append(obj);
        stringBuffer.append(Typography.greater);
        stringBuffer.append(get(obj));
        stringBuffer.append("</");
        stringBuffer.append(obj);
        stringBuffer.append(Typography.greater);
    }

    public String getXmlns() {
        return this.xmlns;
    }

    public Object addProperty(String str, String str2) {
        return setProperty(str, str2);
    }

    public Object setProperty(String str, String str2) {
        return super.setProperty(str, escape(str2));
    }

    public Object setProperty(String str, XmpArray xmpArray) {
        return super.setProperty(str, xmpArray.toString());
    }

    public Object setProperty(String str, LangAlt langAlt) {
        return super.setProperty(str, langAlt.toString());
    }

    public static String escape(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == '\"') {
                stringBuffer.append("&quot;");
            } else if (charAt == '<') {
                stringBuffer.append("&lt;");
            } else if (charAt == '>') {
                stringBuffer.append("&gt;");
            } else if (charAt == '&') {
                stringBuffer.append("&amp;");
            } else if (charAt != '\'') {
                stringBuffer.append(str.charAt(i));
            } else {
                stringBuffer.append("&apos;");
            }
        }
        return stringBuffer.toString();
    }
}
