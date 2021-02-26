package com.iaai.android.bdt.model.productDetail.biddingInfo;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0015"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/productDetail/biddingInfo/WarningTextModel;", "", "warningText", "", "preBidPopMsg", "isTimedAuction", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "()Z", "getPreBidPopMsg", "()Ljava/lang/String;", "getWarningText", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: WarningTextModel.kt */
public final class WarningTextModel {
    private final boolean isTimedAuction;
    @NotNull
    private final String preBidPopMsg;
    @NotNull
    private final String warningText;

    @NotNull
    public static /* synthetic */ WarningTextModel copy$default(WarningTextModel warningTextModel, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = warningTextModel.warningText;
        }
        if ((i & 2) != 0) {
            str2 = warningTextModel.preBidPopMsg;
        }
        if ((i & 4) != 0) {
            z = warningTextModel.isTimedAuction;
        }
        return warningTextModel.copy(str, str2, z);
    }

    @NotNull
    public final String component1() {
        return this.warningText;
    }

    @NotNull
    public final String component2() {
        return this.preBidPopMsg;
    }

    public final boolean component3() {
        return this.isTimedAuction;
    }

    @NotNull
    public final WarningTextModel copy(@NotNull String str, @NotNull String str2, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "warningText");
        Intrinsics.checkParameterIsNotNull(str2, "preBidPopMsg");
        return new WarningTextModel(str, str2, z);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof WarningTextModel) {
                WarningTextModel warningTextModel = (WarningTextModel) obj;
                if (Intrinsics.areEqual((Object) this.warningText, (Object) warningTextModel.warningText) && Intrinsics.areEqual((Object) this.preBidPopMsg, (Object) warningTextModel.preBidPopMsg)) {
                    if (this.isTimedAuction == warningTextModel.isTimedAuction) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.warningText;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.preBidPopMsg;
        if (str2 != null) {
            i = str2.hashCode();
        }
        int i2 = (hashCode + i) * 31;
        boolean z = this.isTimedAuction;
        if (z) {
            z = true;
        }
        return i2 + (z ? 1 : 0);
    }

    @NotNull
    public String toString() {
        return "WarningTextModel(warningText=" + this.warningText + ", preBidPopMsg=" + this.preBidPopMsg + ", isTimedAuction=" + this.isTimedAuction + ")";
    }

    public WarningTextModel(@NotNull String str, @NotNull String str2, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "warningText");
        Intrinsics.checkParameterIsNotNull(str2, "preBidPopMsg");
        this.warningText = str;
        this.preBidPopMsg = str2;
        this.isTimedAuction = z;
    }

    @NotNull
    public final String getWarningText() {
        return this.warningText;
    }

    @NotNull
    public final String getPreBidPopMsg() {
        return this.preBidPopMsg;
    }

    public final boolean isTimedAuction() {
        return this.isTimedAuction;
    }
}
