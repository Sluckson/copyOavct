package com.google.android.datatransport.cct.p007a;

import android.util.SparseArray;

/* renamed from: com.google.android.datatransport.cct.a.zzu */
public enum zzu {
    DEFAULT(0),
    UNMETERED_ONLY(1),
    UNMETERED_OR_DAILY(2),
    FAST_IF_RADIO_AWAKE(3),
    NEVER(4),
    UNRECOGNIZED(-1);
    
    private static final SparseArray<zzu> zzg = null;

    static {
        DEFAULT = new zzu("DEFAULT", 0, 0);
        UNMETERED_ONLY = new zzu("UNMETERED_ONLY", 1, 1);
        UNMETERED_OR_DAILY = new zzu("UNMETERED_OR_DAILY", 2, 2);
        FAST_IF_RADIO_AWAKE = new zzu("FAST_IF_RADIO_AWAKE", 3, 3);
        NEVER = new zzu("NEVER", 4, 4);
        UNRECOGNIZED = new zzu("UNRECOGNIZED", 5, -1);
        zzu[] zzuArr = {DEFAULT, UNMETERED_ONLY, UNMETERED_OR_DAILY, FAST_IF_RADIO_AWAKE, NEVER, UNRECOGNIZED};
        zzg = new SparseArray<>();
        zzg.put(0, DEFAULT);
        zzg.put(1, UNMETERED_ONLY);
        zzg.put(2, UNMETERED_OR_DAILY);
        zzg.put(3, FAST_IF_RADIO_AWAKE);
        zzg.put(4, NEVER);
        zzg.put(-1, UNRECOGNIZED);
    }

    private zzu(int i) {
    }
}
