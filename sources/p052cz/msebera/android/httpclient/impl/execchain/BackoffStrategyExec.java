package p052cz.msebera.android.httpclient.impl.execchain;

import java.io.IOException;
import java.lang.reflect.UndeclaredThrowableException;
import p052cz.msebera.android.httpclient.HttpException;
import p052cz.msebera.android.httpclient.HttpResponse;
import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.client.BackoffManager;
import p052cz.msebera.android.httpclient.client.ConnectionBackoffStrategy;
import p052cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import p052cz.msebera.android.httpclient.client.methods.HttpExecutionAware;
import p052cz.msebera.android.httpclient.client.methods.HttpRequestWrapper;
import p052cz.msebera.android.httpclient.client.protocol.HttpClientContext;
import p052cz.msebera.android.httpclient.conn.routing.HttpRoute;
import p052cz.msebera.android.httpclient.util.Args;

@Immutable
/* renamed from: cz.msebera.android.httpclient.impl.execchain.BackoffStrategyExec */
public class BackoffStrategyExec implements ClientExecChain {
    private final BackoffManager backoffManager;
    private final ConnectionBackoffStrategy connectionBackoffStrategy;
    private final ClientExecChain requestExecutor;

    public BackoffStrategyExec(ClientExecChain clientExecChain, ConnectionBackoffStrategy connectionBackoffStrategy2, BackoffManager backoffManager2) {
        Args.notNull(clientExecChain, "HTTP client request executor");
        Args.notNull(connectionBackoffStrategy2, "Connection backoff strategy");
        Args.notNull(backoffManager2, "Backoff manager");
        this.requestExecutor = clientExecChain;
        this.connectionBackoffStrategy = connectionBackoffStrategy2;
        this.backoffManager = backoffManager2;
    }

    public CloseableHttpResponse execute(HttpRoute httpRoute, HttpRequestWrapper httpRequestWrapper, HttpClientContext httpClientContext, HttpExecutionAware httpExecutionAware) throws IOException, HttpException {
        Args.notNull(httpRoute, "HTTP route");
        Args.notNull(httpRequestWrapper, "HTTP request");
        Args.notNull(httpClientContext, "HTTP context");
        try {
            CloseableHttpResponse execute = this.requestExecutor.execute(httpRoute, httpRequestWrapper, httpClientContext, httpExecutionAware);
            if (this.connectionBackoffStrategy.shouldBackoff((HttpResponse) execute)) {
                this.backoffManager.backOff(httpRoute);
            } else {
                this.backoffManager.probe(httpRoute);
            }
            return execute;
        } catch (Exception e) {
            if (this.connectionBackoffStrategy.shouldBackoff((Throwable) e)) {
                this.backoffManager.backOff(httpRoute);
            }
            if (e instanceof RuntimeException) {
                throw ((RuntimeException) e);
            } else if (e instanceof HttpException) {
                throw ((HttpException) e);
            } else if (e instanceof IOException) {
                throw ((IOException) e);
            } else {
                throw new UndeclaredThrowableException(e);
            }
        }
    }
}
