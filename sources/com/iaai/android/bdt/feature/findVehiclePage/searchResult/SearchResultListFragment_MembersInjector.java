package com.iaai.android.bdt.feature.findVehiclePage.searchResult;

import androidx.lifecycle.ViewModelProvider;
import com.iaai.android.bdt.feature.login.SessionManager;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class SearchResultListFragment_MembersInjector implements MembersInjector<SearchResultListFragment> {
    private final Provider<SessionManager> sessionManagerProvider;
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public SearchResultListFragment_MembersInjector(Provider<ViewModelProvider.Factory> provider, Provider<SessionManager> provider2) {
        this.viewModelFactoryProvider = provider;
        this.sessionManagerProvider = provider2;
    }

    public static MembersInjector<SearchResultListFragment> create(Provider<ViewModelProvider.Factory> provider, Provider<SessionManager> provider2) {
        return new SearchResultListFragment_MembersInjector(provider, provider2);
    }

    public void injectMembers(SearchResultListFragment searchResultListFragment) {
        injectViewModelFactory(searchResultListFragment, this.viewModelFactoryProvider.get());
        injectSessionManager(searchResultListFragment, this.sessionManagerProvider.get());
    }

    public static void injectViewModelFactory(SearchResultListFragment searchResultListFragment, ViewModelProvider.Factory factory) {
        searchResultListFragment.viewModelFactory = factory;
    }

    public static void injectSessionManager(SearchResultListFragment searchResultListFragment, SessionManager sessionManager) {
        searchResultListFragment.sessionManager = sessionManager;
    }
}
