package com.iaai.android.bdt.feature.productDetail.prebid;

import androidx.lifecycle.ViewModelProvider;
import com.iaai.android.bdt.feature.login.SessionManager;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class PreBidFragment_MembersInjector implements MembersInjector<PreBidFragment> {
    private final Provider<SessionManager> sessionManagerProvider;
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public PreBidFragment_MembersInjector(Provider<ViewModelProvider.Factory> provider, Provider<SessionManager> provider2) {
        this.viewModelFactoryProvider = provider;
        this.sessionManagerProvider = provider2;
    }

    public static MembersInjector<PreBidFragment> create(Provider<ViewModelProvider.Factory> provider, Provider<SessionManager> provider2) {
        return new PreBidFragment_MembersInjector(provider, provider2);
    }

    public void injectMembers(PreBidFragment preBidFragment) {
        injectViewModelFactory(preBidFragment, this.viewModelFactoryProvider.get());
        injectSessionManager(preBidFragment, this.sessionManagerProvider.get());
    }

    public static void injectViewModelFactory(PreBidFragment preBidFragment, ViewModelProvider.Factory factory) {
        preBidFragment.viewModelFactory = factory;
    }

    public static void injectSessionManager(PreBidFragment preBidFragment, SessionManager sessionManager) {
        preBidFragment.sessionManager = sessionManager;
    }
}
