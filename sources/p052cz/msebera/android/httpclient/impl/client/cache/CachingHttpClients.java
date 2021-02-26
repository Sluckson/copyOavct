package p052cz.msebera.android.httpclient.impl.client.cache;

import java.io.File;
import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.impl.client.CloseableHttpClient;

@Immutable
/* renamed from: cz.msebera.android.httpclient.impl.client.cache.CachingHttpClients */
public class CachingHttpClients {
    private CachingHttpClients() {
    }

    public static CachingHttpClientBuilder custom() {
        return CachingHttpClientBuilder.create();
    }

    public static CloseableHttpClient createMemoryBound() {
        return CachingHttpClientBuilder.create().build();
    }

    public static CloseableHttpClient createFileBound(File file) {
        return CachingHttpClientBuilder.create().setCacheDir(file).build();
    }
}
