package com.iaai.android.bdt.feature.productDetail.buyNow;

import dagger.internal.Factory;
import javax.inject.Provider;

public final class BuyNowViewModel_Factory implements Factory<BuyNowViewModel> {
    private final Provider<BuyNowRepository> repositoryProvider;

    public BuyNowViewModel_Factory(Provider<BuyNowRepository> provider) {
        this.repositoryProvider = provider;
    }

    public BuyNowViewModel get() {
        return provideInstance(this.repositoryProvider);
    }

    public static BuyNowViewModel provideInstance(Provider<BuyNowRepository> provider) {
        return new BuyNowViewModel(provider.get());
    }

    public static BuyNowViewModel_Factory create(Provider<BuyNowRepository> provider) {
        return new BuyNowViewModel_Factory(provider);
    }

    public static BuyNowViewModel newBuyNowViewModel(BuyNowRepository buyNowRepository) {
        return new BuyNowViewModel(buyNowRepository);
    }
}
