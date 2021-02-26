package com.iaai.android.old.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.Comparator;

public class DefaultRefiner implements Parcelable, Comparator<DefaultRefiner> {
    public static final Parcelable.Creator<DefaultRefiner> CREATOR = new Parcelable.Creator<DefaultRefiner>() {
        public DefaultRefiner createFromParcel(Parcel parcel) {
            return new DefaultRefiner(parcel);
        }

        public DefaultRefiner[] newArray(int i) {
            return new DefaultRefiner[i];
        }
    };
    @SerializedName("DisplayName")
    public String displayName;
    @SerializedName("RefinerCount")
    public String refinerCount;
    @SerializedName("RefinerValue")
    public String refinerValue;

    public int describeContents() {
        return 0;
    }

    public DefaultRefiner() {
    }

    public DefaultRefiner(String str, String str2, String str3) {
        this.displayName = str;
        this.refinerCount = str2;
        this.refinerValue = str3;
    }

    protected DefaultRefiner(Parcel parcel) {
        this.displayName = parcel.readString();
        this.refinerCount = parcel.readString();
        this.refinerValue = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.displayName);
        parcel.writeString(this.refinerCount);
        parcel.writeString(this.refinerValue);
    }

    public int compare(DefaultRefiner defaultRefiner, DefaultRefiner defaultRefiner2) {
        return defaultRefiner.displayName.compareTo(defaultRefiner2.displayName);
    }
}
