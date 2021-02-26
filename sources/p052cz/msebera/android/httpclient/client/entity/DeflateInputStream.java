package p052cz.msebera.android.httpclient.client.entity;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

/* renamed from: cz.msebera.android.httpclient.client.entity.DeflateInputStream */
public class DeflateInputStream extends InputStream {
    private InputStream sourceStream;

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0041, code lost:
        if (r8 == -1) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0043, code lost:
        r1.unread(r0, 0, r11);
        r10.sourceStream = new p052cz.msebera.android.httpclient.client.entity.DeflateInputStream.DeflateStream(r1, new java.util.zip.Inflater());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0058, code lost:
        throw new java.io.IOException("Unable to read the response");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0059, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r1.unread(r0, 0, r11);
        r10.sourceStream = new p052cz.msebera.android.httpclient.client.entity.DeflateInputStream.DeflateStream(r1, new java.util.zip.Inflater(true));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x006e, code lost:
        r6.end();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0071, code lost:
        throw r11;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x005b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DeflateInputStream(java.io.InputStream r11) throws java.io.IOException {
        /*
            r10 = this;
            r10.<init>()
            r0 = 6
            byte[] r0 = new byte[r0]
            java.io.PushbackInputStream r1 = new java.io.PushbackInputStream
            int r2 = r0.length
            r1.<init>(r11, r2)
            int r11 = r1.read(r0)
            r2 = -1
            java.lang.String r3 = "Unable to read the response"
            if (r11 == r2) goto L_0x0072
            r4 = 1
            byte[] r5 = new byte[r4]
            java.util.zip.Inflater r6 = new java.util.zip.Inflater
            r6.<init>()
        L_0x001d:
            r7 = 0
            int r8 = r6.inflate(r5)     // Catch:{ DataFormatException -> 0x005b }
            if (r8 != 0) goto L_0x0041
            boolean r9 = r6.finished()     // Catch:{ DataFormatException -> 0x005b }
            if (r9 != 0) goto L_0x003b
            boolean r9 = r6.needsDictionary()     // Catch:{ DataFormatException -> 0x005b }
            if (r9 == 0) goto L_0x0031
            goto L_0x0041
        L_0x0031:
            boolean r8 = r6.needsInput()     // Catch:{ DataFormatException -> 0x005b }
            if (r8 == 0) goto L_0x001d
            r6.setInput(r0)     // Catch:{ DataFormatException -> 0x005b }
            goto L_0x001d
        L_0x003b:
            java.io.IOException r2 = new java.io.IOException     // Catch:{ DataFormatException -> 0x005b }
            r2.<init>(r3)     // Catch:{ DataFormatException -> 0x005b }
            throw r2     // Catch:{ DataFormatException -> 0x005b }
        L_0x0041:
            if (r8 == r2) goto L_0x0053
            r1.unread(r0, r7, r11)     // Catch:{ DataFormatException -> 0x005b }
            cz.msebera.android.httpclient.client.entity.DeflateInputStream$DeflateStream r2 = new cz.msebera.android.httpclient.client.entity.DeflateInputStream$DeflateStream     // Catch:{ DataFormatException -> 0x005b }
            java.util.zip.Inflater r3 = new java.util.zip.Inflater     // Catch:{ DataFormatException -> 0x005b }
            r3.<init>()     // Catch:{ DataFormatException -> 0x005b }
            r2.<init>(r1, r3)     // Catch:{ DataFormatException -> 0x005b }
            r10.sourceStream = r2     // Catch:{ DataFormatException -> 0x005b }
            goto L_0x006a
        L_0x0053:
            java.io.IOException r2 = new java.io.IOException     // Catch:{ DataFormatException -> 0x005b }
            r2.<init>(r3)     // Catch:{ DataFormatException -> 0x005b }
            throw r2     // Catch:{ DataFormatException -> 0x005b }
        L_0x0059:
            r11 = move-exception
            goto L_0x006e
        L_0x005b:
            r1.unread(r0, r7, r11)     // Catch:{ all -> 0x0059 }
            cz.msebera.android.httpclient.client.entity.DeflateInputStream$DeflateStream r11 = new cz.msebera.android.httpclient.client.entity.DeflateInputStream$DeflateStream     // Catch:{ all -> 0x0059 }
            java.util.zip.Inflater r0 = new java.util.zip.Inflater     // Catch:{ all -> 0x0059 }
            r0.<init>(r4)     // Catch:{ all -> 0x0059 }
            r11.<init>(r1, r0)     // Catch:{ all -> 0x0059 }
            r10.sourceStream = r11     // Catch:{ all -> 0x0059 }
        L_0x006a:
            r6.end()
            return
        L_0x006e:
            r6.end()
            throw r11
        L_0x0072:
            java.io.IOException r11 = new java.io.IOException
            r11.<init>(r3)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: p052cz.msebera.android.httpclient.client.entity.DeflateInputStream.<init>(java.io.InputStream):void");
    }

    public int read() throws IOException {
        return this.sourceStream.read();
    }

    public int read(byte[] bArr) throws IOException {
        return this.sourceStream.read(bArr);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        return this.sourceStream.read(bArr, i, i2);
    }

    public long skip(long j) throws IOException {
        return this.sourceStream.skip(j);
    }

    public int available() throws IOException {
        return this.sourceStream.available();
    }

    public void mark(int i) {
        this.sourceStream.mark(i);
    }

    public void reset() throws IOException {
        this.sourceStream.reset();
    }

    public boolean markSupported() {
        return this.sourceStream.markSupported();
    }

    public void close() throws IOException {
        this.sourceStream.close();
    }

    /* renamed from: cz.msebera.android.httpclient.client.entity.DeflateInputStream$DeflateStream */
    static class DeflateStream extends InflaterInputStream {
        private boolean closed = false;

        public DeflateStream(InputStream inputStream, Inflater inflater) {
            super(inputStream, inflater);
        }

        public void close() throws IOException {
            if (!this.closed) {
                this.closed = true;
                this.inf.end();
                super.close();
            }
        }
    }
}
