package com.medallia.digital.mobilesdk;

import com.medallia.digital.mobilesdk.C3697r0;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/* renamed from: com.medallia.digital.mobilesdk.k2 */
class C3594k2 extends C3493e4<String> {
    protected C3594k2(C3482d4 d4Var, C3612m0 m0Var) {
        super(d4Var, m0Var);
    }

    /* renamed from: o */
    private String m1054o() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (true) {
                    if (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement = inetAddresses.nextElement();
                        if (!nextElement.isLinkLocalAddress() && !nextElement.isLoopbackAddress() && (nextElement instanceof Inet4Address)) {
                            return nextElement.getHostAddress();
                        }
                    }
                }
            }
            return "";
        } catch (SocketException e) {
            C3490e3.m663c(e.getMessage());
            return "";
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public CollectorContract mo55204c() {
        return C3697r0.C3698a.f1762p;
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public String m1057j() {
        return m1054o();
    }
}
