package com.iaai.android.old.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class StateInfo implements Parcelable {
    public static final Parcelable.Creator<StateInfo> CREATOR = new Parcelable.Creator<StateInfo>() {
        public StateInfo createFromParcel(Parcel parcel) {
            return new StateInfo(parcel);
        }

        public StateInfo[] newArray(int i) {
            return new StateInfo[i];
        }
    };
    @SerializedName("count")
    public String count;
    @SerializedName("State")
    public String state;
    @SerializedName("State_Full_Name")
    public String state_Full_Name;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.state);
        parcel.writeString(this.state_Full_Name);
        parcel.writeString(this.count);
    }

    private StateInfo(Parcel parcel) {
        this.state = parcel.readString();
        this.state_Full_Name = parcel.readString();
        this.count = parcel.readString();
    }
}
