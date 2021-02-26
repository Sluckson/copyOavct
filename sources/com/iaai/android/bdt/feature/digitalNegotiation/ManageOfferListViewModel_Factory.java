package com.iaai.android.bdt.feature.digitalNegotiation;

import dagger.internal.Factory;
import javax.inject.Provider;

public final class ManageOfferListViewModel_Factory implements Factory<ManageOfferListViewModel> {
    private final Provider<ManageOfferListRepository> repositoryProvider;

    public ManageOfferListViewModel_Factory(Provider<ManageOfferListRepository> provider) {
        this.repositoryProvider = provider;
    }

    public ManageOfferListViewModel get() {
        return provideInstance(this.repositoryProvider);
    }

    public static ManageOfferListViewModel provideInstance(Provider<ManageOfferListRepository> provider) {
        return new ManageOfferListViewModel(provider.get());
    }

    public static ManageOfferListViewModel_Factory create(Provider<ManageOfferListRepository> provider) {
        return new ManageOfferListViewModel_Factory(provider);
    }

    public static ManageOfferListViewModel newManageOfferListViewModel(ManageOfferListRepository manageOfferListRepository) {
        return new ManageOfferListViewModel(manageOfferListRepository);
    }
}
