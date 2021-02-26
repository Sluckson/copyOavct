package com.iaai.android.bdt.feature.digitalNegotiation;

import android.view.View;
import com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferFilterAdapter;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: ManageOfferFilterAdapter.kt */
final class ManageOfferFilterAdapter$onBindViewHolder$1 implements View.OnClickListener {
    final /* synthetic */ ManageOfferFilterAdapter.ViewHolder $holder;
    final /* synthetic */ ManageOfferFilterAdapter this$0;

    ManageOfferFilterAdapter$onBindViewHolder$1(ManageOfferFilterAdapter manageOfferFilterAdapter, ManageOfferFilterAdapter.ViewHolder viewHolder) {
        this.this$0 = manageOfferFilterAdapter;
        this.$holder = viewHolder;
    }

    public final void onClick(View view) {
        ManageOfferFilterAdapter manageOfferFilterAdapter = this.this$0;
        manageOfferFilterAdapter.notifyItemChanged(manageOfferFilterAdapter.getSelectedPos());
        this.this$0.setSelectedPos(this.$holder.getAdapterPosition());
        ManageOfferFilterAdapter manageOfferFilterAdapter2 = this.this$0;
        manageOfferFilterAdapter2.notifyItemChanged(manageOfferFilterAdapter2.getSelectedPos());
        ManageOfferFilterAdapter.access$getOnItemClickListener$p(this.this$0).onItemClick(this.this$0.filterList[this.this$0.getSelectedPos()], this.$holder.getAdapterPosition());
    }
}
