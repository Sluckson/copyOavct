package p052cz.msebera.android.httpclient.impl.client;

import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import p052cz.msebera.android.httpclient.annotation.ThreadSafe;
import p052cz.msebera.android.httpclient.client.HttpClient;
import p052cz.msebera.android.httpclient.client.ResponseHandler;
import p052cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import p052cz.msebera.android.httpclient.concurrent.FutureCallback;
import p052cz.msebera.android.httpclient.protocol.HttpContext;

@ThreadSafe
/* renamed from: cz.msebera.android.httpclient.impl.client.FutureRequestExecutionService */
public class FutureRequestExecutionService implements Closeable {
    private final AtomicBoolean closed = new AtomicBoolean(false);
    private final ExecutorService executorService;
    private final HttpClient httpclient;
    private final FutureRequestExecutionMetrics metrics = new FutureRequestExecutionMetrics();

    public FutureRequestExecutionService(HttpClient httpClient, ExecutorService executorService2) {
        this.httpclient = httpClient;
        this.executorService = executorService2;
    }

    public <T> HttpRequestFutureTask<T> execute(HttpUriRequest httpUriRequest, HttpContext httpContext, ResponseHandler<T> responseHandler) {
        return execute(httpUriRequest, httpContext, responseHandler, (FutureCallback) null);
    }

    public <T> HttpRequestFutureTask<T> execute(HttpUriRequest httpUriRequest, HttpContext httpContext, ResponseHandler<T> responseHandler, FutureCallback<T> futureCallback) {
        if (!this.closed.get()) {
            this.metrics.getScheduledConnections().incrementAndGet();
            HttpRequestFutureTask<T> httpRequestFutureTask = new HttpRequestFutureTask<>(httpUriRequest, new HttpRequestTaskCallable(this.httpclient, httpUriRequest, httpContext, responseHandler, futureCallback, this.metrics));
            this.executorService.execute(httpRequestFutureTask);
            return httpRequestFutureTask;
        }
        throw new IllegalStateException("Close has been called on this httpclient instance.");
    }

    public FutureRequestExecutionMetrics metrics() {
        return this.metrics;
    }

    public void close() throws IOException {
        this.closed.set(true);
        this.executorService.shutdownNow();
        HttpClient httpClient = this.httpclient;
        if (httpClient instanceof Closeable) {
            ((Closeable) httpClient).close();
        }
    }
}
