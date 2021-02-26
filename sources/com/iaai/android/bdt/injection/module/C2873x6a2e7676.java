package com.iaai.android.bdt.injection.module;

import androidx.fragment.app.Fragment;
import com.iaai.android.bdt.feature.account.buyNowOfferList.BuyNowOfferListFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {BuyNowOfferListFragmentSubcomponent.class})
/* renamed from: com.iaai.android.bdt.injection.module.FragmentModule_ContributeBuyNowOfferListFragment$app_productionRelease */
public abstract class C2873x6a2e7676 {

    @Subcomponent
    /* renamed from: com.iaai.android.bdt.injection.module.FragmentModule_ContributeBuyNowOfferListFragment$app_productionRelease$BuyNowOfferListFragmentSubcomponent */
    /* compiled from: FragmentModule_ContributeBuyNowOfferListFragment$app_productionRelease */
    public interface BuyNowOfferListFragmentSubcomponent extends AndroidInjector<BuyNowOfferListFragment> {

        @Subcomponent.Builder
        /* renamed from: com.iaai.android.bdt.injection.module.FragmentModule_ContributeBuyNowOfferListFragment$app_productionRelease$BuyNowOfferListFragmentSubcomponent$Builder */
        /* compiled from: FragmentModule_ContributeBuyNowOfferListFragment$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<BuyNowOfferListFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @FragmentKey(BuyNowOfferListFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<? extends Fragment> bindAndroidInjectorFactory(BuyNowOfferListFragmentSubcomponent.Builder builder);

    private C2873x6a2e7676() {
    }
}
