package com.iaai.android.old.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class SearchVehicle implements Parcelable {
    public static final Parcelable.Creator<SearchVehicle> CREATOR = new Parcelable.Creator<SearchVehicle>() {
        public SearchVehicle createFromParcel(Parcel parcel) {
            return new SearchVehicle(parcel);
        }

        public SearchVehicle[] newArray(int i) {
            return new SearchVehicle[i];
        }
    };
    @SerializedName("BranchName")
    public String BranchName;
    @SerializedName("Branchnumber")
    public String Branchnumber;
    @SerializedName("Damage")
    public String Damage;
    @SerializedName("ImageUrl")
    public String ImageUrl;
    @SerializedName("ItemId")
    public long ItemId;
    @SerializedName("LaneAndItemNumber")
    public String LaneAndItemNumber;
    @SerializedName("LossType")
    public String LossType;
    @SerializedName("Make")
    public String Make;
    @SerializedName("Model")
    public String Model;
    @SerializedName("Odobrand")
    public String Odobrand;
    @SerializedName("Odometer")
    public String Odometer;
    @SerializedName("SalvageId")
    public long SalvageId;
    @SerializedName("Series")
    public String Series;
    @SerializedName("State")
    public String State;
    @SerializedName("StockNumber")
    public long StockNumber;
    @SerializedName("TimedAuctionClosedDateTime")
    public String TimedAuctionIndicator;
    @SerializedName("Year")
    public String Year;

    public int describeContents() {
        return 0;
    }

    public String getOdometer() {
        String str = this.Odometer;
        return str != null ? str.trim() : "";
    }

    public void setOdometer(String str) {
        this.Odometer = str;
    }

    protected SearchVehicle(Parcel parcel) {
        this.Year = parcel.readString();
        this.Make = parcel.readString();
        this.Model = parcel.readString();
        this.Series = parcel.readString();
        this.LossType = parcel.readString();
        this.Damage = parcel.readString();
        this.BranchName = parcel.readString();
        this.Branchnumber = parcel.readString();
        this.State = parcel.readString();
        this.LaneAndItemNumber = parcel.readString();
        this.ItemId = parcel.readLong();
        this.SalvageId = parcel.readLong();
        this.StockNumber = parcel.readLong();
        this.ImageUrl = parcel.readString();
        this.Odometer = parcel.readString();
        this.Odobrand = parcel.readString();
        this.TimedAuctionIndicator = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.Year);
        parcel.writeString(this.Make);
        parcel.writeString(this.Model);
        parcel.writeString(this.Series);
        parcel.writeString(this.LossType);
        parcel.writeString(this.Damage);
        parcel.writeString(this.BranchName);
        parcel.writeString(this.Branchnumber);
        parcel.writeString(this.State);
        parcel.writeString(this.LaneAndItemNumber);
        parcel.writeLong(this.ItemId);
        parcel.writeLong(this.SalvageId);
        parcel.writeLong(this.StockNumber);
        parcel.writeString(this.ImageUrl);
        parcel.writeString(this.Odometer);
        parcel.writeString(this.Odobrand);
        parcel.writeString(this.TimedAuctionIndicator);
    }
}
