package p052cz.msebera.android.httpclient.impl.client.cache;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import p052cz.msebera.android.httpclient.Header;
import p052cz.msebera.android.httpclient.HeaderElement;
import p052cz.msebera.android.httpclient.HttpEntity;
import p052cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import p052cz.msebera.android.httpclient.HttpRequest;
import p052cz.msebera.android.httpclient.HttpResponse;
import p052cz.msebera.android.httpclient.HttpStatus;
import p052cz.msebera.android.httpclient.HttpVersion;
import p052cz.msebera.android.httpclient.ProtocolVersion;
import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.client.ClientProtocolException;
import p052cz.msebera.android.httpclient.client.cache.HeaderConstants;
import p052cz.msebera.android.httpclient.client.methods.HttpRequestWrapper;
import p052cz.msebera.android.httpclient.entity.AbstractHttpEntity;
import p052cz.msebera.android.httpclient.entity.ContentType;
import p052cz.msebera.android.httpclient.message.BasicHeader;
import p052cz.msebera.android.httpclient.message.BasicHttpResponse;
import p052cz.msebera.android.httpclient.message.BasicStatusLine;
import p052cz.msebera.android.httpclient.protocol.HTTP;

@Immutable
/* renamed from: cz.msebera.android.httpclient.impl.client.cache.RequestProtocolCompliance */
class RequestProtocolCompliance {
    private static final List<String> disallowedWithNoCache = Arrays.asList(new String[]{HeaderConstants.CACHE_CONTROL_MIN_FRESH, HeaderConstants.CACHE_CONTROL_MAX_STALE, "max-age"});
    private final boolean weakETagOnPutDeleteAllowed;

    public RequestProtocolCompliance() {
        this.weakETagOnPutDeleteAllowed = false;
    }

    public RequestProtocolCompliance(boolean z) {
        this.weakETagOnPutDeleteAllowed = z;
    }

    public List<RequestProtocolError> requestIsFatallyNonCompliant(HttpRequest httpRequest) {
        RequestProtocolError requestHasWeekETagForPUTOrDELETEIfMatch;
        ArrayList arrayList = new ArrayList();
        RequestProtocolError requestHasWeakETagAndRange = requestHasWeakETagAndRange(httpRequest);
        if (requestHasWeakETagAndRange != null) {
            arrayList.add(requestHasWeakETagAndRange);
        }
        if (!this.weakETagOnPutDeleteAllowed && (requestHasWeekETagForPUTOrDELETEIfMatch = requestHasWeekETagForPUTOrDELETEIfMatch(httpRequest)) != null) {
            arrayList.add(requestHasWeekETagForPUTOrDELETEIfMatch);
        }
        RequestProtocolError requestContainsNoCacheDirectiveWithFieldName = requestContainsNoCacheDirectiveWithFieldName(httpRequest);
        if (requestContainsNoCacheDirectiveWithFieldName != null) {
            arrayList.add(requestContainsNoCacheDirectiveWithFieldName);
        }
        return arrayList;
    }

    public void makeRequestCompliant(HttpRequestWrapper httpRequestWrapper) throws ClientProtocolException {
        if (requestMustNotHaveEntity(httpRequestWrapper)) {
            ((HttpEntityEnclosingRequest) httpRequestWrapper).setEntity((HttpEntity) null);
        }
        verifyRequestWithExpectContinueFlagHas100continueHeader(httpRequestWrapper);
        verifyOPTIONSRequestWithBodyHasContentType(httpRequestWrapper);
        decrementOPTIONSMaxForwardsIfGreaterThen0(httpRequestWrapper);
        stripOtherFreshnessDirectivesWithNoCache(httpRequestWrapper);
        if (requestVersionIsTooLow(httpRequestWrapper) || requestMinorVersionIsTooHighMajorVersionsMatch(httpRequestWrapper)) {
            httpRequestWrapper.setProtocolVersion(HttpVersion.HTTP_1_1);
        }
    }

    private void stripOtherFreshnessDirectivesWithNoCache(HttpRequest httpRequest) {
        ArrayList arrayList = new ArrayList();
        Header[] headers = httpRequest.getHeaders("Cache-Control");
        int length = headers.length;
        int i = 0;
        boolean z = false;
        while (i < length) {
            boolean z2 = z;
            for (HeaderElement headerElement : headers[i].getElements()) {
                if (!disallowedWithNoCache.contains(headerElement.getName())) {
                    arrayList.add(headerElement);
                }
                if (HeaderConstants.CACHE_CONTROL_NO_CACHE.equals(headerElement.getName())) {
                    z2 = true;
                }
            }
            i++;
            z = z2;
        }
        if (z) {
            httpRequest.removeHeaders("Cache-Control");
            httpRequest.setHeader("Cache-Control", buildHeaderFromElements(arrayList));
        }
    }

    private String buildHeaderFromElements(List<HeaderElement> list) {
        StringBuilder sb = new StringBuilder("");
        boolean z = true;
        for (HeaderElement next : list) {
            if (!z) {
                sb.append(",");
            } else {
                z = false;
            }
            sb.append(next.toString());
        }
        return sb.toString();
    }

    private boolean requestMustNotHaveEntity(HttpRequest httpRequest) {
        return "TRACE".equals(httpRequest.getRequestLine().getMethod()) && (httpRequest instanceof HttpEntityEnclosingRequest);
    }

    private void decrementOPTIONSMaxForwardsIfGreaterThen0(HttpRequest httpRequest) {
        Header firstHeader;
        if ("OPTIONS".equals(httpRequest.getRequestLine().getMethod()) && (firstHeader = httpRequest.getFirstHeader("Max-Forwards")) != null) {
            httpRequest.removeHeaders("Max-Forwards");
            httpRequest.setHeader("Max-Forwards", Integer.toString(Integer.parseInt(firstHeader.getValue()) - 1));
        }
    }

    private void verifyOPTIONSRequestWithBodyHasContentType(HttpRequest httpRequest) {
        if ("OPTIONS".equals(httpRequest.getRequestLine().getMethod()) && (httpRequest instanceof HttpEntityEnclosingRequest)) {
            addContentTypeHeaderIfMissing((HttpEntityEnclosingRequest) httpRequest);
        }
    }

    private void addContentTypeHeaderIfMissing(HttpEntityEnclosingRequest httpEntityEnclosingRequest) {
        if (httpEntityEnclosingRequest.getEntity().getContentType() == null) {
            ((AbstractHttpEntity) httpEntityEnclosingRequest.getEntity()).setContentType(ContentType.APPLICATION_OCTET_STREAM.getMimeType());
        }
    }

    private void verifyRequestWithExpectContinueFlagHas100continueHeader(HttpRequest httpRequest) {
        if (httpRequest instanceof HttpEntityEnclosingRequest) {
            HttpEntityEnclosingRequest httpEntityEnclosingRequest = (HttpEntityEnclosingRequest) httpRequest;
            if (!httpEntityEnclosingRequest.expectContinue() || httpEntityEnclosingRequest.getEntity() == null) {
                remove100ContinueHeaderIfExists(httpRequest);
            } else {
                add100ContinueHeaderIfMissing(httpRequest);
            }
        } else {
            remove100ContinueHeaderIfExists(httpRequest);
        }
    }

    private void remove100ContinueHeaderIfExists(HttpRequest httpRequest) {
        Header[] headers = httpRequest.getHeaders("Expect");
        ArrayList arrayList = new ArrayList();
        int length = headers.length;
        ArrayList<HeaderElement> arrayList2 = arrayList;
        int i = 0;
        boolean z = false;
        while (i < length) {
            Header header = headers[i];
            boolean z2 = z;
            for (HeaderElement headerElement : header.getElements()) {
                if (!HTTP.EXPECT_CONTINUE.equalsIgnoreCase(headerElement.getName())) {
                    arrayList2.add(headerElement);
                } else {
                    z2 = true;
                }
            }
            if (z2) {
                httpRequest.removeHeader(header);
                for (HeaderElement name : arrayList2) {
                    httpRequest.addHeader(new BasicHeader("Expect", name.getName()));
                }
                return;
            }
            arrayList2 = new ArrayList<>();
            i++;
            z = z2;
        }
    }

    private void add100ContinueHeaderIfMissing(HttpRequest httpRequest) {
        Header[] headers = httpRequest.getHeaders("Expect");
        int length = headers.length;
        int i = 0;
        boolean z = false;
        while (i < length) {
            boolean z2 = z;
            for (HeaderElement name : headers[i].getElements()) {
                if (HTTP.EXPECT_CONTINUE.equalsIgnoreCase(name.getName())) {
                    z2 = true;
                }
            }
            i++;
            z = z2;
        }
        if (!z) {
            httpRequest.addHeader("Expect", HTTP.EXPECT_CONTINUE);
        }
    }

    /* access modifiers changed from: protected */
    public boolean requestMinorVersionIsTooHighMajorVersionsMatch(HttpRequest httpRequest) {
        ProtocolVersion protocolVersion = httpRequest.getProtocolVersion();
        if (protocolVersion.getMajor() == HttpVersion.HTTP_1_1.getMajor() && protocolVersion.getMinor() > HttpVersion.HTTP_1_1.getMinor()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean requestVersionIsTooLow(HttpRequest httpRequest) {
        return httpRequest.getProtocolVersion().compareToVersion(HttpVersion.HTTP_1_1) < 0;
    }

    /* renamed from: cz.msebera.android.httpclient.impl.client.cache.RequestProtocolCompliance$1 */
    static /* synthetic */ class C43521 {

        /* renamed from: $SwitchMap$cz$msebera$android$httpclient$impl$client$cache$RequestProtocolError */
        static final /* synthetic */ int[] f4887x3102a434 = new int[RequestProtocolError.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
                cz.msebera.android.httpclient.impl.client.cache.RequestProtocolError[] r0 = p052cz.msebera.android.httpclient.impl.client.cache.RequestProtocolError.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f4887x3102a434 = r0
                int[] r0 = f4887x3102a434     // Catch:{ NoSuchFieldError -> 0x0014 }
                cz.msebera.android.httpclient.impl.client.cache.RequestProtocolError r1 = p052cz.msebera.android.httpclient.impl.client.cache.RequestProtocolError.BODY_BUT_NO_LENGTH_ERROR     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f4887x3102a434     // Catch:{ NoSuchFieldError -> 0x001f }
                cz.msebera.android.httpclient.impl.client.cache.RequestProtocolError r1 = p052cz.msebera.android.httpclient.impl.client.cache.RequestProtocolError.WEAK_ETAG_AND_RANGE_ERROR     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f4887x3102a434     // Catch:{ NoSuchFieldError -> 0x002a }
                cz.msebera.android.httpclient.impl.client.cache.RequestProtocolError r1 = p052cz.msebera.android.httpclient.impl.client.cache.RequestProtocolError.WEAK_ETAG_ON_PUTDELETE_METHOD_ERROR     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f4887x3102a434     // Catch:{ NoSuchFieldError -> 0x0035 }
                cz.msebera.android.httpclient.impl.client.cache.RequestProtocolError r1 = p052cz.msebera.android.httpclient.impl.client.cache.RequestProtocolError.NO_CACHE_DIRECTIVE_WITH_FIELD_NAME     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p052cz.msebera.android.httpclient.impl.client.cache.RequestProtocolCompliance.C43521.<clinit>():void");
        }
    }

    public HttpResponse getErrorForRequest(RequestProtocolError requestProtocolError) {
        int i = C43521.f4887x3102a434[requestProtocolError.ordinal()];
        if (i == 1) {
            return new BasicHttpResponse(new BasicStatusLine(HttpVersion.HTTP_1_1, HttpStatus.SC_LENGTH_REQUIRED, ""));
        }
        if (i == 2) {
            return new BasicHttpResponse(new BasicStatusLine(HttpVersion.HTTP_1_1, 400, "Weak eTag not compatible with byte range"));
        }
        if (i == 3) {
            return new BasicHttpResponse(new BasicStatusLine(HttpVersion.HTTP_1_1, 400, "Weak eTag not compatible with PUT or DELETE requests"));
        }
        if (i == 4) {
            return new BasicHttpResponse(new BasicStatusLine(HttpVersion.HTTP_1_1, 400, "No-Cache directive MUST NOT include a field name"));
        }
        throw new IllegalStateException("The request was compliant, therefore no error can be generated for it.");
    }

    private RequestProtocolError requestHasWeakETagAndRange(HttpRequest httpRequest) {
        Header firstHeader;
        if ("GET".equals(httpRequest.getRequestLine().getMethod()) && httpRequest.getFirstHeader("Range") != null && (firstHeader = httpRequest.getFirstHeader("If-Range")) != null && firstHeader.getValue().startsWith("W/")) {
            return RequestProtocolError.WEAK_ETAG_AND_RANGE_ERROR;
        }
        return null;
    }

    private RequestProtocolError requestHasWeekETagForPUTOrDELETEIfMatch(HttpRequest httpRequest) {
        String method = httpRequest.getRequestLine().getMethod();
        if (!"PUT".equals(method) && !"DELETE".equals(method)) {
            return null;
        }
        Header firstHeader = httpRequest.getFirstHeader("If-Match");
        if (firstHeader == null) {
            Header firstHeader2 = httpRequest.getFirstHeader("If-None-Match");
            if (firstHeader2 != null && firstHeader2.getValue().startsWith("W/")) {
                return RequestProtocolError.WEAK_ETAG_ON_PUTDELETE_METHOD_ERROR;
            }
        } else if (firstHeader.getValue().startsWith("W/")) {
            return RequestProtocolError.WEAK_ETAG_ON_PUTDELETE_METHOD_ERROR;
        }
        return null;
    }

    private RequestProtocolError requestContainsNoCacheDirectiveWithFieldName(HttpRequest httpRequest) {
        for (Header elements : httpRequest.getHeaders("Cache-Control")) {
            for (HeaderElement headerElement : elements.getElements()) {
                if (HeaderConstants.CACHE_CONTROL_NO_CACHE.equalsIgnoreCase(headerElement.getName()) && headerElement.getValue() != null) {
                    return RequestProtocolError.NO_CACHE_DIRECTIVE_WITH_FIELD_NAME;
                }
            }
        }
        return null;
    }
}
