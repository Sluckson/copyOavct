package p052cz.msebera.android.httpclient.impl.client.cache;

import java.util.Date;
import p052cz.msebera.android.httpclient.Header;
import p052cz.msebera.android.httpclient.HeaderElement;
import p052cz.msebera.android.httpclient.HttpHost;
import p052cz.msebera.android.httpclient.HttpRequest;
import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.client.cache.HeaderConstants;
import p052cz.msebera.android.httpclient.client.cache.HttpCacheEntry;
import p052cz.msebera.android.httpclient.client.utils.DateUtils;
import p052cz.msebera.android.httpclient.extras.HttpClientAndroidLog;

@Immutable
/* renamed from: cz.msebera.android.httpclient.impl.client.cache.CachedResponseSuitabilityChecker */
class CachedResponseSuitabilityChecker {
    private final float heuristicCoefficient;
    private final long heuristicDefaultLifetime;
    public HttpClientAndroidLog log;
    private final boolean sharedCache;
    private final boolean useHeuristicCaching;
    private final CacheValidityPolicy validityStrategy;

    CachedResponseSuitabilityChecker(CacheValidityPolicy cacheValidityPolicy, CacheConfig cacheConfig) {
        this.log = new HttpClientAndroidLog(getClass());
        this.validityStrategy = cacheValidityPolicy;
        this.sharedCache = cacheConfig.isSharedCache();
        this.useHeuristicCaching = cacheConfig.isHeuristicCachingEnabled();
        this.heuristicCoefficient = cacheConfig.getHeuristicCoefficient();
        this.heuristicDefaultLifetime = cacheConfig.getHeuristicDefaultLifetime();
    }

    CachedResponseSuitabilityChecker(CacheConfig cacheConfig) {
        this(new CacheValidityPolicy(), cacheConfig);
    }

    private boolean isFreshEnough(HttpCacheEntry httpCacheEntry, HttpRequest httpRequest, Date date) {
        if (this.validityStrategy.isResponseFresh(httpCacheEntry, date)) {
            return true;
        }
        if (this.useHeuristicCaching) {
            if (this.validityStrategy.isResponseHeuristicallyFresh(httpCacheEntry, date, this.heuristicCoefficient, this.heuristicDefaultLifetime)) {
                return true;
            }
        }
        if (originInsistsOnFreshness(httpCacheEntry)) {
            return false;
        }
        long maxStale = getMaxStale(httpRequest);
        if (maxStale != -1 && maxStale > this.validityStrategy.getStalenessSecs(httpCacheEntry, date)) {
            return true;
        }
        return false;
    }

    private boolean originInsistsOnFreshness(HttpCacheEntry httpCacheEntry) {
        if (this.validityStrategy.mustRevalidate(httpCacheEntry)) {
            return true;
        }
        if (!this.sharedCache) {
            return false;
        }
        if (this.validityStrategy.proxyRevalidate(httpCacheEntry) || this.validityStrategy.hasCacheControlDirective(httpCacheEntry, "s-maxage")) {
            return true;
        }
        return false;
    }

    private long getMaxStale(HttpRequest httpRequest) {
        Header[] headers = httpRequest.getHeaders("Cache-Control");
        int length = headers.length;
        long j = -1;
        int i = 0;
        while (i < length) {
            long j2 = j;
            for (HeaderElement headerElement : headers[i].getElements()) {
                if (HeaderConstants.CACHE_CONTROL_MAX_STALE.equals(headerElement.getName())) {
                    if ((headerElement.getValue() == null || "".equals(headerElement.getValue().trim())) && j2 == -1) {
                        j2 = Long.MAX_VALUE;
                    } else {
                        try {
                            long parseLong = Long.parseLong(headerElement.getValue());
                            if (parseLong < 0) {
                                parseLong = 0;
                            }
                            if (j2 == -1 || parseLong < j2) {
                                j2 = parseLong;
                            }
                        } catch (NumberFormatException unused) {
                            j2 = 0;
                        }
                    }
                }
            }
            i++;
            j = j2;
        }
        return j;
    }

    public boolean canCachedResponseBeUsed(HttpHost httpHost, HttpRequest httpRequest, HttpCacheEntry httpCacheEntry, Date date) {
        int i;
        HttpRequest httpRequest2 = httpRequest;
        HttpCacheEntry httpCacheEntry2 = httpCacheEntry;
        Date date2 = date;
        boolean z = false;
        if (!isFreshEnough(httpCacheEntry2, httpRequest2, date2)) {
            this.log.trace("Cache entry was not fresh enough");
            return false;
        } else if (!this.validityStrategy.contentLengthHeaderMatchesActualLength(httpCacheEntry2)) {
            this.log.debug("Cache entry Content-Length and header information do not match");
            return false;
        } else if (hasUnsupportedConditionalHeaders(httpRequest2)) {
            this.log.debug("Request contained conditional headers we don't handle");
            return false;
        } else if (!isConditional(httpRequest2) && httpCacheEntry.getStatusCode() == 304) {
            return false;
        } else {
            if (isConditional(httpRequest2) && !allConditionalsMatch(httpRequest2, httpCacheEntry2, date2)) {
                return false;
            }
            Header[] headers = httpRequest2.getHeaders("Cache-Control");
            int length = headers.length;
            int i2 = 0;
            while (i2 < length) {
                HeaderElement[] elements = headers[i2].getElements();
                int length2 = elements.length;
                int i3 = 0;
                while (i3 < length2) {
                    HeaderElement headerElement = elements[i3];
                    if (HeaderConstants.CACHE_CONTROL_NO_CACHE.equals(headerElement.getName())) {
                        this.log.trace("Response contained NO CACHE directive, cache was not suitable");
                        return z;
                    } else if (HeaderConstants.CACHE_CONTROL_NO_STORE.equals(headerElement.getName())) {
                        this.log.trace("Response contained NO STORE directive, cache was not suitable");
                        return z;
                    } else {
                        if ("max-age".equals(headerElement.getName())) {
                            try {
                                if (this.validityStrategy.getCurrentAgeSecs(httpCacheEntry2, date2) > ((long) Integer.parseInt(headerElement.getValue()))) {
                                    this.log.trace("Response from cache was NOT suitable due to max age");
                                    return z;
                                }
                            } catch (NumberFormatException e) {
                                HttpClientAndroidLog httpClientAndroidLog = this.log;
                                httpClientAndroidLog.debug("Response from cache was malformed" + e.getMessage());
                                return z;
                            }
                        }
                        if (HeaderConstants.CACHE_CONTROL_MAX_STALE.equals(headerElement.getName())) {
                            try {
                                i = i2;
                                if (this.validityStrategy.getFreshnessLifetimeSecs(httpCacheEntry2) > ((long) Integer.parseInt(headerElement.getValue()))) {
                                    this.log.trace("Response from cache was not suitable due to Max stale freshness");
                                    return false;
                                }
                            } catch (NumberFormatException e2) {
                                HttpClientAndroidLog httpClientAndroidLog2 = this.log;
                                httpClientAndroidLog2.debug("Response from cache was malformed: " + e2.getMessage());
                                return false;
                            }
                        } else {
                            i = i2;
                        }
                        if (HeaderConstants.CACHE_CONTROL_MIN_FRESH.equals(headerElement.getName())) {
                            try {
                                long parseLong = Long.parseLong(headerElement.getValue());
                                if (parseLong < 0) {
                                    return false;
                                }
                                if (this.validityStrategy.getFreshnessLifetimeSecs(httpCacheEntry2) - this.validityStrategy.getCurrentAgeSecs(httpCacheEntry2, date2) < parseLong) {
                                    this.log.trace("Response from cache was not suitable due to min fresh freshness requirement");
                                    return false;
                                }
                            } catch (NumberFormatException e3) {
                                HttpClientAndroidLog httpClientAndroidLog3 = this.log;
                                httpClientAndroidLog3.debug("Response from cache was malformed: " + e3.getMessage());
                                return false;
                            }
                        }
                        z = false;
                        i3++;
                        i2 = i;
                    }
                }
                i2++;
            }
            this.log.trace("Response from cache was suitable");
            return true;
        }
    }

    public boolean isConditional(HttpRequest httpRequest) {
        return hasSupportedEtagValidator(httpRequest) || hasSupportedLastModifiedValidator(httpRequest);
    }

    public boolean allConditionalsMatch(HttpRequest httpRequest, HttpCacheEntry httpCacheEntry, Date date) {
        boolean hasSupportedEtagValidator = hasSupportedEtagValidator(httpRequest);
        boolean hasSupportedLastModifiedValidator = hasSupportedLastModifiedValidator(httpRequest);
        boolean z = hasSupportedEtagValidator && etagValidatorMatches(httpRequest, httpCacheEntry);
        boolean z2 = hasSupportedLastModifiedValidator && lastModifiedValidatorMatches(httpRequest, httpCacheEntry, date);
        if (hasSupportedEtagValidator && hasSupportedLastModifiedValidator && (!z || !z2)) {
            return false;
        }
        if (!hasSupportedEtagValidator || z) {
            return !hasSupportedLastModifiedValidator || z2;
        }
        return false;
    }

    private boolean hasUnsupportedConditionalHeaders(HttpRequest httpRequest) {
        return (httpRequest.getFirstHeader("If-Range") == null && httpRequest.getFirstHeader("If-Match") == null && !hasValidDateField(httpRequest, "If-Unmodified-Since")) ? false : true;
    }

    private boolean hasSupportedEtagValidator(HttpRequest httpRequest) {
        return httpRequest.containsHeader("If-None-Match");
    }

    private boolean hasSupportedLastModifiedValidator(HttpRequest httpRequest) {
        return hasValidDateField(httpRequest, "If-Modified-Since");
    }

    private boolean etagValidatorMatches(HttpRequest httpRequest, HttpCacheEntry httpCacheEntry) {
        Header firstHeader = httpCacheEntry.getFirstHeader("ETag");
        String value = firstHeader != null ? firstHeader.getValue() : null;
        Header[] headers = httpRequest.getHeaders("If-None-Match");
        if (headers != null) {
            for (Header elements : headers) {
                for (HeaderElement obj : elements.getElements()) {
                    String obj2 = obj.toString();
                    if (("*".equals(obj2) && value != null) || obj2.equals(value)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean lastModifiedValidatorMatches(HttpRequest httpRequest, HttpCacheEntry httpCacheEntry, Date date) {
        Header firstHeader = httpCacheEntry.getFirstHeader("Last-Modified");
        Date parseDate = firstHeader != null ? DateUtils.parseDate(firstHeader.getValue()) : null;
        if (parseDate == null) {
            return false;
        }
        for (Header value : httpRequest.getHeaders("If-Modified-Since")) {
            Date parseDate2 = DateUtils.parseDate(value.getValue());
            if (parseDate2 != null && (parseDate2.after(date) || parseDate.after(parseDate2))) {
                return false;
            }
        }
        return true;
    }

    private boolean hasValidDateField(HttpRequest httpRequest, String str) {
        Header[] headers = httpRequest.getHeaders(str);
        if (headers.length <= 0 || DateUtils.parseDate(headers[0].getValue()) == null) {
            return false;
        }
        return true;
    }
}
