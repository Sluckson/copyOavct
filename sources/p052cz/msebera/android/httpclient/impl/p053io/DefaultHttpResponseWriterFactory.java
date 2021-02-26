package p052cz.msebera.android.httpclient.impl.p053io;

import p052cz.msebera.android.httpclient.HttpResponse;
import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.message.BasicLineFormatter;
import p052cz.msebera.android.httpclient.message.LineFormatter;
import p052cz.msebera.android.httpclient.p054io.HttpMessageWriter;
import p052cz.msebera.android.httpclient.p054io.HttpMessageWriterFactory;
import p052cz.msebera.android.httpclient.p054io.SessionOutputBuffer;

@Immutable
/* renamed from: cz.msebera.android.httpclient.impl.io.DefaultHttpResponseWriterFactory */
public class DefaultHttpResponseWriterFactory implements HttpMessageWriterFactory<HttpResponse> {
    public static final DefaultHttpResponseWriterFactory INSTANCE = new DefaultHttpResponseWriterFactory();
    private final LineFormatter lineFormatter;

    public DefaultHttpResponseWriterFactory(LineFormatter lineFormatter2) {
        this.lineFormatter = lineFormatter2 == null ? BasicLineFormatter.INSTANCE : lineFormatter2;
    }

    public DefaultHttpResponseWriterFactory() {
        this((LineFormatter) null);
    }

    public HttpMessageWriter<HttpResponse> create(SessionOutputBuffer sessionOutputBuffer) {
        return new DefaultHttpResponseWriter(sessionOutputBuffer, this.lineFormatter);
    }
}
