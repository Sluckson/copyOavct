package com.iaai.android.bdt.feature.account.salesdocument.manageBranchPref;

import androidx.lifecycle.ViewModelProvider;
import com.iaai.android.bdt.feature.login.SessionManager;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class ManageBranchPrefActivity_MembersInjector implements MembersInjector<ManageBranchPrefActivity> {
    private final Provider<SessionManager> sessionManagerProvider;
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public ManageBranchPrefActivity_MembersInjector(Provider<ViewModelProvider.Factory> provider, Provider<SessionManager> provider2) {
        this.viewModelFactoryProvider = provider;
        this.sessionManagerProvider = provider2;
    }

    public static MembersInjector<ManageBranchPrefActivity> create(Provider<ViewModelProvider.Factory> provider, Provider<SessionManager> provider2) {
        return new ManageBranchPrefActivity_MembersInjector(provider, provider2);
    }

    public void injectMembers(ManageBranchPrefActivity manageBranchPrefActivity) {
        injectViewModelFactory(manageBranchPrefActivity, this.viewModelFactoryProvider.get());
        injectSessionManager(manageBranchPrefActivity, this.sessionManagerProvider.get());
    }

    public static void injectViewModelFactory(ManageBranchPrefActivity manageBranchPrefActivity, ViewModelProvider.Factory factory) {
        manageBranchPrefActivity.viewModelFactory = factory;
    }

    public static void injectSessionManager(ManageBranchPrefActivity manageBranchPrefActivity, SessionManager sessionManager) {
        manageBranchPrefActivity.sessionManager = sessionManager;
    }
}
