package com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle;

import com.iaai.android.bdt.network.Service;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class FastSearchFilterRepository_Factory implements Factory<FastSearchFilterRepository> {
    private final Provider<Service> serviceProvider;

    public FastSearchFilterRepository_Factory(Provider<Service> provider) {
        this.serviceProvider = provider;
    }

    public FastSearchFilterRepository get() {
        return provideInstance(this.serviceProvider);
    }

    public static FastSearchFilterRepository provideInstance(Provider<Service> provider) {
        return new FastSearchFilterRepository(provider.get());
    }

    public static FastSearchFilterRepository_Factory create(Provider<Service> provider) {
        return new FastSearchFilterRepository_Factory(provider);
    }

    public static FastSearchFilterRepository newFastSearchFilterRepository(Service service) {
        return new FastSearchFilterRepository(service);
    }
}
