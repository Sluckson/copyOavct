package com.iaai.android.bdt.injection.module;

import androidx.fragment.app.Fragment;
import com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {AuctionSalesListFragmentSubcomponent.class})
public abstract class FragmentModule_ContributeAuctionSalesList$app_productionRelease {

    @Subcomponent
    /* compiled from: FragmentModule_ContributeAuctionSalesList$app_productionRelease */
    public interface AuctionSalesListFragmentSubcomponent extends AndroidInjector<AuctionSalesListFragment> {

        @Subcomponent.Builder
        /* compiled from: FragmentModule_ContributeAuctionSalesList$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<AuctionSalesListFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @FragmentKey(AuctionSalesListFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<? extends Fragment> bindAndroidInjectorFactory(AuctionSalesListFragmentSubcomponent.Builder builder);

    private FragmentModule_ContributeAuctionSalesList$app_productionRelease() {
    }
}
