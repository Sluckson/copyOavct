package com.iaai.android.bdt.model.auctionSalesList;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0002\u0010\u000eJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\n0\u0007HÆ\u0003J\t\u0010\u001d\u001a\u00020\fHÆ\u0003J\t\u0010\u001e\u001a\u00020\fHÆ\u0003JQ\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\fHÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0005HÖ\u0001J\t\u0010$\u001a\u00020\fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017¨\u0006%"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/auctionSalesList/AuctionSalesListResponse;", "", "auctionDetails", "Lcom/iaai/android/bdt/model/auctionSalesList/AuctionDetails;", "listCount", "", "resultData", "", "Lcom/iaai/android/bdt/model/auctionSalesList/ResultData;", "scope", "Lcom/iaai/android/bdt/model/auctionSalesList/Scope;", "selectedScope", "", "sort", "(Lcom/iaai/android/bdt/model/auctionSalesList/AuctionDetails;ILjava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getAuctionDetails", "()Lcom/iaai/android/bdt/model/auctionSalesList/AuctionDetails;", "getListCount", "()I", "getResultData", "()Ljava/util/List;", "getScope", "getSelectedScope", "()Ljava/lang/String;", "getSort", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: AuctionSalesListResponse.kt */
public final class AuctionSalesListResponse {
    @NotNull
    private final AuctionDetails auctionDetails;
    private final int listCount;
    @NotNull
    private final List<ResultData> resultData;
    @NotNull
    private final List<Scope> scope;
    @NotNull
    private final String selectedScope;
    @NotNull
    private final String sort;

    @NotNull
    public static /* synthetic */ AuctionSalesListResponse copy$default(AuctionSalesListResponse auctionSalesListResponse, AuctionDetails auctionDetails2, int i, List<ResultData> list, List<Scope> list2, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            auctionDetails2 = auctionSalesListResponse.auctionDetails;
        }
        if ((i2 & 2) != 0) {
            i = auctionSalesListResponse.listCount;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            list = auctionSalesListResponse.resultData;
        }
        List<ResultData> list3 = list;
        if ((i2 & 8) != 0) {
            list2 = auctionSalesListResponse.scope;
        }
        List<Scope> list4 = list2;
        if ((i2 & 16) != 0) {
            str = auctionSalesListResponse.selectedScope;
        }
        String str3 = str;
        if ((i2 & 32) != 0) {
            str2 = auctionSalesListResponse.sort;
        }
        return auctionSalesListResponse.copy(auctionDetails2, i3, list3, list4, str3, str2);
    }

    @NotNull
    public final AuctionDetails component1() {
        return this.auctionDetails;
    }

    public final int component2() {
        return this.listCount;
    }

    @NotNull
    public final List<ResultData> component3() {
        return this.resultData;
    }

    @NotNull
    public final List<Scope> component4() {
        return this.scope;
    }

    @NotNull
    public final String component5() {
        return this.selectedScope;
    }

    @NotNull
    public final String component6() {
        return this.sort;
    }

    @NotNull
    public final AuctionSalesListResponse copy(@NotNull AuctionDetails auctionDetails2, int i, @NotNull List<ResultData> list, @NotNull List<Scope> list2, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(auctionDetails2, "auctionDetails");
        Intrinsics.checkParameterIsNotNull(list, "resultData");
        Intrinsics.checkParameterIsNotNull(list2, "scope");
        Intrinsics.checkParameterIsNotNull(str, "selectedScope");
        Intrinsics.checkParameterIsNotNull(str2, "sort");
        return new AuctionSalesListResponse(auctionDetails2, i, list, list2, str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof AuctionSalesListResponse) {
                AuctionSalesListResponse auctionSalesListResponse = (AuctionSalesListResponse) obj;
                if (Intrinsics.areEqual((Object) this.auctionDetails, (Object) auctionSalesListResponse.auctionDetails)) {
                    if (!(this.listCount == auctionSalesListResponse.listCount) || !Intrinsics.areEqual((Object) this.resultData, (Object) auctionSalesListResponse.resultData) || !Intrinsics.areEqual((Object) this.scope, (Object) auctionSalesListResponse.scope) || !Intrinsics.areEqual((Object) this.selectedScope, (Object) auctionSalesListResponse.selectedScope) || !Intrinsics.areEqual((Object) this.sort, (Object) auctionSalesListResponse.sort)) {
                        return false;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        AuctionDetails auctionDetails2 = this.auctionDetails;
        int i = 0;
        int hashCode = (((auctionDetails2 != null ? auctionDetails2.hashCode() : 0) * 31) + Integer.valueOf(this.listCount).hashCode()) * 31;
        List<ResultData> list = this.resultData;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        List<Scope> list2 = this.scope;
        int hashCode3 = (hashCode2 + (list2 != null ? list2.hashCode() : 0)) * 31;
        String str = this.selectedScope;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.sort;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode4 + i;
    }

    @NotNull
    public String toString() {
        return "AuctionSalesListResponse(auctionDetails=" + this.auctionDetails + ", listCount=" + this.listCount + ", resultData=" + this.resultData + ", scope=" + this.scope + ", selectedScope=" + this.selectedScope + ", sort=" + this.sort + ")";
    }

    public AuctionSalesListResponse(@NotNull AuctionDetails auctionDetails2, int i, @NotNull List<ResultData> list, @NotNull List<Scope> list2, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(auctionDetails2, "auctionDetails");
        Intrinsics.checkParameterIsNotNull(list, "resultData");
        Intrinsics.checkParameterIsNotNull(list2, "scope");
        Intrinsics.checkParameterIsNotNull(str, "selectedScope");
        Intrinsics.checkParameterIsNotNull(str2, "sort");
        this.auctionDetails = auctionDetails2;
        this.listCount = i;
        this.resultData = list;
        this.scope = list2;
        this.selectedScope = str;
        this.sort = str2;
    }

    @NotNull
    public final AuctionDetails getAuctionDetails() {
        return this.auctionDetails;
    }

    public final int getListCount() {
        return this.listCount;
    }

    @NotNull
    public final List<ResultData> getResultData() {
        return this.resultData;
    }

    @NotNull
    public final List<Scope> getScope() {
        return this.scope;
    }

    @NotNull
    public final String getSelectedScope() {
        return this.selectedScope;
    }

    @NotNull
    public final String getSort() {
        return this.sort;
    }
}
