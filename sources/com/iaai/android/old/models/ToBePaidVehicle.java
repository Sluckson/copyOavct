package com.iaai.android.old.models;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.old.utils.DateHelper;
import com.iaai.android.old.utils.ParcelUtils;
import com.iaai.android.old.utils.constants.Constants;
import com.iaai.android.old.utils.p016ui.UiUtils;
import java.math.BigDecimal;
import java.util.Locale;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

public class ToBePaidVehicle implements Parcelable {
    public static final Parcelable.Creator<ToBePaidVehicle> CREATOR = new Parcelable.Creator<ToBePaidVehicle>() {
        public ToBePaidVehicle createFromParcel(Parcel parcel) {
            return new ToBePaidVehicle(parcel);
        }

        public ToBePaidVehicle[] newArray(int i) {
            return new ToBePaidVehicle[i];
        }
    };
    @SerializedName("AFCDealerPhone")
    public String AFCDealerPhone;
    @SerializedName("AFCEligibleOnSoldDate")
    public boolean AFCEligibleOnSoldDate;
    @SerializedName("AFCResponseErrorType")
    public String AFCResponseErrorType;
    @SerializedName("AlaskaInd")
    public boolean AlaskaInd;
    @SerializedName("AuctionDate")
    public String AuctionDate;
    @SerializedName("AuctionId")
    public String AuctionId;
    @SerializedName("AuctionItemNumber")
    public String AuctionItemNumber;
    @SerializedName("AuctionLane")
    public String AuctionLane;
    @SerializedName("BidAmount")
    public BigDecimal BidAmount;
    @SerializedName("BidderName")
    public String BidderName;
    @SerializedName("BranchCode")
    public String BranchCode;
    @SerializedName("Branchname")
    public String Branchname;
    @SerializedName("BuyerChargeId")
    public String BuyerChargeId;
    @SerializedName("DiscloserMessage")
    public String DiscloserMessage;
    @SerializedName("EnabledRow")
    public boolean EnabledRow;
    @SerializedName("Fees")
    public BigDecimal Fees;
    @SerializedName("Itemid")
    public String Itemid;
    @SerializedName("Make")
    public String Make;
    @SerializedName("Model")
    public String Model;
    @SerializedName("OffsiteIndicator")
    public Boolean OffSiteIndicator;
    @SerializedName("PartialPaymentInd")
    public boolean PartialPaymentInd;
    @SerializedName("PartiallyPaid")
    public BigDecimal PartiallyPaid;
    @SerializedName("PaymentDueDate")
    public String PaymentDueDate;
    @SerializedName("PaymentSourceInd")
    public String PaymentSourceInd;
    @SerializedName("PickUpduedate")
    public String PickUpduedate;
    @SerializedName("ReferenceNumber")
    public String ReferenceNumber;
    @SerializedName("RowNumber")
    public int RowNumber;
    @SerializedName("SalesTax")
    public BigDecimal SalesTax;
    @SerializedName("SalvageBuyerChargeId")
    public String SalvageBuyerChargeId;
    @SerializedName("SalvageId")
    public String SalvageId;
    @SerializedName("StockNumber")
    public String StockNumber;
    @SerializedName("TotalDue")
    public BigDecimal TotalDue;
    @SerializedName("TowFee")
    public BigDecimal TowFee;
    @SerializedName("VIN")
    public String VIN;
    @SerializedName("Year")
    public String Year;
    @SerializedName("clearTitle")
    public String clearTitle;
    @SerializedName("financedItem")
    public boolean financedItem;
    @SerializedName("imageurl")
    public String imageurl;
    @SerializedName("slot")
    public String slot;

    public int describeContents() {
        return 0;
    }

    public ToBePaidVehicle() {
    }

    public ToBePaidVehicle(Parcel parcel) {
        this.AFCDealerPhone = parcel.readString();
        this.AFCEligibleOnSoldDate = ParcelUtils.readBoolean(parcel);
        this.AFCResponseErrorType = parcel.readString();
        this.AlaskaInd = ParcelUtils.readBoolean(parcel);
        this.AuctionDate = parcel.readString();
        this.AuctionId = parcel.readString();
        this.AuctionItemNumber = parcel.readString();
        this.AuctionLane = parcel.readString();
        this.BidAmount = ParcelUtils.readBigDecimal(parcel);
        this.BidderName = parcel.readString();
        this.BranchCode = parcel.readString();
        this.Branchname = parcel.readString();
        this.BuyerChargeId = parcel.readString();
        this.DiscloserMessage = parcel.readString();
        this.EnabledRow = ParcelUtils.readBoolean(parcel);
        this.Fees = ParcelUtils.readBigDecimal(parcel);
        this.Itemid = parcel.readString();
        this.Make = parcel.readString();
        this.Model = parcel.readString();
        this.OffSiteIndicator = Boolean.valueOf(ParcelUtils.readBoolean(parcel));
        this.PartialPaymentInd = ParcelUtils.readBoolean(parcel);
        this.PartiallyPaid = ParcelUtils.readBigDecimal(parcel);
        this.PaymentDueDate = parcel.readString();
        this.PaymentSourceInd = parcel.readString();
        this.PickUpduedate = parcel.readString();
        this.ReferenceNumber = parcel.readString();
        this.RowNumber = parcel.readInt();
        this.SalesTax = ParcelUtils.readBigDecimal(parcel);
        this.SalvageBuyerChargeId = parcel.readString();
        this.SalvageId = parcel.readString();
        this.StockNumber = parcel.readString();
        this.TotalDue = ParcelUtils.readBigDecimal(parcel);
        this.TowFee = ParcelUtils.readBigDecimal(parcel);
        this.VIN = parcel.readString();
        this.Year = parcel.readString();
        this.clearTitle = parcel.readString();
        this.imageurl = parcel.readString();
        this.slot = parcel.readString();
        this.financedItem = ParcelUtils.readBoolean(parcel);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.AFCDealerPhone);
        ParcelUtils.writeBoolean(parcel, this.AFCEligibleOnSoldDate);
        parcel.writeString(this.AFCResponseErrorType);
        ParcelUtils.writeBoolean(parcel, this.AlaskaInd);
        parcel.writeString(this.AuctionDate);
        parcel.writeString(this.AuctionId);
        parcel.writeString(this.AuctionItemNumber);
        parcel.writeString(this.AuctionLane);
        ParcelUtils.writeBigDecimal(parcel, this.BidAmount);
        parcel.writeString(this.BidderName);
        parcel.writeString(this.BranchCode);
        parcel.writeString(this.Branchname);
        parcel.writeString(this.BuyerChargeId);
        parcel.writeString(this.DiscloserMessage);
        ParcelUtils.writeBoolean(parcel, this.EnabledRow);
        ParcelUtils.writeBigDecimal(parcel, this.Fees);
        parcel.writeString(this.Itemid);
        parcel.writeString(this.Make);
        parcel.writeString(this.Model);
        Boolean bool = this.OffSiteIndicator;
        ParcelUtils.writeBoolean(parcel, bool == null ? false : bool.booleanValue());
        ParcelUtils.writeBoolean(parcel, this.PartialPaymentInd);
        ParcelUtils.writeBigDecimal(parcel, this.PartiallyPaid);
        parcel.writeString(this.PaymentDueDate);
        parcel.writeString(this.PaymentSourceInd);
        parcel.writeString(this.PickUpduedate);
        parcel.writeString(this.ReferenceNumber);
        parcel.writeInt(this.RowNumber);
        ParcelUtils.writeBigDecimal(parcel, this.SalesTax);
        parcel.writeString(this.SalvageBuyerChargeId);
        parcel.writeString(this.SalvageId);
        parcel.writeString(this.StockNumber);
        ParcelUtils.writeBigDecimal(parcel, this.TotalDue);
        ParcelUtils.writeBigDecimal(parcel, this.TowFee);
        parcel.writeString(this.VIN);
        parcel.writeString(this.Year);
        parcel.writeString(this.clearTitle);
        parcel.writeString(this.imageurl);
        parcel.writeString(this.slot);
        ParcelUtils.writeBoolean(parcel, this.financedItem);
    }

    public String getAFCDealerPhone() {
        return this.AFCDealerPhone;
    }

    public boolean isAFCEligibleOnSoldDate() {
        return this.AFCEligibleOnSoldDate;
    }

    public String getAFCResponceErrorType() {
        return this.AFCResponseErrorType;
    }

    public boolean isAlaskaInd() {
        return this.AlaskaInd;
    }

    public String getAuctionDate() {
        return DateHelper.convertFormat(this.AuctionDate, Constants.DATE_PATTERN_DATE_TIME, Constants.DATE_PATTERN_TOBE_PAID);
    }

    public String getAuctionId() {
        return this.AuctionId;
    }

    public String getAuctionItemNumber() {
        return this.AuctionItemNumber;
    }

    public String getAuctionLane() {
        return this.AuctionLane;
    }

    public BigDecimal getBidAmount() {
        return this.BidAmount;
    }

    public String getBidAmountString() {
        return UiUtils.formatCurrency(this.BidAmount, false) + " |";
    }

    public String getBidderName() {
        String str = this.BidderName;
        if (str == null || TextUtils.isEmpty(str.trim())) {
            return "";
        }
        return "(" + this.BidderName.trim() + ")";
    }

    public String getBranchCode() {
        return this.BranchCode;
    }

    public String getBranchname() {
        String str = this.BranchCode;
        if (str == null || TextUtils.isEmpty(str.trim())) {
            return "";
        }
        return this.Branchname + ",";
    }

    public String getBranchnameNoComma(Context context) {
        String str = this.BranchCode;
        if (str == null || TextUtils.isEmpty(str.trim())) {
            return "";
        }
        if (Locale.getDefault().getLanguage().equalsIgnoreCase(Constants_MVVM.EXTRA_SPANISH_CODE)) {
            return context.getString(C2723R.string.contact_us_branch) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.Branchname;
        }
        return this.Branchname + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + context.getString(C2723R.string.contact_us_branch);
    }

    public String getBuyerChargeId() {
        return this.BuyerChargeId;
    }

    public String getDiscloserMessage() {
        return this.DiscloserMessage;
    }

    public boolean isEnabledRow() {
        return this.EnabledRow;
    }

    public BigDecimal getFees() {
        return this.Fees;
    }

    public String getFeesString() {
        return UiUtils.formatCurrency(this.Fees, true);
    }

    public String getItemid() {
        return this.Itemid;
    }

    public String getMake() {
        return this.Make;
    }

    public String getModel() {
        return this.Model;
    }

    public boolean isPartialPaymentInd() {
        return this.PartialPaymentInd;
    }

    public BigDecimal getPartiallyPaid() {
        return this.PartiallyPaid;
    }

    public String getPartiallyPaidString() {
        return "-" + UiUtils.formatCurrency(getPartiallyPaid(), true);
    }

    public String getPaymentDueDate(String str) {
        String convertFormat = DateHelper.convertFormat(this.PaymentDueDate, Constants.DATE_PATTERN_DATE_TIME, Constants.DATE_PATTERN_TOBE_PAID);
        if (TextUtils.isEmpty(convertFormat.trim())) {
            return "";
        }
        return str + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + convertFormat;
    }

    public String getPaymentSourceInd() {
        return this.PaymentSourceInd;
    }

    public String getPickUpduedate() {
        return DateHelper.convertFormat(this.PickUpduedate, Constants.DATE_PATTERN_DATE_TIME, Constants.DATE_PATTERN_TOBE_PAID);
    }

    public String getReferenceNumber(String str) {
        if (TextUtils.isEmpty(this.ReferenceNumber.trim())) {
            return "";
        }
        return str + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.ReferenceNumber;
    }

    public int getRowNumber() {
        return this.RowNumber;
    }

    public BigDecimal getSalesTax() {
        return this.SalesTax;
    }

    public String getSalvageBuyerChargeId() {
        return this.SalvageBuyerChargeId;
    }

    public String getSalvageId() {
        return this.SalvageId;
    }

    public String getStockNumber() {
        String str = this.StockNumber;
        return (str == null || TextUtils.isEmpty(str.trim())) ? Constants.STR_NA : this.StockNumber;
    }

    public BigDecimal getTotalDue() {
        return this.TotalDue;
    }

    public String getTotalDueString() {
        return UiUtils.formatCurrency(this.TotalDue, true);
    }

    public String getBalanceDueString() {
        return UiUtils.formatCurrency(this.TotalDue, true);
    }

    public BigDecimal getTowFee() {
        return this.TowFee;
    }

    public String getVIN() {
        if (this.VIN == null) {
            return "";
        }
        return "| " + this.VIN;
    }

    public String getYear() {
        return this.Year;
    }

    public String getClearTitle() {
        return this.clearTitle;
    }

    public boolean isFinancedItem() {
        return this.financedItem;
    }
}
