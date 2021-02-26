package com.iaai.android.old.models;

import com.google.gson.annotations.SerializedName;

public class ForgotPasswordResponse {
    @SerializedName("errorMessage")
    public String errorMessage;
    @SerializedName("Url")
    public String forgot_password_url;
    @SerializedName("Success")
    public boolean isSuccess;
}
