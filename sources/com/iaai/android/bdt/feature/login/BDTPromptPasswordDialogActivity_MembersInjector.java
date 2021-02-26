package com.iaai.android.bdt.feature.login;

import androidx.lifecycle.ViewModelProvider;
import com.iaai.android.bdt.utils.SharedPrefsHelper;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class BDTPromptPasswordDialogActivity_MembersInjector implements MembersInjector<BDTPromptPasswordDialogActivity> {
    private final Provider<SessionManager> sessionManagerProvider;
    private final Provider<SharedPrefsHelper> sharedPrefsHelperProvider;
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public BDTPromptPasswordDialogActivity_MembersInjector(Provider<ViewModelProvider.Factory> provider, Provider<SessionManager> provider2, Provider<SharedPrefsHelper> provider3) {
        this.viewModelFactoryProvider = provider;
        this.sessionManagerProvider = provider2;
        this.sharedPrefsHelperProvider = provider3;
    }

    public static MembersInjector<BDTPromptPasswordDialogActivity> create(Provider<ViewModelProvider.Factory> provider, Provider<SessionManager> provider2, Provider<SharedPrefsHelper> provider3) {
        return new BDTPromptPasswordDialogActivity_MembersInjector(provider, provider2, provider3);
    }

    public void injectMembers(BDTPromptPasswordDialogActivity bDTPromptPasswordDialogActivity) {
        injectViewModelFactory(bDTPromptPasswordDialogActivity, this.viewModelFactoryProvider.get());
        injectSessionManager(bDTPromptPasswordDialogActivity, this.sessionManagerProvider.get());
        injectSharedPrefsHelper(bDTPromptPasswordDialogActivity, this.sharedPrefsHelperProvider.get());
    }

    public static void injectViewModelFactory(BDTPromptPasswordDialogActivity bDTPromptPasswordDialogActivity, ViewModelProvider.Factory factory) {
        bDTPromptPasswordDialogActivity.viewModelFactory = factory;
    }

    public static void injectSessionManager(BDTPromptPasswordDialogActivity bDTPromptPasswordDialogActivity, SessionManager sessionManager) {
        bDTPromptPasswordDialogActivity.sessionManager = sessionManager;
    }

    public static void injectSharedPrefsHelper(BDTPromptPasswordDialogActivity bDTPromptPasswordDialogActivity, SharedPrefsHelper sharedPrefsHelper) {
        bDTPromptPasswordDialogActivity.sharedPrefsHelper = sharedPrefsHelper;
    }
}
