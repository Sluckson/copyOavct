package com.iaai.android.bdt.feature.login;

import androidx.lifecycle.ViewModelProvider;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class BDTTermsOfUseActivity_MembersInjector implements MembersInjector<BDTTermsOfUseActivity> {
    private final Provider<SessionManager> sessionManagerProvider;
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public BDTTermsOfUseActivity_MembersInjector(Provider<ViewModelProvider.Factory> provider, Provider<SessionManager> provider2) {
        this.viewModelFactoryProvider = provider;
        this.sessionManagerProvider = provider2;
    }

    public static MembersInjector<BDTTermsOfUseActivity> create(Provider<ViewModelProvider.Factory> provider, Provider<SessionManager> provider2) {
        return new BDTTermsOfUseActivity_MembersInjector(provider, provider2);
    }

    public void injectMembers(BDTTermsOfUseActivity bDTTermsOfUseActivity) {
        injectViewModelFactory(bDTTermsOfUseActivity, this.viewModelFactoryProvider.get());
        injectSessionManager(bDTTermsOfUseActivity, this.sessionManagerProvider.get());
    }

    public static void injectViewModelFactory(BDTTermsOfUseActivity bDTTermsOfUseActivity, ViewModelProvider.Factory factory) {
        bDTTermsOfUseActivity.viewModelFactory = factory;
    }

    public static void injectSessionManager(BDTTermsOfUseActivity bDTTermsOfUseActivity, SessionManager sessionManager) {
        bDTTermsOfUseActivity.sessionManager = sessionManager;
    }
}
