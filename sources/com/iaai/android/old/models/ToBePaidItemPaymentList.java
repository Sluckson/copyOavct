package com.iaai.android.old.models;

import com.google.gson.annotations.SerializedName;

public class ToBePaidItemPaymentList {
    @SerializedName("IpayReferenceNo")
    public long IpayReferenceNo;
    @SerializedName("IsPartialPay")
    public boolean IsPartialPay;
    @SerializedName("RowNumber")
    public int RowNumber;
    @SerializedName("SuccessInd")
    public boolean SuccessInd;
    @SerializedName("buyerChargeIDs")
    public String buyerChargeIDs;
    @SerializedName("salvageBuyerChargeIDs")
    public String salvageBuyerChargeIDs;
    @SerializedName("salvageSaleIDs")
    public String salvageSaleIDs;
}
