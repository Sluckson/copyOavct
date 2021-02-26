package com.iaai.android.old.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.iaai.android.old.utils.ParcelUtils;
import java.math.BigDecimal;

public class Dashboard implements Parcelable {
    public static final Parcelable.Creator<Dashboard> CREATOR = new Parcelable.Creator<Dashboard>() {
        public Dashboard createFromParcel(Parcel parcel) {
            return new Dashboard(parcel);
        }

        public Dashboard[] newArray(int i) {
            return new Dashboard[i];
        }
    };
    @SerializedName("LicenseLink")
    public String LicenseLink;
    @SerializedName("LincenseLinkInd")
    public Boolean LincenseLinkInd;
    @SerializedName("NegotiationOffers")
    public int NegotiationOffers;
    @SerializedName("ProfileLink")
    public String ProfileLink;
    @SerializedName("ProfileLinkInd")
    public Boolean ProfileLinkInd;
    @SerializedName("RenewalLink")
    public String RenewalLink;
    @SerializedName("RenewalLinkInd")
    public Boolean RenewalLinkInd;
    @SerializedName("TotalAwardPending")
    public BigDecimal TotalAwardPending;
    @SerializedName("UpgradeLink")
    public String UpgradeLink;
    @SerializedName("UpgradeLinkInd")
    public Boolean UpgradeLinkInd;
    @SerializedName("Alerts")
    public int alertsCount;
    @SerializedName("AwardPending")
    public int awardPendingCount;
    @SerializedName("CountofFeeItems")
    public int feeItemCount;
    @SerializedName("FeeOnly")
    public BigDecimal feeOnlyAmount;
    @SerializedName("InfographicMonth")
    public String infographicMonth;
    @SerializedName("InfographicPeriod")
    public String infographicPeriod;
    @SerializedName("BiddingBenchMark")
    public Boolean isBiddingBenchMarkEnabled;
    @SerializedName("Lost")
    public int lostCount;
    @SerializedName("Outbid")
    public int outbidCount;
    @SerializedName("Pickup")
    public int pickupCount;
    @SerializedName("TotalCurrentBids")
    public BigDecimal totalCurrentBidsAmount;
    @SerializedName("TotalMaxBids")
    public BigDecimal totalMaxBidsAmount;
    @SerializedName("TotaltobePaid")
    public BigDecimal totalToBePaidAmount;
    @SerializedName("Countofvehicles")
    public int vehicleCount;
    @SerializedName("VehiclesOnly")
    public BigDecimal vehiclesOnlyAmount;
    @SerializedName("Watching")
    public int watchingCount;
    @SerializedName("WinningPrebids")
    public int winningPrebidsCount;
    @SerializedName("Won")
    public int wonCount;

    public int describeContents() {
        return 0;
    }

    public Dashboard() {
    }

    public Dashboard(Parcel parcel) {
        this.outbidCount = parcel.readInt();
        this.pickupCount = parcel.readInt();
        this.totalCurrentBidsAmount = ParcelUtils.readBigDecimal(parcel);
        this.totalMaxBidsAmount = ParcelUtils.readBigDecimal(parcel);
        this.totalToBePaidAmount = ParcelUtils.readBigDecimal(parcel);
        this.TotalAwardPending = ParcelUtils.readBigDecimal(parcel);
        this.vehiclesOnlyAmount = ParcelUtils.readBigDecimal(parcel);
        this.winningPrebidsCount = parcel.readInt();
        this.alertsCount = parcel.readInt();
        this.awardPendingCount = parcel.readInt();
        this.feeOnlyAmount = ParcelUtils.readBigDecimal(parcel);
        this.lostCount = parcel.readInt();
        this.watchingCount = parcel.readInt();
        this.wonCount = parcel.readInt();
        this.feeItemCount = parcel.readInt();
        this.vehicleCount = parcel.readInt();
        this.isBiddingBenchMarkEnabled = Boolean.valueOf(ParcelUtils.readBoolean(parcel));
        this.infographicPeriod = parcel.readString();
        this.infographicMonth = parcel.readString();
        this.RenewalLinkInd = Boolean.valueOf(ParcelUtils.readBoolean(parcel));
        this.LincenseLinkInd = Boolean.valueOf(ParcelUtils.readBoolean(parcel));
        this.ProfileLinkInd = Boolean.valueOf(ParcelUtils.readBoolean(parcel));
        this.UpgradeLinkInd = Boolean.valueOf(ParcelUtils.readBoolean(parcel));
        this.RenewalLink = parcel.readString();
        this.LicenseLink = parcel.readString();
        this.ProfileLink = parcel.readString();
        this.UpgradeLink = parcel.readString();
        this.NegotiationOffers = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.outbidCount);
        parcel.writeInt(this.pickupCount);
        ParcelUtils.writeBigDecimal(parcel, this.totalCurrentBidsAmount);
        ParcelUtils.writeBigDecimal(parcel, this.totalMaxBidsAmount);
        ParcelUtils.writeBigDecimal(parcel, this.totalToBePaidAmount);
        ParcelUtils.writeBigDecimal(parcel, this.TotalAwardPending);
        ParcelUtils.writeBigDecimal(parcel, this.vehiclesOnlyAmount);
        parcel.writeInt(this.winningPrebidsCount);
        parcel.writeInt(this.alertsCount);
        parcel.writeInt(this.awardPendingCount);
        ParcelUtils.writeBigDecimal(parcel, this.feeOnlyAmount);
        parcel.writeInt(this.lostCount);
        parcel.writeInt(this.watchingCount);
        parcel.writeInt(this.wonCount);
        parcel.writeInt(this.feeItemCount);
        parcel.writeInt(this.vehicleCount);
        ParcelUtils.writeBoolean(parcel, this.isBiddingBenchMarkEnabled.booleanValue());
        parcel.writeString(this.infographicPeriod);
        parcel.writeString(this.infographicMonth);
        ParcelUtils.writeBoolean(parcel, this.RenewalLinkInd.booleanValue());
        ParcelUtils.writeBoolean(parcel, this.LincenseLinkInd.booleanValue());
        ParcelUtils.writeBoolean(parcel, this.ProfileLinkInd.booleanValue());
        ParcelUtils.writeBoolean(parcel, this.UpgradeLinkInd.booleanValue());
        parcel.writeString(this.RenewalLink);
        parcel.writeString(this.LicenseLink);
        parcel.writeString(this.ProfileLink);
        parcel.writeString(this.UpgradeLink);
        parcel.writeInt(this.NegotiationOffers);
    }
}
