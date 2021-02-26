package com.iaai.android.bdt.feature.myAccount.toBePaid;

import android.app.Dialog;
import android.view.View;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.extensions.Activity_ExtensionKt;
import com.iaai.android.bdt.feature.myAccount.toBePaid.BDTToBePaidFragmentDirections;
import com.iaai.android.bdt.model.toBePaid.paymentDueList.PaymentDue;
import com.iaai.android.old.utils.p016ui.UiUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: BDTToBePaidFragment.kt */
final class BDTToBePaidFragment$initializeUI$1 implements View.OnClickListener {
    final /* synthetic */ BDTToBePaidFragment this$0;

    BDTToBePaidFragment$initializeUI$1(BDTToBePaidFragment bDTToBePaidFragment) {
        this.this$0 = bDTToBePaidFragment;
    }

    public final void onClick(View view) {
        double dailyAllowance = this.this$0.getDailyAllowance() - this.this$0.getAllowanceUsed();
        if (this.this$0.getTotalAmountForSelected() > dailyAllowance) {
            String formatCurrencyFromString = UiUtils.formatCurrencyFromString(String.valueOf(dailyAllowance), true);
            String string = this.this$0.getString(C2723R.string.lbl_pay_pal_daily_allowance);
            Intrinsics.checkExpressionValueIsNotNull(string, "getString(R.string.lbl_pay_pal_daily_allowance)");
            String string2 = this.this$0.getString(C2723R.string.lbl_remaining_allowance_exceeded_error, formatCurrencyFromString);
            Intrinsics.checkExpressionValueIsNotNull(string2, "getString(R.string.lbl_r…mattedRemainingAllowance)");
            Dialog showAlert = Activity_ExtensionKt.showAlert(BDTToBePaidFragment.access$getBdtPaymentActivity$p(this.this$0), string, string2);
            if (showAlert != null) {
                showAlert.show();
                return;
            }
            return;
        }
        Collection arrayList = new ArrayList();
        for (Object next : this.this$0.getVehicleList()) {
            if (((PaymentDue) next).isSelected()) {
                arrayList.add(next);
            }
        }
        List list = (List) arrayList;
        if (this.this$0.isSaleDocCheckRequired(list)) {
            BDTToBePaidFragmentDirections.Companion companion = BDTToBePaidFragmentDirections.Companion;
            Object[] array = list.toArray(new PaymentDue[0]);
            if (array != null) {
                NavDirections actionToBePaidFragmentToDeliveryInstructionFragment = companion.actionToBePaidFragmentToDeliveryInstructionFragment((PaymentDue[]) array, (float) this.this$0.getCdfFee(), this.this$0.payPalAccountDetailID);
                NavController findNavController = Navigation.findNavController(BDTToBePaidFragment.access$getBdtPaymentActivity$p(this.this$0), C2723R.C2726id.main_nav_host_fragment);
                Intrinsics.checkExpressionValueIsNotNull(findNavController, "Navigation.findNavContro…d.main_nav_host_fragment)");
                findNavController.navigate(actionToBePaidFragmentToDeliveryInstructionFragment);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        BDTToBePaidFragmentDirections.Companion companion2 = BDTToBePaidFragmentDirections.Companion;
        Object[] array2 = list.toArray(new PaymentDue[0]);
        if (array2 != null) {
            NavDirections actionToBePaidFragmentToBePaidReviewFragment = companion2.actionToBePaidFragmentToBePaidReviewFragment((PaymentDue[]) array2, (float) this.this$0.getCdfFee(), this.this$0.payPalAccountDetailID);
            NavController findNavController2 = Navigation.findNavController(BDTToBePaidFragment.access$getBdtPaymentActivity$p(this.this$0), C2723R.C2726id.main_nav_host_fragment);
            Intrinsics.checkExpressionValueIsNotNull(findNavController2, "Navigation.findNavContro…d.main_nav_host_fragment)");
            findNavController2.navigate(actionToBePaidFragmentToBePaidReviewFragment);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }
}
