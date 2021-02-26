package com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle;

import androidx.lifecycle.ViewModelProvider;
import com.iaai.android.bdt.feature.login.SessionManager;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class FastSearchFilterFragment_MembersInjector implements MembersInjector<FastSearchFilterFragment> {
    private final Provider<SessionManager> sessionManagerProvider;
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public FastSearchFilterFragment_MembersInjector(Provider<ViewModelProvider.Factory> provider, Provider<SessionManager> provider2) {
        this.viewModelFactoryProvider = provider;
        this.sessionManagerProvider = provider2;
    }

    public static MembersInjector<FastSearchFilterFragment> create(Provider<ViewModelProvider.Factory> provider, Provider<SessionManager> provider2) {
        return new FastSearchFilterFragment_MembersInjector(provider, provider2);
    }

    public void injectMembers(FastSearchFilterFragment fastSearchFilterFragment) {
        injectViewModelFactory(fastSearchFilterFragment, this.viewModelFactoryProvider.get());
        injectSessionManager(fastSearchFilterFragment, this.sessionManagerProvider.get());
    }

    public static void injectViewModelFactory(FastSearchFilterFragment fastSearchFilterFragment, ViewModelProvider.Factory factory) {
        fastSearchFilterFragment.viewModelFactory = factory;
    }

    public static void injectSessionManager(FastSearchFilterFragment fastSearchFilterFragment, SessionManager sessionManager) {
        fastSearchFilterFragment.sessionManager = sessionManager;
    }
}
