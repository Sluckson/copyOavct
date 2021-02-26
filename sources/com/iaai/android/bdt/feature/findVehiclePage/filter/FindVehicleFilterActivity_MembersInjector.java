package com.iaai.android.bdt.feature.findVehiclePage.filter;

import androidx.fragment.app.Fragment;
import com.iaai.android.bdt.base.BaseActivity_MembersInjector;
import com.iaai.android.bdt.base.MVVMNavDrawerActivity_MembersInjector;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.bdt.utils.SharedPrefsHelper;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

public final class FindVehicleFilterActivity_MembersInjector implements MembersInjector<FindVehicleFilterActivity> {
    private final Provider<DispatchingAndroidInjector<Fragment>> dispatchingAndroidInjectorProvider;
    private final Provider<SessionManager> sessionManagerProvider;
    private final Provider<SharedPrefsHelper> sharedPrefsHelperProvider;

    public FindVehicleFilterActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<SessionManager> provider2, Provider<SharedPrefsHelper> provider3) {
        this.dispatchingAndroidInjectorProvider = provider;
        this.sessionManagerProvider = provider2;
        this.sharedPrefsHelperProvider = provider3;
    }

    public static MembersInjector<FindVehicleFilterActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<SessionManager> provider2, Provider<SharedPrefsHelper> provider3) {
        return new FindVehicleFilterActivity_MembersInjector(provider, provider2, provider3);
    }

    public void injectMembers(FindVehicleFilterActivity findVehicleFilterActivity) {
        BaseActivity_MembersInjector.injectDispatchingAndroidInjector(findVehicleFilterActivity, this.dispatchingAndroidInjectorProvider.get());
        MVVMNavDrawerActivity_MembersInjector.injectSessionManager(findVehicleFilterActivity, this.sessionManagerProvider.get());
        MVVMNavDrawerActivity_MembersInjector.injectSharedPrefsHelper(findVehicleFilterActivity, this.sharedPrefsHelperProvider.get());
    }
}
