package com.iaai.android.old.models;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class ToBePickedUpList {
    @SerializedName("ShowMyVehicles")
    public boolean ShowMyVehicles;
    @SerializedName("totalcount")
    public int TotalCount;
    @SerializedName("BranchEnabledForPullout")
    public boolean branchEnabledForPullout;
    @SerializedName("list")
    public ArrayList<ToBePickedUpVehicles> vehicleArrayList;
}
