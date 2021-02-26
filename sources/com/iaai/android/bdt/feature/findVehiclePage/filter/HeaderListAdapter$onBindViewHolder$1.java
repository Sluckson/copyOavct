package com.iaai.android.bdt.feature.findVehiclePage.filter;

import android.view.View;
import com.iaai.android.bdt.feature.findVehiclePage.filter.HeaderListAdapter;
import com.iaai.android.bdt.model.fastSearch.SelectedRefinerV2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: HeaderListAdapter.kt */
final class HeaderListAdapter$onBindViewHolder$1 implements View.OnClickListener {
    final /* synthetic */ int $position;
    final /* synthetic */ HeaderListAdapter this$0;

    HeaderListAdapter$onBindViewHolder$1(HeaderListAdapter headerListAdapter, int i) {
        this.this$0 = headerListAdapter;
        this.$position = i;
    }

    public final void onClick(View view) {
        HeaderListAdapter.OnHeaderItemClickListener access$getOnHeaderItemClickListener$p = HeaderListAdapter.access$getOnHeaderItemClickListener$p(this.this$0);
        Object obj = HeaderListAdapter.access$getItemList$p(this.this$0).get(this.$position);
        Intrinsics.checkExpressionValueIsNotNull(obj, "itemList[position]");
        access$getOnHeaderItemClickListener$p.onItemClick((SelectedRefinerV2) obj, this.$position);
    }
}
