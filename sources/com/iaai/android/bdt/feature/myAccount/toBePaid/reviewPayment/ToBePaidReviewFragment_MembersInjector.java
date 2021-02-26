package com.iaai.android.bdt.feature.myAccount.toBePaid.reviewPayment;

import androidx.lifecycle.ViewModelProvider;
import com.iaai.android.bdt.feature.login.SessionManager;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class ToBePaidReviewFragment_MembersInjector implements MembersInjector<ToBePaidReviewFragment> {
    private final Provider<SessionManager> sessionManagerProvider;
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public ToBePaidReviewFragment_MembersInjector(Provider<SessionManager> provider, Provider<ViewModelProvider.Factory> provider2) {
        this.sessionManagerProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public static MembersInjector<ToBePaidReviewFragment> create(Provider<SessionManager> provider, Provider<ViewModelProvider.Factory> provider2) {
        return new ToBePaidReviewFragment_MembersInjector(provider, provider2);
    }

    public void injectMembers(ToBePaidReviewFragment toBePaidReviewFragment) {
        injectSessionManager(toBePaidReviewFragment, this.sessionManagerProvider.get());
        injectViewModelFactory(toBePaidReviewFragment, this.viewModelFactoryProvider.get());
    }

    public static void injectSessionManager(ToBePaidReviewFragment toBePaidReviewFragment, SessionManager sessionManager) {
        toBePaidReviewFragment.sessionManager = sessionManager;
    }

    public static void injectViewModelFactory(ToBePaidReviewFragment toBePaidReviewFragment, ViewModelProvider.Factory factory) {
        toBePaidReviewFragment.viewModelFactory = factory;
    }
}
