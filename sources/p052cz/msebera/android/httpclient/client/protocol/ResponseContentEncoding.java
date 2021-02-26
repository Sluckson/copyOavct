package p052cz.msebera.android.httpclient.client.protocol;

import com.loopj.android.http.AsyncHttpClient;
import java.io.IOException;
import java.util.Locale;
import p052cz.msebera.android.httpclient.Header;
import p052cz.msebera.android.httpclient.HeaderElement;
import p052cz.msebera.android.httpclient.HttpEntity;
import p052cz.msebera.android.httpclient.HttpException;
import p052cz.msebera.android.httpclient.HttpResponse;
import p052cz.msebera.android.httpclient.HttpResponseInterceptor;
import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.client.entity.DeflateDecompressingEntity;
import p052cz.msebera.android.httpclient.client.entity.GzipDecompressingEntity;
import p052cz.msebera.android.httpclient.protocol.HTTP;
import p052cz.msebera.android.httpclient.protocol.HttpContext;

@Immutable
/* renamed from: cz.msebera.android.httpclient.client.protocol.ResponseContentEncoding */
public class ResponseContentEncoding implements HttpResponseInterceptor {
    public static final String UNCOMPRESSED = "http.client.response.uncompressed";

    public void process(HttpResponse httpResponse, HttpContext httpContext) throws HttpException, IOException {
        Header contentEncoding;
        HttpEntity entity = httpResponse.getEntity();
        if (entity != null && entity.getContentLength() != 0 && (contentEncoding = entity.getContentEncoding()) != null) {
            HeaderElement[] elements = contentEncoding.getElements();
            boolean z = true;
            if (elements.length > 0) {
                HeaderElement headerElement = elements[0];
                String lowerCase = headerElement.getName().toLowerCase(Locale.ENGLISH);
                if (AsyncHttpClient.ENCODING_GZIP.equals(lowerCase) || "x-gzip".equals(lowerCase)) {
                    httpResponse.setEntity(new GzipDecompressingEntity(httpResponse.getEntity()));
                } else if ("deflate".equals(lowerCase)) {
                    httpResponse.setEntity(new DeflateDecompressingEntity(httpResponse.getEntity()));
                } else if (!HTTP.IDENTITY_CODING.equals(lowerCase)) {
                    throw new HttpException("Unsupported Content-Coding: " + headerElement.getName());
                } else {
                    return;
                }
            } else {
                z = false;
            }
            if (z) {
                httpResponse.removeHeaders("Content-Length");
                httpResponse.removeHeaders("Content-Encoding");
                httpResponse.removeHeaders("Content-MD5");
            }
        }
    }
}
