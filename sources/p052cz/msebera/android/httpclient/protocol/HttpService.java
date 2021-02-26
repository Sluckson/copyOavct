package p052cz.msebera.android.httpclient.protocol;

import java.io.IOException;
import p052cz.msebera.android.httpclient.ConnectionReuseStrategy;
import p052cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import p052cz.msebera.android.httpclient.HttpException;
import p052cz.msebera.android.httpclient.HttpRequest;
import p052cz.msebera.android.httpclient.HttpResponse;
import p052cz.msebera.android.httpclient.HttpResponseFactory;
import p052cz.msebera.android.httpclient.HttpServerConnection;
import p052cz.msebera.android.httpclient.HttpStatus;
import p052cz.msebera.android.httpclient.HttpVersion;
import p052cz.msebera.android.httpclient.MethodNotSupportedException;
import p052cz.msebera.android.httpclient.ProtocolException;
import p052cz.msebera.android.httpclient.UnsupportedHttpVersionException;
import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.entity.ByteArrayEntity;
import p052cz.msebera.android.httpclient.impl.DefaultConnectionReuseStrategy;
import p052cz.msebera.android.httpclient.impl.DefaultHttpResponseFactory;
import p052cz.msebera.android.httpclient.params.HttpParams;
import p052cz.msebera.android.httpclient.util.Args;
import p052cz.msebera.android.httpclient.util.EncodingUtils;
import p052cz.msebera.android.httpclient.util.EntityUtils;

@Immutable
/* renamed from: cz.msebera.android.httpclient.protocol.HttpService */
public class HttpService {
    private volatile ConnectionReuseStrategy connStrategy;
    private volatile HttpExpectationVerifier expectationVerifier;
    private volatile HttpRequestHandlerMapper handlerMapper;
    private volatile HttpParams params;
    private volatile HttpProcessor processor;
    private volatile HttpResponseFactory responseFactory;

    @Deprecated
    public HttpService(HttpProcessor httpProcessor, ConnectionReuseStrategy connectionReuseStrategy, HttpResponseFactory httpResponseFactory, HttpRequestHandlerResolver httpRequestHandlerResolver, HttpExpectationVerifier httpExpectationVerifier, HttpParams httpParams) {
        this(httpProcessor, connectionReuseStrategy, httpResponseFactory, (HttpRequestHandlerMapper) new HttpRequestHandlerResolverAdapter(httpRequestHandlerResolver), httpExpectationVerifier);
        this.params = httpParams;
    }

    @Deprecated
    public HttpService(HttpProcessor httpProcessor, ConnectionReuseStrategy connectionReuseStrategy, HttpResponseFactory httpResponseFactory, HttpRequestHandlerResolver httpRequestHandlerResolver, HttpParams httpParams) {
        this(httpProcessor, connectionReuseStrategy, httpResponseFactory, (HttpRequestHandlerMapper) new HttpRequestHandlerResolverAdapter(httpRequestHandlerResolver), (HttpExpectationVerifier) null);
        this.params = httpParams;
    }

    @Deprecated
    public HttpService(HttpProcessor httpProcessor, ConnectionReuseStrategy connectionReuseStrategy, HttpResponseFactory httpResponseFactory) {
        this.params = null;
        this.processor = null;
        this.handlerMapper = null;
        this.connStrategy = null;
        this.responseFactory = null;
        this.expectationVerifier = null;
        setHttpProcessor(httpProcessor);
        setConnReuseStrategy(connectionReuseStrategy);
        setResponseFactory(httpResponseFactory);
    }

    public HttpService(HttpProcessor httpProcessor, ConnectionReuseStrategy connectionReuseStrategy, HttpResponseFactory httpResponseFactory, HttpRequestHandlerMapper httpRequestHandlerMapper, HttpExpectationVerifier httpExpectationVerifier) {
        this.params = null;
        this.processor = null;
        this.handlerMapper = null;
        this.connStrategy = null;
        this.responseFactory = null;
        this.expectationVerifier = null;
        this.processor = (HttpProcessor) Args.notNull(httpProcessor, "HTTP processor");
        this.connStrategy = connectionReuseStrategy == null ? DefaultConnectionReuseStrategy.INSTANCE : connectionReuseStrategy;
        this.responseFactory = httpResponseFactory == null ? DefaultHttpResponseFactory.INSTANCE : httpResponseFactory;
        this.handlerMapper = httpRequestHandlerMapper;
        this.expectationVerifier = httpExpectationVerifier;
    }

    public HttpService(HttpProcessor httpProcessor, ConnectionReuseStrategy connectionReuseStrategy, HttpResponseFactory httpResponseFactory, HttpRequestHandlerMapper httpRequestHandlerMapper) {
        this(httpProcessor, connectionReuseStrategy, httpResponseFactory, httpRequestHandlerMapper, (HttpExpectationVerifier) null);
    }

    public HttpService(HttpProcessor httpProcessor, HttpRequestHandlerMapper httpRequestHandlerMapper) {
        this(httpProcessor, (ConnectionReuseStrategy) null, (HttpResponseFactory) null, httpRequestHandlerMapper, (HttpExpectationVerifier) null);
    }

    @Deprecated
    public void setHttpProcessor(HttpProcessor httpProcessor) {
        Args.notNull(httpProcessor, "HTTP processor");
        this.processor = httpProcessor;
    }

    @Deprecated
    public void setConnReuseStrategy(ConnectionReuseStrategy connectionReuseStrategy) {
        Args.notNull(connectionReuseStrategy, "Connection reuse strategy");
        this.connStrategy = connectionReuseStrategy;
    }

    @Deprecated
    public void setResponseFactory(HttpResponseFactory httpResponseFactory) {
        Args.notNull(httpResponseFactory, "Response factory");
        this.responseFactory = httpResponseFactory;
    }

    @Deprecated
    public void setParams(HttpParams httpParams) {
        this.params = httpParams;
    }

    @Deprecated
    public void setHandlerResolver(HttpRequestHandlerResolver httpRequestHandlerResolver) {
        this.handlerMapper = new HttpRequestHandlerResolverAdapter(httpRequestHandlerResolver);
    }

    @Deprecated
    public void setExpectationVerifier(HttpExpectationVerifier httpExpectationVerifier) {
        this.expectationVerifier = httpExpectationVerifier;
    }

    @Deprecated
    public HttpParams getParams() {
        return this.params;
    }

    public void handleRequest(HttpServerConnection httpServerConnection, HttpContext httpContext) throws IOException, HttpException {
        HttpResponse httpResponse;
        httpContext.setAttribute("http.connection", httpServerConnection);
        try {
            HttpRequest receiveRequestHeader = httpServerConnection.receiveRequestHeader();
            httpResponse = null;
            if (receiveRequestHeader instanceof HttpEntityEnclosingRequest) {
                if (((HttpEntityEnclosingRequest) receiveRequestHeader).expectContinue()) {
                    HttpResponse newHttpResponse = this.responseFactory.newHttpResponse(HttpVersion.HTTP_1_1, 100, httpContext);
                    if (this.expectationVerifier != null) {
                        try {
                            this.expectationVerifier.verify(receiveRequestHeader, newHttpResponse, httpContext);
                        } catch (HttpException e) {
                            HttpResponse newHttpResponse2 = this.responseFactory.newHttpResponse(HttpVersion.HTTP_1_0, 500, httpContext);
                            handleException(e, newHttpResponse2);
                            newHttpResponse = newHttpResponse2;
                        }
                    }
                    if (newHttpResponse.getStatusLine().getStatusCode() < 200) {
                        httpServerConnection.sendResponseHeader(newHttpResponse);
                        httpServerConnection.flush();
                        httpServerConnection.receiveRequestEntity((HttpEntityEnclosingRequest) receiveRequestHeader);
                    } else {
                        httpResponse = newHttpResponse;
                    }
                } else {
                    httpServerConnection.receiveRequestEntity((HttpEntityEnclosingRequest) receiveRequestHeader);
                }
            }
            httpContext.setAttribute("http.request", receiveRequestHeader);
            if (httpResponse == null) {
                httpResponse = this.responseFactory.newHttpResponse(HttpVersion.HTTP_1_1, 200, httpContext);
                this.processor.process(receiveRequestHeader, httpContext);
                doService(receiveRequestHeader, httpResponse, httpContext);
            }
            if (receiveRequestHeader instanceof HttpEntityEnclosingRequest) {
                EntityUtils.consume(((HttpEntityEnclosingRequest) receiveRequestHeader).getEntity());
            }
        } catch (HttpException e2) {
            httpResponse = this.responseFactory.newHttpResponse(HttpVersion.HTTP_1_0, 500, httpContext);
            handleException(e2, httpResponse);
        }
        httpContext.setAttribute("http.response", httpResponse);
        this.processor.process(httpResponse, httpContext);
        httpServerConnection.sendResponseHeader(httpResponse);
        httpServerConnection.sendResponseEntity(httpResponse);
        httpServerConnection.flush();
        if (!this.connStrategy.keepAlive(httpResponse, httpContext)) {
            httpServerConnection.close();
        }
    }

    /* access modifiers changed from: protected */
    public void handleException(HttpException httpException, HttpResponse httpResponse) {
        if (httpException instanceof MethodNotSupportedException) {
            httpResponse.setStatusCode(HttpStatus.SC_NOT_IMPLEMENTED);
        } else if (httpException instanceof UnsupportedHttpVersionException) {
            httpResponse.setStatusCode(505);
        } else if (httpException instanceof ProtocolException) {
            httpResponse.setStatusCode(400);
        } else {
            httpResponse.setStatusCode(500);
        }
        String message = httpException.getMessage();
        if (message == null) {
            message = httpException.toString();
        }
        ByteArrayEntity byteArrayEntity = new ByteArrayEntity(EncodingUtils.getAsciiBytes(message));
        byteArrayEntity.setContentType("text/plain; charset=US-ASCII");
        httpResponse.setEntity(byteArrayEntity);
    }

    /* access modifiers changed from: protected */
    public void doService(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) throws HttpException, IOException {
        HttpRequestHandler lookup = this.handlerMapper != null ? this.handlerMapper.lookup(httpRequest) : null;
        if (lookup != null) {
            lookup.handle(httpRequest, httpResponse, httpContext);
        } else {
            httpResponse.setStatusCode(HttpStatus.SC_NOT_IMPLEMENTED);
        }
    }

    @Deprecated
    /* renamed from: cz.msebera.android.httpclient.protocol.HttpService$HttpRequestHandlerResolverAdapter */
    private static class HttpRequestHandlerResolverAdapter implements HttpRequestHandlerMapper {
        private final HttpRequestHandlerResolver resolver;

        public HttpRequestHandlerResolverAdapter(HttpRequestHandlerResolver httpRequestHandlerResolver) {
            this.resolver = httpRequestHandlerResolver;
        }

        public HttpRequestHandler lookup(HttpRequest httpRequest) {
            return this.resolver.lookup(httpRequest.getRequestLine().getUri());
        }
    }
}
