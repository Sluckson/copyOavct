package com.iaai.android.bdt.feature.auctionSalesList;

import android.view.View;
import com.iaai.android.bdt.feature.auctionSalesList.LaneAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: LaneAdapter.kt */
final class LaneAdapter$onBindViewHolder$1 implements View.OnClickListener {
    final /* synthetic */ LaneAdapter.ViewHolder $holder;
    final /* synthetic */ LaneAdapter this$0;

    LaneAdapter$onBindViewHolder$1(LaneAdapter laneAdapter, LaneAdapter.ViewHolder viewHolder) {
        this.this$0 = laneAdapter;
        this.$holder = viewHolder;
    }

    public final void onClick(View view) {
        String str;
        LaneAdapter laneAdapter = this.this$0;
        laneAdapter.notifyItemChanged(laneAdapter.getSelected_position());
        this.this$0.setSelected_position(this.$holder.getAdapterPosition());
        LaneAdapter laneAdapter2 = this.this$0;
        laneAdapter2.notifyItemChanged(laneAdapter2.getSelected_position());
        LaneAdapter.OnItemClickListener onItemClickListener = this.this$0.getOnItemClickListener();
        int adapterPosition = this.$holder.getAdapterPosition();
        if (this.this$0.getSelected_position() == 0) {
            str = "";
        } else {
            Object obj = this.this$0.scopeList.get(this.this$0.getSelected_position());
            Intrinsics.checkExpressionValueIsNotNull(obj, "scopeList[selected_position]");
            str = (String) obj;
        }
        onItemClickListener.OnItemSelected(adapterPosition, str);
    }
}
