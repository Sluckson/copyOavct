package p052cz.msebera.android.httpclient.auth;

import p052cz.msebera.android.httpclient.params.HttpParams;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.auth.AuthSchemeFactory */
public interface AuthSchemeFactory {
    AuthScheme newInstance(HttpParams httpParams);
}
