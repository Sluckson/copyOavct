package com.iaai.android.bdt.injection.module;

import android.app.Activity;
import com.iaai.android.bdt.feature.findVehiclePage.filter.MakeModelFilterActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {MakeModelFilterActivitySubcomponent.class})
/* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeMakeModelFilterActivity$app_productionRelease */
public abstract class C2854xfcdecd5d {

    @Subcomponent
    /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeMakeModelFilterActivity$app_productionRelease$MakeModelFilterActivitySubcomponent */
    /* compiled from: ActivityModule_ContributeMakeModelFilterActivity$app_productionRelease */
    public interface MakeModelFilterActivitySubcomponent extends AndroidInjector<MakeModelFilterActivity> {

        @Subcomponent.Builder
        /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeMakeModelFilterActivity$app_productionRelease$MakeModelFilterActivitySubcomponent$Builder */
        /* compiled from: ActivityModule_ContributeMakeModelFilterActivity$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<MakeModelFilterActivity> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @IntoMap
    @ActivityKey(MakeModelFilterActivity.class)
    public abstract AndroidInjector.Factory<? extends Activity> bindAndroidInjectorFactory(MakeModelFilterActivitySubcomponent.Builder builder);

    private C2854xfcdecd5d() {
    }
}
