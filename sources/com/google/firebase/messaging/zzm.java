package com.google.firebase.messaging;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.firebase:firebase-messaging@@20.2.1 */
final /* synthetic */ class zzm implements SuccessContinuation {
    private final String zza;

    zzm(String str) {
        this.zza = str;
    }

    public final Task then(Object obj) {
        zzab zzab = (zzab) obj;
        Task<Void> zza2 = zzab.zza(zzz.zza(this.zza));
        zzab.zza();
        return zza2;
    }
}
