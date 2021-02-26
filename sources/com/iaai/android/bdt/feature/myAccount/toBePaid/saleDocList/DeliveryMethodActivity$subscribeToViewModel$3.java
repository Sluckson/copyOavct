package com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList;

import android.content.Intent;
import androidx.lifecycle.Observer;
import com.iaai.android.bdt.extensions.Context_ExtensionKt;
import com.iaai.android.bdt.model.toBePaid.saleDocument.SaleDocResponse;
import com.iaai.android.bdt.utils.Constants_MVVM;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Lcom/iaai/android/bdt/model/toBePaid/saleDocument/SaleDocResponse;", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: DeliveryMethodActivity.kt */
final class DeliveryMethodActivity$subscribeToViewModel$3<T> implements Observer<SaleDocResponse> {
    final /* synthetic */ DeliveryMethodActivity this$0;

    DeliveryMethodActivity$subscribeToViewModel$3(DeliveryMethodActivity deliveryMethodActivity) {
        this.this$0 = deliveryMethodActivity;
    }

    public final void onChanged(SaleDocResponse saleDocResponse) {
        this.this$0.showLoadingIndicator(false);
        if (saleDocResponse.getSuccess()) {
            Intent intent = new Intent();
            intent.putExtra(Constants_MVVM.EXTRA_IS_FROM_SET_DELIVERY, true);
            this.this$0.setResult(-1, intent);
            this.this$0.finish();
            return;
        }
        Context_ExtensionKt.showToast(this.this$0, saleDocResponse.getError());
    }
}
