package com.lowagie.text;

import com.lowagie.text.pdf.PRIndirectReference;
import com.lowagie.text.pdf.PdfArray;
import com.lowagie.text.pdf.PdfDictionary;
import com.lowagie.text.pdf.PdfIndirectReference;
import com.lowagie.text.pdf.PdfName;
import com.lowagie.text.pdf.PdfNumber;
import com.lowagie.text.pdf.PdfOCG;
import com.lowagie.text.pdf.PdfObject;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfTemplate;
import com.lowagie.text.pdf.codec.CCITTG4Encoder;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public abstract class Image extends Rectangle {

    /* renamed from: AX */
    public static final int f574AX = 0;

    /* renamed from: AY */
    public static final int f575AY = 1;

    /* renamed from: BX */
    public static final int f576BX = 2;

    /* renamed from: BY */
    public static final int f577BY = 3;

    /* renamed from: CX */
    public static final int f578CX = 4;

    /* renamed from: CY */
    public static final int f579CY = 5;
    public static final int DEFAULT = 0;

    /* renamed from: DX */
    public static final int f580DX = 6;

    /* renamed from: DY */
    public static final int f581DY = 7;
    public static final int LEFT = 0;
    public static final int MIDDLE = 1;
    public static final int ORIGINAL_BMP = 4;
    public static final int ORIGINAL_GIF = 3;
    public static final int ORIGINAL_JBIG2 = 9;
    public static final int ORIGINAL_JPEG = 1;
    public static final int ORIGINAL_JPEG2000 = 8;
    public static final int ORIGINAL_NONE = 0;
    public static final int ORIGINAL_PNG = 2;
    public static final int ORIGINAL_PS = 7;
    public static final int ORIGINAL_TIFF = 5;
    public static final int ORIGINAL_WMF = 6;
    public static final int RIGHT = 2;
    public static final int TEXTWRAP = 4;
    public static final int UNDERLYING = 8;
    static long serialId;
    private float XYRatio = 0.0f;
    protected float absoluteX = Float.NaN;
    protected float absoluteY = Float.NaN;
    private PdfDictionary additional = null;
    protected int alignment;
    protected String alt;
    protected Annotation annotation = null;
    protected int bpc = 1;
    protected int colorspace = -1;
    protected int compressionLevel = -1;
    protected boolean deflated = false;
    private PdfIndirectReference directReference;
    protected int dpiX = 0;
    protected int dpiY = 0;
    protected Image imageMask;
    protected float indentationLeft = 0.0f;
    protected float indentationRight = 0.0f;
    private float initialRotation;
    protected boolean interpolation;
    protected boolean invert = false;
    protected PdfOCG layer;
    protected boolean mask = false;
    protected Long mySerialId = getSerialId();
    protected byte[] originalData;
    protected int originalType = 0;
    protected float plainHeight;
    protected float plainWidth;
    protected byte[] rawData;
    protected float rotationRadians;
    protected float scaledHeight;
    protected float scaledWidth;
    private boolean smask;
    protected float spacingAfter;
    protected float spacingBefore;
    protected PdfTemplate[] template = new PdfTemplate[1];
    protected int[] transparency;
    protected int type;
    protected URL url;
    private float widthPercentage = 100.0f;

    public boolean isNestable() {
        return true;
    }

    public Image(URL url2) {
        super(0.0f, 0.0f);
        this.url = url2;
        this.alignment = 0;
        this.rotationRadians = 0.0f;
    }

    /* JADX WARNING: Removed duplicated region for block: B:110:0x013a A[Catch:{ all -> 0x00e6, all -> 0x015d }] */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0160  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00ec A[Catch:{ all -> 0x00e6, all -> 0x015d }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:100:0x012a=Splitter:B:100:0x012a, B:69:0x00dc=Splitter:B:69:0x00dc, B:64:0x00be=Splitter:B:64:0x00be} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.lowagie.text.Image getInstance(java.net.URL r15) throws com.lowagie.text.BadElementException, java.net.MalformedURLException, java.io.IOException {
        /*
            r0 = 0
            java.io.InputStream r1 = com.google.firebase.perf.network.FirebasePerfUrlConnection.openStream(r15)     // Catch:{ all -> 0x015d }
            int r2 = r1.read()     // Catch:{ all -> 0x015a }
            int r3 = r1.read()     // Catch:{ all -> 0x015a }
            int r4 = r1.read()     // Catch:{ all -> 0x015a }
            int r5 = r1.read()     // Catch:{ all -> 0x015a }
            int r6 = r1.read()     // Catch:{ all -> 0x015a }
            int r7 = r1.read()     // Catch:{ all -> 0x015a }
            int r8 = r1.read()     // Catch:{ all -> 0x015a }
            int r9 = r1.read()     // Catch:{ all -> 0x015a }
            r1.close()     // Catch:{ all -> 0x015a }
            r1 = 71
            r10 = 73
            r11 = 1
            if (r2 != r1) goto L_0x003f
            if (r3 != r10) goto L_0x003f
            r1 = 70
            if (r4 != r1) goto L_0x003f
            com.lowagie.text.pdf.codec.GifImage r1 = new com.lowagie.text.pdf.codec.GifImage     // Catch:{ all -> 0x015d }
            r1.<init>((java.net.URL) r15)     // Catch:{ all -> 0x015d }
            com.lowagie.text.Image r15 = r1.getImage(r11)     // Catch:{ all -> 0x015d }
            return r15
        L_0x003f:
            r1 = 255(0xff, float:3.57E-43)
            if (r2 != r1) goto L_0x004d
            r12 = 216(0xd8, float:3.03E-43)
            if (r3 != r12) goto L_0x004d
            com.lowagie.text.Jpeg r1 = new com.lowagie.text.Jpeg     // Catch:{ all -> 0x015d }
            r1.<init>((java.net.URL) r15)     // Catch:{ all -> 0x015d }
            return r1
        L_0x004d:
            if (r2 != 0) goto L_0x005d
            if (r3 != 0) goto L_0x005d
            if (r4 != 0) goto L_0x005d
            r12 = 12
            if (r5 != r12) goto L_0x005d
            com.lowagie.text.Jpeg2000 r1 = new com.lowagie.text.Jpeg2000     // Catch:{ all -> 0x015d }
            r1.<init>((java.net.URL) r15)     // Catch:{ all -> 0x015d }
            return r1
        L_0x005d:
            if (r2 != r1) goto L_0x006f
            r12 = 79
            if (r3 != r12) goto L_0x006f
            if (r4 != r1) goto L_0x006f
            r1 = 81
            if (r5 != r1) goto L_0x006f
            com.lowagie.text.Jpeg2000 r1 = new com.lowagie.text.Jpeg2000     // Catch:{ all -> 0x015d }
            r1.<init>((java.net.URL) r15)     // Catch:{ all -> 0x015d }
            return r1
        L_0x006f:
            int[] r1 = com.lowagie.text.pdf.codec.PngImage.PNGID     // Catch:{ all -> 0x015d }
            r12 = 0
            r1 = r1[r12]     // Catch:{ all -> 0x015d }
            if (r2 != r1) goto L_0x008f
            int[] r1 = com.lowagie.text.pdf.codec.PngImage.PNGID     // Catch:{ all -> 0x015d }
            r1 = r1[r11]     // Catch:{ all -> 0x015d }
            if (r3 != r1) goto L_0x008f
            int[] r1 = com.lowagie.text.pdf.codec.PngImage.PNGID     // Catch:{ all -> 0x015d }
            r12 = 2
            r1 = r1[r12]     // Catch:{ all -> 0x015d }
            if (r4 != r1) goto L_0x008f
            int[] r1 = com.lowagie.text.pdf.codec.PngImage.PNGID     // Catch:{ all -> 0x015d }
            r12 = 3
            r1 = r1[r12]     // Catch:{ all -> 0x015d }
            if (r5 != r1) goto L_0x008f
            com.lowagie.text.Image r15 = com.lowagie.text.pdf.codec.PngImage.getImage((java.net.URL) r15)     // Catch:{ all -> 0x015d }
            return r15
        L_0x008f:
            r1 = 215(0xd7, float:3.01E-43)
            if (r2 != r1) goto L_0x009d
            r1 = 205(0xcd, float:2.87E-43)
            if (r3 != r1) goto L_0x009d
            com.lowagie.text.ImgWMF r1 = new com.lowagie.text.ImgWMF     // Catch:{ all -> 0x015d }
            r1.<init>((java.net.URL) r15)     // Catch:{ all -> 0x015d }
            return r1
        L_0x009d:
            r1 = 66
            r12 = 77
            if (r2 != r1) goto L_0x00aa
            if (r3 != r12) goto L_0x00aa
            com.lowagie.text.Image r15 = com.lowagie.text.pdf.codec.BmpImage.getImage((java.net.URL) r15)     // Catch:{ all -> 0x015d }
            return r15
        L_0x00aa:
            java.lang.String r13 = "file"
            r14 = 42
            if (r2 != r12) goto L_0x00b6
            if (r3 != r12) goto L_0x00b6
            if (r4 != 0) goto L_0x00b6
            if (r5 == r14) goto L_0x00be
        L_0x00b6:
            if (r2 != r10) goto L_0x00f0
            if (r3 != r10) goto L_0x00f0
            if (r4 != r14) goto L_0x00f0
            if (r5 != 0) goto L_0x00f0
        L_0x00be:
            java.lang.String r1 = r15.getProtocol()     // Catch:{ all -> 0x00e8 }
            boolean r1 = r1.equals(r13)     // Catch:{ all -> 0x00e8 }
            if (r1 == 0) goto L_0x00d7
            java.lang.String r1 = r15.getFile()     // Catch:{ all -> 0x00e8 }
            java.lang.String r1 = com.lowagie.text.Utilities.unEscapeURL(r1)     // Catch:{ all -> 0x00e8 }
            com.lowagie.text.pdf.RandomAccessFileOrArray r2 = new com.lowagie.text.pdf.RandomAccessFileOrArray     // Catch:{ all -> 0x00e8 }
            r2.<init>((java.lang.String) r1)     // Catch:{ all -> 0x00e8 }
            r1 = r2
            goto L_0x00dc
        L_0x00d7:
            com.lowagie.text.pdf.RandomAccessFileOrArray r1 = new com.lowagie.text.pdf.RandomAccessFileOrArray     // Catch:{ all -> 0x00e8 }
            r1.<init>((java.net.URL) r15)     // Catch:{ all -> 0x00e8 }
        L_0x00dc:
            com.lowagie.text.Image r2 = com.lowagie.text.pdf.codec.TiffImage.getTiffImage(r1, r11)     // Catch:{ all -> 0x00e6 }
            r2.url = r15     // Catch:{ all -> 0x00e6 }
            r1.close()     // Catch:{ all -> 0x015d }
            return r2
        L_0x00e6:
            r15 = move-exception
            goto L_0x00ea
        L_0x00e8:
            r15 = move-exception
            r1 = r0
        L_0x00ea:
            if (r1 == 0) goto L_0x00ef
            r1.close()     // Catch:{ all -> 0x015d }
        L_0x00ef:
            throw r15     // Catch:{ all -> 0x015d }
        L_0x00f0:
            r10 = 151(0x97, float:2.12E-43)
            if (r2 != r10) goto L_0x013e
            r2 = 74
            if (r3 != r2) goto L_0x013e
            if (r4 != r1) goto L_0x013e
            r1 = 50
            if (r5 != r1) goto L_0x013e
            r1 = 13
            if (r6 != r1) goto L_0x013e
            r1 = 10
            if (r7 != r1) goto L_0x013e
            r2 = 26
            if (r8 != r2) goto L_0x013e
            if (r9 != r1) goto L_0x013e
            java.lang.String r1 = r15.getProtocol()     // Catch:{ all -> 0x0136 }
            boolean r1 = r1.equals(r13)     // Catch:{ all -> 0x0136 }
            if (r1 == 0) goto L_0x0125
            java.lang.String r1 = r15.getFile()     // Catch:{ all -> 0x0136 }
            java.lang.String r1 = com.lowagie.text.Utilities.unEscapeURL(r1)     // Catch:{ all -> 0x0136 }
            com.lowagie.text.pdf.RandomAccessFileOrArray r2 = new com.lowagie.text.pdf.RandomAccessFileOrArray     // Catch:{ all -> 0x0136 }
            r2.<init>((java.lang.String) r1)     // Catch:{ all -> 0x0136 }
            r1 = r2
            goto L_0x012a
        L_0x0125:
            com.lowagie.text.pdf.RandomAccessFileOrArray r1 = new com.lowagie.text.pdf.RandomAccessFileOrArray     // Catch:{ all -> 0x0136 }
            r1.<init>((java.net.URL) r15)     // Catch:{ all -> 0x0136 }
        L_0x012a:
            com.lowagie.text.Image r2 = com.lowagie.text.pdf.codec.JBIG2Image.getJbig2Image(r1, r11)     // Catch:{ all -> 0x0134 }
            r2.url = r15     // Catch:{ all -> 0x0134 }
            r1.close()     // Catch:{ all -> 0x015d }
            return r2
        L_0x0134:
            r15 = move-exception
            goto L_0x0138
        L_0x0136:
            r15 = move-exception
            r1 = r0
        L_0x0138:
            if (r1 == 0) goto L_0x013d
            r1.close()     // Catch:{ all -> 0x015d }
        L_0x013d:
            throw r15     // Catch:{ all -> 0x015d }
        L_0x013e:
            java.io.IOException r1 = new java.io.IOException     // Catch:{ all -> 0x015d }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x015d }
            java.lang.String r15 = r15.toString()     // Catch:{ all -> 0x015d }
            java.lang.String r15 = java.lang.String.valueOf(r15)     // Catch:{ all -> 0x015d }
            r2.<init>(r15)     // Catch:{ all -> 0x015d }
            java.lang.String r15 = " is not a recognized imageformat."
            r2.append(r15)     // Catch:{ all -> 0x015d }
            java.lang.String r15 = r2.toString()     // Catch:{ all -> 0x015d }
            r1.<init>(r15)     // Catch:{ all -> 0x015d }
            throw r1     // Catch:{ all -> 0x015d }
        L_0x015a:
            r15 = move-exception
            r0 = r1
            goto L_0x015e
        L_0x015d:
            r15 = move-exception
        L_0x015e:
            if (r0 == 0) goto L_0x0163
            r0.close()
        L_0x0163:
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.Image.getInstance(java.net.URL):com.lowagie.text.Image");
    }

    public static Image getInstance(String str) throws BadElementException, MalformedURLException, IOException {
        return getInstance(Utilities.toURL(str));
    }

    /* JADX WARNING: Removed duplicated region for block: B:115:0x0138 A[SYNTHETIC, Splitter:B:115:0x0138] */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00c9 A[Catch:{ all -> 0x00c3, all -> 0x0148 }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:64:0x00ad=Splitter:B:64:0x00ad, B:119:0x013d=Splitter:B:119:0x013d, B:70:0x00bf=Splitter:B:70:0x00bf} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.lowagie.text.Image getInstance(byte[] r11) throws com.lowagie.text.BadElementException, java.net.MalformedURLException, java.io.IOException {
        /*
            r0 = 0
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x0148 }
            r1.<init>(r11)     // Catch:{ all -> 0x0148 }
            int r2 = r1.read()     // Catch:{ all -> 0x0145 }
            int r3 = r1.read()     // Catch:{ all -> 0x0145 }
            int r4 = r1.read()     // Catch:{ all -> 0x0145 }
            int r5 = r1.read()     // Catch:{ all -> 0x0145 }
            r1.close()     // Catch:{ all -> 0x0145 }
            r1 = 71
            r6 = 73
            r7 = 1
            if (r2 != r1) goto L_0x0030
            if (r3 != r6) goto L_0x0030
            r1 = 70
            if (r4 != r1) goto L_0x0030
            com.lowagie.text.pdf.codec.GifImage r1 = new com.lowagie.text.pdf.codec.GifImage     // Catch:{ all -> 0x0148 }
            r1.<init>((byte[]) r11)     // Catch:{ all -> 0x0148 }
            com.lowagie.text.Image r11 = r1.getImage(r7)     // Catch:{ all -> 0x0148 }
            return r11
        L_0x0030:
            r1 = 255(0xff, float:3.57E-43)
            if (r2 != r1) goto L_0x003e
            r8 = 216(0xd8, float:3.03E-43)
            if (r3 != r8) goto L_0x003e
            com.lowagie.text.Jpeg r1 = new com.lowagie.text.Jpeg     // Catch:{ all -> 0x0148 }
            r1.<init>((byte[]) r11)     // Catch:{ all -> 0x0148 }
            return r1
        L_0x003e:
            if (r2 != 0) goto L_0x004e
            if (r3 != 0) goto L_0x004e
            if (r4 != 0) goto L_0x004e
            r8 = 12
            if (r5 != r8) goto L_0x004e
            com.lowagie.text.Jpeg2000 r1 = new com.lowagie.text.Jpeg2000     // Catch:{ all -> 0x0148 }
            r1.<init>((byte[]) r11)     // Catch:{ all -> 0x0148 }
            return r1
        L_0x004e:
            if (r2 != r1) goto L_0x0060
            r8 = 79
            if (r3 != r8) goto L_0x0060
            if (r4 != r1) goto L_0x0060
            r1 = 81
            if (r5 != r1) goto L_0x0060
            com.lowagie.text.Jpeg2000 r1 = new com.lowagie.text.Jpeg2000     // Catch:{ all -> 0x0148 }
            r1.<init>((byte[]) r11)     // Catch:{ all -> 0x0148 }
            return r1
        L_0x0060:
            int[] r1 = com.lowagie.text.pdf.codec.PngImage.PNGID     // Catch:{ all -> 0x0148 }
            r8 = 0
            r1 = r1[r8]     // Catch:{ all -> 0x0148 }
            r8 = 2
            if (r2 != r1) goto L_0x0080
            int[] r1 = com.lowagie.text.pdf.codec.PngImage.PNGID     // Catch:{ all -> 0x0148 }
            r1 = r1[r7]     // Catch:{ all -> 0x0148 }
            if (r3 != r1) goto L_0x0080
            int[] r1 = com.lowagie.text.pdf.codec.PngImage.PNGID     // Catch:{ all -> 0x0148 }
            r1 = r1[r8]     // Catch:{ all -> 0x0148 }
            if (r4 != r1) goto L_0x0080
            int[] r1 = com.lowagie.text.pdf.codec.PngImage.PNGID     // Catch:{ all -> 0x0148 }
            r9 = 3
            r1 = r1[r9]     // Catch:{ all -> 0x0148 }
            if (r5 != r1) goto L_0x0080
            com.lowagie.text.Image r11 = com.lowagie.text.pdf.codec.PngImage.getImage((byte[]) r11)     // Catch:{ all -> 0x0148 }
            return r11
        L_0x0080:
            r1 = 215(0xd7, float:3.01E-43)
            if (r2 != r1) goto L_0x008e
            r1 = 205(0xcd, float:2.87E-43)
            if (r3 != r1) goto L_0x008e
            com.lowagie.text.ImgWMF r1 = new com.lowagie.text.ImgWMF     // Catch:{ all -> 0x0148 }
            r1.<init>((byte[]) r11)     // Catch:{ all -> 0x0148 }
            return r1
        L_0x008e:
            r1 = 66
            r9 = 77
            if (r2 != r1) goto L_0x009b
            if (r3 != r9) goto L_0x009b
            com.lowagie.text.Image r11 = com.lowagie.text.pdf.codec.BmpImage.getImage((byte[]) r11)     // Catch:{ all -> 0x0148 }
            return r11
        L_0x009b:
            r10 = 42
            if (r2 != r9) goto L_0x00a5
            if (r3 != r9) goto L_0x00a5
            if (r4 != 0) goto L_0x00a5
            if (r5 == r10) goto L_0x00ad
        L_0x00a5:
            if (r2 != r6) goto L_0x00cd
            if (r3 != r6) goto L_0x00cd
            if (r4 != r10) goto L_0x00cd
            if (r5 != 0) goto L_0x00cd
        L_0x00ad:
            com.lowagie.text.pdf.RandomAccessFileOrArray r1 = new com.lowagie.text.pdf.RandomAccessFileOrArray     // Catch:{ all -> 0x00c5 }
            r1.<init>((byte[]) r11)     // Catch:{ all -> 0x00c5 }
            com.lowagie.text.Image r2 = com.lowagie.text.pdf.codec.TiffImage.getTiffImage(r1, r7)     // Catch:{ all -> 0x00c3 }
            byte[] r3 = r2.getOriginalData()     // Catch:{ all -> 0x00c3 }
            if (r3 != 0) goto L_0x00bf
            r2.setOriginalData(r11)     // Catch:{ all -> 0x00c3 }
        L_0x00bf:
            r1.close()     // Catch:{ all -> 0x0148 }
            return r2
        L_0x00c3:
            r11 = move-exception
            goto L_0x00c7
        L_0x00c5:
            r11 = move-exception
            r1 = r0
        L_0x00c7:
            if (r1 == 0) goto L_0x00cc
            r1.close()     // Catch:{ all -> 0x0148 }
        L_0x00cc:
            throw r11     // Catch:{ all -> 0x0148 }
        L_0x00cd:
            r6 = 151(0x97, float:2.12E-43)
            if (r2 != r6) goto L_0x013d
            r2 = 74
            if (r3 != r2) goto L_0x013d
            if (r4 != r1) goto L_0x013d
            r1 = 50
            if (r5 != r1) goto L_0x013d
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x0148 }
            r1.<init>(r11)     // Catch:{ all -> 0x0148 }
            r2 = 4
            r1.skip(r2)     // Catch:{ all -> 0x0145 }
            int r2 = r1.read()     // Catch:{ all -> 0x0145 }
            int r3 = r1.read()     // Catch:{ all -> 0x0145 }
            int r4 = r1.read()     // Catch:{ all -> 0x0145 }
            int r5 = r1.read()     // Catch:{ all -> 0x0145 }
            r6 = 13
            if (r2 != r6) goto L_0x013c
            r2 = 10
            if (r3 != r2) goto L_0x013c
            r3 = 26
            if (r4 != r3) goto L_0x013c
            if (r5 != r2) goto L_0x013c
            int r2 = r1.read()     // Catch:{ all -> 0x0145 }
            r2 = r2 & r8
            if (r2 != r8) goto L_0x0116
            r1.read()     // Catch:{ all -> 0x0145 }
            r1.read()     // Catch:{ all -> 0x0145 }
            r1.read()     // Catch:{ all -> 0x0145 }
            r1.read()     // Catch:{ all -> 0x0145 }
        L_0x0116:
            r1.close()     // Catch:{ all -> 0x0145 }
            com.lowagie.text.pdf.RandomAccessFileOrArray r2 = new com.lowagie.text.pdf.RandomAccessFileOrArray     // Catch:{ all -> 0x0134 }
            r2.<init>((byte[]) r11)     // Catch:{ all -> 0x0134 }
            com.lowagie.text.Image r0 = com.lowagie.text.pdf.codec.JBIG2Image.getJbig2Image(r2, r7)     // Catch:{ all -> 0x0132 }
            byte[] r3 = r0.getOriginalData()     // Catch:{ all -> 0x0132 }
            if (r3 != 0) goto L_0x012b
            r0.setOriginalData(r11)     // Catch:{ all -> 0x0132 }
        L_0x012b:
            r2.close()     // Catch:{ all -> 0x0145 }
            r1.close()
            return r0
        L_0x0132:
            r11 = move-exception
            goto L_0x0136
        L_0x0134:
            r11 = move-exception
            r2 = r0
        L_0x0136:
            if (r2 == 0) goto L_0x013b
            r2.close()     // Catch:{ all -> 0x0145 }
        L_0x013b:
            throw r11     // Catch:{ all -> 0x0145 }
        L_0x013c:
            r0 = r1
        L_0x013d:
            java.io.IOException r11 = new java.io.IOException     // Catch:{ all -> 0x0148 }
            java.lang.String r1 = "The byte array is not a recognized imageformat."
            r11.<init>(r1)     // Catch:{ all -> 0x0148 }
            throw r11     // Catch:{ all -> 0x0148 }
        L_0x0145:
            r11 = move-exception
            r0 = r1
            goto L_0x0149
        L_0x0148:
            r11 = move-exception
        L_0x0149:
            if (r0 == 0) goto L_0x014e
            r0.close()
        L_0x014e:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.Image.getInstance(byte[]):com.lowagie.text.Image");
    }

    public static Image getInstance(int i, int i2, int i3, int i4, byte[] bArr) throws BadElementException {
        return getInstance(i, i2, i3, i4, bArr, (int[]) null);
    }

    public static Image getInstance(int i, int i2, byte[] bArr, byte[] bArr2) {
        return new ImgJBIG2(i, i2, bArr, bArr2);
    }

    public static Image getInstance(int i, int i2, boolean z, int i3, int i4, byte[] bArr) throws BadElementException {
        return getInstance(i, i2, z, i3, i4, bArr, (int[]) null);
    }

    public static Image getInstance(int i, int i2, boolean z, int i3, int i4, byte[] bArr, int[] iArr) throws BadElementException {
        if (iArr == null || iArr.length == 2) {
            ImgCCITT imgCCITT = new ImgCCITT(i, i2, z, i3, i4, bArr);
            imgCCITT.transparency = iArr;
            return imgCCITT;
        }
        throw new BadElementException("Transparency length must be equal to 2 with CCITT images");
    }

    public static Image getInstance(int i, int i2, int i3, int i4, byte[] bArr, int[] iArr) throws BadElementException {
        if (iArr != null && iArr.length != i3 * 2) {
            throw new BadElementException("Transparency length must be equal to (componentes * 2)");
        } else if (i3 == 1 && i4 == 1) {
            return getInstance(i, i2, false, 256, 1, CCITTG4Encoder.compress(bArr, i, i2), iArr);
        } else {
            ImgRaw imgRaw = new ImgRaw(i, i2, i3, i4, bArr);
            imgRaw.transparency = iArr;
            return imgRaw;
        }
    }

    public static Image getInstance(PdfTemplate pdfTemplate) throws BadElementException {
        return new ImgTemplate(pdfTemplate);
    }

    public PdfIndirectReference getDirectReference() {
        return this.directReference;
    }

    public void setDirectReference(PdfIndirectReference pdfIndirectReference) {
        this.directReference = pdfIndirectReference;
    }

    public static Image getInstance(PRIndirectReference pRIndirectReference) throws BadElementException {
        Image image;
        PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.getPdfObjectRelease((PdfObject) pRIndirectReference);
        int intValue = ((PdfNumber) PdfReader.getPdfObjectRelease(pdfDictionary.get(PdfName.WIDTH))).intValue();
        int intValue2 = ((PdfNumber) PdfReader.getPdfObjectRelease(pdfDictionary.get(PdfName.HEIGHT))).intValue();
        PdfObject pdfObject = pdfDictionary.get(PdfName.SMASK);
        if (pdfObject == null || !pdfObject.isIndirect()) {
            PdfObject pdfObject2 = pdfDictionary.get(PdfName.MASK);
            image = (pdfObject2 == null || !pdfObject2.isIndirect() || !(PdfReader.getPdfObjectRelease(pdfObject2) instanceof PdfDictionary)) ? null : getInstance((PRIndirectReference) pdfObject2);
        } else {
            image = getInstance((PRIndirectReference) pdfObject);
        }
        ImgRaw imgRaw = new ImgRaw(intValue, intValue2, 1, 1, (byte[]) null);
        imgRaw.imageMask = image;
        imgRaw.directReference = pRIndirectReference;
        return imgRaw;
    }

    protected Image(Image image) {
        super(image);
        this.type = image.type;
        this.url = image.url;
        this.rawData = image.rawData;
        this.bpc = image.bpc;
        this.template = image.template;
        this.alignment = image.alignment;
        this.alt = image.alt;
        this.absoluteX = image.absoluteX;
        this.absoluteY = image.absoluteY;
        this.plainWidth = image.plainWidth;
        this.plainHeight = image.plainHeight;
        this.scaledWidth = image.scaledWidth;
        this.scaledHeight = image.scaledHeight;
        this.mySerialId = image.mySerialId;
        this.directReference = image.directReference;
        this.rotationRadians = image.rotationRadians;
        this.initialRotation = image.initialRotation;
        this.indentationLeft = image.indentationLeft;
        this.indentationRight = image.indentationRight;
        this.spacingBefore = image.spacingBefore;
        this.spacingAfter = image.spacingAfter;
        this.widthPercentage = image.widthPercentage;
        this.annotation = image.annotation;
        this.layer = image.layer;
        this.interpolation = image.interpolation;
        this.originalType = image.originalType;
        this.originalData = image.originalData;
        this.deflated = image.deflated;
        this.dpiX = image.dpiX;
        this.dpiY = image.dpiY;
        this.XYRatio = image.XYRatio;
        this.colorspace = image.colorspace;
        this.invert = image.invert;
        this.additional = image.additional;
        this.mask = image.mask;
        this.imageMask = image.imageMask;
        this.smask = image.smask;
        this.transparency = image.transparency;
    }

    public static Image getInstance(Image image) {
        if (image == null) {
            return null;
        }
        try {
            return (Image) image.getClass().getDeclaredConstructor(new Class[]{Image.class}).newInstance(new Object[]{image});
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public int type() {
        return this.type;
    }

    public boolean isJpeg() {
        return this.type == 32;
    }

    public boolean isImgRaw() {
        return this.type == 34;
    }

    public boolean isImgTemplate() {
        return this.type == 35;
    }

    public URL getUrl() {
        return this.url;
    }

    public void setUrl(URL url2) {
        this.url = url2;
    }

    public byte[] getRawData() {
        return this.rawData;
    }

    public int getBpc() {
        return this.bpc;
    }

    public PdfTemplate getTemplateData() {
        return this.template[0];
    }

    public void setTemplateData(PdfTemplate pdfTemplate) {
        this.template[0] = pdfTemplate;
    }

    public int getAlignment() {
        return this.alignment;
    }

    public void setAlignment(int i) {
        this.alignment = i;
    }

    public String getAlt() {
        return this.alt;
    }

    public void setAlt(String str) {
        this.alt = str;
    }

    public void setAbsolutePosition(float f, float f2) {
        this.absoluteX = f;
        this.absoluteY = f2;
    }

    public boolean hasAbsoluteX() {
        return !Float.isNaN(this.absoluteX);
    }

    public float getAbsoluteX() {
        return this.absoluteX;
    }

    public boolean hasAbsoluteY() {
        return !Float.isNaN(this.absoluteY);
    }

    public float getAbsoluteY() {
        return this.absoluteY;
    }

    public float getScaledWidth() {
        return this.scaledWidth;
    }

    public float getScaledHeight() {
        return this.scaledHeight;
    }

    public float getPlainWidth() {
        return this.plainWidth;
    }

    public float getPlainHeight() {
        return this.plainHeight;
    }

    public void scaleAbsolute(float f, float f2) {
        this.plainWidth = f;
        this.plainHeight = f2;
        float[] matrix = matrix();
        this.scaledWidth = matrix[6] - matrix[4];
        this.scaledHeight = matrix[7] - matrix[5];
        setWidthPercentage(0.0f);
    }

    public void scaleAbsoluteWidth(float f) {
        this.plainWidth = f;
        float[] matrix = matrix();
        this.scaledWidth = matrix[6] - matrix[4];
        this.scaledHeight = matrix[7] - matrix[5];
        setWidthPercentage(0.0f);
    }

    public void scaleAbsoluteHeight(float f) {
        this.plainHeight = f;
        float[] matrix = matrix();
        this.scaledWidth = matrix[6] - matrix[4];
        this.scaledHeight = matrix[7] - matrix[5];
        setWidthPercentage(0.0f);
    }

    public void scalePercent(float f) {
        scalePercent(f, f);
    }

    public void scalePercent(float f, float f2) {
        this.plainWidth = (getWidth() * f) / 100.0f;
        this.plainHeight = (getHeight() * f2) / 100.0f;
        float[] matrix = matrix();
        this.scaledWidth = matrix[6] - matrix[4];
        this.scaledHeight = matrix[7] - matrix[5];
        setWidthPercentage(0.0f);
    }

    public void scaleToFit(float f, float f2) {
        scalePercent(100.0f);
        float scaledWidth2 = (f * 100.0f) / getScaledWidth();
        float scaledHeight2 = (f2 * 100.0f) / getScaledHeight();
        if (scaledWidth2 >= scaledHeight2) {
            scaledWidth2 = scaledHeight2;
        }
        scalePercent(scaledWidth2);
        setWidthPercentage(0.0f);
    }

    public float[] matrix() {
        float[] fArr = new float[8];
        float cos = (float) Math.cos((double) this.rotationRadians);
        float sin = (float) Math.sin((double) this.rotationRadians);
        float f = this.plainWidth;
        fArr[0] = f * cos;
        fArr[1] = f * sin;
        float f2 = this.plainHeight;
        fArr[2] = (-f2) * sin;
        fArr[3] = f2 * cos;
        float f3 = this.rotationRadians;
        if (((double) f3) < 1.5707963267948966d) {
            fArr[4] = fArr[2];
            fArr[5] = 0.0f;
            fArr[6] = fArr[0];
            fArr[7] = fArr[1] + fArr[3];
        } else if (((double) f3) < 3.141592653589793d) {
            fArr[4] = fArr[0] + fArr[2];
            fArr[5] = fArr[3];
            fArr[6] = 0.0f;
            fArr[7] = fArr[1];
        } else if (((double) f3) < 4.71238898038469d) {
            fArr[4] = fArr[0];
            fArr[5] = fArr[1] + fArr[3];
            fArr[6] = fArr[2];
            fArr[7] = 0.0f;
        } else {
            fArr[4] = 0.0f;
            fArr[5] = fArr[1];
            fArr[6] = fArr[0] + fArr[2];
            fArr[7] = fArr[3];
        }
        return fArr;
    }

    protected static synchronized Long getSerialId() {
        Long l;
        synchronized (Image.class) {
            serialId++;
            l = new Long(serialId);
        }
        return l;
    }

    public Long getMySerialId() {
        return this.mySerialId;
    }

    public float getImageRotation() {
        float f = (float) (((double) (this.rotationRadians - this.initialRotation)) % 6.283185307179586d);
        return f < 0.0f ? (float) (((double) f) + 6.283185307179586d) : f;
    }

    public void setRotation(float f) {
        this.rotationRadians = (float) (((double) (f + this.initialRotation)) % 6.283185307179586d);
        float f2 = this.rotationRadians;
        if (f2 < 0.0f) {
            this.rotationRadians = (float) (((double) f2) + 6.283185307179586d);
        }
        float[] matrix = matrix();
        this.scaledWidth = matrix[6] - matrix[4];
        this.scaledHeight = matrix[7] - matrix[5];
    }

    public void setRotationDegrees(float f) {
        setRotation((f / 180.0f) * ((float) 3.141592653589793d));
    }

    public float getInitialRotation() {
        return this.initialRotation;
    }

    public void setInitialRotation(float f) {
        this.initialRotation = f;
        setRotation(this.rotationRadians - this.initialRotation);
    }

    public float getIndentationLeft() {
        return this.indentationLeft;
    }

    public void setIndentationLeft(float f) {
        this.indentationLeft = f;
    }

    public float getIndentationRight() {
        return this.indentationRight;
    }

    public void setIndentationRight(float f) {
        this.indentationRight = f;
    }

    public float getSpacingBefore() {
        return this.spacingBefore;
    }

    public void setSpacingBefore(float f) {
        this.spacingBefore = f;
    }

    public float getSpacingAfter() {
        return this.spacingAfter;
    }

    public void setSpacingAfter(float f) {
        this.spacingAfter = f;
    }

    public float getWidthPercentage() {
        return this.widthPercentage;
    }

    public void setWidthPercentage(float f) {
        this.widthPercentage = f;
    }

    public void setAnnotation(Annotation annotation2) {
        this.annotation = annotation2;
    }

    public Annotation getAnnotation() {
        return this.annotation;
    }

    public PdfOCG getLayer() {
        return this.layer;
    }

    public void setLayer(PdfOCG pdfOCG) {
        this.layer = pdfOCG;
    }

    public boolean isInterpolation() {
        return this.interpolation;
    }

    public void setInterpolation(boolean z) {
        this.interpolation = z;
    }

    public int getOriginalType() {
        return this.originalType;
    }

    public void setOriginalType(int i) {
        this.originalType = i;
    }

    public byte[] getOriginalData() {
        return this.originalData;
    }

    public void setOriginalData(byte[] bArr) {
        this.originalData = bArr;
    }

    public boolean isDeflated() {
        return this.deflated;
    }

    public void setDeflated(boolean z) {
        this.deflated = z;
    }

    public int getDpiX() {
        return this.dpiX;
    }

    public int getDpiY() {
        return this.dpiY;
    }

    public void setDpi(int i, int i2) {
        this.dpiX = i;
        this.dpiY = i2;
    }

    public float getXYRatio() {
        return this.XYRatio;
    }

    public void setXYRatio(float f) {
        this.XYRatio = f;
    }

    public int getColorspace() {
        return this.colorspace;
    }

    public boolean isInverted() {
        return this.invert;
    }

    public void setInverted(boolean z) {
        this.invert = z;
    }

    public PdfDictionary getAdditional() {
        return this.additional;
    }

    public void setAdditional(PdfDictionary pdfDictionary) {
        this.additional = pdfDictionary;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: com.lowagie.text.pdf.PdfArray} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.lowagie.text.pdf.PdfObject} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: com.lowagie.text.pdf.PdfArray} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: com.lowagie.text.pdf.PdfArray} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void simplifyColorspace() {
        /*
            r3 = this;
            com.lowagie.text.pdf.PdfDictionary r0 = r3.additional
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            com.lowagie.text.pdf.PdfName r1 = com.lowagie.text.pdf.PdfName.COLORSPACE
            com.lowagie.text.pdf.PdfArray r0 = r0.getAsArray(r1)
            if (r0 != 0) goto L_0x000e
            return
        L_0x000e:
            com.lowagie.text.pdf.PdfObject r1 = r3.simplifyColorspace(r0)
            boolean r2 = r1.isName()
            if (r2 == 0) goto L_0x001a
            r0 = r1
            goto L_0x003c
        L_0x001a:
            r1 = 0
            com.lowagie.text.pdf.PdfName r1 = r0.getAsName(r1)
            com.lowagie.text.pdf.PdfName r2 = com.lowagie.text.pdf.PdfName.INDEXED
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x003c
            int r1 = r0.size()
            r2 = 2
            if (r1 < r2) goto L_0x003c
            r1 = 1
            com.lowagie.text.pdf.PdfArray r2 = r0.getAsArray(r1)
            if (r2 == 0) goto L_0x003c
            com.lowagie.text.pdf.PdfObject r2 = r3.simplifyColorspace(r2)
            r0.set(r1, r2)
        L_0x003c:
            com.lowagie.text.pdf.PdfDictionary r1 = r3.additional
            com.lowagie.text.pdf.PdfName r2 = com.lowagie.text.pdf.PdfName.COLORSPACE
            r1.put(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.Image.simplifyColorspace():void");
    }

    private PdfObject simplifyColorspace(PdfArray pdfArray) {
        if (pdfArray == null) {
            return pdfArray;
        }
        PdfName asName = pdfArray.getAsName(0);
        if (PdfName.CALGRAY.equals(asName)) {
            return PdfName.DEVICEGRAY;
        }
        return PdfName.CALRGB.equals(asName) ? PdfName.DEVICERGB : pdfArray;
    }

    public boolean isMask() {
        return this.mask;
    }

    public void makeMask() throws DocumentException {
        if (isMaskCandidate()) {
            this.mask = true;
            return;
        }
        throw new DocumentException("This image can not be an image mask.");
    }

    public boolean isMaskCandidate() {
        if ((this.type != 34 || this.bpc <= 255) && this.colorspace != 1) {
            return false;
        }
        return true;
    }

    public Image getImageMask() {
        return this.imageMask;
    }

    public void setImageMask(Image image) throws DocumentException {
        if (this.mask) {
            throw new DocumentException("An image mask cannot contain another image mask.");
        } else if (image.mask) {
            this.imageMask = image;
            int i = image.bpc;
            boolean z = true;
            if (i <= 1 || i > 8) {
                z = false;
            }
            this.smask = z;
        } else {
            throw new DocumentException("The image mask is not a mask. Did you do makeMask()?");
        }
    }

    public boolean isSmask() {
        return this.smask;
    }

    public void setSmask(boolean z) {
        this.smask = z;
    }

    public int[] getTransparency() {
        return this.transparency;
    }

    public void setTransparency(int[] iArr) {
        this.transparency = iArr;
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
}
