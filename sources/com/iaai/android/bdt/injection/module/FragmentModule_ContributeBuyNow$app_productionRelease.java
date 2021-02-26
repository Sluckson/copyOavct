package com.iaai.android.bdt.injection.module;

import androidx.fragment.app.Fragment;
import com.iaai.android.bdt.feature.productDetail.buyNow.BuyNowFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {BuyNowFragmentSubcomponent.class})
public abstract class FragmentModule_ContributeBuyNow$app_productionRelease {

    @Subcomponent
    /* compiled from: FragmentModule_ContributeBuyNow$app_productionRelease */
    public interface BuyNowFragmentSubcomponent extends AndroidInjector<BuyNowFragment> {

        @Subcomponent.Builder
        /* compiled from: FragmentModule_ContributeBuyNow$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<BuyNowFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @FragmentKey(BuyNowFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<? extends Fragment> bindAndroidInjectorFactory(BuyNowFragmentSubcomponent.Builder builder);

    private FragmentModule_ContributeBuyNow$app_productionRelease() {
    }
}
