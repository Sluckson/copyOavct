package com.iaai.android.bdt.injection.module;

import androidx.fragment.app.Fragment;
import com.iaai.android.bdt.feature.account.watchlist.PreSaleListFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {PreSaleListFragmentSubcomponent.class})
public abstract class FragmentModule_ContributeWatchListFragment$app_productionRelease {

    @Subcomponent
    /* compiled from: FragmentModule_ContributeWatchListFragment$app_productionRelease */
    public interface PreSaleListFragmentSubcomponent extends AndroidInjector<PreSaleListFragment> {

        @Subcomponent.Builder
        /* compiled from: FragmentModule_ContributeWatchListFragment$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<PreSaleListFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @FragmentKey(PreSaleListFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<? extends Fragment> bindAndroidInjectorFactory(PreSaleListFragmentSubcomponent.Builder builder);

    private FragmentModule_ContributeWatchListFragment$app_productionRelease() {
    }
}
