package com.iaai.android.bdt.feature.account.watchlist;

import com.iaai.android.bdt.network.Service;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class PreSaleListRepository_Factory implements Factory<PreSaleListRepository> {
    private final Provider<Service> serviceProvider;

    public PreSaleListRepository_Factory(Provider<Service> provider) {
        this.serviceProvider = provider;
    }

    public PreSaleListRepository get() {
        return provideInstance(this.serviceProvider);
    }

    public static PreSaleListRepository provideInstance(Provider<Service> provider) {
        return new PreSaleListRepository(provider.get());
    }

    public static PreSaleListRepository_Factory create(Provider<Service> provider) {
        return new PreSaleListRepository_Factory(provider);
    }

    public static PreSaleListRepository newPreSaleListRepository(Service service) {
        return new PreSaleListRepository(service);
    }
}
