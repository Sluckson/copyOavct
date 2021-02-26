package com.lowagie.text.xml.xmp;

import com.lowagie.text.ExceptionConverter;
import com.lowagie.text.xml.XmlDomWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmpReader {
    private Document domDocument;

    public XmpReader(byte[] bArr) throws SAXException, IOException {
        try {
            DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
            newInstance.setNamespaceAware(true);
            this.domDocument = newInstance.newDocumentBuilder().parse(new ByteArrayInputStream(bArr));
        } catch (ParserConfigurationException e) {
            throw new ExceptionConverter(e);
        }
    }

    public boolean replace(String str, String str2, String str3) {
        NodeList elementsByTagNameNS = this.domDocument.getElementsByTagNameNS(str, str2);
        if (elementsByTagNameNS.getLength() == 0) {
            return false;
        }
        for (int i = 0; i < elementsByTagNameNS.getLength(); i++) {
            setNodeText(this.domDocument, elementsByTagNameNS.item(i), str3);
        }
        return true;
    }

    public boolean add(String str, String str2, String str3, String str4) {
        NodeList elementsByTagName = this.domDocument.getElementsByTagName(str);
        if (elementsByTagName.getLength() == 0) {
            return false;
        }
        for (int i = 0; i < elementsByTagName.getLength(); i++) {
            Node item = elementsByTagName.item(i);
            NamedNodeMap attributes = item.getAttributes();
            for (int i2 = 0; i2 < attributes.getLength(); i2++) {
                if (str2.equals(attributes.item(i2).getNodeValue())) {
                    Element createElement = this.domDocument.createElement(str3);
                    createElement.appendChild(this.domDocument.createTextNode(str4));
                    item.appendChild(createElement);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean setNodeText(Document document, Node node, String str) {
        if (node == null) {
            return false;
        }
        while (true) {
            Node firstChild = node.getFirstChild();
            if (firstChild == null) {
                node.appendChild(document.createTextNode(str));
                return true;
            }
            node.removeChild(firstChild);
        }
    }

    public byte[] serializeDoc() throws IOException {
        XmlDomWriter xmlDomWriter = new XmlDomWriter();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        xmlDomWriter.setOutput(byteArrayOutputStream, (String) null);
        byteArrayOutputStream.write(XmpWriter.XPACKET_PI_BEGIN.getBytes("UTF-8"));
        byteArrayOutputStream.flush();
        xmlDomWriter.write(this.domDocument.getElementsByTagName("x:xmpmeta").item(0));
        byteArrayOutputStream.flush();
        for (int i = 0; i < 20; i++) {
            byteArrayOutputStream.write(XmpWriter.EXTRASPACE.getBytes());
        }
        byteArrayOutputStream.write(XmpWriter.XPACKET_PI_END_W.getBytes());
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }
}
