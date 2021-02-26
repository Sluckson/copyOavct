package com.iaai.android.bdt.feature.digitalNegotiation;

import com.iaai.android.bdt.feature.login.SessionManager;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class ManageOfferListFragment_MembersInjector implements MembersInjector<ManageOfferListFragment> {
    private final Provider<SessionManager> sessionManagerProvider;

    public ManageOfferListFragment_MembersInjector(Provider<SessionManager> provider) {
        this.sessionManagerProvider = provider;
    }

    public static MembersInjector<ManageOfferListFragment> create(Provider<SessionManager> provider) {
        return new ManageOfferListFragment_MembersInjector(provider);
    }

    public void injectMembers(ManageOfferListFragment manageOfferListFragment) {
        injectSessionManager(manageOfferListFragment, this.sessionManagerProvider.get());
    }

    public static void injectSessionManager(ManageOfferListFragment manageOfferListFragment, SessionManager sessionManager) {
        manageOfferListFragment.sessionManager = sessionManager;
    }
}
