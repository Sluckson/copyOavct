package com.iaai.android.bdt.model.firebaseevent;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u0015"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/firebaseevent/PreBidHistoryQueryModel;", "", "()V", "auctionid", "", "getAuctionid$app_productionRelease", "()Ljava/lang/String;", "setAuctionid$app_productionRelease", "(Ljava/lang/String;)V", "culturecode", "getCulturecode$app_productionRelease", "setCulturecode$app_productionRelease", "devicetype", "getDevicetype$app_productionRelease", "setDevicetype$app_productionRelease", "itemId", "getItemId$app_productionRelease", "setItemId$app_productionRelease", "userId", "getUserId$app_productionRelease", "setUserId$app_productionRelease", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: PreBidHistoryQueryModel.kt */
public final class PreBidHistoryQueryModel {
    @Nullable
    private String auctionid;
    @Nullable
    private String culturecode;
    @Nullable
    private String devicetype;
    @Nullable
    private String itemId;
    @Nullable
    private String userId;

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

    @Nullable
    public final String getItemId$app_productionRelease() {
        return this.itemId;
    }

    public final void setItemId$app_productionRelease(@Nullable String str) {
        this.itemId = str;
    }

    @Nullable
    public final String getUserId$app_productionRelease() {
        return this.userId;
    }

    public final void setUserId$app_productionRelease(@Nullable String str) {
        this.userId = str;
    }

    @Nullable
    public final String getAuctionid$app_productionRelease() {
        return this.auctionid;
    }

    public final void setAuctionid$app_productionRelease(@Nullable String str) {
        this.auctionid = str;
    }
}
