package p052cz.msebera.android.httpclient.impl.p053io;

import java.io.IOException;
import p052cz.msebera.android.httpclient.HttpRequest;
import p052cz.msebera.android.httpclient.annotation.NotThreadSafe;
import p052cz.msebera.android.httpclient.message.LineFormatter;
import p052cz.msebera.android.httpclient.p054io.SessionOutputBuffer;
import p052cz.msebera.android.httpclient.params.HttpParams;

@NotThreadSafe
@Deprecated
/* renamed from: cz.msebera.android.httpclient.impl.io.HttpRequestWriter */
public class HttpRequestWriter extends AbstractMessageWriter<HttpRequest> {
    public HttpRequestWriter(SessionOutputBuffer sessionOutputBuffer, LineFormatter lineFormatter, HttpParams httpParams) {
        super(sessionOutputBuffer, lineFormatter, httpParams);
    }

    /* access modifiers changed from: protected */
    public void writeHeadLine(HttpRequest httpRequest) throws IOException {
        this.lineFormatter.formatRequestLine(this.lineBuf, httpRequest.getRequestLine());
        this.sessionBuffer.writeLine(this.lineBuf);
    }
}
