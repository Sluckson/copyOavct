package com.iaai.android.bdt.feature.productDetail.prebid;

import com.iaai.android.bdt.network.Service;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class PreBidRepository_Factory implements Factory<PreBidRepository> {
    private final Provider<Service> serviceProvider;

    public PreBidRepository_Factory(Provider<Service> provider) {
        this.serviceProvider = provider;
    }

    public PreBidRepository get() {
        return provideInstance(this.serviceProvider);
    }

    public static PreBidRepository provideInstance(Provider<Service> provider) {
        return new PreBidRepository(provider.get());
    }

    public static PreBidRepository_Factory create(Provider<Service> provider) {
        return new PreBidRepository_Factory(provider);
    }

    public static PreBidRepository newPreBidRepository(Service service) {
        return new PreBidRepository(service);
    }
}
