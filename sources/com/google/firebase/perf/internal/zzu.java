package com.google.firebase.perf.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
final class zzu implements Parcelable.Creator<zzr> {
    zzu() {
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzr[i];
    }

    public final /* synthetic */ Object createFromParcel(@NonNull Parcel parcel) {
        return new zzr(parcel, (zzu) null);
    }
}
