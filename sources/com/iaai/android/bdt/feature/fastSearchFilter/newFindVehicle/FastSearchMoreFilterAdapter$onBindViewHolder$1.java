package com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle;

import android.view.View;
import com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.FastSearchMoreFilterAdapter;
import com.iaai.android.bdt.model.fastSearchFilter2.FacetXX;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: FastSearchMoreFilterAdapter.kt */
final class FastSearchMoreFilterAdapter$onBindViewHolder$1 implements View.OnClickListener {
    final /* synthetic */ FastSearchMoreFilterAdapter.BaseViewHolder $holder;
    final /* synthetic */ FastSearchMoreFilterAdapter this$0;

    FastSearchMoreFilterAdapter$onBindViewHolder$1(FastSearchMoreFilterAdapter fastSearchMoreFilterAdapter, FastSearchMoreFilterAdapter.BaseViewHolder baseViewHolder) {
        this.this$0 = fastSearchMoreFilterAdapter;
        this.$holder = baseViewHolder;
    }

    public final void onClick(View view) {
        ((FacetXX) this.this$0.facetxxList.get(this.$holder.getAdapterPosition())).setSelected(!((FacetXX) this.this$0.facetxxList.get(this.$holder.getAdapterPosition())).isSelected());
        this.this$0.notifyItemChanged(this.$holder.getAdapterPosition());
        FastSearchMoreFilterAdapter.access$getOnItemClickListener$p(this.this$0).onItemClick((FacetXX) this.this$0.facetxxList.get(this.$holder.getAdapterPosition()), false);
    }
}
