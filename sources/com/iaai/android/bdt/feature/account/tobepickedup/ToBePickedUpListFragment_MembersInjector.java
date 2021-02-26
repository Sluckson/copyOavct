package com.iaai.android.bdt.feature.account.tobepickedup;

import androidx.lifecycle.ViewModelProvider;
import com.iaai.android.bdt.feature.login.SessionManager;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class ToBePickedUpListFragment_MembersInjector implements MembersInjector<ToBePickedUpListFragment> {
    private final Provider<SessionManager> sessionManagerProvider;
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public ToBePickedUpListFragment_MembersInjector(Provider<ViewModelProvider.Factory> provider, Provider<SessionManager> provider2) {
        this.viewModelFactoryProvider = provider;
        this.sessionManagerProvider = provider2;
    }

    public static MembersInjector<ToBePickedUpListFragment> create(Provider<ViewModelProvider.Factory> provider, Provider<SessionManager> provider2) {
        return new ToBePickedUpListFragment_MembersInjector(provider, provider2);
    }

    public void injectMembers(ToBePickedUpListFragment toBePickedUpListFragment) {
        injectViewModelFactory(toBePickedUpListFragment, this.viewModelFactoryProvider.get());
        injectSessionManager(toBePickedUpListFragment, this.sessionManagerProvider.get());
    }

    public static void injectViewModelFactory(ToBePickedUpListFragment toBePickedUpListFragment, ViewModelProvider.Factory factory) {
        toBePickedUpListFragment.viewModelFactory = factory;
    }

    public static void injectSessionManager(ToBePickedUpListFragment toBePickedUpListFragment, SessionManager sessionManager) {
        toBePickedUpListFragment.sessionManager = sessionManager;
    }
}
