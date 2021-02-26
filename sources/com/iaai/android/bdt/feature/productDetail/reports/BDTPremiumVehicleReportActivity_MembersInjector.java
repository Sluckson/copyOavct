package com.iaai.android.bdt.feature.productDetail.reports;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.iaai.android.bdt.base.BaseActivity_MembersInjector;
import com.iaai.android.bdt.feature.login.SessionManager;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

public final class BDTPremiumVehicleReportActivity_MembersInjector implements MembersInjector<BDTPremiumVehicleReportActivity> {
    private final Provider<DispatchingAndroidInjector<Fragment>> dispatchingAndroidInjectorProvider;
    private final Provider<SessionManager> sessionManagerProvider;
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public BDTPremiumVehicleReportActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<ViewModelProvider.Factory> provider2, Provider<SessionManager> provider3) {
        this.dispatchingAndroidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
        this.sessionManagerProvider = provider3;
    }

    public static MembersInjector<BDTPremiumVehicleReportActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<ViewModelProvider.Factory> provider2, Provider<SessionManager> provider3) {
        return new BDTPremiumVehicleReportActivity_MembersInjector(provider, provider2, provider3);
    }

    public void injectMembers(BDTPremiumVehicleReportActivity bDTPremiumVehicleReportActivity) {
        BaseActivity_MembersInjector.injectDispatchingAndroidInjector(bDTPremiumVehicleReportActivity, this.dispatchingAndroidInjectorProvider.get());
        injectViewModelFactory(bDTPremiumVehicleReportActivity, this.viewModelFactoryProvider.get());
        injectSessionManager(bDTPremiumVehicleReportActivity, this.sessionManagerProvider.get());
    }

    public static void injectViewModelFactory(BDTPremiumVehicleReportActivity bDTPremiumVehicleReportActivity, ViewModelProvider.Factory factory) {
        bDTPremiumVehicleReportActivity.viewModelFactory = factory;
    }

    public static void injectSessionManager(BDTPremiumVehicleReportActivity bDTPremiumVehicleReportActivity, SessionManager sessionManager) {
        bDTPremiumVehicleReportActivity.sessionManager = sessionManager;
    }
}
