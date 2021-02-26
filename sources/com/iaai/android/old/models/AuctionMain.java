package com.iaai.android.old.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import org.codehaus.jackson.annotate.JsonProperty;

public class AuctionMain implements Parcelable {
    public static final Parcelable.Creator<AuctionMain> CREATOR = new Parcelable.Creator<AuctionMain>() {
        public AuctionMain createFromParcel(Parcel parcel) {
            return new AuctionMain(parcel);
        }

        public AuctionMain[] newArray(int i) {
            return new AuctionMain[i];
        }
    };
    @JsonProperty("AuctionCalender")
    public AuctionCalender auctionCalender;
    @JsonProperty("AuctionLocations")
    public ArrayList<Auction> auctions;

    public int describeContents() {
        return 0;
    }

    public AuctionMain() {
    }

    public AuctionMain(Parcel parcel) {
        this.auctionCalender = (AuctionCalender) parcel.readParcelable(AuctionCalender.class.getClassLoader());
        this.auctions = parcel.readArrayList(Auction.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.auctionCalender, 0);
        parcel.writeTypedList(this.auctions);
    }
}
