package com.iaai.android.bdt.feature.myAccount.toBePaid.reviewPayment;

import com.iaai.android.bdt.feature.myAccount.toBePaid.reviewPayment.ReviewPaymentAdapter;
import com.iaai.android.bdt.model.toBePaid.paymentDueList.PaymentDue;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, mo66933d2 = {"com/iaai/android/bdt/feature/myAccount/toBePaid/reviewPayment/ToBePaidReviewFragment$initializeRecycler$1", "Lcom/iaai/android/bdt/feature/myAccount/toBePaid/reviewPayment/ReviewPaymentAdapter$OnClickListener;", "onChangePaymentClicked", "", "onRemoveClicked", "position", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: ToBePaidReviewFragment.kt */
public final class ToBePaidReviewFragment$initializeRecycler$1 implements ReviewPaymentAdapter.OnClickListener {
    final /* synthetic */ ToBePaidReviewFragment this$0;

    ToBePaidReviewFragment$initializeRecycler$1(ToBePaidReviewFragment toBePaidReviewFragment) {
        this.this$0 = toBePaidReviewFragment;
    }

    public void onChangePaymentClicked() {
        ToBePaidReviewFragment.access$getBdtPaymentActivity$p(this.this$0).finish();
    }

    public void onRemoveClicked(int i) {
        List access$getSelectedItemsList$p = this.this$0.getSelectedItemsList();
        if (access$getSelectedItemsList$p != null) {
            PaymentDue paymentDue = (PaymentDue) access$getSelectedItemsList$p.remove(i);
        }
        this.this$0.getTotalAmountDue();
        this.this$0.updateUI();
        ReviewPaymentAdapter access$getReviewPaymentAdapter$p = ToBePaidReviewFragment.access$getReviewPaymentAdapter$p(this.this$0);
        List access$getSelectedItemsList$p2 = this.this$0.getSelectedItemsList();
        if (access$getSelectedItemsList$p2 == null) {
            access$getSelectedItemsList$p2 = CollectionsKt.emptyList();
        }
        access$getReviewPaymentAdapter$p.setItemsList(access$getSelectedItemsList$p2);
        ToBePaidReviewFragment.access$getReviewPaymentAdapter$p(this.this$0).notifyDataSetChanged();
    }
}
