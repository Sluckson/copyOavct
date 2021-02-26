package com.iaai.android.bdt.injection.module;

import android.app.Activity;
import com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.FastSearchFilterActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {FastSearchFilterActivitySubcomponent.class})
/* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeFastSearchFilterActivity$app_productionRelease */
public abstract class C2850xe66294a8 {

    @Subcomponent
    /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeFastSearchFilterActivity$app_productionRelease$FastSearchFilterActivitySubcomponent */
    /* compiled from: ActivityModule_ContributeFastSearchFilterActivity$app_productionRelease */
    public interface FastSearchFilterActivitySubcomponent extends AndroidInjector<FastSearchFilterActivity> {

        @Subcomponent.Builder
        /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeFastSearchFilterActivity$app_productionRelease$FastSearchFilterActivitySubcomponent$Builder */
        /* compiled from: ActivityModule_ContributeFastSearchFilterActivity$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<FastSearchFilterActivity> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @IntoMap
    @ActivityKey(FastSearchFilterActivity.class)
    public abstract AndroidInjector.Factory<? extends Activity> bindAndroidInjectorFactory(FastSearchFilterActivitySubcomponent.Builder builder);

    private C2850xe66294a8() {
    }
}
