package p052cz.msebera.android.httpclient.client.cache;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import p052cz.msebera.android.httpclient.Header;
import p052cz.msebera.android.httpclient.ProtocolVersion;
import p052cz.msebera.android.httpclient.StatusLine;
import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.client.utils.DateUtils;
import p052cz.msebera.android.httpclient.message.HeaderGroup;
import p052cz.msebera.android.httpclient.util.Args;

@Immutable
/* renamed from: cz.msebera.android.httpclient.client.cache.HttpCacheEntry */
public class HttpCacheEntry implements Serializable {
    private static final long serialVersionUID = -6300496422359477413L;
    private final Date date;
    private final Date requestDate;
    private final Resource resource;
    private final Date responseDate;
    private final HeaderGroup responseHeaders;
    private final StatusLine statusLine;
    private final Map<String, String> variantMap;

    public HttpCacheEntry(Date date2, Date date3, StatusLine statusLine2, Header[] headerArr, Resource resource2, Map<String, String> map) {
        Args.notNull(date2, "Request date");
        Args.notNull(date3, "Response date");
        Args.notNull(statusLine2, "Status line");
        Args.notNull(headerArr, "Response headers");
        this.requestDate = date2;
        this.responseDate = date3;
        this.statusLine = statusLine2;
        this.responseHeaders = new HeaderGroup();
        this.responseHeaders.setHeaders(headerArr);
        this.resource = resource2;
        this.variantMap = map != null ? new HashMap(map) : null;
        this.date = parseDate();
    }

    public HttpCacheEntry(Date date2, Date date3, StatusLine statusLine2, Header[] headerArr, Resource resource2) {
        this(date2, date3, statusLine2, headerArr, resource2, new HashMap());
    }

    private Date parseDate() {
        Header firstHeader = getFirstHeader("Date");
        if (firstHeader == null) {
            return null;
        }
        return DateUtils.parseDate(firstHeader.getValue());
    }

    public StatusLine getStatusLine() {
        return this.statusLine;
    }

    public ProtocolVersion getProtocolVersion() {
        return this.statusLine.getProtocolVersion();
    }

    public String getReasonPhrase() {
        return this.statusLine.getReasonPhrase();
    }

    public int getStatusCode() {
        return this.statusLine.getStatusCode();
    }

    public Date getRequestDate() {
        return this.requestDate;
    }

    public Date getResponseDate() {
        return this.responseDate;
    }

    public Header[] getAllHeaders() {
        return this.responseHeaders.getAllHeaders();
    }

    public Header getFirstHeader(String str) {
        return this.responseHeaders.getFirstHeader(str);
    }

    public Header[] getHeaders(String str) {
        return this.responseHeaders.getHeaders(str);
    }

    public Date getDate() {
        return this.date;
    }

    public Resource getResource() {
        return this.resource;
    }

    public boolean hasVariants() {
        return getFirstHeader("Vary") != null;
    }

    public Map<String, String> getVariantMap() {
        return Collections.unmodifiableMap(this.variantMap);
    }

    public String toString() {
        return "[request date=" + this.requestDate + "; response date=" + this.responseDate + "; statusLine=" + this.statusLine + "]";
    }
}
