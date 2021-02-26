package com.google.firebase.messaging;

import com.google.android.datatransport.Transformer;

/* compiled from: com.google.firebase:firebase-messaging@@20.2.1 */
final /* synthetic */ class zzp implements Transformer {
    static final Transformer zza = new zzp();

    private zzp() {
    }

    public final Object apply(Object obj) {
        return ((String) obj).getBytes();
    }
}
