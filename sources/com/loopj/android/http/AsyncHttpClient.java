package com.loopj.android.http;

import android.content.Context;
import android.os.Looper;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PushbackInputStream;
import java.lang.reflect.Field;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.zip.GZIPInputStream;
import p052cz.msebera.android.httpclient.Header;
import p052cz.msebera.android.httpclient.HeaderElement;
import p052cz.msebera.android.httpclient.HttpEntity;
import p052cz.msebera.android.httpclient.HttpException;
import p052cz.msebera.android.httpclient.HttpHost;
import p052cz.msebera.android.httpclient.HttpRequest;
import p052cz.msebera.android.httpclient.HttpRequestInterceptor;
import p052cz.msebera.android.httpclient.HttpResponse;
import p052cz.msebera.android.httpclient.HttpResponseInterceptor;
import p052cz.msebera.android.httpclient.HttpVersion;
import p052cz.msebera.android.httpclient.auth.AuthScope;
import p052cz.msebera.android.httpclient.auth.AuthState;
import p052cz.msebera.android.httpclient.auth.Credentials;
import p052cz.msebera.android.httpclient.auth.UsernamePasswordCredentials;
import p052cz.msebera.android.httpclient.client.CookieStore;
import p052cz.msebera.android.httpclient.client.CredentialsProvider;
import p052cz.msebera.android.httpclient.client.HttpClient;
import p052cz.msebera.android.httpclient.client.RedirectHandler;
import p052cz.msebera.android.httpclient.client.methods.HttpEntityEnclosingRequestBase;
import p052cz.msebera.android.httpclient.client.methods.HttpHead;
import p052cz.msebera.android.httpclient.client.methods.HttpPatch;
import p052cz.msebera.android.httpclient.client.methods.HttpPost;
import p052cz.msebera.android.httpclient.client.methods.HttpPut;
import p052cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import p052cz.msebera.android.httpclient.client.params.ClientPNames;
import p052cz.msebera.android.httpclient.conn.ClientConnectionManager;
import p052cz.msebera.android.httpclient.conn.params.ConnManagerParams;
import p052cz.msebera.android.httpclient.conn.params.ConnPerRouteBean;
import p052cz.msebera.android.httpclient.conn.params.ConnRoutePNames;
import p052cz.msebera.android.httpclient.conn.scheme.PlainSocketFactory;
import p052cz.msebera.android.httpclient.conn.scheme.Scheme;
import p052cz.msebera.android.httpclient.conn.scheme.SchemeRegistry;
import p052cz.msebera.android.httpclient.conn.scheme.SocketFactory;
import p052cz.msebera.android.httpclient.conn.ssl.SSLSocketFactory;
import p052cz.msebera.android.httpclient.entity.HttpEntityWrapper;
import p052cz.msebera.android.httpclient.impl.auth.BasicScheme;
import p052cz.msebera.android.httpclient.impl.client.DefaultHttpClient;
import p052cz.msebera.android.httpclient.impl.conn.tsccm.ThreadSafeClientConnManager;
import p052cz.msebera.android.httpclient.params.BasicHttpParams;
import p052cz.msebera.android.httpclient.params.HttpConnectionParams;
import p052cz.msebera.android.httpclient.params.HttpParams;
import p052cz.msebera.android.httpclient.params.HttpProtocolParams;
import p052cz.msebera.android.httpclient.protocol.BasicHttpContext;
import p052cz.msebera.android.httpclient.protocol.HttpContext;
import p052cz.msebera.android.httpclient.protocol.SyncBasicHttpContext;

public class AsyncHttpClient {
    public static final int DEFAULT_MAX_CONNECTIONS = 10;
    public static final int DEFAULT_MAX_RETRIES = 5;
    public static final int DEFAULT_RETRY_SLEEP_TIME_MILLIS = 1500;
    public static final int DEFAULT_SOCKET_BUFFER_SIZE = 8192;
    public static final int DEFAULT_SOCKET_TIMEOUT = 10000;
    public static final String ENCODING_GZIP = "gzip";
    public static final String HEADER_ACCEPT_ENCODING = "Accept-Encoding";
    public static final String HEADER_CONTENT_DISPOSITION = "Content-Disposition";
    public static final String HEADER_CONTENT_ENCODING = "Content-Encoding";
    public static final String HEADER_CONTENT_RANGE = "Content-Range";
    public static final String HEADER_CONTENT_TYPE = "Content-Type";
    public static final String LOG_TAG = "AsyncHttpClient";
    public static LogInterface log = new LogHandler();
    /* access modifiers changed from: private */
    public final Map<String, String> clientHeaderMap;
    private int connectTimeout;
    private final DefaultHttpClient httpClient;
    private final HttpContext httpContext;
    private boolean isUrlEncodingEnabled;
    private int maxConnections;
    private final Map<Context, List<RequestHandle>> requestMap;
    private int responseTimeout;
    private ExecutorService threadPool;

    public AsyncHttpClient() {
        this(false, 80, 443);
    }

    public AsyncHttpClient(int i) {
        this(false, i, 443);
    }

    public AsyncHttpClient(int i, int i2) {
        this(false, i, i2);
    }

    public AsyncHttpClient(boolean z, int i, int i2) {
        this(getDefaultSchemeRegistry(z, i, i2));
    }

    public AsyncHttpClient(SchemeRegistry schemeRegistry) {
        this.maxConnections = 10;
        this.connectTimeout = 10000;
        this.responseTimeout = 10000;
        boolean z = true;
        this.isUrlEncodingEnabled = true;
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        ConnManagerParams.setTimeout(basicHttpParams, (long) this.connectTimeout);
        ConnManagerParams.setMaxConnectionsPerRoute(basicHttpParams, new ConnPerRouteBean(this.maxConnections));
        ConnManagerParams.setMaxTotalConnections(basicHttpParams, 10);
        HttpConnectionParams.setSoTimeout(basicHttpParams, this.responseTimeout);
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, this.connectTimeout);
        HttpConnectionParams.setTcpNoDelay(basicHttpParams, true);
        HttpConnectionParams.setSocketBufferSize(basicHttpParams, 8192);
        HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
        ClientConnectionManager createConnectionManager = createConnectionManager(schemeRegistry, basicHttpParams);
        Utils.asserts(createConnectionManager == null ? false : z, "Custom implementation of #createConnectionManager(SchemeRegistry, BasicHttpParams) returned null");
        this.threadPool = getDefaultThreadPool();
        this.requestMap = Collections.synchronizedMap(new WeakHashMap());
        this.clientHeaderMap = new HashMap();
        this.httpContext = new SyncBasicHttpContext(new BasicHttpContext());
        this.httpClient = new DefaultHttpClient(createConnectionManager, basicHttpParams);
        this.httpClient.addRequestInterceptor(new HttpRequestInterceptor() {
            public void process(HttpRequest httpRequest, HttpContext httpContext) {
                if (!httpRequest.containsHeader("Accept-Encoding")) {
                    httpRequest.addHeader("Accept-Encoding", AsyncHttpClient.ENCODING_GZIP);
                }
                for (String str : AsyncHttpClient.this.clientHeaderMap.keySet()) {
                    if (httpRequest.containsHeader(str)) {
                        Header firstHeader = httpRequest.getFirstHeader(str);
                        AsyncHttpClient.log.mo51334d(AsyncHttpClient.LOG_TAG, String.format("Headers were overwritten! (%s | %s) overwrites (%s | %s)", new Object[]{str, AsyncHttpClient.this.clientHeaderMap.get(str), firstHeader.getName(), firstHeader.getValue()}));
                        httpRequest.removeHeader(firstHeader);
                    }
                    httpRequest.addHeader(str, (String) AsyncHttpClient.this.clientHeaderMap.get(str));
                }
            }
        });
        this.httpClient.addResponseInterceptor(new HttpResponseInterceptor() {
            public void process(HttpResponse httpResponse, HttpContext httpContext) {
                Header contentEncoding;
                HttpEntity entity = httpResponse.getEntity();
                if (entity != null && (contentEncoding = entity.getContentEncoding()) != null) {
                    for (HeaderElement name : contentEncoding.getElements()) {
                        if (name.getName().equalsIgnoreCase(AsyncHttpClient.ENCODING_GZIP)) {
                            httpResponse.setEntity(new InflatingEntity(entity));
                            return;
                        }
                    }
                }
            }
        });
        this.httpClient.addRequestInterceptor(new HttpRequestInterceptor() {
            public void process(HttpRequest httpRequest, HttpContext httpContext) throws HttpException, IOException {
                Credentials credentials;
                AuthState authState = (AuthState) httpContext.getAttribute("http.auth.target-scope");
                CredentialsProvider credentialsProvider = (CredentialsProvider) httpContext.getAttribute("http.auth.credentials-provider");
                HttpHost httpHost = (HttpHost) httpContext.getAttribute("http.target_host");
                if (authState.getAuthScheme() == null && (credentials = credentialsProvider.getCredentials(new AuthScope(httpHost.getHostName(), httpHost.getPort()))) != null) {
                    authState.setAuthScheme(new BasicScheme());
                    authState.setCredentials(credentials);
                }
            }
        }, 0);
        this.httpClient.setHttpRequestRetryHandler(new RetryHandler(5, 1500));
    }

    private static SchemeRegistry getDefaultSchemeRegistry(boolean z, int i, int i2) {
        SSLSocketFactory sSLSocketFactory;
        if (z) {
            log.mo51334d(LOG_TAG, "Beware! Using the fix is insecure, as it doesn't verify SSL certificates.");
        }
        if (i < 1) {
            i = 80;
            log.mo51334d(LOG_TAG, "Invalid HTTP port number specified, defaulting to 80");
        }
        if (i2 < 1) {
            i2 = 443;
            log.mo51334d(LOG_TAG, "Invalid HTTPS port number specified, defaulting to 443");
        }
        if (z) {
            sSLSocketFactory = MySSLSocketFactory.getFixedSocketFactory();
        } else {
            sSLSocketFactory = SSLSocketFactory.getSocketFactory();
        }
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme(HttpHost.DEFAULT_SCHEME_NAME, (SocketFactory) PlainSocketFactory.getSocketFactory(), i));
        schemeRegistry.register(new Scheme("https", (SocketFactory) sSLSocketFactory, i2));
        return schemeRegistry;
    }

    public static void allowRetryExceptionClass(Class<?> cls) {
        if (cls != null) {
            RetryHandler.addClassToWhitelist(cls);
        }
    }

    public static void blockRetryExceptionClass(Class<?> cls) {
        if (cls != null) {
            RetryHandler.addClassToBlacklist(cls);
        }
    }

    public static String getUrlWithQueryString(boolean z, String str, RequestParams requestParams) {
        if (str == null) {
            return null;
        }
        if (z) {
            try {
                URL url = new URL(URLDecoder.decode(str, "UTF-8"));
                str = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef()).toASCIIString();
            } catch (Exception e) {
                log.mo51337e(LOG_TAG, "getUrlWithQueryString encoding URL", e);
            }
        }
        if (requestParams == null) {
            return str;
        }
        String trim = requestParams.getParamString().trim();
        if (trim.equals("")) {
            return str;
        }
        String str2 = "?";
        if (trim.equals(str2)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if (str.contains(str2)) {
            str2 = "&";
        }
        sb.append(str2);
        String sb2 = sb.toString();
        return sb2 + trim;
    }

    public static boolean isInputStreamGZIPCompressed(PushbackInputStream pushbackInputStream) throws IOException {
        if (pushbackInputStream == null) {
            return false;
        }
        byte[] bArr = new byte[2];
        int i = 0;
        while (i < 2) {
            try {
                int read = pushbackInputStream.read(bArr, i, 2 - i);
                if (read < 0) {
                    return false;
                }
                i += read;
            } finally {
                pushbackInputStream.unread(bArr, 0, i);
            }
        }
        pushbackInputStream.unread(bArr, 0, i);
        if (35615 == ((bArr[0] & 255) | ((bArr[1] << 8) & 65280))) {
            return true;
        }
        return false;
    }

    public static void silentCloseInputStream(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                log.mo51350w(LOG_TAG, "Cannot close input stream", e);
            }
        }
    }

    public static void silentCloseOutputStream(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                log.mo51350w(LOG_TAG, "Cannot close output stream", e);
            }
        }
    }

    public static void endEntityViaReflection(HttpEntity httpEntity) {
        if (httpEntity instanceof HttpEntityWrapper) {
            Field field = null;
            try {
                Field[] declaredFields = HttpEntityWrapper.class.getDeclaredFields();
                int length = declaredFields.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    Field field2 = declaredFields[i];
                    if (field2.getName().equals("wrappedEntity")) {
                        field = field2;
                        break;
                    }
                    i++;
                }
                if (field != null) {
                    field.setAccessible(true);
                    HttpEntity httpEntity2 = (HttpEntity) field.get(httpEntity);
                    if (httpEntity2 != null) {
                        httpEntity2.consumeContent();
                    }
                }
            } catch (Throwable th) {
                log.mo51337e(LOG_TAG, "wrappedEntity consume", th);
            }
        }
    }

    public HttpClient getHttpClient() {
        return this.httpClient;
    }

    public HttpContext getHttpContext() {
        return this.httpContext;
    }

    public boolean isLoggingEnabled() {
        return log.isLoggingEnabled();
    }

    public void setLoggingEnabled(boolean z) {
        log.setLoggingEnabled(z);
    }

    public int getLoggingLevel() {
        return log.getLoggingLevel();
    }

    public void setLoggingLevel(int i) {
        log.setLoggingLevel(i);
    }

    public LogInterface getLogInterface() {
        return log;
    }

    public void setLogInterface(LogInterface logInterface) {
        if (logInterface != null) {
            log = logInterface;
        }
    }

    public void setCookieStore(CookieStore cookieStore) {
        this.httpContext.setAttribute("http.cookie-store", cookieStore);
    }

    public ExecutorService getThreadPool() {
        return this.threadPool;
    }

    public void setThreadPool(ExecutorService executorService) {
        this.threadPool = executorService;
    }

    /* access modifiers changed from: protected */
    public ExecutorService getDefaultThreadPool() {
        return Executors.newCachedThreadPool();
    }

    /* access modifiers changed from: protected */
    public ClientConnectionManager createConnectionManager(SchemeRegistry schemeRegistry, BasicHttpParams basicHttpParams) {
        return new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry);
    }

    public void setEnableRedirects(boolean z, boolean z2, boolean z3) {
        this.httpClient.getParams().setBooleanParameter(ClientPNames.REJECT_RELATIVE_REDIRECT, !z2);
        this.httpClient.getParams().setBooleanParameter(ClientPNames.ALLOW_CIRCULAR_REDIRECTS, z3);
        this.httpClient.setRedirectHandler(new MyRedirectHandler(z));
    }

    public void setEnableRedirects(boolean z, boolean z2) {
        setEnableRedirects(z, z2, true);
    }

    public void setEnableRedirects(boolean z) {
        setEnableRedirects(z, z, z);
    }

    public void setRedirectHandler(RedirectHandler redirectHandler) {
        this.httpClient.setRedirectHandler(redirectHandler);
    }

    public void setUserAgent(String str) {
        HttpProtocolParams.setUserAgent(this.httpClient.getParams(), str);
    }

    public int getMaxConnections() {
        return this.maxConnections;
    }

    public void setMaxConnections(int i) {
        if (i < 1) {
            i = 10;
        }
        this.maxConnections = i;
        ConnManagerParams.setMaxConnectionsPerRoute(this.httpClient.getParams(), new ConnPerRouteBean(this.maxConnections));
    }

    public void setTimeout(int i) {
        if (i < 1000) {
            i = 10000;
        }
        setConnectTimeout(i);
        setResponseTimeout(i);
    }

    public int getConnectTimeout() {
        return this.connectTimeout;
    }

    public void setConnectTimeout(int i) {
        if (i < 1000) {
            i = 10000;
        }
        this.connectTimeout = i;
        HttpParams params = this.httpClient.getParams();
        ConnManagerParams.setTimeout(params, (long) this.connectTimeout);
        HttpConnectionParams.setConnectionTimeout(params, this.connectTimeout);
    }

    public int getResponseTimeout() {
        return this.responseTimeout;
    }

    public void setResponseTimeout(int i) {
        if (i < 1000) {
            i = 10000;
        }
        this.responseTimeout = i;
        HttpConnectionParams.setSoTimeout(this.httpClient.getParams(), this.responseTimeout);
    }

    public void setProxy(String str, int i) {
        this.httpClient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, new HttpHost(str, i));
    }

    public void setProxy(String str, int i, String str2, String str3) {
        this.httpClient.getCredentialsProvider().setCredentials(new AuthScope(str, i), new UsernamePasswordCredentials(str2, str3));
        this.httpClient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, new HttpHost(str, i));
    }

    public void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.httpClient.getConnectionManager().getSchemeRegistry().register(new Scheme("https", (SocketFactory) sSLSocketFactory, 443));
    }

    public void setMaxRetriesAndTimeout(int i, int i2) {
        this.httpClient.setHttpRequestRetryHandler(new RetryHandler(i, i2));
    }

    public void removeAllHeaders() {
        this.clientHeaderMap.clear();
    }

    public void addHeader(String str, String str2) {
        this.clientHeaderMap.put(str, str2);
    }

    public void removeHeader(String str) {
        this.clientHeaderMap.remove(str);
    }

    public void setBasicAuth(String str, String str2) {
        setBasicAuth(str, str2, false);
    }

    public void setBasicAuth(String str, String str2, boolean z) {
        setBasicAuth(str, str2, (AuthScope) null, z);
    }

    public void setBasicAuth(String str, String str2, AuthScope authScope) {
        setBasicAuth(str, str2, authScope, false);
    }

    public void setBasicAuth(String str, String str2, AuthScope authScope, boolean z) {
        setCredentials(authScope, new UsernamePasswordCredentials(str, str2));
        setAuthenticationPreemptive(z);
    }

    public void setCredentials(AuthScope authScope, Credentials credentials) {
        if (credentials == null) {
            log.mo51334d(LOG_TAG, "Provided credentials are null, not setting");
            return;
        }
        CredentialsProvider credentialsProvider = this.httpClient.getCredentialsProvider();
        if (authScope == null) {
            authScope = AuthScope.ANY;
        }
        credentialsProvider.setCredentials(authScope, credentials);
    }

    public void setAuthenticationPreemptive(boolean z) {
        if (z) {
            this.httpClient.addRequestInterceptor(new PreemptiveAuthorizationHttpRequestInterceptor(), 0);
        } else {
            this.httpClient.removeRequestInterceptorByClass(PreemptiveAuthorizationHttpRequestInterceptor.class);
        }
    }

    public void clearCredentialsProvider() {
        this.httpClient.getCredentialsProvider().clear();
    }

    public void cancelRequests(Context context, final boolean z) {
        if (context == null) {
            log.mo51336e(LOG_TAG, "Passed null Context to cancelRequests");
            return;
        }
        final List list = this.requestMap.get(context);
        this.requestMap.remove(context);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.threadPool.submit(new Runnable() {
                public void run() {
                    AsyncHttpClient.this.cancelRequests((List<RequestHandle>) list, z);
                }
            });
            return;
        }
        cancelRequests((List<RequestHandle>) list, z);
    }

    /* access modifiers changed from: private */
    public void cancelRequests(List<RequestHandle> list, boolean z) {
        if (list != null) {
            for (RequestHandle cancel : list) {
                cancel.cancel(z);
            }
        }
    }

    public void cancelAllRequests(boolean z) {
        for (List<RequestHandle> next : this.requestMap.values()) {
            if (next != null) {
                for (RequestHandle cancel : next) {
                    cancel.cancel(z);
                }
            }
        }
        this.requestMap.clear();
    }

    public void cancelRequestsByTAG(Object obj, boolean z) {
        if (obj == null) {
            log.mo51334d(LOG_TAG, "cancelRequestsByTAG, passed TAG is null, cannot proceed");
            return;
        }
        for (List<RequestHandle> next : this.requestMap.values()) {
            if (next != null) {
                for (RequestHandle requestHandle : next) {
                    if (obj.equals(requestHandle.getTag())) {
                        requestHandle.cancel(z);
                    }
                }
            }
        }
    }

    public RequestHandle head(String str, ResponseHandlerInterface responseHandlerInterface) {
        return head((Context) null, str, (RequestParams) null, responseHandlerInterface);
    }

    public RequestHandle head(String str, RequestParams requestParams, ResponseHandlerInterface responseHandlerInterface) {
        return head((Context) null, str, requestParams, responseHandlerInterface);
    }

    public RequestHandle head(Context context, String str, ResponseHandlerInterface responseHandlerInterface) {
        return head(context, str, (RequestParams) null, responseHandlerInterface);
    }

    public RequestHandle head(Context context, String str, RequestParams requestParams, ResponseHandlerInterface responseHandlerInterface) {
        return sendRequest(this.httpClient, this.httpContext, new HttpHead(getUrlWithQueryString(this.isUrlEncodingEnabled, str, requestParams)), (String) null, responseHandlerInterface, context);
    }

    public RequestHandle head(Context context, String str, Header[] headerArr, RequestParams requestParams, ResponseHandlerInterface responseHandlerInterface) {
        HttpHead httpHead = new HttpHead(getUrlWithQueryString(this.isUrlEncodingEnabled, str, requestParams));
        if (headerArr != null) {
            httpHead.setHeaders(headerArr);
        }
        return sendRequest(this.httpClient, this.httpContext, httpHead, (String) null, responseHandlerInterface, context);
    }

    public RequestHandle get(String str, ResponseHandlerInterface responseHandlerInterface) {
        return get((Context) null, str, (RequestParams) null, responseHandlerInterface);
    }

    public RequestHandle get(String str, RequestParams requestParams, ResponseHandlerInterface responseHandlerInterface) {
        return get((Context) null, str, requestParams, responseHandlerInterface);
    }

    public RequestHandle get(Context context, String str, ResponseHandlerInterface responseHandlerInterface) {
        return get(context, str, (RequestParams) null, responseHandlerInterface);
    }

    public RequestHandle get(Context context, String str, RequestParams requestParams, ResponseHandlerInterface responseHandlerInterface) {
        return sendRequest(this.httpClient, this.httpContext, new HttpGet(getUrlWithQueryString(this.isUrlEncodingEnabled, str, requestParams)), (String) null, responseHandlerInterface, context);
    }

    public RequestHandle get(Context context, String str, Header[] headerArr, RequestParams requestParams, ResponseHandlerInterface responseHandlerInterface) {
        HttpGet httpGet = new HttpGet(getUrlWithQueryString(this.isUrlEncodingEnabled, str, requestParams));
        if (headerArr != null) {
            httpGet.setHeaders(headerArr);
        }
        return sendRequest(this.httpClient, this.httpContext, httpGet, (String) null, responseHandlerInterface, context);
    }

    public RequestHandle get(Context context, String str, HttpEntity httpEntity, String str2, ResponseHandlerInterface responseHandlerInterface) {
        return sendRequest(this.httpClient, this.httpContext, addEntityToRequestBase(new HttpGet(URI.create(str).normalize()), httpEntity), str2, responseHandlerInterface, context);
    }

    public RequestHandle post(String str, ResponseHandlerInterface responseHandlerInterface) {
        return post((Context) null, str, (RequestParams) null, responseHandlerInterface);
    }

    public RequestHandle post(String str, RequestParams requestParams, ResponseHandlerInterface responseHandlerInterface) {
        return post((Context) null, str, requestParams, responseHandlerInterface);
    }

    public RequestHandle post(Context context, String str, RequestParams requestParams, ResponseHandlerInterface responseHandlerInterface) {
        return post(context, str, paramsToEntity(requestParams, responseHandlerInterface), (String) null, responseHandlerInterface);
    }

    public RequestHandle post(Context context, String str, HttpEntity httpEntity, String str2, ResponseHandlerInterface responseHandlerInterface) {
        return sendRequest(this.httpClient, this.httpContext, addEntityToRequestBase(new HttpPost(getURI(str)), httpEntity), str2, responseHandlerInterface, context);
    }

    public RequestHandle post(Context context, String str, Header[] headerArr, RequestParams requestParams, String str2, ResponseHandlerInterface responseHandlerInterface) {
        HttpPost httpPost = new HttpPost(getURI(str));
        if (requestParams != null) {
            httpPost.setEntity(paramsToEntity(requestParams, responseHandlerInterface));
        }
        if (headerArr != null) {
            httpPost.setHeaders(headerArr);
        }
        return sendRequest(this.httpClient, this.httpContext, httpPost, str2, responseHandlerInterface, context);
    }

    public RequestHandle post(Context context, String str, Header[] headerArr, HttpEntity httpEntity, String str2, ResponseHandlerInterface responseHandlerInterface) {
        HttpEntityEnclosingRequestBase addEntityToRequestBase = addEntityToRequestBase(new HttpPost(getURI(str)), httpEntity);
        if (headerArr != null) {
            addEntityToRequestBase.setHeaders(headerArr);
        }
        return sendRequest(this.httpClient, this.httpContext, addEntityToRequestBase, str2, responseHandlerInterface, context);
    }

    public RequestHandle put(String str, ResponseHandlerInterface responseHandlerInterface) {
        return put((Context) null, str, (RequestParams) null, responseHandlerInterface);
    }

    public RequestHandle put(String str, RequestParams requestParams, ResponseHandlerInterface responseHandlerInterface) {
        return put((Context) null, str, requestParams, responseHandlerInterface);
    }

    public RequestHandle put(Context context, String str, RequestParams requestParams, ResponseHandlerInterface responseHandlerInterface) {
        return put(context, str, paramsToEntity(requestParams, responseHandlerInterface), (String) null, responseHandlerInterface);
    }

    public RequestHandle put(Context context, String str, HttpEntity httpEntity, String str2, ResponseHandlerInterface responseHandlerInterface) {
        return sendRequest(this.httpClient, this.httpContext, addEntityToRequestBase(new HttpPut(getURI(str)), httpEntity), str2, responseHandlerInterface, context);
    }

    public RequestHandle put(Context context, String str, Header[] headerArr, HttpEntity httpEntity, String str2, ResponseHandlerInterface responseHandlerInterface) {
        HttpEntityEnclosingRequestBase addEntityToRequestBase = addEntityToRequestBase(new HttpPut(getURI(str)), httpEntity);
        if (headerArr != null) {
            addEntityToRequestBase.setHeaders(headerArr);
        }
        return sendRequest(this.httpClient, this.httpContext, addEntityToRequestBase, str2, responseHandlerInterface, context);
    }

    public RequestHandle patch(String str, ResponseHandlerInterface responseHandlerInterface) {
        return patch((Context) null, str, (RequestParams) null, responseHandlerInterface);
    }

    public RequestHandle patch(String str, RequestParams requestParams, ResponseHandlerInterface responseHandlerInterface) {
        return patch((Context) null, str, requestParams, responseHandlerInterface);
    }

    public RequestHandle patch(Context context, String str, RequestParams requestParams, ResponseHandlerInterface responseHandlerInterface) {
        return patch(context, str, paramsToEntity(requestParams, responseHandlerInterface), (String) null, responseHandlerInterface);
    }

    public RequestHandle patch(Context context, String str, HttpEntity httpEntity, String str2, ResponseHandlerInterface responseHandlerInterface) {
        return sendRequest(this.httpClient, this.httpContext, addEntityToRequestBase(new HttpPatch(getURI(str)), httpEntity), str2, responseHandlerInterface, context);
    }

    public RequestHandle patch(Context context, String str, Header[] headerArr, HttpEntity httpEntity, String str2, ResponseHandlerInterface responseHandlerInterface) {
        HttpEntityEnclosingRequestBase addEntityToRequestBase = addEntityToRequestBase(new HttpPatch(getURI(str)), httpEntity);
        if (headerArr != null) {
            addEntityToRequestBase.setHeaders(headerArr);
        }
        return sendRequest(this.httpClient, this.httpContext, addEntityToRequestBase, str2, responseHandlerInterface, context);
    }

    public RequestHandle delete(String str, ResponseHandlerInterface responseHandlerInterface) {
        return delete((Context) null, str, responseHandlerInterface);
    }

    public RequestHandle delete(Context context, String str, ResponseHandlerInterface responseHandlerInterface) {
        return sendRequest(this.httpClient, this.httpContext, new HttpDelete(getURI(str)), (String) null, responseHandlerInterface, context);
    }

    public RequestHandle delete(Context context, String str, Header[] headerArr, ResponseHandlerInterface responseHandlerInterface) {
        HttpDelete httpDelete = new HttpDelete(getURI(str));
        if (headerArr != null) {
            httpDelete.setHeaders(headerArr);
        }
        return sendRequest(this.httpClient, this.httpContext, httpDelete, (String) null, responseHandlerInterface, context);
    }

    public void delete(String str, RequestParams requestParams, AsyncHttpResponseHandler asyncHttpResponseHandler) {
        sendRequest(this.httpClient, this.httpContext, new HttpDelete(getUrlWithQueryString(this.isUrlEncodingEnabled, str, requestParams)), (String) null, asyncHttpResponseHandler, (Context) null);
    }

    public RequestHandle delete(Context context, String str, Header[] headerArr, RequestParams requestParams, ResponseHandlerInterface responseHandlerInterface) {
        HttpDelete httpDelete = new HttpDelete(getUrlWithQueryString(this.isUrlEncodingEnabled, str, requestParams));
        if (headerArr != null) {
            httpDelete.setHeaders(headerArr);
        }
        return sendRequest(this.httpClient, this.httpContext, httpDelete, (String) null, responseHandlerInterface, context);
    }

    public RequestHandle delete(Context context, String str, HttpEntity httpEntity, String str2, ResponseHandlerInterface responseHandlerInterface) {
        return sendRequest(this.httpClient, this.httpContext, addEntityToRequestBase(new HttpDelete(URI.create(str).normalize()), httpEntity), str2, responseHandlerInterface, context);
    }

    /* access modifiers changed from: protected */
    public AsyncHttpRequest newAsyncHttpRequest(DefaultHttpClient defaultHttpClient, HttpContext httpContext2, HttpUriRequest httpUriRequest, String str, ResponseHandlerInterface responseHandlerInterface, Context context) {
        return new AsyncHttpRequest(defaultHttpClient, httpContext2, httpUriRequest, responseHandlerInterface);
    }

    /* access modifiers changed from: protected */
    public RequestHandle sendRequest(DefaultHttpClient defaultHttpClient, HttpContext httpContext2, HttpUriRequest httpUriRequest, String str, ResponseHandlerInterface responseHandlerInterface, Context context) {
        List list;
        if (httpUriRequest == null) {
            throw new IllegalArgumentException("HttpUriRequest must not be null");
        } else if (responseHandlerInterface == null) {
            throw new IllegalArgumentException("ResponseHandler must not be null");
        } else if (!responseHandlerInterface.getUseSynchronousMode() || responseHandlerInterface.getUsePoolThread()) {
            if (str != null) {
                if (!(httpUriRequest instanceof HttpEntityEnclosingRequestBase) || ((HttpEntityEnclosingRequestBase) httpUriRequest).getEntity() == null || !httpUriRequest.containsHeader("Content-Type")) {
                    httpUriRequest.setHeader("Content-Type", str);
                } else {
                    log.mo51349w(LOG_TAG, "Passed contentType will be ignored because HttpEntity sets content type");
                }
            }
            responseHandlerInterface.setRequestHeaders(httpUriRequest.getAllHeaders());
            responseHandlerInterface.setRequestURI(httpUriRequest.getURI());
            AsyncHttpRequest newAsyncHttpRequest = newAsyncHttpRequest(defaultHttpClient, httpContext2, httpUriRequest, str, responseHandlerInterface, context);
            this.threadPool.submit(newAsyncHttpRequest);
            RequestHandle requestHandle = new RequestHandle(newAsyncHttpRequest);
            if (context != null) {
                synchronized (this.requestMap) {
                    list = this.requestMap.get(context);
                    if (list == null) {
                        list = Collections.synchronizedList(new LinkedList());
                        this.requestMap.put(context, list);
                    }
                }
                list.add(requestHandle);
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    if (((RequestHandle) it.next()).shouldBeGarbageCollected()) {
                        it.remove();
                    }
                }
            }
            return requestHandle;
        } else {
            throw new IllegalArgumentException("Synchronous ResponseHandler used in AsyncHttpClient. You should create your response handler in a looper thread or use SyncHttpClient instead.");
        }
    }

    /* access modifiers changed from: protected */
    public URI getURI(String str) {
        return URI.create(str).normalize();
    }

    public void setURLEncodingEnabled(boolean z) {
        this.isUrlEncodingEnabled = z;
    }

    private HttpEntity paramsToEntity(RequestParams requestParams, ResponseHandlerInterface responseHandlerInterface) {
        if (requestParams == null) {
            return null;
        }
        try {
            return requestParams.getEntity(responseHandlerInterface);
        } catch (IOException e) {
            if (responseHandlerInterface != null) {
                responseHandlerInterface.sendFailureMessage(0, (Header[]) null, (byte[]) null, e);
                return null;
            }
            e.printStackTrace();
            return null;
        }
    }

    public boolean isUrlEncodingEnabled() {
        return this.isUrlEncodingEnabled;
    }

    private HttpEntityEnclosingRequestBase addEntityToRequestBase(HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase, HttpEntity httpEntity) {
        if (httpEntity != null) {
            httpEntityEnclosingRequestBase.setEntity(httpEntity);
        }
        return httpEntityEnclosingRequestBase;
    }

    private static class InflatingEntity extends HttpEntityWrapper {
        GZIPInputStream gzippedStream;
        PushbackInputStream pushbackStream;
        InputStream wrappedStream;

        public InflatingEntity(HttpEntity httpEntity) {
            super(httpEntity);
        }

        public InputStream getContent() throws IOException {
            this.wrappedStream = this.wrappedEntity.getContent();
            this.pushbackStream = new PushbackInputStream(this.wrappedStream, 2);
            if (!AsyncHttpClient.isInputStreamGZIPCompressed(this.pushbackStream)) {
                return this.pushbackStream;
            }
            this.gzippedStream = new GZIPInputStream(this.pushbackStream);
            return this.gzippedStream;
        }

        public long getContentLength() {
            if (this.wrappedEntity == null) {
                return 0;
            }
            return this.wrappedEntity.getContentLength();
        }

        public void consumeContent() throws IOException {
            AsyncHttpClient.silentCloseInputStream(this.wrappedStream);
            AsyncHttpClient.silentCloseInputStream(this.pushbackStream);
            AsyncHttpClient.silentCloseInputStream(this.gzippedStream);
            super.consumeContent();
        }
    }
}
