package com.google.firebase.iid;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.firebase:firebase-iid@@20.2.1 */
final /* synthetic */ class zzbf implements OnCompleteListener {
    private final zzbg zza;

    zzbf(zzbg zzbg) {
        this.zza = zzbg;
    }

    public final void onComplete(Task task) {
        this.zza.zzb();
    }
}
