package com.google.android.gms.internal.p010firebaseperf;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzbv */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
final class zzbv implements Parcelable.Creator<zzbw> {
    zzbv() {
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzbw[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new zzbw(parcel, (zzbv) null);
    }
}
