package com.iaai.android.bdt.injection.module;

import android.app.Activity;
import com.iaai.android.bdt.feature.fastSearchFilter.savedSearch.SavedSearchActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {SavedSearchActivitySubcomponent.class})
/* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeSavedSearchActivity$app_productionRelease */
public abstract class C2862x7ad821b9 {

    @Subcomponent
    /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeSavedSearchActivity$app_productionRelease$SavedSearchActivitySubcomponent */
    /* compiled from: ActivityModule_ContributeSavedSearchActivity$app_productionRelease */
    public interface SavedSearchActivitySubcomponent extends AndroidInjector<SavedSearchActivity> {

        @Subcomponent.Builder
        /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeSavedSearchActivity$app_productionRelease$SavedSearchActivitySubcomponent$Builder */
        /* compiled from: ActivityModule_ContributeSavedSearchActivity$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<SavedSearchActivity> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @IntoMap
    @ActivityKey(SavedSearchActivity.class)
    public abstract AndroidInjector.Factory<? extends Activity> bindAndroidInjectorFactory(SavedSearchActivitySubcomponent.Builder builder);

    private C2862x7ad821b9() {
    }
}
