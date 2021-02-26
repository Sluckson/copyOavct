package com.iaai.android.old.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class AuctionLanes implements Parcelable {
    public static final Parcelable.Creator<AuctionLanes> CREATOR = new Parcelable.Creator<AuctionLanes>() {
        public AuctionLanes createFromParcel(Parcel parcel) {
            return new AuctionLanes(parcel);
        }

        public AuctionLanes[] newArray(int i) {
            return new AuctionLanes[i];
        }
    };
    @SerializedName("Auctionlane")
    public String auctionLane;
    @SerializedName("AuctionName")
    public String auctionName;
    @SerializedName("BranchNumber")
    public String branchNumber;
    @SerializedName("CompleteIndicator")
    public String completeIndicator;
    @SerializedName("LiveDate")
    public String liveDate;
    @SerializedName("ProgresIndicator")
    public String progresIndicator;

    public int describeContents() {
        return 0;
    }

    public AuctionLanes() {
    }

    public AuctionLanes(Parcel parcel) {
        this.auctionName = parcel.readString();
        this.auctionLane = parcel.readString();
        this.branchNumber = parcel.readString();
        this.completeIndicator = parcel.readString();
        this.liveDate = parcel.readString();
        this.progresIndicator = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.auctionName);
        parcel.writeString(this.auctionLane);
        parcel.writeString(this.branchNumber);
        parcel.writeString(this.completeIndicator);
        parcel.writeString(this.liveDate);
        parcel.writeString(this.progresIndicator);
    }
}
