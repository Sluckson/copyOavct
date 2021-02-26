package com.iaai.android.bdt.feature.landing;

import dagger.internal.Factory;
import javax.inject.Provider;

public final class LandingPageViewModel_Factory implements Factory<LandingPageViewModel> {
    private final Provider<LandingPageRepository> landingPageRepositoryProvider;

    public LandingPageViewModel_Factory(Provider<LandingPageRepository> provider) {
        this.landingPageRepositoryProvider = provider;
    }

    public LandingPageViewModel get() {
        return provideInstance(this.landingPageRepositoryProvider);
    }

    public static LandingPageViewModel provideInstance(Provider<LandingPageRepository> provider) {
        return new LandingPageViewModel(provider.get());
    }

    public static LandingPageViewModel_Factory create(Provider<LandingPageRepository> provider) {
        return new LandingPageViewModel_Factory(provider);
    }

    public static LandingPageViewModel newLandingPageViewModel(LandingPageRepository landingPageRepository) {
        return new LandingPageViewModel(landingPageRepository);
    }
}
