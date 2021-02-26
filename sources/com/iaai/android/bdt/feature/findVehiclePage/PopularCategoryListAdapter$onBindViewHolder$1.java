package com.iaai.android.bdt.feature.findVehiclePage;

import android.view.View;
import com.iaai.android.bdt.feature.findVehiclePage.PopularCategoryListAdapter;
import com.iaai.android.bdt.model.fastSearch.RefinerX;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: PopularCategoryListAdapter.kt */
final class PopularCategoryListAdapter$onBindViewHolder$1 implements View.OnClickListener {
    final /* synthetic */ int $position;
    final /* synthetic */ PopularCategoryListAdapter this$0;

    PopularCategoryListAdapter$onBindViewHolder$1(PopularCategoryListAdapter popularCategoryListAdapter, int i) {
        this.this$0 = popularCategoryListAdapter;
        this.$position = i;
    }

    public final void onClick(View view) {
        if (((RefinerX) PopularCategoryListAdapter.access$getItemList$p(this.this$0).get(this.$position)).isSelect()) {
            PopularCategoryListAdapter popularCategoryListAdapter = this.this$0;
            popularCategoryListAdapter.popularCategorySelect(((RefinerX) PopularCategoryListAdapter.access$getItemList$p(popularCategoryListAdapter).get(this.$position)).getDisplayName(), false);
            PopularCategoryListAdapter.OnPopularCategoryItemClickListener access$getOnItemClickListener$p = PopularCategoryListAdapter.access$getOnItemClickListener$p(this.this$0);
            Object obj = PopularCategoryListAdapter.access$getItemList$p(this.this$0).get(this.$position);
            Intrinsics.checkExpressionValueIsNotNull(obj, "itemList.get(position)");
            access$getOnItemClickListener$p.onPopularCategoryItemClick((RefinerX) obj, false);
            return;
        }
        PopularCategoryListAdapter popularCategoryListAdapter2 = this.this$0;
        popularCategoryListAdapter2.popularCategorySelect(((RefinerX) PopularCategoryListAdapter.access$getItemList$p(popularCategoryListAdapter2).get(this.$position)).getDisplayName(), true);
        PopularCategoryListAdapter.OnPopularCategoryItemClickListener access$getOnItemClickListener$p2 = PopularCategoryListAdapter.access$getOnItemClickListener$p(this.this$0);
        Object obj2 = PopularCategoryListAdapter.access$getItemList$p(this.this$0).get(this.$position);
        Intrinsics.checkExpressionValueIsNotNull(obj2, "itemList.get(position)");
        access$getOnItemClickListener$p2.onPopularCategoryItemClick((RefinerX) obj2, true);
    }
}
