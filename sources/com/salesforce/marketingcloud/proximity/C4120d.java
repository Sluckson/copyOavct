package com.salesforce.marketingcloud.proximity;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.salesforce.marketingcloud.proximity.d */
final class C4120d extends C4114a {
    public static final Parcelable.Creator<C4120d> CREATOR = new Parcelable.Creator<C4120d>() {
        /* renamed from: a */
        public C4120d createFromParcel(Parcel parcel) {
            return new C4120d(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt());
        }

        /* renamed from: a */
        public C4120d[] newArray(int i) {
            return new C4120d[i];
        }
    };

    C4120d(String str, String str2, int i, int i2) {
        super(str, str2, i, i2);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mo56901a());
        parcel.writeString(mo56902b());
        parcel.writeInt(mo56903c());
        parcel.writeInt(mo56904d());
    }
}
