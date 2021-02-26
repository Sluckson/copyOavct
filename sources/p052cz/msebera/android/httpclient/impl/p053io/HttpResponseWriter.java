package p052cz.msebera.android.httpclient.impl.p053io;

import java.io.IOException;
import p052cz.msebera.android.httpclient.HttpResponse;
import p052cz.msebera.android.httpclient.annotation.NotThreadSafe;
import p052cz.msebera.android.httpclient.message.LineFormatter;
import p052cz.msebera.android.httpclient.p054io.SessionOutputBuffer;
import p052cz.msebera.android.httpclient.params.HttpParams;

@NotThreadSafe
@Deprecated
/* renamed from: cz.msebera.android.httpclient.impl.io.HttpResponseWriter */
public class HttpResponseWriter extends AbstractMessageWriter<HttpResponse> {
    public HttpResponseWriter(SessionOutputBuffer sessionOutputBuffer, LineFormatter lineFormatter, HttpParams httpParams) {
        super(sessionOutputBuffer, lineFormatter, httpParams);
    }

    /* access modifiers changed from: protected */
    public void writeHeadLine(HttpResponse httpResponse) throws IOException {
        this.lineFormatter.formatStatusLine(this.lineBuf, httpResponse.getStatusLine());
        this.sessionBuffer.writeLine(this.lineBuf);
    }
}
