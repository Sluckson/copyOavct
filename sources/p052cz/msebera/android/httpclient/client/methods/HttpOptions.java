package p052cz.msebera.android.httpclient.client.methods;

import java.net.URI;
import java.util.HashSet;
import java.util.Set;
import p052cz.msebera.android.httpclient.HeaderElement;
import p052cz.msebera.android.httpclient.HeaderIterator;
import p052cz.msebera.android.httpclient.HttpResponse;
import p052cz.msebera.android.httpclient.annotation.NotThreadSafe;
import p052cz.msebera.android.httpclient.util.Args;

@NotThreadSafe
/* renamed from: cz.msebera.android.httpclient.client.methods.HttpOptions */
public class HttpOptions extends HttpRequestBase {
    public static final String METHOD_NAME = "OPTIONS";

    public String getMethod() {
        return "OPTIONS";
    }

    public HttpOptions() {
    }

    public HttpOptions(URI uri) {
        setURI(uri);
    }

    public HttpOptions(String str) {
        setURI(URI.create(str));
    }

    public Set<String> getAllowedMethods(HttpResponse httpResponse) {
        Args.notNull(httpResponse, "HTTP response");
        HeaderIterator headerIterator = httpResponse.headerIterator("Allow");
        HashSet hashSet = new HashSet();
        while (headerIterator.hasNext()) {
            for (HeaderElement name : headerIterator.nextHeader().getElements()) {
                hashSet.add(name.getName());
            }
        }
        return hashSet;
    }
}
