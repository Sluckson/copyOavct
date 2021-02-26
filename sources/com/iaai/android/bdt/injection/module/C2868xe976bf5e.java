package com.iaai.android.bdt.injection.module;

import android.app.Activity;
import com.iaai.android.bdt.feature.account.tobepickedup.ToPickedUpAccountActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {ToPickedUpAccountActivitySubcomponent.class})
/* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeToBePickedUpAccountActivity$app_productionRelease */
public abstract class C2868xe976bf5e {

    @Subcomponent
    /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeToBePickedUpAccountActivity$app_productionRelease$ToPickedUpAccountActivitySubcomponent */
    /* compiled from: ActivityModule_ContributeToBePickedUpAccountActivity$app_productionRelease */
    public interface ToPickedUpAccountActivitySubcomponent extends AndroidInjector<ToPickedUpAccountActivity> {

        @Subcomponent.Builder
        /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeToBePickedUpAccountActivity$app_productionRelease$ToPickedUpAccountActivitySubcomponent$Builder */
        /* compiled from: ActivityModule_ContributeToBePickedUpAccountActivity$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<ToPickedUpAccountActivity> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @IntoMap
    @ActivityKey(ToPickedUpAccountActivity.class)
    public abstract AndroidInjector.Factory<? extends Activity> bindAndroidInjectorFactory(ToPickedUpAccountActivitySubcomponent.Builder builder);

    private C2868xe976bf5e() {
    }
}
