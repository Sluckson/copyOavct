package com.iaai.android.bdt.injection.module;

import androidx.fragment.app.Fragment;
import com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {ManageOfferListFragmentSubcomponent.class})
/* renamed from: com.iaai.android.bdt.injection.module.FragmentModule_ContributeManageOfferListFragment$app_productionRelease */
public abstract class C2878x2357de1 {

    @Subcomponent
    /* renamed from: com.iaai.android.bdt.injection.module.FragmentModule_ContributeManageOfferListFragment$app_productionRelease$ManageOfferListFragmentSubcomponent */
    /* compiled from: FragmentModule_ContributeManageOfferListFragment$app_productionRelease */
    public interface ManageOfferListFragmentSubcomponent extends AndroidInjector<ManageOfferListFragment> {

        @Subcomponent.Builder
        /* renamed from: com.iaai.android.bdt.injection.module.FragmentModule_ContributeManageOfferListFragment$app_productionRelease$ManageOfferListFragmentSubcomponent$Builder */
        /* compiled from: FragmentModule_ContributeManageOfferListFragment$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<ManageOfferListFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @FragmentKey(ManageOfferListFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<? extends Fragment> bindAndroidInjectorFactory(ManageOfferListFragmentSubcomponent.Builder builder);

    private C2878x2357de1() {
    }
}
