package com.iaai.android.bdt.feature.productDetail;

import com.iaai.android.bdt.network.Service;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class ProductDetailRepository_Factory implements Factory<ProductDetailRepository> {
    private final Provider<Service> serviceProvider;

    public ProductDetailRepository_Factory(Provider<Service> provider) {
        this.serviceProvider = provider;
    }

    public ProductDetailRepository get() {
        return provideInstance(this.serviceProvider);
    }

    public static ProductDetailRepository provideInstance(Provider<Service> provider) {
        return new ProductDetailRepository(provider.get());
    }

    public static ProductDetailRepository_Factory create(Provider<Service> provider) {
        return new ProductDetailRepository_Factory(provider);
    }

    public static ProductDetailRepository newProductDetailRepository(Service service) {
        return new ProductDetailRepository(service);
    }
}
