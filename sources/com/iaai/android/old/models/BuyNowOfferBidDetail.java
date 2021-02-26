package com.iaai.android.old.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class BuyNowOfferBidDetail implements Parcelable {
    public static final Parcelable.Creator<BuyNowOfferBidDetail> CREATOR = new Parcelable.Creator<BuyNowOfferBidDetail>() {
        public BuyNowOfferBidDetail createFromParcel(Parcel parcel) {
            return new BuyNowOfferBidDetail(parcel);
        }

        public BuyNowOfferBidDetail[] newArray(int i) {
            return new BuyNowOfferBidDetail[i];
        }
    };
    @SerializedName("AuctionCloseTime")
    public String AuctionCloseTime;
    @SerializedName("AuctionId")
    public String AuctionId;
    @SerializedName("BidAmount")
    public String BidAmount;
    @SerializedName("BidStatus")
    public boolean BidStatus;
    @SerializedName("BranchName")
    public String BranchName;
    @SerializedName("Branchnumber")
    public String Branchnumber;
    @SerializedName("BuyNowOfferStatus")
    public String BuyNowOfferStatus;
    @SerializedName("CATInd")
    public boolean CATInd;
    @SerializedName("ClosedBidAmount")
    public String ClosedBidAmount;
    @SerializedName("ClosingStatus")
    public String ClosingStatus;
    @SerializedName("CurrentBid")
    public String CurrentBid;
    @SerializedName("Damage")
    public String Damage;
    @SerializedName("DisableWatch")
    public boolean DisableWatch;
    @SerializedName("ErrorMessage")
    public String ErrorMessage;
    @SerializedName("FormatedCurrentBid")
    public String FormatedCurrentBid;
    @SerializedName("IsHighBidder")
    public boolean IsHighBidder;
    @SerializedName("ItemId")
    public String ItemId;
    @SerializedName("Lane")
    public String Lane;
    @SerializedName("LaneAndItemNumber")
    public String LaneAndItemNumber;
    @SerializedName("LaneItemNumber")
    public String LaneItemNumber;
    @SerializedName("LastBidUser")
    public String LastBidUser;
    @SerializedName("LiveDate")
    public String LiveDate;
    @SerializedName("LossType")
    public String LossType;
    @SerializedName("Make")
    public String Make;
    @SerializedName("MaxBid")
    public String MaxBid;
    @SerializedName("MinimumBidAmount")
    public String MinimumBidAmount;
    @SerializedName("Model")
    public String Model;
    @SerializedName("MyBidStock")
    public boolean MyBidStock;
    @SerializedName("MyBidUserID")
    public String MyBidUserID;
    @SerializedName("MyMaxBid")
    public String MyMaxBid;
    @SerializedName("Odometer")
    public String Odometer;
    @SerializedName("OdometerStatus")
    public String OdometerStatus;
    @SerializedName("OfferAmount")
    public String OfferAmount;
    @SerializedName("OfferProcessed")
    public String OfferProcessed;
    @SerializedName("OffsiteInd")
    public boolean OffsiteInd;
    @SerializedName("OffsiteText")
    public String OffsiteText;
    @SerializedName("ProviderDisplayInd")
    public boolean ProviderDisplayInd;
    @SerializedName("PublicVehicle")
    public String PublicVehicle;
    @SerializedName("ReserveMet")
    public boolean ReserveMet;
    @SerializedName("ResultCode")
    public String ResultCode;
    @SerializedName("RowNumber")
    public String RowNumber;
    @SerializedName("RunAndDrive")
    public String RunAndDrive;
    @SerializedName("SalvageId")
    public String SalvageId;
    @SerializedName("SalvageProviderName")
    public String SalvageProviderName;
    @SerializedName("SecondaryDamage")
    public String SecondaryDamage;
    @SerializedName("Series")
    public String Series;
    @SerializedName("Slot")
    public String Slot;
    @SerializedName("SlotOrder")
    public String SlotOrder;
    @SerializedName("StartingBid")
    public String StartingBid;
    @SerializedName("StockNumber")
    public String StockNumber;
    @SerializedName("StorageLocationName")
    public String StorageLocationName;
    @SerializedName("SuggestedStart")
    public String SuggestedStart;
    @SerializedName("TimedAuctionCloseTimeCST")
    public String TimedAuctionCloseTimeCST;
    @SerializedName("TimedAuctionClosed")
    public boolean TimedAuctionClosed;
    @SerializedName("TotalRows")
    public String TotalRows;
    @SerializedName("VIN")
    public String VIN;
    @SerializedName("VehicleStarts")
    public String VehicleStarts;
    @SerializedName("VehicleTitle")
    public String VehicleTitle;
    @SerializedName("WatchStockNum")
    public String WatchStockNum;
    @SerializedName("Year")
    public String Year;

    public int describeContents() {
        return 0;
    }

    protected BuyNowOfferBidDetail(Parcel parcel) {
        this.Year = parcel.readString();
        this.Make = parcel.readString();
        this.Model = parcel.readString();
        this.LossType = parcel.readString();
        this.StockNumber = parcel.readString();
        this.VIN = parcel.readString();
        this.Odometer = parcel.readString();
        this.Lane = parcel.readString();
        this.LaneItemNumber = parcel.readString();
        this.Series = parcel.readString();
        this.ItemId = parcel.readString();
        this.BranchName = parcel.readString();
        this.Damage = parcel.readString();
        this.SecondaryDamage = parcel.readString();
        this.VehicleTitle = parcel.readString();
        this.RowNumber = parcel.readString();
        this.Slot = parcel.readString();
        this.SlotOrder = parcel.readString();
        this.WatchStockNum = parcel.readString();
        this.LastBidUser = parcel.readString();
        this.MaxBid = parcel.readString();
        this.MyMaxBid = parcel.readString();
        this.BidAmount = parcel.readString();
        this.CurrentBid = parcel.readString();
        this.FormatedCurrentBid = parcel.readString();
        this.LiveDate = parcel.readString();
        this.MyBidUserID = parcel.readString();
        this.Branchnumber = parcel.readString();
        this.LaneAndItemNumber = parcel.readString();
        this.ClosedBidAmount = parcel.readString();
        boolean z = true;
        this.DisableWatch = parcel.readByte() != 0;
        this.BidStatus = parcel.readByte() != 0;
        this.MyBidStock = parcel.readByte() != 0;
        this.OdometerStatus = parcel.readString();
        this.TimedAuctionCloseTimeCST = parcel.readString();
        this.AuctionCloseTime = parcel.readString();
        this.RunAndDrive = parcel.readString();
        this.VehicleStarts = parcel.readString();
        this.PublicVehicle = parcel.readString();
        this.TotalRows = parcel.readString();
        this.SalvageId = parcel.readString();
        this.MinimumBidAmount = parcel.readString();
        this.ClosingStatus = parcel.readString();
        this.ReserveMet = parcel.readByte() != 0;
        this.TimedAuctionClosed = parcel.readByte() != 0;
        this.IsHighBidder = parcel.readByte() != 0;
        this.SalvageProviderName = parcel.readString();
        this.ProviderDisplayInd = parcel.readByte() != 0;
        this.AuctionId = parcel.readString();
        this.BuyNowOfferStatus = parcel.readString();
        this.OfferProcessed = parcel.readString();
        this.OffsiteInd = parcel.readByte() != 0;
        this.OffsiteText = parcel.readString();
        this.CATInd = parcel.readByte() == 0 ? false : z;
        this.StorageLocationName = parcel.readString();
        this.ErrorMessage = parcel.readString();
        this.ResultCode = parcel.readString();
        this.OfferAmount = parcel.readString();
        this.SuggestedStart = parcel.readString();
        this.StartingBid = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.Year);
        parcel.writeString(this.Make);
        parcel.writeString(this.Model);
        parcel.writeString(this.LossType);
        parcel.writeString(this.StockNumber);
        parcel.writeString(this.VIN);
        parcel.writeString(this.Odometer);
        parcel.writeString(this.Lane);
        parcel.writeString(this.LaneItemNumber);
        parcel.writeString(this.Series);
        parcel.writeString(this.ItemId);
        parcel.writeString(this.BranchName);
        parcel.writeString(this.Damage);
        parcel.writeString(this.SecondaryDamage);
        parcel.writeString(this.VehicleTitle);
        parcel.writeString(this.RowNumber);
        parcel.writeString(this.Slot);
        parcel.writeString(this.SlotOrder);
        parcel.writeString(this.WatchStockNum);
        parcel.writeString(this.LastBidUser);
        parcel.writeString(this.MaxBid);
        parcel.writeString(this.MyMaxBid);
        parcel.writeString(this.BidAmount);
        parcel.writeString(this.CurrentBid);
        parcel.writeString(this.FormatedCurrentBid);
        parcel.writeString(this.LiveDate);
        parcel.writeString(this.MyBidUserID);
        parcel.writeString(this.Branchnumber);
        parcel.writeString(this.LaneAndItemNumber);
        parcel.writeString(this.ClosedBidAmount);
        parcel.writeByte(this.DisableWatch ? (byte) 1 : 0);
        parcel.writeByte(this.BidStatus ? (byte) 1 : 0);
        parcel.writeByte(this.MyBidStock ? (byte) 1 : 0);
        parcel.writeString(this.OdometerStatus);
        parcel.writeString(this.TimedAuctionCloseTimeCST);
        parcel.writeString(this.AuctionCloseTime);
        parcel.writeString(this.RunAndDrive);
        parcel.writeString(this.VehicleStarts);
        parcel.writeString(this.PublicVehicle);
        parcel.writeString(this.TotalRows);
        parcel.writeString(this.SalvageId);
        parcel.writeString(this.MinimumBidAmount);
        parcel.writeString(this.ClosingStatus);
        parcel.writeByte(this.ReserveMet ? (byte) 1 : 0);
        parcel.writeByte(this.TimedAuctionClosed ? (byte) 1 : 0);
        parcel.writeByte(this.IsHighBidder ? (byte) 1 : 0);
        parcel.writeString(this.SalvageProviderName);
        parcel.writeByte(this.ProviderDisplayInd ? (byte) 1 : 0);
        parcel.writeString(this.AuctionId);
        parcel.writeString(this.BuyNowOfferStatus);
        parcel.writeString(this.OfferProcessed);
        parcel.writeByte(this.OffsiteInd ? (byte) 1 : 0);
        parcel.writeString(this.OffsiteText);
        parcel.writeByte(this.CATInd ? (byte) 1 : 0);
        parcel.writeString(this.StorageLocationName);
        parcel.writeString(this.ErrorMessage);
        parcel.writeString(this.ResultCode);
        parcel.writeString(this.OfferAmount);
        parcel.writeString(this.SuggestedStart);
        parcel.writeString(this.StartingBid);
    }
}
