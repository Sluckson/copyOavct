package com.iaai.android.bdt.feature.login.emailValidation;

import com.iaai.android.bdt.feature.login.LoginRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class ValidateOTPViewModel_Factory implements Factory<ValidateOTPViewModel> {
    private final Provider<LoginRepository> loginRepositoryProvider;

    public ValidateOTPViewModel_Factory(Provider<LoginRepository> provider) {
        this.loginRepositoryProvider = provider;
    }

    public ValidateOTPViewModel get() {
        return provideInstance(this.loginRepositoryProvider);
    }

    public static ValidateOTPViewModel provideInstance(Provider<LoginRepository> provider) {
        return new ValidateOTPViewModel(provider.get());
    }

    public static ValidateOTPViewModel_Factory create(Provider<LoginRepository> provider) {
        return new ValidateOTPViewModel_Factory(provider);
    }

    public static ValidateOTPViewModel newValidateOTPViewModel(LoginRepository loginRepository) {
        return new ValidateOTPViewModel(loginRepository);
    }
}
