package com.lowagie.text.html.simpleparser;

import com.lowagie.text.DocListener;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.ExceptionConverter;
import com.lowagie.text.FontFactoryImp;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Rectangle;
import com.lowagie.text.xml.simpleparser.SimpleXMLDocHandler;
import com.lowagie.text.xml.simpleparser.SimpleXMLDocHandlerComment;
import com.lowagie.text.xml.simpleparser.SimpleXMLParser;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class HTMLWorker implements SimpleXMLDocHandler, DocListener {
    public static final HashMap tagsSupported = new HashMap();
    public static final String tagsSupportedString = "ol ul li a pre font span br p div body table td th tr i b u sub sup em strong s strike h1 h2 h3 h4 h5 h6 img hr";
    private ChainedProperties cprops = new ChainedProperties();
    private Paragraph currentParagraph;
    protected DocListener document;
    private FactoryProperties factoryProperties = new FactoryProperties();
    private HashMap interfaceProps;
    private boolean isPRE = false;
    protected ArrayList objectList;
    private boolean pendingLI = false;
    private boolean pendingTD = false;
    private boolean pendingTR = false;
    private boolean skipText = false;
    private Stack stack = new Stack();
    private StyleSheet style = new StyleSheet();
    private Stack tableState = new Stack();

    public void clearTextWrap() throws DocumentException {
    }

    public void close() {
    }

    public boolean newPage() {
        return true;
    }

    public void open() {
    }

    public void resetFooter() {
    }

    public void resetHeader() {
    }

    public void resetPageCount() {
    }

    public void setFooter(HeaderFooter headerFooter) {
    }

    public void setHeader(HeaderFooter headerFooter) {
    }

    public boolean setMarginMirroring(boolean z) {
        return false;
    }

    public boolean setMarginMirroringTopBottom(boolean z) {
        return false;
    }

    public boolean setMargins(float f, float f2, float f3, float f4) {
        return true;
    }

    public void setPageCount(int i) {
    }

    public boolean setPageSize(Rectangle rectangle) {
        return true;
    }

    public HTMLWorker(DocListener docListener) {
        this.document = docListener;
    }

    public void setStyleSheet(StyleSheet styleSheet) {
        this.style = styleSheet;
    }

    public StyleSheet getStyleSheet() {
        return this.style;
    }

    public void setInterfaceProps(HashMap hashMap) {
        this.interfaceProps = hashMap;
        FontFactoryImp fontFactoryImp = hashMap != null ? (FontFactoryImp) hashMap.get("font_factory") : null;
        if (fontFactoryImp != null) {
            this.factoryProperties.setFontImp(fontFactoryImp);
        }
    }

    public HashMap getInterfaceProps() {
        return this.interfaceProps;
    }

    public void parse(Reader reader) throws IOException {
        SimpleXMLParser.parse(this, (SimpleXMLDocHandlerComment) null, reader, true);
    }

    public static ArrayList parseToList(Reader reader, StyleSheet styleSheet) throws IOException {
        return parseToList(reader, styleSheet, (HashMap) null);
    }

    public static ArrayList parseToList(Reader reader, StyleSheet styleSheet, HashMap hashMap) throws IOException {
        HTMLWorker hTMLWorker = new HTMLWorker((DocListener) null);
        if (styleSheet != null) {
            hTMLWorker.style = styleSheet;
        }
        hTMLWorker.document = hTMLWorker;
        hTMLWorker.setInterfaceProps(hashMap);
        hTMLWorker.objectList = new ArrayList();
        hTMLWorker.parse(reader);
        return hTMLWorker.objectList;
    }

    public void endDocument() {
        int i = 0;
        while (i < this.stack.size()) {
            try {
                this.document.add((Element) this.stack.elementAt(i));
                i++;
            } catch (Exception e) {
                throw new ExceptionConverter(e);
            }
        }
        if (this.currentParagraph != null) {
            this.document.add(this.currentParagraph);
        }
        this.currentParagraph = null;
    }

    public void startDocument() {
        HashMap hashMap = new HashMap();
        this.style.applyStyle("body", hashMap);
        this.cprops.addToChain("body", hashMap);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:161|162|(1:164)|165|166|167|168|169|170|171) */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:174|(1:176)|177|178|179|180|181|182|183) */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a2, code lost:
        r3 = r1.currentParagraph.getChunks().size();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:168:0x033b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:180:0x037a */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0123 A[Catch:{ Exception -> 0x047f }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:180:0x037a=Splitter:B:180:0x037a, B:168:0x033b=Splitter:B:168:0x033b} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void startElement(java.lang.String r22, java.util.HashMap r23) {
        /*
            r21 = this;
            r1 = r21
            r0 = r22
            r2 = r23
            java.lang.String r3 = "tr"
            java.util.HashMap r4 = tagsSupported
            boolean r4 = r4.containsKey(r0)
            if (r4 != 0) goto L_0x0011
            return
        L_0x0011:
            com.lowagie.text.html.simpleparser.StyleSheet r4 = r1.style     // Catch:{ Exception -> 0x047f }
            r4.applyStyle(r0, r2)     // Catch:{ Exception -> 0x047f }
            java.util.HashMap r4 = com.lowagie.text.html.simpleparser.FactoryProperties.followTags     // Catch:{ Exception -> 0x047f }
            java.lang.Object r4 = r4.get(r0)     // Catch:{ Exception -> 0x047f }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x047f }
            r5 = 0
            if (r4 == 0) goto L_0x002f
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ Exception -> 0x047f }
            r0.<init>()     // Catch:{ Exception -> 0x047f }
            r0.put(r4, r5)     // Catch:{ Exception -> 0x047f }
            com.lowagie.text.html.simpleparser.ChainedProperties r2 = r1.cprops     // Catch:{ Exception -> 0x047f }
            r2.addToChain(r4, r0)     // Catch:{ Exception -> 0x047f }
            return
        L_0x002f:
            com.lowagie.text.html.simpleparser.ChainedProperties r4 = r1.cprops     // Catch:{ Exception -> 0x047f }
            com.lowagie.text.html.simpleparser.FactoryProperties.insertStyle(r2, r4)     // Catch:{ Exception -> 0x047f }
            java.lang.String r4 = "a"
            boolean r4 = r0.equals(r4)     // Catch:{ Exception -> 0x047f }
            if (r4 == 0) goto L_0x005b
            com.lowagie.text.html.simpleparser.ChainedProperties r3 = r1.cprops     // Catch:{ Exception -> 0x047f }
            r3.addToChain(r0, r2)     // Catch:{ Exception -> 0x047f }
            com.lowagie.text.Paragraph r0 = r1.currentParagraph     // Catch:{ Exception -> 0x047f }
            if (r0 != 0) goto L_0x004c
            com.lowagie.text.Paragraph r0 = new com.lowagie.text.Paragraph     // Catch:{ Exception -> 0x047f }
            r0.<init>()     // Catch:{ Exception -> 0x047f }
            r1.currentParagraph = r0     // Catch:{ Exception -> 0x047f }
        L_0x004c:
            java.util.Stack r0 = r1.stack     // Catch:{ Exception -> 0x047f }
            com.lowagie.text.Paragraph r2 = r1.currentParagraph     // Catch:{ Exception -> 0x047f }
            r0.push(r2)     // Catch:{ Exception -> 0x047f }
            com.lowagie.text.Paragraph r0 = new com.lowagie.text.Paragraph     // Catch:{ Exception -> 0x047f }
            r0.<init>()     // Catch:{ Exception -> 0x047f }
            r1.currentParagraph = r0     // Catch:{ Exception -> 0x047f }
            return
        L_0x005b:
            java.lang.String r4 = "br"
            boolean r4 = r0.equals(r4)     // Catch:{ Exception -> 0x047f }
            java.lang.String r6 = "\n"
            if (r4 == 0) goto L_0x007e
            com.lowagie.text.Paragraph r0 = r1.currentParagraph     // Catch:{ Exception -> 0x047f }
            if (r0 != 0) goto L_0x0070
            com.lowagie.text.Paragraph r0 = new com.lowagie.text.Paragraph     // Catch:{ Exception -> 0x047f }
            r0.<init>()     // Catch:{ Exception -> 0x047f }
            r1.currentParagraph = r0     // Catch:{ Exception -> 0x047f }
        L_0x0070:
            com.lowagie.text.Paragraph r0 = r1.currentParagraph     // Catch:{ Exception -> 0x047f }
            com.lowagie.text.html.simpleparser.FactoryProperties r2 = r1.factoryProperties     // Catch:{ Exception -> 0x047f }
            com.lowagie.text.html.simpleparser.ChainedProperties r3 = r1.cprops     // Catch:{ Exception -> 0x047f }
            com.lowagie.text.Chunk r2 = r2.createChunk(r6, r3)     // Catch:{ Exception -> 0x047f }
            r0.add(r2)     // Catch:{ Exception -> 0x047f }
            return
        L_0x007e:
            java.lang.String r4 = "hr"
            boolean r4 = r0.equals(r4)     // Catch:{ Exception -> 0x047f }
            java.lang.String r7 = "left"
            java.lang.String r8 = "width"
            java.lang.String r9 = "align"
            r11 = 1094713344(0x41400000, float:12.0)
            java.lang.String r12 = "size"
            r13 = 0
            r15 = 1
            if (r4 == 0) goto L_0x0149
            com.lowagie.text.Paragraph r0 = r1.currentParagraph     // Catch:{ Exception -> 0x047f }
            if (r0 != 0) goto L_0x009f
            com.lowagie.text.Paragraph r0 = new com.lowagie.text.Paragraph     // Catch:{ Exception -> 0x047f }
            r0.<init>()     // Catch:{ Exception -> 0x047f }
            r1.currentParagraph = r0     // Catch:{ Exception -> 0x047f }
            r0 = 0
            goto L_0x00a0
        L_0x009f:
            r0 = 1
        L_0x00a0:
            if (r0 == 0) goto L_0x00c7
            com.lowagie.text.Paragraph r3 = r1.currentParagraph     // Catch:{ Exception -> 0x047f }
            java.util.ArrayList r3 = r3.getChunks()     // Catch:{ Exception -> 0x047f }
            int r3 = r3.size()     // Catch:{ Exception -> 0x047f }
            if (r3 == 0) goto L_0x00c5
            com.lowagie.text.Paragraph r4 = r1.currentParagraph     // Catch:{ Exception -> 0x047f }
            java.util.ArrayList r4 = r4.getChunks()     // Catch:{ Exception -> 0x047f }
            int r3 = r3 - r15
            java.lang.Object r3 = r4.get(r3)     // Catch:{ Exception -> 0x047f }
            com.lowagie.text.Chunk r3 = (com.lowagie.text.Chunk) r3     // Catch:{ Exception -> 0x047f }
            java.lang.String r3 = r3.getContent()     // Catch:{ Exception -> 0x047f }
            boolean r3 = r3.endsWith(r6)     // Catch:{ Exception -> 0x047f }
            if (r3 == 0) goto L_0x00c7
        L_0x00c5:
            r14 = 0
            goto L_0x00c8
        L_0x00c7:
            r14 = r0
        L_0x00c8:
            java.lang.Object r0 = r2.get(r9)     // Catch:{ Exception -> 0x047f }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x047f }
            if (r0 == 0) goto L_0x00e3
            boolean r3 = r0.equalsIgnoreCase(r7)     // Catch:{ Exception -> 0x047f }
            r3 = r3 ^ r15
            java.lang.String r4 = "right"
            boolean r0 = r0.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x047f }
            if (r0 == 0) goto L_0x00e0
            r19 = 2
            goto L_0x00e5
        L_0x00e0:
            r19 = r3
            goto L_0x00e5
        L_0x00e3:
            r19 = 1
        L_0x00e5:
            java.lang.Object r0 = r2.get(r8)     // Catch:{ Exception -> 0x047f }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x047f }
            r3 = 1065353216(0x3f800000, float:1.0)
            if (r0 == 0) goto L_0x010a
            float r4 = com.lowagie.text.html.Markup.parseLength(r0, r11)     // Catch:{ Exception -> 0x047f }
            int r5 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            if (r5 <= 0) goto L_0x00f8
            goto L_0x00fa
        L_0x00f8:
            r4 = 1065353216(0x3f800000, float:1.0)
        L_0x00fa:
            java.lang.String r5 = "%"
            boolean r0 = r0.endsWith(r5)     // Catch:{ Exception -> 0x047f }
            if (r0 != 0) goto L_0x0107
            r0 = 1120403456(0x42c80000, float:100.0)
            r17 = 1120403456(0x42c80000, float:100.0)
            goto L_0x010c
        L_0x0107:
            r17 = r4
            goto L_0x010c
        L_0x010a:
            r17 = 1065353216(0x3f800000, float:1.0)
        L_0x010c:
            java.lang.Object r0 = r2.get(r12)     // Catch:{ Exception -> 0x047f }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x047f }
            if (r0 == 0) goto L_0x011f
            float r0 = com.lowagie.text.html.Markup.parseLength(r0, r11)     // Catch:{ Exception -> 0x047f }
            int r2 = (r0 > r13 ? 1 : (r0 == r13 ? 0 : -1))
            if (r2 <= 0) goto L_0x011f
            r16 = r0
            goto L_0x0121
        L_0x011f:
            r16 = 1065353216(0x3f800000, float:1.0)
        L_0x0121:
            if (r14 == 0) goto L_0x012a
            com.lowagie.text.Paragraph r0 = r1.currentParagraph     // Catch:{ Exception -> 0x047f }
            com.lowagie.text.Chunk r2 = com.lowagie.text.Chunk.NEWLINE     // Catch:{ Exception -> 0x047f }
            r0.add(r2)     // Catch:{ Exception -> 0x047f }
        L_0x012a:
            com.lowagie.text.Paragraph r0 = r1.currentParagraph     // Catch:{ Exception -> 0x047f }
            com.lowagie.text.pdf.draw.LineSeparator r2 = new com.lowagie.text.pdf.draw.LineSeparator     // Catch:{ Exception -> 0x047f }
            r18 = 0
            com.lowagie.text.Paragraph r3 = r1.currentParagraph     // Catch:{ Exception -> 0x047f }
            float r3 = r3.getLeading()     // Catch:{ Exception -> 0x047f }
            r4 = 1073741824(0x40000000, float:2.0)
            float r20 = r3 / r4
            r15 = r2
            r15.<init>(r16, r17, r18, r19, r20)     // Catch:{ Exception -> 0x047f }
            r0.add(r2)     // Catch:{ Exception -> 0x047f }
            com.lowagie.text.Paragraph r0 = r1.currentParagraph     // Catch:{ Exception -> 0x047f }
            com.lowagie.text.Chunk r2 = com.lowagie.text.Chunk.NEWLINE     // Catch:{ Exception -> 0x047f }
            r0.add(r2)     // Catch:{ Exception -> 0x047f }
            return
        L_0x0149:
            java.lang.String r4 = "font"
            boolean r4 = r0.equals(r4)     // Catch:{ Exception -> 0x047f }
            if (r4 != 0) goto L_0x0479
            java.lang.String r4 = "span"
            boolean r4 = r0.equals(r4)     // Catch:{ Exception -> 0x047f }
            if (r4 == 0) goto L_0x015b
            goto L_0x0479
        L_0x015b:
            java.lang.String r4 = "img"
            boolean r4 = r0.equals(r4)     // Catch:{ Exception -> 0x047f }
            java.lang.String r6 = "p"
            if (r4 == 0) goto L_0x02d3
            java.lang.String r3 = "src"
            java.lang.Object r3 = r2.get(r3)     // Catch:{ Exception -> 0x047f }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x047f }
            if (r3 != 0) goto L_0x0170
            return
        L_0x0170:
            com.lowagie.text.html.simpleparser.ChainedProperties r4 = r1.cprops     // Catch:{ Exception -> 0x047f }
            r4.addToChain(r0, r2)     // Catch:{ Exception -> 0x047f }
            java.util.HashMap r4 = r1.interfaceProps     // Catch:{ Exception -> 0x047f }
            if (r4 == 0) goto L_0x01d3
            java.util.HashMap r4 = r1.interfaceProps     // Catch:{ Exception -> 0x047f }
            java.lang.String r5 = "img_provider"
            java.lang.Object r4 = r4.get(r5)     // Catch:{ Exception -> 0x047f }
            com.lowagie.text.html.simpleparser.ImageProvider r4 = (com.lowagie.text.html.simpleparser.ImageProvider) r4     // Catch:{ Exception -> 0x047f }
            if (r4 == 0) goto L_0x018e
            com.lowagie.text.html.simpleparser.ChainedProperties r5 = r1.cprops     // Catch:{ Exception -> 0x047f }
            com.lowagie.text.DocListener r10 = r1.document     // Catch:{ Exception -> 0x047f }
            com.lowagie.text.Image r5 = r4.getImage(r3, r2, r5, r10)     // Catch:{ Exception -> 0x047f }
            goto L_0x018f
        L_0x018e:
            r5 = 0
        L_0x018f:
            if (r5 != 0) goto L_0x01d4
            java.util.HashMap r4 = r1.interfaceProps     // Catch:{ Exception -> 0x047f }
            java.lang.String r10 = "img_static"
            java.lang.Object r4 = r4.get(r10)     // Catch:{ Exception -> 0x047f }
            java.util.HashMap r4 = (java.util.HashMap) r4     // Catch:{ Exception -> 0x047f }
            if (r4 == 0) goto L_0x01aa
            java.lang.Object r4 = r4.get(r3)     // Catch:{ Exception -> 0x047f }
            com.lowagie.text.Image r4 = (com.lowagie.text.Image) r4     // Catch:{ Exception -> 0x047f }
            if (r4 == 0) goto L_0x01d4
            com.lowagie.text.Image r5 = com.lowagie.text.Image.getInstance((com.lowagie.text.Image) r4)     // Catch:{ Exception -> 0x047f }
            goto L_0x01d4
        L_0x01aa:
            java.lang.String r4 = "http"
            boolean r4 = r3.startsWith(r4)     // Catch:{ Exception -> 0x047f }
            if (r4 != 0) goto L_0x01d4
            java.util.HashMap r4 = r1.interfaceProps     // Catch:{ Exception -> 0x047f }
            java.lang.String r10 = "img_baseurl"
            java.lang.Object r4 = r4.get(r10)     // Catch:{ Exception -> 0x047f }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x047f }
            if (r4 == 0) goto L_0x01d4
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x047f }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ Exception -> 0x047f }
            r5.<init>(r4)     // Catch:{ Exception -> 0x047f }
            r5.append(r3)     // Catch:{ Exception -> 0x047f }
            java.lang.String r3 = r5.toString()     // Catch:{ Exception -> 0x047f }
            com.lowagie.text.Image r5 = com.lowagie.text.Image.getInstance((java.lang.String) r3)     // Catch:{ Exception -> 0x047f }
            goto L_0x01d4
        L_0x01d3:
            r5 = 0
        L_0x01d4:
            if (r5 != 0) goto L_0x01f7
            java.lang.String r4 = "http"
            boolean r4 = r3.startsWith(r4)     // Catch:{ Exception -> 0x047f }
            if (r4 != 0) goto L_0x01f3
            com.lowagie.text.html.simpleparser.ChainedProperties r4 = r1.cprops     // Catch:{ Exception -> 0x047f }
            java.lang.String r5 = "image_path"
            java.lang.String r4 = r4.getProperty(r5)     // Catch:{ Exception -> 0x047f }
            if (r4 != 0) goto L_0x01ea
            java.lang.String r4 = ""
        L_0x01ea:
            java.io.File r5 = new java.io.File     // Catch:{ Exception -> 0x047f }
            r5.<init>(r4, r3)     // Catch:{ Exception -> 0x047f }
            java.lang.String r3 = r5.getPath()     // Catch:{ Exception -> 0x047f }
        L_0x01f3:
            com.lowagie.text.Image r5 = com.lowagie.text.Image.getInstance((java.lang.String) r3)     // Catch:{ Exception -> 0x047f }
        L_0x01f7:
            java.lang.Object r3 = r2.get(r9)     // Catch:{ Exception -> 0x047f }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x047f }
            java.lang.Object r4 = r2.get(r8)     // Catch:{ Exception -> 0x047f }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x047f }
            java.lang.String r8 = "height"
            java.lang.Object r8 = r2.get(r8)     // Catch:{ Exception -> 0x047f }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ Exception -> 0x047f }
            com.lowagie.text.html.simpleparser.ChainedProperties r9 = r1.cprops     // Catch:{ Exception -> 0x047f }
            java.lang.String r10 = "before"
            java.lang.String r9 = r9.getProperty(r10)     // Catch:{ Exception -> 0x047f }
            com.lowagie.text.html.simpleparser.ChainedProperties r10 = r1.cprops     // Catch:{ Exception -> 0x047f }
            java.lang.String r14 = "after"
            java.lang.String r10 = r10.getProperty(r14)     // Catch:{ Exception -> 0x047f }
            if (r9 == 0) goto L_0x0224
            float r9 = java.lang.Float.parseFloat(r9)     // Catch:{ Exception -> 0x047f }
            r5.setSpacingBefore(r9)     // Catch:{ Exception -> 0x047f }
        L_0x0224:
            if (r10 == 0) goto L_0x022d
            float r9 = java.lang.Float.parseFloat(r10)     // Catch:{ Exception -> 0x047f }
            r5.setSpacingAfter(r9)     // Catch:{ Exception -> 0x047f }
        L_0x022d:
            com.lowagie.text.html.simpleparser.ChainedProperties r9 = r1.cprops     // Catch:{ Exception -> 0x047f }
            java.lang.String r9 = r9.getProperty(r12)     // Catch:{ Exception -> 0x047f }
            float r9 = com.lowagie.text.html.Markup.parseLength(r9, r11)     // Catch:{ Exception -> 0x047f }
            int r10 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
            if (r10 > 0) goto L_0x023d
            r9 = 1094713344(0x41400000, float:12.0)
        L_0x023d:
            float r4 = com.lowagie.text.html.Markup.parseLength(r4, r9)     // Catch:{ Exception -> 0x047f }
            float r8 = com.lowagie.text.html.Markup.parseLength(r8, r9)     // Catch:{ Exception -> 0x047f }
            int r9 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            if (r9 <= 0) goto L_0x0251
            int r10 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1))
            if (r10 <= 0) goto L_0x0251
            r5.scaleAbsolute(r4, r8)     // Catch:{ Exception -> 0x047f }
            goto L_0x0274
        L_0x0251:
            if (r9 <= 0) goto L_0x0262
            float r8 = r5.getHeight()     // Catch:{ Exception -> 0x047f }
            float r8 = r8 * r4
            float r9 = r5.getWidth()     // Catch:{ Exception -> 0x047f }
            float r8 = r8 / r9
            r5.scaleAbsolute(r4, r8)     // Catch:{ Exception -> 0x047f }
            goto L_0x0274
        L_0x0262:
            int r4 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1))
            if (r4 <= 0) goto L_0x0274
            float r4 = r5.getWidth()     // Catch:{ Exception -> 0x047f }
            float r4 = r4 * r8
            float r9 = r5.getHeight()     // Catch:{ Exception -> 0x047f }
            float r4 = r4 / r9
            r5.scaleAbsolute(r4, r8)     // Catch:{ Exception -> 0x047f }
        L_0x0274:
            r5.setWidthPercentage(r13)     // Catch:{ Exception -> 0x047f }
            if (r3 == 0) goto L_0x02b7
            r1.endElement(r6)     // Catch:{ Exception -> 0x047f }
            boolean r4 = r3.equalsIgnoreCase(r7)     // Catch:{ Exception -> 0x047f }
            if (r4 == 0) goto L_0x0284
            r15 = 0
            goto L_0x028d
        L_0x0284:
            java.lang.String r4 = "right"
            boolean r3 = r3.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x047f }
            if (r3 == 0) goto L_0x028d
            r15 = 2
        L_0x028d:
            r5.setAlignment(r15)     // Catch:{ Exception -> 0x047f }
            java.util.HashMap r3 = r1.interfaceProps     // Catch:{ Exception -> 0x047f }
            if (r3 == 0) goto L_0x02a9
            java.util.HashMap r3 = r1.interfaceProps     // Catch:{ Exception -> 0x047f }
            java.lang.String r4 = "img_interface"
            java.lang.Object r3 = r3.get(r4)     // Catch:{ Exception -> 0x047f }
            com.lowagie.text.html.simpleparser.Img r3 = (com.lowagie.text.html.simpleparser.Img) r3     // Catch:{ Exception -> 0x047f }
            if (r3 == 0) goto L_0x02a9
            com.lowagie.text.html.simpleparser.ChainedProperties r4 = r1.cprops     // Catch:{ Exception -> 0x047f }
            com.lowagie.text.DocListener r6 = r1.document     // Catch:{ Exception -> 0x047f }
            boolean r14 = r3.process(r5, r2, r4, r6)     // Catch:{ Exception -> 0x047f }
            goto L_0x02aa
        L_0x02a9:
            r14 = 0
        L_0x02aa:
            if (r14 != 0) goto L_0x02b1
            com.lowagie.text.DocListener r2 = r1.document     // Catch:{ Exception -> 0x047f }
            r2.add(r5)     // Catch:{ Exception -> 0x047f }
        L_0x02b1:
            com.lowagie.text.html.simpleparser.ChainedProperties r2 = r1.cprops     // Catch:{ Exception -> 0x047f }
            r2.removeChain(r0)     // Catch:{ Exception -> 0x047f }
            goto L_0x02d2
        L_0x02b7:
            com.lowagie.text.html.simpleparser.ChainedProperties r2 = r1.cprops     // Catch:{ Exception -> 0x047f }
            r2.removeChain(r0)     // Catch:{ Exception -> 0x047f }
            com.lowagie.text.Paragraph r0 = r1.currentParagraph     // Catch:{ Exception -> 0x047f }
            if (r0 != 0) goto L_0x02c8
            com.lowagie.text.html.simpleparser.ChainedProperties r0 = r1.cprops     // Catch:{ Exception -> 0x047f }
            com.lowagie.text.Paragraph r0 = com.lowagie.text.html.simpleparser.FactoryProperties.createParagraph(r0)     // Catch:{ Exception -> 0x047f }
            r1.currentParagraph = r0     // Catch:{ Exception -> 0x047f }
        L_0x02c8:
            com.lowagie.text.Paragraph r0 = r1.currentParagraph     // Catch:{ Exception -> 0x047f }
            com.lowagie.text.Chunk r2 = new com.lowagie.text.Chunk     // Catch:{ Exception -> 0x047f }
            r2.<init>((com.lowagie.text.Image) r5, (float) r13, (float) r13)     // Catch:{ Exception -> 0x047f }
            r0.add(r2)     // Catch:{ Exception -> 0x047f }
        L_0x02d2:
            return
        L_0x02d3:
            r1.endElement(r6)     // Catch:{ Exception -> 0x047f }
            java.lang.String r4 = "h1"
            boolean r4 = r0.equals(r4)     // Catch:{ Exception -> 0x047f }
            if (r4 != 0) goto L_0x045c
            java.lang.String r4 = "h2"
            boolean r4 = r0.equals(r4)     // Catch:{ Exception -> 0x047f }
            if (r4 != 0) goto L_0x045c
            java.lang.String r4 = "h3"
            boolean r4 = r0.equals(r4)     // Catch:{ Exception -> 0x047f }
            if (r4 != 0) goto L_0x045c
            java.lang.String r4 = "h4"
            boolean r4 = r0.equals(r4)     // Catch:{ Exception -> 0x047f }
            if (r4 != 0) goto L_0x045c
            java.lang.String r4 = "h5"
            boolean r4 = r0.equals(r4)     // Catch:{ Exception -> 0x047f }
            if (r4 != 0) goto L_0x045c
            java.lang.String r4 = "h6"
            boolean r4 = r0.equals(r4)     // Catch:{ Exception -> 0x047f }
            if (r4 == 0) goto L_0x0308
            goto L_0x045c
        L_0x0308:
            java.lang.String r4 = "ul"
            boolean r4 = r0.equals(r4)     // Catch:{ Exception -> 0x047f }
            java.lang.String r5 = "li"
            if (r4 == 0) goto L_0x034a
            boolean r3 = r1.pendingLI     // Catch:{ Exception -> 0x047f }
            if (r3 == 0) goto L_0x0319
            r1.endElement(r5)     // Catch:{ Exception -> 0x047f }
        L_0x0319:
            r1.skipText = r15     // Catch:{ Exception -> 0x047f }
            com.lowagie.text.html.simpleparser.ChainedProperties r3 = r1.cprops     // Catch:{ Exception -> 0x047f }
            r3.addToChain(r0, r2)     // Catch:{ Exception -> 0x047f }
            com.lowagie.text.List r0 = new com.lowagie.text.List     // Catch:{ Exception -> 0x047f }
            r2 = 0
            r0.<init>((boolean) r2)     // Catch:{ Exception -> 0x047f }
            java.lang.Float r2 = new java.lang.Float     // Catch:{ Exception -> 0x033b }
            com.lowagie.text.html.simpleparser.ChainedProperties r3 = r1.cprops     // Catch:{ Exception -> 0x033b }
            java.lang.String r4 = "indent"
            java.lang.String r3 = r3.getProperty(r4)     // Catch:{ Exception -> 0x033b }
            r2.<init>(r3)     // Catch:{ Exception -> 0x033b }
            float r2 = r2.floatValue()     // Catch:{ Exception -> 0x033b }
            r0.setIndentationLeft(r2)     // Catch:{ Exception -> 0x033b }
            goto L_0x033e
        L_0x033b:
            r0.setAutoindent(r15)     // Catch:{ Exception -> 0x047f }
        L_0x033e:
            java.lang.String r2 = "•"
            r0.setListSymbol((java.lang.String) r2)     // Catch:{ Exception -> 0x047f }
            java.util.Stack r2 = r1.stack     // Catch:{ Exception -> 0x047f }
            r2.push(r0)     // Catch:{ Exception -> 0x047f }
            return
        L_0x034a:
            java.lang.String r4 = "ol"
            boolean r4 = r0.equals(r4)     // Catch:{ Exception -> 0x047f }
            if (r4 == 0) goto L_0x0383
            boolean r3 = r1.pendingLI     // Catch:{ Exception -> 0x047f }
            if (r3 == 0) goto L_0x0359
            r1.endElement(r5)     // Catch:{ Exception -> 0x047f }
        L_0x0359:
            r1.skipText = r15     // Catch:{ Exception -> 0x047f }
            com.lowagie.text.html.simpleparser.ChainedProperties r3 = r1.cprops     // Catch:{ Exception -> 0x047f }
            r3.addToChain(r0, r2)     // Catch:{ Exception -> 0x047f }
            com.lowagie.text.List r0 = new com.lowagie.text.List     // Catch:{ Exception -> 0x047f }
            r0.<init>((boolean) r15)     // Catch:{ Exception -> 0x047f }
            java.lang.Float r2 = new java.lang.Float     // Catch:{ Exception -> 0x037a }
            com.lowagie.text.html.simpleparser.ChainedProperties r3 = r1.cprops     // Catch:{ Exception -> 0x037a }
            java.lang.String r4 = "indent"
            java.lang.String r3 = r3.getProperty(r4)     // Catch:{ Exception -> 0x037a }
            r2.<init>(r3)     // Catch:{ Exception -> 0x037a }
            float r2 = r2.floatValue()     // Catch:{ Exception -> 0x037a }
            r0.setIndentationLeft(r2)     // Catch:{ Exception -> 0x037a }
            goto L_0x037d
        L_0x037a:
            r0.setAutoindent(r15)     // Catch:{ Exception -> 0x047f }
        L_0x037d:
            java.util.Stack r2 = r1.stack     // Catch:{ Exception -> 0x047f }
            r2.push(r0)     // Catch:{ Exception -> 0x047f }
            return
        L_0x0383:
            boolean r4 = r0.equals(r5)     // Catch:{ Exception -> 0x047f }
            if (r4 == 0) goto L_0x03a6
            boolean r3 = r1.pendingLI     // Catch:{ Exception -> 0x047f }
            if (r3 == 0) goto L_0x0390
            r1.endElement(r5)     // Catch:{ Exception -> 0x047f }
        L_0x0390:
            r3 = 0
            r1.skipText = r3     // Catch:{ Exception -> 0x047f }
            r1.pendingLI = r15     // Catch:{ Exception -> 0x047f }
            com.lowagie.text.html.simpleparser.ChainedProperties r3 = r1.cprops     // Catch:{ Exception -> 0x047f }
            r3.addToChain(r0, r2)     // Catch:{ Exception -> 0x047f }
            com.lowagie.text.html.simpleparser.ChainedProperties r0 = r1.cprops     // Catch:{ Exception -> 0x047f }
            com.lowagie.text.ListItem r0 = com.lowagie.text.html.simpleparser.FactoryProperties.createListItem(r0)     // Catch:{ Exception -> 0x047f }
            java.util.Stack r2 = r1.stack     // Catch:{ Exception -> 0x047f }
            r2.push(r0)     // Catch:{ Exception -> 0x047f }
            return
        L_0x03a6:
            java.lang.String r4 = "div"
            boolean r4 = r0.equals(r4)     // Catch:{ Exception -> 0x047f }
            if (r4 != 0) goto L_0x0456
            java.lang.String r4 = "body"
            boolean r4 = r0.equals(r4)     // Catch:{ Exception -> 0x047f }
            if (r4 != 0) goto L_0x0456
            boolean r4 = r0.equals(r6)     // Catch:{ Exception -> 0x047f }
            if (r4 == 0) goto L_0x03be
            goto L_0x0456
        L_0x03be:
            java.lang.String r4 = "pre"
            boolean r4 = r0.equals(r4)     // Catch:{ Exception -> 0x047f }
            if (r4 == 0) goto L_0x03dd
            java.lang.String r3 = "face"
            boolean r3 = r2.containsKey(r3)     // Catch:{ Exception -> 0x047f }
            if (r3 != 0) goto L_0x03d5
            java.lang.String r3 = "face"
            java.lang.String r4 = "Courier"
            r2.put(r3, r4)     // Catch:{ Exception -> 0x047f }
        L_0x03d5:
            com.lowagie.text.html.simpleparser.ChainedProperties r3 = r1.cprops     // Catch:{ Exception -> 0x047f }
            r3.addToChain(r0, r2)     // Catch:{ Exception -> 0x047f }
            r1.isPRE = r15     // Catch:{ Exception -> 0x047f }
            return
        L_0x03dd:
            boolean r4 = r0.equals(r3)     // Catch:{ Exception -> 0x047f }
            if (r4 == 0) goto L_0x03f4
            boolean r0 = r1.pendingTR     // Catch:{ Exception -> 0x047f }
            if (r0 == 0) goto L_0x03ea
            r1.endElement(r3)     // Catch:{ Exception -> 0x047f }
        L_0x03ea:
            r1.skipText = r15     // Catch:{ Exception -> 0x047f }
            r1.pendingTR = r15     // Catch:{ Exception -> 0x047f }
            com.lowagie.text.html.simpleparser.ChainedProperties r0 = r1.cprops     // Catch:{ Exception -> 0x047f }
            r0.addToChain(r3, r2)     // Catch:{ Exception -> 0x047f }
            return
        L_0x03f4:
            java.lang.String r3 = "td"
            boolean r3 = r0.equals(r3)     // Catch:{ Exception -> 0x047f }
            if (r3 != 0) goto L_0x0436
            java.lang.String r3 = "th"
            boolean r3 = r0.equals(r3)     // Catch:{ Exception -> 0x047f }
            if (r3 == 0) goto L_0x0405
            goto L_0x0436
        L_0x0405:
            java.lang.String r3 = "table"
            boolean r0 = r0.equals(r3)     // Catch:{ Exception -> 0x047f }
            if (r0 == 0) goto L_0x0435
            com.lowagie.text.html.simpleparser.ChainedProperties r0 = r1.cprops     // Catch:{ Exception -> 0x047f }
            java.lang.String r3 = "table"
            r0.addToChain(r3, r2)     // Catch:{ Exception -> 0x047f }
            com.lowagie.text.html.simpleparser.IncTable r0 = new com.lowagie.text.html.simpleparser.IncTable     // Catch:{ Exception -> 0x047f }
            r0.<init>(r2)     // Catch:{ Exception -> 0x047f }
            java.util.Stack r2 = r1.stack     // Catch:{ Exception -> 0x047f }
            r2.push(r0)     // Catch:{ Exception -> 0x047f }
            java.util.Stack r0 = r1.tableState     // Catch:{ Exception -> 0x047f }
            r2 = 2
            boolean[] r2 = new boolean[r2]     // Catch:{ Exception -> 0x047f }
            boolean r3 = r1.pendingTR     // Catch:{ Exception -> 0x047f }
            r4 = 0
            r2[r4] = r3     // Catch:{ Exception -> 0x047f }
            boolean r3 = r1.pendingTD     // Catch:{ Exception -> 0x047f }
            r2[r15] = r3     // Catch:{ Exception -> 0x047f }
            r0.push(r2)     // Catch:{ Exception -> 0x047f }
            r1.pendingTD = r4     // Catch:{ Exception -> 0x047f }
            r1.pendingTR = r4     // Catch:{ Exception -> 0x047f }
            r1.skipText = r15     // Catch:{ Exception -> 0x047f }
        L_0x0435:
            return
        L_0x0436:
            boolean r3 = r1.pendingTD     // Catch:{ Exception -> 0x047f }
            if (r3 == 0) goto L_0x043d
            r21.endElement(r22)     // Catch:{ Exception -> 0x047f }
        L_0x043d:
            r3 = 0
            r1.skipText = r3     // Catch:{ Exception -> 0x047f }
            r1.pendingTD = r15     // Catch:{ Exception -> 0x047f }
            com.lowagie.text.html.simpleparser.ChainedProperties r3 = r1.cprops     // Catch:{ Exception -> 0x047f }
            java.lang.String r4 = "td"
            r3.addToChain(r4, r2)     // Catch:{ Exception -> 0x047f }
            java.util.Stack r2 = r1.stack     // Catch:{ Exception -> 0x047f }
            com.lowagie.text.html.simpleparser.IncCell r3 = new com.lowagie.text.html.simpleparser.IncCell     // Catch:{ Exception -> 0x047f }
            com.lowagie.text.html.simpleparser.ChainedProperties r4 = r1.cprops     // Catch:{ Exception -> 0x047f }
            r3.<init>(r0, r4)     // Catch:{ Exception -> 0x047f }
            r2.push(r3)     // Catch:{ Exception -> 0x047f }
            return
        L_0x0456:
            com.lowagie.text.html.simpleparser.ChainedProperties r3 = r1.cprops     // Catch:{ Exception -> 0x047f }
            r3.addToChain(r0, r2)     // Catch:{ Exception -> 0x047f }
            return
        L_0x045c:
            boolean r3 = r2.containsKey(r12)     // Catch:{ Exception -> 0x047f }
            if (r3 != 0) goto L_0x0473
            java.lang.String r3 = r0.substring(r15)     // Catch:{ Exception -> 0x047f }
            int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ Exception -> 0x047f }
            int r3 = 7 - r3
            java.lang.String r3 = java.lang.Integer.toString(r3)     // Catch:{ Exception -> 0x047f }
            r2.put(r12, r3)     // Catch:{ Exception -> 0x047f }
        L_0x0473:
            com.lowagie.text.html.simpleparser.ChainedProperties r3 = r1.cprops     // Catch:{ Exception -> 0x047f }
            r3.addToChain(r0, r2)     // Catch:{ Exception -> 0x047f }
            return
        L_0x0479:
            com.lowagie.text.html.simpleparser.ChainedProperties r3 = r1.cprops     // Catch:{ Exception -> 0x047f }
            r3.addToChain(r0, r2)     // Catch:{ Exception -> 0x047f }
            return
        L_0x047f:
            r0 = move-exception
            com.lowagie.text.ExceptionConverter r2 = new com.lowagie.text.ExceptionConverter
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.html.simpleparser.HTMLWorker.startElement(java.lang.String, java.util.HashMap):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0045, code lost:
        r6 = (com.lowagie.text.html.simpleparser.ALink) r5.interfaceProps.get("alink_interface");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void endElement(java.lang.String r6) {
        /*
            r5 = this;
            java.lang.String r0 = "table"
            java.lang.String r1 = "a"
            java.util.HashMap r2 = tagsSupported
            boolean r2 = r2.containsKey(r6)
            if (r2 != 0) goto L_0x000d
            return
        L_0x000d:
            java.util.HashMap r2 = com.lowagie.text.html.simpleparser.FactoryProperties.followTags     // Catch:{ Exception -> 0x02bd }
            java.lang.Object r2 = r2.get(r6)     // Catch:{ Exception -> 0x02bd }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x02bd }
            if (r2 == 0) goto L_0x001d
            com.lowagie.text.html.simpleparser.ChainedProperties r6 = r5.cprops     // Catch:{ Exception -> 0x02bd }
            r6.removeChain(r2)     // Catch:{ Exception -> 0x02bd }
            return
        L_0x001d:
            java.lang.String r2 = "font"
            boolean r2 = r6.equals(r2)     // Catch:{ Exception -> 0x02bd }
            if (r2 != 0) goto L_0x02b7
            java.lang.String r2 = "span"
            boolean r2 = r6.equals(r2)     // Catch:{ Exception -> 0x02bd }
            if (r2 == 0) goto L_0x002f
            goto L_0x02b7
        L_0x002f:
            boolean r2 = r6.equals(r1)     // Catch:{ Exception -> 0x02bd }
            r3 = 0
            if (r2 == 0) goto L_0x009d
            com.lowagie.text.Paragraph r6 = r5.currentParagraph     // Catch:{ Exception -> 0x02bd }
            if (r6 != 0) goto L_0x0041
            com.lowagie.text.Paragraph r6 = new com.lowagie.text.Paragraph     // Catch:{ Exception -> 0x02bd }
            r6.<init>()     // Catch:{ Exception -> 0x02bd }
            r5.currentParagraph = r6     // Catch:{ Exception -> 0x02bd }
        L_0x0041:
            java.util.HashMap r6 = r5.interfaceProps     // Catch:{ Exception -> 0x02bd }
            if (r6 == 0) goto L_0x005a
            java.util.HashMap r6 = r5.interfaceProps     // Catch:{ Exception -> 0x02bd }
            java.lang.String r0 = "alink_interface"
            java.lang.Object r6 = r6.get(r0)     // Catch:{ Exception -> 0x02bd }
            com.lowagie.text.html.simpleparser.ALink r6 = (com.lowagie.text.html.simpleparser.ALink) r6     // Catch:{ Exception -> 0x02bd }
            if (r6 == 0) goto L_0x005a
            com.lowagie.text.Paragraph r0 = r5.currentParagraph     // Catch:{ Exception -> 0x02bd }
            com.lowagie.text.html.simpleparser.ChainedProperties r2 = r5.cprops     // Catch:{ Exception -> 0x02bd }
            boolean r6 = r6.process(r0, r2)     // Catch:{ Exception -> 0x02bd }
            goto L_0x005b
        L_0x005a:
            r6 = 0
        L_0x005b:
            if (r6 != 0) goto L_0x0080
            com.lowagie.text.html.simpleparser.ChainedProperties r6 = r5.cprops     // Catch:{ Exception -> 0x02bd }
            java.lang.String r0 = "href"
            java.lang.String r6 = r6.getProperty(r0)     // Catch:{ Exception -> 0x02bd }
            if (r6 == 0) goto L_0x0080
            com.lowagie.text.Paragraph r0 = r5.currentParagraph     // Catch:{ Exception -> 0x02bd }
            java.util.ArrayList r0 = r0.getChunks()     // Catch:{ Exception -> 0x02bd }
            int r2 = r0.size()     // Catch:{ Exception -> 0x02bd }
        L_0x0071:
            if (r3 < r2) goto L_0x0074
            goto L_0x0080
        L_0x0074:
            java.lang.Object r4 = r0.get(r3)     // Catch:{ Exception -> 0x02bd }
            com.lowagie.text.Chunk r4 = (com.lowagie.text.Chunk) r4     // Catch:{ Exception -> 0x02bd }
            r4.setAnchor((java.lang.String) r6)     // Catch:{ Exception -> 0x02bd }
            int r3 = r3 + 1
            goto L_0x0071
        L_0x0080:
            java.util.Stack r6 = r5.stack     // Catch:{ Exception -> 0x02bd }
            java.lang.Object r6 = r6.pop()     // Catch:{ Exception -> 0x02bd }
            com.lowagie.text.Paragraph r6 = (com.lowagie.text.Paragraph) r6     // Catch:{ Exception -> 0x02bd }
            com.lowagie.text.Phrase r0 = new com.lowagie.text.Phrase     // Catch:{ Exception -> 0x02bd }
            r0.<init>()     // Catch:{ Exception -> 0x02bd }
            com.lowagie.text.Paragraph r2 = r5.currentParagraph     // Catch:{ Exception -> 0x02bd }
            r0.add(r2)     // Catch:{ Exception -> 0x02bd }
            r6.add(r0)     // Catch:{ Exception -> 0x02bd }
            r5.currentParagraph = r6     // Catch:{ Exception -> 0x02bd }
            com.lowagie.text.html.simpleparser.ChainedProperties r6 = r5.cprops     // Catch:{ Exception -> 0x02bd }
            r6.removeChain(r1)     // Catch:{ Exception -> 0x02bd }
            return
        L_0x009d:
            java.lang.String r1 = "br"
            boolean r1 = r6.equals(r1)     // Catch:{ Exception -> 0x02bd }
            if (r1 == 0) goto L_0x00a6
            return
        L_0x00a6:
            com.lowagie.text.Paragraph r1 = r5.currentParagraph     // Catch:{ Exception -> 0x02bd }
            if (r1 == 0) goto L_0x00d1
            java.util.Stack r1 = r5.stack     // Catch:{ Exception -> 0x02bd }
            boolean r1 = r1.empty()     // Catch:{ Exception -> 0x02bd }
            if (r1 == 0) goto L_0x00ba
            com.lowagie.text.DocListener r1 = r5.document     // Catch:{ Exception -> 0x02bd }
            com.lowagie.text.Paragraph r2 = r5.currentParagraph     // Catch:{ Exception -> 0x02bd }
            r1.add(r2)     // Catch:{ Exception -> 0x02bd }
            goto L_0x00d1
        L_0x00ba:
            java.util.Stack r1 = r5.stack     // Catch:{ Exception -> 0x02bd }
            java.lang.Object r1 = r1.pop()     // Catch:{ Exception -> 0x02bd }
            boolean r2 = r1 instanceof com.lowagie.text.TextElementArray     // Catch:{ Exception -> 0x02bd }
            if (r2 == 0) goto L_0x00cc
            r2 = r1
            com.lowagie.text.TextElementArray r2 = (com.lowagie.text.TextElementArray) r2     // Catch:{ Exception -> 0x02bd }
            com.lowagie.text.Paragraph r4 = r5.currentParagraph     // Catch:{ Exception -> 0x02bd }
            r2.add(r4)     // Catch:{ Exception -> 0x02bd }
        L_0x00cc:
            java.util.Stack r2 = r5.stack     // Catch:{ Exception -> 0x02bd }
            r2.push(r1)     // Catch:{ Exception -> 0x02bd }
        L_0x00d1:
            r1 = 0
            r5.currentParagraph = r1     // Catch:{ Exception -> 0x02bd }
            java.lang.String r1 = "ul"
            boolean r1 = r6.equals(r1)     // Catch:{ Exception -> 0x02bd }
            java.lang.String r2 = "li"
            if (r1 != 0) goto L_0x0274
            java.lang.String r1 = "ol"
            boolean r1 = r6.equals(r1)     // Catch:{ Exception -> 0x02bd }
            if (r1 == 0) goto L_0x00e8
            goto L_0x0274
        L_0x00e8:
            boolean r1 = r6.equals(r2)     // Catch:{ Exception -> 0x02bd }
            r2 = 1
            if (r1 == 0) goto L_0x015a
            r5.pendingLI = r3     // Catch:{ Exception -> 0x02bd }
            r5.skipText = r2     // Catch:{ Exception -> 0x02bd }
            com.lowagie.text.html.simpleparser.ChainedProperties r0 = r5.cprops     // Catch:{ Exception -> 0x02bd }
            r0.removeChain(r6)     // Catch:{ Exception -> 0x02bd }
            java.util.Stack r6 = r5.stack     // Catch:{ Exception -> 0x02bd }
            boolean r6 = r6.empty()     // Catch:{ Exception -> 0x02bd }
            if (r6 == 0) goto L_0x0101
            return
        L_0x0101:
            java.util.Stack r6 = r5.stack     // Catch:{ Exception -> 0x02bd }
            java.lang.Object r6 = r6.pop()     // Catch:{ Exception -> 0x02bd }
            boolean r0 = r6 instanceof com.lowagie.text.ListItem     // Catch:{ Exception -> 0x02bd }
            if (r0 != 0) goto L_0x0111
            java.util.Stack r0 = r5.stack     // Catch:{ Exception -> 0x02bd }
            r0.push(r6)     // Catch:{ Exception -> 0x02bd }
            return
        L_0x0111:
            java.util.Stack r0 = r5.stack     // Catch:{ Exception -> 0x02bd }
            boolean r0 = r0.empty()     // Catch:{ Exception -> 0x02bd }
            if (r0 == 0) goto L_0x0121
            com.lowagie.text.DocListener r0 = r5.document     // Catch:{ Exception -> 0x02bd }
            com.lowagie.text.Element r6 = (com.lowagie.text.Element) r6     // Catch:{ Exception -> 0x02bd }
            r0.add(r6)     // Catch:{ Exception -> 0x02bd }
            return
        L_0x0121:
            java.util.Stack r0 = r5.stack     // Catch:{ Exception -> 0x02bd }
            java.lang.Object r0 = r0.pop()     // Catch:{ Exception -> 0x02bd }
            boolean r1 = r0 instanceof com.lowagie.text.List     // Catch:{ Exception -> 0x02bd }
            if (r1 != 0) goto L_0x0131
            java.util.Stack r6 = r5.stack     // Catch:{ Exception -> 0x02bd }
            r6.push(r0)     // Catch:{ Exception -> 0x02bd }
            return
        L_0x0131:
            com.lowagie.text.ListItem r6 = (com.lowagie.text.ListItem) r6     // Catch:{ Exception -> 0x02bd }
            r1 = r0
            com.lowagie.text.List r1 = (com.lowagie.text.List) r1     // Catch:{ Exception -> 0x02bd }
            r1.add(r6)     // Catch:{ Exception -> 0x02bd }
            java.util.ArrayList r1 = r6.getChunks()     // Catch:{ Exception -> 0x02bd }
            boolean r2 = r1.isEmpty()     // Catch:{ Exception -> 0x02bd }
            if (r2 != 0) goto L_0x0154
            com.lowagie.text.Chunk r6 = r6.getListSymbol()     // Catch:{ Exception -> 0x02bd }
            java.lang.Object r1 = r1.get(r3)     // Catch:{ Exception -> 0x02bd }
            com.lowagie.text.Chunk r1 = (com.lowagie.text.Chunk) r1     // Catch:{ Exception -> 0x02bd }
            com.lowagie.text.Font r1 = r1.getFont()     // Catch:{ Exception -> 0x02bd }
            r6.setFont(r1)     // Catch:{ Exception -> 0x02bd }
        L_0x0154:
            java.util.Stack r6 = r5.stack     // Catch:{ Exception -> 0x02bd }
            r6.push(r0)     // Catch:{ Exception -> 0x02bd }
            return
        L_0x015a:
            java.lang.String r1 = "div"
            boolean r1 = r6.equals(r1)     // Catch:{ Exception -> 0x02bd }
            if (r1 != 0) goto L_0x026e
            java.lang.String r1 = "body"
            boolean r1 = r6.equals(r1)     // Catch:{ Exception -> 0x02bd }
            if (r1 == 0) goto L_0x016c
            goto L_0x026e
        L_0x016c:
            java.lang.String r1 = "pre"
            boolean r1 = r6.equals(r1)     // Catch:{ Exception -> 0x02bd }
            if (r1 == 0) goto L_0x017c
            com.lowagie.text.html.simpleparser.ChainedProperties r0 = r5.cprops     // Catch:{ Exception -> 0x02bd }
            r0.removeChain(r6)     // Catch:{ Exception -> 0x02bd }
            r5.isPRE = r3     // Catch:{ Exception -> 0x02bd }
            return
        L_0x017c:
            java.lang.String r1 = "p"
            boolean r1 = r6.equals(r1)     // Catch:{ Exception -> 0x02bd }
            if (r1 == 0) goto L_0x018a
            com.lowagie.text.html.simpleparser.ChainedProperties r0 = r5.cprops     // Catch:{ Exception -> 0x02bd }
            r0.removeChain(r6)     // Catch:{ Exception -> 0x02bd }
            return
        L_0x018a:
            java.lang.String r1 = "h1"
            boolean r1 = r6.equals(r1)     // Catch:{ Exception -> 0x02bd }
            if (r1 != 0) goto L_0x0268
            java.lang.String r1 = "h2"
            boolean r1 = r6.equals(r1)     // Catch:{ Exception -> 0x02bd }
            if (r1 != 0) goto L_0x0268
            java.lang.String r1 = "h3"
            boolean r1 = r6.equals(r1)     // Catch:{ Exception -> 0x02bd }
            if (r1 != 0) goto L_0x0268
            java.lang.String r1 = "h4"
            boolean r1 = r6.equals(r1)     // Catch:{ Exception -> 0x02bd }
            if (r1 != 0) goto L_0x0268
            java.lang.String r1 = "h5"
            boolean r1 = r6.equals(r1)     // Catch:{ Exception -> 0x02bd }
            if (r1 != 0) goto L_0x0268
            java.lang.String r1 = "h6"
            boolean r1 = r6.equals(r1)     // Catch:{ Exception -> 0x02bd }
            if (r1 == 0) goto L_0x01bc
            goto L_0x0268
        L_0x01bc:
            boolean r1 = r6.equals(r0)     // Catch:{ Exception -> 0x02bd }
            java.lang.String r4 = "tr"
            if (r1 == 0) goto L_0x020b
            boolean r6 = r5.pendingTR     // Catch:{ Exception -> 0x02bd }
            if (r6 == 0) goto L_0x01cb
            r5.endElement(r4)     // Catch:{ Exception -> 0x02bd }
        L_0x01cb:
            com.lowagie.text.html.simpleparser.ChainedProperties r6 = r5.cprops     // Catch:{ Exception -> 0x02bd }
            r6.removeChain(r0)     // Catch:{ Exception -> 0x02bd }
            java.util.Stack r6 = r5.stack     // Catch:{ Exception -> 0x02bd }
            java.lang.Object r6 = r6.pop()     // Catch:{ Exception -> 0x02bd }
            com.lowagie.text.html.simpleparser.IncTable r6 = (com.lowagie.text.html.simpleparser.IncTable) r6     // Catch:{ Exception -> 0x02bd }
            com.lowagie.text.pdf.PdfPTable r6 = r6.buildTable()     // Catch:{ Exception -> 0x02bd }
            r6.setSplitRows(r2)     // Catch:{ Exception -> 0x02bd }
            java.util.Stack r0 = r5.stack     // Catch:{ Exception -> 0x02bd }
            boolean r0 = r0.empty()     // Catch:{ Exception -> 0x02bd }
            if (r0 == 0) goto L_0x01ed
            com.lowagie.text.DocListener r0 = r5.document     // Catch:{ Exception -> 0x02bd }
            r0.add(r6)     // Catch:{ Exception -> 0x02bd }
            goto L_0x01f8
        L_0x01ed:
            java.util.Stack r0 = r5.stack     // Catch:{ Exception -> 0x02bd }
            java.lang.Object r0 = r0.peek()     // Catch:{ Exception -> 0x02bd }
            com.lowagie.text.TextElementArray r0 = (com.lowagie.text.TextElementArray) r0     // Catch:{ Exception -> 0x02bd }
            r0.add(r6)     // Catch:{ Exception -> 0x02bd }
        L_0x01f8:
            java.util.Stack r6 = r5.tableState     // Catch:{ Exception -> 0x02bd }
            java.lang.Object r6 = r6.pop()     // Catch:{ Exception -> 0x02bd }
            boolean[] r6 = (boolean[]) r6     // Catch:{ Exception -> 0x02bd }
            boolean r0 = r6[r3]     // Catch:{ Exception -> 0x02bd }
            r5.pendingTR = r0     // Catch:{ Exception -> 0x02bd }
            boolean r6 = r6[r2]     // Catch:{ Exception -> 0x02bd }
            r5.pendingTD = r6     // Catch:{ Exception -> 0x02bd }
            r5.skipText = r3     // Catch:{ Exception -> 0x02bd }
            return
        L_0x020b:
            boolean r0 = r6.equals(r4)     // Catch:{ Exception -> 0x02bd }
            java.lang.String r1 = "td"
            if (r0 == 0) goto L_0x024e
            boolean r6 = r5.pendingTD     // Catch:{ Exception -> 0x02bd }
            if (r6 == 0) goto L_0x021a
            r5.endElement(r1)     // Catch:{ Exception -> 0x02bd }
        L_0x021a:
            r5.pendingTR = r3     // Catch:{ Exception -> 0x02bd }
            com.lowagie.text.html.simpleparser.ChainedProperties r6 = r5.cprops     // Catch:{ Exception -> 0x02bd }
            r6.removeChain(r4)     // Catch:{ Exception -> 0x02bd }
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ Exception -> 0x02bd }
            r6.<init>()     // Catch:{ Exception -> 0x02bd }
        L_0x0226:
            java.util.Stack r0 = r5.stack     // Catch:{ Exception -> 0x02bd }
            java.lang.Object r0 = r0.pop()     // Catch:{ Exception -> 0x02bd }
            boolean r1 = r0 instanceof com.lowagie.text.html.simpleparser.IncCell     // Catch:{ Exception -> 0x02bd }
            if (r1 == 0) goto L_0x023a
            r1 = r0
            com.lowagie.text.html.simpleparser.IncCell r1 = (com.lowagie.text.html.simpleparser.IncCell) r1     // Catch:{ Exception -> 0x02bd }
            com.lowagie.text.pdf.PdfPCell r1 = r1.getCell()     // Catch:{ Exception -> 0x02bd }
            r6.add(r1)     // Catch:{ Exception -> 0x02bd }
        L_0x023a:
            boolean r1 = r0 instanceof com.lowagie.text.html.simpleparser.IncTable     // Catch:{ Exception -> 0x02bd }
            if (r1 == 0) goto L_0x0226
            com.lowagie.text.html.simpleparser.IncTable r0 = (com.lowagie.text.html.simpleparser.IncTable) r0     // Catch:{ Exception -> 0x02bd }
            r0.addCols(r6)     // Catch:{ Exception -> 0x02bd }
            r0.endRow()     // Catch:{ Exception -> 0x02bd }
            java.util.Stack r6 = r5.stack     // Catch:{ Exception -> 0x02bd }
            r6.push(r0)     // Catch:{ Exception -> 0x02bd }
            r5.skipText = r2     // Catch:{ Exception -> 0x02bd }
            return
        L_0x024e:
            boolean r0 = r6.equals(r1)     // Catch:{ Exception -> 0x02bd }
            if (r0 != 0) goto L_0x025e
            java.lang.String r0 = "th"
            boolean r6 = r6.equals(r0)     // Catch:{ Exception -> 0x02bd }
            if (r6 == 0) goto L_0x025d
            goto L_0x025e
        L_0x025d:
            return
        L_0x025e:
            r5.pendingTD = r3     // Catch:{ Exception -> 0x02bd }
            com.lowagie.text.html.simpleparser.ChainedProperties r6 = r5.cprops     // Catch:{ Exception -> 0x02bd }
            r6.removeChain(r1)     // Catch:{ Exception -> 0x02bd }
            r5.skipText = r2     // Catch:{ Exception -> 0x02bd }
            return
        L_0x0268:
            com.lowagie.text.html.simpleparser.ChainedProperties r0 = r5.cprops     // Catch:{ Exception -> 0x02bd }
            r0.removeChain(r6)     // Catch:{ Exception -> 0x02bd }
            return
        L_0x026e:
            com.lowagie.text.html.simpleparser.ChainedProperties r0 = r5.cprops     // Catch:{ Exception -> 0x02bd }
            r0.removeChain(r6)     // Catch:{ Exception -> 0x02bd }
            return
        L_0x0274:
            boolean r0 = r5.pendingLI     // Catch:{ Exception -> 0x02bd }
            if (r0 == 0) goto L_0x027b
            r5.endElement(r2)     // Catch:{ Exception -> 0x02bd }
        L_0x027b:
            r5.skipText = r3     // Catch:{ Exception -> 0x02bd }
            com.lowagie.text.html.simpleparser.ChainedProperties r0 = r5.cprops     // Catch:{ Exception -> 0x02bd }
            r0.removeChain(r6)     // Catch:{ Exception -> 0x02bd }
            java.util.Stack r6 = r5.stack     // Catch:{ Exception -> 0x02bd }
            boolean r6 = r6.empty()     // Catch:{ Exception -> 0x02bd }
            if (r6 == 0) goto L_0x028b
            return
        L_0x028b:
            java.util.Stack r6 = r5.stack     // Catch:{ Exception -> 0x02bd }
            java.lang.Object r6 = r6.pop()     // Catch:{ Exception -> 0x02bd }
            boolean r0 = r6 instanceof com.lowagie.text.List     // Catch:{ Exception -> 0x02bd }
            if (r0 != 0) goto L_0x029b
            java.util.Stack r0 = r5.stack     // Catch:{ Exception -> 0x02bd }
            r0.push(r6)     // Catch:{ Exception -> 0x02bd }
            return
        L_0x029b:
            java.util.Stack r0 = r5.stack     // Catch:{ Exception -> 0x02bd }
            boolean r0 = r0.empty()     // Catch:{ Exception -> 0x02bd }
            if (r0 == 0) goto L_0x02ab
            com.lowagie.text.DocListener r0 = r5.document     // Catch:{ Exception -> 0x02bd }
            com.lowagie.text.Element r6 = (com.lowagie.text.Element) r6     // Catch:{ Exception -> 0x02bd }
            r0.add(r6)     // Catch:{ Exception -> 0x02bd }
            goto L_0x02b6
        L_0x02ab:
            java.util.Stack r0 = r5.stack     // Catch:{ Exception -> 0x02bd }
            java.lang.Object r0 = r0.peek()     // Catch:{ Exception -> 0x02bd }
            com.lowagie.text.TextElementArray r0 = (com.lowagie.text.TextElementArray) r0     // Catch:{ Exception -> 0x02bd }
            r0.add(r6)     // Catch:{ Exception -> 0x02bd }
        L_0x02b6:
            return
        L_0x02b7:
            com.lowagie.text.html.simpleparser.ChainedProperties r0 = r5.cprops     // Catch:{ Exception -> 0x02bd }
            r0.removeChain(r6)     // Catch:{ Exception -> 0x02bd }
            return
        L_0x02bd:
            r6 = move-exception
            com.lowagie.text.ExceptionConverter r0 = new com.lowagie.text.ExceptionConverter
            r0.<init>(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.html.simpleparser.HTMLWorker.endElement(java.lang.String):void");
    }

    public void text(String str) {
        if (!this.skipText) {
            if (this.isPRE) {
                if (this.currentParagraph == null) {
                    this.currentParagraph = FactoryProperties.createParagraph(this.cprops);
                }
                this.currentParagraph.add(this.factoryProperties.createChunk(str, this.cprops));
            } else if (str.trim().length() != 0 || str.indexOf(32) >= 0) {
                StringBuffer stringBuffer = new StringBuffer();
                int length = str.length();
                boolean z = false;
                for (int i = 0; i < length; i++) {
                    char charAt = str.charAt(i);
                    if (charAt != 9) {
                        if (charAt != 10) {
                            if (charAt != 13) {
                                if (charAt != ' ') {
                                    stringBuffer.append(charAt);
                                    z = false;
                                } else if (!z) {
                                    stringBuffer.append(charAt);
                                }
                            }
                        } else if (i > 0) {
                            stringBuffer.append(' ');
                            z = true;
                        }
                    }
                }
                if (this.currentParagraph == null) {
                    this.currentParagraph = FactoryProperties.createParagraph(this.cprops);
                }
                this.currentParagraph.add(this.factoryProperties.createChunk(stringBuffer.toString(), this.cprops));
            }
        }
    }

    public boolean add(Element element) throws DocumentException {
        this.objectList.add(element);
        return true;
    }

    static {
        StringTokenizer stringTokenizer = new StringTokenizer(tagsSupportedString);
        while (stringTokenizer.hasMoreTokens()) {
            tagsSupported.put(stringTokenizer.nextToken(), (Object) null);
        }
    }
}
