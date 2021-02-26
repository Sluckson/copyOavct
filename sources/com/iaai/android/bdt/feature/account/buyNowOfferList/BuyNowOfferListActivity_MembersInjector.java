package com.iaai.android.bdt.feature.account.buyNowOfferList;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.iaai.android.bdt.base.BaseActivity_MembersInjector;
import com.iaai.android.bdt.feature.login.SessionManager;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

public final class BuyNowOfferListActivity_MembersInjector implements MembersInjector<BuyNowOfferListActivity> {
    private final Provider<DispatchingAndroidInjector<Fragment>> dispatchingAndroidInjectorProvider;
    private final Provider<SessionManager> sessionManagerProvider;
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public BuyNowOfferListActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<ViewModelProvider.Factory> provider2, Provider<SessionManager> provider3) {
        this.dispatchingAndroidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
        this.sessionManagerProvider = provider3;
    }

    public static MembersInjector<BuyNowOfferListActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<ViewModelProvider.Factory> provider2, Provider<SessionManager> provider3) {
        return new BuyNowOfferListActivity_MembersInjector(provider, provider2, provider3);
    }

    public void injectMembers(BuyNowOfferListActivity buyNowOfferListActivity) {
        BaseActivity_MembersInjector.injectDispatchingAndroidInjector(buyNowOfferListActivity, this.dispatchingAndroidInjectorProvider.get());
        injectViewModelFactory(buyNowOfferListActivity, this.viewModelFactoryProvider.get());
        injectSessionManager(buyNowOfferListActivity, this.sessionManagerProvider.get());
    }

    public static void injectViewModelFactory(BuyNowOfferListActivity buyNowOfferListActivity, ViewModelProvider.Factory factory) {
        buyNowOfferListActivity.viewModelFactory = factory;
    }

    public static void injectSessionManager(BuyNowOfferListActivity buyNowOfferListActivity, SessionManager sessionManager) {
        buyNowOfferListActivity.sessionManager = sessionManager;
    }
}
