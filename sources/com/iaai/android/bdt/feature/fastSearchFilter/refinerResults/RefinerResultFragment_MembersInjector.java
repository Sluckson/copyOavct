package com.iaai.android.bdt.feature.fastSearchFilter.refinerResults;

import androidx.lifecycle.ViewModelProvider;
import com.iaai.android.bdt.feature.login.SessionManager;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class RefinerResultFragment_MembersInjector implements MembersInjector<RefinerResultFragment> {
    private final Provider<SessionManager> sessionManagerProvider;
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public RefinerResultFragment_MembersInjector(Provider<SessionManager> provider, Provider<ViewModelProvider.Factory> provider2) {
        this.sessionManagerProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public static MembersInjector<RefinerResultFragment> create(Provider<SessionManager> provider, Provider<ViewModelProvider.Factory> provider2) {
        return new RefinerResultFragment_MembersInjector(provider, provider2);
    }

    public void injectMembers(RefinerResultFragment refinerResultFragment) {
        injectSessionManager(refinerResultFragment, this.sessionManagerProvider.get());
        injectViewModelFactory(refinerResultFragment, this.viewModelFactoryProvider.get());
    }

    public static void injectSessionManager(RefinerResultFragment refinerResultFragment, SessionManager sessionManager) {
        refinerResultFragment.sessionManager = sessionManager;
    }

    public static void injectViewModelFactory(RefinerResultFragment refinerResultFragment, ViewModelProvider.Factory factory) {
        refinerResultFragment.viewModelFactory = factory;
    }
}
