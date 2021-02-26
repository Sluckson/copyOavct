package com.iaai.android.bdt.feature.productDetail.vehicleimage;

import android.view.View;
import com.iaai.android.bdt.model.productDetail.biddingInfo.Image;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: ProductHDImageActivity.kt */
final class ProductHDImageActivity$initializeBtnActions$2 implements View.OnClickListener {
    final /* synthetic */ ProductHDImageActivity this$0;

    ProductHDImageActivity$initializeBtnActions$2(ProductHDImageActivity productHDImageActivity) {
        this.this$0 = productHDImageActivity;
    }

    public final void onClick(View view) {
        if (this.this$0.index > 0) {
            ProductHDImageActivity productHDImageActivity = this.this$0;
            productHDImageActivity.index = productHDImageActivity.index - 1;
            ProductHDImageActivity productHDImageActivity2 = this.this$0;
            productHDImageActivity2.loadWebView((Image) productHDImageActivity2.vehicleImages.get(this.this$0.index));
        }
    }
}
