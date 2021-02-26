package com.lowagie.text.pdf;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.ExceptionConverter;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfDocument;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ListIterator;

public class PdfCopy extends PdfWriter {
    protected PdfIndirectReference acroForm;
    protected int currentObjectNum = 1;
    protected PdfArray fieldArray;
    protected HashMap fieldTemplates;
    protected HashMap indirectMap;
    protected HashMap indirects;
    protected int[] namePtr = new int[1];
    protected PdfReader reader;
    /* access modifiers changed from: private */
    public boolean rotateContents = true;

    public PdfIndirectReference add(PdfOutline pdfOutline) {
        return null;
    }

    /* access modifiers changed from: package-private */
    public PdfIndirectReference add(PdfPage pdfPage, PdfContents pdfContents) throws PdfException {
        return null;
    }

    public void addAnnotation(PdfAnnotation pdfAnnotation) {
    }

    static class IndirectReferences {
        boolean hasCopied = false;
        PdfIndirectReference theRef;

        IndirectReferences(PdfIndirectReference pdfIndirectReference) {
            this.theRef = pdfIndirectReference;
        }

        /* access modifiers changed from: package-private */
        public void setCopied() {
            this.hasCopied = true;
        }

        /* access modifiers changed from: package-private */
        public boolean getCopied() {
            return this.hasCopied;
        }

        /* access modifiers changed from: package-private */
        public PdfIndirectReference getRef() {
            return this.theRef;
        }
    }

    protected static class RefKey {
        int gen;
        int num;

        RefKey(int i, int i2) {
            this.num = i;
            this.gen = i2;
        }

        RefKey(PdfIndirectReference pdfIndirectReference) {
            this.num = pdfIndirectReference.getNumber();
            this.gen = pdfIndirectReference.getGeneration();
        }

        RefKey(PRIndirectReference pRIndirectReference) {
            this.num = pRIndirectReference.getNumber();
            this.gen = pRIndirectReference.getGeneration();
        }

        public int hashCode() {
            return (this.gen << 16) + this.num;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof RefKey)) {
                return false;
            }
            RefKey refKey = (RefKey) obj;
            if (this.gen == refKey.gen && this.num == refKey.num) {
                return true;
            }
            return false;
        }

        public String toString() {
            return String.valueOf(Integer.toString(this.num)) + ' ' + this.gen;
        }
    }

    public PdfCopy(Document document, OutputStream outputStream) throws DocumentException {
        super(new PdfDocument(), outputStream);
        document.addDocListener(this.pdf);
        this.pdf.addWriter(this);
        this.indirectMap = new HashMap();
    }

    public boolean isRotateContents() {
        return this.rotateContents;
    }

    public void setRotateContents(boolean z) {
        this.rotateContents = z;
    }

    public PdfImportedPage getImportedPage(PdfReader pdfReader, int i) {
        if (this.currentPdfReaderInstance == null) {
            this.currentPdfReaderInstance = pdfReader.getPdfReaderInstance(this);
        } else if (this.currentPdfReaderInstance.getReader() != pdfReader) {
            try {
                this.currentPdfReaderInstance.getReader().close();
                this.currentPdfReaderInstance.getReaderFile().close();
            } catch (IOException unused) {
            }
            this.currentPdfReaderInstance = pdfReader.getPdfReaderInstance(this);
        }
        return this.currentPdfReaderInstance.getImportedPage(i);
    }

    /* access modifiers changed from: protected */
    public PdfIndirectReference copyIndirect(PRIndirectReference pRIndirectReference) throws IOException, BadPdfFormatException {
        PdfIndirectReference pdfIndirectReference;
        PdfObject pdfObjectRelease;
        RefKey refKey = new RefKey(pRIndirectReference);
        IndirectReferences indirectReferences = (IndirectReferences) this.indirects.get(refKey);
        if (indirectReferences != null) {
            pdfIndirectReference = indirectReferences.getRef();
            if (indirectReferences.getCopied()) {
                return pdfIndirectReference;
            }
        } else {
            PdfIndirectReference pdfIndirectReference2 = this.body.getPdfIndirectReference();
            IndirectReferences indirectReferences2 = new IndirectReferences(pdfIndirectReference2);
            this.indirects.put(refKey, indirectReferences2);
            pdfIndirectReference = pdfIndirectReference2;
            indirectReferences = indirectReferences2;
        }
        PdfObject pdfObjectRelease2 = PdfReader.getPdfObjectRelease((PdfObject) pRIndirectReference);
        if (pdfObjectRelease2 != null && pdfObjectRelease2.isDictionary() && (pdfObjectRelease = PdfReader.getPdfObjectRelease(((PdfDictionary) pdfObjectRelease2).get(PdfName.TYPE))) != null && PdfName.PAGE.equals(pdfObjectRelease)) {
            return pdfIndirectReference;
        }
        indirectReferences.setCopied();
        addToBody(copyObject(pdfObjectRelease2), pdfIndirectReference);
        return pdfIndirectReference;
    }

    /* access modifiers changed from: protected */
    public PdfDictionary copyDictionary(PdfDictionary pdfDictionary) throws IOException, BadPdfFormatException {
        PdfDictionary pdfDictionary2 = new PdfDictionary();
        PdfObject pdfObjectRelease = PdfReader.getPdfObjectRelease(pdfDictionary.get(PdfName.TYPE));
        for (PdfName pdfName : pdfDictionary.getKeys()) {
            PdfObject pdfObject = pdfDictionary.get(pdfName);
            if (pdfObjectRelease == null || !PdfName.PAGE.equals(pdfObjectRelease)) {
                pdfDictionary2.put(pdfName, copyObject(pdfObject));
            } else if (!pdfName.equals(PdfName.f646B) && !pdfName.equals(PdfName.PARENT)) {
                pdfDictionary2.put(pdfName, copyObject(pdfObject));
            }
        }
        return pdfDictionary2;
    }

    /* access modifiers changed from: protected */
    public PdfStream copyStream(PRStream pRStream) throws IOException, BadPdfFormatException {
        PRStream pRStream2 = new PRStream(pRStream, (PdfDictionary) null);
        for (PdfName pdfName : pRStream.getKeys()) {
            pRStream2.put(pdfName, copyObject(pRStream.get(pdfName)));
        }
        return pRStream2;
    }

    /* access modifiers changed from: protected */
    public PdfArray copyArray(PdfArray pdfArray) throws IOException, BadPdfFormatException {
        PdfArray pdfArray2 = new PdfArray();
        ListIterator listIterator = pdfArray.listIterator();
        while (listIterator.hasNext()) {
            pdfArray2.add(copyObject((PdfObject) listIterator.next()));
        }
        return pdfArray2;
    }

    /* access modifiers changed from: protected */
    public PdfObject copyObject(PdfObject pdfObject) throws IOException, BadPdfFormatException {
        if (pdfObject == null) {
            return PdfNull.PDFNULL;
        }
        switch (pdfObject.type) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 8:
                return pdfObject;
            case 5:
                return copyArray((PdfArray) pdfObject);
            case 6:
                return copyDictionary((PdfDictionary) pdfObject);
            case 7:
                return copyStream((PRStream) pdfObject);
            case 10:
                return copyIndirect((PRIndirectReference) pdfObject);
            default:
                if (pdfObject.type < 0) {
                    String pdfLiteral = ((PdfLiteral) pdfObject).toString();
                    if (pdfLiteral.equals("true") || pdfLiteral.equals(PdfBoolean.FALSE)) {
                        return new PdfBoolean(pdfLiteral);
                    }
                    return new PdfLiteral(pdfLiteral);
                }
                PrintStream printStream = System.out;
                printStream.println("CANNOT COPY type " + pdfObject.type);
                return null;
        }
    }

    /* access modifiers changed from: protected */
    public int setFromIPage(PdfImportedPage pdfImportedPage) {
        int pageNumber = pdfImportedPage.getPageNumber();
        PdfReaderInstance pdfReaderInstance = pdfImportedPage.getPdfReaderInstance();
        this.currentPdfReaderInstance = pdfReaderInstance;
        this.reader = pdfReaderInstance.getReader();
        setFromReader(this.reader);
        return pageNumber;
    }

    /* access modifiers changed from: protected */
    public void setFromReader(PdfReader pdfReader) {
        this.reader = pdfReader;
        this.indirects = (HashMap) this.indirectMap.get(pdfReader);
        if (this.indirects == null) {
            this.indirects = new HashMap();
            this.indirectMap.put(pdfReader, this.indirects);
            PdfObject pdfObject = pdfReader.getCatalog().get(PdfName.ACROFORM);
            if (pdfObject != null && pdfObject.type() == 10) {
                PRIndirectReference pRIndirectReference = (PRIndirectReference) pdfObject;
                if (this.acroForm == null) {
                    this.acroForm = this.body.getPdfIndirectReference();
                }
                this.indirects.put(new RefKey(pRIndirectReference), new IndirectReferences(this.acroForm));
            }
        }
    }

    public void addPage(PdfImportedPage pdfImportedPage) throws IOException, BadPdfFormatException {
        int fromIPage = setFromIPage(pdfImportedPage);
        PdfDictionary pageN = this.reader.getPageN(fromIPage);
        PRIndirectReference pageOrigRef = this.reader.getPageOrigRef(fromIPage);
        this.reader.releasePage(fromIPage);
        RefKey refKey = new RefKey(pageOrigRef);
        IndirectReferences indirectReferences = (IndirectReferences) this.indirects.get(refKey);
        if (indirectReferences != null && !indirectReferences.getCopied()) {
            this.pageReferences.add(indirectReferences.getRef());
            indirectReferences.setCopied();
        }
        PdfIndirectReference currentPage = getCurrentPage();
        if (indirectReferences == null) {
            indirectReferences = new IndirectReferences(currentPage);
            this.indirects.put(refKey, indirectReferences);
        }
        indirectReferences.setCopied();
        this.root.addPage(copyDictionary(pageN));
        this.currentPageNumber++;
    }

    public void addPage(Rectangle rectangle, int i) {
        PdfPage pdfPage = new PdfPage(new PdfRectangle(rectangle, i), new HashMap(), new PageResources().getResources(), 0);
        pdfPage.put(PdfName.TABS, getTabs());
        this.root.addPage((PdfDictionary) pdfPage);
        this.currentPageNumber++;
    }

    public void copyAcroForm(PdfReader pdfReader) throws IOException, BadPdfFormatException {
        PdfIndirectReference pdfIndirectReference;
        setFromReader(pdfReader);
        PdfObject pdfObject = pdfReader.getCatalog().get(PdfName.ACROFORM);
        PRIndirectReference pRIndirectReference = (pdfObject == null || pdfObject.type() != 10) ? null : (PRIndirectReference) pdfObject;
        if (pRIndirectReference != null) {
            RefKey refKey = new RefKey(pRIndirectReference);
            IndirectReferences indirectReferences = (IndirectReferences) this.indirects.get(refKey);
            if (indirectReferences != null) {
                pdfIndirectReference = indirectReferences.getRef();
                this.acroForm = pdfIndirectReference;
            } else {
                PdfIndirectReference pdfIndirectReference2 = this.body.getPdfIndirectReference();
                this.acroForm = pdfIndirectReference2;
                IndirectReferences indirectReferences2 = new IndirectReferences(pdfIndirectReference2);
                this.indirects.put(refKey, indirectReferences2);
                pdfIndirectReference = pdfIndirectReference2;
                indirectReferences = indirectReferences2;
            }
            if (!indirectReferences.getCopied()) {
                indirectReferences.setCopied();
                addToBody((PdfObject) copyDictionary((PdfDictionary) PdfReader.getPdfObject((PdfObject) pRIndirectReference)), pdfIndirectReference);
            }
        }
    }

    /* access modifiers changed from: protected */
    public PdfDictionary getCatalog(PdfIndirectReference pdfIndirectReference) {
        try {
            PdfDocument.PdfCatalog catalog = this.pdf.getCatalog(pdfIndirectReference);
            if (this.fieldArray != null) {
                addFieldResources(catalog);
            } else if (this.acroForm != null) {
                catalog.put(PdfName.ACROFORM, this.acroForm);
            }
            return catalog;
        } catch (IOException e) {
            throw new ExceptionConverter(e);
        }
    }

    private void addFieldResources(PdfDictionary pdfDictionary) throws IOException {
        if (this.fieldArray != null) {
            PdfDictionary pdfDictionary2 = new PdfDictionary();
            pdfDictionary.put(PdfName.ACROFORM, pdfDictionary2);
            pdfDictionary2.put(PdfName.FIELDS, this.fieldArray);
            pdfDictionary2.put(PdfName.f662DA, new PdfString("/Helv 0 Tf 0 g "));
            if (!this.fieldTemplates.isEmpty()) {
                PdfDictionary pdfDictionary3 = new PdfDictionary();
                pdfDictionary2.put(PdfName.f667DR, pdfDictionary3);
                for (PdfTemplate resources : this.fieldTemplates.keySet()) {
                    PdfFormField.mergeResources(pdfDictionary3, (PdfDictionary) resources.getResources());
                }
                PdfDictionary asDict = pdfDictionary3.getAsDict(PdfName.FONT);
                if (asDict == null) {
                    asDict = new PdfDictionary();
                    pdfDictionary3.put(PdfName.FONT, asDict);
                }
                if (!asDict.contains(PdfName.HELV)) {
                    PdfDictionary pdfDictionary4 = new PdfDictionary(PdfName.FONT);
                    pdfDictionary4.put(PdfName.BASEFONT, PdfName.HELVETICA);
                    pdfDictionary4.put(PdfName.ENCODING, PdfName.WIN_ANSI_ENCODING);
                    pdfDictionary4.put(PdfName.NAME, PdfName.HELV);
                    pdfDictionary4.put(PdfName.SUBTYPE, PdfName.TYPE1);
                    asDict.put(PdfName.HELV, addToBody(pdfDictionary4).getIndirectReference());
                }
                if (!asDict.contains(PdfName.ZADB)) {
                    PdfDictionary pdfDictionary5 = new PdfDictionary(PdfName.FONT);
                    pdfDictionary5.put(PdfName.BASEFONT, PdfName.ZAPFDINGBATS);
                    pdfDictionary5.put(PdfName.NAME, PdfName.ZADB);
                    pdfDictionary5.put(PdfName.SUBTYPE, PdfName.TYPE1);
                    asDict.put(PdfName.ZADB, addToBody(pdfDictionary5).getIndirectReference());
                }
            }
        }
    }

    public void close() {
        if (this.open) {
            PdfReaderInstance pdfReaderInstance = this.currentPdfReaderInstance;
            this.pdf.close();
            super.close();
            if (pdfReaderInstance != null) {
                try {
                    pdfReaderInstance.getReader().close();
                    pdfReaderInstance.getReaderFile().close();
                } catch (IOException unused) {
                }
            }
        }
    }

    public void freeReader(PdfReader pdfReader) throws IOException {
        this.indirectMap.remove(pdfReader);
        if (this.currentPdfReaderInstance != null && this.currentPdfReaderInstance.getReader() == pdfReader) {
            try {
                this.currentPdfReaderInstance.getReader().close();
                this.currentPdfReaderInstance.getReaderFile().close();
            } catch (IOException unused) {
            }
            this.currentPdfReaderInstance = null;
        }
    }

    public PageStamp createPageStamp(PdfImportedPage pdfImportedPage) {
        int pageNumber = pdfImportedPage.getPageNumber();
        PdfReader reader2 = pdfImportedPage.getPdfReaderInstance().getReader();
        return new PageStamp(reader2, reader2.getPageN(pageNumber), this);
    }

    public static class PageStamp {
        PdfCopy cstp;
        StampContent over;
        PdfDictionary pageN;
        PageResources pageResources;
        PdfReader reader;
        StampContent under;

        PageStamp(PdfReader pdfReader, PdfDictionary pdfDictionary, PdfCopy pdfCopy) {
            this.pageN = pdfDictionary;
            this.reader = pdfReader;
            this.cstp = pdfCopy;
        }

        public PdfContentByte getUnderContent() {
            if (this.under == null) {
                if (this.pageResources == null) {
                    this.pageResources = new PageResources();
                    this.pageResources.setOriginalResources(this.pageN.getAsDict(PdfName.RESOURCES), this.cstp.namePtr);
                }
                this.under = new StampContent(this.cstp, this.pageResources);
            }
            return this.under;
        }

        public PdfContentByte getOverContent() {
            if (this.over == null) {
                if (this.pageResources == null) {
                    this.pageResources = new PageResources();
                    this.pageResources.setOriginalResources(this.pageN.getAsDict(PdfName.RESOURCES), this.cstp.namePtr);
                }
                this.over = new StampContent(this.cstp, this.pageResources);
            }
            return this.over;
        }

        public void alterContents() throws IOException {
            PdfArray pdfArray;
            if (this.over != null || this.under != null) {
                PdfObject pdfObject = PdfReader.getPdfObject(this.pageN.get(PdfName.CONTENTS), this.pageN);
                if (pdfObject == null) {
                    pdfArray = new PdfArray();
                    this.pageN.put(PdfName.CONTENTS, pdfArray);
                } else if (pdfObject.isArray()) {
                    pdfArray = (PdfArray) pdfObject;
                } else if (pdfObject.isStream()) {
                    pdfArray = new PdfArray();
                    pdfArray.add(this.pageN.get(PdfName.CONTENTS));
                    this.pageN.put(PdfName.CONTENTS, pdfArray);
                } else {
                    pdfArray = new PdfArray();
                    this.pageN.put(PdfName.CONTENTS, pdfArray);
                }
                ByteBuffer byteBuffer = new ByteBuffer();
                if (this.under != null) {
                    byteBuffer.append(PdfContents.SAVESTATE);
                    applyRotation(this.pageN, byteBuffer);
                    byteBuffer.append(this.under.getInternalBuffer());
                    byteBuffer.append(PdfContents.RESTORESTATE);
                }
                if (this.over != null) {
                    byteBuffer.append(PdfContents.SAVESTATE);
                }
                PdfStream pdfStream = new PdfStream(byteBuffer.toByteArray());
                pdfStream.flateCompress(this.cstp.getCompressionLevel());
                pdfArray.addFirst(this.cstp.addToBody(pdfStream).getIndirectReference());
                byteBuffer.reset();
                if (this.over != null) {
                    byteBuffer.append(' ');
                    byteBuffer.append(PdfContents.RESTORESTATE);
                    byteBuffer.append(PdfContents.SAVESTATE);
                    applyRotation(this.pageN, byteBuffer);
                    byteBuffer.append(this.over.getInternalBuffer());
                    byteBuffer.append(PdfContents.RESTORESTATE);
                    PdfStream pdfStream2 = new PdfStream(byteBuffer.toByteArray());
                    pdfStream2.flateCompress(this.cstp.getCompressionLevel());
                    pdfArray.add((PdfObject) this.cstp.addToBody(pdfStream2).getIndirectReference());
                }
                this.pageN.put(PdfName.RESOURCES, this.pageResources.getResources());
            }
        }

        /* access modifiers changed from: package-private */
        public void applyRotation(PdfDictionary pdfDictionary, ByteBuffer byteBuffer) {
            if (this.cstp.rotateContents) {
                Rectangle pageSizeWithRotation = this.reader.getPageSizeWithRotation(pdfDictionary);
                int rotation = pageSizeWithRotation.getRotation();
                if (rotation == 90) {
                    byteBuffer.append(PdfContents.ROTATE90);
                    byteBuffer.append(pageSizeWithRotation.getTop());
                    byteBuffer.append(' ').append('0').append(PdfContents.ROTATEFINAL);
                } else if (rotation == 180) {
                    byteBuffer.append(PdfContents.ROTATE180);
                    byteBuffer.append(pageSizeWithRotation.getRight());
                    byteBuffer.append(' ');
                    byteBuffer.append(pageSizeWithRotation.getTop());
                    byteBuffer.append(PdfContents.ROTATEFINAL);
                } else if (rotation == 270) {
                    byteBuffer.append(PdfContents.ROTATE270);
                    byteBuffer.append('0').append(' ');
                    byteBuffer.append(pageSizeWithRotation.getRight());
                    byteBuffer.append(PdfContents.ROTATEFINAL);
                }
            }
        }

        private void addDocumentField(PdfIndirectReference pdfIndirectReference) {
            if (this.cstp.fieldArray == null) {
                this.cstp.fieldArray = new PdfArray();
            }
            this.cstp.fieldArray.add((PdfObject) pdfIndirectReference);
        }

        private void expandFields(PdfFormField pdfFormField, ArrayList arrayList) {
            arrayList.add(pdfFormField);
            ArrayList kids = pdfFormField.getKids();
            if (kids != null) {
                for (int i = 0; i < kids.size(); i++) {
                    expandFields((PdfFormField) kids.get(i), arrayList);
                }
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:47:0x00d9 A[Catch:{ IOException -> 0x0170 }] */
        /* JADX WARNING: Removed duplicated region for block: B:54:0x0136 A[Catch:{ IOException -> 0x0170 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void addAnnotation(com.lowagie.text.pdf.PdfAnnotation r11) {
            /*
                r10 = this;
                java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ IOException -> 0x0170 }
                r0.<init>()     // Catch:{ IOException -> 0x0170 }
                boolean r1 = r11.isForm()     // Catch:{ IOException -> 0x0170 }
                if (r1 == 0) goto L_0x0027
                com.lowagie.text.pdf.PdfFormField r11 = (com.lowagie.text.pdf.PdfFormField) r11     // Catch:{ IOException -> 0x0170 }
                com.lowagie.text.pdf.PdfFormField r1 = r11.getParent()     // Catch:{ IOException -> 0x0170 }
                if (r1 == 0) goto L_0x0014
                return
            L_0x0014:
                r10.expandFields(r11, r0)     // Catch:{ IOException -> 0x0170 }
                com.lowagie.text.pdf.PdfCopy r11 = r10.cstp     // Catch:{ IOException -> 0x0170 }
                java.util.HashMap r11 = r11.fieldTemplates     // Catch:{ IOException -> 0x0170 }
                if (r11 != 0) goto L_0x002a
                com.lowagie.text.pdf.PdfCopy r11 = r10.cstp     // Catch:{ IOException -> 0x0170 }
                java.util.HashMap r1 = new java.util.HashMap     // Catch:{ IOException -> 0x0170 }
                r1.<init>()     // Catch:{ IOException -> 0x0170 }
                r11.fieldTemplates = r1     // Catch:{ IOException -> 0x0170 }
                goto L_0x002a
            L_0x0027:
                r0.add(r11)     // Catch:{ IOException -> 0x0170 }
            L_0x002a:
                r11 = 0
            L_0x002b:
                int r1 = r0.size()     // Catch:{ IOException -> 0x0170 }
                if (r11 < r1) goto L_0x0032
                return
            L_0x0032:
                java.lang.Object r1 = r0.get(r11)     // Catch:{ IOException -> 0x0170 }
                com.lowagie.text.pdf.PdfAnnotation r1 = (com.lowagie.text.pdf.PdfAnnotation) r1     // Catch:{ IOException -> 0x0170 }
                boolean r2 = r1.isForm()     // Catch:{ IOException -> 0x0170 }
                if (r2 == 0) goto L_0x0061
                boolean r2 = r1.isUsed()     // Catch:{ IOException -> 0x0170 }
                if (r2 != 0) goto L_0x0051
                java.util.HashMap r2 = r1.getTemplates()     // Catch:{ IOException -> 0x0170 }
                if (r2 == 0) goto L_0x0051
                com.lowagie.text.pdf.PdfCopy r3 = r10.cstp     // Catch:{ IOException -> 0x0170 }
                java.util.HashMap r3 = r3.fieldTemplates     // Catch:{ IOException -> 0x0170 }
                r3.putAll(r2)     // Catch:{ IOException -> 0x0170 }
            L_0x0051:
                r2 = r1
                com.lowagie.text.pdf.PdfFormField r2 = (com.lowagie.text.pdf.PdfFormField) r2     // Catch:{ IOException -> 0x0170 }
                com.lowagie.text.pdf.PdfFormField r3 = r2.getParent()     // Catch:{ IOException -> 0x0170 }
                if (r3 != 0) goto L_0x0061
                com.lowagie.text.pdf.PdfIndirectReference r2 = r2.getIndirectReference()     // Catch:{ IOException -> 0x0170 }
                r10.addDocumentField(r2)     // Catch:{ IOException -> 0x0170 }
            L_0x0061:
                boolean r2 = r1.isAnnotation()     // Catch:{ IOException -> 0x0170 }
                if (r2 == 0) goto L_0x015a
                com.lowagie.text.pdf.PdfDictionary r2 = r10.pageN     // Catch:{ IOException -> 0x0170 }
                com.lowagie.text.pdf.PdfName r3 = com.lowagie.text.pdf.PdfName.ANNOTS     // Catch:{ IOException -> 0x0170 }
                com.lowagie.text.pdf.PdfObject r2 = r2.get(r3)     // Catch:{ IOException -> 0x0170 }
                com.lowagie.text.pdf.PdfDictionary r3 = r10.pageN     // Catch:{ IOException -> 0x0170 }
                com.lowagie.text.pdf.PdfObject r2 = com.lowagie.text.pdf.PdfReader.getPdfObject(r2, r3)     // Catch:{ IOException -> 0x0170 }
                if (r2 == 0) goto L_0x0081
                boolean r3 = r2.isArray()     // Catch:{ IOException -> 0x0170 }
                if (r3 != 0) goto L_0x007e
                goto L_0x0081
            L_0x007e:
                com.lowagie.text.pdf.PdfArray r2 = (com.lowagie.text.pdf.PdfArray) r2     // Catch:{ IOException -> 0x0170 }
                goto L_0x008d
            L_0x0081:
                com.lowagie.text.pdf.PdfArray r2 = new com.lowagie.text.pdf.PdfArray     // Catch:{ IOException -> 0x0170 }
                r2.<init>()     // Catch:{ IOException -> 0x0170 }
                com.lowagie.text.pdf.PdfDictionary r3 = r10.pageN     // Catch:{ IOException -> 0x0170 }
                com.lowagie.text.pdf.PdfName r4 = com.lowagie.text.pdf.PdfName.ANNOTS     // Catch:{ IOException -> 0x0170 }
                r3.put(r4, r2)     // Catch:{ IOException -> 0x0170 }
            L_0x008d:
                com.lowagie.text.pdf.PdfIndirectReference r3 = r1.getIndirectReference()     // Catch:{ IOException -> 0x0170 }
                r2.add((com.lowagie.text.pdf.PdfObject) r3)     // Catch:{ IOException -> 0x0170 }
                boolean r2 = r1.isUsed()     // Catch:{ IOException -> 0x0170 }
                if (r2 != 0) goto L_0x015a
                com.lowagie.text.pdf.PdfName r2 = com.lowagie.text.pdf.PdfName.RECT     // Catch:{ IOException -> 0x0170 }
                com.lowagie.text.pdf.PdfObject r2 = r1.get(r2)     // Catch:{ IOException -> 0x0170 }
                com.lowagie.text.pdf.PdfRectangle r2 = (com.lowagie.text.pdf.PdfRectangle) r2     // Catch:{ IOException -> 0x0170 }
                if (r2 == 0) goto L_0x015a
                float r3 = r2.left()     // Catch:{ IOException -> 0x0170 }
                r4 = 0
                int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
                if (r3 != 0) goto L_0x00c5
                float r3 = r2.right()     // Catch:{ IOException -> 0x0170 }
                int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
                if (r3 != 0) goto L_0x00c5
                float r3 = r2.top()     // Catch:{ IOException -> 0x0170 }
                int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
                if (r3 != 0) goto L_0x00c5
                float r3 = r2.bottom()     // Catch:{ IOException -> 0x0170 }
                int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
                if (r3 == 0) goto L_0x015a
            L_0x00c5:
                com.lowagie.text.pdf.PdfReader r3 = r10.reader     // Catch:{ IOException -> 0x0170 }
                com.lowagie.text.pdf.PdfDictionary r4 = r10.pageN     // Catch:{ IOException -> 0x0170 }
                int r3 = r3.getPageRotation((com.lowagie.text.pdf.PdfDictionary) r4)     // Catch:{ IOException -> 0x0170 }
                com.lowagie.text.pdf.PdfReader r4 = r10.reader     // Catch:{ IOException -> 0x0170 }
                com.lowagie.text.pdf.PdfDictionary r5 = r10.pageN     // Catch:{ IOException -> 0x0170 }
                com.lowagie.text.Rectangle r4 = r4.getPageSizeWithRotation((com.lowagie.text.pdf.PdfDictionary) r5)     // Catch:{ IOException -> 0x0170 }
                r5 = 90
                if (r3 == r5) goto L_0x0136
                r5 = 180(0xb4, float:2.52E-43)
                if (r3 == r5) goto L_0x0107
                r5 = 270(0x10e, float:3.78E-43)
                if (r3 == r5) goto L_0x00e2
                goto L_0x015a
            L_0x00e2:
                com.lowagie.text.pdf.PdfName r3 = com.lowagie.text.pdf.PdfName.RECT     // Catch:{ IOException -> 0x0170 }
                com.lowagie.text.pdf.PdfRectangle r5 = new com.lowagie.text.pdf.PdfRectangle     // Catch:{ IOException -> 0x0170 }
                float r6 = r2.bottom()     // Catch:{ IOException -> 0x0170 }
                float r7 = r4.getRight()     // Catch:{ IOException -> 0x0170 }
                float r8 = r2.left()     // Catch:{ IOException -> 0x0170 }
                float r7 = r7 - r8
                float r8 = r2.top()     // Catch:{ IOException -> 0x0170 }
                float r4 = r4.getRight()     // Catch:{ IOException -> 0x0170 }
                float r2 = r2.right()     // Catch:{ IOException -> 0x0170 }
                float r4 = r4 - r2
                r5.<init>(r6, r7, r8, r4)     // Catch:{ IOException -> 0x0170 }
                r1.put(r3, r5)     // Catch:{ IOException -> 0x0170 }
                goto L_0x015a
            L_0x0107:
                com.lowagie.text.pdf.PdfName r3 = com.lowagie.text.pdf.PdfName.RECT     // Catch:{ IOException -> 0x0170 }
                com.lowagie.text.pdf.PdfRectangle r5 = new com.lowagie.text.pdf.PdfRectangle     // Catch:{ IOException -> 0x0170 }
                float r6 = r4.getRight()     // Catch:{ IOException -> 0x0170 }
                float r7 = r2.left()     // Catch:{ IOException -> 0x0170 }
                float r6 = r6 - r7
                float r7 = r4.getTop()     // Catch:{ IOException -> 0x0170 }
                float r8 = r2.bottom()     // Catch:{ IOException -> 0x0170 }
                float r7 = r7 - r8
                float r8 = r4.getRight()     // Catch:{ IOException -> 0x0170 }
                float r9 = r2.right()     // Catch:{ IOException -> 0x0170 }
                float r8 = r8 - r9
                float r4 = r4.getTop()     // Catch:{ IOException -> 0x0170 }
                float r2 = r2.top()     // Catch:{ IOException -> 0x0170 }
                float r4 = r4 - r2
                r5.<init>(r6, r7, r8, r4)     // Catch:{ IOException -> 0x0170 }
                r1.put(r3, r5)     // Catch:{ IOException -> 0x0170 }
                goto L_0x015a
            L_0x0136:
                com.lowagie.text.pdf.PdfName r3 = com.lowagie.text.pdf.PdfName.RECT     // Catch:{ IOException -> 0x0170 }
                com.lowagie.text.pdf.PdfRectangle r5 = new com.lowagie.text.pdf.PdfRectangle     // Catch:{ IOException -> 0x0170 }
                float r6 = r4.getTop()     // Catch:{ IOException -> 0x0170 }
                float r7 = r2.bottom()     // Catch:{ IOException -> 0x0170 }
                float r6 = r6 - r7
                float r7 = r2.left()     // Catch:{ IOException -> 0x0170 }
                float r4 = r4.getTop()     // Catch:{ IOException -> 0x0170 }
                float r8 = r2.top()     // Catch:{ IOException -> 0x0170 }
                float r4 = r4 - r8
                float r2 = r2.right()     // Catch:{ IOException -> 0x0170 }
                r5.<init>(r6, r7, r4, r2)     // Catch:{ IOException -> 0x0170 }
                r1.put(r3, r5)     // Catch:{ IOException -> 0x0170 }
            L_0x015a:
                boolean r2 = r1.isUsed()     // Catch:{ IOException -> 0x0170 }
                if (r2 != 0) goto L_0x016c
                r1.setUsed()     // Catch:{ IOException -> 0x0170 }
                com.lowagie.text.pdf.PdfCopy r2 = r10.cstp     // Catch:{ IOException -> 0x0170 }
                com.lowagie.text.pdf.PdfIndirectReference r3 = r1.getIndirectReference()     // Catch:{ IOException -> 0x0170 }
                r2.addToBody((com.lowagie.text.pdf.PdfObject) r1, (com.lowagie.text.pdf.PdfIndirectReference) r3)     // Catch:{ IOException -> 0x0170 }
            L_0x016c:
                int r11 = r11 + 1
                goto L_0x002b
            L_0x0170:
                r11 = move-exception
                com.lowagie.text.ExceptionConverter r0 = new com.lowagie.text.ExceptionConverter
                r0.<init>(r11)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.PdfCopy.PageStamp.addAnnotation(com.lowagie.text.pdf.PdfAnnotation):void");
        }
    }

    public static class StampContent extends PdfContentByte {
        PageResources pageResources;

        StampContent(PdfWriter pdfWriter, PageResources pageResources2) {
            super(pdfWriter);
            this.pageResources = pageResources2;
        }

        public PdfContentByte getDuplicate() {
            return new StampContent(this.writer, this.pageResources);
        }

        /* access modifiers changed from: package-private */
        public PageResources getPageResources() {
            return this.pageResources;
        }
    }
}
