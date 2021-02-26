package com.iaai.android.bdt.feature.account.salesdocument;

import dagger.internal.Factory;
import javax.inject.Provider;

public final class SaleDocumentViewModel_Factory implements Factory<SaleDocumentViewModel> {
    private final Provider<SaleDocumentRepository> saleDocumentRepositoryProvider;

    public SaleDocumentViewModel_Factory(Provider<SaleDocumentRepository> provider) {
        this.saleDocumentRepositoryProvider = provider;
    }

    public SaleDocumentViewModel get() {
        return provideInstance(this.saleDocumentRepositoryProvider);
    }

    public static SaleDocumentViewModel provideInstance(Provider<SaleDocumentRepository> provider) {
        return new SaleDocumentViewModel(provider.get());
    }

    public static SaleDocumentViewModel_Factory create(Provider<SaleDocumentRepository> provider) {
        return new SaleDocumentViewModel_Factory(provider);
    }

    public static SaleDocumentViewModel newSaleDocumentViewModel(SaleDocumentRepository saleDocumentRepository) {
        return new SaleDocumentViewModel(saleDocumentRepository);
    }
}
