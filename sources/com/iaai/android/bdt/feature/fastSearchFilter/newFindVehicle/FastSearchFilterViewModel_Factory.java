package com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle;

import com.iaai.android.bdt.feature.fastSearchFilter.savedSearch.SavedSearchListRepository;
import com.iaai.android.bdt.feature.watchList.WatchRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class FastSearchFilterViewModel_Factory implements Factory<FastSearchFilterViewModel> {
    private final Provider<FastSearchFilterRepository> repositoryProvider;
    private final Provider<SavedSearchListRepository> savedRepositoryProvider;
    private final Provider<WatchRepository> watchRepositoryProvider;

    public FastSearchFilterViewModel_Factory(Provider<FastSearchFilterRepository> provider, Provider<WatchRepository> provider2, Provider<SavedSearchListRepository> provider3) {
        this.repositoryProvider = provider;
        this.watchRepositoryProvider = provider2;
        this.savedRepositoryProvider = provider3;
    }

    public FastSearchFilterViewModel get() {
        return provideInstance(this.repositoryProvider, this.watchRepositoryProvider, this.savedRepositoryProvider);
    }

    public static FastSearchFilterViewModel provideInstance(Provider<FastSearchFilterRepository> provider, Provider<WatchRepository> provider2, Provider<SavedSearchListRepository> provider3) {
        return new FastSearchFilterViewModel(provider.get(), provider2.get(), provider3.get());
    }

    public static FastSearchFilterViewModel_Factory create(Provider<FastSearchFilterRepository> provider, Provider<WatchRepository> provider2, Provider<SavedSearchListRepository> provider3) {
        return new FastSearchFilterViewModel_Factory(provider, provider2, provider3);
    }

    public static FastSearchFilterViewModel newFastSearchFilterViewModel(FastSearchFilterRepository fastSearchFilterRepository, WatchRepository watchRepository, SavedSearchListRepository savedSearchListRepository) {
        return new FastSearchFilterViewModel(fastSearchFilterRepository, watchRepository, savedSearchListRepository);
    }
}
