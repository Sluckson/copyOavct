package com.iaai.android.bdt.utils;

import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, mo66933d2 = {"Lcom/iaai/android/bdt/utils/ToolTipActvityStatus;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "DN_ToolTip", "Awawrd_Pending", "Purchase_History", "BuyNow_ToolTip", "ToBePickedUP_ToolTip", "MangeBranchPRefToolTip", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: ToolTipActvityStatus.kt */
public enum ToolTipActvityStatus {
    DN_ToolTip(1),
    Awawrd_Pending(2),
    Purchase_History(3),
    BuyNow_ToolTip(4),
    ToBePickedUP_ToolTip(5),
    MangeBranchPRefToolTip(6);
    
    private final int value;

    private ToolTipActvityStatus(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
