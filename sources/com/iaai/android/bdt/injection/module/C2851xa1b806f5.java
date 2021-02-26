package com.iaai.android.bdt.injection.module;

import android.app.Activity;
import com.iaai.android.bdt.feature.findVehiclePage.filter.FindVehicleFilterActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {FindVehicleFilterActivitySubcomponent.class})
/* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeFindVehicleFilterActivity$app_productionRelease */
public abstract class C2851xa1b806f5 {

    @Subcomponent
    /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeFindVehicleFilterActivity$app_productionRelease$FindVehicleFilterActivitySubcomponent */
    /* compiled from: ActivityModule_ContributeFindVehicleFilterActivity$app_productionRelease */
    public interface FindVehicleFilterActivitySubcomponent extends AndroidInjector<FindVehicleFilterActivity> {

        @Subcomponent.Builder
        /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeFindVehicleFilterActivity$app_productionRelease$FindVehicleFilterActivitySubcomponent$Builder */
        /* compiled from: ActivityModule_ContributeFindVehicleFilterActivity$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<FindVehicleFilterActivity> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @IntoMap
    @ActivityKey(FindVehicleFilterActivity.class)
    public abstract AndroidInjector.Factory<? extends Activity> bindAndroidInjectorFactory(FindVehicleFilterActivitySubcomponent.Builder builder);

    private C2851xa1b806f5() {
    }
}
