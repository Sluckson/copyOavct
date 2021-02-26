package com.iaai.android.bdt.feature.auctionSalesList;

import android.view.View;
import com.iaai.android.bdt.feature.auctionSalesList.ClearFilterAdapter;
import com.iaai.android.bdt.model.auctionSalesList.ClearFilter;
import kotlin.Metadata;
import kotlin.text.StringsKt;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: ClearFilterAdapter.kt */
final class ClearFilterAdapter$ViewHolder$bindLaneInfo$1 implements View.OnClickListener {
    final /* synthetic */ ClearFilterAdapter.ViewHolder this$0;

    ClearFilterAdapter$ViewHolder$bindLaneInfo$1(ClearFilterAdapter.ViewHolder viewHolder) {
        this.this$0 = viewHolder;
    }

    public final void onClick(View view) {
        if (StringsKt.equals(((ClearFilter) this.this$0.this$0.clearFilterList.get(this.this$0.getAdapterPosition())).getFilterValue(), "Year", false)) {
            this.this$0.this$0.clearFilterList.remove(this.this$0.getAdapterPosition());
            ClearFilterAdapter.access$getOnItemClickListener$p(this.this$0.this$0).onFilterYearCancelClick();
        } else if (StringsKt.equals(((ClearFilter) this.this$0.this$0.clearFilterList.get(this.this$0.getAdapterPosition())).getFilterValue(), "Lane", false)) {
            this.this$0.this$0.clearFilterList.remove(this.this$0.getAdapterPosition());
            ClearFilterAdapter.access$getOnItemClickListener$p(this.this$0.this$0).onFilterLaneCancelClick();
        } else if (StringsKt.equals(((ClearFilter) this.this$0.this$0.clearFilterList.get(this.this$0.getAdapterPosition())).getFilterValue(), "LossType", false)) {
            this.this$0.this$0.clearFilterList.remove(this.this$0.getAdapterPosition());
            ClearFilterAdapter.access$getOnItemClickListener$p(this.this$0.this$0).onFilterLossTypeCancelClick();
        }
        this.this$0.this$0.notifyDataSetChanged();
    }
}
