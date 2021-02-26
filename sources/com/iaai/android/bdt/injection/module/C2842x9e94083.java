package com.iaai.android.bdt.injection.module;

import android.app.Activity;
import com.iaai.android.bdt.feature.login.BDTPromptPasswordDialogActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {BDTPromptPasswordDialogActivitySubcomponent.class})
/* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeBDTPromptPasswordDialogActivity$app_productionRelease */
public abstract class C2842x9e94083 {

    @Subcomponent
    /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeBDTPromptPasswordDialogActivity$app_productionRelease$BDTPromptPasswordDialogActivitySubcomponent */
    /* compiled from: ActivityModule_ContributeBDTPromptPasswordDialogActivity$app_productionRelease */
    public interface BDTPromptPasswordDialogActivitySubcomponent extends AndroidInjector<BDTPromptPasswordDialogActivity> {

        @Subcomponent.Builder
        /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeBDTPromptPasswordDialogActivity$app_productionRelease$BDTPromptPasswordDialogActivitySubcomponent$Builder */
        /* compiled from: ActivityModule_ContributeBDTPromptPasswordDialogActivity$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<BDTPromptPasswordDialogActivity> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @IntoMap
    @ActivityKey(BDTPromptPasswordDialogActivity.class)
    public abstract AndroidInjector.Factory<? extends Activity> bindAndroidInjectorFactory(BDTPromptPasswordDialogActivitySubcomponent.Builder builder);

    private C2842x9e94083() {
    }
}
