package com.iaai.android.bdt.feature.account.watchlist;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: PreSaleListAdapter.kt */
final class PreSaleListAdapter$onCreateViewHolder$5 implements View.OnClickListener {
    final /* synthetic */ Ref.ObjectRef $holder;
    final /* synthetic */ PreSaleListAdapter this$0;

    PreSaleListAdapter$onCreateViewHolder$5(PreSaleListAdapter preSaleListAdapter, Ref.ObjectRef objectRef) {
        this.this$0 = preSaleListAdapter;
        this.$holder = objectRef;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0021, code lost:
        r1 = r1.getItemid();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onClick(android.view.View r5) {
        /*
            r4 = this;
            com.iaai.android.bdt.feature.account.watchlist.PreSaleListAdapter r0 = r4.this$0
            com.iaai.android.bdt.utils.CustomItemClickListener r0 = r0.getListener()
            java.lang.String r1 = "it"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r5, r1)
            com.iaai.android.bdt.feature.account.watchlist.PreSaleListAdapter r1 = r4.this$0
            kotlin.jvm.internal.Ref$ObjectRef r2 = r4.$holder
            T r2 = r2.element
            androidx.recyclerview.widget.RecyclerView$ViewHolder r2 = (androidx.recyclerview.widget.RecyclerView.ViewHolder) r2
            com.iaai.android.bdt.feature.account.watchlist.PreSaleListAdapter$ResultDataItemViewHolder r2 = (com.iaai.android.bdt.feature.account.watchlist.PreSaleListAdapter.ResultDataItemViewHolder) r2
            int r2 = r2.getAdapterPosition()
            int r2 = r2 + -1
            com.iaai.android.bdt.model.MyAccount.WatchListModel r1 = com.iaai.android.bdt.feature.account.watchlist.PreSaleListAdapter.access$getItem(r1, r2)
            if (r1 == 0) goto L_0x002c
            java.lang.String r1 = r1.getItemid()
            if (r1 == 0) goto L_0x002c
            long r1 = java.lang.Long.parseLong(r1)
            goto L_0x002e
        L_0x002c:
            r1 = 0
        L_0x002e:
            kotlin.jvm.internal.Ref$ObjectRef r3 = r4.$holder
            T r3 = r3.element
            androidx.recyclerview.widget.RecyclerView$ViewHolder r3 = (androidx.recyclerview.widget.RecyclerView.ViewHolder) r3
            com.iaai.android.bdt.feature.account.watchlist.PreSaleListAdapter$ResultDataItemViewHolder r3 = (com.iaai.android.bdt.feature.account.watchlist.PreSaleListAdapter.ResultDataItemViewHolder) r3
            int r3 = r3.getAdapterPosition()
            int r3 = r3 + -1
            r0.onUnWatchItemClick(r5, r1, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.feature.account.watchlist.PreSaleListAdapter$onCreateViewHolder$5.onClick(android.view.View):void");
    }
}