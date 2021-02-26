package com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle;

import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.RefinerHeaderAdapter;
import com.iaai.android.bdt.model.fastSearchFilter2.FacetXX;
import com.iaai.android.bdt.utils.BDTUtils;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J4\u0010\u0002\u001a\u00020\u00032\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u0006H\u0016¨\u0006\n"}, mo66933d2 = {"com/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/FastSearchFilterFragment$headerClickListener$1", "Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/RefinerHeaderAdapter$OnRefinerHeaderItemClickListener;", "onItemClick", "", "indices", "Lkotlin/Triple;", "", "facetXX", "Lcom/iaai/android/bdt/model/fastSearchFilter2/FacetXX;", "position", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: FastSearchFilterFragment.kt */
public final class FastSearchFilterFragment$headerClickListener$1 implements RefinerHeaderAdapter.OnRefinerHeaderItemClickListener {
    final /* synthetic */ FastSearchFilterFragment this$0;

    FastSearchFilterFragment$headerClickListener$1(FastSearchFilterFragment fastSearchFilterFragment) {
        this.this$0 = fastSearchFilterFragment;
    }

    public void onItemClick(@NotNull Triple<Integer, Integer, Integer> triple, @Nullable FacetXX facetXX, int i) {
        String refinerValue;
        String refinerValue2;
        Intrinsics.checkParameterIsNotNull(triple, "indices");
        if (facetXX == null || (refinerValue2 = facetXX.getRefinerValue()) == null || !StringsKt.startsWith$default(refinerValue2, "keyword", false, 2, (Object) null)) {
            this.this$0.updateFilterMapping(triple.getFirst().intValue(), triple.getSecond().intValue(), triple.getThird().intValue(), facetXX);
            if (!(facetXX == null || (refinerValue = facetXX.getRefinerValue()) == null || !StringsKt.startsWith$default(refinerValue, "Make & Model~", false, 2, (Object) null))) {
                Pair<String, String> makeModel = BDTUtils.INSTANCE.getMakeModel(facetXX);
                this.this$0.removeLastSelectedMakeModel(makeModel.getSecond(), makeModel.getFirst());
                this.this$0.getSeriesDataBasedOnMakeModel();
            }
            this.this$0.updateIsEnabledMapping(triple.getSecond().intValue());
            IaaiApplication.isSavedSearch = false;
            this.this$0.showEmptyHeader();
            this.this$0.parentPosition = -1;
            this.this$0.getFilterValueBasedSelectedRefiner(true);
        }
    }
}
