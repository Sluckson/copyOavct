package com.google.android.gms.appinvite;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.appinvite.zzf;
import com.google.android.gms.internal.appinvite.zzm;

@Deprecated
public final class AppInvite {
    public static final Api<Api.ApiOptions.NoOptions> API = new Api<>("AppInvite.API", zze, CLIENT_KEY);
    public static final AppInviteApi AppInviteApi = new zzf();
    private static final Api.ClientKey<zzm> CLIENT_KEY = new Api.ClientKey<>();
    private static final Api.AbstractClientBuilder<zzm, Api.ApiOptions.NoOptions> zze = new zza();

    private AppInvite() {
    }
}
