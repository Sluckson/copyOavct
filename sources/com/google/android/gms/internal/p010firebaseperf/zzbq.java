package com.google.android.gms.internal.p010firebaseperf;

import android.support.p000v4.media.session.PlaybackStateCompat;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzbq */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public enum zzbq {
    TERABYTES(1099511627776L),
    GIGABYTES(1073741824),
    MEGABYTES(PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED),
    KILOBYTES(PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID),
    BYTES(1);
    
    private long zzhx;

    private zzbq(long j) {
        this.zzhx = j;
    }

    public final long zzt(long j) {
        return (j * this.zzhx) / KILOBYTES.zzhx;
    }
}
