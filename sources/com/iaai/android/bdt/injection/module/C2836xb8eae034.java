package com.iaai.android.bdt.injection.module;

import android.app.Activity;
import com.iaai.android.bdt.feature.auctionMainPage.BDTAuctionMainListActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {BDTAuctionMainListActivitySubcomponent.class})
/* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeBDTAuctionMainListActivity$app_productionRelease */
public abstract class C2836xb8eae034 {

    @Subcomponent
    /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeBDTAuctionMainListActivity$app_productionRelease$BDTAuctionMainListActivitySubcomponent */
    /* compiled from: ActivityModule_ContributeBDTAuctionMainListActivity$app_productionRelease */
    public interface BDTAuctionMainListActivitySubcomponent extends AndroidInjector<BDTAuctionMainListActivity> {

        @Subcomponent.Builder
        /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeBDTAuctionMainListActivity$app_productionRelease$BDTAuctionMainListActivitySubcomponent$Builder */
        /* compiled from: ActivityModule_ContributeBDTAuctionMainListActivity$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<BDTAuctionMainListActivity> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @IntoMap
    @ActivityKey(BDTAuctionMainListActivity.class)
    public abstract AndroidInjector.Factory<? extends Activity> bindAndroidInjectorFactory(BDTAuctionMainListActivitySubcomponent.Builder builder);

    private C2836xb8eae034() {
    }
}
