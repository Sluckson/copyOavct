package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzag;
import com.google.android.gms.measurement.internal.zzhd;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.5.0 */
final class zzbf extends zzag.zzb {
    private final /* synthetic */ zzhd zzc;
    private final /* synthetic */ zzag zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbf(zzag zzag, zzhd zzhd) {
        super(zzag);
        this.zzd = zzag;
        this.zzc = zzhd;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        this.zzd.zzm.setEventInterceptor(new zzag.zza(this.zzc));
    }
}
