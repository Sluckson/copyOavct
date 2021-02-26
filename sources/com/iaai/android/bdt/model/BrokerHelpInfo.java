package com.iaai.android.bdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001a\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR \u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR \u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR \u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR \u0010\u001b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\b¨\u0006\u001e"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/BrokerHelpInfo;", "", "()V", "brokerId", "", "getBrokerId", "()Ljava/lang/String;", "setBrokerId", "(Ljava/lang/String;)V", "countryCode", "getCountryCode", "setCountryCode", "countryName", "getCountryName", "setCountryName", "englishContent", "getEnglishContent", "setEnglishContent", "englishHeading", "getEnglishHeading", "setEnglishHeading", "helpUrl", "getHelpUrl", "setHelpUrl", "nativeContent", "getNativeContent", "setNativeContent", "nativeHeading", "getNativeHeading", "setNativeHeading", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: BrokerHelpInfo.kt */
public final class BrokerHelpInfo {
    @SerializedName("broker_id")
    @Nullable
    @Expose
    private String brokerId;
    @SerializedName("country_code")
    @Nullable
    @Expose
    private String countryCode;
    @SerializedName("country_name")
    @Nullable
    @Expose
    private String countryName;
    @SerializedName("english_content")
    @Nullable
    @Expose
    private String englishContent;
    @SerializedName("english_heading")
    @Nullable
    @Expose
    private String englishHeading;
    @SerializedName("help_url")
    @Nullable
    @Expose
    private String helpUrl;
    @SerializedName("native_content")
    @Nullable
    @Expose
    private String nativeContent;
    @SerializedName("native_heading")
    @Nullable
    @Expose
    private String nativeHeading;

    @Nullable
    public final String getCountryCode() {
        return this.countryCode;
    }

    public final void setCountryCode(@Nullable String str) {
        this.countryCode = str;
    }

    @Nullable
    public final String getCountryName() {
        return this.countryName;
    }

    public final void setCountryName(@Nullable String str) {
        this.countryName = str;
    }

    @Nullable
    public final String getNativeContent() {
        return this.nativeContent;
    }

    public final void setNativeContent(@Nullable String str) {
        this.nativeContent = str;
    }

    @Nullable
    public final String getEnglishContent() {
        return this.englishContent;
    }

    public final void setEnglishContent(@Nullable String str) {
        this.englishContent = str;
    }

    @Nullable
    public final String getHelpUrl() {
        return this.helpUrl;
    }

    public final void setHelpUrl(@Nullable String str) {
        this.helpUrl = str;
    }

    @Nullable
    public final String getBrokerId() {
        return this.brokerId;
    }

    public final void setBrokerId(@Nullable String str) {
        this.brokerId = str;
    }

    @Nullable
    public final String getNativeHeading() {
        return this.nativeHeading;
    }

    public final void setNativeHeading(@Nullable String str) {
        this.nativeHeading = str;
    }

    @Nullable
    public final String getEnglishHeading() {
        return this.englishHeading;
    }

    public final void setEnglishHeading(@Nullable String str) {
        this.englishHeading = str;
    }
}
