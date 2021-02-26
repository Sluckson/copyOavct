package com.lowagie.text.pdf;

import androidx.core.view.ViewCompat;
import com.lowagie.text.DocListener;
import com.lowagie.text.DocWriter;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.ExceptionConverter;
import com.lowagie.text.Image;
import com.lowagie.text.ImgJBIG2;
import com.lowagie.text.ImgWMF;
import com.lowagie.text.Rectangle;
import com.lowagie.text.Table;
import com.lowagie.text.html.HtmlTags;
import com.lowagie.text.pdf.PdfDocument;
import com.lowagie.text.pdf.collection.PdfCollection;
import com.lowagie.text.pdf.events.PdfPageEventForwarder;
import com.lowagie.text.pdf.interfaces.PdfAnnotations;
import com.lowagie.text.pdf.interfaces.PdfDocumentActions;
import com.lowagie.text.pdf.interfaces.PdfEncryptionSettings;
import com.lowagie.text.pdf.interfaces.PdfPageActions;
import com.lowagie.text.pdf.interfaces.PdfRunDirection;
import com.lowagie.text.pdf.interfaces.PdfVersion;
import com.lowagie.text.pdf.interfaces.PdfViewerPreferences;
import com.lowagie.text.pdf.interfaces.PdfXConformance;
import com.lowagie.text.pdf.internal.PdfVersionImp;
import com.lowagie.text.pdf.internal.PdfXConformanceImp;
import com.lowagie.text.xml.xmp.XmpWriter;
import harmony.java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

public class PdfWriter extends DocWriter implements PdfViewerPreferences, PdfEncryptionSettings, PdfVersion, PdfDocumentActions, PdfPageActions, PdfXConformance, PdfRunDirection, PdfAnnotations {
    public static final int ALLOW_ASSEMBLY = 1024;
    public static final int ALLOW_COPY = 16;
    public static final int ALLOW_DEGRADED_PRINTING = 4;
    public static final int ALLOW_FILL_IN = 256;
    public static final int ALLOW_MODIFY_ANNOTATIONS = 32;
    public static final int ALLOW_MODIFY_CONTENTS = 8;
    public static final int ALLOW_PRINTING = 2052;
    public static final int ALLOW_SCREENREADERS = 512;
    public static final int AllowAssembly = 1024;
    public static final int AllowCopy = 16;
    public static final int AllowDegradedPrinting = 4;
    public static final int AllowFillIn = 256;
    public static final int AllowModifyAnnotations = 32;
    public static final int AllowModifyContents = 8;
    public static final int AllowPrinting = 2052;
    public static final int AllowScreenReaders = 512;
    public static final int CenterWindow = 65536;
    public static final PdfName DID_PRINT = PdfName.f666DP;
    public static final PdfName DID_SAVE = PdfName.f668DS;
    public static final PdfName DOCUMENT_CLOSE = PdfName.f740WC;
    public static final int DO_NOT_ENCRYPT_METADATA = 8;
    public static final int DirectionL2R = 4194304;
    public static final int DirectionR2L = 8388608;
    public static final int DisplayDocTitle = 131072;
    public static final int EMBEDDED_FILES_ONLY = 24;
    public static final int ENCRYPTION_AES_128 = 2;
    static final int ENCRYPTION_MASK = 7;
    public static final int FitWindow = 32768;
    public static final int GENERATION_MAX = 65535;
    public static final int HideMenubar = 8192;
    public static final int HideToolbar = 4096;
    public static final int HideWindowUI = 16384;
    public static final float NO_SPACE_CHAR_RATIO = 1.0E7f;
    public static final int NonFullScreenPageModeUseNone = 262144;
    public static final int NonFullScreenPageModeUseOC = 2097152;
    public static final int NonFullScreenPageModeUseOutlines = 524288;
    public static final int NonFullScreenPageModeUseThumbs = 1048576;
    public static final PdfName PAGE_CLOSE = PdfName.f652C;
    public static final PdfName PAGE_OPEN = PdfName.f703O;
    public static final int PDFA1A = 3;
    public static final int PDFA1B = 4;
    public static final int PDFX1A2001 = 1;
    public static final int PDFX32002 = 2;
    public static final int PDFXNONE = 0;
    public static final PdfName PDF_VERSION_1_2 = new PdfName("1.2");
    public static final PdfName PDF_VERSION_1_3 = new PdfName("1.3");
    public static final PdfName PDF_VERSION_1_4 = new PdfName("1.4");
    public static final PdfName PDF_VERSION_1_5 = new PdfName("1.5");
    public static final PdfName PDF_VERSION_1_6 = new PdfName("1.6");
    public static final PdfName PDF_VERSION_1_7 = new PdfName("1.7");
    public static final int PageLayoutOneColumn = 2;
    public static final int PageLayoutSinglePage = 1;
    public static final int PageLayoutTwoColumnLeft = 4;
    public static final int PageLayoutTwoColumnRight = 8;
    public static final int PageLayoutTwoPageLeft = 16;
    public static final int PageLayoutTwoPageRight = 32;
    public static final int PageModeFullScreen = 512;
    public static final int PageModeUseAttachments = 2048;
    public static final int PageModeUseNone = 64;
    public static final int PageModeUseOC = 1024;
    public static final int PageModeUseOutlines = 128;
    public static final int PageModeUseThumbs = 256;
    public static final int PrintScalingNone = 16777216;
    public static final int RUN_DIRECTION_DEFAULT = 0;
    public static final int RUN_DIRECTION_LTR = 2;
    public static final int RUN_DIRECTION_NO_BIDI = 1;
    public static final int RUN_DIRECTION_RTL = 3;
    public static final int SIGNATURE_APPEND_ONLY = 2;
    public static final int SIGNATURE_EXISTS = 1;
    public static final float SPACE_CHAR_RATIO_DEFAULT = 2.5f;
    public static final int STANDARD_ENCRYPTION_128 = 1;
    public static final int STANDARD_ENCRYPTION_40 = 0;
    public static final boolean STRENGTH128BITS = true;
    public static final boolean STRENGTH40BITS = false;
    public static final char VERSION_1_2 = '2';
    public static final char VERSION_1_3 = '3';
    public static final char VERSION_1_4 = '4';
    public static final char VERSION_1_5 = '5';
    public static final char VERSION_1_6 = '6';
    public static final char VERSION_1_7 = '7';
    public static final PdfName WILL_PRINT = PdfName.f741WP;
    public static final PdfName WILL_SAVE = PdfName.f742WS;
    protected HashMap JBIG2Globals = new HashMap();
    protected PdfArray OCGLocked = new PdfArray();
    protected PdfArray OCGRadioGroup = new PdfArray();
    protected PdfOCProperties OCProperties;
    protected PdfBody body;
    protected int colorNumber = 1;
    protected int compressionLevel = -1;
    protected PdfEncryption crypto;
    protected int currentPageNumber = 1;
    protected PdfReaderInstance currentPdfReaderInstance;
    protected PdfDictionary defaultColorspace = new PdfDictionary();
    protected PdfContentByte directContent;
    protected PdfContentByte directContentUnder;
    protected HashMap documentColors = new HashMap();
    protected HashMap documentExtGState = new HashMap();
    protected LinkedHashMap documentFonts = new LinkedHashMap();
    protected HashSet documentOCG = new HashSet();
    protected ArrayList documentOCGorder = new ArrayList();
    protected HashMap documentPatterns = new HashMap();
    protected HashMap documentProperties = new HashMap();
    protected HashMap documentShadingPatterns = new HashMap();
    protected HashMap documentShadings = new HashMap();
    protected HashMap documentSpotPatterns = new HashMap();
    protected PdfDictionary extraCatalog;
    protected int fontNumber = 1;
    protected HashMap formXObjects = new HashMap();
    protected int formXObjectsCounter = 1;
    protected boolean fullCompression = false;
    protected PdfDictionary group;
    protected PdfDictionary imageDictionary = new PdfDictionary();
    private HashMap images = new HashMap();
    protected HashMap importedPages = new HashMap();
    protected List newBookmarks;
    private PdfPageEvent pageEvent;
    protected ArrayList pageReferences = new ArrayList();
    protected ColorDetails patternColorspaceCMYK;
    protected ColorDetails patternColorspaceGRAY;
    protected ColorDetails patternColorspaceRGB;
    protected int patternNumber = 1;
    protected PdfDocument pdf;
    protected PdfVersionImp pdf_version = new PdfVersionImp();
    private PdfXConformanceImp pdfxConformance = new PdfXConformanceImp();
    protected int prevxref = 0;
    private boolean rgbTransparencyBlending;
    protected PdfPages root = new PdfPages(this);
    protected int runDirection = 1;
    private float spaceCharRatio = 2.5f;
    protected PdfStructureTreeRoot structureTreeRoot;
    protected PdfName tabs = null;
    protected boolean tagged = false;
    private boolean userProperties;
    protected float userunit = 0.0f;
    protected byte[] xmpMetadata = null;

    public static class PdfBody {
        private static final int OBJSINSTREAM = 200;
        private int currentObjNum;
        private ByteBuffer index;
        private int numObj = 0;
        private int position;
        private int refnum;
        private ByteBuffer streamObjects;
        private PdfWriter writer;
        private TreeSet xrefs = new TreeSet();

        static class PdfCrossReference implements Comparable {
            private int generation;
            private int offset;
            private int refnum;
            private int type;

            PdfCrossReference(int i, int i2, int i3) {
                this.type = 0;
                this.offset = i2;
                this.refnum = i;
                this.generation = i3;
            }

            PdfCrossReference(int i, int i2) {
                this.type = 1;
                this.offset = i2;
                this.refnum = i;
                this.generation = 0;
            }

            PdfCrossReference(int i, int i2, int i3, int i4) {
                this.type = i;
                this.offset = i3;
                this.refnum = i2;
                this.generation = i4;
            }

            /* access modifiers changed from: package-private */
            public int getRefnum() {
                return this.refnum;
            }

            public void toPdf(OutputStream outputStream) throws IOException {
                StringBuffer stringBuffer = new StringBuffer("0000000000");
                stringBuffer.append(this.offset);
                stringBuffer.delete(0, stringBuffer.length() - 10);
                StringBuffer stringBuffer2 = new StringBuffer("00000");
                stringBuffer2.append(this.generation);
                stringBuffer2.delete(0, stringBuffer2.length() - 5);
                stringBuffer.append(' ');
                stringBuffer.append(stringBuffer2);
                stringBuffer.append(this.generation == 65535 ? " f \n" : " n \n");
                outputStream.write(PdfWriter.getISOBytes(stringBuffer.toString()));
            }

            public void toPdf(int i, OutputStream outputStream) throws IOException {
                outputStream.write((byte) this.type);
                while (true) {
                    i--;
                    if (i < 0) {
                        outputStream.write((byte) ((this.generation >>> 8) & 255));
                        outputStream.write((byte) (this.generation & 255));
                        return;
                    }
                    outputStream.write((byte) ((this.offset >>> (i * 8)) & 255));
                }
            }

            public int compareTo(Object obj) {
                int i = this.refnum;
                int i2 = ((PdfCrossReference) obj).refnum;
                if (i < i2) {
                    return -1;
                }
                return i == i2 ? 0 : 1;
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof PdfCrossReference) || this.refnum != ((PdfCrossReference) obj).refnum) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return this.refnum;
            }
        }

        PdfBody(PdfWriter pdfWriter) {
            this.xrefs.add(new PdfCrossReference(0, 0, 65535));
            this.position = pdfWriter.getOs().getCounter();
            this.refnum = 1;
            this.writer = pdfWriter;
        }

        /* access modifiers changed from: package-private */
        public void setRefnum(int i) {
            this.refnum = i;
        }

        private PdfCrossReference addToObjStm(PdfObject pdfObject, int i) throws IOException {
            if (this.numObj >= 200) {
                flushObjStm();
            }
            if (this.index == null) {
                this.index = new ByteBuffer();
                this.streamObjects = new ByteBuffer();
                this.currentObjNum = getIndirectReferenceNumber();
                this.numObj = 0;
            }
            int size = this.streamObjects.size();
            int i2 = this.numObj;
            this.numObj = i2 + 1;
            PdfEncryption pdfEncryption = this.writer.crypto;
            PdfWriter pdfWriter = this.writer;
            pdfWriter.crypto = null;
            pdfObject.toPdf(pdfWriter, this.streamObjects);
            this.writer.crypto = pdfEncryption;
            this.streamObjects.append(' ');
            this.index.append(i).append(' ').append(size).append(' ');
            return new PdfCrossReference(2, i, this.currentObjNum, i2);
        }

        /* access modifiers changed from: private */
        public void flushObjStm() throws IOException {
            if (this.numObj != 0) {
                int size = this.index.size();
                this.index.append(this.streamObjects);
                PdfStream pdfStream = new PdfStream(this.index.toByteArray());
                pdfStream.flateCompress(this.writer.getCompressionLevel());
                pdfStream.put(PdfName.TYPE, PdfName.OBJSTM);
                pdfStream.put(PdfName.f696N, new PdfNumber(this.numObj));
                pdfStream.put(PdfName.FIRST, new PdfNumber(size));
                add((PdfObject) pdfStream, this.currentObjNum);
                this.index = null;
                this.streamObjects = null;
                this.numObj = 0;
            }
        }

        /* access modifiers changed from: package-private */
        public PdfIndirectObject add(PdfObject pdfObject) throws IOException {
            return add(pdfObject, getIndirectReferenceNumber());
        }

        /* access modifiers changed from: package-private */
        public PdfIndirectObject add(PdfObject pdfObject, boolean z) throws IOException {
            return add(pdfObject, getIndirectReferenceNumber(), z);
        }

        /* access modifiers changed from: package-private */
        public PdfIndirectReference getPdfIndirectReference() {
            return new PdfIndirectReference(0, getIndirectReferenceNumber());
        }

        /* access modifiers changed from: package-private */
        public int getIndirectReferenceNumber() {
            int i = this.refnum;
            this.refnum = i + 1;
            this.xrefs.add(new PdfCrossReference(i, 0, 65535));
            return i;
        }

        /* access modifiers changed from: package-private */
        public PdfIndirectObject add(PdfObject pdfObject, PdfIndirectReference pdfIndirectReference) throws IOException {
            return add(pdfObject, pdfIndirectReference.getNumber());
        }

        /* access modifiers changed from: package-private */
        public PdfIndirectObject add(PdfObject pdfObject, PdfIndirectReference pdfIndirectReference, boolean z) throws IOException {
            return add(pdfObject, pdfIndirectReference.getNumber(), z);
        }

        /* access modifiers changed from: package-private */
        public PdfIndirectObject add(PdfObject pdfObject, int i) throws IOException {
            return add(pdfObject, i, true);
        }

        /* access modifiers changed from: package-private */
        public PdfIndirectObject add(PdfObject pdfObject, int i, boolean z) throws IOException {
            if (!z || !pdfObject.canBeInObjStm() || !this.writer.isFullCompression()) {
                PdfIndirectObject pdfIndirectObject = new PdfIndirectObject(i, pdfObject, this.writer);
                PdfCrossReference pdfCrossReference = new PdfCrossReference(i, this.position);
                if (!this.xrefs.add(pdfCrossReference)) {
                    this.xrefs.remove(pdfCrossReference);
                    this.xrefs.add(pdfCrossReference);
                }
                pdfIndirectObject.writeTo(this.writer.getOs());
                this.position = this.writer.getOs().getCounter();
                return pdfIndirectObject;
            }
            PdfCrossReference addToObjStm = addToObjStm(pdfObject, i);
            PdfIndirectObject pdfIndirectObject2 = new PdfIndirectObject(i, pdfObject, this.writer);
            if (!this.xrefs.add(addToObjStm)) {
                this.xrefs.remove(addToObjStm);
                this.xrefs.add(addToObjStm);
            }
            return pdfIndirectObject2;
        }

        /* access modifiers changed from: package-private */
        public int offset() {
            return this.position;
        }

        /* access modifiers changed from: package-private */
        public int size() {
            return Math.max(((PdfCrossReference) this.xrefs.last()).getRefnum() + 1, this.refnum);
        }

        /* access modifiers changed from: package-private */
        public void writeCrossReferenceTable(OutputStream outputStream, PdfIndirectReference pdfIndirectReference, PdfIndirectReference pdfIndirectReference2, PdfIndirectReference pdfIndirectReference3, PdfObject pdfObject, int i) throws IOException {
            int i2;
            OutputStream outputStream2 = outputStream;
            PdfIndirectReference pdfIndirectReference4 = pdfIndirectReference2;
            PdfIndirectReference pdfIndirectReference5 = pdfIndirectReference3;
            PdfObject pdfObject2 = pdfObject;
            int i3 = i;
            int i4 = 0;
            if (this.writer.isFullCompression()) {
                flushObjStm();
                i2 = getIndirectReferenceNumber();
                this.xrefs.add(new PdfCrossReference(i2, this.position));
            } else {
                i2 = 0;
            }
            int refnum2 = ((PdfCrossReference) this.xrefs.first()).getRefnum();
            ArrayList arrayList = new ArrayList();
            Iterator it = this.xrefs.iterator();
            int i5 = 0;
            while (it.hasNext()) {
                PdfIndirectReference pdfIndirectReference6 = pdfIndirectReference;
                PdfCrossReference pdfCrossReference = (PdfCrossReference) it.next();
                if (refnum2 + i5 == pdfCrossReference.getRefnum()) {
                    i5++;
                    i4 = 0;
                } else {
                    arrayList.add(new Integer(refnum2));
                    arrayList.add(new Integer(i5));
                    refnum2 = pdfCrossReference.getRefnum();
                    i4 = 0;
                    i5 = 1;
                }
            }
            arrayList.add(new Integer(refnum2));
            arrayList.add(new Integer(i5));
            if (this.writer.isFullCompression()) {
                int i6 = 4;
                int i7 = ViewCompat.MEASURED_STATE_MASK;
                while (i6 > 1 && (this.position & i7) == 0) {
                    PdfIndirectReference pdfIndirectReference7 = pdfIndirectReference;
                    i7 >>>= 8;
                    i6--;
                }
                ByteBuffer byteBuffer = new ByteBuffer();
                Iterator it2 = this.xrefs.iterator();
                while (it2.hasNext()) {
                    PdfIndirectReference pdfIndirectReference8 = pdfIndirectReference;
                    ((PdfCrossReference) it2.next()).toPdf(i6, byteBuffer);
                }
                PdfStream pdfStream = new PdfStream(byteBuffer.toByteArray());
                pdfStream.flateCompress(this.writer.getCompressionLevel());
                pdfStream.put(PdfName.SIZE, new PdfNumber(size()));
                pdfStream.put(PdfName.ROOT, pdfIndirectReference);
                if (pdfIndirectReference4 != null) {
                    pdfStream.put(PdfName.INFO, pdfIndirectReference4);
                }
                if (pdfIndirectReference5 != null) {
                    pdfStream.put(PdfName.ENCRYPT, pdfIndirectReference5);
                }
                if (pdfObject2 != null) {
                    pdfStream.put(PdfName.f687ID, pdfObject2);
                }
                PdfName pdfName = PdfName.f738W;
                int[] iArr = new int[3];
                iArr[i4] = 1;
                iArr[1] = i6;
                iArr[2] = 2;
                pdfStream.put(pdfName, new PdfArray(iArr));
                pdfStream.put(PdfName.TYPE, PdfName.XREF);
                PdfArray pdfArray = new PdfArray();
                while (i4 < arrayList.size()) {
                    pdfArray.add((PdfObject) new PdfNumber(((Integer) arrayList.get(i4)).intValue()));
                    i4++;
                }
                pdfStream.put(PdfName.INDEX, pdfArray);
                if (i3 > 0) {
                    pdfStream.put(PdfName.PREV, new PdfNumber(i3));
                }
                PdfEncryption pdfEncryption = this.writer.crypto;
                PdfWriter pdfWriter = this.writer;
                pdfWriter.crypto = null;
                new PdfIndirectObject(i2, (PdfObject) pdfStream, pdfWriter).writeTo(this.writer.getOs());
                this.writer.crypto = pdfEncryption;
                return;
            }
            outputStream2.write(PdfWriter.getISOBytes("xref\n"));
            Iterator it3 = this.xrefs.iterator();
            for (int i8 = 0; i8 < arrayList.size(); i8 += 2) {
                int intValue = ((Integer) arrayList.get(i8)).intValue();
                int intValue2 = ((Integer) arrayList.get(i8 + 1)).intValue();
                outputStream2.write(PdfWriter.getISOBytes(String.valueOf(intValue)));
                outputStream2.write(PdfWriter.getISOBytes(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR));
                outputStream2.write(PdfWriter.getISOBytes(String.valueOf(intValue2)));
                outputStream2.write(10);
                while (true) {
                    int i9 = intValue2 - 1;
                    if (intValue2 <= 0) {
                        break;
                    }
                    ((PdfCrossReference) it3.next()).toPdf(outputStream2);
                    intValue2 = i9;
                }
            }
        }
    }

    static class PdfTrailer extends PdfDictionary {
        int offset;

        PdfTrailer(int i, int i2, PdfIndirectReference pdfIndirectReference, PdfIndirectReference pdfIndirectReference2, PdfIndirectReference pdfIndirectReference3, PdfObject pdfObject, int i3) {
            this.offset = i2;
            put(PdfName.SIZE, new PdfNumber(i));
            put(PdfName.ROOT, pdfIndirectReference);
            if (pdfIndirectReference2 != null) {
                put(PdfName.INFO, pdfIndirectReference2);
            }
            if (pdfIndirectReference3 != null) {
                put(PdfName.ENCRYPT, pdfIndirectReference3);
            }
            if (pdfObject != null) {
                put(PdfName.f687ID, pdfObject);
            }
            if (i3 > 0) {
                put(PdfName.PREV, new PdfNumber(i3));
            }
        }

        public void toPdf(PdfWriter pdfWriter, OutputStream outputStream) throws IOException {
            outputStream.write(PdfWriter.getISOBytes("trailer\n"));
            super.toPdf((PdfWriter) null, outputStream);
            outputStream.write(PdfWriter.getISOBytes("\nstartxref\n"));
            outputStream.write(PdfWriter.getISOBytes(String.valueOf(this.offset)));
            outputStream.write(PdfWriter.getISOBytes("\n%%EOF\n"));
        }
    }

    protected PdfWriter() {
    }

    protected PdfWriter(PdfDocument pdfDocument, OutputStream outputStream) {
        super(pdfDocument, outputStream);
        this.pdf = pdfDocument;
        this.directContent = new PdfContentByte(this);
        this.directContentUnder = new PdfContentByte(this);
    }

    public static PdfWriter getInstance(Document document, OutputStream outputStream) throws DocumentException {
        PdfDocument pdfDocument = new PdfDocument();
        document.addDocListener(pdfDocument);
        PdfWriter pdfWriter = new PdfWriter(pdfDocument, outputStream);
        pdfDocument.addWriter(pdfWriter);
        return pdfWriter;
    }

    public static PdfWriter getInstance(Document document, OutputStream outputStream, DocListener docListener) throws DocumentException {
        PdfDocument pdfDocument = new PdfDocument();
        pdfDocument.addDocListener(docListener);
        document.addDocListener(pdfDocument);
        PdfWriter pdfWriter = new PdfWriter(pdfDocument, outputStream);
        pdfDocument.addWriter(pdfWriter);
        return pdfWriter;
    }

    /* access modifiers changed from: package-private */
    public PdfDocument getPdfDocument() {
        return this.pdf;
    }

    public PdfDictionary getInfo() {
        return this.pdf.getInfo();
    }

    public float getVerticalPosition(boolean z) {
        return this.pdf.getVerticalPosition(z);
    }

    public void setInitialLeading(float f) throws DocumentException {
        if (!this.open) {
            this.pdf.setLeading(f);
            return;
        }
        throw new DocumentException("You can't set the initial leading if the document is already open.");
    }

    public PdfContentByte getDirectContent() {
        if (this.open) {
            return this.directContent;
        }
        throw new RuntimeException("The document is not open.");
    }

    public PdfContentByte getDirectContentUnder() {
        if (this.open) {
            return this.directContentUnder;
        }
        throw new RuntimeException("The document is not open.");
    }

    /* access modifiers changed from: package-private */
    public void resetContent() {
        this.directContent.reset();
        this.directContentUnder.reset();
    }

    /* access modifiers changed from: package-private */
    public void addLocalDestinations(TreeMap treeMap) throws IOException {
        for (Map.Entry entry : treeMap.entrySet()) {
            String str = (String) entry.getKey();
            Object[] objArr = (Object[]) entry.getValue();
            PdfDestination pdfDestination = (PdfDestination) objArr[2];
            if (objArr[1] == null) {
                objArr[1] = getPdfIndirectReference();
            }
            if (pdfDestination == null) {
                addToBody((PdfObject) new PdfString("invalid_" + str), (PdfIndirectReference) objArr[1]);
            } else {
                addToBody((PdfObject) pdfDestination, (PdfIndirectReference) objArr[1]);
            }
        }
    }

    public PdfIndirectObject addToBody(PdfObject pdfObject) throws IOException {
        return this.body.add(pdfObject);
    }

    public PdfIndirectObject addToBody(PdfObject pdfObject, boolean z) throws IOException {
        return this.body.add(pdfObject, z);
    }

    public PdfIndirectObject addToBody(PdfObject pdfObject, PdfIndirectReference pdfIndirectReference) throws IOException {
        return this.body.add(pdfObject, pdfIndirectReference);
    }

    public PdfIndirectObject addToBody(PdfObject pdfObject, PdfIndirectReference pdfIndirectReference, boolean z) throws IOException {
        return this.body.add(pdfObject, pdfIndirectReference, z);
    }

    public PdfIndirectObject addToBody(PdfObject pdfObject, int i) throws IOException {
        return this.body.add(pdfObject, i);
    }

    public PdfIndirectObject addToBody(PdfObject pdfObject, int i, boolean z) throws IOException {
        return this.body.add(pdfObject, i, z);
    }

    public PdfIndirectReference getPdfIndirectReference() {
        return this.body.getPdfIndirectReference();
    }

    /* access modifiers changed from: package-private */
    public int getIndirectReferenceNumber() {
        return this.body.getIndirectReferenceNumber();
    }

    /* access modifiers changed from: package-private */
    public OutputStreamCounter getOs() {
        return this.f571os;
    }

    /* access modifiers changed from: protected */
    public PdfDictionary getCatalog(PdfIndirectReference pdfIndirectReference) {
        PdfDocument.PdfCatalog catalog = this.pdf.getCatalog(pdfIndirectReference);
        if (this.tagged) {
            try {
                getStructureTreeRoot().buildTree();
                catalog.put(PdfName.STRUCTTREEROOT, this.structureTreeRoot.getReference());
                PdfDictionary pdfDictionary = new PdfDictionary();
                pdfDictionary.put(PdfName.MARKED, PdfBoolean.PDFTRUE);
                if (this.userProperties) {
                    pdfDictionary.put(PdfName.USERPROPERTIES, PdfBoolean.PDFTRUE);
                }
                catalog.put(PdfName.MARKINFO, pdfDictionary);
            } catch (Exception e) {
                throw new ExceptionConverter(e);
            }
        }
        if (!this.documentOCG.isEmpty()) {
            fillOCProperties(false);
            catalog.put(PdfName.OCPROPERTIES, this.OCProperties);
        }
        return catalog;
    }

    public PdfDictionary getExtraCatalog() {
        if (this.extraCatalog == null) {
            this.extraCatalog = new PdfDictionary();
        }
        return this.extraCatalog;
    }

    public void setLinearPageMode() {
        this.root.setLinearMode((PdfIndirectReference) null);
    }

    public int reorderPages(int[] iArr) throws DocumentException {
        return this.root.reorderPages(iArr);
    }

    public PdfIndirectReference getPageReference(int i) {
        int i2 = i - 1;
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("The page numbers start at 1.");
        } else if (i2 < this.pageReferences.size()) {
            PdfIndirectReference pdfIndirectReference = (PdfIndirectReference) this.pageReferences.get(i2);
            if (pdfIndirectReference != null) {
                return pdfIndirectReference;
            }
            PdfIndirectReference pdfIndirectReference2 = this.body.getPdfIndirectReference();
            this.pageReferences.set(i2, pdfIndirectReference2);
            return pdfIndirectReference2;
        } else {
            int size = i2 - this.pageReferences.size();
            for (int i3 = 0; i3 < size; i3++) {
                this.pageReferences.add((Object) null);
            }
            PdfIndirectReference pdfIndirectReference3 = this.body.getPdfIndirectReference();
            this.pageReferences.add(pdfIndirectReference3);
            return pdfIndirectReference3;
        }
    }

    public int getPageNumber() {
        return this.pdf.getPageNumber();
    }

    /* access modifiers changed from: package-private */
    public PdfIndirectReference getCurrentPage() {
        return getPageReference(this.currentPageNumber);
    }

    public int getCurrentPageNumber() {
        return this.currentPageNumber;
    }

    public void setTabs(PdfName pdfName) {
        this.tabs = pdfName;
    }

    public PdfName getTabs() {
        return this.tabs;
    }

    /* access modifiers changed from: package-private */
    public PdfIndirectReference add(PdfPage pdfPage, PdfContents pdfContents) throws PdfException {
        if (this.open) {
            try {
                pdfPage.add(addToBody(pdfContents).getIndirectReference());
                if (this.group != null) {
                    pdfPage.put(PdfName.GROUP, this.group);
                    this.group = null;
                } else if (this.rgbTransparencyBlending) {
                    PdfDictionary pdfDictionary = new PdfDictionary();
                    pdfDictionary.put(PdfName.TYPE, PdfName.GROUP);
                    pdfDictionary.put(PdfName.f719S, PdfName.TRANSPARENCY);
                    pdfDictionary.put(PdfName.f660CS, PdfName.DEVICERGB);
                    pdfPage.put(PdfName.GROUP, pdfDictionary);
                }
                this.root.addPage((PdfDictionary) pdfPage);
                this.currentPageNumber++;
                return null;
            } catch (IOException e) {
                throw new ExceptionConverter(e);
            }
        } else {
            throw new PdfException("The document isn't open.");
        }
    }

    public void setPageEvent(PdfPageEvent pdfPageEvent) {
        if (pdfPageEvent == null) {
            this.pageEvent = null;
            return;
        }
        PdfPageEvent pdfPageEvent2 = this.pageEvent;
        if (pdfPageEvent2 == null) {
            this.pageEvent = pdfPageEvent;
        } else if (pdfPageEvent2 instanceof PdfPageEventForwarder) {
            ((PdfPageEventForwarder) pdfPageEvent2).addPageEvent(pdfPageEvent);
        } else {
            PdfPageEventForwarder pdfPageEventForwarder = new PdfPageEventForwarder();
            pdfPageEventForwarder.addPageEvent(this.pageEvent);
            pdfPageEventForwarder.addPageEvent(pdfPageEvent);
            this.pageEvent = pdfPageEventForwarder;
        }
    }

    public PdfPageEvent getPageEvent() {
        return this.pageEvent;
    }

    public void open() {
        super.open();
        try {
            this.pdf_version.writeHeader(this.f571os);
            this.body = new PdfBody(this);
            if (this.pdfxConformance.isPdfX32002()) {
                PdfDictionary pdfDictionary = new PdfDictionary();
                pdfDictionary.put(PdfName.GAMMA, new PdfArray(new float[]{2.2f, 2.2f, 2.2f}));
                pdfDictionary.put(PdfName.MATRIX, new PdfArray(new float[]{0.4124f, 0.2126f, 0.0193f, 0.3576f, 0.7152f, 0.1192f, 0.1805f, 0.0722f, 0.9505f}));
                pdfDictionary.put(PdfName.WHITEPOINT, new PdfArray(new float[]{0.9505f, 1.0f, 1.089f}));
                PdfArray pdfArray = new PdfArray((PdfObject) PdfName.CALRGB);
                pdfArray.add((PdfObject) pdfDictionary);
                setDefaultColorspace(PdfName.DEFAULTRGB, addToBody(pdfArray).getIndirectReference());
            }
        } catch (IOException e) {
            throw new ExceptionConverter(e);
        }
    }

    public void close() {
        PdfObject pdfObject;
        if (!this.open) {
            return;
        }
        if (this.currentPageNumber - 1 == this.pageReferences.size()) {
            this.pdf.close();
            try {
                addSharedObjectsToBody();
                PdfDictionary catalog = getCatalog(this.root.writePageTree());
                if (this.xmpMetadata != null) {
                    PdfStream pdfStream = new PdfStream(this.xmpMetadata);
                    pdfStream.put(PdfName.TYPE, PdfName.METADATA);
                    pdfStream.put(PdfName.SUBTYPE, PdfName.XML);
                    if (this.crypto != null && !this.crypto.isMetadataEncrypted()) {
                        PdfArray pdfArray = new PdfArray();
                        pdfArray.add((PdfObject) PdfName.CRYPT);
                        pdfStream.put(PdfName.FILTER, pdfArray);
                    }
                    catalog.put(PdfName.METADATA, this.body.add(pdfStream).getIndirectReference());
                }
                if (isPdfX()) {
                    this.pdfxConformance.completeInfoDictionary(getInfo());
                    this.pdfxConformance.completeExtraCatalog(getExtraCatalog());
                }
                if (this.extraCatalog != null) {
                    catalog.mergeDifferent(this.extraCatalog);
                }
                writeOutlines(catalog, false);
                PdfIndirectObject addToBody = addToBody((PdfObject) catalog, false);
                PdfIndirectObject addToBody2 = addToBody((PdfObject) getInfo(), false);
                PdfIndirectReference pdfIndirectReference = null;
                this.body.flushObjStm();
                if (this.crypto != null) {
                    pdfIndirectReference = addToBody((PdfObject) this.crypto.getEncryptionDictionary(), false).getIndirectReference();
                    pdfObject = this.crypto.getFileID();
                } else {
                    pdfObject = PdfEncryption.createInfoId(PdfEncryption.createDocumentId());
                }
                this.body.writeCrossReferenceTable(this.f571os, addToBody.getIndirectReference(), addToBody2.getIndirectReference(), pdfIndirectReference, pdfObject, this.prevxref);
                if (this.fullCompression) {
                    this.f571os.write(getISOBytes("startxref\n"));
                    this.f571os.write(getISOBytes(String.valueOf(this.body.offset())));
                    this.f571os.write(getISOBytes("\n%%EOF\n"));
                } else {
                    new PdfTrailer(this.body.size(), this.body.offset(), addToBody.getIndirectReference(), addToBody2.getIndirectReference(), pdfIndirectReference, pdfObject, this.prevxref).toPdf(this, this.f571os);
                }
                super.close();
            } catch (IOException e) {
                throw new ExceptionConverter(e);
            }
        } else {
            StringBuilder sb = new StringBuilder("The page ");
            sb.append(this.pageReferences.size());
            sb.append(" was requested but the document has only ");
            sb.append(this.currentPageNumber - 1);
            sb.append(" pages.");
            throw new RuntimeException(sb.toString());
        }
    }

    /* access modifiers changed from: protected */
    public void addSharedObjectsToBody() throws IOException {
        for (FontDetails writeFont : this.documentFonts.values()) {
            writeFont.writeFont(this);
        }
        for (Object[] objArr : this.formXObjects.values()) {
            PdfTemplate pdfTemplate = (PdfTemplate) objArr[1];
            if ((pdfTemplate == null || !(pdfTemplate.getIndirectReference() instanceof PRIndirectReference)) && pdfTemplate != null && pdfTemplate.getType() == 1) {
                addToBody((PdfObject) pdfTemplate.getFormXObject(this.compressionLevel), pdfTemplate.getIndirectReference());
            }
        }
        for (PdfReaderInstance pdfReaderInstance : this.importedPages.values()) {
            this.currentPdfReaderInstance = pdfReaderInstance;
            this.currentPdfReaderInstance.writeAllPages();
        }
        this.currentPdfReaderInstance = null;
        for (ColorDetails colorDetails : this.documentColors.values()) {
            addToBody(colorDetails.getSpotColor(this), colorDetails.getIndirectReference());
        }
        for (PdfPatternPainter pdfPatternPainter : this.documentPatterns.keySet()) {
            addToBody((PdfObject) pdfPatternPainter.getPattern(this.compressionLevel), pdfPatternPainter.getIndirectReference());
        }
        for (PdfShadingPattern addToBody : this.documentShadingPatterns.keySet()) {
            addToBody.addToBody();
        }
        for (PdfShading addToBody2 : this.documentShadings.keySet()) {
            addToBody2.addToBody();
        }
        for (Map.Entry entry : this.documentExtGState.entrySet()) {
            addToBody((PdfObject) (PdfDictionary) entry.getKey(), (PdfIndirectReference) ((PdfObject[]) entry.getValue())[1]);
        }
        for (Map.Entry entry2 : this.documentProperties.entrySet()) {
            Object key = entry2.getKey();
            PdfObject[] pdfObjectArr = (PdfObject[]) entry2.getValue();
            if (key instanceof PdfLayerMembership) {
                PdfLayerMembership pdfLayerMembership = (PdfLayerMembership) key;
                addToBody(pdfLayerMembership.getPdfObject(), pdfLayerMembership.getRef());
            } else if ((key instanceof PdfDictionary) && !(key instanceof PdfLayer)) {
                addToBody((PdfObject) (PdfDictionary) key, (PdfIndirectReference) pdfObjectArr[1]);
            }
        }
        Iterator it = this.documentOCG.iterator();
        while (it.hasNext()) {
            PdfOCG pdfOCG = (PdfOCG) it.next();
            addToBody(pdfOCG.getPdfObject(), pdfOCG.getRef());
        }
    }

    public PdfOutline getRootOutline() {
        return this.directContent.getRootOutline();
    }

    public void setOutlines(List list) {
        this.newBookmarks = list;
    }

    /* access modifiers changed from: protected */
    public void writeOutlines(PdfDictionary pdfDictionary, boolean z) throws IOException {
        List list = this.newBookmarks;
        if (list != null && !list.isEmpty()) {
            PdfDictionary pdfDictionary2 = new PdfDictionary();
            PdfIndirectReference pdfIndirectReference = getPdfIndirectReference();
            Object[] iterateOutlines = SimpleBookmark.iterateOutlines(this, pdfIndirectReference, this.newBookmarks, z);
            pdfDictionary2.put(PdfName.FIRST, (PdfIndirectReference) iterateOutlines[0]);
            pdfDictionary2.put(PdfName.LAST, (PdfIndirectReference) iterateOutlines[1]);
            pdfDictionary2.put(PdfName.COUNT, new PdfNumber(((Integer) iterateOutlines[2]).intValue()));
            addToBody((PdfObject) pdfDictionary2, pdfIndirectReference);
            pdfDictionary.put(PdfName.OUTLINES, pdfIndirectReference);
        }
    }

    public void setPdfVersion(char c) {
        this.pdf_version.setPdfVersion(c);
    }

    public void setAtLeastPdfVersion(char c) {
        this.pdf_version.setAtLeastPdfVersion(c);
    }

    public void setPdfVersion(PdfName pdfName) {
        this.pdf_version.setPdfVersion(pdfName);
    }

    public void addDeveloperExtension(PdfDeveloperExtension pdfDeveloperExtension) {
        this.pdf_version.addDeveloperExtension(pdfDeveloperExtension);
    }

    /* access modifiers changed from: package-private */
    public PdfVersionImp getPdfVersion() {
        return this.pdf_version;
    }

    public void setViewerPreferences(int i) {
        this.pdf.setViewerPreferences(i);
    }

    public void addViewerPreference(PdfName pdfName, PdfObject pdfObject) {
        this.pdf.addViewerPreference(pdfName, pdfObject);
    }

    public void setPageLabels(PdfPageLabels pdfPageLabels) {
        this.pdf.setPageLabels(pdfPageLabels);
    }

    public void addJavaScript(PdfAction pdfAction) {
        this.pdf.addJavaScript(pdfAction);
    }

    public void addJavaScript(String str, boolean z) {
        addJavaScript(PdfAction.javaScript(str, this, z));
    }

    public void addJavaScript(String str) {
        addJavaScript(str, false);
    }

    public void addJavaScript(String str, PdfAction pdfAction) {
        this.pdf.addJavaScript(str, pdfAction);
    }

    public void addJavaScript(String str, String str2, boolean z) {
        addJavaScript(str, PdfAction.javaScript(str2, this, z));
    }

    public void addJavaScript(String str, String str2) {
        addJavaScript(str, str2, false);
    }

    public void addFileAttachment(String str, byte[] bArr, String str2, String str3) throws IOException {
        addFileAttachment(str, PdfFileSpecification.fileEmbedded(this, str2, str3, bArr));
    }

    public void addFileAttachment(String str, PdfFileSpecification pdfFileSpecification) throws IOException {
        this.pdf.addFileAttachment(str, pdfFileSpecification);
    }

    public void addFileAttachment(PdfFileSpecification pdfFileSpecification) throws IOException {
        addFileAttachment((String) null, pdfFileSpecification);
    }

    public void setOpenAction(String str) {
        this.pdf.setOpenAction(str);
    }

    public void setOpenAction(PdfAction pdfAction) {
        this.pdf.setOpenAction(pdfAction);
    }

    public void setAdditionalAction(PdfName pdfName, PdfAction pdfAction) throws DocumentException {
        if (pdfName.equals(DOCUMENT_CLOSE) || pdfName.equals(WILL_SAVE) || pdfName.equals(DID_SAVE) || pdfName.equals(WILL_PRINT) || pdfName.equals(DID_PRINT)) {
            this.pdf.addAdditionalAction(pdfName, pdfAction);
            return;
        }
        throw new DocumentException("Invalid additional action type: " + pdfName.toString());
    }

    public void setCollection(PdfCollection pdfCollection) {
        setAtLeastPdfVersion(VERSION_1_7);
        this.pdf.setCollection(pdfCollection);
    }

    public PdfAcroForm getAcroForm() {
        return this.pdf.getAcroForm();
    }

    public void addAnnotation(PdfAnnotation pdfAnnotation) {
        this.pdf.addAnnotation(pdfAnnotation);
    }

    /* access modifiers changed from: package-private */
    public void addAnnotation(PdfAnnotation pdfAnnotation, int i) {
        addAnnotation(pdfAnnotation);
    }

    public void addCalculationOrder(PdfFormField pdfFormField) {
        this.pdf.addCalculationOrder(pdfFormField);
    }

    public void setSigFlags(int i) {
        this.pdf.setSigFlags(i);
    }

    public void setXmpMetadata(byte[] bArr) {
        this.xmpMetadata = bArr;
    }

    public void setPageXmpMetadata(byte[] bArr) {
        this.pdf.setXmpMetadata(bArr);
    }

    public void createXmpMetadata() {
        setXmpMetadata(createXmpMetadataBytes());
    }

    private byte[] createXmpMetadataBytes() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            new XmpWriter((OutputStream) byteArrayOutputStream, (PdfDictionary) this.pdf.getInfo(), this.pdfxConformance.getPDFXConformance()).close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    public void setPDFXConformance(int i) {
        if (this.pdfxConformance.getPDFXConformance() != i) {
            if (this.pdf.isOpen()) {
                throw new PdfXConformanceException("PDFX conformance can only be set before opening the document.");
            } else if (this.crypto == null) {
                if (i == 3 || i == 4) {
                    setPdfVersion((char) VERSION_1_4);
                } else if (i != 0) {
                    setPdfVersion((char) VERSION_1_3);
                }
                this.pdfxConformance.setPDFXConformance(i);
            } else {
                throw new PdfXConformanceException("A PDFX conforming document cannot be encrypted.");
            }
        }
    }

    public int getPDFXConformance() {
        return this.pdfxConformance.getPDFXConformance();
    }

    public boolean isPdfX() {
        return this.pdfxConformance.isPdfX();
    }

    public void setOutputIntents(String str, String str2, String str3, String str4) throws IOException {
        PdfName pdfName;
        getExtraCatalog();
        PdfDictionary pdfDictionary = new PdfDictionary(PdfName.OUTPUTINTENT);
        if (str2 != null) {
            pdfDictionary.put(PdfName.OUTPUTCONDITION, new PdfString(str2, PdfObject.TEXT_UNICODE));
        }
        if (str != null) {
            pdfDictionary.put(PdfName.OUTPUTCONDITIONIDENTIFIER, new PdfString(str, PdfObject.TEXT_UNICODE));
        }
        if (str3 != null) {
            pdfDictionary.put(PdfName.REGISTRYNAME, new PdfString(str3, PdfObject.TEXT_UNICODE));
        }
        if (str4 != null) {
            pdfDictionary.put(PdfName.INFO, new PdfString(str4, PdfObject.TEXT_UNICODE));
        }
        if (this.pdfxConformance.isPdfA1() || "PDFA/1".equals(str2)) {
            pdfName = PdfName.GTS_PDFA1;
        } else {
            pdfName = PdfName.GTS_PDFX;
        }
        pdfDictionary.put(PdfName.f719S, pdfName);
        this.extraCatalog.put(PdfName.OUTPUTINTENTS, new PdfArray((PdfObject) pdfDictionary));
    }

    public void setOutputIntents(String str, String str2, String str3, String str4, byte[] bArr) throws IOException {
        setOutputIntents(str, str2, str3, str4, (byte[]) null);
    }

    public boolean setOutputIntents(PdfReader pdfReader, boolean z) throws IOException {
        PdfArray asArray = pdfReader.getCatalog().getAsArray(PdfName.OUTPUTINTENTS);
        boolean z2 = false;
        if (asArray == null || asArray.isEmpty()) {
            return false;
        }
        PdfDictionary asDict = asArray.getAsDict(0);
        PdfObject pdfObject = PdfReader.getPdfObject(asDict.get(PdfName.f719S));
        if (pdfObject != null && PdfName.GTS_PDFX.equals(pdfObject)) {
            z2 = true;
            if (z) {
                return true;
            }
            PRStream pRStream = (PRStream) PdfReader.getPdfObject(asDict.get(PdfName.DESTOUTPUTPROFILE));
            byte[] bArr = null;
            if (pRStream != null) {
                bArr = PdfReader.getStreamBytes(pRStream);
            }
            setOutputIntents(getNameString(asDict, PdfName.OUTPUTCONDITIONIDENTIFIER), getNameString(asDict, PdfName.OUTPUTCONDITION), getNameString(asDict, PdfName.REGISTRYNAME), getNameString(asDict, PdfName.INFO), bArr);
        }
        return z2;
    }

    private static String getNameString(PdfDictionary pdfDictionary, PdfName pdfName) {
        PdfObject pdfObject = PdfReader.getPdfObject(pdfDictionary.get(pdfName));
        if (pdfObject == null || !pdfObject.isString()) {
            return null;
        }
        return ((PdfString) pdfObject).toUnicodeString();
    }

    /* access modifiers changed from: package-private */
    public PdfEncryption getEncryption() {
        return this.crypto;
    }

    public void setEncryption(byte[] bArr, byte[] bArr2, int i, int i2) throws DocumentException {
        if (!this.pdf.isOpen()) {
            this.crypto = new PdfEncryption();
            this.crypto.setCryptoMode(i2, 0);
            this.crypto.setupAllKeys(bArr, bArr2, i);
            return;
        }
        throw new DocumentException("Encryption can only be added before opening the document.");
    }

    public void setEncryption(Certificate[] certificateArr, int[] iArr, int i) throws DocumentException {
        if (!this.pdf.isOpen()) {
            this.crypto = new PdfEncryption();
            if (certificateArr != null) {
                for (int i2 = 0; i2 < certificateArr.length; i2++) {
                    this.crypto.addRecipient(certificateArr[i2], iArr[i2]);
                }
            }
            this.crypto.setCryptoMode(i, 0);
            this.crypto.getEncryptionDictionary();
            return;
        }
        throw new DocumentException("Encryption can only be added before opening the document.");
    }

    public void setEncryption(byte[] bArr, byte[] bArr2, int i, boolean z) throws DocumentException {
        setEncryption(bArr, bArr2, i, z ? 1 : 0);
    }

    public void setEncryption(boolean z, String str, String str2, int i) throws DocumentException {
        setEncryption(getISOBytes(str), getISOBytes(str2), i, z ? 1 : 0);
    }

    public void setEncryption(int i, String str, String str2, int i2) throws DocumentException {
        setEncryption(getISOBytes(str), getISOBytes(str2), i2, i);
    }

    public boolean isFullCompression() {
        return this.fullCompression;
    }

    public void setFullCompression() {
        this.fullCompression = true;
        setAtLeastPdfVersion(VERSION_1_5);
    }

    public int getCompressionLevel() {
        return this.compressionLevel;
    }

    public void setCompressionLevel(int i) {
        if (i < 0 || i > 9) {
            this.compressionLevel = -1;
        } else {
            this.compressionLevel = i;
        }
    }

    /* access modifiers changed from: package-private */
    public FontDetails addSimple(BaseFont baseFont) {
        if (baseFont.getFontType() == 4) {
            StringBuilder sb = new StringBuilder("F");
            int i = this.fontNumber;
            this.fontNumber = i + 1;
            sb.append(i);
            return new FontDetails(new PdfName(sb.toString()), ((DocumentFont) baseFont).getIndirectReference(), baseFont);
        }
        FontDetails fontDetails = (FontDetails) this.documentFonts.get(baseFont);
        if (fontDetails != null) {
            return fontDetails;
        }
        PdfXConformanceImp.checkPDFXConformance(this, 4, baseFont);
        StringBuilder sb2 = new StringBuilder("F");
        int i2 = this.fontNumber;
        this.fontNumber = i2 + 1;
        sb2.append(i2);
        FontDetails fontDetails2 = new FontDetails(new PdfName(sb2.toString()), this.body.getPdfIndirectReference(), baseFont);
        this.documentFonts.put(baseFont, fontDetails2);
        return fontDetails2;
    }

    /* access modifiers changed from: package-private */
    public void eliminateFontSubset(PdfDictionary pdfDictionary) {
        for (FontDetails fontDetails : this.documentFonts.values()) {
            if (pdfDictionary.get(fontDetails.getFontName()) != null) {
                fontDetails.setSubset(false);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public PdfName addDirectTemplateSimple(PdfTemplate pdfTemplate, PdfName pdfName) {
        PdfIndirectReference indirectReference = pdfTemplate.getIndirectReference();
        Object[] objArr = (Object[]) this.formXObjects.get(indirectReference);
        if (objArr != null) {
            return (PdfName) objArr[0];
        }
        if (pdfName == null) {
            try {
                pdfName = new PdfName("Xf" + this.formXObjectsCounter);
                this.formXObjectsCounter = this.formXObjectsCounter + 1;
            } catch (Exception e) {
                throw new ExceptionConverter(e);
            }
        }
        if (pdfTemplate.getType() == 2) {
            PdfImportedPage pdfImportedPage = (PdfImportedPage) pdfTemplate;
            PdfReader reader = pdfImportedPage.getPdfReaderInstance().getReader();
            if (!this.importedPages.containsKey(reader)) {
                this.importedPages.put(reader, pdfImportedPage.getPdfReaderInstance());
            }
            pdfTemplate = null;
        }
        this.formXObjects.put(indirectReference, new Object[]{pdfName, pdfTemplate});
        return pdfName;
    }

    public void releaseTemplate(PdfTemplate pdfTemplate) throws IOException {
        Object[] objArr = (Object[]) this.formXObjects.get(pdfTemplate.getIndirectReference());
        if (objArr != null && objArr[1] != null) {
            PdfTemplate pdfTemplate2 = (PdfTemplate) objArr[1];
            if (!(pdfTemplate2.getIndirectReference() instanceof PRIndirectReference) && pdfTemplate2.getType() == 1) {
                addToBody((PdfObject) pdfTemplate2.getFormXObject(this.compressionLevel), pdfTemplate2.getIndirectReference());
                objArr[1] = null;
            }
        }
    }

    public PdfImportedPage getImportedPage(PdfReader pdfReader, int i) {
        PdfReaderInstance pdfReaderInstance = (PdfReaderInstance) this.importedPages.get(pdfReader);
        if (pdfReaderInstance == null) {
            pdfReaderInstance = pdfReader.getPdfReaderInstance(this);
            this.importedPages.put(pdfReader, pdfReaderInstance);
        }
        return pdfReaderInstance.getImportedPage(i);
    }

    public void freeReader(PdfReader pdfReader) throws IOException {
        this.currentPdfReaderInstance = (PdfReaderInstance) this.importedPages.get(pdfReader);
        PdfReaderInstance pdfReaderInstance = this.currentPdfReaderInstance;
        if (pdfReaderInstance != null) {
            pdfReaderInstance.writeAllPages();
            this.currentPdfReaderInstance = null;
            this.importedPages.remove(pdfReader);
        }
    }

    public int getCurrentDocumentSize() {
        return this.body.offset() + (this.body.size() * 20) + 72;
    }

    /* access modifiers changed from: protected */
    public int getNewObjectNumber(PdfReader pdfReader, int i, int i2) {
        return this.currentPdfReaderInstance.getNewObjectNumber(i, i2);
    }

    /* access modifiers changed from: package-private */
    public RandomAccessFileOrArray getReaderFile(PdfReader pdfReader) {
        return this.currentPdfReaderInstance.getReaderFile();
    }

    /* access modifiers changed from: package-private */
    public PdfName getColorspaceName() {
        StringBuilder sb = new StringBuilder("CS");
        int i = this.colorNumber;
        this.colorNumber = i + 1;
        sb.append(i);
        return new PdfName(sb.toString());
    }

    /* access modifiers changed from: package-private */
    public ColorDetails addSimple(PdfSpotColor pdfSpotColor) {
        ColorDetails colorDetails = (ColorDetails) this.documentColors.get(pdfSpotColor);
        if (colorDetails != null) {
            return colorDetails;
        }
        ColorDetails colorDetails2 = new ColorDetails(getColorspaceName(), this.body.getPdfIndirectReference(), pdfSpotColor);
        this.documentColors.put(pdfSpotColor, colorDetails2);
        return colorDetails2;
    }

    /* access modifiers changed from: package-private */
    public PdfName addSimplePattern(PdfPatternPainter pdfPatternPainter) {
        PdfName pdfName = (PdfName) this.documentPatterns.get(pdfPatternPainter);
        if (pdfName != null) {
            return pdfName;
        }
        try {
            PdfName pdfName2 = new PdfName("P" + this.patternNumber);
            this.patternNumber = this.patternNumber + 1;
            this.documentPatterns.put(pdfPatternPainter, pdfName2);
            return pdfName2;
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    /* access modifiers changed from: package-private */
    public void addSimpleShadingPattern(PdfShadingPattern pdfShadingPattern) {
        if (!this.documentShadingPatterns.containsKey(pdfShadingPattern)) {
            pdfShadingPattern.setName(this.patternNumber);
            this.patternNumber++;
            this.documentShadingPatterns.put(pdfShadingPattern, (Object) null);
            addSimpleShading(pdfShadingPattern.getShading());
        }
    }

    /* access modifiers changed from: package-private */
    public void addSimpleShading(PdfShading pdfShading) {
        if (!this.documentShadings.containsKey(pdfShading)) {
            this.documentShadings.put(pdfShading, (Object) null);
            pdfShading.setName(this.documentShadings.size());
        }
    }

    /* access modifiers changed from: package-private */
    public PdfObject[] addSimpleExtGState(PdfDictionary pdfDictionary) {
        if (!this.documentExtGState.containsKey(pdfDictionary)) {
            PdfXConformanceImp.checkPDFXConformance(this, 6, pdfDictionary);
            HashMap hashMap = this.documentExtGState;
            hashMap.put(pdfDictionary, new PdfObject[]{new PdfName("GS" + (this.documentExtGState.size() + 1)), getPdfIndirectReference()});
        }
        return (PdfObject[]) this.documentExtGState.get(pdfDictionary);
    }

    /* access modifiers changed from: package-private */
    public PdfObject[] addSimpleProperty(Object obj, PdfIndirectReference pdfIndirectReference) {
        if (!this.documentProperties.containsKey(obj)) {
            if (obj instanceof PdfOCG) {
                PdfXConformanceImp.checkPDFXConformance(this, 7, (Object) null);
            }
            HashMap hashMap = this.documentProperties;
            hashMap.put(obj, new PdfObject[]{new PdfName("Pr" + (this.documentProperties.size() + 1)), pdfIndirectReference});
        }
        return (PdfObject[]) this.documentProperties.get(obj);
    }

    /* access modifiers changed from: package-private */
    public boolean propertyExists(Object obj) {
        return this.documentProperties.containsKey(obj);
    }

    public void setTagged() {
        if (!this.open) {
            this.tagged = true;
            return;
        }
        throw new IllegalArgumentException("Tagging must be set before opening the document.");
    }

    public boolean isTagged() {
        return this.tagged;
    }

    public PdfStructureTreeRoot getStructureTreeRoot() {
        if (this.tagged && this.structureTreeRoot == null) {
            this.structureTreeRoot = new PdfStructureTreeRoot(this);
        }
        return this.structureTreeRoot;
    }

    public PdfOCProperties getOCProperties() {
        fillOCProperties(true);
        return this.OCProperties;
    }

    public void addOCGRadioGroup(ArrayList arrayList) {
        PdfArray pdfArray = new PdfArray();
        for (int i = 0; i < arrayList.size(); i++) {
            PdfLayer pdfLayer = (PdfLayer) arrayList.get(i);
            if (pdfLayer.getTitle() == null) {
                pdfArray.add((PdfObject) pdfLayer.getRef());
            }
        }
        if (pdfArray.size() != 0) {
            this.OCGRadioGroup.add((PdfObject) pdfArray);
        }
    }

    public void lockLayer(PdfLayer pdfLayer) {
        this.OCGLocked.add((PdfObject) pdfLayer.getRef());
    }

    private static void getOCGOrder(PdfArray pdfArray, PdfLayer pdfLayer) {
        if (pdfLayer.isOnPanel()) {
            if (pdfLayer.getTitle() == null) {
                pdfArray.add((PdfObject) pdfLayer.getRef());
            }
            ArrayList children = pdfLayer.getChildren();
            if (children != null) {
                PdfArray pdfArray2 = new PdfArray();
                if (pdfLayer.getTitle() != null) {
                    pdfArray2.add((PdfObject) new PdfString(pdfLayer.getTitle(), PdfObject.TEXT_UNICODE));
                }
                for (int i = 0; i < children.size(); i++) {
                    getOCGOrder(pdfArray2, (PdfLayer) children.get(i));
                }
                if (pdfArray2.size() > 0) {
                    pdfArray.add((PdfObject) pdfArray2);
                }
            }
        }
    }

    private void addASEvent(PdfName pdfName, PdfName pdfName2) {
        PdfArray pdfArray = new PdfArray();
        Iterator it = this.documentOCG.iterator();
        while (it.hasNext()) {
            PdfLayer pdfLayer = (PdfLayer) it.next();
            PdfDictionary pdfDictionary = (PdfDictionary) pdfLayer.get(PdfName.USAGE);
            if (!(pdfDictionary == null || pdfDictionary.get(pdfName2) == null)) {
                pdfArray.add((PdfObject) pdfLayer.getRef());
            }
        }
        if (pdfArray.size() != 0) {
            PdfDictionary pdfDictionary2 = (PdfDictionary) this.OCProperties.get(PdfName.f661D);
            PdfArray pdfArray2 = (PdfArray) pdfDictionary2.get(PdfName.f645AS);
            if (pdfArray2 == null) {
                pdfArray2 = new PdfArray();
                pdfDictionary2.put(PdfName.f645AS, pdfArray2);
            }
            PdfDictionary pdfDictionary3 = new PdfDictionary();
            pdfDictionary3.put(PdfName.EVENT, pdfName);
            pdfDictionary3.put(PdfName.CATEGORY, new PdfArray((PdfObject) pdfName2));
            pdfDictionary3.put(PdfName.OCGS, pdfArray);
            pdfArray2.add((PdfObject) pdfDictionary3);
        }
    }

    /* access modifiers changed from: protected */
    public void fillOCProperties(boolean z) {
        if (this.OCProperties == null) {
            this.OCProperties = new PdfOCProperties();
        }
        if (z) {
            this.OCProperties.remove(PdfName.OCGS);
            this.OCProperties.remove(PdfName.f661D);
        }
        if (this.OCProperties.get(PdfName.OCGS) == null) {
            PdfArray pdfArray = new PdfArray();
            Iterator it = this.documentOCG.iterator();
            while (it.hasNext()) {
                pdfArray.add((PdfObject) ((PdfLayer) it.next()).getRef());
            }
            this.OCProperties.put(PdfName.OCGS, pdfArray);
        }
        if (this.OCProperties.get(PdfName.f661D) == null) {
            ArrayList arrayList = new ArrayList(this.documentOCGorder);
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                if (((PdfLayer) it2.next()).getParent() != null) {
                    it2.remove();
                }
            }
            PdfArray pdfArray2 = new PdfArray();
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                getOCGOrder(pdfArray2, (PdfLayer) it3.next());
            }
            PdfDictionary pdfDictionary = new PdfDictionary();
            this.OCProperties.put(PdfName.f661D, pdfDictionary);
            pdfDictionary.put(PdfName.ORDER, pdfArray2);
            PdfArray pdfArray3 = new PdfArray();
            Iterator it4 = this.documentOCG.iterator();
            while (it4.hasNext()) {
                PdfLayer pdfLayer = (PdfLayer) it4.next();
                if (!pdfLayer.isOn()) {
                    pdfArray3.add((PdfObject) pdfLayer.getRef());
                }
            }
            if (pdfArray3.size() > 0) {
                pdfDictionary.put(PdfName.OFF, pdfArray3);
            }
            if (this.OCGRadioGroup.size() > 0) {
                pdfDictionary.put(PdfName.RBGROUPS, this.OCGRadioGroup);
            }
            if (this.OCGLocked.size() > 0) {
                pdfDictionary.put(PdfName.LOCKED, this.OCGLocked);
            }
            addASEvent(PdfName.VIEW, PdfName.ZOOM);
            addASEvent(PdfName.VIEW, PdfName.VIEW);
            addASEvent(PdfName.PRINT, PdfName.PRINT);
            addASEvent(PdfName.EXPORT, PdfName.EXPORT);
            pdfDictionary.put(PdfName.LISTMODE, PdfName.VISIBLEPAGES);
        }
    }

    /* access modifiers changed from: package-private */
    public void registerLayer(PdfOCG pdfOCG) {
        PdfXConformanceImp.checkPDFXConformance(this, 7, (Object) null);
        if (!(pdfOCG instanceof PdfLayer)) {
            throw new IllegalArgumentException("Only PdfLayer is accepted.");
        } else if (((PdfLayer) pdfOCG).getTitle() != null) {
            this.documentOCGorder.add(pdfOCG);
        } else if (!this.documentOCG.contains(pdfOCG)) {
            this.documentOCG.add(pdfOCG);
            this.documentOCGorder.add(pdfOCG);
        }
    }

    public Rectangle getPageSize() {
        return this.pdf.getPageSize();
    }

    public void setCropBoxSize(Rectangle rectangle) {
        this.pdf.setCropBoxSize(rectangle);
    }

    public void setBoxSize(String str, Rectangle rectangle) {
        this.pdf.setBoxSize(str, rectangle);
    }

    public Rectangle getBoxSize(String str) {
        return this.pdf.getBoxSize(str);
    }

    public void setPageEmpty(boolean z) {
        this.pdf.setPageEmpty(z);
    }

    public void setPageAction(PdfName pdfName, PdfAction pdfAction) throws DocumentException {
        if (pdfName.equals(PAGE_OPEN) || pdfName.equals(PAGE_CLOSE)) {
            this.pdf.setPageAction(pdfName, pdfAction);
            return;
        }
        throw new DocumentException("Invalid page additional action type: " + pdfName.toString());
    }

    public void setDuration(int i) {
        this.pdf.setDuration(i);
    }

    public void setTransition(PdfTransition pdfTransition) {
        this.pdf.setTransition(pdfTransition);
    }

    public void setThumbnail(Image image) throws PdfException, DocumentException {
        this.pdf.setThumbnail(image);
    }

    public PdfDictionary getGroup() {
        return this.group;
    }

    public void setGroup(PdfDictionary pdfDictionary) {
        this.group = pdfDictionary;
    }

    public float getSpaceCharRatio() {
        return this.spaceCharRatio;
    }

    public void setSpaceCharRatio(float f) {
        if (f < 0.001f) {
            this.spaceCharRatio = 0.001f;
        } else {
            this.spaceCharRatio = f;
        }
    }

    public void setRunDirection(int i) {
        if (i < 1 || i > 3) {
            throw new RuntimeException("Invalid run direction: " + i);
        }
        this.runDirection = i;
    }

    public int getRunDirection() {
        return this.runDirection;
    }

    public float getUserunit() {
        return this.userunit;
    }

    public void setUserunit(float f) throws DocumentException {
        if (f < 1.0f || f > 75000.0f) {
            throw new DocumentException("UserUnit should be a value between 1 and 75000.");
        }
        this.userunit = f;
        setAtLeastPdfVersion(VERSION_1_6);
    }

    public PdfDictionary getDefaultColorspace() {
        return this.defaultColorspace;
    }

    public void setDefaultColorspace(PdfName pdfName, PdfObject pdfObject) {
        if (pdfObject == null || pdfObject.isNull()) {
            this.defaultColorspace.remove(pdfName);
        }
        this.defaultColorspace.put(pdfName, pdfObject);
    }

    /* access modifiers changed from: package-private */
    public ColorDetails addSimplePatternColorspace(Color color) {
        int type = ExtendedColor.getType(color);
        if (type == 4 || type == 5) {
            throw new RuntimeException("An uncolored tile pattern can not have another pattern or shading as color.");
        } else if (type == 0) {
            if (this.patternColorspaceRGB == null) {
                this.patternColorspaceRGB = new ColorDetails(getColorspaceName(), this.body.getPdfIndirectReference(), (PdfSpotColor) null);
                PdfArray pdfArray = new PdfArray((PdfObject) PdfName.PATTERN);
                pdfArray.add((PdfObject) PdfName.DEVICERGB);
                addToBody((PdfObject) pdfArray, this.patternColorspaceRGB.getIndirectReference());
            }
            return this.patternColorspaceRGB;
        } else if (type == 1) {
            if (this.patternColorspaceGRAY == null) {
                this.patternColorspaceGRAY = new ColorDetails(getColorspaceName(), this.body.getPdfIndirectReference(), (PdfSpotColor) null);
                PdfArray pdfArray2 = new PdfArray((PdfObject) PdfName.PATTERN);
                pdfArray2.add((PdfObject) PdfName.DEVICEGRAY);
                addToBody((PdfObject) pdfArray2, this.patternColorspaceGRAY.getIndirectReference());
            }
            return this.patternColorspaceGRAY;
        } else if (type == 2) {
            if (this.patternColorspaceCMYK == null) {
                this.patternColorspaceCMYK = new ColorDetails(getColorspaceName(), this.body.getPdfIndirectReference(), (PdfSpotColor) null);
                PdfArray pdfArray3 = new PdfArray((PdfObject) PdfName.PATTERN);
                pdfArray3.add((PdfObject) PdfName.DEVICECMYK);
                addToBody((PdfObject) pdfArray3, this.patternColorspaceCMYK.getIndirectReference());
            }
            return this.patternColorspaceCMYK;
        } else if (type == 3) {
            try {
                ColorDetails addSimple = addSimple(((SpotColor) color).getPdfSpotColor());
                ColorDetails colorDetails = (ColorDetails) this.documentSpotPatterns.get(addSimple);
                if (colorDetails != null) {
                    return colorDetails;
                }
                ColorDetails colorDetails2 = new ColorDetails(getColorspaceName(), this.body.getPdfIndirectReference(), (PdfSpotColor) null);
                PdfArray pdfArray4 = new PdfArray((PdfObject) PdfName.PATTERN);
                pdfArray4.add((PdfObject) addSimple.getIndirectReference());
                addToBody((PdfObject) pdfArray4, colorDetails2.getIndirectReference());
                this.documentSpotPatterns.put(addSimple, colorDetails2);
                return colorDetails2;
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        } else {
            throw new RuntimeException("Invalid color type in PdfWriter.addSimplePatternColorspace().");
        }
    }

    public boolean isStrictImageSequence() {
        return this.pdf.isStrictImageSequence();
    }

    public void setStrictImageSequence(boolean z) {
        this.pdf.setStrictImageSequence(z);
    }

    public void clearTextWrap() throws DocumentException {
        this.pdf.clearTextWrap();
    }

    public PdfName addDirectImageSimple(Image image) throws PdfException, DocumentException {
        return addDirectImageSimple(image, (PdfIndirectReference) null);
    }

    public PdfName addDirectImageSimple(Image image, PdfIndirectReference pdfIndirectReference) throws PdfException, DocumentException {
        PdfName pdfName;
        byte[] globalBytes;
        if (this.images.containsKey(image.getMySerialId())) {
            return (PdfName) this.images.get(image.getMySerialId());
        }
        if (image.isImgTemplate()) {
            pdfName = new PdfName(HtmlTags.IMAGE + this.images.size());
            if (image instanceof ImgWMF) {
                try {
                    ((ImgWMF) image).readWMF(PdfTemplate.createTemplate(this, 0.0f, 0.0f));
                } catch (Exception e) {
                    throw new DocumentException(e);
                }
            }
        } else {
            PdfIndirectReference directReference = image.getDirectReference();
            if (directReference != null) {
                PdfName pdfName2 = new PdfName(HtmlTags.IMAGE + this.images.size());
                this.images.put(image.getMySerialId(), pdfName2);
                this.imageDictionary.put(pdfName2, directReference);
                return pdfName2;
            }
            Image imageMask = image.getImageMask();
            PdfIndirectReference pdfIndirectReference2 = null;
            if (imageMask != null) {
                pdfIndirectReference2 = getImageReference((PdfName) this.images.get(imageMask.getMySerialId()));
            }
            PdfImage pdfImage = new PdfImage(image, HtmlTags.IMAGE + this.images.size(), pdfIndirectReference2);
            if ((image instanceof ImgJBIG2) && (globalBytes = ((ImgJBIG2) image).getGlobalBytes()) != null) {
                PdfDictionary pdfDictionary = new PdfDictionary();
                pdfDictionary.put(PdfName.JBIG2GLOBALS, getReferenceJBIG2Globals(globalBytes));
                pdfImage.put(PdfName.DECODEPARMS, pdfDictionary);
            }
            add(pdfImage, pdfIndirectReference);
            pdfName = pdfImage.name();
        }
        this.images.put(image.getMySerialId(), pdfName);
        return pdfName;
    }

    /* access modifiers changed from: package-private */
    public PdfIndirectReference add(PdfImage pdfImage, PdfIndirectReference pdfIndirectReference) throws PdfException {
        if (this.imageDictionary.contains(pdfImage.name())) {
            return (PdfIndirectReference) this.imageDictionary.get(pdfImage.name());
        }
        PdfXConformanceImp.checkPDFXConformance(this, 5, pdfImage);
        if (pdfIndirectReference instanceof PRIndirectReference) {
            PRIndirectReference pRIndirectReference = (PRIndirectReference) pdfIndirectReference;
            pdfIndirectReference = new PdfIndirectReference(0, getNewObjectNumber(pRIndirectReference.getReader(), pRIndirectReference.getNumber(), pRIndirectReference.getGeneration()));
        }
        if (pdfIndirectReference == null) {
            try {
                pdfIndirectReference = addToBody(pdfImage).getIndirectReference();
            } catch (IOException e) {
                throw new ExceptionConverter(e);
            }
        } else {
            addToBody((PdfObject) pdfImage, pdfIndirectReference);
        }
        this.imageDictionary.put(pdfImage.name(), pdfIndirectReference);
        return pdfIndirectReference;
    }

    /* access modifiers changed from: package-private */
    public PdfIndirectReference getImageReference(PdfName pdfName) {
        return (PdfIndirectReference) this.imageDictionary.get(pdfName);
    }

    /* access modifiers changed from: protected */
    public PdfIndirectReference getReferenceJBIG2Globals(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        for (PdfStream pdfStream : this.JBIG2Globals.keySet()) {
            if (Arrays.equals(bArr, pdfStream.getBytes())) {
                return (PdfIndirectReference) this.JBIG2Globals.get(pdfStream);
            }
        }
        PdfStream pdfStream2 = new PdfStream(bArr);
        try {
            PdfIndirectObject addToBody = addToBody(pdfStream2);
            this.JBIG2Globals.put(pdfStream2, addToBody.getIndirectReference());
            return addToBody.getIndirectReference();
        } catch (IOException unused) {
            return null;
        }
    }

    public boolean fitsPage(Table table, float f) {
        return this.pdf.bottom(table) > this.pdf.indentBottom() + f;
    }

    public boolean fitsPage(Table table) {
        return fitsPage(table, 0.0f);
    }

    public boolean isUserProperties() {
        return this.userProperties;
    }

    public void setUserProperties(boolean z) {
        this.userProperties = z;
    }

    public boolean isRgbTransparencyBlending() {
        return this.rgbTransparencyBlending;
    }

    public void setRgbTransparencyBlending(boolean z) {
        this.rgbTransparencyBlending = z;
    }
}
