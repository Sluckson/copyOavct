package com.iaai.android.bdt.feature.myAccount.toBePaid;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.iaai.android.bdt.base.BaseActivity_MembersInjector;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.bdt.utils.SharedPrefsHelper;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

public final class BDTPaymentMethodActivity_MembersInjector implements MembersInjector<BDTPaymentMethodActivity> {
    private final Provider<DispatchingAndroidInjector<Fragment>> dispatchingAndroidInjectorProvider;
    private final Provider<SessionManager> sessionManagerProvider;
    private final Provider<SharedPrefsHelper> sharedPrefsHelperProvider;
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public BDTPaymentMethodActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<ViewModelProvider.Factory> provider2, Provider<SharedPrefsHelper> provider3, Provider<SessionManager> provider4) {
        this.dispatchingAndroidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
        this.sharedPrefsHelperProvider = provider3;
        this.sessionManagerProvider = provider4;
    }

    public static MembersInjector<BDTPaymentMethodActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<ViewModelProvider.Factory> provider2, Provider<SharedPrefsHelper> provider3, Provider<SessionManager> provider4) {
        return new BDTPaymentMethodActivity_MembersInjector(provider, provider2, provider3, provider4);
    }

    public void injectMembers(BDTPaymentMethodActivity bDTPaymentMethodActivity) {
        BaseActivity_MembersInjector.injectDispatchingAndroidInjector(bDTPaymentMethodActivity, this.dispatchingAndroidInjectorProvider.get());
        injectViewModelFactory(bDTPaymentMethodActivity, this.viewModelFactoryProvider.get());
        injectSharedPrefsHelper(bDTPaymentMethodActivity, this.sharedPrefsHelperProvider.get());
        injectSessionManager(bDTPaymentMethodActivity, this.sessionManagerProvider.get());
    }

    public static void injectViewModelFactory(BDTPaymentMethodActivity bDTPaymentMethodActivity, ViewModelProvider.Factory factory) {
        bDTPaymentMethodActivity.viewModelFactory = factory;
    }

    public static void injectSharedPrefsHelper(BDTPaymentMethodActivity bDTPaymentMethodActivity, SharedPrefsHelper sharedPrefsHelper) {
        bDTPaymentMethodActivity.sharedPrefsHelper = sharedPrefsHelper;
    }

    public static void injectSessionManager(BDTPaymentMethodActivity bDTPaymentMethodActivity, SessionManager sessionManager) {
        bDTPaymentMethodActivity.sessionManager = sessionManager;
    }
}
