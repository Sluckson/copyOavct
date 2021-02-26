package com.iaai.android.bdt.feature.account.buyNowOfferList;

import com.iaai.android.bdt.network.Service;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class BuyNowOfferListRepository_Factory implements Factory<BuyNowOfferListRepository> {
    private final Provider<Service> serviceProvider;

    public BuyNowOfferListRepository_Factory(Provider<Service> provider) {
        this.serviceProvider = provider;
    }

    public BuyNowOfferListRepository get() {
        return provideInstance(this.serviceProvider);
    }

    public static BuyNowOfferListRepository provideInstance(Provider<Service> provider) {
        return new BuyNowOfferListRepository(provider.get());
    }

    public static BuyNowOfferListRepository_Factory create(Provider<Service> provider) {
        return new BuyNowOfferListRepository_Factory(provider);
    }

    public static BuyNowOfferListRepository newBuyNowOfferListRepository(Service service) {
        return new BuyNowOfferListRepository(service);
    }
}
