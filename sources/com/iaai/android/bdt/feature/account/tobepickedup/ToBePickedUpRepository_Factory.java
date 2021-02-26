package com.iaai.android.bdt.feature.account.tobepickedup;

import com.iaai.android.bdt.network.Service;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class ToBePickedUpRepository_Factory implements Factory<ToBePickedUpRepository> {
    private final Provider<Service> serviceProvider;

    public ToBePickedUpRepository_Factory(Provider<Service> provider) {
        this.serviceProvider = provider;
    }

    public ToBePickedUpRepository get() {
        return provideInstance(this.serviceProvider);
    }

    public static ToBePickedUpRepository provideInstance(Provider<Service> provider) {
        return new ToBePickedUpRepository(provider.get());
    }

    public static ToBePickedUpRepository_Factory create(Provider<Service> provider) {
        return new ToBePickedUpRepository_Factory(provider);
    }

    public static ToBePickedUpRepository newToBePickedUpRepository(Service service) {
        return new ToBePickedUpRepository(service);
    }
}
