package com.iaai.android.old.models;

import com.google.gson.annotations.SerializedName;

public class BuyerReceiptImage {
    @SerializedName("_buffer")
    public byte[] buffer;
    @SerializedName("_capacity")
    public int capacity;
    @SerializedName("_expandable")
    public boolean expandable;
    @SerializedName("_exposable")
    public boolean exposable;
    @SerializedName("_isOpen")
    public boolean isOpen;
    @SerializedName("_length")
    public int length;
}
