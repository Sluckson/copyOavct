package com.iaai.android.bdt.injection.module;

import android.app.Activity;
import com.iaai.android.bdt.feature.applaunch.SplashActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {SplashActivitySubcomponent.class})
public abstract class ActivityModule_ContributeSplashActivity$app_productionRelease {

    @Subcomponent
    /* compiled from: ActivityModule_ContributeSplashActivity$app_productionRelease */
    public interface SplashActivitySubcomponent extends AndroidInjector<SplashActivity> {

        @Subcomponent.Builder
        /* compiled from: ActivityModule_ContributeSplashActivity$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<SplashActivity> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @IntoMap
    @ActivityKey(SplashActivity.class)
    public abstract AndroidInjector.Factory<? extends Activity> bindAndroidInjectorFactory(SplashActivitySubcomponent.Builder builder);

    private ActivityModule_ContributeSplashActivity$app_productionRelease() {
    }
}
