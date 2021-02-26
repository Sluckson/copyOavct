package com.iaai.android.bdt.feature.login;

import androidx.lifecycle.ViewModelProvider;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class BDTForgotPasswordActivity_MembersInjector implements MembersInjector<BDTForgotPasswordActivity> {
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public BDTForgotPasswordActivity_MembersInjector(Provider<ViewModelProvider.Factory> provider) {
        this.viewModelFactoryProvider = provider;
    }

    public static MembersInjector<BDTForgotPasswordActivity> create(Provider<ViewModelProvider.Factory> provider) {
        return new BDTForgotPasswordActivity_MembersInjector(provider);
    }

    public void injectMembers(BDTForgotPasswordActivity bDTForgotPasswordActivity) {
        injectViewModelFactory(bDTForgotPasswordActivity, this.viewModelFactoryProvider.get());
    }

    public static void injectViewModelFactory(BDTForgotPasswordActivity bDTForgotPasswordActivity, ViewModelProvider.Factory factory) {
        bDTForgotPasswordActivity.viewModelFactory = factory;
    }
}
