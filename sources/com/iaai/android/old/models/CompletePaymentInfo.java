package com.iaai.android.old.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.iaai.android.old.utils.ParcelUtils;
import java.math.BigDecimal;

public class CompletePaymentInfo implements Parcelable {
    public static final Parcelable.Creator<CompletePaymentInfo> CREATOR = new Parcelable.Creator<CompletePaymentInfo>() {
        public CompletePaymentInfo createFromParcel(Parcel parcel) {
            return new CompletePaymentInfo(parcel);
        }

        public CompletePaymentInfo[] newArray(int i) {
            return new CompletePaymentInfo[i];
        }
    };
    public BigDecimal afcCredit;
    public BigDecimal iPayDailyAllowance;
    public BigDecimal iPayRemaining;
    public boolean ipayError;
    public boolean isAfc;
    public boolean isIpay;

    public int describeContents() {
        return 0;
    }

    public CompletePaymentInfo() {
    }

    public CompletePaymentInfo(Parcel parcel) {
        this.isIpay = ParcelUtils.readBoolean(parcel);
        this.ipayError = ParcelUtils.readBoolean(parcel);
        this.isAfc = ParcelUtils.readBoolean(parcel);
        this.iPayRemaining = ParcelUtils.readBigDecimal(parcel);
        this.iPayDailyAllowance = ParcelUtils.readBigDecimal(parcel);
        this.afcCredit = ParcelUtils.readBigDecimal(parcel);
    }

    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtils.writeBoolean(parcel, this.isIpay);
        ParcelUtils.writeBoolean(parcel, this.ipayError);
        ParcelUtils.writeBoolean(parcel, this.isAfc);
        ParcelUtils.writeBigDecimal(parcel, this.iPayRemaining);
        ParcelUtils.writeBigDecimal(parcel, this.iPayDailyAllowance);
        ParcelUtils.writeBigDecimal(parcel, this.afcCredit);
    }
}
