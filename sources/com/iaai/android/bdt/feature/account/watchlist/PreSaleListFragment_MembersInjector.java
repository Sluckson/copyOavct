package com.iaai.android.bdt.feature.account.watchlist;

import androidx.lifecycle.ViewModelProvider;
import com.iaai.android.bdt.feature.login.SessionManager;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class PreSaleListFragment_MembersInjector implements MembersInjector<PreSaleListFragment> {
    private final Provider<SessionManager> sessionManagerProvider;
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public PreSaleListFragment_MembersInjector(Provider<ViewModelProvider.Factory> provider, Provider<SessionManager> provider2) {
        this.viewModelFactoryProvider = provider;
        this.sessionManagerProvider = provider2;
    }

    public static MembersInjector<PreSaleListFragment> create(Provider<ViewModelProvider.Factory> provider, Provider<SessionManager> provider2) {
        return new PreSaleListFragment_MembersInjector(provider, provider2);
    }

    public void injectMembers(PreSaleListFragment preSaleListFragment) {
        injectViewModelFactory(preSaleListFragment, this.viewModelFactoryProvider.get());
        injectSessionManager(preSaleListFragment, this.sessionManagerProvider.get());
    }

    public static void injectViewModelFactory(PreSaleListFragment preSaleListFragment, ViewModelProvider.Factory factory) {
        preSaleListFragment.viewModelFactory = factory;
    }

    public static void injectSessionManager(PreSaleListFragment preSaleListFragment, SessionManager sessionManager) {
        preSaleListFragment.sessionManager = sessionManager;
    }
}
