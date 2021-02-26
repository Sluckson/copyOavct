package p052cz.msebera.android.httpclient.impl.client.cache;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import p052cz.msebera.android.httpclient.Header;
import p052cz.msebera.android.httpclient.HttpHost;
import p052cz.msebera.android.httpclient.HttpRequest;
import p052cz.msebera.android.httpclient.HttpResponse;
import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.client.cache.HttpCacheEntry;
import p052cz.msebera.android.httpclient.client.cache.HttpCacheInvalidator;
import p052cz.msebera.android.httpclient.client.cache.HttpCacheStorage;
import p052cz.msebera.android.httpclient.client.utils.DateUtils;
import p052cz.msebera.android.httpclient.extras.HttpClientAndroidLog;

@Immutable
/* renamed from: cz.msebera.android.httpclient.impl.client.cache.CacheInvalidator */
class CacheInvalidator implements HttpCacheInvalidator {
    private final CacheKeyGenerator cacheKeyGenerator;
    public HttpClientAndroidLog log = new HttpClientAndroidLog(getClass());
    private final HttpCacheStorage storage;

    public CacheInvalidator(CacheKeyGenerator cacheKeyGenerator2, HttpCacheStorage httpCacheStorage) {
        this.cacheKeyGenerator = cacheKeyGenerator2;
        this.storage = httpCacheStorage;
    }

    public void flushInvalidatedCacheEntries(HttpHost httpHost, HttpRequest httpRequest) {
        if (requestShouldNotBeCached(httpRequest)) {
            this.log.debug("Request should not be cached");
            String uri = this.cacheKeyGenerator.getURI(httpHost, httpRequest);
            HttpCacheEntry entry = getEntry(uri);
            HttpClientAndroidLog httpClientAndroidLog = this.log;
            httpClientAndroidLog.debug("parent entry: " + entry);
            if (entry != null) {
                for (String flushEntry : entry.getVariantMap().values()) {
                    flushEntry(flushEntry);
                }
                flushEntry(uri);
            }
            URL absoluteURL = getAbsoluteURL(uri);
            if (absoluteURL == null) {
                this.log.error("Couldn't transform request into valid URL");
                return;
            }
            Header firstHeader = httpRequest.getFirstHeader("Content-Location");
            if (firstHeader != null) {
                String value = firstHeader.getValue();
                if (!flushAbsoluteUriFromSameHost(absoluteURL, value)) {
                    flushRelativeUriFromSameHost(absoluteURL, value);
                }
            }
            Header firstHeader2 = httpRequest.getFirstHeader("Location");
            if (firstHeader2 != null) {
                flushAbsoluteUriFromSameHost(absoluteURL, firstHeader2.getValue());
            }
        }
    }

    private void flushEntry(String str) {
        try {
            this.storage.removeEntry(str);
        } catch (IOException e) {
            this.log.warn("unable to flush cache entry", e);
        }
    }

    private HttpCacheEntry getEntry(String str) {
        try {
            return this.storage.getEntry(str);
        } catch (IOException e) {
            this.log.warn("could not retrieve entry from storage", e);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public void flushUriIfSameHost(URL url, URL url2) {
        URL absoluteURL = getAbsoluteURL(this.cacheKeyGenerator.canonicalizeUri(url2.toString()));
        if (absoluteURL != null && absoluteURL.getAuthority().equalsIgnoreCase(url.getAuthority())) {
            flushEntry(absoluteURL.toString());
        }
    }

    /* access modifiers changed from: protected */
    public void flushRelativeUriFromSameHost(URL url, String str) {
        URL relativeURL = getRelativeURL(url, str);
        if (relativeURL != null) {
            flushUriIfSameHost(url, relativeURL);
        }
    }

    /* access modifiers changed from: protected */
    public boolean flushAbsoluteUriFromSameHost(URL url, String str) {
        URL absoluteURL = getAbsoluteURL(str);
        if (absoluteURL == null) {
            return false;
        }
        flushUriIfSameHost(url, absoluteURL);
        return true;
    }

    private URL getAbsoluteURL(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException unused) {
            return null;
        }
    }

    private URL getRelativeURL(URL url, String str) {
        try {
            return new URL(url, str);
        } catch (MalformedURLException unused) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public boolean requestShouldNotBeCached(HttpRequest httpRequest) {
        return notGetOrHeadRequest(httpRequest.getRequestLine().getMethod());
    }

    private boolean notGetOrHeadRequest(String str) {
        return !"GET".equals(str) && !"HEAD".equals(str);
    }

    public void flushInvalidatedCacheEntries(HttpHost httpHost, HttpRequest httpRequest, HttpResponse httpResponse) {
        URL absoluteURL;
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        if (statusCode >= 200 && statusCode <= 299 && (absoluteURL = getAbsoluteURL(this.cacheKeyGenerator.getURI(httpHost, httpRequest))) != null) {
            URL contentLocationURL = getContentLocationURL(absoluteURL, httpResponse);
            if (contentLocationURL != null) {
                flushLocationCacheEntry(absoluteURL, httpResponse, contentLocationURL);
            }
            URL locationURL = getLocationURL(absoluteURL, httpResponse);
            if (locationURL != null) {
                flushLocationCacheEntry(absoluteURL, httpResponse, locationURL);
            }
        }
    }

    private void flushLocationCacheEntry(URL url, HttpResponse httpResponse, URL url2) {
        HttpCacheEntry entry = getEntry(this.cacheKeyGenerator.canonicalizeUri(url2.toString()));
        if (entry != null && !responseDateOlderThanEntryDate(httpResponse, entry) && responseAndEntryEtagsDiffer(httpResponse, entry)) {
            flushUriIfSameHost(url, url2);
        }
    }

    private URL getContentLocationURL(URL url, HttpResponse httpResponse) {
        Header firstHeader = httpResponse.getFirstHeader("Content-Location");
        if (firstHeader == null) {
            return null;
        }
        String value = firstHeader.getValue();
        URL absoluteURL = getAbsoluteURL(value);
        if (absoluteURL != null) {
            return absoluteURL;
        }
        return getRelativeURL(url, value);
    }

    private URL getLocationURL(URL url, HttpResponse httpResponse) {
        Header firstHeader = httpResponse.getFirstHeader("Location");
        if (firstHeader == null) {
            return null;
        }
        String value = firstHeader.getValue();
        URL absoluteURL = getAbsoluteURL(value);
        if (absoluteURL != null) {
            return absoluteURL;
        }
        return getRelativeURL(url, value);
    }

    private boolean responseAndEntryEtagsDiffer(HttpResponse httpResponse, HttpCacheEntry httpCacheEntry) {
        Header firstHeader = httpCacheEntry.getFirstHeader("ETag");
        Header firstHeader2 = httpResponse.getFirstHeader("ETag");
        if (firstHeader == null || firstHeader2 == null) {
            return false;
        }
        return !firstHeader.getValue().equals(firstHeader2.getValue());
    }

    private boolean responseDateOlderThanEntryDate(HttpResponse httpResponse, HttpCacheEntry httpCacheEntry) {
        Header firstHeader = httpCacheEntry.getFirstHeader("Date");
        Header firstHeader2 = httpResponse.getFirstHeader("Date");
        if (!(firstHeader == null || firstHeader2 == null)) {
            Date parseDate = DateUtils.parseDate(firstHeader.getValue());
            Date parseDate2 = DateUtils.parseDate(firstHeader2.getValue());
            if (!(parseDate == null || parseDate2 == null)) {
                return parseDate2.before(parseDate);
            }
        }
        return false;
    }
}
