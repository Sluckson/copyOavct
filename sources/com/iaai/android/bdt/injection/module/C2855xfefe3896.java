package com.iaai.android.bdt.injection.module;

import android.app.Activity;
import com.iaai.android.bdt.feature.account.salesdocument.manageBranchPref.ManageBranchPrefActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {ManageBranchPrefActivitySubcomponent.class})
/* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeManageBranchPrefActivity$app_productionRelease */
public abstract class C2855xfefe3896 {

    @Subcomponent
    /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeManageBranchPrefActivity$app_productionRelease$ManageBranchPrefActivitySubcomponent */
    /* compiled from: ActivityModule_ContributeManageBranchPrefActivity$app_productionRelease */
    public interface ManageBranchPrefActivitySubcomponent extends AndroidInjector<ManageBranchPrefActivity> {

        @Subcomponent.Builder
        /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeManageBranchPrefActivity$app_productionRelease$ManageBranchPrefActivitySubcomponent$Builder */
        /* compiled from: ActivityModule_ContributeManageBranchPrefActivity$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<ManageBranchPrefActivity> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @IntoMap
    @ActivityKey(ManageBranchPrefActivity.class)
    public abstract AndroidInjector.Factory<? extends Activity> bindAndroidInjectorFactory(ManageBranchPrefActivitySubcomponent.Builder builder);

    private C2855xfefe3896() {
    }
}
