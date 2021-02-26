package p052cz.msebera.android.httpclient.impl.client;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import p052cz.msebera.android.httpclient.client.HttpClient;
import p052cz.msebera.android.httpclient.client.ResponseHandler;
import p052cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import p052cz.msebera.android.httpclient.concurrent.FutureCallback;
import p052cz.msebera.android.httpclient.protocol.HttpContext;

/* renamed from: cz.msebera.android.httpclient.impl.client.HttpRequestTaskCallable */
class HttpRequestTaskCallable<V> implements Callable<V> {
    private final FutureCallback<V> callback;
    private final AtomicBoolean cancelled = new AtomicBoolean(false);
    private final HttpContext context;
    private long ended = -1;
    private final HttpClient httpclient;
    private final FutureRequestExecutionMetrics metrics;
    private final HttpUriRequest request;
    private final ResponseHandler<V> responseHandler;
    private final long scheduled = System.currentTimeMillis();
    private long started = -1;

    HttpRequestTaskCallable(HttpClient httpClient, HttpUriRequest httpUriRequest, HttpContext httpContext, ResponseHandler<V> responseHandler2, FutureCallback<V> futureCallback, FutureRequestExecutionMetrics futureRequestExecutionMetrics) {
        this.httpclient = httpClient;
        this.responseHandler = responseHandler2;
        this.request = httpUriRequest;
        this.context = httpContext;
        this.callback = futureCallback;
        this.metrics = futureRequestExecutionMetrics;
    }

    public long getScheduled() {
        return this.scheduled;
    }

    public long getStarted() {
        return this.started;
    }

    public long getEnded() {
        return this.ended;
    }

    public V call() throws Exception {
        if (!this.cancelled.get()) {
            try {
                this.metrics.getActiveConnections().incrementAndGet();
                this.started = System.currentTimeMillis();
                this.metrics.getScheduledConnections().decrementAndGet();
                V execute = this.httpclient.execute(this.request, this.responseHandler, this.context);
                this.ended = System.currentTimeMillis();
                this.metrics.getSuccessfulConnections().increment(this.started);
                if (this.callback != null) {
                    this.callback.completed(execute);
                }
                this.metrics.getRequests().increment(this.started);
                this.metrics.getTasks().increment(this.started);
                this.metrics.getActiveConnections().decrementAndGet();
                return execute;
            } catch (Exception e) {
                this.metrics.getFailedConnections().increment(this.started);
                this.ended = System.currentTimeMillis();
                if (this.callback != null) {
                    this.callback.failed(e);
                }
                throw e;
            } catch (Throwable th) {
                this.metrics.getRequests().increment(this.started);
                this.metrics.getTasks().increment(this.started);
                this.metrics.getActiveConnections().decrementAndGet();
                throw th;
            }
        } else {
            throw new IllegalStateException("call has been cancelled for request " + this.request.getURI());
        }
    }

    public void cancel() {
        this.cancelled.set(true);
        FutureCallback<V> futureCallback = this.callback;
        if (futureCallback != null) {
            futureCallback.cancelled();
        }
    }
}
