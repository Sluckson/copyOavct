package com.google.android.gms.internal.appinvite;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzs extends zzb implements zzq {
    zzs(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.appinvite.internal.IAppInviteService");
    }

    public final void zza(zzo zzo, String str) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (IInterface) zzo);
        zza.writeString(str);
        zza(1, zza);
    }

    public final void zzb(zzo zzo, String str) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (IInterface) zzo);
        zza.writeString(str);
        zza(2, zza);
    }

    public final void zza(zzo zzo) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (IInterface) zzo);
        zza(3, zza);
    }
}
