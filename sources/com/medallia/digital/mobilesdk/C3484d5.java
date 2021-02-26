package com.medallia.digital.mobilesdk;

import java.net.InetAddress;
import java.net.Socket;
import java.security.SecureRandom;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

/* renamed from: com.medallia.digital.mobilesdk.d5 */
class C3484d5 extends SSLSocketFactory {

    /* renamed from: b */
    private static final String f1019b = "TLS";

    /* renamed from: c */
    private static final String f1020c = "TLSv1.1";

    /* renamed from: d */
    private static final String f1021d = "TLSv1.2";

    /* renamed from: a */
    private SSLSocketFactory f1022a;

    protected C3484d5() {
        SSLContext instance = SSLContext.getInstance("TLS");
        instance.init((KeyManager[]) null, (TrustManager[]) null, (SecureRandom) null);
        this.f1022a = instance.getSocketFactory();
    }

    /* renamed from: a */
    private Socket m638a(Socket socket) {
        if (socket instanceof SSLSocket) {
            ((SSLSocket) socket).setEnabledProtocols(new String[]{f1020c, f1021d});
        }
        return socket;
    }

    public Socket createSocket(String str, int i) {
        return m638a(this.f1022a.createSocket(str, i));
    }

    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) {
        return m638a(this.f1022a.createSocket(str, i, inetAddress, i2));
    }

    public Socket createSocket(InetAddress inetAddress, int i) {
        return m638a(this.f1022a.createSocket(inetAddress, i));
    }

    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) {
        return m638a(this.f1022a.createSocket(inetAddress, i, inetAddress2, i2));
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) {
        return m638a(this.f1022a.createSocket(socket, str, i, z));
    }

    public String[] getDefaultCipherSuites() {
        return this.f1022a.getDefaultCipherSuites();
    }

    public String[] getSupportedCipherSuites() {
        return this.f1022a.getSupportedCipherSuites();
    }
}
