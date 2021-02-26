package p052cz.msebera.android.httpclient.client.config;

import p052cz.msebera.android.httpclient.annotation.Immutable;

@Immutable
/* renamed from: cz.msebera.android.httpclient.client.config.AuthSchemes */
public final class AuthSchemes {
    public static final String BASIC = "Basic";
    public static final String DIGEST = "Digest";
    public static final String KERBEROS = "Kerberos";
    public static final String NTLM = "NTLM";
    public static final String SPNEGO = "negotiate";

    private AuthSchemes() {
    }
}
