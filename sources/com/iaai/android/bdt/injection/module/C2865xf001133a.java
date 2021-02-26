package com.iaai.android.bdt.injection.module;

import android.app.Activity;
import com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.SearchByOdometerActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {SearchByOdometerActivitySubcomponent.class})
/* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeSearchByOdometerActivity$app_productionRelease */
public abstract class C2865xf001133a {

    @Subcomponent
    /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeSearchByOdometerActivity$app_productionRelease$SearchByOdometerActivitySubcomponent */
    /* compiled from: ActivityModule_ContributeSearchByOdometerActivity$app_productionRelease */
    public interface SearchByOdometerActivitySubcomponent extends AndroidInjector<SearchByOdometerActivity> {

        @Subcomponent.Builder
        /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeSearchByOdometerActivity$app_productionRelease$SearchByOdometerActivitySubcomponent$Builder */
        /* compiled from: ActivityModule_ContributeSearchByOdometerActivity$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<SearchByOdometerActivity> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @IntoMap
    @ActivityKey(SearchByOdometerActivity.class)
    public abstract AndroidInjector.Factory<? extends Activity> bindAndroidInjectorFactory(SearchByOdometerActivitySubcomponent.Builder builder);

    private C2865xf001133a() {
    }
}
