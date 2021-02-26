package com.iaai.android.bdt.feature.login;

import dagger.internal.Factory;
import javax.inject.Provider;

public final class TermsOfUseViewModel_Factory implements Factory<TermsOfUseViewModel> {
    private final Provider<LoginRepository> loginRepositoryProvider;

    public TermsOfUseViewModel_Factory(Provider<LoginRepository> provider) {
        this.loginRepositoryProvider = provider;
    }

    public TermsOfUseViewModel get() {
        return provideInstance(this.loginRepositoryProvider);
    }

    public static TermsOfUseViewModel provideInstance(Provider<LoginRepository> provider) {
        return new TermsOfUseViewModel(provider.get());
    }

    public static TermsOfUseViewModel_Factory create(Provider<LoginRepository> provider) {
        return new TermsOfUseViewModel_Factory(provider);
    }

    public static TermsOfUseViewModel newTermsOfUseViewModel(LoginRepository loginRepository) {
        return new TermsOfUseViewModel(loginRepository);
    }
}
