package com.salesforce.marketingcloud.analytics;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* renamed from: com.salesforce.marketingcloud.analytics.f */
final class C3914f extends C3878a {
    public static final Parcelable.Creator<C3914f> CREATOR = new Parcelable.Creator<C3914f>() {
        /* renamed from: a */
        public C3914f createFromParcel(Parcel parcel) {
            return new C3914f(parcel.readArrayList(PiCart.class.getClassLoader()));
        }

        /* renamed from: a */
        public C3914f[] newArray(int i) {
            return new C3914f[i];
        }
    };

    C3914f(List<PiCartItem> list) {
        super(list);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(cartItems());
    }
}
