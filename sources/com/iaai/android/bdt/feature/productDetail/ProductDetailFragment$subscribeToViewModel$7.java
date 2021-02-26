package com.iaai.android.bdt.feature.productDetail;

import androidx.lifecycle.Observer;
import com.iaai.android.bdt.model.productDetail.biddingInfo.WarningTextModel;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "warningsText", "Lcom/iaai/android/bdt/model/productDetail/biddingInfo/WarningTextModel;", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: ProductDetailFragment.kt */
final class ProductDetailFragment$subscribeToViewModel$7<T> implements Observer<WarningTextModel> {
    final /* synthetic */ ProductDetailFragment this$0;

    ProductDetailFragment$subscribeToViewModel$7(ProductDetailFragment productDetailFragment) {
        this.this$0 = productDetailFragment;
    }

    public final void onChanged(WarningTextModel warningTextModel) {
        if (warningTextModel != null && this.this$0.isAdded() && this.this$0.isViewAvalibale) {
            this.this$0.updateBiddingWarnings(warningTextModel);
        }
    }
}
