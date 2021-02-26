package com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.iaai.android.bdt.base.BaseActivity_MembersInjector;
import com.iaai.android.bdt.feature.login.SessionManager;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

public final class SaleDocListActivity_MembersInjector implements MembersInjector<SaleDocListActivity> {
    private final Provider<DispatchingAndroidInjector<Fragment>> dispatchingAndroidInjectorProvider;
    private final Provider<SessionManager> sessionManagerProvider;
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public SaleDocListActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<ViewModelProvider.Factory> provider2, Provider<SessionManager> provider3) {
        this.dispatchingAndroidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
        this.sessionManagerProvider = provider3;
    }

    public static MembersInjector<SaleDocListActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<ViewModelProvider.Factory> provider2, Provider<SessionManager> provider3) {
        return new SaleDocListActivity_MembersInjector(provider, provider2, provider3);
    }

    public void injectMembers(SaleDocListActivity saleDocListActivity) {
        BaseActivity_MembersInjector.injectDispatchingAndroidInjector(saleDocListActivity, this.dispatchingAndroidInjectorProvider.get());
        injectViewModelFactory(saleDocListActivity, this.viewModelFactoryProvider.get());
        injectSessionManager(saleDocListActivity, this.sessionManagerProvider.get());
    }

    public static void injectViewModelFactory(SaleDocListActivity saleDocListActivity, ViewModelProvider.Factory factory) {
        saleDocListActivity.viewModelFactory = factory;
    }

    public static void injectSessionManager(SaleDocListActivity saleDocListActivity, SessionManager sessionManager) {
        saleDocListActivity.sessionManager = sessionManager;
    }
}
