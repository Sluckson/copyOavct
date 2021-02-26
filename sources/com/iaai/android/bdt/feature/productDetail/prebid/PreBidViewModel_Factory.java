package com.iaai.android.bdt.feature.productDetail.prebid;

import com.iaai.android.bdt.feature.productDetail.ProductDetailRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class PreBidViewModel_Factory implements Factory<PreBidViewModel> {
    private final Provider<ProductDetailRepository> productDetailRepositoryProvider;
    private final Provider<PreBidRepository> repositoryProvider;

    public PreBidViewModel_Factory(Provider<PreBidRepository> provider, Provider<ProductDetailRepository> provider2) {
        this.repositoryProvider = provider;
        this.productDetailRepositoryProvider = provider2;
    }

    public PreBidViewModel get() {
        return provideInstance(this.repositoryProvider, this.productDetailRepositoryProvider);
    }

    public static PreBidViewModel provideInstance(Provider<PreBidRepository> provider, Provider<ProductDetailRepository> provider2) {
        return new PreBidViewModel(provider.get(), provider2.get());
    }

    public static PreBidViewModel_Factory create(Provider<PreBidRepository> provider, Provider<ProductDetailRepository> provider2) {
        return new PreBidViewModel_Factory(provider, provider2);
    }

    public static PreBidViewModel newPreBidViewModel(PreBidRepository preBidRepository, ProductDetailRepository productDetailRepository) {
        return new PreBidViewModel(preBidRepository, productDetailRepository);
    }
}
