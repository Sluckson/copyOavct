package com.iaai.android.bdt.feature.myAccount.toBePaid;

import androidx.lifecycle.Observer;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.iaai.android.bdt.model.toBePaid.PayPalInfoResponse;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Lcom/iaai/android/bdt/model/toBePaid/PayPalInfoResponse;", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: BDTPaymentMethodActivity.kt */
final class BDTPaymentMethodActivity$subscribeToViewModel$5<T> implements Observer<PayPalInfoResponse> {
    final /* synthetic */ BDTPaymentMethodActivity this$0;

    BDTPaymentMethodActivity$subscribeToViewModel$5(BDTPaymentMethodActivity bDTPaymentMethodActivity) {
        this.this$0 = bDTPaymentMethodActivity;
    }

    public final void onChanged(PayPalInfoResponse payPalInfoResponse) {
        Double dailyAllowancePPPay = payPalInfoResponse.getDailyAllowancePPPay();
        double doubleValue = dailyAllowancePPPay != null ? dailyAllowancePPPay.doubleValue() : 99999.0d;
        Double allowanceUsedPPPay = payPalInfoResponse.getAllowanceUsedPPPay();
        this.this$0.payPalDailyAllowance = String.valueOf(doubleValue - (allowanceUsedPPPay != null ? allowanceUsedPPPay.doubleValue() : FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE));
        BDTPaymentMethodActivity bDTPaymentMethodActivity = this.this$0;
        Boolean isPPEligible = payPalInfoResponse.getIsPPEligible();
        bDTPaymentMethodActivity.isPayPal = isPPEligible != null ? isPPEligible.booleanValue() : false;
        BDTPaymentMethodActivity.access$getBdtPaymentMethodAdapter$p(this.this$0).setData(this.this$0.createPaymentMethodData());
        BDTPaymentMethodActivity.access$getBdtPaymentMethodAdapter$p(this.this$0).notifyDataSetChanged();
        if (this.this$0.isPayPal) {
            this.this$0.launchHintScreen();
        }
    }
}
