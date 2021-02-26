package p052cz.msebera.android.httpclient.conn.ssl;

import javax.net.ssl.SSLException;
import p052cz.msebera.android.httpclient.annotation.Immutable;

@Immutable
/* renamed from: cz.msebera.android.httpclient.conn.ssl.BrowserCompatHostnameVerifier */
public class BrowserCompatHostnameVerifier extends AbstractVerifier {
    public final String toString() {
        return "BROWSER_COMPATIBLE";
    }

    /* access modifiers changed from: package-private */
    public boolean validCountryWildcard(String str) {
        return true;
    }

    public final void verify(String str, String[] strArr, String[] strArr2) throws SSLException {
        verify(str, strArr, strArr2, false);
    }
}
