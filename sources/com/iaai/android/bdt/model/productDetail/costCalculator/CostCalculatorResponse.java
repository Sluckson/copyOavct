package com.iaai.android.bdt.model.productDetail.costCalculator;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001e\b\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0002\u0010\u0011J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\bHÆ\u0003J\t\u0010$\u001a\u00020\bHÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\fHÆ\u0003J\t\u0010'\u001a\u00020\fHÆ\u0003J\u000f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fHÆ\u0003Ji\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fHÆ\u0001J\u0013\u0010*\u001a\u00020\f2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\u0003HÖ\u0001J\t\u0010-\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001e¨\u0006."}, mo66933d2 = {"Lcom/iaai/android/bdt/model/productDetail/costCalculator/CostCalculatorResponse;", "", "salvageID", "", "bidAmount", "", "estimatedFinalCost", "strEstimatedFinalCost", "", "strBidAmount", "buyerID", "vhrInd", "", "successInd", "costList", "", "Lcom/iaai/android/bdt/model/productDetail/costCalculator/CostList;", "(IFFLjava/lang/String;Ljava/lang/String;IZZLjava/util/List;)V", "getBidAmount", "()F", "getBuyerID", "()I", "getCostList", "()Ljava/util/List;", "getEstimatedFinalCost", "getSalvageID", "getStrBidAmount", "()Ljava/lang/String;", "getStrEstimatedFinalCost", "getSuccessInd", "()Z", "getVhrInd", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: CostCalculatorResponse.kt */
public final class CostCalculatorResponse {
    private final float bidAmount;
    private final int buyerID;
    @NotNull
    private final List<CostList> costList;
    private final float estimatedFinalCost;
    private final int salvageID;
    @NotNull
    private final String strBidAmount;
    @NotNull
    private final String strEstimatedFinalCost;
    private final boolean successInd;
    private final boolean vhrInd;

    @NotNull
    public static /* synthetic */ CostCalculatorResponse copy$default(CostCalculatorResponse costCalculatorResponse, int i, float f, float f2, String str, String str2, int i2, boolean z, boolean z2, List list, int i3, Object obj) {
        CostCalculatorResponse costCalculatorResponse2 = costCalculatorResponse;
        int i4 = i3;
        return costCalculatorResponse.copy((i4 & 1) != 0 ? costCalculatorResponse2.salvageID : i, (i4 & 2) != 0 ? costCalculatorResponse2.bidAmount : f, (i4 & 4) != 0 ? costCalculatorResponse2.estimatedFinalCost : f2, (i4 & 8) != 0 ? costCalculatorResponse2.strEstimatedFinalCost : str, (i4 & 16) != 0 ? costCalculatorResponse2.strBidAmount : str2, (i4 & 32) != 0 ? costCalculatorResponse2.buyerID : i2, (i4 & 64) != 0 ? costCalculatorResponse2.vhrInd : z, (i4 & 128) != 0 ? costCalculatorResponse2.successInd : z2, (i4 & 256) != 0 ? costCalculatorResponse2.costList : list);
    }

    public final int component1() {
        return this.salvageID;
    }

    public final float component2() {
        return this.bidAmount;
    }

    public final float component3() {
        return this.estimatedFinalCost;
    }

    @NotNull
    public final String component4() {
        return this.strEstimatedFinalCost;
    }

    @NotNull
    public final String component5() {
        return this.strBidAmount;
    }

    public final int component6() {
        return this.buyerID;
    }

    public final boolean component7() {
        return this.vhrInd;
    }

    public final boolean component8() {
        return this.successInd;
    }

    @NotNull
    public final List<CostList> component9() {
        return this.costList;
    }

    @NotNull
    public final CostCalculatorResponse copy(int i, float f, float f2, @NotNull String str, @NotNull String str2, int i2, boolean z, boolean z2, @NotNull List<CostList> list) {
        Intrinsics.checkParameterIsNotNull(str, "strEstimatedFinalCost");
        String str3 = str2;
        Intrinsics.checkParameterIsNotNull(str3, "strBidAmount");
        List<CostList> list2 = list;
        Intrinsics.checkParameterIsNotNull(list2, "costList");
        return new CostCalculatorResponse(i, f, f2, str, str3, i2, z, z2, list2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof CostCalculatorResponse) {
                CostCalculatorResponse costCalculatorResponse = (CostCalculatorResponse) obj;
                if ((this.salvageID == costCalculatorResponse.salvageID) && Float.compare(this.bidAmount, costCalculatorResponse.bidAmount) == 0 && Float.compare(this.estimatedFinalCost, costCalculatorResponse.estimatedFinalCost) == 0 && Intrinsics.areEqual((Object) this.strEstimatedFinalCost, (Object) costCalculatorResponse.strEstimatedFinalCost) && Intrinsics.areEqual((Object) this.strBidAmount, (Object) costCalculatorResponse.strBidAmount)) {
                    if (this.buyerID == costCalculatorResponse.buyerID) {
                        if (this.vhrInd == costCalculatorResponse.vhrInd) {
                            if (!(this.successInd == costCalculatorResponse.successInd) || !Intrinsics.areEqual((Object) this.costList, (Object) costCalculatorResponse.costList)) {
                                return false;
                            }
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = ((((Integer.valueOf(this.salvageID).hashCode() * 31) + Float.valueOf(this.bidAmount).hashCode()) * 31) + Float.valueOf(this.estimatedFinalCost).hashCode()) * 31;
        String str = this.strEstimatedFinalCost;
        int i = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.strBidAmount;
        int hashCode3 = (((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + Integer.valueOf(this.buyerID).hashCode()) * 31;
        boolean z = this.vhrInd;
        if (z) {
            z = true;
        }
        int i2 = (hashCode3 + (z ? 1 : 0)) * 31;
        boolean z2 = this.successInd;
        if (z2) {
            z2 = true;
        }
        int i3 = (i2 + (z2 ? 1 : 0)) * 31;
        List<CostList> list = this.costList;
        if (list != null) {
            i = list.hashCode();
        }
        return i3 + i;
    }

    @NotNull
    public String toString() {
        return "CostCalculatorResponse(salvageID=" + this.salvageID + ", bidAmount=" + this.bidAmount + ", estimatedFinalCost=" + this.estimatedFinalCost + ", strEstimatedFinalCost=" + this.strEstimatedFinalCost + ", strBidAmount=" + this.strBidAmount + ", buyerID=" + this.buyerID + ", vhrInd=" + this.vhrInd + ", successInd=" + this.successInd + ", costList=" + this.costList + ")";
    }

    public CostCalculatorResponse(int i, float f, float f2, @NotNull String str, @NotNull String str2, int i2, boolean z, boolean z2, @NotNull List<CostList> list) {
        Intrinsics.checkParameterIsNotNull(str, "strEstimatedFinalCost");
        Intrinsics.checkParameterIsNotNull(str2, "strBidAmount");
        Intrinsics.checkParameterIsNotNull(list, "costList");
        this.salvageID = i;
        this.bidAmount = f;
        this.estimatedFinalCost = f2;
        this.strEstimatedFinalCost = str;
        this.strBidAmount = str2;
        this.buyerID = i2;
        this.vhrInd = z;
        this.successInd = z2;
        this.costList = list;
    }

    public final int getSalvageID() {
        return this.salvageID;
    }

    public final float getBidAmount() {
        return this.bidAmount;
    }

    public final float getEstimatedFinalCost() {
        return this.estimatedFinalCost;
    }

    @NotNull
    public final String getStrEstimatedFinalCost() {
        return this.strEstimatedFinalCost;
    }

    @NotNull
    public final String getStrBidAmount() {
        return this.strBidAmount;
    }

    public final int getBuyerID() {
        return this.buyerID;
    }

    public final boolean getVhrInd() {
        return this.vhrInd;
    }

    public final boolean getSuccessInd() {
        return this.successInd;
    }

    @NotNull
    public final List<CostList> getCostList() {
        return this.costList;
    }
}
