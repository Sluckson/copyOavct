package com.iaai.android.bdt.injection.module;

import androidx.fragment.app.Fragment;
import com.iaai.android.bdt.feature.productDetail.chromeSection.ChromeSectionFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {ChromeSectionFragmentSubcomponent.class})
public abstract class FragmentModule_ContributeChromeSection$app_productionRelease {

    @Subcomponent
    /* compiled from: FragmentModule_ContributeChromeSection$app_productionRelease */
    public interface ChromeSectionFragmentSubcomponent extends AndroidInjector<ChromeSectionFragment> {

        @Subcomponent.Builder
        /* compiled from: FragmentModule_ContributeChromeSection$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<ChromeSectionFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @FragmentKey(ChromeSectionFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<? extends Fragment> bindAndroidInjectorFactory(ChromeSectionFragmentSubcomponent.Builder builder);

    private FragmentModule_ContributeChromeSection$app_productionRelease() {
    }
}
