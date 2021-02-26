package com.lowagie.text;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Jpeg2000 extends Image {
    public static final int JP2_BPCC = 1651532643;
    public static final int JP2_COLR = 1668246642;
    public static final int JP2_DBTL = 1685348972;
    public static final int JP2_FTYP = 1718909296;
    public static final int JP2_IHDR = 1768449138;
    public static final int JP2_JP = 1783636000;
    public static final int JP2_JP2 = 1785737760;
    public static final int JP2_JP2C = 1785737827;
    public static final int JP2_JP2H = 1785737832;
    public static final int JP2_URL = 1970433056;
    public static final int JPIP_JPIP = 1785751920;
    int boxLength;
    int boxType;
    InputStream inp;

    Jpeg2000(Image image) {
        super(image);
    }

    public Jpeg2000(URL url) throws BadElementException, IOException {
        super(url);
        processParameters();
    }

    public Jpeg2000(byte[] bArr) throws BadElementException, IOException {
        super((URL) null);
        this.rawData = bArr;
        this.originalData = bArr;
        processParameters();
    }

    public Jpeg2000(byte[] bArr, float f, float f2) throws BadElementException, IOException {
        this(bArr);
        this.scaledWidth = f;
        this.scaledHeight = f2;
    }

    private int cio_read(int i) throws IOException {
        int i2 = 0;
        for (int i3 = i - 1; i3 >= 0; i3--) {
            i2 += this.inp.read() << (i3 << 3);
        }
        return i2;
    }

    public void jp2_read_boxhdr() throws IOException {
        this.boxLength = cio_read(4);
        this.boxType = cio_read(4);
        int i = this.boxLength;
        if (i == 1) {
            if (cio_read(4) == 0) {
                this.boxLength = cio_read(4);
                if (this.boxLength == 0) {
                    throw new IOException("Unsupported box size == 0");
                }
                return;
            }
            throw new IOException("Cannot handle box sizes higher than 2^32");
        } else if (i == 0) {
            throw new IOException("Unsupported box size == 0");
        }
    }

    /* JADX INFO: finally extract failed */
    private void processParameters() throws IOException {
        this.type = 33;
        this.originalType = 8;
        this.inp = null;
        try {
            if (this.rawData == null) {
                this.inp = FirebasePerfUrlConnection.openStream(this.url);
                this.url.toString();
            } else {
                this.inp = new ByteArrayInputStream(this.rawData);
            }
            this.boxLength = cio_read(4);
            if (this.boxLength == 12) {
                this.boxType = cio_read(4);
                if (1783636000 != this.boxType) {
                    throw new IOException("Expected JP Marker");
                } else if (218793738 == cio_read(4)) {
                    jp2_read_boxhdr();
                    if (1718909296 == this.boxType) {
                        Utilities.skip(this.inp, this.boxLength - 8);
                        jp2_read_boxhdr();
                        do {
                            if (1785737832 != this.boxType) {
                                if (this.boxType != 1785737827) {
                                    Utilities.skip(this.inp, this.boxLength - 8);
                                    jp2_read_boxhdr();
                                } else {
                                    throw new IOException("Expected JP2H Marker");
                                }
                            }
                        } while (1785737832 != this.boxType);
                        jp2_read_boxhdr();
                        if (1768449138 == this.boxType) {
                            this.scaledHeight = (float) cio_read(4);
                            setTop(this.scaledHeight);
                            this.scaledWidth = (float) cio_read(4);
                            setRight(this.scaledWidth);
                            this.bpc = -1;
                        } else {
                            throw new IOException("Expected IHDR Marker");
                        }
                    } else {
                        throw new IOException("Expected FTYP Marker");
                    }
                } else {
                    throw new IOException("Error with JP Marker");
                }
            } else if (this.boxLength == -11534511) {
                Utilities.skip(this.inp, 4);
                int cio_read = cio_read(4);
                int cio_read2 = cio_read(4);
                int cio_read3 = cio_read(4);
                int cio_read4 = cio_read(4);
                Utilities.skip(this.inp, 16);
                this.colorspace = cio_read(2);
                this.bpc = 8;
                this.scaledHeight = (float) (cio_read2 - cio_read4);
                setTop(this.scaledHeight);
                this.scaledWidth = (float) (cio_read - cio_read3);
                setRight(this.scaledWidth);
            } else {
                throw new IOException("Not a valid Jpeg2000 file");
            }
            InputStream inputStream = this.inp;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception unused) {
                }
                this.inp = null;
            }
            this.plainWidth = getWidth();
            this.plainHeight = getHeight();
        } catch (Throwable th) {
            InputStream inputStream2 = this.inp;
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (Exception unused2) {
                }
                this.inp = null;
            }
            throw th;
        }
    }
}
