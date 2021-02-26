package com.iaai.android.bdt.feature.myAccount.toBePaid.creditCard;

import android.view.View;
import com.iaai.android.bdt.feature.myAccount.toBePaid.creditCard.CreditCardAdapter;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: CreditCardAdapter.kt */
final class CreditCardAdapter$onBindViewHolder$1 implements View.OnClickListener {
    final /* synthetic */ CreditCardAdapter.ViewHolder $holder;
    final /* synthetic */ CreditCardAdapter this$0;

    CreditCardAdapter$onBindViewHolder$1(CreditCardAdapter creditCardAdapter, CreditCardAdapter.ViewHolder viewHolder) {
        this.this$0 = creditCardAdapter;
        this.$holder = viewHolder;
    }

    public final void onClick(View view) {
        CreditCardAdapter creditCardAdapter = this.this$0;
        creditCardAdapter.notifyItemChanged(creditCardAdapter.getSelectedPosition());
        this.this$0.setSelectedPosition(this.$holder.getAdapterPosition());
        CreditCardAdapter creditCardAdapter2 = this.this$0;
        creditCardAdapter2.notifyItemChanged(creditCardAdapter2.getSelectedPosition());
        this.this$0.cardSelectedListener.onCardSelected((DummyCard) CreditCardAdapter.access$getCardList$p(this.this$0).get(this.this$0.getSelectedPosition()), this.this$0.getSelectedPosition());
    }
}
