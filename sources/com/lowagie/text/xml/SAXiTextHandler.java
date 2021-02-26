package com.lowagie.text.xml;

import com.lowagie.text.Anchor;
import com.lowagie.text.Annotation;
import com.lowagie.text.Cell;
import com.lowagie.text.Chapter;
import com.lowagie.text.Chunk;
import com.lowagie.text.DocListener;
import com.lowagie.text.ElementTags;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.Section;
import com.lowagie.text.TextElementArray;
import com.lowagie.text.html.HtmlTagMap;
import com.lowagie.text.pdf.BaseFont;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Properties;
import java.util.Stack;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class SAXiTextHandler extends DefaultHandler {

    /* renamed from: bf */
    private BaseFont f809bf;
    float bottomMargin;
    protected int chapters;
    protected boolean controlOpenClose;
    protected Chunk currentChunk;
    protected DocListener document;
    protected boolean ignore;
    float leftMargin;
    protected HashMap myTags;
    float rightMargin;
    protected Stack stack;
    float topMargin;

    public SAXiTextHandler(DocListener docListener) {
        this.chapters = 0;
        this.currentChunk = null;
        this.ignore = false;
        this.controlOpenClose = true;
        this.topMargin = 36.0f;
        this.rightMargin = 36.0f;
        this.leftMargin = 36.0f;
        this.bottomMargin = 36.0f;
        this.f809bf = null;
        this.document = docListener;
        this.stack = new Stack();
    }

    public SAXiTextHandler(DocListener docListener, HtmlTagMap htmlTagMap) {
        this(docListener);
        this.myTags = htmlTagMap;
    }

    public SAXiTextHandler(DocListener docListener, HtmlTagMap htmlTagMap, BaseFont baseFont) {
        this(docListener, htmlTagMap);
        this.f809bf = baseFont;
    }

    public SAXiTextHandler(DocListener docListener, HashMap hashMap) {
        this(docListener);
        this.myTags = hashMap;
    }

    public void setControlOpenClose(boolean z) {
        this.controlOpenClose = z;
    }

    public void startElement(String str, String str2, String str3, Attributes attributes) {
        Properties properties = new Properties();
        if (attributes != null) {
            for (int i = 0; i < attributes.getLength(); i++) {
                properties.setProperty(attributes.getQName(i), attributes.getValue(i));
            }
        }
        handleStartingTags(str3, properties);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:87|88|89) */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:99|100|101|102|103|104|105|106|213) */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x01ac, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:?, code lost:
        r9.document.add(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x01b9, code lost:
        throw new com.lowagie.text.ExceptionConverter(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:212:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:220:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:?, code lost:
        r9.document.add(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x017a, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:104:0x01a1 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:108:0x01ae */
    /* JADX WARNING: Missing exception handler attribute for start block: B:139:0x0246 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:87:0x0175 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleStartingTags(java.lang.String r10, java.util.Properties r11) {
        /*
            r9 = this;
            boolean r0 = r9.ignore
            if (r0 != 0) goto L_0x0372
            java.lang.String r0 = "ignore"
            boolean r0 = r0.equals(r10)
            if (r0 == 0) goto L_0x000e
            goto L_0x0372
        L_0x000e:
            com.lowagie.text.Chunk r0 = r9.currentChunk
            java.lang.String r1 = ""
            r2 = 0
            if (r0 == 0) goto L_0x0045
            java.util.Stack r0 = r9.stack     // Catch:{ EmptyStackException -> 0x001e }
            java.lang.Object r0 = r0.pop()     // Catch:{ EmptyStackException -> 0x001e }
            com.lowagie.text.TextElementArray r0 = (com.lowagie.text.TextElementArray) r0     // Catch:{ EmptyStackException -> 0x001e }
            goto L_0x0039
        L_0x001e:
            com.lowagie.text.pdf.BaseFont r0 = r9.f809bf
            if (r0 != 0) goto L_0x002e
            com.lowagie.text.Paragraph r0 = new com.lowagie.text.Paragraph
            com.lowagie.text.Font r3 = new com.lowagie.text.Font
            r3.<init>()
            r0.<init>((java.lang.String) r1, (com.lowagie.text.Font) r3)
            goto L_0x0039
        L_0x002e:
            com.lowagie.text.Paragraph r3 = new com.lowagie.text.Paragraph
            com.lowagie.text.Font r4 = new com.lowagie.text.Font
            r4.<init>((com.lowagie.text.pdf.BaseFont) r0)
            r3.<init>((java.lang.String) r1, (com.lowagie.text.Font) r4)
            r0 = r3
        L_0x0039:
            com.lowagie.text.Chunk r3 = r9.currentChunk
            r0.add(r3)
            java.util.Stack r3 = r9.stack
            r3.push(r0)
            r9.currentChunk = r2
        L_0x0045:
            java.lang.String r0 = "chunk"
            boolean r3 = r0.equals(r10)
            if (r3 == 0) goto L_0x0062
            com.lowagie.text.Chunk r10 = com.lowagie.text.factories.ElementFactory.getChunk(r11)
            r9.currentChunk = r10
            com.lowagie.text.pdf.BaseFont r10 = r9.f809bf
            if (r10 == 0) goto L_0x0061
            com.lowagie.text.Chunk r11 = r9.currentChunk
            com.lowagie.text.Font r0 = new com.lowagie.text.Font
            r0.<init>((com.lowagie.text.pdf.BaseFont) r10)
            r11.setFont(r0)
        L_0x0061:
            return
        L_0x0062:
            java.lang.String r3 = "entity"
            boolean r3 = r3.equals(r10)
            if (r3 == 0) goto L_0x0089
            com.lowagie.text.Font r10 = new com.lowagie.text.Font
            r10.<init>()
            com.lowagie.text.Chunk r1 = r9.currentChunk
            if (r1 == 0) goto L_0x007c
            r9.handleEndingTags(r0)
            com.lowagie.text.Chunk r10 = r9.currentChunk
            com.lowagie.text.Font r10 = r10.getFont()
        L_0x007c:
            java.lang.String r0 = "id"
            java.lang.String r11 = r11.getProperty(r0)
            com.lowagie.text.Chunk r10 = com.lowagie.text.xml.simpleparser.EntitiesToSymbol.get(r11, r10)
            r9.currentChunk = r10
            return
        L_0x0089:
            java.lang.String r0 = "phrase"
            boolean r0 = r0.equals(r10)
            if (r0 == 0) goto L_0x009b
            java.util.Stack r10 = r9.stack
            com.lowagie.text.Phrase r11 = com.lowagie.text.factories.ElementFactory.getPhrase(r11)
            r10.push(r11)
            return
        L_0x009b:
            java.lang.String r0 = "anchor"
            boolean r0 = r0.equals(r10)
            if (r0 == 0) goto L_0x00ad
            java.util.Stack r10 = r9.stack
            com.lowagie.text.Anchor r11 = com.lowagie.text.factories.ElementFactory.getAnchor(r11)
            r10.push(r11)
            return
        L_0x00ad:
            java.lang.String r0 = "paragraph"
            boolean r0 = r0.equals(r10)
            if (r0 != 0) goto L_0x0368
            java.lang.String r0 = "title"
            boolean r0 = r0.equals(r10)
            if (r0 == 0) goto L_0x00bf
            goto L_0x0368
        L_0x00bf:
            java.lang.String r0 = "list"
            boolean r0 = r0.equals(r10)
            if (r0 == 0) goto L_0x00d1
            java.util.Stack r10 = r9.stack
            com.lowagie.text.List r11 = com.lowagie.text.factories.ElementFactory.getList(r11)
            r10.push(r11)
            return
        L_0x00d1:
            java.lang.String r0 = "listitem"
            boolean r0 = r0.equals(r10)
            if (r0 == 0) goto L_0x00e3
            java.util.Stack r10 = r9.stack
            com.lowagie.text.ListItem r11 = com.lowagie.text.factories.ElementFactory.getListItem(r11)
            r10.push(r11)
            return
        L_0x00e3:
            java.lang.String r0 = "cell"
            boolean r0 = r0.equals(r10)
            if (r0 == 0) goto L_0x00f5
            java.util.Stack r10 = r9.stack
            com.lowagie.text.Cell r11 = com.lowagie.text.factories.ElementFactory.getCell(r11)
            r10.push(r11)
            return
        L_0x00f5:
            java.lang.String r0 = "table"
            boolean r0 = r0.equals(r10)
            if (r0 == 0) goto L_0x012a
            com.lowagie.text.Table r0 = com.lowagie.text.factories.ElementFactory.getTable(r11)
            float[] r3 = r0.getProportionalWidths()
            r10 = 0
        L_0x0106:
            int r11 = r3.length
            if (r10 < r11) goto L_0x0119
            r0.setWidths((float[]) r3)     // Catch:{ BadElementException -> 0x0112 }
            java.util.Stack r10 = r9.stack
            r10.push(r0)
            return
        L_0x0112:
            r10 = move-exception
            com.lowagie.text.ExceptionConverter r11 = new com.lowagie.text.ExceptionConverter
            r11.<init>(r10)
            throw r11
        L_0x0119:
            r11 = r3[r10]
            r1 = 0
            int r11 = (r11 > r1 ? 1 : (r11 == r1 ? 0 : -1))
            if (r11 != 0) goto L_0x0127
            r11 = 1120403456(0x42c80000, float:100.0)
            int r1 = r3.length
            float r1 = (float) r1
            float r11 = r11 / r1
            r3[r10] = r11
        L_0x0127:
            int r10 = r10 + 1
            goto L_0x0106
        L_0x012a:
            java.lang.String r0 = "section"
            boolean r0 = r0.equals(r10)
            if (r0 == 0) goto L_0x0153
            java.util.Stack r10 = r9.stack
            java.lang.Object r10 = r10.pop()
            com.lowagie.text.Element r10 = (com.lowagie.text.Element) r10
            r0 = r10
            com.lowagie.text.Section r0 = (com.lowagie.text.Section) r0     // Catch:{ ClassCastException -> 0x014c }
            com.lowagie.text.Section r11 = com.lowagie.text.factories.ElementFactory.getSection(r0, r11)     // Catch:{ ClassCastException -> 0x014c }
            java.util.Stack r0 = r9.stack
            r0.push(r10)
            java.util.Stack r10 = r9.stack
            r10.push(r11)
            return
        L_0x014c:
            r10 = move-exception
            com.lowagie.text.ExceptionConverter r11 = new com.lowagie.text.ExceptionConverter
            r11.<init>(r10)
            throw r11
        L_0x0153:
            java.lang.String r0 = "chapter"
            boolean r0 = r0.equals(r10)
            if (r0 == 0) goto L_0x0165
            java.util.Stack r10 = r9.stack
            com.lowagie.text.ChapterAutoNumber r11 = com.lowagie.text.factories.ElementFactory.getChapter(r11)
            r10.push(r11)
            return
        L_0x0165:
            java.lang.String r0 = "image"
            boolean r0 = r0.equals(r10)
            if (r0 == 0) goto L_0x0189
            com.lowagie.text.Image r10 = com.lowagie.text.factories.ElementFactory.getImage(r11)     // Catch:{ Exception -> 0x0182 }
            r9.addImage(r10)     // Catch:{ EmptyStackException -> 0x0175 }
            return
        L_0x0175:
            com.lowagie.text.DocListener r11 = r9.document     // Catch:{ DocumentException -> 0x017b }
            r11.add(r10)     // Catch:{ DocumentException -> 0x017b }
            return
        L_0x017b:
            r10 = move-exception
            com.lowagie.text.ExceptionConverter r11 = new com.lowagie.text.ExceptionConverter     // Catch:{ Exception -> 0x0182 }
            r11.<init>(r10)     // Catch:{ Exception -> 0x0182 }
            throw r11     // Catch:{ Exception -> 0x0182 }
        L_0x0182:
            r10 = move-exception
            com.lowagie.text.ExceptionConverter r11 = new com.lowagie.text.ExceptionConverter
            r11.<init>(r10)
            throw r11
        L_0x0189:
            java.lang.String r0 = "annotation"
            boolean r0 = r0.equals(r10)
            if (r0 == 0) goto L_0x01ba
            com.lowagie.text.Annotation r10 = com.lowagie.text.factories.ElementFactory.getAnnotation(r11)
            java.util.Stack r11 = r9.stack     // Catch:{ EmptyStackException -> 0x01ae }
            java.lang.Object r11 = r11.pop()     // Catch:{ EmptyStackException -> 0x01ae }
            com.lowagie.text.TextElementArray r11 = (com.lowagie.text.TextElementArray) r11     // Catch:{ EmptyStackException -> 0x01ae }
            r11.add(r10)     // Catch:{ Exception -> 0x01a1 }
            goto L_0x01a6
        L_0x01a1:
            com.lowagie.text.DocListener r0 = r9.document     // Catch:{ EmptyStackException -> 0x01ae }
            r0.add(r10)     // Catch:{ EmptyStackException -> 0x01ae }
        L_0x01a6:
            java.util.Stack r0 = r9.stack     // Catch:{ EmptyStackException -> 0x01ae }
            r0.push(r11)     // Catch:{ EmptyStackException -> 0x01ae }
            goto L_0x01b3
        L_0x01ac:
            r10 = move-exception
            goto L_0x01b4
        L_0x01ae:
            com.lowagie.text.DocListener r11 = r9.document     // Catch:{ DocumentException -> 0x01ac }
            r11.add(r10)     // Catch:{ DocumentException -> 0x01ac }
        L_0x01b3:
            return
        L_0x01b4:
            com.lowagie.text.ExceptionConverter r11 = new com.lowagie.text.ExceptionConverter
            r11.<init>(r10)
            throw r11
        L_0x01ba:
            boolean r0 = r9.isNewline(r10)
            if (r0 == 0) goto L_0x01ed
            java.util.Stack r10 = r9.stack     // Catch:{ EmptyStackException -> 0x01d3 }
            java.lang.Object r10 = r10.pop()     // Catch:{ EmptyStackException -> 0x01d3 }
            com.lowagie.text.TextElementArray r10 = (com.lowagie.text.TextElementArray) r10     // Catch:{ EmptyStackException -> 0x01d3 }
            com.lowagie.text.Chunk r11 = com.lowagie.text.Chunk.NEWLINE     // Catch:{ EmptyStackException -> 0x01d3 }
            r10.add(r11)     // Catch:{ EmptyStackException -> 0x01d3 }
            java.util.Stack r11 = r9.stack     // Catch:{ EmptyStackException -> 0x01d3 }
            r11.push(r10)     // Catch:{ EmptyStackException -> 0x01d3 }
            goto L_0x01ec
        L_0x01d3:
            com.lowagie.text.Chunk r10 = r9.currentChunk
            if (r10 != 0) goto L_0x01e7
            com.lowagie.text.DocListener r10 = r9.document     // Catch:{ DocumentException -> 0x01e0 }
            com.lowagie.text.Chunk r11 = com.lowagie.text.Chunk.NEWLINE     // Catch:{ DocumentException -> 0x01e0 }
            r10.add(r11)     // Catch:{ DocumentException -> 0x01e0 }
            goto L_0x01ec
        L_0x01e0:
            r10 = move-exception
            com.lowagie.text.ExceptionConverter r11 = new com.lowagie.text.ExceptionConverter
            r11.<init>(r10)
            throw r11
        L_0x01e7:
            java.lang.String r11 = "\n"
            r10.append(r11)
        L_0x01ec:
            return
        L_0x01ed:
            boolean r0 = r9.isNewpage(r10)
            if (r0 == 0) goto L_0x0220
            java.util.Stack r10 = r9.stack     // Catch:{ EmptyStackException -> 0x021a }
            java.lang.Object r10 = r10.pop()     // Catch:{ EmptyStackException -> 0x021a }
            com.lowagie.text.TextElementArray r10 = (com.lowagie.text.TextElementArray) r10     // Catch:{ EmptyStackException -> 0x021a }
            com.lowagie.text.Chunk r11 = new com.lowagie.text.Chunk     // Catch:{ EmptyStackException -> 0x021a }
            r11.<init>((java.lang.String) r1)     // Catch:{ EmptyStackException -> 0x021a }
            r11.setNewPage()     // Catch:{ EmptyStackException -> 0x021a }
            com.lowagie.text.pdf.BaseFont r0 = r9.f809bf     // Catch:{ EmptyStackException -> 0x021a }
            if (r0 == 0) goto L_0x0211
            com.lowagie.text.Font r0 = new com.lowagie.text.Font     // Catch:{ EmptyStackException -> 0x021a }
            com.lowagie.text.pdf.BaseFont r1 = r9.f809bf     // Catch:{ EmptyStackException -> 0x021a }
            r0.<init>((com.lowagie.text.pdf.BaseFont) r1)     // Catch:{ EmptyStackException -> 0x021a }
            r11.setFont(r0)     // Catch:{ EmptyStackException -> 0x021a }
        L_0x0211:
            r10.add(r11)     // Catch:{ EmptyStackException -> 0x021a }
            java.util.Stack r11 = r9.stack     // Catch:{ EmptyStackException -> 0x021a }
            r11.push(r10)     // Catch:{ EmptyStackException -> 0x021a }
            goto L_0x021f
        L_0x021a:
            com.lowagie.text.DocListener r10 = r9.document
            r10.newPage()
        L_0x021f:
            return
        L_0x0220:
            java.lang.String r0 = "horizontalrule"
            boolean r0 = r0.equals(r10)
            if (r0 == 0) goto L_0x0253
            com.lowagie.text.pdf.draw.LineSeparator r10 = new com.lowagie.text.pdf.draw.LineSeparator
            r4 = 1065353216(0x3f800000, float:1.0)
            r5 = 1120403456(0x42c80000, float:100.0)
            r6 = 0
            r7 = 1
            r8 = 0
            r3 = r10
            r3.<init>(r4, r5, r6, r7, r8)
            java.util.Stack r11 = r9.stack     // Catch:{ EmptyStackException -> 0x0246 }
            java.lang.Object r11 = r11.pop()     // Catch:{ EmptyStackException -> 0x0246 }
            com.lowagie.text.TextElementArray r11 = (com.lowagie.text.TextElementArray) r11     // Catch:{ EmptyStackException -> 0x0246 }
            r11.add(r10)     // Catch:{ EmptyStackException -> 0x0246 }
            java.util.Stack r0 = r9.stack     // Catch:{ EmptyStackException -> 0x0246 }
            r0.push(r11)     // Catch:{ EmptyStackException -> 0x0246 }
            goto L_0x024b
        L_0x0246:
            com.lowagie.text.DocListener r11 = r9.document     // Catch:{ DocumentException -> 0x024c }
            r11.add(r10)     // Catch:{ DocumentException -> 0x024c }
        L_0x024b:
            return
        L_0x024c:
            r10 = move-exception
            com.lowagie.text.ExceptionConverter r11 = new com.lowagie.text.ExceptionConverter
            r11.<init>(r10)
            throw r11
        L_0x0253:
            boolean r10 = r9.isDocumentRoot(r10)
            if (r10 == 0) goto L_0x0367
            java.util.Set r10 = r11.keySet()
            java.util.Iterator r10 = r10.iterator()
            java.lang.String r0 = "landscape"
            r1 = r2
            r3 = r1
        L_0x0265:
            boolean r4 = r10.hasNext()
            if (r4 != 0) goto L_0x0294
            if (r1 == 0) goto L_0x027c
            boolean r10 = r0.equals(r3)
            if (r10 == 0) goto L_0x0277
            com.lowagie.text.Rectangle r1 = r1.rotate()
        L_0x0277:
            com.lowagie.text.DocListener r10 = r9.document
            r10.setPageSize(r1)
        L_0x027c:
            com.lowagie.text.DocListener r10 = r9.document
            float r11 = r9.leftMargin
            float r0 = r9.rightMargin
            float r1 = r9.topMargin
            float r2 = r9.bottomMargin
            r10.setMargins(r11, r0, r1, r2)
            boolean r10 = r9.controlOpenClose
            if (r10 == 0) goto L_0x0367
            com.lowagie.text.DocListener r10 = r9.document
            r10.open()
            goto L_0x0367
        L_0x0294:
            java.lang.Object r4 = r10.next()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String r5 = r11.getProperty(r4)
            java.lang.String r6 = "left"
            boolean r6 = r6.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x0360 }
            java.lang.String r7 = "f"
            if (r6 == 0) goto L_0x02be
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0360 }
            java.lang.String r8 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x0360 }
            r6.<init>(r8)     // Catch:{ Exception -> 0x0360 }
            r6.append(r7)     // Catch:{ Exception -> 0x0360 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x0360 }
            float r6 = java.lang.Float.parseFloat(r6)     // Catch:{ Exception -> 0x0360 }
            r9.leftMargin = r6     // Catch:{ Exception -> 0x0360 }
        L_0x02be:
            java.lang.String r6 = "right"
            boolean r6 = r6.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x0360 }
            if (r6 == 0) goto L_0x02dc
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0360 }
            java.lang.String r8 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x0360 }
            r6.<init>(r8)     // Catch:{ Exception -> 0x0360 }
            r6.append(r7)     // Catch:{ Exception -> 0x0360 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x0360 }
            float r6 = java.lang.Float.parseFloat(r6)     // Catch:{ Exception -> 0x0360 }
            r9.rightMargin = r6     // Catch:{ Exception -> 0x0360 }
        L_0x02dc:
            java.lang.String r6 = "top"
            boolean r6 = r6.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x0360 }
            if (r6 == 0) goto L_0x02fa
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0360 }
            java.lang.String r8 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x0360 }
            r6.<init>(r8)     // Catch:{ Exception -> 0x0360 }
            r6.append(r7)     // Catch:{ Exception -> 0x0360 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x0360 }
            float r6 = java.lang.Float.parseFloat(r6)     // Catch:{ Exception -> 0x0360 }
            r9.topMargin = r6     // Catch:{ Exception -> 0x0360 }
        L_0x02fa:
            java.lang.String r6 = "bottom"
            boolean r6 = r6.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x0360 }
            if (r6 == 0) goto L_0x0318
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0360 }
            java.lang.String r8 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x0360 }
            r6.<init>(r8)     // Catch:{ Exception -> 0x0360 }
            r6.append(r7)     // Catch:{ Exception -> 0x0360 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x0360 }
            float r6 = java.lang.Float.parseFloat(r6)     // Catch:{ Exception -> 0x0360 }
            r9.bottomMargin = r6     // Catch:{ Exception -> 0x0360 }
        L_0x0318:
            java.lang.String r6 = "pagesize"
            boolean r6 = r6.equals(r4)
            if (r6 == 0) goto L_0x0335
            java.lang.Class<com.lowagie.text.PageSize> r1 = com.lowagie.text.PageSize.class
            java.lang.reflect.Field r1 = r1.getField(r5)     // Catch:{ Exception -> 0x032e }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ Exception -> 0x032e }
            com.lowagie.text.Rectangle r1 = (com.lowagie.text.Rectangle) r1     // Catch:{ Exception -> 0x032e }
            goto L_0x0265
        L_0x032e:
            r10 = move-exception
            com.lowagie.text.ExceptionConverter r11 = new com.lowagie.text.ExceptionConverter
            r11.<init>(r10)
            throw r11
        L_0x0335:
            java.lang.String r6 = "orientation"
            boolean r6 = r6.equals(r4)
            if (r6 == 0) goto L_0x034d
            boolean r4 = r0.equals(r5)     // Catch:{ Exception -> 0x0346 }
            if (r4 == 0) goto L_0x0265
            r3 = r0
            goto L_0x0265
        L_0x0346:
            r10 = move-exception
            com.lowagie.text.ExceptionConverter r11 = new com.lowagie.text.ExceptionConverter
            r11.<init>(r10)
            throw r11
        L_0x034d:
            com.lowagie.text.DocListener r6 = r9.document     // Catch:{ DocumentException -> 0x0359 }
            com.lowagie.text.Meta r7 = new com.lowagie.text.Meta     // Catch:{ DocumentException -> 0x0359 }
            r7.<init>((java.lang.String) r4, (java.lang.String) r5)     // Catch:{ DocumentException -> 0x0359 }
            r6.add(r7)     // Catch:{ DocumentException -> 0x0359 }
            goto L_0x0265
        L_0x0359:
            r10 = move-exception
            com.lowagie.text.ExceptionConverter r11 = new com.lowagie.text.ExceptionConverter
            r11.<init>(r10)
            throw r11
        L_0x0360:
            r10 = move-exception
            com.lowagie.text.ExceptionConverter r11 = new com.lowagie.text.ExceptionConverter
            r11.<init>(r10)
            throw r11
        L_0x0367:
            return
        L_0x0368:
            java.util.Stack r10 = r9.stack
            com.lowagie.text.Paragraph r11 = com.lowagie.text.factories.ElementFactory.getParagraph(r11)
            r10.push(r11)
            return
        L_0x0372:
            r10 = 1
            r9.ignore = r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.xml.SAXiTextHandler.handleStartingTags(java.lang.String, java.util.Properties):void");
    }

    /* access modifiers changed from: protected */
    public void addImage(Image image) throws EmptyStackException {
        Object pop = this.stack.pop();
        if ((pop instanceof Chapter) || (pop instanceof Section) || (pop instanceof Cell)) {
            ((TextElementArray) pop).add(image);
            this.stack.push(pop);
            return;
        }
        Stack stack2 = new Stack();
        while (!(pop instanceof Chapter) && !(pop instanceof Section) && !(pop instanceof Cell)) {
            stack2.push(pop);
            if (pop instanceof Anchor) {
                image.setAnnotation(new Annotation(0.0f, 0.0f, 0.0f, 0.0f, ((Anchor) pop).getReference()));
            }
            pop = this.stack.pop();
        }
        ((TextElementArray) pop).add(image);
        this.stack.push(pop);
        while (!stack2.empty()) {
            this.stack.push(stack2.pop());
        }
    }

    public void ignorableWhitespace(char[] cArr, int i, int i2) {
        characters(cArr, i, i2);
    }

    public void characters(char[] cArr, int i, int i2) {
        if (!this.ignore) {
            String str = new String(cArr, i, i2);
            if (str.trim().length() != 0 || str.indexOf(32) >= 0) {
                StringBuffer stringBuffer = new StringBuffer();
                int length = str.length();
                boolean z = false;
                for (int i3 = 0; i3 < length; i3++) {
                    char charAt = str.charAt(i3);
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
                        } else if (i3 > 0) {
                            stringBuffer.append(' ');
                            z = true;
                        }
                    }
                }
                Chunk chunk = this.currentChunk;
                if (chunk != null) {
                    chunk.append(stringBuffer.toString());
                } else if (this.f809bf == null) {
                    this.currentChunk = new Chunk(stringBuffer.toString());
                } else {
                    this.currentChunk = new Chunk(stringBuffer.toString(), new Font(this.f809bf));
                }
            }
        }
    }

    public void setBaseFont(BaseFont baseFont) {
        this.f809bf = baseFont;
    }

    public void endElement(String str, String str2, String str3) {
        handleEndingTags(str3);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:26|27|28|29|30) */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:128|129|130|131|132|133|134|157) */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x0254, code lost:
        if (r14.controlOpenClose != false) goto L_0x0256;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x0256, code lost:
        r14.document.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x027b, code lost:
        r15 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x0281, code lost:
        throw new com.lowagie.text.ExceptionConverter(r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x0233, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:?, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:112:0x01ee */
    /* JADX WARNING: Missing exception handler attribute for start block: B:132:0x024c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:134:0x0252 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:141:0x0275 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x0069 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00e6 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleEndingTags(java.lang.String r15) {
        /*
            r14 = this;
            java.lang.String r0 = "ignore"
            boolean r0 = r0.equals(r15)
            r1 = 0
            if (r0 == 0) goto L_0x000c
            r14.ignore = r1
            return
        L_0x000c:
            boolean r0 = r14.ignore
            if (r0 == 0) goto L_0x0011
            return
        L_0x0011:
            boolean r0 = r14.isNewpage(r15)
            if (r0 != 0) goto L_0x0282
            java.lang.String r0 = "annotation"
            boolean r0 = r0.equals(r15)
            if (r0 != 0) goto L_0x0282
            java.lang.String r0 = "image"
            boolean r0 = r0.equals(r15)
            if (r0 != 0) goto L_0x0282
            boolean r0 = r14.isNewline(r15)
            if (r0 == 0) goto L_0x002f
            goto L_0x0282
        L_0x002f:
            java.lang.String r0 = "title"
            boolean r0 = r0.equals(r15)     // Catch:{ DocumentException -> 0x027b }
            r2 = 0
            if (r0 == 0) goto L_0x005c
            java.util.Stack r15 = r14.stack     // Catch:{ DocumentException -> 0x027b }
            java.lang.Object r15 = r15.pop()     // Catch:{ DocumentException -> 0x027b }
            com.lowagie.text.Paragraph r15 = (com.lowagie.text.Paragraph) r15     // Catch:{ DocumentException -> 0x027b }
            com.lowagie.text.Chunk r0 = r14.currentChunk     // Catch:{ DocumentException -> 0x027b }
            if (r0 == 0) goto L_0x004b
            com.lowagie.text.Chunk r0 = r14.currentChunk     // Catch:{ DocumentException -> 0x027b }
            r15.add(r0)     // Catch:{ DocumentException -> 0x027b }
            r14.currentChunk = r2     // Catch:{ DocumentException -> 0x027b }
        L_0x004b:
            java.util.Stack r0 = r14.stack     // Catch:{ DocumentException -> 0x027b }
            java.lang.Object r0 = r0.pop()     // Catch:{ DocumentException -> 0x027b }
            com.lowagie.text.Section r0 = (com.lowagie.text.Section) r0     // Catch:{ DocumentException -> 0x027b }
            r0.setTitle(r15)     // Catch:{ DocumentException -> 0x027b }
            java.util.Stack r15 = r14.stack     // Catch:{ DocumentException -> 0x027b }
            r15.push(r0)     // Catch:{ DocumentException -> 0x027b }
            return
        L_0x005c:
            com.lowagie.text.Chunk r0 = r14.currentChunk     // Catch:{ DocumentException -> 0x027b }
            if (r0 == 0) goto L_0x007a
            java.util.Stack r0 = r14.stack     // Catch:{ EmptyStackException -> 0x0069 }
            java.lang.Object r0 = r0.pop()     // Catch:{ EmptyStackException -> 0x0069 }
            com.lowagie.text.TextElementArray r0 = (com.lowagie.text.TextElementArray) r0     // Catch:{ EmptyStackException -> 0x0069 }
            goto L_0x006e
        L_0x0069:
            com.lowagie.text.Paragraph r0 = new com.lowagie.text.Paragraph     // Catch:{ DocumentException -> 0x027b }
            r0.<init>()     // Catch:{ DocumentException -> 0x027b }
        L_0x006e:
            com.lowagie.text.Chunk r3 = r14.currentChunk     // Catch:{ DocumentException -> 0x027b }
            r0.add(r3)     // Catch:{ DocumentException -> 0x027b }
            java.util.Stack r3 = r14.stack     // Catch:{ DocumentException -> 0x027b }
            r3.push(r0)     // Catch:{ DocumentException -> 0x027b }
            r14.currentChunk = r2     // Catch:{ DocumentException -> 0x027b }
        L_0x007a:
            java.lang.String r0 = "chunk"
            boolean r0 = r0.equals(r15)     // Catch:{ DocumentException -> 0x027b }
            if (r0 == 0) goto L_0x0083
            return
        L_0x0083:
            java.lang.String r0 = "phrase"
            boolean r0 = r0.equals(r15)     // Catch:{ DocumentException -> 0x027b }
            if (r0 != 0) goto L_0x025c
            java.lang.String r0 = "anchor"
            boolean r0 = r0.equals(r15)     // Catch:{ DocumentException -> 0x027b }
            if (r0 != 0) goto L_0x025c
            java.lang.String r0 = "list"
            boolean r0 = r0.equals(r15)     // Catch:{ DocumentException -> 0x027b }
            if (r0 != 0) goto L_0x025c
            java.lang.String r0 = "paragraph"
            boolean r0 = r0.equals(r15)     // Catch:{ DocumentException -> 0x027b }
            if (r0 == 0) goto L_0x00a5
            goto L_0x025c
        L_0x00a5:
            java.lang.String r0 = "listitem"
            boolean r0 = r0.equals(r15)     // Catch:{ DocumentException -> 0x027b }
            if (r0 == 0) goto L_0x00c5
            java.util.Stack r0 = r14.stack     // Catch:{ DocumentException -> 0x027b }
            java.lang.Object r0 = r0.pop()     // Catch:{ DocumentException -> 0x027b }
            com.lowagie.text.ListItem r0 = (com.lowagie.text.ListItem) r0     // Catch:{ DocumentException -> 0x027b }
            java.util.Stack r2 = r14.stack     // Catch:{ DocumentException -> 0x027b }
            java.lang.Object r2 = r2.pop()     // Catch:{ DocumentException -> 0x027b }
            com.lowagie.text.List r2 = (com.lowagie.text.List) r2     // Catch:{ DocumentException -> 0x027b }
            r2.add(r0)     // Catch:{ DocumentException -> 0x027b }
            java.util.Stack r0 = r14.stack     // Catch:{ DocumentException -> 0x027b }
            r0.push(r2)     // Catch:{ DocumentException -> 0x027b }
        L_0x00c5:
            java.lang.String r0 = "table"
            boolean r0 = r0.equals(r15)     // Catch:{ DocumentException -> 0x027b }
            if (r0 == 0) goto L_0x00ec
            java.util.Stack r15 = r14.stack     // Catch:{ DocumentException -> 0x027b }
            java.lang.Object r15 = r15.pop()     // Catch:{ DocumentException -> 0x027b }
            com.lowagie.text.Table r15 = (com.lowagie.text.Table) r15     // Catch:{ DocumentException -> 0x027b }
            java.util.Stack r0 = r14.stack     // Catch:{ EmptyStackException -> 0x00e6 }
            java.lang.Object r0 = r0.pop()     // Catch:{ EmptyStackException -> 0x00e6 }
            com.lowagie.text.TextElementArray r0 = (com.lowagie.text.TextElementArray) r0     // Catch:{ EmptyStackException -> 0x00e6 }
            r0.add(r15)     // Catch:{ EmptyStackException -> 0x00e6 }
            java.util.Stack r1 = r14.stack     // Catch:{ EmptyStackException -> 0x00e6 }
            r1.push(r0)     // Catch:{ EmptyStackException -> 0x00e6 }
            goto L_0x00eb
        L_0x00e6:
            com.lowagie.text.DocListener r0 = r14.document     // Catch:{ DocumentException -> 0x027b }
            r0.add(r15)     // Catch:{ DocumentException -> 0x027b }
        L_0x00eb:
            return
        L_0x00ec:
            java.lang.String r0 = "row"
            boolean r0 = r0.equals(r15)     // Catch:{ DocumentException -> 0x027b }
            if (r0 == 0) goto L_0x0200
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ DocumentException -> 0x027b }
            r0.<init>()     // Catch:{ DocumentException -> 0x027b }
            r2 = 0
        L_0x00fa:
            java.util.Stack r3 = r14.stack     // Catch:{ DocumentException -> 0x027b }
            java.lang.Object r3 = r3.pop()     // Catch:{ DocumentException -> 0x027b }
            com.lowagie.text.Element r3 = (com.lowagie.text.Element) r3     // Catch:{ DocumentException -> 0x027b }
            int r4 = r3.type()     // Catch:{ DocumentException -> 0x027b }
            r5 = 20
            if (r4 != r5) goto L_0x0115
            com.lowagie.text.Cell r3 = (com.lowagie.text.Cell) r3     // Catch:{ DocumentException -> 0x027b }
            int r4 = r3.getColspan()     // Catch:{ DocumentException -> 0x027b }
            int r2 = r2 + r4
            r0.add(r3)     // Catch:{ DocumentException -> 0x027b }
            goto L_0x00fa
        L_0x0115:
            com.lowagie.text.Table r3 = (com.lowagie.text.Table) r3     // Catch:{ DocumentException -> 0x027b }
            int r4 = r3.getColumns()     // Catch:{ DocumentException -> 0x027b }
            if (r4 >= r2) goto L_0x0126
            int r4 = r3.getColumns()     // Catch:{ DocumentException -> 0x027b }
            int r4 = r2 - r4
            r3.addColumns(r4)     // Catch:{ DocumentException -> 0x027b }
        L_0x0126:
            java.util.Collections.reverse(r0)     // Catch:{ DocumentException -> 0x027b }
            float[] r4 = new float[r2]     // Catch:{ DocumentException -> 0x027b }
            boolean[] r5 = new boolean[r2]     // Catch:{ DocumentException -> 0x027b }
            r6 = 0
        L_0x012e:
            r7 = 1
            r8 = 0
            if (r6 < r2) goto L_0x01f8
            java.util.Iterator r0 = r0.iterator()     // Catch:{ DocumentException -> 0x027b }
            r6 = 0
            r9 = 0
        L_0x0138:
            boolean r10 = r0.hasNext()     // Catch:{ DocumentException -> 0x027b }
            r11 = 1120403456(0x42c80000, float:100.0)
            if (r10 != 0) goto L_0x018d
            float[] r0 = r3.getProportionalWidths()     // Catch:{ DocumentException -> 0x027b }
            int r6 = r0.length     // Catch:{ DocumentException -> 0x027b }
            if (r6 != r2) goto L_0x0186
            r6 = 0
            r7 = 0
        L_0x0149:
            if (r6 < r2) goto L_0x0172
            r5 = 4636737291354636288(0x4059000000000000, double:100.0)
            double r12 = (double) r9     // Catch:{ DocumentException -> 0x027b }
            int r2 = (r5 > r12 ? 1 : (r5 == r12 ? 0 : -1))
            if (r2 < 0) goto L_0x016e
        L_0x0152:
            int r2 = r0.length     // Catch:{ DocumentException -> 0x027b }
            if (r1 < r2) goto L_0x0156
            goto L_0x016e
        L_0x0156:
            r2 = r4[r1]     // Catch:{ DocumentException -> 0x027b }
            int r2 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r2 != 0) goto L_0x016b
            r2 = r0[r1]     // Catch:{ DocumentException -> 0x027b }
            int r2 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r2 == 0) goto L_0x016b
            r2 = r0[r1]     // Catch:{ DocumentException -> 0x027b }
            float r2 = r2 / r7
            float r5 = r11 - r9
            float r2 = r2 * r5
            r4[r1] = r2     // Catch:{ DocumentException -> 0x027b }
        L_0x016b:
            int r1 = r1 + 1
            goto L_0x0152
        L_0x016e:
            r3.setWidths((float[]) r4)     // Catch:{ DocumentException -> 0x027b }
            goto L_0x0186
        L_0x0172:
            boolean r10 = r5[r6]     // Catch:{ DocumentException -> 0x027b }
            if (r10 == 0) goto L_0x0183
            r10 = r0[r6]     // Catch:{ DocumentException -> 0x027b }
            int r10 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r10 == 0) goto L_0x0183
            r10 = r0[r6]     // Catch:{ DocumentException -> 0x027b }
            float r7 = r7 + r10
            r10 = r0[r6]     // Catch:{ DocumentException -> 0x027b }
            r4[r6] = r10     // Catch:{ DocumentException -> 0x027b }
        L_0x0183:
            int r6 = r6 + 1
            goto L_0x0149
        L_0x0186:
            java.util.Stack r0 = r14.stack     // Catch:{ DocumentException -> 0x027b }
            r0.push(r3)     // Catch:{ DocumentException -> 0x027b }
            goto L_0x0200
        L_0x018d:
            java.lang.Object r10 = r0.next()     // Catch:{ DocumentException -> 0x027b }
            com.lowagie.text.Cell r10 = (com.lowagie.text.Cell) r10     // Catch:{ DocumentException -> 0x027b }
            java.lang.String r12 = r10.getWidthAsString()     // Catch:{ DocumentException -> 0x027b }
            float r13 = r10.getWidth()     // Catch:{ DocumentException -> 0x027b }
            int r13 = (r13 > r8 ? 1 : (r13 == r8 ? 0 : -1))
            if (r13 != 0) goto L_0x01bc
            int r12 = r10.getColspan()     // Catch:{ DocumentException -> 0x027b }
            if (r12 != r7) goto L_0x01b3
            r12 = r4[r6]     // Catch:{ DocumentException -> 0x027b }
            int r12 = (r12 > r8 ? 1 : (r12 == r8 ? 0 : -1))
            if (r12 != 0) goto L_0x01b3
            float r12 = (float) r2
            float r11 = r11 / r12
            r4[r6] = r11     // Catch:{ Exception -> 0x01ee }
            r11 = r4[r6]     // Catch:{ Exception -> 0x01ee }
        L_0x01b1:
            float r9 = r9 + r11
            goto L_0x01ee
        L_0x01b3:
            int r11 = r10.getColspan()     // Catch:{ DocumentException -> 0x027b }
            if (r11 != r7) goto L_0x01ee
            r5[r6] = r1     // Catch:{ DocumentException -> 0x027b }
            goto L_0x01ee
        L_0x01bc:
            int r11 = r10.getColspan()     // Catch:{ DocumentException -> 0x027b }
            if (r11 != r7) goto L_0x01ee
            java.lang.String r11 = "%"
            boolean r11 = r12.endsWith(r11)     // Catch:{ DocumentException -> 0x027b }
            if (r11 == 0) goto L_0x01ee
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01ee }
            int r13 = r12.length()     // Catch:{ Exception -> 0x01ee }
            int r13 = r13 - r7
            java.lang.String r12 = r12.substring(r1, r13)     // Catch:{ Exception -> 0x01ee }
            java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch:{ Exception -> 0x01ee }
            r11.<init>(r12)     // Catch:{ Exception -> 0x01ee }
            java.lang.String r12 = "f"
            r11.append(r12)     // Catch:{ Exception -> 0x01ee }
            java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x01ee }
            float r11 = java.lang.Float.parseFloat(r11)     // Catch:{ Exception -> 0x01ee }
            r4[r6] = r11     // Catch:{ Exception -> 0x01ee }
            r11 = r4[r6]     // Catch:{ Exception -> 0x01ee }
            goto L_0x01b1
        L_0x01ee:
            int r11 = r10.getColspan()     // Catch:{ DocumentException -> 0x027b }
            int r6 = r6 + r11
            r3.addCell((com.lowagie.text.Cell) r10)     // Catch:{ DocumentException -> 0x027b }
            goto L_0x0138
        L_0x01f8:
            r4[r6] = r8     // Catch:{ DocumentException -> 0x027b }
            r5[r6] = r7     // Catch:{ DocumentException -> 0x027b }
            int r6 = r6 + 1
            goto L_0x012e
        L_0x0200:
            java.lang.String r0 = "cell"
            boolean r0 = r0.equals(r15)     // Catch:{ DocumentException -> 0x027b }
            if (r0 == 0) goto L_0x0209
            return
        L_0x0209:
            java.lang.String r0 = "section"
            boolean r0 = r0.equals(r15)     // Catch:{ DocumentException -> 0x027b }
            if (r0 == 0) goto L_0x0217
            java.util.Stack r15 = r14.stack     // Catch:{ DocumentException -> 0x027b }
            r15.pop()     // Catch:{ DocumentException -> 0x027b }
            return
        L_0x0217:
            java.lang.String r0 = "chapter"
            boolean r0 = r0.equals(r15)     // Catch:{ DocumentException -> 0x027b }
            if (r0 == 0) goto L_0x022d
            com.lowagie.text.DocListener r15 = r14.document     // Catch:{ DocumentException -> 0x027b }
            java.util.Stack r0 = r14.stack     // Catch:{ DocumentException -> 0x027b }
            java.lang.Object r0 = r0.pop()     // Catch:{ DocumentException -> 0x027b }
            com.lowagie.text.Element r0 = (com.lowagie.text.Element) r0     // Catch:{ DocumentException -> 0x027b }
            r15.add(r0)     // Catch:{ DocumentException -> 0x027b }
            return
        L_0x022d:
            boolean r15 = r14.isDocumentRoot(r15)     // Catch:{ DocumentException -> 0x027b }
            if (r15 == 0) goto L_0x025b
        L_0x0233:
            java.util.Stack r15 = r14.stack     // Catch:{ EmptyStackException -> 0x0252 }
            java.lang.Object r15 = r15.pop()     // Catch:{ EmptyStackException -> 0x0252 }
            com.lowagie.text.Element r15 = (com.lowagie.text.Element) r15     // Catch:{ EmptyStackException -> 0x0252 }
            java.util.Stack r0 = r14.stack     // Catch:{ EmptyStackException -> 0x024c }
            java.lang.Object r0 = r0.pop()     // Catch:{ EmptyStackException -> 0x024c }
            com.lowagie.text.TextElementArray r0 = (com.lowagie.text.TextElementArray) r0     // Catch:{ EmptyStackException -> 0x024c }
            r0.add(r15)     // Catch:{ EmptyStackException -> 0x024c }
            java.util.Stack r1 = r14.stack     // Catch:{ EmptyStackException -> 0x024c }
            r1.push(r0)     // Catch:{ EmptyStackException -> 0x024c }
            goto L_0x0233
        L_0x024c:
            com.lowagie.text.DocListener r0 = r14.document     // Catch:{ EmptyStackException -> 0x0252 }
            r0.add(r15)     // Catch:{ EmptyStackException -> 0x0252 }
            goto L_0x0233
        L_0x0252:
            boolean r15 = r14.controlOpenClose     // Catch:{ DocumentException -> 0x027b }
            if (r15 == 0) goto L_0x025b
            com.lowagie.text.DocListener r15 = r14.document     // Catch:{ DocumentException -> 0x027b }
            r15.close()     // Catch:{ DocumentException -> 0x027b }
        L_0x025b:
            return
        L_0x025c:
            java.util.Stack r15 = r14.stack     // Catch:{ DocumentException -> 0x027b }
            java.lang.Object r15 = r15.pop()     // Catch:{ DocumentException -> 0x027b }
            com.lowagie.text.Element r15 = (com.lowagie.text.Element) r15     // Catch:{ DocumentException -> 0x027b }
            java.util.Stack r0 = r14.stack     // Catch:{ EmptyStackException -> 0x0275 }
            java.lang.Object r0 = r0.pop()     // Catch:{ EmptyStackException -> 0x0275 }
            com.lowagie.text.TextElementArray r0 = (com.lowagie.text.TextElementArray) r0     // Catch:{ EmptyStackException -> 0x0275 }
            r0.add(r15)     // Catch:{ EmptyStackException -> 0x0275 }
            java.util.Stack r1 = r14.stack     // Catch:{ EmptyStackException -> 0x0275 }
            r1.push(r0)     // Catch:{ EmptyStackException -> 0x0275 }
            goto L_0x027a
        L_0x0275:
            com.lowagie.text.DocListener r0 = r14.document     // Catch:{ DocumentException -> 0x027b }
            r0.add(r15)     // Catch:{ DocumentException -> 0x027b }
        L_0x027a:
            return
        L_0x027b:
            r15 = move-exception
            com.lowagie.text.ExceptionConverter r0 = new com.lowagie.text.ExceptionConverter
            r0.<init>(r15)
            throw r0
        L_0x0282:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.xml.SAXiTextHandler.handleEndingTags(java.lang.String):void");
    }

    private boolean isNewpage(String str) {
        return ElementTags.NEWPAGE.equals(str);
    }

    private boolean isNewline(String str) {
        return ElementTags.NEWLINE.equals(str);
    }

    /* access modifiers changed from: protected */
    public boolean isDocumentRoot(String str) {
        return ElementTags.ITEXT.equals(str);
    }
}
