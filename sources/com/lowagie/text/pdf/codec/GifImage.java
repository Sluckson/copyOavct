package com.lowagie.text.pdf.codec;

import androidx.fragment.app.FragmentTransaction;
import com.lowagie.text.ExceptionConverter;
import com.lowagie.text.Image;
import com.lowagie.text.ImgRaw;
import com.lowagie.text.Utilities;
import com.lowagie.text.pdf.PdfArray;
import com.lowagie.text.pdf.PdfDictionary;
import com.lowagie.text.pdf.PdfName;
import com.lowagie.text.pdf.PdfNumber;
import com.lowagie.text.pdf.PdfObject;
import com.lowagie.text.pdf.PdfString;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

public class GifImage {
    protected static final int MaxStackSize = 4096;
    protected int bgColor;
    protected int bgIndex;
    protected byte[] block;
    protected int blockSize;
    protected int delay;
    protected int dispose;
    protected ArrayList frames;
    protected byte[] fromData;
    protected URL fromUrl;
    protected boolean gctFlag;
    protected int height;

    /* renamed from: ih */
    protected int f768ih;

    /* renamed from: in */
    protected DataInputStream f769in;
    protected boolean interlace;

    /* renamed from: iw */
    protected int f770iw;

    /* renamed from: ix */
    protected int f771ix;

    /* renamed from: iy */
    protected int f772iy;
    protected boolean lctFlag;
    protected int lctSize;
    protected int m_bpc;
    protected byte[] m_curr_table;
    protected int m_gbpc;
    protected byte[] m_global_table;
    protected int m_line_stride;
    protected byte[] m_local_table;
    protected byte[] m_out;
    protected int pixelAspect;
    protected byte[] pixelStack;
    protected byte[] pixels;
    protected short[] prefix;
    protected byte[] suffix;
    protected int transIndex;
    protected boolean transparency;
    protected int width;

    protected static int newBpc(int i) {
        if (!(i == 1 || i == 2)) {
            if (i == 3) {
                return 4;
            }
            if (i != 4) {
                return 8;
            }
        }
        return i;
    }

    /* access modifiers changed from: protected */
    public void resetFrame() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public GifImage(java.net.URL r2) throws java.io.IOException {
        /*
            r1 = this;
            r1.<init>()
            r0 = 256(0x100, float:3.59E-43)
            byte[] r0 = new byte[r0]
            r1.block = r0
            r0 = 0
            r1.blockSize = r0
            r1.dispose = r0
            r1.transparency = r0
            r1.delay = r0
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1.frames = r0
            r1.fromUrl = r2
            java.io.InputStream r2 = com.google.firebase.perf.network.FirebasePerfUrlConnection.openStream(r2)     // Catch:{ all -> 0x002a }
            r1.process(r2)     // Catch:{ all -> 0x0028 }
            if (r2 == 0) goto L_0x0027
            r2.close()
        L_0x0027:
            return
        L_0x0028:
            r0 = move-exception
            goto L_0x002c
        L_0x002a:
            r0 = move-exception
            r2 = 0
        L_0x002c:
            if (r2 == 0) goto L_0x0031
            r2.close()
        L_0x0031:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.codec.GifImage.<init>(java.net.URL):void");
    }

    public GifImage(String str) throws IOException {
        this(Utilities.toURL(str));
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public GifImage(byte[] r3) throws java.io.IOException {
        /*
            r2 = this;
            r2.<init>()
            r0 = 256(0x100, float:3.59E-43)
            byte[] r0 = new byte[r0]
            r2.block = r0
            r0 = 0
            r2.blockSize = r0
            r2.dispose = r0
            r2.transparency = r0
            r2.delay = r0
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r2.frames = r0
            r2.fromData = r3
            r0 = 0
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x002b }
            r1.<init>(r3)     // Catch:{ all -> 0x002b }
            r2.process(r1)     // Catch:{ all -> 0x0028 }
            r1.close()
            return
        L_0x0028:
            r3 = move-exception
            r0 = r1
            goto L_0x002c
        L_0x002b:
            r3 = move-exception
        L_0x002c:
            if (r0 == 0) goto L_0x0031
            r0.close()
        L_0x0031:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.codec.GifImage.<init>(byte[]):void");
    }

    public GifImage(InputStream inputStream) throws IOException {
        this.block = new byte[256];
        this.blockSize = 0;
        this.dispose = 0;
        this.transparency = false;
        this.delay = 0;
        this.frames = new ArrayList();
        process(inputStream);
    }

    public int getFrameCount() {
        return this.frames.size();
    }

    public Image getImage(int i) {
        return ((GifFrame) this.frames.get(i - 1)).image;
    }

    public int[] getFramePosition(int i) {
        GifFrame gifFrame = (GifFrame) this.frames.get(i - 1);
        return new int[]{gifFrame.f773ix, gifFrame.f774iy};
    }

    public int[] getLogicalScreen() {
        return new int[]{this.width, this.height};
    }

    /* access modifiers changed from: package-private */
    public void process(InputStream inputStream) throws IOException {
        this.f769in = new DataInputStream(new BufferedInputStream(inputStream));
        readHeader();
        readContents();
        if (this.frames.isEmpty()) {
            throw new IOException("The file does not contain any valid image.");
        }
    }

    /* access modifiers changed from: protected */
    public void readHeader() throws IOException {
        String str = "";
        for (int i = 0; i < 6; i++) {
            str = String.valueOf(str) + ((char) this.f769in.read());
        }
        if (str.startsWith("GIF8")) {
            readLSD();
            if (this.gctFlag) {
                this.m_global_table = readColorTable(this.m_gbpc);
                return;
            }
            return;
        }
        throw new IOException("Gif signature nor found.");
    }

    /* access modifiers changed from: protected */
    public void readLSD() throws IOException {
        this.width = readShort();
        this.height = readShort();
        int read = this.f769in.read();
        this.gctFlag = (read & 128) != 0;
        this.m_gbpc = (read & 7) + 1;
        this.bgIndex = this.f769in.read();
        this.pixelAspect = this.f769in.read();
    }

    /* access modifiers changed from: protected */
    public int readShort() throws IOException {
        return this.f769in.read() | (this.f769in.read() << 8);
    }

    /* access modifiers changed from: protected */
    public int readBlock() throws IOException {
        this.blockSize = this.f769in.read();
        int i = 0;
        if (this.blockSize <= 0) {
            this.blockSize = 0;
            return 0;
        }
        while (true) {
            int i2 = this.blockSize;
            if (i >= i2) {
                return i2;
            }
            int read = this.f769in.read();
            if (read < 0) {
                this.blockSize = i;
                return i;
            }
            this.block[i] = (byte) read;
            i++;
        }
    }

    /* access modifiers changed from: protected */
    public byte[] readColorTable(int i) throws IOException {
        byte[] bArr = new byte[((1 << newBpc(i)) * 3)];
        this.f769in.readFully(bArr, 0, (1 << i) * 3);
        return bArr;
    }

    /* access modifiers changed from: protected */
    public void readContents() throws IOException {
        boolean z = false;
        while (!z) {
            int read = this.f769in.read();
            if (read == 33) {
                int read2 = this.f769in.read();
                if (read2 == 249) {
                    readGraphicControlExt();
                } else if (read2 != 255) {
                    skip();
                } else {
                    readBlock();
                    skip();
                }
            } else if (read != 44) {
                z = true;
            } else {
                readImage();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void readImage() throws IOException {
        this.f771ix = readShort();
        this.f772iy = readShort();
        this.f770iw = readShort();
        this.f768ih = readShort();
        int read = this.f769in.read();
        this.lctFlag = (read & 128) != 0;
        this.interlace = (read & 64) != 0;
        int i = read & 7;
        this.lctSize = 2 << i;
        this.m_bpc = newBpc(this.m_gbpc);
        if (this.lctFlag) {
            int i2 = i + 1;
            this.m_curr_table = readColorTable(i2);
            this.m_bpc = newBpc(i2);
        } else {
            this.m_curr_table = this.m_global_table;
        }
        if (this.transparency && this.transIndex >= this.m_curr_table.length / 3) {
            this.transparency = false;
        }
        if (this.transparency && this.m_bpc == 1) {
            byte[] bArr = new byte[12];
            System.arraycopy(this.m_curr_table, 0, bArr, 0, 6);
            this.m_curr_table = bArr;
            this.m_bpc = 2;
        }
        if (!decodeImageData()) {
            skip();
        }
        try {
            ImgRaw imgRaw = new ImgRaw(this.f770iw, this.f768ih, 1, this.m_bpc, this.m_out);
            PdfArray pdfArray = new PdfArray();
            pdfArray.add((PdfObject) PdfName.INDEXED);
            pdfArray.add((PdfObject) PdfName.DEVICERGB);
            pdfArray.add((PdfObject) new PdfNumber((this.m_curr_table.length / 3) - 1));
            pdfArray.add((PdfObject) new PdfString(this.m_curr_table));
            PdfDictionary pdfDictionary = new PdfDictionary();
            pdfDictionary.put(PdfName.COLORSPACE, pdfArray);
            imgRaw.setAdditional(pdfDictionary);
            if (this.transparency) {
                imgRaw.setTransparency(new int[]{this.transIndex, this.transIndex});
            }
            imgRaw.setOriginalType(3);
            imgRaw.setOriginalData(this.fromData);
            imgRaw.setUrl(this.fromUrl);
            GifFrame gifFrame = new GifFrame();
            gifFrame.image = imgRaw;
            gifFrame.f773ix = this.f771ix;
            gifFrame.f774iy = this.f772iy;
            this.frames.add(gifFrame);
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    /* access modifiers changed from: protected */
    public boolean decodeImageData() throws IOException {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        byte b;
        int i6;
        int i7;
        short s;
        int i8 = this.f770iw * this.f768ih;
        if (this.prefix == null) {
            this.prefix = new short[4096];
        }
        if (this.suffix == null) {
            this.suffix = new byte[4096];
        }
        if (this.pixelStack == null) {
            this.pixelStack = new byte[FragmentTransaction.TRANSIT_FRAGMENT_OPEN];
        }
        int i9 = 8;
        this.m_line_stride = ((this.f770iw * this.m_bpc) + 7) / 8;
        this.m_out = new byte[(this.m_line_stride * this.f768ih)];
        if (!this.interlace) {
            i9 = 1;
        }
        int read = this.f769in.read();
        int i10 = 1 << read;
        int i11 = i10 + 1;
        int i12 = i10 + 2;
        int i13 = read + 1;
        int i14 = (1 << i13) - 1;
        int i15 = 0;
        while (i15 < i10) {
            this.prefix[i15] = 0;
            this.suffix[i15] = (byte) i15;
            i15++;
            i8 = i2;
            i13 = i;
        }
        int i16 = i;
        int i17 = i9;
        int i18 = i12;
        int i19 = i14;
        byte b2 = -1;
        int i20 = 0;
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        int i25 = 0;
        byte b3 = 0;
        int i26 = 1;
        int i27 = 0;
        loop1:
        while (true) {
            int i28 = 0;
            while (i20 < i2) {
                if (i21 == 0) {
                    if (i22 >= i16) {
                        byte b4 = i23 & i19;
                        i23 >>= i16;
                        i22 -= i16;
                        if (b4 > i18 || b4 == i11) {
                            break loop1;
                        } else if (b4 == i10) {
                            i16 = i;
                            i18 = i12;
                            i19 = i14;
                            b2 = -1;
                        } else if (b2 == -1) {
                            this.pixelStack[i21] = this.suffix[b4];
                            b2 = b4;
                            b3 = b2;
                            i21++;
                            i2 = i2;
                        } else {
                            i4 = i2;
                            if (b4 == i18) {
                                i3 = i;
                                this.pixelStack[i21] = (byte) b3;
                                s = b2;
                                i21++;
                            } else {
                                i3 = i;
                                s = b4;
                            }
                            while (s > i10) {
                                this.pixelStack[i21] = this.suffix[s];
                                s = this.prefix[s];
                                i21++;
                                b4 = b4;
                            }
                            byte[] bArr = this.suffix;
                            b = bArr[s] & 255;
                            if (i18 >= 4096) {
                                break loop1;
                            }
                            i5 = i21 + 1;
                            byte b5 = b4;
                            byte b6 = (byte) b;
                            this.pixelStack[i21] = b6;
                            this.prefix[i18] = (short) b2;
                            bArr[i18] = b6;
                            i18++;
                            if ((i18 & i19) == 0) {
                                if (i18 < 4096) {
                                    i16++;
                                    i19 += i18;
                                }
                            }
                            b2 = b5;
                        }
                    } else {
                        if (i24 == 0) {
                            i24 = readBlock();
                            if (i24 <= 0) {
                                return true;
                            }
                            i25 = 0;
                        }
                        i23 += (this.block[i25] & 255) << i22;
                        i22 += 8;
                        i25++;
                        i24--;
                    }
                } else {
                    i4 = i2;
                    i3 = i;
                    b = b3;
                    i5 = i21;
                }
                i21 = i5 - 1;
                i20++;
                int i29 = i27;
                int i30 = i28;
                setPixel(i30, i29, this.pixelStack[i21]);
                int i31 = i30 + 1;
                if (i31 >= this.f770iw) {
                    int i32 = i29 + i17;
                    int i33 = this.f768ih;
                    if (i32 < i33) {
                        b3 = b;
                        i27 = i32;
                    } else if (this.interlace) {
                        while (true) {
                            i6 = i26 + 1;
                            i7 = 4;
                            if (i6 != 2) {
                                if (i6 == 3) {
                                    i7 = 2;
                                    i17 = 4;
                                } else if (i6 != 4) {
                                    i7 = this.f768ih - 1;
                                    i17 = 0;
                                } else {
                                    i7 = 1;
                                    i17 = 2;
                                }
                            }
                            if (i7 < this.f768ih) {
                                break;
                            }
                            i26 = i6;
                        }
                        b3 = b;
                        i26 = i6;
                        i27 = i7;
                    } else {
                        i27 = i33 - 1;
                        b3 = b;
                        i2 = i4;
                        i = i3;
                        i17 = 0;
                    }
                    i2 = i4;
                    i = i3;
                } else {
                    b3 = b;
                    i28 = i31;
                    i27 = i29;
                    i2 = i4;
                    i = i3;
                }
            }
            break loop1;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void setPixel(int i, int i2, int i3) {
        int i4 = this.m_bpc;
        if (i4 == 8) {
            this.m_out[i + (this.f770iw * i2)] = (byte) i3;
            return;
        }
        int i5 = (this.m_line_stride * i2) + (i / (8 / i4));
        byte[] bArr = this.m_out;
        bArr[i5] = (byte) ((i3 << ((8 - ((i % (8 / i4)) * i4)) - i4)) | bArr[i5]);
    }

    /* access modifiers changed from: protected */
    public void readGraphicControlExt() throws IOException {
        this.f769in.read();
        int read = this.f769in.read();
        this.dispose = (read & 28) >> 2;
        boolean z = true;
        if (this.dispose == 0) {
            this.dispose = 1;
        }
        if ((read & 1) == 0) {
            z = false;
        }
        this.transparency = z;
        this.delay = readShort() * 10;
        this.transIndex = this.f769in.read();
        this.f769in.read();
    }

    /* access modifiers changed from: protected */
    public void skip() throws IOException {
        do {
            readBlock();
        } while (this.blockSize > 0);
    }

    static class GifFrame {
        Image image;

        /* renamed from: ix */
        int f773ix;

        /* renamed from: iy */
        int f774iy;

        GifFrame() {
        }
    }
}
