package com.iaai.android.bdt.feature.digitalNegotiation;

import com.iaai.android.bdt.network.Service;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class ManageOfferListRepository_Factory implements Factory<ManageOfferListRepository> {
    private final Provider<Service> serviceProvider;

    public ManageOfferListRepository_Factory(Provider<Service> provider) {
        this.serviceProvider = provider;
    }

    public ManageOfferListRepository get() {
        return provideInstance(this.serviceProvider);
    }

    public static ManageOfferListRepository provideInstance(Provider<Service> provider) {
        return new ManageOfferListRepository(provider.get());
    }

    public static ManageOfferListRepository_Factory create(Provider<Service> provider) {
        return new ManageOfferListRepository_Factory(provider);
    }

    public static ManageOfferListRepository newManageOfferListRepository(Service service) {
        return new ManageOfferListRepository(service);
    }
}
