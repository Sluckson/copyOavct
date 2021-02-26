package p052cz.msebera.android.httpclient.impl.conn;

import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.util.concurrent.atomic.AtomicLong;
import p052cz.msebera.android.httpclient.HttpRequest;
import p052cz.msebera.android.httpclient.HttpResponse;
import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.config.ConnectionConfig;
import p052cz.msebera.android.httpclient.conn.HttpConnectionFactory;
import p052cz.msebera.android.httpclient.conn.ManagedHttpClientConnection;
import p052cz.msebera.android.httpclient.conn.routing.HttpRoute;
import p052cz.msebera.android.httpclient.entity.ContentLengthStrategy;
import p052cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import p052cz.msebera.android.httpclient.impl.p053io.DefaultHttpRequestWriterFactory;
import p052cz.msebera.android.httpclient.p054io.HttpMessageParserFactory;
import p052cz.msebera.android.httpclient.p054io.HttpMessageWriterFactory;

@Immutable
/* renamed from: cz.msebera.android.httpclient.impl.conn.ManagedHttpClientConnectionFactory */
public class ManagedHttpClientConnectionFactory implements HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> {
    private static final AtomicLong COUNTER = new AtomicLong();
    public static final ManagedHttpClientConnectionFactory INSTANCE = new ManagedHttpClientConnectionFactory();
    public HttpClientAndroidLog headerlog;
    public HttpClientAndroidLog log;
    private final HttpMessageWriterFactory<HttpRequest> requestWriterFactory;
    private final HttpMessageParserFactory<HttpResponse> responseParserFactory;
    public HttpClientAndroidLog wirelog;

    public ManagedHttpClientConnectionFactory(HttpMessageWriterFactory<HttpRequest> httpMessageWriterFactory, HttpMessageParserFactory<HttpResponse> httpMessageParserFactory) {
        this.log = new HttpClientAndroidLog(DefaultManagedHttpClientConnection.class);
        this.headerlog = new HttpClientAndroidLog("cz.msebera.android.httpclient.headers");
        this.wirelog = new HttpClientAndroidLog("cz.msebera.android.httpclient.wire");
        this.requestWriterFactory = httpMessageWriterFactory == null ? DefaultHttpRequestWriterFactory.INSTANCE : httpMessageWriterFactory;
        this.responseParserFactory = httpMessageParserFactory == null ? DefaultHttpResponseParserFactory.INSTANCE : httpMessageParserFactory;
    }

    public ManagedHttpClientConnectionFactory(HttpMessageParserFactory<HttpResponse> httpMessageParserFactory) {
        this((HttpMessageWriterFactory<HttpRequest>) null, httpMessageParserFactory);
    }

    public ManagedHttpClientConnectionFactory() {
        this((HttpMessageWriterFactory<HttpRequest>) null, (HttpMessageParserFactory<HttpResponse>) null);
    }

    public ManagedHttpClientConnection create(HttpRoute httpRoute, ConnectionConfig connectionConfig) {
        CharsetEncoder charsetEncoder;
        CharsetDecoder charsetDecoder;
        ConnectionConfig connectionConfig2 = connectionConfig != null ? connectionConfig : ConnectionConfig.DEFAULT;
        Charset charset = connectionConfig2.getCharset();
        CodingErrorAction malformedInputAction = connectionConfig2.getMalformedInputAction() != null ? connectionConfig2.getMalformedInputAction() : CodingErrorAction.REPORT;
        CodingErrorAction unmappableInputAction = connectionConfig2.getUnmappableInputAction() != null ? connectionConfig2.getUnmappableInputAction() : CodingErrorAction.REPORT;
        if (charset != null) {
            CharsetDecoder newDecoder = charset.newDecoder();
            newDecoder.onMalformedInput(malformedInputAction);
            newDecoder.onUnmappableCharacter(unmappableInputAction);
            CharsetEncoder newEncoder = charset.newEncoder();
            newEncoder.onMalformedInput(malformedInputAction);
            newEncoder.onUnmappableCharacter(unmappableInputAction);
            charsetEncoder = newEncoder;
            charsetDecoder = newDecoder;
        } else {
            charsetDecoder = null;
            charsetEncoder = null;
        }
        return new LoggingManagedHttpClientConnection("http-outgoing-" + Long.toString(COUNTER.getAndIncrement()), this.log, this.headerlog, this.wirelog, connectionConfig2.getBufferSize(), connectionConfig2.getFragmentSizeHint(), charsetDecoder, charsetEncoder, connectionConfig2.getMessageConstraints(), (ContentLengthStrategy) null, (ContentLengthStrategy) null, this.requestWriterFactory, this.responseParserFactory);
    }
}
