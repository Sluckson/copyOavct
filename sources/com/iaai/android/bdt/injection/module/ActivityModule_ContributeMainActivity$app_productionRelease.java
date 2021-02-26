package com.iaai.android.bdt.injection.module;

import android.app.Activity;
import com.iaai.android.bdt.feature.main.MainActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {MainActivitySubcomponent.class})
public abstract class ActivityModule_ContributeMainActivity$app_productionRelease {

    @Subcomponent
    /* compiled from: ActivityModule_ContributeMainActivity$app_productionRelease */
    public interface MainActivitySubcomponent extends AndroidInjector<MainActivity> {

        @Subcomponent.Builder
        /* compiled from: ActivityModule_ContributeMainActivity$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<MainActivity> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    public abstract AndroidInjector.Factory<? extends Activity> bindAndroidInjectorFactory(MainActivitySubcomponent.Builder builder);

    private ActivityModule_ContributeMainActivity$app_productionRelease() {
    }
}
