package com.iaai.android.bdt.model.auctionmainlist;

import com.google.gson.annotations.SerializedName;
import com.iaai.android.old.utils.DateHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b8\u0018\u0000 P2\u00020\u0001:\u0001PB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010M\u001a\u00020\u0004J\u0006\u0010N\u001a\u00020\u0012J\u000e\u0010N\u001a\u00020\u00122\u0006\u0010O\u001a\u00020\u0004R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\"\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\u0018\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR \u0010\u001e\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR \u0010!\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010\u001dR\"\u0010$\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010*\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b*\u0010\u0014\"\u0004\b+\u0010\u0016R \u0010,\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001b\"\u0004\b.\u0010\u001dR \u0010/\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001b\"\u0004\b1\u0010\u001dR \u00102\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001b\"\u0004\b4\u0010\u001dR \u00105\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u001b\"\u0004\b7\u0010\u001dR\"\u00108\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b9\u0010\u0014\"\u0004\b:\u0010\u0016R\"\u0010;\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b<\u0010\u0014\"\u0004\b=\u0010\u0016R\"\u0010>\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b?\u0010\u0014\"\u0004\b@\u0010\u0016R \u0010A\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u001b\"\u0004\bC\u0010\u001dR \u0010D\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u001b\"\u0004\bF\u0010\u001dR\"\u0010G\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\bH\u0010&\"\u0004\bI\u0010(R\"\u0010J\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\bK\u0010&\"\u0004\bL\u0010(¨\u0006Q"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/auctionmainlist/AuctionLocations;", "", "()V", "STATUS_AUCTION_IN_PROGRESS", "", "getSTATUS_AUCTION_IN_PROGRESS", "()I", "STATUS_AUCTION_UNKNOWN", "getSTATUS_AUCTION_UNKNOWN", "STATUS_BEFORE_PRE_BID_ENDS", "getSTATUS_BEFORE_PRE_BID_ENDS", "setSTATUS_BEFORE_PRE_BID_ENDS", "(I)V", "STATUS_BEFORE_PRE_BID_STARTS", "getSTATUS_BEFORE_PRE_BID_STARTS", "STATUS_BETWEEN_PRE_BID_AND_AUCTION_STARTS", "getSTATUS_BETWEEN_PRE_BID_AND_AUCTION_STARTS", "auctionCloseInd", "", "getAuctionCloseInd", "()Ljava/lang/Boolean;", "setAuctionCloseInd", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "branchid", "", "getBranchid", "()Ljava/lang/String;", "setBranchid", "(Ljava/lang/String;)V", "city", "getCity", "setCity", "closeDate", "getCloseDate", "setCloseDate", "internetLiveaAction", "getInternetLiveaAction", "()Ljava/lang/Integer;", "setInternetLiveaAction", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "isDirty", "setDirty", "liveDate", "getLiveDate", "setLiveDate", "liveDateSort", "getLiveDateSort", "setLiveDateSort", "mdDate", "getMdDate", "setMdDate", "name", "getName", "setName", "nfInd", "getNfInd", "setNfInd", "publicAuction", "getPublicAuction", "setPublicAuction", "sealedauction", "getSealedauction", "setSealedauction", "state", "getState", "setState", "timezone", "getTimezone", "setTimezone", "tzAdjust", "getTzAdjust", "setTzAdjust", "vehiclecount", "getVehiclecount", "setVehiclecount", "getStatus", "isIBuyLive", "status", "Companion", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: AuctionLocations.kt */
public final class AuctionLocations {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int STATUS_AUCTION_ENDS = 4;
    private final int STATUS_AUCTION_IN_PROGRESS = 3;
    private final int STATUS_AUCTION_UNKNOWN = 5;
    private int STATUS_BEFORE_PRE_BID_ENDS = 1;
    private final int STATUS_BEFORE_PRE_BID_STARTS;
    private final int STATUS_BETWEEN_PRE_BID_AND_AUCTION_STARTS = 2;
    @SerializedName("auctioncloseind")
    @Nullable
    private Boolean auctionCloseInd;
    @SerializedName("branchid")
    @Nullable
    private String branchid;
    @SerializedName("City")
    @Nullable
    private String city;
    @SerializedName("closedate")
    @Nullable
    private String closeDate;
    @SerializedName("internetliveauction")
    @Nullable
    private Integer internetLiveaAction;
    @SerializedName("isdirty")
    @Nullable
    private Boolean isDirty;
    @SerializedName("livedate")
    @Nullable
    private String liveDate;
    @SerializedName("livedatesort")
    @Nullable
    private String liveDateSort;
    @SerializedName("mddate")
    @Nullable
    private String mdDate;
    @SerializedName("name")
    @Nullable
    private String name;
    @SerializedName("NFInd")
    @Nullable
    private Boolean nfInd;
    @SerializedName("publicauction")
    @Nullable
    private Boolean publicAuction;
    @SerializedName("sealedauction")
    @Nullable
    private Boolean sealedauction;
    @SerializedName("State")
    @Nullable
    private String state;
    @SerializedName("timezone")
    @Nullable
    private String timezone;
    @SerializedName("tzAdjust")
    @Nullable
    private Integer tzAdjust;
    @SerializedName("vehiclecount")
    @Nullable
    private Integer vehiclecount;

    public final int getSTATUS_BEFORE_PRE_BID_STARTS() {
        return this.STATUS_BEFORE_PRE_BID_STARTS;
    }

    public final int getSTATUS_BEFORE_PRE_BID_ENDS() {
        return this.STATUS_BEFORE_PRE_BID_ENDS;
    }

    public final void setSTATUS_BEFORE_PRE_BID_ENDS(int i) {
        this.STATUS_BEFORE_PRE_BID_ENDS = i;
    }

    public final int getSTATUS_BETWEEN_PRE_BID_AND_AUCTION_STARTS() {
        return this.STATUS_BETWEEN_PRE_BID_AND_AUCTION_STARTS;
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/auctionmainlist/AuctionLocations$Companion;", "", "()V", "STATUS_AUCTION_ENDS", "", "getSTATUS_AUCTION_ENDS", "()I", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: AuctionLocations.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int getSTATUS_AUCTION_ENDS() {
            return AuctionLocations.STATUS_AUCTION_ENDS;
        }
    }

    public final int getSTATUS_AUCTION_IN_PROGRESS() {
        return this.STATUS_AUCTION_IN_PROGRESS;
    }

    public final int getSTATUS_AUCTION_UNKNOWN() {
        return this.STATUS_AUCTION_UNKNOWN;
    }

    @Nullable
    public final Boolean getNfInd() {
        return this.nfInd;
    }

    public final void setNfInd(@Nullable Boolean bool) {
        this.nfInd = bool;
    }

    @Nullable
    public final Boolean getAuctionCloseInd() {
        return this.auctionCloseInd;
    }

    public final void setAuctionCloseInd(@Nullable Boolean bool) {
        this.auctionCloseInd = bool;
    }

    @Nullable
    public final String getBranchid() {
        return this.branchid;
    }

    public final void setBranchid(@Nullable String str) {
        this.branchid = str;
    }

    @Nullable
    public final String getCloseDate() {
        return this.closeDate;
    }

    public final void setCloseDate(@Nullable String str) {
        this.closeDate = str;
    }

    @Nullable
    public final Integer getInternetLiveaAction() {
        return this.internetLiveaAction;
    }

    public final void setInternetLiveaAction(@Nullable Integer num) {
        this.internetLiveaAction = num;
    }

    @Nullable
    public final Boolean isDirty() {
        return this.isDirty;
    }

    public final void setDirty(@Nullable Boolean bool) {
        this.isDirty = bool;
    }

    @Nullable
    public final String getLiveDate() {
        return this.liveDate;
    }

    public final void setLiveDate(@Nullable String str) {
        this.liveDate = str;
    }

    @Nullable
    public final String getLiveDateSort() {
        return this.liveDateSort;
    }

    public final void setLiveDateSort(@Nullable String str) {
        this.liveDateSort = str;
    }

    @Nullable
    public final String getMdDate() {
        return this.mdDate;
    }

    public final void setMdDate(@Nullable String str) {
        this.mdDate = str;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    public final void setName(@Nullable String str) {
        this.name = str;
    }

    @Nullable
    public final Boolean getPublicAuction() {
        return this.publicAuction;
    }

    public final void setPublicAuction(@Nullable Boolean bool) {
        this.publicAuction = bool;
    }

    @Nullable
    public final Boolean getSealedauction() {
        return this.sealedauction;
    }

    public final void setSealedauction(@Nullable Boolean bool) {
        this.sealedauction = bool;
    }

    @Nullable
    public final String getTimezone() {
        return this.timezone;
    }

    public final void setTimezone(@Nullable String str) {
        this.timezone = str;
    }

    @Nullable
    public final Integer getTzAdjust() {
        return this.tzAdjust;
    }

    public final void setTzAdjust(@Nullable Integer num) {
        this.tzAdjust = num;
    }

    @Nullable
    public final Integer getVehiclecount() {
        return this.vehiclecount;
    }

    public final void setVehiclecount(@Nullable Integer num) {
        this.vehiclecount = num;
    }

    @Nullable
    public final String getCity() {
        return this.city;
    }

    public final void setCity(@Nullable String str) {
        this.city = str;
    }

    @Nullable
    public final String getState() {
        return this.state;
    }

    public final void setState(@Nullable String str) {
        this.state = str;
    }

    public final int getStatus() {
        if (this.closeDate == null || this.liveDate == null) {
            return this.STATUS_AUCTION_UNKNOWN;
        }
        Boolean bool = this.auctionCloseInd;
        if (bool == null) {
            Intrinsics.throwNpe();
        }
        if (!bool.booleanValue()) {
            if (!DateHelper.isPast(DateHelper.parseDateInServerTimezone(this.closeDate))) {
                return this.STATUS_BEFORE_PRE_BID_ENDS;
            }
            if (!DateHelper.isPast(DateHelper.parseDateInServerTimezone(this.liveDate))) {
                return this.STATUS_BETWEEN_PRE_BID_AND_AUCTION_STARTS;
            }
            Integer num = this.internetLiveaAction;
            if (num != null && num.intValue() == 1) {
                return this.STATUS_AUCTION_IN_PROGRESS;
            }
        }
        return STATUS_AUCTION_ENDS;
    }

    public final boolean isIBuyLive() {
        return isIBuyLive(getStatus());
    }

    public final boolean isIBuyLive(int i) {
        Boolean bool = this.auctionCloseInd;
        if (bool == null) {
            Intrinsics.throwNpe();
        }
        if (!bool.booleanValue()) {
            Boolean bool2 = this.sealedauction;
            if (bool2 == null) {
                Intrinsics.throwNpe();
            }
            return !bool2.booleanValue() && i == this.STATUS_AUCTION_IN_PROGRESS;
        }
    }
}
