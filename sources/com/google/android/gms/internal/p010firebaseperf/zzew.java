package com.google.android.gms.internal.p010firebaseperf;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzew */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public class zzew {
    private static volatile boolean zznq = false;
    private static boolean zznr = true;
    private static volatile zzew zzns;
    private static final zzew zznt = new zzew(true);
    private final Map<Object, Object> zznu;

    public static zzew zzgw() {
        zzew zzew = zzns;
        if (zzew == null) {
            synchronized (zzew.class) {
                zzew = zzns;
                if (zzew == null) {
                    zzew = zznt;
                    zzns = zzew;
                }
            }
        }
        return zzew;
    }

    zzew() {
        this.zznu = new HashMap();
    }

    private zzew(boolean z) {
        this.zznu = Collections.emptyMap();
    }
}
