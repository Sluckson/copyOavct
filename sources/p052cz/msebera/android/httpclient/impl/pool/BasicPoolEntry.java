package p052cz.msebera.android.httpclient.impl.pool;

import java.io.IOException;
import p052cz.msebera.android.httpclient.HttpClientConnection;
import p052cz.msebera.android.httpclient.HttpHost;
import p052cz.msebera.android.httpclient.annotation.ThreadSafe;
import p052cz.msebera.android.httpclient.pool.PoolEntry;

@ThreadSafe
/* renamed from: cz.msebera.android.httpclient.impl.pool.BasicPoolEntry */
public class BasicPoolEntry extends PoolEntry<HttpHost, HttpClientConnection> {
    public BasicPoolEntry(String str, HttpHost httpHost, HttpClientConnection httpClientConnection) {
        super(str, httpHost, httpClientConnection);
    }

    public void close() {
        try {
            ((HttpClientConnection) getConnection()).close();
        } catch (IOException unused) {
        }
    }

    public boolean isClosed() {
        return !((HttpClientConnection) getConnection()).isOpen();
    }
}
