package com.google.android.gms.internal.p010firebaseperf;

import kotlin.text.Typography;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzcl */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public enum zzcl implements zzfm {
    EFFECTIVE_CONNECTION_TYPE_UNKNOWN(0),
    EFFECTIVE_CONNECTION_TYPE_SLOW_2G(1),
    EFFECTIVE_CONNECTION_TYPE_2G(2),
    EFFECTIVE_CONNECTION_TYPE_3G(3),
    EFFECTIVE_CONNECTION_TYPE_4G(4);
    
    private static final zzfl<zzcl> zziz = null;
    private final int value;

    public final int getNumber() {
        return this.value;
    }

    public static zzfo zzdq() {
        return zzcm.zzjc;
    }

    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + getNumber() + " name=" + name() + Typography.greater;
    }

    private zzcl(int i) {
        this.value = i;
    }

    static {
        zziz = new zzcn();
    }
}
