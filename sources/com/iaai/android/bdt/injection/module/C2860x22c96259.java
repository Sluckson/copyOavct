package com.iaai.android.bdt.injection.module;

import android.app.Activity;
import com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList.SaleDocListActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {SaleDocListActivitySubcomponent.class})
/* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeSaleDocListActivity$app_productionRelease */
public abstract class C2860x22c96259 {

    @Subcomponent
    /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeSaleDocListActivity$app_productionRelease$SaleDocListActivitySubcomponent */
    /* compiled from: ActivityModule_ContributeSaleDocListActivity$app_productionRelease */
    public interface SaleDocListActivitySubcomponent extends AndroidInjector<SaleDocListActivity> {

        @Subcomponent.Builder
        /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeSaleDocListActivity$app_productionRelease$SaleDocListActivitySubcomponent$Builder */
        /* compiled from: ActivityModule_ContributeSaleDocListActivity$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<SaleDocListActivity> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @IntoMap
    @ActivityKey(SaleDocListActivity.class)
    public abstract AndroidInjector.Factory<? extends Activity> bindAndroidInjectorFactory(SaleDocListActivitySubcomponent.Builder builder);

    private C2860x22c96259() {
    }
}
