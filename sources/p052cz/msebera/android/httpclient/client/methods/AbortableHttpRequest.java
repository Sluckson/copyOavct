package p052cz.msebera.android.httpclient.client.methods;

import java.io.IOException;
import p052cz.msebera.android.httpclient.conn.ClientConnectionRequest;
import p052cz.msebera.android.httpclient.conn.ConnectionReleaseTrigger;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.client.methods.AbortableHttpRequest */
public interface AbortableHttpRequest {
    void abort();

    void setConnectionRequest(ClientConnectionRequest clientConnectionRequest) throws IOException;

    void setReleaseTrigger(ConnectionReleaseTrigger connectionReleaseTrigger) throws IOException;
}
