package com.google.android.gms.internal.p010firebaseperf;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzbw */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public class zzbw implements Parcelable {
    public static final Parcelable.Creator<zzbw> CREATOR = new zzbv();
    private long zzhz;
    private long zzia;

    public zzbw() {
        this.zzhz = TimeUnit.MILLISECONDS.toMicros(System.currentTimeMillis());
        this.zzia = System.nanoTime();
    }

    public int describeContents() {
        return 0;
    }

    private zzbw(Parcel parcel) {
        this.zzhz = parcel.readLong();
        this.zzia = parcel.readLong();
    }

    public final void reset() {
        this.zzhz = TimeUnit.MILLISECONDS.toMicros(System.currentTimeMillis());
        this.zzia = System.nanoTime();
    }

    public final long zzdb() {
        return this.zzhz;
    }

    public final long getDurationMicros() {
        return TimeUnit.NANOSECONDS.toMicros(System.nanoTime() - this.zzia);
    }

    public final long zzk(@NonNull zzbw zzbw) {
        return TimeUnit.NANOSECONDS.toMicros(zzbw.zzia - this.zzia);
    }

    public final long zzdc() {
        return this.zzhz + getDurationMicros();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.zzhz);
        parcel.writeLong(this.zzia);
    }

    /* synthetic */ zzbw(Parcel parcel, zzbv zzbv) {
        this(parcel);
    }
}
