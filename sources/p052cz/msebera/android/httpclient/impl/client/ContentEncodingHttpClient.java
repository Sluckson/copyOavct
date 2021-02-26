package p052cz.msebera.android.httpclient.impl.client;

import p052cz.msebera.android.httpclient.annotation.ThreadSafe;
import p052cz.msebera.android.httpclient.client.protocol.RequestAcceptEncoding;
import p052cz.msebera.android.httpclient.client.protocol.ResponseContentEncoding;
import p052cz.msebera.android.httpclient.conn.ClientConnectionManager;
import p052cz.msebera.android.httpclient.params.HttpParams;
import p052cz.msebera.android.httpclient.protocol.BasicHttpProcessor;

@ThreadSafe
@Deprecated
/* renamed from: cz.msebera.android.httpclient.impl.client.ContentEncodingHttpClient */
public class ContentEncodingHttpClient extends DefaultHttpClient {
    public ContentEncodingHttpClient(ClientConnectionManager clientConnectionManager, HttpParams httpParams) {
        super(clientConnectionManager, httpParams);
    }

    public ContentEncodingHttpClient(HttpParams httpParams) {
        this((ClientConnectionManager) null, httpParams);
    }

    public ContentEncodingHttpClient() {
        this((HttpParams) null);
    }

    /* access modifiers changed from: protected */
    public BasicHttpProcessor createHttpProcessor() {
        BasicHttpProcessor createHttpProcessor = super.createHttpProcessor();
        createHttpProcessor.addRequestInterceptor(new RequestAcceptEncoding());
        createHttpProcessor.addResponseInterceptor(new ResponseContentEncoding());
        return createHttpProcessor;
    }
}
