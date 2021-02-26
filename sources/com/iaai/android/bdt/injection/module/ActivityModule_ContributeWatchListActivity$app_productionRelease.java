package com.iaai.android.bdt.injection.module;

import android.app.Activity;
import com.iaai.android.bdt.feature.account.watchlist.PreSaleListActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {PreSaleListActivitySubcomponent.class})
public abstract class ActivityModule_ContributeWatchListActivity$app_productionRelease {

    @Subcomponent
    /* compiled from: ActivityModule_ContributeWatchListActivity$app_productionRelease */
    public interface PreSaleListActivitySubcomponent extends AndroidInjector<PreSaleListActivity> {

        @Subcomponent.Builder
        /* compiled from: ActivityModule_ContributeWatchListActivity$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<PreSaleListActivity> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @IntoMap
    @ActivityKey(PreSaleListActivity.class)
    public abstract AndroidInjector.Factory<? extends Activity> bindAndroidInjectorFactory(PreSaleListActivitySubcomponent.Builder builder);

    private ActivityModule_ContributeWatchListActivity$app_productionRelease() {
    }
}
