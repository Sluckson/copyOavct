package com.google.firebase.iid;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import p052cz.msebera.android.httpclient.HttpStatus;

/* compiled from: com.google.firebase:firebase-iid@@20.2.1 */
final /* synthetic */ class zze implements Continuation {
    static final Continuation zza = new zze();

    private zze() {
    }

    public final Object then(Task task) {
        return Integer.valueOf(HttpStatus.SC_FORBIDDEN);
    }
}
