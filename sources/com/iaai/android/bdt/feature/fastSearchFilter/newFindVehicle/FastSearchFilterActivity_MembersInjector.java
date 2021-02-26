package com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle;

import androidx.fragment.app.Fragment;
import com.iaai.android.bdt.base.BaseActivity_MembersInjector;
import com.iaai.android.bdt.base.MVVMNavDrawerActivity_MembersInjector;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.bdt.utils.SharedPrefsHelper;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

public final class FastSearchFilterActivity_MembersInjector implements MembersInjector<FastSearchFilterActivity> {
    private final Provider<DispatchingAndroidInjector<Fragment>> dispatchingAndroidInjectorProvider;
    private final Provider<SessionManager> sessionManagerProvider;
    private final Provider<SharedPrefsHelper> sharedPrefsHelperProvider;

    public FastSearchFilterActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<SessionManager> provider2, Provider<SharedPrefsHelper> provider3) {
        this.dispatchingAndroidInjectorProvider = provider;
        this.sessionManagerProvider = provider2;
        this.sharedPrefsHelperProvider = provider3;
    }

    public static MembersInjector<FastSearchFilterActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<SessionManager> provider2, Provider<SharedPrefsHelper> provider3) {
        return new FastSearchFilterActivity_MembersInjector(provider, provider2, provider3);
    }

    public void injectMembers(FastSearchFilterActivity fastSearchFilterActivity) {
        BaseActivity_MembersInjector.injectDispatchingAndroidInjector(fastSearchFilterActivity, this.dispatchingAndroidInjectorProvider.get());
        MVVMNavDrawerActivity_MembersInjector.injectSessionManager(fastSearchFilterActivity, this.sessionManagerProvider.get());
        MVVMNavDrawerActivity_MembersInjector.injectSharedPrefsHelper(fastSearchFilterActivity, this.sharedPrefsHelperProvider.get());
    }
}
