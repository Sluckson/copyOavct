package com.iaai.android.old.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.iaai.android.old.utils.ParcelUtils;
import java.util.ArrayList;
import org.codehaus.jackson.annotate.JsonProperty;

public class LoadAlertsResult implements Parcelable {
    public static final Parcelable.Creator<LoadAlertsResult> CREATOR = new Parcelable.Creator<LoadAlertsResult>() {
        public LoadAlertsResult createFromParcel(Parcel parcel) {
            return new LoadAlertsResult(parcel);
        }

        public LoadAlertsResult[] newArray(int i) {
            return new LoadAlertsResult[i];
        }
    };
    @JsonProperty("alertmessage")
    public ArrayList<Alert> alerts;
    @JsonProperty("IsSuccessful")
    public boolean isSuccessful;
    @JsonProperty("ValidationMessage")
    public String message;

    public int describeContents() {
        return 0;
    }

    public LoadAlertsResult() {
    }

    public LoadAlertsResult(Parcel parcel) {
        this.isSuccessful = ParcelUtils.readBoolean(parcel);
        this.message = parcel.readString();
        this.alerts = parcel.readArrayList(Alert.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeBoolean(parcel, this.isSuccessful);
        parcel.writeString(this.message);
        parcel.writeTypedList(this.alerts);
    }
}
