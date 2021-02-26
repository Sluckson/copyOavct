package p052cz.msebera.android.httpclient.impl.execchain;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import p052cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import p052cz.msebera.android.httpclient.HttpException;
import p052cz.msebera.android.httpclient.HttpHost;
import p052cz.msebera.android.httpclient.ProtocolException;
import p052cz.msebera.android.httpclient.annotation.ThreadSafe;
import p052cz.msebera.android.httpclient.auth.AuthScheme;
import p052cz.msebera.android.httpclient.auth.AuthState;
import p052cz.msebera.android.httpclient.client.RedirectException;
import p052cz.msebera.android.httpclient.client.RedirectStrategy;
import p052cz.msebera.android.httpclient.client.config.RequestConfig;
import p052cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import p052cz.msebera.android.httpclient.client.methods.HttpExecutionAware;
import p052cz.msebera.android.httpclient.client.methods.HttpRequestWrapper;
import p052cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import p052cz.msebera.android.httpclient.client.protocol.HttpClientContext;
import p052cz.msebera.android.httpclient.client.utils.URIUtils;
import p052cz.msebera.android.httpclient.conn.routing.HttpRoute;
import p052cz.msebera.android.httpclient.conn.routing.HttpRoutePlanner;
import p052cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import p052cz.msebera.android.httpclient.util.Args;
import p052cz.msebera.android.httpclient.util.EntityUtils;

@ThreadSafe
/* renamed from: cz.msebera.android.httpclient.impl.execchain.RedirectExec */
public class RedirectExec implements ClientExecChain {
    public HttpClientAndroidLog log = new HttpClientAndroidLog(getClass());
    private final RedirectStrategy redirectStrategy;
    private final ClientExecChain requestExecutor;
    private final HttpRoutePlanner routePlanner;

    public RedirectExec(ClientExecChain clientExecChain, HttpRoutePlanner httpRoutePlanner, RedirectStrategy redirectStrategy2) {
        Args.notNull(clientExecChain, "HTTP client request executor");
        Args.notNull(httpRoutePlanner, "HTTP route planner");
        Args.notNull(redirectStrategy2, "HTTP redirect strategy");
        this.requestExecutor = clientExecChain;
        this.routePlanner = httpRoutePlanner;
        this.redirectStrategy = redirectStrategy2;
    }

    public CloseableHttpResponse execute(HttpRoute httpRoute, HttpRequestWrapper httpRequestWrapper, HttpClientContext httpClientContext, HttpExecutionAware httpExecutionAware) throws IOException, HttpException {
        CloseableHttpResponse execute;
        AuthScheme authScheme;
        Args.notNull(httpRoute, "HTTP route");
        Args.notNull(httpRequestWrapper, "HTTP request");
        Args.notNull(httpClientContext, "HTTP context");
        List<URI> redirectLocations = httpClientContext.getRedirectLocations();
        if (redirectLocations != null) {
            redirectLocations.clear();
        }
        RequestConfig requestConfig = httpClientContext.getRequestConfig();
        int maxRedirects = requestConfig.getMaxRedirects() > 0 ? requestConfig.getMaxRedirects() : 50;
        HttpRequestWrapper httpRequestWrapper2 = httpRequestWrapper;
        int i = 0;
        while (true) {
            execute = this.requestExecutor.execute(httpRoute, httpRequestWrapper2, httpClientContext, httpExecutionAware);
            try {
                if (!requestConfig.isRedirectsEnabled() || !this.redirectStrategy.isRedirected(httpRequestWrapper2, execute, httpClientContext)) {
                    return execute;
                }
                if (i < maxRedirects) {
                    i++;
                    HttpUriRequest redirect = this.redirectStrategy.getRedirect(httpRequestWrapper2, execute, httpClientContext);
                    if (!redirect.headerIterator().hasNext()) {
                        redirect.setHeaders(httpRequestWrapper.getOriginal().getAllHeaders());
                    }
                    httpRequestWrapper2 = HttpRequestWrapper.wrap(redirect);
                    if (httpRequestWrapper2 instanceof HttpEntityEnclosingRequest) {
                        RequestEntityProxy.enhance((HttpEntityEnclosingRequest) httpRequestWrapper2);
                    }
                    URI uri = httpRequestWrapper2.getURI();
                    HttpHost extractHost = URIUtils.extractHost(uri);
                    if (extractHost != null) {
                        if (!httpRoute.getTargetHost().equals(extractHost)) {
                            AuthState targetAuthState = httpClientContext.getTargetAuthState();
                            if (targetAuthState != null) {
                                this.log.debug("Resetting target auth state");
                                targetAuthState.reset();
                            }
                            AuthState proxyAuthState = httpClientContext.getProxyAuthState();
                            if (!(proxyAuthState == null || (authScheme = proxyAuthState.getAuthScheme()) == null || !authScheme.isConnectionBased())) {
                                this.log.debug("Resetting proxy auth state");
                                proxyAuthState.reset();
                            }
                        }
                        httpRoute = this.routePlanner.determineRoute(extractHost, httpRequestWrapper2, httpClientContext);
                        if (this.log.isDebugEnabled()) {
                            HttpClientAndroidLog httpClientAndroidLog = this.log;
                            httpClientAndroidLog.debug("Redirecting to '" + uri + "' via " + httpRoute);
                        }
                        EntityUtils.consume(execute.getEntity());
                        execute.close();
                    } else {
                        throw new ProtocolException("Redirect URI does not specify a valid host name: " + uri);
                    }
                } else {
                    throw new RedirectException("Maximum redirects (" + maxRedirects + ") exceeded");
                }
            } catch (RuntimeException e) {
                execute.close();
                throw e;
            } catch (IOException e2) {
                execute.close();
                throw e2;
            } catch (HttpException e3) {
                try {
                    EntityUtils.consume(execute.getEntity());
                } catch (IOException e4) {
                    this.log.debug("I/O error while releasing connection", e4);
                } catch (Throwable th) {
                    execute.close();
                    throw th;
                }
                execute.close();
                throw e3;
            }
        }
        return execute;
    }
}
