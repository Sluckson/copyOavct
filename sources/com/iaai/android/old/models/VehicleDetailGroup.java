package com.iaai.android.old.models;

import android.os.Parcel;
import android.os.Parcelable;
import org.codehaus.jackson.annotate.JsonProperty;

public class VehicleDetailGroup implements Parcelable {
    public static final Parcelable.Creator<VehicleDetailGroup> CREATOR = new Parcelable.Creator<VehicleDetailGroup>() {
        public VehicleDetailGroup createFromParcel(Parcel parcel) {
            return new VehicleDetailGroup(parcel);
        }

        public VehicleDetailGroup[] newArray(int i) {
            return new VehicleDetailGroup[i];
        }
    };
    @JsonProperty("Key")
    public String key;
    @JsonProperty("Value")
    public VehicleDetailItem[] value;

    public int describeContents() {
        return 0;
    }

    public VehicleDetailGroup() {
    }

    public VehicleDetailGroup(Parcel parcel) {
        this.key = parcel.readString();
        this.value = (VehicleDetailItem[]) parcel.readParcelableArray(VehicleDetailItem[].class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.key);
        parcel.writeParcelableArray(this.value, 0);
    }
}
