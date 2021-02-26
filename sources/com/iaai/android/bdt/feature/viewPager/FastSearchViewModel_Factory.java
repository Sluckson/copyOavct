package com.iaai.android.bdt.feature.viewPager;

import com.iaai.android.bdt.feature.watchList.WatchRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class FastSearchViewModel_Factory implements Factory<FastSearchViewModel> {
    private final Provider<FastSearchListRepository> repositoryProvider;
    private final Provider<WatchRepository> watchRepositoryProvider;

    public FastSearchViewModel_Factory(Provider<FastSearchListRepository> provider, Provider<WatchRepository> provider2) {
        this.repositoryProvider = provider;
        this.watchRepositoryProvider = provider2;
    }

    public FastSearchViewModel get() {
        return provideInstance(this.repositoryProvider, this.watchRepositoryProvider);
    }

    public static FastSearchViewModel provideInstance(Provider<FastSearchListRepository> provider, Provider<WatchRepository> provider2) {
        return new FastSearchViewModel(provider.get(), provider2.get());
    }

    public static FastSearchViewModel_Factory create(Provider<FastSearchListRepository> provider, Provider<WatchRepository> provider2) {
        return new FastSearchViewModel_Factory(provider, provider2);
    }

    public static FastSearchViewModel newFastSearchViewModel(FastSearchListRepository fastSearchListRepository, WatchRepository watchRepository) {
        return new FastSearchViewModel(fastSearchListRepository, watchRepository);
    }
}
