package com.google.android.gms.internal.p010firebaseperf;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzir */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public enum zzir {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)),
    BOOLEAN(false),
    STRING(""),
    BYTE_STRING(zzee.zzna),
    ENUM((String) null),
    MESSAGE((String) null);
    
    private final Object zzry;

    private zzir(Object obj) {
        this.zzry = obj;
    }
}
