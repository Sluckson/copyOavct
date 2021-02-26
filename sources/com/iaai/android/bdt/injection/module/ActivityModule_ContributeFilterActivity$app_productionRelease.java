package com.iaai.android.bdt.injection.module;

import android.app.Activity;
import com.iaai.android.bdt.feature.findVehiclePage.filter.FilterActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {FilterActivitySubcomponent.class})
public abstract class ActivityModule_ContributeFilterActivity$app_productionRelease {

    @Subcomponent
    /* compiled from: ActivityModule_ContributeFilterActivity$app_productionRelease */
    public interface FilterActivitySubcomponent extends AndroidInjector<FilterActivity> {

        @Subcomponent.Builder
        /* compiled from: ActivityModule_ContributeFilterActivity$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<FilterActivity> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @IntoMap
    @ActivityKey(FilterActivity.class)
    public abstract AndroidInjector.Factory<? extends Activity> bindAndroidInjectorFactory(FilterActivitySubcomponent.Builder builder);

    private ActivityModule_ContributeFilterActivity$app_productionRelease() {
    }
}
