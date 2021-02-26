package com.iaai.android.bdt.feature.myAccount.toBePaid;

import com.iaai.android.bdt.feature.logIAAError.LogIAAErrorRepository;
import com.iaai.android.bdt.feature.myAccount.MyAccountRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class ToBePaidViewModel_Factory implements Factory<ToBePaidViewModel> {
    private final Provider<MyAccountRepository> myAccountRepositoryProvider;
    private final Provider<LogIAAErrorRepository> repositoryLogIAAErrorProvider;

    public ToBePaidViewModel_Factory(Provider<MyAccountRepository> provider, Provider<LogIAAErrorRepository> provider2) {
        this.myAccountRepositoryProvider = provider;
        this.repositoryLogIAAErrorProvider = provider2;
    }

    public ToBePaidViewModel get() {
        return provideInstance(this.myAccountRepositoryProvider, this.repositoryLogIAAErrorProvider);
    }

    public static ToBePaidViewModel provideInstance(Provider<MyAccountRepository> provider, Provider<LogIAAErrorRepository> provider2) {
        return new ToBePaidViewModel(provider.get(), provider2.get());
    }

    public static ToBePaidViewModel_Factory create(Provider<MyAccountRepository> provider, Provider<LogIAAErrorRepository> provider2) {
        return new ToBePaidViewModel_Factory(provider, provider2);
    }

    public static ToBePaidViewModel newToBePaidViewModel(MyAccountRepository myAccountRepository, LogIAAErrorRepository logIAAErrorRepository) {
        return new ToBePaidViewModel(myAccountRepository, logIAAErrorRepository);
    }
}
