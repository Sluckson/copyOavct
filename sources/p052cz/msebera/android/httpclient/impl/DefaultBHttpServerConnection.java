package p052cz.msebera.android.httpclient.impl;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import p052cz.msebera.android.httpclient.HttpEntity;
import p052cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import p052cz.msebera.android.httpclient.HttpException;
import p052cz.msebera.android.httpclient.HttpRequest;
import p052cz.msebera.android.httpclient.HttpResponse;
import p052cz.msebera.android.httpclient.HttpServerConnection;
import p052cz.msebera.android.httpclient.annotation.NotThreadSafe;
import p052cz.msebera.android.httpclient.config.MessageConstraints;
import p052cz.msebera.android.httpclient.entity.ContentLengthStrategy;
import p052cz.msebera.android.httpclient.impl.entity.DisallowIdentityContentLengthStrategy;
import p052cz.msebera.android.httpclient.impl.p053io.DefaultHttpRequestParserFactory;
import p052cz.msebera.android.httpclient.impl.p053io.DefaultHttpResponseWriterFactory;
import p052cz.msebera.android.httpclient.p054io.HttpMessageParser;
import p052cz.msebera.android.httpclient.p054io.HttpMessageParserFactory;
import p052cz.msebera.android.httpclient.p054io.HttpMessageWriter;
import p052cz.msebera.android.httpclient.p054io.HttpMessageWriterFactory;
import p052cz.msebera.android.httpclient.util.Args;

@NotThreadSafe
/* renamed from: cz.msebera.android.httpclient.impl.DefaultBHttpServerConnection */
public class DefaultBHttpServerConnection extends BHttpConnectionBase implements HttpServerConnection {
    private final HttpMessageParser<HttpRequest> requestParser;
    private final HttpMessageWriter<HttpResponse> responseWriter;

    /* access modifiers changed from: protected */
    public void onRequestReceived(HttpRequest httpRequest) {
    }

    /* access modifiers changed from: protected */
    public void onResponseSubmitted(HttpResponse httpResponse) {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DefaultBHttpServerConnection(int i, int i2, CharsetDecoder charsetDecoder, CharsetEncoder charsetEncoder, MessageConstraints messageConstraints, ContentLengthStrategy contentLengthStrategy, ContentLengthStrategy contentLengthStrategy2, HttpMessageParserFactory<HttpRequest> httpMessageParserFactory, HttpMessageWriterFactory<HttpResponse> httpMessageWriterFactory) {
        super(i, i2, charsetDecoder, charsetEncoder, messageConstraints, contentLengthStrategy != null ? contentLengthStrategy : DisallowIdentityContentLengthStrategy.INSTANCE, contentLengthStrategy2);
        HttpMessageParserFactory<HttpRequest> httpMessageParserFactory2;
        HttpMessageWriterFactory<HttpResponse> httpMessageWriterFactory2;
        if (httpMessageParserFactory != null) {
            httpMessageParserFactory2 = httpMessageParserFactory;
        } else {
            httpMessageParserFactory2 = DefaultHttpRequestParserFactory.INSTANCE;
        }
        MessageConstraints messageConstraints2 = messageConstraints;
        this.requestParser = httpMessageParserFactory2.create(getSessionInputBuffer(), messageConstraints);
        if (httpMessageWriterFactory != null) {
            httpMessageWriterFactory2 = httpMessageWriterFactory;
        } else {
            httpMessageWriterFactory2 = DefaultHttpResponseWriterFactory.INSTANCE;
        }
        this.responseWriter = httpMessageWriterFactory2.create(getSessionOutputBuffer());
    }

    public DefaultBHttpServerConnection(int i, CharsetDecoder charsetDecoder, CharsetEncoder charsetEncoder, MessageConstraints messageConstraints) {
        this(i, i, charsetDecoder, charsetEncoder, messageConstraints, (ContentLengthStrategy) null, (ContentLengthStrategy) null, (HttpMessageParserFactory<HttpRequest>) null, (HttpMessageWriterFactory<HttpResponse>) null);
    }

    public DefaultBHttpServerConnection(int i) {
        this(i, i, (CharsetDecoder) null, (CharsetEncoder) null, (MessageConstraints) null, (ContentLengthStrategy) null, (ContentLengthStrategy) null, (HttpMessageParserFactory<HttpRequest>) null, (HttpMessageWriterFactory<HttpResponse>) null);
    }

    public void bind(Socket socket) throws IOException {
        super.bind(socket);
    }

    public HttpRequest receiveRequestHeader() throws HttpException, IOException {
        ensureOpen();
        HttpRequest parse = this.requestParser.parse();
        onRequestReceived(parse);
        incrementRequestCount();
        return parse;
    }

    public void receiveRequestEntity(HttpEntityEnclosingRequest httpEntityEnclosingRequest) throws HttpException, IOException {
        Args.notNull(httpEntityEnclosingRequest, "HTTP request");
        ensureOpen();
        httpEntityEnclosingRequest.setEntity(prepareInput(httpEntityEnclosingRequest));
    }

    public void sendResponseHeader(HttpResponse httpResponse) throws HttpException, IOException {
        Args.notNull(httpResponse, "HTTP response");
        ensureOpen();
        this.responseWriter.write(httpResponse);
        onResponseSubmitted(httpResponse);
        if (httpResponse.getStatusLine().getStatusCode() >= 200) {
            incrementResponseCount();
        }
    }

    public void sendResponseEntity(HttpResponse httpResponse) throws HttpException, IOException {
        Args.notNull(httpResponse, "HTTP response");
        ensureOpen();
        HttpEntity entity = httpResponse.getEntity();
        if (entity != null) {
            OutputStream prepareOutput = prepareOutput(httpResponse);
            entity.writeTo(prepareOutput);
            prepareOutput.close();
        }
    }

    public void flush() throws IOException {
        ensureOpen();
        doFlush();
    }
}
