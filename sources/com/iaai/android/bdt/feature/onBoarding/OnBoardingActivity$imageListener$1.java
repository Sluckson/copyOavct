package com.iaai.android.bdt.feature.onBoarding;

import android.widget.ImageView;
import com.synnapps.carouselview.ImageListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, mo66933d2 = {"<anonymous>", "", "position", "", "imageView", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "setImageForPosition"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: OnBoardingActivity.kt */
final class OnBoardingActivity$imageListener$1 implements ImageListener {
    final /* synthetic */ OnBoardingActivity this$0;

    OnBoardingActivity$imageListener$1(OnBoardingActivity onBoardingActivity) {
        this.this$0 = onBoardingActivity;
    }

    public final void setImageForPosition(int i, ImageView imageView) {
        Intrinsics.checkExpressionValueIsNotNull(imageView, "imageView");
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.this$0.vehicleImageUrl(i, imageView);
    }
}
