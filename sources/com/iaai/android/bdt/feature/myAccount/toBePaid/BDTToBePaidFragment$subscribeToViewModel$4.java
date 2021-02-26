package com.iaai.android.bdt.feature.myAccount.toBePaid;

import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.model.toBePaid.paymentDueList.PaymentDueListResponse;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "response", "Lcom/iaai/android/bdt/model/toBePaid/paymentDueList/PaymentDueListResponse;", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: BDTToBePaidFragment.kt */
final class BDTToBePaidFragment$subscribeToViewModel$4<T> implements Observer<PaymentDueListResponse> {
    final /* synthetic */ BDTToBePaidFragment this$0;

    BDTToBePaidFragment$subscribeToViewModel$4(BDTToBePaidFragment bDTToBePaidFragment) {
        this.this$0 = bDTToBePaidFragment;
    }

    public final void onChanged(PaymentDueListResponse paymentDueListResponse) {
        BDTToBePaidFragment bDTToBePaidFragment = this.this$0;
        Integer itemsCount = paymentDueListResponse.getPaymentDueModel().getItemsCount();
        bDTToBePaidFragment.totalItemCount = itemsCount != null ? itemsCount.intValue() : 0;
        this.this$0.totalDueAmount = String.valueOf(paymentDueListResponse.getPaymentDueModel().getTotalDueAmount());
        if (this.this$0.totalItemCount > 0) {
            TextView toolbar_title = BDTToBePaidFragment.access$getBdtPaymentActivity$p(this.this$0).getToolbar_title();
            toolbar_title.setText(this.this$0.getResources().getString(C2723R.string.lbl_to_be_paid) + " (" + this.this$0.totalItemCount + ')');
        }
    }
}
