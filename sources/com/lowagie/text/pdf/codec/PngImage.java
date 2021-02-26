package com.lowagie.text.pdf.codec;

import com.lowagie.text.Image;
import com.lowagie.text.Utilities;
import com.lowagie.text.pdf.ByteBuffer;
import com.lowagie.text.pdf.PdfArray;
import com.lowagie.text.pdf.PdfDictionary;
import com.lowagie.text.pdf.PdfLiteral;
import com.lowagie.text.pdf.PdfName;
import com.lowagie.text.pdf.PdfNumber;
import com.lowagie.text.pdf.PdfObject;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfString;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

public class PngImage {
    public static final String IDAT = "IDAT";
    public static final String IEND = "IEND";
    public static final String IHDR = "IHDR";
    public static final String PLTE = "PLTE";
    public static final int[] PNGID = {137, 80, 78, 71, 13, 10, 26, 10};
    private static final int PNG_FILTER_AVERAGE = 3;
    private static final int PNG_FILTER_NONE = 0;
    private static final int PNG_FILTER_PAETH = 4;
    private static final int PNG_FILTER_SUB = 1;
    private static final int PNG_FILTER_UP = 2;
    private static final int TRANSFERSIZE = 4096;
    public static final String cHRM = "cHRM";
    public static final String gAMA = "gAMA";
    public static final String iCCP = "iCCP";
    private static final PdfName[] intents = {PdfName.PERCEPTUAL, PdfName.RELATIVECOLORIMETRIC, PdfName.SATURATION, PdfName.ABSOLUTECOLORIMETRIC};
    public static final String pHYs = "pHYs";
    public static final String sRGB = "sRGB";
    public static final String tRNS = "tRNS";
    float XYRatio;
    PdfDictionary additional = new PdfDictionary();
    int bitDepth;
    int bytesPerPixel;
    byte[] colorTable;
    int colorType;
    int compressionMethod;
    DataInputStream dataStream;
    int dpiX;
    int dpiY;
    int filterMethod;
    float gamma = 1.0f;
    boolean genBWMask;
    boolean hasCHRM = false;
    int height;
    NewByteArrayOutputStream idat = new NewByteArrayOutputStream();
    byte[] image;
    int inputBands;
    PdfName intent;
    int interlaceMethod;

    /* renamed from: is */
    InputStream f777is;
    boolean palShades;
    byte[] smask;
    byte[] trans;
    int transBlue = -1;
    int transGreen = -1;
    int transRedGray = -1;
    int width;

    /* renamed from: xB */
    float f778xB;

    /* renamed from: xG */
    float f779xG;

    /* renamed from: xR */
    float f780xR;

    /* renamed from: xW */
    float f781xW;

    /* renamed from: yB */
    float f782yB;

    /* renamed from: yG */
    float f783yG;

    /* renamed from: yR */
    float f784yR;

    /* renamed from: yW */
    float f785yW;

    PngImage(InputStream inputStream) {
        this.f777is = inputStream;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0017  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.lowagie.text.Image getImage(java.net.URL r2) throws java.io.IOException {
        /*
            java.io.InputStream r0 = com.google.firebase.perf.network.FirebasePerfUrlConnection.openStream(r2)     // Catch:{ all -> 0x0013 }
            com.lowagie.text.Image r1 = getImage((java.io.InputStream) r0)     // Catch:{ all -> 0x0011 }
            r1.setUrl(r2)     // Catch:{ all -> 0x0011 }
            if (r0 == 0) goto L_0x0010
            r0.close()
        L_0x0010:
            return r1
        L_0x0011:
            r2 = move-exception
            goto L_0x0015
        L_0x0013:
            r2 = move-exception
            r0 = 0
        L_0x0015:
            if (r0 == 0) goto L_0x001a
            r0.close()
        L_0x001a:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.codec.PngImage.getImage(java.net.URL):com.lowagie.text.Image");
    }

    public static Image getImage(InputStream inputStream) throws IOException {
        return new PngImage(inputStream).getImage();
    }

    public static Image getImage(String str) throws IOException {
        return getImage(Utilities.toURL(str));
    }

    public static Image getImage(byte[] bArr) throws IOException {
        Image image2 = getImage((InputStream) new ByteArrayInputStream(bArr));
        image2.setOriginalData(bArr);
        return image2;
    }

    /* access modifiers changed from: package-private */
    public boolean checkMarker(String str) {
        if (str.length() != 4) {
            return false;
        }
        for (int i = 0; i < 4; i++) {
            char charAt = str.charAt(i);
            if ((charAt < 'a' || charAt > 'z') && (charAt < 'A' || charAt > 'Z')) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void readPng() throws IOException {
        int i = 0;
        while (true) {
            int[] iArr = PNGID;
            if (i >= iArr.length) {
                byte[] bArr = new byte[4096];
                while (true) {
                    int i2 = getInt(this.f777is);
                    String string = getString(this.f777is);
                    if (i2 >= 0 && checkMarker(string)) {
                        if (IDAT.equals(string)) {
                            while (i2 != 0) {
                                int read = this.f777is.read(bArr, 0, Math.min(i2, 4096));
                                if (read >= 0) {
                                    this.idat.write(bArr, 0, read);
                                    i2 -= read;
                                } else {
                                    return;
                                }
                            }
                            continue;
                        } else if (tRNS.equals(string)) {
                            int i3 = this.colorType;
                            if (i3 != 0) {
                                if (i3 != 2) {
                                    if (i3 == 3 && i2 > 0) {
                                        this.trans = new byte[i2];
                                        for (int i4 = 0; i4 < i2; i4++) {
                                            this.trans[i4] = (byte) this.f777is.read();
                                        }
                                        i2 = 0;
                                    }
                                } else if (i2 >= 6) {
                                    i2 -= 6;
                                    int word = getWord(this.f777is);
                                    int word2 = getWord(this.f777is);
                                    int word3 = getWord(this.f777is);
                                    if (this.bitDepth == 16) {
                                        this.transRedGray = word;
                                        this.transGreen = word2;
                                        this.transBlue = word3;
                                    } else {
                                        this.additional.put(PdfName.MASK, new PdfLiteral("[" + word + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + word + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + word2 + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + word2 + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + word3 + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + word3 + "]"));
                                    }
                                }
                            } else if (i2 >= 2) {
                                i2 -= 2;
                                int word4 = getWord(this.f777is);
                                if (this.bitDepth == 16) {
                                    this.transRedGray = word4;
                                } else {
                                    this.additional.put(PdfName.MASK, new PdfLiteral("[" + word4 + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + word4 + "]"));
                                }
                            }
                            Utilities.skip(this.f777is, i2);
                        } else if (IHDR.equals(string)) {
                            this.width = getInt(this.f777is);
                            this.height = getInt(this.f777is);
                            this.bitDepth = this.f777is.read();
                            this.colorType = this.f777is.read();
                            this.compressionMethod = this.f777is.read();
                            this.filterMethod = this.f777is.read();
                            this.interlaceMethod = this.f777is.read();
                        } else {
                            boolean z = true;
                            if (PLTE.equals(string)) {
                                if (this.colorType == 3) {
                                    PdfArray pdfArray = new PdfArray();
                                    pdfArray.add((PdfObject) PdfName.INDEXED);
                                    pdfArray.add(getColorspace());
                                    pdfArray.add((PdfObject) new PdfNumber((i2 / 3) - 1));
                                    ByteBuffer byteBuffer = new ByteBuffer();
                                    while (true) {
                                        int i5 = i2 - 1;
                                        if (i2 <= 0) {
                                            break;
                                        }
                                        byteBuffer.append_i(this.f777is.read());
                                        i2 = i5;
                                    }
                                    byte[] byteArray = byteBuffer.toByteArray();
                                    this.colorTable = byteArray;
                                    pdfArray.add((PdfObject) new PdfString(byteArray));
                                    this.additional.put(PdfName.COLORSPACE, pdfArray);
                                } else {
                                    Utilities.skip(this.f777is, i2);
                                }
                            } else if (pHYs.equals(string)) {
                                int i6 = getInt(this.f777is);
                                int i7 = getInt(this.f777is);
                                if (this.f777is.read() == 1) {
                                    this.dpiX = (int) ((((float) i6) * 0.0254f) + 0.5f);
                                    this.dpiY = (int) ((((float) i7) * 0.0254f) + 0.5f);
                                } else if (i7 != 0) {
                                    this.XYRatio = ((float) i6) / ((float) i7);
                                }
                            } else if (cHRM.equals(string)) {
                                this.f781xW = ((float) getInt(this.f777is)) / 100000.0f;
                                this.f785yW = ((float) getInt(this.f777is)) / 100000.0f;
                                this.f780xR = ((float) getInt(this.f777is)) / 100000.0f;
                                this.f784yR = ((float) getInt(this.f777is)) / 100000.0f;
                                this.f779xG = ((float) getInt(this.f777is)) / 100000.0f;
                                this.f783yG = ((float) getInt(this.f777is)) / 100000.0f;
                                this.f778xB = ((float) getInt(this.f777is)) / 100000.0f;
                                this.f782yB = ((float) getInt(this.f777is)) / 100000.0f;
                                if (Math.abs(this.f781xW) < 1.0E-4f || Math.abs(this.f785yW) < 1.0E-4f || Math.abs(this.f780xR) < 1.0E-4f || Math.abs(this.f784yR) < 1.0E-4f || Math.abs(this.f779xG) < 1.0E-4f || Math.abs(this.f783yG) < 1.0E-4f || Math.abs(this.f778xB) < 1.0E-4f || Math.abs(this.f782yB) < 1.0E-4f) {
                                    z = false;
                                }
                                this.hasCHRM = z;
                            } else if (sRGB.equals(string)) {
                                this.intent = intents[this.f777is.read()];
                                this.gamma = 2.2f;
                                this.f781xW = 0.3127f;
                                this.f785yW = 0.329f;
                                this.f780xR = 0.64f;
                                this.f784yR = 0.33f;
                                this.f779xG = 0.3f;
                                this.f783yG = 0.6f;
                                this.f778xB = 0.15f;
                                this.f782yB = 0.06f;
                                this.hasCHRM = true;
                            } else if (gAMA.equals(string)) {
                                int i8 = getInt(this.f777is);
                                if (i8 != 0) {
                                    this.gamma = 100000.0f / ((float) i8);
                                    if (!this.hasCHRM) {
                                        this.f781xW = 0.3127f;
                                        this.f785yW = 0.329f;
                                        this.f780xR = 0.64f;
                                        this.f784yR = 0.33f;
                                        this.f779xG = 0.3f;
                                        this.f783yG = 0.6f;
                                        this.f778xB = 0.15f;
                                        this.f782yB = 0.06f;
                                        this.hasCHRM = true;
                                    }
                                }
                            } else if (iCCP.equals(string)) {
                                do {
                                    i2--;
                                } while (this.f777is.read() != 0);
                                this.f777is.read();
                                int i9 = i2 - 1;
                                byte[] bArr2 = new byte[i9];
                                int i10 = 0;
                                while (i9 > 0) {
                                    int read2 = this.f777is.read(bArr2, i10, i9);
                                    if (read2 >= 0) {
                                        i10 += read2;
                                        i9 -= read2;
                                    } else {
                                        throw new IOException("Premature end of file.");
                                    }
                                }
                                PdfReader.FlateDecode(bArr2, true);
                            } else if (!IEND.equals(string)) {
                                Utilities.skip(this.f777is, i2);
                            } else {
                                return;
                            }
                        }
                        Utilities.skip(this.f777is, 4);
                    }
                }
                throw new IOException("Corrupted PNG file.");
            } else if (iArr[i] == this.f777is.read()) {
                i++;
            } else {
                throw new IOException("File is not a valid PNG.");
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: com.lowagie.text.pdf.PdfLiteral} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: com.lowagie.text.pdf.PdfLiteral} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: com.lowagie.text.pdf.PdfArray} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: com.lowagie.text.pdf.PdfLiteral} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.lowagie.text.pdf.PdfObject getColorspace() {
        /*
            r19 = this;
            r0 = r19
            float r1 = r0.gamma
            r2 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 != 0) goto L_0x001a
            boolean r1 = r0.hasCHRM
            if (r1 != 0) goto L_0x001a
            int r1 = r0.colorType
            r1 = r1 & 2
            if (r1 != 0) goto L_0x0017
            com.lowagie.text.pdf.PdfName r1 = com.lowagie.text.pdf.PdfName.DEVICEGRAY
            return r1
        L_0x0017:
            com.lowagie.text.pdf.PdfName r1 = com.lowagie.text.pdf.PdfName.DEVICERGB
            return r1
        L_0x001a:
            com.lowagie.text.pdf.PdfArray r1 = new com.lowagie.text.pdf.PdfArray
            r1.<init>()
            com.lowagie.text.pdf.PdfDictionary r3 = new com.lowagie.text.pdf.PdfDictionary
            r3.<init>()
            int r4 = r0.colorType
            r4 = r4 & 2
            java.lang.String r5 = "[1 1 1]"
            if (r4 != 0) goto L_0x0055
            float r4 = r0.gamma
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 != 0) goto L_0x0035
            com.lowagie.text.pdf.PdfName r1 = com.lowagie.text.pdf.PdfName.DEVICEGRAY
            return r1
        L_0x0035:
            com.lowagie.text.pdf.PdfName r2 = com.lowagie.text.pdf.PdfName.CALGRAY
            r1.add((com.lowagie.text.pdf.PdfObject) r2)
            com.lowagie.text.pdf.PdfName r2 = com.lowagie.text.pdf.PdfName.GAMMA
            com.lowagie.text.pdf.PdfNumber r4 = new com.lowagie.text.pdf.PdfNumber
            float r6 = r0.gamma
            r4.<init>((float) r6)
            r3.put(r2, r4)
            com.lowagie.text.pdf.PdfName r2 = com.lowagie.text.pdf.PdfName.WHITEPOINT
            com.lowagie.text.pdf.PdfLiteral r4 = new com.lowagie.text.pdf.PdfLiteral
            r4.<init>((java.lang.String) r5)
            r3.put(r2, r4)
            r1.add((com.lowagie.text.pdf.PdfObject) r3)
            goto L_0x017c
        L_0x0055:
            com.lowagie.text.pdf.PdfLiteral r4 = new com.lowagie.text.pdf.PdfLiteral
            r4.<init>((java.lang.String) r5)
            com.lowagie.text.pdf.PdfName r5 = com.lowagie.text.pdf.PdfName.CALRGB
            r1.add((com.lowagie.text.pdf.PdfObject) r5)
            float r5 = r0.gamma
            int r5 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r5 == 0) goto L_0x007f
            com.lowagie.text.pdf.PdfArray r5 = new com.lowagie.text.pdf.PdfArray
            r5.<init>()
            com.lowagie.text.pdf.PdfNumber r6 = new com.lowagie.text.pdf.PdfNumber
            float r7 = r0.gamma
            r6.<init>((float) r7)
            r5.add((com.lowagie.text.pdf.PdfObject) r6)
            r5.add((com.lowagie.text.pdf.PdfObject) r6)
            r5.add((com.lowagie.text.pdf.PdfObject) r6)
            com.lowagie.text.pdf.PdfName r6 = com.lowagie.text.pdf.PdfName.GAMMA
            r3.put(r6, r5)
        L_0x007f:
            boolean r5 = r0.hasCHRM
            if (r5 == 0) goto L_0x0174
            float r4 = r0.f785yW
            float r5 = r0.f779xG
            float r6 = r0.f778xB
            float r7 = r5 - r6
            float r8 = r0.f784yR
            float r7 = r7 * r8
            float r9 = r0.f780xR
            float r10 = r9 - r6
            float r11 = r0.f783yG
            float r10 = r10 * r11
            float r7 = r7 - r10
            float r10 = r9 - r5
            float r12 = r0.f782yB
            float r10 = r10 * r12
            float r7 = r7 + r10
            float r7 = r7 * r4
            float r10 = r5 - r6
            float r10 = r10 * r4
            float r13 = r0.f781xW
            float r14 = r13 - r6
            float r14 = r14 * r11
            float r10 = r10 - r14
            float r14 = r13 - r5
            float r14 = r14 * r12
            float r10 = r10 + r14
            float r10 = r10 * r8
            float r10 = r10 / r7
            float r14 = r10 * r9
            float r14 = r14 / r8
            float r15 = r2 - r9
            float r15 = r15 / r8
            float r15 = r15 - r2
            float r15 = r15 * r10
            float r2 = -r11
            float r17 = r9 - r6
            float r17 = r17 * r4
            float r18 = r13 - r6
            float r18 = r18 * r8
            float r17 = r17 - r18
            float r8 = r13 - r9
            float r8 = r8 * r12
            float r17 = r17 + r8
            float r2 = r2 * r17
            float r2 = r2 / r7
            float r8 = r2 * r5
            float r8 = r8 / r11
            r16 = 1065353216(0x3f800000, float:1.0)
            float r17 = r16 - r5
            float r17 = r17 / r11
            float r17 = r17 - r16
            float r0 = r2 * r17
            float r17 = r9 - r5
            float r17 = r17 * r4
            float r5 = r13 - r5
            float r5 = r5 * r4
            float r17 = r17 - r5
            float r13 = r13 - r9
            float r13 = r13 * r11
            float r17 = r17 + r13
            float r17 = r17 * r12
            float r4 = r17 / r7
            float r5 = r4 * r6
            float r5 = r5 / r12
            r7 = 1065353216(0x3f800000, float:1.0)
            float r6 = r7 - r6
            float r6 = r6 / r12
            float r6 = r6 - r7
            float r6 = r6 * r4
            float r7 = r14 + r8
            float r7 = r7 + r5
            float r9 = r15 + r0
            float r9 = r9 + r6
            com.lowagie.text.pdf.PdfArray r11 = new com.lowagie.text.pdf.PdfArray
            r11.<init>()
            com.lowagie.text.pdf.PdfNumber r12 = new com.lowagie.text.pdf.PdfNumber
            r12.<init>((float) r7)
            r11.add((com.lowagie.text.pdf.PdfObject) r12)
            com.lowagie.text.pdf.PdfNumber r7 = new com.lowagie.text.pdf.PdfNumber
            r12 = 1065353216(0x3f800000, float:1.0)
            r7.<init>((float) r12)
            r11.add((com.lowagie.text.pdf.PdfObject) r7)
            com.lowagie.text.pdf.PdfNumber r7 = new com.lowagie.text.pdf.PdfNumber
            r7.<init>((float) r9)
            r11.add((com.lowagie.text.pdf.PdfObject) r7)
            com.lowagie.text.pdf.PdfArray r7 = new com.lowagie.text.pdf.PdfArray
            r7.<init>()
            com.lowagie.text.pdf.PdfNumber r9 = new com.lowagie.text.pdf.PdfNumber
            r9.<init>((float) r14)
            r7.add((com.lowagie.text.pdf.PdfObject) r9)
            com.lowagie.text.pdf.PdfNumber r9 = new com.lowagie.text.pdf.PdfNumber
            r9.<init>((float) r10)
            r7.add((com.lowagie.text.pdf.PdfObject) r9)
            com.lowagie.text.pdf.PdfNumber r9 = new com.lowagie.text.pdf.PdfNumber
            r9.<init>((float) r15)
            r7.add((com.lowagie.text.pdf.PdfObject) r9)
            com.lowagie.text.pdf.PdfNumber r9 = new com.lowagie.text.pdf.PdfNumber
            r9.<init>((float) r8)
            r7.add((com.lowagie.text.pdf.PdfObject) r9)
            com.lowagie.text.pdf.PdfNumber r8 = new com.lowagie.text.pdf.PdfNumber
            r8.<init>((float) r2)
            r7.add((com.lowagie.text.pdf.PdfObject) r8)
            com.lowagie.text.pdf.PdfNumber r2 = new com.lowagie.text.pdf.PdfNumber
            r2.<init>((float) r0)
            r7.add((com.lowagie.text.pdf.PdfObject) r2)
            com.lowagie.text.pdf.PdfNumber r0 = new com.lowagie.text.pdf.PdfNumber
            r0.<init>((float) r5)
            r7.add((com.lowagie.text.pdf.PdfObject) r0)
            com.lowagie.text.pdf.PdfNumber r0 = new com.lowagie.text.pdf.PdfNumber
            r0.<init>((float) r4)
            r7.add((com.lowagie.text.pdf.PdfObject) r0)
            com.lowagie.text.pdf.PdfNumber r0 = new com.lowagie.text.pdf.PdfNumber
            r0.<init>((float) r6)
            r7.add((com.lowagie.text.pdf.PdfObject) r0)
            com.lowagie.text.pdf.PdfName r0 = com.lowagie.text.pdf.PdfName.MATRIX
            r3.put(r0, r7)
            r4 = r11
        L_0x0174:
            com.lowagie.text.pdf.PdfName r0 = com.lowagie.text.pdf.PdfName.WHITEPOINT
            r3.put(r0, r4)
            r1.add((com.lowagie.text.pdf.PdfObject) r3)
        L_0x017c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.codec.PngImage.getColorspace():com.lowagie.text.pdf.PdfObject");
    }

    /* JADX WARNING: type inference failed for: r0v11, types: [com.lowagie.text.Image] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.lowagie.text.Image getImage() throws java.io.IOException {
        /*
            r13 = this;
            r13.readPng()
            r0 = 0
            r13.palShades = r0     // Catch:{ Exception -> 0x01a2 }
            byte[] r1 = r13.trans     // Catch:{ Exception -> 0x01a2 }
            r2 = 1
            if (r1 == 0) goto L_0x002a
            r1 = 0
            r3 = 0
            r4 = 0
        L_0x000e:
            byte[] r5 = r13.trans     // Catch:{ Exception -> 0x01a2 }
            int r5 = r5.length     // Catch:{ Exception -> 0x01a2 }
            if (r1 < r5) goto L_0x0014
            goto L_0x002c
        L_0x0014:
            byte[] r5 = r13.trans     // Catch:{ Exception -> 0x01a2 }
            byte r5 = r5[r1]     // Catch:{ Exception -> 0x01a2 }
            r6 = 255(0xff, float:3.57E-43)
            r5 = r5 & r6
            if (r5 != 0) goto L_0x0020
            int r3 = r3 + 1
            r4 = r1
        L_0x0020:
            if (r5 == 0) goto L_0x0027
            if (r5 == r6) goto L_0x0027
            r13.palShades = r2     // Catch:{ Exception -> 0x01a2 }
            goto L_0x002c
        L_0x0027:
            int r1 = r1 + 1
            goto L_0x000e
        L_0x002a:
            r3 = 0
            r4 = 0
        L_0x002c:
            int r1 = r13.colorType     // Catch:{ Exception -> 0x01a2 }
            r5 = 4
            r1 = r1 & r5
            if (r1 == 0) goto L_0x0034
            r13.palShades = r2     // Catch:{ Exception -> 0x01a2 }
        L_0x0034:
            boolean r1 = r13.palShades     // Catch:{ Exception -> 0x01a2 }
            if (r1 != 0) goto L_0x0040
            if (r3 > r2) goto L_0x003e
            int r1 = r13.transRedGray     // Catch:{ Exception -> 0x01a2 }
            if (r1 < 0) goto L_0x0040
        L_0x003e:
            r1 = 1
            goto L_0x0041
        L_0x0040:
            r1 = 0
        L_0x0041:
            r13.genBWMask = r1     // Catch:{ Exception -> 0x01a2 }
            boolean r1 = r13.palShades     // Catch:{ Exception -> 0x01a2 }
            if (r1 != 0) goto L_0x0074
            boolean r1 = r13.genBWMask     // Catch:{ Exception -> 0x01a2 }
            if (r1 != 0) goto L_0x0074
            if (r3 != r2) goto L_0x0074
            com.lowagie.text.pdf.PdfDictionary r1 = r13.additional     // Catch:{ Exception -> 0x01a2 }
            com.lowagie.text.pdf.PdfName r3 = com.lowagie.text.pdf.PdfName.MASK     // Catch:{ Exception -> 0x01a2 }
            com.lowagie.text.pdf.PdfLiteral r6 = new com.lowagie.text.pdf.PdfLiteral     // Catch:{ Exception -> 0x01a2 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01a2 }
            java.lang.String r8 = "["
            r7.<init>(r8)     // Catch:{ Exception -> 0x01a2 }
            r7.append(r4)     // Catch:{ Exception -> 0x01a2 }
            java.lang.String r8 = " "
            r7.append(r8)     // Catch:{ Exception -> 0x01a2 }
            r7.append(r4)     // Catch:{ Exception -> 0x01a2 }
            java.lang.String r4 = "]"
            r7.append(r4)     // Catch:{ Exception -> 0x01a2 }
            java.lang.String r4 = r7.toString()     // Catch:{ Exception -> 0x01a2 }
            r6.<init>((java.lang.String) r4)     // Catch:{ Exception -> 0x01a2 }
            r1.put(r3, r6)     // Catch:{ Exception -> 0x01a2 }
        L_0x0074:
            int r1 = r13.interlaceMethod     // Catch:{ Exception -> 0x01a2 }
            r3 = 16
            if (r1 == r2) goto L_0x008c
            int r1 = r13.bitDepth     // Catch:{ Exception -> 0x01a2 }
            if (r1 == r3) goto L_0x008c
            int r1 = r13.colorType     // Catch:{ Exception -> 0x01a2 }
            r1 = r1 & r5
            if (r1 != 0) goto L_0x008c
            boolean r1 = r13.palShades     // Catch:{ Exception -> 0x01a2 }
            if (r1 != 0) goto L_0x008c
            boolean r1 = r13.genBWMask     // Catch:{ Exception -> 0x01a2 }
            if (r1 != 0) goto L_0x008c
            goto L_0x008d
        L_0x008c:
            r0 = 1
        L_0x008d:
            int r1 = r13.colorType     // Catch:{ Exception -> 0x01a2 }
            r4 = 2
            r6 = 3
            if (r1 == 0) goto L_0x00a9
            r7 = 6
            if (r1 == r7) goto L_0x00a6
            if (r1 == r4) goto L_0x00a3
            if (r1 == r6) goto L_0x00a0
            if (r1 == r5) goto L_0x009d
            goto L_0x00ab
        L_0x009d:
            r13.inputBands = r4     // Catch:{ Exception -> 0x01a2 }
            goto L_0x00ab
        L_0x00a0:
            r13.inputBands = r2     // Catch:{ Exception -> 0x01a2 }
            goto L_0x00ab
        L_0x00a3:
            r13.inputBands = r6     // Catch:{ Exception -> 0x01a2 }
            goto L_0x00ab
        L_0x00a6:
            r13.inputBands = r5     // Catch:{ Exception -> 0x01a2 }
            goto L_0x00ab
        L_0x00a9:
            r13.inputBands = r2     // Catch:{ Exception -> 0x01a2 }
        L_0x00ab:
            if (r0 == 0) goto L_0x00b0
            r13.decodeIdat()     // Catch:{ Exception -> 0x01a2 }
        L_0x00b0:
            int r0 = r13.inputBands     // Catch:{ Exception -> 0x01a2 }
            int r1 = r13.colorType     // Catch:{ Exception -> 0x01a2 }
            r1 = r1 & r5
            if (r1 == 0) goto L_0x00b9
            int r0 = r0 + -1
        L_0x00b9:
            r10 = r0
            int r0 = r13.bitDepth     // Catch:{ Exception -> 0x01a2 }
            r1 = 8
            if (r0 != r3) goto L_0x00c3
            r11 = 8
            goto L_0x00c4
        L_0x00c3:
            r11 = r0
        L_0x00c4:
            byte[] r0 = r13.image     // Catch:{ Exception -> 0x01a2 }
            if (r0 == 0) goto L_0x00e4
            int r0 = r13.colorType     // Catch:{ Exception -> 0x01a2 }
            if (r0 != r6) goto L_0x00d9
            com.lowagie.text.ImgRaw r0 = new com.lowagie.text.ImgRaw     // Catch:{ Exception -> 0x01a2 }
            int r8 = r13.width     // Catch:{ Exception -> 0x01a2 }
            int r9 = r13.height     // Catch:{ Exception -> 0x01a2 }
            byte[] r12 = r13.image     // Catch:{ Exception -> 0x01a2 }
            r7 = r0
            r7.<init>(r8, r9, r10, r11, r12)     // Catch:{ Exception -> 0x01a2 }
            goto L_0x013b
        L_0x00d9:
            int r0 = r13.width     // Catch:{ Exception -> 0x01a2 }
            int r3 = r13.height     // Catch:{ Exception -> 0x01a2 }
            byte[] r5 = r13.image     // Catch:{ Exception -> 0x01a2 }
            com.lowagie.text.Image r0 = com.lowagie.text.Image.getInstance(r0, r3, r10, r11, r5)     // Catch:{ Exception -> 0x01a2 }
            goto L_0x013b
        L_0x00e4:
            com.lowagie.text.ImgRaw r0 = new com.lowagie.text.ImgRaw     // Catch:{ Exception -> 0x01a2 }
            int r8 = r13.width     // Catch:{ Exception -> 0x01a2 }
            int r9 = r13.height     // Catch:{ Exception -> 0x01a2 }
            com.lowagie.text.pdf.codec.PngImage$NewByteArrayOutputStream r3 = r13.idat     // Catch:{ Exception -> 0x01a2 }
            byte[] r12 = r3.toByteArray()     // Catch:{ Exception -> 0x01a2 }
            r7 = r0
            r7.<init>(r8, r9, r10, r11, r12)     // Catch:{ Exception -> 0x01a2 }
            r0.setDeflated(r2)     // Catch:{ Exception -> 0x01a2 }
            com.lowagie.text.pdf.PdfDictionary r3 = new com.lowagie.text.pdf.PdfDictionary     // Catch:{ Exception -> 0x01a2 }
            r3.<init>()     // Catch:{ Exception -> 0x01a2 }
            com.lowagie.text.pdf.PdfName r5 = com.lowagie.text.pdf.PdfName.BITSPERCOMPONENT     // Catch:{ Exception -> 0x01a2 }
            com.lowagie.text.pdf.PdfNumber r7 = new com.lowagie.text.pdf.PdfNumber     // Catch:{ Exception -> 0x01a2 }
            int r8 = r13.bitDepth     // Catch:{ Exception -> 0x01a2 }
            r7.<init>((int) r8)     // Catch:{ Exception -> 0x01a2 }
            r3.put(r5, r7)     // Catch:{ Exception -> 0x01a2 }
            com.lowagie.text.pdf.PdfName r5 = com.lowagie.text.pdf.PdfName.PREDICTOR     // Catch:{ Exception -> 0x01a2 }
            com.lowagie.text.pdf.PdfNumber r7 = new com.lowagie.text.pdf.PdfNumber     // Catch:{ Exception -> 0x01a2 }
            r8 = 15
            r7.<init>((int) r8)     // Catch:{ Exception -> 0x01a2 }
            r3.put(r5, r7)     // Catch:{ Exception -> 0x01a2 }
            com.lowagie.text.pdf.PdfName r5 = com.lowagie.text.pdf.PdfName.COLUMNS     // Catch:{ Exception -> 0x01a2 }
            com.lowagie.text.pdf.PdfNumber r7 = new com.lowagie.text.pdf.PdfNumber     // Catch:{ Exception -> 0x01a2 }
            int r8 = r13.width     // Catch:{ Exception -> 0x01a2 }
            r7.<init>((int) r8)     // Catch:{ Exception -> 0x01a2 }
            r3.put(r5, r7)     // Catch:{ Exception -> 0x01a2 }
            com.lowagie.text.pdf.PdfName r5 = com.lowagie.text.pdf.PdfName.COLORS     // Catch:{ Exception -> 0x01a2 }
            com.lowagie.text.pdf.PdfNumber r7 = new com.lowagie.text.pdf.PdfNumber     // Catch:{ Exception -> 0x01a2 }
            int r8 = r13.colorType     // Catch:{ Exception -> 0x01a2 }
            if (r8 == r6) goto L_0x012d
            int r8 = r13.colorType     // Catch:{ Exception -> 0x01a2 }
            r8 = r8 & r4
            if (r8 != 0) goto L_0x012e
        L_0x012d:
            r6 = 1
        L_0x012e:
            r7.<init>((int) r6)     // Catch:{ Exception -> 0x01a2 }
            r3.put(r5, r7)     // Catch:{ Exception -> 0x01a2 }
            com.lowagie.text.pdf.PdfDictionary r5 = r13.additional     // Catch:{ Exception -> 0x01a2 }
            com.lowagie.text.pdf.PdfName r6 = com.lowagie.text.pdf.PdfName.DECODEPARMS     // Catch:{ Exception -> 0x01a2 }
            r5.put(r6, r3)     // Catch:{ Exception -> 0x01a2 }
        L_0x013b:
            com.lowagie.text.pdf.PdfDictionary r3 = r13.additional     // Catch:{ Exception -> 0x01a2 }
            com.lowagie.text.pdf.PdfName r5 = com.lowagie.text.pdf.PdfName.COLORSPACE     // Catch:{ Exception -> 0x01a2 }
            com.lowagie.text.pdf.PdfObject r3 = r3.get(r5)     // Catch:{ Exception -> 0x01a2 }
            if (r3 != 0) goto L_0x0150
            com.lowagie.text.pdf.PdfDictionary r3 = r13.additional     // Catch:{ Exception -> 0x01a2 }
            com.lowagie.text.pdf.PdfName r5 = com.lowagie.text.pdf.PdfName.COLORSPACE     // Catch:{ Exception -> 0x01a2 }
            com.lowagie.text.pdf.PdfObject r6 = r13.getColorspace()     // Catch:{ Exception -> 0x01a2 }
            r3.put(r5, r6)     // Catch:{ Exception -> 0x01a2 }
        L_0x0150:
            com.lowagie.text.pdf.PdfName r3 = r13.intent     // Catch:{ Exception -> 0x01a2 }
            if (r3 == 0) goto L_0x015d
            com.lowagie.text.pdf.PdfDictionary r3 = r13.additional     // Catch:{ Exception -> 0x01a2 }
            com.lowagie.text.pdf.PdfName r5 = com.lowagie.text.pdf.PdfName.INTENT     // Catch:{ Exception -> 0x01a2 }
            com.lowagie.text.pdf.PdfName r6 = r13.intent     // Catch:{ Exception -> 0x01a2 }
            r3.put(r5, r6)     // Catch:{ Exception -> 0x01a2 }
        L_0x015d:
            com.lowagie.text.pdf.PdfDictionary r3 = r13.additional     // Catch:{ Exception -> 0x01a2 }
            int r3 = r3.size()     // Catch:{ Exception -> 0x01a2 }
            if (r3 <= 0) goto L_0x016a
            com.lowagie.text.pdf.PdfDictionary r3 = r13.additional     // Catch:{ Exception -> 0x01a2 }
            r0.setAdditional(r3)     // Catch:{ Exception -> 0x01a2 }
        L_0x016a:
            boolean r3 = r13.palShades     // Catch:{ Exception -> 0x01a2 }
            if (r3 == 0) goto L_0x017e
            int r3 = r13.width     // Catch:{ Exception -> 0x01a2 }
            int r5 = r13.height     // Catch:{ Exception -> 0x01a2 }
            byte[] r6 = r13.smask     // Catch:{ Exception -> 0x01a2 }
            com.lowagie.text.Image r1 = com.lowagie.text.Image.getInstance(r3, r5, r2, r1, r6)     // Catch:{ Exception -> 0x01a2 }
            r1.makeMask()     // Catch:{ Exception -> 0x01a2 }
            r0.setImageMask(r1)     // Catch:{ Exception -> 0x01a2 }
        L_0x017e:
            boolean r1 = r13.genBWMask     // Catch:{ Exception -> 0x01a2 }
            if (r1 == 0) goto L_0x0192
            int r1 = r13.width     // Catch:{ Exception -> 0x01a2 }
            int r3 = r13.height     // Catch:{ Exception -> 0x01a2 }
            byte[] r5 = r13.smask     // Catch:{ Exception -> 0x01a2 }
            com.lowagie.text.Image r1 = com.lowagie.text.Image.getInstance(r1, r3, r2, r2, r5)     // Catch:{ Exception -> 0x01a2 }
            r1.makeMask()     // Catch:{ Exception -> 0x01a2 }
            r0.setImageMask(r1)     // Catch:{ Exception -> 0x01a2 }
        L_0x0192:
            int r1 = r13.dpiX     // Catch:{ Exception -> 0x01a2 }
            int r2 = r13.dpiY     // Catch:{ Exception -> 0x01a2 }
            r0.setDpi(r1, r2)     // Catch:{ Exception -> 0x01a2 }
            float r1 = r13.XYRatio     // Catch:{ Exception -> 0x01a2 }
            r0.setXYRatio(r1)     // Catch:{ Exception -> 0x01a2 }
            r0.setOriginalType(r4)     // Catch:{ Exception -> 0x01a2 }
            return r0
        L_0x01a2:
            r0 = move-exception
            com.lowagie.text.ExceptionConverter r1 = new com.lowagie.text.ExceptionConverter
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.codec.PngImage.getImage():com.lowagie.text.Image");
    }

    /* access modifiers changed from: package-private */
    public void decodeIdat() {
        int i = this.bitDepth;
        if (i == 16) {
            i = 8;
        }
        int i2 = -1;
        this.bytesPerPixel = this.bitDepth == 16 ? 2 : 1;
        int i3 = this.colorType;
        if (i3 == 0) {
            i2 = (((i * this.width) + 7) / 8) * this.height;
        } else if (i3 == 6) {
            i2 = this.width * 3 * this.height;
            this.bytesPerPixel *= 4;
        } else if (i3 == 2) {
            i2 = this.width * 3 * this.height;
            this.bytesPerPixel *= 3;
        } else if (i3 == 3) {
            if (this.interlaceMethod == 1) {
                i2 = (((i * this.width) + 7) / 8) * this.height;
            }
            this.bytesPerPixel = 1;
        } else if (i3 == 4) {
            i2 = this.width * this.height;
            this.bytesPerPixel *= 2;
        }
        if (i2 >= 0) {
            this.image = new byte[i2];
        }
        if (this.palShades) {
            this.smask = new byte[(this.width * this.height)];
        } else if (this.genBWMask) {
            this.smask = new byte[(((this.width + 7) / 8) * this.height)];
        }
        this.dataStream = new DataInputStream(new InflaterInputStream(new ByteArrayInputStream(this.idat.getBuf(), 0, this.idat.size()), new Inflater()));
        if (this.interlaceMethod != 1) {
            decodePass(0, 0, 1, 1, this.width, this.height);
            return;
        }
        decodePass(0, 0, 8, 8, (this.width + 7) / 8, (this.height + 7) / 8);
        decodePass(4, 0, 8, 8, (this.width + 3) / 8, (this.height + 7) / 8);
        decodePass(0, 4, 4, 8, (this.width + 3) / 4, (this.height + 3) / 8);
        decodePass(2, 0, 4, 4, (this.width + 1) / 4, (this.height + 3) / 4);
        decodePass(0, 2, 2, 4, (this.width + 1) / 2, (this.height + 1) / 4);
        decodePass(1, 0, 2, 2, this.width / 2, (this.height + 1) / 2);
        decodePass(0, 1, 1, 2, this.width, this.height / 2);
    }

    /* access modifiers changed from: package-private */
    public void decodePass(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8 = i6;
        if (i5 != 0 && i8 != 0) {
            int i9 = (((this.inputBands * i5) * this.bitDepth) + 7) / 8;
            int i10 = i2;
            byte[] bArr = new byte[i9];
            byte[] bArr2 = new byte[i9];
            int i11 = 0;
            while (i11 < i8) {
                try {
                    i7 = this.dataStream.read();
                    try {
                        this.dataStream.readFully(bArr, 0, i9);
                    } catch (Exception unused) {
                    }
                } catch (Exception unused2) {
                    i7 = 0;
                }
                if (i7 != 0) {
                    if (i7 == 1) {
                        decodeSubFilter(bArr, i9, this.bytesPerPixel);
                    } else if (i7 == 2) {
                        decodeUpFilter(bArr, bArr2, i9);
                    } else if (i7 == 3) {
                        decodeAverageFilter(bArr, bArr2, i9, this.bytesPerPixel);
                    } else if (i7 == 4) {
                        decodePaethFilter(bArr, bArr2, i9, this.bytesPerPixel);
                    } else {
                        throw new RuntimeException("PNG filter unknown.");
                    }
                }
                processPixels(bArr, i, i3, i10, i5);
                i11++;
                i10 += i4;
                byte[] bArr3 = bArr2;
                bArr2 = bArr;
                bArr = bArr3;
            }
        }
    }

    /* JADX WARNING: type inference failed for: r3v4, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r2v19, types: [byte] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00d4  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void processPixels(byte[] r27, int r28, int r29, int r30, int r31) {
        /*
            r26 = this;
            r0 = r26
            r1 = r31
            int[] r10 = r26.getPixel(r27)
            int r2 = r0.colorType
            r11 = 4
            r12 = 3
            r13 = 2
            r14 = 1
            r15 = 0
            if (r2 == 0) goto L_0x0020
            r3 = 6
            if (r2 == r3) goto L_0x001d
            if (r2 == r13) goto L_0x001d
            if (r2 == r12) goto L_0x0020
            if (r2 == r11) goto L_0x0020
            r16 = 0
            goto L_0x0022
        L_0x001d:
            r16 = 3
            goto L_0x0022
        L_0x0020:
            r16 = 1
        L_0x0022:
            byte[] r2 = r0.image
            r9 = 16
            r17 = 8
            if (r2 == 0) goto L_0x0064
            int r2 = r0.width
            int r2 = r2 * r16
            int r3 = r0.bitDepth
            if (r3 != r9) goto L_0x0034
            r3 = 8
        L_0x0034:
            int r2 = r2 * r3
            int r2 = r2 + 7
            int r18 = r2 / 8
            r19 = r28
            r8 = 0
        L_0x003d:
            if (r8 < r1) goto L_0x0040
            goto L_0x0064
        L_0x0040:
            byte[] r2 = r0.image
            int r3 = r0.inputBands
            int r4 = r3 * r8
            int r7 = r0.bitDepth
            r3 = r10
            r5 = r16
            r6 = r19
            r20 = r7
            r7 = r30
            r21 = r8
            r8 = r20
            r12 = 16
            r9 = r18
            setPixel(r2, r3, r4, r5, r6, r7, r8, r9)
            int r19 = r19 + r29
            int r8 = r21 + 1
            r9 = 16
            r12 = 3
            goto L_0x003d
        L_0x0064:
            r12 = 16
            boolean r2 = r0.palShades
            if (r2 == 0) goto L_0x00d4
            int r2 = r0.colorType
            r2 = r2 & r11
            if (r2 == 0) goto L_0x00a6
            int r2 = r0.bitDepth
            if (r2 != r12) goto L_0x0086
            r2 = 0
        L_0x0074:
            if (r2 < r1) goto L_0x0077
            goto L_0x0086
        L_0x0077:
            int r3 = r0.inputBands
            int r3 = r3 * r2
            int r3 = r3 + r16
            r4 = r10[r3]
            int r4 = r4 >>> 8
            r10[r3] = r4
            int r2 = r2 + 1
            goto L_0x0074
        L_0x0086:
            int r11 = r0.width
            r12 = r28
        L_0x008a:
            if (r15 < r1) goto L_0x008e
            goto L_0x0197
        L_0x008e:
            byte[] r2 = r0.smask
            int r3 = r0.inputBands
            int r3 = r3 * r15
            int r4 = r3 + r16
            r5 = 1
            r8 = 8
            r3 = r10
            r6 = r12
            r7 = r30
            r9 = r11
            setPixel(r2, r3, r4, r5, r6, r7, r8, r9)
            int r12 = r12 + r29
            int r15 = r15 + 1
            goto L_0x008a
        L_0x00a6:
            int r11 = r0.width
            int[] r12 = new int[r14]
            r14 = r28
            r13 = 0
        L_0x00ad:
            if (r13 < r1) goto L_0x00b1
            goto L_0x0197
        L_0x00b1:
            r2 = r10[r13]
            byte[] r3 = r0.trans
            int r4 = r3.length
            if (r2 >= r4) goto L_0x00bd
            byte r2 = r3[r2]
            r12[r15] = r2
            goto L_0x00c1
        L_0x00bd:
            r2 = 255(0xff, float:3.57E-43)
            r12[r15] = r2
        L_0x00c1:
            byte[] r2 = r0.smask
            r4 = 0
            r5 = 1
            r8 = 8
            r3 = r12
            r6 = r14
            r7 = r30
            r9 = r11
            setPixel(r2, r3, r4, r5, r6, r7, r8, r9)
            int r14 = r14 + r29
            int r13 = r13 + 1
            goto L_0x00ad
        L_0x00d4:
            boolean r2 = r0.genBWMask
            if (r2 == 0) goto L_0x0197
            int r2 = r0.colorType
            if (r2 == 0) goto L_0x0164
            if (r2 == r13) goto L_0x011c
            r3 = 3
            if (r2 == r3) goto L_0x00e3
            goto L_0x0197
        L_0x00e3:
            int r2 = r0.width
            int r2 = r2 + 7
            int r2 = r2 / 8
            int[] r3 = new int[r14]
            r5 = r28
            r4 = 0
        L_0x00ee:
            if (r4 < r1) goto L_0x00f2
            goto L_0x0197
        L_0x00f2:
            r6 = r10[r4]
            byte[] r7 = r0.trans
            int r8 = r7.length
            if (r6 >= r8) goto L_0x00ff
            byte r6 = r7[r6]
            if (r6 != 0) goto L_0x00ff
            r6 = 1
            goto L_0x0100
        L_0x00ff:
            r6 = 0
        L_0x0100:
            r3[r15] = r6
            byte[] r6 = r0.smask
            r20 = 0
            r21 = 1
            r24 = 1
            r18 = r6
            r19 = r3
            r22 = r5
            r23 = r30
            r25 = r2
            setPixel(r18, r19, r20, r21, r22, r23, r24, r25)
            int r5 = r5 + r29
            int r4 = r4 + 1
            goto L_0x00ee
        L_0x011c:
            int r2 = r0.width
            int r2 = r2 + 7
            int r2 = r2 / 8
            int[] r3 = new int[r14]
            r5 = r28
            r4 = 0
        L_0x0127:
            if (r4 < r1) goto L_0x012b
            goto L_0x0197
        L_0x012b:
            int r6 = r0.inputBands
            int r6 = r6 * r4
            r7 = r10[r6]
            int r8 = r0.transRedGray
            if (r7 != r8) goto L_0x0147
            int r7 = r6 + 1
            r7 = r10[r7]
            int r8 = r0.transGreen
            if (r7 != r8) goto L_0x0147
            int r6 = r6 + 2
            r6 = r10[r6]
            int r7 = r0.transBlue
            if (r6 != r7) goto L_0x0147
            r6 = 1
            goto L_0x0148
        L_0x0147:
            r6 = 0
        L_0x0148:
            r3[r15] = r6
            byte[] r6 = r0.smask
            r20 = 0
            r21 = 1
            r24 = 1
            r18 = r6
            r19 = r3
            r22 = r5
            r23 = r30
            r25 = r2
            setPixel(r18, r19, r20, r21, r22, r23, r24, r25)
            int r5 = r5 + r29
            int r4 = r4 + 1
            goto L_0x0127
        L_0x0164:
            int r2 = r0.width
            int r2 = r2 + 7
            int r2 = r2 / 8
            int[] r3 = new int[r14]
            r5 = r28
            r4 = 0
        L_0x016f:
            if (r4 < r1) goto L_0x0172
            goto L_0x0197
        L_0x0172:
            r6 = r10[r4]
            int r7 = r0.transRedGray
            if (r6 != r7) goto L_0x017a
            r6 = 1
            goto L_0x017b
        L_0x017a:
            r6 = 0
        L_0x017b:
            r3[r15] = r6
            byte[] r6 = r0.smask
            r20 = 0
            r21 = 1
            r24 = 1
            r18 = r6
            r19 = r3
            r22 = r5
            r23 = r30
            r25 = r2
            setPixel(r18, r19, r20, r21, r22, r23, r24, r25)
            int r5 = r5 + r29
            int r4 = r4 + 1
            goto L_0x016f
        L_0x0197:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.codec.PngImage.processPixels(byte[], int, int, int, int):void");
    }

    static int getPixel(byte[] bArr, int i, int i2, int i3, int i4) {
        if (i3 == 8) {
            return bArr[(i4 * i2) + i] & 255;
        }
        int i5 = i4 * i2;
        int i6 = 8 / i3;
        return (bArr[i5 + (i / i6)] >> ((8 - ((i % i6) * i3)) - i3)) & ((1 << i3) - 1);
    }

    static void setPixel(byte[] bArr, int[] iArr, int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = 0;
        if (i5 == 8) {
            int i8 = (i6 * i4) + (i3 * i2);
            while (i7 < i2) {
                bArr[i8 + i7] = (byte) iArr[i7 + i];
                i7++;
            }
        } else if (i5 == 16) {
            int i9 = (i6 * i4) + (i3 * i2);
            while (i7 < i2) {
                bArr[i9 + i7] = (byte) (iArr[i7 + i] >>> 8);
                i7++;
            }
        } else {
            int i10 = 8 / i5;
            int i11 = (i6 * i4) + (i3 / i10);
            bArr[i11] = (byte) ((iArr[i] << ((8 - ((i3 % i10) * i5)) - i5)) | bArr[i11]);
        }
    }

    /* access modifiers changed from: package-private */
    public int[] getPixel(byte[] bArr) {
        int i = this.bitDepth;
        int i2 = 0;
        if (i == 8) {
            int[] iArr = new int[bArr.length];
            while (i2 < iArr.length) {
                iArr[i2] = bArr[i2] & 255;
                i2++;
            }
            return iArr;
        } else if (i != 16) {
            int[] iArr2 = new int[((bArr.length * 8) / i)];
            int i3 = 8 / i;
            int i4 = (1 << i) - 1;
            for (int i5 = 0; i5 < bArr.length; i5++) {
                int i6 = i3 - 1;
                while (i6 >= 0) {
                    iArr2[i2] = (bArr[i5] >>> (this.bitDepth * i6)) & i4;
                    i6--;
                    i2++;
                }
            }
            return iArr2;
        } else {
            int[] iArr3 = new int[(bArr.length / 2)];
            while (i2 < iArr3.length) {
                int i7 = i2 * 2;
                iArr3[i2] = ((bArr[i7] & 255) << 8) + (bArr[i7 + 1] & 255);
                i2++;
            }
            return iArr3;
        }
    }

    private static void decodeSubFilter(byte[] bArr, int i, int i2) {
        for (int i3 = i2; i3 < i; i3++) {
            bArr[i3] = (byte) ((bArr[i3] & 255) + (bArr[i3 - i2] & 255));
        }
    }

    private static void decodeUpFilter(byte[] bArr, byte[] bArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) ((bArr[i2] & 255) + (bArr2[i2] & 255));
        }
    }

    private static void decodeAverageFilter(byte[] bArr, byte[] bArr2, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            bArr[i3] = (byte) ((bArr[i3] & 255) + ((bArr2[i3] & 255) / 2));
        }
        for (int i4 = i2; i4 < i; i4++) {
            bArr[i4] = (byte) ((bArr[i4] & 255) + (((bArr[i4 - i2] & 255) + (bArr2[i4] & 255)) / 2));
        }
    }

    private static int paethPredictor(int i, int i2, int i3) {
        int i4 = (i + i2) - i3;
        int abs = Math.abs(i4 - i);
        int abs2 = Math.abs(i4 - i2);
        int abs3 = Math.abs(i4 - i3);
        if (abs > abs2 || abs > abs3) {
            return abs2 <= abs3 ? i2 : i3;
        }
        return i;
    }

    private static void decodePaethFilter(byte[] bArr, byte[] bArr2, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            bArr[i3] = (byte) ((bArr[i3] & 255) + (bArr2[i3] & 255));
        }
        for (int i4 = i2; i4 < i; i4++) {
            int i5 = i4 - i2;
            bArr[i4] = (byte) ((bArr[i4] & 255) + paethPredictor(bArr[i5] & 255, bArr2[i4] & 255, bArr2[i5] & 255));
        }
    }

    static class NewByteArrayOutputStream extends ByteArrayOutputStream {
        NewByteArrayOutputStream() {
        }

        public byte[] getBuf() {
            return this.buf;
        }
    }

    public static final int getInt(InputStream inputStream) throws IOException {
        return (inputStream.read() << 24) + (inputStream.read() << 16) + (inputStream.read() << 8) + inputStream.read();
    }

    public static final int getWord(InputStream inputStream) throws IOException {
        return (inputStream.read() << 8) + inputStream.read();
    }

    public static final String getString(InputStream inputStream) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 4; i++) {
            stringBuffer.append((char) inputStream.read());
        }
        return stringBuffer.toString();
    }
}
