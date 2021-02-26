package p052cz.msebera.android.httpclient.impl.p053io;

import java.io.IOException;
import p052cz.msebera.android.httpclient.HeaderIterator;
import p052cz.msebera.android.httpclient.HttpException;
import p052cz.msebera.android.httpclient.HttpMessage;
import p052cz.msebera.android.httpclient.annotation.NotThreadSafe;
import p052cz.msebera.android.httpclient.message.BasicLineFormatter;
import p052cz.msebera.android.httpclient.message.LineFormatter;
import p052cz.msebera.android.httpclient.p054io.HttpMessageWriter;
import p052cz.msebera.android.httpclient.p054io.SessionOutputBuffer;
import p052cz.msebera.android.httpclient.params.HttpParams;
import p052cz.msebera.android.httpclient.util.Args;
import p052cz.msebera.android.httpclient.util.CharArrayBuffer;

@NotThreadSafe
/* renamed from: cz.msebera.android.httpclient.impl.io.AbstractMessageWriter */
public abstract class AbstractMessageWriter<T extends HttpMessage> implements HttpMessageWriter<T> {
    protected final CharArrayBuffer lineBuf;
    protected final LineFormatter lineFormatter;
    protected final SessionOutputBuffer sessionBuffer;

    /* access modifiers changed from: protected */
    public abstract void writeHeadLine(T t) throws IOException;

    @Deprecated
    public AbstractMessageWriter(SessionOutputBuffer sessionOutputBuffer, LineFormatter lineFormatter2, HttpParams httpParams) {
        Args.notNull(sessionOutputBuffer, "Session input buffer");
        this.sessionBuffer = sessionOutputBuffer;
        this.lineBuf = new CharArrayBuffer(128);
        this.lineFormatter = lineFormatter2 == null ? BasicLineFormatter.INSTANCE : lineFormatter2;
    }

    public AbstractMessageWriter(SessionOutputBuffer sessionOutputBuffer, LineFormatter lineFormatter2) {
        this.sessionBuffer = (SessionOutputBuffer) Args.notNull(sessionOutputBuffer, "Session input buffer");
        this.lineFormatter = lineFormatter2 == null ? BasicLineFormatter.INSTANCE : lineFormatter2;
        this.lineBuf = new CharArrayBuffer(128);
    }

    public void write(T t) throws IOException, HttpException {
        Args.notNull(t, "HTTP message");
        writeHeadLine(t);
        HeaderIterator headerIterator = t.headerIterator();
        while (headerIterator.hasNext()) {
            this.sessionBuffer.writeLine(this.lineFormatter.formatHeader(this.lineBuf, headerIterator.nextHeader()));
        }
        this.lineBuf.clear();
        this.sessionBuffer.writeLine(this.lineBuf);
    }
}
