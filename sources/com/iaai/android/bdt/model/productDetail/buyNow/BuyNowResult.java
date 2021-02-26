package com.iaai.android.bdt.model.productDetail.buyNow;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/productDetail/buyNow/BuyNowResult;", "", "canbuyerbuy", "", "message", "", "(ZLjava/lang/String;)V", "getCanbuyerbuy", "()Z", "getMessage", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: BuyNowResult.kt */
public final class BuyNowResult {
    private final boolean canbuyerbuy;
    @NotNull
    private final String message;

    @NotNull
    public static /* synthetic */ BuyNowResult copy$default(BuyNowResult buyNowResult, boolean z, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = buyNowResult.canbuyerbuy;
        }
        if ((i & 2) != 0) {
            str = buyNowResult.message;
        }
        return buyNowResult.copy(z, str);
    }

    public final boolean component1() {
        return this.canbuyerbuy;
    }

    @NotNull
    public final String component2() {
        return this.message;
    }

    @NotNull
    public final BuyNowResult copy(boolean z, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "message");
        return new BuyNowResult(z, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof BuyNowResult) {
                BuyNowResult buyNowResult = (BuyNowResult) obj;
                if (!(this.canbuyerbuy == buyNowResult.canbuyerbuy) || !Intrinsics.areEqual((Object) this.message, (Object) buyNowResult.message)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        boolean z = this.canbuyerbuy;
        if (z) {
            z = true;
        }
        int i = (z ? 1 : 0) * true;
        String str = this.message;
        return i + (str != null ? str.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "BuyNowResult(canbuyerbuy=" + this.canbuyerbuy + ", message=" + this.message + ")";
    }

    public BuyNowResult(boolean z, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "message");
        this.canbuyerbuy = z;
        this.message = str;
    }

    public final boolean getCanbuyerbuy() {
        return this.canbuyerbuy;
    }

    @NotNull
    public final String getMessage() {
        return this.message;
    }
}
