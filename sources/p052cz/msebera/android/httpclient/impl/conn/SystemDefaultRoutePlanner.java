package p052cz.msebera.android.httpclient.impl.conn;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import p052cz.msebera.android.httpclient.HttpException;
import p052cz.msebera.android.httpclient.HttpHost;
import p052cz.msebera.android.httpclient.HttpRequest;
import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.conn.SchemePortResolver;
import p052cz.msebera.android.httpclient.protocol.HttpContext;

@Immutable
/* renamed from: cz.msebera.android.httpclient.impl.conn.SystemDefaultRoutePlanner */
public class SystemDefaultRoutePlanner extends DefaultRoutePlanner {
    private final ProxySelector proxySelector;

    public SystemDefaultRoutePlanner(SchemePortResolver schemePortResolver, ProxySelector proxySelector2) {
        super(schemePortResolver);
        this.proxySelector = proxySelector2 == null ? ProxySelector.getDefault() : proxySelector2;
    }

    public SystemDefaultRoutePlanner(ProxySelector proxySelector2) {
        this((SchemePortResolver) null, proxySelector2);
    }

    /* access modifiers changed from: protected */
    public HttpHost determineProxy(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws HttpException {
        try {
            Proxy chooseProxy = chooseProxy(this.proxySelector.select(new URI(httpHost.toURI())));
            if (chooseProxy.type() != Proxy.Type.HTTP) {
                return null;
            }
            if (chooseProxy.address() instanceof InetSocketAddress) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) chooseProxy.address();
                return new HttpHost(getHost(inetSocketAddress), inetSocketAddress.getPort());
            }
            throw new HttpException("Unable to handle non-Inet proxy address: " + chooseProxy.address());
        } catch (URISyntaxException e) {
            throw new HttpException("Cannot convert host to URI: " + httpHost, e);
        }
    }

    private String getHost(InetSocketAddress inetSocketAddress) {
        return inetSocketAddress.isUnresolved() ? inetSocketAddress.getHostName() : inetSocketAddress.getAddress().getHostAddress();
    }

    private Proxy chooseProxy(List<Proxy> list) {
        Proxy proxy = null;
        int i = 0;
        while (proxy == null && i < list.size()) {
            Proxy proxy2 = list.get(i);
            int i2 = C43601.$SwitchMap$java$net$Proxy$Type[proxy2.type().ordinal()];
            if (i2 == 1 || i2 == 2) {
                proxy = proxy2;
            }
            i++;
        }
        return proxy == null ? Proxy.NO_PROXY : proxy;
    }

    /* renamed from: cz.msebera.android.httpclient.impl.conn.SystemDefaultRoutePlanner$1 */
    static /* synthetic */ class C43601 {
        static final /* synthetic */ int[] $SwitchMap$java$net$Proxy$Type = new int[Proxy.Type.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                java.net.Proxy$Type[] r0 = java.net.Proxy.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$java$net$Proxy$Type = r0
                int[] r0 = $SwitchMap$java$net$Proxy$Type     // Catch:{ NoSuchFieldError -> 0x0014 }
                java.net.Proxy$Type r1 = java.net.Proxy.Type.DIRECT     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = $SwitchMap$java$net$Proxy$Type     // Catch:{ NoSuchFieldError -> 0x001f }
                java.net.Proxy$Type r1 = java.net.Proxy.Type.HTTP     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = $SwitchMap$java$net$Proxy$Type     // Catch:{ NoSuchFieldError -> 0x002a }
                java.net.Proxy$Type r1 = java.net.Proxy.Type.SOCKS     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p052cz.msebera.android.httpclient.impl.conn.SystemDefaultRoutePlanner.C43601.<clinit>():void");
        }
    }
}
