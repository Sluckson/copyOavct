package com.iaai.android.bdt.model.productDetail.buyNowOffer;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/productDetail/buyNowOffer/BDTBuyNowOfferResult;", "", "WCBCODE", "", "BIDLIMITCODE", "ERRORMESSAGE", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBIDLIMITCODE", "()Ljava/lang/String;", "getERRORMESSAGE", "getWCBCODE", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: BDTBuyNowOfferResult.kt */
public final class BDTBuyNowOfferResult {
    @NotNull
    private final String BIDLIMITCODE;
    @NotNull
    private final String ERRORMESSAGE;
    @NotNull
    private final String WCBCODE;

    @NotNull
    public static /* synthetic */ BDTBuyNowOfferResult copy$default(BDTBuyNowOfferResult bDTBuyNowOfferResult, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bDTBuyNowOfferResult.WCBCODE;
        }
        if ((i & 2) != 0) {
            str2 = bDTBuyNowOfferResult.BIDLIMITCODE;
        }
        if ((i & 4) != 0) {
            str3 = bDTBuyNowOfferResult.ERRORMESSAGE;
        }
        return bDTBuyNowOfferResult.copy(str, str2, str3);
    }

    @NotNull
    public final String component1() {
        return this.WCBCODE;
    }

    @NotNull
    public final String component2() {
        return this.BIDLIMITCODE;
    }

    @NotNull
    public final String component3() {
        return this.ERRORMESSAGE;
    }

    @NotNull
    public final BDTBuyNowOfferResult copy(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkParameterIsNotNull(str, "WCBCODE");
        Intrinsics.checkParameterIsNotNull(str2, "BIDLIMITCODE");
        Intrinsics.checkParameterIsNotNull(str3, "ERRORMESSAGE");
        return new BDTBuyNowOfferResult(str, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BDTBuyNowOfferResult)) {
            return false;
        }
        BDTBuyNowOfferResult bDTBuyNowOfferResult = (BDTBuyNowOfferResult) obj;
        return Intrinsics.areEqual((Object) this.WCBCODE, (Object) bDTBuyNowOfferResult.WCBCODE) && Intrinsics.areEqual((Object) this.BIDLIMITCODE, (Object) bDTBuyNowOfferResult.BIDLIMITCODE) && Intrinsics.areEqual((Object) this.ERRORMESSAGE, (Object) bDTBuyNowOfferResult.ERRORMESSAGE);
    }

    public int hashCode() {
        String str = this.WCBCODE;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.BIDLIMITCODE;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.ERRORMESSAGE;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        return "BDTBuyNowOfferResult(WCBCODE=" + this.WCBCODE + ", BIDLIMITCODE=" + this.BIDLIMITCODE + ", ERRORMESSAGE=" + this.ERRORMESSAGE + ")";
    }

    public BDTBuyNowOfferResult(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkParameterIsNotNull(str, "WCBCODE");
        Intrinsics.checkParameterIsNotNull(str2, "BIDLIMITCODE");
        Intrinsics.checkParameterIsNotNull(str3, "ERRORMESSAGE");
        this.WCBCODE = str;
        this.BIDLIMITCODE = str2;
        this.ERRORMESSAGE = str3;
    }

    @NotNull
    public final String getWCBCODE() {
        return this.WCBCODE;
    }

    @NotNull
    public final String getBIDLIMITCODE() {
        return this.BIDLIMITCODE;
    }

    @NotNull
    public final String getERRORMESSAGE() {
        return this.ERRORMESSAGE;
    }
}
