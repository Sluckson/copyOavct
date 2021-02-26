package com.iaai.android.bdt.injection.module;

import androidx.fragment.app.Fragment;
import com.iaai.android.bdt.feature.productDetail.prebid.PreBidFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {PreBidFragmentSubcomponent.class})
public abstract class FragmentModule_ContributePreBid$app_productionRelease {

    @Subcomponent
    /* compiled from: FragmentModule_ContributePreBid$app_productionRelease */
    public interface PreBidFragmentSubcomponent extends AndroidInjector<PreBidFragment> {

        @Subcomponent.Builder
        /* compiled from: FragmentModule_ContributePreBid$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<PreBidFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @FragmentKey(PreBidFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<? extends Fragment> bindAndroidInjectorFactory(PreBidFragmentSubcomponent.Builder builder);

    private FragmentModule_ContributePreBid$app_productionRelease() {
    }
}
