package com.iaai.android.bdt.injection.module;

import android.app.Activity;
import com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.SearchByACVActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {SearchByACVActivitySubcomponent.class})
/* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeSearchByACVActivity$app_productionRelease */
public abstract class C2863xd79c7c1f {

    @Subcomponent
    /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeSearchByACVActivity$app_productionRelease$SearchByACVActivitySubcomponent */
    /* compiled from: ActivityModule_ContributeSearchByACVActivity$app_productionRelease */
    public interface SearchByACVActivitySubcomponent extends AndroidInjector<SearchByACVActivity> {

        @Subcomponent.Builder
        /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeSearchByACVActivity$app_productionRelease$SearchByACVActivitySubcomponent$Builder */
        /* compiled from: ActivityModule_ContributeSearchByACVActivity$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<SearchByACVActivity> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @IntoMap
    @ActivityKey(SearchByACVActivity.class)
    public abstract AndroidInjector.Factory<? extends Activity> bindAndroidInjectorFactory(SearchByACVActivitySubcomponent.Builder builder);

    private C2863xd79c7c1f() {
    }
}
