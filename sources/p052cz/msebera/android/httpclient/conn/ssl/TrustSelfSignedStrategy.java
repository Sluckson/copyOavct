package p052cz.msebera.android.httpclient.conn.ssl;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/* renamed from: cz.msebera.android.httpclient.conn.ssl.TrustSelfSignedStrategy */
public class TrustSelfSignedStrategy implements TrustStrategy {
    public boolean isTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        return x509CertificateArr.length == 1;
    }
}
