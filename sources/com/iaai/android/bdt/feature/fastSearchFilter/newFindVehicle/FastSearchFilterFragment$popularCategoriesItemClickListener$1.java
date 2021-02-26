package com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle;

import com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.PopularCategoriesAdapter;
import com.iaai.android.bdt.model.fastSearchFilter2.FacetXX;
import com.iaai.android.bdt.utils.BDTUtils;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, mo66933d2 = {"com/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/FastSearchFilterFragment$popularCategoriesItemClickListener$1", "Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/PopularCategoriesAdapter$PopularCategoriesItemClickListener;", "onPopularCategoriesItemClick", "", "clickedItem", "Lcom/iaai/android/bdt/model/fastSearchFilter2/FacetXX;", "isSelect", "", "position", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: FastSearchFilterFragment.kt */
public final class FastSearchFilterFragment$popularCategoriesItemClickListener$1 implements PopularCategoriesAdapter.PopularCategoriesItemClickListener {
    final /* synthetic */ FastSearchFilterFragment this$0;

    FastSearchFilterFragment$popularCategoriesItemClickListener$1(FastSearchFilterFragment fastSearchFilterFragment) {
        this.this$0 = fastSearchFilterFragment;
    }

    public void onPopularCategoriesItemClick(@Nullable FacetXX facetXX, boolean z, int i) {
        BDTUtils.INSTANCE.updateGlobalPopularCategoryMapping(facetXX);
        PopularCategoriesAdapter access$getPopularCategoriesAdapter$p = this.this$0.popularCategoriesAdapter;
        if (access$getPopularCategoriesAdapter$p != null) {
            access$getPopularCategoriesAdapter$p.setQuickLinksData();
        }
        PopularCategoriesAdapter access$getPopularCategoriesAdapter$p2 = this.this$0.popularCategoriesAdapter;
        if (access$getPopularCategoriesAdapter$p2 != null) {
            access$getPopularCategoriesAdapter$p2.notifyDataSetChanged();
        }
        this.this$0.updateHeader(2, i, HeaderUpdate.POPULAR_CATEGORIES, !z);
        this.this$0.parentPosition = -1;
        this.this$0.getFilterValueBasedSelectedRefiner(true);
    }
}
