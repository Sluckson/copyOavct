package com.iaai.android.old.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import org.codehaus.jackson.annotate.JsonProperty;

public class AuctionCalender implements Parcelable {
    public static final Parcelable.Creator<AuctionCalender> CREATOR = new Parcelable.Creator<AuctionCalender>() {
        public AuctionCalender createFromParcel(Parcel parcel) {
            return new AuctionCalender(parcel);
        }

        public AuctionCalender[] newArray(int i) {
            return new AuctionCalender[i];
        }
    };
    @JsonProperty("AuctionCalendarInfo")
    public ArrayList<AuctionCalendarInfo> auctionCalendarInfoArrayList;
    @JsonProperty("CurrentAuction")
    public String currentAuction;
    @JsonProperty("CurrentAuctionLable")
    public String currentAuctionLable;
    @JsonProperty("NextAuction")
    public String nextAuction;
    @JsonProperty("NextAuctionLable")
    public String nextAuctionLable;

    public int describeContents() {
        return 0;
    }

    public AuctionCalender() {
    }

    public AuctionCalender(Parcel parcel) {
        this.auctionCalendarInfoArrayList = parcel.readArrayList(AuctionCalendarInfo.class.getClassLoader());
        this.currentAuction = parcel.readString();
        this.currentAuctionLable = parcel.readString();
        this.nextAuction = parcel.readString();
        this.nextAuctionLable = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.auctionCalendarInfoArrayList);
        parcel.writeString(this.currentAuction);
        parcel.writeString(this.currentAuctionLable);
        parcel.writeString(this.nextAuction);
        parcel.writeString(this.nextAuctionLable);
    }
}
