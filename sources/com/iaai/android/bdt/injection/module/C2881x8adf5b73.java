package com.iaai.android.bdt.injection.module;

import androidx.fragment.app.Fragment;
import com.iaai.android.bdt.feature.account.salesdocument.SalesDocumentFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {SalesDocumentFragmentSubcomponent.class})
/* renamed from: com.iaai.android.bdt.injection.module.FragmentModule_ContributeSalesDocumentFragment$app_productionRelease */
public abstract class C2881x8adf5b73 {

    @Subcomponent
    /* renamed from: com.iaai.android.bdt.injection.module.FragmentModule_ContributeSalesDocumentFragment$app_productionRelease$SalesDocumentFragmentSubcomponent */
    /* compiled from: FragmentModule_ContributeSalesDocumentFragment$app_productionRelease */
    public interface SalesDocumentFragmentSubcomponent extends AndroidInjector<SalesDocumentFragment> {

        @Subcomponent.Builder
        /* renamed from: com.iaai.android.bdt.injection.module.FragmentModule_ContributeSalesDocumentFragment$app_productionRelease$SalesDocumentFragmentSubcomponent$Builder */
        /* compiled from: FragmentModule_ContributeSalesDocumentFragment$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<SalesDocumentFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @FragmentKey(SalesDocumentFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<? extends Fragment> bindAndroidInjectorFactory(SalesDocumentFragmentSubcomponent.Builder builder);

    private C2881x8adf5b73() {
    }
}
