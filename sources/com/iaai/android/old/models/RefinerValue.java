package com.iaai.android.old.models;

import android.os.Parcel;
import android.os.Parcelable;

public class RefinerValue implements Parcelable {
    public static final Parcelable.Creator<RefinerValue> CREATOR = new Parcelable.Creator<RefinerValue>() {
        public RefinerValue createFromParcel(Parcel parcel) {
            return new RefinerValue(parcel);
        }

        public RefinerValue[] newArray(int i) {
            return new RefinerValue[i];
        }
    };
    public String count;
    public String value;

    public int describeContents() {
        return 0;
    }

    public RefinerValue() {
    }

    public RefinerValue(Parcel parcel) {
        this.count = parcel.readString();
        this.value = parcel.readString();
    }

    public String toString() {
        return String.format("%s (%s)", new Object[]{this.value.trim(), this.count.trim()});
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.count);
        parcel.writeString(this.value);
    }
}
