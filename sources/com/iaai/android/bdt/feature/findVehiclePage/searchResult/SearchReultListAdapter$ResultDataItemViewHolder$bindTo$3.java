package com.iaai.android.bdt.feature.findVehiclePage.searchResult;

import android.text.Layout;
import android.view.ViewTreeObserver;
import com.iaai.android.bdt.feature.findVehiclePage.searchResult.SearchReultListAdapter;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo66933d2 = {"<anonymous>", "", "onPreDraw"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: SearchResultListAdapter.kt */
final class SearchReultListAdapter$ResultDataItemViewHolder$bindTo$3 implements ViewTreeObserver.OnPreDrawListener {
    final /* synthetic */ SearchReultListAdapter.ResultDataItemViewHolder this$0;

    SearchReultListAdapter$ResultDataItemViewHolder$bindTo$3(SearchReultListAdapter.ResultDataItemViewHolder resultDataItemViewHolder) {
        this.this$0 = resultDataItemViewHolder;
    }

    public final boolean onPreDraw() {
        int lineCount;
        Layout layout = this.this$0.binding.tvOffsite.getLayout();
        if (layout != null && (lineCount = layout.getLineCount()) > 0 && layout.getEllipsisCount(lineCount - 1) > 0) {
            this.this$0.this$0.isOffsiteTruncate = true;
            SearchReultListAdapter.ResultDataItemViewHolder resultDataItemViewHolder = this.this$0;
            resultDataItemViewHolder.handleBadgeAlignment(resultDataItemViewHolder.binding, this.this$0.this$0.isPublicTruncate, this.this$0.this$0.isRunDriveTruncate, this.this$0.this$0.isOffsiteTruncate);
        }
        return true;
    }
}
