package com.google.firebase.perf.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.internal.p010firebaseperf.zzah;
import com.google.android.gms.internal.p010firebaseperf.zzbi;
import com.google.android.gms.internal.p010firebaseperf.zzbk;
import com.google.android.gms.internal.p010firebaseperf.zzbw;
import com.google.android.gms.internal.p010firebaseperf.zzde;
import com.google.android.gms.internal.p010firebaseperf.zzdl;
import com.google.android.gms.internal.p010firebaseperf.zzfi;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public class zzr implements Parcelable {
    public static final Parcelable.Creator<zzr> CREATOR = new zzu();
    private String zzel;
    private boolean zzem;
    private zzbw zzen;

    public static zzr zzcd() {
        String replaceAll = UUID.randomUUID().toString().replaceAll("\\-", "");
        zzr zzr = new zzr(replaceAll, new zzbk());
        zzah zzo = zzah.zzo();
        zzr.zzem = zzo.zzp() && Math.random() < ((double) zzo.zzv());
        zzbi zzcl = zzbi.zzcl();
        Object[] objArr = new Object[2];
        objArr[0] = zzr.zzem ? "Verbose" : "Non Verbose";
        objArr[1] = replaceAll;
        zzcl.zzm(String.format("Creating a new %s Session: %s", objArr));
        return zzr;
    }

    public int describeContents() {
        return 0;
    }

    @VisibleForTesting
    private zzr(String str, zzbk zzbk) {
        this.zzem = false;
        this.zzel = str;
        this.zzen = new zzbw();
    }

    private zzr(@NonNull Parcel parcel) {
        boolean z = false;
        this.zzem = false;
        this.zzel = parcel.readString();
        this.zzem = parcel.readByte() != 0 ? true : z;
        this.zzen = (zzbw) parcel.readParcelable(zzbw.class.getClassLoader());
    }

    public final String zzce() {
        return this.zzel;
    }

    public final zzbw zzcf() {
        return this.zzen;
    }

    public final boolean zzcg() {
        return this.zzem;
    }

    public final boolean isExpired() {
        return TimeUnit.MICROSECONDS.toMinutes(this.zzen.getDurationMicros()) > zzah.zzo().zzaa();
    }

    public final zzde zzch() {
        zzde.zza zzag = zzde.zzfp().zzag(this.zzel);
        if (this.zzem) {
            zzag.zzb(zzdl.GAUGES_AND_SYSTEM_EVENTS);
        }
        return (zzde) ((zzfi) zzag.zzhm());
    }

    @Nullable
    public static zzde[] zza(@NonNull List<zzr> list) {
        if (list.isEmpty()) {
            return null;
        }
        zzde[] zzdeArr = new zzde[list.size()];
        zzde zzch = list.get(0).zzch();
        boolean z = false;
        for (int i = 1; i < list.size(); i++) {
            zzde zzch2 = list.get(i).zzch();
            if (z || !list.get(i).zzem) {
                zzdeArr[i] = zzch2;
            } else {
                zzdeArr[0] = zzch2;
                zzdeArr[i] = zzch;
                z = true;
            }
        }
        if (!z) {
            zzdeArr[0] = zzch;
        }
        return zzdeArr;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(this.zzel);
        parcel.writeByte(this.zzem ? (byte) 1 : 0);
        parcel.writeParcelable(this.zzen, 0);
    }

    /* synthetic */ zzr(Parcel parcel, zzu zzu) {
        this(parcel);
    }
}
