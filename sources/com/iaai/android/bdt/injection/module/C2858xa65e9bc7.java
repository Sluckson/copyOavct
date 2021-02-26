package com.iaai.android.bdt.injection.module;

import android.app.Activity;
import com.iaai.android.bdt.feature.productDetail.vehicleimage.Product360ImageActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {Product360ImageActivitySubcomponent.class})
/* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeProduct360ImageActivity$app_productionRelease */
public abstract class C2858xa65e9bc7 {

    @Subcomponent
    /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeProduct360ImageActivity$app_productionRelease$Product360ImageActivitySubcomponent */
    /* compiled from: ActivityModule_ContributeProduct360ImageActivity$app_productionRelease */
    public interface Product360ImageActivitySubcomponent extends AndroidInjector<Product360ImageActivity> {

        @Subcomponent.Builder
        /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeProduct360ImageActivity$app_productionRelease$Product360ImageActivitySubcomponent$Builder */
        /* compiled from: ActivityModule_ContributeProduct360ImageActivity$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<Product360ImageActivity> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @IntoMap
    @ActivityKey(Product360ImageActivity.class)
    public abstract AndroidInjector.Factory<? extends Activity> bindAndroidInjectorFactory(Product360ImageActivitySubcomponent.Builder builder);

    private C2858xa65e9bc7() {
    }
}
