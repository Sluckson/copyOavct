package com.iaai.android.bdt.injection.module;

import android.app.Activity;
import com.iaai.android.bdt.feature.productDetail.reports.IAAConditionReportActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {IAAConditionReportActivitySubcomponent.class})
/* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeIAAConditionReportActivity$app_productionRelease */
public abstract class C2852xd7732dd2 {

    @Subcomponent
    /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeIAAConditionReportActivity$app_productionRelease$IAAConditionReportActivitySubcomponent */
    /* compiled from: ActivityModule_ContributeIAAConditionReportActivity$app_productionRelease */
    public interface IAAConditionReportActivitySubcomponent extends AndroidInjector<IAAConditionReportActivity> {

        @Subcomponent.Builder
        /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeIAAConditionReportActivity$app_productionRelease$IAAConditionReportActivitySubcomponent$Builder */
        /* compiled from: ActivityModule_ContributeIAAConditionReportActivity$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<IAAConditionReportActivity> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @IntoMap
    @ActivityKey(IAAConditionReportActivity.class)
    public abstract AndroidInjector.Factory<? extends Activity> bindAndroidInjectorFactory(IAAConditionReportActivitySubcomponent.Builder builder);

    private C2852xd7732dd2() {
    }
}
