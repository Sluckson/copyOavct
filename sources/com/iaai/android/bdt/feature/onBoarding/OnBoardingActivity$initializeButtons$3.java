package com.iaai.android.bdt.feature.onBoarding;

import android.view.View;
import com.iaai.android.C2723R;
import com.synnapps.carouselview.CarouselView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: OnBoardingActivity.kt */
final class OnBoardingActivity$initializeButtons$3 implements View.OnClickListener {
    final /* synthetic */ OnBoardingActivity this$0;

    OnBoardingActivity$initializeButtons$3(OnBoardingActivity onBoardingActivity) {
        this.this$0 = onBoardingActivity;
    }

    public final void onClick(View view) {
        CarouselView carouselView = (CarouselView) this.this$0._$_findCachedViewById(C2723R.C2726id.cvOnBoarding);
        Intrinsics.checkExpressionValueIsNotNull(carouselView, "cvOnBoarding");
        carouselView.setCurrentItem(this.this$0.currentPosition + 1);
    }
}
