package com.iaai.android.old.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.iaai.android.old.utils.ParcelUtils;
import org.codehaus.jackson.annotate.JsonProperty;

public class IBuyFastResult implements Parcelable {
    public static final Parcelable.Creator<IBuyFastResult> CREATOR = new Parcelable.Creator<IBuyFastResult>() {
        public IBuyFastResult createFromParcel(Parcel parcel) {
            return new IBuyFastResult(parcel);
        }

        public IBuyFastResult[] newArray(int i) {
            return new IBuyFastResult[i];
        }
    };
    @JsonProperty("canbuyerbuy")
    public boolean isSuccessful;
    public String message;

    public int describeContents() {
        return 0;
    }

    public IBuyFastResult() {
    }

    public IBuyFastResult(Parcel parcel) {
        this.isSuccessful = ParcelUtils.readBoolean(parcel);
        this.message = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeBoolean(parcel, this.isSuccessful);
        parcel.writeString(this.message);
    }
}
