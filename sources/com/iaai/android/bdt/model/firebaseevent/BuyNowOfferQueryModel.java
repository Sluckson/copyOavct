package com.iaai.android.bdt.model.firebaseevent;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\b¨\u0006\u001c"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/firebaseevent/BuyNowOfferQueryModel;", "", "()V", "auctionId", "", "getAuctionId$app_productionRelease", "()Ljava/lang/String;", "setAuctionId$app_productionRelease", "(Ljava/lang/String;)V", "branchId", "getBranchId$app_productionRelease", "setBranchId$app_productionRelease", "isAcceptBNO", "", "isAcceptBNO$app_productionRelease", "()Ljava/lang/Boolean;", "setAcceptBNO$app_productionRelease", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "itemId", "getItemId$app_productionRelease", "setItemId$app_productionRelease", "stockId", "getStockId$app_productionRelease", "setStockId$app_productionRelease", "userId", "getUserId$app_productionRelease", "setUserId$app_productionRelease", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: BuyNowOfferQueryModel.kt */
public final class BuyNowOfferQueryModel {
    @Nullable
    private String auctionId;
    @Nullable
    private String branchId;
    @Nullable
    private Boolean isAcceptBNO;
    @Nullable
    private String itemId;
    @Nullable
    private String stockId;
    @Nullable
    private String userId;

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
    public final String getAuctionId$app_productionRelease() {
        return this.auctionId;
    }

    public final void setAuctionId$app_productionRelease(@Nullable String str) {
        this.auctionId = str;
    }

    @Nullable
    public final String getBranchId$app_productionRelease() {
        return this.branchId;
    }

    public final void setBranchId$app_productionRelease(@Nullable String str) {
        this.branchId = str;
    }

    @Nullable
    public final String getStockId$app_productionRelease() {
        return this.stockId;
    }

    public final void setStockId$app_productionRelease(@Nullable String str) {
        this.stockId = str;
    }

    @Nullable
    public final Boolean isAcceptBNO$app_productionRelease() {
        return this.isAcceptBNO;
    }

    public final void setAcceptBNO$app_productionRelease(@Nullable Boolean bool) {
        this.isAcceptBNO = bool;
    }
}
