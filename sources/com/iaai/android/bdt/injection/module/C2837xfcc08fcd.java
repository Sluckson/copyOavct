package com.iaai.android.bdt.injection.module;

import android.app.Activity;
import com.iaai.android.bdt.feature.landing.BDTLandingPageActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {BDTLandingPageActivitySubcomponent.class})
/* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeBDTFindVehicleActivity$app_productionRelease */
public abstract class C2837xfcc08fcd {

    @Subcomponent
    /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeBDTFindVehicleActivity$app_productionRelease$BDTLandingPageActivitySubcomponent */
    /* compiled from: ActivityModule_ContributeBDTFindVehicleActivity$app_productionRelease */
    public interface BDTLandingPageActivitySubcomponent extends AndroidInjector<BDTLandingPageActivity> {

        @Subcomponent.Builder
        /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeBDTFindVehicleActivity$app_productionRelease$BDTLandingPageActivitySubcomponent$Builder */
        /* compiled from: ActivityModule_ContributeBDTFindVehicleActivity$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<BDTLandingPageActivity> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @IntoMap
    @ActivityKey(BDTLandingPageActivity.class)
    public abstract AndroidInjector.Factory<? extends Activity> bindAndroidInjectorFactory(BDTLandingPageActivitySubcomponent.Builder builder);

    private C2837xfcc08fcd() {
    }
}
