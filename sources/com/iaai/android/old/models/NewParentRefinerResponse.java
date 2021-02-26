package com.iaai.android.old.models;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class NewParentRefinerResponse {
    @SerializedName("Breadcrumbs")
    public String Breadcrumbs;
    @SerializedName("error")
    public String error;
    @SerializedName("Refiners")
    public ArrayList<NewRefinersArrayList> newRefinersArrayList;
    @SerializedName("SearchInput")
    public NewSearchInput newSearchInput;
    @SerializedName("Vehicles")
    public ArrayList<NewSearchVehicleList> newSearchVehicleList;
    @SerializedName("SortAscending")
    public boolean sortAscending;
    @SerializedName("SortField")
    public String sortField;
    @SerializedName("TotalVehicleCount")
    public int totalVehicleCount;
}
