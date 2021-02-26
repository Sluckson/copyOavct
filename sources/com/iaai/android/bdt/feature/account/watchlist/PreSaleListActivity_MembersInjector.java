package com.iaai.android.bdt.feature.account.watchlist;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.iaai.android.bdt.base.BaseActivity_MembersInjector;
import com.iaai.android.bdt.feature.login.SessionManager;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

public final class PreSaleListActivity_MembersInjector implements MembersInjector<PreSaleListActivity> {
    private final Provider<DispatchingAndroidInjector<Fragment>> dispatchingAndroidInjectorProvider;
    private final Provider<SessionManager> sessionManagerProvider;
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public PreSaleListActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<ViewModelProvider.Factory> provider2, Provider<SessionManager> provider3) {
        this.dispatchingAndroidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
        this.sessionManagerProvider = provider3;
    }

    public static MembersInjector<PreSaleListActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<ViewModelProvider.Factory> provider2, Provider<SessionManager> provider3) {
        return new PreSaleListActivity_MembersInjector(provider, provider2, provider3);
    }

    public void injectMembers(PreSaleListActivity preSaleListActivity) {
        BaseActivity_MembersInjector.injectDispatchingAndroidInjector(preSaleListActivity, this.dispatchingAndroidInjectorProvider.get());
        injectViewModelFactory(preSaleListActivity, this.viewModelFactoryProvider.get());
        injectSessionManager(preSaleListActivity, this.sessionManagerProvider.get());
    }

    public static void injectViewModelFactory(PreSaleListActivity preSaleListActivity, ViewModelProvider.Factory factory) {
        preSaleListActivity.viewModelFactory = factory;
    }

    public static void injectSessionManager(PreSaleListActivity preSaleListActivity, SessionManager sessionManager) {
        preSaleListActivity.sessionManager = sessionManager;
    }
}
