package com.iaai.android.bdt.injection.module;

import androidx.fragment.app.Fragment;
import com.iaai.android.bdt.feature.landing.quickFilter.QuickLinksFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {QuickLinksFragmentSubcomponent.class})
public abstract class FragmentModule_ContributeFindVehicle$app_productionRelease {

    @Subcomponent
    /* compiled from: FragmentModule_ContributeFindVehicle$app_productionRelease */
    public interface QuickLinksFragmentSubcomponent extends AndroidInjector<QuickLinksFragment> {

        @Subcomponent.Builder
        /* compiled from: FragmentModule_ContributeFindVehicle$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<QuickLinksFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @FragmentKey(QuickLinksFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<? extends Fragment> bindAndroidInjectorFactory(QuickLinksFragmentSubcomponent.Builder builder);

    private FragmentModule_ContributeFindVehicle$app_productionRelease() {
    }
}
