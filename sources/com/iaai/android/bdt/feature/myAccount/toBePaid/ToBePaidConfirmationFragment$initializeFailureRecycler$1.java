package com.iaai.android.bdt.feature.myAccount.toBePaid;

import android.view.View;
import android.widget.TextView;
import com.iaai.android.C2723R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: ToBePaidConfirmationFragment.kt */
final class ToBePaidConfirmationFragment$initializeFailureRecycler$1 implements View.OnClickListener {
    final /* synthetic */ ConfirmPaymentAdapter $failurePaymentAdapter;
    final /* synthetic */ ToBePaidConfirmationFragment this$0;

    ToBePaidConfirmationFragment$initializeFailureRecycler$1(ToBePaidConfirmationFragment toBePaidConfirmationFragment, ConfirmPaymentAdapter confirmPaymentAdapter) {
        this.this$0 = toBePaidConfirmationFragment;
        this.$failurePaymentAdapter = confirmPaymentAdapter;
    }

    public final void onClick(View view) {
        ToBePaidConfirmationFragment toBePaidConfirmationFragment = this.this$0;
        toBePaidConfirmationFragment.isViewAllSelectedFailure = !toBePaidConfirmationFragment.isViewAllSelectedFailure;
        if (this.this$0.isViewAllSelectedFailure) {
            TextView textView = (TextView) this.this$0._$_findCachedViewById(C2723R.C2726id.tvViewAllFailure);
            Intrinsics.checkExpressionValueIsNotNull(textView, "tvViewAllFailure");
            textView.setText(this.this$0.getResources().getString(C2723R.string.lbl_view_less));
            ((TextView) this.this$0._$_findCachedViewById(C2723R.C2726id.tvViewAllFailure)).setCompoundDrawablesWithIntrinsicBounds(0, 0, C2723R.C2725drawable.ic_view_up, 0);
        } else {
            TextView textView2 = (TextView) this.this$0._$_findCachedViewById(C2723R.C2726id.tvViewAllFailure);
            Intrinsics.checkExpressionValueIsNotNull(textView2, "tvViewAllFailure");
            textView2.setText(this.this$0.getResources().getString(C2723R.string.lbl_view_all));
            ((TextView) this.this$0._$_findCachedViewById(C2723R.C2726id.tvViewAllFailure)).setCompoundDrawablesWithIntrinsicBounds(0, 0, C2723R.C2725drawable.ic_view_down, 0);
        }
        this.$failurePaymentAdapter.shouldDisplayAll(this.this$0.isViewAllSelectedFailure);
    }
}
