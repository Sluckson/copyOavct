package com.google.android.gms.internal.appinvite;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

final class zzl extends zze {
    private final /* synthetic */ zzi zzo;

    zzl(zzi zzi) {
        this.zzo = zzi;
    }

    public final void zza(Status status) throws RemoteException {
        this.zzo.setResult(status);
    }
}
