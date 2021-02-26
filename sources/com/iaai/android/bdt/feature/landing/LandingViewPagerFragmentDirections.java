package com.iaai.android.bdt.feature.landing;

import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.iaai.android.C2723R;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/landing/LandingViewPagerFragmentDirections;", "", "()V", "Companion", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: LandingViewPagerFragmentDirections.kt */
public final class LandingViewPagerFragmentDirections {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004¨\u0006\b"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/landing/LandingViewPagerFragmentDirections$Companion;", "", "()V", "actionLandingViewPagerPdToBuyNow", "Landroidx/navigation/NavDirections;", "actionLandingViewPagerPdToChromeSection", "actionLandingViewPagerPdToCostCalculator", "actionLandingViewPagerPdToPreBid", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: LandingViewPagerFragmentDirections.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final NavDirections actionLandingViewPagerPdToPreBid() {
            return new ActionOnlyNavDirections(C2723R.C2726id.action_landing_view_pager_pd_to_pre_bid);
        }

        @NotNull
        public final NavDirections actionLandingViewPagerPdToBuyNow() {
            return new ActionOnlyNavDirections(C2723R.C2726id.action_landing_view_pager_pd_to_buy_now);
        }

        @NotNull
        public final NavDirections actionLandingViewPagerPdToCostCalculator() {
            return new ActionOnlyNavDirections(C2723R.C2726id.action_landing_view_pager_pd_to_cost_calculator);
        }

        @NotNull
        public final NavDirections actionLandingViewPagerPdToChromeSection() {
            return new ActionOnlyNavDirections(C2723R.C2726id.action_landing_view_pager_pd_to_chrome_section);
        }
    }

    private LandingViewPagerFragmentDirections() {
    }
}
