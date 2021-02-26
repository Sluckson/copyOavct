package com.iaai.android.bdt.injection.module;

import android.app.Activity;
import com.iaai.android.bdt.feature.myAccount.toBePaid.BDTPaymentMethodActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {BDTPaymentMethodActivitySubcomponent.class})
/* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeBDTPaymentMethodActivity$app_productionRelease */
public abstract class C2840xc5ac0c61 {

    @Subcomponent
    /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeBDTPaymentMethodActivity$app_productionRelease$BDTPaymentMethodActivitySubcomponent */
    /* compiled from: ActivityModule_ContributeBDTPaymentMethodActivity$app_productionRelease */
    public interface BDTPaymentMethodActivitySubcomponent extends AndroidInjector<BDTPaymentMethodActivity> {

        @Subcomponent.Builder
        /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeBDTPaymentMethodActivity$app_productionRelease$BDTPaymentMethodActivitySubcomponent$Builder */
        /* compiled from: ActivityModule_ContributeBDTPaymentMethodActivity$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<BDTPaymentMethodActivity> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @IntoMap
    @ActivityKey(BDTPaymentMethodActivity.class)
    public abstract AndroidInjector.Factory<? extends Activity> bindAndroidInjectorFactory(BDTPaymentMethodActivitySubcomponent.Builder builder);

    private C2840xc5ac0c61() {
    }
}
