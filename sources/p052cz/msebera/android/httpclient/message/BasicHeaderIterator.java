package p052cz.msebera.android.httpclient.message;

import java.util.NoSuchElementException;
import p052cz.msebera.android.httpclient.Header;
import p052cz.msebera.android.httpclient.HeaderIterator;
import p052cz.msebera.android.httpclient.annotation.NotThreadSafe;
import p052cz.msebera.android.httpclient.util.Args;

@NotThreadSafe
/* renamed from: cz.msebera.android.httpclient.message.BasicHeaderIterator */
public class BasicHeaderIterator implements HeaderIterator {
    protected final Header[] allHeaders;
    protected int currentIndex = findNext(-1);
    protected String headerName;

    public BasicHeaderIterator(Header[] headerArr, String str) {
        this.allHeaders = (Header[]) Args.notNull(headerArr, "Header array");
        this.headerName = str;
    }

    /* access modifiers changed from: protected */
    public int findNext(int i) {
        if (i < -1) {
            return -1;
        }
        int length = this.allHeaders.length - 1;
        boolean z = false;
        while (!z && i < length) {
            i++;
            z = filterHeader(i);
        }
        if (z) {
            return i;
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public boolean filterHeader(int i) {
        String str = this.headerName;
        return str == null || str.equalsIgnoreCase(this.allHeaders[i].getName());
    }

    public boolean hasNext() {
        return this.currentIndex >= 0;
    }

    public Header nextHeader() throws NoSuchElementException {
        int i = this.currentIndex;
        if (i >= 0) {
            this.currentIndex = findNext(i);
            return this.allHeaders[i];
        }
        throw new NoSuchElementException("Iteration already finished.");
    }

    public final Object next() throws NoSuchElementException {
        return nextHeader();
    }

    public void remove() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Removing headers is not supported.");
    }
}
