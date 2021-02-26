package p052cz.msebera.android.httpclient.impl.execchain;

import java.io.IOException;
import p052cz.msebera.android.httpclient.Header;
import p052cz.msebera.android.httpclient.HttpException;
import p052cz.msebera.android.httpclient.NoHttpResponseException;
import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.client.HttpRequestRetryHandler;
import p052cz.msebera.android.httpclient.client.NonRepeatableRequestException;
import p052cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import p052cz.msebera.android.httpclient.client.methods.HttpExecutionAware;
import p052cz.msebera.android.httpclient.client.methods.HttpRequestWrapper;
import p052cz.msebera.android.httpclient.client.protocol.HttpClientContext;
import p052cz.msebera.android.httpclient.conn.routing.HttpRoute;
import p052cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import p052cz.msebera.android.httpclient.util.Args;

@Immutable
/* renamed from: cz.msebera.android.httpclient.impl.execchain.RetryExec */
public class RetryExec implements ClientExecChain {
    public HttpClientAndroidLog log = new HttpClientAndroidLog(getClass());
    private final ClientExecChain requestExecutor;
    private final HttpRequestRetryHandler retryHandler;

    public RetryExec(ClientExecChain clientExecChain, HttpRequestRetryHandler httpRequestRetryHandler) {
        Args.notNull(clientExecChain, "HTTP request executor");
        Args.notNull(httpRequestRetryHandler, "HTTP request retry handler");
        this.requestExecutor = clientExecChain;
        this.retryHandler = httpRequestRetryHandler;
    }

    public CloseableHttpResponse execute(HttpRoute httpRoute, HttpRequestWrapper httpRequestWrapper, HttpClientContext httpClientContext, HttpExecutionAware httpExecutionAware) throws IOException, HttpException {
        Args.notNull(httpRoute, "HTTP route");
        Args.notNull(httpRequestWrapper, "HTTP request");
        Args.notNull(httpClientContext, "HTTP context");
        Header[] allHeaders = httpRequestWrapper.getAllHeaders();
        int i = 1;
        while (true) {
            try {
                return this.requestExecutor.execute(httpRoute, httpRequestWrapper, httpClientContext, httpExecutionAware);
            } catch (IOException e) {
                if (httpExecutionAware != null && httpExecutionAware.isAborted()) {
                    this.log.debug("Request has been aborted");
                    throw e;
                } else if (this.retryHandler.retryRequest(e, i, httpClientContext)) {
                    if (this.log.isInfoEnabled()) {
                        HttpClientAndroidLog httpClientAndroidLog = this.log;
                        httpClientAndroidLog.info("I/O exception (" + e.getClass().getName() + ") caught when processing request to " + httpRoute + ": " + e.getMessage());
                    }
                    if (this.log.isDebugEnabled()) {
                        this.log.debug(e.getMessage(), e);
                    }
                    if (RequestEntityProxy.isRepeatable(httpRequestWrapper)) {
                        httpRequestWrapper.setHeaders(allHeaders);
                        if (this.log.isInfoEnabled()) {
                            HttpClientAndroidLog httpClientAndroidLog2 = this.log;
                            httpClientAndroidLog2.info("Retrying request to " + httpRoute);
                        }
                        i++;
                    } else {
                        this.log.debug("Cannot retry non-repeatable request");
                        throw new NonRepeatableRequestException("Cannot retry request with a non-repeatable request entity", e);
                    }
                } else if (e instanceof NoHttpResponseException) {
                    NoHttpResponseException noHttpResponseException = new NoHttpResponseException(httpRoute.getTargetHost().toHostString() + " failed to respond");
                    noHttpResponseException.setStackTrace(e.getStackTrace());
                    throw noHttpResponseException;
                } else {
                    throw e;
                }
            }
        }
    }
}
