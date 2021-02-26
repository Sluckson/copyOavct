package com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList;

import com.iaai.android.bdt.feature.myAccount.MyAccountRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class InsertRepOrAddViewModel_Factory implements Factory<InsertRepOrAddViewModel> {
    private final Provider<MyAccountRepository> myAccountRepositoryProvider;

    public InsertRepOrAddViewModel_Factory(Provider<MyAccountRepository> provider) {
        this.myAccountRepositoryProvider = provider;
    }

    public InsertRepOrAddViewModel get() {
        return provideInstance(this.myAccountRepositoryProvider);
    }

    public static InsertRepOrAddViewModel provideInstance(Provider<MyAccountRepository> provider) {
        return new InsertRepOrAddViewModel(provider.get());
    }

    public static InsertRepOrAddViewModel_Factory create(Provider<MyAccountRepository> provider) {
        return new InsertRepOrAddViewModel_Factory(provider);
    }

    public static InsertRepOrAddViewModel newInsertRepOrAddViewModel(MyAccountRepository myAccountRepository) {
        return new InsertRepOrAddViewModel(myAccountRepository);
    }
}
