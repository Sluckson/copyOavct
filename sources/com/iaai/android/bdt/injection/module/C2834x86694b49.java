package com.iaai.android.bdt.injection.module;

import android.app.Activity;
import com.iaai.android.bdt.feature.productDetail.ProductDetailActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {ProductDetailActivitySubcomponent.class})
/* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeAuctionProductDetailActivity$app_productionRelease */
public abstract class C2834x86694b49 {

    @Subcomponent
    /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeAuctionProductDetailActivity$app_productionRelease$ProductDetailActivitySubcomponent */
    /* compiled from: ActivityModule_ContributeAuctionProductDetailActivity$app_productionRelease */
    public interface ProductDetailActivitySubcomponent extends AndroidInjector<ProductDetailActivity> {

        @Subcomponent.Builder
        /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeAuctionProductDetailActivity$app_productionRelease$ProductDetailActivitySubcomponent$Builder */
        /* compiled from: ActivityModule_ContributeAuctionProductDetailActivity$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<ProductDetailActivity> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @IntoMap
    @ActivityKey(ProductDetailActivity.class)
    public abstract AndroidInjector.Factory<? extends Activity> bindAndroidInjectorFactory(ProductDetailActivitySubcomponent.Builder builder);

    private C2834x86694b49() {
    }
}
