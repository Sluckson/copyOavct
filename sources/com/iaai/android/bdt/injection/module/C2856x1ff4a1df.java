package com.iaai.android.bdt.injection.module;

import android.app.Activity;
import com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {ManageOfferListActivitySubcomponent.class})
/* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeManageOfferListActivity$app_productionRelease */
public abstract class C2856x1ff4a1df {

    @Subcomponent
    /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeManageOfferListActivity$app_productionRelease$ManageOfferListActivitySubcomponent */
    /* compiled from: ActivityModule_ContributeManageOfferListActivity$app_productionRelease */
    public interface ManageOfferListActivitySubcomponent extends AndroidInjector<ManageOfferListActivity> {

        @Subcomponent.Builder
        /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeManageOfferListActivity$app_productionRelease$ManageOfferListActivitySubcomponent$Builder */
        /* compiled from: ActivityModule_ContributeManageOfferListActivity$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<ManageOfferListActivity> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @IntoMap
    @ActivityKey(ManageOfferListActivity.class)
    public abstract AndroidInjector.Factory<? extends Activity> bindAndroidInjectorFactory(ManageOfferListActivitySubcomponent.Builder builder);

    private C2856x1ff4a1df() {
    }
}
