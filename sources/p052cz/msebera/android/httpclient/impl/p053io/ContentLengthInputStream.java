package p052cz.msebera.android.httpclient.impl.p053io;

import android.support.p000v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.io.InputStream;
import p052cz.msebera.android.httpclient.ConnectionClosedException;
import p052cz.msebera.android.httpclient.annotation.NotThreadSafe;
import p052cz.msebera.android.httpclient.p054io.BufferInfo;
import p052cz.msebera.android.httpclient.p054io.SessionInputBuffer;
import p052cz.msebera.android.httpclient.util.Args;

@NotThreadSafe
/* renamed from: cz.msebera.android.httpclient.impl.io.ContentLengthInputStream */
public class ContentLengthInputStream extends InputStream {
    private static final int BUFFER_SIZE = 2048;
    private boolean closed = false;
    private final long contentLength;

    /* renamed from: in */
    private SessionInputBuffer f4894in = null;
    private long pos = 0;

    public ContentLengthInputStream(SessionInputBuffer sessionInputBuffer, long j) {
        this.f4894in = (SessionInputBuffer) Args.notNull(sessionInputBuffer, "Session input buffer");
        this.contentLength = Args.notNegative(j, "Content length");
    }

    public void close() throws IOException {
        if (!this.closed) {
            try {
                if (this.pos < this.contentLength) {
                    do {
                    } while (read(new byte[2048]) >= 0);
                }
            } finally {
                this.closed = true;
            }
        }
    }

    public int available() throws IOException {
        SessionInputBuffer sessionInputBuffer = this.f4894in;
        if (sessionInputBuffer instanceof BufferInfo) {
            return Math.min(((BufferInfo) sessionInputBuffer).length(), (int) (this.contentLength - this.pos));
        }
        return 0;
    }

    public int read() throws IOException {
        if (this.closed) {
            throw new IOException("Attempted read from closed stream.");
        } else if (this.pos >= this.contentLength) {
            return -1;
        } else {
            int read = this.f4894in.read();
            if (read != -1) {
                this.pos++;
            } else if (this.pos < this.contentLength) {
                throw new ConnectionClosedException("Premature end of Content-Length delimited message body (expected: " + this.contentLength + "; received: " + this.pos);
            }
            return read;
        }
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (!this.closed) {
            long j = this.pos;
            long j2 = this.contentLength;
            if (j >= j2) {
                return -1;
            }
            if (((long) i2) + j > j2) {
                i2 = (int) (j2 - j);
            }
            int read = this.f4894in.read(bArr, i, i2);
            if (read != -1 || this.pos >= this.contentLength) {
                if (read > 0) {
                    this.pos += (long) read;
                }
                return read;
            }
            throw new ConnectionClosedException("Premature end of Content-Length delimited message body (expected: " + this.contentLength + "; received: " + this.pos);
        }
        throw new IOException("Attempted read from closed stream.");
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public long skip(long j) throws IOException {
        int read;
        if (j <= 0) {
            return 0;
        }
        byte[] bArr = new byte[2048];
        long min = Math.min(j, this.contentLength - this.pos);
        long j2 = 0;
        while (min > 0 && (read = read(bArr, 0, (int) Math.min(PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH, min))) != -1) {
            long j3 = (long) read;
            j2 += j3;
            min -= j3;
        }
        return j2;
    }
}
