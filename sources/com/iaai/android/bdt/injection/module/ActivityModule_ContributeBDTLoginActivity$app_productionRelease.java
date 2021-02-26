package com.iaai.android.bdt.injection.module;

import android.app.Activity;
import com.iaai.android.bdt.feature.login.BDTLoginActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {BDTLoginActivitySubcomponent.class})
public abstract class ActivityModule_ContributeBDTLoginActivity$app_productionRelease {

    @Subcomponent
    /* compiled from: ActivityModule_ContributeBDTLoginActivity$app_productionRelease */
    public interface BDTLoginActivitySubcomponent extends AndroidInjector<BDTLoginActivity> {

        @Subcomponent.Builder
        /* compiled from: ActivityModule_ContributeBDTLoginActivity$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<BDTLoginActivity> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @IntoMap
    @ActivityKey(BDTLoginActivity.class)
    public abstract AndroidInjector.Factory<? extends Activity> bindAndroidInjectorFactory(BDTLoginActivitySubcomponent.Builder builder);

    private ActivityModule_ContributeBDTLoginActivity$app_productionRelease() {
    }
}
