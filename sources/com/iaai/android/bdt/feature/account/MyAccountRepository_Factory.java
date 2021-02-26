package com.iaai.android.bdt.feature.account;

import com.iaai.android.bdt.network.Service;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class MyAccountRepository_Factory implements Factory<MyAccountRepository> {
    private final Provider<Service> serviceProvider;

    public MyAccountRepository_Factory(Provider<Service> provider) {
        this.serviceProvider = provider;
    }

    public MyAccountRepository get() {
        return provideInstance(this.serviceProvider);
    }

    public static MyAccountRepository provideInstance(Provider<Service> provider) {
        return new MyAccountRepository(provider.get());
    }

    public static MyAccountRepository_Factory create(Provider<Service> provider) {
        return new MyAccountRepository_Factory(provider);
    }

    public static MyAccountRepository newMyAccountRepository(Service service) {
        return new MyAccountRepository(service);
    }
}
