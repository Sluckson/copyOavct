package com.lowagie.text.pdf;

import java.util.ArrayList;

public class PdfLayer extends PdfDictionary implements PdfOCG {
    protected ArrayList children;

    /* renamed from: on */
    private boolean f640on = true;
    private boolean onPanel = true;
    protected PdfLayer parent;
    protected PdfIndirectReference ref;
    protected String title;

    public PdfObject getPdfObject() {
        return this;
    }

    PdfLayer(String str) {
        this.title = str;
    }

    public static PdfLayer createTitle(String str, PdfWriter pdfWriter) {
        if (str != null) {
            PdfLayer pdfLayer = new PdfLayer(str);
            pdfWriter.registerLayer(pdfLayer);
            return pdfLayer;
        }
        throw new NullPointerException("Title cannot be null.");
    }

    public PdfLayer(String str, PdfWriter pdfWriter) {
        super(PdfName.OCG);
        setName(str);
        this.ref = pdfWriter.getPdfIndirectReference();
        pdfWriter.registerLayer(this);
    }

    /* access modifiers changed from: package-private */
    public String getTitle() {
        return this.title;
    }

    public void addChild(PdfLayer pdfLayer) {
        if (pdfLayer.parent == null) {
            pdfLayer.parent = this;
            if (this.children == null) {
                this.children = new ArrayList();
            }
            this.children.add(pdfLayer);
            return;
        }
        throw new IllegalArgumentException("The layer '" + ((PdfString) pdfLayer.get(PdfName.NAME)).toUnicodeString() + "' already has a parent.");
    }

    public PdfLayer getParent() {
        return this.parent;
    }

    public ArrayList getChildren() {
        return this.children;
    }

    public PdfIndirectReference getRef() {
        return this.ref;
    }

    /* access modifiers changed from: package-private */
    public void setRef(PdfIndirectReference pdfIndirectReference) {
        this.ref = pdfIndirectReference;
    }

    public void setName(String str) {
        put(PdfName.NAME, new PdfString(str, PdfObject.TEXT_UNICODE));
    }

    public boolean isOn() {
        return this.f640on;
    }

    public void setOn(boolean z) {
        this.f640on = z;
    }

    private PdfDictionary getUsage() {
        PdfDictionary pdfDictionary = (PdfDictionary) get(PdfName.USAGE);
        if (pdfDictionary != null) {
            return pdfDictionary;
        }
        PdfDictionary pdfDictionary2 = new PdfDictionary();
        put(PdfName.USAGE, pdfDictionary2);
        return pdfDictionary2;
    }

    public void setCreatorInfo(String str, String str2) {
        PdfDictionary usage = getUsage();
        PdfDictionary pdfDictionary = new PdfDictionary();
        pdfDictionary.put(PdfName.CREATOR, new PdfString(str, PdfObject.TEXT_UNICODE));
        pdfDictionary.put(PdfName.SUBTYPE, new PdfName(str2));
        usage.put(PdfName.CREATORINFO, pdfDictionary);
    }

    public void setLanguage(String str, boolean z) {
        PdfDictionary usage = getUsage();
        PdfDictionary pdfDictionary = new PdfDictionary();
        pdfDictionary.put(PdfName.LANG, new PdfString(str, PdfObject.TEXT_UNICODE));
        if (z) {
            pdfDictionary.put(PdfName.PREFERRED, PdfName.f705ON);
        }
        usage.put(PdfName.LANGUAGE, pdfDictionary);
    }

    public void setExport(boolean z) {
        PdfDictionary usage = getUsage();
        PdfDictionary pdfDictionary = new PdfDictionary();
        pdfDictionary.put(PdfName.EXPORTSTATE, z ? PdfName.f705ON : PdfName.OFF);
        usage.put(PdfName.EXPORT, pdfDictionary);
    }

    public void setZoom(float f, float f2) {
        if (f > 0.0f || f2 >= 0.0f) {
            PdfDictionary usage = getUsage();
            PdfDictionary pdfDictionary = new PdfDictionary();
            if (f > 0.0f) {
                pdfDictionary.put(PdfName.MIN_LOWER_CASE, new PdfNumber(f));
            }
            if (f2 >= 0.0f) {
                pdfDictionary.put(PdfName.MAX_LOWER_CASE, new PdfNumber(f2));
            }
            usage.put(PdfName.ZOOM, pdfDictionary);
        }
    }

    public void setPrint(String str, boolean z) {
        PdfDictionary usage = getUsage();
        PdfDictionary pdfDictionary = new PdfDictionary();
        pdfDictionary.put(PdfName.SUBTYPE, new PdfName(str));
        pdfDictionary.put(PdfName.PRINTSTATE, z ? PdfName.f705ON : PdfName.OFF);
        usage.put(PdfName.PRINT, pdfDictionary);
    }

    public void setView(boolean z) {
        PdfDictionary usage = getUsage();
        PdfDictionary pdfDictionary = new PdfDictionary();
        pdfDictionary.put(PdfName.VIEWSTATE, z ? PdfName.f705ON : PdfName.OFF);
        usage.put(PdfName.VIEW, pdfDictionary);
    }

    public boolean isOnPanel() {
        return this.onPanel;
    }

    public void setOnPanel(boolean z) {
        this.onPanel = z;
    }
}
