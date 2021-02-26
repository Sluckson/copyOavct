package com.iaai.android.bdt.injection.module;

import android.app.Activity;
import com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.SearchByDistanceActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {SearchByDistanceActivitySubcomponent.class})
/* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeSearchByDistanceActivity$app_productionRelease */
public abstract class C2864xbce57620 {

    @Subcomponent
    /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeSearchByDistanceActivity$app_productionRelease$SearchByDistanceActivitySubcomponent */
    /* compiled from: ActivityModule_ContributeSearchByDistanceActivity$app_productionRelease */
    public interface SearchByDistanceActivitySubcomponent extends AndroidInjector<SearchByDistanceActivity> {

        @Subcomponent.Builder
        /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeSearchByDistanceActivity$app_productionRelease$SearchByDistanceActivitySubcomponent$Builder */
        /* compiled from: ActivityModule_ContributeSearchByDistanceActivity$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<SearchByDistanceActivity> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @IntoMap
    @ActivityKey(SearchByDistanceActivity.class)
    public abstract AndroidInjector.Factory<? extends Activity> bindAndroidInjectorFactory(SearchByDistanceActivitySubcomponent.Builder builder);

    private C2864xbce57620() {
    }
}
