package com.iaai.android.bdt.model.toBePaid.saleDocument.groupedByBranch;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0001HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J7\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0004HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/toBePaid/saleDocument/groupedByBranch/GetSaleDocListGroupResponse;", "", "BuyerGlobalInstructionNote", "ItemCount", "", "ShowTitleHandlingInstructionInfoScreen", "TitleInstructionItemListGrouped", "", "Lcom/iaai/android/bdt/model/toBePaid/saleDocument/groupedByBranch/TitleInstructionItemGrouped;", "(Ljava/lang/Object;IILjava/util/List;)V", "getBuyerGlobalInstructionNote", "()Ljava/lang/Object;", "getItemCount", "()I", "getShowTitleHandlingInstructionInfoScreen", "getTitleInstructionItemListGrouped", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: GetSaleDocListGroupResponse.kt */
public final class GetSaleDocListGroupResponse {
    @NotNull
    private final Object BuyerGlobalInstructionNote;
    private final int ItemCount;
    private final int ShowTitleHandlingInstructionInfoScreen;
    @NotNull
    private final List<TitleInstructionItemGrouped> TitleInstructionItemListGrouped;

    @NotNull
    public static /* synthetic */ GetSaleDocListGroupResponse copy$default(GetSaleDocListGroupResponse getSaleDocListGroupResponse, Object obj, int i, int i2, List<TitleInstructionItemGrouped> list, int i3, Object obj2) {
        if ((i3 & 1) != 0) {
            obj = getSaleDocListGroupResponse.BuyerGlobalInstructionNote;
        }
        if ((i3 & 2) != 0) {
            i = getSaleDocListGroupResponse.ItemCount;
        }
        if ((i3 & 4) != 0) {
            i2 = getSaleDocListGroupResponse.ShowTitleHandlingInstructionInfoScreen;
        }
        if ((i3 & 8) != 0) {
            list = getSaleDocListGroupResponse.TitleInstructionItemListGrouped;
        }
        return getSaleDocListGroupResponse.copy(obj, i, i2, list);
    }

    @NotNull
    public final Object component1() {
        return this.BuyerGlobalInstructionNote;
    }

    public final int component2() {
        return this.ItemCount;
    }

    public final int component3() {
        return this.ShowTitleHandlingInstructionInfoScreen;
    }

    @NotNull
    public final List<TitleInstructionItemGrouped> component4() {
        return this.TitleInstructionItemListGrouped;
    }

    @NotNull
    public final GetSaleDocListGroupResponse copy(@NotNull Object obj, int i, int i2, @NotNull List<TitleInstructionItemGrouped> list) {
        Intrinsics.checkParameterIsNotNull(obj, "BuyerGlobalInstructionNote");
        Intrinsics.checkParameterIsNotNull(list, "TitleInstructionItemListGrouped");
        return new GetSaleDocListGroupResponse(obj, i, i2, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof GetSaleDocListGroupResponse) {
                GetSaleDocListGroupResponse getSaleDocListGroupResponse = (GetSaleDocListGroupResponse) obj;
                if (Intrinsics.areEqual(this.BuyerGlobalInstructionNote, getSaleDocListGroupResponse.BuyerGlobalInstructionNote)) {
                    if (this.ItemCount == getSaleDocListGroupResponse.ItemCount) {
                        if (!(this.ShowTitleHandlingInstructionInfoScreen == getSaleDocListGroupResponse.ShowTitleHandlingInstructionInfoScreen) || !Intrinsics.areEqual((Object) this.TitleInstructionItemListGrouped, (Object) getSaleDocListGroupResponse.TitleInstructionItemListGrouped)) {
                            return false;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        Object obj = this.BuyerGlobalInstructionNote;
        int i = 0;
        int hashCode = (((((obj != null ? obj.hashCode() : 0) * 31) + Integer.valueOf(this.ItemCount).hashCode()) * 31) + Integer.valueOf(this.ShowTitleHandlingInstructionInfoScreen).hashCode()) * 31;
        List<TitleInstructionItemGrouped> list = this.TitleInstructionItemListGrouped;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        return "GetSaleDocListGroupResponse(BuyerGlobalInstructionNote=" + this.BuyerGlobalInstructionNote + ", ItemCount=" + this.ItemCount + ", ShowTitleHandlingInstructionInfoScreen=" + this.ShowTitleHandlingInstructionInfoScreen + ", TitleInstructionItemListGrouped=" + this.TitleInstructionItemListGrouped + ")";
    }

    public GetSaleDocListGroupResponse(@NotNull Object obj, int i, int i2, @NotNull List<TitleInstructionItemGrouped> list) {
        Intrinsics.checkParameterIsNotNull(obj, "BuyerGlobalInstructionNote");
        Intrinsics.checkParameterIsNotNull(list, "TitleInstructionItemListGrouped");
        this.BuyerGlobalInstructionNote = obj;
        this.ItemCount = i;
        this.ShowTitleHandlingInstructionInfoScreen = i2;
        this.TitleInstructionItemListGrouped = list;
    }

    @NotNull
    public final Object getBuyerGlobalInstructionNote() {
        return this.BuyerGlobalInstructionNote;
    }

    public final int getItemCount() {
        return this.ItemCount;
    }

    public final int getShowTitleHandlingInstructionInfoScreen() {
        return this.ShowTitleHandlingInstructionInfoScreen;
    }

    @NotNull
    public final List<TitleInstructionItemGrouped> getTitleInstructionItemListGrouped() {
        return this.TitleInstructionItemListGrouped;
    }
}
