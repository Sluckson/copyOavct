package com.google.android.gms.internal.p010firebaseperf;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzfu */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public enum zzfu {
    VOID(Void.class, Void.class, (Class<?>) null),
    INT(Integer.TYPE, Integer.class, 0),
    LONG(Long.TYPE, Long.class, 0L),
    FLOAT(Float.TYPE, Float.class, Float.valueOf(0.0f)),
    DOUBLE(Double.TYPE, Double.class, Double.valueOf(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)),
    BOOLEAN(Boolean.TYPE, Boolean.class, false),
    STRING(String.class, String.class, ""),
    BYTE_STRING(zzee.class, zzee.class, zzee.zzna),
    ENUM(Integer.TYPE, Integer.class, (Class<?>) null),
    MESSAGE(Object.class, Object.class, (Class<?>) null);
    
    private final Class<?> zzrw;
    private final Class<?> zzrx;
    private final Object zzry;

    private zzfu(Class<?> cls, Class<?> cls2, Object obj) {
        this.zzrw = cls;
        this.zzrx = cls2;
        this.zzry = obj;
    }

    public final Class<?> zzhv() {
        return this.zzrx;
    }
}
