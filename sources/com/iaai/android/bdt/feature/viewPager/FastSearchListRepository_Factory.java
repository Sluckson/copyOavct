package com.iaai.android.bdt.feature.viewPager;

import com.iaai.android.bdt.network.Service;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class FastSearchListRepository_Factory implements Factory<FastSearchListRepository> {
    private final Provider<Service> serviceProvider;

    public FastSearchListRepository_Factory(Provider<Service> provider) {
        this.serviceProvider = provider;
    }

    public FastSearchListRepository get() {
        return provideInstance(this.serviceProvider);
    }

    public static FastSearchListRepository provideInstance(Provider<Service> provider) {
        return new FastSearchListRepository(provider.get());
    }

    public static FastSearchListRepository_Factory create(Provider<Service> provider) {
        return new FastSearchListRepository_Factory(provider);
    }

    public static FastSearchListRepository newFastSearchListRepository(Service service) {
        return new FastSearchListRepository(service);
    }
}
