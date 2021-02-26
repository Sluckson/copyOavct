package com.iaai.android.old.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.iaai.android.old.utils.ParcelUtils;
import org.codehaus.jackson.annotate.JsonProperty;

public class GenerateOTPResult implements Parcelable {
    public static final Parcelable.Creator<GenerateOTPResult> CREATOR = new Parcelable.Creator<GenerateOTPResult>() {
        public GenerateOTPResult createFromParcel(Parcel parcel) {
            return new GenerateOTPResult(parcel);
        }

        public GenerateOTPResult[] newArray(int i) {
            return new GenerateOTPResult[i];
        }
    };
    @JsonProperty("Error")
    public String Error;
    @JsonProperty("RowsAffected")
    public int RowsAffected;
    @JsonProperty("Success")
    public boolean Success;

    public int describeContents() {
        return 0;
    }

    public GenerateOTPResult() {
    }

    public GenerateOTPResult(Parcel parcel) {
        this.Success = ParcelUtils.readBoolean(parcel);
        this.Error = parcel.readString();
        this.RowsAffected = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeBoolean(parcel, this.Success);
        parcel.writeString(this.Error);
        parcel.writeInt(this.RowsAffected);
    }
}
