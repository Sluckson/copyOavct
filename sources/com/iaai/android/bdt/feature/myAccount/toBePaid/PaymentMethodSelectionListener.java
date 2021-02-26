package com.iaai.android.bdt.feature.myAccount.toBePaid;

import com.iaai.android.bdt.model.toBePaid.PaymentMethodInformation;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH&J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\u000e"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/myAccount/toBePaid/PaymentMethodSelectionListener;", "", "onPayPalFeeInfoClick", "", "onPaymentLinkSelection", "paymentMethodInformation", "Lcom/iaai/android/bdt/model/toBePaid/PaymentMethodInformation;", "position", "", "onPaymentNameInfoClick", "title", "", "message", "onPaymentSelection", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: BDTPaymentMethodAdapter.kt */
public interface PaymentMethodSelectionListener {
    void onPayPalFeeInfoClick();

    void onPaymentLinkSelection(@NotNull PaymentMethodInformation paymentMethodInformation, int i);

    void onPaymentNameInfoClick(@NotNull String str, @NotNull String str2);

    void onPaymentSelection(@NotNull PaymentMethodInformation paymentMethodInformation, int i);
}
