package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "EventParcelCreator")
@SafeParcelable.Reserved({1})
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
public final class zzar extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzar> CREATOR = new zzaq();
    @SafeParcelable.Field(mo18230id = 2)
    public final String zza;
    @SafeParcelable.Field(mo18230id = 3)
    public final zzam zzb;
    @SafeParcelable.Field(mo18230id = 4)
    public final String zzc;
    @SafeParcelable.Field(mo18230id = 5)
    public final long zzd;

    @SafeParcelable.Constructor
    public zzar(@SafeParcelable.Param(mo18233id = 2) String str, @SafeParcelable.Param(mo18233id = 3) zzam zzam, @SafeParcelable.Param(mo18233id = 4) String str2, @SafeParcelable.Param(mo18233id = 5) long j) {
        this.zza = str;
        this.zzb = zzam;
        this.zzc = str2;
        this.zzd = j;
    }

    zzar(zzar zzar, long j) {
        Preconditions.checkNotNull(zzar);
        this.zza = zzar.zza;
        this.zzb = zzar.zzb;
        this.zzc = zzar.zzc;
        this.zzd = j;
    }

    public final String toString() {
        String str = this.zzc;
        String str2 = this.zza;
        String valueOf = String.valueOf(this.zzb);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 21 + String.valueOf(str2).length() + String.valueOf(valueOf).length());
        sb.append("origin=");
        sb.append(str);
        sb.append(",name=");
        sb.append(str2);
        sb.append(",params=");
        sb.append(valueOf);
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zza, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzb, i, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzc, false);
        SafeParcelWriter.writeLong(parcel, 5, this.zzd);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
