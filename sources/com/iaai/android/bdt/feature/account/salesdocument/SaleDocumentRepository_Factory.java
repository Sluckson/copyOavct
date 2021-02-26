package com.iaai.android.bdt.feature.account.salesdocument;

import com.iaai.android.bdt.network.Service;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class SaleDocumentRepository_Factory implements Factory<SaleDocumentRepository> {
    private final Provider<Service> serviceProvider;

    public SaleDocumentRepository_Factory(Provider<Service> provider) {
        this.serviceProvider = provider;
    }

    public SaleDocumentRepository get() {
        return provideInstance(this.serviceProvider);
    }

    public static SaleDocumentRepository provideInstance(Provider<Service> provider) {
        return new SaleDocumentRepository(provider.get());
    }

    public static SaleDocumentRepository_Factory create(Provider<Service> provider) {
        return new SaleDocumentRepository_Factory(provider);
    }

    public static SaleDocumentRepository newSaleDocumentRepository(Service service) {
        return new SaleDocumentRepository(service);
    }
}
