package com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList;

import com.iaai.android.bdt.feature.myAccount.MyAccountRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class DeliveryMethodViewModel_Factory implements Factory<DeliveryMethodViewModel> {
    private final Provider<MyAccountRepository> myAccountRepositoryProvider;

    public DeliveryMethodViewModel_Factory(Provider<MyAccountRepository> provider) {
        this.myAccountRepositoryProvider = provider;
    }

    public DeliveryMethodViewModel get() {
        return provideInstance(this.myAccountRepositoryProvider);
    }

    public static DeliveryMethodViewModel provideInstance(Provider<MyAccountRepository> provider) {
        return new DeliveryMethodViewModel(provider.get());
    }

    public static DeliveryMethodViewModel_Factory create(Provider<MyAccountRepository> provider) {
        return new DeliveryMethodViewModel_Factory(provider);
    }

    public static DeliveryMethodViewModel newDeliveryMethodViewModel(MyAccountRepository myAccountRepository) {
        return new DeliveryMethodViewModel(myAccountRepository);
    }
}
