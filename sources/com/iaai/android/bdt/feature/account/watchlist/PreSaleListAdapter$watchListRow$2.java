package com.iaai.android.bdt.feature.account.watchlist;

import android.text.Layout;
import android.view.ViewTreeObserver;
import com.iaai.android.databinding.ItemAuctionSalesListBinding;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo66933d2 = {"<anonymous>", "", "onPreDraw"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: PreSaleListAdapter.kt */
final class PreSaleListAdapter$watchListRow$2 implements ViewTreeObserver.OnPreDrawListener {
    final /* synthetic */ ItemAuctionSalesListBinding $binding;
    final /* synthetic */ PreSaleListAdapter this$0;

    PreSaleListAdapter$watchListRow$2(PreSaleListAdapter preSaleListAdapter, ItemAuctionSalesListBinding itemAuctionSalesListBinding) {
        this.this$0 = preSaleListAdapter;
        this.$binding = itemAuctionSalesListBinding;
    }

    public final boolean onPreDraw() {
        int lineCount;
        Layout layout = this.$binding.tvRunDrive.getLayout();
        if (layout != null && (lineCount = layout.getLineCount()) > 0 && layout.getEllipsisCount(lineCount - 1) > 0) {
            this.this$0.isRunDriveTruncate = true;
            PreSaleListAdapter preSaleListAdapter = this.this$0;
            preSaleListAdapter.handleBadgeAlignment(this.$binding, preSaleListAdapter.isPublicTruncate, this.this$0.isRunDriveTruncate, this.this$0.isOffsiteTruncate);
        }
        return true;
    }
}
