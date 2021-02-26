package com.lowagie.text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class Document implements DocListener {
    private static final String ITEXT = "iText";
    private static final String ITEXT_VERSION = "iText 2.1.7 by 1T3XT";
    private static final String RELEASE = "2.1.7";
    public static boolean compress = true;
    public static boolean plainRandomAccess = false;
    public static float wmfFontCorrection = 0.86f;
    protected int chapternumber;
    protected boolean close;
    protected HeaderFooter footer;
    protected HeaderFooter header;
    protected String htmlStyleClass;
    protected String javaScript_onLoad;
    protected String javaScript_onUnLoad;
    private ArrayList listeners;
    protected float marginBottom;
    protected float marginLeft;
    protected boolean marginMirroring;
    protected boolean marginMirroringTopBottom;
    protected float marginRight;
    protected float marginTop;
    protected boolean open;
    protected int pageN;
    protected Rectangle pageSize;

    public static final String getProduct() {
        return ITEXT;
    }

    public static final String getRelease() {
        return RELEASE;
    }

    public static final String getVersion() {
        return ITEXT_VERSION;
    }

    public Document() {
        this(PageSize.f586A4);
    }

    public Document(Rectangle rectangle) {
        this(rectangle, 36.0f, 36.0f, 36.0f, 36.0f);
    }

    public Document(Rectangle rectangle, float f, float f2, float f3, float f4) {
        this.listeners = new ArrayList();
        this.marginLeft = 0.0f;
        this.marginRight = 0.0f;
        this.marginTop = 0.0f;
        this.marginBottom = 0.0f;
        this.marginMirroring = false;
        this.marginMirroringTopBottom = false;
        this.javaScript_onLoad = null;
        this.javaScript_onUnLoad = null;
        this.htmlStyleClass = null;
        this.pageN = 0;
        this.header = null;
        this.footer = null;
        this.chapternumber = 0;
        this.pageSize = rectangle;
        this.marginLeft = f;
        this.marginRight = f2;
        this.marginTop = f3;
        this.marginBottom = f4;
    }

    public void addDocListener(DocListener docListener) {
        this.listeners.add(docListener);
    }

    public void removeDocListener(DocListener docListener) {
        this.listeners.remove(docListener);
    }

    public boolean add(Element element) throws DocumentException {
        if (this.close) {
            throw new DocumentException("The document has been closed. You can't add any Elements.");
        } else if (this.open || !element.isContent()) {
            boolean z = false;
            if (element instanceof ChapterAutoNumber) {
                this.chapternumber = ((ChapterAutoNumber) element).setAutomaticNumber(this.chapternumber);
            }
            Iterator it = this.listeners.iterator();
            while (it.hasNext()) {
                z |= ((DocListener) it.next()).add(element);
            }
            if (element instanceof LargeElement) {
                LargeElement largeElement = (LargeElement) element;
                if (!largeElement.isComplete()) {
                    largeElement.flushContent();
                }
            }
            return z;
        } else {
            throw new DocumentException("The document is not open yet; you can only add Meta information.");
        }
    }

    public void open() {
        if (!this.close) {
            this.open = true;
        }
        Iterator it = this.listeners.iterator();
        while (it.hasNext()) {
            DocListener docListener = (DocListener) it.next();
            docListener.setPageSize(this.pageSize);
            docListener.setMargins(this.marginLeft, this.marginRight, this.marginTop, this.marginBottom);
            docListener.open();
        }
    }

    public boolean setPageSize(Rectangle rectangle) {
        this.pageSize = rectangle;
        Iterator it = this.listeners.iterator();
        while (it.hasNext()) {
            ((DocListener) it.next()).setPageSize(rectangle);
        }
        return true;
    }

    public boolean setMargins(float f, float f2, float f3, float f4) {
        this.marginLeft = f;
        this.marginRight = f2;
        this.marginTop = f3;
        this.marginBottom = f4;
        Iterator it = this.listeners.iterator();
        while (it.hasNext()) {
            ((DocListener) it.next()).setMargins(f, f2, f3, f4);
        }
        return true;
    }

    public boolean newPage() {
        if (!this.open || this.close) {
            return false;
        }
        Iterator it = this.listeners.iterator();
        while (it.hasNext()) {
            ((DocListener) it.next()).newPage();
        }
        return true;
    }

    public void setHeader(HeaderFooter headerFooter) {
        this.header = headerFooter;
        Iterator it = this.listeners.iterator();
        while (it.hasNext()) {
            ((DocListener) it.next()).setHeader(headerFooter);
        }
    }

    public void resetHeader() {
        this.header = null;
        Iterator it = this.listeners.iterator();
        while (it.hasNext()) {
            ((DocListener) it.next()).resetHeader();
        }
    }

    public void setFooter(HeaderFooter headerFooter) {
        this.footer = headerFooter;
        Iterator it = this.listeners.iterator();
        while (it.hasNext()) {
            ((DocListener) it.next()).setFooter(headerFooter);
        }
    }

    public void resetFooter() {
        this.footer = null;
        Iterator it = this.listeners.iterator();
        while (it.hasNext()) {
            ((DocListener) it.next()).resetFooter();
        }
    }

    public void resetPageCount() {
        this.pageN = 0;
        Iterator it = this.listeners.iterator();
        while (it.hasNext()) {
            ((DocListener) it.next()).resetPageCount();
        }
    }

    public void setPageCount(int i) {
        this.pageN = i;
        Iterator it = this.listeners.iterator();
        while (it.hasNext()) {
            ((DocListener) it.next()).setPageCount(i);
        }
    }

    public int getPageNumber() {
        return this.pageN;
    }

    public void close() {
        if (!this.close) {
            this.open = false;
            this.close = true;
        }
        Iterator it = this.listeners.iterator();
        while (it.hasNext()) {
            ((DocListener) it.next()).close();
        }
    }

    public boolean addHeader(String str, String str2) {
        try {
            return add(new Header(str, str2));
        } catch (DocumentException e) {
            throw new ExceptionConverter(e);
        }
    }

    public boolean addTitle(String str) {
        try {
            return add(new Meta(1, str));
        } catch (DocumentException e) {
            throw new ExceptionConverter(e);
        }
    }

    public boolean addSubject(String str) {
        try {
            return add(new Meta(2, str));
        } catch (DocumentException e) {
            throw new ExceptionConverter(e);
        }
    }

    public boolean addKeywords(String str) {
        try {
            return add(new Meta(3, str));
        } catch (DocumentException e) {
            throw new ExceptionConverter(e);
        }
    }

    public boolean addAuthor(String str) {
        try {
            return add(new Meta(4, str));
        } catch (DocumentException e) {
            throw new ExceptionConverter(e);
        }
    }

    public boolean addCreator(String str) {
        try {
            return add(new Meta(7, str));
        } catch (DocumentException e) {
            throw new ExceptionConverter(e);
        }
    }

    public boolean addProducer() {
        try {
            return add(new Meta(5, getVersion()));
        } catch (DocumentException e) {
            throw new ExceptionConverter(e);
        }
    }

    public boolean addCreationDate() {
        try {
            return add(new Meta(6, new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").format(new Date())));
        } catch (DocumentException e) {
            throw new ExceptionConverter(e);
        }
    }

    public float leftMargin() {
        return this.marginLeft;
    }

    public float rightMargin() {
        return this.marginRight;
    }

    public float topMargin() {
        return this.marginTop;
    }

    public float bottomMargin() {
        return this.marginBottom;
    }

    public float left() {
        return this.pageSize.getLeft(this.marginLeft);
    }

    public float right() {
        return this.pageSize.getRight(this.marginRight);
    }

    public float top() {
        return this.pageSize.getTop(this.marginTop);
    }

    public float bottom() {
        return this.pageSize.getBottom(this.marginBottom);
    }

    public float left(float f) {
        return this.pageSize.getLeft(this.marginLeft + f);
    }

    public float right(float f) {
        return this.pageSize.getRight(this.marginRight + f);
    }

    public float top(float f) {
        return this.pageSize.getTop(this.marginTop + f);
    }

    public float bottom(float f) {
        return this.pageSize.getBottom(this.marginBottom + f);
    }

    public Rectangle getPageSize() {
        return this.pageSize;
    }

    public boolean isOpen() {
        return this.open;
    }

    public void setJavaScript_onLoad(String str) {
        this.javaScript_onLoad = str;
    }

    public String getJavaScript_onLoad() {
        return this.javaScript_onLoad;
    }

    public void setJavaScript_onUnLoad(String str) {
        this.javaScript_onUnLoad = str;
    }

    public String getJavaScript_onUnLoad() {
        return this.javaScript_onUnLoad;
    }

    public void setHtmlStyleClass(String str) {
        this.htmlStyleClass = str;
    }

    public String getHtmlStyleClass() {
        return this.htmlStyleClass;
    }

    public boolean setMarginMirroring(boolean z) {
        this.marginMirroring = z;
        Iterator it = this.listeners.iterator();
        while (it.hasNext()) {
            ((DocListener) it.next()).setMarginMirroring(z);
        }
        return true;
    }

    public boolean setMarginMirroringTopBottom(boolean z) {
        this.marginMirroringTopBottom = z;
        Iterator it = this.listeners.iterator();
        while (it.hasNext()) {
            ((DocListener) it.next()).setMarginMirroringTopBottom(z);
        }
        return true;
    }

    public boolean isMarginMirroring() {
        return this.marginMirroring;
    }
}
