package com.iaai.android.bdt.injection.module;

import android.app.Activity;
import com.iaai.android.bdt.feature.findVehiclePage.searchResult.SearchResultActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {SearchResultActivitySubcomponent.class})
/* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeSearchResultActivity$app_productionRelease */
public abstract class C2866xb82e191 {

    @Subcomponent
    /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeSearchResultActivity$app_productionRelease$SearchResultActivitySubcomponent */
    /* compiled from: ActivityModule_ContributeSearchResultActivity$app_productionRelease */
    public interface SearchResultActivitySubcomponent extends AndroidInjector<SearchResultActivity> {

        @Subcomponent.Builder
        /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeSearchResultActivity$app_productionRelease$SearchResultActivitySubcomponent$Builder */
        /* compiled from: ActivityModule_ContributeSearchResultActivity$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<SearchResultActivity> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @IntoMap
    @ActivityKey(SearchResultActivity.class)
    public abstract AndroidInjector.Factory<? extends Activity> bindAndroidInjectorFactory(SearchResultActivitySubcomponent.Builder builder);

    private C2866xb82e191() {
    }
}
