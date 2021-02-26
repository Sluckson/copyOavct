package com.iaai.android.bdt.feature.productDetail;

import android.os.Build;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.model.productDetail.biddingInfo.Image;
import com.synnapps.carouselview.ImageListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, mo66933d2 = {"<anonymous>", "", "position", "", "imageView", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "setImageForPosition"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: ProductDetailFragment.kt */
final class ProductDetailFragment$imageListener$1 implements ImageListener {
    final /* synthetic */ ProductDetailFragment this$0;

    ProductDetailFragment$imageListener$1(ProductDetailFragment productDetailFragment) {
        this.this$0 = productDetailFragment;
    }

    public final void setImageForPosition(int i, ImageView imageView) {
        int i2 = Build.VERSION.SDK_INT;
        if (i <= this.this$0.vehicleImages.size()) {
            if (i == this.this$0.vehicleImages.size()) {
                if (this.this$0.isEngineVideoPresent) {
                    if (i2 > 25) {
                        ProductDetailFragment productDetailFragment = this.this$0;
                        Intrinsics.checkExpressionValueIsNotNull(imageView, "imageView");
                        productDetailFragment.vehicleImageUrl(false, "img_engine_video_thumbnail", imageView);
                    } else {
                        ProductDetailFragment productDetailFragment2 = this.this$0;
                        Intrinsics.checkExpressionValueIsNotNull(imageView, "imageView");
                        productDetailFragment2.loadVehicleImageUrlForAndroidOS7(false, "img_engine_video_thumbnail", imageView);
                    }
                } else if (i2 > 25) {
                    ProductDetailFragment productDetailFragment3 = this.this$0;
                    Intrinsics.checkExpressionValueIsNotNull(imageView, "imageView");
                    productDetailFragment3.vehicleImageUrl(false, "ic_image_na", imageView);
                } else {
                    ProductDetailFragment productDetailFragment4 = this.this$0;
                    Intrinsics.checkExpressionValueIsNotNull(imageView, "imageView");
                    productDetailFragment4.loadVehicleImageUrlForAndroidOS7(false, "ic_image_na", imageView);
                }
            } else if (i2 > 25) {
                ProductDetailFragment productDetailFragment5 = this.this$0;
                String url = ((Image) productDetailFragment5.vehicleImages.get(i)).getUrl();
                Intrinsics.checkExpressionValueIsNotNull(imageView, "imageView");
                productDetailFragment5.vehicleImageUrl(true, url, imageView);
            } else {
                ProductDetailFragment productDetailFragment6 = this.this$0;
                String thumbImageUrl = ((Image) productDetailFragment6.vehicleImages.get(i)).getThumbImageUrl();
                Intrinsics.checkExpressionValueIsNotNull(imageView, "imageView");
                productDetailFragment6.loadVehicleImageUrlForAndroidOS7(true, thumbImageUrl, imageView);
            }
            if (!this.this$0.vehicleImages.isEmpty()) {
                LinearLayout linearLayout = (LinearLayout) this.this$0._$_findCachedViewById(C2723R.C2726id.llImages);
                Intrinsics.checkExpressionValueIsNotNull(linearLayout, "llImages");
                linearLayout.setVisibility(0);
                LinearLayout linearLayout2 = (LinearLayout) this.this$0._$_findCachedViewById(C2723R.C2726id.vehicleImageListView);
                Intrinsics.checkExpressionValueIsNotNull(linearLayout2, "vehicleImageListView");
                linearLayout2.setVisibility(0);
                LinearLayout linearLayout3 = (LinearLayout) this.this$0._$_findCachedViewById(C2723R.C2726id.llImageDownload);
                Intrinsics.checkExpressionValueIsNotNull(linearLayout3, "llImageDownload");
                linearLayout3.setVisibility(0);
            } else if (this.this$0.isEngineVideoPresent) {
                LinearLayout linearLayout4 = (LinearLayout) this.this$0._$_findCachedViewById(C2723R.C2726id.llImages);
                Intrinsics.checkExpressionValueIsNotNull(linearLayout4, "llImages");
                linearLayout4.setVisibility(0);
            } else {
                LinearLayout linearLayout5 = (LinearLayout) this.this$0._$_findCachedViewById(C2723R.C2726id.llImages);
                Intrinsics.checkExpressionValueIsNotNull(linearLayout5, "llImages");
                linearLayout5.setVisibility(8);
            }
        } else {
            if (i2 > 25) {
                ProductDetailFragment productDetailFragment7 = this.this$0;
                Intrinsics.checkExpressionValueIsNotNull(imageView, "imageView");
                productDetailFragment7.vehicleImageUrl(false, "ic_image_na", imageView);
            } else {
                ProductDetailFragment productDetailFragment8 = this.this$0;
                Intrinsics.checkExpressionValueIsNotNull(imageView, "imageView");
                productDetailFragment8.loadVehicleImageUrlForAndroidOS7(false, "ic_image_na", imageView);
            }
            LinearLayout linearLayout6 = (LinearLayout) this.this$0._$_findCachedViewById(C2723R.C2726id.vehicleImageListView);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout6, "vehicleImageListView");
            linearLayout6.setVisibility(8);
            LinearLayout linearLayout7 = (LinearLayout) this.this$0._$_findCachedViewById(C2723R.C2726id.llImageDownload);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout7, "llImageDownload");
            linearLayout7.setVisibility(8);
        }
    }
}
