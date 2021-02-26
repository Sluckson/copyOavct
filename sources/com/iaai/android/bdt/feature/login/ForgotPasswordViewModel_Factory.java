package com.iaai.android.bdt.feature.login;

import dagger.internal.Factory;
import javax.inject.Provider;

public final class ForgotPasswordViewModel_Factory implements Factory<ForgotPasswordViewModel> {
    private final Provider<LoginRepository> loginRepositoryProvider;

    public ForgotPasswordViewModel_Factory(Provider<LoginRepository> provider) {
        this.loginRepositoryProvider = provider;
    }

    public ForgotPasswordViewModel get() {
        return provideInstance(this.loginRepositoryProvider);
    }

    public static ForgotPasswordViewModel provideInstance(Provider<LoginRepository> provider) {
        return new ForgotPasswordViewModel(provider.get());
    }

    public static ForgotPasswordViewModel_Factory create(Provider<LoginRepository> provider) {
        return new ForgotPasswordViewModel_Factory(provider);
    }

    public static ForgotPasswordViewModel newForgotPasswordViewModel(LoginRepository loginRepository) {
        return new ForgotPasswordViewModel(loginRepository);
    }
}
