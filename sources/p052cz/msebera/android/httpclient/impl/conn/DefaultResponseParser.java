package p052cz.msebera.android.httpclient.impl.conn;

import java.io.IOException;
import p052cz.msebera.android.httpclient.HttpException;
import p052cz.msebera.android.httpclient.HttpMessage;
import p052cz.msebera.android.httpclient.HttpResponseFactory;
import p052cz.msebera.android.httpclient.NoHttpResponseException;
import p052cz.msebera.android.httpclient.ProtocolException;
import p052cz.msebera.android.httpclient.annotation.ThreadSafe;
import p052cz.msebera.android.httpclient.conn.params.ConnConnectionPNames;
import p052cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import p052cz.msebera.android.httpclient.impl.p053io.AbstractMessageParser;
import p052cz.msebera.android.httpclient.message.LineParser;
import p052cz.msebera.android.httpclient.message.ParserCursor;
import p052cz.msebera.android.httpclient.p054io.SessionInputBuffer;
import p052cz.msebera.android.httpclient.params.HttpParams;
import p052cz.msebera.android.httpclient.protocol.HttpContext;
import p052cz.msebera.android.httpclient.util.Args;
import p052cz.msebera.android.httpclient.util.CharArrayBuffer;

@ThreadSafe
@Deprecated
/* renamed from: cz.msebera.android.httpclient.impl.conn.DefaultResponseParser */
public class DefaultResponseParser extends AbstractMessageParser<HttpMessage> {
    private final CharArrayBuffer lineBuf;
    public HttpClientAndroidLog log = new HttpClientAndroidLog(getClass());
    private final int maxGarbageLines;
    private final HttpResponseFactory responseFactory;

    public DefaultResponseParser(SessionInputBuffer sessionInputBuffer, LineParser lineParser, HttpResponseFactory httpResponseFactory, HttpParams httpParams) {
        super(sessionInputBuffer, lineParser, httpParams);
        Args.notNull(httpResponseFactory, "Response factory");
        this.responseFactory = httpResponseFactory;
        this.lineBuf = new CharArrayBuffer(128);
        this.maxGarbageLines = getMaxGarbageLines(httpParams);
    }

    /* access modifiers changed from: protected */
    public int getMaxGarbageLines(HttpParams httpParams) {
        return httpParams.getIntParameter(ConnConnectionPNames.MAX_STATUS_LINE_GARBAGE, Integer.MAX_VALUE);
    }

    /* access modifiers changed from: protected */
    public HttpMessage parseHead(SessionInputBuffer sessionInputBuffer) throws IOException, HttpException {
        int i = 0;
        while (true) {
            this.lineBuf.clear();
            int readLine = sessionInputBuffer.readLine(this.lineBuf);
            if (readLine == -1 && i == 0) {
                throw new NoHttpResponseException("The target server failed to respond");
            }
            ParserCursor parserCursor = new ParserCursor(0, this.lineBuf.length());
            if (this.lineParser.hasProtocolVersion(this.lineBuf, parserCursor)) {
                return this.responseFactory.newHttpResponse(this.lineParser.parseStatusLine(this.lineBuf, parserCursor), (HttpContext) null);
            } else if (readLine != -1 && i < this.maxGarbageLines) {
                if (this.log.isDebugEnabled()) {
                    HttpClientAndroidLog httpClientAndroidLog = this.log;
                    httpClientAndroidLog.debug("Garbage in response: " + this.lineBuf.toString());
                }
                i++;
            }
        }
        throw new ProtocolException("The server failed to respond with a valid HTTP response");
    }
}
