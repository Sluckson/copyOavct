package p052cz.msebera.android.httpclient;

import java.io.Serializable;
import java.net.InetAddress;
import java.util.Locale;
import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.util.Args;
import p052cz.msebera.android.httpclient.util.LangUtils;

@Immutable
/* renamed from: cz.msebera.android.httpclient.HttpHost */
public final class HttpHost implements Cloneable, Serializable {
    public static final String DEFAULT_SCHEME_NAME = "http";
    private static final long serialVersionUID = -7529410654042457626L;
    protected final InetAddress address;
    protected final String hostname;
    protected final String lcHostname;
    protected final int port;
    protected final String schemeName;

    public HttpHost(String str, int i, String str2) {
        this.hostname = (String) Args.notBlank(str, "Host name");
        this.lcHostname = str.toLowerCase(Locale.ENGLISH);
        if (str2 != null) {
            this.schemeName = str2.toLowerCase(Locale.ENGLISH);
        } else {
            this.schemeName = DEFAULT_SCHEME_NAME;
        }
        this.port = i;
        this.address = null;
    }

    public HttpHost(String str, int i) {
        this(str, i, (String) null);
    }

    public HttpHost(String str) {
        this(str, -1, (String) null);
    }

    public HttpHost(InetAddress inetAddress, int i, String str) {
        this.address = (InetAddress) Args.notNull(inetAddress, "Inet address");
        this.hostname = inetAddress.getHostAddress();
        this.lcHostname = this.hostname.toLowerCase(Locale.ENGLISH);
        if (str != null) {
            this.schemeName = str.toLowerCase(Locale.ENGLISH);
        } else {
            this.schemeName = DEFAULT_SCHEME_NAME;
        }
        this.port = i;
    }

    public HttpHost(InetAddress inetAddress, int i) {
        this(inetAddress, i, (String) null);
    }

    public HttpHost(InetAddress inetAddress) {
        this(inetAddress, -1, (String) null);
    }

    public HttpHost(HttpHost httpHost) {
        Args.notNull(httpHost, "HTTP host");
        this.hostname = httpHost.hostname;
        this.lcHostname = httpHost.lcHostname;
        this.schemeName = httpHost.schemeName;
        this.port = httpHost.port;
        this.address = httpHost.address;
    }

    public String getHostName() {
        return this.hostname;
    }

    public int getPort() {
        return this.port;
    }

    public String getSchemeName() {
        return this.schemeName;
    }

    public InetAddress getAddress() {
        return this.address;
    }

    public String toURI() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.schemeName);
        sb.append("://");
        sb.append(this.hostname);
        if (this.port != -1) {
            sb.append(':');
            sb.append(Integer.toString(this.port));
        }
        return sb.toString();
    }

    public String toHostString() {
        if (this.port == -1) {
            return this.hostname;
        }
        StringBuilder sb = new StringBuilder(this.hostname.length() + 6);
        sb.append(this.hostname);
        sb.append(":");
        sb.append(Integer.toString(this.port));
        return sb.toString();
    }

    public String toString() {
        return toURI();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HttpHost)) {
            return false;
        }
        HttpHost httpHost = (HttpHost) obj;
        if (!this.lcHostname.equals(httpHost.lcHostname) || this.port != httpHost.port || !this.schemeName.equals(httpHost.schemeName)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return LangUtils.hashCode(LangUtils.hashCode(LangUtils.hashCode(17, (Object) this.lcHostname), this.port), (Object) this.schemeName);
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
