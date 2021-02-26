package com.salesforce.marketingcloud.analytics;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.salesforce.marketingcloud.analytics.h */
final class C3918h extends C3909c {
    public static final Parcelable.Creator<C3918h> CREATOR = new Parcelable.Creator<C3918h>() {
        /* renamed from: a */
        public C3918h createFromParcel(Parcel parcel) {
            return new C3918h((PiCart) parcel.readParcelable(PiOrder.class.getClassLoader()), parcel.readString(), parcel.readDouble(), parcel.readDouble());
        }

        /* renamed from: a */
        public C3918h[] newArray(int i) {
            return new C3918h[i];
        }
    };

    C3918h(PiCart piCart, String str, double d, double d2) {
        super(piCart, str, d, d2);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(cart(), i);
        parcel.writeString(orderNumber());
        parcel.writeDouble(shipping());
        parcel.writeDouble(discount());
    }
}
