package com.iaai.android.bdt.feature.productDetail.chromeSection;

import com.iaai.android.bdt.network.Service;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class ChromeSectionRepository_Factory implements Factory<ChromeSectionRepository> {
    private final Provider<Service> serviceProvider;

    public ChromeSectionRepository_Factory(Provider<Service> provider) {
        this.serviceProvider = provider;
    }

    public ChromeSectionRepository get() {
        return provideInstance(this.serviceProvider);
    }

    public static ChromeSectionRepository provideInstance(Provider<Service> provider) {
        return new ChromeSectionRepository(provider.get());
    }

    public static ChromeSectionRepository_Factory create(Provider<Service> provider) {
        return new ChromeSectionRepository_Factory(provider);
    }

    public static ChromeSectionRepository newChromeSectionRepository(Service service) {
        return new ChromeSectionRepository(service);
    }
}
