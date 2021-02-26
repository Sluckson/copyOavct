package com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList;

import android.app.Dialog;
import androidx.lifecycle.Observer;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.extensions.Activity_ExtensionKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: DeliveryMethodActivity.kt */
final class DeliveryMethodActivity$subscribeToViewModel$4<T> implements Observer<String> {
    final /* synthetic */ DeliveryMethodActivity this$0;

    DeliveryMethodActivity$subscribeToViewModel$4(DeliveryMethodActivity deliveryMethodActivity) {
        this.this$0 = deliveryMethodActivity;
    }

    public final void onChanged(String str) {
        this.this$0.showLoadingIndicator(false);
        DeliveryMethodActivity deliveryMethodActivity = this.this$0;
        String string = deliveryMethodActivity.getResources().getString(C2723R.string.lbl_apply_delivery_method_failed);
        Intrinsics.checkExpressionValueIsNotNull(string, "resources.getString(R.st…y_delivery_method_failed)");
        String string2 = this.this$0.getResources().getString(C2723R.string.lbl_apply_delivery_failed_msg);
        Intrinsics.checkExpressionValueIsNotNull(string2, "resources.getString(R.st…pply_delivery_failed_msg)");
        Dialog showAlert = Activity_ExtensionKt.showAlert(deliveryMethodActivity, string, string2);
        if (showAlert != null) {
            showAlert.show();
        }
    }
}
