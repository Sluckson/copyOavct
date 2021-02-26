package com.iaai.android.bdt.injection.module;

import android.app.Activity;
import com.iaai.android.bdt.base.BaseActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {BaseActivitySubcomponent.class})
public abstract class ActivityModule_ContributeBaseActivity$app_productionRelease {

    @Subcomponent
    /* compiled from: ActivityModule_ContributeBaseActivity$app_productionRelease */
    public interface BaseActivitySubcomponent extends AndroidInjector<BaseActivity> {

        @Subcomponent.Builder
        /* compiled from: ActivityModule_ContributeBaseActivity$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<BaseActivity> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @IntoMap
    @ActivityKey(BaseActivity.class)
    public abstract AndroidInjector.Factory<? extends Activity> bindAndroidInjectorFactory(BaseActivitySubcomponent.Builder builder);

    private ActivityModule_ContributeBaseActivity$app_productionRelease() {
    }
}
