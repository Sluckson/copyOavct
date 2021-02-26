package p052cz.msebera.android.httpclient.impl.conn;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import p052cz.msebera.android.httpclient.conn.DnsResolver;
import p052cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import p052cz.msebera.android.httpclient.util.Args;

/* renamed from: cz.msebera.android.httpclient.impl.conn.InMemoryDnsResolver */
public class InMemoryDnsResolver implements DnsResolver {
    private final Map<String, InetAddress[]> dnsMap = new ConcurrentHashMap();
    public HttpClientAndroidLog log = new HttpClientAndroidLog(InMemoryDnsResolver.class);

    public void add(String str, InetAddress... inetAddressArr) {
        Args.notNull(str, "Host name");
        Args.notNull(inetAddressArr, "Array of IP addresses");
        this.dnsMap.put(str, inetAddressArr);
    }

    public InetAddress[] resolve(String str) throws UnknownHostException {
        InetAddress[] inetAddressArr = this.dnsMap.get(str);
        if (this.log.isInfoEnabled()) {
            HttpClientAndroidLog httpClientAndroidLog = this.log;
            httpClientAndroidLog.info("Resolving " + str + " to " + Arrays.deepToString(inetAddressArr));
        }
        if (inetAddressArr != null) {
            return inetAddressArr;
        }
        throw new UnknownHostException(str + " cannot be resolved");
    }
}
