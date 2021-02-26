package com.iaai.android.bdt.feature.auctionMainPage;

import com.iaai.android.bdt.feature.login.SessionManager;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class AuctionMainListFragment_MembersInjector implements MembersInjector<AuctionMainListFragment> {
    private final Provider<SessionManager> sessionManagerProvider;

    public AuctionMainListFragment_MembersInjector(Provider<SessionManager> provider) {
        this.sessionManagerProvider = provider;
    }

    public static MembersInjector<AuctionMainListFragment> create(Provider<SessionManager> provider) {
        return new AuctionMainListFragment_MembersInjector(provider);
    }

    public void injectMembers(AuctionMainListFragment auctionMainListFragment) {
        injectSessionManager(auctionMainListFragment, this.sessionManagerProvider.get());
    }

    public static void injectSessionManager(AuctionMainListFragment auctionMainListFragment, SessionManager sessionManager) {
        auctionMainListFragment.sessionManager = sessionManager;
    }
}
