package com.iaai.android.bdt.injection.module;

import android.app.Activity;
import com.iaai.android.bdt.feature.login.emailValidation.EmailConfirmationActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {EmailConfirmationActivitySubcomponent.class})
/* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeEmailConfirmationActivity$app_productionRelease */
public abstract class C2848x7f1a6ddb {

    @Subcomponent
    /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeEmailConfirmationActivity$app_productionRelease$EmailConfirmationActivitySubcomponent */
    /* compiled from: ActivityModule_ContributeEmailConfirmationActivity$app_productionRelease */
    public interface EmailConfirmationActivitySubcomponent extends AndroidInjector<EmailConfirmationActivity> {

        @Subcomponent.Builder
        /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeEmailConfirmationActivity$app_productionRelease$EmailConfirmationActivitySubcomponent$Builder */
        /* compiled from: ActivityModule_ContributeEmailConfirmationActivity$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<EmailConfirmationActivity> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @IntoMap
    @ActivityKey(EmailConfirmationActivity.class)
    public abstract AndroidInjector.Factory<? extends Activity> bindAndroidInjectorFactory(EmailConfirmationActivitySubcomponent.Builder builder);

    private C2848x7f1a6ddb() {
    }
}
