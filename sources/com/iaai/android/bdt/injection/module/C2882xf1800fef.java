package com.iaai.android.bdt.injection.module;

import androidx.fragment.app.Fragment;
import com.iaai.android.bdt.feature.findVehiclePage.searchResult.SearchResultListFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {SearchResultListFragmentSubcomponent.class})
/* renamed from: com.iaai.android.bdt.injection.module.FragmentModule_ContributeSearchResultListFragment$app_productionRelease */
public abstract class C2882xf1800fef {

    @Subcomponent
    /* renamed from: com.iaai.android.bdt.injection.module.FragmentModule_ContributeSearchResultListFragment$app_productionRelease$SearchResultListFragmentSubcomponent */
    /* compiled from: FragmentModule_ContributeSearchResultListFragment$app_productionRelease */
    public interface SearchResultListFragmentSubcomponent extends AndroidInjector<SearchResultListFragment> {

        @Subcomponent.Builder
        /* renamed from: com.iaai.android.bdt.injection.module.FragmentModule_ContributeSearchResultListFragment$app_productionRelease$SearchResultListFragmentSubcomponent$Builder */
        /* compiled from: FragmentModule_ContributeSearchResultListFragment$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<SearchResultListFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @FragmentKey(SearchResultListFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<? extends Fragment> bindAndroidInjectorFactory(SearchResultListFragmentSubcomponent.Builder builder);

    private C2882xf1800fef() {
    }
}
