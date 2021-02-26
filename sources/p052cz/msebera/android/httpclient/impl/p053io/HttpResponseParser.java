package p052cz.msebera.android.httpclient.impl.p053io;

import java.io.IOException;
import p052cz.msebera.android.httpclient.HttpException;
import p052cz.msebera.android.httpclient.HttpMessage;
import p052cz.msebera.android.httpclient.HttpResponseFactory;
import p052cz.msebera.android.httpclient.NoHttpResponseException;
import p052cz.msebera.android.httpclient.ParseException;
import p052cz.msebera.android.httpclient.annotation.NotThreadSafe;
import p052cz.msebera.android.httpclient.message.LineParser;
import p052cz.msebera.android.httpclient.message.ParserCursor;
import p052cz.msebera.android.httpclient.p054io.SessionInputBuffer;
import p052cz.msebera.android.httpclient.params.HttpParams;
import p052cz.msebera.android.httpclient.protocol.HttpContext;
import p052cz.msebera.android.httpclient.util.Args;
import p052cz.msebera.android.httpclient.util.CharArrayBuffer;

@NotThreadSafe
@Deprecated
/* renamed from: cz.msebera.android.httpclient.impl.io.HttpResponseParser */
public class HttpResponseParser extends AbstractMessageParser<HttpMessage> {
    private final CharArrayBuffer lineBuf = new CharArrayBuffer(128);
    private final HttpResponseFactory responseFactory;

    public HttpResponseParser(SessionInputBuffer sessionInputBuffer, LineParser lineParser, HttpResponseFactory httpResponseFactory, HttpParams httpParams) {
        super(sessionInputBuffer, lineParser, httpParams);
        this.responseFactory = (HttpResponseFactory) Args.notNull(httpResponseFactory, "Response factory");
    }

    /* access modifiers changed from: protected */
    public HttpMessage parseHead(SessionInputBuffer sessionInputBuffer) throws IOException, HttpException, ParseException {
        this.lineBuf.clear();
        if (sessionInputBuffer.readLine(this.lineBuf) != -1) {
            return this.responseFactory.newHttpResponse(this.lineParser.parseStatusLine(this.lineBuf, new ParserCursor(0, this.lineBuf.length())), (HttpContext) null);
        }
        throw new NoHttpResponseException("The target server failed to respond");
    }
}
