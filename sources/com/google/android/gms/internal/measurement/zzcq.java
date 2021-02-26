package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
final class zzcq extends ContentObserver {
    private final /* synthetic */ zzco zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzcq(zzco zzco, Handler handler) {
        super((Handler) null);
        this.zza = zzco;
    }

    public final void onChange(boolean z) {
        this.zza.zzb();
    }
}
