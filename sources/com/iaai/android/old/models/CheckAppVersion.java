package com.iaai.android.old.models;

import com.google.gson.annotations.SerializedName;

public class CheckAppVersion {
    @SerializedName("Error")
    public String error;
    @SerializedName("Version")
    public String play_store_appVersion;
}
