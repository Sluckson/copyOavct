package p052cz.msebera.android.httpclient.impl.p053io;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import p052cz.msebera.android.httpclient.Header;
import p052cz.msebera.android.httpclient.HttpException;
import p052cz.msebera.android.httpclient.HttpMessage;
import p052cz.msebera.android.httpclient.MessageConstraintException;
import p052cz.msebera.android.httpclient.ParseException;
import p052cz.msebera.android.httpclient.ProtocolException;
import p052cz.msebera.android.httpclient.annotation.NotThreadSafe;
import p052cz.msebera.android.httpclient.config.MessageConstraints;
import p052cz.msebera.android.httpclient.message.BasicLineParser;
import p052cz.msebera.android.httpclient.message.LineParser;
import p052cz.msebera.android.httpclient.p054io.HttpMessageParser;
import p052cz.msebera.android.httpclient.p054io.SessionInputBuffer;
import p052cz.msebera.android.httpclient.params.HttpParamConfig;
import p052cz.msebera.android.httpclient.params.HttpParams;
import p052cz.msebera.android.httpclient.util.Args;
import p052cz.msebera.android.httpclient.util.CharArrayBuffer;

@NotThreadSafe
/* renamed from: cz.msebera.android.httpclient.impl.io.AbstractMessageParser */
public abstract class AbstractMessageParser<T extends HttpMessage> implements HttpMessageParser<T> {
    private static final int HEADERS = 1;
    private static final int HEAD_LINE = 0;
    private final List<CharArrayBuffer> headerLines;
    protected final LineParser lineParser;
    private T message;
    private final MessageConstraints messageConstraints;
    private final SessionInputBuffer sessionBuffer;
    private int state;

    /* access modifiers changed from: protected */
    public abstract T parseHead(SessionInputBuffer sessionInputBuffer) throws IOException, HttpException, ParseException;

    @Deprecated
    public AbstractMessageParser(SessionInputBuffer sessionInputBuffer, LineParser lineParser2, HttpParams httpParams) {
        Args.notNull(sessionInputBuffer, "Session input buffer");
        Args.notNull(httpParams, "HTTP parameters");
        this.sessionBuffer = sessionInputBuffer;
        this.messageConstraints = HttpParamConfig.getMessageConstraints(httpParams);
        this.lineParser = lineParser2 == null ? BasicLineParser.INSTANCE : lineParser2;
        this.headerLines = new ArrayList();
        this.state = 0;
    }

    public AbstractMessageParser(SessionInputBuffer sessionInputBuffer, LineParser lineParser2, MessageConstraints messageConstraints2) {
        this.sessionBuffer = (SessionInputBuffer) Args.notNull(sessionInputBuffer, "Session input buffer");
        this.lineParser = lineParser2 == null ? BasicLineParser.INSTANCE : lineParser2;
        this.messageConstraints = messageConstraints2 == null ? MessageConstraints.DEFAULT : messageConstraints2;
        this.headerLines = new ArrayList();
        this.state = 0;
    }

    public static Header[] parseHeaders(SessionInputBuffer sessionInputBuffer, int i, int i2, LineParser lineParser2) throws HttpException, IOException {
        ArrayList arrayList = new ArrayList();
        if (lineParser2 == null) {
            lineParser2 = BasicLineParser.INSTANCE;
        }
        return parseHeaders(sessionInputBuffer, i, i2, lineParser2, arrayList);
    }

    public static Header[] parseHeaders(SessionInputBuffer sessionInputBuffer, int i, int i2, LineParser lineParser2, List<CharArrayBuffer> list) throws HttpException, IOException {
        int i3;
        Args.notNull(sessionInputBuffer, "Session input buffer");
        Args.notNull(lineParser2, "Line parser");
        Args.notNull(list, "Header line list");
        CharArrayBuffer charArrayBuffer = null;
        CharArrayBuffer charArrayBuffer2 = null;
        while (true) {
            if (charArrayBuffer == null) {
                charArrayBuffer = new CharArrayBuffer(64);
            } else {
                charArrayBuffer.clear();
            }
            i3 = 0;
            if (sessionInputBuffer.readLine(charArrayBuffer) == -1 || charArrayBuffer.length() < 1) {
                Header[] headerArr = new Header[list.size()];
            } else {
                if ((charArrayBuffer.charAt(0) == ' ' || charArrayBuffer.charAt(0) == 9) && charArrayBuffer2 != null) {
                    while (i3 < charArrayBuffer.length() && ((r3 = charArrayBuffer.charAt(i3)) == ' ' || r3 == 9)) {
                        i3++;
                    }
                    if (i2 <= 0 || ((charArrayBuffer2.length() + 1) + charArrayBuffer.length()) - i3 <= i2) {
                        charArrayBuffer2.append(' ');
                        charArrayBuffer2.append(charArrayBuffer, i3, charArrayBuffer.length() - i3);
                    } else {
                        throw new MessageConstraintException("Maximum line length limit exceeded");
                    }
                } else {
                    list.add(charArrayBuffer);
                    charArrayBuffer2 = charArrayBuffer;
                    charArrayBuffer = null;
                }
                if (i > 0 && list.size() >= i) {
                    throw new MessageConstraintException("Maximum header count exceeded");
                }
            }
        }
        Header[] headerArr2 = new Header[list.size()];
        while (i3 < list.size()) {
            try {
                headerArr2[i3] = lineParser2.parseHeader(list.get(i3));
                i3++;
            } catch (ParseException e) {
                throw new ProtocolException(e.getMessage());
            }
        }
        return headerArr2;
    }

    public T parse() throws IOException, HttpException {
        int i = this.state;
        if (i == 0) {
            try {
                this.message = parseHead(this.sessionBuffer);
                this.state = 1;
            } catch (ParseException e) {
                throw new ProtocolException(e.getMessage(), e);
            }
        } else if (i != 1) {
            throw new IllegalStateException("Inconsistent parser state");
        }
        this.message.setHeaders(parseHeaders(this.sessionBuffer, this.messageConstraints.getMaxHeaderCount(), this.messageConstraints.getMaxLineLength(), this.lineParser, this.headerLines));
        T t = this.message;
        this.message = null;
        this.headerLines.clear();
        this.state = 0;
        return t;
    }
}
