package com.iaai.android.bdt.model.auctionSalesList;

import androidx.recyclerview.widget.DiffUtil;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u001b\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b!\n\u0002\u0010 \n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b'\u0018\u0000 \u00012\u00020\u0001:\u0002\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R \u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR \u0010\u0019\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR \u0010\u001c\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR\"\u0010\u001f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b \u0010\u000f\"\u0004\b!\u0010\u0011R \u0010\"\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\bR \u0010%\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0006\"\u0004\b'\u0010\bR\"\u0010(\u001a\u0004\u0018\u00010)8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u0010/\u001a\u0004\u0018\u0001008\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u00105\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u00106\u001a\u0004\u0018\u0001008\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u00105\u001a\u0004\b7\u00102\"\u0004\b8\u00104R\"\u00109\u001a\u0004\u0018\u0001008\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u00105\u001a\u0004\b9\u00102\"\u0004\b:\u00104R\"\u0010;\u001a\u0004\u0018\u0001008\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u00105\u001a\u0004\b;\u00102\"\u0004\b<\u00104R\"\u0010=\u001a\u0004\u0018\u0001008\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u00105\u001a\u0004\b=\u00102\"\u0004\b>\u00104R\"\u0010?\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b@\u0010\u000f\"\u0004\bA\u0010\u0011R \u0010B\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0006\"\u0004\bD\u0010\bR \u0010E\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u0006\"\u0004\bG\u0010\bR \u0010H\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u0006\"\u0004\bJ\u0010\bR \u0010K\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u0006\"\u0004\bM\u0010\bR \u0010N\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u0006\"\u0004\bP\u0010\bR&\u0010Q\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010R8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR \u0010W\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010\u0006\"\u0004\bY\u0010\bR\"\u0010Z\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b[\u0010\u000f\"\u0004\b\\\u0010\u0011R\"\u0010]\u001a\u0004\u0018\u0001008\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u00105\u001a\u0004\b^\u00102\"\u0004\b_\u00104R \u0010`\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010\u0006\"\u0004\bb\u0010\bR\"\u0010c\u001a\u0004\u0018\u0001008\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u00105\u001a\u0004\bd\u00102\"\u0004\be\u00104R \u0010f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010\u0006\"\u0004\bh\u0010\bR\"\u0010i\u001a\u0004\u0018\u00010j8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010o\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR \u0010p\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010\u0006\"\u0004\br\u0010\bR \u0010s\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bt\u0010\u0006\"\u0004\bu\u0010\bR\"\u0010v\u001a\u0004\u0018\u0001008\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u00105\u001a\u0004\bw\u00102\"\u0004\bx\u00104R \u0010y\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010\u0006\"\u0004\b{\u0010\bR!\u0010|\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b}\u0010~\"\u0005\b\u0010\u0001R%\u0010\u0001\u001a\u0004\u0018\u0001008\u0006@\u0006X\u000e¢\u0006\u0012\n\u0002\u00105\u001a\u0005\b\u0001\u00102\"\u0005\b\u0001\u00104R#\u0010\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u0006\"\u0005\b\u0001\u0010\bR#\u0010\u0001\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u0006\"\u0005\b\u0001\u0010\bR)\u0010\u0001\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010R8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010T\"\u0005\b\u0001\u0010VR%\u0010\u0001\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0002\u0010\u0012\u001a\u0005\b\u0001\u0010\u000f\"\u0005\b\u0001\u0010\u0011¨\u0006\u0001"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/auctionSalesList/ResultData;", "", "()V", "OdometerStatus", "", "getOdometerStatus", "()Ljava/lang/String;", "setOdometerStatus", "(Ljava/lang/String;)V", "aisleRow", "getAisleRow", "setAisleRow", "auctionId", "", "getAuctionId", "()Ljava/lang/Long;", "setAuctionId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "branchCode", "getBranchCode", "setBranchCode", "branchName", "getBranchName", "setBranchName", "closeDateTime", "getCloseDateTime", "setCloseDateTime", "currentBid", "getCurrentBid", "setCurrentBid", "currentHighBid", "getCurrentHighBid", "setCurrentHighBid", "damage", "getDamage", "setDamage", "damage2", "getDamage2", "setDamage2", "ibnPrice", "", "getIbnPrice", "()Ljava/lang/Double;", "setIbnPrice", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "ibnSold", "", "getIbnSold", "()Ljava/lang/Boolean;", "setIbnSold", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "internetLiveAuction", "getInternetLiveAuction", "setInternetLiveAuction", "isVehicleAtBranch", "setVehicleAtBranch", "isWatchAvailable", "setWatchAvailable", "isWatching", "setWatching", "itemId", "getItemId", "setItemId", "lane", "getLane", "setLane", "liveDateTime", "getLiveDateTime", "setLiveDateTime", "make", "getMake", "setMake", "model", "getModel", "setModel", "odometer", "getOdometer", "setOdometer", "other", "", "getOther", "()Ljava/util/List;", "setOther", "(Ljava/util/List;)V", "predictedtimeonblock", "getPredictedtimeonblock", "setPredictedtimeonblock", "resultCount", "getResultCount", "setResultCount", "runAndDrive", "getRunAndDrive", "setRunAndDrive", "saleDoc", "getSaleDoc", "setSaleDoc", "sealedAuction", "getSealedAuction", "setSealedAuction", "slot", "getSlot", "setSlot", "stallNumber", "", "getStallNumber", "()Ljava/lang/Integer;", "setStallNumber", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "startCode", "getStartCode", "setStartCode", "stockNumber", "getStockNumber", "setStockNumber", "tBOInd", "getTBOInd", "setTBOInd", "thumbnailUrl", "getThumbnailUrl", "setThumbnailUrl", "timedAuctionCloseTimeCST", "getTimedAuctionCloseTimeCST", "()Ljava/lang/Object;", "setTimedAuctionCloseTimeCST", "(Ljava/lang/Object;)V", "timedAuctionIndicator", "getTimedAuctionIndicator", "setTimedAuctionIndicator", "vehicleTitle", "getVehicleTitle", "setVehicleTitle", "vehicleType", "getVehicleType", "setVehicleType", "whoCanBuy", "getWhoCanBuy", "setWhoCanBuy", "year", "getYear", "setYear", "Companion", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: ResultData.kt */
public final class ResultData {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static DiffUtil.ItemCallback<ResultData> DIFF_CALLBACK = new ResultData$Companion$DIFF_CALLBACK$1();
    @SerializedName("OdometerStatus")
    @Nullable
    private String OdometerStatus;
    @SerializedName("AisleRow")
    @Nullable
    private String aisleRow;
    @SerializedName("AuctionId")
    @Nullable
    private Long auctionId;
    @SerializedName("BranchCode")
    @Nullable
    private Long branchCode;
    @SerializedName("BranchName")
    @Nullable
    private String branchName;
    @SerializedName("CloseDateTime")
    @Nullable
    private String closeDateTime;
    @SerializedName("CurrentBid")
    @Nullable
    private String currentBid;
    @SerializedName("CurrentHighBid")
    @Nullable
    private Long currentHighBid;
    @SerializedName("Damage")
    @Nullable
    private String damage;
    @SerializedName("Damage2")
    @Nullable
    private String damage2;
    @SerializedName("IBNPrice")
    @Nullable
    private Double ibnPrice;
    @SerializedName("IBNSold")
    @Nullable
    private Boolean ibnSold;
    @SerializedName("InternetLiveAuction")
    @Nullable
    private Boolean internetLiveAuction;
    @SerializedName("IsVehicleAtBranch")
    @Nullable
    private Boolean isVehicleAtBranch;
    @SerializedName("IsWatchAvailable")
    @Nullable
    private Boolean isWatchAvailable;
    @SerializedName("IsWatching")
    @Nullable
    private Boolean isWatching;
    @SerializedName("ItemId")
    @Nullable
    private Long itemId;
    @SerializedName("Lane")
    @Nullable
    private String lane;
    @SerializedName("LiveDateTime")
    @Nullable
    private String liveDateTime;
    @SerializedName("Make")
    @Nullable
    private String make;
    @SerializedName("Model")
    @Nullable
    private String model;
    @SerializedName("Odometer")
    @Nullable
    private String odometer;
    @SerializedName("Other")
    @Nullable
    private List<String> other;
    @SerializedName("Predictedtimeonblock")
    @Nullable
    private String predictedtimeonblock;
    @SerializedName("ResultCount")
    @Nullable
    private Long resultCount;
    @SerializedName("RunAndDrive")
    @Nullable
    private Boolean runAndDrive;
    @SerializedName("SaleDoc")
    @Nullable
    private String saleDoc;
    @SerializedName("SealedAuction")
    @Nullable
    private Boolean sealedAuction;
    @SerializedName("Slot")
    @Nullable
    private String slot;
    @SerializedName("stallNumber")
    @Nullable
    private Integer stallNumber;
    @SerializedName("StartCode")
    @Nullable
    private String startCode;
    @SerializedName("StockNumber")
    @Nullable
    private String stockNumber;
    @SerializedName("TBOInd")
    @Nullable
    private Boolean tBOInd;
    @SerializedName("ThumbnailUrl")
    @Nullable
    private String thumbnailUrl;
    @SerializedName("TimedAuctionCloseTimeCST")
    @Nullable
    private Object timedAuctionCloseTimeCST;
    @SerializedName("TimedAuctionIndicator")
    @Nullable
    private Boolean timedAuctionIndicator;
    @SerializedName("VehicleTitle")
    @Nullable
    private String vehicleTitle;
    @SerializedName("VehicleType")
    @Nullable
    private String vehicleType;
    @SerializedName("WhoCanBuy")
    @Nullable
    private List<String> whoCanBuy;
    @SerializedName("Year")
    @Nullable
    private Long year;

    @Nullable
    public final Long getAuctionId() {
        return this.auctionId;
    }

    public final void setAuctionId(@Nullable Long l) {
        this.auctionId = l;
    }

    @Nullable
    public final Long getBranchCode() {
        return this.branchCode;
    }

    public final void setBranchCode(@Nullable Long l) {
        this.branchCode = l;
    }

    @Nullable
    public final String getBranchName() {
        return this.branchName;
    }

    public final void setBranchName(@Nullable String str) {
        this.branchName = str;
    }

    @Nullable
    public final String getCloseDateTime() {
        return this.closeDateTime;
    }

    public final void setCloseDateTime(@Nullable String str) {
        this.closeDateTime = str;
    }

    @Nullable
    public final Long getCurrentHighBid() {
        return this.currentHighBid;
    }

    public final void setCurrentHighBid(@Nullable Long l) {
        this.currentHighBid = l;
    }

    @Nullable
    public final String getDamage() {
        return this.damage;
    }

    public final void setDamage(@Nullable String str) {
        this.damage = str;
    }

    @Nullable
    public final String getDamage2() {
        return this.damage2;
    }

    public final void setDamage2(@Nullable String str) {
        this.damage2 = str;
    }

    @Nullable
    public final Double getIbnPrice() {
        return this.ibnPrice;
    }

    public final void setIbnPrice(@Nullable Double d) {
        this.ibnPrice = d;
    }

    @Nullable
    public final Boolean getIbnSold() {
        return this.ibnSold;
    }

    public final void setIbnSold(@Nullable Boolean bool) {
        this.ibnSold = bool;
    }

    @Nullable
    public final Boolean getInternetLiveAuction() {
        return this.internetLiveAuction;
    }

    public final void setInternetLiveAuction(@Nullable Boolean bool) {
        this.internetLiveAuction = bool;
    }

    @Nullable
    public final Long getItemId() {
        return this.itemId;
    }

    public final void setItemId(@Nullable Long l) {
        this.itemId = l;
    }

    @Nullable
    public final String getLane() {
        return this.lane;
    }

    public final void setLane(@Nullable String str) {
        this.lane = str;
    }

    @Nullable
    public final String getLiveDateTime() {
        return this.liveDateTime;
    }

    public final void setLiveDateTime(@Nullable String str) {
        this.liveDateTime = str;
    }

    @Nullable
    public final String getMake() {
        return this.make;
    }

    public final void setMake(@Nullable String str) {
        this.make = str;
    }

    @Nullable
    public final String getModel() {
        return this.model;
    }

    public final void setModel(@Nullable String str) {
        this.model = str;
    }

    @Nullable
    public final String getOdometer() {
        return this.odometer;
    }

    public final void setOdometer(@Nullable String str) {
        this.odometer = str;
    }

    @Nullable
    public final String getOdometerStatus() {
        return this.OdometerStatus;
    }

    public final void setOdometerStatus(@Nullable String str) {
        this.OdometerStatus = str;
    }

    @Nullable
    public final Long getResultCount() {
        return this.resultCount;
    }

    public final void setResultCount(@Nullable Long l) {
        this.resultCount = l;
    }

    @Nullable
    public final Boolean getRunAndDrive() {
        return this.runAndDrive;
    }

    public final void setRunAndDrive(@Nullable Boolean bool) {
        this.runAndDrive = bool;
    }

    @Nullable
    public final Boolean getSealedAuction() {
        return this.sealedAuction;
    }

    public final void setSealedAuction(@Nullable Boolean bool) {
        this.sealedAuction = bool;
    }

    @Nullable
    public final String getSlot() {
        return this.slot;
    }

    public final void setSlot(@Nullable String str) {
        this.slot = str;
    }

    @Nullable
    public final String getStockNumber() {
        return this.stockNumber;
    }

    public final void setStockNumber(@Nullable String str) {
        this.stockNumber = str;
    }

    @Nullable
    public final String getThumbnailUrl() {
        return this.thumbnailUrl;
    }

    public final void setThumbnailUrl(@Nullable String str) {
        this.thumbnailUrl = str;
    }

    @Nullable
    public final Object getTimedAuctionCloseTimeCST() {
        return this.timedAuctionCloseTimeCST;
    }

    public final void setTimedAuctionCloseTimeCST(@Nullable Object obj) {
        this.timedAuctionCloseTimeCST = obj;
    }

    @Nullable
    public final Boolean getTimedAuctionIndicator() {
        return this.timedAuctionIndicator;
    }

    public final void setTimedAuctionIndicator(@Nullable Boolean bool) {
        this.timedAuctionIndicator = bool;
    }

    @Nullable
    public final String getVehicleType() {
        return this.vehicleType;
    }

    public final void setVehicleType(@Nullable String str) {
        this.vehicleType = str;
    }

    @Nullable
    public final Long getYear() {
        return this.year;
    }

    public final void setYear(@Nullable Long l) {
        this.year = l;
    }

    @Nullable
    public final String getVehicleTitle() {
        return this.vehicleTitle;
    }

    public final void setVehicleTitle(@Nullable String str) {
        this.vehicleTitle = str;
    }

    @Nullable
    public final String getSaleDoc() {
        return this.saleDoc;
    }

    public final void setSaleDoc(@Nullable String str) {
        this.saleDoc = str;
    }

    @Nullable
    public final String getStartCode() {
        return this.startCode;
    }

    public final void setStartCode(@Nullable String str) {
        this.startCode = str;
    }

    @Nullable
    public final String getCurrentBid() {
        return this.currentBid;
    }

    public final void setCurrentBid(@Nullable String str) {
        this.currentBid = str;
    }

    @Nullable
    public final String getPredictedtimeonblock() {
        return this.predictedtimeonblock;
    }

    public final void setPredictedtimeonblock(@Nullable String str) {
        this.predictedtimeonblock = str;
    }

    @Nullable
    public final Boolean isVehicleAtBranch() {
        return this.isVehicleAtBranch;
    }

    public final void setVehicleAtBranch(@Nullable Boolean bool) {
        this.isVehicleAtBranch = bool;
    }

    @Nullable
    public final Boolean isWatchAvailable() {
        return this.isWatchAvailable;
    }

    public final void setWatchAvailable(@Nullable Boolean bool) {
        this.isWatchAvailable = bool;
    }

    @Nullable
    public final Boolean isWatching() {
        return this.isWatching;
    }

    public final void setWatching(@Nullable Boolean bool) {
        this.isWatching = bool;
    }

    @Nullable
    public final List<String> getWhoCanBuy() {
        return this.whoCanBuy;
    }

    public final void setWhoCanBuy(@Nullable List<String> list) {
        this.whoCanBuy = list;
    }

    @Nullable
    public final List<String> getOther() {
        return this.other;
    }

    public final void setOther(@Nullable List<String> list) {
        this.other = list;
    }

    @Nullable
    public final Boolean getTBOInd() {
        return this.tBOInd;
    }

    public final void setTBOInd(@Nullable Boolean bool) {
        this.tBOInd = bool;
    }

    @Nullable
    public final String getAisleRow() {
        return this.aisleRow;
    }

    public final void setAisleRow(@Nullable String str) {
        this.aisleRow = str;
    }

    @Nullable
    public final Integer getStallNumber() {
        return this.stallNumber;
    }

    public final void setStallNumber(@Nullable Integer num) {
        this.stallNumber = num;
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/auctionSalesList/ResultData$Companion;", "", "()V", "DIFF_CALLBACK", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/iaai/android/bdt/model/auctionSalesList/ResultData;", "getDIFF_CALLBACK", "()Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "setDIFF_CALLBACK", "(Landroidx/recyclerview/widget/DiffUtil$ItemCallback;)V", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: ResultData.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final DiffUtil.ItemCallback<ResultData> getDIFF_CALLBACK() {
            return ResultData.DIFF_CALLBACK;
        }

        public final void setDIFF_CALLBACK(@NotNull DiffUtil.ItemCallback<ResultData> itemCallback) {
            Intrinsics.checkParameterIsNotNull(itemCallback, "<set-?>");
            ResultData.DIFF_CALLBACK = itemCallback;
        }
    }
}
