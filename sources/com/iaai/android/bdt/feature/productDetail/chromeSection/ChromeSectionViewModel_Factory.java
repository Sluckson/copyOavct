package com.iaai.android.bdt.feature.productDetail.chromeSection;

import dagger.internal.Factory;
import javax.inject.Provider;

public final class ChromeSectionViewModel_Factory implements Factory<ChromeSectionViewModel> {
    private final Provider<ChromeSectionRepository> repositoryProvider;

    public ChromeSectionViewModel_Factory(Provider<ChromeSectionRepository> provider) {
        this.repositoryProvider = provider;
    }

    public ChromeSectionViewModel get() {
        return provideInstance(this.repositoryProvider);
    }

    public static ChromeSectionViewModel provideInstance(Provider<ChromeSectionRepository> provider) {
        return new ChromeSectionViewModel(provider.get());
    }

    public static ChromeSectionViewModel_Factory create(Provider<ChromeSectionRepository> provider) {
        return new ChromeSectionViewModel_Factory(provider);
    }

    public static ChromeSectionViewModel newChromeSectionViewModel(ChromeSectionRepository chromeSectionRepository) {
        return new ChromeSectionViewModel(chromeSectionRepository);
    }
}
