package com.google.firebase.iid;

import android.os.Handler;
import android.os.Message;

/* compiled from: com.google.firebase:firebase-iid@@20.2.1 */
final /* synthetic */ class zzaf implements Handler.Callback {
    private final zzac zza;

    zzaf(zzac zzac) {
        this.zza = zzac;
    }

    public final boolean handleMessage(Message message) {
        return this.zza.zza(message);
    }
}
