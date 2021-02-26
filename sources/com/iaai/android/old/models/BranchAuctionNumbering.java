package com.iaai.android.old.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class BranchAuctionNumbering implements Parcelable {
    public static final Parcelable.Creator<BranchAuctionNumbering> CREATOR = new Parcelable.Creator<BranchAuctionNumbering>() {
        public BranchAuctionNumbering createFromParcel(Parcel parcel) {
            return new BranchAuctionNumbering(parcel);
        }

        public BranchAuctionNumbering[] newArray(int i) {
            return new BranchAuctionNumbering[i];
        }
    };
    @SerializedName("EndItemNumber")
    public String endItemNumber;
    @SerializedName("SaleOrderInfo")
    public String saleOrderInfo;
    @SerializedName("SeqNumber")
    public String seqNumber;
    @SerializedName("StartItemNumber")
    public String startItemNumber;

    public int describeContents() {
        return 0;
    }

    public BranchAuctionNumbering() {
    }

    public BranchAuctionNumbering(Parcel parcel) {
        this.endItemNumber = parcel.readString();
        this.saleOrderInfo = parcel.readString();
        this.seqNumber = parcel.readString();
        this.startItemNumber = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.endItemNumber);
        parcel.writeString(this.saleOrderInfo);
        parcel.writeString(this.seqNumber);
        parcel.writeString(this.startItemNumber);
    }
}
