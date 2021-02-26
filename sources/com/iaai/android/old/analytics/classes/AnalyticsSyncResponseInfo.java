package com.iaai.android.old.analytics.classes;

import com.google.gson.annotations.SerializedName;

public class AnalyticsSyncResponseInfo {
    @SerializedName("IsSuccessful")
    public boolean IsSuccessful;
    @SerializedName("ValidationMessage")
    public String validationMessage;
}
