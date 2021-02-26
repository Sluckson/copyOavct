package p052cz.msebera.android.httpclient.impl.client;

import p052cz.msebera.android.httpclient.HttpRequestInterceptor;
import p052cz.msebera.android.httpclient.HttpResponseInterceptor;
import p052cz.msebera.android.httpclient.HttpVersion;
import p052cz.msebera.android.httpclient.annotation.ThreadSafe;
import p052cz.msebera.android.httpclient.client.protocol.RequestAddCookies;
import p052cz.msebera.android.httpclient.client.protocol.RequestAuthCache;
import p052cz.msebera.android.httpclient.client.protocol.RequestClientConnControl;
import p052cz.msebera.android.httpclient.client.protocol.RequestDefaultHeaders;
import p052cz.msebera.android.httpclient.client.protocol.RequestProxyAuthentication;
import p052cz.msebera.android.httpclient.client.protocol.RequestTargetAuthentication;
import p052cz.msebera.android.httpclient.client.protocol.ResponseProcessCookies;
import p052cz.msebera.android.httpclient.conn.ClientConnectionManager;
import p052cz.msebera.android.httpclient.params.HttpConnectionParams;
import p052cz.msebera.android.httpclient.params.HttpParams;
import p052cz.msebera.android.httpclient.params.HttpProtocolParams;
import p052cz.msebera.android.httpclient.params.SyncBasicHttpParams;
import p052cz.msebera.android.httpclient.protocol.BasicHttpProcessor;
import p052cz.msebera.android.httpclient.protocol.HTTP;
import p052cz.msebera.android.httpclient.protocol.RequestContent;
import p052cz.msebera.android.httpclient.protocol.RequestExpectContinue;
import p052cz.msebera.android.httpclient.protocol.RequestTargetHost;
import p052cz.msebera.android.httpclient.protocol.RequestUserAgent;

@ThreadSafe
@Deprecated
/* renamed from: cz.msebera.android.httpclient.impl.client.DefaultHttpClient */
public class DefaultHttpClient extends AbstractHttpClient {
    public DefaultHttpClient(ClientConnectionManager clientConnectionManager, HttpParams httpParams) {
        super(clientConnectionManager, httpParams);
    }

    public DefaultHttpClient(ClientConnectionManager clientConnectionManager) {
        super(clientConnectionManager, (HttpParams) null);
    }

    public DefaultHttpClient(HttpParams httpParams) {
        super((ClientConnectionManager) null, httpParams);
    }

    public DefaultHttpClient() {
        super((ClientConnectionManager) null, (HttpParams) null);
    }

    /* access modifiers changed from: protected */
    public HttpParams createHttpParams() {
        SyncBasicHttpParams syncBasicHttpParams = new SyncBasicHttpParams();
        setDefaultHttpParams(syncBasicHttpParams);
        return syncBasicHttpParams;
    }

    public static void setDefaultHttpParams(HttpParams httpParams) {
        HttpProtocolParams.setVersion(httpParams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(httpParams, HTTP.DEF_CONTENT_CHARSET.name());
        HttpConnectionParams.setTcpNoDelay(httpParams, true);
        HttpConnectionParams.setSocketBufferSize(httpParams, 8192);
        HttpProtocolParams.setUserAgent(httpParams, HttpClientBuilder.DEFAULT_USER_AGENT);
    }

    /* access modifiers changed from: protected */
    public BasicHttpProcessor createHttpProcessor() {
        BasicHttpProcessor basicHttpProcessor = new BasicHttpProcessor();
        basicHttpProcessor.addInterceptor((HttpRequestInterceptor) new RequestDefaultHeaders());
        basicHttpProcessor.addInterceptor((HttpRequestInterceptor) new RequestContent());
        basicHttpProcessor.addInterceptor((HttpRequestInterceptor) new RequestTargetHost());
        basicHttpProcessor.addInterceptor((HttpRequestInterceptor) new RequestClientConnControl());
        basicHttpProcessor.addInterceptor((HttpRequestInterceptor) new RequestUserAgent());
        basicHttpProcessor.addInterceptor((HttpRequestInterceptor) new RequestExpectContinue());
        basicHttpProcessor.addInterceptor((HttpRequestInterceptor) new RequestAddCookies());
        basicHttpProcessor.addInterceptor((HttpResponseInterceptor) new ResponseProcessCookies());
        basicHttpProcessor.addInterceptor((HttpRequestInterceptor) new RequestAuthCache());
        basicHttpProcessor.addInterceptor((HttpRequestInterceptor) new RequestTargetAuthentication());
        basicHttpProcessor.addInterceptor((HttpRequestInterceptor) new RequestProxyAuthentication());
        return basicHttpProcessor;
    }
}
