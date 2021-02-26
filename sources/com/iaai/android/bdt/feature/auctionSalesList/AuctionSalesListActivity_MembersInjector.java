package com.iaai.android.bdt.feature.auctionSalesList;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.iaai.android.bdt.base.BaseActivity_MembersInjector;
import com.iaai.android.bdt.feature.login.SessionManager;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

public final class AuctionSalesListActivity_MembersInjector implements MembersInjector<AuctionSalesListActivity> {
    private final Provider<DispatchingAndroidInjector<Fragment>> dispatchingAndroidInjectorProvider;
    private final Provider<SessionManager> sessionManagerProvider;
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public AuctionSalesListActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<ViewModelProvider.Factory> provider2, Provider<SessionManager> provider3) {
        this.dispatchingAndroidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
        this.sessionManagerProvider = provider3;
    }

    public static MembersInjector<AuctionSalesListActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<ViewModelProvider.Factory> provider2, Provider<SessionManager> provider3) {
        return new AuctionSalesListActivity_MembersInjector(provider, provider2, provider3);
    }

    public void injectMembers(AuctionSalesListActivity auctionSalesListActivity) {
        BaseActivity_MembersInjector.injectDispatchingAndroidInjector(auctionSalesListActivity, this.dispatchingAndroidInjectorProvider.get());
        injectViewModelFactory(auctionSalesListActivity, this.viewModelFactoryProvider.get());
        injectSessionManager(auctionSalesListActivity, this.sessionManagerProvider.get());
    }

    public static void injectViewModelFactory(AuctionSalesListActivity auctionSalesListActivity, ViewModelProvider.Factory factory) {
        auctionSalesListActivity.viewModelFactory = factory;
    }

    public static void injectSessionManager(AuctionSalesListActivity auctionSalesListActivity, SessionManager sessionManager) {
        auctionSalesListActivity.sessionManager = sessionManager;
    }
}
