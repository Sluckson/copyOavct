package p052cz.msebera.android.httpclient.impl.client.cache;

import java.io.IOException;
import p052cz.msebera.android.httpclient.Header;
import p052cz.msebera.android.httpclient.HttpException;
import p052cz.msebera.android.httpclient.HttpResponse;
import p052cz.msebera.android.httpclient.client.cache.HttpCacheEntry;
import p052cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import p052cz.msebera.android.httpclient.client.methods.HttpExecutionAware;
import p052cz.msebera.android.httpclient.client.methods.HttpRequestWrapper;
import p052cz.msebera.android.httpclient.client.protocol.HttpClientContext;
import p052cz.msebera.android.httpclient.conn.routing.HttpRoute;
import p052cz.msebera.android.httpclient.extras.HttpClientAndroidLog;

/* renamed from: cz.msebera.android.httpclient.impl.client.cache.AsynchronousValidationRequest */
class AsynchronousValidationRequest implements Runnable {
    private final HttpCacheEntry cacheEntry;
    private final CachingExec cachingExec;
    private final int consecutiveFailedAttempts;
    private final HttpClientContext context;
    private final HttpExecutionAware execAware;
    private final String identifier;
    public HttpClientAndroidLog log = new HttpClientAndroidLog(getClass());
    private final AsynchronousValidator parent;
    private final HttpRequestWrapper request;
    private final HttpRoute route;

    private boolean isNotServerError(int i) {
        return i < 500;
    }

    AsynchronousValidationRequest(AsynchronousValidator asynchronousValidator, CachingExec cachingExec2, HttpRoute httpRoute, HttpRequestWrapper httpRequestWrapper, HttpClientContext httpClientContext, HttpExecutionAware httpExecutionAware, HttpCacheEntry httpCacheEntry, String str, int i) {
        this.parent = asynchronousValidator;
        this.cachingExec = cachingExec2;
        this.route = httpRoute;
        this.request = httpRequestWrapper;
        this.context = httpClientContext;
        this.execAware = httpExecutionAware;
        this.cacheEntry = httpCacheEntry;
        this.identifier = str;
        this.consecutiveFailedAttempts = i;
    }

    public void run() {
        try {
            if (revalidateCacheEntry()) {
                this.parent.jobSuccessful(this.identifier);
            } else {
                this.parent.jobFailed(this.identifier);
            }
        } finally {
            this.parent.markComplete(this.identifier);
        }
    }

    /* access modifiers changed from: protected */
    public boolean revalidateCacheEntry() {
        CloseableHttpResponse revalidateCacheEntry;
        try {
            revalidateCacheEntry = this.cachingExec.revalidateCacheEntry(this.route, this.request, this.context, this.execAware, this.cacheEntry);
            boolean z = isNotServerError(revalidateCacheEntry.getStatusLine().getStatusCode()) && isNotStale(revalidateCacheEntry);
            revalidateCacheEntry.close();
            return z;
        } catch (IOException e) {
            this.log.debug("Asynchronous revalidation failed due to I/O error", e);
            return false;
        } catch (HttpException e2) {
            this.log.error("HTTP protocol exception during asynchronous revalidation", e2);
            return false;
        } catch (RuntimeException e3) {
            HttpClientAndroidLog httpClientAndroidLog = this.log;
            httpClientAndroidLog.error("RuntimeException thrown during asynchronous revalidation: " + e3);
            return false;
        } catch (Throwable th) {
            revalidateCacheEntry.close();
            throw th;
        }
    }

    private boolean isNotStale(HttpResponse httpResponse) {
        Header[] headers = httpResponse.getHeaders("Warning");
        if (headers == null) {
            return true;
        }
        for (Header value : headers) {
            String value2 = value.getValue();
            if (value2.startsWith("110") || value2.startsWith("111")) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public String getIdentifier() {
        return this.identifier;
    }

    public int getConsecutiveFailedAttempts() {
        return this.consecutiveFailedAttempts;
    }
}
