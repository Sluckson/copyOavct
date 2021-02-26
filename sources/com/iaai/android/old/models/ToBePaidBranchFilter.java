package com.iaai.android.old.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class ToBePaidBranchFilter implements Parcelable {
    public static final Parcelable.Creator<ToBePaidBranchFilter> CREATOR = new Parcelable.Creator<ToBePaidBranchFilter>() {
        public ToBePaidBranchFilter createFromParcel(Parcel parcel) {
            return new ToBePaidBranchFilter(parcel);
        }

        public ToBePaidBranchFilter[] newArray(int i) {
            return new ToBePaidBranchFilter[i];
        }
    };
    @SerializedName("BranchCode")
    public String BranchCode;
    @SerializedName("BranchName")
    public String BranchName;

    public int describeContents() {
        return 0;
    }

    public ToBePaidBranchFilter() {
    }

    public ToBePaidBranchFilter(Parcel parcel) {
        this.BranchCode = parcel.readString();
        this.BranchName = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.BranchCode);
        parcel.writeString(this.BranchName);
    }
}
