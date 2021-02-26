package p052cz.msebera.android.httpclient.impl.p053io;

import java.io.IOException;
import java.io.InputStream;
import p052cz.msebera.android.httpclient.annotation.NotThreadSafe;
import p052cz.msebera.android.httpclient.p054io.BufferInfo;
import p052cz.msebera.android.httpclient.p054io.SessionInputBuffer;
import p052cz.msebera.android.httpclient.util.Args;

@NotThreadSafe
/* renamed from: cz.msebera.android.httpclient.impl.io.IdentityInputStream */
public class IdentityInputStream extends InputStream {
    private boolean closed = false;

    /* renamed from: in */
    private final SessionInputBuffer f4895in;

    public IdentityInputStream(SessionInputBuffer sessionInputBuffer) {
        this.f4895in = (SessionInputBuffer) Args.notNull(sessionInputBuffer, "Session input buffer");
    }

    public int available() throws IOException {
        SessionInputBuffer sessionInputBuffer = this.f4895in;
        if (sessionInputBuffer instanceof BufferInfo) {
            return ((BufferInfo) sessionInputBuffer).length();
        }
        return 0;
    }

    public void close() throws IOException {
        this.closed = true;
    }

    public int read() throws IOException {
        if (this.closed) {
            return -1;
        }
        return this.f4895in.read();
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.closed) {
            return -1;
        }
        return this.f4895in.read(bArr, i, i2);
    }
}
