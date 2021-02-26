package p052cz.msebera.android.httpclient.client.params;

import p052cz.msebera.android.httpclient.annotation.Immutable;

@Immutable
@Deprecated
/* renamed from: cz.msebera.android.httpclient.client.params.AuthPolicy */
public final class AuthPolicy {
    public static final String BASIC = "Basic";
    public static final String DIGEST = "Digest";
    public static final String KERBEROS = "Kerberos";
    public static final String NTLM = "NTLM";
    public static final String SPNEGO = "negotiate";

    private AuthPolicy() {
    }
}
