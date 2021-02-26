package com.iaai.android.bdt.feature.account;

import com.iaai.android.bdt.feature.login.SessionManager;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class MyListFragment_MembersInjector implements MembersInjector<MyListFragment> {
    private final Provider<SessionManager> sessionManagerProvider;

    public MyListFragment_MembersInjector(Provider<SessionManager> provider) {
        this.sessionManagerProvider = provider;
    }

    public static MembersInjector<MyListFragment> create(Provider<SessionManager> provider) {
        return new MyListFragment_MembersInjector(provider);
    }

    public void injectMembers(MyListFragment myListFragment) {
        injectSessionManager(myListFragment, this.sessionManagerProvider.get());
    }

    public static void injectSessionManager(MyListFragment myListFragment, SessionManager sessionManager) {
        myListFragment.sessionManager = sessionManager;
    }
}
