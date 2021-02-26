package p052cz.msebera.android.httpclient.message;

import p052cz.msebera.android.httpclient.Header;
import p052cz.msebera.android.httpclient.ParseException;
import p052cz.msebera.android.httpclient.ProtocolVersion;
import p052cz.msebera.android.httpclient.RequestLine;
import p052cz.msebera.android.httpclient.StatusLine;
import p052cz.msebera.android.httpclient.util.CharArrayBuffer;

/* renamed from: cz.msebera.android.httpclient.message.LineParser */
public interface LineParser {
    boolean hasProtocolVersion(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor);

    Header parseHeader(CharArrayBuffer charArrayBuffer) throws ParseException;

    ProtocolVersion parseProtocolVersion(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) throws ParseException;

    RequestLine parseRequestLine(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) throws ParseException;

    StatusLine parseStatusLine(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) throws ParseException;
}
