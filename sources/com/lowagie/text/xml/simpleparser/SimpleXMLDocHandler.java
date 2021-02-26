package com.lowagie.text.xml.simpleparser;

import java.util.HashMap;

public interface SimpleXMLDocHandler {
    void endDocument();

    void endElement(String str);

    void startDocument();

    void startElement(String str, HashMap hashMap);

    void text(String str);
}
