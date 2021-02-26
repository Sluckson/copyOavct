package com.iaai.android.bdt.feature.login.emailValidation;

import com.iaai.android.bdt.feature.login.LoginRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class EmailConfirmationViewModel_Factory implements Factory<EmailConfirmationViewModel> {
    private final Provider<LoginRepository> loginRepositoryProvider;

    public EmailConfirmationViewModel_Factory(Provider<LoginRepository> provider) {
        this.loginRepositoryProvider = provider;
    }

    public EmailConfirmationViewModel get() {
        return provideInstance(this.loginRepositoryProvider);
    }

    public static EmailConfirmationViewModel provideInstance(Provider<LoginRepository> provider) {
        return new EmailConfirmationViewModel(provider.get());
    }

    public static EmailConfirmationViewModel_Factory create(Provider<LoginRepository> provider) {
        return new EmailConfirmationViewModel_Factory(provider);
    }

    public static EmailConfirmationViewModel newEmailConfirmationViewModel(LoginRepository loginRepository) {
        return new EmailConfirmationViewModel(loginRepository);
    }
}
