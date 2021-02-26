package com.iaai.android.bdt.feature.account.salesdocument;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.iaai.android.bdt.base.BaseActivity_MembersInjector;
import com.iaai.android.bdt.feature.login.SessionManager;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

public final class SalesDocumentActivity_MembersInjector implements MembersInjector<SalesDocumentActivity> {
    private final Provider<DispatchingAndroidInjector<Fragment>> dispatchingAndroidInjectorProvider;
    private final Provider<SessionManager> sessionManagerProvider;
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public SalesDocumentActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<ViewModelProvider.Factory> provider2, Provider<SessionManager> provider3) {
        this.dispatchingAndroidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
        this.sessionManagerProvider = provider3;
    }

    public static MembersInjector<SalesDocumentActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<ViewModelProvider.Factory> provider2, Provider<SessionManager> provider3) {
        return new SalesDocumentActivity_MembersInjector(provider, provider2, provider3);
    }

    public void injectMembers(SalesDocumentActivity salesDocumentActivity) {
        BaseActivity_MembersInjector.injectDispatchingAndroidInjector(salesDocumentActivity, this.dispatchingAndroidInjectorProvider.get());
        injectViewModelFactory(salesDocumentActivity, this.viewModelFactoryProvider.get());
        injectSessionManager(salesDocumentActivity, this.sessionManagerProvider.get());
    }

    public static void injectViewModelFactory(SalesDocumentActivity salesDocumentActivity, ViewModelProvider.Factory factory) {
        salesDocumentActivity.viewModelFactory = factory;
    }

    public static void injectSessionManager(SalesDocumentActivity salesDocumentActivity, SessionManager sessionManager) {
        salesDocumentActivity.sessionManager = sessionManager;
    }
}
