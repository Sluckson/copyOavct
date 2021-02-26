package com.iaai.android.bdt.feature.myAccount.toBePaid.creditCard;

import android.os.Bundle;
import android.view.View;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.utils.Constants_MVVM;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: SelectCreditCardFragment.kt */
final class SelectCreditCardFragment$initializeUI$2 implements View.OnClickListener {
    final /* synthetic */ SelectCreditCardFragment this$0;

    SelectCreditCardFragment$initializeUI$2(SelectCreditCardFragment selectCreditCardFragment) {
        this.this$0 = selectCreditCardFragment;
    }

    public final void onClick(View view) {
        NavController findNavController = Navigation.findNavController(SelectCreditCardFragment.access$getBdtPaymentActivity$p(this.this$0), C2723R.C2726id.main_nav_host_fragment);
        Intrinsics.checkExpressionValueIsNotNull(findNavController, "Navigation.findNavContro…d.main_nav_host_fragment)");
        Bundle bundle = new Bundle();
        bundle.putString(Constants_MVVM.EXTRA_PAYMENT_METHOD, Constants_MVVM.PaymentMethod.CREDIT_CARD.getValue());
        findNavController.navigate((int) C2723R.C2726id.action_set_cc_to_select_vehicle_cc, bundle);
    }
}
