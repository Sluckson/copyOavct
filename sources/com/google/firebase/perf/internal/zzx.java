package com.google.firebase.perf.internal;

import com.google.android.gms.tasks.OnFailureListener;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
final /* synthetic */ class zzx implements OnFailureListener {
    private final RemoteConfigManager zzfe;

    zzx(RemoteConfigManager remoteConfigManager) {
        this.zzfe = remoteConfigManager;
    }

    public final void onFailure(Exception exc) {
        this.zzfe.zza(exc);
    }
}
