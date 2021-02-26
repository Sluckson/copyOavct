package com.iaai.android.bdt.feature.landing;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.iaai.android.bdt.base.BaseActivity_MembersInjector;
import com.iaai.android.bdt.base.MVVMNavDrawerActivity_MembersInjector;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.bdt.utils.SharedPrefsHelper;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

public final class BDTLandingPageActivity_MembersInjector implements MembersInjector<BDTLandingPageActivity> {
    private final Provider<DispatchingAndroidInjector<Fragment>> dispatchingAndroidInjectorProvider;
    private final Provider<SessionManager> sessionManagerProvider;
    private final Provider<SharedPrefsHelper> sharedPrefsHelperProvider;
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public BDTLandingPageActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<SessionManager> provider2, Provider<SharedPrefsHelper> provider3, Provider<ViewModelProvider.Factory> provider4) {
        this.dispatchingAndroidInjectorProvider = provider;
        this.sessionManagerProvider = provider2;
        this.sharedPrefsHelperProvider = provider3;
        this.viewModelFactoryProvider = provider4;
    }

    public static MembersInjector<BDTLandingPageActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<SessionManager> provider2, Provider<SharedPrefsHelper> provider3, Provider<ViewModelProvider.Factory> provider4) {
        return new BDTLandingPageActivity_MembersInjector(provider, provider2, provider3, provider4);
    }

    public void injectMembers(BDTLandingPageActivity bDTLandingPageActivity) {
        BaseActivity_MembersInjector.injectDispatchingAndroidInjector(bDTLandingPageActivity, this.dispatchingAndroidInjectorProvider.get());
        MVVMNavDrawerActivity_MembersInjector.injectSessionManager(bDTLandingPageActivity, this.sessionManagerProvider.get());
        MVVMNavDrawerActivity_MembersInjector.injectSharedPrefsHelper(bDTLandingPageActivity, this.sharedPrefsHelperProvider.get());
        injectViewModelFactory(bDTLandingPageActivity, this.viewModelFactoryProvider.get());
    }

    public static void injectViewModelFactory(BDTLandingPageActivity bDTLandingPageActivity, ViewModelProvider.Factory factory) {
        bDTLandingPageActivity.viewModelFactory = factory;
    }
}
