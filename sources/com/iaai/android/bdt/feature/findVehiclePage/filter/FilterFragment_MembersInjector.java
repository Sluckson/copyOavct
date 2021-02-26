package com.iaai.android.bdt.feature.findVehiclePage.filter;

import androidx.lifecycle.ViewModelProvider;
import com.iaai.android.bdt.feature.login.SessionManager;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class FilterFragment_MembersInjector implements MembersInjector<FilterFragment> {
    private final Provider<SessionManager> sessionManagerProvider;
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public FilterFragment_MembersInjector(Provider<ViewModelProvider.Factory> provider, Provider<SessionManager> provider2) {
        this.viewModelFactoryProvider = provider;
        this.sessionManagerProvider = provider2;
    }

    public static MembersInjector<FilterFragment> create(Provider<ViewModelProvider.Factory> provider, Provider<SessionManager> provider2) {
        return new FilterFragment_MembersInjector(provider, provider2);
    }

    public void injectMembers(FilterFragment filterFragment) {
        injectViewModelFactory(filterFragment, this.viewModelFactoryProvider.get());
        injectSessionManager(filterFragment, this.sessionManagerProvider.get());
    }

    public static void injectViewModelFactory(FilterFragment filterFragment, ViewModelProvider.Factory factory) {
        filterFragment.viewModelFactory = factory;
    }

    public static void injectSessionManager(FilterFragment filterFragment, SessionManager sessionManager) {
        filterFragment.sessionManager = sessionManager;
    }
}
