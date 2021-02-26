package com.lowagie.text.pdf;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.lowagie.text.Image;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

public class PdfImage extends PdfStream {
    static final int TRANSFERSIZE = 4096;
    protected PdfName name = null;

    public PdfImage(Image image, String str, PdfIndirectReference pdfIndirectReference) throws BadPdfFormatException {
        String str2;
        InputStream inputStream = null;
        this.name = new PdfName(str);
        put(PdfName.TYPE, PdfName.XOBJECT);
        put(PdfName.SUBTYPE, PdfName.IMAGE);
        put(PdfName.WIDTH, new PdfNumber(image.getWidth()));
        put(PdfName.HEIGHT, new PdfNumber(image.getHeight()));
        if (image.getLayer() != null) {
            put(PdfName.f704OC, image.getLayer().getRef());
        }
        if (image.isMask() && (image.getBpc() == 1 || image.getBpc() > 255)) {
            put(PdfName.IMAGEMASK, PdfBoolean.PDFTRUE);
        }
        if (pdfIndirectReference != null) {
            if (image.isSmask()) {
                put(PdfName.SMASK, pdfIndirectReference);
            } else {
                put(PdfName.MASK, pdfIndirectReference);
            }
        }
        if (image.isMask() && image.isInverted()) {
            put(PdfName.DECODE, new PdfLiteral("[1 0]"));
        }
        if (image.isInterpolation()) {
            put(PdfName.INTERPOLATE, PdfBoolean.PDFTRUE);
        }
        try {
            if (image.isImgRaw()) {
                int colorspace = image.getColorspace();
                int[] transparency = image.getTransparency();
                if (transparency != null && !image.isMask() && pdfIndirectReference == null) {
                    String str3 = "[";
                    for (int i = 0; i < transparency.length; i++) {
                        str3 = String.valueOf(str3) + transparency[i] + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
                    }
                    put(PdfName.MASK, new PdfLiteral(String.valueOf(str3) + "]"));
                }
                this.bytes = image.getRawData();
                put(PdfName.LENGTH, new PdfNumber(this.bytes.length));
                int bpc = image.getBpc();
                if (bpc > 255) {
                    if (!image.isMask()) {
                        put(PdfName.COLORSPACE, PdfName.DEVICEGRAY);
                    }
                    put(PdfName.BITSPERCOMPONENT, new PdfNumber(1));
                    put(PdfName.FILTER, PdfName.CCITTFAXDECODE);
                    int i2 = bpc - 257;
                    PdfDictionary pdfDictionary = new PdfDictionary();
                    if (i2 != 0) {
                        pdfDictionary.put(PdfName.f691K, new PdfNumber(i2));
                    }
                    if ((colorspace & 1) != 0) {
                        pdfDictionary.put(PdfName.BLACKIS1, PdfBoolean.PDFTRUE);
                    }
                    if ((colorspace & 2) != 0) {
                        pdfDictionary.put(PdfName.ENCODEDBYTEALIGN, PdfBoolean.PDFTRUE);
                    }
                    if ((colorspace & 4) != 0) {
                        pdfDictionary.put(PdfName.ENDOFLINE, PdfBoolean.PDFTRUE);
                    }
                    if ((colorspace & 8) != 0) {
                        pdfDictionary.put(PdfName.ENDOFBLOCK, PdfBoolean.PDFFALSE);
                    }
                    pdfDictionary.put(PdfName.COLUMNS, new PdfNumber(image.getWidth()));
                    pdfDictionary.put(PdfName.ROWS, new PdfNumber(image.getHeight()));
                    put(PdfName.DECODEPARMS, pdfDictionary);
                    return;
                }
                if (colorspace == 1) {
                    put(PdfName.COLORSPACE, PdfName.DEVICEGRAY);
                    if (image.isInverted()) {
                        put(PdfName.DECODE, new PdfLiteral("[1 0]"));
                    }
                } else if (colorspace != 3) {
                    put(PdfName.COLORSPACE, PdfName.DEVICECMYK);
                    if (image.isInverted()) {
                        put(PdfName.DECODE, new PdfLiteral("[1 0 1 0 1 0 1 0]"));
                    }
                } else {
                    put(PdfName.COLORSPACE, PdfName.DEVICERGB);
                    if (image.isInverted()) {
                        put(PdfName.DECODE, new PdfLiteral("[1 0 1 0 1 0]"));
                    }
                }
                PdfDictionary additional = image.getAdditional();
                if (additional != null) {
                    putAll(additional);
                }
                if (image.isMask() && (image.getBpc() == 1 || image.getBpc() > 8)) {
                    remove(PdfName.COLORSPACE);
                }
                put(PdfName.BITSPERCOMPONENT, new PdfNumber(image.getBpc()));
                if (image.isDeflated()) {
                    put(PdfName.FILTER, PdfName.FLATEDECODE);
                } else {
                    flateCompress(image.getCompressionLevel());
                }
            } else {
                if (image.getRawData() == null) {
                    inputStream = FirebasePerfUrlConnection.openStream(image.getUrl());
                    str2 = image.getUrl().toString();
                } else {
                    inputStream = new ByteArrayInputStream(image.getRawData());
                    str2 = "Byte array";
                }
                int type = image.type();
                if (type == 32) {
                    put(PdfName.FILTER, PdfName.DCTDECODE);
                    int colorspace2 = image.getColorspace();
                    if (colorspace2 == 1) {
                        put(PdfName.COLORSPACE, PdfName.DEVICEGRAY);
                    } else if (colorspace2 != 3) {
                        put(PdfName.COLORSPACE, PdfName.DEVICECMYK);
                        if (image.isInverted()) {
                            put(PdfName.DECODE, new PdfLiteral("[1 0 1 0 1 0 1 0]"));
                        }
                    } else {
                        put(PdfName.COLORSPACE, PdfName.DEVICERGB);
                    }
                    put(PdfName.BITSPERCOMPONENT, new PdfNumber(8));
                    if (image.getRawData() != null) {
                        this.bytes = image.getRawData();
                        put(PdfName.LENGTH, new PdfNumber(this.bytes.length));
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                                return;
                            } catch (Exception unused) {
                                return;
                            }
                        } else {
                            return;
                        }
                    } else {
                        this.streamBytes = new ByteArrayOutputStream();
                        transferBytes(inputStream, this.streamBytes, -1);
                    }
                } else if (type == 33) {
                    put(PdfName.FILTER, PdfName.JPXDECODE);
                    if (image.getColorspace() > 0) {
                        int colorspace3 = image.getColorspace();
                        if (colorspace3 == 1) {
                            put(PdfName.COLORSPACE, PdfName.DEVICEGRAY);
                        } else if (colorspace3 != 3) {
                            put(PdfName.COLORSPACE, PdfName.DEVICECMYK);
                        } else {
                            put(PdfName.COLORSPACE, PdfName.DEVICERGB);
                        }
                        put(PdfName.BITSPERCOMPONENT, new PdfNumber(image.getBpc()));
                    }
                    if (image.getRawData() != null) {
                        this.bytes = image.getRawData();
                        put(PdfName.LENGTH, new PdfNumber(this.bytes.length));
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                                return;
                            } catch (Exception unused2) {
                                return;
                            }
                        } else {
                            return;
                        }
                    } else {
                        this.streamBytes = new ByteArrayOutputStream();
                        transferBytes(inputStream, this.streamBytes, -1);
                    }
                } else if (type == 36) {
                    put(PdfName.FILTER, PdfName.JBIG2DECODE);
                    put(PdfName.COLORSPACE, PdfName.DEVICEGRAY);
                    put(PdfName.BITSPERCOMPONENT, new PdfNumber(1));
                    if (image.getRawData() != null) {
                        this.bytes = image.getRawData();
                        put(PdfName.LENGTH, new PdfNumber(this.bytes.length));
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                                return;
                            } catch (Exception unused3) {
                                return;
                            }
                        } else {
                            return;
                        }
                    } else {
                        this.streamBytes = new ByteArrayOutputStream();
                        transferBytes(inputStream, this.streamBytes, -1);
                    }
                } else {
                    throw new BadPdfFormatException(String.valueOf(str2) + " is an unknown Image format.");
                }
                put(PdfName.LENGTH, new PdfNumber(this.streamBytes.size()));
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception unused4) {
                    }
                }
            }
        } catch (IOException e) {
            throw new BadPdfFormatException(e.getMessage());
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception unused5) {
                }
            }
            throw th;
        }
    }

    public PdfName name() {
        return this.name;
    }

    static void transferBytes(InputStream inputStream, OutputStream outputStream, int i) throws IOException {
        byte[] bArr = new byte[4096];
        if (i < 0) {
            i = 134217727;
        }
        while (i != 0) {
            int read = inputStream.read(bArr, 0, Math.min(i, 4096));
            if (read >= 0) {
                outputStream.write(bArr, 0, read);
                i -= read;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void importAll(PdfImage pdfImage) {
        this.name = pdfImage.name;
        this.compressed = pdfImage.compressed;
        this.compressionLevel = pdfImage.compressionLevel;
        this.streamBytes = pdfImage.streamBytes;
        this.bytes = pdfImage.bytes;
        this.hashMap = pdfImage.hashMap;
    }
}
