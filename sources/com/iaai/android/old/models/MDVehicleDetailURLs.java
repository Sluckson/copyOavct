package com.iaai.android.old.models;

import android.os.Parcel;
import android.os.Parcelable;

public class MDVehicleDetailURLs implements Parcelable {
    public static final Parcelable.Creator<MDVehicleDetailURLs> CREATOR = new Parcelable.Creator<MDVehicleDetailURLs>() {
        public MDVehicleDetailURLs createFromParcel(Parcel parcel) {
            return new MDVehicleDetailURLs(parcel);
        }

        public MDVehicleDetailURLs[] newArray(int i) {
            return new MDVehicleDetailURLs[i];
        }
    };
    public String url;

    public int describeContents() {
        return 0;
    }

    public MDVehicleDetailURLs() {
    }

    public MDVehicleDetailURLs(Parcel parcel) {
        this.url = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.url);
    }
}
