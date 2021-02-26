package com.google.firebase.messaging;

import com.google.android.gms.tasks.OnSuccessListener;

/* compiled from: com.google.firebase:firebase-messaging@@20.2.1 */
final /* synthetic */ class zzk implements OnSuccessListener {
    private final FirebaseMessaging zza;

    zzk(FirebaseMessaging firebaseMessaging) {
        this.zza = firebaseMessaging;
    }

    public final void onSuccess(Object obj) {
        zzab zzab = (zzab) obj;
        if (this.zza.isAutoInitEnabled()) {
            zzab.zza();
        }
    }
}
