package com.iaai.android.bdt.injection.module;

import android.app.Activity;
import com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {AuctionSalesListActivitySubcomponent.class})
/* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeAuctionSalesListActivity$app_productionRelease */
public abstract class C2835x9781d273 {

    @Subcomponent
    /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeAuctionSalesListActivity$app_productionRelease$AuctionSalesListActivitySubcomponent */
    /* compiled from: ActivityModule_ContributeAuctionSalesListActivity$app_productionRelease */
    public interface AuctionSalesListActivitySubcomponent extends AndroidInjector<AuctionSalesListActivity> {

        @Subcomponent.Builder
        /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeAuctionSalesListActivity$app_productionRelease$AuctionSalesListActivitySubcomponent$Builder */
        /* compiled from: ActivityModule_ContributeAuctionSalesListActivity$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<AuctionSalesListActivity> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @IntoMap
    @ActivityKey(AuctionSalesListActivity.class)
    public abstract AndroidInjector.Factory<? extends Activity> bindAndroidInjectorFactory(AuctionSalesListActivitySubcomponent.Builder builder);

    private C2835x9781d273() {
    }
}
