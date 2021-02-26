package com.iaai.android.bdt.feature.login;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.iaai.android.bdt.base.BaseActivity_MembersInjector;
import com.iaai.android.bdt.utils.SharedPrefsHelper;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

public final class OldBDTLoginActivity_MembersInjector implements MembersInjector<OldBDTLoginActivity> {
    private final Provider<DispatchingAndroidInjector<Fragment>> dispatchingAndroidInjectorProvider;
    private final Provider<SessionManager> sessionManagerProvider;
    private final Provider<SharedPrefsHelper> sharedPrefsHelperProvider;
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public OldBDTLoginActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<ViewModelProvider.Factory> provider2, Provider<SessionManager> provider3, Provider<SharedPrefsHelper> provider4) {
        this.dispatchingAndroidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
        this.sessionManagerProvider = provider3;
        this.sharedPrefsHelperProvider = provider4;
    }

    public static MembersInjector<OldBDTLoginActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<ViewModelProvider.Factory> provider2, Provider<SessionManager> provider3, Provider<SharedPrefsHelper> provider4) {
        return new OldBDTLoginActivity_MembersInjector(provider, provider2, provider3, provider4);
    }

    public void injectMembers(OldBDTLoginActivity oldBDTLoginActivity) {
        BaseActivity_MembersInjector.injectDispatchingAndroidInjector(oldBDTLoginActivity, this.dispatchingAndroidInjectorProvider.get());
        injectViewModelFactory(oldBDTLoginActivity, this.viewModelFactoryProvider.get());
        injectSessionManager(oldBDTLoginActivity, this.sessionManagerProvider.get());
        injectSharedPrefsHelper(oldBDTLoginActivity, this.sharedPrefsHelperProvider.get());
    }

    public static void injectViewModelFactory(OldBDTLoginActivity oldBDTLoginActivity, ViewModelProvider.Factory factory) {
        oldBDTLoginActivity.viewModelFactory = factory;
    }

    public static void injectSessionManager(OldBDTLoginActivity oldBDTLoginActivity, SessionManager sessionManager) {
        oldBDTLoginActivity.sessionManager = sessionManager;
    }

    public static void injectSharedPrefsHelper(OldBDTLoginActivity oldBDTLoginActivity, SharedPrefsHelper sharedPrefsHelper) {
        oldBDTLoginActivity.sharedPrefsHelper = sharedPrefsHelper;
    }
}
