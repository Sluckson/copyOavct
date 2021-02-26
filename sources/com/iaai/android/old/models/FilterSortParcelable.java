package com.iaai.android.old.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class FilterSortParcelable implements Parcelable {
    public static final Parcelable.Creator<AuctionLanes> CREATOR = new Parcelable.Creator<AuctionLanes>() {
        public AuctionLanes createFromParcel(Parcel parcel) {
            return new AuctionLanes(parcel);
        }

        public AuctionLanes[] newArray(int i) {
            return new AuctionLanes[i];
        }
    };
    @SerializedName("AuctionSaleList")
    public FilterSortModel AuctionSaleList;

    public int describeContents() {
        return 0;
    }

    public FilterSortParcelable() {
    }

    public FilterSortParcelable(Parcel parcel) {
        this.AuctionSaleList = (FilterSortModel) parcel.readParcelable(FilterSortParcelable.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.AuctionSaleList, 0);
    }
}
