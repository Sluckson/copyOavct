package com.google.firebase.iid;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: com.google.firebase:firebase-iid@@20.2.1 */
final class zzi implements Parcelable.Creator<zzj> {
    zzi() {
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzj[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        IBinder readStrongBinder = parcel.readStrongBinder();
        if (readStrongBinder != null) {
            return new zzj(readStrongBinder);
        }
        return null;
    }
}
