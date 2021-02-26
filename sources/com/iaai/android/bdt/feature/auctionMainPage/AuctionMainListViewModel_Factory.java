package com.iaai.android.bdt.feature.auctionMainPage;

import dagger.internal.Factory;
import javax.inject.Provider;

public final class AuctionMainListViewModel_Factory implements Factory<AuctionMainListViewModel> {
    private final Provider<AuctionMainListRepository> repositoryProvider;

    public AuctionMainListViewModel_Factory(Provider<AuctionMainListRepository> provider) {
        this.repositoryProvider = provider;
    }

    public AuctionMainListViewModel get() {
        return provideInstance(this.repositoryProvider);
    }

    public static AuctionMainListViewModel provideInstance(Provider<AuctionMainListRepository> provider) {
        return new AuctionMainListViewModel(provider.get());
    }

    public static AuctionMainListViewModel_Factory create(Provider<AuctionMainListRepository> provider) {
        return new AuctionMainListViewModel_Factory(provider);
    }

    public static AuctionMainListViewModel newAuctionMainListViewModel(AuctionMainListRepository auctionMainListRepository) {
        return new AuctionMainListViewModel(auctionMainListRepository);
    }
}
