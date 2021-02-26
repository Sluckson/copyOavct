package com.iaai.android.old.models;

import com.google.gson.annotations.SerializedName;
import java.math.BigDecimal;

public class ToBePaidConfirmationVehicle {
    @SerializedName("ClearTitle")
    public static int ClearTitle;
    @SerializedName("AmountFloored")
    public int AmountFloored;
    @SerializedName("AmountRequested")
    public BigDecimal AmountRequested;
    @SerializedName("ConfirmationDateTime")
    public String ConfirmationDateTime;
    @SerializedName("ConfirmationID")
    public String ConfirmationID;
    @SerializedName("FlooringError")
    public String FlooringError;
    @SerializedName("RowNumber")
    public int RowNumber;
    @SerializedName("SalvageID")
    public String SalvageID;
    @SerializedName("WebTransactionID")
    public String WebTransactionID;
}
