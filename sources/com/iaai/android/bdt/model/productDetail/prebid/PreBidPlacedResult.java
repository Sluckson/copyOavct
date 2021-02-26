package com.iaai.android.bdt.model.productDetail.prebid;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u0019"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/productDetail/prebid/PreBidPlacedResult;", "", "ConfirmationNumber", "", "bidding", "message", "IsSuccessful", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getConfirmationNumber", "()Ljava/lang/String;", "getIsSuccessful", "()Z", "getBidding", "getMessage", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: PreBidPlacedResult.kt */
public final class PreBidPlacedResult {
    @NotNull
    private final String ConfirmationNumber;
    private final boolean IsSuccessful;
    @NotNull
    private final String bidding;
    @NotNull
    private final String message;

    @NotNull
    public static /* synthetic */ PreBidPlacedResult copy$default(PreBidPlacedResult preBidPlacedResult, String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = preBidPlacedResult.ConfirmationNumber;
        }
        if ((i & 2) != 0) {
            str2 = preBidPlacedResult.bidding;
        }
        if ((i & 4) != 0) {
            str3 = preBidPlacedResult.message;
        }
        if ((i & 8) != 0) {
            z = preBidPlacedResult.IsSuccessful;
        }
        return preBidPlacedResult.copy(str, str2, str3, z);
    }

    @NotNull
    public final String component1() {
        return this.ConfirmationNumber;
    }

    @NotNull
    public final String component2() {
        return this.bidding;
    }

    @NotNull
    public final String component3() {
        return this.message;
    }

    public final boolean component4() {
        return this.IsSuccessful;
    }

    @NotNull
    public final PreBidPlacedResult copy(@NotNull String str, @NotNull String str2, @NotNull String str3, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "ConfirmationNumber");
        Intrinsics.checkParameterIsNotNull(str2, "bidding");
        Intrinsics.checkParameterIsNotNull(str3, "message");
        return new PreBidPlacedResult(str, str2, str3, z);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof PreBidPlacedResult) {
                PreBidPlacedResult preBidPlacedResult = (PreBidPlacedResult) obj;
                if (Intrinsics.areEqual((Object) this.ConfirmationNumber, (Object) preBidPlacedResult.ConfirmationNumber) && Intrinsics.areEqual((Object) this.bidding, (Object) preBidPlacedResult.bidding) && Intrinsics.areEqual((Object) this.message, (Object) preBidPlacedResult.message)) {
                    if (this.IsSuccessful == preBidPlacedResult.IsSuccessful) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.ConfirmationNumber;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.bidding;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.message;
        if (str3 != null) {
            i = str3.hashCode();
        }
        int i2 = (hashCode2 + i) * 31;
        boolean z = this.IsSuccessful;
        if (z) {
            z = true;
        }
        return i2 + (z ? 1 : 0);
    }

    @NotNull
    public String toString() {
        return "PreBidPlacedResult(ConfirmationNumber=" + this.ConfirmationNumber + ", bidding=" + this.bidding + ", message=" + this.message + ", IsSuccessful=" + this.IsSuccessful + ")";
    }

    public PreBidPlacedResult(@NotNull String str, @NotNull String str2, @NotNull String str3, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "ConfirmationNumber");
        Intrinsics.checkParameterIsNotNull(str2, "bidding");
        Intrinsics.checkParameterIsNotNull(str3, "message");
        this.ConfirmationNumber = str;
        this.bidding = str2;
        this.message = str3;
        this.IsSuccessful = z;
    }

    @NotNull
    public final String getConfirmationNumber() {
        return this.ConfirmationNumber;
    }

    @NotNull
    public final String getBidding() {
        return this.bidding;
    }

    @NotNull
    public final String getMessage() {
        return this.message;
    }

    public final boolean getIsSuccessful() {
        return this.IsSuccessful;
    }
}
