package p052cz.msebera.android.httpclient.impl.p053io;

import java.io.IOException;
import java.net.Socket;
import p052cz.msebera.android.httpclient.annotation.NotThreadSafe;
import p052cz.msebera.android.httpclient.p054io.EofSensor;
import p052cz.msebera.android.httpclient.params.HttpParams;
import p052cz.msebera.android.httpclient.util.Args;

@NotThreadSafe
@Deprecated
/* renamed from: cz.msebera.android.httpclient.impl.io.SocketInputBuffer */
public class SocketInputBuffer extends AbstractSessionInputBuffer implements EofSensor {
    private boolean eof = false;
    private final Socket socket;

    public SocketInputBuffer(Socket socket2, int i, HttpParams httpParams) throws IOException {
        Args.notNull(socket2, "Socket");
        this.socket = socket2;
        i = i < 0 ? socket2.getReceiveBufferSize() : i;
        init(socket2.getInputStream(), i < 1024 ? 1024 : i, httpParams);
    }

    /* access modifiers changed from: protected */
    public int fillBuffer() throws IOException {
        int fillBuffer = super.fillBuffer();
        this.eof = fillBuffer == -1;
        return fillBuffer;
    }

    /* JADX INFO: finally extract failed */
    public boolean isDataAvailable(int i) throws IOException {
        boolean hasBufferedData = hasBufferedData();
        if (hasBufferedData) {
            return hasBufferedData;
        }
        int soTimeout = this.socket.getSoTimeout();
        try {
            this.socket.setSoTimeout(i);
            fillBuffer();
            boolean hasBufferedData2 = hasBufferedData();
            this.socket.setSoTimeout(soTimeout);
            return hasBufferedData2;
        } catch (Throwable th) {
            this.socket.setSoTimeout(soTimeout);
            throw th;
        }
    }

    public boolean isEof() {
        return this.eof;
    }
}
