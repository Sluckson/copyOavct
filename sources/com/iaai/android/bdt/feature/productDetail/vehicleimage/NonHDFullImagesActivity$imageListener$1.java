package com.iaai.android.bdt.feature.productDetail.vehicleimage;

import android.widget.ImageView;
import com.iaai.android.bdt.extensions.Activity_ExtensionKt;
import com.iaai.android.bdt.model.productDetail.biddingInfo.Image;
import com.synnapps.carouselview.ImageListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, mo66933d2 = {"<anonymous>", "", "position", "", "imageView", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "setImageForPosition"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: NonHDFullImagesActivity.kt */
final class NonHDFullImagesActivity$imageListener$1 implements ImageListener {
    final /* synthetic */ NonHDFullImagesActivity this$0;

    NonHDFullImagesActivity$imageListener$1(NonHDFullImagesActivity nonHDFullImagesActivity) {
        this.this$0 = nonHDFullImagesActivity;
    }

    public final void setImageForPosition(int i, ImageView imageView) {
        if (i < this.this$0.vehicleImages.size()) {
            NonHDFullImagesActivity nonHDFullImagesActivity = this.this$0;
            String url = ((Image) nonHDFullImagesActivity.vehicleImages.get(i)).getUrl();
            Intrinsics.checkExpressionValueIsNotNull(imageView, "imageView");
            Activity_ExtensionKt.vehicleImageUrl(nonHDFullImagesActivity, true, url, imageView);
            return;
        }
        NonHDFullImagesActivity nonHDFullImagesActivity2 = this.this$0;
        Intrinsics.checkExpressionValueIsNotNull(imageView, "imageView");
        Activity_ExtensionKt.vehicleImageUrl(nonHDFullImagesActivity2, false, "", imageView);
    }
}
