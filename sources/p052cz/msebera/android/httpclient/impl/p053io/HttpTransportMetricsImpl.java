package p052cz.msebera.android.httpclient.impl.p053io;

import p052cz.msebera.android.httpclient.annotation.NotThreadSafe;
import p052cz.msebera.android.httpclient.p054io.HttpTransportMetrics;

@NotThreadSafe
/* renamed from: cz.msebera.android.httpclient.impl.io.HttpTransportMetricsImpl */
public class HttpTransportMetricsImpl implements HttpTransportMetrics {
    private long bytesTransferred = 0;

    public long getBytesTransferred() {
        return this.bytesTransferred;
    }

    public void setBytesTransferred(long j) {
        this.bytesTransferred = j;
    }

    public void incrementBytesTransferred(long j) {
        this.bytesTransferred += j;
    }

    public void reset() {
        this.bytesTransferred = 0;
    }
}
