package com.iaai.android.bdt.injection.module;

import android.app.Activity;
import com.iaai.android.bdt.feature.productDetail.EngineVideoActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {EngineVideoActivitySubcomponent.class})
/* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeEngineVideoActivity$app_productionRelease */
public abstract class C2849x8913c883 {

    @Subcomponent
    /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeEngineVideoActivity$app_productionRelease$EngineVideoActivitySubcomponent */
    /* compiled from: ActivityModule_ContributeEngineVideoActivity$app_productionRelease */
    public interface EngineVideoActivitySubcomponent extends AndroidInjector<EngineVideoActivity> {

        @Subcomponent.Builder
        /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeEngineVideoActivity$app_productionRelease$EngineVideoActivitySubcomponent$Builder */
        /* compiled from: ActivityModule_ContributeEngineVideoActivity$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<EngineVideoActivity> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @IntoMap
    @ActivityKey(EngineVideoActivity.class)
    public abstract AndroidInjector.Factory<? extends Activity> bindAndroidInjectorFactory(EngineVideoActivitySubcomponent.Builder builder);

    private C2849x8913c883() {
    }
}
