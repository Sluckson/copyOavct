package com.iaai.android.bdt.injection.module;

import android.app.Activity;
import com.iaai.android.bdt.feature.login.BDTTermsOfUseActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {BDTTermsOfUseActivitySubcomponent.class})
/* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeBDTTermsOfUseActivity$app_productionRelease */
public abstract class C2844xbb69ae5 {

    @Subcomponent
    /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeBDTTermsOfUseActivity$app_productionRelease$BDTTermsOfUseActivitySubcomponent */
    /* compiled from: ActivityModule_ContributeBDTTermsOfUseActivity$app_productionRelease */
    public interface BDTTermsOfUseActivitySubcomponent extends AndroidInjector<BDTTermsOfUseActivity> {

        @Subcomponent.Builder
        /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeBDTTermsOfUseActivity$app_productionRelease$BDTTermsOfUseActivitySubcomponent$Builder */
        /* compiled from: ActivityModule_ContributeBDTTermsOfUseActivity$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<BDTTermsOfUseActivity> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @IntoMap
    @ActivityKey(BDTTermsOfUseActivity.class)
    public abstract AndroidInjector.Factory<? extends Activity> bindAndroidInjectorFactory(BDTTermsOfUseActivitySubcomponent.Builder builder);

    private C2844xbb69ae5() {
    }
}
