package com.google.android.gms.internal.appinvite;

import android.app.Activity;
import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.appinvite.AppInviteInvitationResult;
import com.google.android.gms.appinvite.AppInviteReferral;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.lang.ref.WeakReference;

final class zzk extends zzh<AppInviteInvitationResult> {
    /* access modifiers changed from: private */
    public final WeakReference<Activity> zzl;
    /* access modifiers changed from: private */
    public final boolean zzm;
    private final Intent zzn;

    public zzk(zzf zzf, GoogleApiClient googleApiClient, Activity activity, boolean z) {
        super(googleApiClient);
        this.zzm = z;
        this.zzl = new WeakReference<>(activity);
        this.zzn = activity != null ? activity.getIntent() : null;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        zzm zzm2 = (zzm) anyClient;
        if (AppInviteReferral.hasReferral(this.zzn)) {
            setResult(new zzp(Status.RESULT_SUCCESS, this.zzn));
            zzm2.zza((zzo) null);
            return;
        }
        zzm2.zza(new zzn(this));
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Result createFailedResult(Status status) {
        return new zzp(status, new Intent());
    }
}
