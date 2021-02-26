package com.google.android.gms.internal.appinvite;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

final class zzj extends zze {
    private final /* synthetic */ zzg zzk;

    zzj(zzg zzg) {
        this.zzk = zzg;
    }

    public final void zza(Status status) throws RemoteException {
        this.zzk.setResult(status);
    }
}
