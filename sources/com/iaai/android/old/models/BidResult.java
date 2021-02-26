package com.iaai.android.old.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.iaai.android.old.utils.ParcelUtils;
import org.codehaus.jackson.annotate.JsonProperty;

public class BidResult implements Parcelable {
    public static final Parcelable.Creator<BidResult> CREATOR = new Parcelable.Creator<BidResult>() {
        public BidResult createFromParcel(Parcel parcel) {
            return new BidResult(parcel);
        }

        public BidResult[] newArray(int i) {
            return new BidResult[i];
        }
    };
    public String bidding;
    @JsonProperty("ConfirmationNumber")
    public String confirmationNo;
    @JsonProperty("IsSuccessful")
    public boolean isSuccessful;
    public String message;

    public int describeContents() {
        return 0;
    }

    public BidResult() {
    }

    public BidResult(Parcel parcel) {
        this.bidding = parcel.readString();
        this.message = parcel.readString();
        this.confirmationNo = parcel.readString();
        this.isSuccessful = ParcelUtils.readBoolean(parcel);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.bidding);
        parcel.writeString(this.message);
        parcel.writeString(this.confirmationNo);
        ParcelUtils.writeBoolean(parcel, this.isSuccessful);
    }

    public String getErrorMessage() {
        return TextUtils.isEmpty(this.bidding) ? this.message : this.bidding;
    }
}
