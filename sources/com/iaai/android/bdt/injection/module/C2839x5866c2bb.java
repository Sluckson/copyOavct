package com.iaai.android.bdt.injection.module;

import android.app.Activity;
import com.iaai.android.bdt.feature.account.BDTMyAccountActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {BDTMyAccountActivitySubcomponent.class})
/* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeBDTMyAccountActivity$app_productionRelease */
public abstract class C2839x5866c2bb {

    @Subcomponent
    /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeBDTMyAccountActivity$app_productionRelease$BDTMyAccountActivitySubcomponent */
    /* compiled from: ActivityModule_ContributeBDTMyAccountActivity$app_productionRelease */
    public interface BDTMyAccountActivitySubcomponent extends AndroidInjector<BDTMyAccountActivity> {

        @Subcomponent.Builder
        /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeBDTMyAccountActivity$app_productionRelease$BDTMyAccountActivitySubcomponent$Builder */
        /* compiled from: ActivityModule_ContributeBDTMyAccountActivity$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<BDTMyAccountActivity> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @IntoMap
    @ActivityKey(BDTMyAccountActivity.class)
    public abstract AndroidInjector.Factory<? extends Activity> bindAndroidInjectorFactory(BDTMyAccountActivitySubcomponent.Builder builder);

    private C2839x5866c2bb() {
    }
}
