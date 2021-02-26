package com.iaai.android.old.models;

import com.google.gson.annotations.SerializedName;

public class AuctionFeedBackResponse {
    @SerializedName("IsSuccessful")
    public boolean IsSuccessful;
    @SerializedName("ValidationMessage")
    public String validationMessage;
}
