package com.iaai.android.old.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class NewSelectedRefiners implements Parcelable {
    public static final Parcelable.Creator<NewSelectedRefiners> CREATOR = new Parcelable.Creator<NewSelectedRefiners>() {
        public NewSelectedRefiners createFromParcel(Parcel parcel) {
            return new NewSelectedRefiners(parcel);
        }

        public NewSelectedRefiners[] newArray(int i) {
            return new NewSelectedRefiners[i];
        }
    };
    @SerializedName("RefinerTypeValue")
    public String refinerTypeValue;
    @SerializedName("RefinerValue")
    public String refinerValue;

    public int describeContents() {
        return 0;
    }

    public NewSelectedRefiners(Parcel parcel) {
        this.refinerTypeValue = parcel.readString();
        this.refinerValue = parcel.readString();
    }

    public NewSelectedRefiners() {
    }

    public NewSelectedRefiners(String str, String str2) {
        this.refinerTypeValue = str;
        this.refinerValue = str2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof NewSelectedRefiners) {
            return this.refinerTypeValue.equalsIgnoreCase(((NewSelectedRefiners) obj).refinerTypeValue);
        }
        return super.equals(obj);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.refinerTypeValue);
        parcel.writeString(this.refinerValue);
    }
}
