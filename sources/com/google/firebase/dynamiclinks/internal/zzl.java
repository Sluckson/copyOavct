package com.google.firebase.dynamiclinks.internal;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.dynamiclinks.PendingDynamicLinkData;

final class zzl extends TaskApiCall<zzd, PendingDynamicLinkData> {
    private final String zzj;
    @Nullable
    private final AnalyticsConnector zzr;

    zzl(AnalyticsConnector analyticsConnector, String str) {
        this.zzj = str;
        this.zzr = analyticsConnector;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient, TaskCompletionSource taskCompletionSource) throws RemoteException {
        zzd zzd = (zzd) anyClient;
        try {
            ((zzm) zzd.getService()).zza((zzk) new zzi(this.zzr, taskCompletionSource), this.zzj);
        } catch (RemoteException unused) {
        }
    }
}
