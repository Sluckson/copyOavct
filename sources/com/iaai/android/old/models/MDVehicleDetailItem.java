package com.iaai.android.old.models;

import android.os.Parcel;
import android.os.Parcelable;
import org.codehaus.jackson.annotate.JsonProperty;

public class MDVehicleDetailItem implements Parcelable {
    public static final Parcelable.Creator<MDVehicleDetailItem> CREATOR = new Parcelable.Creator<MDVehicleDetailItem>() {
        public MDVehicleDetailItem createFromParcel(Parcel parcel) {
            return new MDVehicleDetailItem(parcel);
        }

        public MDVehicleDetailItem[] newArray(int i) {
            return new MDVehicleDetailItem[i];
        }
    };
    @JsonProperty("key")
    public String key;
    @JsonProperty("value")
    public String value;

    public int describeContents() {
        return 0;
    }

    public MDVehicleDetailItem() {
    }

    public MDVehicleDetailItem(Parcel parcel) {
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
