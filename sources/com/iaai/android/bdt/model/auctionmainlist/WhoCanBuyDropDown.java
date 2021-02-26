package com.iaai.android.bdt.model.auctionmainlist;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/auctionmainlist/WhoCanBuyDropDown;", "", "()V", "licenseTypeCode", "", "getLicenseTypeCode", "()Ljava/lang/String;", "setLicenseTypeCode", "(Ljava/lang/String;)V", "licenseTypeDesc", "getLicenseTypeDesc", "setLicenseTypeDesc", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: WhoCanBuyDropDown.kt */
public final class WhoCanBuyDropDown {
    @SerializedName("LicenseTypeCode")
    @Nullable
    private String licenseTypeCode;
    @SerializedName("LicenseTypeDesc")
    @Nullable
    private String licenseTypeDesc;

    @Nullable
    public final String getLicenseTypeCode() {
        return this.licenseTypeCode;
    }

    public final void setLicenseTypeCode(@Nullable String str) {
        this.licenseTypeCode = str;
    }

    @Nullable
    public final String getLicenseTypeDesc() {
        return this.licenseTypeDesc;
    }

    public final void setLicenseTypeDesc(@Nullable String str) {
        this.licenseTypeDesc = str;
    }
}
