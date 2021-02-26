package com.iaai.android.bdt.model.productDetail.prebid;

import java.math.BigDecimal;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/productDetail/prebid/RequestBody;", "", "MaxBid", "Ljava/math/BigDecimal;", "CurrentBid", "(Ljava/math/BigDecimal;Ljava/math/BigDecimal;)V", "getCurrentBid", "()Ljava/math/BigDecimal;", "getMaxBid", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: RequestBody.kt */
public final class RequestBody {
    @NotNull
    private final BigDecimal CurrentBid;
    @NotNull
    private final BigDecimal MaxBid;

    @NotNull
    public static /* synthetic */ RequestBody copy$default(RequestBody requestBody, BigDecimal bigDecimal, BigDecimal bigDecimal2, int i, Object obj) {
        if ((i & 1) != 0) {
            bigDecimal = requestBody.MaxBid;
        }
        if ((i & 2) != 0) {
            bigDecimal2 = requestBody.CurrentBid;
        }
        return requestBody.copy(bigDecimal, bigDecimal2);
    }

    @NotNull
    public final BigDecimal component1() {
        return this.MaxBid;
    }

    @NotNull
    public final BigDecimal component2() {
        return this.CurrentBid;
    }

    @NotNull
    public final RequestBody copy(@NotNull BigDecimal bigDecimal, @NotNull BigDecimal bigDecimal2) {
        Intrinsics.checkParameterIsNotNull(bigDecimal, "MaxBid");
        Intrinsics.checkParameterIsNotNull(bigDecimal2, "CurrentBid");
        return new RequestBody(bigDecimal, bigDecimal2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RequestBody)) {
            return false;
        }
        RequestBody requestBody = (RequestBody) obj;
        return Intrinsics.areEqual((Object) this.MaxBid, (Object) requestBody.MaxBid) && Intrinsics.areEqual((Object) this.CurrentBid, (Object) requestBody.CurrentBid);
    }

    public int hashCode() {
        BigDecimal bigDecimal = this.MaxBid;
        int i = 0;
        int hashCode = (bigDecimal != null ? bigDecimal.hashCode() : 0) * 31;
        BigDecimal bigDecimal2 = this.CurrentBid;
        if (bigDecimal2 != null) {
            i = bigDecimal2.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        return "RequestBody(MaxBid=" + this.MaxBid + ", CurrentBid=" + this.CurrentBid + ")";
    }

    public RequestBody(@NotNull BigDecimal bigDecimal, @NotNull BigDecimal bigDecimal2) {
        Intrinsics.checkParameterIsNotNull(bigDecimal, "MaxBid");
        Intrinsics.checkParameterIsNotNull(bigDecimal2, "CurrentBid");
        this.MaxBid = bigDecimal;
        this.CurrentBid = bigDecimal2;
    }

    @NotNull
    public final BigDecimal getMaxBid() {
        return this.MaxBid;
    }

    @NotNull
    public final BigDecimal getCurrentBid() {
        return this.CurrentBid;
    }
}
