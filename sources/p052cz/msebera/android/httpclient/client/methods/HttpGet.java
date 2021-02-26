package p052cz.msebera.android.httpclient.client.methods;

import java.net.URI;
import p052cz.msebera.android.httpclient.annotation.NotThreadSafe;

@NotThreadSafe
/* renamed from: cz.msebera.android.httpclient.client.methods.HttpGet */
public class HttpGet extends HttpRequestBase {
    public static final String METHOD_NAME = "GET";

    public String getMethod() {
        return "GET";
    }

    public HttpGet() {
    }

    public HttpGet(URI uri) {
        setURI(uri);
    }

    public HttpGet(String str) {
        setURI(URI.create(str));
    }
}
