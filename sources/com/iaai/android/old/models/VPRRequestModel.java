package com.iaai.android.old.models;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class VPRRequestModel {
    @SerializedName("Notes")
    public String notes;
    @SerializedName("pin")
    public String pin;
    @SerializedName("PulloutList")
    public ArrayList<Integer> pullout_list;
    @SerializedName("StocksModified")
    public boolean stocksModified;
    @SerializedName("Title")
    public String title;
    @SerializedName("VehiclePulloutRequestID")
    public String vehiclePulloutRequestID;
}
