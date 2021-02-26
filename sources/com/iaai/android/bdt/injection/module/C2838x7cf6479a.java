package com.iaai.android.bdt.injection.module;

import android.app.Activity;
import com.iaai.android.bdt.feature.login.BDTForgotPasswordActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {BDTForgotPasswordActivitySubcomponent.class})
/* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeBDTForgotPasswordActivity$app_productionRelease */
public abstract class C2838x7cf6479a {

    @Subcomponent
    /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeBDTForgotPasswordActivity$app_productionRelease$BDTForgotPasswordActivitySubcomponent */
    /* compiled from: ActivityModule_ContributeBDTForgotPasswordActivity$app_productionRelease */
    public interface BDTForgotPasswordActivitySubcomponent extends AndroidInjector<BDTForgotPasswordActivity> {

        @Subcomponent.Builder
        /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeBDTForgotPasswordActivity$app_productionRelease$BDTForgotPasswordActivitySubcomponent$Builder */
        /* compiled from: ActivityModule_ContributeBDTForgotPasswordActivity$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<BDTForgotPasswordActivity> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @IntoMap
    @ActivityKey(BDTForgotPasswordActivity.class)
    public abstract AndroidInjector.Factory<? extends Activity> bindAndroidInjectorFactory(BDTForgotPasswordActivitySubcomponent.Builder builder);

    private C2838x7cf6479a() {
    }
}
