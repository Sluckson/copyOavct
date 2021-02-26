package p052cz.msebera.android.httpclient.impl.client;

import java.io.IOException;
import java.net.URI;
import p052cz.msebera.android.httpclient.HttpHost;
import p052cz.msebera.android.httpclient.HttpRequest;
import p052cz.msebera.android.httpclient.HttpResponse;
import p052cz.msebera.android.httpclient.annotation.ThreadSafe;
import p052cz.msebera.android.httpclient.client.HttpClient;
import p052cz.msebera.android.httpclient.client.ResponseHandler;
import p052cz.msebera.android.httpclient.client.ServiceUnavailableRetryStrategy;
import p052cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import p052cz.msebera.android.httpclient.conn.ClientConnectionManager;
import p052cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import p052cz.msebera.android.httpclient.params.HttpParams;
import p052cz.msebera.android.httpclient.protocol.HttpContext;
import p052cz.msebera.android.httpclient.util.Args;

@ThreadSafe
@Deprecated
/* renamed from: cz.msebera.android.httpclient.impl.client.AutoRetryHttpClient */
public class AutoRetryHttpClient implements HttpClient {
    private final HttpClient backend;
    public HttpClientAndroidLog log;
    private final ServiceUnavailableRetryStrategy retryStrategy;

    public AutoRetryHttpClient(HttpClient httpClient, ServiceUnavailableRetryStrategy serviceUnavailableRetryStrategy) {
        this.log = new HttpClientAndroidLog(getClass());
        Args.notNull(httpClient, "HttpClient");
        Args.notNull(serviceUnavailableRetryStrategy, "ServiceUnavailableRetryStrategy");
        this.backend = httpClient;
        this.retryStrategy = serviceUnavailableRetryStrategy;
    }

    public AutoRetryHttpClient() {
        this(new DefaultHttpClient(), new DefaultServiceUnavailableRetryStrategy());
    }

    public AutoRetryHttpClient(ServiceUnavailableRetryStrategy serviceUnavailableRetryStrategy) {
        this(new DefaultHttpClient(), serviceUnavailableRetryStrategy);
    }

    public AutoRetryHttpClient(HttpClient httpClient) {
        this(httpClient, new DefaultServiceUnavailableRetryStrategy());
    }

    public HttpResponse execute(HttpHost httpHost, HttpRequest httpRequest) throws IOException {
        return execute(httpHost, httpRequest, (HttpContext) null);
    }

    public <T> T execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler) throws IOException {
        return execute(httpHost, httpRequest, responseHandler, (HttpContext) null);
    }

    public <T> T execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws IOException {
        return responseHandler.handleResponse(execute(httpHost, httpRequest, httpContext));
    }

    public HttpResponse execute(HttpUriRequest httpUriRequest) throws IOException {
        return execute(httpUriRequest, (HttpContext) null);
    }

    public HttpResponse execute(HttpUriRequest httpUriRequest, HttpContext httpContext) throws IOException {
        URI uri = httpUriRequest.getURI();
        return execute(new HttpHost(uri.getHost(), uri.getPort(), uri.getScheme()), (HttpRequest) httpUriRequest, httpContext);
    }

    public <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler) throws IOException {
        return execute(httpUriRequest, responseHandler, (HttpContext) null);
    }

    public <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws IOException {
        return responseHandler.handleResponse(execute(httpUriRequest, httpContext));
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:9|10|11) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0044, code lost:
        throw new java.io.InterruptedIOException();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0038 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public p052cz.msebera.android.httpclient.HttpResponse execute(p052cz.msebera.android.httpclient.HttpHost r8, p052cz.msebera.android.httpclient.HttpRequest r9, p052cz.msebera.android.httpclient.protocol.HttpContext r10) throws java.io.IOException {
        /*
            r7 = this;
            r0 = 1
        L_0x0001:
            cz.msebera.android.httpclient.client.HttpClient r1 = r7.backend
            cz.msebera.android.httpclient.HttpResponse r1 = r1.execute((p052cz.msebera.android.httpclient.HttpHost) r8, (p052cz.msebera.android.httpclient.HttpRequest) r9, (p052cz.msebera.android.httpclient.protocol.HttpContext) r10)
            cz.msebera.android.httpclient.client.ServiceUnavailableRetryStrategy r2 = r7.retryStrategy     // Catch:{ RuntimeException -> 0x0046 }
            boolean r2 = r2.retryRequest(r1, r0, r10)     // Catch:{ RuntimeException -> 0x0046 }
            if (r2 == 0) goto L_0x0045
            cz.msebera.android.httpclient.HttpEntity r2 = r1.getEntity()     // Catch:{ RuntimeException -> 0x0046 }
            p052cz.msebera.android.httpclient.util.EntityUtils.consume(r2)     // Catch:{ RuntimeException -> 0x0046 }
            cz.msebera.android.httpclient.client.ServiceUnavailableRetryStrategy r2 = r7.retryStrategy     // Catch:{ RuntimeException -> 0x0046 }
            long r2 = r2.getRetryInterval()     // Catch:{ RuntimeException -> 0x0046 }
            cz.msebera.android.httpclient.extras.HttpClientAndroidLog r4 = r7.log     // Catch:{ InterruptedException -> 0x0038 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ InterruptedException -> 0x0038 }
            r5.<init>()     // Catch:{ InterruptedException -> 0x0038 }
            java.lang.String r6 = "Wait for "
            r5.append(r6)     // Catch:{ InterruptedException -> 0x0038 }
            r5.append(r2)     // Catch:{ InterruptedException -> 0x0038 }
            java.lang.String r5 = r5.toString()     // Catch:{ InterruptedException -> 0x0038 }
            r4.trace(r5)     // Catch:{ InterruptedException -> 0x0038 }
            java.lang.Thread.sleep(r2)     // Catch:{ InterruptedException -> 0x0038 }
            int r0 = r0 + 1
            goto L_0x0001
        L_0x0038:
            java.lang.Thread r8 = java.lang.Thread.currentThread()     // Catch:{ RuntimeException -> 0x0046 }
            r8.interrupt()     // Catch:{ RuntimeException -> 0x0046 }
            java.io.InterruptedIOException r8 = new java.io.InterruptedIOException     // Catch:{ RuntimeException -> 0x0046 }
            r8.<init>()     // Catch:{ RuntimeException -> 0x0046 }
            throw r8     // Catch:{ RuntimeException -> 0x0046 }
        L_0x0045:
            return r1
        L_0x0046:
            r8 = move-exception
            cz.msebera.android.httpclient.HttpEntity r9 = r1.getEntity()     // Catch:{ IOException -> 0x004f }
            p052cz.msebera.android.httpclient.util.EntityUtils.consume(r9)     // Catch:{ IOException -> 0x004f }
            goto L_0x0057
        L_0x004f:
            r9 = move-exception
            cz.msebera.android.httpclient.extras.HttpClientAndroidLog r10 = r7.log
            java.lang.String r0 = "I/O error consuming response content"
            r10.warn(r0, r9)
        L_0x0057:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: p052cz.msebera.android.httpclient.impl.client.AutoRetryHttpClient.execute(cz.msebera.android.httpclient.HttpHost, cz.msebera.android.httpclient.HttpRequest, cz.msebera.android.httpclient.protocol.HttpContext):cz.msebera.android.httpclient.HttpResponse");
    }

    public ClientConnectionManager getConnectionManager() {
        return this.backend.getConnectionManager();
    }

    public HttpParams getParams() {
        return this.backend.getParams();
    }
}
