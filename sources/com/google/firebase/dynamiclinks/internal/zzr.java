package com.google.firebase.dynamiclinks.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.dynamiclinks.ShortDynamicLink;

@SafeParcelable.Class(creator = "WarningImplCreator")
public final class zzr extends AbstractSafeParcelable implements ShortDynamicLink.Warning {
    public static final Parcelable.Creator<zzr> CREATOR = new zzs();
    @SafeParcelable.Field(getter = "getMessage", mo18230id = 2)
    @SafeParcelable.Reserved({1})
    private final String zzx;

    @SafeParcelable.Constructor
    public zzr(@SafeParcelable.Param(mo18233id = 2) String str) {
        this.zzx = str;
    }

    public final String getCode() {
        return null;
    }

    public final String getMessage() {
        return this.zzx;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, getMessage(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
