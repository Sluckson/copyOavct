package com.iaai.android.old.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class DefaultRefinersArray implements Parcelable {
    public static final Parcelable.Creator<DefaultRefinersArray> CREATOR = new Parcelable.Creator<DefaultRefinersArray>() {
        public DefaultRefinersArray createFromParcel(Parcel parcel) {
            return new DefaultRefinersArray(parcel);
        }

        public DefaultRefinersArray[] newArray(int i) {
            return new DefaultRefinersArray[i];
        }
    };
    @SerializedName("Refiners")
    public ArrayList<DefaultRefiner> defaultRefinersList;
    @SerializedName("DisplayName")
    public String displayName;
    @SerializedName("RefinerTypeValue")
    public String refinerTypeValue;

    public int describeContents() {
        return 0;
    }

    protected DefaultRefinersArray(Parcel parcel) {
        this.displayName = parcel.readString();
        this.refinerTypeValue = parcel.readString();
        parcel.readTypedList(this.defaultRefinersList, DefaultRefiner.CREATOR);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.displayName);
        parcel.writeString(this.refinerTypeValue);
        parcel.writeTypedList(this.defaultRefinersList);
    }
}
