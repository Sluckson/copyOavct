package com.iaai.android.bdt.model.auctionSalesList;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/auctionSalesList/RequestBody;", "", "AuctionSaleList", "Lcom/iaai/android/bdt/model/auctionSalesList/AuctionSaleList;", "(Lcom/iaai/android/bdt/model/auctionSalesList/AuctionSaleList;)V", "getAuctionSaleList", "()Lcom/iaai/android/bdt/model/auctionSalesList/AuctionSaleList;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: RequestBody.kt */
public final class RequestBody {
    @NotNull
    private final AuctionSaleList AuctionSaleList;

    @NotNull
    public static /* synthetic */ RequestBody copy$default(RequestBody requestBody, AuctionSaleList auctionSaleList, int i, Object obj) {
        if ((i & 1) != 0) {
            auctionSaleList = requestBody.AuctionSaleList;
        }
        return requestBody.copy(auctionSaleList);
    }

    @NotNull
    public final AuctionSaleList component1() {
        return this.AuctionSaleList;
    }

    @NotNull
    public final RequestBody copy(@NotNull AuctionSaleList auctionSaleList) {
        Intrinsics.checkParameterIsNotNull(auctionSaleList, "AuctionSaleList");
        return new RequestBody(auctionSaleList);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof RequestBody) && Intrinsics.areEqual((Object) this.AuctionSaleList, (Object) ((RequestBody) obj).AuctionSaleList);
        }
        return true;
    }

    public int hashCode() {
        AuctionSaleList auctionSaleList = this.AuctionSaleList;
        if (auctionSaleList != null) {
            return auctionSaleList.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        return "RequestBody(AuctionSaleList=" + this.AuctionSaleList + ")";
    }

    public RequestBody(@NotNull AuctionSaleList auctionSaleList) {
        Intrinsics.checkParameterIsNotNull(auctionSaleList, "AuctionSaleList");
        this.AuctionSaleList = auctionSaleList;
    }

    @NotNull
    public final AuctionSaleList getAuctionSaleList() {
        return this.AuctionSaleList;
    }
}
