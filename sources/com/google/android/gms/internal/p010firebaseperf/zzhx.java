package com.google.android.gms.internal.p010firebaseperf;

import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzhx */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public final class zzhx extends RuntimeException {
    private final List<String> zzuv = null;

    public zzhx(zzgs zzgs) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }
}
