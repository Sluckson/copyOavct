package com.iaai.android.bdt.feature.auctionSalesList;

import com.iaai.android.bdt.network.Service;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class AuctionSalesListRepository_Factory implements Factory<AuctionSalesListRepository> {
    private final Provider<Service> serviceProvider;

    public AuctionSalesListRepository_Factory(Provider<Service> provider) {
        this.serviceProvider = provider;
    }

    public AuctionSalesListRepository get() {
        return provideInstance(this.serviceProvider);
    }

    public static AuctionSalesListRepository provideInstance(Provider<Service> provider) {
        return new AuctionSalesListRepository(provider.get());
    }

    public static AuctionSalesListRepository_Factory create(Provider<Service> provider) {
        return new AuctionSalesListRepository_Factory(provider);
    }

    public static AuctionSalesListRepository newAuctionSalesListRepository(Service service) {
        return new AuctionSalesListRepository(service);
    }
}
