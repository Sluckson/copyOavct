package com.iaai.android.bdt.injection.module;

import androidx.fragment.app.Fragment;
import com.iaai.android.bdt.feature.myAccount.toBePaid.creditCard.SelectCreditCardFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {SelectCreditCardFragmentSubcomponent.class})
/* renamed from: com.iaai.android.bdt.injection.module.FragmentModule_ContributeSelectCreditCardFragment$app_productionRelease */
public abstract class C2883x76239e11 {

    @Subcomponent
    /* renamed from: com.iaai.android.bdt.injection.module.FragmentModule_ContributeSelectCreditCardFragment$app_productionRelease$SelectCreditCardFragmentSubcomponent */
    /* compiled from: FragmentModule_ContributeSelectCreditCardFragment$app_productionRelease */
    public interface SelectCreditCardFragmentSubcomponent extends AndroidInjector<SelectCreditCardFragment> {

        @Subcomponent.Builder
        /* renamed from: com.iaai.android.bdt.injection.module.FragmentModule_ContributeSelectCreditCardFragment$app_productionRelease$SelectCreditCardFragmentSubcomponent$Builder */
        /* compiled from: FragmentModule_ContributeSelectCreditCardFragment$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<SelectCreditCardFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @FragmentKey(SelectCreditCardFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<? extends Fragment> bindAndroidInjectorFactory(SelectCreditCardFragmentSubcomponent.Builder builder);

    private C2883x76239e11() {
    }
}
