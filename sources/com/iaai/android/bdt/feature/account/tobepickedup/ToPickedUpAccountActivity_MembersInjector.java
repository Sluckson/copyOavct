package com.iaai.android.bdt.feature.account.tobepickedup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.iaai.android.bdt.base.BaseActivity_MembersInjector;
import com.iaai.android.bdt.feature.login.SessionManager;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

public final class ToPickedUpAccountActivity_MembersInjector implements MembersInjector<ToPickedUpAccountActivity> {
    private final Provider<DispatchingAndroidInjector<Fragment>> dispatchingAndroidInjectorProvider;
    private final Provider<SessionManager> sessionManagerProvider;
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public ToPickedUpAccountActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<ViewModelProvider.Factory> provider2, Provider<SessionManager> provider3) {
        this.dispatchingAndroidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
        this.sessionManagerProvider = provider3;
    }

    public static MembersInjector<ToPickedUpAccountActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<ViewModelProvider.Factory> provider2, Provider<SessionManager> provider3) {
        return new ToPickedUpAccountActivity_MembersInjector(provider, provider2, provider3);
    }

    public void injectMembers(ToPickedUpAccountActivity toPickedUpAccountActivity) {
        BaseActivity_MembersInjector.injectDispatchingAndroidInjector(toPickedUpAccountActivity, this.dispatchingAndroidInjectorProvider.get());
        injectViewModelFactory(toPickedUpAccountActivity, this.viewModelFactoryProvider.get());
        injectSessionManager(toPickedUpAccountActivity, this.sessionManagerProvider.get());
    }

    public static void injectViewModelFactory(ToPickedUpAccountActivity toPickedUpAccountActivity, ViewModelProvider.Factory factory) {
        toPickedUpAccountActivity.viewModelFactory = factory;
    }

    public static void injectSessionManager(ToPickedUpAccountActivity toPickedUpAccountActivity, SessionManager sessionManager) {
        toPickedUpAccountActivity.sessionManager = sessionManager;
    }
}
