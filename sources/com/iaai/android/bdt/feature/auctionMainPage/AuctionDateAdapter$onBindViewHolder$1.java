package com.iaai.android.bdt.feature.auctionMainPage;

import android.view.View;
import com.iaai.android.bdt.feature.auctionMainPage.AuctionDateAdapter;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: AuctionDateAdapter.kt */
final class AuctionDateAdapter$onBindViewHolder$1 implements View.OnClickListener {
    final /* synthetic */ AuctionDateAdapter.ViewHolder $holder;
    final /* synthetic */ AuctionDateAdapter this$0;

    AuctionDateAdapter$onBindViewHolder$1(AuctionDateAdapter auctionDateAdapter, AuctionDateAdapter.ViewHolder viewHolder) {
        this.this$0 = auctionDateAdapter;
        this.$holder = viewHolder;
    }

    public final void onClick(View view) {
        this.$holder.updateUIForSelection();
        AuctionDateAdapter auctionDateAdapter = this.this$0;
        auctionDateAdapter.notifyItemChanged(auctionDateAdapter.getSelected_position());
        this.this$0.setSelected_position(this.$holder.getAdapterPosition());
        AuctionDateAdapter auctionDateAdapter2 = this.this$0;
        auctionDateAdapter2.notifyItemChanged(auctionDateAdapter2.getSelected_position());
        AuctionDateAdapter.access$getOnItemClickListener$p(this.this$0).onItemClick(AuctionDateAdapter.access$getAuctionDateItemList$p(this.this$0)[this.this$0.getSelected_position()], this.this$0.getSelected_position());
    }
}
