package p052cz.msebera.android.httpclient.impl.conn;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import p052cz.msebera.android.httpclient.HttpHost;
import p052cz.msebera.android.httpclient.conn.ClientConnectionOperator;
import p052cz.msebera.android.httpclient.conn.OperatedClientConnection;
import p052cz.msebera.android.httpclient.conn.routing.HttpRoute;
import p052cz.msebera.android.httpclient.conn.routing.RouteTracker;
import p052cz.msebera.android.httpclient.params.HttpParams;
import p052cz.msebera.android.httpclient.protocol.HttpContext;
import p052cz.msebera.android.httpclient.util.Args;
import p052cz.msebera.android.httpclient.util.Asserts;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.impl.conn.AbstractPoolEntry */
public abstract class AbstractPoolEntry {
    protected final ClientConnectionOperator connOperator;
    protected final OperatedClientConnection connection;
    protected volatile HttpRoute route;
    protected volatile Object state;
    protected volatile RouteTracker tracker = null;

    protected AbstractPoolEntry(ClientConnectionOperator clientConnectionOperator, HttpRoute httpRoute) {
        Args.notNull(clientConnectionOperator, "Connection operator");
        this.connOperator = clientConnectionOperator;
        this.connection = clientConnectionOperator.createConnection();
        this.route = httpRoute;
    }

    public Object getState() {
        return this.state;
    }

    public void setState(Object obj) {
        this.state = obj;
    }

    public void open(HttpRoute httpRoute, HttpContext httpContext, HttpParams httpParams) throws IOException {
        HttpHost httpHost;
        Args.notNull(httpRoute, "Route");
        Args.notNull(httpParams, "HTTP parameters");
        if (this.tracker != null) {
            Asserts.check(!this.tracker.isConnected(), "Connection already open");
        }
        this.tracker = new RouteTracker(httpRoute);
        HttpHost proxyHost = httpRoute.getProxyHost();
        ClientConnectionOperator clientConnectionOperator = this.connOperator;
        OperatedClientConnection operatedClientConnection = this.connection;
        if (proxyHost != null) {
            httpHost = proxyHost;
        } else {
            httpHost = httpRoute.getTargetHost();
        }
        clientConnectionOperator.openConnection(operatedClientConnection, httpHost, httpRoute.getLocalAddress(), httpContext, httpParams);
        RouteTracker routeTracker = this.tracker;
        if (routeTracker == null) {
            throw new InterruptedIOException("Request aborted");
        } else if (proxyHost == null) {
            routeTracker.connectTarget(this.connection.isSecure());
        } else {
            routeTracker.connectProxy(proxyHost, this.connection.isSecure());
        }
    }

    public void tunnelTarget(boolean z, HttpParams httpParams) throws IOException {
        Args.notNull(httpParams, "HTTP parameters");
        Asserts.notNull(this.tracker, "Route tracker");
        Asserts.check(this.tracker.isConnected(), "Connection not open");
        Asserts.check(!this.tracker.isTunnelled(), "Connection is already tunnelled");
        this.connection.update((Socket) null, this.tracker.getTargetHost(), z, httpParams);
        this.tracker.tunnelTarget(z);
    }

    public void tunnelProxy(HttpHost httpHost, boolean z, HttpParams httpParams) throws IOException {
        Args.notNull(httpHost, "Next proxy");
        Args.notNull(httpParams, "Parameters");
        Asserts.notNull(this.tracker, "Route tracker");
        Asserts.check(this.tracker.isConnected(), "Connection not open");
        this.connection.update((Socket) null, httpHost, z, httpParams);
        this.tracker.tunnelProxy(httpHost, z);
    }

    public void layerProtocol(HttpContext httpContext, HttpParams httpParams) throws IOException {
        Args.notNull(httpParams, "HTTP parameters");
        Asserts.notNull(this.tracker, "Route tracker");
        Asserts.check(this.tracker.isConnected(), "Connection not open");
        Asserts.check(this.tracker.isTunnelled(), "Protocol layering without a tunnel not supported");
        Asserts.check(!this.tracker.isLayered(), "Multiple protocol layering not supported");
        this.connOperator.updateSecureConnection(this.connection, this.tracker.getTargetHost(), httpContext, httpParams);
        this.tracker.layerProtocol(this.connection.isSecure());
    }

    /* access modifiers changed from: protected */
    public void shutdownEntry() {
        this.tracker = null;
        this.state = null;
    }
}
