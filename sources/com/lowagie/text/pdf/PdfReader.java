package com.lowagie.text.pdf;

import com.lowagie.text.ExceptionConverter;
import com.lowagie.text.PageSize;
import com.lowagie.text.Rectangle;
import com.lowagie.text.exceptions.BadPasswordException;
import com.lowagie.text.exceptions.InvalidPdfException;
import com.lowagie.text.exceptions.UnsupportedPdfException;
import com.lowagie.text.pdf.IntHashtable;
import com.lowagie.text.pdf.PdfAnnotation;
import com.lowagie.text.pdf.interfaces.PdfViewerPreferences;
import com.lowagie.text.pdf.internal.PdfViewerPreferencesImp;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.Key;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.zip.InflaterInputStream;

public class PdfReader implements PdfViewerPreferences {
    static final byte[] endobj = PdfEncodings.convertToBytes("endobj", (String) null);
    static final byte[] endstream = PdfEncodings.convertToBytes("endstream", (String) null);
    static final PdfName[] pageInhCandidates = {PdfName.MEDIABOX, PdfName.ROTATE, PdfName.RESOURCES, PdfName.CROPBOX};
    protected PRAcroForm acroForm;
    protected boolean acroFormParsed;
    private boolean appendable;
    protected PdfDictionary catalog;
    protected Certificate certificate;
    protected Key certificateKey;
    protected String certificateKeyProvider;
    protected boolean consolidateNamedDestinations;
    private PRIndirectReference cryptoRef;
    protected PdfEncryption decrypt;
    protected boolean encrypted;
    private boolean encryptionError;
    protected int eofPos;
    private int fileLength;
    protected int freeXref;
    private boolean hybridXref;
    protected int lastXref;
    /* access modifiers changed from: private */
    public int lastXrefPartial;
    protected boolean newXrefType;
    private int objGen;
    private int objNum;
    protected HashMap objStmMark;
    protected IntHashtable objStmToOffset;
    private boolean ownerPasswordUsed;
    protected int pValue;
    protected PageRefs pageRefs;
    /* access modifiers changed from: private */
    public boolean partial;
    protected byte[] password;
    protected char pdfVersion;
    protected int rValue;
    private int readDepth;
    protected boolean rebuilt;
    PdfDictionary rootPages;
    protected boolean sharedStreams;
    protected ArrayList strings;
    protected boolean tampered;
    protected PRTokeniser tokens;
    protected PdfDictionary trailer;
    private PdfViewerPreferencesImp viewerPreferences;
    protected int[] xref;
    /* access modifiers changed from: private */
    public ArrayList xrefObj;

    protected PdfReader() {
        this.acroForm = null;
        this.acroFormParsed = false;
        this.encrypted = false;
        this.rebuilt = false;
        this.tampered = false;
        this.password = null;
        this.certificateKey = null;
        this.certificate = null;
        this.certificateKeyProvider = null;
        this.strings = new ArrayList();
        this.sharedStreams = true;
        this.consolidateNamedDestinations = false;
        this.lastXrefPartial = -1;
        this.viewerPreferences = new PdfViewerPreferencesImp();
        this.readDepth = 0;
    }

    public PdfReader(String str) throws IOException {
        this(str, (byte[]) null);
    }

    public PdfReader(String str, byte[] bArr) throws IOException {
        this.acroForm = null;
        this.acroFormParsed = false;
        this.encrypted = false;
        this.rebuilt = false;
        this.tampered = false;
        this.password = null;
        this.certificateKey = null;
        this.certificate = null;
        this.certificateKeyProvider = null;
        this.strings = new ArrayList();
        this.sharedStreams = true;
        this.consolidateNamedDestinations = false;
        this.lastXrefPartial = -1;
        this.viewerPreferences = new PdfViewerPreferencesImp();
        this.readDepth = 0;
        this.password = bArr;
        this.tokens = new PRTokeniser(str);
        readPdf();
    }

    public PdfReader(byte[] bArr) throws IOException {
        this(bArr, (byte[]) null);
    }

    public PdfReader(byte[] bArr, byte[] bArr2) throws IOException {
        this.acroForm = null;
        this.acroFormParsed = false;
        this.encrypted = false;
        this.rebuilt = false;
        this.tampered = false;
        this.password = null;
        this.certificateKey = null;
        this.certificate = null;
        this.certificateKeyProvider = null;
        this.strings = new ArrayList();
        this.sharedStreams = true;
        this.consolidateNamedDestinations = false;
        this.lastXrefPartial = -1;
        this.viewerPreferences = new PdfViewerPreferencesImp();
        this.readDepth = 0;
        this.password = bArr2;
        this.tokens = new PRTokeniser(bArr);
        readPdf();
    }

    public PdfReader(String str, Certificate certificate2, Key key, String str2) throws IOException {
        this.acroForm = null;
        this.acroFormParsed = false;
        this.encrypted = false;
        this.rebuilt = false;
        this.tampered = false;
        this.password = null;
        this.certificateKey = null;
        this.certificate = null;
        this.certificateKeyProvider = null;
        this.strings = new ArrayList();
        this.sharedStreams = true;
        this.consolidateNamedDestinations = false;
        this.lastXrefPartial = -1;
        this.viewerPreferences = new PdfViewerPreferencesImp();
        this.readDepth = 0;
        this.certificate = certificate2;
        this.certificateKey = key;
        this.certificateKeyProvider = str2;
        this.tokens = new PRTokeniser(str);
        readPdf();
    }

    public PdfReader(URL url) throws IOException {
        this(url, (byte[]) null);
    }

    public PdfReader(URL url, byte[] bArr) throws IOException {
        this.acroForm = null;
        this.acroFormParsed = false;
        this.encrypted = false;
        this.rebuilt = false;
        this.tampered = false;
        this.password = null;
        this.certificateKey = null;
        this.certificate = null;
        this.certificateKeyProvider = null;
        this.strings = new ArrayList();
        this.sharedStreams = true;
        this.consolidateNamedDestinations = false;
        this.lastXrefPartial = -1;
        this.viewerPreferences = new PdfViewerPreferencesImp();
        this.readDepth = 0;
        this.password = bArr;
        this.tokens = new PRTokeniser(new RandomAccessFileOrArray(url));
        readPdf();
    }

    public PdfReader(InputStream inputStream, byte[] bArr) throws IOException {
        this.acroForm = null;
        this.acroFormParsed = false;
        this.encrypted = false;
        this.rebuilt = false;
        this.tampered = false;
        this.password = null;
        this.certificateKey = null;
        this.certificate = null;
        this.certificateKeyProvider = null;
        this.strings = new ArrayList();
        this.sharedStreams = true;
        this.consolidateNamedDestinations = false;
        this.lastXrefPartial = -1;
        this.viewerPreferences = new PdfViewerPreferencesImp();
        this.readDepth = 0;
        this.password = bArr;
        this.tokens = new PRTokeniser(new RandomAccessFileOrArray(inputStream));
        readPdf();
    }

    public PdfReader(InputStream inputStream) throws IOException {
        this(inputStream, (byte[]) null);
    }

    public PdfReader(RandomAccessFileOrArray randomAccessFileOrArray, byte[] bArr) throws IOException {
        this.acroForm = null;
        this.acroFormParsed = false;
        this.encrypted = false;
        this.rebuilt = false;
        this.tampered = false;
        this.password = null;
        this.certificateKey = null;
        this.certificate = null;
        this.certificateKeyProvider = null;
        this.strings = new ArrayList();
        this.sharedStreams = true;
        this.consolidateNamedDestinations = false;
        this.lastXrefPartial = -1;
        this.viewerPreferences = new PdfViewerPreferencesImp();
        this.readDepth = 0;
        this.password = bArr;
        this.partial = true;
        this.tokens = new PRTokeniser(randomAccessFileOrArray);
        readPdfPartial();
    }

    public PdfReader(PdfReader pdfReader) {
        this.acroForm = null;
        this.acroFormParsed = false;
        this.encrypted = false;
        this.rebuilt = false;
        this.tampered = false;
        this.password = null;
        this.certificateKey = null;
        this.certificate = null;
        this.certificateKeyProvider = null;
        this.strings = new ArrayList();
        this.sharedStreams = true;
        this.consolidateNamedDestinations = false;
        this.lastXrefPartial = -1;
        this.viewerPreferences = new PdfViewerPreferencesImp();
        this.readDepth = 0;
        this.appendable = pdfReader.appendable;
        this.consolidateNamedDestinations = pdfReader.consolidateNamedDestinations;
        this.encrypted = pdfReader.encrypted;
        this.rebuilt = pdfReader.rebuilt;
        this.sharedStreams = pdfReader.sharedStreams;
        this.tampered = pdfReader.tampered;
        this.password = pdfReader.password;
        this.pdfVersion = pdfReader.pdfVersion;
        this.eofPos = pdfReader.eofPos;
        this.freeXref = pdfReader.freeXref;
        this.lastXref = pdfReader.lastXref;
        this.tokens = new PRTokeniser(pdfReader.tokens.getSafeFile());
        PdfEncryption pdfEncryption = pdfReader.decrypt;
        if (pdfEncryption != null) {
            this.decrypt = new PdfEncryption(pdfEncryption);
        }
        this.pValue = pdfReader.pValue;
        this.rValue = pdfReader.rValue;
        this.xrefObj = new ArrayList(pdfReader.xrefObj);
        for (int i = 0; i < pdfReader.xrefObj.size(); i++) {
            this.xrefObj.set(i, duplicatePdfObject((PdfObject) pdfReader.xrefObj.get(i), this));
        }
        this.pageRefs = new PageRefs(pdfReader.pageRefs, this);
        this.trailer = (PdfDictionary) duplicatePdfObject(pdfReader.trailer, this);
        this.catalog = this.trailer.getAsDict(PdfName.ROOT);
        this.rootPages = this.catalog.getAsDict(PdfName.PAGES);
        this.fileLength = pdfReader.fileLength;
        this.partial = pdfReader.partial;
        this.hybridXref = pdfReader.hybridXref;
        this.objStmToOffset = pdfReader.objStmToOffset;
        this.xref = pdfReader.xref;
        this.cryptoRef = (PRIndirectReference) duplicatePdfObject(pdfReader.cryptoRef, this);
        this.ownerPasswordUsed = pdfReader.ownerPasswordUsed;
    }

    public RandomAccessFileOrArray getSafeFile() {
        return this.tokens.getSafeFile();
    }

    /* access modifiers changed from: protected */
    public PdfReaderInstance getPdfReaderInstance(PdfWriter pdfWriter) {
        return new PdfReaderInstance(this, pdfWriter);
    }

    public int getNumberOfPages() {
        return this.pageRefs.size();
    }

    public PdfDictionary getCatalog() {
        return this.catalog;
    }

    public PRAcroForm getAcroForm() {
        if (!this.acroFormParsed) {
            this.acroFormParsed = true;
            PdfObject pdfObject = this.catalog.get(PdfName.ACROFORM);
            if (pdfObject != null) {
                try {
                    this.acroForm = new PRAcroForm(this);
                    this.acroForm.readAcroForm((PdfDictionary) getPdfObject(pdfObject));
                } catch (Exception unused) {
                    this.acroForm = null;
                }
            }
        }
        return this.acroForm;
    }

    public int getPageRotation(int i) {
        return getPageRotation(this.pageRefs.getPageNRelease(i));
    }

    /* access modifiers changed from: package-private */
    public int getPageRotation(PdfDictionary pdfDictionary) {
        PdfNumber asNumber = pdfDictionary.getAsNumber(PdfName.ROTATE);
        if (asNumber == null) {
            return 0;
        }
        int intValue = asNumber.intValue() % 360;
        return intValue < 0 ? intValue + 360 : intValue;
    }

    public Rectangle getPageSizeWithRotation(int i) {
        return getPageSizeWithRotation(this.pageRefs.getPageNRelease(i));
    }

    public Rectangle getPageSizeWithRotation(PdfDictionary pdfDictionary) {
        Rectangle pageSize = getPageSize(pdfDictionary);
        for (int pageRotation = getPageRotation(pdfDictionary); pageRotation > 0; pageRotation -= 90) {
            pageSize = pageSize.rotate();
        }
        return pageSize;
    }

    public Rectangle getPageSize(int i) {
        return getPageSize(this.pageRefs.getPageNRelease(i));
    }

    public Rectangle getPageSize(PdfDictionary pdfDictionary) {
        return getNormalizedRectangle(pdfDictionary.getAsArray(PdfName.MEDIABOX));
    }

    public Rectangle getCropBox(int i) {
        PdfDictionary pageNRelease = this.pageRefs.getPageNRelease(i);
        PdfArray pdfArray = (PdfArray) getPdfObjectRelease(pageNRelease.get(PdfName.CROPBOX));
        if (pdfArray == null) {
            return getPageSize(pageNRelease);
        }
        return getNormalizedRectangle(pdfArray);
    }

    public Rectangle getBoxSize(int i, String str) {
        PdfArray pdfArray;
        PdfDictionary pageNRelease = this.pageRefs.getPageNRelease(i);
        if (str.equals("trim")) {
            pdfArray = (PdfArray) getPdfObjectRelease(pageNRelease.get(PdfName.TRIMBOX));
        } else if (str.equals("art")) {
            pdfArray = (PdfArray) getPdfObjectRelease(pageNRelease.get(PdfName.ARTBOX));
        } else if (str.equals("bleed")) {
            pdfArray = (PdfArray) getPdfObjectRelease(pageNRelease.get(PdfName.BLEEDBOX));
        } else if (str.equals("crop")) {
            pdfArray = (PdfArray) getPdfObjectRelease(pageNRelease.get(PdfName.CROPBOX));
        } else {
            pdfArray = str.equals("media") ? (PdfArray) getPdfObjectRelease(pageNRelease.get(PdfName.MEDIABOX)) : null;
        }
        if (pdfArray == null) {
            return null;
        }
        return getNormalizedRectangle(pdfArray);
    }

    public HashMap getInfo() {
        HashMap hashMap = new HashMap();
        PdfDictionary asDict = this.trailer.getAsDict(PdfName.INFO);
        if (asDict == null) {
            return hashMap;
        }
        for (PdfName pdfName : asDict.getKeys()) {
            PdfObject pdfObject = getPdfObject(asDict.get(pdfName));
            if (pdfObject != null) {
                String pdfObject2 = pdfObject.toString();
                int type = pdfObject.type();
                if (type == 3) {
                    pdfObject2 = ((PdfString) pdfObject).toUnicodeString();
                } else if (type == 4) {
                    pdfObject2 = PdfName.decodeName(pdfObject2);
                }
                hashMap.put(PdfName.decodeName(pdfName.toString()), pdfObject2);
            }
        }
        return hashMap;
    }

    public static Rectangle getNormalizedRectangle(PdfArray pdfArray) {
        float floatValue = ((PdfNumber) getPdfObjectRelease(pdfArray.getPdfObject(0))).floatValue();
        float floatValue2 = ((PdfNumber) getPdfObjectRelease(pdfArray.getPdfObject(1))).floatValue();
        float floatValue3 = ((PdfNumber) getPdfObjectRelease(pdfArray.getPdfObject(2))).floatValue();
        float floatValue4 = ((PdfNumber) getPdfObjectRelease(pdfArray.getPdfObject(3))).floatValue();
        return new Rectangle(Math.min(floatValue, floatValue3), Math.min(floatValue2, floatValue4), Math.max(floatValue, floatValue3), Math.max(floatValue2, floatValue4));
    }

    /* access modifiers changed from: protected */
    public void readPdf() throws IOException {
        try {
            this.fileLength = this.tokens.getFile().length();
            this.pdfVersion = this.tokens.checkPdfHeader();
            try {
                readXref();
            } catch (Exception e) {
                this.rebuilt = true;
                rebuildXref();
                this.lastXref = -1;
            }
            readDocObj();
        } catch (Exception e2) {
            throw new InvalidPdfException("Rebuild failed: " + e2.getMessage() + "; Original message: " + e.getMessage());
        } catch (Exception e3) {
            if (e3 instanceof BadPasswordException) {
                throw new BadPasswordException(e3.getMessage());
            } else if (this.rebuilt || this.encryptionError) {
                throw new InvalidPdfException(e3.getMessage());
            } else {
                this.rebuilt = true;
                this.encrypted = false;
                rebuildXref();
                this.lastXref = -1;
                readDocObj();
            }
        } catch (Throwable th) {
            try {
                this.tokens.close();
            } catch (Exception unused) {
            }
            throw th;
        }
        this.strings.clear();
        readPages();
        eliminateSharedStreams();
        removeUnusedObjects();
        try {
            this.tokens.close();
        } catch (Exception unused2) {
        }
    }

    /* access modifiers changed from: protected */
    public void readPdfPartial() throws IOException {
        try {
            this.fileLength = this.tokens.getFile().length();
            this.pdfVersion = this.tokens.checkPdfHeader();
            try {
                readXref();
            } catch (Exception e) {
                this.rebuilt = true;
                rebuildXref();
                this.lastXref = -1;
            }
            readDocObjPartial();
            readPages();
        } catch (Exception e2) {
            throw new InvalidPdfException("Rebuild failed: " + e2.getMessage() + "; Original message: " + e.getMessage());
        } catch (IOException e3) {
            try {
                this.tokens.close();
            } catch (Exception unused) {
            }
            throw e3;
        }
    }

    private boolean equalsArray(byte[] bArr, byte[] bArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:155:0x033b  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0389  */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x03a8  */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x03bc A[LOOP:3: B:175:0x039a->B:182:0x03bc, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void readDecryptedDocObj() throws java.io.IOException {
        /*
            r16 = this;
            r1 = r16
            boolean r0 = r1.encrypted
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            com.lowagie.text.pdf.PdfDictionary r0 = r1.trailer
            com.lowagie.text.pdf.PdfName r2 = com.lowagie.text.pdf.PdfName.ENCRYPT
            com.lowagie.text.pdf.PdfObject r0 = r0.get(r2)
            if (r0 == 0) goto L_0x03cc
            java.lang.String r2 = r0.toString()
            java.lang.String r3 = "null"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x001f
            goto L_0x03cc
        L_0x001f:
            r2 = 1
            r1.encryptionError = r2
            r1.encrypted = r2
            com.lowagie.text.pdf.PdfObject r3 = getPdfObject((com.lowagie.text.pdf.PdfObject) r0)
            com.lowagie.text.pdf.PdfDictionary r3 = (com.lowagie.text.pdf.PdfDictionary) r3
            com.lowagie.text.pdf.PdfDictionary r4 = r1.trailer
            com.lowagie.text.pdf.PdfName r5 = com.lowagie.text.pdf.PdfName.f687ID
            com.lowagie.text.pdf.PdfArray r4 = r4.getAsArray(r5)
            r6 = 0
            if (r4 == 0) goto L_0x0056
            com.lowagie.text.pdf.PdfObject r7 = r4.getPdfObject(r6)
            java.util.ArrayList r8 = r1.strings
            r8.remove(r7)
            java.lang.String r7 = r7.toString()
            byte[] r7 = com.lowagie.text.DocWriter.getISOBytes(r7)
            int r8 = r4.size()
            if (r8 <= r2) goto L_0x0057
            java.util.ArrayList r8 = r1.strings
            com.lowagie.text.pdf.PdfObject r4 = r4.getPdfObject(r2)
            r8.remove(r4)
            goto L_0x0057
        L_0x0056:
            r7 = 0
        L_0x0057:
            if (r7 != 0) goto L_0x005b
            byte[] r7 = new byte[r6]
        L_0x005b:
            com.lowagie.text.pdf.PdfName r4 = com.lowagie.text.pdf.PdfName.FILTER
            com.lowagie.text.pdf.PdfObject r4 = r3.get(r4)
            com.lowagie.text.pdf.PdfObject r4 = getPdfObjectRelease((com.lowagie.text.pdf.PdfObject) r4)
            com.lowagie.text.pdf.PdfName r8 = com.lowagie.text.pdf.PdfName.STANDARD
            boolean r8 = r4.equals(r8)
            java.lang.String r9 = "No compatible encryption found"
            java.lang.String r10 = "/CF not found (encryption)"
            r11 = 128(0x80, float:1.794E-43)
            java.lang.String r13 = "Illegal Length value."
            r14 = 3
            r15 = 4
            r5 = 2
            if (r8 == 0) goto L_0x0193
            com.lowagie.text.pdf.PdfName r8 = com.lowagie.text.pdf.PdfName.f733U
            com.lowagie.text.pdf.PdfObject r8 = r3.get(r8)
            java.lang.String r8 = r8.toString()
            java.util.ArrayList r6 = r1.strings
            com.lowagie.text.pdf.PdfName r2 = com.lowagie.text.pdf.PdfName.f733U
            com.lowagie.text.pdf.PdfObject r2 = r3.get(r2)
            r6.remove(r2)
            byte[] r2 = com.lowagie.text.DocWriter.getISOBytes(r8)
            com.lowagie.text.pdf.PdfName r6 = com.lowagie.text.pdf.PdfName.f703O
            com.lowagie.text.pdf.PdfObject r6 = r3.get(r6)
            java.lang.String r6 = r6.toString()
            java.util.ArrayList r8 = r1.strings
            com.lowagie.text.pdf.PdfName r12 = com.lowagie.text.pdf.PdfName.f703O
            com.lowagie.text.pdf.PdfObject r12 = r3.get(r12)
            r8.remove(r12)
            byte[] r6 = com.lowagie.text.DocWriter.getISOBytes(r6)
            com.lowagie.text.pdf.PdfName r8 = com.lowagie.text.pdf.PdfName.f707P
            com.lowagie.text.pdf.PdfObject r8 = r3.get(r8)
            boolean r12 = r8.isNumber()
            if (r12 == 0) goto L_0x018b
            com.lowagie.text.pdf.PdfNumber r8 = (com.lowagie.text.pdf.PdfNumber) r8
            int r8 = r8.intValue()
            r1.pValue = r8
            com.lowagie.text.pdf.PdfName r8 = com.lowagie.text.pdf.PdfName.f715R
            com.lowagie.text.pdf.PdfObject r8 = r3.get(r8)
            boolean r12 = r8.isNumber()
            if (r12 == 0) goto L_0x0183
            com.lowagie.text.pdf.PdfNumber r8 = (com.lowagie.text.pdf.PdfNumber) r8
            int r8 = r8.intValue()
            r1.rValue = r8
            int r8 = r1.rValue
            if (r8 == r5) goto L_0x017f
            if (r8 == r14) goto L_0x0151
            if (r8 != r15) goto L_0x013b
            com.lowagie.text.pdf.PdfName r8 = com.lowagie.text.pdf.PdfName.f656CF
            com.lowagie.text.pdf.PdfObject r8 = r3.get(r8)
            com.lowagie.text.pdf.PdfDictionary r8 = (com.lowagie.text.pdf.PdfDictionary) r8
            if (r8 == 0) goto L_0x0135
            com.lowagie.text.pdf.PdfName r10 = com.lowagie.text.pdf.PdfName.STDCF
            com.lowagie.text.pdf.PdfObject r8 = r8.get(r10)
            com.lowagie.text.pdf.PdfDictionary r8 = (com.lowagie.text.pdf.PdfDictionary) r8
            if (r8 == 0) goto L_0x012d
            com.lowagie.text.pdf.PdfName r10 = com.lowagie.text.pdf.PdfName.f737V2
            com.lowagie.text.pdf.PdfName r11 = com.lowagie.text.pdf.PdfName.CFM
            com.lowagie.text.pdf.PdfObject r11 = r8.get(r11)
            boolean r10 = r10.equals(r11)
            if (r10 == 0) goto L_0x00fe
            r5 = 1
            goto L_0x010c
        L_0x00fe:
            com.lowagie.text.pdf.PdfName r10 = com.lowagie.text.pdf.PdfName.AESV2
            com.lowagie.text.pdf.PdfName r11 = com.lowagie.text.pdf.PdfName.CFM
            com.lowagie.text.pdf.PdfObject r8 = r8.get(r11)
            boolean r8 = r10.equals(r8)
            if (r8 == 0) goto L_0x0127
        L_0x010c:
            com.lowagie.text.pdf.PdfName r8 = com.lowagie.text.pdf.PdfName.ENCRYPTMETADATA
            com.lowagie.text.pdf.PdfObject r3 = r3.get(r8)
            if (r3 == 0) goto L_0x0123
            java.lang.String r3 = r3.toString()
            java.lang.String r8 = "false"
            boolean r3 = r3.equals(r8)
            if (r3 == 0) goto L_0x0123
            r3 = r5 | 8
            goto L_0x0124
        L_0x0123:
            r3 = r5
        L_0x0124:
            r5 = r6
            goto L_0x0325
        L_0x0127:
            com.lowagie.text.exceptions.UnsupportedPdfException r0 = new com.lowagie.text.exceptions.UnsupportedPdfException
            r0.<init>(r9)
            throw r0
        L_0x012d:
            com.lowagie.text.exceptions.InvalidPdfException r0 = new com.lowagie.text.exceptions.InvalidPdfException
            java.lang.String r2 = "/StdCF not found (encryption)"
            r0.<init>(r2)
            throw r0
        L_0x0135:
            com.lowagie.text.exceptions.InvalidPdfException r0 = new com.lowagie.text.exceptions.InvalidPdfException
            r0.<init>(r10)
            throw r0
        L_0x013b:
            com.lowagie.text.exceptions.UnsupportedPdfException r0 = new com.lowagie.text.exceptions.UnsupportedPdfException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Unknown encryption type R = "
            r2.<init>(r3)
            int r3 = r1.rValue
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.<init>(r2)
            throw r0
        L_0x0151:
            com.lowagie.text.pdf.PdfName r5 = com.lowagie.text.pdf.PdfName.LENGTH
            com.lowagie.text.pdf.PdfObject r3 = r3.get(r5)
            boolean r5 = r3.isNumber()
            if (r5 == 0) goto L_0x0179
            com.lowagie.text.pdf.PdfNumber r3 = (com.lowagie.text.pdf.PdfNumber) r3
            int r3 = r3.intValue()
            if (r3 > r11) goto L_0x0173
            r5 = 40
            if (r3 < r5) goto L_0x0173
            int r5 = r3 % 8
            if (r5 != 0) goto L_0x0173
            r5 = r6
            r8 = 0
            r6 = r3
            r3 = 1
            goto L_0x0327
        L_0x0173:
            com.lowagie.text.exceptions.InvalidPdfException r0 = new com.lowagie.text.exceptions.InvalidPdfException
            r0.<init>(r13)
            throw r0
        L_0x0179:
            com.lowagie.text.exceptions.InvalidPdfException r0 = new com.lowagie.text.exceptions.InvalidPdfException
            r0.<init>(r13)
            throw r0
        L_0x017f:
            r5 = r6
            r3 = 0
            goto L_0x0325
        L_0x0183:
            com.lowagie.text.exceptions.InvalidPdfException r0 = new com.lowagie.text.exceptions.InvalidPdfException
            java.lang.String r2 = "Illegal R value."
            r0.<init>(r2)
            throw r0
        L_0x018b:
            com.lowagie.text.exceptions.InvalidPdfException r0 = new com.lowagie.text.exceptions.InvalidPdfException
            java.lang.String r2 = "Illegal P value."
            r0.<init>(r2)
            throw r0
        L_0x0193:
            com.lowagie.text.pdf.PdfName r2 = com.lowagie.text.pdf.PdfName.PUBSEC
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0322
            com.lowagie.text.pdf.PdfName r2 = com.lowagie.text.pdf.PdfName.f736V
            com.lowagie.text.pdf.PdfObject r2 = r3.get(r2)
            boolean r6 = r2.isNumber()
            if (r6 == 0) goto L_0x031a
            com.lowagie.text.pdf.PdfNumber r2 = (com.lowagie.text.pdf.PdfNumber) r2
            int r2 = r2.intValue()
            r6 = 1
            if (r2 == r6) goto L_0x0266
            if (r2 == r5) goto L_0x0232
            if (r2 != r15) goto L_0x021c
            com.lowagie.text.pdf.PdfName r2 = com.lowagie.text.pdf.PdfName.f656CF
            com.lowagie.text.pdf.PdfObject r2 = r3.get(r2)
            com.lowagie.text.pdf.PdfDictionary r2 = (com.lowagie.text.pdf.PdfDictionary) r2
            if (r2 == 0) goto L_0x0216
            com.lowagie.text.pdf.PdfName r3 = com.lowagie.text.pdf.PdfName.DEFAULTCRYPTFILTER
            com.lowagie.text.pdf.PdfObject r2 = r2.get(r3)
            com.lowagie.text.pdf.PdfDictionary r2 = (com.lowagie.text.pdf.PdfDictionary) r2
            if (r2 == 0) goto L_0x020e
            com.lowagie.text.pdf.PdfName r3 = com.lowagie.text.pdf.PdfName.f737V2
            com.lowagie.text.pdf.PdfName r6 = com.lowagie.text.pdf.PdfName.CFM
            com.lowagie.text.pdf.PdfObject r6 = r2.get(r6)
            boolean r3 = r3.equals(r6)
            if (r3 == 0) goto L_0x01d8
            r3 = 1
            goto L_0x01e7
        L_0x01d8:
            com.lowagie.text.pdf.PdfName r3 = com.lowagie.text.pdf.PdfName.AESV2
            com.lowagie.text.pdf.PdfName r6 = com.lowagie.text.pdf.PdfName.CFM
            com.lowagie.text.pdf.PdfObject r6 = r2.get(r6)
            boolean r3 = r3.equals(r6)
            if (r3 == 0) goto L_0x0208
            r3 = 2
        L_0x01e7:
            com.lowagie.text.pdf.PdfName r6 = com.lowagie.text.pdf.PdfName.ENCRYPTMETADATA
            com.lowagie.text.pdf.PdfObject r6 = r2.get(r6)
            if (r6 == 0) goto L_0x01fd
            java.lang.String r6 = r6.toString()
            java.lang.String r8 = "false"
            boolean r6 = r6.equals(r8)
            if (r6 == 0) goto L_0x01fd
            r3 = r3 | 8
        L_0x01fd:
            com.lowagie.text.pdf.PdfName r6 = com.lowagie.text.pdf.PdfName.RECIPIENTS
            com.lowagie.text.pdf.PdfObject r2 = r2.get(r6)
            com.lowagie.text.pdf.PdfArray r2 = (com.lowagie.text.pdf.PdfArray) r2
            r6 = 128(0x80, float:1.794E-43)
            goto L_0x0271
        L_0x0208:
            com.lowagie.text.exceptions.UnsupportedPdfException r0 = new com.lowagie.text.exceptions.UnsupportedPdfException
            r0.<init>(r9)
            throw r0
        L_0x020e:
            com.lowagie.text.exceptions.InvalidPdfException r0 = new com.lowagie.text.exceptions.InvalidPdfException
            java.lang.String r2 = "/DefaultCryptFilter not found (encryption)"
            r0.<init>(r2)
            throw r0
        L_0x0216:
            com.lowagie.text.exceptions.InvalidPdfException r0 = new com.lowagie.text.exceptions.InvalidPdfException
            r0.<init>(r10)
            throw r0
        L_0x021c:
            com.lowagie.text.exceptions.UnsupportedPdfException r0 = new com.lowagie.text.exceptions.UnsupportedPdfException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Unknown encryption type V = "
            r2.<init>(r3)
            int r3 = r1.rValue
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.<init>(r2)
            throw r0
        L_0x0232:
            com.lowagie.text.pdf.PdfName r2 = com.lowagie.text.pdf.PdfName.LENGTH
            com.lowagie.text.pdf.PdfObject r2 = r3.get(r2)
            boolean r6 = r2.isNumber()
            if (r6 == 0) goto L_0x0260
            com.lowagie.text.pdf.PdfNumber r2 = (com.lowagie.text.pdf.PdfNumber) r2
            int r2 = r2.intValue()
            if (r2 > r11) goto L_0x025a
            r6 = 40
            if (r2 < r6) goto L_0x025a
            int r6 = r2 % 8
            if (r6 != 0) goto L_0x025a
            com.lowagie.text.pdf.PdfName r6 = com.lowagie.text.pdf.PdfName.RECIPIENTS
            com.lowagie.text.pdf.PdfObject r3 = r3.get(r6)
            com.lowagie.text.pdf.PdfArray r3 = (com.lowagie.text.pdf.PdfArray) r3
            r6 = r2
            r2 = r3
            r3 = 1
            goto L_0x0271
        L_0x025a:
            com.lowagie.text.exceptions.InvalidPdfException r0 = new com.lowagie.text.exceptions.InvalidPdfException
            r0.<init>(r13)
            throw r0
        L_0x0260:
            com.lowagie.text.exceptions.InvalidPdfException r0 = new com.lowagie.text.exceptions.InvalidPdfException
            r0.<init>(r13)
            throw r0
        L_0x0266:
            r6 = 40
            com.lowagie.text.pdf.PdfName r2 = com.lowagie.text.pdf.PdfName.RECIPIENTS
            com.lowagie.text.pdf.PdfObject r2 = r3.get(r2)
            com.lowagie.text.pdf.PdfArray r2 = (com.lowagie.text.pdf.PdfArray) r2
            r3 = 0
        L_0x0271:
            r8 = 0
            r9 = 0
            r10 = 0
        L_0x0274:
            int r11 = r2.size()
            if (r8 < r11) goto L_0x02cb
            if (r9 == 0) goto L_0x02c3
            if (r10 == 0) goto L_0x02c3
            java.lang.String r8 = "SHA-1"
            java.security.MessageDigest r8 = java.security.MessageDigest.getInstance(r8)     // Catch:{ Exception -> 0x02bc }
            r9 = 20
            r11 = 0
            r8.update(r10, r11, r9)     // Catch:{ Exception -> 0x02bc }
            r9 = 0
        L_0x028b:
            int r10 = r2.size()     // Catch:{ Exception -> 0x02bc }
            if (r9 < r10) goto L_0x02ae
            r2 = r3 & 8
            if (r2 == 0) goto L_0x02a5
            byte[] r2 = new byte[r15]     // Catch:{ Exception -> 0x02bc }
            r9 = -1
            r10 = 0
            r2[r10] = r9     // Catch:{ Exception -> 0x02bc }
            r10 = 1
            r2[r10] = r9     // Catch:{ Exception -> 0x02bc }
            r2[r5] = r9     // Catch:{ Exception -> 0x02bc }
            r2[r14] = r9     // Catch:{ Exception -> 0x02bc }
            r8.update(r2)     // Catch:{ Exception -> 0x02bc }
        L_0x02a5:
            byte[] r5 = r8.digest()     // Catch:{ Exception -> 0x02bc }
            r8 = r5
            r2 = 0
            r5 = 0
            goto L_0x0327
        L_0x02ae:
            com.lowagie.text.pdf.PdfObject r10 = r2.getPdfObject(r9)     // Catch:{ Exception -> 0x02bc }
            byte[] r10 = r10.getBytes()     // Catch:{ Exception -> 0x02bc }
            r8.update(r10)     // Catch:{ Exception -> 0x02bc }
            int r9 = r9 + 1
            goto L_0x028b
        L_0x02bc:
            r0 = move-exception
            com.lowagie.text.ExceptionConverter r2 = new com.lowagie.text.ExceptionConverter
            r2.<init>(r0)
            throw r2
        L_0x02c3:
            com.lowagie.text.exceptions.UnsupportedPdfException r0 = new com.lowagie.text.exceptions.UnsupportedPdfException
            java.lang.String r2 = "Bad certificate and key."
            r0.<init>(r2)
            throw r0
        L_0x02cb:
            com.lowagie.text.pdf.PdfObject r11 = r2.getPdfObject(r8)
            java.util.ArrayList r12 = r1.strings
            r12.remove(r11)
            repack.org.bouncycastle.cms.CMSEnvelopedData r12 = new repack.org.bouncycastle.cms.CMSEnvelopedData     // Catch:{ Exception -> 0x0313 }
            byte[] r11 = r11.getBytes()     // Catch:{ Exception -> 0x0313 }
            r12.<init>((byte[]) r11)     // Catch:{ Exception -> 0x0313 }
            repack.org.bouncycastle.cms.RecipientInformationStore r11 = r12.getRecipientInfos()     // Catch:{ Exception -> 0x0313 }
            java.util.Collection r11 = r11.getRecipients()     // Catch:{ Exception -> 0x0313 }
            java.util.Iterator r11 = r11.iterator()     // Catch:{ Exception -> 0x0313 }
        L_0x02e9:
            boolean r12 = r11.hasNext()     // Catch:{ Exception -> 0x0313 }
            if (r12 != 0) goto L_0x02f2
            int r8 = r8 + 1
            goto L_0x0274
        L_0x02f2:
            java.lang.Object r12 = r11.next()     // Catch:{ Exception -> 0x0313 }
            repack.org.bouncycastle.cms.RecipientInformation r12 = (repack.org.bouncycastle.cms.RecipientInformation) r12     // Catch:{ Exception -> 0x0313 }
            repack.org.bouncycastle.cms.RecipientId r13 = r12.getRID()     // Catch:{ Exception -> 0x0313 }
            java.security.cert.Certificate r5 = r1.certificate     // Catch:{ Exception -> 0x0313 }
            boolean r5 = r13.match(r5)     // Catch:{ Exception -> 0x0313 }
            if (r5 == 0) goto L_0x0311
            if (r9 != 0) goto L_0x0311
            java.security.Key r5 = r1.certificateKey     // Catch:{ Exception -> 0x0313 }
            java.lang.String r9 = r1.certificateKeyProvider     // Catch:{ Exception -> 0x0313 }
            byte[] r10 = r12.getContent((java.security.Key) r5, (java.lang.String) r9)     // Catch:{ Exception -> 0x0313 }
            r5 = 2
            r9 = 1
            goto L_0x02e9
        L_0x0311:
            r5 = 2
            goto L_0x02e9
        L_0x0313:
            r0 = move-exception
            com.lowagie.text.ExceptionConverter r2 = new com.lowagie.text.ExceptionConverter
            r2.<init>(r0)
            throw r2
        L_0x031a:
            com.lowagie.text.exceptions.InvalidPdfException r0 = new com.lowagie.text.exceptions.InvalidPdfException
            java.lang.String r2 = "Illegal V value."
            r0.<init>(r2)
            throw r0
        L_0x0322:
            r2 = 0
            r3 = 0
            r5 = 0
        L_0x0325:
            r6 = 0
            r8 = 0
        L_0x0327:
            com.lowagie.text.pdf.PdfEncryption r9 = new com.lowagie.text.pdf.PdfEncryption
            r9.<init>()
            r1.decrypt = r9
            com.lowagie.text.pdf.PdfEncryption r9 = r1.decrypt
            r9.setCryptoMode(r3, r6)
            com.lowagie.text.pdf.PdfName r3 = com.lowagie.text.pdf.PdfName.STANDARD
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x0389
            com.lowagie.text.pdf.PdfEncryption r8 = r1.decrypt
            byte[] r10 = r1.password
            int r13 = r1.pValue
            r9 = r7
            r11 = r2
            r12 = r5
            r8.setupByOwnerPassword(r9, r10, r11, r12, r13)
            com.lowagie.text.pdf.PdfEncryption r3 = r1.decrypt
            byte[] r3 = r3.userKey
            int r4 = r1.rValue
            r6 = 32
            r8 = 16
            if (r4 == r14) goto L_0x0359
            if (r4 != r15) goto L_0x0356
            goto L_0x0359
        L_0x0356:
            r4 = 32
            goto L_0x035b
        L_0x0359:
            r4 = 16
        L_0x035b:
            boolean r3 = r1.equalsArray(r2, r3, r4)
            if (r3 != 0) goto L_0x0385
            com.lowagie.text.pdf.PdfEncryption r3 = r1.decrypt
            byte[] r4 = r1.password
            int r9 = r1.pValue
            r3.setupByUserPassword(r7, r4, r5, r9)
            com.lowagie.text.pdf.PdfEncryption r3 = r1.decrypt
            byte[] r3 = r3.userKey
            int r4 = r1.rValue
            if (r4 == r14) goto L_0x0374
            if (r4 != r15) goto L_0x0376
        L_0x0374:
            r6 = 16
        L_0x0376:
            boolean r2 = r1.equalsArray(r2, r3, r6)
            if (r2 == 0) goto L_0x037d
            goto L_0x0399
        L_0x037d:
            com.lowagie.text.exceptions.BadPasswordException r0 = new com.lowagie.text.exceptions.BadPasswordException
            java.lang.String r2 = "Bad user password"
            r0.<init>(r2)
            throw r0
        L_0x0385:
            r2 = 1
            r1.ownerPasswordUsed = r2
            goto L_0x0399
        L_0x0389:
            r2 = 1
            com.lowagie.text.pdf.PdfName r3 = com.lowagie.text.pdf.PdfName.PUBSEC
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x0399
            com.lowagie.text.pdf.PdfEncryption r3 = r1.decrypt
            r3.setupByEncryptionKey(r8, r6)
            r1.ownerPasswordUsed = r2
        L_0x0399:
            r2 = 0
        L_0x039a:
            java.util.ArrayList r3 = r1.strings
            int r3 = r3.size()
            if (r2 < r3) goto L_0x03bc
            boolean r2 = r0.isIndirect()
            if (r2 == 0) goto L_0x03b8
            com.lowagie.text.pdf.PRIndirectReference r0 = (com.lowagie.text.pdf.PRIndirectReference) r0
            r1.cryptoRef = r0
            java.util.ArrayList r0 = r1.xrefObj
            com.lowagie.text.pdf.PRIndirectReference r2 = r1.cryptoRef
            int r2 = r2.getNumber()
            r3 = 0
            r0.set(r2, r3)
        L_0x03b8:
            r4 = 0
            r1.encryptionError = r4
            return
        L_0x03bc:
            r3 = 0
            r4 = 0
            java.util.ArrayList r5 = r1.strings
            java.lang.Object r5 = r5.get(r2)
            com.lowagie.text.pdf.PdfString r5 = (com.lowagie.text.pdf.PdfString) r5
            r5.decrypt(r1)
            int r2 = r2 + 1
            goto L_0x039a
        L_0x03cc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.PdfReader.readDecryptedDocObj():void");
    }

    public static PdfObject getPdfObjectRelease(PdfObject pdfObject) {
        PdfObject pdfObject2 = getPdfObject(pdfObject);
        releaseLastXrefPartial(pdfObject);
        return pdfObject2;
    }

    public static PdfObject getPdfObject(PdfObject pdfObject) {
        PdfObject pdfBoolean;
        if (pdfObject == null) {
            return null;
        }
        if (!pdfObject.isIndirect()) {
            return pdfObject;
        }
        try {
            PRIndirectReference pRIndirectReference = (PRIndirectReference) pdfObject;
            int number = pRIndirectReference.getNumber();
            boolean z = pRIndirectReference.getReader().appendable;
            PdfObject pdfObject2 = pRIndirectReference.getReader().getPdfObject(number);
            if (pdfObject2 == null) {
                return null;
            }
            if (z) {
                int type = pdfObject2.type();
                if (type == 1) {
                    pdfBoolean = new PdfBoolean(((PdfBoolean) pdfObject2).booleanValue());
                } else if (type == 4) {
                    pdfBoolean = new PdfName(pdfObject2.getBytes());
                } else if (type != 8) {
                    pdfObject2.setIndRef(pRIndirectReference);
                } else {
                    pdfBoolean = new PdfNull();
                }
                pdfObject2 = pdfBoolean;
                pdfObject2.setIndRef(pRIndirectReference);
            }
            return pdfObject2;
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public static PdfObject getPdfObjectRelease(PdfObject pdfObject, PdfObject pdfObject2) {
        PdfObject pdfObject3 = getPdfObject(pdfObject, pdfObject2);
        releaseLastXrefPartial(pdfObject);
        return pdfObject3;
    }

    public static PdfObject getPdfObject(PdfObject pdfObject, PdfObject pdfObject2) {
        PRIndirectReference indRef;
        PdfObject pdfObject3;
        if (pdfObject == null) {
            return null;
        }
        if (pdfObject.isIndirect()) {
            return getPdfObject(pdfObject);
        }
        if (!(pdfObject2 == null || (indRef = pdfObject2.getIndRef()) == null || !indRef.getReader().isAppendable())) {
            int type = pdfObject.type();
            if (type == 1) {
                pdfObject3 = new PdfBoolean(((PdfBoolean) pdfObject).booleanValue());
            } else if (type != 4) {
                if (type == 8) {
                    pdfObject = new PdfNull();
                }
                pdfObject.setIndRef(indRef);
            } else {
                pdfObject3 = new PdfName(pdfObject.getBytes());
            }
            pdfObject = pdfObject3;
            pdfObject.setIndRef(indRef);
        }
        return pdfObject;
    }

    public PdfObject getPdfObjectRelease(int i) {
        PdfObject pdfObject = getPdfObject(i);
        releaseLastXrefPartial();
        return pdfObject;
    }

    public PdfObject getPdfObject(int i) {
        try {
            this.lastXrefPartial = -1;
            if (i >= 0) {
                if (i < this.xrefObj.size()) {
                    PdfObject pdfObject = (PdfObject) this.xrefObj.get(i);
                    if (this.partial) {
                        if (pdfObject == null) {
                            if (i * 2 >= this.xref.length) {
                                return null;
                            }
                            PdfObject readSingleObject = readSingleObject(i);
                            this.lastXrefPartial = -1;
                            if (readSingleObject != null) {
                                this.lastXrefPartial = i;
                            }
                            return readSingleObject;
                        }
                    }
                    return pdfObject;
                }
            }
            return null;
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public void resetLastXrefPartial() {
        this.lastXrefPartial = -1;
    }

    public void releaseLastXrefPartial() {
        int i;
        if (this.partial && (i = this.lastXrefPartial) != -1) {
            this.xrefObj.set(i, (Object) null);
            this.lastXrefPartial = -1;
        }
    }

    public static void releaseLastXrefPartial(PdfObject pdfObject) {
        int i;
        if (pdfObject != null && pdfObject.isIndirect() && (pdfObject instanceof PRIndirectReference)) {
            PRIndirectReference pRIndirectReference = (PRIndirectReference) pdfObject;
            PdfReader reader = pRIndirectReference.getReader();
            if (reader.partial && (i = reader.lastXrefPartial) != -1 && i == pRIndirectReference.getNumber()) {
                reader.xrefObj.set(reader.lastXrefPartial, (Object) null);
            }
            reader.lastXrefPartial = -1;
        }
    }

    private void setXrefPartialObject(int i, PdfObject pdfObject) {
        if (this.partial && i >= 0) {
            this.xrefObj.set(i, pdfObject);
        }
    }

    public PRIndirectReference addPdfObject(PdfObject pdfObject) {
        this.xrefObj.add(pdfObject);
        return new PRIndirectReference(this, this.xrefObj.size() - 1);
    }

    /* access modifiers changed from: protected */
    public void readPages() throws IOException {
        this.catalog = this.trailer.getAsDict(PdfName.ROOT);
        this.rootPages = this.catalog.getAsDict(PdfName.PAGES);
        this.pageRefs = new PageRefs(this, (PageRefs) null);
    }

    /* access modifiers changed from: protected */
    public void readDocObjPartial() throws IOException {
        this.xrefObj = new ArrayList(this.xref.length / 2);
        this.xrefObj.addAll(Collections.nCopies(this.xref.length / 2, (Object) null));
        readDecryptedDocObj();
        IntHashtable intHashtable = this.objStmToOffset;
        if (intHashtable != null) {
            int[] keys = intHashtable.getKeys();
            for (int i : keys) {
                int i2 = i * 2;
                this.objStmToOffset.put(i, this.xref[i2]);
                this.xref[i2] = -1;
            }
        }
    }

    /* access modifiers changed from: protected */
    public PdfObject readSingleObject(int i) throws IOException {
        PdfObject pdfObject;
        this.strings.clear();
        int i2 = i * 2;
        int[] iArr = this.xref;
        int i3 = iArr[i2];
        if (i3 < 0) {
            return null;
        }
        int i4 = i2 + 1;
        if (iArr[i4] > 0) {
            i3 = this.objStmToOffset.get(iArr[i4]);
        }
        if (i3 == 0) {
            return null;
        }
        this.tokens.seek(i3);
        this.tokens.nextValidToken();
        if (this.tokens.getTokenType() != 1) {
            this.tokens.throwError("Invalid object number.");
        }
        this.objNum = this.tokens.intValue();
        this.tokens.nextValidToken();
        if (this.tokens.getTokenType() != 1) {
            this.tokens.throwError("Invalid generation number.");
        }
        this.objGen = this.tokens.intValue();
        this.tokens.nextValidToken();
        if (!this.tokens.getStringValue().equals("obj")) {
            this.tokens.throwError("Token 'obj' expected.");
        }
        try {
            pdfObject = readPRObject();
            for (int i5 = 0; i5 < this.strings.size(); i5++) {
                ((PdfString) this.strings.get(i5)).decrypt(this);
            }
            if (pdfObject.isStream()) {
                checkPRStreamLength((PRStream) pdfObject);
            }
        } catch (Exception unused) {
            pdfObject = null;
        }
        int[] iArr2 = this.xref;
        if (iArr2[i4] > 0) {
            pdfObject = readOneObjStm((PRStream) pdfObject, iArr2[i2]);
        }
        this.xrefObj.set(i, pdfObject);
        return pdfObject;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0037, code lost:
        r5 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.lowagie.text.pdf.PdfObject readOneObjStm(com.lowagie.text.pdf.PRStream r8, int r9) throws java.io.IOException {
        /*
            r7 = this;
            com.lowagie.text.pdf.PdfName r0 = com.lowagie.text.pdf.PdfName.FIRST
            com.lowagie.text.pdf.PdfNumber r0 = r8.getAsNumber(r0)
            int r0 = r0.intValue()
            com.lowagie.text.pdf.PRTokeniser r1 = r7.tokens
            com.lowagie.text.pdf.RandomAccessFileOrArray r1 = r1.getFile()
            byte[] r8 = getStreamBytes(r8, r1)
            com.lowagie.text.pdf.PRTokeniser r1 = r7.tokens
            com.lowagie.text.pdf.PRTokeniser r2 = new com.lowagie.text.pdf.PRTokeniser
            r2.<init>((byte[]) r8)
            r7.tokens = r2
            r8 = 1
            int r9 = r9 + r8
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 1
        L_0x0023:
            if (r3 < r9) goto L_0x0026
            goto L_0x004b
        L_0x0026:
            com.lowagie.text.pdf.PRTokeniser r5 = r7.tokens     // Catch:{ all -> 0x006b }
            boolean r5 = r5.nextToken()     // Catch:{ all -> 0x006b }
            if (r5 != 0) goto L_0x002f
            goto L_0x004b
        L_0x002f:
            com.lowagie.text.pdf.PRTokeniser r5 = r7.tokens     // Catch:{ all -> 0x006b }
            int r5 = r5.getTokenType()     // Catch:{ all -> 0x006b }
            if (r5 == r8) goto L_0x0039
        L_0x0037:
            r5 = 0
            goto L_0x004b
        L_0x0039:
            com.lowagie.text.pdf.PRTokeniser r5 = r7.tokens     // Catch:{ all -> 0x006b }
            boolean r5 = r5.nextToken()     // Catch:{ all -> 0x006b }
            if (r5 != 0) goto L_0x0042
            goto L_0x004b
        L_0x0042:
            com.lowagie.text.pdf.PRTokeniser r6 = r7.tokens     // Catch:{ all -> 0x006b }
            int r6 = r6.getTokenType()     // Catch:{ all -> 0x006b }
            if (r6 == r8) goto L_0x0061
            goto L_0x0037
        L_0x004b:
            if (r5 == 0) goto L_0x0059
            com.lowagie.text.pdf.PRTokeniser r8 = r7.tokens     // Catch:{ all -> 0x006b }
            r8.seek(r4)     // Catch:{ all -> 0x006b }
            com.lowagie.text.pdf.PdfObject r8 = r7.readPRObject()     // Catch:{ all -> 0x006b }
            r7.tokens = r1
            return r8
        L_0x0059:
            com.lowagie.text.exceptions.InvalidPdfException r8 = new com.lowagie.text.exceptions.InvalidPdfException     // Catch:{ all -> 0x006b }
            java.lang.String r9 = "Error reading ObjStm"
            r8.<init>(r9)     // Catch:{ all -> 0x006b }
            throw r8     // Catch:{ all -> 0x006b }
        L_0x0061:
            com.lowagie.text.pdf.PRTokeniser r4 = r7.tokens     // Catch:{ all -> 0x006b }
            int r4 = r4.intValue()     // Catch:{ all -> 0x006b }
            int r4 = r4 + r0
            int r3 = r3 + 1
            goto L_0x0023
        L_0x006b:
            r8 = move-exception
            r7.tokens = r1
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.PdfReader.readOneObjStm(com.lowagie.text.pdf.PRStream, int):com.lowagie.text.pdf.PdfObject");
    }

    public double dumpPerc() {
        int i = 0;
        for (int i2 = 0; i2 < this.xrefObj.size(); i2++) {
            if (this.xrefObj.get(i2) != null) {
                i++;
            }
        }
        return (((double) i) * 100.0d) / ((double) this.xrefObj.size());
    }

    /* access modifiers changed from: protected */
    public void readDocObj() throws IOException {
        PdfObject pdfObject;
        ArrayList arrayList = new ArrayList();
        int i = 2;
        this.xrefObj = new ArrayList(this.xref.length / 2);
        this.xrefObj.addAll(Collections.nCopies(this.xref.length / 2, (Object) null));
        while (true) {
            int[] iArr = this.xref;
            if (i >= iArr.length) {
                break;
            }
            int i2 = iArr[i];
            if (i2 > 0 && iArr[i + 1] <= 0) {
                this.tokens.seek(i2);
                this.tokens.nextValidToken();
                if (this.tokens.getTokenType() != 1) {
                    this.tokens.throwError("Invalid object number.");
                }
                this.objNum = this.tokens.intValue();
                this.tokens.nextValidToken();
                if (this.tokens.getTokenType() != 1) {
                    this.tokens.throwError("Invalid generation number.");
                }
                this.objGen = this.tokens.intValue();
                this.tokens.nextValidToken();
                if (!this.tokens.getStringValue().equals("obj")) {
                    this.tokens.throwError("Token 'obj' expected.");
                }
                try {
                    pdfObject = readPRObject();
                    if (pdfObject.isStream()) {
                        arrayList.add(pdfObject);
                    }
                } catch (Exception unused) {
                    pdfObject = null;
                }
                this.xrefObj.set(i / 2, pdfObject);
            }
            i += 2;
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            checkPRStreamLength((PRStream) arrayList.get(i3));
        }
        readDecryptedDocObj();
        HashMap hashMap = this.objStmMark;
        if (hashMap != null) {
            for (Map.Entry entry : hashMap.entrySet()) {
                int intValue = ((Integer) entry.getKey()).intValue();
                readObjStm((PRStream) this.xrefObj.get(intValue), (IntHashtable) entry.getValue());
                this.xrefObj.set(intValue, (Object) null);
            }
            this.objStmMark = null;
        }
        this.xref = null;
    }

    private void checkPRStreamLength(PRStream pRStream) throws IOException {
        int i;
        int filePointer;
        int length = this.tokens.length();
        int offset = pRStream.getOffset();
        PdfObject pdfObjectRelease = getPdfObjectRelease(pRStream.get(PdfName.LENGTH));
        boolean z = true;
        if (pdfObjectRelease == null || pdfObjectRelease.type() != 2) {
            i = 0;
        } else {
            i = ((PdfNumber) pdfObjectRelease).intValue();
            int i2 = i + offset;
            if (i2 <= length - 20) {
                this.tokens.seek(i2);
                String readString = this.tokens.readString(20);
                if (readString.startsWith("\nendstream") || readString.startsWith("\r\nendstream") || readString.startsWith("\rendstream") || readString.startsWith("endstream")) {
                    z = false;
                }
            }
        }
        if (z) {
            byte[] bArr = new byte[16];
            this.tokens.seek(offset);
            while (true) {
                filePointer = this.tokens.getFilePointer();
                if (this.tokens.readLineSegment(bArr)) {
                    if (equalsn(bArr, endstream)) {
                        break;
                    } else if (equalsn(bArr, endobj)) {
                        int i3 = filePointer - 16;
                        this.tokens.seek(i3);
                        int indexOf = this.tokens.readString(16).indexOf("endstream");
                        if (indexOf >= 0) {
                            filePointer = i3 + indexOf;
                        }
                    }
                } else {
                    break;
                }
            }
            i = filePointer - offset;
        }
        pRStream.setLength(i);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0043, code lost:
        r7 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void readObjStm(com.lowagie.text.pdf.PRStream r10, com.lowagie.text.pdf.IntHashtable r11) throws java.io.IOException {
        /*
            r9 = this;
            com.lowagie.text.pdf.PdfName r0 = com.lowagie.text.pdf.PdfName.FIRST
            com.lowagie.text.pdf.PdfNumber r0 = r10.getAsNumber(r0)
            int r0 = r0.intValue()
            com.lowagie.text.pdf.PdfName r1 = com.lowagie.text.pdf.PdfName.f696N
            com.lowagie.text.pdf.PdfNumber r1 = r10.getAsNumber(r1)
            int r1 = r1.intValue()
            com.lowagie.text.pdf.PRTokeniser r2 = r9.tokens
            com.lowagie.text.pdf.RandomAccessFileOrArray r2 = r2.getFile()
            byte[] r10 = getStreamBytes(r10, r2)
            com.lowagie.text.pdf.PRTokeniser r2 = r9.tokens
            com.lowagie.text.pdf.PRTokeniser r3 = new com.lowagie.text.pdf.PRTokeniser
            r3.<init>((byte[]) r10)
            r9.tokens = r3
            int[] r10 = new int[r1]     // Catch:{ all -> 0x0095 }
            int[] r3 = new int[r1]     // Catch:{ all -> 0x0095 }
            r4 = 0
            r5 = 1
            r6 = 0
            r7 = 1
        L_0x002f:
            if (r6 < r1) goto L_0x0032
            goto L_0x005f
        L_0x0032:
            com.lowagie.text.pdf.PRTokeniser r7 = r9.tokens     // Catch:{ all -> 0x0095 }
            boolean r7 = r7.nextToken()     // Catch:{ all -> 0x0095 }
            if (r7 != 0) goto L_0x003b
            goto L_0x005f
        L_0x003b:
            com.lowagie.text.pdf.PRTokeniser r7 = r9.tokens     // Catch:{ all -> 0x0095 }
            int r7 = r7.getTokenType()     // Catch:{ all -> 0x0095 }
            if (r7 == r5) goto L_0x0045
        L_0x0043:
            r7 = 0
            goto L_0x005f
        L_0x0045:
            com.lowagie.text.pdf.PRTokeniser r7 = r9.tokens     // Catch:{ all -> 0x0095 }
            int r7 = r7.intValue()     // Catch:{ all -> 0x0095 }
            r3[r6] = r7     // Catch:{ all -> 0x0095 }
            com.lowagie.text.pdf.PRTokeniser r7 = r9.tokens     // Catch:{ all -> 0x0095 }
            boolean r7 = r7.nextToken()     // Catch:{ all -> 0x0095 }
            if (r7 != 0) goto L_0x0056
            goto L_0x005f
        L_0x0056:
            com.lowagie.text.pdf.PRTokeniser r8 = r9.tokens     // Catch:{ all -> 0x0095 }
            int r8 = r8.getTokenType()     // Catch:{ all -> 0x0095 }
            if (r8 == r5) goto L_0x0089
            goto L_0x0043
        L_0x005f:
            if (r7 == 0) goto L_0x0081
        L_0x0061:
            if (r4 < r1) goto L_0x0066
            r9.tokens = r2
            return
        L_0x0066:
            boolean r0 = r11.containsKey(r4)     // Catch:{ all -> 0x0095 }
            if (r0 == 0) goto L_0x007e
            com.lowagie.text.pdf.PRTokeniser r0 = r9.tokens     // Catch:{ all -> 0x0095 }
            r5 = r10[r4]     // Catch:{ all -> 0x0095 }
            r0.seek(r5)     // Catch:{ all -> 0x0095 }
            com.lowagie.text.pdf.PdfObject r0 = r9.readPRObject()     // Catch:{ all -> 0x0095 }
            java.util.ArrayList r5 = r9.xrefObj     // Catch:{ all -> 0x0095 }
            r6 = r3[r4]     // Catch:{ all -> 0x0095 }
            r5.set(r6, r0)     // Catch:{ all -> 0x0095 }
        L_0x007e:
            int r4 = r4 + 1
            goto L_0x0061
        L_0x0081:
            com.lowagie.text.exceptions.InvalidPdfException r10 = new com.lowagie.text.exceptions.InvalidPdfException     // Catch:{ all -> 0x0095 }
            java.lang.String r11 = "Error reading ObjStm"
            r10.<init>(r11)     // Catch:{ all -> 0x0095 }
            throw r10     // Catch:{ all -> 0x0095 }
        L_0x0089:
            com.lowagie.text.pdf.PRTokeniser r8 = r9.tokens     // Catch:{ all -> 0x0095 }
            int r8 = r8.intValue()     // Catch:{ all -> 0x0095 }
            int r8 = r8 + r0
            r10[r6] = r8     // Catch:{ all -> 0x0095 }
            int r6 = r6 + 1
            goto L_0x002f
        L_0x0095:
            r10 = move-exception
            r9.tokens = r2
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.PdfReader.readObjStm(com.lowagie.text.pdf.PRStream, com.lowagie.text.pdf.IntHashtable):void");
    }

    public static PdfObject killIndirect(PdfObject pdfObject) {
        if (pdfObject == null || pdfObject.isNull()) {
            return null;
        }
        PdfObject pdfObjectRelease = getPdfObjectRelease(pdfObject);
        if (pdfObject.isIndirect()) {
            PRIndirectReference pRIndirectReference = (PRIndirectReference) pdfObject;
            PdfReader reader = pRIndirectReference.getReader();
            int number = pRIndirectReference.getNumber();
            reader.xrefObj.set(number, (Object) null);
            if (reader.partial) {
                reader.xref[number * 2] = -1;
            }
        }
        return pdfObjectRelease;
    }

    private void ensureXrefSize(int i) {
        if (i != 0) {
            int[] iArr = this.xref;
            if (iArr == null) {
                this.xref = new int[i];
            } else if (iArr.length < i) {
                int[] iArr2 = new int[i];
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                this.xref = iArr2;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void readXref() throws IOException {
        this.hybridXref = false;
        this.newXrefType = false;
        PRTokeniser pRTokeniser = this.tokens;
        pRTokeniser.seek(pRTokeniser.getStartxref());
        this.tokens.nextToken();
        if (this.tokens.getStringValue().equals("startxref")) {
            this.tokens.nextToken();
            if (this.tokens.getTokenType() == 1) {
                int intValue = this.tokens.intValue();
                this.lastXref = intValue;
                this.eofPos = this.tokens.getFilePointer();
                try {
                    if (readXRefStream(intValue)) {
                        this.newXrefType = true;
                        return;
                    }
                } catch (Exception unused) {
                }
                this.xref = null;
                this.tokens.seek(intValue);
                this.trailer = readXrefSection();
                PdfDictionary pdfDictionary = this.trailer;
                while (true) {
                    PdfNumber pdfNumber = (PdfNumber) pdfDictionary.get(PdfName.PREV);
                    if (pdfNumber != null) {
                        this.tokens.seek(pdfNumber.intValue());
                        pdfDictionary = readXrefSection();
                    } else {
                        return;
                    }
                }
            } else {
                throw new InvalidPdfException("startxref is not followed by a number.");
            }
        } else {
            throw new InvalidPdfException("startxref not found.");
        }
    }

    /* access modifiers changed from: protected */
    public PdfDictionary readXrefSection() throws IOException {
        this.tokens.nextValidToken();
        if (!this.tokens.getStringValue().equals("xref")) {
            this.tokens.throwError("xref subsection not found");
        }
        while (true) {
            this.tokens.nextValidToken();
            if (this.tokens.getStringValue().equals("trailer")) {
                break;
            }
            if (this.tokens.getTokenType() != 1) {
                this.tokens.throwError("Object number of the first object in this xref subsection not found");
            }
            int intValue = this.tokens.intValue();
            this.tokens.nextValidToken();
            if (this.tokens.getTokenType() != 1) {
                this.tokens.throwError("Number of entries in this xref subsection not found");
            }
            int intValue2 = this.tokens.intValue() + intValue;
            if (intValue == 1) {
                int filePointer = this.tokens.getFilePointer();
                this.tokens.nextValidToken();
                int intValue3 = this.tokens.intValue();
                this.tokens.nextValidToken();
                int intValue4 = this.tokens.intValue();
                if (intValue3 == 0 && intValue4 == 65535) {
                    intValue--;
                    intValue2--;
                }
                this.tokens.seek(filePointer);
            }
            ensureXrefSize(intValue2 * 2);
            while (intValue < intValue2) {
                this.tokens.nextValidToken();
                int intValue5 = this.tokens.intValue();
                this.tokens.nextValidToken();
                this.tokens.intValue();
                this.tokens.nextValidToken();
                int i = intValue * 2;
                if (this.tokens.getStringValue().equals("n")) {
                    int[] iArr = this.xref;
                    if (iArr[i] == 0 && iArr[i + 1] == 0) {
                        iArr[i] = intValue5;
                    }
                } else if (this.tokens.getStringValue().equals("f")) {
                    int[] iArr2 = this.xref;
                    if (iArr2[i] == 0 && iArr2[i + 1] == 0) {
                        iArr2[i] = -1;
                    }
                } else {
                    this.tokens.throwError("Invalid cross-reference entry in this xref subsection");
                }
                intValue++;
            }
        }
        PdfDictionary pdfDictionary = (PdfDictionary) readPRObject();
        ensureXrefSize(((PdfNumber) pdfDictionary.get(PdfName.SIZE)).intValue() * 2);
        PdfObject pdfObject = pdfDictionary.get(PdfName.XREFSTM);
        if (pdfObject != null && pdfObject.isNumber()) {
            try {
                readXRefStream(((PdfNumber) pdfObject).intValue());
                this.newXrefType = true;
                this.hybridXref = true;
            } catch (IOException e) {
                this.xref = null;
                throw e;
            }
        }
        return pdfDictionary;
    }

    /* JADX WARNING: type inference failed for: r3v2 */
    /* JADX WARNING: type inference failed for: r3v5 */
    /* JADX WARNING: type inference failed for: r3v7 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean readXRefStream(int r20) throws java.io.IOException {
        /*
            r19 = this;
            r0 = r19
            com.lowagie.text.pdf.PRTokeniser r1 = r0.tokens
            r2 = r20
            r1.seek(r2)
            com.lowagie.text.pdf.PRTokeniser r1 = r0.tokens
            boolean r1 = r1.nextToken()
            r2 = 0
            if (r1 != 0) goto L_0x0013
            return r2
        L_0x0013:
            com.lowagie.text.pdf.PRTokeniser r1 = r0.tokens
            int r1 = r1.getTokenType()
            r3 = 1
            if (r1 == r3) goto L_0x001d
            return r2
        L_0x001d:
            com.lowagie.text.pdf.PRTokeniser r1 = r0.tokens
            int r1 = r1.intValue()
            com.lowagie.text.pdf.PRTokeniser r4 = r0.tokens
            boolean r4 = r4.nextToken()
            if (r4 == 0) goto L_0x01fc
            com.lowagie.text.pdf.PRTokeniser r4 = r0.tokens
            int r4 = r4.getTokenType()
            if (r4 == r3) goto L_0x0035
            goto L_0x01fc
        L_0x0035:
            com.lowagie.text.pdf.PRTokeniser r4 = r0.tokens
            boolean r4 = r4.nextToken()
            if (r4 == 0) goto L_0x01fc
            com.lowagie.text.pdf.PRTokeniser r4 = r0.tokens
            java.lang.String r4 = r4.getStringValue()
            java.lang.String r5 = "obj"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x004d
            goto L_0x01fc
        L_0x004d:
            com.lowagie.text.pdf.PdfObject r4 = r19.readPRObject()
            boolean r5 = r4.isStream()
            if (r5 == 0) goto L_0x01fc
            com.lowagie.text.pdf.PRStream r4 = (com.lowagie.text.pdf.PRStream) r4
            com.lowagie.text.pdf.PdfName r5 = com.lowagie.text.pdf.PdfName.XREF
            com.lowagie.text.pdf.PdfName r6 = com.lowagie.text.pdf.PdfName.TYPE
            com.lowagie.text.pdf.PdfObject r6 = r4.get(r6)
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L_0x0068
            return r2
        L_0x0068:
            com.lowagie.text.pdf.PdfDictionary r5 = r0.trailer
            if (r5 != 0) goto L_0x0078
            com.lowagie.text.pdf.PdfDictionary r5 = new com.lowagie.text.pdf.PdfDictionary
            r5.<init>()
            r0.trailer = r5
            com.lowagie.text.pdf.PdfDictionary r5 = r0.trailer
            r5.putAll(r4)
        L_0x0078:
            com.lowagie.text.pdf.PdfName r5 = com.lowagie.text.pdf.PdfName.LENGTH
            com.lowagie.text.pdf.PdfObject r5 = r4.get(r5)
            com.lowagie.text.pdf.PdfNumber r5 = (com.lowagie.text.pdf.PdfNumber) r5
            int r5 = r5.intValue()
            r4.setLength(r5)
            com.lowagie.text.pdf.PdfName r5 = com.lowagie.text.pdf.PdfName.SIZE
            com.lowagie.text.pdf.PdfObject r5 = r4.get(r5)
            com.lowagie.text.pdf.PdfNumber r5 = (com.lowagie.text.pdf.PdfNumber) r5
            int r5 = r5.intValue()
            com.lowagie.text.pdf.PdfName r6 = com.lowagie.text.pdf.PdfName.INDEX
            com.lowagie.text.pdf.PdfObject r6 = r4.get(r6)
            r7 = 2
            if (r6 != 0) goto L_0x00a9
            com.lowagie.text.pdf.PdfArray r6 = new com.lowagie.text.pdf.PdfArray
            r6.<init>()
            int[] r8 = new int[r7]
            r8[r3] = r5
            r6.add((int[]) r8)
            goto L_0x00ab
        L_0x00a9:
            com.lowagie.text.pdf.PdfArray r6 = (com.lowagie.text.pdf.PdfArray) r6
        L_0x00ab:
            com.lowagie.text.pdf.PdfName r8 = com.lowagie.text.pdf.PdfName.f738W
            com.lowagie.text.pdf.PdfObject r8 = r4.get(r8)
            com.lowagie.text.pdf.PdfArray r8 = (com.lowagie.text.pdf.PdfArray) r8
            com.lowagie.text.pdf.PdfName r9 = com.lowagie.text.pdf.PdfName.PREV
            com.lowagie.text.pdf.PdfObject r9 = r4.get(r9)
            r10 = -1
            if (r9 == 0) goto L_0x00c3
            com.lowagie.text.pdf.PdfNumber r9 = (com.lowagie.text.pdf.PdfNumber) r9
            int r9 = r9.intValue()
            goto L_0x00c4
        L_0x00c3:
            r9 = -1
        L_0x00c4:
            int r5 = r5 * 2
            r0.ensureXrefSize(r5)
            java.util.HashMap r5 = r0.objStmMark
            if (r5 != 0) goto L_0x00d8
            boolean r5 = r0.partial
            if (r5 != 0) goto L_0x00d8
            java.util.HashMap r5 = new java.util.HashMap
            r5.<init>()
            r0.objStmMark = r5
        L_0x00d8:
            com.lowagie.text.pdf.IntHashtable r5 = r0.objStmToOffset
            if (r5 != 0) goto L_0x00e7
            boolean r5 = r0.partial
            if (r5 == 0) goto L_0x00e7
            com.lowagie.text.pdf.IntHashtable r5 = new com.lowagie.text.pdf.IntHashtable
            r5.<init>()
            r0.objStmToOffset = r5
        L_0x00e7:
            com.lowagie.text.pdf.PRTokeniser r5 = r0.tokens
            com.lowagie.text.pdf.RandomAccessFileOrArray r5 = r5.getFile()
            byte[] r4 = getStreamBytes(r4, r5)
            r5 = 3
            int[] r11 = new int[r5]
            r12 = 0
        L_0x00f5:
            if (r12 < r5) goto L_0x01e7
            r5 = 0
            r13 = 0
        L_0x00f9:
            int r8 = r6.size()
            if (r13 < r8) goto L_0x0110
            int r1 = r1 * 2
            int[] r2 = r0.xref
            int r4 = r2.length
            if (r1 >= r4) goto L_0x0108
            r2[r1] = r10
        L_0x0108:
            if (r9 != r10) goto L_0x010b
            return r3
        L_0x010b:
            boolean r1 = r0.readXRefStream(r9)
            return r1
        L_0x0110:
            com.lowagie.text.pdf.PdfNumber r8 = r6.getAsNumber(r13)
            int r8 = r8.intValue()
            int r12 = r13 + 1
            com.lowagie.text.pdf.PdfNumber r12 = r6.getAsNumber(r12)
            int r12 = r12.intValue()
            int r14 = r8 + r12
            int r14 = r14 * 2
            r0.ensureXrefSize(r14)
            r14 = r8
        L_0x012a:
            int r15 = r12 + -1
            if (r12 > 0) goto L_0x0131
            int r13 = r13 + 2
            goto L_0x00f9
        L_0x0131:
            r8 = r11[r2]
            if (r8 <= 0) goto L_0x014c
            r12 = r5
            r5 = 0
            r8 = 0
        L_0x0138:
            r10 = r11[r2]
            if (r5 < r10) goto L_0x013f
            r10 = r8
            r5 = r12
            goto L_0x014d
        L_0x013f:
            int r8 = r8 << 8
            int r10 = r12 + 1
            byte r12 = r4[r12]
            r12 = r12 & 255(0xff, float:3.57E-43)
            int r8 = r8 + r12
            int r5 = r5 + 1
            r12 = r10
            goto L_0x0138
        L_0x014c:
            r10 = 1
        L_0x014d:
            r12 = r5
            r5 = 0
            r8 = 0
        L_0x0150:
            r2 = r11[r3]
            if (r5 < r2) goto L_0x01d3
            r2 = 0
            r5 = 0
        L_0x0156:
            r3 = r11[r7]
            if (r2 < r3) goto L_0x01bf
            int r2 = r14 * 2
            int[] r3 = r0.xref
            r17 = r3[r2]
            if (r17 != 0) goto L_0x01b0
            int r17 = r2 + 1
            r18 = r3[r17]
            if (r18 != 0) goto L_0x01b0
            if (r10 == 0) goto L_0x01a9
            r18 = r1
            r1 = 1
            if (r10 == r1) goto L_0x01a4
            if (r10 == r7) goto L_0x0172
            goto L_0x01b2
        L_0x0172:
            r3[r2] = r5
            r3[r17] = r8
            boolean r1 = r0.partial
            if (r1 == 0) goto L_0x0181
            com.lowagie.text.pdf.IntHashtable r1 = r0.objStmToOffset
            r2 = 0
            r1.put(r8, r2)
            goto L_0x01b2
        L_0x0181:
            java.lang.Integer r1 = new java.lang.Integer
            r1.<init>(r8)
            java.util.HashMap r2 = r0.objStmMark
            java.lang.Object r2 = r2.get(r1)
            com.lowagie.text.pdf.IntHashtable r2 = (com.lowagie.text.pdf.IntHashtable) r2
            if (r2 != 0) goto L_0x019f
            com.lowagie.text.pdf.IntHashtable r2 = new com.lowagie.text.pdf.IntHashtable
            r2.<init>()
            r10 = 1
            r2.put(r5, r10)
            java.util.HashMap r3 = r0.objStmMark
            r3.put(r1, r2)
            goto L_0x01a7
        L_0x019f:
            r10 = 1
            r2.put(r5, r10)
            goto L_0x01a7
        L_0x01a4:
            r10 = 1
            r3[r2] = r8
        L_0x01a7:
            r1 = -1
            goto L_0x01b4
        L_0x01a9:
            r18 = r1
            r1 = -1
            r10 = 1
            r3[r2] = r1
            goto L_0x01b4
        L_0x01b0:
            r18 = r1
        L_0x01b2:
            r1 = -1
            r10 = 1
        L_0x01b4:
            int r14 = r14 + 1
            r5 = r12
            r12 = r15
            r1 = r18
            r2 = 0
            r3 = 1
            r10 = -1
            goto L_0x012a
        L_0x01bf:
            r18 = r1
            r1 = -1
            r3 = 1
            int r5 = r5 << 8
            int r16 = r12 + 1
            byte r12 = r4[r12]
            r12 = r12 & 255(0xff, float:3.57E-43)
            int r5 = r5 + r12
            int r2 = r2 + 1
            r12 = r16
            r1 = r18
            goto L_0x0156
        L_0x01d3:
            r18 = r1
            r1 = -1
            int r2 = r8 << 8
            int r8 = r12 + 1
            byte r12 = r4[r12]
            r12 = r12 & 255(0xff, float:3.57E-43)
            int r2 = r2 + r12
            int r5 = r5 + 1
            r12 = r8
            r1 = r18
            r8 = r2
            goto L_0x0150
        L_0x01e7:
            r18 = r1
            r1 = -1
            com.lowagie.text.pdf.PdfNumber r2 = r8.getAsNumber(r12)
            int r2 = r2.intValue()
            r11[r12] = r2
            int r12 = r12 + 1
            r1 = r18
            r2 = 0
            r10 = -1
            goto L_0x00f5
        L_0x01fc:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.PdfReader.readXRefStream(int):boolean");
    }

    /* access modifiers changed from: protected */
    public void rebuildXref() throws IOException {
        int[] checkObjectStart;
        this.hybridXref = false;
        this.newXrefType = false;
        this.tokens.seek(0);
        this.trailer = null;
        byte[] bArr = new byte[64];
        int[][] iArr = new int[1024][];
        int i = 0;
        while (true) {
            int filePointer = this.tokens.getFilePointer();
            if (!this.tokens.readLineSegment(bArr)) {
                break;
            } else if (bArr[0] == 116) {
                if (PdfEncodings.convertToString(bArr, (String) null).startsWith("trailer")) {
                    this.tokens.seek(filePointer);
                    this.tokens.nextToken();
                    int filePointer2 = this.tokens.getFilePointer();
                    try {
                        PdfDictionary pdfDictionary = (PdfDictionary) readPRObject();
                        if (pdfDictionary.get(PdfName.ROOT) != null) {
                            this.trailer = pdfDictionary;
                        } else {
                            this.tokens.seek(filePointer2);
                        }
                    } catch (Exception unused) {
                        this.tokens.seek(filePointer2);
                    }
                }
            } else if (bArr[0] >= 48 && bArr[0] <= 57 && (checkObjectStart = PRTokeniser.checkObjectStart(bArr)) != null) {
                int i2 = checkObjectStart[0];
                int i3 = checkObjectStart[1];
                if (i2 >= iArr.length) {
                    int[][] iArr2 = new int[(i2 * 2)][];
                    System.arraycopy(iArr, 0, iArr2, 0, i);
                    iArr = iArr2;
                }
                if (i2 >= i) {
                    i = i2 + 1;
                }
                if (iArr[i2] == null || i3 >= iArr[i2][1]) {
                    checkObjectStart[0] = filePointer;
                    iArr[i2] = checkObjectStart;
                }
            }
        }
        if (this.trailer != null) {
            this.xref = new int[(i * 2)];
            for (int i4 = 0; i4 < i; i4++) {
                int[] iArr3 = iArr[i4];
                if (iArr3 != null) {
                    this.xref[i4 * 2] = iArr3[0];
                }
            }
            return;
        }
        throw new InvalidPdfException("trailer not found.");
    }

    /* access modifiers changed from: protected */
    public PdfDictionary readDictionary() throws IOException {
        PdfDictionary pdfDictionary = new PdfDictionary();
        while (true) {
            this.tokens.nextValidToken();
            if (this.tokens.getTokenType() == 8) {
                return pdfDictionary;
            }
            if (this.tokens.getTokenType() != 3) {
                this.tokens.throwError("Dictionary key is not a name.");
            }
            PdfName pdfName = new PdfName(this.tokens.getStringValue(), false);
            PdfObject readPRObject = readPRObject();
            int i = -readPRObject.type();
            if (i == 8) {
                this.tokens.throwError("Unexpected '>>'");
            }
            if (i == 6) {
                this.tokens.throwError("Unexpected ']'");
            }
            pdfDictionary.put(pdfName, readPRObject);
        }
    }

    /* access modifiers changed from: protected */
    public PdfArray readArray() throws IOException {
        PdfArray pdfArray = new PdfArray();
        while (true) {
            PdfObject readPRObject = readPRObject();
            int i = -readPRObject.type();
            if (i == 6) {
                return pdfArray;
            }
            if (i == 8) {
                this.tokens.throwError("Unexpected '>>'");
            }
            pdfArray.add(readPRObject);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00b8 A[LOOP:1: B:47:0x00b8->B:78:0x00b8, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00f1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.lowagie.text.pdf.PdfObject readPRObject() throws java.io.IOException {
        /*
            r6 = this;
            com.lowagie.text.pdf.PRTokeniser r0 = r6.tokens
            r0.nextValidToken()
            com.lowagie.text.pdf.PRTokeniser r0 = r6.tokens
            int r0 = r0.getTokenType()
            r1 = 1
            if (r0 == r1) goto L_0x014c
            r2 = 2
            if (r0 == r2) goto L_0x0127
            r2 = 3
            r3 = 0
            if (r0 == r2) goto L_0x0106
            r2 = 5
            if (r0 == r2) goto L_0x00f7
            r2 = 7
            r4 = 9
            if (r0 == r2) goto L_0x0083
            if (r0 == r4) goto L_0x0071
            com.lowagie.text.pdf.PRTokeniser r2 = r6.tokens
            java.lang.String r2 = r2.getStringValue()
            java.lang.String r4 = "null"
            boolean r4 = r4.equals(r2)
            if (r4 == 0) goto L_0x003a
            int r0 = r6.readDepth
            if (r0 != 0) goto L_0x0037
            com.lowagie.text.pdf.PdfNull r0 = new com.lowagie.text.pdf.PdfNull
            r0.<init>()
            return r0
        L_0x0037:
            com.lowagie.text.pdf.PdfNull r0 = com.lowagie.text.pdf.PdfNull.PDFNULL
            return r0
        L_0x003a:
            java.lang.String r4 = "true"
            boolean r4 = r4.equals(r2)
            if (r4 == 0) goto L_0x004f
            int r0 = r6.readDepth
            if (r0 != 0) goto L_0x004c
            com.lowagie.text.pdf.PdfBoolean r0 = new com.lowagie.text.pdf.PdfBoolean
            r0.<init>((boolean) r1)
            return r0
        L_0x004c:
            com.lowagie.text.pdf.PdfBoolean r0 = com.lowagie.text.pdf.PdfBoolean.PDFTRUE
            return r0
        L_0x004f:
            java.lang.String r1 = "false"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0064
            int r0 = r6.readDepth
            if (r0 != 0) goto L_0x0061
            com.lowagie.text.pdf.PdfBoolean r0 = new com.lowagie.text.pdf.PdfBoolean
            r0.<init>((boolean) r3)
            return r0
        L_0x0061:
            com.lowagie.text.pdf.PdfBoolean r0 = com.lowagie.text.pdf.PdfBoolean.PDFFALSE
            return r0
        L_0x0064:
            com.lowagie.text.pdf.PdfLiteral r1 = new com.lowagie.text.pdf.PdfLiteral
            int r0 = -r0
            com.lowagie.text.pdf.PRTokeniser r2 = r6.tokens
            java.lang.String r2 = r2.getStringValue()
            r1.<init>((int) r0, (java.lang.String) r2)
            return r1
        L_0x0071:
            com.lowagie.text.pdf.PRTokeniser r0 = r6.tokens
            int r0 = r0.getReference()
            com.lowagie.text.pdf.PRIndirectReference r1 = new com.lowagie.text.pdf.PRIndirectReference
            com.lowagie.text.pdf.PRTokeniser r2 = r6.tokens
            int r2 = r2.getGeneration()
            r1.<init>(r6, r0, r2)
            return r1
        L_0x0083:
            int r0 = r6.readDepth
            int r0 = r0 + r1
            r6.readDepth = r0
            com.lowagie.text.pdf.PdfDictionary r0 = r6.readDictionary()
            int r2 = r6.readDepth
            int r2 = r2 - r1
            r6.readDepth = r2
            com.lowagie.text.pdf.PRTokeniser r1 = r6.tokens
            int r1 = r1.getFilePointer()
        L_0x0097:
            com.lowagie.text.pdf.PRTokeniser r2 = r6.tokens
            boolean r2 = r2.nextToken()
            if (r2 == 0) goto L_0x00a8
            com.lowagie.text.pdf.PRTokeniser r3 = r6.tokens
            int r3 = r3.getTokenType()
            r5 = 4
            if (r3 == r5) goto L_0x0097
        L_0x00a8:
            if (r2 == 0) goto L_0x00f1
            com.lowagie.text.pdf.PRTokeniser r2 = r6.tokens
            java.lang.String r2 = r2.getStringValue()
            java.lang.String r3 = "stream"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x00f1
        L_0x00b8:
            com.lowagie.text.pdf.PRTokeniser r1 = r6.tokens
            int r1 = r1.read()
            r2 = 32
            if (r1 == r2) goto L_0x00b8
            if (r1 == r4) goto L_0x00b8
            if (r1 == 0) goto L_0x00b8
            r2 = 12
            if (r1 == r2) goto L_0x00b8
            r2 = 10
            if (r1 == r2) goto L_0x00d4
            com.lowagie.text.pdf.PRTokeniser r1 = r6.tokens
            int r1 = r1.read()
        L_0x00d4:
            if (r1 == r2) goto L_0x00db
            com.lowagie.text.pdf.PRTokeniser r2 = r6.tokens
            r2.backOnePosition(r1)
        L_0x00db:
            com.lowagie.text.pdf.PRStream r1 = new com.lowagie.text.pdf.PRStream
            com.lowagie.text.pdf.PRTokeniser r2 = r6.tokens
            int r2 = r2.getFilePointer()
            r1.<init>((com.lowagie.text.pdf.PdfReader) r6, (int) r2)
            r1.putAll(r0)
            int r0 = r6.objNum
            int r2 = r6.objGen
            r1.setObjNum(r0, r2)
            return r1
        L_0x00f1:
            com.lowagie.text.pdf.PRTokeniser r2 = r6.tokens
            r2.seek(r1)
            return r0
        L_0x00f7:
            int r0 = r6.readDepth
            int r0 = r0 + r1
            r6.readDepth = r0
            com.lowagie.text.pdf.PdfArray r0 = r6.readArray()
            int r2 = r6.readDepth
            int r2 = r2 - r1
            r6.readDepth = r2
            return r0
        L_0x0106:
            java.util.Map r0 = com.lowagie.text.pdf.PdfName.staticNames
            com.lowagie.text.pdf.PRTokeniser r1 = r6.tokens
            java.lang.String r1 = r1.getStringValue()
            java.lang.Object r0 = r0.get(r1)
            com.lowagie.text.pdf.PdfName r0 = (com.lowagie.text.pdf.PdfName) r0
            int r1 = r6.readDepth
            if (r1 <= 0) goto L_0x011b
            if (r0 == 0) goto L_0x011b
            return r0
        L_0x011b:
            com.lowagie.text.pdf.PdfName r0 = new com.lowagie.text.pdf.PdfName
            com.lowagie.text.pdf.PRTokeniser r1 = r6.tokens
            java.lang.String r1 = r1.getStringValue()
            r0.<init>(r1, r3)
            return r0
        L_0x0127:
            com.lowagie.text.pdf.PdfString r0 = new com.lowagie.text.pdf.PdfString
            com.lowagie.text.pdf.PRTokeniser r1 = r6.tokens
            java.lang.String r1 = r1.getStringValue()
            r2 = 0
            r0.<init>(r1, r2)
            com.lowagie.text.pdf.PRTokeniser r1 = r6.tokens
            boolean r1 = r1.isHexString()
            com.lowagie.text.pdf.PdfString r0 = r0.setHexWriting(r1)
            int r1 = r6.objNum
            int r2 = r6.objGen
            r0.setObjNum(r1, r2)
            java.util.ArrayList r1 = r6.strings
            if (r1 == 0) goto L_0x014b
            r1.add(r0)
        L_0x014b:
            return r0
        L_0x014c:
            com.lowagie.text.pdf.PdfNumber r0 = new com.lowagie.text.pdf.PdfNumber
            com.lowagie.text.pdf.PRTokeniser r1 = r6.tokens
            java.lang.String r1 = r1.getStringValue()
            r0.<init>((java.lang.String) r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.PdfReader.readPRObject():com.lowagie.text.pdf.PdfObject");
    }

    public static byte[] FlateDecode(byte[] bArr) {
        byte[] FlateDecode = FlateDecode(bArr, true);
        return FlateDecode == null ? FlateDecode(bArr, false) : FlateDecode;
    }

    public static byte[] decodePredictor(byte[] bArr, PdfObject pdfObject) {
        if (pdfObject == null || !pdfObject.isDictionary()) {
            return bArr;
        }
        PdfDictionary pdfDictionary = (PdfDictionary) pdfObject;
        PdfObject pdfObject2 = getPdfObject(pdfDictionary.get(PdfName.PREDICTOR));
        if (pdfObject2 == null || !pdfObject2.isNumber() || ((PdfNumber) pdfObject2).intValue() < 10) {
            return bArr;
        }
        PdfObject pdfObject3 = getPdfObject(pdfDictionary.get(PdfName.COLUMNS));
        int intValue = (pdfObject3 == null || !pdfObject3.isNumber()) ? 1 : ((PdfNumber) pdfObject3).intValue();
        PdfObject pdfObject4 = getPdfObject(pdfDictionary.get(PdfName.COLORS));
        int intValue2 = (pdfObject4 == null || !pdfObject4.isNumber()) ? 1 : ((PdfNumber) pdfObject4).intValue();
        PdfObject pdfObject5 = getPdfObject(pdfDictionary.get(PdfName.BITSPERCOMPONENT));
        int intValue3 = (pdfObject5 == null || !pdfObject5.isNumber()) ? 8 : ((PdfNumber) pdfObject5).intValue();
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
        int i = (intValue2 * intValue3) / 8;
        int i2 = (((intValue2 * intValue) * intValue3) + 7) / 8;
        byte[] bArr2 = new byte[i2];
        byte[] bArr3 = new byte[i2];
        while (true) {
            try {
                int read = dataInputStream.read();
                if (read < 0) {
                    return byteArrayOutputStream.toByteArray();
                }
                int i3 = 0;
                dataInputStream.readFully(bArr2, 0, i2);
                if (read != 0) {
                    if (read == 1) {
                        for (int i4 = i; i4 < i2; i4++) {
                            bArr2[i4] = (byte) (bArr2[i4] + bArr2[i4 - i]);
                        }
                    } else if (read == 2) {
                        while (i3 < i2) {
                            bArr2[i3] = (byte) (bArr2[i3] + bArr3[i3]);
                            i3++;
                        }
                    } else if (read == 3) {
                        while (i3 < i) {
                            bArr2[i3] = (byte) (bArr2[i3] + (bArr3[i3] / 2));
                            i3++;
                        }
                        for (int i5 = i; i5 < i2; i5++) {
                            bArr2[i5] = (byte) (bArr2[i5] + (((bArr2[i5 - i] & 255) + (bArr3[i5] & 255)) / 2));
                        }
                    } else if (read == 4) {
                        while (i3 < i) {
                            bArr2[i3] = (byte) (bArr2[i3] + bArr3[i3]);
                            i3++;
                        }
                        for (int i6 = i; i6 < i2; i6++) {
                            int i7 = i6 - i;
                            byte b = bArr2[i7] & 255;
                            byte b2 = bArr3[i6] & 255;
                            byte b3 = bArr3[i7] & 255;
                            int i8 = (b + b2) - b3;
                            int abs = Math.abs(i8 - b);
                            int abs2 = Math.abs(i8 - b2);
                            int abs3 = Math.abs(i8 - b3);
                            if (abs <= abs2 && abs <= abs3) {
                                b3 = b;
                            } else if (abs2 <= abs3) {
                                b3 = b2;
                            }
                            bArr2[i6] = (byte) (bArr2[i6] + ((byte) b3));
                        }
                    } else {
                        throw new RuntimeException("PNG filter unknown.");
                    }
                }
                try {
                    byteArrayOutputStream.write(bArr2);
                } catch (IOException unused) {
                }
                byte[] bArr4 = bArr3;
                bArr3 = bArr2;
                bArr2 = bArr4;
            } catch (Exception unused2) {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public static byte[] FlateDecode(byte[] bArr, boolean z) {
        InflaterInputStream inflaterInputStream = new InflaterInputStream(new ByteArrayInputStream(bArr));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr2 = new byte[(z ? 4092 : 1)];
        while (true) {
            try {
                int read = inflaterInputStream.read(bArr2);
                if (read < 0) {
                    inflaterInputStream.close();
                    byteArrayOutputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            } catch (Exception unused) {
                if (z) {
                    return null;
                }
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public static byte[] ASCIIHexDecode(byte[] bArr) {
        byte b;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        boolean z = true;
        int i2 = 0;
        while (i < bArr.length && (b = bArr[i] & 255) != 62) {
            if (!PRTokeniser.isWhitespace(b)) {
                int hex = PRTokeniser.getHex(b);
                if (hex != -1) {
                    if (z) {
                        i2 = hex;
                    } else {
                        byteArrayOutputStream.write((byte) ((i2 << 4) + hex));
                    }
                    z = !z;
                } else {
                    throw new RuntimeException("Illegal character in ASCIIHexDecode.");
                }
            }
            i++;
        }
        if (!z) {
            byteArrayOutputStream.write((byte) (i2 << 4));
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] ASCII85Decode(byte[] bArr) {
        byte b;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int[] iArr = new int[5];
        int i = 0;
        int i2 = 0;
        while (i < bArr.length && (b = bArr[i] & 255) != 126) {
            if (!PRTokeniser.isWhitespace(b)) {
                if (b == 122 && i2 == 0) {
                    byteArrayOutputStream.write(0);
                    byteArrayOutputStream.write(0);
                    byteArrayOutputStream.write(0);
                    byteArrayOutputStream.write(0);
                } else if (b < 33 || b > 117) {
                    throw new RuntimeException("Illegal character in ASCII85Decode.");
                } else {
                    iArr[i2] = b - 33;
                    i2++;
                    if (i2 == 5) {
                        int i3 = 0;
                        for (int i4 = 0; i4 < 5; i4++) {
                            i3 = (i3 * 85) + iArr[i4];
                        }
                        byteArrayOutputStream.write((byte) (i3 >> 24));
                        byteArrayOutputStream.write((byte) (i3 >> 16));
                        byteArrayOutputStream.write((byte) (i3 >> 8));
                        byteArrayOutputStream.write((byte) i3);
                        i2 = 0;
                    }
                }
            }
            i++;
        }
        if (i2 == 2) {
            byteArrayOutputStream.write((byte) (((((((((iArr[0] * 85) * 85) * 85) * 85) + (((iArr[1] * 85) * 85) * 85)) + 614125) + 7225) + 85) >> 24));
        } else if (i2 == 3) {
            int i5 = (iArr[0] * 85 * 85 * 85 * 85) + (iArr[1] * 85 * 85 * 85) + (iArr[2] * 85 * 85) + 7225 + 85;
            byteArrayOutputStream.write((byte) (i5 >> 24));
            byteArrayOutputStream.write((byte) (i5 >> 16));
        } else if (i2 == 4) {
            int i6 = (iArr[0] * 85 * 85 * 85 * 85) + (iArr[1] * 85 * 85 * 85) + (iArr[2] * 85 * 85) + (iArr[3] * 85) + 85;
            byteArrayOutputStream.write((byte) (i6 >> 24));
            byteArrayOutputStream.write((byte) (i6 >> 16));
            byteArrayOutputStream.write((byte) (i6 >> 8));
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] LZWDecode(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        new LZWDecoder().decode(bArr, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public boolean isRebuilt() {
        return this.rebuilt;
    }

    public PdfDictionary getPageN(int i) {
        PdfDictionary pageN = this.pageRefs.getPageN(i);
        if (pageN == null) {
            return null;
        }
        if (this.appendable) {
            pageN.setIndRef(this.pageRefs.getPageOrigRef(i));
        }
        return pageN;
    }

    public PdfDictionary getPageNRelease(int i) {
        PdfDictionary pageN = getPageN(i);
        this.pageRefs.releasePage(i);
        return pageN;
    }

    public void releasePage(int i) {
        this.pageRefs.releasePage(i);
    }

    public void resetReleasePage() {
        this.pageRefs.resetReleasePage();
    }

    public PRIndirectReference getPageOrigRef(int i) {
        return this.pageRefs.getPageOrigRef(i);
    }

    public byte[] getPageContent(int i, RandomAccessFileOrArray randomAccessFileOrArray) throws IOException {
        PdfDictionary pageNRelease = getPageNRelease(i);
        if (pageNRelease == null) {
            return null;
        }
        PdfObject pdfObjectRelease = getPdfObjectRelease(pageNRelease.get(PdfName.CONTENTS));
        if (pdfObjectRelease == null) {
            return new byte[0];
        }
        if (pdfObjectRelease.isStream()) {
            return getStreamBytes((PRStream) pdfObjectRelease, randomAccessFileOrArray);
        }
        if (!pdfObjectRelease.isArray()) {
            return new byte[0];
        }
        PdfArray pdfArray = (PdfArray) pdfObjectRelease;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i2 = 0; i2 < pdfArray.size(); i2++) {
            PdfObject pdfObjectRelease2 = getPdfObjectRelease(pdfArray.getPdfObject(i2));
            if (pdfObjectRelease2 != null && pdfObjectRelease2.isStream()) {
                byteArrayOutputStream.write(getStreamBytes((PRStream) pdfObjectRelease2, randomAccessFileOrArray));
                if (i2 != pdfArray.size() - 1) {
                    byteArrayOutputStream.write(10);
                }
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    public byte[] getPageContent(int i) throws IOException {
        RandomAccessFileOrArray safeFile = getSafeFile();
        try {
            safeFile.reOpen();
            return getPageContent(i, safeFile);
        } finally {
            try {
                safeFile.close();
            } catch (Exception unused) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public void killXref(PdfObject pdfObject) {
        if (pdfObject != null) {
            if (!(pdfObject instanceof PdfIndirectReference) || pdfObject.isIndirect()) {
                int type = pdfObject.type();
                if (type == 5) {
                    PdfArray pdfArray = (PdfArray) pdfObject;
                    for (int i = 0; i < pdfArray.size(); i++) {
                        killXref(pdfArray.getPdfObject(i));
                    }
                } else if (type == 6 || type == 7) {
                    PdfDictionary pdfDictionary = (PdfDictionary) pdfObject;
                    for (PdfName pdfName : pdfDictionary.getKeys()) {
                        killXref(pdfDictionary.get(pdfName));
                    }
                } else if (type == 10) {
                    int number = ((PRIndirectReference) pdfObject).getNumber();
                    this.xrefObj.set(number, (Object) null);
                    this.freeXref = number;
                    killXref((PdfObject) this.xrefObj.get(number));
                }
            }
        }
    }

    public void setPageContent(int i, byte[] bArr) {
        setPageContent(i, bArr, -1);
    }

    public void setPageContent(int i, byte[] bArr, int i2) {
        PdfDictionary pageN = getPageN(i);
        if (pageN != null) {
            PdfObject pdfObject = pageN.get(PdfName.CONTENTS);
            this.freeXref = -1;
            killXref(pdfObject);
            if (this.freeXref == -1) {
                this.xrefObj.add((Object) null);
                this.freeXref = this.xrefObj.size() - 1;
            }
            pageN.put(PdfName.CONTENTS, new PRIndirectReference(this, this.freeXref));
            this.xrefObj.set(this.freeXref, new PRStream(this, bArr, i2));
        }
    }

    public static byte[] getStreamBytes(PRStream pRStream, RandomAccessFileOrArray randomAccessFileOrArray) throws IOException {
        PdfObject pdfObjectRelease = getPdfObjectRelease(pRStream.get(PdfName.FILTER));
        byte[] streamBytesRaw = getStreamBytesRaw(pRStream, randomAccessFileOrArray);
        ArrayList arrayList = new ArrayList();
        if (pdfObjectRelease != null) {
            if (pdfObjectRelease.isName()) {
                arrayList.add(pdfObjectRelease);
            } else if (pdfObjectRelease.isArray()) {
                arrayList = ((PdfArray) pdfObjectRelease).getArrayList();
            }
        }
        ArrayList arrayList2 = new ArrayList();
        PdfObject pdfObjectRelease2 = getPdfObjectRelease(pRStream.get(PdfName.DECODEPARMS));
        if (pdfObjectRelease2 == null || (!pdfObjectRelease2.isDictionary() && !pdfObjectRelease2.isArray())) {
            pdfObjectRelease2 = getPdfObjectRelease(pRStream.get(PdfName.f666DP));
        }
        if (pdfObjectRelease2 != null) {
            if (pdfObjectRelease2.isDictionary()) {
                arrayList2.add(pdfObjectRelease2);
            } else if (pdfObjectRelease2.isArray()) {
                arrayList2 = ((PdfArray) pdfObjectRelease2).getArrayList();
            }
        }
        for (int i = 0; i < arrayList.size(); i++) {
            String pdfName = ((PdfName) getPdfObjectRelease((PdfObject) arrayList.get(i))).toString();
            if (pdfName.equals("/FlateDecode") || pdfName.equals("/Fl")) {
                streamBytesRaw = FlateDecode(streamBytesRaw);
                if (i < arrayList2.size()) {
                    streamBytesRaw = decodePredictor(streamBytesRaw, (PdfObject) arrayList2.get(i));
                }
            } else if (pdfName.equals("/ASCIIHexDecode") || pdfName.equals("/AHx")) {
                streamBytesRaw = ASCIIHexDecode(streamBytesRaw);
            } else if (pdfName.equals("/ASCII85Decode") || pdfName.equals("/A85")) {
                streamBytesRaw = ASCII85Decode(streamBytesRaw);
            } else if (pdfName.equals("/LZWDecode")) {
                streamBytesRaw = LZWDecode(streamBytesRaw);
                if (i < arrayList2.size()) {
                    streamBytesRaw = decodePredictor(streamBytesRaw, (PdfObject) arrayList2.get(i));
                }
            } else if (!pdfName.equals("/Crypt")) {
                throw new UnsupportedPdfException("The filter " + pdfName + " is not supported.");
            }
        }
        return streamBytesRaw;
    }

    public static byte[] getStreamBytes(PRStream pRStream) throws IOException {
        RandomAccessFileOrArray safeFile = pRStream.getReader().getSafeFile();
        try {
            safeFile.reOpen();
            return getStreamBytes(pRStream, safeFile);
        } finally {
            try {
                safeFile.close();
            } catch (Exception unused) {
            }
        }
    }

    public static byte[] getStreamBytesRaw(PRStream pRStream, RandomAccessFileOrArray randomAccessFileOrArray) throws IOException {
        PdfReader reader = pRStream.getReader();
        if (pRStream.getOffset() < 0) {
            return pRStream.getBytes();
        }
        byte[] bArr = new byte[pRStream.getLength()];
        randomAccessFileOrArray.seek(pRStream.getOffset());
        randomAccessFileOrArray.readFully(bArr);
        PdfEncryption decrypt2 = reader.getDecrypt();
        if (decrypt2 != null) {
            PdfObject pdfObjectRelease = getPdfObjectRelease(pRStream.get(PdfName.FILTER));
            ArrayList arrayList = new ArrayList();
            if (pdfObjectRelease != null) {
                if (pdfObjectRelease.isName()) {
                    arrayList.add(pdfObjectRelease);
                } else if (pdfObjectRelease.isArray()) {
                    arrayList = ((PdfArray) pdfObjectRelease).getArrayList();
                }
            }
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= arrayList.size()) {
                    break;
                }
                PdfObject pdfObjectRelease2 = getPdfObjectRelease((PdfObject) arrayList.get(i));
                if (pdfObjectRelease2 != null && pdfObjectRelease2.toString().equals("/Crypt")) {
                    z = true;
                    break;
                }
                i++;
            }
            if (!z) {
                decrypt2.setHashKey(pRStream.getObjNum(), pRStream.getObjGen());
                return decrypt2.decryptByteArray(bArr);
            }
        }
        return bArr;
    }

    public static byte[] getStreamBytesRaw(PRStream pRStream) throws IOException {
        RandomAccessFileOrArray safeFile = pRStream.getReader().getSafeFile();
        try {
            safeFile.reOpen();
            return getStreamBytesRaw(pRStream, safeFile);
        } finally {
            try {
                safeFile.close();
            } catch (Exception unused) {
            }
        }
    }

    public void eliminateSharedStreams() {
        PdfObject pdfObject;
        if (this.sharedStreams) {
            this.sharedStreams = false;
            if (this.pageRefs.size() != 1) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                IntHashtable intHashtable = new IntHashtable();
                for (int i = 1; i <= this.pageRefs.size(); i++) {
                    PdfDictionary pageN = this.pageRefs.getPageN(i);
                    if (!(pageN == null || (pdfObject = getPdfObject(pageN.get(PdfName.CONTENTS))) == null)) {
                        if (pdfObject.isStream()) {
                            PRIndirectReference pRIndirectReference = (PRIndirectReference) pageN.get(PdfName.CONTENTS);
                            if (intHashtable.containsKey(pRIndirectReference.getNumber())) {
                                arrayList.add(pRIndirectReference);
                                arrayList2.add(new PRStream((PRStream) pdfObject, (PdfDictionary) null));
                            } else {
                                intHashtable.put(pRIndirectReference.getNumber(), 1);
                            }
                        } else if (pdfObject.isArray()) {
                            PdfArray pdfArray = (PdfArray) pdfObject;
                            for (int i2 = 0; i2 < pdfArray.size(); i2++) {
                                PRIndirectReference pRIndirectReference2 = (PRIndirectReference) pdfArray.getPdfObject(i2);
                                if (intHashtable.containsKey(pRIndirectReference2.getNumber())) {
                                    arrayList.add(pRIndirectReference2);
                                    arrayList2.add(new PRStream((PRStream) getPdfObject((PdfObject) pRIndirectReference2), (PdfDictionary) null));
                                } else {
                                    intHashtable.put(pRIndirectReference2.getNumber(), 1);
                                }
                            }
                        }
                    }
                }
                if (!arrayList2.isEmpty()) {
                    for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                        this.xrefObj.add(arrayList2.get(i3));
                        ((PRIndirectReference) arrayList.get(i3)).setNumber(this.xrefObj.size() - 1, 0);
                    }
                }
            }
        }
    }

    public boolean isTampered() {
        return this.tampered;
    }

    public void setTampered(boolean z) {
        this.tampered = z;
        this.pageRefs.keepPages();
    }

    public byte[] getMetadata() throws IOException {
        PdfObject pdfObject = getPdfObject(this.catalog.get(PdfName.METADATA));
        if (!(pdfObject instanceof PRStream)) {
            return null;
        }
        RandomAccessFileOrArray safeFile = getSafeFile();
        try {
            safeFile.reOpen();
            return getStreamBytes((PRStream) pdfObject, safeFile);
        } finally {
            try {
                safeFile.close();
            } catch (Exception unused) {
            }
        }
    }

    public int getLastXref() {
        return this.lastXref;
    }

    public int getXrefSize() {
        return this.xrefObj.size();
    }

    public int getEofPos() {
        return this.eofPos;
    }

    public char getPdfVersion() {
        return this.pdfVersion;
    }

    public boolean isEncrypted() {
        return this.encrypted;
    }

    public int getPermissions() {
        return this.pValue;
    }

    public boolean is128Key() {
        return this.rValue == 3;
    }

    public PdfDictionary getTrailer() {
        return this.trailer;
    }

    /* access modifiers changed from: package-private */
    public PdfEncryption getDecrypt() {
        return this.decrypt;
    }

    static boolean equalsn(byte[] bArr, byte[] bArr2) {
        int length = bArr2.length;
        for (int i = 0; i < length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    static boolean existsName(PdfDictionary pdfDictionary, PdfName pdfName, PdfName pdfName2) {
        PdfObject pdfObjectRelease = getPdfObjectRelease(pdfDictionary.get(pdfName));
        if (pdfObjectRelease == null || !pdfObjectRelease.isName()) {
            return false;
        }
        return ((PdfName) pdfObjectRelease).equals(pdfName2);
    }

    static String getFontName(PdfDictionary pdfDictionary) {
        PdfObject pdfObjectRelease;
        if (pdfDictionary == null || (pdfObjectRelease = getPdfObjectRelease(pdfDictionary.get(PdfName.BASEFONT))) == null || !pdfObjectRelease.isName()) {
            return null;
        }
        return PdfName.decodeName(pdfObjectRelease.toString());
    }

    static String getSubsetPrefix(PdfDictionary pdfDictionary) {
        String fontName;
        if (pdfDictionary != null && (fontName = getFontName(pdfDictionary)) != null && fontName.length() >= 8 && fontName.charAt(6) == '+') {
            int i = 0;
            while (i < 6) {
                char charAt = fontName.charAt(i);
                if (charAt >= 'A' && charAt <= 'Z') {
                    i++;
                }
            }
            return fontName;
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0069, code lost:
        r6 = r6.getAsDict(0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int shuffleSubsetNames() {
        /*
            r13 = this;
            r0 = 0
            r1 = 1
            r2 = 0
        L_0x0003:
            java.util.ArrayList r3 = r13.xrefObj
            int r3 = r3.size()
            if (r1 < r3) goto L_0x000c
            return r2
        L_0x000c:
            com.lowagie.text.pdf.PdfObject r3 = r13.getPdfObjectRelease((int) r1)
            if (r3 == 0) goto L_0x0107
            boolean r4 = r3.isDictionary()
            if (r4 != 0) goto L_0x001a
            goto L_0x0107
        L_0x001a:
            com.lowagie.text.pdf.PdfDictionary r3 = (com.lowagie.text.pdf.PdfDictionary) r3
            com.lowagie.text.pdf.PdfName r4 = com.lowagie.text.pdf.PdfName.TYPE
            com.lowagie.text.pdf.PdfName r5 = com.lowagie.text.pdf.PdfName.FONT
            boolean r4 = existsName(r3, r4, r5)
            if (r4 != 0) goto L_0x0028
            goto L_0x0107
        L_0x0028:
            com.lowagie.text.pdf.PdfName r4 = com.lowagie.text.pdf.PdfName.SUBTYPE
            com.lowagie.text.pdf.PdfName r5 = com.lowagie.text.pdf.PdfName.TYPE1
            boolean r4 = existsName(r3, r4, r5)
            r5 = 7
            if (r4 != 0) goto L_0x00cb
            com.lowagie.text.pdf.PdfName r4 = com.lowagie.text.pdf.PdfName.SUBTYPE
            com.lowagie.text.pdf.PdfName r6 = com.lowagie.text.pdf.PdfName.MMTYPE1
            boolean r4 = existsName(r3, r4, r6)
            if (r4 != 0) goto L_0x00cb
            com.lowagie.text.pdf.PdfName r4 = com.lowagie.text.pdf.PdfName.SUBTYPE
            com.lowagie.text.pdf.PdfName r6 = com.lowagie.text.pdf.PdfName.TRUETYPE
            boolean r4 = existsName(r3, r4, r6)
            if (r4 == 0) goto L_0x0049
            goto L_0x00cb
        L_0x0049:
            com.lowagie.text.pdf.PdfName r4 = com.lowagie.text.pdf.PdfName.SUBTYPE
            com.lowagie.text.pdf.PdfName r6 = com.lowagie.text.pdf.PdfName.TYPE0
            boolean r4 = existsName(r3, r4, r6)
            if (r4 == 0) goto L_0x0107
            java.lang.String r4 = getSubsetPrefix(r3)
            com.lowagie.text.pdf.PdfName r6 = com.lowagie.text.pdf.PdfName.DESCENDANTFONTS
            com.lowagie.text.pdf.PdfArray r6 = r3.getAsArray(r6)
            if (r6 != 0) goto L_0x0061
            goto L_0x0107
        L_0x0061:
            boolean r7 = r6.isEmpty()
            if (r7 == 0) goto L_0x0069
            goto L_0x0107
        L_0x0069:
            com.lowagie.text.pdf.PdfDictionary r6 = r6.getAsDict(r0)
            java.lang.String r7 = getSubsetPrefix(r6)
            if (r7 != 0) goto L_0x0075
            goto L_0x0107
        L_0x0075:
            java.lang.String r8 = com.lowagie.text.pdf.BaseFont.createSubsetPrefix()
            if (r4 == 0) goto L_0x0099
            com.lowagie.text.pdf.PdfName r9 = com.lowagie.text.pdf.PdfName.BASEFONT
            com.lowagie.text.pdf.PdfName r10 = new com.lowagie.text.pdf.PdfName
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r12 = java.lang.String.valueOf(r8)
            r11.<init>(r12)
            java.lang.String r4 = r4.substring(r5)
            r11.append(r4)
            java.lang.String r4 = r11.toString()
            r10.<init>((java.lang.String) r4)
            r3.put(r9, r10)
        L_0x0099:
            r13.setXrefPartialObject(r1, r3)
            com.lowagie.text.pdf.PdfName r3 = new com.lowagie.text.pdf.PdfName
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r8 = java.lang.String.valueOf(r8)
            r4.<init>(r8)
            java.lang.String r5 = r7.substring(r5)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r3.<init>((java.lang.String) r4)
            com.lowagie.text.pdf.PdfName r4 = com.lowagie.text.pdf.PdfName.BASEFONT
            r6.put(r4, r3)
            int r2 = r2 + 1
            com.lowagie.text.pdf.PdfName r4 = com.lowagie.text.pdf.PdfName.FONTDESCRIPTOR
            com.lowagie.text.pdf.PdfDictionary r4 = r6.getAsDict(r4)
            if (r4 != 0) goto L_0x00c5
            goto L_0x0107
        L_0x00c5:
            com.lowagie.text.pdf.PdfName r5 = com.lowagie.text.pdf.PdfName.FONTNAME
            r4.put(r5, r3)
            goto L_0x0107
        L_0x00cb:
            java.lang.String r4 = getSubsetPrefix(r3)
            if (r4 != 0) goto L_0x00d2
            goto L_0x0107
        L_0x00d2:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = com.lowagie.text.pdf.BaseFont.createSubsetPrefix()
            java.lang.String r7 = java.lang.String.valueOf(r7)
            r6.<init>(r7)
            java.lang.String r4 = r4.substring(r5)
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            com.lowagie.text.pdf.PdfName r5 = new com.lowagie.text.pdf.PdfName
            r5.<init>((java.lang.String) r4)
            com.lowagie.text.pdf.PdfName r4 = com.lowagie.text.pdf.PdfName.BASEFONT
            r3.put(r4, r5)
            r13.setXrefPartialObject(r1, r3)
            int r2 = r2 + 1
            com.lowagie.text.pdf.PdfName r4 = com.lowagie.text.pdf.PdfName.FONTDESCRIPTOR
            com.lowagie.text.pdf.PdfDictionary r3 = r3.getAsDict(r4)
            if (r3 != 0) goto L_0x0102
            goto L_0x0107
        L_0x0102:
            com.lowagie.text.pdf.PdfName r4 = com.lowagie.text.pdf.PdfName.FONTNAME
            r3.put(r4, r5)
        L_0x0107:
            int r1 = r1 + 1
            goto L_0x0003
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.PdfReader.shuffleSubsetNames():int");
    }

    public int createFakeFontSubsets() {
        String fontName;
        int i = 0;
        for (int i2 = 1; i2 < this.xrefObj.size(); i2++) {
            PdfObject pdfObjectRelease = getPdfObjectRelease(i2);
            if (pdfObjectRelease != null && pdfObjectRelease.isDictionary()) {
                PdfDictionary pdfDictionary = (PdfDictionary) pdfObjectRelease;
                if (existsName(pdfDictionary, PdfName.TYPE, PdfName.FONT) && ((existsName(pdfDictionary, PdfName.SUBTYPE, PdfName.TYPE1) || existsName(pdfDictionary, PdfName.SUBTYPE, PdfName.MMTYPE1) || existsName(pdfDictionary, PdfName.SUBTYPE, PdfName.TRUETYPE)) && getSubsetPrefix(pdfDictionary) == null && (fontName = getFontName(pdfDictionary)) != null)) {
                    String str = String.valueOf(BaseFont.createSubsetPrefix()) + fontName;
                    PdfDictionary pdfDictionary2 = (PdfDictionary) getPdfObjectRelease(pdfDictionary.get(PdfName.FONTDESCRIPTOR));
                    if (!(pdfDictionary2 == null || (pdfDictionary2.get(PdfName.FONTFILE) == null && pdfDictionary2.get(PdfName.FONTFILE2) == null && pdfDictionary2.get(PdfName.FONTFILE3) == null))) {
                        PdfDictionary asDict = pdfDictionary.getAsDict(PdfName.FONTDESCRIPTOR);
                        PdfName pdfName = new PdfName(str);
                        pdfDictionary.put(PdfName.BASEFONT, pdfName);
                        asDict.put(PdfName.FONTNAME, pdfName);
                        setXrefPartialObject(i2, pdfDictionary);
                        i++;
                    }
                }
            }
        }
        return i;
    }

    private static PdfArray getNameArray(PdfObject pdfObject) {
        PdfObject pdfObjectRelease;
        PdfObject pdfObjectRelease2;
        if (pdfObject == null || (pdfObjectRelease = getPdfObjectRelease(pdfObject)) == null) {
            return null;
        }
        if (pdfObjectRelease.isArray()) {
            return (PdfArray) pdfObjectRelease;
        }
        if (!pdfObjectRelease.isDictionary() || (pdfObjectRelease2 = getPdfObjectRelease(((PdfDictionary) pdfObjectRelease).get(PdfName.f661D))) == null || !pdfObjectRelease2.isArray()) {
            return null;
        }
        return (PdfArray) pdfObjectRelease2;
    }

    public HashMap getNamedDestination() {
        return getNamedDestination(false);
    }

    public HashMap getNamedDestination(boolean z) {
        HashMap namedDestinationFromNames = getNamedDestinationFromNames(z);
        namedDestinationFromNames.putAll(getNamedDestinationFromStrings());
        return namedDestinationFromNames;
    }

    public HashMap getNamedDestinationFromNames() {
        return getNamedDestinationFromNames(false);
    }

    public HashMap getNamedDestinationFromNames(boolean z) {
        PdfDictionary pdfDictionary;
        HashMap hashMap = new HashMap();
        if (this.catalog.get(PdfName.DESTS) == null || (pdfDictionary = (PdfDictionary) getPdfObjectRelease(this.catalog.get(PdfName.DESTS))) == null) {
            return hashMap;
        }
        for (PdfName pdfName : pdfDictionary.getKeys()) {
            PdfArray nameArray = getNameArray(pdfDictionary.get(pdfName));
            if (nameArray != null) {
                if (z) {
                    hashMap.put(pdfName, nameArray);
                } else {
                    hashMap.put(PdfName.decodeName(pdfName.toString()), nameArray);
                }
            }
        }
        return hashMap;
    }

    public HashMap getNamedDestinationFromStrings() {
        PdfDictionary pdfDictionary;
        PdfDictionary pdfDictionary2;
        if (this.catalog.get(PdfName.NAMES) == null || (pdfDictionary = (PdfDictionary) getPdfObjectRelease(this.catalog.get(PdfName.NAMES))) == null || (pdfDictionary2 = (PdfDictionary) getPdfObjectRelease(pdfDictionary.get(PdfName.DESTS))) == null) {
            return new HashMap();
        }
        HashMap readTree = PdfNameTree.readTree(pdfDictionary2);
        Iterator it = readTree.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            PdfArray nameArray = getNameArray((PdfObject) entry.getValue());
            if (nameArray != null) {
                entry.setValue(nameArray);
            } else {
                it.remove();
            }
        }
        return readTree;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: com.lowagie.text.pdf.PdfObject} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean replaceNamedDestination(com.lowagie.text.pdf.PdfObject r9, java.util.HashMap r10) {
        /*
            r8 = this;
            com.lowagie.text.pdf.PdfObject r9 = getPdfObject((com.lowagie.text.pdf.PdfObject) r9)
            int r0 = r8.lastXrefPartial
            r8.releaseLastXrefPartial()
            if (r9 == 0) goto L_0x00a0
            boolean r1 = r9.isDictionary()
            if (r1 == 0) goto L_0x00a0
            r1 = r9
            com.lowagie.text.pdf.PdfDictionary r1 = (com.lowagie.text.pdf.PdfDictionary) r1
            com.lowagie.text.pdf.PdfName r2 = com.lowagie.text.pdf.PdfName.DEST
            com.lowagie.text.pdf.PdfObject r2 = r1.get(r2)
            com.lowagie.text.pdf.PdfObject r2 = getPdfObjectRelease((com.lowagie.text.pdf.PdfObject) r2)
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0046
            boolean r5 = r2.isName()
            if (r5 == 0) goto L_0x0029
            goto L_0x0035
        L_0x0029:
            boolean r5 = r2.isString()
            if (r5 == 0) goto L_0x0034
            java.lang.String r2 = r2.toString()
            goto L_0x0035
        L_0x0034:
            r2 = r3
        L_0x0035:
            java.lang.Object r10 = r10.get(r2)
            com.lowagie.text.pdf.PdfArray r10 = (com.lowagie.text.pdf.PdfArray) r10
            if (r10 == 0) goto L_0x00a0
            com.lowagie.text.pdf.PdfName r2 = com.lowagie.text.pdf.PdfName.DEST
            r1.put(r2, r10)
            r8.setXrefPartialObject(r0, r9)
            return r4
        L_0x0046:
            com.lowagie.text.pdf.PdfName r2 = com.lowagie.text.pdf.PdfName.f641A
            com.lowagie.text.pdf.PdfObject r1 = r1.get(r2)
            com.lowagie.text.pdf.PdfObject r1 = getPdfObject((com.lowagie.text.pdf.PdfObject) r1)
            if (r1 == 0) goto L_0x00a0
            int r2 = r8.lastXrefPartial
            r8.releaseLastXrefPartial()
            r5 = r1
            com.lowagie.text.pdf.PdfDictionary r5 = (com.lowagie.text.pdf.PdfDictionary) r5
            com.lowagie.text.pdf.PdfName r6 = com.lowagie.text.pdf.PdfName.f719S
            com.lowagie.text.pdf.PdfObject r6 = r5.get(r6)
            com.lowagie.text.pdf.PdfObject r6 = getPdfObjectRelease((com.lowagie.text.pdf.PdfObject) r6)
            com.lowagie.text.pdf.PdfName r6 = (com.lowagie.text.pdf.PdfName) r6
            com.lowagie.text.pdf.PdfName r7 = com.lowagie.text.pdf.PdfName.GOTO
            boolean r6 = r7.equals(r6)
            if (r6 == 0) goto L_0x00a0
            com.lowagie.text.pdf.PdfName r6 = com.lowagie.text.pdf.PdfName.f661D
            com.lowagie.text.pdf.PdfObject r6 = r5.get(r6)
            com.lowagie.text.pdf.PdfObject r6 = getPdfObjectRelease((com.lowagie.text.pdf.PdfObject) r6)
            if (r6 == 0) goto L_0x008c
            boolean r7 = r6.isName()
            if (r7 == 0) goto L_0x0082
            r3 = r6
            goto L_0x008c
        L_0x0082:
            boolean r7 = r6.isString()
            if (r7 == 0) goto L_0x008c
            java.lang.String r3 = r6.toString()
        L_0x008c:
            java.lang.Object r10 = r10.get(r3)
            com.lowagie.text.pdf.PdfArray r10 = (com.lowagie.text.pdf.PdfArray) r10
            if (r10 == 0) goto L_0x00a0
            com.lowagie.text.pdf.PdfName r3 = com.lowagie.text.pdf.PdfName.f661D
            r5.put(r3, r10)
            r8.setXrefPartialObject(r2, r1)
            r8.setXrefPartialObject(r0, r9)
            return r4
        L_0x00a0:
            r9 = 0
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.PdfReader.replaceNamedDestination(com.lowagie.text.pdf.PdfObject, java.util.HashMap):boolean");
    }

    public void removeFields() {
        this.pageRefs.resetReleasePage();
        for (int i = 1; i <= this.pageRefs.size(); i++) {
            PdfDictionary pageN = this.pageRefs.getPageN(i);
            PdfArray asArray = pageN.getAsArray(PdfName.ANNOTS);
            if (asArray == null) {
                this.pageRefs.releasePage(i);
            } else {
                int i2 = 0;
                while (i2 < asArray.size()) {
                    PdfObject pdfObjectRelease = getPdfObjectRelease(asArray.getPdfObject(i2));
                    if (pdfObjectRelease != null && pdfObjectRelease.isDictionary() && PdfName.WIDGET.equals(((PdfDictionary) pdfObjectRelease).get(PdfName.SUBTYPE))) {
                        asArray.remove(i2);
                        i2--;
                    }
                    i2++;
                }
                if (asArray.isEmpty()) {
                    pageN.remove(PdfName.ANNOTS);
                } else {
                    this.pageRefs.releasePage(i);
                }
            }
        }
        this.catalog.remove(PdfName.ACROFORM);
        this.pageRefs.resetReleasePage();
    }

    public void removeAnnotations() {
        this.pageRefs.resetReleasePage();
        for (int i = 1; i <= this.pageRefs.size(); i++) {
            PdfDictionary pageN = this.pageRefs.getPageN(i);
            if (pageN.get(PdfName.ANNOTS) == null) {
                this.pageRefs.releasePage(i);
            } else {
                pageN.remove(PdfName.ANNOTS);
            }
        }
        this.catalog.remove(PdfName.ACROFORM);
        this.pageRefs.resetReleasePage();
    }

    public ArrayList getLinks(int i) {
        this.pageRefs.resetReleasePage();
        ArrayList arrayList = new ArrayList();
        PdfDictionary pageN = this.pageRefs.getPageN(i);
        if (pageN.get(PdfName.ANNOTS) != null) {
            PdfArray asArray = pageN.getAsArray(PdfName.ANNOTS);
            for (int i2 = 0; i2 < asArray.size(); i2++) {
                PdfDictionary pdfDictionary = (PdfDictionary) getPdfObjectRelease(asArray.getPdfObject(i2));
                if (PdfName.LINK.equals(pdfDictionary.get(PdfName.SUBTYPE))) {
                    arrayList.add(new PdfAnnotation.PdfImportedLink(pdfDictionary));
                }
            }
        }
        this.pageRefs.releasePage(i);
        this.pageRefs.resetReleasePage();
        return arrayList;
    }

    private void iterateBookmarks(PdfObject pdfObject, HashMap hashMap) {
        while (pdfObject != null) {
            replaceNamedDestination(pdfObject, hashMap);
            PdfDictionary pdfDictionary = (PdfDictionary) getPdfObjectRelease(pdfObject);
            PdfObject pdfObject2 = pdfDictionary.get(PdfName.FIRST);
            if (pdfObject2 != null) {
                iterateBookmarks(pdfObject2, hashMap);
            }
            pdfObject = pdfDictionary.get(PdfName.NEXT);
        }
    }

    public void consolidateNamedDestinations() {
        if (!this.consolidateNamedDestinations) {
            this.consolidateNamedDestinations = true;
            HashMap namedDestination = getNamedDestination(true);
            if (!namedDestination.isEmpty()) {
                for (int i = 1; i <= this.pageRefs.size(); i++) {
                    PdfObject pdfObject = this.pageRefs.getPageN(i).get(PdfName.ANNOTS);
                    PdfArray pdfArray = (PdfArray) getPdfObject(pdfObject);
                    int i2 = this.lastXrefPartial;
                    releaseLastXrefPartial();
                    if (pdfArray == null) {
                        this.pageRefs.releasePage(i);
                    } else {
                        boolean z = false;
                        for (int i3 = 0; i3 < pdfArray.size(); i3++) {
                            PdfObject pdfObject2 = pdfArray.getPdfObject(i3);
                            if (replaceNamedDestination(pdfObject2, namedDestination) && !pdfObject2.isIndirect()) {
                                z = true;
                            }
                        }
                        if (z) {
                            setXrefPartialObject(i2, pdfArray);
                        }
                        if (!z || pdfObject.isIndirect()) {
                            this.pageRefs.releasePage(i);
                        }
                    }
                }
                PdfDictionary pdfDictionary = (PdfDictionary) getPdfObjectRelease(this.catalog.get(PdfName.OUTLINES));
                if (pdfDictionary != null) {
                    iterateBookmarks(pdfDictionary.get(PdfName.FIRST), namedDestination);
                }
            }
        }
    }

    protected static PdfDictionary duplicatePdfDictionary(PdfDictionary pdfDictionary, PdfDictionary pdfDictionary2, PdfReader pdfReader) {
        if (pdfDictionary2 == null) {
            pdfDictionary2 = new PdfDictionary();
        }
        for (PdfName pdfName : pdfDictionary.getKeys()) {
            pdfDictionary2.put(pdfName, duplicatePdfObject(pdfDictionary.get(pdfName), pdfReader));
        }
        return pdfDictionary2;
    }

    protected static PdfObject duplicatePdfObject(PdfObject pdfObject, PdfReader pdfReader) {
        if (pdfObject == null) {
            return null;
        }
        int type = pdfObject.type();
        if (type == 5) {
            PdfArray pdfArray = new PdfArray();
            ListIterator listIterator = ((PdfArray) pdfObject).listIterator();
            while (listIterator.hasNext()) {
                pdfArray.add(duplicatePdfObject((PdfObject) listIterator.next(), pdfReader));
            }
            return pdfArray;
        } else if (type == 6) {
            return duplicatePdfDictionary((PdfDictionary) pdfObject, (PdfDictionary) null, pdfReader);
        } else {
            if (type == 7) {
                PRStream pRStream = (PRStream) pdfObject;
                PRStream pRStream2 = new PRStream(pRStream, (PdfDictionary) null, pdfReader);
                duplicatePdfDictionary(pRStream, pRStream2, pdfReader);
                return pRStream2;
            } else if (type != 10) {
                return pdfObject;
            } else {
                PRIndirectReference pRIndirectReference = (PRIndirectReference) pdfObject;
                return new PRIndirectReference(pdfReader, pRIndirectReference.getNumber(), pRIndirectReference.getGeneration());
            }
        }
    }

    public void close() {
        if (this.partial) {
            try {
                this.tokens.close();
            } catch (IOException e) {
                throw new ExceptionConverter(e);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: java.lang.Object[]} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0138  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void removeUnusedNode(com.lowagie.text.pdf.PdfObject r13, boolean[] r14) {
        /*
            r12 = this;
            java.util.Stack r0 = new java.util.Stack
            r0.<init>()
            r0.push(r13)
        L_0x0008:
            boolean r13 = r0.empty()
            if (r13 == 0) goto L_0x000f
            return
        L_0x000f:
            java.lang.Object r13 = r0.pop()
            if (r13 != 0) goto L_0x0016
            goto L_0x0008
        L_0x0016:
            boolean r1 = r13 instanceof com.lowagie.text.pdf.PdfObject
            r2 = 2
            r3 = 0
            r4 = 0
            r5 = 1
            if (r1 == 0) goto L_0x0064
            com.lowagie.text.pdf.PdfObject r13 = (com.lowagie.text.pdf.PdfObject) r13
            int r1 = r13.type()
            r6 = 5
            if (r1 == r6) goto L_0x0058
            r6 = 6
            if (r1 == r6) goto L_0x0046
            r6 = 7
            if (r1 == r6) goto L_0x0046
            r2 = 10
            if (r1 == r2) goto L_0x0032
            goto L_0x0008
        L_0x0032:
            com.lowagie.text.pdf.PRIndirectReference r13 = (com.lowagie.text.pdf.PRIndirectReference) r13
            int r1 = r13.getNumber()
            boolean r2 = r14[r1]
            if (r2 != 0) goto L_0x0008
            r14[r1] = r5
            com.lowagie.text.pdf.PdfObject r13 = getPdfObjectRelease((com.lowagie.text.pdf.PdfObject) r13)
            r0.push(r13)
            goto L_0x0008
        L_0x0046:
            com.lowagie.text.pdf.PdfDictionary r13 = (com.lowagie.text.pdf.PdfDictionary) r13
            int r1 = r13.size()
            com.lowagie.text.pdf.PdfName[] r1 = new com.lowagie.text.pdf.PdfName[r1]
            java.util.Set r6 = r13.getKeys()
            r6.toArray(r1)
            r7 = r3
            r6 = 0
            goto L_0x0091
        L_0x0058:
            com.lowagie.text.pdf.PdfArray r13 = (com.lowagie.text.pdf.PdfArray) r13
            java.util.ArrayList r13 = r13.getArrayList()
            r1 = r3
            r7 = r1
            r6 = 0
            r3 = r13
            r13 = r7
            goto L_0x0091
        L_0x0064:
            java.lang.Object[] r13 = (java.lang.Object[]) r13
            r1 = r13[r4]
            boolean r1 = r1 instanceof java.util.ArrayList
            if (r1 == 0) goto L_0x007d
            r1 = r13[r4]
            java.util.ArrayList r1 = (java.util.ArrayList) r1
            r6 = r13[r5]
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            r7 = r13
            r13 = r3
            r3 = r1
            r1 = r13
            goto L_0x0091
        L_0x007d:
            r1 = r13[r4]
            com.lowagie.text.pdf.PdfName[] r1 = (com.lowagie.text.pdf.PdfName[]) r1
            r6 = r13[r5]
            com.lowagie.text.pdf.PdfDictionary r6 = (com.lowagie.text.pdf.PdfDictionary) r6
            r7 = r13[r2]
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            r11 = r7
            r7 = r13
            r13 = r6
            r6 = r11
        L_0x0091:
            if (r3 == 0) goto L_0x00ee
        L_0x0093:
            int r13 = r3.size()
            if (r6 < r13) goto L_0x009b
            goto L_0x0008
        L_0x009b:
            java.lang.Object r13 = r3.get(r6)
            com.lowagie.text.pdf.PdfObject r13 = (com.lowagie.text.pdf.PdfObject) r13
            boolean r1 = r13.isIndirect()
            if (r1 == 0) goto L_0x00ca
            r1 = r13
            com.lowagie.text.pdf.PRIndirectReference r1 = (com.lowagie.text.pdf.PRIndirectReference) r1
            int r1 = r1.getNumber()
            java.util.ArrayList r8 = r12.xrefObj
            int r8 = r8.size()
            if (r1 >= r8) goto L_0x00c2
            boolean r8 = r12.partial
            if (r8 != 0) goto L_0x00ca
            java.util.ArrayList r8 = r12.xrefObj
            java.lang.Object r1 = r8.get(r1)
            if (r1 != 0) goto L_0x00ca
        L_0x00c2:
            com.lowagie.text.pdf.PdfNull r13 = com.lowagie.text.pdf.PdfNull.PDFNULL
            r3.set(r6, r13)
            int r6 = r6 + 1
            goto L_0x0093
        L_0x00ca:
            if (r7 != 0) goto L_0x00dd
            java.lang.Object[] r1 = new java.lang.Object[r2]
            r1[r4] = r3
            java.lang.Integer r2 = new java.lang.Integer
            int r6 = r6 + 1
            r2.<init>(r6)
            r1[r5] = r2
            r0.push(r1)
            goto L_0x00e9
        L_0x00dd:
            java.lang.Integer r1 = new java.lang.Integer
            int r6 = r6 + 1
            r1.<init>(r6)
            r7[r5] = r1
            r0.push(r7)
        L_0x00e9:
            r0.push(r13)
            goto L_0x0008
        L_0x00ee:
            int r3 = r1.length
            if (r6 < r3) goto L_0x00f3
            goto L_0x0008
        L_0x00f3:
            r3 = r1[r6]
            com.lowagie.text.pdf.PdfObject r8 = r13.get(r3)
            boolean r9 = r8.isIndirect()
            if (r9 == 0) goto L_0x0122
            r9 = r8
            com.lowagie.text.pdf.PRIndirectReference r9 = (com.lowagie.text.pdf.PRIndirectReference) r9
            int r9 = r9.getNumber()
            java.util.ArrayList r10 = r12.xrefObj
            int r10 = r10.size()
            if (r9 >= r10) goto L_0x011a
            boolean r10 = r12.partial
            if (r10 != 0) goto L_0x0122
            java.util.ArrayList r10 = r12.xrefObj
            java.lang.Object r9 = r10.get(r9)
            if (r9 != 0) goto L_0x0122
        L_0x011a:
            com.lowagie.text.pdf.PdfNull r8 = com.lowagie.text.pdf.PdfNull.PDFNULL
            r13.put(r3, r8)
            int r6 = r6 + 1
            goto L_0x00ee
        L_0x0122:
            if (r7 != 0) goto L_0x0138
            r3 = 3
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r3[r4] = r1
            r3[r5] = r13
            java.lang.Integer r13 = new java.lang.Integer
            int r6 = r6 + 1
            r13.<init>(r6)
            r3[r2] = r13
            r0.push(r3)
            goto L_0x0144
        L_0x0138:
            java.lang.Integer r13 = new java.lang.Integer
            int r6 = r6 + 1
            r13.<init>(r6)
            r7[r2] = r13
            r0.push(r7)
        L_0x0144:
            r0.push(r8)
            goto L_0x0008
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.PdfReader.removeUnusedNode(com.lowagie.text.pdf.PdfObject, boolean[]):void");
    }

    public int removeUnusedObjects() {
        int i;
        boolean[] zArr = new boolean[this.xrefObj.size()];
        removeUnusedNode(this.trailer, zArr);
        if (this.partial) {
            i = 0;
            for (int i2 = 1; i2 < zArr.length; i2++) {
                if (!zArr[i2]) {
                    int[] iArr = this.xref;
                    int i3 = i2 * 2;
                    iArr[i3] = -1;
                    iArr[i3 + 1] = 0;
                    this.xrefObj.set(i2, (Object) null);
                    i++;
                }
            }
        } else {
            i = 0;
            for (int i4 = 1; i4 < zArr.length; i4++) {
                if (!zArr[i4]) {
                    this.xrefObj.set(i4, (Object) null);
                    i++;
                }
            }
        }
        return i;
    }

    public AcroFields getAcroFields() {
        return new AcroFields(this, (PdfWriter) null);
    }

    public String getJavaScript(RandomAccessFileOrArray randomAccessFileOrArray) throws IOException {
        PdfDictionary pdfDictionary;
        PdfObject pdfObjectRelease;
        PdfDictionary pdfDictionary2 = (PdfDictionary) getPdfObjectRelease(this.catalog.get(PdfName.NAMES));
        if (pdfDictionary2 == null || (pdfDictionary = (PdfDictionary) getPdfObjectRelease(pdfDictionary2.get(PdfName.JAVASCRIPT))) == null) {
            return null;
        }
        HashMap readTree = PdfNameTree.readTree(pdfDictionary);
        String[] strArr = (String[]) readTree.keySet().toArray(new String[readTree.size()]);
        Arrays.sort(strArr);
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : strArr) {
            PdfDictionary pdfDictionary3 = (PdfDictionary) getPdfObjectRelease((PdfObject) (PdfIndirectReference) readTree.get(str));
            if (!(pdfDictionary3 == null || (pdfObjectRelease = getPdfObjectRelease(pdfDictionary3.get(PdfName.f690JS))) == null)) {
                if (pdfObjectRelease.isString()) {
                    stringBuffer.append(((PdfString) pdfObjectRelease).toUnicodeString());
                    stringBuffer.append(10);
                } else if (pdfObjectRelease.isStream()) {
                    byte[] streamBytes = getStreamBytes((PRStream) pdfObjectRelease, randomAccessFileOrArray);
                    if (streamBytes.length >= 2 && streamBytes[0] == -2 && streamBytes[1] == -1) {
                        stringBuffer.append(PdfEncodings.convertToString(streamBytes, PdfObject.TEXT_UNICODE));
                    } else {
                        stringBuffer.append(PdfEncodings.convertToString(streamBytes, PdfObject.TEXT_PDFDOCENCODING));
                    }
                    stringBuffer.append(10);
                }
            }
        }
        return stringBuffer.toString();
    }

    public String getJavaScript() throws IOException {
        RandomAccessFileOrArray safeFile = getSafeFile();
        try {
            safeFile.reOpen();
            return getJavaScript(safeFile);
        } finally {
            try {
                safeFile.close();
            } catch (Exception unused) {
            }
        }
    }

    public void selectPages(String str) {
        selectPages(SequenceList.expand(str, getNumberOfPages()));
    }

    public void selectPages(List list) {
        this.pageRefs.selectPages(list);
        removeUnusedObjects();
    }

    public void setViewerPreferences(int i) {
        this.viewerPreferences.setViewerPreferences(i);
        setViewerPreferences(this.viewerPreferences);
    }

    public void addViewerPreference(PdfName pdfName, PdfObject pdfObject) {
        this.viewerPreferences.addViewerPreference(pdfName, pdfObject);
        setViewerPreferences(this.viewerPreferences);
    }

    /* access modifiers changed from: package-private */
    public void setViewerPreferences(PdfViewerPreferencesImp pdfViewerPreferencesImp) {
        pdfViewerPreferencesImp.addToCatalog(this.catalog);
    }

    public int getSimpleViewerPreferences() {
        return PdfViewerPreferencesImp.getViewerPreferences(this.catalog).getPageLayoutAndMode();
    }

    public boolean isAppendable() {
        return this.appendable;
    }

    public void setAppendable(boolean z) {
        this.appendable = z;
        if (z) {
            getPdfObject(this.trailer.get(PdfName.ROOT));
        }
    }

    public boolean isNewXrefType() {
        return this.newXrefType;
    }

    public int getFileLength() {
        return this.fileLength;
    }

    public boolean isHybridXref() {
        return this.hybridXref;
    }

    static class PageRefs {
        private boolean keepPages;
        private int lastPageRead;
        private ArrayList pageInh;
        private PdfReader reader;
        private ArrayList refsn;
        private IntHashtable refsp;
        private int sizep;

        private PageRefs(PdfReader pdfReader) throws IOException {
            this.lastPageRead = -1;
            this.reader = pdfReader;
            if (pdfReader.partial) {
                this.refsp = new IntHashtable();
                this.sizep = ((PdfNumber) PdfReader.getPdfObjectRelease(pdfReader.rootPages.get(PdfName.COUNT))).intValue();
                return;
            }
            readPages();
        }

        /* synthetic */ PageRefs(PdfReader pdfReader, PageRefs pageRefs) throws IOException {
            this(pdfReader);
        }

        PageRefs(PageRefs pageRefs, PdfReader pdfReader) {
            this.lastPageRead = -1;
            this.reader = pdfReader;
            this.sizep = pageRefs.sizep;
            ArrayList arrayList = pageRefs.refsn;
            if (arrayList != null) {
                this.refsn = new ArrayList(arrayList);
                for (int i = 0; i < this.refsn.size(); i++) {
                    ArrayList arrayList2 = this.refsn;
                    arrayList2.set(i, PdfReader.duplicatePdfObject((PdfObject) arrayList2.get(i), pdfReader));
                }
                return;
            }
            this.refsp = (IntHashtable) pageRefs.refsp.clone();
        }

        /* access modifiers changed from: package-private */
        public int size() {
            ArrayList arrayList = this.refsn;
            if (arrayList != null) {
                return arrayList.size();
            }
            return this.sizep;
        }

        /* access modifiers changed from: package-private */
        public void readPages() throws IOException {
            if (this.refsn == null) {
                this.refsp = null;
                this.refsn = new ArrayList();
                this.pageInh = new ArrayList();
                iteratePages((PRIndirectReference) this.reader.catalog.get(PdfName.PAGES));
                this.pageInh = null;
                this.reader.rootPages.put(PdfName.COUNT, new PdfNumber(this.refsn.size()));
            }
        }

        /* access modifiers changed from: package-private */
        public void reReadPages() throws IOException {
            this.refsn = null;
            readPages();
        }

        public PdfDictionary getPageN(int i) {
            return (PdfDictionary) PdfReader.getPdfObject((PdfObject) getPageOrigRef(i));
        }

        public PdfDictionary getPageNRelease(int i) {
            PdfDictionary pageN = getPageN(i);
            releasePage(i);
            return pageN;
        }

        public PRIndirectReference getPageOrigRefRelease(int i) {
            PRIndirectReference pageOrigRef = getPageOrigRef(i);
            releasePage(i);
            return pageOrigRef;
        }

        public PRIndirectReference getPageOrigRef(int i) {
            int i2 = i - 1;
            if (i2 < 0) {
                return null;
            }
            try {
                if (i2 >= size()) {
                    return null;
                }
                if (this.refsn != null) {
                    return (PRIndirectReference) this.refsn.get(i2);
                }
                int i3 = this.refsp.get(i2);
                if (i3 == 0) {
                    PRIndirectReference singlePage = getSinglePage(i2);
                    if (this.reader.lastXrefPartial == -1) {
                        this.lastPageRead = -1;
                    } else {
                        this.lastPageRead = i2;
                    }
                    this.reader.lastXrefPartial = -1;
                    this.refsp.put(i2, singlePage.getNumber());
                    if (this.keepPages) {
                        this.lastPageRead = -1;
                    }
                    return singlePage;
                }
                if (this.lastPageRead != i2) {
                    this.lastPageRead = -1;
                }
                if (this.keepPages) {
                    this.lastPageRead = -1;
                }
                return new PRIndirectReference(this.reader, i3);
            } catch (Exception e) {
                throw new ExceptionConverter(e);
            }
        }

        /* access modifiers changed from: package-private */
        public void keepPages() {
            IntHashtable intHashtable = this.refsp;
            if (intHashtable != null && !this.keepPages) {
                this.keepPages = true;
                intHashtable.clear();
            }
        }

        public void releasePage(int i) {
            int i2;
            if (this.refsp != null && i - 1 >= 0 && i2 < size() && i2 == this.lastPageRead) {
                this.lastPageRead = -1;
                this.reader.lastXrefPartial = this.refsp.get(i2);
                this.reader.releaseLastXrefPartial();
                this.refsp.remove(i2);
            }
        }

        public void resetReleasePage() {
            if (this.refsp != null) {
                this.lastPageRead = -1;
            }
        }

        /* access modifiers changed from: package-private */
        public void insertPage(int i, PRIndirectReference pRIndirectReference) {
            int i2 = i - 1;
            ArrayList arrayList = this.refsn;
            if (arrayList == null) {
                this.sizep++;
                this.lastPageRead = -1;
                if (i2 >= size()) {
                    this.refsp.put(size(), pRIndirectReference.getNumber());
                    return;
                }
                IntHashtable intHashtable = new IntHashtable((this.refsp.size() + 1) * 2);
                Iterator entryIterator = this.refsp.getEntryIterator();
                while (entryIterator.hasNext()) {
                    IntHashtable.Entry entry = (IntHashtable.Entry) entryIterator.next();
                    int key = entry.getKey();
                    if (key >= i2) {
                        key++;
                    }
                    intHashtable.put(key, entry.getValue());
                }
                intHashtable.put(i2, pRIndirectReference.getNumber());
                this.refsp = intHashtable;
            } else if (i2 >= arrayList.size()) {
                this.refsn.add(pRIndirectReference);
            } else {
                this.refsn.add(i2, pRIndirectReference);
            }
        }

        private void pushPageAttributes(PdfDictionary pdfDictionary) {
            PdfDictionary pdfDictionary2 = new PdfDictionary();
            if (!this.pageInh.isEmpty()) {
                ArrayList arrayList = this.pageInh;
                pdfDictionary2.putAll((PdfDictionary) arrayList.get(arrayList.size() - 1));
            }
            for (int i = 0; i < PdfReader.pageInhCandidates.length; i++) {
                PdfObject pdfObject = pdfDictionary.get(PdfReader.pageInhCandidates[i]);
                if (pdfObject != null) {
                    pdfDictionary2.put(PdfReader.pageInhCandidates[i], pdfObject);
                }
            }
            this.pageInh.add(pdfDictionary2);
        }

        private void popPageAttributes() {
            ArrayList arrayList = this.pageInh;
            arrayList.remove(arrayList.size() - 1);
        }

        private void iteratePages(PRIndirectReference pRIndirectReference) throws IOException {
            PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.getPdfObject((PdfObject) pRIndirectReference);
            PdfArray asArray = pdfDictionary.getAsArray(PdfName.KIDS);
            int i = 0;
            if (asArray == null) {
                pdfDictionary.put(PdfName.TYPE, PdfName.PAGE);
                ArrayList arrayList = this.pageInh;
                PdfDictionary pdfDictionary2 = (PdfDictionary) arrayList.get(arrayList.size() - 1);
                for (PdfName pdfName : pdfDictionary2.getKeys()) {
                    if (pdfDictionary.get(pdfName) == null) {
                        pdfDictionary.put(pdfName, pdfDictionary2.get(pdfName));
                    }
                }
                if (pdfDictionary.get(PdfName.MEDIABOX) == null) {
                    pdfDictionary.put(PdfName.MEDIABOX, new PdfArray(new float[]{0.0f, 0.0f, PageSize.LETTER.getRight(), PageSize.LETTER.getTop()}));
                }
                this.refsn.add(pRIndirectReference);
                return;
            }
            pdfDictionary.put(PdfName.TYPE, PdfName.PAGES);
            pushPageAttributes(pdfDictionary);
            while (true) {
                if (i >= asArray.size()) {
                    break;
                }
                PdfObject pdfObject = asArray.getPdfObject(i);
                if (!pdfObject.isIndirect()) {
                    while (i < asArray.size()) {
                        asArray.remove(i);
                    }
                } else {
                    iteratePages((PRIndirectReference) pdfObject);
                    i++;
                }
            }
            popPageAttributes();
        }

        /* access modifiers changed from: protected */
        public PRIndirectReference getSinglePage(int i) {
            PdfDictionary pdfDictionary = new PdfDictionary();
            PdfDictionary pdfDictionary2 = this.reader.rootPages;
            int i2 = 0;
            while (true) {
                for (int i3 = 0; i3 < PdfReader.pageInhCandidates.length; i3++) {
                    PdfObject pdfObject = pdfDictionary2.get(PdfReader.pageInhCandidates[i3]);
                    if (pdfObject != null) {
                        pdfDictionary.put(PdfReader.pageInhCandidates[i3], pdfObject);
                    }
                }
                ListIterator listIterator = ((PdfArray) PdfReader.getPdfObjectRelease(pdfDictionary2.get(PdfName.KIDS))).listIterator();
                while (true) {
                    if (!listIterator.hasNext()) {
                        break;
                    }
                    PRIndirectReference pRIndirectReference = (PRIndirectReference) listIterator.next();
                    PdfDictionary pdfDictionary3 = (PdfDictionary) PdfReader.getPdfObject((PdfObject) pRIndirectReference);
                    int access$1 = this.reader.lastXrefPartial;
                    PdfObject pdfObjectRelease = PdfReader.getPdfObjectRelease(pdfDictionary3.get(PdfName.COUNT));
                    this.reader.lastXrefPartial = access$1;
                    int intValue = ((pdfObjectRelease == null || pdfObjectRelease.type() != 2) ? 1 : ((PdfNumber) pdfObjectRelease).intValue()) + i2;
                    if (i >= intValue) {
                        this.reader.releaseLastXrefPartial();
                        i2 = intValue;
                    } else if (pdfObjectRelease == null) {
                        pdfDictionary3.mergeDifferent(pdfDictionary);
                        return pRIndirectReference;
                    } else {
                        this.reader.releaseLastXrefPartial();
                        pdfDictionary2 = pdfDictionary3;
                    }
                }
            }
        }

        /* access modifiers changed from: private */
        public void selectPages(List list) {
            IntHashtable intHashtable = new IntHashtable();
            ArrayList arrayList = new ArrayList();
            int size = size();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Integer num = (Integer) it.next();
                int intValue = num.intValue();
                if (intValue >= 1 && intValue <= size && intHashtable.put(intValue, 1) == 0) {
                    arrayList.add(num);
                }
            }
            if (this.reader.partial) {
                for (int i = 1; i <= size; i++) {
                    getPageOrigRef(i);
                    resetReleasePage();
                }
            }
            PRIndirectReference pRIndirectReference = (PRIndirectReference) this.reader.catalog.get(PdfName.PAGES);
            PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.getPdfObject((PdfObject) pRIndirectReference);
            ArrayList arrayList2 = new ArrayList(arrayList.size());
            PdfArray pdfArray = new PdfArray();
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                int intValue2 = ((Integer) arrayList.get(i2)).intValue();
                PRIndirectReference pageOrigRef = getPageOrigRef(intValue2);
                resetReleasePage();
                pdfArray.add((PdfObject) pageOrigRef);
                arrayList2.add(pageOrigRef);
                getPageN(intValue2).put(PdfName.PARENT, pRIndirectReference);
            }
            AcroFields acroFields = this.reader.getAcroFields();
            boolean z = acroFields.getFields().size() > 0;
            for (int i3 = 1; i3 <= size; i3++) {
                if (!intHashtable.containsKey(i3)) {
                    if (z) {
                        acroFields.removeFieldsFromPage(i3);
                    }
                    int number = getPageOrigRef(i3).getNumber();
                    this.reader.xrefObj.set(number, (Object) null);
                    if (this.reader.partial) {
                        int i4 = number * 2;
                        this.reader.xref[i4] = -1;
                        this.reader.xref[i4 + 1] = 0;
                    }
                }
            }
            pdfDictionary.put(PdfName.COUNT, new PdfNumber(arrayList.size()));
            pdfDictionary.put(PdfName.KIDS, pdfArray);
            this.refsp = null;
            this.refsn = arrayList2;
        }
    }

    /* access modifiers changed from: package-private */
    public PdfIndirectReference getCryptoRef() {
        PRIndirectReference pRIndirectReference = this.cryptoRef;
        if (pRIndirectReference == null) {
            return null;
        }
        return new PdfIndirectReference(0, pRIndirectReference.getNumber(), this.cryptoRef.getGeneration());
    }

    public void removeUsageRights() {
        PdfDictionary asDict = this.catalog.getAsDict(PdfName.PERMS);
        if (asDict != null) {
            asDict.remove(PdfName.f735UR);
            asDict.remove(PdfName.UR3);
            if (asDict.size() == 0) {
                this.catalog.remove(PdfName.PERMS);
            }
        }
    }

    public int getCertificationLevel() {
        PdfDictionary asDict;
        PdfArray asArray;
        PdfDictionary asDict2;
        PdfDictionary asDict3;
        PdfNumber asNumber;
        PdfDictionary asDict4 = this.catalog.getAsDict(PdfName.PERMS);
        if (asDict4 == null || (asDict = asDict4.getAsDict(PdfName.DOCMDP)) == null || (asArray = asDict.getAsArray(PdfName.REFERENCE)) == null || asArray.size() == 0 || (asDict2 = asArray.getAsDict(0)) == null || (asDict3 = asDict2.getAsDict(PdfName.TRANSFORMPARAMS)) == null || (asNumber = asDict3.getAsNumber(PdfName.f707P)) == null) {
            return 0;
        }
        return asNumber.intValue();
    }

    public final boolean isOpenedWithFullPermissions() {
        return !this.encrypted || this.ownerPasswordUsed;
    }

    public int getCryptoMode() {
        PdfEncryption pdfEncryption = this.decrypt;
        if (pdfEncryption == null) {
            return -1;
        }
        return pdfEncryption.getCryptoMode();
    }

    public boolean isMetadataEncrypted() {
        PdfEncryption pdfEncryption = this.decrypt;
        if (pdfEncryption == null) {
            return false;
        }
        return pdfEncryption.isMetadataEncrypted();
    }

    public byte[] computeUserPassword() {
        if (!this.encrypted || !this.ownerPasswordUsed) {
            return null;
        }
        return this.decrypt.computeUserPassword(this.password);
    }
}
