package com.google.android.gms.internal.appinvite;

import android.app.Activity;
import android.content.Intent;
import com.google.android.gms.appinvite.AppInviteReferral;
import com.google.android.gms.common.api.Status;

final class zzn extends zze {
    private final /* synthetic */ zzk zzq;

    zzn(zzk zzk) {
        this.zzq = zzk;
    }

    public final void zza(Status status, Intent intent) {
        Activity activity;
        this.zzq.setResult(new zzp(status, intent));
        if (AppInviteReferral.hasReferral(intent) && this.zzq.zzm && this.zzq.zzl != null && (activity = (Activity) this.zzq.zzl.get()) != null) {
            activity.startActivity(intent);
        }
    }
}
