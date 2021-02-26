package p052cz.msebera.android.httpclient.p054io;

import p052cz.msebera.android.httpclient.HttpMessage;

/* renamed from: cz.msebera.android.httpclient.io.HttpMessageWriterFactory */
public interface HttpMessageWriterFactory<T extends HttpMessage> {
    HttpMessageWriter<T> create(SessionOutputBuffer sessionOutputBuffer);
}
