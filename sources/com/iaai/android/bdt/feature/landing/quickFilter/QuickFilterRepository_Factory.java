package com.iaai.android.bdt.feature.landing.quickFilter;

import com.iaai.android.bdt.network.Service;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class QuickFilterRepository_Factory implements Factory<QuickFilterRepository> {
    private final Provider<Service> serviceProvider;

    public QuickFilterRepository_Factory(Provider<Service> provider) {
        this.serviceProvider = provider;
    }

    public QuickFilterRepository get() {
        return provideInstance(this.serviceProvider);
    }

    public static QuickFilterRepository provideInstance(Provider<Service> provider) {
        return new QuickFilterRepository(provider.get());
    }

    public static QuickFilterRepository_Factory create(Provider<Service> provider) {
        return new QuickFilterRepository_Factory(provider);
    }

    public static QuickFilterRepository newQuickFilterRepository(Service service) {
        return new QuickFilterRepository(service);
    }
}
