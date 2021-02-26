package com.lowagie.text.pdf;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.Rectangle;
import com.lowagie.text.exceptions.BadPasswordException;
import com.lowagie.text.pdf.AcroFields;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.collection.PdfCollection;
import com.lowagie.text.pdf.internal.PdfViewerPreferencesImp;
import com.lowagie.text.xml.xmp.PdfSchema;
import com.lowagie.text.xml.xmp.XmpBasicSchema;
import com.lowagie.text.xml.xmp.XmpReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import org.codehaus.jackson.util.MinimalPrettyPrinter;
import org.xml.sax.SAXException;

class PdfStamperImp extends PdfWriter {
    protected AcroFields acroFields;
    protected boolean append;
    boolean closed = false;
    protected HashMap fieldTemplates = new HashMap();
    protected boolean fieldsAdded = false;
    RandomAccessFileOrArray file;
    protected boolean flat = false;
    protected boolean flatFreeText = false;
    protected int initialXrefSize;
    protected IntHashtable marked;
    IntHashtable myXref = new IntHashtable();
    protected int[] namePtr = new int[1];
    protected PdfAction openAction;
    HashMap pagesToContent = new HashMap();
    protected HashSet partialFlattening = new HashSet();
    PdfReader reader;
    HashMap readers2file = new HashMap();
    HashMap readers2intrefs = new HashMap();
    private boolean rotateContents = true;
    protected int sigFlags = 0;
    protected boolean useVp = false;
    protected PdfViewerPreferencesImp viewerPreferences = new PdfViewerPreferencesImp();

    PdfStamperImp(PdfReader pdfReader, OutputStream outputStream, char c, boolean z) throws DocumentException, IOException {
        super(new PdfDocument(), outputStream);
        if (!pdfReader.isOpenedWithFullPermissions()) {
            throw new BadPasswordException("PdfReader not opened with owner password");
        } else if (!pdfReader.isTampered()) {
            pdfReader.setTampered(true);
            this.reader = pdfReader;
            this.file = pdfReader.getSafeFile();
            this.append = z;
            if (z) {
                if (!pdfReader.isRebuilt()) {
                    if (pdfReader.isEncrypted()) {
                        this.crypto = new PdfEncryption(pdfReader.getDecrypt());
                    }
                    this.pdf_version.setAppendmode(true);
                    this.file.reOpen();
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = this.file.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        this.f571os.write(bArr, 0, read);
                    }
                    this.file.close();
                    this.prevxref = pdfReader.getLastXref();
                    pdfReader.setAppendable(true);
                } else {
                    throw new DocumentException("Append mode requires a document without errors even if recovery was possible.");
                }
            } else if (c == 0) {
                super.setPdfVersion(pdfReader.getPdfVersion());
            } else {
                super.setPdfVersion(c);
            }
            super.open();
            this.pdf.addWriter(this);
            if (z) {
                this.body.setRefnum(pdfReader.getXrefSize());
                this.marked = new IntHashtable();
                if (pdfReader.isNewXrefType()) {
                    this.fullCompression = true;
                }
                if (pdfReader.isHybridXref()) {
                    this.fullCompression = false;
                }
            }
            this.initialXrefSize = pdfReader.getXrefSize();
        } else {
            throw new DocumentException("The original document was reused. Read it again from file.");
        }
    }

    /* access modifiers changed from: package-private */
    public void close(HashMap hashMap) throws IOException {
        byte[] bArr;
        PdfObject pdfObject;
        PdfIndirectReference pdfIndirectReference;
        PdfIndirectReference pdfIndirectReference2;
        PdfStream pdfStream;
        if (!this.closed) {
            if (this.useVp) {
                this.reader.setViewerPreferences(this.viewerPreferences);
                markUsed(this.reader.getTrailer().get(PdfName.ROOT));
            }
            if (this.flat) {
                flatFields();
            }
            if (this.flatFreeText) {
                flatFreeTextFields();
            }
            addFieldResources();
            PdfDictionary catalog = this.reader.getCatalog();
            PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.getPdfObject(catalog.get(PdfName.PAGES));
            pdfDictionary.put(PdfName.ITXT, new PdfString(Document.getRelease()));
            markUsed((PdfObject) pdfDictionary);
            PdfDictionary pdfDictionary2 = (PdfDictionary) PdfReader.getPdfObject(catalog.get(PdfName.ACROFORM), this.reader.getCatalog());
            AcroFields acroFields2 = this.acroFields;
            if (acroFields2 != null && acroFields2.getXfa().isChanged()) {
                markUsed((PdfObject) pdfDictionary2);
                if (!this.flat) {
                    this.acroFields.getXfa().setXfa(this);
                }
            }
            if (!(this.sigFlags == 0 || pdfDictionary2 == null)) {
                pdfDictionary2.put(PdfName.SIGFLAGS, new PdfNumber(this.sigFlags));
                markUsed((PdfObject) pdfDictionary2);
                markUsed((PdfObject) catalog);
            }
            this.closed = true;
            addSharedObjectsToBody();
            setOutlines();
            setJavaScript();
            addFileAttachments();
            if (this.openAction != null) {
                catalog.put(PdfName.OPENACTION, this.openAction);
            }
            if (this.pdf.pageLabels != null) {
                catalog.put(PdfName.PAGELABELS, this.pdf.pageLabels.getDictionary(this));
            }
            if (!this.documentOCG.isEmpty()) {
                fillOCProperties(false);
                PdfDictionary asDict = catalog.getAsDict(PdfName.OCPROPERTIES);
                if (asDict == null) {
                    this.reader.getCatalog().put(PdfName.OCPROPERTIES, this.OCProperties);
                } else {
                    asDict.put(PdfName.OCGS, this.OCProperties.get(PdfName.OCGS));
                    PdfDictionary asDict2 = asDict.getAsDict(PdfName.f661D);
                    if (asDict2 == null) {
                        asDict2 = new PdfDictionary();
                        asDict.put(PdfName.f661D, asDict2);
                    }
                    asDict2.put(PdfName.ORDER, this.OCProperties.getAsDict(PdfName.f661D).get(PdfName.ORDER));
                    asDict2.put(PdfName.RBGROUPS, this.OCProperties.getAsDict(PdfName.f661D).get(PdfName.RBGROUPS));
                    asDict2.put(PdfName.OFF, this.OCProperties.getAsDict(PdfName.f661D).get(PdfName.OFF));
                    asDict2.put(PdfName.f645AS, this.OCProperties.getAsDict(PdfName.f661D).get(PdfName.f645AS));
                }
            }
            PRIndirectReference pRIndirectReference = (PRIndirectReference) this.reader.getTrailer().get(PdfName.INFO);
            PdfDictionary pdfDictionary3 = (PdfDictionary) PdfReader.getPdfObject((PdfObject) pRIndirectReference);
            int number = pRIndirectReference != null ? pRIndirectReference.getNumber() : -1;
            PdfIndirectReference pdfIndirectReference3 = null;
            String pdfString = (pdfDictionary3 == null || pdfDictionary3.get(PdfName.PRODUCER) == null) ? null : pdfDictionary3.getAsString(PdfName.PRODUCER).toString();
            if (pdfString == null) {
                pdfString = Document.getVersion();
            } else if (pdfString.indexOf(Document.getProduct()) == -1) {
                StringBuffer stringBuffer = new StringBuffer(pdfString);
                stringBuffer.append("; modified using ");
                stringBuffer.append(Document.getVersion());
                pdfString = stringBuffer.toString();
            }
            PdfObject pdfObject2 = PdfReader.getPdfObject(catalog.get(PdfName.METADATA));
            if (pdfObject2 == null || !pdfObject2.isStream()) {
                bArr = null;
            } else {
                bArr = PdfReader.getStreamBytesRaw((PRStream) pdfObject2);
                PdfReader.killIndirect(catalog.get(PdfName.METADATA));
            }
            if (this.xmpMetadata != null) {
                bArr = this.xmpMetadata;
            }
            PdfDate pdfDate = new PdfDate();
            if (bArr != null) {
                try {
                    XmpReader xmpReader = new XmpReader(bArr);
                    if (!xmpReader.replace(PdfSchema.DEFAULT_XPATH_URI, "Producer", pdfString)) {
                        xmpReader.add("rdf:Description", PdfSchema.DEFAULT_XPATH_URI, PdfSchema.PRODUCER, pdfString);
                    }
                    if (!xmpReader.replace(XmpBasicSchema.DEFAULT_XPATH_URI, "ModifyDate", pdfDate.getW3CDate())) {
                        xmpReader.add("rdf:Description", XmpBasicSchema.DEFAULT_XPATH_URI, XmpBasicSchema.MODIFYDATE, pdfDate.getW3CDate());
                    }
                    xmpReader.replace(XmpBasicSchema.DEFAULT_XPATH_URI, "MetadataDate", pdfDate.getW3CDate());
                    pdfStream = new PdfStream(xmpReader.serializeDoc());
                } catch (SAXException unused) {
                    pdfStream = new PdfStream(bArr);
                } catch (IOException unused2) {
                    pdfStream = new PdfStream(bArr);
                }
                pdfStream.put(PdfName.TYPE, PdfName.METADATA);
                pdfStream.put(PdfName.SUBTYPE, PdfName.XML);
                if (this.crypto != null && !this.crypto.isMetadataEncrypted()) {
                    PdfArray pdfArray = new PdfArray();
                    pdfArray.add((PdfObject) PdfName.CRYPT);
                    pdfStream.put(PdfName.FILTER, pdfArray);
                }
                if (!this.append || pdfObject2 == null) {
                    catalog.put(PdfName.METADATA, this.body.add(pdfStream).getIndirectReference());
                    markUsed((PdfObject) catalog);
                } else {
                    this.body.add((PdfObject) pdfStream, (PdfIndirectReference) pdfObject2.getIndRef());
                }
            }
            try {
                this.file.reOpen();
                alterContents();
                int number2 = ((PRIndirectReference) this.reader.trailer.get(PdfName.ROOT)).getNumber();
                if (this.append) {
                    int[] keys = this.marked.getKeys();
                    for (int i = 0; i < keys.length; i++) {
                        int i2 = keys[i];
                        PdfObject pdfObjectRelease = this.reader.getPdfObjectRelease(i2);
                        if (!(pdfObjectRelease == null || number == i2 || i2 >= this.initialXrefSize)) {
                            addToBody(pdfObjectRelease, i2, i2 != number2);
                        }
                    }
                    for (int i3 = this.initialXrefSize; i3 < this.reader.getXrefSize(); i3++) {
                        PdfObject pdfObject3 = this.reader.getPdfObject(i3);
                        if (pdfObject3 != null) {
                            addToBody(pdfObject3, getNewObjectNumber(this.reader, i3, 0));
                        }
                    }
                } else {
                    int i4 = 1;
                    while (i4 < this.reader.getXrefSize()) {
                        PdfObject pdfObjectRelease2 = this.reader.getPdfObjectRelease(i4);
                        if (!(pdfObjectRelease2 == null || number == i4)) {
                            addToBody(pdfObjectRelease2, getNewObjectNumber(this.reader, i4, 0), i4 != number2);
                        }
                        i4++;
                    }
                }
                if (this.crypto != null) {
                    if (this.append) {
                        pdfIndirectReference2 = this.reader.getCryptoRef();
                    } else {
                        pdfIndirectReference2 = addToBody((PdfObject) this.crypto.getEncryptionDictionary(), false).getIndirectReference();
                    }
                    pdfIndirectReference3 = pdfIndirectReference2;
                    pdfObject = this.crypto.getFileID();
                } else {
                    pdfObject = PdfEncryption.createInfoId(PdfEncryption.createDocumentId());
                }
                PdfIndirectReference pdfIndirectReference4 = new PdfIndirectReference(0, getNewObjectNumber(this.reader, ((PRIndirectReference) this.reader.trailer.get(PdfName.ROOT)).getNumber(), 0));
                PdfDictionary pdfDictionary4 = new PdfDictionary();
                if (pdfDictionary3 != null) {
                    for (PdfName pdfName : pdfDictionary3.getKeys()) {
                        pdfDictionary4.put(pdfName, PdfReader.getPdfObject(pdfDictionary3.get(pdfName)));
                    }
                }
                if (hashMap != null) {
                    for (Map.Entry entry : hashMap.entrySet()) {
                        PdfName pdfName2 = new PdfName((String) entry.getKey());
                        String str = (String) entry.getValue();
                        if (str == null) {
                            pdfDictionary4.remove(pdfName2);
                        } else {
                            pdfDictionary4.put(pdfName2, new PdfString(str, PdfObject.TEXT_UNICODE));
                        }
                    }
                }
                pdfDictionary4.put(PdfName.MODDATE, pdfDate);
                pdfDictionary4.put(PdfName.PRODUCER, new PdfString(pdfString));
                if (!this.append) {
                    pdfIndirectReference = addToBody((PdfObject) pdfDictionary4, false).getIndirectReference();
                } else if (pRIndirectReference == null) {
                    pdfIndirectReference = addToBody((PdfObject) pdfDictionary4, false).getIndirectReference();
                } else {
                    pdfIndirectReference = addToBody((PdfObject) pdfDictionary4, pRIndirectReference.getNumber(), false).getIndirectReference();
                }
                this.body.writeCrossReferenceTable(this.f571os, pdfIndirectReference4, pdfIndirectReference, pdfIndirectReference3, pdfObject, this.prevxref);
                if (this.fullCompression) {
                    this.f571os.write(getISOBytes("startxref\n"));
                    this.f571os.write(getISOBytes(String.valueOf(this.body.offset())));
                    this.f571os.write(getISOBytes("\n%%EOF\n"));
                } else {
                    new PdfWriter.PdfTrailer(this.body.size(), this.body.offset(), pdfIndirectReference4, pdfIndirectReference, pdfIndirectReference3, pdfObject, this.prevxref).toPdf(this, this.f571os);
                }
                this.f571os.flush();
                if (isCloseStream()) {
                    this.f571os.close();
                }
                this.reader.close();
            } finally {
                try {
                    this.file.close();
                } catch (Exception unused3) {
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void applyRotation(PdfDictionary pdfDictionary, ByteBuffer byteBuffer) {
        if (this.rotateContents) {
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

    /* access modifiers changed from: package-private */
    public void alterContents() throws IOException {
        PdfArray pdfArray;
        for (PageStamp pageStamp : this.pagesToContent.values()) {
            PdfDictionary pdfDictionary = pageStamp.pageN;
            markUsed((PdfObject) pdfDictionary);
            PdfObject pdfObject = PdfReader.getPdfObject(pdfDictionary.get(PdfName.CONTENTS), pdfDictionary);
            if (pdfObject == null) {
                pdfArray = new PdfArray();
                pdfDictionary.put(PdfName.CONTENTS, pdfArray);
            } else if (pdfObject.isArray()) {
                pdfArray = (PdfArray) pdfObject;
                markUsed((PdfObject) pdfArray);
            } else if (pdfObject.isStream()) {
                pdfArray = new PdfArray();
                pdfArray.add(pdfDictionary.get(PdfName.CONTENTS));
                pdfDictionary.put(PdfName.CONTENTS, pdfArray);
            } else {
                pdfArray = new PdfArray();
                pdfDictionary.put(PdfName.CONTENTS, pdfArray);
            }
            ByteBuffer byteBuffer = new ByteBuffer();
            if (pageStamp.under != null) {
                byteBuffer.append(PdfContents.SAVESTATE);
                applyRotation(pdfDictionary, byteBuffer);
                byteBuffer.append(pageStamp.under.getInternalBuffer());
                byteBuffer.append(PdfContents.RESTORESTATE);
            }
            if (pageStamp.over != null) {
                byteBuffer.append(PdfContents.SAVESTATE);
            }
            PdfStream pdfStream = new PdfStream(byteBuffer.toByteArray());
            pdfStream.flateCompress(this.compressionLevel);
            pdfArray.addFirst(addToBody(pdfStream).getIndirectReference());
            byteBuffer.reset();
            if (pageStamp.over != null) {
                byteBuffer.append(' ');
                byteBuffer.append(PdfContents.RESTORESTATE);
                ByteBuffer internalBuffer = pageStamp.over.getInternalBuffer();
                byteBuffer.append(internalBuffer.getBuffer(), 0, pageStamp.replacePoint);
                byteBuffer.append(PdfContents.SAVESTATE);
                applyRotation(pdfDictionary, byteBuffer);
                byteBuffer.append(internalBuffer.getBuffer(), pageStamp.replacePoint, internalBuffer.size() - pageStamp.replacePoint);
                byteBuffer.append(PdfContents.RESTORESTATE);
                PdfStream pdfStream2 = new PdfStream(byteBuffer.toByteArray());
                pdfStream2.flateCompress(this.compressionLevel);
                pdfArray.add((PdfObject) addToBody(pdfStream2).getIndirectReference());
            }
            alterResources(pageStamp);
        }
    }

    /* access modifiers changed from: package-private */
    public void alterResources(PageStamp pageStamp) {
        pageStamp.pageN.put(PdfName.RESOURCES, pageStamp.pageResources.getResources());
    }

    /* access modifiers changed from: protected */
    public int getNewObjectNumber(PdfReader pdfReader, int i, int i2) {
        IntHashtable intHashtable = (IntHashtable) this.readers2intrefs.get(pdfReader);
        if (intHashtable != null) {
            int i3 = intHashtable.get(i);
            if (i3 != 0) {
                return i3;
            }
            int indirectReferenceNumber = getIndirectReferenceNumber();
            intHashtable.put(i, indirectReferenceNumber);
            return indirectReferenceNumber;
        } else if (this.currentPdfReaderInstance != null) {
            return this.currentPdfReaderInstance.getNewObjectNumber(i, i2);
        } else {
            if (this.append && i < this.initialXrefSize) {
                return i;
            }
            int i4 = this.myXref.get(i);
            if (i4 != 0) {
                return i4;
            }
            int indirectReferenceNumber2 = getIndirectReferenceNumber();
            this.myXref.put(i, indirectReferenceNumber2);
            return indirectReferenceNumber2;
        }
    }

    /* access modifiers changed from: package-private */
    public RandomAccessFileOrArray getReaderFile(PdfReader pdfReader) {
        if (this.readers2intrefs.containsKey(pdfReader)) {
            RandomAccessFileOrArray randomAccessFileOrArray = (RandomAccessFileOrArray) this.readers2file.get(pdfReader);
            if (randomAccessFileOrArray != null) {
                return randomAccessFileOrArray;
            }
            return pdfReader.getSafeFile();
        } else if (this.currentPdfReaderInstance == null) {
            return this.file;
        } else {
            return this.currentPdfReaderInstance.getReaderFile();
        }
    }

    public void registerReader(PdfReader pdfReader, boolean z) throws IOException {
        if (!this.readers2intrefs.containsKey(pdfReader)) {
            this.readers2intrefs.put(pdfReader, new IntHashtable());
            if (z) {
                RandomAccessFileOrArray safeFile = pdfReader.getSafeFile();
                this.readers2file.put(pdfReader, safeFile);
                safeFile.reOpen();
            }
        }
    }

    public void unRegisterReader(PdfReader pdfReader) {
        if (this.readers2intrefs.containsKey(pdfReader)) {
            this.readers2intrefs.remove(pdfReader);
            RandomAccessFileOrArray randomAccessFileOrArray = (RandomAccessFileOrArray) this.readers2file.get(pdfReader);
            if (randomAccessFileOrArray != null) {
                this.readers2file.remove(pdfReader);
                try {
                    randomAccessFileOrArray.close();
                } catch (Exception unused) {
                }
            }
        }
    }

    static void findAllObjects(PdfReader pdfReader, PdfObject pdfObject, IntHashtable intHashtable) {
        if (pdfObject != null) {
            int type = pdfObject.type();
            if (type == 5) {
                PdfArray pdfArray = (PdfArray) pdfObject;
                for (int i = 0; i < pdfArray.size(); i++) {
                    findAllObjects(pdfReader, pdfArray.getPdfObject(i), intHashtable);
                }
            } else if (type == 6 || type == 7) {
                PdfDictionary pdfDictionary = (PdfDictionary) pdfObject;
                for (PdfName pdfName : pdfDictionary.getKeys()) {
                    findAllObjects(pdfReader, pdfDictionary.get(pdfName), intHashtable);
                }
            } else if (type == 10) {
                PRIndirectReference pRIndirectReference = (PRIndirectReference) pdfObject;
                if (pdfReader == pRIndirectReference.getReader() && !intHashtable.containsKey(pRIndirectReference.getNumber())) {
                    intHashtable.put(pRIndirectReference.getNumber(), 1);
                    findAllObjects(pdfReader, PdfReader.getPdfObject(pdfObject), intHashtable);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00cd, code lost:
        r5 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00cd, code lost:
        r5 = r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void addComments(com.lowagie.text.pdf.FdfReader r12) throws java.io.IOException {
        /*
            r11 = this;
            java.util.HashMap r0 = r11.readers2intrefs
            boolean r0 = r0.containsKey(r12)
            if (r0 == 0) goto L_0x0009
            return
        L_0x0009:
            com.lowagie.text.pdf.PdfDictionary r0 = r12.getCatalog()
            com.lowagie.text.pdf.PdfName r1 = com.lowagie.text.pdf.PdfName.FDF
            com.lowagie.text.pdf.PdfDictionary r0 = r0.getAsDict(r1)
            if (r0 != 0) goto L_0x0016
            return
        L_0x0016:
            com.lowagie.text.pdf.PdfName r1 = com.lowagie.text.pdf.PdfName.ANNOTS
            com.lowagie.text.pdf.PdfArray r0 = r0.getAsArray(r1)
            if (r0 == 0) goto L_0x0122
            int r1 = r0.size()
            if (r1 != 0) goto L_0x0026
            goto L_0x0122
        L_0x0026:
            r1 = 0
            r11.registerReader(r12, r1)
            com.lowagie.text.pdf.IntHashtable r2 = new com.lowagie.text.pdf.IntHashtable
            r2.<init>()
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r5 = 0
        L_0x003a:
            int r6 = r0.size()
            r7 = 3
            if (r5 < r6) goto L_0x00d8
            int[] r6 = r2.getKeys()
            r0 = 0
        L_0x0046:
            int r2 = r6.length
            if (r0 < r2) goto L_0x0092
        L_0x0049:
            int r12 = r4.size()
            if (r1 < r12) goto L_0x0050
            return
        L_0x0050:
            java.lang.Object r12 = r4.get(r1)
            com.lowagie.text.pdf.PdfObject r12 = (com.lowagie.text.pdf.PdfObject) r12
            com.lowagie.text.pdf.PdfObject r0 = com.lowagie.text.pdf.PdfReader.getPdfObject((com.lowagie.text.pdf.PdfObject) r12)
            com.lowagie.text.pdf.PdfDictionary r0 = (com.lowagie.text.pdf.PdfDictionary) r0
            com.lowagie.text.pdf.PdfName r2 = com.lowagie.text.pdf.PdfName.PAGE
            com.lowagie.text.pdf.PdfNumber r0 = r0.getAsNumber(r2)
            com.lowagie.text.pdf.PdfReader r2 = r11.reader
            int r0 = r0.intValue()
            int r0 = r0 + 1
            com.lowagie.text.pdf.PdfDictionary r0 = r2.getPageN(r0)
            com.lowagie.text.pdf.PdfName r2 = com.lowagie.text.pdf.PdfName.ANNOTS
            com.lowagie.text.pdf.PdfObject r2 = r0.get(r2)
            com.lowagie.text.pdf.PdfObject r2 = com.lowagie.text.pdf.PdfReader.getPdfObject(r2, r0)
            com.lowagie.text.pdf.PdfArray r2 = (com.lowagie.text.pdf.PdfArray) r2
            if (r2 != 0) goto L_0x0089
            com.lowagie.text.pdf.PdfArray r2 = new com.lowagie.text.pdf.PdfArray
            r2.<init>()
            com.lowagie.text.pdf.PdfName r3 = com.lowagie.text.pdf.PdfName.ANNOTS
            r0.put(r3, r2)
            r11.markUsed((com.lowagie.text.pdf.PdfObject) r0)
        L_0x0089:
            r11.markUsed((com.lowagie.text.pdf.PdfObject) r2)
            r2.add((com.lowagie.text.pdf.PdfObject) r12)
            int r1 = r1 + 1
            goto L_0x0049
        L_0x0092:
            r2 = r6[r0]
            com.lowagie.text.pdf.PdfObject r5 = r12.getPdfObject((int) r2)
            int r8 = r5.type()
            r9 = 6
            if (r8 != r9) goto L_0x00cd
            r8 = r5
            com.lowagie.text.pdf.PdfDictionary r8 = (com.lowagie.text.pdf.PdfDictionary) r8
            com.lowagie.text.pdf.PdfName r9 = com.lowagie.text.pdf.PdfName.IRT
            com.lowagie.text.pdf.PdfObject r9 = r8.get(r9)
            com.lowagie.text.pdf.PdfObject r9 = com.lowagie.text.pdf.PdfReader.getPdfObject((com.lowagie.text.pdf.PdfObject) r9)
            if (r9 == 0) goto L_0x00cd
            int r10 = r9.type()
            if (r10 != r7) goto L_0x00cd
            java.lang.String r9 = r9.toString()
            java.lang.Object r9 = r3.get(r9)
            com.lowagie.text.pdf.PdfObject r9 = (com.lowagie.text.pdf.PdfObject) r9
            if (r9 == 0) goto L_0x00cd
            com.lowagie.text.pdf.PdfDictionary r5 = new com.lowagie.text.pdf.PdfDictionary
            r5.<init>()
            r5.merge(r8)
            com.lowagie.text.pdf.PdfName r8 = com.lowagie.text.pdf.PdfName.IRT
            r5.put(r8, r9)
        L_0x00cd:
            int r2 = r11.getNewObjectNumber(r12, r2, r1)
            r11.addToBody((com.lowagie.text.pdf.PdfObject) r5, (int) r2)
            int r0 = r0 + 1
            goto L_0x0046
        L_0x00d8:
            com.lowagie.text.pdf.PdfObject r6 = r0.getPdfObject(r5)
            com.lowagie.text.pdf.PdfObject r8 = com.lowagie.text.pdf.PdfReader.getPdfObject((com.lowagie.text.pdf.PdfObject) r6)
            com.lowagie.text.pdf.PdfDictionary r8 = (com.lowagie.text.pdf.PdfDictionary) r8
            com.lowagie.text.pdf.PdfName r9 = com.lowagie.text.pdf.PdfName.PAGE
            com.lowagie.text.pdf.PdfNumber r9 = r8.getAsNumber(r9)
            if (r9 == 0) goto L_0x011e
            int r9 = r9.intValue()
            com.lowagie.text.pdf.PdfReader r10 = r11.reader
            int r10 = r10.getNumberOfPages()
            if (r9 < r10) goto L_0x00f7
            goto L_0x011e
        L_0x00f7:
            findAllObjects(r12, r6, r2)
            r4.add(r6)
            int r9 = r6.type()
            r10 = 10
            if (r9 != r10) goto L_0x011e
            com.lowagie.text.pdf.PdfName r9 = com.lowagie.text.pdf.PdfName.f702NM
            com.lowagie.text.pdf.PdfObject r8 = r8.get(r9)
            com.lowagie.text.pdf.PdfObject r8 = com.lowagie.text.pdf.PdfReader.getPdfObject((com.lowagie.text.pdf.PdfObject) r8)
            if (r8 == 0) goto L_0x011e
            int r9 = r8.type()
            if (r9 != r7) goto L_0x011e
            java.lang.String r7 = r8.toString()
            r3.put(r7, r6)
        L_0x011e:
            int r5 = r5 + 1
            goto L_0x003a
        L_0x0122:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.PdfStamperImp.addComments(com.lowagie.text.pdf.FdfReader):void");
    }

    /* access modifiers changed from: package-private */
    public PageStamp getPageStamp(int i) {
        PdfDictionary pageN = this.reader.getPageN(i);
        PageStamp pageStamp = (PageStamp) this.pagesToContent.get(pageN);
        if (pageStamp != null) {
            return pageStamp;
        }
        PageStamp pageStamp2 = new PageStamp(this, this.reader, pageN);
        this.pagesToContent.put(pageN, pageStamp2);
        return pageStamp2;
    }

    /* access modifiers changed from: package-private */
    public PdfContentByte getUnderContent(int i) {
        if (i < 1 || i > this.reader.getNumberOfPages()) {
            return null;
        }
        PageStamp pageStamp = getPageStamp(i);
        if (pageStamp.under == null) {
            pageStamp.under = new StampContent(this, pageStamp);
        }
        return pageStamp.under;
    }

    /* access modifiers changed from: package-private */
    public PdfContentByte getOverContent(int i) {
        if (i < 1 || i > this.reader.getNumberOfPages()) {
            return null;
        }
        PageStamp pageStamp = getPageStamp(i);
        if (pageStamp.over == null) {
            pageStamp.over = new StampContent(this, pageStamp);
        }
        return pageStamp.over;
    }

    /* access modifiers changed from: package-private */
    public void correctAcroFieldPages(int i) {
        if (this.acroFields != null && i <= this.reader.getNumberOfPages()) {
            for (AcroFields.Item item : this.acroFields.getFields().values()) {
                for (int i2 = 0; i2 < item.size(); i2++) {
                    int intValue = item.getPage(i2).intValue();
                    if (intValue >= i) {
                        item.forcePage(i2, intValue + 1);
                    }
                }
            }
        }
    }

    private static void moveRectangle(PdfDictionary pdfDictionary, PdfReader pdfReader, int i, PdfName pdfName, String str) {
        Rectangle boxSize = pdfReader.getBoxSize(i, str);
        if (boxSize == null) {
            pdfDictionary.remove(pdfName);
        } else {
            pdfDictionary.put(pdfName, new PdfRectangle(boxSize));
        }
    }

    /* access modifiers changed from: package-private */
    public void replacePage(PdfReader pdfReader, int i, int i2) {
        PdfDictionary pageN = this.reader.getPageN(i2);
        if (!this.pagesToContent.containsKey(pageN)) {
            PdfImportedPage importedPage = getImportedPage(pdfReader, i);
            PdfDictionary pageNRelease = this.reader.getPageNRelease(i2);
            pageNRelease.remove(PdfName.RESOURCES);
            pageNRelease.remove(PdfName.CONTENTS);
            moveRectangle(pageNRelease, pdfReader, i, PdfName.MEDIABOX, "media");
            moveRectangle(pageNRelease, pdfReader, i, PdfName.CROPBOX, "crop");
            moveRectangle(pageNRelease, pdfReader, i, PdfName.TRIMBOX, "trim");
            moveRectangle(pageNRelease, pdfReader, i, PdfName.ARTBOX, "art");
            moveRectangle(pageNRelease, pdfReader, i, PdfName.BLEEDBOX, "bleed");
            pageNRelease.put(PdfName.ROTATE, new PdfNumber(pdfReader.getPageRotation(i)));
            getOverContent(i2).addTemplate(importedPage, 0.0f, 0.0f);
            PageStamp pageStamp = (PageStamp) this.pagesToContent.get(pageN);
            pageStamp.replacePoint = pageStamp.over.getInternalBuffer().size();
            return;
        }
        throw new IllegalStateException("This page cannot be replaced: new content was already added");
    }

    /* access modifiers changed from: package-private */
    public void insertPage(int i, Rectangle rectangle) {
        PRIndirectReference pRIndirectReference;
        PdfDictionary pdfDictionary;
        Rectangle rectangle2 = new Rectangle(rectangle);
        int rotation = rectangle2.getRotation() % 360;
        PdfDictionary pdfDictionary2 = new PdfDictionary(PdfName.PAGE);
        PdfDictionary pdfDictionary3 = new PdfDictionary();
        PdfArray pdfArray = new PdfArray();
        pdfArray.add((PdfObject) PdfName.PDF);
        pdfArray.add((PdfObject) PdfName.TEXT);
        pdfArray.add((PdfObject) PdfName.IMAGEB);
        pdfArray.add((PdfObject) PdfName.IMAGEC);
        pdfArray.add((PdfObject) PdfName.IMAGEI);
        pdfDictionary3.put(PdfName.PROCSET, pdfArray);
        pdfDictionary2.put(PdfName.RESOURCES, pdfDictionary3);
        pdfDictionary2.put(PdfName.ROTATE, new PdfNumber(rotation));
        pdfDictionary2.put(PdfName.MEDIABOX, new PdfRectangle(rectangle2, rotation));
        PRIndirectReference addPdfObject = this.reader.addPdfObject(pdfDictionary2);
        if (i > this.reader.getNumberOfPages()) {
            PdfReader pdfReader = this.reader;
            pRIndirectReference = new PRIndirectReference(this.reader, ((PRIndirectReference) pdfReader.getPageNRelease(pdfReader.getNumberOfPages()).get(PdfName.PARENT)).getNumber());
            pdfDictionary = (PdfDictionary) PdfReader.getPdfObject((PdfObject) pRIndirectReference);
            PdfArray pdfArray2 = (PdfArray) PdfReader.getPdfObject(pdfDictionary.get(PdfName.KIDS), pdfDictionary);
            pdfArray2.add((PdfObject) addPdfObject);
            markUsed((PdfObject) pdfArray2);
            this.reader.pageRefs.insertPage(i, addPdfObject);
        } else {
            if (i < 1) {
                i = 1;
            }
            PdfDictionary pageN = this.reader.getPageN(i);
            PRIndirectReference pageOrigRef = this.reader.getPageOrigRef(i);
            this.reader.releasePage(i);
            PRIndirectReference pRIndirectReference2 = new PRIndirectReference(this.reader, ((PRIndirectReference) pageN.get(PdfName.PARENT)).getNumber());
            pdfDictionary = (PdfDictionary) PdfReader.getPdfObject((PdfObject) pRIndirectReference2);
            PdfArray pdfArray3 = (PdfArray) PdfReader.getPdfObject(pdfDictionary.get(PdfName.KIDS), pdfDictionary);
            int size = pdfArray3.size();
            int number = pageOrigRef.getNumber();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    break;
                } else if (number == ((PRIndirectReference) pdfArray3.getPdfObject(i2)).getNumber()) {
                    pdfArray3.add(i2, addPdfObject);
                    break;
                } else {
                    i2++;
                }
            }
            if (size != pdfArray3.size()) {
                markUsed((PdfObject) pdfArray3);
                this.reader.pageRefs.insertPage(i, addPdfObject);
                correctAcroFieldPages(i);
                pRIndirectReference = pRIndirectReference2;
            } else {
                throw new RuntimeException("Internal inconsistence.");
            }
        }
        pdfDictionary2.put(PdfName.PARENT, pRIndirectReference);
        while (pdfDictionary != null) {
            markUsed((PdfObject) pdfDictionary);
            pdfDictionary.put(PdfName.COUNT, new PdfNumber(((PdfNumber) PdfReader.getPdfObjectRelease(pdfDictionary.get(PdfName.COUNT))).intValue() + 1));
            pdfDictionary = pdfDictionary.getAsDict(PdfName.PARENT);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isRotateContents() {
        return this.rotateContents;
    }

    /* access modifiers changed from: package-private */
    public void setRotateContents(boolean z) {
        this.rotateContents = z;
    }

    /* access modifiers changed from: package-private */
    public boolean isContentWritten() {
        return this.body.size() > 1;
    }

    /* access modifiers changed from: package-private */
    public AcroFields getAcroFields() {
        if (this.acroFields == null) {
            this.acroFields = new AcroFields(this.reader, this);
        }
        return this.acroFields;
    }

    /* access modifiers changed from: package-private */
    public void setFormFlattening(boolean z) {
        this.flat = z;
    }

    /* access modifiers changed from: package-private */
    public void setFreeTextFlattening(boolean z) {
        this.flatFreeText = z;
    }

    /* access modifiers changed from: package-private */
    public boolean partialFormFlattening(String str) {
        getAcroFields();
        if (this.acroFields.getXfa().isXfaPresent()) {
            throw new UnsupportedOperationException("Partial form flattening is not supported with XFA forms.");
        } else if (!this.acroFields.getFields().containsKey(str)) {
            return false;
        } else {
            this.partialFlattening.add(str);
            return true;
        }
    }

    /* JADX WARNING: type inference failed for: r10v8, types: [com.lowagie.text.pdf.PdfObject] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0193  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void flatFields() {
        /*
            r17 = this;
            r0 = r17
            boolean r1 = r0.append
            if (r1 != 0) goto L_0x028e
            r17.getAcroFields()
            com.lowagie.text.pdf.AcroFields r1 = r0.acroFields
            java.util.HashMap r1 = r1.getFields()
            boolean r2 = r0.fieldsAdded
            if (r2 == 0) goto L_0x0034
            java.util.HashSet r2 = r0.partialFlattening
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x0034
            java.util.Set r2 = r1.keySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x0023:
            boolean r3 = r2.hasNext()
            if (r3 != 0) goto L_0x002a
            goto L_0x0034
        L_0x002a:
            java.util.HashSet r3 = r0.partialFlattening
            java.lang.Object r4 = r2.next()
            r3.add(r4)
            goto L_0x0023
        L_0x0034:
            com.lowagie.text.pdf.PdfReader r2 = r0.reader
            com.lowagie.text.pdf.PdfDictionary r2 = r2.getCatalog()
            com.lowagie.text.pdf.PdfName r3 = com.lowagie.text.pdf.PdfName.ACROFORM
            com.lowagie.text.pdf.PdfDictionary r2 = r2.getAsDict(r3)
            if (r2 == 0) goto L_0x004f
            com.lowagie.text.pdf.PdfName r4 = com.lowagie.text.pdf.PdfName.FIELDS
            com.lowagie.text.pdf.PdfObject r4 = r2.get(r4)
            com.lowagie.text.pdf.PdfObject r2 = com.lowagie.text.pdf.PdfReader.getPdfObject(r4, r2)
            com.lowagie.text.pdf.PdfArray r2 = (com.lowagie.text.pdf.PdfArray) r2
            goto L_0x0050
        L_0x004f:
            r2 = 0
        L_0x0050:
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x0058:
            boolean r4 = r1.hasNext()
            r5 = 0
            r6 = 1
            if (r4 != 0) goto L_0x00d3
            boolean r1 = r0.fieldsAdded
            if (r1 != 0) goto L_0x00d2
            java.util.HashSet r1 = r0.partialFlattening
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x00d2
            r1 = 1
        L_0x006d:
            com.lowagie.text.pdf.PdfReader r2 = r0.reader
            int r2 = r2.getNumberOfPages()
            if (r1 <= r2) goto L_0x0079
            r17.eliminateAcroformObjects()
            goto L_0x00d2
        L_0x0079:
            com.lowagie.text.pdf.PdfReader r2 = r0.reader
            com.lowagie.text.pdf.PdfDictionary r2 = r2.getPageN(r1)
            com.lowagie.text.pdf.PdfName r3 = com.lowagie.text.pdf.PdfName.ANNOTS
            com.lowagie.text.pdf.PdfArray r3 = r2.getAsArray(r3)
            if (r3 != 0) goto L_0x0088
            goto L_0x00a3
        L_0x0088:
            r4 = 0
        L_0x0089:
            int r7 = r3.size()
            if (r4 < r7) goto L_0x00a6
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x00a3
            com.lowagie.text.pdf.PdfName r3 = com.lowagie.text.pdf.PdfName.ANNOTS
            com.lowagie.text.pdf.PdfObject r3 = r2.get(r3)
            com.lowagie.text.pdf.PdfReader.killIndirect(r3)
            com.lowagie.text.pdf.PdfName r3 = com.lowagie.text.pdf.PdfName.ANNOTS
            r2.remove(r3)
        L_0x00a3:
            int r1 = r1 + 1
            goto L_0x006d
        L_0x00a6:
            com.lowagie.text.pdf.PdfObject r7 = r3.getDirectObject(r4)
            boolean r8 = r7 instanceof com.lowagie.text.pdf.PdfIndirectReference
            if (r8 == 0) goto L_0x00b5
            boolean r8 = r7.isIndirect()
            if (r8 != 0) goto L_0x00b5
            goto L_0x00d0
        L_0x00b5:
            boolean r8 = r7.isDictionary()
            if (r8 == 0) goto L_0x00cb
            com.lowagie.text.pdf.PdfName r8 = com.lowagie.text.pdf.PdfName.WIDGET
            com.lowagie.text.pdf.PdfDictionary r7 = (com.lowagie.text.pdf.PdfDictionary) r7
            com.lowagie.text.pdf.PdfName r9 = com.lowagie.text.pdf.PdfName.SUBTYPE
            com.lowagie.text.pdf.PdfObject r7 = r7.get(r9)
            boolean r7 = r8.equals(r7)
            if (r7 == 0) goto L_0x00d0
        L_0x00cb:
            r3.remove(r4)
            int r4 = r4 + -1
        L_0x00d0:
            int r4 = r4 + r6
            goto L_0x0089
        L_0x00d2:
            return
        L_0x00d3:
            java.lang.Object r4 = r1.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r7 = r4.getKey()
            java.lang.String r7 = (java.lang.String) r7
            java.util.HashSet r8 = r0.partialFlattening
            boolean r8 = r8.isEmpty()
            if (r8 != 0) goto L_0x00f1
            java.util.HashSet r8 = r0.partialFlattening
            boolean r7 = r8.contains(r7)
            if (r7 != 0) goto L_0x00f1
            goto L_0x0058
        L_0x00f1:
            java.lang.Object r4 = r4.getValue()
            com.lowagie.text.pdf.AcroFields$Item r4 = (com.lowagie.text.pdf.AcroFields.Item) r4
            r7 = 0
        L_0x00f8:
            int r8 = r4.size()
            if (r7 < r8) goto L_0x0100
            goto L_0x0058
        L_0x0100:
            com.lowagie.text.pdf.PdfDictionary r8 = r4.getMerged(r7)
            com.lowagie.text.pdf.PdfName r9 = com.lowagie.text.pdf.PdfName.f673F
            com.lowagie.text.pdf.PdfNumber r9 = r8.getAsNumber(r9)
            if (r9 == 0) goto L_0x0111
            int r9 = r9.intValue()
            goto L_0x0112
        L_0x0111:
            r9 = 0
        L_0x0112:
            java.lang.Integer r10 = r4.getPage(r7)
            int r10 = r10.intValue()
            com.lowagie.text.pdf.PdfName r11 = com.lowagie.text.pdf.PdfName.f644AP
            com.lowagie.text.pdf.PdfDictionary r11 = r8.getAsDict(r11)
            if (r11 == 0) goto L_0x01b6
            r12 = r9 & 4
            if (r12 == 0) goto L_0x01b6
            r9 = r9 & 2
            if (r9 != 0) goto L_0x01b6
            com.lowagie.text.pdf.PdfName r9 = com.lowagie.text.pdf.PdfName.f696N
            com.lowagie.text.pdf.PdfObject r9 = r11.get(r9)
            if (r9 == 0) goto L_0x0190
            com.lowagie.text.pdf.PdfObject r11 = com.lowagie.text.pdf.PdfReader.getPdfObject((com.lowagie.text.pdf.PdfObject) r9)
            boolean r12 = r9 instanceof com.lowagie.text.pdf.PdfIndirectReference
            if (r12 == 0) goto L_0x0148
            boolean r12 = r9.isIndirect()
            if (r12 != 0) goto L_0x0148
            com.lowagie.text.pdf.PdfAppearance r11 = new com.lowagie.text.pdf.PdfAppearance
            com.lowagie.text.pdf.PdfIndirectReference r9 = (com.lowagie.text.pdf.PdfIndirectReference) r9
            r11.<init>((com.lowagie.text.pdf.PdfIndirectReference) r9)
            goto L_0x0191
        L_0x0148:
            boolean r12 = r11 instanceof com.lowagie.text.pdf.PdfStream
            if (r12 == 0) goto L_0x015d
            com.lowagie.text.pdf.PdfDictionary r11 = (com.lowagie.text.pdf.PdfDictionary) r11
            com.lowagie.text.pdf.PdfName r12 = com.lowagie.text.pdf.PdfName.SUBTYPE
            com.lowagie.text.pdf.PdfName r13 = com.lowagie.text.pdf.PdfName.FORM
            r11.put(r12, r13)
            com.lowagie.text.pdf.PdfAppearance r11 = new com.lowagie.text.pdf.PdfAppearance
            com.lowagie.text.pdf.PdfIndirectReference r9 = (com.lowagie.text.pdf.PdfIndirectReference) r9
            r11.<init>((com.lowagie.text.pdf.PdfIndirectReference) r9)
            goto L_0x0191
        L_0x015d:
            if (r11 == 0) goto L_0x0190
            boolean r9 = r11.isDictionary()
            if (r9 == 0) goto L_0x0190
            com.lowagie.text.pdf.PdfName r9 = com.lowagie.text.pdf.PdfName.f645AS
            com.lowagie.text.pdf.PdfName r9 = r8.getAsName(r9)
            if (r9 == 0) goto L_0x0190
            com.lowagie.text.pdf.PdfDictionary r11 = (com.lowagie.text.pdf.PdfDictionary) r11
            com.lowagie.text.pdf.PdfObject r9 = r11.get(r9)
            com.lowagie.text.pdf.PdfIndirectReference r9 = (com.lowagie.text.pdf.PdfIndirectReference) r9
            if (r9 == 0) goto L_0x0190
            com.lowagie.text.pdf.PdfAppearance r11 = new com.lowagie.text.pdf.PdfAppearance
            r11.<init>((com.lowagie.text.pdf.PdfIndirectReference) r9)
            boolean r12 = r9.isIndirect()
            if (r12 == 0) goto L_0x0191
            com.lowagie.text.pdf.PdfObject r9 = com.lowagie.text.pdf.PdfReader.getPdfObject((com.lowagie.text.pdf.PdfObject) r9)
            com.lowagie.text.pdf.PdfDictionary r9 = (com.lowagie.text.pdf.PdfDictionary) r9
            com.lowagie.text.pdf.PdfName r12 = com.lowagie.text.pdf.PdfName.SUBTYPE
            com.lowagie.text.pdf.PdfName r13 = com.lowagie.text.pdf.PdfName.FORM
            r9.put(r12, r13)
            goto L_0x0191
        L_0x0190:
            r11 = 0
        L_0x0191:
            if (r11 == 0) goto L_0x01b6
            com.lowagie.text.pdf.PdfName r9 = com.lowagie.text.pdf.PdfName.RECT
            com.lowagie.text.pdf.PdfArray r8 = r8.getAsArray(r9)
            com.lowagie.text.Rectangle r8 = com.lowagie.text.pdf.PdfReader.getNormalizedRectangle(r8)
            com.lowagie.text.pdf.PdfContentByte r9 = r0.getOverContent(r10)
            java.lang.String r12 = "Q "
            r9.setLiteral((java.lang.String) r12)
            float r12 = r8.getLeft()
            float r8 = r8.getBottom()
            r9.addTemplate(r11, r12, r8)
            java.lang.String r8 = "q "
            r9.setLiteral((java.lang.String) r8)
        L_0x01b6:
            java.util.HashSet r8 = r0.partialFlattening
            boolean r8 = r8.isEmpty()
            if (r8 == 0) goto L_0x01bf
            goto L_0x01e9
        L_0x01bf:
            com.lowagie.text.pdf.PdfReader r8 = r0.reader
            com.lowagie.text.pdf.PdfDictionary r8 = r8.getPageN(r10)
            com.lowagie.text.pdf.PdfName r9 = com.lowagie.text.pdf.PdfName.ANNOTS
            com.lowagie.text.pdf.PdfArray r9 = r8.getAsArray(r9)
            if (r9 != 0) goto L_0x01ce
            goto L_0x01e9
        L_0x01ce:
            r10 = 0
        L_0x01cf:
            int r11 = r9.size()
            if (r10 < r11) goto L_0x01ed
            boolean r9 = r9.isEmpty()
            if (r9 == 0) goto L_0x01e9
            com.lowagie.text.pdf.PdfName r9 = com.lowagie.text.pdf.PdfName.ANNOTS
            com.lowagie.text.pdf.PdfObject r9 = r8.get(r9)
            com.lowagie.text.pdf.PdfReader.killIndirect(r9)
            com.lowagie.text.pdf.PdfName r9 = com.lowagie.text.pdf.PdfName.ANNOTS
            r8.remove(r9)
        L_0x01e9:
            int r7 = r7 + 1
            goto L_0x00f8
        L_0x01ed:
            com.lowagie.text.pdf.PdfObject r11 = r9.getPdfObject(r10)
            boolean r12 = r11.isIndirect()
            if (r12 != 0) goto L_0x01f9
            goto L_0x028b
        L_0x01f9:
            com.lowagie.text.pdf.PdfIndirectReference r12 = r4.getWidgetRef(r7)
            boolean r13 = r12.isIndirect()
            if (r13 != 0) goto L_0x0205
            goto L_0x028b
        L_0x0205:
            com.lowagie.text.pdf.PRIndirectReference r11 = (com.lowagie.text.pdf.PRIndirectReference) r11
            int r11 = r11.getNumber()
            com.lowagie.text.pdf.PRIndirectReference r12 = (com.lowagie.text.pdf.PRIndirectReference) r12
            int r13 = r12.getNumber()
            if (r11 != r13) goto L_0x028b
            int r11 = r10 + -1
            r9.remove(r10)
        L_0x0218:
            com.lowagie.text.pdf.PdfObject r10 = com.lowagie.text.pdf.PdfReader.getPdfObject((com.lowagie.text.pdf.PdfObject) r12)
            com.lowagie.text.pdf.PdfDictionary r10 = (com.lowagie.text.pdf.PdfDictionary) r10
            com.lowagie.text.pdf.PdfName r13 = com.lowagie.text.pdf.PdfName.PARENT
            com.lowagie.text.pdf.PdfObject r10 = r10.get(r13)
            r13 = r10
            com.lowagie.text.pdf.PRIndirectReference r13 = (com.lowagie.text.pdf.PRIndirectReference) r13
            com.lowagie.text.pdf.PdfReader.killIndirect(r12)
            if (r13 != 0) goto L_0x0251
            r10 = 0
        L_0x022d:
            int r13 = r2.size()
            if (r10 < r13) goto L_0x0234
            goto L_0x026a
        L_0x0234:
            com.lowagie.text.pdf.PdfObject r13 = r2.getPdfObject(r10)
            boolean r14 = r13.isIndirect()
            if (r14 == 0) goto L_0x024f
            com.lowagie.text.pdf.PRIndirectReference r13 = (com.lowagie.text.pdf.PRIndirectReference) r13
            int r13 = r13.getNumber()
            int r14 = r12.getNumber()
            if (r13 != r14) goto L_0x024f
            r2.remove(r10)
            int r10 = r10 + -1
        L_0x024f:
            int r10 = r10 + r6
            goto L_0x022d
        L_0x0251:
            com.lowagie.text.pdf.PdfObject r10 = com.lowagie.text.pdf.PdfReader.getPdfObject((com.lowagie.text.pdf.PdfObject) r13)
            com.lowagie.text.pdf.PdfDictionary r10 = (com.lowagie.text.pdf.PdfDictionary) r10
            com.lowagie.text.pdf.PdfName r14 = com.lowagie.text.pdf.PdfName.KIDS
            com.lowagie.text.pdf.PdfArray r14 = r10.getAsArray(r14)
            r10 = 0
        L_0x025e:
            int r15 = r14.size()
            if (r10 < r15) goto L_0x026e
            boolean r10 = r14.isEmpty()
            if (r10 != 0) goto L_0x026c
        L_0x026a:
            r10 = r11
            goto L_0x028b
        L_0x026c:
            r12 = r13
            goto L_0x0218
        L_0x026e:
            com.lowagie.text.pdf.PdfObject r15 = r14.getPdfObject(r10)
            boolean r16 = r15.isIndirect()
            if (r16 == 0) goto L_0x0289
            com.lowagie.text.pdf.PRIndirectReference r15 = (com.lowagie.text.pdf.PRIndirectReference) r15
            int r15 = r15.getNumber()
            int r3 = r12.getNumber()
            if (r15 != r3) goto L_0x0289
            r14.remove(r10)
            int r10 = r10 + -1
        L_0x0289:
            int r10 = r10 + r6
            goto L_0x025e
        L_0x028b:
            int r10 = r10 + r6
            goto L_0x01cf
        L_0x028e:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Field flattening is not supported in append mode."
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.PdfStamperImp.flatFields():void");
    }

    /* access modifiers changed from: package-private */
    public void eliminateAcroformObjects() {
        PdfObject pdfObject = this.reader.getCatalog().get(PdfName.ACROFORM);
        if (pdfObject != null) {
            PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.getPdfObject(pdfObject);
            this.reader.killXref(pdfDictionary.get(PdfName.XFA));
            pdfDictionary.remove(PdfName.XFA);
            PdfObject pdfObject2 = pdfDictionary.get(PdfName.FIELDS);
            if (pdfObject2 != null) {
                PdfDictionary pdfDictionary2 = new PdfDictionary();
                pdfDictionary2.put(PdfName.KIDS, pdfObject2);
                sweepKids(pdfDictionary2);
                PdfReader.killIndirect(pdfObject2);
                pdfDictionary.put(PdfName.FIELDS, new PdfArray());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void sweepKids(PdfObject pdfObject) {
        PdfArray pdfArray;
        PdfObject killIndirect = PdfReader.killIndirect(pdfObject);
        if (killIndirect != null && killIndirect.isDictionary() && (pdfArray = (PdfArray) PdfReader.killIndirect(((PdfDictionary) killIndirect).get(PdfName.KIDS))) != null) {
            for (int i = 0; i < pdfArray.size(); i++) {
                sweepKids(pdfArray.getPdfObject(i));
            }
        }
    }

    private void flatFreeTextFields() {
        PdfObject pdfObject;
        PdfName asName;
        PdfIndirectReference pdfIndirectReference;
        if (!this.append) {
            for (int i = 1; i <= this.reader.getNumberOfPages(); i++) {
                PdfDictionary pageN = this.reader.getPageN(i);
                PdfArray asArray = pageN.getAsArray(PdfName.ANNOTS);
                if (asArray != null) {
                    int i2 = 0;
                    for (int i3 = 0; i3 < asArray.size(); i3++) {
                        PdfObject directObject = asArray.getDirectObject(i3);
                        if (!(directObject instanceof PdfIndirectReference) || directObject.isIndirect()) {
                            PdfDictionary pdfDictionary = (PdfDictionary) directObject;
                            if (((PdfName) pdfDictionary.get(PdfName.SUBTYPE)).equals(PdfName.FREETEXT)) {
                                PdfNumber asNumber = pdfDictionary.getAsNumber(PdfName.f673F);
                                int intValue = asNumber != null ? asNumber.intValue() : 0;
                                if (!((intValue & 4) == 0 || (intValue & 2) != 0 || (pdfObject = pdfDictionary.get(PdfName.f644AP)) == null)) {
                                    if (pdfObject instanceof PdfIndirectReference) {
                                        pdfObject = PdfReader.getPdfObject(pdfObject);
                                    }
                                    PdfDictionary pdfDictionary2 = (PdfDictionary) pdfObject;
                                    PdfObject pdfObject2 = pdfDictionary2.get(PdfName.f696N);
                                    PdfAppearance pdfAppearance = null;
                                    PdfObject pdfObject3 = PdfReader.getPdfObject(pdfObject2);
                                    if ((pdfObject2 instanceof PdfIndirectReference) && !pdfObject2.isIndirect()) {
                                        pdfAppearance = new PdfAppearance((PdfIndirectReference) pdfObject2);
                                    } else if (pdfObject3 instanceof PdfStream) {
                                        ((PdfDictionary) pdfObject3).put(PdfName.SUBTYPE, PdfName.FORM);
                                        pdfAppearance = new PdfAppearance((PdfIndirectReference) pdfObject2);
                                    } else if (!(!pdfObject3.isDictionary() || (asName = pdfDictionary2.getAsName(PdfName.f645AS)) == null || (pdfIndirectReference = (PdfIndirectReference) ((PdfDictionary) pdfObject3).get(asName)) == null)) {
                                        pdfAppearance = new PdfAppearance(pdfIndirectReference);
                                        if (pdfIndirectReference.isIndirect()) {
                                            ((PdfDictionary) PdfReader.getPdfObject((PdfObject) pdfIndirectReference)).put(PdfName.SUBTYPE, PdfName.FORM);
                                        }
                                    }
                                    if (pdfAppearance != null) {
                                        Rectangle normalizedRectangle = PdfReader.getNormalizedRectangle(pdfDictionary.getAsArray(PdfName.RECT));
                                        PdfContentByte overContent = getOverContent(i);
                                        overContent.setLiteral("Q ");
                                        overContent.addTemplate(pdfAppearance, normalizedRectangle.getLeft(), normalizedRectangle.getBottom());
                                        overContent.setLiteral("q ");
                                    }
                                }
                            }
                        }
                    }
                    while (i2 < asArray.size()) {
                        PdfDictionary asDict = asArray.getAsDict(i2);
                        if (asDict != null && PdfName.FREETEXT.equals(asDict.get(PdfName.SUBTYPE))) {
                            asArray.remove(i2);
                            i2--;
                        }
                        i2++;
                    }
                    if (asArray.isEmpty()) {
                        PdfReader.killIndirect(pageN.get(PdfName.ANNOTS));
                        pageN.remove(PdfName.ANNOTS);
                    }
                }
            }
            return;
        }
        throw new IllegalArgumentException("FreeText flattening is not supported in append mode.");
    }

    public PdfIndirectReference getPageReference(int i) {
        PRIndirectReference pageOrigRef = this.reader.getPageOrigRef(i);
        if (pageOrigRef != null) {
            return pageOrigRef;
        }
        throw new IllegalArgumentException("Invalid page number " + i);
    }

    public void addAnnotation(PdfAnnotation pdfAnnotation) {
        throw new RuntimeException("Unsupported in this context. Use PdfStamper.addAnnotation()");
    }

    /* access modifiers changed from: package-private */
    public void addDocumentField(PdfIndirectReference pdfIndirectReference) {
        PdfDictionary catalog = this.reader.getCatalog();
        PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.getPdfObject(catalog.get(PdfName.ACROFORM), catalog);
        if (pdfDictionary == null) {
            pdfDictionary = new PdfDictionary();
            catalog.put(PdfName.ACROFORM, pdfDictionary);
            markUsed((PdfObject) catalog);
        }
        PdfArray pdfArray = (PdfArray) PdfReader.getPdfObject(pdfDictionary.get(PdfName.FIELDS), pdfDictionary);
        if (pdfArray == null) {
            pdfArray = new PdfArray();
            pdfDictionary.put(PdfName.FIELDS, pdfArray);
            markUsed((PdfObject) pdfDictionary);
        }
        if (!pdfDictionary.contains(PdfName.f662DA)) {
            pdfDictionary.put(PdfName.f662DA, new PdfString("/Helv 0 Tf 0 g "));
            markUsed((PdfObject) pdfDictionary);
        }
        pdfArray.add((PdfObject) pdfIndirectReference);
        markUsed((PdfObject) pdfArray);
    }

    /* access modifiers changed from: package-private */
    public void addFieldResources() throws IOException {
        if (!this.fieldTemplates.isEmpty()) {
            PdfDictionary catalog = this.reader.getCatalog();
            PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.getPdfObject(catalog.get(PdfName.ACROFORM), catalog);
            if (pdfDictionary == null) {
                pdfDictionary = new PdfDictionary();
                catalog.put(PdfName.ACROFORM, pdfDictionary);
                markUsed((PdfObject) catalog);
            }
            PdfDictionary pdfDictionary2 = (PdfDictionary) PdfReader.getPdfObject(pdfDictionary.get(PdfName.f667DR), pdfDictionary);
            if (pdfDictionary2 == null) {
                pdfDictionary2 = new PdfDictionary();
                pdfDictionary.put(PdfName.f667DR, pdfDictionary2);
                markUsed((PdfObject) pdfDictionary);
            }
            markUsed((PdfObject) pdfDictionary2);
            for (PdfTemplate resources : this.fieldTemplates.keySet()) {
                PdfFormField.mergeResources(pdfDictionary2, (PdfDictionary) resources.getResources(), this);
            }
            PdfDictionary asDict = pdfDictionary2.getAsDict(PdfName.FONT);
            if (asDict == null) {
                asDict = new PdfDictionary();
                pdfDictionary2.put(PdfName.FONT, asDict);
            }
            if (!asDict.contains(PdfName.HELV)) {
                PdfDictionary pdfDictionary3 = new PdfDictionary(PdfName.FONT);
                pdfDictionary3.put(PdfName.BASEFONT, PdfName.HELVETICA);
                pdfDictionary3.put(PdfName.ENCODING, PdfName.WIN_ANSI_ENCODING);
                pdfDictionary3.put(PdfName.NAME, PdfName.HELV);
                pdfDictionary3.put(PdfName.SUBTYPE, PdfName.TYPE1);
                asDict.put(PdfName.HELV, addToBody(pdfDictionary3).getIndirectReference());
            }
            if (!asDict.contains(PdfName.ZADB)) {
                PdfDictionary pdfDictionary4 = new PdfDictionary(PdfName.FONT);
                pdfDictionary4.put(PdfName.BASEFONT, PdfName.ZAPFDINGBATS);
                pdfDictionary4.put(PdfName.NAME, PdfName.ZADB);
                pdfDictionary4.put(PdfName.SUBTYPE, PdfName.TYPE1);
                asDict.put(PdfName.ZADB, addToBody(pdfDictionary4).getIndirectReference());
            }
            if (pdfDictionary.get(PdfName.f662DA) == null) {
                pdfDictionary.put(PdfName.f662DA, new PdfString("/Helv 0 Tf 0 g "));
                markUsed((PdfObject) pdfDictionary);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void expandFields(PdfFormField pdfFormField, ArrayList arrayList) {
        arrayList.add(pdfFormField);
        ArrayList kids = pdfFormField.getKids();
        if (kids != null) {
            for (int i = 0; i < kids.size(); i++) {
                expandFields((PdfFormField) kids.get(i), arrayList);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00da A[Catch:{ IOException -> 0x016f }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0137 A[Catch:{ IOException -> 0x016f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void addAnnotation(com.lowagie.text.pdf.PdfAnnotation r11, com.lowagie.text.pdf.PdfDictionary r12) {
        /*
            r10 = this;
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ IOException -> 0x016f }
            r0.<init>()     // Catch:{ IOException -> 0x016f }
            boolean r1 = r11.isForm()     // Catch:{ IOException -> 0x016f }
            if (r1 == 0) goto L_0x001e
            r1 = 1
            r10.fieldsAdded = r1     // Catch:{ IOException -> 0x016f }
            r10.getAcroFields()     // Catch:{ IOException -> 0x016f }
            com.lowagie.text.pdf.PdfFormField r11 = (com.lowagie.text.pdf.PdfFormField) r11     // Catch:{ IOException -> 0x016f }
            com.lowagie.text.pdf.PdfFormField r1 = r11.getParent()     // Catch:{ IOException -> 0x016f }
            if (r1 == 0) goto L_0x001a
            return
        L_0x001a:
            r10.expandFields(r11, r0)     // Catch:{ IOException -> 0x016f }
            goto L_0x0021
        L_0x001e:
            r0.add(r11)     // Catch:{ IOException -> 0x016f }
        L_0x0021:
            r11 = 0
        L_0x0022:
            int r1 = r0.size()     // Catch:{ IOException -> 0x016f }
            if (r11 < r1) goto L_0x0029
            return
        L_0x0029:
            java.lang.Object r1 = r0.get(r11)     // Catch:{ IOException -> 0x016f }
            com.lowagie.text.pdf.PdfAnnotation r1 = (com.lowagie.text.pdf.PdfAnnotation) r1     // Catch:{ IOException -> 0x016f }
            int r2 = r1.getPlaceInPage()     // Catch:{ IOException -> 0x016f }
            if (r2 <= 0) goto L_0x003f
            com.lowagie.text.pdf.PdfReader r12 = r10.reader     // Catch:{ IOException -> 0x016f }
            int r2 = r1.getPlaceInPage()     // Catch:{ IOException -> 0x016f }
            com.lowagie.text.pdf.PdfDictionary r12 = r12.getPageN(r2)     // Catch:{ IOException -> 0x016f }
        L_0x003f:
            boolean r2 = r1.isForm()     // Catch:{ IOException -> 0x016f }
            if (r2 == 0) goto L_0x0066
            boolean r2 = r1.isUsed()     // Catch:{ IOException -> 0x016f }
            if (r2 != 0) goto L_0x0056
            java.util.HashMap r2 = r1.getTemplates()     // Catch:{ IOException -> 0x016f }
            if (r2 == 0) goto L_0x0056
            java.util.HashMap r3 = r10.fieldTemplates     // Catch:{ IOException -> 0x016f }
            r3.putAll(r2)     // Catch:{ IOException -> 0x016f }
        L_0x0056:
            r2 = r1
            com.lowagie.text.pdf.PdfFormField r2 = (com.lowagie.text.pdf.PdfFormField) r2     // Catch:{ IOException -> 0x016f }
            com.lowagie.text.pdf.PdfFormField r3 = r2.getParent()     // Catch:{ IOException -> 0x016f }
            if (r3 != 0) goto L_0x0066
            com.lowagie.text.pdf.PdfIndirectReference r2 = r2.getIndirectReference()     // Catch:{ IOException -> 0x016f }
            r10.addDocumentField(r2)     // Catch:{ IOException -> 0x016f }
        L_0x0066:
            boolean r2 = r1.isAnnotation()     // Catch:{ IOException -> 0x016f }
            if (r2 == 0) goto L_0x015b
            com.lowagie.text.pdf.PdfName r2 = com.lowagie.text.pdf.PdfName.ANNOTS     // Catch:{ IOException -> 0x016f }
            com.lowagie.text.pdf.PdfObject r2 = r12.get(r2)     // Catch:{ IOException -> 0x016f }
            com.lowagie.text.pdf.PdfObject r2 = com.lowagie.text.pdf.PdfReader.getPdfObject(r2, r12)     // Catch:{ IOException -> 0x016f }
            if (r2 == 0) goto L_0x0082
            boolean r3 = r2.isArray()     // Catch:{ IOException -> 0x016f }
            if (r3 != 0) goto L_0x007f
            goto L_0x0082
        L_0x007f:
            com.lowagie.text.pdf.PdfArray r2 = (com.lowagie.text.pdf.PdfArray) r2     // Catch:{ IOException -> 0x016f }
            goto L_0x008f
        L_0x0082:
            com.lowagie.text.pdf.PdfArray r2 = new com.lowagie.text.pdf.PdfArray     // Catch:{ IOException -> 0x016f }
            r2.<init>()     // Catch:{ IOException -> 0x016f }
            com.lowagie.text.pdf.PdfName r3 = com.lowagie.text.pdf.PdfName.ANNOTS     // Catch:{ IOException -> 0x016f }
            r12.put(r3, r2)     // Catch:{ IOException -> 0x016f }
            r10.markUsed((com.lowagie.text.pdf.PdfObject) r12)     // Catch:{ IOException -> 0x016f }
        L_0x008f:
            com.lowagie.text.pdf.PdfIndirectReference r3 = r1.getIndirectReference()     // Catch:{ IOException -> 0x016f }
            r2.add((com.lowagie.text.pdf.PdfObject) r3)     // Catch:{ IOException -> 0x016f }
            r10.markUsed((com.lowagie.text.pdf.PdfObject) r2)     // Catch:{ IOException -> 0x016f }
            boolean r2 = r1.isUsed()     // Catch:{ IOException -> 0x016f }
            if (r2 != 0) goto L_0x015b
            com.lowagie.text.pdf.PdfName r2 = com.lowagie.text.pdf.PdfName.RECT     // Catch:{ IOException -> 0x016f }
            com.lowagie.text.pdf.PdfObject r2 = r1.get(r2)     // Catch:{ IOException -> 0x016f }
            com.lowagie.text.pdf.PdfRectangle r2 = (com.lowagie.text.pdf.PdfRectangle) r2     // Catch:{ IOException -> 0x016f }
            if (r2 == 0) goto L_0x015b
            float r3 = r2.left()     // Catch:{ IOException -> 0x016f }
            r4 = 0
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 != 0) goto L_0x00ca
            float r3 = r2.right()     // Catch:{ IOException -> 0x016f }
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 != 0) goto L_0x00ca
            float r3 = r2.top()     // Catch:{ IOException -> 0x016f }
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 != 0) goto L_0x00ca
            float r3 = r2.bottom()     // Catch:{ IOException -> 0x016f }
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 == 0) goto L_0x015b
        L_0x00ca:
            com.lowagie.text.pdf.PdfReader r3 = r10.reader     // Catch:{ IOException -> 0x016f }
            int r3 = r3.getPageRotation((com.lowagie.text.pdf.PdfDictionary) r12)     // Catch:{ IOException -> 0x016f }
            com.lowagie.text.pdf.PdfReader r4 = r10.reader     // Catch:{ IOException -> 0x016f }
            com.lowagie.text.Rectangle r4 = r4.getPageSizeWithRotation((com.lowagie.text.pdf.PdfDictionary) r12)     // Catch:{ IOException -> 0x016f }
            r5 = 90
            if (r3 == r5) goto L_0x0137
            r5 = 180(0xb4, float:2.52E-43)
            if (r3 == r5) goto L_0x0108
            r5 = 270(0x10e, float:3.78E-43)
            if (r3 == r5) goto L_0x00e3
            goto L_0x015b
        L_0x00e3:
            com.lowagie.text.pdf.PdfName r3 = com.lowagie.text.pdf.PdfName.RECT     // Catch:{ IOException -> 0x016f }
            com.lowagie.text.pdf.PdfRectangle r5 = new com.lowagie.text.pdf.PdfRectangle     // Catch:{ IOException -> 0x016f }
            float r6 = r2.bottom()     // Catch:{ IOException -> 0x016f }
            float r7 = r4.getRight()     // Catch:{ IOException -> 0x016f }
            float r8 = r2.left()     // Catch:{ IOException -> 0x016f }
            float r7 = r7 - r8
            float r8 = r2.top()     // Catch:{ IOException -> 0x016f }
            float r4 = r4.getRight()     // Catch:{ IOException -> 0x016f }
            float r2 = r2.right()     // Catch:{ IOException -> 0x016f }
            float r4 = r4 - r2
            r5.<init>(r6, r7, r8, r4)     // Catch:{ IOException -> 0x016f }
            r1.put(r3, r5)     // Catch:{ IOException -> 0x016f }
            goto L_0x015b
        L_0x0108:
            com.lowagie.text.pdf.PdfName r3 = com.lowagie.text.pdf.PdfName.RECT     // Catch:{ IOException -> 0x016f }
            com.lowagie.text.pdf.PdfRectangle r5 = new com.lowagie.text.pdf.PdfRectangle     // Catch:{ IOException -> 0x016f }
            float r6 = r4.getRight()     // Catch:{ IOException -> 0x016f }
            float r7 = r2.left()     // Catch:{ IOException -> 0x016f }
            float r6 = r6 - r7
            float r7 = r4.getTop()     // Catch:{ IOException -> 0x016f }
            float r8 = r2.bottom()     // Catch:{ IOException -> 0x016f }
            float r7 = r7 - r8
            float r8 = r4.getRight()     // Catch:{ IOException -> 0x016f }
            float r9 = r2.right()     // Catch:{ IOException -> 0x016f }
            float r8 = r8 - r9
            float r4 = r4.getTop()     // Catch:{ IOException -> 0x016f }
            float r2 = r2.top()     // Catch:{ IOException -> 0x016f }
            float r4 = r4 - r2
            r5.<init>(r6, r7, r8, r4)     // Catch:{ IOException -> 0x016f }
            r1.put(r3, r5)     // Catch:{ IOException -> 0x016f }
            goto L_0x015b
        L_0x0137:
            com.lowagie.text.pdf.PdfName r3 = com.lowagie.text.pdf.PdfName.RECT     // Catch:{ IOException -> 0x016f }
            com.lowagie.text.pdf.PdfRectangle r5 = new com.lowagie.text.pdf.PdfRectangle     // Catch:{ IOException -> 0x016f }
            float r6 = r4.getTop()     // Catch:{ IOException -> 0x016f }
            float r7 = r2.bottom()     // Catch:{ IOException -> 0x016f }
            float r6 = r6 - r7
            float r7 = r2.left()     // Catch:{ IOException -> 0x016f }
            float r4 = r4.getTop()     // Catch:{ IOException -> 0x016f }
            float r8 = r2.top()     // Catch:{ IOException -> 0x016f }
            float r4 = r4 - r8
            float r2 = r2.right()     // Catch:{ IOException -> 0x016f }
            r5.<init>(r6, r7, r4, r2)     // Catch:{ IOException -> 0x016f }
            r1.put(r3, r5)     // Catch:{ IOException -> 0x016f }
        L_0x015b:
            boolean r2 = r1.isUsed()     // Catch:{ IOException -> 0x016f }
            if (r2 != 0) goto L_0x016b
            r1.setUsed()     // Catch:{ IOException -> 0x016f }
            com.lowagie.text.pdf.PdfIndirectReference r2 = r1.getIndirectReference()     // Catch:{ IOException -> 0x016f }
            r10.addToBody((com.lowagie.text.pdf.PdfObject) r1, (com.lowagie.text.pdf.PdfIndirectReference) r2)     // Catch:{ IOException -> 0x016f }
        L_0x016b:
            int r11 = r11 + 1
            goto L_0x0022
        L_0x016f:
            r11 = move-exception
            com.lowagie.text.ExceptionConverter r12 = new com.lowagie.text.ExceptionConverter
            r12.<init>(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.PdfStamperImp.addAnnotation(com.lowagie.text.pdf.PdfAnnotation, com.lowagie.text.pdf.PdfDictionary):void");
    }

    /* access modifiers changed from: package-private */
    public void addAnnotation(PdfAnnotation pdfAnnotation, int i) {
        pdfAnnotation.setPage(i);
        addAnnotation(pdfAnnotation, this.reader.getPageN(i));
    }

    private void outlineTravel(PRIndirectReference pRIndirectReference) {
        while (pRIndirectReference != null) {
            PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.getPdfObjectRelease((PdfObject) pRIndirectReference);
            PRIndirectReference pRIndirectReference2 = (PRIndirectReference) pdfDictionary.get(PdfName.FIRST);
            if (pRIndirectReference2 != null) {
                outlineTravel(pRIndirectReference2);
            }
            PdfReader.killIndirect(pdfDictionary.get(PdfName.DEST));
            PdfReader.killIndirect(pdfDictionary.get(PdfName.f641A));
            PdfReader.killIndirect(pRIndirectReference);
            pRIndirectReference = (PRIndirectReference) pdfDictionary.get(PdfName.NEXT);
        }
    }

    /* access modifiers changed from: package-private */
    public void deleteOutlines() {
        PdfDictionary catalog = this.reader.getCatalog();
        PRIndirectReference pRIndirectReference = (PRIndirectReference) catalog.get(PdfName.OUTLINES);
        if (pRIndirectReference != null) {
            outlineTravel(pRIndirectReference);
            PdfReader.killIndirect(pRIndirectReference);
            catalog.remove(PdfName.OUTLINES);
            markUsed((PdfObject) catalog);
        }
    }

    /* access modifiers changed from: package-private */
    public void setJavaScript() throws IOException {
        HashMap documentLevelJS = this.pdf.getDocumentLevelJS();
        if (!documentLevelJS.isEmpty()) {
            PdfDictionary catalog = this.reader.getCatalog();
            PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.getPdfObject(catalog.get(PdfName.NAMES), catalog);
            if (pdfDictionary == null) {
                pdfDictionary = new PdfDictionary();
                catalog.put(PdfName.NAMES, pdfDictionary);
                markUsed((PdfObject) catalog);
            }
            markUsed((PdfObject) pdfDictionary);
            pdfDictionary.put(PdfName.JAVASCRIPT, addToBody(PdfNameTree.writeTree(documentLevelJS, this)).getIndirectReference());
        }
    }

    /* access modifiers changed from: package-private */
    public void addFileAttachments() throws IOException {
        HashMap documentFileAttachment = this.pdf.getDocumentFileAttachment();
        if (!documentFileAttachment.isEmpty()) {
            PdfDictionary catalog = this.reader.getCatalog();
            PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.getPdfObject(catalog.get(PdfName.NAMES), catalog);
            if (pdfDictionary == null) {
                pdfDictionary = new PdfDictionary();
                catalog.put(PdfName.NAMES, pdfDictionary);
                markUsed((PdfObject) catalog);
            }
            markUsed((PdfObject) pdfDictionary);
            HashMap readTree = PdfNameTree.readTree((PdfDictionary) PdfReader.getPdfObjectRelease(pdfDictionary.get(PdfName.EMBEDDEDFILES)));
            for (Map.Entry entry : documentFileAttachment.entrySet()) {
                String str = (String) entry.getKey();
                int i = 0;
                while (readTree.containsKey(str)) {
                    i++;
                    str = String.valueOf(str) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + i;
                }
                readTree.put(str, entry.getValue());
            }
            pdfDictionary.put(PdfName.EMBEDDEDFILES, addToBody(PdfNameTree.writeTree(readTree, this)).getIndirectReference());
        }
    }

    /* access modifiers changed from: package-private */
    public void makePackage(PdfCollection pdfCollection) {
        this.reader.getCatalog().put(PdfName.COLLECTION, pdfCollection);
    }

    /* access modifiers changed from: package-private */
    public void setOutlines() throws IOException {
        if (this.newBookmarks != null) {
            deleteOutlines();
            if (!this.newBookmarks.isEmpty()) {
                PdfDictionary catalog = this.reader.getCatalog();
                writeOutlines(catalog, catalog.get(PdfName.DESTS) != null);
                markUsed((PdfObject) catalog);
            }
        }
    }

    public void setViewerPreferences(int i) {
        this.useVp = true;
        this.viewerPreferences.setViewerPreferences(i);
    }

    public void addViewerPreference(PdfName pdfName, PdfObject pdfObject) {
        this.useVp = true;
        this.viewerPreferences.addViewerPreference(pdfName, pdfObject);
    }

    public void setSigFlags(int i) {
        this.sigFlags = i | this.sigFlags;
    }

    public void setPageAction(PdfName pdfName, PdfAction pdfAction) throws PdfException {
        throw new UnsupportedOperationException("Use setPageAction(PdfName actionType, PdfAction action, int page)");
    }

    /* access modifiers changed from: package-private */
    public void setPageAction(PdfName pdfName, PdfAction pdfAction, int i) throws PdfException {
        if (pdfName.equals(PAGE_OPEN) || pdfName.equals(PAGE_CLOSE)) {
            PdfDictionary pageN = this.reader.getPageN(i);
            PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.getPdfObject(pageN.get(PdfName.f642AA), pageN);
            if (pdfDictionary == null) {
                pdfDictionary = new PdfDictionary();
                pageN.put(PdfName.f642AA, pdfDictionary);
                markUsed((PdfObject) pageN);
            }
            pdfDictionary.put(pdfName, pdfAction);
            markUsed((PdfObject) pdfDictionary);
            return;
        }
        throw new PdfException("Invalid page additional action type: " + pdfName.toString());
    }

    public void setDuration(int i) {
        throw new UnsupportedOperationException("Use setPageAction(PdfName actionType, PdfAction action, int page)");
    }

    public void setTransition(PdfTransition pdfTransition) {
        throw new UnsupportedOperationException("Use setPageAction(PdfName actionType, PdfAction action, int page)");
    }

    /* access modifiers changed from: package-private */
    public void setDuration(int i, int i2) {
        PdfDictionary pageN = this.reader.getPageN(i2);
        if (i < 0) {
            pageN.remove(PdfName.DUR);
        } else {
            pageN.put(PdfName.DUR, new PdfNumber(i));
        }
        markUsed((PdfObject) pageN);
    }

    /* access modifiers changed from: package-private */
    public void setTransition(PdfTransition pdfTransition, int i) {
        PdfDictionary pageN = this.reader.getPageN(i);
        if (pdfTransition == null) {
            pageN.remove(PdfName.TRANS);
        } else {
            pageN.put(PdfName.TRANS, pdfTransition.getTransitionDictionary());
        }
        markUsed((PdfObject) pageN);
    }

    /* access modifiers changed from: protected */
    public void markUsed(PdfObject pdfObject) {
        PRIndirectReference pRIndirectReference;
        if (this.append && pdfObject != null) {
            if (pdfObject.type() == 10) {
                pRIndirectReference = (PRIndirectReference) pdfObject;
            } else {
                pRIndirectReference = pdfObject.getIndRef();
            }
            if (pRIndirectReference != null) {
                this.marked.put(pRIndirectReference.getNumber(), 1);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void markUsed(int i) {
        if (this.append) {
            this.marked.put(i, 1);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isAppend() {
        return this.append;
    }

    public void setAdditionalAction(PdfName pdfName, PdfAction pdfAction) throws PdfException {
        if (pdfName.equals(DOCUMENT_CLOSE) || pdfName.equals(WILL_SAVE) || pdfName.equals(DID_SAVE) || pdfName.equals(WILL_PRINT) || pdfName.equals(DID_PRINT)) {
            PdfDictionary asDict = this.reader.getCatalog().getAsDict(PdfName.f642AA);
            if (asDict == null) {
                if (pdfAction != null) {
                    asDict = new PdfDictionary();
                    this.reader.getCatalog().put(PdfName.f642AA, asDict);
                } else {
                    return;
                }
            }
            markUsed((PdfObject) asDict);
            if (pdfAction == null) {
                asDict.remove(pdfName);
            } else {
                asDict.put(pdfName, pdfAction);
            }
        } else {
            throw new PdfException("Invalid additional action type: " + pdfName.toString());
        }
    }

    public void setOpenAction(PdfAction pdfAction) {
        this.openAction = pdfAction;
    }

    public void setOpenAction(String str) {
        throw new UnsupportedOperationException("Open actions by name are not supported.");
    }

    public void setThumbnail(Image image) {
        throw new UnsupportedOperationException("Use PdfStamper.setThumbnail().");
    }

    /* access modifiers changed from: package-private */
    public void setThumbnail(Image image, int i) throws PdfException, DocumentException {
        PdfIndirectReference imageReference = getImageReference(addDirectImageSimple(image));
        this.reader.resetReleasePage();
        this.reader.getPageN(i).put(PdfName.THUMB, imageReference);
        this.reader.resetReleasePage();
    }

    public PdfContentByte getDirectContentUnder() {
        throw new UnsupportedOperationException("Use PdfStamper.getUnderContent() or PdfStamper.getOverContent()");
    }

    public PdfContentByte getDirectContent() {
        throw new UnsupportedOperationException("Use PdfStamper.getUnderContent() or PdfStamper.getOverContent()");
    }

    /* access modifiers changed from: protected */
    public void readOCProperties() {
        PdfDictionary asDict;
        if (this.documentOCG.isEmpty() && (asDict = this.reader.getCatalog().getAsDict(PdfName.OCPROPERTIES)) != null) {
            PdfArray asArray = asDict.getAsArray(PdfName.OCGS);
            HashMap hashMap = new HashMap();
            ListIterator listIterator = asArray.listIterator();
            while (listIterator.hasNext()) {
                PdfIndirectReference pdfIndirectReference = (PdfIndirectReference) listIterator.next();
                PdfLayer pdfLayer = new PdfLayer((String) null);
                pdfLayer.setRef(pdfIndirectReference);
                pdfLayer.setOnPanel(false);
                pdfLayer.merge((PdfDictionary) PdfReader.getPdfObject((PdfObject) pdfIndirectReference));
                hashMap.put(pdfIndirectReference.toString(), pdfLayer);
            }
            PdfDictionary asDict2 = asDict.getAsDict(PdfName.f661D);
            PdfArray asArray2 = asDict2.getAsArray(PdfName.OFF);
            if (asArray2 != null) {
                ListIterator listIterator2 = asArray2.listIterator();
                while (listIterator2.hasNext()) {
                    ((PdfLayer) hashMap.get(((PdfIndirectReference) listIterator2.next()).toString())).setOn(false);
                }
            }
            PdfArray asArray3 = asDict2.getAsArray(PdfName.ORDER);
            if (asArray3 != null) {
                addOrder((PdfLayer) null, asArray3, hashMap);
            }
            this.documentOCG.addAll(hashMap.values());
            this.OCGRadioGroup = asDict2.getAsArray(PdfName.RBGROUPS);
            this.OCGLocked = asDict2.getAsArray(PdfName.LOCKED);
            if (this.OCGLocked == null) {
                this.OCGLocked = new PdfArray();
            }
        }
    }

    private void addOrder(PdfLayer pdfLayer, PdfArray pdfArray, Map map) {
        int i = 0;
        while (i < pdfArray.size()) {
            PdfObject pdfObject = pdfArray.getPdfObject(i);
            if (pdfObject.isIndirect()) {
                PdfLayer pdfLayer2 = (PdfLayer) map.get(pdfObject.toString());
                pdfLayer2.setOnPanel(true);
                registerLayer(pdfLayer2);
                if (pdfLayer != null) {
                    pdfLayer.addChild(pdfLayer2);
                }
                int i2 = i + 1;
                if (pdfArray.size() > i2 && pdfArray.getPdfObject(i2).isArray()) {
                    addOrder(pdfLayer2, (PdfArray) pdfArray.getPdfObject(i2), map);
                    i = i2;
                }
            } else if (pdfObject.isArray()) {
                PdfArray pdfArray2 = (PdfArray) pdfObject;
                if (!pdfArray2.isEmpty()) {
                    PdfObject pdfObject2 = pdfArray2.getPdfObject(0);
                    if (pdfObject2.isString()) {
                        PdfLayer pdfLayer3 = new PdfLayer(pdfObject2.toString());
                        pdfLayer3.setOnPanel(true);
                        registerLayer(pdfLayer3);
                        if (pdfLayer != null) {
                            pdfLayer.addChild(pdfLayer3);
                        }
                        PdfArray pdfArray3 = new PdfArray();
                        ListIterator listIterator = pdfArray2.listIterator();
                        while (listIterator.hasNext()) {
                            pdfArray3.add((PdfObject) listIterator.next());
                        }
                        addOrder(pdfLayer3, pdfArray3, map);
                    } else {
                        addOrder(pdfLayer, (PdfArray) pdfObject2, map);
                    }
                } else {
                    return;
                }
            } else {
                continue;
            }
            i++;
        }
    }

    public Map getPdfLayers() {
        String str;
        if (this.documentOCG.isEmpty()) {
            readOCProperties();
        }
        HashMap hashMap = new HashMap();
        Iterator it = this.documentOCG.iterator();
        while (it.hasNext()) {
            PdfLayer pdfLayer = (PdfLayer) it.next();
            if (pdfLayer.getTitle() == null) {
                str = pdfLayer.getAsString(PdfName.NAME).toString();
            } else {
                str = pdfLayer.getTitle();
            }
            if (hashMap.containsKey(str)) {
                int i = 2;
                String str2 = String.valueOf(str) + "(" + 2 + ")";
                while (hashMap.containsKey(str2)) {
                    i++;
                    str2 = String.valueOf(str) + "(" + i + ")";
                }
                str = str2;
            }
            hashMap.put(str, pdfLayer);
        }
        return hashMap;
    }

    static class PageStamp {
        StampContent over;
        PdfDictionary pageN;
        PageResources pageResources;
        int replacePoint = 0;
        StampContent under;

        PageStamp(PdfStamperImp pdfStamperImp, PdfReader pdfReader, PdfDictionary pdfDictionary) {
            this.pageN = pdfDictionary;
            this.pageResources = new PageResources();
            this.pageResources.setOriginalResources(pdfDictionary.getAsDict(PdfName.RESOURCES), pdfStamperImp.namePtr);
        }
    }
}
