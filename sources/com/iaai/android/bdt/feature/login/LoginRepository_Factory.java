package com.iaai.android.bdt.feature.login;

import com.iaai.android.bdt.network.Service;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class LoginRepository_Factory implements Factory<LoginRepository> {
    private final Provider<Service> serviceProvider;

    public LoginRepository_Factory(Provider<Service> provider) {
        this.serviceProvider = provider;
    }

    public LoginRepository get() {
        return provideInstance(this.serviceProvider);
    }

    public static LoginRepository provideInstance(Provider<Service> provider) {
        return new LoginRepository(provider.get());
    }

    public static LoginRepository_Factory create(Provider<Service> provider) {
        return new LoginRepository_Factory(provider);
    }

    public static LoginRepository newLoginRepository(Service service) {
        return new LoginRepository(service);
    }
}
