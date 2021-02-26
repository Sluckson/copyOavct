package com.iaai.android.bdt.injection.module;

import android.app.Activity;
import com.iaai.android.bdt.feature.utilsActivity.WebViewActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {WebViewActivitySubcomponent.class})
public abstract class ActivityModule_ContributeWebViewActivity$app_productionRelease {

    @Subcomponent
    /* compiled from: ActivityModule_ContributeWebViewActivity$app_productionRelease */
    public interface WebViewActivitySubcomponent extends AndroidInjector<WebViewActivity> {

        @Subcomponent.Builder
        /* compiled from: ActivityModule_ContributeWebViewActivity$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<WebViewActivity> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @IntoMap
    @ActivityKey(WebViewActivity.class)
    public abstract AndroidInjector.Factory<? extends Activity> bindAndroidInjectorFactory(WebViewActivitySubcomponent.Builder builder);

    private ActivityModule_ContributeWebViewActivity$app_productionRelease() {
    }
}
