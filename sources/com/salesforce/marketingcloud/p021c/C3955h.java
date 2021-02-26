package com.salesforce.marketingcloud.p021c;

import androidx.annotation.Nullable;
import com.salesforce.marketingcloud.C4039h;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.security.SecureRandom;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

/* renamed from: com.salesforce.marketingcloud.c.h */
class C3955h extends SSLSocketFactory {

    /* renamed from: a */
    private static final String f2557a = C4039h.m2810a((Class<?>) C3955h.class);

    /* renamed from: b */
    private final SSLSocketFactory f2558b;

    C3955h() {
        SSLContext instance = SSLContext.getInstance("TLSv1.2");
        instance.init((KeyManager[]) null, (TrustManager[]) null, (SecureRandom) null);
        this.f2558b = instance.getSocketFactory();
    }

    @Nullable
    /* renamed from: a */
    private Socket m2453a(Exception exc) {
        if (!(exc instanceof IOException)) {
            C4039h.m2830e(f2557a, exc, "Failed to patch socket for TLS.", new Object[0]);
            return null;
        }
        throw ((IOException) exc);
    }

    /* renamed from: a */
    private Socket m2454a(Socket socket) {
        if (socket != null && (socket instanceof SSLSocket)) {
            ((SSLSocket) socket).setEnabledProtocols(new String[]{"TLSv1.1", "TLSv1.2"});
        }
        return socket;
    }

    public Socket createSocket() {
        try {
            return m2454a(this.f2558b.createSocket());
        } catch (Exception e) {
            return m2453a(e);
        }
    }

    public Socket createSocket(String str, int i) {
        try {
            return m2454a(this.f2558b.createSocket(str, i));
        } catch (Exception e) {
            return m2453a(e);
        }
    }

    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) {
        try {
            return m2454a(this.f2558b.createSocket(str, i, inetAddress, i2));
        } catch (Exception e) {
            return m2453a(e);
        }
    }

    public Socket createSocket(InetAddress inetAddress, int i) {
        try {
            return m2454a(this.f2558b.createSocket(inetAddress, i));
        } catch (Exception e) {
            return m2453a(e);
        }
    }

    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) {
        try {
            return m2454a(this.f2558b.createSocket(inetAddress, i, inetAddress2, i2));
        } catch (Exception e) {
            return m2453a(e);
        }
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) {
        try {
            return m2454a(this.f2558b.createSocket(socket, str, i, z));
        } catch (Exception e) {
            return m2453a(e);
        }
    }

    public String[] getDefaultCipherSuites() {
        return this.f2558b.getDefaultCipherSuites();
    }

    public String[] getSupportedCipherSuites() {
        return this.f2558b.getSupportedCipherSuites();
    }
}
