package p052cz.msebera.android.httpclient.client.methods;

import java.net.URI;
import p052cz.msebera.android.httpclient.annotation.NotThreadSafe;

@NotThreadSafe
/* renamed from: cz.msebera.android.httpclient.client.methods.HttpDelete */
public class HttpDelete extends HttpRequestBase {
    public static final String METHOD_NAME = "DELETE";

    public String getMethod() {
        return "DELETE";
    }

    public HttpDelete() {
    }

    public HttpDelete(URI uri) {
        setURI(uri);
    }

    public HttpDelete(String str) {
        setURI(URI.create(str));
    }
}
