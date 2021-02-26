package com.iaai.android.bdt.feature.productDetail;

import android.view.View;
import com.iaai.android.bdt.utils.NonHDImagesMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, mo66933d2 = {"com/iaai/android/bdt/feature/productDetail/ProductDetailFragment$onCreate$1", "Lcom/iaai/android/bdt/feature/productDetail/ProductDetailInfoListener;", "onEngineVideoClick", "", "v", "Landroid/view/View;", "onKeyFobClick", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: ProductDetailFragment.kt */
public final class ProductDetailFragment$onCreate$1 implements ProductDetailInfoListener {
    final /* synthetic */ ProductDetailFragment this$0;

    ProductDetailFragment$onCreate$1(ProductDetailFragment productDetailFragment) {
        this.this$0 = productDetailFragment;
    }

    public void onKeyFobClick(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "v");
        if (!this.this$0.vehicleImages.isEmpty()) {
            ProductDetailFragment productDetailFragment = this.this$0;
            productDetailFragment.launchNonHDActivity(productDetailFragment.keyIndex, NonHDImagesMode.DEFAULT);
        }
    }

    public void onEngineVideoClick(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "v");
        ProductDetailFragment productDetailFragment = this.this$0;
        productDetailFragment.playEngineVideoSound(productDetailFragment.engineURL);
    }
}
