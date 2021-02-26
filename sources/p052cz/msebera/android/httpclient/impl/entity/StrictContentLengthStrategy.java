package p052cz.msebera.android.httpclient.impl.entity;

import p052cz.msebera.android.httpclient.Header;
import p052cz.msebera.android.httpclient.HttpException;
import p052cz.msebera.android.httpclient.HttpMessage;
import p052cz.msebera.android.httpclient.HttpVersion;
import p052cz.msebera.android.httpclient.ProtocolException;
import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.entity.ContentLengthStrategy;
import p052cz.msebera.android.httpclient.protocol.HTTP;
import p052cz.msebera.android.httpclient.util.Args;

@Immutable
/* renamed from: cz.msebera.android.httpclient.impl.entity.StrictContentLengthStrategy */
public class StrictContentLengthStrategy implements ContentLengthStrategy {
    public static final StrictContentLengthStrategy INSTANCE = new StrictContentLengthStrategy();
    private final int implicitLen;

    public StrictContentLengthStrategy(int i) {
        this.implicitLen = i;
    }

    public StrictContentLengthStrategy() {
        this(-1);
    }

    public long determineLength(HttpMessage httpMessage) throws HttpException {
        Args.notNull(httpMessage, "HTTP message");
        Header firstHeader = httpMessage.getFirstHeader("Transfer-Encoding");
        if (firstHeader != null) {
            String value = firstHeader.getValue();
            if (HTTP.CHUNK_CODING.equalsIgnoreCase(value)) {
                if (!httpMessage.getProtocolVersion().lessEquals(HttpVersion.HTTP_1_0)) {
                    return -2;
                }
                throw new ProtocolException("Chunked transfer encoding not allowed for " + httpMessage.getProtocolVersion());
            } else if (HTTP.IDENTITY_CODING.equalsIgnoreCase(value)) {
                return -1;
            } else {
                throw new ProtocolException("Unsupported transfer encoding: " + value);
            }
        } else {
            Header firstHeader2 = httpMessage.getFirstHeader("Content-Length");
            if (firstHeader2 == null) {
                return (long) this.implicitLen;
            }
            String value2 = firstHeader2.getValue();
            try {
                long parseLong = Long.parseLong(value2);
                if (parseLong >= 0) {
                    return parseLong;
                }
                throw new ProtocolException("Negative content length: " + value2);
            } catch (NumberFormatException unused) {
                throw new ProtocolException("Invalid content length: " + value2);
            }
        }
    }
}
