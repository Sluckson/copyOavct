package com.iaai.android.bdt.feature.landing;

import com.iaai.android.bdt.network.Service;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class LandingPageRepository_Factory implements Factory<LandingPageRepository> {
    private final Provider<Service> serviceProvider;

    public LandingPageRepository_Factory(Provider<Service> provider) {
        this.serviceProvider = provider;
    }

    public LandingPageRepository get() {
        return provideInstance(this.serviceProvider);
    }

    public static LandingPageRepository provideInstance(Provider<Service> provider) {
        return new LandingPageRepository(provider.get());
    }

    public static LandingPageRepository_Factory create(Provider<Service> provider) {
        return new LandingPageRepository_Factory(provider);
    }

    public static LandingPageRepository newLandingPageRepository(Service service) {
        return new LandingPageRepository(service);
    }
}
