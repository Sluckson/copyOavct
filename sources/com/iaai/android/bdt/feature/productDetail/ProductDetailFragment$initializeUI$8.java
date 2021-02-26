package com.iaai.android.bdt.feature.productDetail;

import android.os.Bundle;
import android.util.Log;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.analytics.IAAAnalytics;
import com.iaai.android.bdt.utils.NonHDImagesMode;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo66933d2 = {"<anonymous>", "", "position", "", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: ProductDetailFragment.kt */
final class ProductDetailFragment$initializeUI$8 implements ImageClickListener {
    final /* synthetic */ ProductDetailFragment this$0;

    ProductDetailFragment$initializeUI$8(ProductDetailFragment productDetailFragment) {
        this.this$0 = productDetailFragment;
    }

    public final void onClick(int i) {
        CarouselView carouselView = (CarouselView) this.this$0._$_findCachedViewById(C2723R.C2726id.cvVehicleImages);
        Intrinsics.checkExpressionValueIsNotNull(carouselView, "cvVehicleImages");
        if (i == carouselView.getPageCount() - 1 && this.this$0.isEngineVideoPresent) {
            ProductDetailFragment productDetailFragment = this.this$0;
            productDetailFragment.playEngineVideoSound(productDetailFragment.engineURL);
        } else if (!this.this$0.vehicleImages.isEmpty()) {
            Log.e("FIRE_BASE_ANALYTICS", "Sending Event: " + IAAAnalytics.IAAEvents.GRID_IMAGE.getId());
            IAAAnalytics.INSTANCE.logIAAEvent(IAAAnalytics.IAAEvents.GRID_IMAGE, (Bundle) null);
            this.this$0.launchNonHDActivity(i, NonHDImagesMode.DEFAULT);
        }
    }
}
