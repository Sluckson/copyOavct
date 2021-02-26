package p052cz.msebera.android.httpclient.util;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

/* renamed from: cz.msebera.android.httpclient.util.NetUtils */
public final class NetUtils {
    public static void formatAddress(StringBuilder sb, SocketAddress socketAddress) {
        Args.notNull(sb, "Buffer");
        Args.notNull(socketAddress, "Socket address");
        if (socketAddress instanceof InetSocketAddress) {
            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddress;
            InetAddress address = inetSocketAddress.getAddress();
            Object obj = address;
            if (address != null) {
                obj = address.getHostAddress();
            }
            sb.append(obj);
            sb.append(':');
            sb.append(inetSocketAddress.getPort());
            return;
        }
        sb.append(socketAddress);
    }
}
