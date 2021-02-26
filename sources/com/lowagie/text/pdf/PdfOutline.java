package com.lowagie.text.pdf;

import com.lowagie.text.Chunk;
import com.lowagie.text.Paragraph;
import harmony.java.awt.Color;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class PdfOutline extends PdfDictionary {
    private PdfAction action;
    private Color color;
    private int count;
    private PdfDestination destination;
    protected ArrayList kids;
    private boolean open;
    private PdfOutline parent;
    private PdfIndirectReference reference;
    private int style;
    private String tag;
    protected PdfWriter writer;

    PdfOutline(PdfWriter pdfWriter) {
        super(OUTLINES);
        this.count = 0;
        this.kids = new ArrayList();
        this.style = 0;
        this.open = true;
        this.parent = null;
        this.writer = pdfWriter;
    }

    public PdfOutline(PdfOutline pdfOutline, PdfAction pdfAction, String str) {
        this(pdfOutline, pdfAction, str, true);
    }

    public PdfOutline(PdfOutline pdfOutline, PdfAction pdfAction, String str, boolean z) {
        this.count = 0;
        this.kids = new ArrayList();
        this.style = 0;
        this.action = pdfAction;
        initOutline(pdfOutline, str, z);
    }

    public PdfOutline(PdfOutline pdfOutline, PdfDestination pdfDestination, String str) {
        this(pdfOutline, pdfDestination, str, true);
    }

    public PdfOutline(PdfOutline pdfOutline, PdfDestination pdfDestination, String str, boolean z) {
        this.count = 0;
        this.kids = new ArrayList();
        this.style = 0;
        this.destination = pdfDestination;
        initOutline(pdfOutline, str, z);
    }

    public PdfOutline(PdfOutline pdfOutline, PdfAction pdfAction, PdfString pdfString) {
        this(pdfOutline, pdfAction, pdfString, true);
    }

    public PdfOutline(PdfOutline pdfOutline, PdfAction pdfAction, PdfString pdfString, boolean z) {
        this(pdfOutline, pdfAction, pdfString.toString(), z);
    }

    public PdfOutline(PdfOutline pdfOutline, PdfDestination pdfDestination, PdfString pdfString) {
        this(pdfOutline, pdfDestination, pdfString, true);
    }

    public PdfOutline(PdfOutline pdfOutline, PdfDestination pdfDestination, PdfString pdfString, boolean z) {
        this(pdfOutline, pdfDestination, pdfString.toString(), true);
    }

    public PdfOutline(PdfOutline pdfOutline, PdfAction pdfAction, Paragraph paragraph) {
        this(pdfOutline, pdfAction, paragraph, true);
    }

    public PdfOutline(PdfOutline pdfOutline, PdfAction pdfAction, Paragraph paragraph, boolean z) {
        this.count = 0;
        this.kids = new ArrayList();
        this.style = 0;
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = paragraph.getChunks().iterator();
        while (it.hasNext()) {
            stringBuffer.append(((Chunk) it.next()).getContent());
        }
        this.action = pdfAction;
        initOutline(pdfOutline, stringBuffer.toString(), z);
    }

    public PdfOutline(PdfOutline pdfOutline, PdfDestination pdfDestination, Paragraph paragraph) {
        this(pdfOutline, pdfDestination, paragraph, true);
    }

    public PdfOutline(PdfOutline pdfOutline, PdfDestination pdfDestination, Paragraph paragraph, boolean z) {
        this.count = 0;
        this.kids = new ArrayList();
        this.style = 0;
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = paragraph.getChunks().iterator();
        while (it.hasNext()) {
            stringBuffer.append(((Chunk) it.next()).getContent());
        }
        this.destination = pdfDestination;
        initOutline(pdfOutline, stringBuffer.toString(), z);
    }

    /* access modifiers changed from: package-private */
    public void initOutline(PdfOutline pdfOutline, String str, boolean z) {
        this.open = z;
        this.parent = pdfOutline;
        this.writer = pdfOutline.writer;
        put(PdfName.TITLE, new PdfString(str, PdfObject.TEXT_UNICODE));
        pdfOutline.addKid(this);
        PdfDestination pdfDestination = this.destination;
        if (pdfDestination != null && !pdfDestination.hasPage()) {
            setDestinationPage(this.writer.getCurrentPage());
        }
    }

    public void setIndirectReference(PdfIndirectReference pdfIndirectReference) {
        this.reference = pdfIndirectReference;
    }

    public PdfIndirectReference indirectReference() {
        return this.reference;
    }

    public PdfOutline parent() {
        return this.parent;
    }

    public boolean setDestinationPage(PdfIndirectReference pdfIndirectReference) {
        PdfDestination pdfDestination = this.destination;
        if (pdfDestination == null) {
            return false;
        }
        return pdfDestination.addPage(pdfIndirectReference);
    }

    public PdfDestination getPdfDestination() {
        return this.destination;
    }

    /* access modifiers changed from: package-private */
    public int getCount() {
        return this.count;
    }

    /* access modifiers changed from: package-private */
    public void setCount(int i) {
        this.count = i;
    }

    public int level() {
        PdfOutline pdfOutline = this.parent;
        if (pdfOutline == null) {
            return 0;
        }
        return pdfOutline.level() + 1;
    }

    public void toPdf(PdfWriter pdfWriter, OutputStream outputStream) throws IOException {
        Color color2 = this.color;
        int i = 0;
        if (color2 != null && !color2.equals(Color.black)) {
            put(PdfName.f652C, new PdfArray(new float[]{((float) this.color.getRed()) / 255.0f, ((float) this.color.getGreen()) / 255.0f, ((float) this.color.getBlue()) / 255.0f}));
        }
        if ((this.style & 1) != 0) {
            i = 2;
        }
        if ((this.style & 2) != 0) {
            i |= 1;
        }
        if (i != 0) {
            put(PdfName.f673F, new PdfNumber(i));
        }
        if (this.parent != null) {
            put(PdfName.PARENT, this.parent.indirectReference());
        }
        PdfDestination pdfDestination = this.destination;
        if (pdfDestination != null && pdfDestination.hasPage()) {
            put(PdfName.DEST, this.destination);
        }
        if (this.action != null) {
            put(PdfName.f641A, this.action);
        }
        if (this.count != 0) {
            put(PdfName.COUNT, new PdfNumber(this.count));
        }
        super.toPdf(pdfWriter, outputStream);
    }

    public void addKid(PdfOutline pdfOutline) {
        this.kids.add(pdfOutline);
    }

    public ArrayList getKids() {
        return this.kids;
    }

    public void setKids(ArrayList arrayList) {
        this.kids = arrayList;
    }

    public String getTag() {
        return this.tag;
    }

    public void setTag(String str) {
        this.tag = str;
    }

    public String getTitle() {
        return ((PdfString) get(PdfName.TITLE)).toString();
    }

    public void setTitle(String str) {
        put(PdfName.TITLE, new PdfString(str, PdfObject.TEXT_UNICODE));
    }

    public boolean isOpen() {
        return this.open;
    }

    public void setOpen(boolean z) {
        this.open = z;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color2) {
        this.color = color2;
    }

    public int getStyle() {
        return this.style;
    }

    public void setStyle(int i) {
        this.style = i;
    }
}
