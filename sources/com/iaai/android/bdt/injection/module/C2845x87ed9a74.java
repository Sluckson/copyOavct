package com.iaai.android.bdt.injection.module;

import android.app.Activity;
import com.iaai.android.bdt.feature.account.buyNowOfferList.BuyNowOfferListActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {BuyNowOfferListActivitySubcomponent.class})
/* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeBuyNowOfferListActivity$app_productionRelease */
public abstract class C2845x87ed9a74 {

    @Subcomponent
    /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeBuyNowOfferListActivity$app_productionRelease$BuyNowOfferListActivitySubcomponent */
    /* compiled from: ActivityModule_ContributeBuyNowOfferListActivity$app_productionRelease */
    public interface BuyNowOfferListActivitySubcomponent extends AndroidInjector<BuyNowOfferListActivity> {

        @Subcomponent.Builder
        /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeBuyNowOfferListActivity$app_productionRelease$BuyNowOfferListActivitySubcomponent$Builder */
        /* compiled from: ActivityModule_ContributeBuyNowOfferListActivity$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<BuyNowOfferListActivity> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @IntoMap
    @ActivityKey(BuyNowOfferListActivity.class)
    public abstract AndroidInjector.Factory<? extends Activity> bindAndroidInjectorFactory(BuyNowOfferListActivitySubcomponent.Builder builder);

    private C2845x87ed9a74() {
    }
}
