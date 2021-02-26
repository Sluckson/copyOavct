package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "ValidateAccountRequestCreator")
@Deprecated
/* compiled from: com.google.android.gms:play-services-basement@@17.2.1 */
public final class zzr extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzr> CREATOR = new zzs();
    @SafeParcelable.VersionField(mo18236id = 1)
    private final int zzq;

    @SafeParcelable.Constructor
    zzr(@SafeParcelable.Param(mo18233id = 1) int i) {
        this.zzq = i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzq);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
