package com.google.android.gms.internal.p010firebaseperf;

import kotlin.text.Typography;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzdl */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public enum zzdl implements zzfm {
    SESSION_VERBOSITY_NONE(0),
    GAUGES_AND_SYSTEM_EVENTS(1);
    
    private static final zzfl<zzdl> zziz = null;
    private final int value;

    public final int getNumber() {
        return this.value;
    }

    public static zzdl zzo(int i) {
        if (i == 0) {
            return SESSION_VERBOSITY_NONE;
        }
        if (i != 1) {
            return null;
        }
        return GAUGES_AND_SYSTEM_EVENTS;
    }

    public static zzfo zzdq() {
        return zzdn.zzjc;
    }

    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + getNumber() + " name=" + name() + Typography.greater;
    }

    private zzdl(int i) {
        this.value = i;
    }

    static {
        zziz = new zzdk();
    }
}
