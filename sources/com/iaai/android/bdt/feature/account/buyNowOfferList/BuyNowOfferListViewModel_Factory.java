package com.iaai.android.bdt.feature.account.buyNowOfferList;

import dagger.internal.Factory;
import javax.inject.Provider;

public final class BuyNowOfferListViewModel_Factory implements Factory<BuyNowOfferListViewModel> {
    private final Provider<BuyNowOfferListRepository> repositoryProvider;

    public BuyNowOfferListViewModel_Factory(Provider<BuyNowOfferListRepository> provider) {
        this.repositoryProvider = provider;
    }

    public BuyNowOfferListViewModel get() {
        return provideInstance(this.repositoryProvider);
    }

    public static BuyNowOfferListViewModel provideInstance(Provider<BuyNowOfferListRepository> provider) {
        return new BuyNowOfferListViewModel(provider.get());
    }

    public static BuyNowOfferListViewModel_Factory create(Provider<BuyNowOfferListRepository> provider) {
        return new BuyNowOfferListViewModel_Factory(provider);
    }

    public static BuyNowOfferListViewModel newBuyNowOfferListViewModel(BuyNowOfferListRepository buyNowOfferListRepository) {
        return new BuyNowOfferListViewModel(buyNowOfferListRepository);
    }
}
