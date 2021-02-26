package com.google.android.gms.internal.p010firebaseperf;

import androidx.annotation.NonNull;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzbm */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public enum zzbm {
    TRACE_EVENT_RATE_LIMITED("_fstec"),
    NETWORK_TRACE_EVENT_RATE_LIMITED("_fsntc"),
    TRACE_STARTED_NOT_STOPPED("_tsns"),
    FRAMES_TOTAL("_fr_tot"),
    FRAMES_SLOW("_fr_slo"),
    FRAMES_FROZEN("_fr_fzn");
    
    private String mName;

    private zzbm(@NonNull String str) {
        this.mName = str;
    }

    public final String toString() {
        return this.mName;
    }
}
