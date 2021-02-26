package com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList;

import androidx.lifecycle.ViewModelProvider;
import com.iaai.android.bdt.feature.login.SessionManager;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class InsertRepOrAddFragment_MembersInjector implements MembersInjector<InsertRepOrAddFragment> {
    private final Provider<SessionManager> sessionManagerProvider;
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public InsertRepOrAddFragment_MembersInjector(Provider<ViewModelProvider.Factory> provider, Provider<SessionManager> provider2) {
        this.viewModelFactoryProvider = provider;
        this.sessionManagerProvider = provider2;
    }

    public static MembersInjector<InsertRepOrAddFragment> create(Provider<ViewModelProvider.Factory> provider, Provider<SessionManager> provider2) {
        return new InsertRepOrAddFragment_MembersInjector(provider, provider2);
    }

    public void injectMembers(InsertRepOrAddFragment insertRepOrAddFragment) {
        injectViewModelFactory(insertRepOrAddFragment, this.viewModelFactoryProvider.get());
        injectSessionManager(insertRepOrAddFragment, this.sessionManagerProvider.get());
    }

    public static void injectViewModelFactory(InsertRepOrAddFragment insertRepOrAddFragment, ViewModelProvider.Factory factory) {
        insertRepOrAddFragment.viewModelFactory = factory;
    }

    public static void injectSessionManager(InsertRepOrAddFragment insertRepOrAddFragment, SessionManager sessionManager) {
        insertRepOrAddFragment.sessionManager = sessionManager;
    }
}
