package com.iaai.android.bdt.injection.module;

import androidx.fragment.app.Fragment;
import com.iaai.android.bdt.feature.landing.quickFilter.SearchByAuctionFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {SearchByAuctionFragmentSubcomponent.class})
public abstract class FragmentModule_ContributeSearchByAuction$app_productionRelease {

    @Subcomponent
    /* compiled from: FragmentModule_ContributeSearchByAuction$app_productionRelease */
    public interface SearchByAuctionFragmentSubcomponent extends AndroidInjector<SearchByAuctionFragment> {

        @Subcomponent.Builder
        /* compiled from: FragmentModule_ContributeSearchByAuction$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<SearchByAuctionFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @FragmentKey(SearchByAuctionFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<? extends Fragment> bindAndroidInjectorFactory(SearchByAuctionFragmentSubcomponent.Builder builder);

    private FragmentModule_ContributeSearchByAuction$app_productionRelease() {
    }
}
