package p052cz.msebera.android.httpclient.conn.ssl;

import p052cz.msebera.android.httpclient.annotation.Immutable;

@Immutable
/* renamed from: cz.msebera.android.httpclient.conn.ssl.AllowAllHostnameVerifier */
public class AllowAllHostnameVerifier extends AbstractVerifier {
    public final String toString() {
        return "ALLOW_ALL";
    }

    public final void verify(String str, String[] strArr, String[] strArr2) {
    }
}
