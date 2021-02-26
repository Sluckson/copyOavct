package com.google.android.gms.internal.p010firebaseperf;

import java.io.IOException;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzfs */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public class zzfs extends IOException {
    private zzgs zzrl = null;

    public zzfs(String str) {
        super(str);
    }

    static zzfr zzht() {
        return new zzfr("Protocol message tag had invalid wire type.");
    }
}
