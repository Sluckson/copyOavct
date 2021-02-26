package com.iaai.android.bdt.feature.productDetail;

import androidx.lifecycle.Observer;
import com.iaai.android.bdt.model.productDetail.biddingInfo.ProductDetailResponse;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Lcom/iaai/android/bdt/model/productDetail/biddingInfo/ProductDetailResponse;", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: ProductDetailFragment.kt */
final class ProductDetailFragment$subscribeToViewModel$1<T> implements Observer<ProductDetailResponse> {
    final /* synthetic */ ProductDetailFragment this$0;

    ProductDetailFragment$subscribeToViewModel$1(ProductDetailFragment productDetailFragment) {
        this.this$0 = productDetailFragment;
    }

    public final void onChanged(ProductDetailResponse productDetailResponse) {
        this.this$0.updateNonUSVehicleDetails(productDetailResponse);
        if (this.this$0.getUserVisibleHint()) {
            this.this$0.setUpShareButtonClick();
        }
    }
}
