package p052cz.msebera.android.httpclient.message;

import p052cz.msebera.android.httpclient.Header;
import p052cz.msebera.android.httpclient.ProtocolVersion;
import p052cz.msebera.android.httpclient.RequestLine;
import p052cz.msebera.android.httpclient.StatusLine;
import p052cz.msebera.android.httpclient.util.CharArrayBuffer;

/* renamed from: cz.msebera.android.httpclient.message.LineFormatter */
public interface LineFormatter {
    CharArrayBuffer appendProtocolVersion(CharArrayBuffer charArrayBuffer, ProtocolVersion protocolVersion);

    CharArrayBuffer formatHeader(CharArrayBuffer charArrayBuffer, Header header);

    CharArrayBuffer formatRequestLine(CharArrayBuffer charArrayBuffer, RequestLine requestLine);

    CharArrayBuffer formatStatusLine(CharArrayBuffer charArrayBuffer, StatusLine statusLine);
}
