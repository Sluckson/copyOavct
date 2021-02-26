package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "UserAttributeParcelCreator")
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
public final class zzkw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzkw> CREATOR = new zzkv();
    @SafeParcelable.Field(mo18230id = 2)
    public final String zza;
    @SafeParcelable.Field(mo18230id = 3)
    public final long zzb;
    @SafeParcelable.Field(mo18230id = 4)
    public final Long zzc;
    @SafeParcelable.Field(mo18230id = 6)
    public final String zzd;
    @SafeParcelable.Field(mo18230id = 7)
    public final String zze;
    @SafeParcelable.Field(mo18230id = 8)
    public final Double zzf;
    @SafeParcelable.Field(mo18230id = 1)
    private final int zzg;
    @SafeParcelable.Field(mo18230id = 5)
    private final Float zzh;

    zzkw(zzky zzky) {
        this(zzky.zzc, zzky.zzd, zzky.zze, zzky.zzb);
    }

    zzkw(String str, long j, Object obj, String str2) {
        Preconditions.checkNotEmpty(str);
        this.zzg = 2;
        this.zza = str;
        this.zzb = j;
        this.zze = str2;
        if (obj == null) {
            this.zzc = null;
            this.zzh = null;
            this.zzf = null;
            this.zzd = null;
        } else if (obj instanceof Long) {
            this.zzc = (Long) obj;
            this.zzh = null;
            this.zzf = null;
            this.zzd = null;
        } else if (obj instanceof String) {
            this.zzc = null;
            this.zzh = null;
            this.zzf = null;
            this.zzd = (String) obj;
        } else if (obj instanceof Double) {
            this.zzc = null;
            this.zzh = null;
            this.zzf = (Double) obj;
            this.zzd = null;
        } else {
            throw new IllegalArgumentException("User attribute given of un-supported type");
        }
    }

    @SafeParcelable.Constructor
    zzkw(@SafeParcelable.Param(mo18233id = 1) int i, @SafeParcelable.Param(mo18233id = 2) String str, @SafeParcelable.Param(mo18233id = 3) long j, @SafeParcelable.Param(mo18233id = 4) Long l, @SafeParcelable.Param(mo18233id = 5) Float f, @SafeParcelable.Param(mo18233id = 6) String str2, @SafeParcelable.Param(mo18233id = 7) String str3, @SafeParcelable.Param(mo18233id = 8) Double d) {
        this.zzg = i;
        this.zza = str;
        this.zzb = j;
        this.zzc = l;
        Double d2 = null;
        this.zzh = null;
        if (i == 1) {
            this.zzf = f != null ? Double.valueOf(f.doubleValue()) : d2;
        } else {
            this.zzf = d;
        }
        this.zzd = str2;
        this.zze = str3;
    }

    public final Object zza() {
        Long l = this.zzc;
        if (l != null) {
            return l;
        }
        Double d = this.zzf;
        if (d != null) {
            return d;
        }
        String str = this.zzd;
        if (str != null) {
            return str;
        }
        return null;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzg);
        SafeParcelWriter.writeString(parcel, 2, this.zza, false);
        SafeParcelWriter.writeLong(parcel, 3, this.zzb);
        SafeParcelWriter.writeLongObject(parcel, 4, this.zzc, false);
        SafeParcelWriter.writeFloatObject(parcel, 5, (Float) null, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzd, false);
        SafeParcelWriter.writeString(parcel, 7, this.zze, false);
        SafeParcelWriter.writeDoubleObject(parcel, 8, this.zzf, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
