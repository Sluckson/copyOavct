package com.iaai.android.old.models;

import com.google.gson.annotations.SerializedName;

public class MarketingCloudFlagsResponse {
    @SerializedName("CreateBuyer")
    public boolean createBuyer;
    @SerializedName("CreateGuest")
    public boolean createGuest;
    @SerializedName("UpdateBuyer")
    public boolean updateBuyer;
}
