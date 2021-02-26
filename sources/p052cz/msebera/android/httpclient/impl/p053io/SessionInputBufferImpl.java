package p052cz.msebera.android.httpclient.impl.p053io;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import p052cz.msebera.android.httpclient.annotation.NotThreadSafe;
import p052cz.msebera.android.httpclient.config.MessageConstraints;
import p052cz.msebera.android.httpclient.p054io.BufferInfo;
import p052cz.msebera.android.httpclient.p054io.HttpTransportMetrics;
import p052cz.msebera.android.httpclient.p054io.SessionInputBuffer;
import p052cz.msebera.android.httpclient.util.Args;
import p052cz.msebera.android.httpclient.util.Asserts;
import p052cz.msebera.android.httpclient.util.ByteArrayBuffer;
import p052cz.msebera.android.httpclient.util.CharArrayBuffer;

@NotThreadSafe
/* renamed from: cz.msebera.android.httpclient.impl.io.SessionInputBufferImpl */
public class SessionInputBufferImpl implements SessionInputBuffer, BufferInfo {
    private final byte[] buffer;
    private int bufferlen;
    private int bufferpos;
    private CharBuffer cbuf;
    private final MessageConstraints constraints;
    private final CharsetDecoder decoder;
    private InputStream instream;
    private final ByteArrayBuffer linebuffer;
    private final HttpTransportMetricsImpl metrics;
    private final int minChunkLimit;

    public SessionInputBufferImpl(HttpTransportMetricsImpl httpTransportMetricsImpl, int i, int i2, MessageConstraints messageConstraints, CharsetDecoder charsetDecoder) {
        Args.notNull(httpTransportMetricsImpl, "HTTP transport metrcis");
        Args.positive(i, "Buffer size");
        this.metrics = httpTransportMetricsImpl;
        this.buffer = new byte[i];
        this.bufferpos = 0;
        this.bufferlen = 0;
        this.minChunkLimit = i2 < 0 ? 512 : i2;
        this.constraints = messageConstraints == null ? MessageConstraints.DEFAULT : messageConstraints;
        this.linebuffer = new ByteArrayBuffer(i);
        this.decoder = charsetDecoder;
    }

    public SessionInputBufferImpl(HttpTransportMetricsImpl httpTransportMetricsImpl, int i) {
        this(httpTransportMetricsImpl, i, i, (MessageConstraints) null, (CharsetDecoder) null);
    }

    public void bind(InputStream inputStream) {
        this.instream = inputStream;
    }

    public boolean isBound() {
        return this.instream != null;
    }

    public int capacity() {
        return this.buffer.length;
    }

    public int length() {
        return this.bufferlen - this.bufferpos;
    }

    public int available() {
        return capacity() - length();
    }

    private int streamRead(byte[] bArr, int i, int i2) throws IOException {
        Asserts.notNull(this.instream, "Input stream");
        return this.instream.read(bArr, i, i2);
    }

    public int fillBuffer() throws IOException {
        int i = this.bufferpos;
        if (i > 0) {
            int i2 = this.bufferlen - i;
            if (i2 > 0) {
                byte[] bArr = this.buffer;
                System.arraycopy(bArr, i, bArr, 0, i2);
            }
            this.bufferpos = 0;
            this.bufferlen = i2;
        }
        int i3 = this.bufferlen;
        byte[] bArr2 = this.buffer;
        int streamRead = streamRead(bArr2, i3, bArr2.length - i3);
        if (streamRead == -1) {
            return -1;
        }
        this.bufferlen = i3 + streamRead;
        this.metrics.incrementBytesTransferred((long) streamRead);
        return streamRead;
    }

    public boolean hasBufferedData() {
        return this.bufferpos < this.bufferlen;
    }

    public void clear() {
        this.bufferpos = 0;
        this.bufferlen = 0;
    }

    public int read() throws IOException {
        while (!hasBufferedData()) {
            if (fillBuffer() == -1) {
                return -1;
            }
        }
        byte[] bArr = this.buffer;
        int i = this.bufferpos;
        this.bufferpos = i + 1;
        return bArr[i] & 255;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (bArr == null) {
            return 0;
        }
        if (hasBufferedData()) {
            int min = Math.min(i2, this.bufferlen - this.bufferpos);
            System.arraycopy(this.buffer, this.bufferpos, bArr, i, min);
            this.bufferpos += min;
            return min;
        } else if (i2 > this.minChunkLimit) {
            int streamRead = streamRead(bArr, i, i2);
            if (streamRead > 0) {
                this.metrics.incrementBytesTransferred((long) streamRead);
            }
            return streamRead;
        } else {
            while (!hasBufferedData()) {
                if (fillBuffer() == -1) {
                    return -1;
                }
            }
            int min2 = Math.min(i2, this.bufferlen - this.bufferpos);
            System.arraycopy(this.buffer, this.bufferpos, bArr, i, min2);
            this.bufferpos += min2;
            return min2;
        }
    }

    public int read(byte[] bArr) throws IOException {
        if (bArr == null) {
            return 0;
        }
        return read(bArr, 0, bArr.length);
    }

    private int locateLF() {
        for (int i = this.bufferpos; i < this.bufferlen; i++) {
            if (this.buffer[i] == 10) {
                return i;
            }
        }
        return -1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0049, code lost:
        if (r2 == -1) goto L_0x002d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int readLine(p052cz.msebera.android.httpclient.util.CharArrayBuffer r8) throws java.io.IOException {
        /*
            r7 = this;
            java.lang.String r0 = "Char array buffer"
            p052cz.msebera.android.httpclient.util.Args.notNull(r8, r0)
            r0 = 1
            r1 = 0
            r2 = 0
        L_0x0008:
            r3 = -1
            if (r0 == 0) goto L_0x0065
            int r4 = r7.locateLF()
            if (r4 == r3) goto L_0x002f
            cz.msebera.android.httpclient.util.ByteArrayBuffer r0 = r7.linebuffer
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x001e
            int r8 = r7.lineFromReadBuffer(r8, r4)
            return r8
        L_0x001e:
            int r4 = r4 + 1
            int r0 = r7.bufferpos
            int r3 = r4 - r0
            cz.msebera.android.httpclient.util.ByteArrayBuffer r5 = r7.linebuffer
            byte[] r6 = r7.buffer
            r5.append((byte[]) r6, (int) r0, (int) r3)
            r7.bufferpos = r4
        L_0x002d:
            r0 = 0
            goto L_0x004c
        L_0x002f:
            boolean r2 = r7.hasBufferedData()
            if (r2 == 0) goto L_0x0045
            int r2 = r7.bufferlen
            int r4 = r7.bufferpos
            int r2 = r2 - r4
            cz.msebera.android.httpclient.util.ByteArrayBuffer r5 = r7.linebuffer
            byte[] r6 = r7.buffer
            r5.append((byte[]) r6, (int) r4, (int) r2)
            int r2 = r7.bufferlen
            r7.bufferpos = r2
        L_0x0045:
            int r2 = r7.fillBuffer()
            if (r2 != r3) goto L_0x004c
            goto L_0x002d
        L_0x004c:
            cz.msebera.android.httpclient.config.MessageConstraints r3 = r7.constraints
            int r3 = r3.getMaxLineLength()
            if (r3 <= 0) goto L_0x0008
            cz.msebera.android.httpclient.util.ByteArrayBuffer r4 = r7.linebuffer
            int r4 = r4.length()
            if (r4 >= r3) goto L_0x005d
            goto L_0x0008
        L_0x005d:
            cz.msebera.android.httpclient.MessageConstraintException r8 = new cz.msebera.android.httpclient.MessageConstraintException
            java.lang.String r0 = "Maximum line length limit exceeded"
            r8.<init>(r0)
            throw r8
        L_0x0065:
            if (r2 != r3) goto L_0x0070
            cz.msebera.android.httpclient.util.ByteArrayBuffer r0 = r7.linebuffer
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0070
            return r3
        L_0x0070:
            int r8 = r7.lineFromLineBuffer(r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: p052cz.msebera.android.httpclient.impl.p053io.SessionInputBufferImpl.readLine(cz.msebera.android.httpclient.util.CharArrayBuffer):int");
    }

    private int lineFromLineBuffer(CharArrayBuffer charArrayBuffer) throws IOException {
        int length = this.linebuffer.length();
        if (length > 0) {
            if (this.linebuffer.byteAt(length - 1) == 10) {
                length--;
            }
            if (length > 0 && this.linebuffer.byteAt(length - 1) == 13) {
                length--;
            }
        }
        if (this.decoder == null) {
            charArrayBuffer.append(this.linebuffer, 0, length);
        } else {
            length = appendDecoded(charArrayBuffer, ByteBuffer.wrap(this.linebuffer.buffer(), 0, length));
        }
        this.linebuffer.clear();
        return length;
    }

    private int lineFromReadBuffer(CharArrayBuffer charArrayBuffer, int i) throws IOException {
        int i2 = this.bufferpos;
        this.bufferpos = i + 1;
        if (i > i2 && this.buffer[i - 1] == 13) {
            i--;
        }
        int i3 = i - i2;
        if (this.decoder != null) {
            return appendDecoded(charArrayBuffer, ByteBuffer.wrap(this.buffer, i2, i3));
        }
        charArrayBuffer.append(this.buffer, i2, i3);
        return i3;
    }

    private int appendDecoded(CharArrayBuffer charArrayBuffer, ByteBuffer byteBuffer) throws IOException {
        int i = 0;
        if (!byteBuffer.hasRemaining()) {
            return 0;
        }
        if (this.cbuf == null) {
            this.cbuf = CharBuffer.allocate(1024);
        }
        this.decoder.reset();
        while (byteBuffer.hasRemaining()) {
            i += handleDecodingResult(this.decoder.decode(byteBuffer, this.cbuf, true), charArrayBuffer, byteBuffer);
        }
        int handleDecodingResult = i + handleDecodingResult(this.decoder.flush(this.cbuf), charArrayBuffer, byteBuffer);
        this.cbuf.clear();
        return handleDecodingResult;
    }

    private int handleDecodingResult(CoderResult coderResult, CharArrayBuffer charArrayBuffer, ByteBuffer byteBuffer) throws IOException {
        if (coderResult.isError()) {
            coderResult.throwException();
        }
        this.cbuf.flip();
        int remaining = this.cbuf.remaining();
        while (this.cbuf.hasRemaining()) {
            charArrayBuffer.append(this.cbuf.get());
        }
        this.cbuf.compact();
        return remaining;
    }

    public String readLine() throws IOException {
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(64);
        if (readLine(charArrayBuffer) != -1) {
            return charArrayBuffer.toString();
        }
        return null;
    }

    public boolean isDataAvailable(int i) throws IOException {
        return hasBufferedData();
    }

    public HttpTransportMetrics getMetrics() {
        return this.metrics;
    }
}
