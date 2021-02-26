package com.lowagie.text.pdf;

import com.lowagie.text.xml.XmlDomWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Iterator;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class XfaForm {
    public static final String XFA_DATA_SCHEMA = "http://www.xfa.org/schema/xfa-data/1.0/";
    private AcroFieldsSearch acroFieldsSom;
    private boolean changed;
    private Node datasetsNode;
    private Xml2SomDatasets datasetsSom;
    private Document domDocument;
    private PdfReader reader;
    private Node templateNode;
    private Xml2SomTemplate templateSom;
    private boolean xfaPresent;

    public XfaForm() {
    }

    public static PdfObject getXfaObject(PdfReader pdfReader) {
        PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.getPdfObjectRelease(pdfReader.getCatalog().get(PdfName.ACROFORM));
        if (pdfDictionary == null) {
            return null;
        }
        return PdfReader.getPdfObjectRelease(pdfDictionary.get(PdfName.XFA));
    }

    public XfaForm(PdfReader pdfReader) throws IOException, ParserConfigurationException, SAXException {
        this.reader = pdfReader;
        PdfObject xfaObject = getXfaObject(pdfReader);
        if (xfaObject == null) {
            this.xfaPresent = false;
            return;
        }
        this.xfaPresent = true;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (xfaObject.isArray()) {
            PdfArray pdfArray = (PdfArray) xfaObject;
            for (int i = 1; i < pdfArray.size(); i += 2) {
                PdfObject directObject = pdfArray.getDirectObject(i);
                if (directObject instanceof PRStream) {
                    byteArrayOutputStream.write(PdfReader.getStreamBytes((PRStream) directObject));
                }
            }
        } else if (xfaObject instanceof PRStream) {
            byteArrayOutputStream.write(PdfReader.getStreamBytes((PRStream) xfaObject));
        }
        byteArrayOutputStream.close();
        DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
        newInstance.setNamespaceAware(true);
        this.domDocument = newInstance.newDocumentBuilder().parse(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
        extractNodes();
    }

    private void extractNodes() {
        Node firstChild = this.domDocument.getFirstChild();
        while (firstChild.getChildNodes().getLength() == 0) {
            firstChild = firstChild.getNextSibling();
        }
        for (Node firstChild2 = firstChild.getFirstChild(); firstChild2 != null; firstChild2 = firstChild2.getNextSibling()) {
            if (firstChild2.getNodeType() == 1) {
                String localName = firstChild2.getLocalName();
                if (localName.equals("template")) {
                    this.templateNode = firstChild2;
                    this.templateSom = new Xml2SomTemplate(firstChild2);
                } else if (localName.equals("datasets")) {
                    this.datasetsNode = firstChild2;
                    this.datasetsSom = new Xml2SomDatasets(firstChild2.getFirstChild());
                }
            }
        }
    }

    public static void setXfa(XfaForm xfaForm, PdfReader pdfReader, PdfWriter pdfWriter) throws IOException {
        PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.getPdfObjectRelease(pdfReader.getCatalog().get(PdfName.ACROFORM));
        if (pdfDictionary != null) {
            PdfObject xfaObject = getXfaObject(pdfReader);
            if (xfaObject.isArray()) {
                PdfArray pdfArray = (PdfArray) xfaObject;
                int i = -1;
                int i2 = -1;
                for (int i3 = 0; i3 < pdfArray.size(); i3 += 2) {
                    PdfString asString = pdfArray.getAsString(i3);
                    if ("template".equals(asString.toString())) {
                        i = i3 + 1;
                    }
                    if ("datasets".equals(asString.toString())) {
                        i2 = i3 + 1;
                    }
                }
                if (i > -1 && i2 > -1) {
                    pdfReader.killXref(pdfArray.getAsIndirectObject(i));
                    pdfReader.killXref(pdfArray.getAsIndirectObject(i2));
                    PdfStream pdfStream = new PdfStream(serializeDoc(xfaForm.templateNode));
                    pdfStream.flateCompress(pdfWriter.getCompressionLevel());
                    pdfArray.set(i, pdfWriter.addToBody(pdfStream).getIndirectReference());
                    PdfStream pdfStream2 = new PdfStream(serializeDoc(xfaForm.datasetsNode));
                    pdfStream2.flateCompress(pdfWriter.getCompressionLevel());
                    pdfArray.set(i2, pdfWriter.addToBody(pdfStream2).getIndirectReference());
                    pdfDictionary.put(PdfName.XFA, new PdfArray(pdfArray));
                    return;
                }
            }
            pdfReader.killXref(pdfDictionary.get(PdfName.XFA));
            PdfStream pdfStream3 = new PdfStream(serializeDoc(xfaForm.domDocument));
            pdfStream3.flateCompress(pdfWriter.getCompressionLevel());
            pdfDictionary.put(PdfName.XFA, pdfWriter.addToBody(pdfStream3).getIndirectReference());
        }
    }

    public void setXfa(PdfWriter pdfWriter) throws IOException {
        setXfa(this, this.reader, pdfWriter);
    }

    public static byte[] serializeDoc(Node node) throws IOException {
        XmlDomWriter xmlDomWriter = new XmlDomWriter();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        xmlDomWriter.setOutput(byteArrayOutputStream, (String) null);
        xmlDomWriter.setCanonical(false);
        xmlDomWriter.write(node);
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public boolean isXfaPresent() {
        return this.xfaPresent;
    }

    public Document getDomDocument() {
        return this.domDocument;
    }

    public String findFieldName(String str, AcroFields acroFields) {
        HashMap fields = acroFields.getFields();
        if (fields.containsKey(str)) {
            return str;
        }
        if (this.acroFieldsSom == null) {
            if (!fields.isEmpty() || !this.xfaPresent) {
                this.acroFieldsSom = new AcroFieldsSearch(fields.keySet());
            } else {
                this.acroFieldsSom = new AcroFieldsSearch(this.datasetsSom.getName2Node().keySet());
            }
        }
        if (this.acroFieldsSom.getAcroShort2LongName().containsKey(str)) {
            return (String) this.acroFieldsSom.getAcroShort2LongName().get(str);
        }
        return this.acroFieldsSom.inverseSearchGlobal(Xml2Som.splitParts(str));
    }

    public String findDatasetsName(String str) {
        if (this.datasetsSom.getName2Node().containsKey(str)) {
            return str;
        }
        return this.datasetsSom.inverseSearchGlobal(Xml2Som.splitParts(str));
    }

    public Node findDatasetsNode(String str) {
        String findDatasetsName;
        if (str == null || (findDatasetsName = findDatasetsName(str)) == null) {
            return null;
        }
        return (Node) this.datasetsSom.getName2Node().get(findDatasetsName);
    }

    public static String getNodeText(Node node) {
        return node == null ? "" : getNodeText(node, "");
    }

    private static String getNodeText(Node node, String str) {
        for (Node firstChild = node.getFirstChild(); firstChild != null; firstChild = firstChild.getNextSibling()) {
            if (firstChild.getNodeType() == 1) {
                str = getNodeText(firstChild, str);
            } else if (firstChild.getNodeType() == 3) {
                str = String.valueOf(str) + firstChild.getNodeValue();
            }
        }
        return str;
    }

    public void setNodeText(Node node, String str) {
        if (node != null) {
            while (true) {
                Node firstChild = node.getFirstChild();
                if (firstChild == null) {
                    break;
                }
                node.removeChild(firstChild);
            }
            if (node.getAttributes().getNamedItemNS(XFA_DATA_SCHEMA, "dataNode") != null) {
                node.getAttributes().removeNamedItemNS(XFA_DATA_SCHEMA, "dataNode");
            }
            node.appendChild(this.domDocument.createTextNode(str));
            this.changed = true;
        }
    }

    public void setXfaPresent(boolean z) {
        this.xfaPresent = z;
    }

    public void setDomDocument(Document document) {
        this.domDocument = document;
        extractNodes();
    }

    public PdfReader getReader() {
        return this.reader;
    }

    public void setReader(PdfReader pdfReader) {
        this.reader = pdfReader;
    }

    public boolean isChanged() {
        return this.changed;
    }

    public void setChanged(boolean z) {
        this.changed = z;
    }

    public static class InverseStore {
        protected ArrayList follow = new ArrayList();
        protected ArrayList part = new ArrayList();

        public String getDefaultName() {
            InverseStore inverseStore = this;
            while (true) {
                Object obj = inverseStore.follow.get(0);
                if (obj instanceof String) {
                    return (String) obj;
                }
                inverseStore = (InverseStore) obj;
            }
        }

        public boolean isSimilar(String str) {
            String substring = str.substring(0, str.indexOf(91) + 1);
            for (int i = 0; i < this.part.size(); i++) {
                if (((String) this.part.get(i)).startsWith(substring)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static class Stack2 extends ArrayList {
        private static final long serialVersionUID = -7451476576174095212L;

        public Object peek() {
            if (size() != 0) {
                return get(size() - 1);
            }
            throw new EmptyStackException();
        }

        public Object pop() {
            if (size() != 0) {
                Object obj = get(size() - 1);
                remove(size() - 1);
                return obj;
            }
            throw new EmptyStackException();
        }

        public Object push(Object obj) {
            add(obj);
            return obj;
        }

        public boolean empty() {
            return size() == 0;
        }
    }

    public static class Xml2Som {
        protected int anform;
        protected HashMap inverseSearch;
        protected HashMap name2Node;
        protected ArrayList order;
        protected Stack2 stack;

        public static String escapeSom(String str) {
            int indexOf = str.indexOf(46);
            if (indexOf < 0) {
                return str;
            }
            StringBuffer stringBuffer = new StringBuffer();
            int i = indexOf;
            int i2 = 0;
            while (i >= 0) {
                stringBuffer.append(str.substring(i2, i));
                stringBuffer.append('\\');
                int i3 = i;
                i = str.indexOf(46, i + 1);
                i2 = i3;
            }
            stringBuffer.append(str.substring(i2));
            return stringBuffer.toString();
        }

        public static String unescapeSom(String str) {
            int indexOf = str.indexOf(92);
            if (indexOf < 0) {
                return str;
            }
            StringBuffer stringBuffer = new StringBuffer();
            int i = 0;
            while (indexOf >= 0) {
                stringBuffer.append(str.substring(i, indexOf));
                i = indexOf + 1;
                indexOf = str.indexOf(92, i);
            }
            stringBuffer.append(str.substring(i));
            return stringBuffer.toString();
        }

        /* access modifiers changed from: protected */
        public String printStack() {
            if (this.stack.empty()) {
                return "";
            }
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < this.stack.size(); i++) {
                stringBuffer.append('.');
                stringBuffer.append((String) this.stack.get(i));
            }
            return stringBuffer.substring(1);
        }

        public static String getShortName(String str) {
            int indexOf = str.indexOf(".#subform[");
            if (indexOf < 0) {
                return str;
            }
            int i = 0;
            StringBuffer stringBuffer = new StringBuffer();
            while (indexOf >= 0) {
                stringBuffer.append(str.substring(i, indexOf));
                int indexOf2 = str.indexOf("]", indexOf + 10);
                if (indexOf2 < 0) {
                    return stringBuffer.toString();
                }
                i = indexOf2 + 1;
                indexOf = str.indexOf(".#subform[", i);
            }
            stringBuffer.append(str.substring(i));
            return stringBuffer.toString();
        }

        public void inverseSearchAdd(String str) {
            inverseSearchAdd(this.inverseSearch, this.stack, str);
        }

        public static void inverseSearchAdd(HashMap hashMap, Stack2 stack2, String str) {
            InverseStore inverseStore;
            String str2 = (String) stack2.peek();
            InverseStore inverseStore2 = (InverseStore) hashMap.get(str2);
            if (inverseStore2 == null) {
                inverseStore2 = new InverseStore();
                hashMap.put(str2, inverseStore2);
            }
            for (int size = stack2.size() - 2; size >= 0; size--) {
                String str3 = (String) stack2.get(size);
                int indexOf = inverseStore2.part.indexOf(str3);
                if (indexOf < 0) {
                    inverseStore2.part.add(str3);
                    inverseStore = new InverseStore();
                    inverseStore2.follow.add(inverseStore);
                } else {
                    inverseStore = (InverseStore) inverseStore2.follow.get(indexOf);
                }
                inverseStore2 = inverseStore;
            }
            inverseStore2.part.add("");
            inverseStore2.follow.add(str);
        }

        public String inverseSearchGlobal(ArrayList arrayList) {
            InverseStore inverseStore;
            if (arrayList.isEmpty() || (inverseStore = (InverseStore) this.inverseSearch.get(arrayList.get(arrayList.size() - 1))) == null) {
                return null;
            }
            int size = arrayList.size() - 2;
            while (size >= 0) {
                String str = (String) arrayList.get(size);
                int indexOf = inverseStore.part.indexOf(str);
                if (indexOf >= 0) {
                    inverseStore = (InverseStore) inverseStore.follow.get(indexOf);
                    size--;
                } else if (inverseStore.isSimilar(str)) {
                    return null;
                } else {
                    return inverseStore.getDefaultName();
                }
            }
            return inverseStore.getDefaultName();
        }

        public static Stack2 splitParts(String str) {
            int indexOf;
            while (str.startsWith(".")) {
                str = str.substring(1);
            }
            Stack2 stack2 = new Stack2();
            int i = 0;
            while (true) {
                int i2 = i;
                while (true) {
                    indexOf = str.indexOf(46, i2);
                    if (indexOf >= 0 && str.charAt(indexOf - 1) == '\\') {
                        i2 = indexOf + 1;
                    }
                }
                if (indexOf < 0) {
                    break;
                }
                String substring = str.substring(i, indexOf);
                if (!substring.endsWith("]")) {
                    substring = String.valueOf(substring) + "[0]";
                }
                stack2.add(substring);
                i = indexOf + 1;
            }
            String substring2 = str.substring(i);
            if (!substring2.endsWith("]")) {
                substring2 = String.valueOf(substring2) + "[0]";
            }
            stack2.add(substring2);
            return stack2;
        }

        public ArrayList getOrder() {
            return this.order;
        }

        public void setOrder(ArrayList arrayList) {
            this.order = arrayList;
        }

        public HashMap getName2Node() {
            return this.name2Node;
        }

        public void setName2Node(HashMap hashMap) {
            this.name2Node = hashMap;
        }

        public HashMap getInverseSearch() {
            return this.inverseSearch;
        }

        public void setInverseSearch(HashMap hashMap) {
            this.inverseSearch = hashMap;
        }
    }

    public static class Xml2SomDatasets extends Xml2Som {
        public Xml2SomDatasets(Node node) {
            this.order = new ArrayList();
            this.name2Node = new HashMap();
            this.stack = new Stack2();
            this.anform = 0;
            this.inverseSearch = new HashMap();
            processDatasetsInternal(node);
        }

        public Node insertNode(Node node, String str) {
            Stack2 splitParts = splitParts(str);
            Document ownerDocument = node.getOwnerDocument();
            Node firstChild = node.getFirstChild();
            Node node2 = null;
            int i = 0;
            while (i < splitParts.size()) {
                String str2 = (String) splitParts.get(i);
                int lastIndexOf = str2.lastIndexOf(91);
                String substring = str2.substring(0, lastIndexOf);
                int parseInt = Integer.parseInt(str2.substring(lastIndexOf + 1, str2.length() - 1));
                int i2 = -1;
                Node firstChild2 = firstChild.getFirstChild();
                while (firstChild2 != null && (firstChild2.getNodeType() != 1 || !escapeSom(firstChild2.getLocalName()).equals(substring) || (i2 = i2 + 1) != parseInt)) {
                    firstChild2 = firstChild2.getNextSibling();
                }
                while (i2 < parseInt) {
                    firstChild2 = firstChild.appendChild(ownerDocument.createElementNS((String) null, substring));
                    Attr createAttributeNS = ownerDocument.createAttributeNS(XfaForm.XFA_DATA_SCHEMA, "dataNode");
                    createAttributeNS.setNodeValue("dataGroup");
                    firstChild2.getAttributes().setNamedItemNS(createAttributeNS);
                    i2++;
                }
                i++;
                firstChild = firstChild2;
                node2 = firstChild;
            }
            inverseSearchAdd(this.inverseSearch, splitParts, str);
            this.name2Node.put(str, node2);
            this.order.add(str);
            return node2;
        }

        private static boolean hasChildren(Node node) {
            Node namedItemNS = node.getAttributes().getNamedItemNS(XfaForm.XFA_DATA_SCHEMA, "dataNode");
            if (namedItemNS != null) {
                String nodeValue = namedItemNS.getNodeValue();
                if ("dataGroup".equals(nodeValue)) {
                    return true;
                }
                if ("dataValue".equals(nodeValue)) {
                    return false;
                }
            }
            if (!node.hasChildNodes()) {
                return false;
            }
            for (Node firstChild = node.getFirstChild(); firstChild != null; firstChild = firstChild.getNextSibling()) {
                if (firstChild.getNodeType() == 1) {
                    return true;
                }
            }
            return false;
        }

        private void processDatasetsInternal(Node node) {
            Integer num;
            HashMap hashMap = new HashMap();
            for (Node firstChild = node.getFirstChild(); firstChild != null; firstChild = firstChild.getNextSibling()) {
                if (firstChild.getNodeType() == 1) {
                    String escapeSom = escapeSom(firstChild.getLocalName());
                    Integer num2 = (Integer) hashMap.get(escapeSom);
                    if (num2 == null) {
                        num = new Integer(0);
                    } else {
                        num = new Integer(num2.intValue() + 1);
                    }
                    hashMap.put(escapeSom, num);
                    if (hasChildren(firstChild)) {
                        Stack2 stack2 = this.stack;
                        stack2.push(String.valueOf(escapeSom) + "[" + num.toString() + "]");
                        processDatasetsInternal(firstChild);
                        this.stack.pop();
                    } else {
                        Stack2 stack22 = this.stack;
                        stack22.push(String.valueOf(escapeSom) + "[" + num.toString() + "]");
                        String printStack = printStack();
                        this.order.add(printStack);
                        inverseSearchAdd(printStack);
                        this.name2Node.put(printStack, firstChild);
                        this.stack.pop();
                    }
                }
            }
        }
    }

    public static class AcroFieldsSearch extends Xml2Som {
        private HashMap acroShort2LongName = new HashMap();

        public AcroFieldsSearch(Collection collection) {
            this.inverseSearch = new HashMap();
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                String shortName = getShortName(str);
                this.acroShort2LongName.put(shortName, str);
                inverseSearchAdd(this.inverseSearch, splitParts(shortName), str);
            }
        }

        public HashMap getAcroShort2LongName() {
            return this.acroShort2LongName;
        }

        public void setAcroShort2LongName(HashMap hashMap) {
            this.acroShort2LongName = hashMap;
        }
    }

    public static class Xml2SomTemplate extends Xml2Som {
        private boolean dynamicForm;
        private int templateLevel = 0;

        public Xml2SomTemplate(Node node) {
            this.order = new ArrayList();
            this.name2Node = new HashMap();
            this.stack = new Stack2();
            this.anform = 0;
            this.inverseSearch = new HashMap();
            processTemplate(node, (HashMap) null);
        }

        public String getFieldType(String str) {
            Node node = (Node) this.name2Node.get(str);
            if (node == null) {
                return null;
            }
            if (node.getLocalName().equals("exclGroup")) {
                return "exclGroup";
            }
            Node firstChild = node.getFirstChild();
            while (firstChild != null && (firstChild.getNodeType() != 1 || !firstChild.getLocalName().equals("ui"))) {
                firstChild = firstChild.getNextSibling();
            }
            if (firstChild == null) {
                return null;
            }
            for (Node firstChild2 = firstChild.getFirstChild(); firstChild2 != null; firstChild2 = firstChild2.getNextSibling()) {
                if (firstChild2.getNodeType() == 1 && (!firstChild2.getLocalName().equals("extras") || !firstChild2.getLocalName().equals("picture"))) {
                    return firstChild2.getLocalName();
                }
            }
            return null;
        }

        /* JADX WARNING: Removed duplicated region for block: B:43:0x00f2 A[SYNTHETIC, Splitter:B:43:0x00f2] */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x010c A[SYNTHETIC, Splitter:B:49:0x010c] */
        /* JADX WARNING: Removed duplicated region for block: B:54:0x011c A[ADDED_TO_REGION] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void processTemplate(org.w3c.dom.Node r10, java.util.HashMap r11) {
            /*
                r9 = this;
                if (r11 != 0) goto L_0x0007
                java.util.HashMap r11 = new java.util.HashMap
                r11.<init>()
            L_0x0007:
                java.util.HashMap r0 = new java.util.HashMap
                r0.<init>()
                org.w3c.dom.Node r10 = r10.getFirstChild()
            L_0x0010:
                if (r10 != 0) goto L_0x0013
                return
            L_0x0013:
                short r1 = r10.getNodeType()
                r2 = 1
                if (r1 != r2) goto L_0x0184
                java.lang.String r1 = r10.getLocalName()
                java.lang.String r3 = "subform"
                boolean r3 = r1.equals(r3)
                java.lang.String r4 = "]"
                java.lang.String r5 = "["
                java.lang.String r6 = "name"
                r7 = 0
                if (r3 == 0) goto L_0x00ab
                org.w3c.dom.NamedNodeMap r1 = r10.getAttributes()
                org.w3c.dom.Node r1 = r1.getNamedItem(r6)
                if (r1 == 0) goto L_0x0042
                java.lang.String r1 = r1.getNodeValue()
                java.lang.String r1 = escapeSom(r1)
                r3 = r1
                r1 = 0
                goto L_0x0046
            L_0x0042:
                java.lang.String r1 = "#subform"
                r3 = r1
                r1 = 1
            L_0x0046:
                if (r1 == 0) goto L_0x0055
                java.lang.Integer r6 = new java.lang.Integer
                int r7 = r9.anform
                r6.<init>(r7)
                int r7 = r9.anform
                int r7 = r7 + r2
                r9.anform = r7
                goto L_0x0071
            L_0x0055:
                java.lang.Object r6 = r0.get(r3)
                java.lang.Integer r6 = (java.lang.Integer) r6
                if (r6 != 0) goto L_0x0063
                java.lang.Integer r6 = new java.lang.Integer
                r6.<init>(r7)
                goto L_0x006e
            L_0x0063:
                java.lang.Integer r7 = new java.lang.Integer
                int r6 = r6.intValue()
                int r6 = r6 + r2
                r7.<init>(r6)
                r6 = r7
            L_0x006e:
                r0.put(r3, r6)
            L_0x0071:
                com.lowagie.text.pdf.XfaForm$Stack2 r7 = r9.stack
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                java.lang.String r3 = java.lang.String.valueOf(r3)
                r8.<init>(r3)
                r8.append(r5)
                java.lang.String r3 = r6.toString()
                r8.append(r3)
                r8.append(r4)
                java.lang.String r3 = r8.toString()
                r7.push(r3)
                int r3 = r9.templateLevel
                int r3 = r3 + r2
                r9.templateLevel = r3
                if (r1 == 0) goto L_0x009b
                r9.processTemplate(r10, r11)
                goto L_0x009f
            L_0x009b:
                r1 = 0
                r9.processTemplate(r10, r1)
            L_0x009f:
                int r1 = r9.templateLevel
                int r1 = r1 - r2
                r9.templateLevel = r1
                com.lowagie.text.pdf.XfaForm$Stack2 r1 = r9.stack
                r1.pop()
                goto L_0x0184
            L_0x00ab:
                java.lang.String r3 = "field"
                boolean r3 = r1.equals(r3)
                if (r3 != 0) goto L_0x0121
                java.lang.String r3 = "exclGroup"
                boolean r3 = r1.equals(r3)
                if (r3 == 0) goto L_0x00bc
                goto L_0x0121
            L_0x00bc:
                boolean r3 = r9.dynamicForm
                if (r3 != 0) goto L_0x0184
                int r3 = r9.templateLevel
                if (r3 <= 0) goto L_0x0184
                java.lang.String r3 = "occur"
                boolean r1 = r1.equals(r3)
                if (r1 == 0) goto L_0x0184
                org.w3c.dom.NamedNodeMap r1 = r10.getAttributes()
                java.lang.String r3 = "initial"
                org.w3c.dom.Node r1 = r1.getNamedItem(r3)
                if (r1 == 0) goto L_0x00e5
                java.lang.String r1 = r1.getNodeValue()     // Catch:{ Exception -> 0x00e5 }
                java.lang.String r1 = r1.trim()     // Catch:{ Exception -> 0x00e5 }
                int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ Exception -> 0x00e5 }
                goto L_0x00e6
            L_0x00e5:
                r1 = 1
            L_0x00e6:
                org.w3c.dom.NamedNodeMap r3 = r10.getAttributes()
                java.lang.String r4 = "min"
                org.w3c.dom.Node r3 = r3.getNamedItem(r4)
                if (r3 == 0) goto L_0x00ff
                java.lang.String r3 = r3.getNodeValue()     // Catch:{ Exception -> 0x00ff }
                java.lang.String r3 = r3.trim()     // Catch:{ Exception -> 0x00ff }
                int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ Exception -> 0x00ff }
                goto L_0x0100
            L_0x00ff:
                r3 = 1
            L_0x0100:
                org.w3c.dom.NamedNodeMap r4 = r10.getAttributes()
                java.lang.String r5 = "max"
                org.w3c.dom.Node r4 = r4.getNamedItem(r5)
                if (r4 == 0) goto L_0x0119
                java.lang.String r4 = r4.getNodeValue()     // Catch:{ Exception -> 0x0119 }
                java.lang.String r4 = r4.trim()     // Catch:{ Exception -> 0x0119 }
                int r4 = java.lang.Integer.parseInt(r4)     // Catch:{ Exception -> 0x0119 }
                goto L_0x011a
            L_0x0119:
                r4 = 1
            L_0x011a:
                if (r1 != r3) goto L_0x011e
                if (r3 == r4) goto L_0x0184
            L_0x011e:
                r9.dynamicForm = r2
                goto L_0x0184
            L_0x0121:
                org.w3c.dom.NamedNodeMap r1 = r10.getAttributes()
                org.w3c.dom.Node r1 = r1.getNamedItem(r6)
                if (r1 == 0) goto L_0x0184
                java.lang.String r1 = r1.getNodeValue()
                java.lang.String r1 = escapeSom(r1)
                java.lang.Object r3 = r11.get(r1)
                java.lang.Integer r3 = (java.lang.Integer) r3
                if (r3 != 0) goto L_0x0141
                java.lang.Integer r2 = new java.lang.Integer
                r2.<init>(r7)
                goto L_0x014c
            L_0x0141:
                java.lang.Integer r6 = new java.lang.Integer
                int r3 = r3.intValue()
                int r3 = r3 + r2
                r6.<init>(r3)
                r2 = r6
            L_0x014c:
                r11.put(r1, r2)
                com.lowagie.text.pdf.XfaForm$Stack2 r3 = r9.stack
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                java.lang.String r1 = java.lang.String.valueOf(r1)
                r6.<init>(r1)
                r6.append(r5)
                java.lang.String r1 = r2.toString()
                r6.append(r1)
                r6.append(r4)
                java.lang.String r1 = r6.toString()
                r3.push(r1)
                java.lang.String r1 = r9.printStack()
                java.util.ArrayList r2 = r9.order
                r2.add(r1)
                r9.inverseSearchAdd(r1)
                java.util.HashMap r2 = r9.name2Node
                r2.put(r1, r10)
                com.lowagie.text.pdf.XfaForm$Stack2 r1 = r9.stack
                r1.pop()
            L_0x0184:
                org.w3c.dom.Node r10 = r10.getNextSibling()
                goto L_0x0010
            */
            throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.XfaForm.Xml2SomTemplate.processTemplate(org.w3c.dom.Node, java.util.HashMap):void");
        }

        public boolean isDynamicForm() {
            return this.dynamicForm;
        }

        public void setDynamicForm(boolean z) {
            this.dynamicForm = z;
        }
    }

    public Xml2SomTemplate getTemplateSom() {
        return this.templateSom;
    }

    public void setTemplateSom(Xml2SomTemplate xml2SomTemplate) {
        this.templateSom = xml2SomTemplate;
    }

    public Xml2SomDatasets getDatasetsSom() {
        return this.datasetsSom;
    }

    public void setDatasetsSom(Xml2SomDatasets xml2SomDatasets) {
        this.datasetsSom = xml2SomDatasets;
    }

    public AcroFieldsSearch getAcroFieldsSom() {
        return this.acroFieldsSom;
    }

    public void setAcroFieldsSom(AcroFieldsSearch acroFieldsSearch) {
        this.acroFieldsSom = acroFieldsSearch;
    }

    public Node getDatasetsNode() {
        return this.datasetsNode;
    }
}
