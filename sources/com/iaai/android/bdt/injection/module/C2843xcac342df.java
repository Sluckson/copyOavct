package com.iaai.android.bdt.injection.module;

import android.app.Activity;
import com.iaai.android.bdt.feature.account.BDTSettingsActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {BDTSettingsActivitySubcomponent.class})
/* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeBDTSettingsActivity$app_productionRelease */
public abstract class C2843xcac342df {

    @Subcomponent
    /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeBDTSettingsActivity$app_productionRelease$BDTSettingsActivitySubcomponent */
    /* compiled from: ActivityModule_ContributeBDTSettingsActivity$app_productionRelease */
    public interface BDTSettingsActivitySubcomponent extends AndroidInjector<BDTSettingsActivity> {

        @Subcomponent.Builder
        /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeBDTSettingsActivity$app_productionRelease$BDTSettingsActivitySubcomponent$Builder */
        /* compiled from: ActivityModule_ContributeBDTSettingsActivity$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<BDTSettingsActivity> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @IntoMap
    @ActivityKey(BDTSettingsActivity.class)
    public abstract AndroidInjector.Factory<? extends Activity> bindAndroidInjectorFactory(BDTSettingsActivitySubcomponent.Builder builder);

    private C2843xcac342df() {
    }
}
