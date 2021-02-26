package com.iaai.android.bdt.feature.auctionSalesList;

import android.view.View;
import com.iaai.android.bdt.feature.auctionSalesList.SortAdapter;
import com.iaai.android.bdt.model.sort.SortOptionData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: SortAdapter.kt */
final class SortAdapter$onBindViewHolder$1 implements View.OnClickListener {
    final /* synthetic */ SortAdapter.BaseViewHolder $holder;
    final /* synthetic */ SortAdapter this$0;

    SortAdapter$onBindViewHolder$1(SortAdapter sortAdapter, SortAdapter.BaseViewHolder baseViewHolder) {
        this.this$0 = sortAdapter;
        this.$holder = baseViewHolder;
    }

    public final void onClick(View view) {
        this.this$0.notifyItemChanged(this.$holder.getAdapterPosition());
        ((SortOptionData) this.this$0.sortItemList.get(this.$holder.getAdapterPosition())).setSelected(true);
        this.this$0.notifyItemChanged(this.$holder.getAdapterPosition());
        SortAdapter.OnItemClickListener access$getOnItemClickListener$p = SortAdapter.access$getOnItemClickListener$p(this.this$0);
        Object obj = this.this$0.sortItemList.get(this.$holder.getAdapterPosition());
        Intrinsics.checkExpressionValueIsNotNull(obj, "sortItemList[holder.adapterPosition]");
        access$getOnItemClickListener$p.onItemClick((SortOptionData) obj, this.$holder.getAdapterPosition());
    }
}
