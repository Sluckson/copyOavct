package com.iaai.android.bdt.feature.myAccount.toBePaid;

import androidx.lifecycle.ViewModelProvider;
import com.iaai.android.bdt.feature.login.SessionManager;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class BDTToBePaidFragment_MembersInjector implements MembersInjector<BDTToBePaidFragment> {
    private final Provider<SessionManager> sessionManagerProvider;
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public BDTToBePaidFragment_MembersInjector(Provider<ViewModelProvider.Factory> provider, Provider<SessionManager> provider2) {
        this.viewModelFactoryProvider = provider;
        this.sessionManagerProvider = provider2;
    }

    public static MembersInjector<BDTToBePaidFragment> create(Provider<ViewModelProvider.Factory> provider, Provider<SessionManager> provider2) {
        return new BDTToBePaidFragment_MembersInjector(provider, provider2);
    }

    public void injectMembers(BDTToBePaidFragment bDTToBePaidFragment) {
        injectViewModelFactory(bDTToBePaidFragment, this.viewModelFactoryProvider.get());
        injectSessionManager(bDTToBePaidFragment, this.sessionManagerProvider.get());
    }

    public static void injectViewModelFactory(BDTToBePaidFragment bDTToBePaidFragment, ViewModelProvider.Factory factory) {
        bDTToBePaidFragment.viewModelFactory = factory;
    }

    public static void injectSessionManager(BDTToBePaidFragment bDTToBePaidFragment, SessionManager sessionManager) {
        bDTToBePaidFragment.sessionManager = sessionManager;
    }
}
