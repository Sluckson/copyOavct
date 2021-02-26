package com.iaai.android.bdt.feature.myAccount.toBePaid;

import android.app.Dialog;
import android.util.Log;
import com.braintreepayments.api.dropin.DropInRequest;
import com.google.zxing.integration.android.IntentIntegrator;
import com.iaai.android.bdt.extensions.Activity_ExtensionKt;
import com.iaai.android.bdt.model.toBePaid.PaymentMethodInformation;
import com.iaai.android.bdt.utils.Constants_MVVM;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\u000e"}, mo66933d2 = {"com/iaai/android/bdt/feature/myAccount/toBePaid/BDTPaymentMethodActivity$initializeRecycler$1", "Lcom/iaai/android/bdt/feature/myAccount/toBePaid/PaymentMethodSelectionListener;", "onPayPalFeeInfoClick", "", "onPaymentLinkSelection", "paymentMethodInformation", "Lcom/iaai/android/bdt/model/toBePaid/PaymentMethodInformation;", "position", "", "onPaymentNameInfoClick", "title", "", "information", "onPaymentSelection", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: BDTPaymentMethodActivity.kt */
public final class BDTPaymentMethodActivity$initializeRecycler$1 implements PaymentMethodSelectionListener {
    final /* synthetic */ BDTPaymentMethodActivity this$0;

    public void onPayPalFeeInfoClick() {
    }

    BDTPaymentMethodActivity$initializeRecycler$1(BDTPaymentMethodActivity bDTPaymentMethodActivity) {
        this.this$0 = bDTPaymentMethodActivity;
    }

    public void onPaymentSelection(@NotNull PaymentMethodInformation paymentMethodInformation, int i) {
        Intrinsics.checkParameterIsNotNull(paymentMethodInformation, "paymentMethodInformation");
        this.this$0.updateButton();
        this.this$0.selectedPaymentMethod = paymentMethodInformation;
    }

    public void onPaymentNameInfoClick(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "title");
        Intrinsics.checkParameterIsNotNull(str2, TtmlNode.TAG_INFORMATION);
        Dialog showAlert = Activity_ExtensionKt.showAlert(this.this$0, str, str2);
        if (showAlert != null) {
            showAlert.show();
        }
    }

    public void onPaymentLinkSelection(@NotNull PaymentMethodInformation paymentMethodInformation, int i) {
        Intrinsics.checkParameterIsNotNull(paymentMethodInformation, "paymentMethodInformation");
        Log.d("Payment Method", "Payment Selection");
        String value = paymentMethodInformation.getPaymentMethodType().getValue();
        if (Intrinsics.areEqual((Object) value, (Object) Constants_MVVM.PaymentMethod.ACH.getValue()) || Intrinsics.areEqual((Object) value, (Object) Constants_MVVM.PaymentMethod.AFC.getValue())) {
            return;
        }
        if (Intrinsics.areEqual((Object) value, (Object) Constants_MVVM.PaymentMethod.PAY_PAL.getValue())) {
            DropInRequest clientToken = new DropInRequest().clientToken(this.this$0.brainTreeToken);
            clientToken.disableCard();
            BDTPaymentMethodActivity bDTPaymentMethodActivity = this.this$0;
            bDTPaymentMethodActivity.startActivityForResult(clientToken.getIntent(bDTPaymentMethodActivity), IntentIntegrator.REQUEST_CODE);
            return;
        }
        Intrinsics.areEqual((Object) value, (Object) Constants_MVVM.PaymentMethod.CREDIT_CARD.getValue());
    }
}
