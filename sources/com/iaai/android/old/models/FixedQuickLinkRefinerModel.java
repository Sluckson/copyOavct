package com.iaai.android.old.models;

public class FixedQuickLinkRefinerModel {
    public String displayRefinerValue;
    public boolean isSelected;
    public String refinerTypeValue;
    public String refinerValue;

    public FixedQuickLinkRefinerModel(String str, String str2, boolean z, String str3) {
        this.refinerTypeValue = str;
        this.refinerValue = str2;
        this.displayRefinerValue = str3;
        this.isSelected = z;
    }
}
