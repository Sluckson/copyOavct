package com.iaai.android.bdt.injection.module;

import android.app.Activity;
import com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {RefinerResultActivitySubcomponent.class})
/* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeRefinerResultActivity$app_productionRelease */
public abstract class C2859xf0fafcc {

    @Subcomponent
    /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeRefinerResultActivity$app_productionRelease$RefinerResultActivitySubcomponent */
    /* compiled from: ActivityModule_ContributeRefinerResultActivity$app_productionRelease */
    public interface RefinerResultActivitySubcomponent extends AndroidInjector<RefinerResultActivity> {

        @Subcomponent.Builder
        /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeRefinerResultActivity$app_productionRelease$RefinerResultActivitySubcomponent$Builder */
        /* compiled from: ActivityModule_ContributeRefinerResultActivity$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<RefinerResultActivity> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @IntoMap
    @ActivityKey(RefinerResultActivity.class)
    public abstract AndroidInjector.Factory<? extends Activity> bindAndroidInjectorFactory(RefinerResultActivitySubcomponent.Builder builder);

    private C2859xf0fafcc() {
    }
}
