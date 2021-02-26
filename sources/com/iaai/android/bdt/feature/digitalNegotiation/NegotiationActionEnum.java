package com.iaai.android.bdt.feature.digitalNegotiation;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/digitalNegotiation/NegotiationActionEnum;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "RAISE_MY_BID", "RAISE_MY_BID_DISABLED_MSG", "BUY_IT", "KEEP_MY_BID", "BID_HISTORY", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: NegotiationActionEnum.kt */
public enum NegotiationActionEnum {
    RAISE_MY_BID("RAISE_MY_BID"),
    RAISE_MY_BID_DISABLED_MSG("RAISE_MY_BID_DISABLED_MSG"),
    BUY_IT("BUY_IT"),
    KEEP_MY_BID("KEEP_MY_BID"),
    BID_HISTORY("BidHistory");
    
    @NotNull
    private final String value;

    private NegotiationActionEnum(String str) {
        this.value = str;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }
}
