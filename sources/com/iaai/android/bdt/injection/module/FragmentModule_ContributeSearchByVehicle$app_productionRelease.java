package com.iaai.android.bdt.injection.module;

import androidx.fragment.app.Fragment;
import com.iaai.android.bdt.feature.landing.quickFilter.SearchByVehicleFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {SearchByVehicleFragmentSubcomponent.class})
public abstract class FragmentModule_ContributeSearchByVehicle$app_productionRelease {

    @Subcomponent
    /* compiled from: FragmentModule_ContributeSearchByVehicle$app_productionRelease */
    public interface SearchByVehicleFragmentSubcomponent extends AndroidInjector<SearchByVehicleFragment> {

        @Subcomponent.Builder
        /* compiled from: FragmentModule_ContributeSearchByVehicle$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<SearchByVehicleFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @FragmentKey(SearchByVehicleFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<? extends Fragment> bindAndroidInjectorFactory(SearchByVehicleFragmentSubcomponent.Builder builder);

    private FragmentModule_ContributeSearchByVehicle$app_productionRelease() {
    }
}
