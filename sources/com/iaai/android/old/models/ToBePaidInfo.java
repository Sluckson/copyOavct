package com.iaai.android.old.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.iaai.android.old.utils.ParcelUtils;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ToBePaidInfo implements Parcelable {
    public static final Parcelable.Creator<ToBePaidInfo> CREATOR = new Parcelable.Creator<ToBePaidInfo>() {
        public ToBePaidInfo createFromParcel(Parcel parcel) {
            return new ToBePaidInfo(parcel);
        }

        public ToBePaidInfo[] newArray(int i) {
            return new ToBePaidInfo[i];
        }
    };
    @SerializedName("AFCResponseList")
    public ToBePaidAFCResponse AFCResponseList;
    @SerializedName("Count")
    public String Count;
    @SerializedName("DailyAllowance")
    public BigDecimal DailyAllowance;
    @SerializedName("DailyBalance")
    public BigDecimal DailyBalance;
    @SerializedName("ErrorCode")
    public String ErrorCode;
    @SerializedName("GuidIdentifier")
    public String GuidIdentifier;
    @SerializedName("RequestId")
    public String RequestId;
    @SerializedName("SortColumn")
    public String SortColumn;
    @SerializedName("SortDirection")
    public String SortDirection;
    @SerializedName("SubmitDateTime")
    public String SubmitDateTime;
    @SerializedName("TotalSelectedAmount")
    public BigDecimal TotalSelectedAmount;
    @SerializedName("isAFC")
    public boolean isAFC;
    @SerializedName("isIPay")
    public boolean isIPay;
    @SerializedName("tobePaidList")
    public ArrayList<ToBePaidVehicle> tobePaidList;
    @SerializedName("list")
    public ArrayList<ToBePaidVehicle> tobePaidList1;

    public int describeContents() {
        return 0;
    }

    public ToBePaidInfo() {
    }

    public ToBePaidInfo(Parcel parcel) {
        this.Count = parcel.readString();
        this.ErrorCode = parcel.readString();
        this.GuidIdentifier = parcel.readString();
        this.RequestId = parcel.readString();
        this.SortColumn = parcel.readString();
        this.SortDirection = parcel.readString();
        this.SubmitDateTime = parcel.readString();
        this.DailyAllowance = ParcelUtils.readBigDecimal(parcel);
        this.DailyBalance = ParcelUtils.readBigDecimal(parcel);
        this.TotalSelectedAmount = ParcelUtils.readBigDecimal(parcel);
        this.isAFC = ParcelUtils.readBoolean(parcel);
        this.isIPay = ParcelUtils.readBoolean(parcel);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.Count);
        parcel.writeString(this.ErrorCode);
        parcel.writeString(this.GuidIdentifier);
        parcel.writeString(this.RequestId);
        parcel.writeString(this.SortColumn);
        parcel.writeString(this.SortDirection);
        parcel.writeString(this.SubmitDateTime);
        ParcelUtils.writeBigDecimal(parcel, this.DailyAllowance);
        ParcelUtils.writeBigDecimal(parcel, this.DailyBalance);
        ParcelUtils.writeBigDecimal(parcel, this.TotalSelectedAmount);
        ParcelUtils.writeBoolean(parcel, this.isAFC);
        ParcelUtils.writeBoolean(parcel, this.isIPay);
    }

    public void migrateWithCurrentData() {
        this.tobePaidList = this.tobePaidList1;
    }

    public ToBePaidAFCResponse getAFCResponseList() {
        return this.AFCResponseList;
    }

    public String getCount() {
        return this.Count;
    }

    public BigDecimal getDailyAllowance() {
        return this.DailyAllowance;
    }

    public BigDecimal getDailyBalance() {
        return this.DailyBalance;
    }

    public String getErrorCode() {
        return this.ErrorCode;
    }

    public String getGuidIdentifier() {
        return this.GuidIdentifier;
    }

    public String getRequestId() {
        return this.RequestId;
    }

    public String getSortColumn() {
        return this.SortColumn;
    }

    public String getSortDirection() {
        return this.SortDirection;
    }

    public String getSubmitDateTime() {
        return this.SubmitDateTime;
    }

    public BigDecimal getTotalSelectedAmount() {
        return this.TotalSelectedAmount;
    }

    public boolean isAFC() {
        return this.isAFC;
    }

    public boolean isIPay() {
        return this.isIPay;
    }

    public List<ToBePaidVehicle> getTobePaidList() {
        return this.tobePaidList;
    }
}
