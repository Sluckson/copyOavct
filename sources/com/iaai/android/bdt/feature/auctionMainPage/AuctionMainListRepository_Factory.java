package com.iaai.android.bdt.feature.auctionMainPage;

import com.iaai.android.bdt.network.Service;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class AuctionMainListRepository_Factory implements Factory<AuctionMainListRepository> {
    private final Provider<Service> serviceProvider;

    public AuctionMainListRepository_Factory(Provider<Service> provider) {
        this.serviceProvider = provider;
    }

    public AuctionMainListRepository get() {
        return provideInstance(this.serviceProvider);
    }

    public static AuctionMainListRepository provideInstance(Provider<Service> provider) {
        return new AuctionMainListRepository(provider.get());
    }

    public static AuctionMainListRepository_Factory create(Provider<Service> provider) {
        return new AuctionMainListRepository_Factory(provider);
    }

    public static AuctionMainListRepository newAuctionMainListRepository(Service service) {
        return new AuctionMainListRepository(service);
    }
}
