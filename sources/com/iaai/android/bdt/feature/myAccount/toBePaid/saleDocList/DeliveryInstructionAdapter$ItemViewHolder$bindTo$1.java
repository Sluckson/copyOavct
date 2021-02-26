package com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList;

import android.view.View;
import com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList.DeliveryInstructionAdapter;
import com.iaai.android.bdt.model.toBePaid.saleDocument.defaultResponse.TitleInstructionItem;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: DeliveryInstructionAdapter.kt */
final class DeliveryInstructionAdapter$ItemViewHolder$bindTo$1 implements View.OnClickListener {
    final /* synthetic */ int $position;
    final /* synthetic */ DeliveryInstructionAdapter.ItemViewHolder this$0;

    DeliveryInstructionAdapter$ItemViewHolder$bindTo$1(DeliveryInstructionAdapter.ItemViewHolder itemViewHolder, int i) {
        this.this$0 = itemViewHolder;
        this.$position = i;
    }

    public final void onClick(View view) {
        ((TitleInstructionItem) this.this$0.this$0.itemsList.get(this.$position - 1)).setSelected(!((TitleInstructionItem) this.this$0.this$0.itemsList.get(this.$position - 1)).isSelected());
        this.this$0.this$0.setSelectedPosition(this.$position);
        this.this$0.this$0.notifyItemChanged(this.this$0.this$0.getSelectedPosition());
        this.this$0.this$0.getOnClickListener().onSingleStockClicked(new ArrayList(this.this$0.this$0.itemsList));
    }
}
