package com.iaai.android.bdt.feature.productDetail;

import androidx.lifecycle.ViewModelProvider;
import com.iaai.android.bdt.feature.login.SessionManager;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class ViewPagerFragment_MembersInjector implements MembersInjector<ViewPagerFragment> {
    private final Provider<SessionManager> sessionManagerProvider;
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public ViewPagerFragment_MembersInjector(Provider<ViewModelProvider.Factory> provider, Provider<SessionManager> provider2) {
        this.viewModelFactoryProvider = provider;
        this.sessionManagerProvider = provider2;
    }

    public static MembersInjector<ViewPagerFragment> create(Provider<ViewModelProvider.Factory> provider, Provider<SessionManager> provider2) {
        return new ViewPagerFragment_MembersInjector(provider, provider2);
    }

    public void injectMembers(ViewPagerFragment viewPagerFragment) {
        injectViewModelFactory(viewPagerFragment, this.viewModelFactoryProvider.get());
        injectSessionManager(viewPagerFragment, this.sessionManagerProvider.get());
    }

    public static void injectViewModelFactory(ViewPagerFragment viewPagerFragment, ViewModelProvider.Factory factory) {
        viewPagerFragment.viewModelFactory = factory;
    }

    public static void injectSessionManager(ViewPagerFragment viewPagerFragment, SessionManager sessionManager) {
        viewPagerFragment.sessionManager = sessionManager;
    }
}
