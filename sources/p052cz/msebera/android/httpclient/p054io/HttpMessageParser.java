package p052cz.msebera.android.httpclient.p054io;

import java.io.IOException;
import p052cz.msebera.android.httpclient.HttpException;
import p052cz.msebera.android.httpclient.HttpMessage;

/* renamed from: cz.msebera.android.httpclient.io.HttpMessageParser */
public interface HttpMessageParser<T extends HttpMessage> {
    T parse() throws IOException, HttpException;
}
