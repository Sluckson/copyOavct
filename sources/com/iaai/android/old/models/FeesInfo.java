package com.iaai.android.old.models;

import com.google.gson.annotations.SerializedName;
import com.iaai.android.old.utils.p016ui.UiUtils;
import java.math.BigDecimal;

public class FeesInfo {
    @SerializedName("Feelabel")
    public String FeeLabel;
    @SerializedName("Feevalue")
    public BigDecimal Feevalue;
    public boolean isPartiallyPaid;

    public String getFeevalueAndLable() {
        return this.FeeLabel + ": " + UiUtils.formatCurrency(this.Feevalue, true);
    }
}
