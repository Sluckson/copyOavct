package com.iaai.android.bdt.feature.account;

import dagger.internal.Factory;
import javax.inject.Provider;

public final class MyAccountViewModel_Factory implements Factory<MyAccountViewModel> {
    private final Provider<MyAccountRepository> myAccountRepositoryProvider;

    public MyAccountViewModel_Factory(Provider<MyAccountRepository> provider) {
        this.myAccountRepositoryProvider = provider;
    }

    public MyAccountViewModel get() {
        return provideInstance(this.myAccountRepositoryProvider);
    }

    public static MyAccountViewModel provideInstance(Provider<MyAccountRepository> provider) {
        return new MyAccountViewModel(provider.get());
    }

    public static MyAccountViewModel_Factory create(Provider<MyAccountRepository> provider) {
        return new MyAccountViewModel_Factory(provider);
    }

    public static MyAccountViewModel newMyAccountViewModel(MyAccountRepository myAccountRepository) {
        return new MyAccountViewModel(myAccountRepository);
    }
}
