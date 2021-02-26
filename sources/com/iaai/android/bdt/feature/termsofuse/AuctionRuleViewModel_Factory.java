package com.iaai.android.bdt.feature.termsofuse;

import dagger.internal.Factory;
import javax.inject.Provider;

public final class AuctionRuleViewModel_Factory implements Factory<AuctionRuleViewModel> {
    private final Provider<AuctionRuleRepository> repositoryProvider;

    public AuctionRuleViewModel_Factory(Provider<AuctionRuleRepository> provider) {
        this.repositoryProvider = provider;
    }

    public AuctionRuleViewModel get() {
        return provideInstance(this.repositoryProvider);
    }

    public static AuctionRuleViewModel provideInstance(Provider<AuctionRuleRepository> provider) {
        return new AuctionRuleViewModel(provider.get());
    }

    public static AuctionRuleViewModel_Factory create(Provider<AuctionRuleRepository> provider) {
        return new AuctionRuleViewModel_Factory(provider);
    }

    public static AuctionRuleViewModel newAuctionRuleViewModel(AuctionRuleRepository auctionRuleRepository) {
        return new AuctionRuleViewModel(auctionRuleRepository);
    }
}
