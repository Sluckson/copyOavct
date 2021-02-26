package com.iaai.android.bdt.feature.productDetail;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.iaai.android.bdt.analytics.IAAAnalytics;
import com.iaai.android.bdt.utils.NonHDImagesMode;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: ProductDetailFragment.kt */
final class ProductDetailFragment$initializeUI$11 implements View.OnClickListener {
    final /* synthetic */ ProductDetailFragment this$0;

    ProductDetailFragment$initializeUI$11(ProductDetailFragment productDetailFragment) {
        this.this$0 = productDetailFragment;
    }

    public final void onClick(View view) {
        if (!this.this$0.vehicleImages.isEmpty()) {
            Log.e("FIRE_BASE_ANALYTICS", "Sending Event: " + IAAAnalytics.IAAEvents.KEY_IMAGE.getId());
            IAAAnalytics.INSTANCE.logIAAEvent(IAAAnalytics.IAAEvents.KEY_IMAGE, (Bundle) null);
            ProductDetailFragment productDetailFragment = this.this$0;
            productDetailFragment.launchNonHDActivity(productDetailFragment.keyIndex, NonHDImagesMode.DEFAULT);
        }
    }
}
