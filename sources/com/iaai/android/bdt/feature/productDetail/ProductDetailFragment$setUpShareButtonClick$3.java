package com.iaai.android.bdt.feature.productDetail;

import android.view.View;
import com.iaai.android.bdt.extensions.Activity_ExtensionKt;
import com.iaai.android.bdt.model.productDetail.biddingInfo.Image;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: ProductDetailFragment.kt */
final class ProductDetailFragment$setUpShareButtonClick$3 implements View.OnClickListener {
    final /* synthetic */ ProductDetailActivity $productDetailActivity;
    final /* synthetic */ ProductDetailFragment this$0;

    ProductDetailFragment$setUpShareButtonClick$3(ProductDetailFragment productDetailFragment, ProductDetailActivity productDetailActivity) {
        this.this$0 = productDetailFragment;
        this.$productDetailActivity = productDetailActivity;
    }

    public final void onClick(View view) {
        if (!this.this$0.vehicleImages.isEmpty()) {
            Activity_ExtensionKt.createDynamicLinkForProduct(this.$productDetailActivity, this.this$0.itemId, this.this$0.shareStockVerbiage(), ((Image) this.this$0.vehicleImages.get(0)).getUrl(), this.this$0, "");
        } else {
            Activity_ExtensionKt.createDynamicLinkForProduct(this.$productDetailActivity, this.this$0.itemId, this.this$0.shareStockVerbiage(), "", this.this$0, "");
        }
    }
}
