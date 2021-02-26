package com.iaai.android.old.models;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class ToBePickedUpBranchList {
    @SerializedName("BranchNumber")
    public String branchNumber;
    @SerializedName("Branchname")
    public String branch_name;
    @SerializedName("BuyerName")
    public String buyerName;
    @SerializedName("Notes")
    public String notes;
    @SerializedName("Pin")
    public int pin;
    @SerializedName("PullOutRequestID")
    public int pullOutRequestID;
    @SerializedName("TitileHandlingInstructions")
    public String titileHandlingInstructions;
    @SerializedName("Title")
    public String title;
    @SerializedName("list")
    public ArrayList<ToBePickedUpVehicles> vehicleArrayList;
}
