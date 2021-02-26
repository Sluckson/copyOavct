package p052cz.msebera.android.httpclient.impl;

import com.google.firebase.perf.FirebasePerformance;
import p052cz.msebera.android.httpclient.HttpRequest;
import p052cz.msebera.android.httpclient.HttpRequestFactory;
import p052cz.msebera.android.httpclient.MethodNotSupportedException;
import p052cz.msebera.android.httpclient.RequestLine;
import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.message.BasicHttpEntityEnclosingRequest;
import p052cz.msebera.android.httpclient.message.BasicHttpRequest;
import p052cz.msebera.android.httpclient.util.Args;

@Immutable
/* renamed from: cz.msebera.android.httpclient.impl.DefaultHttpRequestFactory */
public class DefaultHttpRequestFactory implements HttpRequestFactory {
    public static final DefaultHttpRequestFactory INSTANCE = new DefaultHttpRequestFactory();
    private static final String[] RFC2616_COMMON_METHODS = {"GET"};
    private static final String[] RFC2616_ENTITY_ENC_METHODS = {"POST", "PUT"};
    private static final String[] RFC2616_SPECIAL_METHODS = {"HEAD", "OPTIONS", "DELETE", "TRACE", FirebasePerformance.HttpMethod.CONNECT};

    private static boolean isOneOf(String[] strArr, String str) {
        for (String equalsIgnoreCase : strArr) {
            if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public HttpRequest newHttpRequest(RequestLine requestLine) throws MethodNotSupportedException {
        Args.notNull(requestLine, "Request line");
        String method = requestLine.getMethod();
        if (isOneOf(RFC2616_COMMON_METHODS, method)) {
            return new BasicHttpRequest(requestLine);
        }
        if (isOneOf(RFC2616_ENTITY_ENC_METHODS, method)) {
            return new BasicHttpEntityEnclosingRequest(requestLine);
        }
        if (isOneOf(RFC2616_SPECIAL_METHODS, method)) {
            return new BasicHttpRequest(requestLine);
        }
        throw new MethodNotSupportedException(method + " method not supported");
    }

    public HttpRequest newHttpRequest(String str, String str2) throws MethodNotSupportedException {
        if (isOneOf(RFC2616_COMMON_METHODS, str)) {
            return new BasicHttpRequest(str, str2);
        }
        if (isOneOf(RFC2616_ENTITY_ENC_METHODS, str)) {
            return new BasicHttpEntityEnclosingRequest(str, str2);
        }
        if (isOneOf(RFC2616_SPECIAL_METHODS, str)) {
            return new BasicHttpRequest(str, str2);
        }
        throw new MethodNotSupportedException(str + " method not supported");
    }
}
