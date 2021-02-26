package com.lowagie.text.pdf;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.lowagie.text.Document;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class RandomAccessFileOrArray implements DataInput {
    byte[] arrayIn;
    int arrayInPtr;
    byte back;
    String filename;
    boolean isBack;
    boolean plainRandomAccess;

    /* renamed from: rf */
    MappedRandomAccessFile f762rf;
    private int startOffset;
    RandomAccessFile trf;

    public RandomAccessFileOrArray(String str) throws IOException {
        this(str, false, Document.plainRandomAccess);
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x0095 A[SYNTHETIC, Splitter:B:48:0x0095] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public RandomAccessFileOrArray(java.lang.String r4, boolean r5, boolean r6) throws java.io.IOException {
        /*
            r3 = this;
            r3.<init>()
            r0 = 0
            r3.isBack = r0
            r3.startOffset = r0
            r3.plainRandomAccess = r6
            java.io.File r0 = new java.io.File
            r0.<init>(r4)
            boolean r1 = r0.canRead()
            if (r1 != 0) goto L_0x007b
            java.lang.String r5 = "file:/"
            boolean r5 = r4.startsWith(r5)
            if (r5 != 0) goto L_0x0063
            java.lang.String r5 = "http://"
            boolean r5 = r4.startsWith(r5)
            if (r5 != 0) goto L_0x0063
            java.lang.String r5 = "https://"
            boolean r5 = r4.startsWith(r5)
            if (r5 != 0) goto L_0x0063
            java.lang.String r5 = "jar:"
            boolean r5 = r4.startsWith(r5)
            if (r5 == 0) goto L_0x0036
            goto L_0x0063
        L_0x0036:
            java.io.InputStream r5 = com.lowagie.text.pdf.BaseFont.getResourceStream(r4)
            if (r5 == 0) goto L_0x004b
            byte[] r4 = InputStreamToArray(r5)     // Catch:{ all -> 0x0046 }
            r3.arrayIn = r4     // Catch:{ all -> 0x0046 }
            r5.close()     // Catch:{ IOException -> 0x0045 }
        L_0x0045:
            return
        L_0x0046:
            r4 = move-exception
            r5.close()     // Catch:{ IOException -> 0x004a }
        L_0x004a:
            throw r4
        L_0x004b:
            java.io.IOException r5 = new java.io.IOException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r4 = java.lang.String.valueOf(r4)
            r6.<init>(r4)
            java.lang.String r4 = " not found as file or resource."
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            r5.<init>(r4)
            throw r5
        L_0x0063:
            java.net.URL r5 = new java.net.URL
            r5.<init>(r4)
            java.io.InputStream r4 = com.google.firebase.perf.network.FirebasePerfUrlConnection.openStream(r5)
            byte[] r5 = InputStreamToArray(r4)     // Catch:{ all -> 0x0076 }
            r3.arrayIn = r5     // Catch:{ all -> 0x0076 }
            r4.close()     // Catch:{ IOException -> 0x0075 }
        L_0x0075:
            return
        L_0x0076:
            r5 = move-exception
            r4.close()     // Catch:{ IOException -> 0x007a }
        L_0x007a:
            throw r5
        L_0x007b:
            if (r5 == 0) goto L_0x0099
            r4 = 0
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ all -> 0x008f }
            r5.<init>(r0)     // Catch:{ all -> 0x008f }
            byte[] r4 = InputStreamToArray(r5)     // Catch:{ all -> 0x008d }
            r3.arrayIn = r4     // Catch:{ all -> 0x008d }
            r5.close()     // Catch:{ Exception -> 0x008c }
        L_0x008c:
            return
        L_0x008d:
            r4 = move-exception
            goto L_0x0093
        L_0x008f:
            r5 = move-exception
            r2 = r5
            r5 = r4
            r4 = r2
        L_0x0093:
            if (r5 == 0) goto L_0x0098
            r5.close()     // Catch:{ Exception -> 0x0098 }
        L_0x0098:
            throw r4
        L_0x0099:
            r3.filename = r4
            java.lang.String r5 = "r"
            if (r6 == 0) goto L_0x00a7
            java.io.RandomAccessFile r6 = new java.io.RandomAccessFile
            r6.<init>(r4, r5)
            r3.trf = r6
            goto L_0x00ae
        L_0x00a7:
            com.lowagie.text.pdf.MappedRandomAccessFile r6 = new com.lowagie.text.pdf.MappedRandomAccessFile
            r6.<init>(r4, r5)
            r3.f762rf = r6
        L_0x00ae:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.RandomAccessFileOrArray.<init>(java.lang.String, boolean, boolean):void");
    }

    public RandomAccessFileOrArray(URL url) throws IOException {
        this.isBack = false;
        this.startOffset = 0;
        InputStream openStream = FirebasePerfUrlConnection.openStream(url);
        try {
            this.arrayIn = InputStreamToArray(openStream);
        } finally {
            try {
                openStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public RandomAccessFileOrArray(InputStream inputStream) throws IOException {
        this.isBack = false;
        this.startOffset = 0;
        this.arrayIn = InputStreamToArray(inputStream);
    }

    public static byte[] InputStreamToArray(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[8192];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(bArr);
            if (read < 1) {
                byteArrayOutputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public RandomAccessFileOrArray(byte[] bArr) {
        this.isBack = false;
        this.startOffset = 0;
        this.arrayIn = bArr;
    }

    public RandomAccessFileOrArray(RandomAccessFileOrArray randomAccessFileOrArray) {
        this.isBack = false;
        this.startOffset = 0;
        this.filename = randomAccessFileOrArray.filename;
        this.arrayIn = randomAccessFileOrArray.arrayIn;
        this.startOffset = randomAccessFileOrArray.startOffset;
        this.plainRandomAccess = randomAccessFileOrArray.plainRandomAccess;
    }

    public void pushBack(byte b) {
        this.back = b;
        this.isBack = true;
    }

    public int read() throws IOException {
        byte b;
        if (this.isBack) {
            this.isBack = false;
            b = this.back;
        } else {
            byte[] bArr = this.arrayIn;
            if (bArr == null) {
                return this.plainRandomAccess ? this.trf.read() : this.f762rf.read();
            }
            int i = this.arrayInPtr;
            if (i >= bArr.length) {
                return -1;
            }
            this.arrayInPtr = i + 1;
            b = bArr[i];
        }
        return b & 255;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        if (i2 == 0) {
            return 0;
        }
        if (this.isBack) {
            this.isBack = false;
            if (i2 == 1) {
                bArr[i] = this.back;
                return 1;
            }
            bArr[i] = this.back;
            i2--;
            i++;
            i3 = 1;
        }
        byte[] bArr2 = this.arrayIn;
        if (bArr2 == null) {
            return (this.plainRandomAccess ? this.trf.read(bArr, i, i2) : this.f762rf.read(bArr, i, i2)) + i3;
        }
        int i4 = this.arrayInPtr;
        if (i4 >= bArr2.length) {
            return -1;
        }
        if (i4 + i2 > bArr2.length) {
            i2 = bArr2.length - i4;
        }
        System.arraycopy(this.arrayIn, this.arrayInPtr, bArr, i, i2);
        this.arrayInPtr += i2;
        return i2 + i3;
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public void readFully(byte[] bArr) throws IOException {
        readFully(bArr, 0, bArr.length);
    }

    public void readFully(byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        do {
            int read = read(bArr, i + i3, i2 - i3);
            if (read >= 0) {
                i3 += read;
            } else {
                throw new EOFException();
            }
        } while (i3 < i2);
    }

    public long skip(long j) throws IOException {
        return (long) skipBytes((int) j);
    }

    public int skipBytes(int i) throws IOException {
        int i2 = 0;
        if (i <= 0) {
            return 0;
        }
        if (this.isBack) {
            this.isBack = false;
            if (i == 1) {
                return 1;
            }
            i--;
            i2 = 1;
        }
        int filePointer = getFilePointer();
        int length = length();
        int i3 = i + filePointer;
        if (i3 > length) {
            i3 = length;
        }
        seek(i3);
        return (i3 - filePointer) + i2;
    }

    public void reOpen() throws IOException {
        String str = this.filename;
        if (str != null && this.f762rf == null && this.trf == null) {
            if (this.plainRandomAccess) {
                this.trf = new RandomAccessFile(str, "r");
            } else {
                this.f762rf = new MappedRandomAccessFile(str, "r");
            }
        }
        seek(0);
    }

    /* access modifiers changed from: protected */
    public void insureOpen() throws IOException {
        if (this.filename != null && this.f762rf == null && this.trf == null) {
            reOpen();
        }
    }

    public boolean isOpen() {
        return (this.filename != null && this.f762rf == null && this.trf == null) ? false : true;
    }

    public void close() throws IOException {
        this.isBack = false;
        MappedRandomAccessFile mappedRandomAccessFile = this.f762rf;
        if (mappedRandomAccessFile != null) {
            mappedRandomAccessFile.close();
            this.f762rf = null;
            this.plainRandomAccess = true;
            return;
        }
        RandomAccessFile randomAccessFile = this.trf;
        if (randomAccessFile != null) {
            randomAccessFile.close();
            this.trf = null;
        }
    }

    public int length() throws IOException {
        byte[] bArr = this.arrayIn;
        if (bArr != null) {
            return bArr.length - this.startOffset;
        }
        insureOpen();
        return ((int) (this.plainRandomAccess ? this.trf.length() : this.f762rf.length())) - this.startOffset;
    }

    public void seek(int i) throws IOException {
        int i2 = i + this.startOffset;
        this.isBack = false;
        if (this.arrayIn == null) {
            insureOpen();
            if (this.plainRandomAccess) {
                this.trf.seek((long) i2);
            } else {
                this.f762rf.seek((long) i2);
            }
        } else {
            this.arrayInPtr = i2;
        }
    }

    public void seek(long j) throws IOException {
        seek((int) j);
    }

    public int getFilePointer() throws IOException {
        insureOpen();
        boolean z = this.isBack;
        if (this.arrayIn != null) {
            return (this.arrayInPtr - (z ? 1 : 0)) - this.startOffset;
        }
        return (((int) (this.plainRandomAccess ? this.trf.getFilePointer() : this.f762rf.getFilePointer())) - z) - this.startOffset;
    }

    public boolean readBoolean() throws IOException {
        int read = read();
        if (read >= 0) {
            return read != 0;
        }
        throw new EOFException();
    }

    public byte readByte() throws IOException {
        int read = read();
        if (read >= 0) {
            return (byte) read;
        }
        throw new EOFException();
    }

    public int readUnsignedByte() throws IOException {
        int read = read();
        if (read >= 0) {
            return read;
        }
        throw new EOFException();
    }

    public short readShort() throws IOException {
        int read = read();
        int read2 = read();
        if ((read | read2) >= 0) {
            return (short) ((read << 8) + read2);
        }
        throw new EOFException();
    }

    public final short readShortLE() throws IOException {
        int read = read();
        int read2 = read();
        if ((read | read2) >= 0) {
            return (short) ((read2 << 8) + (read << 0));
        }
        throw new EOFException();
    }

    public int readUnsignedShort() throws IOException {
        int read = read();
        int read2 = read();
        if ((read | read2) >= 0) {
            return (read << 8) + read2;
        }
        throw new EOFException();
    }

    public final int readUnsignedShortLE() throws IOException {
        int read = read();
        int read2 = read();
        if ((read | read2) >= 0) {
            return (read2 << 8) + (read << 0);
        }
        throw new EOFException();
    }

    public char readChar() throws IOException {
        int read = read();
        int read2 = read();
        if ((read | read2) >= 0) {
            return (char) ((read << 8) + read2);
        }
        throw new EOFException();
    }

    public final char readCharLE() throws IOException {
        int read = read();
        int read2 = read();
        if ((read | read2) >= 0) {
            return (char) ((read2 << 8) + (read << 0));
        }
        throw new EOFException();
    }

    public int readInt() throws IOException {
        int read = read();
        int read2 = read();
        int read3 = read();
        int read4 = read();
        if ((read | read2 | read3 | read4) >= 0) {
            return (read << 24) + (read2 << 16) + (read3 << 8) + read4;
        }
        throw new EOFException();
    }

    public final int readIntLE() throws IOException {
        int read = read();
        int read2 = read();
        int read3 = read();
        int read4 = read();
        if ((read | read2 | read3 | read4) >= 0) {
            return (read4 << 24) + (read3 << 16) + (read2 << 8) + (read << 0);
        }
        throw new EOFException();
    }

    public final long readUnsignedInt() throws IOException {
        long read = (long) read();
        long read2 = (long) read();
        long read3 = (long) read();
        long read4 = (long) read();
        if ((read | read2 | read3 | read4) >= 0) {
            return (read << 24) + (read2 << 16) + (read3 << 8) + (read4 << 0);
        }
        throw new EOFException();
    }

    public final long readUnsignedIntLE() throws IOException {
        long read = (long) read();
        long read2 = (long) read();
        long read3 = (long) read();
        long read4 = (long) read();
        if ((read | read2 | read3 | read4) >= 0) {
            return (read4 << 24) + (read3 << 16) + (read2 << 8) + (read << 0);
        }
        throw new EOFException();
    }

    public long readLong() throws IOException {
        return (((long) readInt()) << 32) + (((long) readInt()) & 4294967295L);
    }

    public final long readLongLE() throws IOException {
        return (((long) readIntLE()) << 32) + (((long) readIntLE()) & 4294967295L);
    }

    public float readFloat() throws IOException {
        return Float.intBitsToFloat(readInt());
    }

    public final float readFloatLE() throws IOException {
        return Float.intBitsToFloat(readIntLE());
    }

    public double readDouble() throws IOException {
        return Double.longBitsToDouble(readLong());
    }

    public final double readDoubleLE() throws IOException {
        return Double.longBitsToDouble(readLongLE());
    }

    public String readLine() throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        boolean z = false;
        int i = -1;
        while (!z) {
            i = read();
            if (!(i == -1 || i == 10)) {
                if (i != 13) {
                    stringBuffer.append((char) i);
                } else {
                    int filePointer = getFilePointer();
                    if (read() != 10) {
                        seek(filePointer);
                    }
                }
            }
            z = true;
        }
        if (i == -1 && stringBuffer.length() == 0) {
            return null;
        }
        return stringBuffer.toString();
    }

    public String readUTF() throws IOException {
        return DataInputStream.readUTF(this);
    }

    public int getStartOffset() {
        return this.startOffset;
    }

    public void setStartOffset(int i) {
        this.startOffset = i;
    }

    public ByteBuffer getNioByteBuffer() throws IOException {
        FileChannel fileChannel;
        if (this.filename == null) {
            return ByteBuffer.wrap(this.arrayIn);
        }
        if (this.plainRandomAccess) {
            fileChannel = this.trf.getChannel();
        } else {
            fileChannel = this.f762rf.getChannel();
        }
        FileChannel fileChannel2 = fileChannel;
        return fileChannel2.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel2.size());
    }
}
