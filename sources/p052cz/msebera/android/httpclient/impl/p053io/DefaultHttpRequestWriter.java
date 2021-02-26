package p052cz.msebera.android.httpclient.impl.p053io;

import java.io.IOException;
import p052cz.msebera.android.httpclient.HttpRequest;
import p052cz.msebera.android.httpclient.annotation.NotThreadSafe;
import p052cz.msebera.android.httpclient.message.LineFormatter;
import p052cz.msebera.android.httpclient.p054io.SessionOutputBuffer;

@NotThreadSafe
/* renamed from: cz.msebera.android.httpclient.impl.io.DefaultHttpRequestWriter */
public class DefaultHttpRequestWriter extends AbstractMessageWriter<HttpRequest> {
    public DefaultHttpRequestWriter(SessionOutputBuffer sessionOutputBuffer, LineFormatter lineFormatter) {
        super(sessionOutputBuffer, lineFormatter);
    }

    public DefaultHttpRequestWriter(SessionOutputBuffer sessionOutputBuffer) {
        this(sessionOutputBuffer, (LineFormatter) null);
    }

    /* access modifiers changed from: protected */
    public void writeHeadLine(HttpRequest httpRequest) throws IOException {
        this.lineFormatter.formatRequestLine(this.lineBuf, httpRequest.getRequestLine());
        this.sessionBuffer.writeLine(this.lineBuf);
    }
}
