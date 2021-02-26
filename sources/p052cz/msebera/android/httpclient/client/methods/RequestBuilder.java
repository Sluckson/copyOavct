package p052cz.msebera.android.httpclient.client.methods;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import p052cz.msebera.android.httpclient.Header;
import p052cz.msebera.android.httpclient.HeaderIterator;
import p052cz.msebera.android.httpclient.HttpEntity;
import p052cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import p052cz.msebera.android.httpclient.HttpRequest;
import p052cz.msebera.android.httpclient.NameValuePair;
import p052cz.msebera.android.httpclient.ProtocolVersion;
import p052cz.msebera.android.httpclient.annotation.NotThreadSafe;
import p052cz.msebera.android.httpclient.client.config.RequestConfig;
import p052cz.msebera.android.httpclient.client.entity.UrlEncodedFormEntity;
import p052cz.msebera.android.httpclient.client.utils.URIBuilder;
import p052cz.msebera.android.httpclient.message.BasicHeader;
import p052cz.msebera.android.httpclient.message.BasicNameValuePair;
import p052cz.msebera.android.httpclient.message.HeaderGroup;
import p052cz.msebera.android.httpclient.protocol.HTTP;
import p052cz.msebera.android.httpclient.util.Args;

@NotThreadSafe
/* renamed from: cz.msebera.android.httpclient.client.methods.RequestBuilder */
public class RequestBuilder {
    private RequestConfig config;
    private HttpEntity entity;
    private HeaderGroup headergroup;
    private String method;
    private LinkedList<NameValuePair> parameters;
    private URI uri;
    private ProtocolVersion version;

    RequestBuilder(String str) {
        this.method = str;
    }

    RequestBuilder() {
        this((String) null);
    }

    public static RequestBuilder create(String str) {
        Args.notBlank(str, "HTTP method");
        return new RequestBuilder(str);
    }

    public static RequestBuilder get() {
        return new RequestBuilder("GET");
    }

    public static RequestBuilder head() {
        return new RequestBuilder("HEAD");
    }

    public static RequestBuilder post() {
        return new RequestBuilder("POST");
    }

    public static RequestBuilder put() {
        return new RequestBuilder("PUT");
    }

    public static RequestBuilder delete() {
        return new RequestBuilder("DELETE");
    }

    public static RequestBuilder trace() {
        return new RequestBuilder("TRACE");
    }

    public static RequestBuilder options() {
        return new RequestBuilder("OPTIONS");
    }

    public static RequestBuilder copy(HttpRequest httpRequest) {
        Args.notNull(httpRequest, "HTTP request");
        return new RequestBuilder().doCopy(httpRequest);
    }

    private RequestBuilder doCopy(HttpRequest httpRequest) {
        if (httpRequest == null) {
            return this;
        }
        this.method = httpRequest.getRequestLine().getMethod();
        this.version = httpRequest.getRequestLine().getProtocolVersion();
        if (httpRequest instanceof HttpUriRequest) {
            this.uri = ((HttpUriRequest) httpRequest).getURI();
        } else {
            this.uri = URI.create(httpRequest.getRequestLine().getUri());
        }
        if (this.headergroup == null) {
            this.headergroup = new HeaderGroup();
        }
        this.headergroup.clear();
        this.headergroup.setHeaders(httpRequest.getAllHeaders());
        if (httpRequest instanceof HttpEntityEnclosingRequest) {
            this.entity = ((HttpEntityEnclosingRequest) httpRequest).getEntity();
        } else {
            this.entity = null;
        }
        if (httpRequest instanceof Configurable) {
            this.config = ((Configurable) httpRequest).getConfig();
        } else {
            this.config = null;
        }
        this.parameters = null;
        return this;
    }

    public String getMethod() {
        return this.method;
    }

    public ProtocolVersion getVersion() {
        return this.version;
    }

    public RequestBuilder setVersion(ProtocolVersion protocolVersion) {
        this.version = protocolVersion;
        return this;
    }

    public URI getUri() {
        return this.uri;
    }

    public RequestBuilder setUri(URI uri2) {
        this.uri = uri2;
        return this;
    }

    public RequestBuilder setUri(String str) {
        this.uri = str != null ? URI.create(str) : null;
        return this;
    }

    public Header getFirstHeader(String str) {
        HeaderGroup headerGroup = this.headergroup;
        if (headerGroup != null) {
            return headerGroup.getFirstHeader(str);
        }
        return null;
    }

    public Header getLastHeader(String str) {
        HeaderGroup headerGroup = this.headergroup;
        if (headerGroup != null) {
            return headerGroup.getLastHeader(str);
        }
        return null;
    }

    public Header[] getHeaders(String str) {
        HeaderGroup headerGroup = this.headergroup;
        if (headerGroup != null) {
            return headerGroup.getHeaders(str);
        }
        return null;
    }

    public RequestBuilder addHeader(Header header) {
        if (this.headergroup == null) {
            this.headergroup = new HeaderGroup();
        }
        this.headergroup.addHeader(header);
        return this;
    }

    public RequestBuilder addHeader(String str, String str2) {
        if (this.headergroup == null) {
            this.headergroup = new HeaderGroup();
        }
        this.headergroup.addHeader(new BasicHeader(str, str2));
        return this;
    }

    public RequestBuilder removeHeader(Header header) {
        if (this.headergroup == null) {
            this.headergroup = new HeaderGroup();
        }
        this.headergroup.removeHeader(header);
        return this;
    }

    public RequestBuilder removeHeaders(String str) {
        HeaderGroup headerGroup;
        if (!(str == null || (headerGroup = this.headergroup) == null)) {
            HeaderIterator it = headerGroup.iterator();
            while (it.hasNext()) {
                if (str.equalsIgnoreCase(it.nextHeader().getName())) {
                    it.remove();
                }
            }
        }
        return this;
    }

    public RequestBuilder setHeader(Header header) {
        if (this.headergroup == null) {
            this.headergroup = new HeaderGroup();
        }
        this.headergroup.updateHeader(header);
        return this;
    }

    public RequestBuilder setHeader(String str, String str2) {
        if (this.headergroup == null) {
            this.headergroup = new HeaderGroup();
        }
        this.headergroup.updateHeader(new BasicHeader(str, str2));
        return this;
    }

    public HttpEntity getEntity() {
        return this.entity;
    }

    public RequestBuilder setEntity(HttpEntity httpEntity) {
        this.entity = httpEntity;
        return this;
    }

    public List<NameValuePair> getParameters() {
        LinkedList<NameValuePair> linkedList = this.parameters;
        return linkedList != null ? new ArrayList(linkedList) : new ArrayList();
    }

    public RequestBuilder addParameter(NameValuePair nameValuePair) {
        Args.notNull(nameValuePair, "Name value pair");
        if (this.parameters == null) {
            this.parameters = new LinkedList<>();
        }
        this.parameters.add(nameValuePair);
        return this;
    }

    public RequestBuilder addParameter(String str, String str2) {
        return addParameter(new BasicNameValuePair(str, str2));
    }

    public RequestBuilder addParameters(NameValuePair... nameValuePairArr) {
        for (NameValuePair addParameter : nameValuePairArr) {
            addParameter(addParameter);
        }
        return this;
    }

    public RequestConfig getConfig() {
        return this.config;
    }

    public RequestBuilder setConfig(RequestConfig requestConfig) {
        this.config = requestConfig;
        return this;
    }

    public HttpUriRequest build() {
        HttpRequestBase httpRequestBase;
        URI uri2 = this.uri;
        if (uri2 == null) {
            uri2 = URI.create("/");
        }
        HttpEntity httpEntity = this.entity;
        LinkedList<NameValuePair> linkedList = this.parameters;
        if (linkedList != null && !linkedList.isEmpty()) {
            if (httpEntity != null || (!"POST".equalsIgnoreCase(this.method) && !"PUT".equalsIgnoreCase(this.method))) {
                try {
                    uri2 = new URIBuilder(uri2).addParameters(this.parameters).build();
                } catch (URISyntaxException unused) {
                }
            } else {
                httpEntity = new UrlEncodedFormEntity((Iterable<? extends NameValuePair>) this.parameters, HTTP.DEF_CONTENT_CHARSET);
            }
        }
        if (httpEntity == null) {
            httpRequestBase = new InternalRequest(this.method);
        } else {
            InternalEntityEclosingRequest internalEntityEclosingRequest = new InternalEntityEclosingRequest(this.method);
            internalEntityEclosingRequest.setEntity(httpEntity);
            httpRequestBase = internalEntityEclosingRequest;
        }
        httpRequestBase.setProtocolVersion(this.version);
        httpRequestBase.setURI(uri2);
        HeaderGroup headerGroup = this.headergroup;
        if (headerGroup != null) {
            httpRequestBase.setHeaders(headerGroup.getAllHeaders());
        }
        httpRequestBase.setConfig(this.config);
        return httpRequestBase;
    }

    /* renamed from: cz.msebera.android.httpclient.client.methods.RequestBuilder$InternalRequest */
    static class InternalRequest extends HttpRequestBase {
        private final String method;

        InternalRequest(String str) {
            this.method = str;
        }

        public String getMethod() {
            return this.method;
        }
    }

    /* renamed from: cz.msebera.android.httpclient.client.methods.RequestBuilder$InternalEntityEclosingRequest */
    static class InternalEntityEclosingRequest extends HttpEntityEnclosingRequestBase {
        private final String method;

        InternalEntityEclosingRequest(String str) {
            this.method = str;
        }

        public String getMethod() {
            return this.method;
        }
    }
}
