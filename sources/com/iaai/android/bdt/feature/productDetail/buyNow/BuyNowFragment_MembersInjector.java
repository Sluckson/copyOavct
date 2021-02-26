package com.iaai.android.bdt.feature.productDetail.buyNow;

import androidx.lifecycle.ViewModelProvider;
import com.iaai.android.bdt.feature.login.SessionManager;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class BuyNowFragment_MembersInjector implements MembersInjector<BuyNowFragment> {
    private final Provider<SessionManager> sessionManagerProvider;
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public BuyNowFragment_MembersInjector(Provider<ViewModelProvider.Factory> provider, Provider<SessionManager> provider2) {
        this.viewModelFactoryProvider = provider;
        this.sessionManagerProvider = provider2;
    }

    public static MembersInjector<BuyNowFragment> create(Provider<ViewModelProvider.Factory> provider, Provider<SessionManager> provider2) {
        return new BuyNowFragment_MembersInjector(provider, provider2);
    }

    public void injectMembers(BuyNowFragment buyNowFragment) {
        injectViewModelFactory(buyNowFragment, this.viewModelFactoryProvider.get());
        injectSessionManager(buyNowFragment, this.sessionManagerProvider.get());
    }

    public static void injectViewModelFactory(BuyNowFragment buyNowFragment, ViewModelProvider.Factory factory) {
        buyNowFragment.viewModelFactory = factory;
    }

    public static void injectSessionManager(BuyNowFragment buyNowFragment, SessionManager sessionManager) {
        buyNowFragment.sessionManager = sessionManager;
    }
}
