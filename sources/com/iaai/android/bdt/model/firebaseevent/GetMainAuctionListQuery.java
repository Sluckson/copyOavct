package com.iaai.android.bdt.model.firebaseevent;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\b¨\u0006\u001e"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/firebaseevent/GetMainAuctionListQuery;", "", "()V", "Date", "", "getDate$app_productionRelease", "()Ljava/lang/String;", "setDate$app_productionRelease", "(Ljava/lang/String;)V", "Latitude", "getLatitude$app_productionRelease", "setLatitude$app_productionRelease", "Longitude", "getLongitude$app_productionRelease", "setLongitude$app_productionRelease", "SortAscending", "", "getSortAscending$app_productionRelease", "()Z", "setSortAscending$app_productionRelease", "(Z)V", "culturecode", "getCulturecode$app_productionRelease", "setCulturecode$app_productionRelease", "devicetype", "getDevicetype$app_productionRelease", "setDevicetype$app_productionRelease", "query", "getQuery$app_productionRelease", "setQuery$app_productionRelease", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: GetMainAuctionListQuery.kt */
public final class GetMainAuctionListQuery {
    @Nullable
    private String Date;
    @Nullable
    private String Latitude;
    @Nullable
    private String Longitude;
    private boolean SortAscending = true;
    @Nullable
    private String culturecode;
    @Nullable
    private String devicetype;
    @Nullable
    private String query;

    @Nullable
    public final String getCulturecode$app_productionRelease() {
        return this.culturecode;
    }

    public final void setCulturecode$app_productionRelease(@Nullable String str) {
        this.culturecode = str;
    }

    @Nullable
    public final String getDevicetype$app_productionRelease() {
        return this.devicetype;
    }

    public final void setDevicetype$app_productionRelease(@Nullable String str) {
        this.devicetype = str;
    }

    public final boolean getSortAscending$app_productionRelease() {
        return this.SortAscending;
    }

    public final void setSortAscending$app_productionRelease(boolean z) {
        this.SortAscending = z;
    }

    @Nullable
    public final String getQuery$app_productionRelease() {
        return this.query;
    }

    public final void setQuery$app_productionRelease(@Nullable String str) {
        this.query = str;
    }

    @Nullable
    public final String getDate$app_productionRelease() {
        return this.Date;
    }

    public final void setDate$app_productionRelease(@Nullable String str) {
        this.Date = str;
    }

    @Nullable
    public final String getLatitude$app_productionRelease() {
        return this.Latitude;
    }

    public final void setLatitude$app_productionRelease(@Nullable String str) {
        this.Latitude = str;
    }

    @Nullable
    public final String getLongitude$app_productionRelease() {
        return this.Longitude;
    }

    public final void setLongitude$app_productionRelease(@Nullable String str) {
        this.Longitude = str;
    }
}
