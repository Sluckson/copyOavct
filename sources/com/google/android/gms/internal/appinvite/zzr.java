package com.google.android.gms.internal.appinvite;

import android.content.Intent;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

public abstract class zzr extends zza implements zzo {
    public zzr() {
        super("com.google.android.gms.appinvite.internal.IAppInviteCallbacks");
    }

    /* access modifiers changed from: protected */
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zza((Status) zzd.zza(parcel, Status.CREATOR));
        } else if (i != 2) {
            return false;
        } else {
            zza((Status) zzd.zza(parcel, Status.CREATOR), (Intent) zzd.zza(parcel, Intent.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
