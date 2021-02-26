package p052cz.msebera.android.httpclient.impl.conn;

import p052cz.msebera.android.httpclient.HttpResponse;
import p052cz.msebera.android.httpclient.HttpResponseFactory;
import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.config.MessageConstraints;
import p052cz.msebera.android.httpclient.impl.DefaultHttpResponseFactory;
import p052cz.msebera.android.httpclient.message.BasicLineParser;
import p052cz.msebera.android.httpclient.message.LineParser;
import p052cz.msebera.android.httpclient.p054io.HttpMessageParser;
import p052cz.msebera.android.httpclient.p054io.HttpMessageParserFactory;
import p052cz.msebera.android.httpclient.p054io.SessionInputBuffer;

@Immutable
/* renamed from: cz.msebera.android.httpclient.impl.conn.DefaultHttpResponseParserFactory */
public class DefaultHttpResponseParserFactory implements HttpMessageParserFactory<HttpResponse> {
    public static final DefaultHttpResponseParserFactory INSTANCE = new DefaultHttpResponseParserFactory();
    private final LineParser lineParser;
    private final HttpResponseFactory responseFactory;

    public DefaultHttpResponseParserFactory(LineParser lineParser2, HttpResponseFactory httpResponseFactory) {
        this.lineParser = lineParser2 == null ? BasicLineParser.INSTANCE : lineParser2;
        this.responseFactory = httpResponseFactory == null ? DefaultHttpResponseFactory.INSTANCE : httpResponseFactory;
    }

    public DefaultHttpResponseParserFactory(HttpResponseFactory httpResponseFactory) {
        this((LineParser) null, httpResponseFactory);
    }

    public DefaultHttpResponseParserFactory() {
        this((LineParser) null, (HttpResponseFactory) null);
    }

    public HttpMessageParser<HttpResponse> create(SessionInputBuffer sessionInputBuffer, MessageConstraints messageConstraints) {
        return new DefaultHttpResponseParser(sessionInputBuffer, this.lineParser, this.responseFactory, messageConstraints);
    }
}
