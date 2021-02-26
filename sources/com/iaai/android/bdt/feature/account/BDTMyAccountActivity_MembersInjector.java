package com.iaai.android.bdt.feature.account;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.iaai.android.bdt.base.BaseActivity_MembersInjector;
import com.iaai.android.bdt.base.MVVMNavDrawerActivity_MembersInjector;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.bdt.utils.SharedPrefsHelper;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

public final class BDTMyAccountActivity_MembersInjector implements MembersInjector<BDTMyAccountActivity> {
    private final Provider<DispatchingAndroidInjector<Fragment>> dispatchingAndroidInjectorProvider;
    private final Provider<SessionManager> sessionManagerProvider;
    private final Provider<SharedPrefsHelper> sharedPrefsHelperProvider;
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public BDTMyAccountActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<SessionManager> provider2, Provider<SharedPrefsHelper> provider3, Provider<ViewModelProvider.Factory> provider4) {
        this.dispatchingAndroidInjectorProvider = provider;
        this.sessionManagerProvider = provider2;
        this.sharedPrefsHelperProvider = provider3;
        this.viewModelFactoryProvider = provider4;
    }

    public static MembersInjector<BDTMyAccountActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<SessionManager> provider2, Provider<SharedPrefsHelper> provider3, Provider<ViewModelProvider.Factory> provider4) {
        return new BDTMyAccountActivity_MembersInjector(provider, provider2, provider3, provider4);
    }

    public void injectMembers(BDTMyAccountActivity bDTMyAccountActivity) {
        BaseActivity_MembersInjector.injectDispatchingAndroidInjector(bDTMyAccountActivity, this.dispatchingAndroidInjectorProvider.get());
        MVVMNavDrawerActivity_MembersInjector.injectSessionManager(bDTMyAccountActivity, this.sessionManagerProvider.get());
        MVVMNavDrawerActivity_MembersInjector.injectSharedPrefsHelper(bDTMyAccountActivity, this.sharedPrefsHelperProvider.get());
        injectViewModelFactory(bDTMyAccountActivity, this.viewModelFactoryProvider.get());
    }

    public static void injectViewModelFactory(BDTMyAccountActivity bDTMyAccountActivity, ViewModelProvider.Factory factory) {
        bDTMyAccountActivity.viewModelFactory = factory;
    }
}
