package com.iaai.android.bdt.feature.myAccount.toBePaid;

import com.iaai.android.bdt.model.toBePaid.PayPalPaymentRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: BDTPaymentMethodActivity.kt */
final class BDTPaymentMethodActivity$createPaymentMethodData$1 extends MutablePropertyReference0 {
    BDTPaymentMethodActivity$createPaymentMethodData$1(BDTPaymentMethodActivity bDTPaymentMethodActivity) {
        super(bDTPaymentMethodActivity);
    }

    public String getName() {
        return "payPalPaymentRequest";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(BDTPaymentMethodActivity.class);
    }

    public String getSignature() {
        return "getPayPalPaymentRequest()Lcom/iaai/android/bdt/model/toBePaid/PayPalPaymentRequest;";
    }

    @Nullable
    public Object get() {
        return BDTPaymentMethodActivity.access$getPayPalPaymentRequest$p((BDTPaymentMethodActivity) this.receiver);
    }

    public void set(@Nullable Object obj) {
        ((BDTPaymentMethodActivity) this.receiver).payPalPaymentRequest = (PayPalPaymentRequest) obj;
    }
}
