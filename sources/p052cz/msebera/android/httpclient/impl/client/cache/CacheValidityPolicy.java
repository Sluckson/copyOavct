package p052cz.msebera.android.httpclient.impl.client.cache;

import java.util.Date;
import p052cz.msebera.android.httpclient.Header;
import p052cz.msebera.android.httpclient.HeaderElement;
import p052cz.msebera.android.httpclient.HttpRequest;
import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.client.cache.HeaderConstants;
import p052cz.msebera.android.httpclient.client.cache.HttpCacheEntry;
import p052cz.msebera.android.httpclient.client.utils.DateUtils;

@Immutable
/* renamed from: cz.msebera.android.httpclient.impl.client.cache.CacheValidityPolicy */
class CacheValidityPolicy {
    public static final long MAX_AGE = 2147483648L;

    CacheValidityPolicy() {
    }

    public long getCurrentAgeSecs(HttpCacheEntry httpCacheEntry, Date date) {
        return getCorrectedInitialAgeSecs(httpCacheEntry) + getResidentTimeSecs(httpCacheEntry, date);
    }

    public long getFreshnessLifetimeSecs(HttpCacheEntry httpCacheEntry) {
        Date expirationDate;
        long maxAge = getMaxAge(httpCacheEntry);
        if (maxAge > -1) {
            return maxAge;
        }
        Date date = httpCacheEntry.getDate();
        if (date == null || (expirationDate = getExpirationDate(httpCacheEntry)) == null) {
            return 0;
        }
        return (expirationDate.getTime() - date.getTime()) / 1000;
    }

    public boolean isResponseFresh(HttpCacheEntry httpCacheEntry, Date date) {
        return getCurrentAgeSecs(httpCacheEntry, date) < getFreshnessLifetimeSecs(httpCacheEntry);
    }

    public boolean isResponseHeuristicallyFresh(HttpCacheEntry httpCacheEntry, Date date, float f, long j) {
        return getCurrentAgeSecs(httpCacheEntry, date) < getHeuristicFreshnessLifetimeSecs(httpCacheEntry, f, j);
    }

    public long getHeuristicFreshnessLifetimeSecs(HttpCacheEntry httpCacheEntry, float f, long j) {
        Date date = httpCacheEntry.getDate();
        Date lastModifiedValue = getLastModifiedValue(httpCacheEntry);
        if (date == null || lastModifiedValue == null) {
            return j;
        }
        long time = date.getTime() - lastModifiedValue.getTime();
        if (time < 0) {
            return 0;
        }
        return (long) (f * ((float) (time / 1000)));
    }

    public boolean isRevalidatable(HttpCacheEntry httpCacheEntry) {
        return (httpCacheEntry.getFirstHeader("ETag") == null && httpCacheEntry.getFirstHeader("Last-Modified") == null) ? false : true;
    }

    public boolean mustRevalidate(HttpCacheEntry httpCacheEntry) {
        return hasCacheControlDirective(httpCacheEntry, HeaderConstants.CACHE_CONTROL_MUST_REVALIDATE);
    }

    public boolean proxyRevalidate(HttpCacheEntry httpCacheEntry) {
        return hasCacheControlDirective(httpCacheEntry, HeaderConstants.CACHE_CONTROL_PROXY_REVALIDATE);
    }

    public boolean mayReturnStaleWhileRevalidating(HttpCacheEntry httpCacheEntry, Date date) {
        for (Header elements : httpCacheEntry.getHeaders("Cache-Control")) {
            for (HeaderElement headerElement : elements.getElements()) {
                if (HeaderConstants.STALE_WHILE_REVALIDATE.equalsIgnoreCase(headerElement.getName())) {
                    try {
                        if (getStalenessSecs(httpCacheEntry, date) <= ((long) Integer.parseInt(headerElement.getValue()))) {
                            return true;
                        }
                    } catch (NumberFormatException unused) {
                        continue;
                    }
                }
            }
        }
        return false;
    }

    public boolean mayReturnStaleIfError(HttpRequest httpRequest, HttpCacheEntry httpCacheEntry, Date date) {
        long stalenessSecs = getStalenessSecs(httpCacheEntry, date);
        return mayReturnStaleIfError(httpRequest.getHeaders("Cache-Control"), stalenessSecs) || mayReturnStaleIfError(httpCacheEntry.getHeaders("Cache-Control"), stalenessSecs);
    }

    private boolean mayReturnStaleIfError(Header[] headerArr, long j) {
        boolean z = false;
        for (Header elements : headerArr) {
            HeaderElement[] elements2 = elements.getElements();
            int length = elements2.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                HeaderElement headerElement = elements2[i];
                if (HeaderConstants.STALE_IF_ERROR.equals(headerElement.getName())) {
                    try {
                        if (j <= ((long) Integer.parseInt(headerElement.getValue()))) {
                            z = true;
                            break;
                        }
                    } catch (NumberFormatException unused) {
                        continue;
                    }
                }
                i++;
            }
        }
        return z;
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public Date getDateValue(HttpCacheEntry httpCacheEntry) {
        return httpCacheEntry.getDate();
    }

    /* access modifiers changed from: protected */
    public Date getLastModifiedValue(HttpCacheEntry httpCacheEntry) {
        Header firstHeader = httpCacheEntry.getFirstHeader("Last-Modified");
        if (firstHeader == null) {
            return null;
        }
        return DateUtils.parseDate(firstHeader.getValue());
    }

    /* access modifiers changed from: protected */
    public long getContentLengthValue(HttpCacheEntry httpCacheEntry) {
        Header firstHeader = httpCacheEntry.getFirstHeader("Content-Length");
        if (firstHeader == null) {
            return -1;
        }
        try {
            return Long.parseLong(firstHeader.getValue());
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    /* access modifiers changed from: protected */
    public boolean hasContentLengthHeader(HttpCacheEntry httpCacheEntry) {
        return httpCacheEntry.getFirstHeader("Content-Length") != null;
    }

    /* access modifiers changed from: protected */
    public boolean contentLengthHeaderMatchesActualLength(HttpCacheEntry httpCacheEntry) {
        return !hasContentLengthHeader(httpCacheEntry) || getContentLengthValue(httpCacheEntry) == httpCacheEntry.getResource().length();
    }

    /* access modifiers changed from: protected */
    public long getApparentAgeSecs(HttpCacheEntry httpCacheEntry) {
        Date date = httpCacheEntry.getDate();
        if (date == null) {
            return MAX_AGE;
        }
        long time = httpCacheEntry.getResponseDate().getTime() - date.getTime();
        if (time < 0) {
            return 0;
        }
        return time / 1000;
    }

    /* access modifiers changed from: protected */
    public long getAgeValue(HttpCacheEntry httpCacheEntry) {
        long j = 0;
        for (Header header : httpCacheEntry.getHeaders("Age")) {
            long j2 = MAX_AGE;
            try {
                long parseLong = Long.parseLong(header.getValue());
                if (parseLong >= 0) {
                    j2 = parseLong;
                }
            } catch (NumberFormatException unused) {
            }
            if (j2 > j) {
                j = j2;
            }
        }
        return j;
    }

    /* access modifiers changed from: protected */
    public long getCorrectedReceivedAgeSecs(HttpCacheEntry httpCacheEntry) {
        long apparentAgeSecs = getApparentAgeSecs(httpCacheEntry);
        long ageValue = getAgeValue(httpCacheEntry);
        return apparentAgeSecs > ageValue ? apparentAgeSecs : ageValue;
    }

    /* access modifiers changed from: protected */
    public long getResponseDelaySecs(HttpCacheEntry httpCacheEntry) {
        return (httpCacheEntry.getResponseDate().getTime() - httpCacheEntry.getRequestDate().getTime()) / 1000;
    }

    /* access modifiers changed from: protected */
    public long getCorrectedInitialAgeSecs(HttpCacheEntry httpCacheEntry) {
        return getCorrectedReceivedAgeSecs(httpCacheEntry) + getResponseDelaySecs(httpCacheEntry);
    }

    /* access modifiers changed from: protected */
    public long getResidentTimeSecs(HttpCacheEntry httpCacheEntry, Date date) {
        return (date.getTime() - httpCacheEntry.getResponseDate().getTime()) / 1000;
    }

    /* access modifiers changed from: protected */
    public long getMaxAge(HttpCacheEntry httpCacheEntry) {
        Header[] headers = httpCacheEntry.getHeaders("Cache-Control");
        int length = headers.length;
        long j = -1;
        int i = 0;
        while (i < length) {
            long j2 = j;
            for (HeaderElement headerElement : headers[i].getElements()) {
                if ("max-age".equals(headerElement.getName()) || "s-maxage".equals(headerElement.getName())) {
                    try {
                        long parseLong = Long.parseLong(headerElement.getValue());
                        if (j2 == -1 || parseLong < j2) {
                            j2 = parseLong;
                        }
                    } catch (NumberFormatException unused) {
                        j2 = 0;
                    }
                }
            }
            i++;
            j = j2;
        }
        return j;
    }

    /* access modifiers changed from: protected */
    public Date getExpirationDate(HttpCacheEntry httpCacheEntry) {
        Header firstHeader = httpCacheEntry.getFirstHeader("Expires");
        if (firstHeader == null) {
            return null;
        }
        return DateUtils.parseDate(firstHeader.getValue());
    }

    public boolean hasCacheControlDirective(HttpCacheEntry httpCacheEntry, String str) {
        for (Header elements : httpCacheEntry.getHeaders("Cache-Control")) {
            for (HeaderElement name : elements.getElements()) {
                if (str.equalsIgnoreCase(name.getName())) {
                    return true;
                }
            }
        }
        return false;
    }

    public long getStalenessSecs(HttpCacheEntry httpCacheEntry, Date date) {
        long currentAgeSecs = getCurrentAgeSecs(httpCacheEntry, date);
        long freshnessLifetimeSecs = getFreshnessLifetimeSecs(httpCacheEntry);
        if (currentAgeSecs <= freshnessLifetimeSecs) {
            return 0;
        }
        return currentAgeSecs - freshnessLifetimeSecs;
    }
}
