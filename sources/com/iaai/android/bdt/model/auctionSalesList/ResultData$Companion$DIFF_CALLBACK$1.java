package com.iaai.android.bdt.model.auctionSalesList;

import androidx.recyclerview.widget.DiffUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\b"}, mo66933d2 = {"com/iaai/android/bdt/model/auctionSalesList/ResultData$Companion$DIFF_CALLBACK$1", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/iaai/android/bdt/model/auctionSalesList/ResultData;", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: ResultData.kt */
public final class ResultData$Companion$DIFF_CALLBACK$1 extends DiffUtil.ItemCallback<ResultData> {
    ResultData$Companion$DIFF_CALLBACK$1() {
    }

    public boolean areItemsTheSame(@NotNull ResultData resultData, @NotNull ResultData resultData2) {
        Intrinsics.checkParameterIsNotNull(resultData, "oldItem");
        Intrinsics.checkParameterIsNotNull(resultData2, "newItem");
        return Intrinsics.areEqual((Object) resultData.getItemId(), (Object) resultData2.getItemId());
    }

    public boolean areContentsTheSame(@NotNull ResultData resultData, @NotNull ResultData resultData2) {
        Intrinsics.checkParameterIsNotNull(resultData, "oldItem");
        Intrinsics.checkParameterIsNotNull(resultData2, "newItem");
        return resultData.equals(resultData2);
    }
}
