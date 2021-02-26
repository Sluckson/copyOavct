package com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList;

import com.iaai.android.bdt.feature.myAccount.MyAccountRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class DeliveryInstructionViewModel_Factory implements Factory<DeliveryInstructionViewModel> {
    private final Provider<MyAccountRepository> myAccountRepositoryProvider;

    public DeliveryInstructionViewModel_Factory(Provider<MyAccountRepository> provider) {
        this.myAccountRepositoryProvider = provider;
    }

    public DeliveryInstructionViewModel get() {
        return provideInstance(this.myAccountRepositoryProvider);
    }

    public static DeliveryInstructionViewModel provideInstance(Provider<MyAccountRepository> provider) {
        return new DeliveryInstructionViewModel(provider.get());
    }

    public static DeliveryInstructionViewModel_Factory create(Provider<MyAccountRepository> provider) {
        return new DeliveryInstructionViewModel_Factory(provider);
    }

    public static DeliveryInstructionViewModel newDeliveryInstructionViewModel(MyAccountRepository myAccountRepository) {
        return new DeliveryInstructionViewModel(myAccountRepository);
    }
}
