package com.iaai.android.old.models;

import android.os.Parcel;
import android.os.Parcelable;
import org.codehaus.jackson.annotate.JsonProperty;

public class VehicleDetailItem implements Parcelable {
    public static final Parcelable.Creator<VehicleDetailItem> CREATOR = new Parcelable.Creator<VehicleDetailItem>() {
        public VehicleDetailItem createFromParcel(Parcel parcel) {
            return new VehicleDetailItem(parcel);
        }

        public VehicleDetailItem[] newArray(int i) {
            return new VehicleDetailItem[i];
        }
    };
    @JsonProperty("_key")
    public String key;
    @JsonProperty("_value")
    public String value;

    public int describeContents() {
        return 0;
    }

    public VehicleDetailItem() {
    }

    public VehicleDetailItem(Parcel parcel) {
        this.key = parcel.readString();
        this.value = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.key);
        parcel.writeString(this.value);
    }

    public String toString() {
        return String.format("key[%s] value[%s]", new Object[]{this.key, this.value});
    }
}
