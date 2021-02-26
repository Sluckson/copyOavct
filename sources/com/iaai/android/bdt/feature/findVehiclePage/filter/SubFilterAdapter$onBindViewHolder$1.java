package com.iaai.android.bdt.feature.findVehiclePage.filter;

import android.view.View;
import com.iaai.android.bdt.feature.findVehiclePage.filter.SubFilterAdapter;
import com.iaai.android.bdt.model.filter.FilterValues;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: SubFilterAdapter.kt */
final class SubFilterAdapter$onBindViewHolder$1 implements View.OnClickListener {
    final /* synthetic */ SubFilterAdapter.ViewHolder $holder;
    final /* synthetic */ SubFilterAdapter this$0;

    SubFilterAdapter$onBindViewHolder$1(SubFilterAdapter subFilterAdapter, SubFilterAdapter.ViewHolder viewHolder) {
        this.this$0 = subFilterAdapter;
        this.$holder = viewHolder;
    }

    public final void onClick(View view) {
        SubFilterAdapter subFilterAdapter = this.this$0;
        subFilterAdapter.notifyItemChanged(subFilterAdapter.getSelectedPosition());
        this.this$0.setSelectedPosition(this.$holder.getAdapterPosition());
        SubFilterAdapter subFilterAdapter2 = this.this$0;
        subFilterAdapter2.notifyItemChanged(subFilterAdapter2.getSelectedPosition());
        SubFilterAdapter.access$getOnItemClickListener$p(this.this$0).onItemClick((FilterValues) SubFilterAdapter.access$getFilterValues$p(this.this$0).get(this.this$0.getSelectedPosition()), this.this$0.getSelectedPosition());
    }
}
