package com.iaai.android.bdt.injection.module;

import android.app.Activity;
import com.iaai.android.bdt.feature.auctionMainPage.AuctionDateListActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {AuctionDateListActivitySubcomponent.class})
/* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeAuctionDateListActivity$app_productionRelease */
public abstract class C2833xec933ff9 {

    @Subcomponent
    /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeAuctionDateListActivity$app_productionRelease$AuctionDateListActivitySubcomponent */
    /* compiled from: ActivityModule_ContributeAuctionDateListActivity$app_productionRelease */
    public interface AuctionDateListActivitySubcomponent extends AndroidInjector<AuctionDateListActivity> {

        @Subcomponent.Builder
        /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeAuctionDateListActivity$app_productionRelease$AuctionDateListActivitySubcomponent$Builder */
        /* compiled from: ActivityModule_ContributeAuctionDateListActivity$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<AuctionDateListActivity> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @IntoMap
    @ActivityKey(AuctionDateListActivity.class)
    public abstract AndroidInjector.Factory<? extends Activity> bindAndroidInjectorFactory(AuctionDateListActivitySubcomponent.Builder builder);

    private C2833xec933ff9() {
    }
}
