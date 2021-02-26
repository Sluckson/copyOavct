package com.iaai.android.old.models;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class AuctionStatus {
    @SerializedName("auctionStatus")
    public ArrayList<AuctionLanes> auctionStatus;
}
