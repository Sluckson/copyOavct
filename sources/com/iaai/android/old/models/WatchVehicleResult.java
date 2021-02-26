package com.iaai.android.old.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.iaai.android.old.utils.ParcelUtils;
import org.codehaus.jackson.annotate.JsonProperty;

public class WatchVehicleResult implements Parcelable {
    public static final Parcelable.Creator<WatchVehicleResult> CREATOR = new Parcelable.Creator<WatchVehicleResult>() {
        public WatchVehicleResult createFromParcel(Parcel parcel) {
            return new WatchVehicleResult(parcel);
        }

        public WatchVehicleResult[] newArray(int i) {
            return new WatchVehicleResult[i];
        }
    };
    @JsonProperty("IsSuccessful")
    public boolean isSuccessful;
    @JsonProperty("Message")
    public String message;

    public int describeContents() {
        return 0;
    }

    public WatchVehicleResult() {
    }

    public WatchVehicleResult(Parcel parcel) {
        this.isSuccessful = ParcelUtils.readBoolean(parcel);
        this.message = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeBoolean(parcel, this.isSuccessful);
        parcel.writeString(this.message);
    }
}
