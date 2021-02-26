package com.google.android.gms.internal.p010firebaseperf;

import kotlin.text.Typography;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzdu */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public enum zzdu implements zzfm {
    VISIBILITY_STATE_UNKNOWN(0),
    VISIBLE(1),
    HIDDEN(2),
    PRERENDER(3),
    UNLOADED(4);
    
    private static final zzfl<zzdu> zziz = null;
    private final int value;

    public final int getNumber() {
        return this.value;
    }

    public static zzfo zzdq() {
        return zzdw.zzjc;
    }

    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + getNumber() + " name=" + name() + Typography.greater;
    }

    private zzdu(int i) {
        this.value = i;
    }

    static {
        zziz = new zzdt();
    }
}
