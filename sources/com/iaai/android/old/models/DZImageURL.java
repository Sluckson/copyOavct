package com.iaai.android.old.models;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class DZImageURL {
    @SerializedName("DeepZoomInd")
    public boolean DeepZoomInd;
    @SerializedName("keys")
    public ArrayList<DZImageURLKeyData> dzImageURLKeyDataArrayList;
}
