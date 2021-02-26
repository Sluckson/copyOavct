package com.iaai.android.bdt.feature.account.buyNowOfferList;

import androidx.lifecycle.ViewModelProvider;
import com.iaai.android.bdt.feature.login.SessionManager;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class BuyNowOfferListFragment_MembersInjector implements MembersInjector<BuyNowOfferListFragment> {
    private final Provider<SessionManager> sessionManagerProvider;
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public BuyNowOfferListFragment_MembersInjector(Provider<ViewModelProvider.Factory> provider, Provider<SessionManager> provider2) {
        this.viewModelFactoryProvider = provider;
        this.sessionManagerProvider = provider2;
    }

    public static MembersInjector<BuyNowOfferListFragment> create(Provider<ViewModelProvider.Factory> provider, Provider<SessionManager> provider2) {
        return new BuyNowOfferListFragment_MembersInjector(provider, provider2);
    }

    public void injectMembers(BuyNowOfferListFragment buyNowOfferListFragment) {
        injectViewModelFactory(buyNowOfferListFragment, this.viewModelFactoryProvider.get());
        injectSessionManager(buyNowOfferListFragment, this.sessionManagerProvider.get());
    }

    public static void injectViewModelFactory(BuyNowOfferListFragment buyNowOfferListFragment, ViewModelProvider.Factory factory) {
        buyNowOfferListFragment.viewModelFactory = factory;
    }

    public static void injectSessionManager(BuyNowOfferListFragment buyNowOfferListFragment, SessionManager sessionManager) {
        buyNowOfferListFragment.sessionManager = sessionManager;
    }
}
