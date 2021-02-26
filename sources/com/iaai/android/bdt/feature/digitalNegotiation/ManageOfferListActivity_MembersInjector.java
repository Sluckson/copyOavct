package com.iaai.android.bdt.feature.digitalNegotiation;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.iaai.android.bdt.base.BaseActivity_MembersInjector;
import com.iaai.android.bdt.feature.login.SessionManager;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

public final class ManageOfferListActivity_MembersInjector implements MembersInjector<ManageOfferListActivity> {
    private final Provider<DispatchingAndroidInjector<Fragment>> dispatchingAndroidInjectorProvider;
    private final Provider<SessionManager> sessionManagerProvider;
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public ManageOfferListActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<ViewModelProvider.Factory> provider2, Provider<SessionManager> provider3) {
        this.dispatchingAndroidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
        this.sessionManagerProvider = provider3;
    }

    public static MembersInjector<ManageOfferListActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<ViewModelProvider.Factory> provider2, Provider<SessionManager> provider3) {
        return new ManageOfferListActivity_MembersInjector(provider, provider2, provider3);
    }

    public void injectMembers(ManageOfferListActivity manageOfferListActivity) {
        BaseActivity_MembersInjector.injectDispatchingAndroidInjector(manageOfferListActivity, this.dispatchingAndroidInjectorProvider.get());
        injectViewModelFactory(manageOfferListActivity, this.viewModelFactoryProvider.get());
        injectSessionManager(manageOfferListActivity, this.sessionManagerProvider.get());
    }

    public static void injectViewModelFactory(ManageOfferListActivity manageOfferListActivity, ViewModelProvider.Factory factory) {
        manageOfferListActivity.viewModelFactory = factory;
    }

    public static void injectSessionManager(ManageOfferListActivity manageOfferListActivity, SessionManager sessionManager) {
        manageOfferListActivity.sessionManager = sessionManager;
    }
}
