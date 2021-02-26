package com.iaai.android.old.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class DZImageURLKeyData implements Parcelable {
    public static final Parcelable.Creator<DZImageURLKeyData> CREATOR = new Parcelable.Creator<DZImageURLKeyData>() {
        public DZImageURLKeyData createFromParcel(Parcel parcel) {
            return new DZImageURLKeyData(parcel);
        }

        public DZImageURLKeyData[] newArray(int i) {
            return new DZImageURLKeyData[i];
        }
    };
    @SerializedName("height")
    public String height;
    @SerializedName("url")
    public String url;
    @SerializedName("width")
    public String width;

    public int describeContents() {
        return 0;
    }

    public DZImageURLKeyData() {
    }

    protected DZImageURLKeyData(Parcel parcel) {
        this.height = parcel.readString();
        this.url = parcel.readString();
        this.width = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.height);
        parcel.writeString(this.url);
        parcel.writeString(this.width);
    }
}
