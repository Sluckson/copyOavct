package com.iaai.android.bdt.injection.module;

import androidx.fragment.app.Fragment;
import com.iaai.android.bdt.feature.findVehiclePage.filter.FilterFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {FilterFragmentSubcomponent.class})
public abstract class FragmentModule_ContributeFilterFragment$app_productionRelease {

    @Subcomponent
    /* compiled from: FragmentModule_ContributeFilterFragment$app_productionRelease */
    public interface FilterFragmentSubcomponent extends AndroidInjector<FilterFragment> {

        @Subcomponent.Builder
        /* compiled from: FragmentModule_ContributeFilterFragment$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<FilterFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @FragmentKey(FilterFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<? extends Fragment> bindAndroidInjectorFactory(FilterFragmentSubcomponent.Builder builder);

    private FragmentModule_ContributeFilterFragment$app_productionRelease() {
    }
}
