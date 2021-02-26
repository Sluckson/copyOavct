package com.iaai.android.bdt.feature.landing;

import com.iaai.android.bdt.feature.login.SessionManager;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class LandingViewPagerFragment_MembersInjector implements MembersInjector<LandingViewPagerFragment> {
    private final Provider<SessionManager> sessionManagerProvider;

    public LandingViewPagerFragment_MembersInjector(Provider<SessionManager> provider) {
        this.sessionManagerProvider = provider;
    }

    public static MembersInjector<LandingViewPagerFragment> create(Provider<SessionManager> provider) {
        return new LandingViewPagerFragment_MembersInjector(provider);
    }

    public void injectMembers(LandingViewPagerFragment landingViewPagerFragment) {
        injectSessionManager(landingViewPagerFragment, this.sessionManagerProvider.get());
    }

    public static void injectSessionManager(LandingViewPagerFragment landingViewPagerFragment, SessionManager sessionManager) {
        landingViewPagerFragment.sessionManager = sessionManager;
    }
}
