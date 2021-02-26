package p052cz.msebera.android.httpclient.impl;

import java.io.IOException;
import p052cz.msebera.android.httpclient.HttpConnectionMetrics;
import p052cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import p052cz.msebera.android.httpclient.HttpException;
import p052cz.msebera.android.httpclient.HttpRequest;
import p052cz.msebera.android.httpclient.HttpRequestFactory;
import p052cz.msebera.android.httpclient.HttpResponse;
import p052cz.msebera.android.httpclient.HttpServerConnection;
import p052cz.msebera.android.httpclient.annotation.NotThreadSafe;
import p052cz.msebera.android.httpclient.impl.entity.DisallowIdentityContentLengthStrategy;
import p052cz.msebera.android.httpclient.impl.entity.EntityDeserializer;
import p052cz.msebera.android.httpclient.impl.entity.EntitySerializer;
import p052cz.msebera.android.httpclient.impl.entity.LaxContentLengthStrategy;
import p052cz.msebera.android.httpclient.impl.entity.StrictContentLengthStrategy;
import p052cz.msebera.android.httpclient.impl.p053io.DefaultHttpRequestParser;
import p052cz.msebera.android.httpclient.impl.p053io.HttpResponseWriter;
import p052cz.msebera.android.httpclient.message.LineFormatter;
import p052cz.msebera.android.httpclient.message.LineParser;
import p052cz.msebera.android.httpclient.p054io.EofSensor;
import p052cz.msebera.android.httpclient.p054io.HttpMessageParser;
import p052cz.msebera.android.httpclient.p054io.HttpMessageWriter;
import p052cz.msebera.android.httpclient.p054io.HttpTransportMetrics;
import p052cz.msebera.android.httpclient.p054io.SessionInputBuffer;
import p052cz.msebera.android.httpclient.p054io.SessionOutputBuffer;
import p052cz.msebera.android.httpclient.params.HttpParams;
import p052cz.msebera.android.httpclient.util.Args;

@NotThreadSafe
@Deprecated
/* renamed from: cz.msebera.android.httpclient.impl.AbstractHttpServerConnection */
public abstract class AbstractHttpServerConnection implements HttpServerConnection {
    private final EntityDeserializer entitydeserializer = createEntityDeserializer();
    private final EntitySerializer entityserializer = createEntitySerializer();
    private EofSensor eofSensor = null;
    private SessionInputBuffer inbuffer = null;
    private HttpConnectionMetricsImpl metrics = null;
    private SessionOutputBuffer outbuffer = null;
    private HttpMessageParser<HttpRequest> requestParser = null;
    private HttpMessageWriter<HttpResponse> responseWriter = null;

    /* access modifiers changed from: protected */
    public abstract void assertOpen() throws IllegalStateException;

    /* access modifiers changed from: protected */
    public EntityDeserializer createEntityDeserializer() {
        return new EntityDeserializer(new DisallowIdentityContentLengthStrategy(new LaxContentLengthStrategy(0)));
    }

    /* access modifiers changed from: protected */
    public EntitySerializer createEntitySerializer() {
        return new EntitySerializer(new StrictContentLengthStrategy());
    }

    /* access modifiers changed from: protected */
    public HttpRequestFactory createHttpRequestFactory() {
        return DefaultHttpRequestFactory.INSTANCE;
    }

    /* access modifiers changed from: protected */
    public HttpMessageParser<HttpRequest> createRequestParser(SessionInputBuffer sessionInputBuffer, HttpRequestFactory httpRequestFactory, HttpParams httpParams) {
        return new DefaultHttpRequestParser(sessionInputBuffer, (LineParser) null, httpRequestFactory, httpParams);
    }

    /* access modifiers changed from: protected */
    public HttpMessageWriter<HttpResponse> createResponseWriter(SessionOutputBuffer sessionOutputBuffer, HttpParams httpParams) {
        return new HttpResponseWriter(sessionOutputBuffer, (LineFormatter) null, httpParams);
    }

    /* access modifiers changed from: protected */
    public HttpConnectionMetricsImpl createConnectionMetrics(HttpTransportMetrics httpTransportMetrics, HttpTransportMetrics httpTransportMetrics2) {
        return new HttpConnectionMetricsImpl(httpTransportMetrics, httpTransportMetrics2);
    }

    /* access modifiers changed from: protected */
    public void init(SessionInputBuffer sessionInputBuffer, SessionOutputBuffer sessionOutputBuffer, HttpParams httpParams) {
        this.inbuffer = (SessionInputBuffer) Args.notNull(sessionInputBuffer, "Input session buffer");
        this.outbuffer = (SessionOutputBuffer) Args.notNull(sessionOutputBuffer, "Output session buffer");
        if (sessionInputBuffer instanceof EofSensor) {
            this.eofSensor = (EofSensor) sessionInputBuffer;
        }
        this.requestParser = createRequestParser(sessionInputBuffer, createHttpRequestFactory(), httpParams);
        this.responseWriter = createResponseWriter(sessionOutputBuffer, httpParams);
        this.metrics = createConnectionMetrics(sessionInputBuffer.getMetrics(), sessionOutputBuffer.getMetrics());
    }

    public HttpRequest receiveRequestHeader() throws HttpException, IOException {
        assertOpen();
        HttpRequest parse = this.requestParser.parse();
        this.metrics.incrementRequestCount();
        return parse;
    }

    public void receiveRequestEntity(HttpEntityEnclosingRequest httpEntityEnclosingRequest) throws HttpException, IOException {
        Args.notNull(httpEntityEnclosingRequest, "HTTP request");
        assertOpen();
        httpEntityEnclosingRequest.setEntity(this.entitydeserializer.deserialize(this.inbuffer, httpEntityEnclosingRequest));
    }

    /* access modifiers changed from: protected */
    public void doFlush() throws IOException {
        this.outbuffer.flush();
    }

    public void flush() throws IOException {
        assertOpen();
        doFlush();
    }

    public void sendResponseHeader(HttpResponse httpResponse) throws HttpException, IOException {
        Args.notNull(httpResponse, "HTTP response");
        assertOpen();
        this.responseWriter.write(httpResponse);
        if (httpResponse.getStatusLine().getStatusCode() >= 200) {
            this.metrics.incrementResponseCount();
        }
    }

    public void sendResponseEntity(HttpResponse httpResponse) throws HttpException, IOException {
        if (httpResponse.getEntity() != null) {
            this.entityserializer.serialize(this.outbuffer, httpResponse, httpResponse.getEntity());
        }
    }

    /* access modifiers changed from: protected */
    public boolean isEof() {
        EofSensor eofSensor2 = this.eofSensor;
        return eofSensor2 != null && eofSensor2.isEof();
    }

    public boolean isStale() {
        if (!isOpen() || isEof()) {
            return true;
        }
        try {
            this.inbuffer.isDataAvailable(1);
            return isEof();
        } catch (IOException unused) {
            return true;
        }
    }

    public HttpConnectionMetrics getMetrics() {
        return this.metrics;
    }
}
