package com.iaai.android.bdt.feature.myAccount.toBePaid;

import androidx.lifecycle.Observer;
import com.google.gson.Gson;
import com.iaai.android.bdt.extensions.Context_ExtensionKt;
import com.iaai.android.bdt.model.toBePaid.PayPalCreateCustomerResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Lcom/iaai/android/bdt/model/toBePaid/PayPalCreateCustomerResponse;", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: BDTPaymentMethodActivity.kt */
final class BDTPaymentMethodActivity$subscribeToViewModel$3<T> implements Observer<PayPalCreateCustomerResponse> {
    final /* synthetic */ BDTPaymentMethodActivity this$0;

    BDTPaymentMethodActivity$subscribeToViewModel$3(BDTPaymentMethodActivity bDTPaymentMethodActivity) {
        this.this$0 = bDTPaymentMethodActivity;
    }

    public final void onChanged(PayPalCreateCustomerResponse payPalCreateCustomerResponse) {
        this.this$0.showLoadingIndicator(false);
        if (payPalCreateCustomerResponse.getIsCustomerCreated()) {
            this.this$0.fetchPayPalToken();
            return;
        }
        Context_ExtensionKt.showToast(this.this$0, payPalCreateCustomerResponse.getCustomerCreateResponseText());
        try {
            String json = new Gson().toJson((Object) this.this$0.getPayPalCreateCustomerIDRequestBody());
            String json2 = new Gson().toJson((Object) payPalCreateCustomerResponse);
            BDTPaymentMethodActivity bDTPaymentMethodActivity = this.this$0;
            String currentSessionUserId = this.this$0.getSessionManager().getCurrentSessionUserId();
            Intrinsics.checkExpressionValueIsNotNull(json, "requestString");
            Intrinsics.checkExpressionValueIsNotNull(json2, "responseString");
            bDTPaymentMethodActivity.logIAAError(currentSessionUserId, "acserviceswebapi/api/createpaypalcustomer/", json, json2, "200");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
