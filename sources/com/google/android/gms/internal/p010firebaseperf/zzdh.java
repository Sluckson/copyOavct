package com.google.android.gms.internal.p010firebaseperf;

import kotlin.text.Typography;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzdh */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public enum zzdh implements zzfm {
    SERVICE_WORKER_STATUS_UNKNOWN(0),
    UNSUPPORTED(1),
    CONTROLLED(2),
    UNCONTROLLED(3);
    
    private static final zzfl<zzdh> zziz = null;
    private final int value;

    public final int getNumber() {
        return this.value;
    }

    public static zzfo zzdq() {
        return zzdi.zzjc;
    }

    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + getNumber() + " name=" + name() + Typography.greater;
    }

    private zzdh(int i) {
        this.value = i;
    }

    static {
        zziz = new zzdj();
    }
}
