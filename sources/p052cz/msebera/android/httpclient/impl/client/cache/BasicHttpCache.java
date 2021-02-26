package p052cz.msebera.android.httpclient.impl.client.cache;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import p052cz.msebera.android.httpclient.Header;
import p052cz.msebera.android.httpclient.HttpHost;
import p052cz.msebera.android.httpclient.HttpRequest;
import p052cz.msebera.android.httpclient.HttpResponse;
import p052cz.msebera.android.httpclient.HttpStatus;
import p052cz.msebera.android.httpclient.HttpVersion;
import p052cz.msebera.android.httpclient.ProtocolVersion;
import p052cz.msebera.android.httpclient.client.cache.HttpCacheEntry;
import p052cz.msebera.android.httpclient.client.cache.HttpCacheInvalidator;
import p052cz.msebera.android.httpclient.client.cache.HttpCacheStorage;
import p052cz.msebera.android.httpclient.client.cache.HttpCacheUpdateCallback;
import p052cz.msebera.android.httpclient.client.cache.HttpCacheUpdateException;
import p052cz.msebera.android.httpclient.client.cache.Resource;
import p052cz.msebera.android.httpclient.client.cache.ResourceFactory;
import p052cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import p052cz.msebera.android.httpclient.entity.ByteArrayEntity;
import p052cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import p052cz.msebera.android.httpclient.message.BasicHttpResponse;

/* renamed from: cz.msebera.android.httpclient.impl.client.cache.BasicHttpCache */
class BasicHttpCache implements HttpCache {
    private static final Set<String> safeRequestMethods = new HashSet(Arrays.asList(new String[]{"HEAD", "GET", "OPTIONS", "TRACE"}));
    private final CacheEntryUpdater cacheEntryUpdater;
    private final HttpCacheInvalidator cacheInvalidator;
    public HttpClientAndroidLog log;
    private final long maxObjectSizeBytes;
    private final ResourceFactory resourceFactory;
    private final CachedHttpResponseGenerator responseGenerator;
    private final HttpCacheStorage storage;
    /* access modifiers changed from: private */
    public final CacheKeyGenerator uriExtractor;

    public BasicHttpCache(ResourceFactory resourceFactory2, HttpCacheStorage httpCacheStorage, CacheConfig cacheConfig, CacheKeyGenerator cacheKeyGenerator, HttpCacheInvalidator httpCacheInvalidator) {
        this.log = new HttpClientAndroidLog(getClass());
        this.resourceFactory = resourceFactory2;
        this.uriExtractor = cacheKeyGenerator;
        this.cacheEntryUpdater = new CacheEntryUpdater(resourceFactory2);
        this.maxObjectSizeBytes = cacheConfig.getMaxObjectSize();
        this.responseGenerator = new CachedHttpResponseGenerator();
        this.storage = httpCacheStorage;
        this.cacheInvalidator = httpCacheInvalidator;
    }

    public BasicHttpCache(ResourceFactory resourceFactory2, HttpCacheStorage httpCacheStorage, CacheConfig cacheConfig, CacheKeyGenerator cacheKeyGenerator) {
        this(resourceFactory2, httpCacheStorage, cacheConfig, cacheKeyGenerator, new CacheInvalidator(cacheKeyGenerator, httpCacheStorage));
    }

    public BasicHttpCache(ResourceFactory resourceFactory2, HttpCacheStorage httpCacheStorage, CacheConfig cacheConfig) {
        this(resourceFactory2, httpCacheStorage, cacheConfig, new CacheKeyGenerator());
    }

    public BasicHttpCache(CacheConfig cacheConfig) {
        this(new HeapResourceFactory(), new BasicHttpCacheStorage(cacheConfig), cacheConfig);
    }

    public BasicHttpCache() {
        this(CacheConfig.DEFAULT);
    }

    public void flushCacheEntriesFor(HttpHost httpHost, HttpRequest httpRequest) throws IOException {
        if (!safeRequestMethods.contains(httpRequest.getRequestLine().getMethod())) {
            this.storage.removeEntry(this.uriExtractor.getURI(httpHost, httpRequest));
        }
    }

    public void flushInvalidatedCacheEntriesFor(HttpHost httpHost, HttpRequest httpRequest, HttpResponse httpResponse) {
        if (!safeRequestMethods.contains(httpRequest.getRequestLine().getMethod())) {
            this.cacheInvalidator.flushInvalidatedCacheEntries(httpHost, httpRequest, httpResponse);
        }
    }

    /* access modifiers changed from: package-private */
    public void storeInCache(HttpHost httpHost, HttpRequest httpRequest, HttpCacheEntry httpCacheEntry) throws IOException {
        if (httpCacheEntry.hasVariants()) {
            storeVariantEntry(httpHost, httpRequest, httpCacheEntry);
        } else {
            storeNonVariantEntry(httpHost, httpRequest, httpCacheEntry);
        }
    }

    /* access modifiers changed from: package-private */
    public void storeNonVariantEntry(HttpHost httpHost, HttpRequest httpRequest, HttpCacheEntry httpCacheEntry) throws IOException {
        this.storage.putEntry(this.uriExtractor.getURI(httpHost, httpRequest), httpCacheEntry);
    }

    /* access modifiers changed from: package-private */
    public void storeVariantEntry(HttpHost httpHost, final HttpRequest httpRequest, final HttpCacheEntry httpCacheEntry) throws IOException {
        String uri = this.uriExtractor.getURI(httpHost, httpRequest);
        final String variantURI = this.uriExtractor.getVariantURI(httpHost, httpRequest, httpCacheEntry);
        this.storage.putEntry(variantURI, httpCacheEntry);
        try {
            this.storage.updateEntry(uri, new HttpCacheUpdateCallback() {
                public HttpCacheEntry update(HttpCacheEntry httpCacheEntry) throws IOException {
                    return BasicHttpCache.this.doGetUpdatedParentEntry(httpRequest.getRequestLine().getUri(), httpCacheEntry, httpCacheEntry, BasicHttpCache.this.uriExtractor.getVariantKey(httpRequest, httpCacheEntry), variantURI);
                }
            });
        } catch (HttpCacheUpdateException e) {
            HttpClientAndroidLog httpClientAndroidLog = this.log;
            httpClientAndroidLog.warn("Could not update key [" + uri + "]", e);
        }
    }

    public void reuseVariantEntryFor(HttpHost httpHost, HttpRequest httpRequest, Variant variant) throws IOException {
        String uri = this.uriExtractor.getURI(httpHost, httpRequest);
        final HttpCacheEntry entry = variant.getEntry();
        final String variantKey = this.uriExtractor.getVariantKey(httpRequest, entry);
        final String cacheKey = variant.getCacheKey();
        final HttpRequest httpRequest2 = httpRequest;
        try {
            this.storage.updateEntry(uri, new HttpCacheUpdateCallback() {
                public HttpCacheEntry update(HttpCacheEntry httpCacheEntry) throws IOException {
                    return BasicHttpCache.this.doGetUpdatedParentEntry(httpRequest2.getRequestLine().getUri(), httpCacheEntry, entry, variantKey, cacheKey);
                }
            });
        } catch (HttpCacheUpdateException e) {
            HttpClientAndroidLog httpClientAndroidLog = this.log;
            httpClientAndroidLog.warn("Could not update key [" + uri + "]", e);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isIncompleteResponse(HttpResponse httpResponse, Resource resource) {
        Header firstHeader;
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        if ((statusCode != 200 && statusCode != 206) || (firstHeader = httpResponse.getFirstHeader("Content-Length")) == null) {
            return false;
        }
        try {
            if (resource.length() < ((long) Integer.parseInt(firstHeader.getValue()))) {
                return true;
            }
            return false;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public CloseableHttpResponse generateIncompleteResponseError(HttpResponse httpResponse, Resource resource) {
        int parseInt = Integer.parseInt(httpResponse.getFirstHeader("Content-Length").getValue());
        BasicHttpResponse basicHttpResponse = new BasicHttpResponse((ProtocolVersion) HttpVersion.HTTP_1_1, (int) HttpStatus.SC_BAD_GATEWAY, "Bad Gateway");
        basicHttpResponse.setHeader("Content-Type", "text/plain;charset=UTF-8");
        byte[] bytes = String.format("Received incomplete response with Content-Length %d but actual body length %d", new Object[]{Integer.valueOf(parseInt), Long.valueOf(resource.length())}).getBytes();
        basicHttpResponse.setHeader("Content-Length", Integer.toString(bytes.length));
        basicHttpResponse.setEntity(new ByteArrayEntity(bytes));
        return Proxies.enhanceResponse(basicHttpResponse);
    }

    /* access modifiers changed from: package-private */
    public HttpCacheEntry doGetUpdatedParentEntry(String str, HttpCacheEntry httpCacheEntry, HttpCacheEntry httpCacheEntry2, String str2, String str3) throws IOException {
        if (httpCacheEntry == null) {
            httpCacheEntry = httpCacheEntry2;
        }
        Resource resource = null;
        if (httpCacheEntry.getResource() != null) {
            resource = this.resourceFactory.copy(str, httpCacheEntry.getResource());
        }
        HashMap hashMap = new HashMap(httpCacheEntry.getVariantMap());
        hashMap.put(str2, str3);
        return new HttpCacheEntry(httpCacheEntry.getRequestDate(), httpCacheEntry.getResponseDate(), httpCacheEntry.getStatusLine(), httpCacheEntry.getAllHeaders(), resource, hashMap);
    }

    public HttpCacheEntry updateCacheEntry(HttpHost httpHost, HttpRequest httpRequest, HttpCacheEntry httpCacheEntry, HttpResponse httpResponse, Date date, Date date2) throws IOException {
        HttpCacheEntry updateCacheEntry = this.cacheEntryUpdater.updateCacheEntry(httpRequest.getRequestLine().getUri(), httpCacheEntry, date, date2, httpResponse);
        storeInCache(httpHost, httpRequest, updateCacheEntry);
        return updateCacheEntry;
    }

    public HttpCacheEntry updateVariantCacheEntry(HttpHost httpHost, HttpRequest httpRequest, HttpCacheEntry httpCacheEntry, HttpResponse httpResponse, Date date, Date date2, String str) throws IOException {
        HttpCacheEntry updateCacheEntry = this.cacheEntryUpdater.updateCacheEntry(httpRequest.getRequestLine().getUri(), httpCacheEntry, date, date2, httpResponse);
        this.storage.putEntry(str, updateCacheEntry);
        return updateCacheEntry;
    }

    public HttpResponse cacheAndReturnResponse(HttpHost httpHost, HttpRequest httpRequest, HttpResponse httpResponse, Date date, Date date2) throws IOException {
        return cacheAndReturnResponse(httpHost, httpRequest, Proxies.enhanceResponse(httpResponse), date, date2);
    }

    public CloseableHttpResponse cacheAndReturnResponse(HttpHost httpHost, HttpRequest httpRequest, CloseableHttpResponse closeableHttpResponse, Date date, Date date2) throws IOException {
        SizeLimitedResponseReader responseReader = getResponseReader(httpRequest, closeableHttpResponse);
        try {
            responseReader.readResponse();
            if (responseReader.isLimitReached()) {
                return responseReader.getReconstructedResponse();
            }
            Resource resource = responseReader.getResource();
            if (isIncompleteResponse(closeableHttpResponse, resource)) {
                CloseableHttpResponse generateIncompleteResponseError = generateIncompleteResponseError(closeableHttpResponse, resource);
                closeableHttpResponse.close();
                return generateIncompleteResponseError;
            }
            HttpCacheEntry httpCacheEntry = new HttpCacheEntry(date, date2, closeableHttpResponse.getStatusLine(), closeableHttpResponse.getAllHeaders(), resource);
            storeInCache(httpHost, httpRequest, httpCacheEntry);
            CloseableHttpResponse generateResponse = this.responseGenerator.generateResponse(httpCacheEntry);
            closeableHttpResponse.close();
            return generateResponse;
        } catch (Throwable th) {
            if (1 != 0) {
                closeableHttpResponse.close();
            }
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public SizeLimitedResponseReader getResponseReader(HttpRequest httpRequest, CloseableHttpResponse closeableHttpResponse) {
        return new SizeLimitedResponseReader(this.resourceFactory, this.maxObjectSizeBytes, httpRequest, closeableHttpResponse);
    }

    public HttpCacheEntry getCacheEntry(HttpHost httpHost, HttpRequest httpRequest) throws IOException {
        HttpCacheEntry entry = this.storage.getEntry(this.uriExtractor.getURI(httpHost, httpRequest));
        if (entry == null) {
            return null;
        }
        if (!entry.hasVariants()) {
            return entry;
        }
        String str = entry.getVariantMap().get(this.uriExtractor.getVariantKey(httpRequest, entry));
        if (str == null) {
            return null;
        }
        return this.storage.getEntry(str);
    }

    public void flushInvalidatedCacheEntriesFor(HttpHost httpHost, HttpRequest httpRequest) throws IOException {
        this.cacheInvalidator.flushInvalidatedCacheEntries(httpHost, httpRequest);
    }

    public Map<String, Variant> getVariantCacheEntriesWithEtags(HttpHost httpHost, HttpRequest httpRequest) throws IOException {
        HashMap hashMap = new HashMap();
        HttpCacheEntry entry = this.storage.getEntry(this.uriExtractor.getURI(httpHost, httpRequest));
        if (entry != null && entry.hasVariants()) {
            for (Map.Entry next : entry.getVariantMap().entrySet()) {
                addVariantWithEtag((String) next.getKey(), (String) next.getValue(), hashMap);
            }
        }
        return hashMap;
    }

    private void addVariantWithEtag(String str, String str2, Map<String, Variant> map) throws IOException {
        Header firstHeader;
        HttpCacheEntry entry = this.storage.getEntry(str2);
        if (entry != null && (firstHeader = entry.getFirstHeader("ETag")) != null) {
            map.put(firstHeader.getValue(), new Variant(str, str2, entry));
        }
    }
}
