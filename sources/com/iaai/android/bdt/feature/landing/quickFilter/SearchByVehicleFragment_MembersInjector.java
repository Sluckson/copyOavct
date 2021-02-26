package com.iaai.android.bdt.feature.landing.quickFilter;

import androidx.lifecycle.ViewModelProvider;
import com.iaai.android.bdt.feature.login.SessionManager;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class SearchByVehicleFragment_MembersInjector implements MembersInjector<SearchByVehicleFragment> {
    private final Provider<SessionManager> sessionManagerProvider;
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public SearchByVehicleFragment_MembersInjector(Provider<ViewModelProvider.Factory> provider, Provider<SessionManager> provider2) {
        this.viewModelFactoryProvider = provider;
        this.sessionManagerProvider = provider2;
    }

    public static MembersInjector<SearchByVehicleFragment> create(Provider<ViewModelProvider.Factory> provider, Provider<SessionManager> provider2) {
        return new SearchByVehicleFragment_MembersInjector(provider, provider2);
    }

    public void injectMembers(SearchByVehicleFragment searchByVehicleFragment) {
        injectViewModelFactory(searchByVehicleFragment, this.viewModelFactoryProvider.get());
        injectSessionManager(searchByVehicleFragment, this.sessionManagerProvider.get());
    }

    public static void injectViewModelFactory(SearchByVehicleFragment searchByVehicleFragment, ViewModelProvider.Factory factory) {
        searchByVehicleFragment.viewModelFactory = factory;
    }

    public static void injectSessionManager(SearchByVehicleFragment searchByVehicleFragment, SessionManager sessionManager) {
        searchByVehicleFragment.sessionManager = sessionManager;
    }
}
