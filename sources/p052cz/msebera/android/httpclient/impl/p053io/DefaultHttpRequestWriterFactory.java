package p052cz.msebera.android.httpclient.impl.p053io;

import p052cz.msebera.android.httpclient.HttpRequest;
import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.message.BasicLineFormatter;
import p052cz.msebera.android.httpclient.message.LineFormatter;
import p052cz.msebera.android.httpclient.p054io.HttpMessageWriter;
import p052cz.msebera.android.httpclient.p054io.HttpMessageWriterFactory;
import p052cz.msebera.android.httpclient.p054io.SessionOutputBuffer;

@Immutable
/* renamed from: cz.msebera.android.httpclient.impl.io.DefaultHttpRequestWriterFactory */
public class DefaultHttpRequestWriterFactory implements HttpMessageWriterFactory<HttpRequest> {
    public static final DefaultHttpRequestWriterFactory INSTANCE = new DefaultHttpRequestWriterFactory();
    private final LineFormatter lineFormatter;

    public DefaultHttpRequestWriterFactory(LineFormatter lineFormatter2) {
        this.lineFormatter = lineFormatter2 == null ? BasicLineFormatter.INSTANCE : lineFormatter2;
    }

    public DefaultHttpRequestWriterFactory() {
        this((LineFormatter) null);
    }

    public HttpMessageWriter<HttpRequest> create(SessionOutputBuffer sessionOutputBuffer) {
        return new DefaultHttpRequestWriter(sessionOutputBuffer, this.lineFormatter);
    }
}
