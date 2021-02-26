package com.iaai.android.bdt.feature.productDetail.buyNow;

import com.iaai.android.bdt.network.Service;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class BuyNowRepository_Factory implements Factory<BuyNowRepository> {
    private final Provider<Service> serviceProvider;

    public BuyNowRepository_Factory(Provider<Service> provider) {
        this.serviceProvider = provider;
    }

    public BuyNowRepository get() {
        return provideInstance(this.serviceProvider);
    }

    public static BuyNowRepository provideInstance(Provider<Service> provider) {
        return new BuyNowRepository(provider.get());
    }

    public static BuyNowRepository_Factory create(Provider<Service> provider) {
        return new BuyNowRepository_Factory(provider);
    }

    public static BuyNowRepository newBuyNowRepository(Service service) {
        return new BuyNowRepository(service);
    }
}
