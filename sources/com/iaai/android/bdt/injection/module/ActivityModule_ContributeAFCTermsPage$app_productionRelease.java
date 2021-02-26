package com.iaai.android.bdt.injection.module;

import android.app.Activity;
import com.iaai.android.bdt.feature.account.watchlist.ReceiptDPFActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {ReceiptDPFActivitySubcomponent.class})
public abstract class ActivityModule_ContributeAFCTermsPage$app_productionRelease {

    @Subcomponent
    /* compiled from: ActivityModule_ContributeAFCTermsPage$app_productionRelease */
    public interface ReceiptDPFActivitySubcomponent extends AndroidInjector<ReceiptDPFActivity> {

        @Subcomponent.Builder
        /* compiled from: ActivityModule_ContributeAFCTermsPage$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<ReceiptDPFActivity> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @IntoMap
    @ActivityKey(ReceiptDPFActivity.class)
    public abstract AndroidInjector.Factory<? extends Activity> bindAndroidInjectorFactory(ReceiptDPFActivitySubcomponent.Builder builder);

    private ActivityModule_ContributeAFCTermsPage$app_productionRelease() {
    }
}
