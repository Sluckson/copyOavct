package p052cz.msebera.android.httpclient.impl;

import java.util.Locale;
import p052cz.msebera.android.httpclient.HttpStatus;
import p052cz.msebera.android.httpclient.ReasonPhraseCatalog;
import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.util.Args;

@Immutable
/* renamed from: cz.msebera.android.httpclient.impl.EnglishReasonPhraseCatalog */
public class EnglishReasonPhraseCatalog implements ReasonPhraseCatalog {
    public static final EnglishReasonPhraseCatalog INSTANCE = new EnglishReasonPhraseCatalog();
    private static final String[][] REASON_PHRASES = {null, new String[3], new String[8], new String[8], new String[25], new String[8]};

    static {
        setReason(200, "OK");
        setReason(201, "Created");
        setReason(202, "Accepted");
        setReason(HttpStatus.SC_NO_CONTENT, "No Content");
        setReason(301, "Moved Permanently");
        setReason(302, "Moved Temporarily");
        setReason(HttpStatus.SC_NOT_MODIFIED, "Not Modified");
        setReason(400, "Bad Request");
        setReason(401, "Unauthorized");
        setReason(HttpStatus.SC_FORBIDDEN, "Forbidden");
        setReason(HttpStatus.SC_NOT_FOUND, "Not Found");
        setReason(500, "Internal Server Error");
        setReason(HttpStatus.SC_NOT_IMPLEMENTED, "Not Implemented");
        setReason(HttpStatus.SC_BAD_GATEWAY, "Bad Gateway");
        setReason(HttpStatus.SC_SERVICE_UNAVAILABLE, "Service Unavailable");
        setReason(100, "Continue");
        setReason(307, "Temporary Redirect");
        setReason(HttpStatus.SC_METHOD_NOT_ALLOWED, "Method Not Allowed");
        setReason(HttpStatus.SC_CONFLICT, "Conflict");
        setReason(HttpStatus.SC_PRECONDITION_FAILED, "Precondition Failed");
        setReason(HttpStatus.SC_REQUEST_TOO_LONG, "Request Too Long");
        setReason(HttpStatus.SC_REQUEST_URI_TOO_LONG, "Request-URI Too Long");
        setReason(HttpStatus.SC_UNSUPPORTED_MEDIA_TYPE, "Unsupported Media Type");
        setReason(300, "Multiple Choices");
        setReason(HttpStatus.SC_SEE_OTHER, "See Other");
        setReason(305, "Use Proxy");
        setReason(402, "Payment Required");
        setReason(HttpStatus.SC_NOT_ACCEPTABLE, "Not Acceptable");
        setReason(HttpStatus.SC_PROXY_AUTHENTICATION_REQUIRED, "Proxy Authentication Required");
        setReason(HttpStatus.SC_REQUEST_TIMEOUT, "Request Timeout");
        setReason(101, "Switching Protocols");
        setReason(203, "Non Authoritative Information");
        setReason(HttpStatus.SC_RESET_CONTENT, "Reset Content");
        setReason(HttpStatus.SC_PARTIAL_CONTENT, "Partial Content");
        setReason(HttpStatus.SC_GATEWAY_TIMEOUT, "Gateway Timeout");
        setReason(505, "Http Version Not Supported");
        setReason(HttpStatus.SC_GONE, "Gone");
        setReason(HttpStatus.SC_LENGTH_REQUIRED, "Length Required");
        setReason(HttpStatus.SC_REQUESTED_RANGE_NOT_SATISFIABLE, "Requested Range Not Satisfiable");
        setReason(HttpStatus.SC_EXPECTATION_FAILED, "Expectation Failed");
        setReason(102, "Processing");
        setReason(HttpStatus.SC_MULTI_STATUS, "Multi-Status");
        setReason(HttpStatus.SC_UNPROCESSABLE_ENTITY, "Unprocessable Entity");
        setReason(HttpStatus.SC_INSUFFICIENT_SPACE_ON_RESOURCE, "Insufficient Space On Resource");
        setReason(HttpStatus.SC_METHOD_FAILURE, "Method Failure");
        setReason(HttpStatus.SC_LOCKED, "Locked");
        setReason(HttpStatus.SC_INSUFFICIENT_STORAGE, "Insufficient Storage");
        setReason(HttpStatus.SC_FAILED_DEPENDENCY, "Failed Dependency");
    }

    protected EnglishReasonPhraseCatalog() {
    }

    public String getReason(int i, Locale locale) {
        boolean z = i >= 100 && i < 600;
        Args.check(z, "Unknown category for status code " + i);
        int i2 = i / 100;
        int i3 = i - (i2 * 100);
        String[][] strArr = REASON_PHRASES;
        if (strArr[i2].length > i3) {
            return strArr[i2][i3];
        }
        return null;
    }

    private static void setReason(int i, String str) {
        int i2 = i / 100;
        REASON_PHRASES[i2][i - (i2 * 100)] = str;
    }
}
