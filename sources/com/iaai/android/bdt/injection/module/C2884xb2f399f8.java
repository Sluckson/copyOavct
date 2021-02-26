package com.iaai.android.bdt.injection.module;

import androidx.fragment.app.Fragment;
import com.iaai.android.bdt.feature.myAccount.toBePaid.BDTToBePaidFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {BDTToBePaidFragmentSubcomponent.class})
/* renamed from: com.iaai.android.bdt.injection.module.FragmentModule_ContributeSelectVehiclesCreditCardFragment$app_productionRelease */
public abstract class C2884xb2f399f8 {

    @Subcomponent
    /* renamed from: com.iaai.android.bdt.injection.module.FragmentModule_ContributeSelectVehiclesCreditCardFragment$app_productionRelease$BDTToBePaidFragmentSubcomponent */
    /* compiled from: FragmentModule_ContributeSelectVehiclesCreditCardFragment$app_productionRelease */
    public interface BDTToBePaidFragmentSubcomponent extends AndroidInjector<BDTToBePaidFragment> {

        @Subcomponent.Builder
        /* renamed from: com.iaai.android.bdt.injection.module.FragmentModule_ContributeSelectVehiclesCreditCardFragment$app_productionRelease$BDTToBePaidFragmentSubcomponent$Builder */
        /* compiled from: FragmentModule_ContributeSelectVehiclesCreditCardFragment$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<BDTToBePaidFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @FragmentKey(BDTToBePaidFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<? extends Fragment> bindAndroidInjectorFactory(BDTToBePaidFragmentSubcomponent.Builder builder);

    private C2884xb2f399f8() {
    }
}
