package com.salesforce.marketingcloud.analytics;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;

/* renamed from: com.salesforce.marketingcloud.analytics.g */
final class C3916g extends C3882b {
    public static final Parcelable.Creator<C3916g> CREATOR = new Parcelable.Creator<C3916g>() {
        /* renamed from: a */
        public C3916g createFromParcel(Parcel parcel) {
            return new C3916g(parcel.readString(), parcel.readInt(), parcel.readDouble(), parcel.readInt() == 0 ? parcel.readString() : null);
        }

        /* renamed from: a */
        public C3916g[] newArray(int i) {
            return new C3916g[i];
        }
    };

    C3916g(String str, int i, double d, @Nullable String str2) {
        super(str, i, d, str2);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(item());
        parcel.writeInt(quantity());
        parcel.writeDouble(price());
        if (uniqueId() == null) {
            parcel.writeInt(1);
            return;
        }
        parcel.writeInt(0);
        parcel.writeString(uniqueId());
    }
}
