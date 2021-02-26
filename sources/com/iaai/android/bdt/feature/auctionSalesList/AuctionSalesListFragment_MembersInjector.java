package com.iaai.android.bdt.feature.auctionSalesList;

import com.iaai.android.bdt.feature.login.SessionManager;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class AuctionSalesListFragment_MembersInjector implements MembersInjector<AuctionSalesListFragment> {
    private final Provider<SessionManager> sessionManagerProvider;

    public AuctionSalesListFragment_MembersInjector(Provider<SessionManager> provider) {
        this.sessionManagerProvider = provider;
    }

    public static MembersInjector<AuctionSalesListFragment> create(Provider<SessionManager> provider) {
        return new AuctionSalesListFragment_MembersInjector(provider);
    }

    public void injectMembers(AuctionSalesListFragment auctionSalesListFragment) {
        injectSessionManager(auctionSalesListFragment, this.sessionManagerProvider.get());
    }

    public static void injectSessionManager(AuctionSalesListFragment auctionSalesListFragment, SessionManager sessionManager) {
        auctionSalesListFragment.sessionManager = sessionManager;
    }
}
