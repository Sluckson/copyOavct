package com.iaai.android.old.models;

import com.google.gson.annotations.SerializedName;

public class PremiumVehicleReport {
    @SerializedName("FilePath")
    public String filePath;
    @SerializedName("HtmlContent")
    public String htmlContent;
    @SerializedName("StatusCode")
    public int statusCode;
}
