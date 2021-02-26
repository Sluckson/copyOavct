package com.iaai.android.bdt.feature.fastSearchFilter.savedSearch;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.iaai.android.bdt.base.BaseActivity_MembersInjector;
import com.iaai.android.bdt.feature.login.SessionManager;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

public final class SavedSearchActivity_MembersInjector implements MembersInjector<SavedSearchActivity> {
    private final Provider<DispatchingAndroidInjector<Fragment>> dispatchingAndroidInjectorProvider;
    private final Provider<SessionManager> sessionManagerProvider;
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public SavedSearchActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<ViewModelProvider.Factory> provider2, Provider<SessionManager> provider3) {
        this.dispatchingAndroidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
        this.sessionManagerProvider = provider3;
    }

    public static MembersInjector<SavedSearchActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<ViewModelProvider.Factory> provider2, Provider<SessionManager> provider3) {
        return new SavedSearchActivity_MembersInjector(provider, provider2, provider3);
    }

    public void injectMembers(SavedSearchActivity savedSearchActivity) {
        BaseActivity_MembersInjector.injectDispatchingAndroidInjector(savedSearchActivity, this.dispatchingAndroidInjectorProvider.get());
        injectViewModelFactory(savedSearchActivity, this.viewModelFactoryProvider.get());
        injectSessionManager(savedSearchActivity, this.sessionManagerProvider.get());
    }

    public static void injectViewModelFactory(SavedSearchActivity savedSearchActivity, ViewModelProvider.Factory factory) {
        savedSearchActivity.viewModelFactory = factory;
    }

    public static void injectSessionManager(SavedSearchActivity savedSearchActivity, SessionManager sessionManager) {
        savedSearchActivity.sessionManager = sessionManager;
    }
}
