package p052cz.msebera.android.httpclient.impl;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import p052cz.msebera.android.httpclient.HttpClientConnection;
import p052cz.msebera.android.httpclient.HttpEntity;
import p052cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import p052cz.msebera.android.httpclient.HttpException;
import p052cz.msebera.android.httpclient.HttpRequest;
import p052cz.msebera.android.httpclient.HttpResponse;
import p052cz.msebera.android.httpclient.annotation.NotThreadSafe;
import p052cz.msebera.android.httpclient.config.MessageConstraints;
import p052cz.msebera.android.httpclient.entity.ContentLengthStrategy;
import p052cz.msebera.android.httpclient.impl.p053io.DefaultHttpRequestWriterFactory;
import p052cz.msebera.android.httpclient.impl.p053io.DefaultHttpResponseParserFactory;
import p052cz.msebera.android.httpclient.p054io.HttpMessageParser;
import p052cz.msebera.android.httpclient.p054io.HttpMessageParserFactory;
import p052cz.msebera.android.httpclient.p054io.HttpMessageWriter;
import p052cz.msebera.android.httpclient.p054io.HttpMessageWriterFactory;
import p052cz.msebera.android.httpclient.util.Args;

@NotThreadSafe
/* renamed from: cz.msebera.android.httpclient.impl.DefaultBHttpClientConnection */
public class DefaultBHttpClientConnection extends BHttpConnectionBase implements HttpClientConnection {
    private final HttpMessageWriter<HttpRequest> requestWriter;
    private final HttpMessageParser<HttpResponse> responseParser;

    /* access modifiers changed from: protected */
    public void onRequestSubmitted(HttpRequest httpRequest) {
    }

    /* access modifiers changed from: protected */
    public void onResponseReceived(HttpResponse httpResponse) {
    }

    public DefaultBHttpClientConnection(int i, int i2, CharsetDecoder charsetDecoder, CharsetEncoder charsetEncoder, MessageConstraints messageConstraints, ContentLengthStrategy contentLengthStrategy, ContentLengthStrategy contentLengthStrategy2, HttpMessageWriterFactory<HttpRequest> httpMessageWriterFactory, HttpMessageParserFactory<HttpResponse> httpMessageParserFactory) {
        super(i, i2, charsetDecoder, charsetEncoder, messageConstraints, contentLengthStrategy, contentLengthStrategy2);
        this.requestWriter = (httpMessageWriterFactory == null ? DefaultHttpRequestWriterFactory.INSTANCE : httpMessageWriterFactory).create(getSessionOutputBuffer());
        this.responseParser = (httpMessageParserFactory == null ? DefaultHttpResponseParserFactory.INSTANCE : httpMessageParserFactory).create(getSessionInputBuffer(), messageConstraints);
    }

    public DefaultBHttpClientConnection(int i, CharsetDecoder charsetDecoder, CharsetEncoder charsetEncoder, MessageConstraints messageConstraints) {
        this(i, i, charsetDecoder, charsetEncoder, messageConstraints, (ContentLengthStrategy) null, (ContentLengthStrategy) null, (HttpMessageWriterFactory<HttpRequest>) null, (HttpMessageParserFactory<HttpResponse>) null);
    }

    public DefaultBHttpClientConnection(int i) {
        this(i, i, (CharsetDecoder) null, (CharsetEncoder) null, (MessageConstraints) null, (ContentLengthStrategy) null, (ContentLengthStrategy) null, (HttpMessageWriterFactory<HttpRequest>) null, (HttpMessageParserFactory<HttpResponse>) null);
    }

    public void bind(Socket socket) throws IOException {
        super.bind(socket);
    }

    public boolean isResponseAvailable(int i) throws IOException {
        ensureOpen();
        try {
            return awaitInput(i);
        } catch (SocketTimeoutException unused) {
            return false;
        }
    }

    public void sendRequestHeader(HttpRequest httpRequest) throws HttpException, IOException {
        Args.notNull(httpRequest, "HTTP request");
        ensureOpen();
        this.requestWriter.write(httpRequest);
        onRequestSubmitted(httpRequest);
        incrementRequestCount();
    }

    public void sendRequestEntity(HttpEntityEnclosingRequest httpEntityEnclosingRequest) throws HttpException, IOException {
        Args.notNull(httpEntityEnclosingRequest, "HTTP request");
        ensureOpen();
        HttpEntity entity = httpEntityEnclosingRequest.getEntity();
        if (entity != null) {
            OutputStream prepareOutput = prepareOutput(httpEntityEnclosingRequest);
            entity.writeTo(prepareOutput);
            prepareOutput.close();
        }
    }

    public HttpResponse receiveResponseHeader() throws HttpException, IOException {
        ensureOpen();
        HttpResponse parse = this.responseParser.parse();
        onResponseReceived(parse);
        if (parse.getStatusLine().getStatusCode() >= 200) {
            incrementResponseCount();
        }
        return parse;
    }

    public void receiveResponseEntity(HttpResponse httpResponse) throws HttpException, IOException {
        Args.notNull(httpResponse, "HTTP response");
        ensureOpen();
        httpResponse.setEntity(prepareInput(httpResponse));
    }

    public void flush() throws IOException {
        ensureOpen();
        doFlush();
    }
}
