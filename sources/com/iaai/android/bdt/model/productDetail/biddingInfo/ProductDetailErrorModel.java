package com.iaai.android.bdt.model.productDetail.biddingInfo;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\t¨\u0006\u0012"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/productDetail/biddingInfo/ProductDetailErrorModel;", "", "isNetworkError", "", "errormessage", "", "(ZLjava/lang/String;)V", "getErrormessage", "()Ljava/lang/String;", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: ProductDetailErrorModel.kt */
public final class ProductDetailErrorModel {
    @NotNull
    private final String errormessage;
    private final boolean isNetworkError;

    @NotNull
    public static /* synthetic */ ProductDetailErrorModel copy$default(ProductDetailErrorModel productDetailErrorModel, boolean z, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = productDetailErrorModel.isNetworkError;
        }
        if ((i & 2) != 0) {
            str = productDetailErrorModel.errormessage;
        }
        return productDetailErrorModel.copy(z, str);
    }

    public final boolean component1() {
        return this.isNetworkError;
    }

    @NotNull
    public final String component2() {
        return this.errormessage;
    }

    @NotNull
    public final ProductDetailErrorModel copy(boolean z, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "errormessage");
        return new ProductDetailErrorModel(z, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof ProductDetailErrorModel) {
                ProductDetailErrorModel productDetailErrorModel = (ProductDetailErrorModel) obj;
                if (!(this.isNetworkError == productDetailErrorModel.isNetworkError) || !Intrinsics.areEqual((Object) this.errormessage, (Object) productDetailErrorModel.errormessage)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        boolean z = this.isNetworkError;
        if (z) {
            z = true;
        }
        int i = (z ? 1 : 0) * true;
        String str = this.errormessage;
        return i + (str != null ? str.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "ProductDetailErrorModel(isNetworkError=" + this.isNetworkError + ", errormessage=" + this.errormessage + ")";
    }

    public ProductDetailErrorModel(boolean z, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "errormessage");
        this.isNetworkError = z;
        this.errormessage = str;
    }

    public final boolean isNetworkError() {
        return this.isNetworkError;
    }

    @NotNull
    public final String getErrormessage() {
        return this.errormessage;
    }
}
