package com.iaai.android.old.models;

import com.google.gson.annotations.SerializedName;

public class Fees {
    @SerializedName("ErrorCode")
    public String ErrorCode;
    @SerializedName("list")
    public FeesInfo[] FeesList;

    public String[] getFeesList() {
        String[] strArr = new String[this.FeesList.length];
        int i = 0;
        while (true) {
            FeesInfo[] feesInfoArr = this.FeesList;
            if (i >= feesInfoArr.length) {
                return strArr;
            }
            strArr[i] = feesInfoArr[i].getFeevalueAndLable();
            i++;
        }
    }
}
