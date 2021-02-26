package com.iaai.android.old.models;

import android.os.Parcel;
import android.os.Parcelable;

public class IBidLiveAuthenticationResult implements Parcelable {
    public static final Parcelable.Creator<IBidLiveAuthenticationResult> CREATOR = new Parcelable.Creator<IBidLiveAuthenticationResult>() {
        public IBidLiveAuthenticationResult createFromParcel(Parcel parcel) {
            return new IBidLiveAuthenticationResult(parcel);
        }

        public IBidLiveAuthenticationResult[] newArray(int i) {
            return new IBidLiveAuthenticationResult[i];
        }
    };
    public int laneCount;
    public String validationMessage;

    public int describeContents() {
        return 0;
    }

    public IBidLiveAuthenticationResult() {
    }

    public IBidLiveAuthenticationResult(Parcel parcel) {
        this.validationMessage = parcel.readString();
        this.laneCount = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.validationMessage);
        parcel.writeInt(this.laneCount);
    }
}
