package com.google.firebase.dynamiclinks.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.dynamiclinks.ShortDynamicLink;
import java.util.List;

@SafeParcelable.Class(creator = "ShortDynamicLinkImplCreator")
public final class zzo extends AbstractSafeParcelable implements ShortDynamicLink {
    public static final Parcelable.Creator<zzo> CREATOR = new zzq();
    @SafeParcelable.Field(getter = "getShortLink", mo18230id = 1)
    private final Uri zzu;
    @SafeParcelable.Field(getter = "getPreviewLink", mo18230id = 2)
    private final Uri zzv;
    @SafeParcelable.Field(getter = "getWarnings", mo18230id = 3)
    private final List<zzr> zzw;

    @SafeParcelable.Constructor
    public zzo(@SafeParcelable.Param(mo18233id = 1) Uri uri, @SafeParcelable.Param(mo18233id = 2) Uri uri2, @SafeParcelable.Param(mo18233id = 3) List<zzr> list) {
        this.zzu = uri;
        this.zzv = uri2;
        this.zzw = list;
    }

    public final Uri getShortLink() {
        return this.zzu;
    }

    public final Uri getPreviewLink() {
        return this.zzv;
    }

    public final List<zzr> getWarnings() {
        return this.zzw;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getShortLink(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 2, getPreviewLink(), i, false);
        SafeParcelWriter.writeTypedList(parcel, 3, getWarnings(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
