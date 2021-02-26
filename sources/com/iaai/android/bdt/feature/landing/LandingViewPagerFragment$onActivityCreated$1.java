package com.iaai.android.bdt.feature.landing;

import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.utils.BDTUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\f"}, mo66933d2 = {"com/iaai/android/bdt/feature/landing/LandingViewPagerFragment$onActivityCreated$1", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "onPageScrollStateChanged", "", "state", "", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: LandingViewPagerFragment.kt */
public final class LandingViewPagerFragment$onActivityCreated$1 implements ViewPager.OnPageChangeListener {
    final /* synthetic */ LandingViewPagerFragment this$0;

    public void onPageScrollStateChanged(int i) {
    }

    LandingViewPagerFragment$onActivityCreated$1(LandingViewPagerFragment landingViewPagerFragment) {
        this.this$0 = landingViewPagerFragment;
    }

    public void onPageScrolled(int i, float f, int i2) {
        this.this$0.updateToolbar(i);
    }

    public void onPageSelected(int i) {
        ImageView imageView = (ImageView) LandingViewPagerFragment.access$getBaseActivity$p(this.this$0)._$_findCachedViewById(C2723R.C2726id.ivShareLanding);
        Intrinsics.checkExpressionValueIsNotNull(imageView, "baseActivity.ivShareLanding");
        imageView.setVisibility(0);
        if (this.this$0.itemIdList.size() > 1) {
            TextView textView = (TextView) LandingViewPagerFragment.access$getBaseActivity$p(this.this$0)._$_findCachedViewById(C2723R.C2726id.toolbar_title);
            Intrinsics.checkExpressionValueIsNotNull(textView, "baseActivity.toolbar_title");
            textView.setText(String.valueOf(i + 1) + " of " + BDTUtils.INSTANCE.getCountDisplay(this.this$0.itemIdList.size()));
            TextView textView2 = (TextView) LandingViewPagerFragment.access$getBaseActivity$p(this.this$0)._$_findCachedViewById(C2723R.C2726id.toolbar_sub_title);
            Intrinsics.checkExpressionValueIsNotNull(textView2, "baseActivity.toolbar_sub_title");
            textView2.setVisibility(8);
            return;
        }
        TextView textView3 = (TextView) LandingViewPagerFragment.access$getBaseActivity$p(this.this$0)._$_findCachedViewById(C2723R.C2726id.toolbar_title);
        Intrinsics.checkExpressionValueIsNotNull(textView3, "baseActivity.toolbar_title");
        textView3.setText("Year Make Model");
        TextView textView4 = (TextView) LandingViewPagerFragment.access$getBaseActivity$p(this.this$0)._$_findCachedViewById(C2723R.C2726id.toolbar_sub_title);
        Intrinsics.checkExpressionValueIsNotNull(textView4, "baseActivity.toolbar_sub_title");
        textView4.setVisibility(8);
    }
}
