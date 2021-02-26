package com.google.firebase.dynamiclinks.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "DynamicLinkDataCreator")
public class DynamicLinkData extends AbstractSafeParcelable {
    public static final Parcelable.Creator<DynamicLinkData> CREATOR = new zza();
    @SafeParcelable.Field(getter = "getDynamicLink", mo18230id = 1)
    private String zzj;
    @SafeParcelable.Field(getter = "getDeepLink", mo18230id = 2)
    private String zzk;
    @SafeParcelable.Field(getter = "getMinVersion", mo18230id = 3)
    private int zzl;
    @SafeParcelable.Field(getter = "getClickTimestamp", mo18230id = 4)
    private long zzm = 0;
    @SafeParcelable.Field(getter = "getExtensionBundle", mo18230id = 5)
    private Bundle zzn = null;
    @SafeParcelable.Field(getter = "getRedirectUrl", mo18230id = 6)
    private Uri zzo;

    public final String zzd() {
        return this.zzk;
    }

    public final int zze() {
        return this.zzl;
    }

    public final long getClickTimestamp() {
        return this.zzm;
    }

    public final void zza(long j) {
        this.zzm = j;
    }

    public final Bundle zzf() {
        Bundle bundle = this.zzn;
        return bundle == null ? new Bundle() : bundle;
    }

    public final Uri zzc() {
        return this.zzo;
    }

    @SafeParcelable.Constructor
    public DynamicLinkData(@SafeParcelable.Param(mo18233id = 1) String str, @SafeParcelable.Param(mo18233id = 2) String str2, @SafeParcelable.Param(mo18233id = 3) int i, @SafeParcelable.Param(mo18233id = 4) long j, @SafeParcelable.Param(mo18233id = 5) Bundle bundle, @SafeParcelable.Param(mo18233id = 6) Uri uri) {
        this.zzj = str;
        this.zzk = str2;
        this.zzl = i;
        this.zzm = j;
        this.zzn = bundle;
        this.zzo = uri;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzj, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzk, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzl);
        SafeParcelWriter.writeLong(parcel, 4, this.zzm);
        SafeParcelWriter.writeBundle(parcel, 5, zzf(), false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzo, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
