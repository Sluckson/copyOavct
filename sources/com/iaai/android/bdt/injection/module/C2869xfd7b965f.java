package com.iaai.android.bdt.injection.module;

import android.app.Activity;
import com.iaai.android.bdt.feature.login.emailValidation.ValidateOTPActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {ValidateOTPActivitySubcomponent.class})
/* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeValidateOTPActivity$app_productionRelease */
public abstract class C2869xfd7b965f {

    @Subcomponent
    /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeValidateOTPActivity$app_productionRelease$ValidateOTPActivitySubcomponent */
    /* compiled from: ActivityModule_ContributeValidateOTPActivity$app_productionRelease */
    public interface ValidateOTPActivitySubcomponent extends AndroidInjector<ValidateOTPActivity> {

        @Subcomponent.Builder
        /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeValidateOTPActivity$app_productionRelease$ValidateOTPActivitySubcomponent$Builder */
        /* compiled from: ActivityModule_ContributeValidateOTPActivity$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<ValidateOTPActivity> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @IntoMap
    @ActivityKey(ValidateOTPActivity.class)
    public abstract AndroidInjector.Factory<? extends Activity> bindAndroidInjectorFactory(ValidateOTPActivitySubcomponent.Builder builder);

    private C2869xfd7b965f() {
    }
}
