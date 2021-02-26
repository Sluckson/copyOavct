package com.iaai.android.bdt.injection.module;

import androidx.fragment.app.Fragment;
import com.iaai.android.bdt.feature.auctionMainPage.AuctionMainListFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {AuctionMainListFragmentSubcomponent.class})
public abstract class FragmentModule_ContributeAuctionMainList$app_productionRelease {

    @Subcomponent
    /* compiled from: FragmentModule_ContributeAuctionMainList$app_productionRelease */
    public interface AuctionMainListFragmentSubcomponent extends AndroidInjector<AuctionMainListFragment> {

        @Subcomponent.Builder
        /* compiled from: FragmentModule_ContributeAuctionMainList$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<AuctionMainListFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @FragmentKey(AuctionMainListFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<? extends Fragment> bindAndroidInjectorFactory(AuctionMainListFragmentSubcomponent.Builder builder);

    private FragmentModule_ContributeAuctionMainList$app_productionRelease() {
    }
}
