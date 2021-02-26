package com.iaai.android.bdt.feature.auctionSalesList;

import com.iaai.android.bdt.feature.watchList.WatchRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class AuctionSalesListViewModel_Factory implements Factory<AuctionSalesListViewModel> {
    private final Provider<AuctionSalesListRepository> repositoryProvider;
    private final Provider<WatchRepository> watchRepositoryProvider;

    public AuctionSalesListViewModel_Factory(Provider<AuctionSalesListRepository> provider, Provider<WatchRepository> provider2) {
        this.repositoryProvider = provider;
        this.watchRepositoryProvider = provider2;
    }

    public AuctionSalesListViewModel get() {
        return provideInstance(this.repositoryProvider, this.watchRepositoryProvider);
    }

    public static AuctionSalesListViewModel provideInstance(Provider<AuctionSalesListRepository> provider, Provider<WatchRepository> provider2) {
        return new AuctionSalesListViewModel(provider.get(), provider2.get());
    }

    public static AuctionSalesListViewModel_Factory create(Provider<AuctionSalesListRepository> provider, Provider<WatchRepository> provider2) {
        return new AuctionSalesListViewModel_Factory(provider, provider2);
    }

    public static AuctionSalesListViewModel newAuctionSalesListViewModel(AuctionSalesListRepository auctionSalesListRepository, WatchRepository watchRepository) {
        return new AuctionSalesListViewModel(auctionSalesListRepository, watchRepository);
    }
}
