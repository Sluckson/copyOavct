package com.iaai.android.bdt.feature.watchList;

import com.iaai.android.bdt.network.Service;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class WatchRepository_Factory implements Factory<WatchRepository> {
    private final Provider<Service> serviceProvider;

    public WatchRepository_Factory(Provider<Service> provider) {
        this.serviceProvider = provider;
    }

    public WatchRepository get() {
        return provideInstance(this.serviceProvider);
    }

    public static WatchRepository provideInstance(Provider<Service> provider) {
        return new WatchRepository(provider.get());
    }

    public static WatchRepository_Factory create(Provider<Service> provider) {
        return new WatchRepository_Factory(provider);
    }

    public static WatchRepository newWatchRepository(Service service) {
        return new WatchRepository(service);
    }
}
