package p052cz.msebera.android.httpclient.impl.client;

import java.io.IOException;
import p052cz.msebera.android.httpclient.HttpEntity;
import p052cz.msebera.android.httpclient.HttpResponse;
import p052cz.msebera.android.httpclient.StatusLine;
import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.client.HttpResponseException;
import p052cz.msebera.android.httpclient.client.ResponseHandler;
import p052cz.msebera.android.httpclient.util.EntityUtils;

@Immutable
/* renamed from: cz.msebera.android.httpclient.impl.client.BasicResponseHandler */
public class BasicResponseHandler implements ResponseHandler<String> {
    public String handleResponse(HttpResponse httpResponse) throws HttpResponseException, IOException {
        StatusLine statusLine = httpResponse.getStatusLine();
        HttpEntity entity = httpResponse.getEntity();
        if (statusLine.getStatusCode() >= 300) {
            EntityUtils.consume(entity);
            throw new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase());
        } else if (entity == null) {
            return null;
        } else {
            return EntityUtils.toString(entity);
        }
    }
}
