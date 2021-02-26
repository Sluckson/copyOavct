package com.iaai.android.old.models;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class NewRefinersArrayList {
    @SerializedName("Refiners")
    public ArrayList<NewRefinerValue> newRefinerValueArrayList;
    @SerializedName("DisplayName")
    public String parent_displayName;
    @SerializedName("RefinerTypeValue")
    public String parent_refinerTypeValue;
}
