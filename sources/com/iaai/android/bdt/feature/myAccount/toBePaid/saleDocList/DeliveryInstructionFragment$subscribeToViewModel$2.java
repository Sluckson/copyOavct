package com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList;

import android.content.Context;
import androidx.lifecycle.Observer;
import com.iaai.android.bdt.extensions.Context_ExtensionKt;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: DeliveryInstructionFragment.kt */
final class DeliveryInstructionFragment$subscribeToViewModel$2<T> implements Observer<String> {
    final /* synthetic */ DeliveryInstructionFragment this$0;

    DeliveryInstructionFragment$subscribeToViewModel$2(DeliveryInstructionFragment deliveryInstructionFragment) {
        this.this$0 = deliveryInstructionFragment;
    }

    public final void onChanged(String str) {
        this.this$0.showLoadingIndicator(false);
        Context access$getBdtPaymentActivity$p = DeliveryInstructionFragment.access$getBdtPaymentActivity$p(this.this$0);
        if (str == null) {
            str = "Unable to process the request";
        }
        Context_ExtensionKt.showToast(access$getBdtPaymentActivity$p, str);
    }
}
