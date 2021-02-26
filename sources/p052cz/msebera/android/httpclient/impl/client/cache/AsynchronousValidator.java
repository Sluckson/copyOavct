package p052cz.msebera.android.httpclient.impl.client.cache;

import java.io.Closeable;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.RejectedExecutionException;
import p052cz.msebera.android.httpclient.client.cache.HttpCacheEntry;
import p052cz.msebera.android.httpclient.client.methods.HttpExecutionAware;
import p052cz.msebera.android.httpclient.client.methods.HttpRequestWrapper;
import p052cz.msebera.android.httpclient.client.protocol.HttpClientContext;
import p052cz.msebera.android.httpclient.conn.routing.HttpRoute;
import p052cz.msebera.android.httpclient.extras.HttpClientAndroidLog;

/* renamed from: cz.msebera.android.httpclient.impl.client.cache.AsynchronousValidator */
class AsynchronousValidator implements Closeable {
    private final CacheKeyGenerator cacheKeyGenerator;
    private final FailureCache failureCache;
    public HttpClientAndroidLog log;
    private final Set<String> queued;
    private final SchedulingStrategy schedulingStrategy;

    public AsynchronousValidator(CacheConfig cacheConfig) {
        this((SchedulingStrategy) new ImmediateSchedulingStrategy(cacheConfig));
    }

    AsynchronousValidator(SchedulingStrategy schedulingStrategy2) {
        this.log = new HttpClientAndroidLog(getClass());
        this.schedulingStrategy = schedulingStrategy2;
        this.queued = new HashSet();
        this.cacheKeyGenerator = new CacheKeyGenerator();
        this.failureCache = new DefaultFailureCache();
    }

    public void close() throws IOException {
        this.schedulingStrategy.close();
    }

    public synchronized void revalidateCacheEntry(CachingExec cachingExec, HttpRoute httpRoute, HttpRequestWrapper httpRequestWrapper, HttpClientContext httpClientContext, HttpExecutionAware httpExecutionAware, HttpCacheEntry httpCacheEntry) {
        synchronized (this) {
            String variantURI = this.cacheKeyGenerator.getVariantURI(httpClientContext.getTargetHost(), httpRequestWrapper, httpCacheEntry);
            if (!this.queued.contains(variantURI)) {
                try {
                    this.schedulingStrategy.schedule(new AsynchronousValidationRequest(this, cachingExec, httpRoute, httpRequestWrapper, httpClientContext, httpExecutionAware, httpCacheEntry, variantURI, this.failureCache.getErrorCount(variantURI)));
                    this.queued.add(variantURI);
                } catch (RejectedExecutionException e) {
                    HttpClientAndroidLog httpClientAndroidLog = this.log;
                    httpClientAndroidLog.debug("Revalidation for [" + variantURI + "] not scheduled: " + e);
                }
            }
        }
        return;
    }

    /* access modifiers changed from: package-private */
    public synchronized void markComplete(String str) {
        this.queued.remove(str);
    }

    /* access modifiers changed from: package-private */
    public void jobSuccessful(String str) {
        this.failureCache.resetErrorCount(str);
    }

    /* access modifiers changed from: package-private */
    public void jobFailed(String str) {
        this.failureCache.increaseErrorCount(str);
    }

    /* access modifiers changed from: package-private */
    public Set<String> getScheduledIdentifiers() {
        return Collections.unmodifiableSet(this.queued);
    }
}
