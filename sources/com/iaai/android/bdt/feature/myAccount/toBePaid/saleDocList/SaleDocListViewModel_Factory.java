package com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList;

import com.iaai.android.bdt.feature.myAccount.MyAccountRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class SaleDocListViewModel_Factory implements Factory<SaleDocListViewModel> {
    private final Provider<MyAccountRepository> myAccountRepositoryProvider;

    public SaleDocListViewModel_Factory(Provider<MyAccountRepository> provider) {
        this.myAccountRepositoryProvider = provider;
    }

    public SaleDocListViewModel get() {
        return provideInstance(this.myAccountRepositoryProvider);
    }

    public static SaleDocListViewModel provideInstance(Provider<MyAccountRepository> provider) {
        return new SaleDocListViewModel(provider.get());
    }

    public static SaleDocListViewModel_Factory create(Provider<MyAccountRepository> provider) {
        return new SaleDocListViewModel_Factory(provider);
    }

    public static SaleDocListViewModel newSaleDocListViewModel(MyAccountRepository myAccountRepository) {
        return new SaleDocListViewModel(myAccountRepository);
    }
}
