package com.iaai.android.bdt.feature.termsofuse;

import com.iaai.android.bdt.network.Service;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class AuctionRuleRepository_Factory implements Factory<AuctionRuleRepository> {
    private final Provider<Service> serviceProvider;

    public AuctionRuleRepository_Factory(Provider<Service> provider) {
        this.serviceProvider = provider;
    }

    public AuctionRuleRepository get() {
        return provideInstance(this.serviceProvider);
    }

    public static AuctionRuleRepository provideInstance(Provider<Service> provider) {
        return new AuctionRuleRepository(provider.get());
    }

    public static AuctionRuleRepository_Factory create(Provider<Service> provider) {
        return new AuctionRuleRepository_Factory(provider);
    }

    public static AuctionRuleRepository newAuctionRuleRepository(Service service) {
        return new AuctionRuleRepository(service);
    }
}
