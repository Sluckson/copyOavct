package com.iaai.android.bdt.feature.onBoarding;

import androidx.viewpager.widget.ViewPager;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\f"}, mo66933d2 = {"com/iaai/android/bdt/feature/onBoarding/OnBoardingActivity$initializeCarousel$1", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "onPageScrollStateChanged", "", "state", "", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: OnBoardingActivity.kt */
public final class OnBoardingActivity$initializeCarousel$1 implements ViewPager.OnPageChangeListener {
    final /* synthetic */ OnBoardingActivity this$0;

    public void onPageScrollStateChanged(int i) {
    }

    public void onPageScrolled(int i, float f, int i2) {
    }

    OnBoardingActivity$initializeCarousel$1(OnBoardingActivity onBoardingActivity) {
        this.this$0 = onBoardingActivity;
    }

    public void onPageSelected(int i) {
        this.this$0.currentPosition = i;
        this.this$0.setHintHeaderAndMSG(i);
        this.this$0.initializeUI();
    }
}
