package com.iaai.android.old.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.iaai.android.old.utils.DateHelper;
import com.iaai.android.old.utils.JsonSerializer;
import com.iaai.android.old.utils.ParcelUtils;
import java.util.Date;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

public class Auction implements Parcelable {
    public static final Parcelable.Creator<Auction> CREATOR = new Parcelable.Creator<Auction>() {
        public Auction createFromParcel(Parcel parcel) {
            return new Auction(parcel);
        }

        public Auction[] newArray(int i) {
            return new Auction[i];
        }
    };
    public static final int STATUS_AUCTION_ENDS = 4;
    public static final int STATUS_AUCTION_IN_PROGRESS = 3;
    public static final int STATUS_AUCTION_UNKNOWN = 5;
    public static final int STATUS_BEFORE_PRE_BID_ENDS = 1;
    public static final int STATUS_BEFORE_PRE_BID_STARTS = 0;
    public static final int STATUS_BETWEEN_PRE_BID_AND_AUCTION_STARTS = 2;
    @JsonProperty("NFInd")
    public boolean NFInd;
    @JsonProperty("branchid")
    public String branchId;
    @JsonDeserialize(using = JsonSerializer.ServerDateDeserializer.class)
    @JsonProperty("closedate")
    public Date closeDate;
    @JsonProperty("internetliveauction")
    public int internetLiveAuction;
    @JsonProperty("auctioncloseind")
    public boolean isAuctionClose;
    @JsonProperty("isdirty")
    public boolean isDirty;
    @JsonProperty("isNFAuction")
    public boolean isNFAuction;
    @JsonProperty("publicauction")
    public boolean isPublicAuction;
    @JsonProperty("sealedauction")
    public boolean isSealedAuction;
    @JsonDeserialize(using = JsonSerializer.ServerDateDeserializer.class)
    @JsonProperty("livedate")
    public Date liveDate;
    @JsonDeserialize(using = JsonSerializer.ServerDateDeserializer.class)
    @JsonProperty("livedatesort")
    public Date liveDateSort;
    @JsonDeserialize(using = JsonSerializer.ServerDateDeserializer.class)
    @JsonProperty("mddate")
    public Date mdDate;
    @JsonProperty("name")
    public String name;
    @JsonProperty("timezone")
    public String timezone;
    @JsonProperty("tzAdjust")
    public int tzAdjust;
    @JsonProperty("vehiclecount")
    public int vehicleCount;

    public int describeContents() {
        return 0;
    }

    public Auction() {
    }

    public Auction(Parcel parcel) {
        this.isAuctionClose = ParcelUtils.readBoolean(parcel);
        this.branchId = parcel.readString();
        this.closeDate = ParcelUtils.readDate(parcel);
        this.internetLiveAuction = parcel.readInt();
        this.isDirty = ParcelUtils.readBoolean(parcel);
        this.liveDate = ParcelUtils.readDate(parcel);
        this.liveDateSort = ParcelUtils.readDate(parcel);
        this.mdDate = ParcelUtils.readDate(parcel);
        this.name = parcel.readString();
        this.isPublicAuction = ParcelUtils.readBoolean(parcel);
        this.isSealedAuction = ParcelUtils.readBoolean(parcel);
        this.isNFAuction = ParcelUtils.readBoolean(parcel);
        this.timezone = parcel.readString();
        this.tzAdjust = parcel.readInt();
        this.vehicleCount = parcel.readInt();
        this.NFInd = ParcelUtils.readBoolean(parcel);
    }

    public int getStatus() {
        Date date = this.closeDate;
        if (date == null || this.liveDate == null) {
            return 5;
        }
        if (this.isAuctionClose) {
            return 4;
        }
        if (!DateHelper.isPast(date)) {
            return 1;
        }
        if (!DateHelper.isPast(this.liveDate)) {
            return 2;
        }
        return this.internetLiveAuction == 1 ? 3 : 4;
    }

    public boolean isIBuyLive() {
        return isIBuyLive(getStatus());
    }

    public boolean isIBuyLive(int i) {
        return !this.isAuctionClose && !this.isSealedAuction && i == 3;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeBoolean(parcel, this.isAuctionClose);
        parcel.writeString(this.branchId);
        ParcelUtils.writeDate(parcel, this.closeDate);
        parcel.writeInt(this.internetLiveAuction);
        ParcelUtils.writeBoolean(parcel, this.isDirty);
        ParcelUtils.writeDate(parcel, this.liveDate);
        ParcelUtils.writeDate(parcel, this.liveDateSort);
        ParcelUtils.writeDate(parcel, this.mdDate);
        parcel.writeString(this.name);
        ParcelUtils.writeBoolean(parcel, this.isPublicAuction);
        ParcelUtils.writeBoolean(parcel, this.isSealedAuction);
        ParcelUtils.writeBoolean(parcel, this.isNFAuction);
        parcel.writeString(this.timezone);
        parcel.writeInt(this.tzAdjust);
        parcel.writeInt(this.vehicleCount);
        ParcelUtils.writeBoolean(parcel, this.NFInd);
    }
}
