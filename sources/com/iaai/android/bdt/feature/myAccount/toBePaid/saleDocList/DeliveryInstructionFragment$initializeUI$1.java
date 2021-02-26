package com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList;

import android.view.View;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList.DeliveryInstructionFragmentDirections;
import com.iaai.android.bdt.model.toBePaid.paymentDueList.PaymentDue;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: DeliveryInstructionFragment.kt */
final class DeliveryInstructionFragment$initializeUI$1 implements View.OnClickListener {
    final /* synthetic */ DeliveryInstructionFragment this$0;

    DeliveryInstructionFragment$initializeUI$1(DeliveryInstructionFragment deliveryInstructionFragment) {
        this.this$0 = deliveryInstructionFragment;
    }

    public final void onClick(View view) {
        PaymentDue[] paymentDueArr;
        DeliveryInstructionFragmentDirections.Companion companion = DeliveryInstructionFragmentDirections.Companion;
        List access$getSelectedItemsList$p = this.this$0.getSelectedItemsList();
        if (access$getSelectedItemsList$p != null) {
            Object[] array = access$getSelectedItemsList$p.toArray(new PaymentDue[0]);
            if (array != null) {
                paymentDueArr = (PaymentDue[]) array;
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
        } else {
            paymentDueArr = null;
        }
        NavDirections actionFromDeliveryInstructionFragmentToBePaidReviewFragment = companion.actionFromDeliveryInstructionFragmentToBePaidReviewFragment(paymentDueArr, (float) this.this$0.getCdfFee(), this.this$0.getPayPalAccountDetailID());
        NavController findNavController = Navigation.findNavController(DeliveryInstructionFragment.access$getBdtPaymentActivity$p(this.this$0), C2723R.C2726id.main_nav_host_fragment);
        Intrinsics.checkExpressionValueIsNotNull(findNavController, "Navigation.findNavContro…d.main_nav_host_fragment)");
        findNavController.navigate(actionFromDeliveryInstructionFragmentToBePaidReviewFragment);
    }
}
