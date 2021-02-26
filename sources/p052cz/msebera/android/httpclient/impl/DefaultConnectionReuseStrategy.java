package p052cz.msebera.android.httpclient.impl;

import p052cz.msebera.android.httpclient.ConnectionReuseStrategy;
import p052cz.msebera.android.httpclient.HeaderIterator;
import p052cz.msebera.android.httpclient.HttpResponse;
import p052cz.msebera.android.httpclient.TokenIterator;
import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.message.BasicTokenIterator;

@Immutable
/* renamed from: cz.msebera.android.httpclient.impl.DefaultConnectionReuseStrategy */
public class DefaultConnectionReuseStrategy implements ConnectionReuseStrategy {
    public static final DefaultConnectionReuseStrategy INSTANCE = new DefaultConnectionReuseStrategy();

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0042, code lost:
        if (java.lang.Integer.parseInt(r0[0].getValue()) < 0) goto L_0x0044;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean keepAlive(p052cz.msebera.android.httpclient.HttpResponse r6, p052cz.msebera.android.httpclient.protocol.HttpContext r7) {
        /*
            r5 = this;
            java.lang.String r0 = "HTTP response"
            p052cz.msebera.android.httpclient.util.Args.notNull(r6, r0)
            java.lang.String r0 = "HTTP context"
            p052cz.msebera.android.httpclient.util.Args.notNull(r7, r0)
            cz.msebera.android.httpclient.StatusLine r7 = r6.getStatusLine()
            cz.msebera.android.httpclient.ProtocolVersion r7 = r7.getProtocolVersion()
            java.lang.String r0 = "Transfer-Encoding"
            cz.msebera.android.httpclient.Header r0 = r6.getFirstHeader(r0)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0029
            java.lang.String r0 = r0.getValue()
            java.lang.String r3 = "chunked"
            boolean r0 = r3.equalsIgnoreCase(r0)
            if (r0 != 0) goto L_0x0045
            return r2
        L_0x0029:
            boolean r0 = r5.canResponseHaveBody(r6)
            if (r0 == 0) goto L_0x0045
            java.lang.String r0 = "Content-Length"
            cz.msebera.android.httpclient.Header[] r0 = r6.getHeaders(r0)
            int r3 = r0.length
            if (r3 != r1) goto L_0x0044
            r0 = r0[r2]
            java.lang.String r0 = r0.getValue()     // Catch:{ NumberFormatException -> 0x0044 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException -> 0x0044 }
            if (r0 >= 0) goto L_0x0045
        L_0x0044:
            return r2
        L_0x0045:
            java.lang.String r0 = "Connection"
            cz.msebera.android.httpclient.HeaderIterator r0 = r6.headerIterator(r0)
            boolean r3 = r0.hasNext()
            if (r3 != 0) goto L_0x0057
            java.lang.String r0 = "Proxy-Connection"
            cz.msebera.android.httpclient.HeaderIterator r0 = r6.headerIterator(r0)
        L_0x0057:
            boolean r6 = r0.hasNext()
            if (r6 == 0) goto L_0x0083
            cz.msebera.android.httpclient.TokenIterator r6 = r5.createTokenIterator(r0)     // Catch:{ ParseException -> 0x0082 }
            r0 = 0
        L_0x0062:
            boolean r3 = r6.hasNext()     // Catch:{ ParseException -> 0x0082 }
            if (r3 == 0) goto L_0x007f
            java.lang.String r3 = r6.nextToken()     // Catch:{ ParseException -> 0x0082 }
            java.lang.String r4 = "Close"
            boolean r4 = r4.equalsIgnoreCase(r3)     // Catch:{ ParseException -> 0x0082 }
            if (r4 == 0) goto L_0x0075
            return r2
        L_0x0075:
            java.lang.String r4 = "Keep-Alive"
            boolean r3 = r4.equalsIgnoreCase(r3)     // Catch:{ ParseException -> 0x0082 }
            if (r3 == 0) goto L_0x0062
            r0 = 1
            goto L_0x0062
        L_0x007f:
            if (r0 == 0) goto L_0x0083
            return r1
        L_0x0082:
            return r2
        L_0x0083:
            cz.msebera.android.httpclient.HttpVersion r6 = p052cz.msebera.android.httpclient.HttpVersion.HTTP_1_0
            boolean r6 = r7.lessEquals(r6)
            r6 = r6 ^ r1
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: p052cz.msebera.android.httpclient.impl.DefaultConnectionReuseStrategy.keepAlive(cz.msebera.android.httpclient.HttpResponse, cz.msebera.android.httpclient.protocol.HttpContext):boolean");
    }

    /* access modifiers changed from: protected */
    public TokenIterator createTokenIterator(HeaderIterator headerIterator) {
        return new BasicTokenIterator(headerIterator);
    }

    private boolean canResponseHaveBody(HttpResponse httpResponse) {
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        return (statusCode < 200 || statusCode == 204 || statusCode == 304 || statusCode == 205) ? false : true;
    }
}
