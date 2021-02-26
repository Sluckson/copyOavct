package com.iaai.android.bdt.feature.account.salesdocument;

import androidx.lifecycle.ViewModelProvider;
import com.iaai.android.bdt.feature.login.SessionManager;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class SalesDocumentFragment_MembersInjector implements MembersInjector<SalesDocumentFragment> {
    private final Provider<SessionManager> sessionManagerProvider;
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public SalesDocumentFragment_MembersInjector(Provider<ViewModelProvider.Factory> provider, Provider<SessionManager> provider2) {
        this.viewModelFactoryProvider = provider;
        this.sessionManagerProvider = provider2;
    }

    public static MembersInjector<SalesDocumentFragment> create(Provider<ViewModelProvider.Factory> provider, Provider<SessionManager> provider2) {
        return new SalesDocumentFragment_MembersInjector(provider, provider2);
    }

    public void injectMembers(SalesDocumentFragment salesDocumentFragment) {
        injectViewModelFactory(salesDocumentFragment, this.viewModelFactoryProvider.get());
        injectSessionManager(salesDocumentFragment, this.sessionManagerProvider.get());
    }

    public static void injectViewModelFactory(SalesDocumentFragment salesDocumentFragment, ViewModelProvider.Factory factory) {
        salesDocumentFragment.viewModelFactory = factory;
    }

    public static void injectSessionManager(SalesDocumentFragment salesDocumentFragment, SessionManager sessionManager) {
        salesDocumentFragment.sessionManager = sessionManager;
    }
}
