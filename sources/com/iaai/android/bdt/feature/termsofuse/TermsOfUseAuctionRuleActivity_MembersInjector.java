package com.iaai.android.bdt.feature.termsofuse;

import androidx.lifecycle.ViewModelProvider;
import com.iaai.android.bdt.feature.login.SessionManager;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class TermsOfUseAuctionRuleActivity_MembersInjector implements MembersInjector<TermsOfUseAuctionRuleActivity> {
    private final Provider<SessionManager> sessionManagerProvider;
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public TermsOfUseAuctionRuleActivity_MembersInjector(Provider<ViewModelProvider.Factory> provider, Provider<SessionManager> provider2) {
        this.viewModelFactoryProvider = provider;
        this.sessionManagerProvider = provider2;
    }

    public static MembersInjector<TermsOfUseAuctionRuleActivity> create(Provider<ViewModelProvider.Factory> provider, Provider<SessionManager> provider2) {
        return new TermsOfUseAuctionRuleActivity_MembersInjector(provider, provider2);
    }

    public void injectMembers(TermsOfUseAuctionRuleActivity termsOfUseAuctionRuleActivity) {
        injectViewModelFactory(termsOfUseAuctionRuleActivity, this.viewModelFactoryProvider.get());
        injectSessionManager(termsOfUseAuctionRuleActivity, this.sessionManagerProvider.get());
    }

    public static void injectViewModelFactory(TermsOfUseAuctionRuleActivity termsOfUseAuctionRuleActivity, ViewModelProvider.Factory factory) {
        termsOfUseAuctionRuleActivity.viewModelFactory = factory;
    }

    public static void injectSessionManager(TermsOfUseAuctionRuleActivity termsOfUseAuctionRuleActivity, SessionManager sessionManager) {
        termsOfUseAuctionRuleActivity.sessionManager = sessionManager;
    }
}
