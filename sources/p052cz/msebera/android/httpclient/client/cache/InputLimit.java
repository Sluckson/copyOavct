package p052cz.msebera.android.httpclient.client.cache;

import p052cz.msebera.android.httpclient.annotation.NotThreadSafe;

@NotThreadSafe
/* renamed from: cz.msebera.android.httpclient.client.cache.InputLimit */
public class InputLimit {
    private boolean reached = false;
    private final long value;

    public InputLimit(long j) {
        this.value = j;
    }

    public long getValue() {
        return this.value;
    }

    public void reached() {
        this.reached = true;
    }

    public boolean isReached() {
        return this.reached;
    }
}
