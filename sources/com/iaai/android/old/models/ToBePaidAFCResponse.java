package com.iaai.android.old.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.iaai.android.old.utils.ParcelUtils;
import java.math.BigDecimal;
import java.util.List;

public class ToBePaidAFCResponse implements Parcelable {
    public static final Parcelable.Creator<ToBePaidAFCResponse> CREATOR = new Parcelable.Creator<ToBePaidAFCResponse>() {
        public ToBePaidAFCResponse createFromParcel(Parcel parcel) {
            return new ToBePaidAFCResponse(parcel);
        }

        public ToBePaidAFCResponse[] newArray(int i) {
            return new ToBePaidAFCResponse[i];
        }
    };
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
    public List<ToBePaidVehicle> VehicleList;

    public int describeContents() {
        return 0;
    }

    public ToBePaidAFCResponse() {
    }

    public ToBePaidAFCResponse(Parcel parcel) {
        this.DealerID = parcel.readString();
        this.DealerName = parcel.readString();
        this.DealerPhone = parcel.readString();
        this.ErrorMessage = parcel.readString();
        this.FinanceCompany = parcel.readString();
        this.RequestId = parcel.readString();
        this.Source = parcel.readString();
        this.Status = parcel.readString();
        this.TransactionDateTime = parcel.readString();
        this.TransactionType = parcel.readString();
        this.AvailableCredit = ParcelUtils.readBigDecimal(parcel);
        this.TotalAmountFloored = ParcelUtils.readBigDecimal(parcel);
        this.TotalAmountToBeFloored = ParcelUtils.readBigDecimal(parcel);
        this.BuyerID = parcel.readLong();
        this.NumberOfVehiclesFloored = parcel.readInt();
        this.NumberOfVehiclesRequested = parcel.readInt();
        this.ErrorFlag = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.DealerID);
        parcel.writeString(this.DealerName);
        parcel.writeString(this.DealerPhone);
        parcel.writeString(this.ErrorMessage);
        parcel.writeString(this.FinanceCompany);
        parcel.writeString(this.RequestId);
        parcel.writeString(this.Source);
        parcel.writeString(this.Status);
        parcel.writeString(this.TransactionDateTime);
        parcel.writeString(this.TransactionType);
        ParcelUtils.writeBigDecimal(parcel, this.AvailableCredit);
        ParcelUtils.writeBigDecimal(parcel, this.TotalAmountFloored);
        ParcelUtils.writeBigDecimal(parcel, this.TotalAmountToBeFloored);
        parcel.writeLong(this.BuyerID);
        parcel.writeInt(this.NumberOfVehiclesFloored);
        parcel.writeInt(this.NumberOfVehiclesRequested);
        parcel.writeInt(this.ErrorFlag);
    }

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

    public List<ToBePaidVehicle> getVehicleList() {
        return this.VehicleList;
    }
}
