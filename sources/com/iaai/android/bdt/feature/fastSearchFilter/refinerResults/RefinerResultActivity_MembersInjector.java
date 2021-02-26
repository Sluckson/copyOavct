package com.iaai.android.bdt.feature.fastSearchFilter.refinerResults;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.iaai.android.bdt.base.BaseActivity_MembersInjector;
import com.iaai.android.bdt.feature.login.SessionManager;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

public final class RefinerResultActivity_MembersInjector implements MembersInjector<RefinerResultActivity> {
    private final Provider<DispatchingAndroidInjector<Fragment>> dispatchingAndroidInjectorProvider;
    private final Provider<SessionManager> sessionManagerProvider;
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public RefinerResultActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<ViewModelProvider.Factory> provider2, Provider<SessionManager> provider3) {
        this.dispatchingAndroidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
        this.sessionManagerProvider = provider3;
    }

    public static MembersInjector<RefinerResultActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<ViewModelProvider.Factory> provider2, Provider<SessionManager> provider3) {
        return new RefinerResultActivity_MembersInjector(provider, provider2, provider3);
    }

    public void injectMembers(RefinerResultActivity refinerResultActivity) {
        BaseActivity_MembersInjector.injectDispatchingAndroidInjector(refinerResultActivity, this.dispatchingAndroidInjectorProvider.get());
        injectViewModelFactory(refinerResultActivity, this.viewModelFactoryProvider.get());
        injectSessionManager(refinerResultActivity, this.sessionManagerProvider.get());
    }

    public static void injectViewModelFactory(RefinerResultActivity refinerResultActivity, ViewModelProvider.Factory factory) {
        refinerResultActivity.viewModelFactory = factory;
    }

    public static void injectSessionManager(RefinerResultActivity refinerResultActivity, SessionManager sessionManager) {
        refinerResultActivity.sessionManager = sessionManager;
    }
}
