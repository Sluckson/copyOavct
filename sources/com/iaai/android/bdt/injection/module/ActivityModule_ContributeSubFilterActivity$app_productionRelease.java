package com.iaai.android.bdt.injection.module;

import android.app.Activity;
import com.iaai.android.bdt.feature.findVehiclePage.filter.SubFilterActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {SubFilterActivitySubcomponent.class})
public abstract class ActivityModule_ContributeSubFilterActivity$app_productionRelease {

    @Subcomponent
    /* compiled from: ActivityModule_ContributeSubFilterActivity$app_productionRelease */
    public interface SubFilterActivitySubcomponent extends AndroidInjector<SubFilterActivity> {

        @Subcomponent.Builder
        /* compiled from: ActivityModule_ContributeSubFilterActivity$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<SubFilterActivity> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @IntoMap
    @ActivityKey(SubFilterActivity.class)
    public abstract AndroidInjector.Factory<? extends Activity> bindAndroidInjectorFactory(SubFilterActivitySubcomponent.Builder builder);

    private ActivityModule_ContributeSubFilterActivity$app_productionRelease() {
    }
}
