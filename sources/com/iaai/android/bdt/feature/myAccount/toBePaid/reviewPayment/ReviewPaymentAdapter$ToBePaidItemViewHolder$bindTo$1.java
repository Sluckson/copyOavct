package com.iaai.android.bdt.feature.myAccount.toBePaid.reviewPayment;

import android.view.View;
import com.iaai.android.bdt.feature.myAccount.toBePaid.reviewPayment.ReviewPaymentAdapter;
import com.iaai.android.bdt.model.toBePaid.paymentDueList.PaymentDue;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: ReviewPaymentAdapter.kt */
final class ReviewPaymentAdapter$ToBePaidItemViewHolder$bindTo$1 implements View.OnClickListener {
    final /* synthetic */ PaymentDue $tobePaid;
    final /* synthetic */ ReviewPaymentAdapter.ToBePaidItemViewHolder this$0;

    ReviewPaymentAdapter$ToBePaidItemViewHolder$bindTo$1(ReviewPaymentAdapter.ToBePaidItemViewHolder toBePaidItemViewHolder, PaymentDue paymentDue) {
        this.this$0 = toBePaidItemViewHolder;
        this.$tobePaid = paymentDue;
    }

    public final void onClick(View view) {
        ReviewPaymentAdapter.OnClickListener onClickListener = this.this$0.this$0.getOnClickListener();
        List<PaymentDue> selectedItemsList = this.this$0.this$0.getSelectedItemsList();
        onClickListener.onRemoveClicked(selectedItemsList != null ? selectedItemsList.indexOf(this.$tobePaid) : 0);
    }
}
