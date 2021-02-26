package com.iaai.android.old.models;

import com.google.gson.annotations.SerializedName;
import java.math.BigDecimal;
import java.util.List;

public class ToBePaidAFCResponseConfirmation {
    @SerializedName("AvailableCredit")
    public BigDecimal AvailableCredit;
    @SerializedName("BuyerID")
    public long BuyerID;
    @SerializedName("DealerID")
    public String DealerID;
    @SerializedName("DealerName")
    public String DealerName;
    @SerializedName("DealerPhone")
    public String DealerPhone;
    @SerializedName("ErrorFlag")
    public int ErrorFlag;
    @SerializedName("ErrorMessage")
    public String ErrorMessage;
    @SerializedName("FinanceCompany")
    public String FinanceCompany;
    @SerializedName("NumberOfVehiclesFloored")
    public int NumberOfVehiclesFloored;
    @SerializedName("NumberOfVehiclesRequested")
    public int NumberOfVehiclesRequested;
    @SerializedName("RequestId")
    public String RequestId;
    @SerializedName("Source")
    public String Source;
    @SerializedName("Status")
    public String Status;
    @SerializedName("TotalAmountFloored")
    public BigDecimal TotalAmountFloored;
    @SerializedName("TotalAmountToBeFloored")
    public BigDecimal TotalAmountToBeFloored;
    @SerializedName("TransactionDateTime")
    public String TransactionDateTime;
    @SerializedName("TransactionType")
    public String TransactionType;
    @SerializedName("VehicleList")
    public List<ToBePaidConfirmationVehicle> VehicleList;

    public BigDecimal getAvailableCredit() {
        return this.AvailableCredit;
    }

    public long getBuyerID() {
        return this.BuyerID;
    }

    public String getDealerID() {
        return this.DealerID;
    }

    public String getDealerName() {
        return this.DealerName;
    }

    public String getDealerPhone() {
        return this.DealerPhone;
    }

    public int getErrorFlag() {
        return this.ErrorFlag;
    }

    public String getErrorMessage() {
        return this.ErrorMessage;
    }

    public String getFinanceCompany() {
        return this.FinanceCompany;
    }

    public int getNumberOfVehiclesFloored() {
        return this.NumberOfVehiclesFloored;
    }

    public int getNumberOfVehiclesRequested() {
        return this.NumberOfVehiclesRequested;
    }

    public String getRequestId() {
        return this.RequestId;
    }

    public String getSource() {
        return this.Source;
    }

    public String getStatus() {
        return this.Status;
    }

    public BigDecimal getTotalAmountFloored() {
        return this.TotalAmountFloored;
    }

    public BigDecimal getTotalAmountToBeFloored() {
        return this.TotalAmountToBeFloored;
    }

    public String getTransactionDateTime() {
        return this.TransactionDateTime;
    }

    public String getTransactionType() {
        return this.TransactionType;
    }
}
