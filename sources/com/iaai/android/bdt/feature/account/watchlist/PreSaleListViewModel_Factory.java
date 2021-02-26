package com.iaai.android.bdt.feature.account.watchlist;

import com.iaai.android.bdt.feature.watchList.WatchRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class PreSaleListViewModel_Factory implements Factory<PreSaleListViewModel> {
    private final Provider<PreSaleListRepository> repositoryProvider;
    private final Provider<WatchRepository> watchRepositoryProvider;

    public PreSaleListViewModel_Factory(Provider<PreSaleListRepository> provider, Provider<WatchRepository> provider2) {
        this.repositoryProvider = provider;
        this.watchRepositoryProvider = provider2;
    }

    public PreSaleListViewModel get() {
        return provideInstance(this.repositoryProvider, this.watchRepositoryProvider);
    }

    public static PreSaleListViewModel provideInstance(Provider<PreSaleListRepository> provider, Provider<WatchRepository> provider2) {
        return new PreSaleListViewModel(provider.get(), provider2.get());
    }

    public static PreSaleListViewModel_Factory create(Provider<PreSaleListRepository> provider, Provider<WatchRepository> provider2) {
        return new PreSaleListViewModel_Factory(provider, provider2);
    }

    public static PreSaleListViewModel newPreSaleListViewModel(PreSaleListRepository preSaleListRepository, WatchRepository watchRepository) {
        return new PreSaleListViewModel(preSaleListRepository, watchRepository);
    }
}
