package com.iaai.android.bdt.feature.auctionMainPage;

import android.view.View;
import com.iaai.android.bdt.feature.auctionMainPage.BDTAuctionMainListAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: BDTAuctionMainListAdapter.kt */
final class BDTAuctionMainListAdapter$onCreateViewHolder$2 implements View.OnClickListener {
    final /* synthetic */ BDTAuctionMainListAdapter.ViewHolder $holder;
    final /* synthetic */ BDTAuctionMainListAdapter this$0;

    BDTAuctionMainListAdapter$onCreateViewHolder$2(BDTAuctionMainListAdapter bDTAuctionMainListAdapter, BDTAuctionMainListAdapter.ViewHolder viewHolder) {
        this.this$0 = bDTAuctionMainListAdapter;
        this.$holder = viewHolder;
    }

    public final void onClick(View view) {
        AuctionItemClickListener listener = this.this$0.getListener();
        Intrinsics.checkExpressionValueIsNotNull(view, "it");
        listener.onAuctionViewListClick(view, this.this$0.getItem(this.$holder.getAdapterPosition()));
    }
}
