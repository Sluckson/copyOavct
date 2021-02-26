package p052cz.msebera.android.httpclient.client.utils;

import java.io.Closeable;
import java.io.IOException;
import p052cz.msebera.android.httpclient.HttpEntity;
import p052cz.msebera.android.httpclient.HttpResponse;
import p052cz.msebera.android.httpclient.client.HttpClient;
import p052cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import p052cz.msebera.android.httpclient.util.EntityUtils;

/* renamed from: cz.msebera.android.httpclient.client.utils.HttpClientUtils */
public class HttpClientUtils {
    private HttpClientUtils() {
    }

    public static void closeQuietly(HttpResponse httpResponse) {
        HttpEntity entity;
        if (httpResponse != null && (entity = httpResponse.getEntity()) != null) {
            try {
                EntityUtils.consume(entity);
            } catch (IOException unused) {
            }
        }
    }

    public static void closeQuietly(CloseableHttpResponse closeableHttpResponse) {
        if (closeableHttpResponse != null) {
            try {
                EntityUtils.consume(closeableHttpResponse.getEntity());
                closeableHttpResponse.close();
            } catch (IOException unused) {
            } catch (Throwable th) {
                closeableHttpResponse.close();
                throw th;
            }
        }
    }

    public static void closeQuietly(HttpClient httpClient) {
        if (httpClient != null && (httpClient instanceof Closeable)) {
            try {
                ((Closeable) httpClient).close();
            } catch (IOException unused) {
            }
        }
    }
}
