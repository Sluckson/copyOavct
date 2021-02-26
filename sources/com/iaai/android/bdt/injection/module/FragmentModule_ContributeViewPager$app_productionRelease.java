package com.iaai.android.bdt.injection.module;

import androidx.fragment.app.Fragment;
import com.iaai.android.bdt.feature.productDetail.ViewPagerFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {ViewPagerFragmentSubcomponent.class})
public abstract class FragmentModule_ContributeViewPager$app_productionRelease {

    @Subcomponent
    /* compiled from: FragmentModule_ContributeViewPager$app_productionRelease */
    public interface ViewPagerFragmentSubcomponent extends AndroidInjector<ViewPagerFragment> {

        @Subcomponent.Builder
        /* compiled from: FragmentModule_ContributeViewPager$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<ViewPagerFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @FragmentKey(ViewPagerFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<? extends Fragment> bindAndroidInjectorFactory(ViewPagerFragmentSubcomponent.Builder builder);

    private FragmentModule_ContributeViewPager$app_productionRelease() {
    }
}
