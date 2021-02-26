package com.iaai.android.bdt.injection.module;

import android.app.Activity;
import com.iaai.android.bdt.feature.landing.LandingBRESectionActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {LandingBRESectionActivitySubcomponent.class})
/* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeLandingBRESectionActivity$app_productionRelease */
public abstract class C2853xa62b51f1 {

    @Subcomponent
    /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeLandingBRESectionActivity$app_productionRelease$LandingBRESectionActivitySubcomponent */
    /* compiled from: ActivityModule_ContributeLandingBRESectionActivity$app_productionRelease */
    public interface LandingBRESectionActivitySubcomponent extends AndroidInjector<LandingBRESectionActivity> {

        @Subcomponent.Builder
        /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeLandingBRESectionActivity$app_productionRelease$LandingBRESectionActivitySubcomponent$Builder */
        /* compiled from: ActivityModule_ContributeLandingBRESectionActivity$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<LandingBRESectionActivity> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @IntoMap
    @ActivityKey(LandingBRESectionActivity.class)
    public abstract AndroidInjector.Factory<? extends Activity> bindAndroidInjectorFactory(LandingBRESectionActivitySubcomponent.Builder builder);

    private C2853xa62b51f1() {
    }
}
