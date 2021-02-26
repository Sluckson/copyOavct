package p052cz.msebera.android.httpclient.impl.client.cache;

import com.google.android.gms.appinvite.PreviewActivity;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import p052cz.msebera.android.httpclient.HttpResponse;
import p052cz.msebera.android.httpclient.annotation.NotThreadSafe;

@NotThreadSafe
/* renamed from: cz.msebera.android.httpclient.impl.client.cache.ResponseProxyHandler */
class ResponseProxyHandler implements InvocationHandler {
    private static final Method CLOSE_METHOD;
    private final HttpResponse original;

    static {
        try {
            CLOSE_METHOD = Closeable.class.getMethod(PreviewActivity.ON_CLICK_LISTENER_CLOSE, new Class[0]);
        } catch (NoSuchMethodException e) {
            throw new Error(e);
        }
    }

    ResponseProxyHandler(HttpResponse httpResponse) {
        this.original = httpResponse;
    }

    public void close() throws IOException {
        IOUtils.consume(this.original.getEntity());
    }

    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        if (method.equals(CLOSE_METHOD)) {
            close();
            return null;
        }
        try {
            return method.invoke(this.original, objArr);
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            if (cause != null) {
                throw cause;
            }
            throw e;
        }
    }
}
