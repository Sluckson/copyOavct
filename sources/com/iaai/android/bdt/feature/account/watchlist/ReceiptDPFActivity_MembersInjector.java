package com.iaai.android.bdt.feature.account.watchlist;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.iaai.android.bdt.base.BaseActivity_MembersInjector;
import com.iaai.android.bdt.feature.login.SessionManager;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

public final class ReceiptDPFActivity_MembersInjector implements MembersInjector<ReceiptDPFActivity> {
    private final Provider<DispatchingAndroidInjector<Fragment>> dispatchingAndroidInjectorProvider;
    private final Provider<SessionManager> sessionManagerProvider;
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public ReceiptDPFActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<ViewModelProvider.Factory> provider2, Provider<SessionManager> provider3) {
        this.dispatchingAndroidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
        this.sessionManagerProvider = provider3;
    }

    public static MembersInjector<ReceiptDPFActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<ViewModelProvider.Factory> provider2, Provider<SessionManager> provider3) {
        return new ReceiptDPFActivity_MembersInjector(provider, provider2, provider3);
    }

    public void injectMembers(ReceiptDPFActivity receiptDPFActivity) {
        BaseActivity_MembersInjector.injectDispatchingAndroidInjector(receiptDPFActivity, this.dispatchingAndroidInjectorProvider.get());
        injectViewModelFactory(receiptDPFActivity, this.viewModelFactoryProvider.get());
        injectSessionManager(receiptDPFActivity, this.sessionManagerProvider.get());
    }

    public static void injectViewModelFactory(ReceiptDPFActivity receiptDPFActivity, ViewModelProvider.Factory factory) {
        receiptDPFActivity.viewModelFactory = factory;
    }

    public static void injectSessionManager(ReceiptDPFActivity receiptDPFActivity, SessionManager sessionManager) {
        receiptDPFActivity.sessionManager = sessionManager;
    }
}
