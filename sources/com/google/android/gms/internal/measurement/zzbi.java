package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzag;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.5.0 */
final class zzbi extends zzag.zzb {
    private final /* synthetic */ Bundle zzc;
    private final /* synthetic */ zzag zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbi(zzag zzag, Bundle bundle) {
        super(zzag);
        this.zzd = zzag;
        this.zzc = bundle;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        this.zzd.zzm.setDefaultEventParameters(this.zzc);
    }
}
