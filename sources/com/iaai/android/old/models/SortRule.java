package com.iaai.android.old.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class SortRule implements Parcelable {
    public static final Parcelable.Creator<SortRule> CREATOR = new Parcelable.Creator<SortRule>() {
        public SortRule createFromParcel(Parcel parcel) {
            return new SortRule(parcel);
        }

        public SortRule[] newArray(int i) {
            return new SortRule[i];
        }
    };
    @SerializedName("Ascending")
    public boolean Ascending;
    @SerializedName("FieldName")
    public String FieldName;

    public int describeContents() {
        return 0;
    }

    public SortRule(Parcel parcel) {
        this.FieldName = parcel.readString();
        this.Ascending = parcel.readByte() != 0;
    }

    public SortRule(String str, boolean z) {
        this.FieldName = str;
        this.Ascending = z;
    }

    public SortRule() {
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.FieldName);
        parcel.writeByte(this.Ascending ? (byte) 1 : 0);
    }
}
