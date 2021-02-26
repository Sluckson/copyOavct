package com.iaai.android.bdt.injection.module;

import android.app.Activity;
import com.iaai.android.bdt.feature.myAccount.toBePaid.BDTPaymentActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {BDTPaymentActivitySubcomponent.class})
/* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeCreditCardActivity$app_productionRelease */
public abstract class C2846xb9ae6495 {

    @Subcomponent
    /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeCreditCardActivity$app_productionRelease$BDTPaymentActivitySubcomponent */
    /* compiled from: ActivityModule_ContributeCreditCardActivity$app_productionRelease */
    public interface BDTPaymentActivitySubcomponent extends AndroidInjector<BDTPaymentActivity> {

        @Subcomponent.Builder
        /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeCreditCardActivity$app_productionRelease$BDTPaymentActivitySubcomponent$Builder */
        /* compiled from: ActivityModule_ContributeCreditCardActivity$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<BDTPaymentActivity> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @IntoMap
    @ActivityKey(BDTPaymentActivity.class)
    public abstract AndroidInjector.Factory<? extends Activity> bindAndroidInjectorFactory(BDTPaymentActivitySubcomponent.Builder builder);

    private C2846xb9ae6495() {
    }
}
