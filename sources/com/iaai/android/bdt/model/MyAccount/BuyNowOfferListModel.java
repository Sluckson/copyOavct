package com.iaai.android.bdt.model.MyAccount;

import androidx.recyclerview.widget.DiffUtil;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0003\b®\u0001\u0018\u0000 ½\u00012\u00020\u0001:\u0002½\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR \u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR \u0010\u001b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001e\u0010\u001e\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014R \u0010!\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR \u0010$\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR \u0010'\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR \u0010*\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR\u001e\u0010-\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0012\"\u0004\b/\u0010\u0014R \u00100\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\bR \u00103\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0006\"\u0004\b5\u0010\bR\u001e\u00106\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0012\"\u0004\b8\u0010\u0014R \u00109\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0006\"\u0004\b;\u0010\bR \u0010<\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0006\"\u0004\b>\u0010\bR \u0010?\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0006\"\u0004\bA\u0010\bR \u0010B\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0006\"\u0004\bD\u0010\bR \u0010E\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u0006\"\u0004\bG\u0010\bR \u0010H\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u0006\"\u0004\bJ\u0010\bR \u0010K\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u0006\"\u0004\bM\u0010\bR \u0010N\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u0006\"\u0004\bP\u0010\bR \u0010Q\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\u0006\"\u0004\bS\u0010\bR \u0010T\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010\u0006\"\u0004\bV\u0010\bR \u0010W\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010\u0006\"\u0004\bY\u0010\bR\u001e\u0010Z\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\u0012\"\u0004\b\\\u0010\u0014R \u0010]\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010\u0006\"\u0004\b_\u0010\bR \u0010`\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010\u0006\"\u0004\bb\u0010\bR \u0010c\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010\u0006\"\u0004\be\u0010\bR \u0010f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010\u0006\"\u0004\bh\u0010\bR \u0010i\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010\u0006\"\u0004\bk\u0010\bR \u0010l\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010\u0006\"\u0004\bn\u0010\bR\u001e\u0010o\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010\u0012\"\u0004\bq\u0010\u0014R \u0010r\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010\u0006\"\u0004\bt\u0010\bR\u001e\u0010u\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010\u0012\"\u0004\bw\u0010\u0014R \u0010x\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\by\u0010\u0006\"\u0004\bz\u0010\bR\u001e\u0010{\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b|\u0010\u0012\"\u0004\b}\u0010\u0014R!\u0010~\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b\u0010\u0006\"\u0005\b\u0001\u0010\bR#\u0010\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u0006\"\u0005\b\u0001\u0010\bR#\u0010\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u0006\"\u0005\b\u0001\u0010\bR#\u0010\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u0006\"\u0005\b\u0001\u0010\bR#\u0010\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u0006\"\u0005\b\u0001\u0010\bR#\u0010\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u0006\"\u0005\b\u0001\u0010\bR#\u0010\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u0006\"\u0005\b\u0001\u0010\bR#\u0010\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u0006\"\u0005\b\u0001\u0010\bR#\u0010\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u0006\"\u0005\b\u0001\u0010\bR#\u0010\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u0006\"\u0005\b\u0001\u0010\bR#\u0010\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u0006\"\u0005\b\u0001\u0010\bR#\u0010\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b \u0001\u0010\u0006\"\u0005\b¡\u0001\u0010\bR#\u0010¢\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b£\u0001\u0010\u0006\"\u0005\b¤\u0001\u0010\bR#\u0010¥\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¦\u0001\u0010\u0006\"\u0005\b§\u0001\u0010\bR!\u0010¨\u0001\u001a\u00020\u00108\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b©\u0001\u0010\u0012\"\u0005\bª\u0001\u0010\u0014R#\u0010«\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¬\u0001\u0010\u0006\"\u0005\b­\u0001\u0010\bR#\u0010®\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¯\u0001\u0010\u0006\"\u0005\b°\u0001\u0010\bR#\u0010±\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b²\u0001\u0010\u0006\"\u0005\b³\u0001\u0010\bR#\u0010´\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bµ\u0001\u0010\u0006\"\u0005\b¶\u0001\u0010\bR#\u0010·\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¸\u0001\u0010\u0006\"\u0005\b¹\u0001\u0010\bR#\u0010º\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b»\u0001\u0010\u0006\"\u0005\b¼\u0001\u0010\b¨\u0006¾\u0001"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/MyAccount/BuyNowOfferListModel;", "", "()V", "AuctionCloseTime", "", "getAuctionCloseTime", "()Ljava/lang/String;", "setAuctionCloseTime", "(Ljava/lang/String;)V", "AuctionId", "getAuctionId", "setAuctionId", "BidAmount", "getBidAmount", "setBidAmount", "BidStatus", "", "getBidStatus", "()Z", "setBidStatus", "(Z)V", "BranchName", "getBranchName", "setBranchName", "Branchnumber", "getBranchnumber", "setBranchnumber", "BuyNowOfferStatus", "getBuyNowOfferStatus", "setBuyNowOfferStatus", "CATInd", "getCATInd", "setCATInd", "ClosedBidAmount", "getClosedBidAmount", "setClosedBidAmount", "ClosingStatus", "getClosingStatus", "setClosingStatus", "CurrentBid", "getCurrentBid", "setCurrentBid", "Damage", "getDamage", "setDamage", "DisableWatch", "getDisableWatch", "setDisableWatch", "ErrorMessage", "getErrorMessage", "setErrorMessage", "FormatedCurrentBid", "getFormatedCurrentBid", "setFormatedCurrentBid", "IsHighBidder", "getIsHighBidder", "setIsHighBidder", "ItemId", "getItemId", "setItemId", "Lane", "getLane", "setLane", "LaneAndItemNumber", "getLaneAndItemNumber", "setLaneAndItemNumber", "LaneItemNumber", "getLaneItemNumber", "setLaneItemNumber", "LastBidUser", "getLastBidUser", "setLastBidUser", "LiveDate", "getLiveDate", "setLiveDate", "LossType", "getLossType", "setLossType", "Make", "getMake", "setMake", "MaxBid", "getMaxBid", "setMaxBid", "MinimumBidAmount", "getMinimumBidAmount", "setMinimumBidAmount", "Model", "getModel", "setModel", "MyBidStock", "getMyBidStock", "setMyBidStock", "MyBidUserID", "getMyBidUserID", "setMyBidUserID", "MyMaxBid", "getMyMaxBid", "setMyMaxBid", "Odometer", "getOdometer", "setOdometer", "OdometerStatus", "getOdometerStatus", "setOdometerStatus", "OfferAmount", "getOfferAmount", "setOfferAmount", "OfferProcessed", "getOfferProcessed", "setOfferProcessed", "OffsiteInd", "getOffsiteInd", "setOffsiteInd", "OffsiteText", "getOffsiteText", "setOffsiteText", "ProviderDisplayInd", "getProviderDisplayInd", "setProviderDisplayInd", "PublicVehicle", "getPublicVehicle", "setPublicVehicle", "ReserveMet", "getReserveMet", "setReserveMet", "ResultCode", "getResultCode", "setResultCode", "RowNumber", "getRowNumber", "setRowNumber", "RunAndDrive", "getRunAndDrive", "setRunAndDrive", "SalvageId", "getSalvageId", "setSalvageId", "SalvageProviderName", "getSalvageProviderName", "setSalvageProviderName", "SecondaryDamage", "getSecondaryDamage", "setSecondaryDamage", "Series", "getSeries", "setSeries", "Slot", "getSlot", "setSlot", "SlotOrder", "getSlotOrder", "setSlotOrder", "StartingBid", "getStartingBid", "setStartingBid", "StockNumber", "getStockNumber", "setStockNumber", "StorageLocationName", "getStorageLocationName", "setStorageLocationName", "SuggestedStart", "getSuggestedStart", "setSuggestedStart", "TimedAuctionCloseTimeCST", "getTimedAuctionCloseTimeCST", "setTimedAuctionCloseTimeCST", "TimedAuctionClosed", "getTimedAuctionClosed", "setTimedAuctionClosed", "TotalRows", "getTotalRows", "setTotalRows", "VIN", "getVIN", "setVIN", "VehicleStarts", "getVehicleStarts", "setVehicleStarts", "VehicleTitle", "getVehicleTitle", "setVehicleTitle", "WatchStockNum", "getWatchStockNum", "setWatchStockNum", "Year", "getYear", "setYear", "Companion", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: BuyNowOfferListModel.kt */
public final class BuyNowOfferListModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static DiffUtil.ItemCallback<BuyNowOfferListModel> diffCallback = new BuyNowOfferListModel$Companion$diffCallback$1();
    @SerializedName("AuctionCloseTime")
    @Nullable
    @Expose
    private String AuctionCloseTime;
    @SerializedName("AuctionId")
    @Nullable
    @Expose
    private String AuctionId;
    @SerializedName("BidAmount")
    @Nullable
    @Expose
    private String BidAmount;
    @SerializedName("BidStatus")
    @Expose
    private boolean BidStatus;
    @SerializedName("BranchName")
    @Nullable
    @Expose
    private String BranchName;
    @SerializedName("Branchnumber")
    @Nullable
    @Expose
    private String Branchnumber;
    @SerializedName("BuyNowOfferStatus")
    @Nullable
    @Expose
    private String BuyNowOfferStatus;
    @SerializedName("CATInd")
    @Expose
    private boolean CATInd;
    @SerializedName("ClosedBidAmount")
    @Nullable
    @Expose
    private String ClosedBidAmount;
    @SerializedName("ClosingStatus")
    @Nullable
    @Expose
    private String ClosingStatus;
    @SerializedName("CurrentBid")
    @Nullable
    @Expose
    private String CurrentBid;
    @SerializedName("Damage")
    @Nullable
    @Expose
    private String Damage;
    @SerializedName("DisableWatch")
    @Expose
    private boolean DisableWatch;
    @SerializedName("ErrorMessage")
    @Nullable
    @Expose
    private String ErrorMessage;
    @SerializedName("FormatedCurrentBid")
    @Nullable
    @Expose
    private String FormatedCurrentBid;
    @SerializedName("IsHighBidder")
    @Expose
    private boolean IsHighBidder;
    @SerializedName("ItemId")
    @Nullable
    @Expose
    private String ItemId;
    @SerializedName("Lane")
    @Nullable
    @Expose
    private String Lane;
    @SerializedName("LaneAndItemNumber")
    @Nullable
    @Expose
    private String LaneAndItemNumber;
    @SerializedName("LaneItemNumber")
    @Nullable
    @Expose
    private String LaneItemNumber;
    @SerializedName("LastBidUser")
    @Nullable
    @Expose
    private String LastBidUser;
    @SerializedName("LiveDate")
    @Nullable
    @Expose
    private String LiveDate;
    @SerializedName("LossType")
    @Nullable
    @Expose
    private String LossType;
    @SerializedName("Make")
    @Nullable
    @Expose
    private String Make;
    @SerializedName("MaxBid")
    @Nullable
    @Expose
    private String MaxBid;
    @SerializedName("MinimumBidAmount")
    @Nullable
    @Expose
    private String MinimumBidAmount;
    @SerializedName("Model")
    @Nullable
    @Expose
    private String Model;
    @SerializedName("MyBidStock")
    @Expose
    private boolean MyBidStock;
    @SerializedName("MyBidUserID")
    @Nullable
    @Expose
    private String MyBidUserID;
    @SerializedName("MyMaxBid")
    @Nullable
    @Expose
    private String MyMaxBid;
    @SerializedName("Odometer")
    @Nullable
    @Expose
    private String Odometer;
    @SerializedName("OdometerStatus")
    @Nullable
    @Expose
    private String OdometerStatus;
    @SerializedName("OfferAmount")
    @Nullable
    @Expose
    private String OfferAmount;
    @SerializedName("OfferProcessed")
    @Nullable
    @Expose
    private String OfferProcessed;
    @SerializedName("OffsiteInd")
    @Expose
    private boolean OffsiteInd;
    @SerializedName("OffsiteText")
    @Nullable
    @Expose
    private String OffsiteText;
    @SerializedName("ProviderDisplayInd")
    @Expose
    private boolean ProviderDisplayInd;
    @SerializedName("PublicVehicle")
    @Nullable
    @Expose
    private String PublicVehicle;
    @SerializedName("ReserveMet")
    @Expose
    private boolean ReserveMet;
    @SerializedName("ResultCode")
    @Nullable
    @Expose
    private String ResultCode;
    @SerializedName("RowNumber")
    @Nullable
    @Expose
    private String RowNumber;
    @SerializedName("RunAndDrive")
    @Nullable
    @Expose
    private String RunAndDrive;
    @SerializedName("SalvageId")
    @Nullable
    @Expose
    private String SalvageId;
    @SerializedName("SalvageProviderName")
    @Nullable
    @Expose
    private String SalvageProviderName;
    @SerializedName("SecondaryDamage")
    @Nullable
    @Expose
    private String SecondaryDamage;
    @SerializedName("Series")
    @Nullable
    @Expose
    private String Series;
    @SerializedName("Slot")
    @Nullable
    @Expose
    private String Slot;
    @SerializedName("SlotOrder")
    @Nullable
    @Expose
    private String SlotOrder;
    @SerializedName("StartingBid")
    @Nullable
    @Expose
    private String StartingBid;
    @SerializedName("StockNumber")
    @Nullable
    @Expose
    private String StockNumber;
    @SerializedName("StorageLocationName")
    @Nullable
    @Expose
    private String StorageLocationName;
    @SerializedName("SuggestedStart")
    @Nullable
    @Expose
    private String SuggestedStart;
    @SerializedName("TimedAuctionCloseTimeCST")
    @Nullable
    @Expose
    private String TimedAuctionCloseTimeCST;
    @SerializedName("TimedAuctionClosed")
    @Expose
    private boolean TimedAuctionClosed;
    @SerializedName("TotalRows")
    @Nullable
    @Expose
    private String TotalRows;
    @SerializedName("VIN")
    @Nullable
    @Expose
    private String VIN;
    @SerializedName("VehicleStarts")
    @Nullable
    @Expose
    private String VehicleStarts;
    @SerializedName("VehicleTitle")
    @Nullable
    @Expose
    private String VehicleTitle;
    @SerializedName("WatchStockNum")
    @Nullable
    @Expose
    private String WatchStockNum;
    @SerializedName("Year")
    @Nullable
    @Expose
    private String Year;

    @Nullable
    public final String getYear() {
        return this.Year;
    }

    public final void setYear(@Nullable String str) {
        this.Year = str;
    }

    @Nullable
    public final String getMake() {
        return this.Make;
    }

    public final void setMake(@Nullable String str) {
        this.Make = str;
    }

    @Nullable
    public final String getModel() {
        return this.Model;
    }

    public final void setModel(@Nullable String str) {
        this.Model = str;
    }

    @Nullable
    public final String getLossType() {
        return this.LossType;
    }

    public final void setLossType(@Nullable String str) {
        this.LossType = str;
    }

    @Nullable
    public final String getStockNumber() {
        return this.StockNumber;
    }

    public final void setStockNumber(@Nullable String str) {
        this.StockNumber = str;
    }

    @Nullable
    public final String getVIN() {
        return this.VIN;
    }

    public final void setVIN(@Nullable String str) {
        this.VIN = str;
    }

    @Nullable
    public final String getOdometer() {
        return this.Odometer;
    }

    public final void setOdometer(@Nullable String str) {
        this.Odometer = str;
    }

    @Nullable
    public final String getLane() {
        return this.Lane;
    }

    public final void setLane(@Nullable String str) {
        this.Lane = str;
    }

    @Nullable
    public final String getLaneItemNumber() {
        return this.LaneItemNumber;
    }

    public final void setLaneItemNumber(@Nullable String str) {
        this.LaneItemNumber = str;
    }

    @Nullable
    public final String getSeries() {
        return this.Series;
    }

    public final void setSeries(@Nullable String str) {
        this.Series = str;
    }

    @Nullable
    public final String getItemId() {
        return this.ItemId;
    }

    public final void setItemId(@Nullable String str) {
        this.ItemId = str;
    }

    @Nullable
    public final String getBranchName() {
        return this.BranchName;
    }

    public final void setBranchName(@Nullable String str) {
        this.BranchName = str;
    }

    @Nullable
    public final String getDamage() {
        return this.Damage;
    }

    public final void setDamage(@Nullable String str) {
        this.Damage = str;
    }

    @Nullable
    public final String getSecondaryDamage() {
        return this.SecondaryDamage;
    }

    public final void setSecondaryDamage(@Nullable String str) {
        this.SecondaryDamage = str;
    }

    @Nullable
    public final String getVehicleTitle() {
        return this.VehicleTitle;
    }

    public final void setVehicleTitle(@Nullable String str) {
        this.VehicleTitle = str;
    }

    @Nullable
    public final String getRowNumber() {
        return this.RowNumber;
    }

    public final void setRowNumber(@Nullable String str) {
        this.RowNumber = str;
    }

    @Nullable
    public final String getSlot() {
        return this.Slot;
    }

    public final void setSlot(@Nullable String str) {
        this.Slot = str;
    }

    @Nullable
    public final String getSlotOrder() {
        return this.SlotOrder;
    }

    public final void setSlotOrder(@Nullable String str) {
        this.SlotOrder = str;
    }

    @Nullable
    public final String getWatchStockNum() {
        return this.WatchStockNum;
    }

    public final void setWatchStockNum(@Nullable String str) {
        this.WatchStockNum = str;
    }

    @Nullable
    public final String getLastBidUser() {
        return this.LastBidUser;
    }

    public final void setLastBidUser(@Nullable String str) {
        this.LastBidUser = str;
    }

    @Nullable
    public final String getMaxBid() {
        return this.MaxBid;
    }

    public final void setMaxBid(@Nullable String str) {
        this.MaxBid = str;
    }

    @Nullable
    public final String getMyMaxBid() {
        return this.MyMaxBid;
    }

    public final void setMyMaxBid(@Nullable String str) {
        this.MyMaxBid = str;
    }

    @Nullable
    public final String getBidAmount() {
        return this.BidAmount;
    }

    public final void setBidAmount(@Nullable String str) {
        this.BidAmount = str;
    }

    @Nullable
    public final String getCurrentBid() {
        return this.CurrentBid;
    }

    public final void setCurrentBid(@Nullable String str) {
        this.CurrentBid = str;
    }

    @Nullable
    public final String getFormatedCurrentBid() {
        return this.FormatedCurrentBid;
    }

    public final void setFormatedCurrentBid(@Nullable String str) {
        this.FormatedCurrentBid = str;
    }

    @Nullable
    public final String getLiveDate() {
        return this.LiveDate;
    }

    public final void setLiveDate(@Nullable String str) {
        this.LiveDate = str;
    }

    @Nullable
    public final String getMyBidUserID() {
        return this.MyBidUserID;
    }

    public final void setMyBidUserID(@Nullable String str) {
        this.MyBidUserID = str;
    }

    @Nullable
    public final String getBranchnumber() {
        return this.Branchnumber;
    }

    public final void setBranchnumber(@Nullable String str) {
        this.Branchnumber = str;
    }

    @Nullable
    public final String getLaneAndItemNumber() {
        return this.LaneAndItemNumber;
    }

    public final void setLaneAndItemNumber(@Nullable String str) {
        this.LaneAndItemNumber = str;
    }

    @Nullable
    public final String getClosedBidAmount() {
        return this.ClosedBidAmount;
    }

    public final void setClosedBidAmount(@Nullable String str) {
        this.ClosedBidAmount = str;
    }

    public final boolean getDisableWatch() {
        return this.DisableWatch;
    }

    public final void setDisableWatch(boolean z) {
        this.DisableWatch = z;
    }

    public final boolean getBidStatus() {
        return this.BidStatus;
    }

    public final void setBidStatus(boolean z) {
        this.BidStatus = z;
    }

    public final boolean getMyBidStock() {
        return this.MyBidStock;
    }

    public final void setMyBidStock(boolean z) {
        this.MyBidStock = z;
    }

    @Nullable
    public final String getOdometerStatus() {
        return this.OdometerStatus;
    }

    public final void setOdometerStatus(@Nullable String str) {
        this.OdometerStatus = str;
    }

    @Nullable
    public final String getTimedAuctionCloseTimeCST() {
        return this.TimedAuctionCloseTimeCST;
    }

    public final void setTimedAuctionCloseTimeCST(@Nullable String str) {
        this.TimedAuctionCloseTimeCST = str;
    }

    @Nullable
    public final String getAuctionCloseTime() {
        return this.AuctionCloseTime;
    }

    public final void setAuctionCloseTime(@Nullable String str) {
        this.AuctionCloseTime = str;
    }

    @Nullable
    public final String getRunAndDrive() {
        return this.RunAndDrive;
    }

    public final void setRunAndDrive(@Nullable String str) {
        this.RunAndDrive = str;
    }

    @Nullable
    public final String getVehicleStarts() {
        return this.VehicleStarts;
    }

    public final void setVehicleStarts(@Nullable String str) {
        this.VehicleStarts = str;
    }

    @Nullable
    public final String getPublicVehicle() {
        return this.PublicVehicle;
    }

    public final void setPublicVehicle(@Nullable String str) {
        this.PublicVehicle = str;
    }

    @Nullable
    public final String getTotalRows() {
        return this.TotalRows;
    }

    public final void setTotalRows(@Nullable String str) {
        this.TotalRows = str;
    }

    @Nullable
    public final String getSalvageId() {
        return this.SalvageId;
    }

    public final void setSalvageId(@Nullable String str) {
        this.SalvageId = str;
    }

    @Nullable
    public final String getMinimumBidAmount() {
        return this.MinimumBidAmount;
    }

    public final void setMinimumBidAmount(@Nullable String str) {
        this.MinimumBidAmount = str;
    }

    @Nullable
    public final String getClosingStatus() {
        return this.ClosingStatus;
    }

    public final void setClosingStatus(@Nullable String str) {
        this.ClosingStatus = str;
    }

    public final boolean getReserveMet() {
        return this.ReserveMet;
    }

    public final void setReserveMet(boolean z) {
        this.ReserveMet = z;
    }

    public final boolean getTimedAuctionClosed() {
        return this.TimedAuctionClosed;
    }

    public final void setTimedAuctionClosed(boolean z) {
        this.TimedAuctionClosed = z;
    }

    public final boolean getIsHighBidder() {
        return this.IsHighBidder;
    }

    public final void setIsHighBidder(boolean z) {
        this.IsHighBidder = z;
    }

    @Nullable
    public final String getSalvageProviderName() {
        return this.SalvageProviderName;
    }

    public final void setSalvageProviderName(@Nullable String str) {
        this.SalvageProviderName = str;
    }

    public final boolean getProviderDisplayInd() {
        return this.ProviderDisplayInd;
    }

    public final void setProviderDisplayInd(boolean z) {
        this.ProviderDisplayInd = z;
    }

    @Nullable
    public final String getAuctionId() {
        return this.AuctionId;
    }

    public final void setAuctionId(@Nullable String str) {
        this.AuctionId = str;
    }

    @Nullable
    public final String getBuyNowOfferStatus() {
        return this.BuyNowOfferStatus;
    }

    public final void setBuyNowOfferStatus(@Nullable String str) {
        this.BuyNowOfferStatus = str;
    }

    @Nullable
    public final String getOfferProcessed() {
        return this.OfferProcessed;
    }

    public final void setOfferProcessed(@Nullable String str) {
        this.OfferProcessed = str;
    }

    public final boolean getOffsiteInd() {
        return this.OffsiteInd;
    }

    public final void setOffsiteInd(boolean z) {
        this.OffsiteInd = z;
    }

    @Nullable
    public final String getOffsiteText() {
        return this.OffsiteText;
    }

    public final void setOffsiteText(@Nullable String str) {
        this.OffsiteText = str;
    }

    public final boolean getCATInd() {
        return this.CATInd;
    }

    public final void setCATInd(boolean z) {
        this.CATInd = z;
    }

    @Nullable
    public final String getStorageLocationName() {
        return this.StorageLocationName;
    }

    public final void setStorageLocationName(@Nullable String str) {
        this.StorageLocationName = str;
    }

    @Nullable
    public final String getErrorMessage() {
        return this.ErrorMessage;
    }

    public final void setErrorMessage(@Nullable String str) {
        this.ErrorMessage = str;
    }

    @Nullable
    public final String getResultCode() {
        return this.ResultCode;
    }

    public final void setResultCode(@Nullable String str) {
        this.ResultCode = str;
    }

    @Nullable
    public final String getOfferAmount() {
        return this.OfferAmount;
    }

    public final void setOfferAmount(@Nullable String str) {
        this.OfferAmount = str;
    }

    @Nullable
    public final String getSuggestedStart() {
        return this.SuggestedStart;
    }

    public final void setSuggestedStart(@Nullable String str) {
        this.SuggestedStart = str;
    }

    @Nullable
    public final String getStartingBid() {
        return this.StartingBid;
    }

    public final void setStartingBid(@Nullable String str) {
        this.StartingBid = str;
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/MyAccount/BuyNowOfferListModel$Companion;", "", "()V", "diffCallback", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/iaai/android/bdt/model/MyAccount/BuyNowOfferListModel;", "getDiffCallback", "()Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "setDiffCallback", "(Landroidx/recyclerview/widget/DiffUtil$ItemCallback;)V", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: BuyNowOfferListModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final DiffUtil.ItemCallback<BuyNowOfferListModel> getDiffCallback() {
            return BuyNowOfferListModel.diffCallback;
        }

        public final void setDiffCallback(@NotNull DiffUtil.ItemCallback<BuyNowOfferListModel> itemCallback) {
            Intrinsics.checkParameterIsNotNull(itemCallback, "<set-?>");
            BuyNowOfferListModel.diffCallback = itemCallback;
        }
    }
}
