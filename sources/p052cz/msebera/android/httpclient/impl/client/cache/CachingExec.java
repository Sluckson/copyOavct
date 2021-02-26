package p052cz.msebera.android.httpclient.impl.client.cache;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import p052cz.msebera.android.httpclient.Header;
import p052cz.msebera.android.httpclient.HeaderElement;
import p052cz.msebera.android.httpclient.HttpException;
import p052cz.msebera.android.httpclient.HttpHost;
import p052cz.msebera.android.httpclient.HttpMessage;
import p052cz.msebera.android.httpclient.HttpRequest;
import p052cz.msebera.android.httpclient.HttpResponse;
import p052cz.msebera.android.httpclient.HttpStatus;
import p052cz.msebera.android.httpclient.HttpVersion;
import p052cz.msebera.android.httpclient.ProtocolException;
import p052cz.msebera.android.httpclient.ProtocolVersion;
import p052cz.msebera.android.httpclient.RequestLine;
import p052cz.msebera.android.httpclient.annotation.ThreadSafe;
import p052cz.msebera.android.httpclient.client.cache.CacheResponseStatus;
import p052cz.msebera.android.httpclient.client.cache.HeaderConstants;
import p052cz.msebera.android.httpclient.client.cache.HttpCacheContext;
import p052cz.msebera.android.httpclient.client.cache.HttpCacheEntry;
import p052cz.msebera.android.httpclient.client.cache.HttpCacheStorage;
import p052cz.msebera.android.httpclient.client.cache.ResourceFactory;
import p052cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import p052cz.msebera.android.httpclient.client.methods.HttpExecutionAware;
import p052cz.msebera.android.httpclient.client.methods.HttpRequestWrapper;
import p052cz.msebera.android.httpclient.client.protocol.HttpClientContext;
import p052cz.msebera.android.httpclient.client.utils.DateUtils;
import p052cz.msebera.android.httpclient.conn.routing.HttpRoute;
import p052cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import p052cz.msebera.android.httpclient.impl.execchain.ClientExecChain;
import p052cz.msebera.android.httpclient.message.BasicHttpResponse;
import p052cz.msebera.android.httpclient.protocol.HttpContext;
import p052cz.msebera.android.httpclient.util.Args;
import p052cz.msebera.android.httpclient.util.VersionInfo;

@ThreadSafe
/* renamed from: cz.msebera.android.httpclient.impl.client.cache.CachingExec */
public class CachingExec implements ClientExecChain {
    private static final boolean SUPPORTS_RANGE_AND_CONTENT_RANGE_HEADERS = false;
    private final AsynchronousValidator asynchRevalidator;
    private final ClientExecChain backend;
    private final CacheConfig cacheConfig;
    private final AtomicLong cacheHits;
    private final AtomicLong cacheMisses;
    private final AtomicLong cacheUpdates;
    private final CacheableRequestPolicy cacheableRequestPolicy;
    private final ConditionalRequestBuilder conditionalRequestBuilder;
    public HttpClientAndroidLog log;
    private final RequestProtocolCompliance requestCompliance;
    private final HttpCache responseCache;
    private final ResponseCachingPolicy responseCachingPolicy;
    private final ResponseProtocolCompliance responseCompliance;
    private final CachedHttpResponseGenerator responseGenerator;
    private final CachedResponseSuitabilityChecker suitabilityChecker;
    private final CacheValidityPolicy validityPolicy;
    private final Map<ProtocolVersion, String> viaHeaders;

    private boolean staleIfErrorAppliesTo(int i) {
        return i == 500 || i == 502 || i == 503 || i == 504;
    }

    public boolean supportsRangeAndContentRangeHeaders() {
        return false;
    }

    public CachingExec(ClientExecChain clientExecChain, HttpCache httpCache, CacheConfig cacheConfig2) {
        this(clientExecChain, httpCache, cacheConfig2, (AsynchronousValidator) null);
    }

    public CachingExec(ClientExecChain clientExecChain, HttpCache httpCache, CacheConfig cacheConfig2, AsynchronousValidator asynchronousValidator) {
        this.cacheHits = new AtomicLong();
        this.cacheMisses = new AtomicLong();
        this.cacheUpdates = new AtomicLong();
        this.viaHeaders = new HashMap(4);
        this.log = new HttpClientAndroidLog(getClass());
        Args.notNull(clientExecChain, "HTTP backend");
        Args.notNull(httpCache, "HttpCache");
        this.cacheConfig = cacheConfig2 == null ? CacheConfig.DEFAULT : cacheConfig2;
        this.backend = clientExecChain;
        this.responseCache = httpCache;
        this.validityPolicy = new CacheValidityPolicy();
        this.responseGenerator = new CachedHttpResponseGenerator(this.validityPolicy);
        this.cacheableRequestPolicy = new CacheableRequestPolicy();
        this.suitabilityChecker = new CachedResponseSuitabilityChecker(this.validityPolicy, this.cacheConfig);
        this.conditionalRequestBuilder = new ConditionalRequestBuilder();
        this.responseCompliance = new ResponseProtocolCompliance();
        this.requestCompliance = new RequestProtocolCompliance(this.cacheConfig.isWeakETagOnPutDeleteAllowed());
        this.responseCachingPolicy = new ResponseCachingPolicy(this.cacheConfig.getMaxObjectSize(), this.cacheConfig.isSharedCache(), this.cacheConfig.isNeverCacheHTTP10ResponsesWithQuery(), this.cacheConfig.is303CachingEnabled());
        this.asynchRevalidator = asynchronousValidator;
    }

    public CachingExec(ClientExecChain clientExecChain, ResourceFactory resourceFactory, HttpCacheStorage httpCacheStorage, CacheConfig cacheConfig2) {
        this(clientExecChain, new BasicHttpCache(resourceFactory, httpCacheStorage, cacheConfig2), cacheConfig2);
    }

    public CachingExec(ClientExecChain clientExecChain) {
        this(clientExecChain, new BasicHttpCache(), CacheConfig.DEFAULT);
    }

    CachingExec(ClientExecChain clientExecChain, HttpCache httpCache, CacheValidityPolicy cacheValidityPolicy, ResponseCachingPolicy responseCachingPolicy2, CachedHttpResponseGenerator cachedHttpResponseGenerator, CacheableRequestPolicy cacheableRequestPolicy2, CachedResponseSuitabilityChecker cachedResponseSuitabilityChecker, ConditionalRequestBuilder conditionalRequestBuilder2, ResponseProtocolCompliance responseProtocolCompliance, RequestProtocolCompliance requestProtocolCompliance, CacheConfig cacheConfig2, AsynchronousValidator asynchronousValidator) {
        this.cacheHits = new AtomicLong();
        this.cacheMisses = new AtomicLong();
        this.cacheUpdates = new AtomicLong();
        this.viaHeaders = new HashMap(4);
        this.log = new HttpClientAndroidLog(getClass());
        this.cacheConfig = cacheConfig2 == null ? CacheConfig.DEFAULT : cacheConfig2;
        this.backend = clientExecChain;
        this.responseCache = httpCache;
        this.validityPolicy = cacheValidityPolicy;
        this.responseCachingPolicy = responseCachingPolicy2;
        this.responseGenerator = cachedHttpResponseGenerator;
        this.cacheableRequestPolicy = cacheableRequestPolicy2;
        this.suitabilityChecker = cachedResponseSuitabilityChecker;
        this.conditionalRequestBuilder = conditionalRequestBuilder2;
        this.responseCompliance = responseProtocolCompliance;
        this.requestCompliance = requestProtocolCompliance;
        this.asynchRevalidator = asynchronousValidator;
    }

    public long getCacheHits() {
        return this.cacheHits.get();
    }

    public long getCacheMisses() {
        return this.cacheMisses.get();
    }

    public long getCacheUpdates() {
        return this.cacheUpdates.get();
    }

    public CloseableHttpResponse execute(HttpRoute httpRoute, HttpRequestWrapper httpRequestWrapper) throws IOException, HttpException {
        return execute(httpRoute, httpRequestWrapper, HttpClientContext.create(), (HttpExecutionAware) null);
    }

    public CloseableHttpResponse execute(HttpRoute httpRoute, HttpRequestWrapper httpRequestWrapper, HttpClientContext httpClientContext) throws IOException, HttpException {
        return execute(httpRoute, httpRequestWrapper, httpClientContext, (HttpExecutionAware) null);
    }

    public CloseableHttpResponse execute(HttpRoute httpRoute, HttpRequestWrapper httpRequestWrapper, HttpClientContext httpClientContext, HttpExecutionAware httpExecutionAware) throws IOException, HttpException {
        HttpHost targetHost = httpClientContext.getTargetHost();
        String generateViaHeader = generateViaHeader(httpRequestWrapper.getOriginal());
        setResponseStatus(httpClientContext, CacheResponseStatus.CACHE_MISS);
        if (clientRequestsOurOptions(httpRequestWrapper)) {
            setResponseStatus(httpClientContext, CacheResponseStatus.CACHE_MODULE_RESPONSE);
            return Proxies.enhanceResponse(new OptionsHttp11Response());
        }
        HttpResponse fatallyNoncompliantResponse = getFatallyNoncompliantResponse(httpRequestWrapper, httpClientContext);
        if (fatallyNoncompliantResponse != null) {
            return Proxies.enhanceResponse(fatallyNoncompliantResponse);
        }
        this.requestCompliance.makeRequestCompliant(httpRequestWrapper);
        httpRequestWrapper.addHeader("Via", generateViaHeader);
        flushEntriesInvalidatedByRequest(httpClientContext.getTargetHost(), httpRequestWrapper);
        if (!this.cacheableRequestPolicy.isServableFromCache(httpRequestWrapper)) {
            this.log.debug("Request is not servable from cache");
            return callBackend(httpRoute, httpRequestWrapper, httpClientContext, httpExecutionAware);
        }
        HttpCacheEntry satisfyFromCache = satisfyFromCache(targetHost, httpRequestWrapper);
        if (satisfyFromCache != null) {
            return handleCacheHit(httpRoute, httpRequestWrapper, httpClientContext, httpExecutionAware, satisfyFromCache);
        }
        this.log.debug("Cache miss");
        return handleCacheMiss(httpRoute, httpRequestWrapper, httpClientContext, httpExecutionAware);
    }

    private CloseableHttpResponse handleCacheHit(HttpRoute httpRoute, HttpRequestWrapper httpRequestWrapper, HttpClientContext httpClientContext, HttpExecutionAware httpExecutionAware, HttpCacheEntry httpCacheEntry) throws IOException, HttpException {
        CloseableHttpResponse closeableHttpResponse;
        HttpHost targetHost = httpClientContext.getTargetHost();
        recordCacheHit(targetHost, httpRequestWrapper);
        Date currentDate = getCurrentDate();
        if (this.suitabilityChecker.canCachedResponseBeUsed(targetHost, httpRequestWrapper, httpCacheEntry, currentDate)) {
            this.log.debug("Cache hit");
            closeableHttpResponse = generateCachedResponse(httpRequestWrapper, httpClientContext, httpCacheEntry, currentDate);
        } else if (!mayCallBackend(httpRequestWrapper)) {
            this.log.debug("Cache entry not suitable but only-if-cached requested");
            closeableHttpResponse = generateGatewayTimeout(httpClientContext);
        } else if (httpCacheEntry.getStatusCode() != 304 || this.suitabilityChecker.isConditional(httpRequestWrapper)) {
            this.log.debug("Revalidating cache entry");
            return revalidateCacheEntry(httpRoute, httpRequestWrapper, httpClientContext, httpExecutionAware, httpCacheEntry, currentDate);
        } else {
            this.log.debug("Cache entry not usable; calling backend");
            return callBackend(httpRoute, httpRequestWrapper, httpClientContext, httpExecutionAware);
        }
        httpClientContext.setAttribute("http.route", httpRoute);
        httpClientContext.setAttribute("http.target_host", targetHost);
        httpClientContext.setAttribute("http.request", httpRequestWrapper);
        httpClientContext.setAttribute("http.response", closeableHttpResponse);
        httpClientContext.setAttribute("http.request_sent", Boolean.TRUE);
        return closeableHttpResponse;
    }

    private CloseableHttpResponse revalidateCacheEntry(HttpRoute httpRoute, HttpRequestWrapper httpRequestWrapper, HttpClientContext httpClientContext, HttpExecutionAware httpExecutionAware, HttpCacheEntry httpCacheEntry, Date date) throws HttpException {
        try {
            if (this.asynchRevalidator == null || staleResponseNotAllowed(httpRequestWrapper, httpCacheEntry, date) || !this.validityPolicy.mayReturnStaleWhileRevalidating(httpCacheEntry, date)) {
                return revalidateCacheEntry(httpRoute, httpRequestWrapper, httpClientContext, httpExecutionAware, httpCacheEntry);
            }
            this.log.trace("Serving stale with asynchronous revalidation");
            CloseableHttpResponse generateCachedResponse = generateCachedResponse(httpRequestWrapper, httpClientContext, httpCacheEntry, date);
            this.asynchRevalidator.revalidateCacheEntry(this, httpRoute, httpRequestWrapper, httpClientContext, httpExecutionAware, httpCacheEntry);
            return generateCachedResponse;
        } catch (IOException unused) {
            return handleRevalidationFailure(httpRequestWrapper, httpClientContext, httpCacheEntry, date);
        }
    }

    private CloseableHttpResponse handleCacheMiss(HttpRoute httpRoute, HttpRequestWrapper httpRequestWrapper, HttpClientContext httpClientContext, HttpExecutionAware httpExecutionAware) throws IOException, HttpException {
        HttpHost targetHost = httpClientContext.getTargetHost();
        recordCacheMiss(targetHost, httpRequestWrapper);
        if (!mayCallBackend(httpRequestWrapper)) {
            return Proxies.enhanceResponse(new BasicHttpResponse((ProtocolVersion) HttpVersion.HTTP_1_1, (int) HttpStatus.SC_GATEWAY_TIMEOUT, "Gateway Timeout"));
        }
        Map<String, Variant> existingCacheVariants = getExistingCacheVariants(targetHost, httpRequestWrapper);
        if (existingCacheVariants == null || existingCacheVariants.size() <= 0) {
            return callBackend(httpRoute, httpRequestWrapper, httpClientContext, httpExecutionAware);
        }
        return negotiateResponseFromVariants(httpRoute, httpRequestWrapper, httpClientContext, httpExecutionAware, existingCacheVariants);
    }

    private HttpCacheEntry satisfyFromCache(HttpHost httpHost, HttpRequestWrapper httpRequestWrapper) {
        try {
            return this.responseCache.getCacheEntry(httpHost, httpRequestWrapper);
        } catch (IOException e) {
            this.log.warn("Unable to retrieve entries from cache", e);
            return null;
        }
    }

    private HttpResponse getFatallyNoncompliantResponse(HttpRequestWrapper httpRequestWrapper, HttpContext httpContext) {
        HttpResponse httpResponse = null;
        for (RequestProtocolError errorForRequest : this.requestCompliance.requestIsFatallyNonCompliant(httpRequestWrapper)) {
            setResponseStatus(httpContext, CacheResponseStatus.CACHE_MODULE_RESPONSE);
            httpResponse = this.requestCompliance.getErrorForRequest(errorForRequest);
        }
        return httpResponse;
    }

    private Map<String, Variant> getExistingCacheVariants(HttpHost httpHost, HttpRequestWrapper httpRequestWrapper) {
        try {
            return this.responseCache.getVariantCacheEntriesWithEtags(httpHost, httpRequestWrapper);
        } catch (IOException e) {
            this.log.warn("Unable to retrieve variant entries from cache", e);
            return null;
        }
    }

    private void recordCacheMiss(HttpHost httpHost, HttpRequestWrapper httpRequestWrapper) {
        this.cacheMisses.getAndIncrement();
        if (this.log.isTraceEnabled()) {
            RequestLine requestLine = httpRequestWrapper.getRequestLine();
            HttpClientAndroidLog httpClientAndroidLog = this.log;
            httpClientAndroidLog.trace("Cache miss [host: " + httpHost + "; uri: " + requestLine.getUri() + "]");
        }
    }

    private void recordCacheHit(HttpHost httpHost, HttpRequestWrapper httpRequestWrapper) {
        this.cacheHits.getAndIncrement();
        if (this.log.isTraceEnabled()) {
            RequestLine requestLine = httpRequestWrapper.getRequestLine();
            HttpClientAndroidLog httpClientAndroidLog = this.log;
            httpClientAndroidLog.trace("Cache hit [host: " + httpHost + "; uri: " + requestLine.getUri() + "]");
        }
    }

    private void recordCacheUpdate(HttpContext httpContext) {
        this.cacheUpdates.getAndIncrement();
        setResponseStatus(httpContext, CacheResponseStatus.VALIDATED);
    }

    private void flushEntriesInvalidatedByRequest(HttpHost httpHost, HttpRequestWrapper httpRequestWrapper) {
        try {
            this.responseCache.flushInvalidatedCacheEntriesFor(httpHost, httpRequestWrapper);
        } catch (IOException e) {
            this.log.warn("Unable to flush invalidated entries from cache", e);
        }
    }

    private CloseableHttpResponse generateCachedResponse(HttpRequestWrapper httpRequestWrapper, HttpContext httpContext, HttpCacheEntry httpCacheEntry, Date date) {
        CloseableHttpResponse closeableHttpResponse;
        if (httpRequestWrapper.containsHeader("If-None-Match") || httpRequestWrapper.containsHeader("If-Modified-Since")) {
            closeableHttpResponse = this.responseGenerator.generateNotModifiedResponse(httpCacheEntry);
        } else {
            closeableHttpResponse = this.responseGenerator.generateResponse(httpCacheEntry);
        }
        setResponseStatus(httpContext, CacheResponseStatus.CACHE_HIT);
        if (this.validityPolicy.getStalenessSecs(httpCacheEntry, date) > 0) {
            closeableHttpResponse.addHeader("Warning", "110 localhost \"Response is stale\"");
        }
        return closeableHttpResponse;
    }

    private CloseableHttpResponse handleRevalidationFailure(HttpRequestWrapper httpRequestWrapper, HttpContext httpContext, HttpCacheEntry httpCacheEntry, Date date) {
        if (staleResponseNotAllowed(httpRequestWrapper, httpCacheEntry, date)) {
            return generateGatewayTimeout(httpContext);
        }
        return unvalidatedCacheHit(httpContext, httpCacheEntry);
    }

    private CloseableHttpResponse generateGatewayTimeout(HttpContext httpContext) {
        setResponseStatus(httpContext, CacheResponseStatus.CACHE_MODULE_RESPONSE);
        return Proxies.enhanceResponse(new BasicHttpResponse((ProtocolVersion) HttpVersion.HTTP_1_1, (int) HttpStatus.SC_GATEWAY_TIMEOUT, "Gateway Timeout"));
    }

    private CloseableHttpResponse unvalidatedCacheHit(HttpContext httpContext, HttpCacheEntry httpCacheEntry) {
        CloseableHttpResponse generateResponse = this.responseGenerator.generateResponse(httpCacheEntry);
        setResponseStatus(httpContext, CacheResponseStatus.CACHE_HIT);
        generateResponse.addHeader("Warning", "111 localhost \"Revalidation failed\"");
        return generateResponse;
    }

    private boolean staleResponseNotAllowed(HttpRequestWrapper httpRequestWrapper, HttpCacheEntry httpCacheEntry, Date date) {
        return this.validityPolicy.mustRevalidate(httpCacheEntry) || (this.cacheConfig.isSharedCache() && this.validityPolicy.proxyRevalidate(httpCacheEntry)) || explicitFreshnessRequest(httpRequestWrapper, httpCacheEntry, date);
    }

    private boolean mayCallBackend(HttpRequestWrapper httpRequestWrapper) {
        for (Header elements : httpRequestWrapper.getHeaders("Cache-Control")) {
            for (HeaderElement name : elements.getElements()) {
                if ("only-if-cached".equals(name.getName())) {
                    this.log.trace("Request marked only-if-cached");
                    return false;
                }
            }
        }
        return true;
    }

    private boolean explicitFreshnessRequest(HttpRequestWrapper httpRequestWrapper, HttpCacheEntry httpCacheEntry, Date date) {
        HttpCacheEntry httpCacheEntry2 = httpCacheEntry;
        for (Header elements : httpRequestWrapper.getHeaders("Cache-Control")) {
            for (HeaderElement headerElement : elements.getElements()) {
                if (HeaderConstants.CACHE_CONTROL_MAX_STALE.equals(headerElement.getName())) {
                    try {
                        if (this.validityPolicy.getCurrentAgeSecs(httpCacheEntry2, date) - this.validityPolicy.getFreshnessLifetimeSecs(httpCacheEntry2) > ((long) Integer.parseInt(headerElement.getValue()))) {
                            return true;
                        }
                    } catch (NumberFormatException unused) {
                    }
                } else {
                    Date date2 = date;
                    if (HeaderConstants.CACHE_CONTROL_MIN_FRESH.equals(headerElement.getName()) || "max-age".equals(headerElement.getName())) {
                        return true;
                    }
                }
            }
            Date date3 = date;
        }
        return false;
    }

    private String generateViaHeader(HttpMessage httpMessage) {
        String str;
        ProtocolVersion protocolVersion = httpMessage.getProtocolVersion();
        String str2 = this.viaHeaders.get(protocolVersion);
        if (str2 != null) {
            return str2;
        }
        VersionInfo loadVersionInfo = VersionInfo.loadVersionInfo("cz.msebera.android.httpclient.client", getClass().getClassLoader());
        String release = loadVersionInfo != null ? loadVersionInfo.getRelease() : VersionInfo.UNAVAILABLE;
        if (HttpHost.DEFAULT_SCHEME_NAME.equalsIgnoreCase(protocolVersion.getProtocol())) {
            str = String.format("%d.%d localhost (Apache-HttpClient/%s (cache))", new Object[]{Integer.valueOf(protocolVersion.getMajor()), Integer.valueOf(protocolVersion.getMinor()), release});
        } else {
            str = String.format("%s/%d.%d localhost (Apache-HttpClient/%s (cache))", new Object[]{protocolVersion.getProtocol(), Integer.valueOf(protocolVersion.getMajor()), Integer.valueOf(protocolVersion.getMinor()), release});
        }
        this.viaHeaders.put(protocolVersion, str);
        return str;
    }

    private void setResponseStatus(HttpContext httpContext, CacheResponseStatus cacheResponseStatus) {
        if (httpContext != null) {
            httpContext.setAttribute(HttpCacheContext.CACHE_RESPONSE_STATUS, cacheResponseStatus);
        }
    }

    /* access modifiers changed from: package-private */
    public Date getCurrentDate() {
        return new Date();
    }

    /* access modifiers changed from: package-private */
    public boolean clientRequestsOurOptions(HttpRequest httpRequest) {
        RequestLine requestLine = httpRequest.getRequestLine();
        if ("OPTIONS".equals(requestLine.getMethod()) && "*".equals(requestLine.getUri()) && "0".equals(httpRequest.getFirstHeader("Max-Forwards").getValue())) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public CloseableHttpResponse callBackend(HttpRoute httpRoute, HttpRequestWrapper httpRequestWrapper, HttpClientContext httpClientContext, HttpExecutionAware httpExecutionAware) throws IOException, HttpException {
        Date currentDate = getCurrentDate();
        this.log.trace("Calling the backend");
        CloseableHttpResponse execute = this.backend.execute(httpRoute, httpRequestWrapper, httpClientContext, httpExecutionAware);
        try {
            execute.addHeader("Via", generateViaHeader(execute));
            return handleBackendResponse(httpRoute, httpRequestWrapper, httpClientContext, httpExecutionAware, currentDate, getCurrentDate(), execute);
        } catch (IOException e) {
            execute.close();
            throw e;
        } catch (RuntimeException e2) {
            execute.close();
            throw e2;
        }
    }

    private boolean revalidationResponseIsTooOld(HttpResponse httpResponse, HttpCacheEntry httpCacheEntry) {
        Header firstHeader = httpCacheEntry.getFirstHeader("Date");
        Header firstHeader2 = httpResponse.getFirstHeader("Date");
        if (!(firstHeader == null || firstHeader2 == null)) {
            Date parseDate = DateUtils.parseDate(firstHeader.getValue());
            Date parseDate2 = DateUtils.parseDate(firstHeader2.getValue());
            if (parseDate == null || parseDate2 == null || !parseDate2.before(parseDate)) {
                return false;
            }
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public CloseableHttpResponse negotiateResponseFromVariants(HttpRoute httpRoute, HttpRequestWrapper httpRequestWrapper, HttpClientContext httpClientContext, HttpExecutionAware httpExecutionAware, Map<String, Variant> map) throws IOException, HttpException {
        HttpRequestWrapper httpRequestWrapper2 = httpRequestWrapper;
        HttpClientContext httpClientContext2 = httpClientContext;
        Map<String, Variant> map2 = map;
        HttpRequestWrapper buildConditionalRequestFromVariants = this.conditionalRequestBuilder.buildConditionalRequestFromVariants(httpRequestWrapper, map2);
        Date currentDate = getCurrentDate();
        HttpRoute httpRoute2 = httpRoute;
        CloseableHttpResponse execute = this.backend.execute(httpRoute, buildConditionalRequestFromVariants, httpClientContext2, httpExecutionAware);
        try {
            Date currentDate2 = getCurrentDate();
            execute.addHeader("Via", generateViaHeader(execute));
            if (execute.getStatusLine().getStatusCode() != 304) {
                return handleBackendResponse(httpRoute, httpRequestWrapper, httpClientContext, httpExecutionAware, currentDate, currentDate2, execute);
            }
            Header firstHeader = execute.getFirstHeader("ETag");
            if (firstHeader == null) {
                this.log.warn("304 response did not contain ETag");
                IOUtils.consume(execute.getEntity());
                execute.close();
                return callBackend(httpRoute, httpRequestWrapper, httpClientContext, httpExecutionAware);
            }
            Variant variant = map2.get(firstHeader.getValue());
            if (variant == null) {
                this.log.debug("304 response did not contain ETag matching one sent in If-None-Match");
                IOUtils.consume(execute.getEntity());
                execute.close();
                return callBackend(httpRoute, httpRequestWrapper, httpClientContext, httpExecutionAware);
            }
            HttpCacheEntry entry = variant.getEntry();
            if (revalidationResponseIsTooOld(execute, entry)) {
                IOUtils.consume(execute.getEntity());
                execute.close();
                return retryRequestUnconditionally(httpRoute, httpRequestWrapper, httpClientContext, httpExecutionAware, entry);
            }
            recordCacheUpdate(httpClientContext2);
            HttpCacheEntry updatedVariantEntry = getUpdatedVariantEntry(httpClientContext.getTargetHost(), buildConditionalRequestFromVariants, currentDate, currentDate2, execute, variant, entry);
            execute.close();
            CloseableHttpResponse generateResponse = this.responseGenerator.generateResponse(updatedVariantEntry);
            tryToUpdateVariantMap(httpClientContext.getTargetHost(), httpRequestWrapper, variant);
            return shouldSendNotModifiedResponse(httpRequestWrapper, updatedVariantEntry) ? this.responseGenerator.generateNotModifiedResponse(updatedVariantEntry) : generateResponse;
        } catch (IOException e) {
            execute.close();
            throw e;
        } catch (RuntimeException e2) {
            execute.close();
            throw e2;
        }
    }

    private CloseableHttpResponse retryRequestUnconditionally(HttpRoute httpRoute, HttpRequestWrapper httpRequestWrapper, HttpClientContext httpClientContext, HttpExecutionAware httpExecutionAware, HttpCacheEntry httpCacheEntry) throws IOException, HttpException {
        return callBackend(httpRoute, this.conditionalRequestBuilder.buildUnconditionalRequest(httpRequestWrapper, httpCacheEntry), httpClientContext, httpExecutionAware);
    }

    private HttpCacheEntry getUpdatedVariantEntry(HttpHost httpHost, HttpRequestWrapper httpRequestWrapper, Date date, Date date2, CloseableHttpResponse closeableHttpResponse, Variant variant, HttpCacheEntry httpCacheEntry) throws IOException {
        try {
            httpCacheEntry = this.responseCache.updateVariantCacheEntry(httpHost, httpRequestWrapper, httpCacheEntry, closeableHttpResponse, date, date2, variant.getCacheKey());
        } catch (IOException e) {
            this.log.warn("Could not update cache entry", e);
        } catch (Throwable th) {
            closeableHttpResponse.close();
            throw th;
        }
        closeableHttpResponse.close();
        return httpCacheEntry;
    }

    private void tryToUpdateVariantMap(HttpHost httpHost, HttpRequestWrapper httpRequestWrapper, Variant variant) {
        try {
            this.responseCache.reuseVariantEntryFor(httpHost, httpRequestWrapper, variant);
        } catch (IOException e) {
            this.log.warn("Could not update cache entry to reuse variant", e);
        }
    }

    private boolean shouldSendNotModifiedResponse(HttpRequestWrapper httpRequestWrapper, HttpCacheEntry httpCacheEntry) {
        return this.suitabilityChecker.isConditional(httpRequestWrapper) && this.suitabilityChecker.allConditionalsMatch(httpRequestWrapper, httpCacheEntry, new Date());
    }

    /* access modifiers changed from: package-private */
    public CloseableHttpResponse revalidateCacheEntry(HttpRoute httpRoute, HttpRequestWrapper httpRequestWrapper, HttpClientContext httpClientContext, HttpExecutionAware httpExecutionAware, HttpCacheEntry httpCacheEntry) throws IOException, HttpException {
        Date date;
        Date date2;
        CloseableHttpResponse closeableHttpResponse;
        HttpRoute httpRoute2 = httpRoute;
        HttpRequestWrapper httpRequestWrapper2 = httpRequestWrapper;
        HttpClientContext httpClientContext2 = httpClientContext;
        HttpExecutionAware httpExecutionAware2 = httpExecutionAware;
        HttpCacheEntry httpCacheEntry2 = httpCacheEntry;
        HttpRequestWrapper buildConditionalRequest = this.conditionalRequestBuilder.buildConditionalRequest(httpRequestWrapper, httpCacheEntry2);
        URI uri = buildConditionalRequest.getURI();
        if (uri != null) {
            try {
                buildConditionalRequest.setURI(InternalURIUtils.rewriteURIForRoute(uri, httpRoute));
            } catch (URISyntaxException e) {
                throw new ProtocolException("Invalid URI: " + uri, e);
            }
        }
        Date currentDate = getCurrentDate();
        CloseableHttpResponse execute = this.backend.execute(httpRoute, buildConditionalRequest, httpClientContext2, httpExecutionAware2);
        Date currentDate2 = getCurrentDate();
        if (revalidationResponseIsTooOld(execute, httpCacheEntry2)) {
            execute.close();
            HttpRequestWrapper buildUnconditionalRequest = this.conditionalRequestBuilder.buildUnconditionalRequest(httpRequestWrapper, httpCacheEntry2);
            Date currentDate3 = getCurrentDate();
            CloseableHttpResponse execute2 = this.backend.execute(httpRoute, buildUnconditionalRequest, httpClientContext2, httpExecutionAware2);
            date2 = currentDate3;
            date = getCurrentDate();
            closeableHttpResponse = execute2;
        } else {
            date2 = currentDate;
            date = currentDate2;
            closeableHttpResponse = execute;
        }
        closeableHttpResponse.addHeader("Via", generateViaHeader(closeableHttpResponse));
        int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
        if (statusCode == 304 || statusCode == 200) {
            recordCacheUpdate(httpClientContext2);
        }
        if (statusCode == 304) {
            HttpCacheEntry updateCacheEntry = this.responseCache.updateCacheEntry(httpClientContext.getTargetHost(), httpRequestWrapper, httpCacheEntry, closeableHttpResponse, date2, date);
            if (!this.suitabilityChecker.isConditional(httpRequestWrapper) || !this.suitabilityChecker.allConditionalsMatch(httpRequestWrapper, updateCacheEntry, new Date())) {
                return this.responseGenerator.generateResponse(updateCacheEntry);
            }
            return this.responseGenerator.generateNotModifiedResponse(updateCacheEntry);
        } else if (!staleIfErrorAppliesTo(statusCode) || staleResponseNotAllowed(httpRequestWrapper, httpCacheEntry2, getCurrentDate()) || !this.validityPolicy.mayReturnStaleIfError(httpRequestWrapper, httpCacheEntry2, date)) {
            return handleBackendResponse(httpRoute, buildConditionalRequest, httpClientContext, httpExecutionAware, date2, date, closeableHttpResponse);
        } else {
            try {
                CloseableHttpResponse generateResponse = this.responseGenerator.generateResponse(httpCacheEntry2);
                generateResponse.addHeader("Warning", "110 localhost \"Response is stale\"");
                return generateResponse;
            } finally {
                closeableHttpResponse.close();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public CloseableHttpResponse handleBackendResponse(HttpRoute httpRoute, HttpRequestWrapper httpRequestWrapper, HttpClientContext httpClientContext, HttpExecutionAware httpExecutionAware, Date date, Date date2, CloseableHttpResponse closeableHttpResponse) throws IOException {
        this.log.trace("Handling Backend response");
        this.responseCompliance.ensureProtocolCompliance(httpRequestWrapper, closeableHttpResponse);
        HttpHost targetHost = httpClientContext.getTargetHost();
        boolean isResponseCacheable = this.responseCachingPolicy.isResponseCacheable((HttpRequest) httpRequestWrapper, (HttpResponse) closeableHttpResponse);
        this.responseCache.flushInvalidatedCacheEntriesFor(targetHost, httpRequestWrapper, closeableHttpResponse);
        if (!isResponseCacheable || alreadyHaveNewerCacheEntry(targetHost, httpRequestWrapper, closeableHttpResponse)) {
            if (!isResponseCacheable) {
                try {
                    this.responseCache.flushCacheEntriesFor(targetHost, httpRequestWrapper);
                } catch (IOException e) {
                    this.log.warn("Unable to flush invalid cache entries", e);
                }
            }
            return closeableHttpResponse;
        }
        storeRequestIfModifiedSinceFor304Response(httpRequestWrapper, closeableHttpResponse);
        return this.responseCache.cacheAndReturnResponse(targetHost, (HttpRequest) httpRequestWrapper, closeableHttpResponse, date, date2);
    }

    private void storeRequestIfModifiedSinceFor304Response(HttpRequest httpRequest, HttpResponse httpResponse) {
        Header firstHeader;
        if (httpResponse.getStatusLine().getStatusCode() == 304 && (firstHeader = httpRequest.getFirstHeader("If-Modified-Since")) != null) {
            httpResponse.addHeader("Last-Modified", firstHeader.getValue());
        }
    }

    private boolean alreadyHaveNewerCacheEntry(HttpHost httpHost, HttpRequestWrapper httpRequestWrapper, HttpResponse httpResponse) {
        HttpCacheEntry httpCacheEntry;
        Header firstHeader;
        Header firstHeader2;
        try {
            httpCacheEntry = this.responseCache.getCacheEntry(httpHost, httpRequestWrapper);
        } catch (IOException unused) {
            httpCacheEntry = null;
        }
        if (httpCacheEntry == null || (firstHeader = httpCacheEntry.getFirstHeader("Date")) == null || (firstHeader2 = httpResponse.getFirstHeader("Date")) == null) {
            return false;
        }
        Date parseDate = DateUtils.parseDate(firstHeader.getValue());
        Date parseDate2 = DateUtils.parseDate(firstHeader2.getValue());
        if (parseDate == null || parseDate2 == null) {
            return false;
        }
        return parseDate2.before(parseDate);
    }
}
