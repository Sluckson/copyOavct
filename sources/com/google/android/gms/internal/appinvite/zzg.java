package com.google.android.gms.internal.appinvite;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

final class zzg extends zzh<Status> {
    private final String zzj;

    public zzg(zzf zzf, GoogleApiClient googleApiClient, String str) {
        super(googleApiClient);
        this.zzj = str;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Result createFailedResult(Status status) {
        return status;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        zzm zzm = (zzm) anyClient;
        try {
            ((zzq) zzm.getService()).zza(new zzj(this), this.zzj);
        } catch (RemoteException unused) {
        }
    }
}
