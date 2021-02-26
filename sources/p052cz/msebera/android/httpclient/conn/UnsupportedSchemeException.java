package p052cz.msebera.android.httpclient.conn;

import java.io.IOException;
import p052cz.msebera.android.httpclient.annotation.Immutable;

@Immutable
/* renamed from: cz.msebera.android.httpclient.conn.UnsupportedSchemeException */
public class UnsupportedSchemeException extends IOException {
    private static final long serialVersionUID = 3597127619218687636L;

    public UnsupportedSchemeException(String str) {
        super(str);
    }
}
