package com.iaai.android.bdt.feature.login;

import dagger.internal.Factory;
import javax.inject.Provider;

public final class LoginViewModel_Factory implements Factory<LoginViewModel> {
    private final Provider<LoginRepository> loginRepositoryProvider;

    public LoginViewModel_Factory(Provider<LoginRepository> provider) {
        this.loginRepositoryProvider = provider;
    }

    public LoginViewModel get() {
        return provideInstance(this.loginRepositoryProvider);
    }

    public static LoginViewModel provideInstance(Provider<LoginRepository> provider) {
        return new LoginViewModel(provider.get());
    }

    public static LoginViewModel_Factory create(Provider<LoginRepository> provider) {
        return new LoginViewModel_Factory(provider);
    }

    public static LoginViewModel newLoginViewModel(LoginRepository loginRepository) {
        return new LoginViewModel(loginRepository);
    }
}
