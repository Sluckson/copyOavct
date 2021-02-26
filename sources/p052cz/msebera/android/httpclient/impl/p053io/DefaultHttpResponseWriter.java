package p052cz.msebera.android.httpclient.impl.p053io;

import java.io.IOException;
import p052cz.msebera.android.httpclient.HttpResponse;
import p052cz.msebera.android.httpclient.annotation.NotThreadSafe;
import p052cz.msebera.android.httpclient.message.LineFormatter;
import p052cz.msebera.android.httpclient.p054io.SessionOutputBuffer;

@NotThreadSafe
/* renamed from: cz.msebera.android.httpclient.impl.io.DefaultHttpResponseWriter */
public class DefaultHttpResponseWriter extends AbstractMessageWriter<HttpResponse> {
    public DefaultHttpResponseWriter(SessionOutputBuffer sessionOutputBuffer, LineFormatter lineFormatter) {
        super(sessionOutputBuffer, lineFormatter);
    }

    public DefaultHttpResponseWriter(SessionOutputBuffer sessionOutputBuffer) {
        super(sessionOutputBuffer, (LineFormatter) null);
    }

    /* access modifiers changed from: protected */
    public void writeHeadLine(HttpResponse httpResponse) throws IOException {
        this.lineFormatter.formatStatusLine(this.lineBuf, httpResponse.getStatusLine());
        this.sessionBuffer.writeLine(this.lineBuf);
    }
}
