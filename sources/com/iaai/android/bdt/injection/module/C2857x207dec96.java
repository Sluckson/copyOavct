package com.iaai.android.bdt.injection.module;

import android.app.Activity;
import com.iaai.android.bdt.feature.onBoarding.OnBoardingActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {OnBoardingActivitySubcomponent.class})
/* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeOnBoardingActivityActivity$app_productionRelease */
public abstract class C2857x207dec96 {

    @Subcomponent
    /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeOnBoardingActivityActivity$app_productionRelease$OnBoardingActivitySubcomponent */
    /* compiled from: ActivityModule_ContributeOnBoardingActivityActivity$app_productionRelease */
    public interface OnBoardingActivitySubcomponent extends AndroidInjector<OnBoardingActivity> {

        @Subcomponent.Builder
        /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeOnBoardingActivityActivity$app_productionRelease$OnBoardingActivitySubcomponent$Builder */
        /* compiled from: ActivityModule_ContributeOnBoardingActivityActivity$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<OnBoardingActivity> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @IntoMap
    @ActivityKey(OnBoardingActivity.class)
    public abstract AndroidInjector.Factory<? extends Activity> bindAndroidInjectorFactory(OnBoardingActivitySubcomponent.Builder builder);

    private C2857x207dec96() {
    }
}
