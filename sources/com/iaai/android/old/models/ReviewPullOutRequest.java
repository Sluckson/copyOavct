package com.iaai.android.old.models;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class ReviewPullOutRequest {
    @SerializedName("PulloutList")
    public ArrayList<Integer> pullout_list;
}
