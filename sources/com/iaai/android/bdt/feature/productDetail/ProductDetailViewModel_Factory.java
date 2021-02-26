package com.iaai.android.bdt.feature.productDetail;

import com.iaai.android.bdt.feature.watchList.WatchRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class ProductDetailViewModel_Factory implements Factory<ProductDetailViewModel> {
    private final Provider<ProductDetailRepository> repositoryProvider;
    private final Provider<WatchRepository> watchRepositoryProvider;

    public ProductDetailViewModel_Factory(Provider<ProductDetailRepository> provider, Provider<WatchRepository> provider2) {
        this.repositoryProvider = provider;
        this.watchRepositoryProvider = provider2;
    }

    public ProductDetailViewModel get() {
        return provideInstance(this.repositoryProvider, this.watchRepositoryProvider);
    }

    public static ProductDetailViewModel provideInstance(Provider<ProductDetailRepository> provider, Provider<WatchRepository> provider2) {
        return new ProductDetailViewModel(provider.get(), provider2.get());
    }

    public static ProductDetailViewModel_Factory create(Provider<ProductDetailRepository> provider, Provider<WatchRepository> provider2) {
        return new ProductDetailViewModel_Factory(provider, provider2);
    }

    public static ProductDetailViewModel newProductDetailViewModel(ProductDetailRepository productDetailRepository, WatchRepository watchRepository) {
        return new ProductDetailViewModel(productDetailRepository, watchRepository);
    }
}
