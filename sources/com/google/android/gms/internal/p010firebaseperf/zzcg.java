package com.google.android.gms.internal.p010firebaseperf;

import kotlin.text.Typography;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzcg */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public enum zzcg implements zzfm {
    APPLICATION_PROCESS_STATE_UNKNOWN(0),
    FOREGROUND(1),
    BACKGROUND(2),
    FOREGROUND_BACKGROUND(3);
    
    private static final zzfl<zzcg> zziz = null;
    private final int value;

    public final int getNumber() {
        return this.value;
    }

    public static zzfo zzdq() {
        return zzch.zzjc;
    }

    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + getNumber() + " name=" + name() + Typography.greater;
    }

    private zzcg(int i) {
        this.value = i;
    }

    static {
        zziz = new zzci();
    }
}
