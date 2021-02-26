package com.iaai.android.bdt.feature.myAccount.toBePaid;

import android.content.Intent;
import android.view.View;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.old.activities.ToBePaidSelectionActivity;
import com.iaai.android.old.utils.constants.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: BDTPaymentMethodActivity.kt */
final class BDTPaymentMethodActivity$initializeButtonUI$1 implements View.OnClickListener {
    final /* synthetic */ BDTPaymentMethodActivity this$0;

    BDTPaymentMethodActivity$initializeButtonUI$1(BDTPaymentMethodActivity bDTPaymentMethodActivity) {
        this.this$0 = bDTPaymentMethodActivity;
    }

    public final void onClick(View view) {
        if (this.this$0.selectedPaymentMethod != null) {
            this.this$0.getSharedPrefsHelper().put(Constants_MVVM.KEY_LAST_USED_PAYMENT_METHOD, BDTPaymentMethodActivity.access$getSelectedPaymentMethod$p(this.this$0).getPaymentMethodType().getValue());
            String value = BDTPaymentMethodActivity.access$getSelectedPaymentMethod$p(this.this$0).getPaymentMethodType().getValue();
            if (Intrinsics.areEqual((Object) value, (Object) Constants_MVVM.PaymentMethod.ACH.getValue())) {
                Intent intent = new Intent(this.this$0, ToBePaidSelectionActivity.class);
                intent.putExtra(Constants.EXTRA_PAYMENT_OPTION, BDTPaymentMethodActivity.access$getSelectedPaymentMethod$p(this.this$0).getPaymentMethodType().getValue());
                intent.putExtra(Constants.EXTRA_TOBPAID_MY_VEHICLES_ONLY, this.this$0.isMyItemOnlyString);
                intent.putExtra(Constants.MY_VEHICLES_ONLY_ARG, this.this$0.isMyItemOnlyString);
                intent.putExtra(Constants.SORTING_OPTION_SELECTION, this.this$0.selectedSort);
                intent.putExtra(Constants.BRANCH_FILTER_SELECTION, this.this$0.branchSelected);
                this.this$0.startActivity(intent);
            } else if (Intrinsics.areEqual((Object) value, (Object) Constants_MVVM.PaymentMethod.AFC.getValue())) {
                Intent intent2 = new Intent(this.this$0, ToBePaidSelectionActivity.class);
                intent2.putExtra(Constants.EXTRA_PAYMENT_OPTION, BDTPaymentMethodActivity.access$getSelectedPaymentMethod$p(this.this$0).getPaymentMethodType().getValue());
                intent2.putExtra(Constants.EXTRA_TOBPAID_MY_VEHICLES_ONLY, this.this$0.isMyItemOnlyString);
                intent2.putExtra(Constants.MY_VEHICLES_ONLY_ARG, this.this$0.isMyItemOnlyString);
                intent2.putExtra(Constants.SORTING_OPTION_SELECTION, this.this$0.selectedSort);
                intent2.putExtra(Constants.BRANCH_FILTER_SELECTION, this.this$0.branchSelected);
                this.this$0.startActivity(intent2);
            } else if (Intrinsics.areEqual((Object) value, (Object) Constants_MVVM.PaymentMethod.PAY_PAL.getValue())) {
                Intent intent3 = new Intent(this.this$0, BDTPaymentActivity.class);
                intent3.putExtra(Constants_MVVM.EXTRA_PAYMENT_METHOD, BDTPaymentMethodActivity.access$getSelectedPaymentMethod$p(this.this$0).getPaymentMethodType().getValue());
                intent3.putExtra(Constants_MVVM.EXTRA_TOBPAID_MY_VEHICLES_ONLY, this.this$0.isMyItemOnlyString);
                intent3.putExtra(Constants_MVVM.EXTRA_PAYMENT_PAYPAL_REQUEST, BDTPaymentMethodActivity.access$getPayPalPaymentRequest$p(this.this$0));
                intent3.putExtra(Constants_MVVM.EXTRA_PAYMENT_PAYPAL_ACCOUNT_DETAIL_ID, this.this$0.payPalAccountDetailID);
                this.this$0.startActivityForResult(intent3, 105);
            } else if (Intrinsics.areEqual((Object) value, (Object) Constants_MVVM.PaymentMethod.CREDIT_CARD.getValue())) {
                Intent intent4 = new Intent(this.this$0, BDTPaymentActivity.class);
                intent4.putExtra(Constants_MVVM.EXTRA_PAYMENT_METHOD, BDTPaymentMethodActivity.access$getSelectedPaymentMethod$p(this.this$0).getPaymentMethodType().getValue());
                this.this$0.startActivityForResult(intent4, 105);
            }
        }
    }
}
