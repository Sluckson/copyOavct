package com.iaai.android.bdt.feature.myAccount.toBePaid;

import android.view.View;
import android.widget.TextView;
import com.iaai.android.C2723R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: ToBePaidConfirmationFragment.kt */
final class ToBePaidConfirmationFragment$initializeSuccessRecycler$1 implements View.OnClickListener {
    final /* synthetic */ ConfirmPaymentAdapter $successPaymentAdapter;
    final /* synthetic */ ToBePaidConfirmationFragment this$0;

    ToBePaidConfirmationFragment$initializeSuccessRecycler$1(ToBePaidConfirmationFragment toBePaidConfirmationFragment, ConfirmPaymentAdapter confirmPaymentAdapter) {
        this.this$0 = toBePaidConfirmationFragment;
        this.$successPaymentAdapter = confirmPaymentAdapter;
    }

    public final void onClick(View view) {
        ToBePaidConfirmationFragment toBePaidConfirmationFragment = this.this$0;
        toBePaidConfirmationFragment.isViewAllSelectedSuccess = !toBePaidConfirmationFragment.isViewAllSelectedSuccess;
        if (this.this$0.isViewAllSelectedSuccess) {
            TextView textView = (TextView) this.this$0._$_findCachedViewById(C2723R.C2726id.tvViewAll);
            Intrinsics.checkExpressionValueIsNotNull(textView, "tvViewAll");
            textView.setText(this.this$0.getResources().getString(C2723R.string.lbl_view_less));
            ((TextView) this.this$0._$_findCachedViewById(C2723R.C2726id.tvViewAll)).setCompoundDrawablesWithIntrinsicBounds(0, 0, C2723R.C2725drawable.ic_view_up, 0);
        } else {
            TextView textView2 = (TextView) this.this$0._$_findCachedViewById(C2723R.C2726id.tvViewAll);
            Intrinsics.checkExpressionValueIsNotNull(textView2, "tvViewAll");
            textView2.setText(this.this$0.getResources().getString(C2723R.string.lbl_view_all));
            ((TextView) this.this$0._$_findCachedViewById(C2723R.C2726id.tvViewAll)).setCompoundDrawablesWithIntrinsicBounds(0, 0, C2723R.C2725drawable.ic_view_down, 0);
        }
        this.$successPaymentAdapter.shouldDisplayAll(this.this$0.isViewAllSelectedSuccess);
    }
}
