package com.iaai.android.bdt.feature.myAccount.toBePaid;

import android.view.View;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.model.toBePaid.PaymentMethodInformation;
import com.iaai.android.bdt.utils.Constants_MVVM;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: BDTPaymentMethodAdapter.kt */
final class BDTPaymentMethodAdapter$onBindViewHolder$5 implements View.OnClickListener {
    final /* synthetic */ PaymentMethodInformation $paymentMethod;
    final /* synthetic */ BDTPaymentMethodAdapter this$0;

    BDTPaymentMethodAdapter$onBindViewHolder$5(BDTPaymentMethodAdapter bDTPaymentMethodAdapter, PaymentMethodInformation paymentMethodInformation) {
        this.this$0 = bDTPaymentMethodAdapter;
        this.$paymentMethod = paymentMethodInformation;
    }

    public final void onClick(View view) {
        if (Intrinsics.areEqual((Object) this.$paymentMethod.getPaymentMethodType().getValue(), (Object) Constants_MVVM.PaymentMethod.AFC.getValue())) {
            PaymentMethodSelectionListener access$getPaymentMethodSelection$p = this.this$0.paymentMethodSelection;
            String string = this.this$0.getMContext().getString(C2723R.string.lbl_bdt_title_afc_financing);
            Intrinsics.checkExpressionValueIsNotNull(string, "mContext.getString(R.str…_bdt_title_afc_financing)");
            String string2 = this.this$0.getMContext().getString(C2723R.string.lbl_bdt_afc_finance_info);
            Intrinsics.checkExpressionValueIsNotNull(string2, "mContext.getString(R.str…lbl_bdt_afc_finance_info)");
            access$getPaymentMethodSelection$p.onPaymentNameInfoClick(string, string2);
        }
    }
}
