package com.iaai.android.bdt.injection.module;

import androidx.fragment.app.Fragment;
import com.iaai.android.bdt.feature.landing.LandingViewPagerFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {LandingViewPagerFragmentSubcomponent.class})
/* renamed from: com.iaai.android.bdt.injection.module.FragmentModule_ContributeLandingViewPagerFragment$app_productionRelease */
public abstract class C2877x93a7a693 {

    @Subcomponent
    /* renamed from: com.iaai.android.bdt.injection.module.FragmentModule_ContributeLandingViewPagerFragment$app_productionRelease$LandingViewPagerFragmentSubcomponent */
    /* compiled from: FragmentModule_ContributeLandingViewPagerFragment$app_productionRelease */
    public interface LandingViewPagerFragmentSubcomponent extends AndroidInjector<LandingViewPagerFragment> {

        @Subcomponent.Builder
        /* renamed from: com.iaai.android.bdt.injection.module.FragmentModule_ContributeLandingViewPagerFragment$app_productionRelease$LandingViewPagerFragmentSubcomponent$Builder */
        /* compiled from: FragmentModule_ContributeLandingViewPagerFragment$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<LandingViewPagerFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @FragmentKey(LandingViewPagerFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<? extends Fragment> bindAndroidInjectorFactory(LandingViewPagerFragmentSubcomponent.Builder builder);

    private C2877x93a7a693() {
    }
}
