package com.iaai.android.bdt.feature.productDetail;

import android.view.View;
import android.widget.TextView;
import com.iaai.android.bdt.feature.productDetail.ConditionInfoAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: ConditionInfoAdapter.kt */
final class ConditionInfoAdapter$onCreateViewHolder$1 implements View.OnClickListener {
    final /* synthetic */ ConditionInfoAdapter.ViewHolder $holder;
    final /* synthetic */ ConditionInfoAdapter this$0;

    ConditionInfoAdapter$onCreateViewHolder$1(ConditionInfoAdapter conditionInfoAdapter, ConditionInfoAdapter.ViewHolder viewHolder) {
        this.this$0 = conditionInfoAdapter;
        this.$holder = viewHolder;
    }

    public final void onClick(View view) {
        TextView textView = this.$holder.getBinding().tvLabelCondition;
        Intrinsics.checkExpressionValueIsNotNull(textView, "holder.binding.tvLabelCondition");
        if (StringsKt.equals(textView.getText().toString(), "Start Code:", true)) {
            ProductDetailInfoListener productDetailInfoListener = this.this$0.getProductDetailInfoListener();
            Intrinsics.checkExpressionValueIsNotNull(view, "it");
            productDetailInfoListener.onEngineVideoClick(view);
            return;
        }
        TextView textView2 = this.$holder.getBinding().tvLabelCondition;
        Intrinsics.checkExpressionValueIsNotNull(textView2, "holder.binding.tvLabelCondition");
        if (StringsKt.equals(textView2.getText().toString(), "Key/Fob:", true)) {
            ProductDetailInfoListener productDetailInfoListener2 = this.this$0.getProductDetailInfoListener();
            Intrinsics.checkExpressionValueIsNotNull(view, "it");
            productDetailInfoListener2.onKeyFobClick(view);
        }
    }
}
