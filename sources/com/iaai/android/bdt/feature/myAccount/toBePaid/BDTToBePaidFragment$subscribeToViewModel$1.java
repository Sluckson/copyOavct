package com.iaai.android.bdt.feature.myAccount.toBePaid;

import androidx.lifecycle.Observer;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.iaai.android.bdt.model.toBePaid.PayPalInfoResponse;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Lcom/iaai/android/bdt/model/toBePaid/PayPalInfoResponse;", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: BDTToBePaidFragment.kt */
final class BDTToBePaidFragment$subscribeToViewModel$1<T> implements Observer<PayPalInfoResponse> {
    final /* synthetic */ BDTToBePaidFragment this$0;

    BDTToBePaidFragment$subscribeToViewModel$1(BDTToBePaidFragment bDTToBePaidFragment) {
        this.this$0 = bDTToBePaidFragment;
    }

    public final void onChanged(PayPalInfoResponse payPalInfoResponse) {
        BDTToBePaidFragment bDTToBePaidFragment = this.this$0;
        Double dailyAllowancePPPay = payPalInfoResponse.getDailyAllowancePPPay();
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        bDTToBePaidFragment.setDailyAllowance(dailyAllowancePPPay != null ? dailyAllowancePPPay.doubleValue() : 0.0d);
        BDTToBePaidFragment bDTToBePaidFragment2 = this.this$0;
        Double allowanceUsedPPPay = payPalInfoResponse.getAllowanceUsedPPPay();
        bDTToBePaidFragment2.setAllowanceUsed(allowanceUsedPPPay != null ? allowanceUsedPPPay.doubleValue() : 0.0d);
        BDTToBePaidFragment bDTToBePaidFragment3 = this.this$0;
        Double cashDiscountForfeited = payPalInfoResponse.getCashDiscountForfeited();
        if (cashDiscountForfeited != null) {
            d = cashDiscountForfeited.doubleValue();
        }
        bDTToBePaidFragment3.setCdfFee(d);
    }
}
