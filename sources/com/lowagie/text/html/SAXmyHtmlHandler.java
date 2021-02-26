package com.lowagie.text.html;

import com.lowagie.text.DocListener;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.ElementTags;
import com.lowagie.text.ExceptionConverter;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.xml.SAXiTextHandler;
import com.lowagie.text.xml.XmlPeer;
import java.util.HashMap;
import java.util.Properties;
import org.xml.sax.Attributes;

public class SAXmyHtmlHandler extends SAXiTextHandler {
    private Properties bodyAttributes = new Properties();
    private boolean tableBorder = false;

    public SAXmyHtmlHandler(DocListener docListener) {
        super(docListener, new HtmlTagMap());
    }

    public SAXmyHtmlHandler(DocListener docListener, BaseFont baseFont) {
        super(docListener, new HtmlTagMap(), baseFont);
    }

    public SAXmyHtmlHandler(DocListener docListener, HashMap hashMap) {
        super(docListener, hashMap);
    }

    public void startElement(String str, String str2, String str3, Attributes attributes) {
        String property;
        String str4;
        String lowerCase = str3.toLowerCase();
        if (!HtmlTagMap.isHtml(lowerCase) && !HtmlTagMap.isHead(lowerCase) && !HtmlTagMap.isTitle(lowerCase)) {
            int i = 0;
            if (HtmlTagMap.isMeta(lowerCase)) {
                String str5 = null;
                if (attributes != null) {
                    str4 = null;
                    while (i < attributes.getLength()) {
                        String qName = attributes.getQName(i);
                        if (qName.equalsIgnoreCase("content")) {
                            str4 = attributes.getValue(i);
                        } else if (qName.equalsIgnoreCase("name")) {
                            str5 = attributes.getValue(i);
                        }
                        i++;
                    }
                } else {
                    str4 = null;
                }
                if (str5 != null && str4 != null) {
                    this.bodyAttributes.put(str5, str4);
                }
            } else if (!HtmlTagMap.isLink(lowerCase)) {
                if (HtmlTagMap.isBody(lowerCase)) {
                    XmlPeer xmlPeer = new XmlPeer(ElementTags.ITEXT, lowerCase);
                    xmlPeer.addAlias("top", HtmlTags.TOPMARGIN);
                    xmlPeer.addAlias("bottom", HtmlTags.BOTTOMMARGIN);
                    xmlPeer.addAlias("right", HtmlTags.RIGHTMARGIN);
                    xmlPeer.addAlias("left", HtmlTags.LEFTMARGIN);
                    this.bodyAttributes.putAll(xmlPeer.getAttributes(attributes));
                    handleStartingTags(xmlPeer.getTag(), this.bodyAttributes);
                } else if (this.myTags.containsKey(lowerCase)) {
                    XmlPeer xmlPeer2 = (XmlPeer) this.myTags.get(lowerCase);
                    if ("table".equals(xmlPeer2.getTag()) || ElementTags.CELL.equals(xmlPeer2.getTag())) {
                        Properties attributes2 = xmlPeer2.getAttributes(attributes);
                        if ("table".equals(xmlPeer2.getTag()) && (property = attributes2.getProperty(ElementTags.BORDERWIDTH)) != null) {
                            if (Float.parseFloat(String.valueOf(property) + "f") > 0.0f) {
                                this.tableBorder = true;
                            }
                        }
                        if (this.tableBorder) {
                            attributes2.put("left", String.valueOf(true));
                            attributes2.put("right", String.valueOf(true));
                            attributes2.put("top", String.valueOf(true));
                            attributes2.put("bottom", String.valueOf(true));
                        }
                        handleStartingTags(xmlPeer2.getTag(), attributes2);
                        return;
                    }
                    handleStartingTags(xmlPeer2.getTag(), xmlPeer2.getAttributes(attributes));
                } else {
                    Properties properties = new Properties();
                    if (attributes != null) {
                        while (i < attributes.getLength()) {
                            properties.setProperty(attributes.getQName(i).toLowerCase(), attributes.getValue(i).toLowerCase());
                            i++;
                        }
                    }
                    handleStartingTags(lowerCase, properties);
                }
            }
        }
    }

    public void endElement(String str, String str2, String str3) {
        String lowerCase = str3.toLowerCase();
        if (ElementTags.PARAGRAPH.equals(lowerCase)) {
            try {
                this.document.add((Element) this.stack.pop());
            } catch (DocumentException e) {
                throw new ExceptionConverter(e);
            }
        } else if (!HtmlTagMap.isHead(lowerCase)) {
            if (HtmlTagMap.isTitle(lowerCase)) {
                if (this.currentChunk != null) {
                    this.bodyAttributes.put("title", this.currentChunk.getContent());
                }
            } else if (HtmlTagMap.isMeta(lowerCase) || HtmlTagMap.isLink(lowerCase) || HtmlTagMap.isBody(lowerCase)) {
            } else {
                if (this.myTags.containsKey(lowerCase)) {
                    XmlPeer xmlPeer = (XmlPeer) this.myTags.get(lowerCase);
                    if ("table".equals(xmlPeer.getTag())) {
                        this.tableBorder = false;
                    }
                    super.handleEndingTags(xmlPeer.getTag());
                    return;
                }
                handleEndingTags(lowerCase);
            }
        }
    }
}
