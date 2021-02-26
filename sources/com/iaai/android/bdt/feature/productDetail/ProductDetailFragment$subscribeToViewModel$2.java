package com.iaai.android.bdt.feature.productDetail;

import androidx.lifecycle.Observer;
import com.iaai.android.bdt.base.BaseFragment;
import com.iaai.android.bdt.model.productDetail.biddingInfo.ProductDetailErrorModel;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Lcom/iaai/android/bdt/model/productDetail/biddingInfo/ProductDetailErrorModel;", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: ProductDetailFragment.kt */
final class ProductDetailFragment$subscribeToViewModel$2<T> implements Observer<ProductDetailErrorModel> {
    final /* synthetic */ ProductDetailFragment this$0;

    ProductDetailFragment$subscribeToViewModel$2(ProductDetailFragment productDetailFragment) {
        this.this$0 = productDetailFragment;
    }

    public final void onChanged(ProductDetailErrorModel productDetailErrorModel) {
        String str;
        if (productDetailErrorModel == null || !productDetailErrorModel.isNetworkError()) {
            ProductDetailFragment productDetailFragment = this.this$0;
            BaseFragment.ErrorType errorType = BaseFragment.ErrorType.NO_VEHICLE_INFO;
            if (productDetailErrorModel == null || (str = productDetailErrorModel.getErrormessage()) == null) {
                str = "No Vehicle Info Available";
            }
            productDetailFragment.displayError(errorType, str);
            return;
        }
        this.this$0.displayError(BaseFragment.ErrorType.NETWORK_ERROR, "");
    }
}
