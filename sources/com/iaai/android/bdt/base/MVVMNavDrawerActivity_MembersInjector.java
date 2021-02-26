package com.iaai.android.bdt.base;

import androidx.fragment.app.Fragment;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.bdt.utils.SharedPrefsHelper;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

public final class MVVMNavDrawerActivity_MembersInjector implements MembersInjector<MVVMNavDrawerActivity> {
    private final Provider<DispatchingAndroidInjector<Fragment>> dispatchingAndroidInjectorProvider;
    private final Provider<SessionManager> sessionManagerProvider;
    private final Provider<SharedPrefsHelper> sharedPrefsHelperProvider;

    public MVVMNavDrawerActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<SessionManager> provider2, Provider<SharedPrefsHelper> provider3) {
        this.dispatchingAndroidInjectorProvider = provider;
        this.sessionManagerProvider = provider2;
        this.sharedPrefsHelperProvider = provider3;
    }

    public static MembersInjector<MVVMNavDrawerActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<SessionManager> provider2, Provider<SharedPrefsHelper> provider3) {
        return new MVVMNavDrawerActivity_MembersInjector(provider, provider2, provider3);
    }

    public void injectMembers(MVVMNavDrawerActivity mVVMNavDrawerActivity) {
        BaseActivity_MembersInjector.injectDispatchingAndroidInjector(mVVMNavDrawerActivity, this.dispatchingAndroidInjectorProvider.get());
        injectSessionManager(mVVMNavDrawerActivity, this.sessionManagerProvider.get());
        injectSharedPrefsHelper(mVVMNavDrawerActivity, this.sharedPrefsHelperProvider.get());
    }

    public static void injectSessionManager(MVVMNavDrawerActivity mVVMNavDrawerActivity, SessionManager sessionManager) {
        mVVMNavDrawerActivity.sessionManager = sessionManager;
    }

    public static void injectSharedPrefsHelper(MVVMNavDrawerActivity mVVMNavDrawerActivity, SharedPrefsHelper sharedPrefsHelper) {
        mVVMNavDrawerActivity.sharedPrefsHelper = sharedPrefsHelper;
    }
}
