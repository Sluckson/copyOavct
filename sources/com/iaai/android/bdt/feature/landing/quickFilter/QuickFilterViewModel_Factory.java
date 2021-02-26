package com.iaai.android.bdt.feature.landing.quickFilter;

import com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.FastSearchFilterRepository;
import com.iaai.android.bdt.feature.fastSearchFilter.savedSearch.SavedSearchListRepository;
import com.iaai.android.bdt.feature.viewPager.FastSearchListRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class QuickFilterViewModel_Factory implements Factory<QuickFilterViewModel> {
    private final Provider<FastSearchFilterRepository> repositoryFacetsProvider;
    private final Provider<FastSearchListRepository> repositoryFastSearchProvider;
    private final Provider<QuickFilterRepository> repositoryProvider;
    private final Provider<SavedSearchListRepository> savedRepositoryProvider;

    public QuickFilterViewModel_Factory(Provider<QuickFilterRepository> provider, Provider<FastSearchListRepository> provider2, Provider<FastSearchFilterRepository> provider3, Provider<SavedSearchListRepository> provider4) {
        this.repositoryProvider = provider;
        this.repositoryFastSearchProvider = provider2;
        this.repositoryFacetsProvider = provider3;
        this.savedRepositoryProvider = provider4;
    }

    public QuickFilterViewModel get() {
        return provideInstance(this.repositoryProvider, this.repositoryFastSearchProvider, this.repositoryFacetsProvider, this.savedRepositoryProvider);
    }

    public static QuickFilterViewModel provideInstance(Provider<QuickFilterRepository> provider, Provider<FastSearchListRepository> provider2, Provider<FastSearchFilterRepository> provider3, Provider<SavedSearchListRepository> provider4) {
        return new QuickFilterViewModel(provider.get(), provider2.get(), provider3.get(), provider4.get());
    }

    public static QuickFilterViewModel_Factory create(Provider<QuickFilterRepository> provider, Provider<FastSearchListRepository> provider2, Provider<FastSearchFilterRepository> provider3, Provider<SavedSearchListRepository> provider4) {
        return new QuickFilterViewModel_Factory(provider, provider2, provider3, provider4);
    }

    public static QuickFilterViewModel newQuickFilterViewModel(QuickFilterRepository quickFilterRepository, FastSearchListRepository fastSearchListRepository, FastSearchFilterRepository fastSearchFilterRepository, SavedSearchListRepository savedSearchListRepository) {
        return new QuickFilterViewModel(quickFilterRepository, fastSearchListRepository, fastSearchFilterRepository, savedSearchListRepository);
    }
}
