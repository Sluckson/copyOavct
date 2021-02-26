package com.iaai.android.bdt.feature.auctionMainPage;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.iaai.android.bdt.base.BaseActivity_MembersInjector;
import com.iaai.android.bdt.base.MVVMNavDrawerActivity_MembersInjector;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.bdt.utils.SharedPrefsHelper;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

public final class BDTAuctionMainListActivity_MembersInjector implements MembersInjector<BDTAuctionMainListActivity> {
    private final Provider<DispatchingAndroidInjector<Fragment>> dispatchingAndroidInjectorProvider;
    private final Provider<SessionManager> sessionManagerProvider;
    private final Provider<SharedPrefsHelper> sharedPrefsHelperProvider;
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public BDTAuctionMainListActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<SessionManager> provider2, Provider<SharedPrefsHelper> provider3, Provider<ViewModelProvider.Factory> provider4) {
        this.dispatchingAndroidInjectorProvider = provider;
        this.sessionManagerProvider = provider2;
        this.sharedPrefsHelperProvider = provider3;
        this.viewModelFactoryProvider = provider4;
    }

    public static MembersInjector<BDTAuctionMainListActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<SessionManager> provider2, Provider<SharedPrefsHelper> provider3, Provider<ViewModelProvider.Factory> provider4) {
        return new BDTAuctionMainListActivity_MembersInjector(provider, provider2, provider3, provider4);
    }

    public void injectMembers(BDTAuctionMainListActivity bDTAuctionMainListActivity) {
        BaseActivity_MembersInjector.injectDispatchingAndroidInjector(bDTAuctionMainListActivity, this.dispatchingAndroidInjectorProvider.get());
        MVVMNavDrawerActivity_MembersInjector.injectSessionManager(bDTAuctionMainListActivity, this.sessionManagerProvider.get());
        MVVMNavDrawerActivity_MembersInjector.injectSharedPrefsHelper(bDTAuctionMainListActivity, this.sharedPrefsHelperProvider.get());
        injectViewModelFactory(bDTAuctionMainListActivity, this.viewModelFactoryProvider.get());
    }

    public static void injectViewModelFactory(BDTAuctionMainListActivity bDTAuctionMainListActivity, ViewModelProvider.Factory factory) {
        bDTAuctionMainListActivity.viewModelFactory = factory;
    }
}
