package com.iaai.android.bdt.injection.module;

import android.app.Activity;
import com.iaai.android.bdt.feature.productDetail.reports.BDTPremiumVehicleReportActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {BDTPremiumVehicleReportActivitySubcomponent.class})
/* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeBDTPremiumVehicleReportActivity$app_productionRelease */
public abstract class C2841x2bca5525 {

    @Subcomponent
    /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeBDTPremiumVehicleReportActivity$app_productionRelease$BDTPremiumVehicleReportActivitySubcomponent */
    /* compiled from: ActivityModule_ContributeBDTPremiumVehicleReportActivity$app_productionRelease */
    public interface BDTPremiumVehicleReportActivitySubcomponent extends AndroidInjector<BDTPremiumVehicleReportActivity> {

        @Subcomponent.Builder
        /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeBDTPremiumVehicleReportActivity$app_productionRelease$BDTPremiumVehicleReportActivitySubcomponent$Builder */
        /* compiled from: ActivityModule_ContributeBDTPremiumVehicleReportActivity$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<BDTPremiumVehicleReportActivity> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @IntoMap
    @ActivityKey(BDTPremiumVehicleReportActivity.class)
    public abstract AndroidInjector.Factory<? extends Activity> bindAndroidInjectorFactory(BDTPremiumVehicleReportActivitySubcomponent.Builder builder);

    private C2841x2bca5525() {
    }
}
