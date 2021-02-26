package com.iaai.android.bdt.feature.account.tobepickedup;

import dagger.internal.Factory;
import javax.inject.Provider;

public final class ToBePickedUpViewModel_Factory implements Factory<ToBePickedUpViewModel> {
    private final Provider<ToBePickedUpRepository> repositoryProvider;

    public ToBePickedUpViewModel_Factory(Provider<ToBePickedUpRepository> provider) {
        this.repositoryProvider = provider;
    }

    public ToBePickedUpViewModel get() {
        return provideInstance(this.repositoryProvider);
    }

    public static ToBePickedUpViewModel provideInstance(Provider<ToBePickedUpRepository> provider) {
        return new ToBePickedUpViewModel(provider.get());
    }

    public static ToBePickedUpViewModel_Factory create(Provider<ToBePickedUpRepository> provider) {
        return new ToBePickedUpViewModel_Factory(provider);
    }

    public static ToBePickedUpViewModel newToBePickedUpViewModel(ToBePickedUpRepository toBePickedUpRepository) {
        return new ToBePickedUpViewModel(toBePickedUpRepository);
    }
}
