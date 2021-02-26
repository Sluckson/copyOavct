package com.iaai.android.old.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.Comparator;

public class NewSearchVehicleList implements Parcelable, Comparator<NewSearchVehicleList> {
    public static final Parcelable.Creator<NewSearchVehicleList> CREATOR = new Parcelable.Creator<NewSearchVehicleList>() {
        public NewSearchVehicleList createFromParcel(Parcel parcel) {
            return new NewSearchVehicleList(parcel);
        }

        public NewSearchVehicleList[] newArray(int i) {
            return new NewSearchVehicleList[i];
        }
    };
    @SerializedName("Branchnumber")
    public String Branchnumber;
    @SerializedName("Damage")
    public String Damage;
    @SerializedName("ImageUrl")
    public String ImageUrl;
    @SerializedName("ItemId")
    public long ItemId;
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
    @SerializedName("TimedAuctionInd")
    public boolean TimedAuctionInd;
    @SerializedName("TimedAuctionCloseTimeCST")
    public String TimedAuctionIndicator;
    @SerializedName("Year")
    public String Year;
    @SerializedName("BranchName")
    public String branchName;
    @SerializedName("LaneAndItemNumber")
    public String laneAndItemNumber;
    @SerializedName("LiveDate")
    public String liveDate;
    @SerializedName("LossType")
    public String lossType;

    public int compare(NewSearchVehicleList newSearchVehicleList, NewSearchVehicleList newSearchVehicleList2) {
        return 0;
    }

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

    protected NewSearchVehicleList(Parcel parcel) {
        this.Year = parcel.readString();
        this.Make = parcel.readString();
        this.Model = parcel.readString();
        this.lossType = parcel.readString();
        this.Damage = parcel.readString();
        this.branchName = parcel.readString();
        this.Branchnumber = parcel.readString();
        this.State = parcel.readString();
        this.laneAndItemNumber = parcel.readString();
        this.ItemId = parcel.readLong();
        this.SalvageId = parcel.readLong();
        this.StockNumber = parcel.readLong();
        this.ImageUrl = parcel.readString();
        this.Odometer = parcel.readString();
        this.TimedAuctionIndicator = parcel.readString();
        this.TimedAuctionInd = parcel.readByte() != 0;
        this.liveDate = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.Year);
        parcel.writeString(this.Make);
        parcel.writeString(this.Model);
        parcel.writeString(this.lossType);
        parcel.writeString(this.Damage);
        parcel.writeString(this.branchName);
        parcel.writeString(this.Branchnumber);
        parcel.writeString(this.State);
        parcel.writeString(this.laneAndItemNumber);
        parcel.writeLong(this.ItemId);
        parcel.writeLong(this.SalvageId);
        parcel.writeLong(this.StockNumber);
        parcel.writeString(this.ImageUrl);
        parcel.writeString(this.Odometer);
        parcel.writeString(this.TimedAuctionIndicator);
        parcel.writeByte(this.TimedAuctionInd ? (byte) 1 : 0);
        parcel.writeString(this.liveDate);
    }
}
