package com.iaai.android.bdt.feature.login;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.iaai.android.bdt.base.BaseActivity_MembersInjector;
import com.iaai.android.bdt.utils.SharedPrefsHelper;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

public final class BDTLoginActivity_MembersInjector implements MembersInjector<BDTLoginActivity> {
    private final Provider<DispatchingAndroidInjector<Fragment>> dispatchingAndroidInjectorProvider;
    private final Provider<SessionManager> sessionManagerProvider;
    private final Provider<SharedPrefsHelper> sharedPrefsHelperProvider;
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public BDTLoginActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<ViewModelProvider.Factory> provider2, Provider<SessionManager> provider3, Provider<SharedPrefsHelper> provider4) {
        this.dispatchingAndroidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
        this.sessionManagerProvider = provider3;
        this.sharedPrefsHelperProvider = provider4;
    }

    public static MembersInjector<BDTLoginActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<ViewModelProvider.Factory> provider2, Provider<SessionManager> provider3, Provider<SharedPrefsHelper> provider4) {
        return new BDTLoginActivity_MembersInjector(provider, provider2, provider3, provider4);
    }

    public void injectMembers(BDTLoginActivity bDTLoginActivity) {
        BaseActivity_MembersInjector.injectDispatchingAndroidInjector(bDTLoginActivity, this.dispatchingAndroidInjectorProvider.get());
        injectViewModelFactory(bDTLoginActivity, this.viewModelFactoryProvider.get());
        injectSessionManager(bDTLoginActivity, this.sessionManagerProvider.get());
        injectSharedPrefsHelper(bDTLoginActivity, this.sharedPrefsHelperProvider.get());
    }

    public static void injectViewModelFactory(BDTLoginActivity bDTLoginActivity, ViewModelProvider.Factory factory) {
        bDTLoginActivity.viewModelFactory = factory;
    }

    public static void injectSessionManager(BDTLoginActivity bDTLoginActivity, SessionManager sessionManager) {
        bDTLoginActivity.sessionManager = sessionManager;
    }

    public static void injectSharedPrefsHelper(BDTLoginActivity bDTLoginActivity, SharedPrefsHelper sharedPrefsHelper) {
        bDTLoginActivity.sharedPrefsHelper = sharedPrefsHelper;
    }
}
