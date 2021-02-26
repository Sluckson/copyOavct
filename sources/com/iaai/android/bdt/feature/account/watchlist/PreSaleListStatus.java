package com.iaai.android.bdt.feature.account.watchlist;

import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/account/watchlist/PreSaleListStatus;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "WATCHING_LIST", "PRE_BID", "AWARD_PENDING", "LOST_PREBID", "PURCHASE_HISTORY", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: PreSaleListStatus.kt */
public enum PreSaleListStatus {
    WATCHING_LIST(1),
    PRE_BID(60),
    AWARD_PENDING(15),
    LOST_PREBID(50),
    PURCHASE_HISTORY(55);
    
    private final int value;

    private PreSaleListStatus(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
