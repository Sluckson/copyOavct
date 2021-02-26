package com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList;

import android.view.View;
import android.widget.TextView;
import com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList.DeliveryInstructionAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: DeliveryInstructionAdapter.kt */
final class DeliveryInstructionAdapter$HeaderViewHolder$bindTo$1 implements View.OnClickListener {
    final /* synthetic */ DeliveryInstructionAdapter.HeaderViewHolder this$0;

    DeliveryInstructionAdapter$HeaderViewHolder$bindTo$1(DeliveryInstructionAdapter.HeaderViewHolder headerViewHolder) {
        this.this$0 = headerViewHolder;
    }

    public final void onClick(View view) {
        TextView textView = this.this$0.binding.tvSetForAll;
        Intrinsics.checkExpressionValueIsNotNull(textView, "binding.tvSetForAll");
        TextView textView2 = this.this$0.binding.tvSetForAll;
        Intrinsics.checkExpressionValueIsNotNull(textView2, "binding.tvSetForAll");
        textView.setSelected(!textView2.isSelected());
        DeliveryInstructionAdapter deliveryInstructionAdapter = this.this$0.this$0;
        TextView textView3 = this.this$0.binding.tvSetForAll;
        Intrinsics.checkExpressionValueIsNotNull(textView3, "binding.tvSetForAll");
        deliveryInstructionAdapter.setAllSelected(textView3.isSelected());
        this.this$0.this$0.getOnClickListener().onSelectAllClicked(this.this$0.this$0.isAllSelected());
    }
}
