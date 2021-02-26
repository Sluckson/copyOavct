package com.iaai.android.bdt.feature.productDetail.buyNow;

import android.app.Dialog;
import androidx.lifecycle.Observer;
import com.iaai.android.bdt.extensions.Activity_ExtensionKt;
import com.iaai.android.bdt.model.productDetail.buyNow.BuyNowResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Lcom/iaai/android/bdt/model/productDetail/buyNow/BuyNowResult;", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: BuyNowFragment.kt */
final class BuyNowFragment$subscribeToViewModel$2<T> implements Observer<BuyNowResult> {
    final /* synthetic */ BuyNowFragment this$0;

    BuyNowFragment$subscribeToViewModel$2(BuyNowFragment buyNowFragment) {
        this.this$0 = buyNowFragment;
    }

    public final void onChanged(BuyNowResult buyNowResult) {
        if (this.this$0.isAdded()) {
            Boolean valueOf = buyNowResult != null ? Boolean.valueOf(buyNowResult.getCanbuyerbuy()) : null;
            if (valueOf == null) {
                Intrinsics.throwNpe();
            }
            if (valueOf.booleanValue()) {
                this.this$0.handleBuyNowResult();
                return;
            }
            Dialog showAlertWithCallback = Activity_ExtensionKt.showAlertWithCallback(BuyNowFragment.access$getBaseActivity$p(this.this$0), buyNowResult.getMessage(), this.this$0);
            if (showAlertWithCallback != null) {
                showAlertWithCallback.show();
            }
        }
    }
}
