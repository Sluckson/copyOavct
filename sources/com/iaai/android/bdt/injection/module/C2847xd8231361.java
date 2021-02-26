package com.iaai.android.bdt.injection.module;

import android.app.Activity;
import com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList.DeliveryMethodActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {DeliveryMethodActivitySubcomponent.class})
/* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeDeliveryMethodActivity$app_productionRelease */
public abstract class C2847xd8231361 {

    @Subcomponent
    /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeDeliveryMethodActivity$app_productionRelease$DeliveryMethodActivitySubcomponent */
    /* compiled from: ActivityModule_ContributeDeliveryMethodActivity$app_productionRelease */
    public interface DeliveryMethodActivitySubcomponent extends AndroidInjector<DeliveryMethodActivity> {

        @Subcomponent.Builder
        /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeDeliveryMethodActivity$app_productionRelease$DeliveryMethodActivitySubcomponent$Builder */
        /* compiled from: ActivityModule_ContributeDeliveryMethodActivity$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<DeliveryMethodActivity> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @IntoMap
    @ActivityKey(DeliveryMethodActivity.class)
    public abstract AndroidInjector.Factory<? extends Activity> bindAndroidInjectorFactory(DeliveryMethodActivitySubcomponent.Builder builder);

    private C2847xd8231361() {
    }
}
