package com.lowagie.text.html;

import com.lowagie.text.DocWriter;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.ExceptionConverter;
import com.lowagie.text.Font;
import com.lowagie.text.Header;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.MarkedObject;
import com.lowagie.text.MarkedSection;
import com.lowagie.text.Meta;
import com.lowagie.text.Section;
import com.lowagie.text.pdf.BaseFont;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.EmptyStackException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Stack;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

public class HtmlWriter extends DocWriter {
    public static final byte[] BEGINCOMMENT = getISOBytes("<!-- ");
    public static final byte[] ENDCOMMENT = getISOBytes(" -->");
    public static final String NBSP = "&nbsp;";
    protected Stack currentfont = new Stack();
    protected HeaderFooter footer = null;
    protected HeaderFooter header = null;
    protected String imagepath = null;
    protected Properties markup = new Properties();
    protected int pageN = 0;
    protected Font standardfont = new Font();

    protected HtmlWriter(Document document, OutputStream outputStream) {
        super(document, outputStream);
        this.document.addDocListener(this);
        this.pageN = this.document.getPageNumber();
        try {
            outputStream.write(60);
            outputStream.write(getISOBytes(HtmlTags.HTML));
            outputStream.write(62);
            outputStream.write(10);
            outputStream.write(9);
            outputStream.write(60);
            outputStream.write(getISOBytes("head"));
            outputStream.write(62);
        } catch (IOException e) {
            throw new ExceptionConverter(e);
        }
    }

    public static HtmlWriter getInstance(Document document, OutputStream outputStream) {
        return new HtmlWriter(document, outputStream);
    }

    public boolean newPage() {
        try {
            writeStart("div");
            write(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            write("style");
            write("=\"");
            writeCssProperty(Markup.CSS_KEY_PAGE_BREAK_BEFORE, Markup.CSS_VALUE_ALWAYS);
            write("\" /");
            this.f571os.write(62);
            return true;
        } catch (IOException e) {
            throw new ExceptionConverter(e);
        }
    }

    public boolean add(Element element) throws DocumentException {
        if (this.pause) {
            return false;
        }
        if (!this.open || element.isContent()) {
            try {
                int type = element.type();
                if (type != 50) {
                    switch (type) {
                        case 0:
                            try {
                                Header header2 = (Header) element;
                                if ("stylesheet".equals(header2.getName())) {
                                    writeLink(header2);
                                } else if (HtmlTags.JAVASCRIPT.equals(header2.getName())) {
                                    writeJavaScript(header2);
                                } else {
                                    writeHeader(header2);
                                }
                            } catch (ClassCastException unused) {
                            }
                            return true;
                        case 1:
                            addTabs(2);
                            writeStart("title");
                            this.f571os.write(62);
                            addTabs(3);
                            write(HtmlEncoder.encode(((Meta) element).getContent()));
                            addTabs(2);
                            writeEnd("title");
                            return true;
                        case 2:
                        case 3:
                        case 4:
                            writeHeader((Meta) element);
                            return true;
                        case 5:
                            writeComment("Producer: " + HtmlEncoder.encode(((Meta) element).getContent()));
                            return true;
                        case 6:
                            writeComment("Creationdate: " + HtmlEncoder.encode(((Meta) element).getContent()));
                            return true;
                        case 7:
                            writeComment("Creator: " + HtmlEncoder.encode(((Meta) element).getContent()));
                            return true;
                        default:
                            write(element, 2);
                            return true;
                    }
                } else if (element instanceof MarkedSection) {
                    MarkedSection markedSection = (MarkedSection) element;
                    addTabs(1);
                    writeStart("div");
                    writeMarkupAttributes(markedSection.getMarkupAttributes());
                    this.f571os.write(62);
                    MarkedObject title = ((MarkedSection) element).getTitle();
                    if (title != null) {
                        this.markup = title.getMarkupAttributes();
                        title.process(this);
                    }
                    markedSection.process(this);
                    writeEnd("div");
                    return true;
                } else {
                    MarkedObject markedObject = (MarkedObject) element;
                    this.markup = markedObject.getMarkupAttributes();
                    return markedObject.process(this);
                }
            } catch (IOException e) {
                throw new ExceptionConverter(e);
            }
        } else {
            throw new DocumentException("The document is open; you can only add Elements with content.");
        }
    }

    public void open() {
        super.open();
        try {
            writeComment(Document.getVersion());
            writeComment("CreationDate: " + new Date().toString());
            addTabs(1);
            writeEnd("head");
            addTabs(1);
            writeStart("body");
            if (this.document.leftMargin() > 0.0f) {
                write(HtmlTags.LEFTMARGIN, String.valueOf(this.document.leftMargin()));
            }
            if (this.document.rightMargin() > 0.0f) {
                write(HtmlTags.RIGHTMARGIN, String.valueOf(this.document.rightMargin()));
            }
            if (this.document.topMargin() > 0.0f) {
                write(HtmlTags.TOPMARGIN, String.valueOf(this.document.topMargin()));
            }
            if (this.document.bottomMargin() > 0.0f) {
                write(HtmlTags.BOTTOMMARGIN, String.valueOf(this.document.bottomMargin()));
            }
            if (this.pageSize.getBackgroundColor() != null) {
                write(HtmlTags.BACKGROUNDCOLOR, HtmlEncoder.encode(this.pageSize.getBackgroundColor()));
            }
            if (this.document.getJavaScript_onLoad() != null) {
                write(HtmlTags.JAVASCRIPT_ONLOAD, HtmlEncoder.encode(this.document.getJavaScript_onLoad()));
            }
            if (this.document.getJavaScript_onUnLoad() != null) {
                write(HtmlTags.JAVASCRIPT_ONUNLOAD, HtmlEncoder.encode(this.document.getJavaScript_onUnLoad()));
            }
            if (this.document.getHtmlStyleClass() != null) {
                write(Markup.HTML_ATTR_CSS_CLASS, this.document.getHtmlStyleClass());
            }
            this.f571os.write(62);
            initHeader();
        } catch (IOException e) {
            throw new ExceptionConverter(e);
        }
    }

    public void close() {
        try {
            initFooter();
            addTabs(1);
            writeEnd("body");
            this.f571os.write(10);
            writeEnd(HtmlTags.HTML);
            super.close();
        } catch (IOException e) {
            throw new ExceptionConverter(e);
        }
    }

    /* access modifiers changed from: protected */
    public void initHeader() {
        HeaderFooter headerFooter = this.header;
        if (headerFooter != null) {
            try {
                add((Element) headerFooter.paragraph());
            } catch (Exception e) {
                throw new ExceptionConverter(e);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void initFooter() {
        HeaderFooter headerFooter = this.footer;
        if (headerFooter != null) {
            try {
                headerFooter.setPageNumber(this.pageN + 1);
                add((Element) this.footer.paragraph());
            } catch (Exception e) {
                throw new ExceptionConverter(e);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void writeHeader(Meta meta) throws IOException {
        addTabs(2);
        writeStart(HtmlTags.META);
        int type = meta.type();
        if (type == 0) {
            write("name", ((Header) meta).getName());
        } else if (type == 2) {
            write("name", "subject");
        } else if (type == 3) {
            write("name", "keywords");
        } else if (type == 4) {
            write("name", "author");
        }
        write("content", HtmlEncoder.encode(meta.getContent()));
        writeEnd();
    }

    /* access modifiers changed from: protected */
    public void writeLink(Header header2) throws IOException {
        addTabs(2);
        writeStart("link");
        write("rel", header2.getName());
        write("type", "text/css");
        write("href", header2.getContent());
        writeEnd();
    }

    /* access modifiers changed from: protected */
    public void writeJavaScript(Header header2) throws IOException {
        addTabs(2);
        writeStart(HtmlTags.SCRIPT);
        write(HtmlTags.LANGUAGE, HtmlTags.JAVASCRIPT);
        if (this.markup.size() > 0) {
            writeMarkupAttributes(this.markup);
            this.f571os.write(62);
            writeEnd(HtmlTags.SCRIPT);
            return;
        }
        write("type", Markup.HTML_VALUE_JAVASCRIPT);
        this.f571os.write(62);
        addTabs(2);
        write(new String(BEGINCOMMENT) + "\n");
        write(header2.getContent());
        addTabs(2);
        write("//" + new String(ENDCOMMENT));
        addTabs(2);
        writeEnd(HtmlTags.SCRIPT);
    }

    /* access modifiers changed from: protected */
    public void writeComment(String str) throws IOException {
        addTabs(2);
        this.f571os.write(BEGINCOMMENT);
        write(str);
        this.f571os.write(ENDCOMMENT);
    }

    public void setStandardFont(Font font) {
        this.standardfont = font;
    }

    public boolean isOtherFont(Font font) {
        try {
            return ((Font) this.currentfont.peek()).compareTo(font) != 0;
        } catch (EmptyStackException unused) {
            return this.standardfont.compareTo(font) != 0;
        }
    }

    public void setImagepath(String str) {
        this.imagepath = str;
    }

    public void resetImagepath() {
        this.imagepath = null;
    }

    public void setHeader(HeaderFooter headerFooter) {
        this.header = headerFooter;
    }

    public void setFooter(HeaderFooter headerFooter) {
        this.footer = headerFooter;
    }

    public boolean add(String str) {
        if (this.pause) {
            return false;
        }
        try {
            write(str);
            return true;
        } catch (IOException e) {
            throw new ExceptionConverter(e);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(19:31|32|33|34|35|(1:37)|38|(1:40)|41|(1:43)|44|(1:46)|47|(1:49)|50|(2:55|51)|217|53|54) */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x01a8, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x01ae, code lost:
        throw new com.lowagie.text.ExceptionConverter(r11);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00d1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void write(com.lowagie.text.Element r11, int r12) throws java.io.IOException {
        /*
            r10 = this;
            int r0 = r11.type()
            r1 = 29
            if (r0 == r1) goto L_0x05cd
            r1 = 50
            if (r0 == r1) goto L_0x05c4
            r1 = 0
            r2 = 47
            java.lang.String r3 = ""
            java.lang.String r4 = "pt"
            java.lang.String r5 = "line-height"
            java.lang.String r6 = "span"
            java.lang.String r7 = "align"
            r8 = 62
            r9 = 1
            switch(r0) {
                case 10: goto L_0x04fd;
                case 11: goto L_0x0497;
                case 12: goto L_0x041e;
                case 13: goto L_0x0418;
                case 14: goto L_0x03cc;
                case 15: goto L_0x0362;
                case 16: goto L_0x0418;
                case 17: goto L_0x02da;
                default: goto L_0x001f;
            }
        L_0x001f:
            java.lang.String r4 = "width"
            switch(r0) {
                case 20: goto L_0x01e1;
                case 21: goto L_0x01af;
                case 22: goto L_0x00ce;
                default: goto L_0x0024;
            }
        L_0x0024:
            switch(r0) {
                case 32: goto L_0x0028;
                case 33: goto L_0x0028;
                case 34: goto L_0x0028;
                case 35: goto L_0x0028;
                default: goto L_0x0027;
            }
        L_0x0027:
            return
        L_0x0028:
            com.lowagie.text.Image r11 = (com.lowagie.text.Image) r11
            java.net.URL r0 = r11.getUrl()
            if (r0 != 0) goto L_0x0031
            return
        L_0x0031:
            r10.addTabs(r12)
            java.lang.String r12 = "img"
            r10.writeStart(r12)
            java.net.URL r12 = r11.getUrl()
            java.lang.String r12 = r12.toString()
            java.lang.String r0 = r10.imagepath
            if (r0 == 0) goto L_0x0079
            int r0 = r12.indexOf(r2)
            if (r0 <= 0) goto L_0x0067
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = r10.imagepath
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r0.<init>(r1)
            int r1 = r12.lastIndexOf(r2)
            int r1 = r1 + r9
            java.lang.String r12 = r12.substring(r1)
            r0.append(r12)
            java.lang.String r12 = r0.toString()
            goto L_0x0079
        L_0x0067:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = r10.imagepath
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r0.<init>(r1)
            r0.append(r12)
            java.lang.String r12 = r0.toString()
        L_0x0079:
            java.lang.String r0 = "src"
            r10.write(r0, r12)
            int r12 = r11.getAlignment()
            r12 = r12 & 2
            if (r12 <= 0) goto L_0x008c
            java.lang.String r12 = "Right"
            r10.write(r7, r12)
            goto L_0x009e
        L_0x008c:
            int r12 = r11.getAlignment()
            r12 = r12 & r9
            if (r12 <= 0) goto L_0x0099
            java.lang.String r12 = "Middle"
            r10.write(r7, r12)
            goto L_0x009e
        L_0x0099:
            java.lang.String r12 = "Left"
            r10.write(r7, r12)
        L_0x009e:
            java.lang.String r12 = r11.getAlt()
            if (r12 == 0) goto L_0x00ad
            java.lang.String r12 = r11.getAlt()
            java.lang.String r0 = "alt"
            r10.write(r0, r12)
        L_0x00ad:
            float r12 = r11.getScaledWidth()
            java.lang.String r12 = java.lang.String.valueOf(r12)
            r10.write(r4, r12)
            float r11 = r11.getScaledHeight()
            java.lang.String r11 = java.lang.String.valueOf(r11)
            java.lang.String r12 = "height"
            r10.write(r12, r11)
            java.util.Properties r11 = r10.markup
            r10.writeMarkupAttributes(r11)
            r10.writeEnd()
            return
        L_0x00ce:
            com.lowagie.text.Table r11 = (com.lowagie.text.Table) r11     // Catch:{ ClassCastException -> 0x00d1 }
            goto L_0x00d7
        L_0x00d1:
            com.lowagie.text.SimpleTable r11 = (com.lowagie.text.SimpleTable) r11     // Catch:{ BadElementException -> 0x01a8 }
            com.lowagie.text.Table r11 = r11.createTable()     // Catch:{ BadElementException -> 0x01a8 }
        L_0x00d7:
            r11.complete()
            r10.addTabs(r12)
            java.lang.String r0 = "table"
            r10.writeStart(r0)
            java.util.Properties r0 = r10.markup
            r10.writeMarkupAttributes(r0)
            com.lowagie.text.pdf.OutputStreamCounter r0 = r10.f571os
            r1 = 32
            r0.write((int) r1)
            r10.write(r4)
            com.lowagie.text.pdf.OutputStreamCounter r0 = r10.f571os
            r1 = 61
            r0.write((int) r1)
            com.lowagie.text.pdf.OutputStreamCounter r0 = r10.f571os
            r1 = 34
            r0.write((int) r1)
            float r0 = r11.getWidth()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r10.write(r0)
            boolean r0 = r11.isLocked()
            if (r0 != 0) goto L_0x0115
            java.lang.String r0 = "%"
            r10.write(r0)
        L_0x0115:
            com.lowagie.text.pdf.OutputStreamCounter r0 = r10.f571os
            r1 = 34
            r0.write((int) r1)
            int r0 = r11.getAlignment()
            java.lang.String r0 = com.lowagie.text.html.HtmlEncoder.getAlignment(r0)
            boolean r1 = r3.equals(r0)
            if (r1 != 0) goto L_0x012d
            r10.write(r7, r0)
        L_0x012d:
            float r0 = r11.getPadding()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "cellpadding"
            r10.write(r1, r0)
            float r0 = r11.getSpacing()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "cellspacing"
            r10.write(r1, r0)
            float r0 = r11.getBorderWidth()
            r1 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x015e
            float r0 = r11.getBorderWidth()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "border"
            r10.write(r1, r0)
        L_0x015e:
            harmony.java.awt.Color r0 = r11.getBorderColor()
            if (r0 == 0) goto L_0x0171
            harmony.java.awt.Color r0 = r11.getBorderColor()
            java.lang.String r0 = com.lowagie.text.html.HtmlEncoder.encode((harmony.java.awt.Color) r0)
            java.lang.String r1 = "bordercolor"
            r10.write(r1, r0)
        L_0x0171:
            harmony.java.awt.Color r0 = r11.getBackgroundColor()
            if (r0 == 0) goto L_0x0184
            harmony.java.awt.Color r0 = r11.getBackgroundColor()
            java.lang.String r0 = com.lowagie.text.html.HtmlEncoder.encode((harmony.java.awt.Color) r0)
            java.lang.String r1 = "bgcolor"
            r10.write(r1, r0)
        L_0x0184:
            com.lowagie.text.pdf.OutputStreamCounter r0 = r10.f571os
            r0.write((int) r8)
            java.util.Iterator r11 = r11.iterator()
        L_0x018d:
            boolean r0 = r11.hasNext()
            if (r0 != 0) goto L_0x019c
            r10.addTabs(r12)
            java.lang.String r11 = "table"
            r10.writeEnd(r11)
            return
        L_0x019c:
            java.lang.Object r0 = r11.next()
            com.lowagie.text.Row r0 = (com.lowagie.text.Row) r0
            int r1 = r12 + 1
            r10.write((com.lowagie.text.Element) r0, (int) r1)
            goto L_0x018d
        L_0x01a8:
            r11 = move-exception
            com.lowagie.text.ExceptionConverter r12 = new com.lowagie.text.ExceptionConverter
            r12.<init>(r11)
            throw r12
        L_0x01af:
            r0 = r11
            com.lowagie.text.Row r0 = (com.lowagie.text.Row) r0
            r10.addTabs(r12)
            java.lang.String r2 = "tr"
            r10.writeStart(r2)
            java.util.Properties r11 = r10.markup
            r10.writeMarkupAttributes(r11)
            com.lowagie.text.pdf.OutputStreamCounter r11 = r10.f571os
            r11.write((int) r8)
        L_0x01c4:
            int r11 = r0.getColumns()
            if (r1 < r11) goto L_0x01d1
            r10.addTabs(r12)
            r10.writeEnd(r2)
            return
        L_0x01d1:
            java.lang.Object r11 = r0.getCell(r1)
            com.lowagie.text.Element r11 = (com.lowagie.text.Element) r11
            if (r11 == 0) goto L_0x01de
            int r3 = r12 + 1
            r10.write((com.lowagie.text.Element) r11, (int) r3)
        L_0x01de:
            int r1 = r1 + 1
            goto L_0x01c4
        L_0x01e1:
            r0 = r11
            com.lowagie.text.Cell r0 = (com.lowagie.text.Cell) r0
            r10.addTabs(r12)
            boolean r11 = r0.isHeader()
            if (r11 == 0) goto L_0x01f3
            java.lang.String r11 = "th"
            r10.writeStart(r11)
            goto L_0x01f8
        L_0x01f3:
            java.lang.String r11 = "td"
            r10.writeStart(r11)
        L_0x01f8:
            java.util.Properties r11 = r10.markup
            r10.writeMarkupAttributes(r11)
            float r11 = r0.getBorderWidth()
            r1 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r11 = (r11 > r1 ? 1 : (r11 == r1 ? 0 : -1))
            if (r11 == 0) goto L_0x0214
            float r11 = r0.getBorderWidth()
            java.lang.String r11 = java.lang.String.valueOf(r11)
            java.lang.String r1 = "border"
            r10.write(r1, r11)
        L_0x0214:
            harmony.java.awt.Color r11 = r0.getBorderColor()
            if (r11 == 0) goto L_0x0227
            harmony.java.awt.Color r11 = r0.getBorderColor()
            java.lang.String r11 = com.lowagie.text.html.HtmlEncoder.encode((harmony.java.awt.Color) r11)
            java.lang.String r1 = "bordercolor"
            r10.write(r1, r11)
        L_0x0227:
            harmony.java.awt.Color r11 = r0.getBackgroundColor()
            if (r11 == 0) goto L_0x023a
            harmony.java.awt.Color r11 = r0.getBackgroundColor()
            java.lang.String r11 = com.lowagie.text.html.HtmlEncoder.encode((harmony.java.awt.Color) r11)
            java.lang.String r1 = "bgcolor"
            r10.write(r1, r11)
        L_0x023a:
            int r11 = r0.getHorizontalAlignment()
            java.lang.String r11 = com.lowagie.text.html.HtmlEncoder.getAlignment(r11)
            boolean r1 = r3.equals(r11)
            if (r1 != 0) goto L_0x024b
            r10.write(r7, r11)
        L_0x024b:
            int r11 = r0.getVerticalAlignment()
            java.lang.String r11 = com.lowagie.text.html.HtmlEncoder.getAlignment(r11)
            boolean r1 = r3.equals(r11)
            if (r1 != 0) goto L_0x025e
            java.lang.String r1 = "valign"
            r10.write(r1, r11)
        L_0x025e:
            java.lang.String r11 = r0.getWidthAsString()
            if (r11 == 0) goto L_0x026b
            java.lang.String r11 = r0.getWidthAsString()
            r10.write(r4, r11)
        L_0x026b:
            int r11 = r0.getColspan()
            if (r11 == r9) goto L_0x027e
            int r11 = r0.getColspan()
            java.lang.String r11 = java.lang.String.valueOf(r11)
            java.lang.String r1 = "colspan"
            r10.write(r1, r11)
        L_0x027e:
            int r11 = r0.getRowspan()
            if (r11 == r9) goto L_0x0291
            int r11 = r0.getRowspan()
            java.lang.String r11 = java.lang.String.valueOf(r11)
            java.lang.String r1 = "rowspan"
            r10.write(r1, r11)
        L_0x0291:
            int r11 = r0.getMaxLines()
            if (r11 != r9) goto L_0x029e
            java.lang.String r11 = "style"
            java.lang.String r1 = "white-space: nowrap;"
            r10.write(r11, r1)
        L_0x029e:
            com.lowagie.text.pdf.OutputStreamCounter r11 = r10.f571os
            r11.write((int) r8)
            boolean r11 = r0.isEmpty()
            if (r11 == 0) goto L_0x02af
            java.lang.String r11 = "&nbsp;"
            r10.write(r11)
            goto L_0x02b9
        L_0x02af:
            java.util.Iterator r1 = r0.getElements()
        L_0x02b3:
            boolean r11 = r1.hasNext()
            if (r11 != 0) goto L_0x02ce
        L_0x02b9:
            r10.addTabs(r12)
            boolean r11 = r0.isHeader()
            if (r11 == 0) goto L_0x02c8
            java.lang.String r11 = "th"
            r10.writeEnd(r11)
            goto L_0x02cd
        L_0x02c8:
            java.lang.String r11 = "td"
            r10.writeEnd(r11)
        L_0x02cd:
            return
        L_0x02ce:
            java.lang.Object r11 = r1.next()
            com.lowagie.text.Element r11 = (com.lowagie.text.Element) r11
            int r2 = r12 + 1
            r10.write((com.lowagie.text.Element) r11, (int) r2)
            goto L_0x02b3
        L_0x02da:
            com.lowagie.text.Anchor r11 = (com.lowagie.text.Anchor) r11
            java.util.Properties r0 = new java.util.Properties
            r0.<init>()
            boolean r1 = r11.hasLeading()
            if (r1 == 0) goto L_0x02fe
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            float r2 = r11.getLeading()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r1.<init>(r2)
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            r0.setProperty(r5, r1)
        L_0x02fe:
            r10.addTabs(r12)
            java.lang.String r1 = "a"
            r10.writeStart(r1)
            java.lang.String r1 = r11.getName()
            if (r1 == 0) goto L_0x0315
            java.lang.String r1 = r11.getName()
            java.lang.String r2 = "name"
            r10.write(r2, r1)
        L_0x0315:
            java.lang.String r1 = r11.getReference()
            if (r1 == 0) goto L_0x0324
            java.lang.String r1 = r11.getReference()
            java.lang.String r2 = "href"
            r10.write(r2, r1)
        L_0x0324:
            java.util.Properties r1 = r10.markup
            r10.writeMarkupAttributes(r1)
            com.lowagie.text.Font r1 = r11.getFont()
            r10.write((com.lowagie.text.Font) r1, (java.util.Properties) r0)
            com.lowagie.text.pdf.OutputStreamCounter r0 = r10.f571os
            r0.write((int) r8)
            java.util.Stack r0 = r10.currentfont
            com.lowagie.text.Font r1 = r11.getFont()
            r0.push(r1)
            java.util.Iterator r0 = r11.iterator()
        L_0x0342:
            boolean r11 = r0.hasNext()
            if (r11 != 0) goto L_0x0356
            r10.addTabs(r12)
            java.lang.String r11 = "a"
            r10.writeEnd(r11)
            java.util.Stack r11 = r10.currentfont
            r11.pop()
            return
        L_0x0356:
            java.lang.Object r11 = r0.next()
            com.lowagie.text.Element r11 = (com.lowagie.text.Element) r11
            int r1 = r12 + 1
            r10.write((com.lowagie.text.Element) r11, (int) r1)
            goto L_0x0342
        L_0x0362:
            com.lowagie.text.ListItem r11 = (com.lowagie.text.ListItem) r11
            java.util.Properties r0 = new java.util.Properties
            r0.<init>()
            boolean r1 = r11.hasLeading()
            if (r1 == 0) goto L_0x0386
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            float r2 = r11.getTotalLeading()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r1.<init>(r2)
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            r0.setProperty(r5, r1)
        L_0x0386:
            r10.addTabs(r12)
            java.lang.String r1 = "li"
            r10.writeStart(r1)
            java.util.Properties r1 = r10.markup
            r10.writeMarkupAttributes(r1)
            com.lowagie.text.Font r1 = r11.getFont()
            r10.write((com.lowagie.text.Font) r1, (java.util.Properties) r0)
            com.lowagie.text.pdf.OutputStreamCounter r0 = r10.f571os
            r0.write((int) r8)
            java.util.Stack r0 = r10.currentfont
            com.lowagie.text.Font r1 = r11.getFont()
            r0.push(r1)
            java.util.Iterator r0 = r11.iterator()
        L_0x03ac:
            boolean r11 = r0.hasNext()
            if (r11 != 0) goto L_0x03c0
            r10.addTabs(r12)
            java.lang.String r11 = "li"
            r10.writeEnd(r11)
            java.util.Stack r11 = r10.currentfont
            r11.pop()
            return
        L_0x03c0:
            java.lang.Object r11 = r0.next()
            com.lowagie.text.Element r11 = (com.lowagie.text.Element) r11
            int r1 = r12 + 1
            r10.write((com.lowagie.text.Element) r11, (int) r1)
            goto L_0x03ac
        L_0x03cc:
            r0 = r11
            com.lowagie.text.List r0 = (com.lowagie.text.List) r0
            r10.addTabs(r12)
            boolean r11 = r0.isNumbered()
            java.lang.String r1 = "ol"
            java.lang.String r2 = "ul"
            if (r11 == 0) goto L_0x03e0
            r10.writeStart(r1)
            goto L_0x03e3
        L_0x03e0:
            r10.writeStart(r2)
        L_0x03e3:
            java.util.Properties r11 = r10.markup
            r10.writeMarkupAttributes(r11)
            com.lowagie.text.pdf.OutputStreamCounter r11 = r10.f571os
            r11.write((int) r8)
            java.util.ArrayList r11 = r0.getItems()
            java.util.Iterator r3 = r11.iterator()
        L_0x03f5:
            boolean r11 = r3.hasNext()
            if (r11 != 0) goto L_0x040c
            r10.addTabs(r12)
            boolean r11 = r0.isNumbered()
            if (r11 == 0) goto L_0x0408
            r10.writeEnd(r1)
            goto L_0x040b
        L_0x0408:
            r10.writeEnd(r2)
        L_0x040b:
            return
        L_0x040c:
            java.lang.Object r11 = r3.next()
            com.lowagie.text.Element r11 = (com.lowagie.text.Element) r11
            int r4 = r12 + 1
            r10.write((com.lowagie.text.Element) r11, (int) r4)
            goto L_0x03f5
        L_0x0418:
            com.lowagie.text.Section r11 = (com.lowagie.text.Section) r11
            r10.writeSection(r11, r12)
            return
        L_0x041e:
            com.lowagie.text.Paragraph r11 = (com.lowagie.text.Paragraph) r11
            java.util.Properties r0 = new java.util.Properties
            r0.<init>()
            boolean r1 = r11.hasLeading()
            if (r1 == 0) goto L_0x0442
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            float r2 = r11.getTotalLeading()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r1.<init>(r2)
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            r0.setProperty(r5, r1)
        L_0x0442:
            r10.addTabs(r12)
            java.lang.String r1 = "div"
            r10.writeStart(r1)
            java.util.Properties r2 = r10.markup
            r10.writeMarkupAttributes(r2)
            int r2 = r11.getAlignment()
            java.lang.String r2 = com.lowagie.text.html.HtmlEncoder.getAlignment(r2)
            boolean r3 = r3.equals(r2)
            if (r3 != 0) goto L_0x0460
            r10.write(r7, r2)
        L_0x0460:
            com.lowagie.text.Font r2 = r11.getFont()
            r10.write((com.lowagie.text.Font) r2, (java.util.Properties) r0)
            com.lowagie.text.pdf.OutputStreamCounter r0 = r10.f571os
            r0.write((int) r8)
            java.util.Stack r0 = r10.currentfont
            com.lowagie.text.Font r2 = r11.getFont()
            r0.push(r2)
            java.util.Iterator r0 = r11.iterator()
        L_0x0479:
            boolean r11 = r0.hasNext()
            if (r11 != 0) goto L_0x048b
            r10.addTabs(r12)
            r10.writeEnd(r1)
            java.util.Stack r11 = r10.currentfont
            r11.pop()
            return
        L_0x048b:
            java.lang.Object r11 = r0.next()
            com.lowagie.text.Element r11 = (com.lowagie.text.Element) r11
            int r2 = r12 + 1
            r10.write((com.lowagie.text.Element) r11, (int) r2)
            goto L_0x0479
        L_0x0497:
            com.lowagie.text.Phrase r11 = (com.lowagie.text.Phrase) r11
            java.util.Properties r0 = new java.util.Properties
            r0.<init>()
            boolean r1 = r11.hasLeading()
            if (r1 == 0) goto L_0x04bb
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            float r2 = r11.getLeading()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r1.<init>(r2)
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            r0.setProperty(r5, r1)
        L_0x04bb:
            r10.addTabs(r12)
            r10.writeStart(r6)
            java.util.Properties r1 = r10.markup
            r10.writeMarkupAttributes(r1)
            com.lowagie.text.Font r1 = r11.getFont()
            r10.write((com.lowagie.text.Font) r1, (java.util.Properties) r0)
            com.lowagie.text.pdf.OutputStreamCounter r0 = r10.f571os
            r0.write((int) r8)
            java.util.Stack r0 = r10.currentfont
            com.lowagie.text.Font r1 = r11.getFont()
            r0.push(r1)
            java.util.Iterator r0 = r11.iterator()
        L_0x04df:
            boolean r11 = r0.hasNext()
            if (r11 != 0) goto L_0x04f1
            r10.addTabs(r12)
            r10.writeEnd(r6)
            java.util.Stack r11 = r10.currentfont
            r11.pop()
            return
        L_0x04f1:
            java.lang.Object r11 = r0.next()
            com.lowagie.text.Element r11 = (com.lowagie.text.Element) r11
            int r1 = r12 + 1
            r10.write((com.lowagie.text.Element) r11, (int) r1)
            goto L_0x04df
        L_0x04fd:
            com.lowagie.text.Chunk r11 = (com.lowagie.text.Chunk) r11
            com.lowagie.text.Image r0 = r11.getImage()
            if (r0 == 0) goto L_0x0509
            r10.write((com.lowagie.text.Element) r0, (int) r12)
            return
        L_0x0509:
            boolean r0 = r11.isEmpty()
            if (r0 == 0) goto L_0x0510
            return
        L_0x0510:
            java.util.HashMap r0 = r11.getAttributes()
            if (r0 == 0) goto L_0x051f
            java.lang.String r3 = "NEWPAGE"
            java.lang.Object r3 = r0.get(r3)
            if (r3 == 0) goto L_0x051f
            return
        L_0x051f:
            com.lowagie.text.Font r3 = r11.getFont()
            boolean r3 = r10.isOtherFont(r3)
            if (r3 != 0) goto L_0x0532
            java.util.Properties r3 = r10.markup
            int r3 = r3.size()
            if (r3 > 0) goto L_0x0532
            goto L_0x0533
        L_0x0532:
            r1 = 1
        L_0x0533:
            if (r1 == 0) goto L_0x0557
            r10.addTabs(r12)
            r10.writeStart(r6)
            com.lowagie.text.Font r12 = r11.getFont()
            boolean r12 = r10.isOtherFont(r12)
            if (r12 == 0) goto L_0x054d
            com.lowagie.text.Font r12 = r11.getFont()
            r3 = 0
            r10.write((com.lowagie.text.Font) r12, (java.util.Properties) r3)
        L_0x054d:
            java.util.Properties r12 = r10.markup
            r10.writeMarkupAttributes(r12)
            com.lowagie.text.pdf.OutputStreamCounter r12 = r10.f571os
            r12.write((int) r8)
        L_0x0557:
            java.lang.String r12 = "SUBSUPSCRIPT"
            if (r0 == 0) goto L_0x0580
            java.lang.Object r3 = r0.get(r12)
            if (r3 == 0) goto L_0x0580
            java.lang.Object r3 = r0.get(r12)
            java.lang.Float r3 = (java.lang.Float) r3
            float r3 = r3.floatValue()
            r4 = 0
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 <= 0) goto L_0x0576
            java.lang.String r3 = "sup"
            r10.writeStart(r3)
            goto L_0x057b
        L_0x0576:
            java.lang.String r3 = "sub"
            r10.writeStart(r3)
        L_0x057b:
            com.lowagie.text.pdf.OutputStreamCounter r3 = r10.f571os
            r3.write((int) r8)
        L_0x0580:
            java.lang.String r11 = r11.getContent()
            java.lang.String r11 = com.lowagie.text.html.HtmlEncoder.encode((java.lang.String) r11)
            r10.write(r11)
            if (r0 == 0) goto L_0x05be
            java.lang.Object r11 = r0.get(r12)
            if (r11 == 0) goto L_0x05be
            com.lowagie.text.pdf.OutputStreamCounter r11 = r10.f571os
            r3 = 60
            r11.write((int) r3)
            com.lowagie.text.pdf.OutputStreamCounter r11 = r10.f571os
            r11.write((int) r2)
            java.lang.Object r11 = r0.get(r12)
            java.lang.Float r11 = (java.lang.Float) r11
            float r11 = r11.floatValue()
            r12 = 0
            int r11 = (r11 > r12 ? 1 : (r11 == r12 ? 0 : -1))
            if (r11 <= 0) goto L_0x05b4
            java.lang.String r11 = "sup"
            r10.write(r11)
            goto L_0x05b9
        L_0x05b4:
            java.lang.String r11 = "sub"
            r10.write(r11)
        L_0x05b9:
            com.lowagie.text.pdf.OutputStreamCounter r11 = r10.f571os
            r11.write((int) r8)
        L_0x05be:
            if (r1 == 0) goto L_0x05c3
            r10.writeEnd(r6)
        L_0x05c3:
            return
        L_0x05c4:
            r10.add((com.lowagie.text.Element) r11)     // Catch:{ DocumentException -> 0x05c8 }
            goto L_0x05cc
        L_0x05c8:
            r11 = move-exception
            r11.printStackTrace()
        L_0x05cc:
            return
        L_0x05cd:
            com.lowagie.text.Annotation r11 = (com.lowagie.text.Annotation) r11
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r0 = r11.title()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r12.<init>(r0)
            java.lang.String r0 = ": "
            r12.append(r0)
            java.lang.String r11 = r11.content()
            r12.append(r11)
            java.lang.String r11 = r12.toString()
            r10.writeComment(r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.html.HtmlWriter.write(com.lowagie.text.Element, int):void");
    }

    /* access modifiers changed from: protected */
    public void writeSection(Section section, int i) throws IOException {
        if (section.getTitle() != null) {
            int depth = section.getDepth() - 1;
            if (depth > 5) {
                depth = 5;
            }
            Properties properties = new Properties();
            if (section.getTitle().hasLeading()) {
                properties.setProperty(Markup.CSS_KEY_LINEHEIGHT, String.valueOf(section.getTitle().getTotalLeading()) + "pt");
            }
            addTabs(i);
            writeStart(HtmlTags.f605H[depth]);
            write(section.getTitle().getFont(), properties);
            String alignment = HtmlEncoder.getAlignment(section.getTitle().getAlignment());
            if (!"".equals(alignment)) {
                write("align", alignment);
            }
            writeMarkupAttributes(this.markup);
            this.f571os.write(62);
            this.currentfont.push(section.getTitle().getFont());
            Iterator it = section.getTitle().iterator();
            while (it.hasNext()) {
                write((Element) it.next(), i + 1);
            }
            addTabs(i);
            writeEnd(HtmlTags.f605H[depth]);
            this.currentfont.pop();
        }
        Iterator it2 = section.iterator();
        while (it2.hasNext()) {
            write((Element) it2.next(), i);
        }
    }

    /* access modifiers changed from: protected */
    public void write(Font font, Properties properties) throws IOException {
        if (font != null && isOtherFont(font)) {
            write(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            write("style");
            write("=\"");
            if (properties != null) {
                Enumeration<?> propertyNames = properties.propertyNames();
                while (propertyNames.hasMoreElements()) {
                    String str = (String) propertyNames.nextElement();
                    writeCssProperty(str, properties.getProperty(str));
                }
            }
            if (isOtherFont(font)) {
                writeCssProperty(Markup.CSS_KEY_FONTFAMILY, font.getFamilyname());
                if (font.getSize() != -1.0f) {
                    writeCssProperty(Markup.CSS_KEY_FONTSIZE, String.valueOf(font.getSize()) + "pt");
                }
                if (font.getColor() != null) {
                    writeCssProperty("color", HtmlEncoder.encode(font.getColor()));
                }
                int style = font.getStyle();
                BaseFont baseFont = font.getBaseFont();
                if (baseFont != null) {
                    String lowerCase = baseFont.getPostscriptFontName().toLowerCase();
                    if (lowerCase.indexOf("bold") >= 0) {
                        if (style == -1) {
                            style = 0;
                        }
                        style |= 1;
                    }
                    if (lowerCase.indexOf("italic") >= 0 || lowerCase.indexOf(Markup.CSS_VALUE_OBLIQUE) >= 0) {
                        if (style == -1) {
                            style = 0;
                        }
                        style |= 2;
                    }
                }
                if (!(style == -1 || style == 0)) {
                    int i = style & 3;
                    if (i == 1) {
                        writeCssProperty(Markup.CSS_KEY_FONTWEIGHT, "bold");
                    } else if (i == 2) {
                        writeCssProperty(Markup.CSS_KEY_FONTSTYLE, "italic");
                    } else if (i == 3) {
                        writeCssProperty(Markup.CSS_KEY_FONTWEIGHT, "bold");
                        writeCssProperty(Markup.CSS_KEY_FONTSTYLE, "italic");
                    }
                    if ((style & 4) > 0) {
                        writeCssProperty(Markup.CSS_KEY_TEXTDECORATION, "underline");
                    }
                    if ((style & 8) > 0) {
                        writeCssProperty(Markup.CSS_KEY_TEXTDECORATION, Markup.CSS_VALUE_LINETHROUGH);
                    }
                }
            }
            write("\"");
        }
    }

    /* access modifiers changed from: protected */
    public void writeCssProperty(String str, String str2) throws IOException {
        StringBuffer stringBuffer = new StringBuffer(str);
        stringBuffer.append(": ");
        stringBuffer.append(str2);
        stringBuffer.append("; ");
        write(stringBuffer.toString());
    }
}
