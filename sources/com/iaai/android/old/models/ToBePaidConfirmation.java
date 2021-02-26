package com.iaai.android.old.models;

import com.google.gson.annotations.SerializedName;
import java.math.BigDecimal;
import java.util.List;

public class ToBePaidConfirmation {
    @SerializedName("AFCResponseList")
    public ToBePaidAFCResponseConfirmation AFCResponseList;
    @SerializedName("IsPartialPayExist")
    public boolean IsPartialPayExist;
    @SerializedName("ItemPaymentDetailsList")
    public List<ToBePaidItemPaymentList> ItemPaymentDetailsList;
    @SerializedName("PaymentRefenceNumber")
    public long PaymentRefenceNumber;
    @SerializedName("SubmitDateTime")
    public String SubmitDateTime;
    @SerializedName("SuccessInd")
    public boolean SuccessInd;
    @SerializedName("TotalSelectedAmount")
    public BigDecimal TotalSelectedAmount;
}
