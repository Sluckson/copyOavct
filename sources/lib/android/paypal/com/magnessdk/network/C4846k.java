package lib.android.paypal.com.magnessdk.network;

import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import lib.android.paypal.com.magnessdk.p059b.C4823a;

/* renamed from: lib.android.paypal.com.magnessdk.network.k */
final class C4846k extends SSLSocketFactory {

    /* renamed from: a */
    private static final String f5795a = "k";

    /* renamed from: b */
    private static TrustManager[] f5796b;

    /* renamed from: c */
    private SSLContext f5797c;

    /* renamed from: d */
    private SSLSocketFactory f5798d;

    /* renamed from: e */
    private TrustManager[] f5799e;

    private C4846k() {
        try {
            this.f5797c = SSLContext.getInstance("TLS");
            this.f5799e = m4751b();
            this.f5797c.init((KeyManager[]) null, this.f5799e, (SecureRandom) null);
            this.f5798d = this.f5797c.getSocketFactory();
        } catch (Exception e) {
            C4823a.m4654a(getClass(), 3, (Throwable) e);
        }
    }

    /* renamed from: a */
    private Socket m4749a(Socket socket) {
        if (socket instanceof SSLSocket) {
            SSLSocket sSLSocket = (SSLSocket) socket;
            ArrayList arrayList = new ArrayList(Arrays.asList(sSLSocket.getSupportedProtocols()));
            arrayList.retainAll(Arrays.asList(new String[]{"TLSv1.2", "TLSv1.1", "TLSv1"}));
            sSLSocket.setEnabledProtocols((String[]) arrayList.toArray(new String[arrayList.size()]));
        }
        return socket;
    }

    /* renamed from: a */
    static C4846k m4750a() {
        return new C4846k();
    }

    /* renamed from: b */
    private TrustManager[] m4751b() {
        if (f5796b == null) {
            try {
                KeyStore instance = KeyStore.getInstance(KeyStore.getDefaultType());
                instance.load((InputStream) null, (char[]) null);
                for (Certificate certificate : CertificateFactory.getInstance("X.509").generateCertificates(PayPalCertificate.getCertInputStream())) {
                    if (certificate instanceof X509Certificate) {
                        instance.setCertificateEntry(((X509Certificate) certificate).getSubjectDN().getName(), certificate);
                    }
                }
                TrustManagerFactory instance2 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                instance2.init(instance);
                this.f5799e = instance2.getTrustManagers();
            } catch (Exception e) {
                C4823a.m4654a(getClass(), 3, (Throwable) e);
            }
            f5796b = this.f5799e;
        }
        return f5796b;
    }

    public Socket createSocket(String str, int i) {
        return m4749a(this.f5798d.createSocket(str, i));
    }

    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) {
        return m4749a(this.f5798d.createSocket(str, i, inetAddress, i2));
    }

    public Socket createSocket(InetAddress inetAddress, int i) {
        return m4749a(this.f5798d.createSocket(inetAddress, i));
    }

    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) {
        return m4749a(this.f5798d.createSocket(inetAddress, i, inetAddress2, i2));
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) {
        return m4749a(this.f5798d.createSocket(socket, str, i, z));
    }

    public String[] getDefaultCipherSuites() {
        return this.f5798d.getDefaultCipherSuites();
    }

    public String[] getSupportedCipherSuites() {
        return this.f5798d.getSupportedCipherSuites();
    }
}
