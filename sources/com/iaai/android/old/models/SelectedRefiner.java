package com.iaai.android.old.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class SelectedRefiner implements Parcelable {
    public static final Parcelable.Creator<SelectedRefiner> CREATOR = new Parcelable.Creator<SelectedRefiner>() {
        public SelectedRefiner createFromParcel(Parcel parcel) {
            return new SelectedRefiner(parcel);
        }

        public SelectedRefiner[] newArray(int i) {
            return new SelectedRefiner[i];
        }
    };
    @SerializedName("RefinerTypeValue")
    public String RefinerTypeValue;
    @SerializedName("RefinerValue")
    public String RefinerValue;
    public String refiner_display_value;

    public int describeContents() {
        return 0;
    }

    public SelectedRefiner() {
    }

    public SelectedRefiner(String str, String str2) {
        this.RefinerTypeValue = str;
        this.RefinerValue = str2;
    }

    public SelectedRefiner(String str, String str2, String str3) {
        this.RefinerTypeValue = str;
        this.RefinerValue = str2;
        this.refiner_display_value = str3;
    }

    protected SelectedRefiner(Parcel parcel) {
        this.RefinerTypeValue = parcel.readString();
        this.RefinerValue = parcel.readString();
        this.refiner_display_value = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.RefinerTypeValue);
        parcel.writeString(this.RefinerValue);
        parcel.writeString(this.refiner_display_value);
    }

    public boolean equals(Object obj) {
        if (obj instanceof SelectedRefiner) {
            return this.RefinerValue.equalsIgnoreCase(((SelectedRefiner) obj).RefinerValue);
        }
        return super.equals(obj);
    }

    public int hashCode() {
        String str = this.RefinerValue;
        return (str != null ? str.hashCode() : 0) * 17;
    }
}
