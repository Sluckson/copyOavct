package com.iaai.android.bdt.injection.module;

import android.app.Activity;
import com.iaai.android.bdt.feature.account.salesdocument.SalesDocumentActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {SalesDocumentActivitySubcomponent.class})
/* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeSalesDocumentActivity$app_productionRelease */
public abstract class C2861xd6519331 {

    @Subcomponent
    /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeSalesDocumentActivity$app_productionRelease$SalesDocumentActivitySubcomponent */
    /* compiled from: ActivityModule_ContributeSalesDocumentActivity$app_productionRelease */
    public interface SalesDocumentActivitySubcomponent extends AndroidInjector<SalesDocumentActivity> {

        @Subcomponent.Builder
        /* renamed from: com.iaai.android.bdt.injection.module.ActivityModule_ContributeSalesDocumentActivity$app_productionRelease$SalesDocumentActivitySubcomponent$Builder */
        /* compiled from: ActivityModule_ContributeSalesDocumentActivity$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<SalesDocumentActivity> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @IntoMap
    @ActivityKey(SalesDocumentActivity.class)
    public abstract AndroidInjector.Factory<? extends Activity> bindAndroidInjectorFactory(SalesDocumentActivitySubcomponent.Builder builder);

    private C2861xd6519331() {
    }
}
