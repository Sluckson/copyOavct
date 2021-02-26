package com.iaai.android.old.utils;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.X509Certificate;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.SSLSocketFactory;

public class MySSLSocketFactory extends SSLSocketFactory {
    SSLContext sslContext = SSLContext.getInstance("TLS");

    public MySSLSocketFactory(KeyStore keyStore) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
        super(keyStore);
        C33191 r4 = new X509TrustManager() {
            public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
            }

            public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
            }

            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        };
        this.sslContext.init((KeyManager[]) null, new TrustManager[]{r4}, (SecureRandom) null);
    }

    public MySSLSocketFactory(SSLContext sSLContext) throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException {
        super((KeyStore) null);
        this.sslContext = sSLContext;
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException, UnknownHostException {
        return this.sslContext.getSocketFactory().createSocket(socket, str, i, z);
    }

    public Socket createSocket() throws IOException {
        return this.sslContext.getSocketFactory().createSocket();
    }
}
