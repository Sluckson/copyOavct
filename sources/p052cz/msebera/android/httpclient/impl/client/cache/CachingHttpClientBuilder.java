package p052cz.msebera.android.httpclient.impl.client.cache;

import java.io.File;
import p052cz.msebera.android.httpclient.client.cache.HttpCacheInvalidator;
import p052cz.msebera.android.httpclient.client.cache.HttpCacheStorage;
import p052cz.msebera.android.httpclient.client.cache.ResourceFactory;
import p052cz.msebera.android.httpclient.impl.client.HttpClientBuilder;

/* renamed from: cz.msebera.android.httpclient.impl.client.cache.CachingHttpClientBuilder */
public class CachingHttpClientBuilder extends HttpClientBuilder {
    private CacheConfig cacheConfig;
    private File cacheDir;
    private HttpCacheInvalidator httpCacheInvalidator;
    private ResourceFactory resourceFactory;
    private SchedulingStrategy schedulingStrategy;
    private HttpCacheStorage storage;

    public static CachingHttpClientBuilder create() {
        return new CachingHttpClientBuilder();
    }

    protected CachingHttpClientBuilder() {
    }

    public final CachingHttpClientBuilder setResourceFactory(ResourceFactory resourceFactory2) {
        this.resourceFactory = resourceFactory2;
        return this;
    }

    public final CachingHttpClientBuilder setHttpCacheStorage(HttpCacheStorage httpCacheStorage) {
        this.storage = httpCacheStorage;
        return this;
    }

    public final CachingHttpClientBuilder setCacheDir(File file) {
        this.cacheDir = file;
        return this;
    }

    public final CachingHttpClientBuilder setCacheConfig(CacheConfig cacheConfig2) {
        this.cacheConfig = cacheConfig2;
        return this;
    }

    public final CachingHttpClientBuilder setSchedulingStrategy(SchedulingStrategy schedulingStrategy2) {
        this.schedulingStrategy = schedulingStrategy2;
        return this;
    }

    public final CachingHttpClientBuilder setHttpCacheInvalidator(HttpCacheInvalidator httpCacheInvalidator2) {
        this.httpCacheInvalidator = httpCacheInvalidator2;
        return this;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0020  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0040  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public p052cz.msebera.android.httpclient.impl.execchain.ClientExecChain decorateMainExec(p052cz.msebera.android.httpclient.impl.execchain.ClientExecChain r11) {
        /*
            r10 = this;
            cz.msebera.android.httpclient.impl.client.cache.CacheConfig r0 = r10.cacheConfig
            if (r0 == 0) goto L_0x0005
            goto L_0x0007
        L_0x0005:
            cz.msebera.android.httpclient.impl.client.cache.CacheConfig r0 = p052cz.msebera.android.httpclient.impl.client.cache.CacheConfig.DEFAULT
        L_0x0007:
            cz.msebera.android.httpclient.client.cache.ResourceFactory r1 = r10.resourceFactory
            if (r1 != 0) goto L_0x001b
            java.io.File r1 = r10.cacheDir
            if (r1 != 0) goto L_0x0015
            cz.msebera.android.httpclient.impl.client.cache.HeapResourceFactory r1 = new cz.msebera.android.httpclient.impl.client.cache.HeapResourceFactory
            r1.<init>()
            goto L_0x001b
        L_0x0015:
            cz.msebera.android.httpclient.impl.client.cache.FileResourceFactory r2 = new cz.msebera.android.httpclient.impl.client.cache.FileResourceFactory
            r2.<init>(r1)
            goto L_0x001c
        L_0x001b:
            r2 = r1
        L_0x001c:
            cz.msebera.android.httpclient.client.cache.HttpCacheStorage r1 = r10.storage
            if (r1 != 0) goto L_0x0032
            java.io.File r1 = r10.cacheDir
            if (r1 != 0) goto L_0x002a
            cz.msebera.android.httpclient.impl.client.cache.BasicHttpCacheStorage r1 = new cz.msebera.android.httpclient.impl.client.cache.BasicHttpCacheStorage
            r1.<init>(r0)
            goto L_0x0032
        L_0x002a:
            cz.msebera.android.httpclient.impl.client.cache.ManagedHttpCacheStorage r1 = new cz.msebera.android.httpclient.impl.client.cache.ManagedHttpCacheStorage
            r1.<init>(r0)
            r10.addCloseable(r1)
        L_0x0032:
            r3 = r1
            cz.msebera.android.httpclient.impl.client.cache.AsynchronousValidator r7 = r10.createAsynchronousRevalidator(r0)
            cz.msebera.android.httpclient.impl.client.cache.CacheKeyGenerator r5 = new cz.msebera.android.httpclient.impl.client.cache.CacheKeyGenerator
            r5.<init>()
            cz.msebera.android.httpclient.client.cache.HttpCacheInvalidator r1 = r10.httpCacheInvalidator
            if (r1 != 0) goto L_0x0045
            cz.msebera.android.httpclient.impl.client.cache.CacheInvalidator r1 = new cz.msebera.android.httpclient.impl.client.cache.CacheInvalidator
            r1.<init>(r5, r3)
        L_0x0045:
            r6 = r1
            cz.msebera.android.httpclient.impl.client.cache.CachingExec r8 = new cz.msebera.android.httpclient.impl.client.cache.CachingExec
            cz.msebera.android.httpclient.impl.client.cache.BasicHttpCache r9 = new cz.msebera.android.httpclient.impl.client.cache.BasicHttpCache
            r1 = r9
            r4 = r0
            r1.<init>(r2, r3, r4, r5, r6)
            r8.<init>((p052cz.msebera.android.httpclient.impl.execchain.ClientExecChain) r11, (p052cz.msebera.android.httpclient.impl.client.cache.HttpCache) r9, (p052cz.msebera.android.httpclient.impl.client.cache.CacheConfig) r0, (p052cz.msebera.android.httpclient.impl.client.cache.AsynchronousValidator) r7)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: p052cz.msebera.android.httpclient.impl.client.cache.CachingHttpClientBuilder.decorateMainExec(cz.msebera.android.httpclient.impl.execchain.ClientExecChain):cz.msebera.android.httpclient.impl.execchain.ClientExecChain");
    }

    private AsynchronousValidator createAsynchronousRevalidator(CacheConfig cacheConfig2) {
        if (cacheConfig2.getAsynchronousWorkersMax() <= 0) {
            return null;
        }
        AsynchronousValidator asynchronousValidator = new AsynchronousValidator(createSchedulingStrategy(cacheConfig2));
        addCloseable(asynchronousValidator);
        return asynchronousValidator;
    }

    private SchedulingStrategy createSchedulingStrategy(CacheConfig cacheConfig2) {
        SchedulingStrategy schedulingStrategy2 = this.schedulingStrategy;
        return schedulingStrategy2 != null ? schedulingStrategy2 : new ImmediateSchedulingStrategy(cacheConfig2);
    }
}
