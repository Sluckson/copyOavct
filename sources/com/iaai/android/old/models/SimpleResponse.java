package com.iaai.android.old.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.iaai.android.old.utils.ParcelUtils;
import org.codehaus.jackson.annotate.JsonProperty;

public class SimpleResponse implements Parcelable {
    public static final Parcelable.Creator<SimpleResponse> CREATOR = new Parcelable.Creator<SimpleResponse>() {
        public SimpleResponse createFromParcel(Parcel parcel) {
            return new SimpleResponse(parcel);
        }

        public SimpleResponse[] newArray(int i) {
            return new SimpleResponse[i];
        }
    };
    @JsonProperty("IsSuccessful")
    public boolean isSuccessful;
    @JsonProperty("Message")
    public String message;

    public int describeContents() {
        return 0;
    }

    public SimpleResponse() {
    }

    public SimpleResponse(Parcel parcel) {
        this.isSuccessful = ParcelUtils.readBoolean(parcel);
        this.message = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeBoolean(parcel, this.isSuccessful);
        parcel.writeString(this.message);
    }
}
