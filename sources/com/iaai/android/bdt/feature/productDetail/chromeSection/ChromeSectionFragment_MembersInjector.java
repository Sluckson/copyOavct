package com.iaai.android.bdt.feature.productDetail.chromeSection;

import androidx.lifecycle.ViewModelProvider;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class ChromeSectionFragment_MembersInjector implements MembersInjector<ChromeSectionFragment> {
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public ChromeSectionFragment_MembersInjector(Provider<ViewModelProvider.Factory> provider) {
        this.viewModelFactoryProvider = provider;
    }

    public static MembersInjector<ChromeSectionFragment> create(Provider<ViewModelProvider.Factory> provider) {
        return new ChromeSectionFragment_MembersInjector(provider);
    }

    public void injectMembers(ChromeSectionFragment chromeSectionFragment) {
        injectViewModelFactory(chromeSectionFragment, this.viewModelFactoryProvider.get());
    }

    public static void injectViewModelFactory(ChromeSectionFragment chromeSectionFragment, ViewModelProvider.Factory factory) {
        chromeSectionFragment.viewModelFactory = factory;
    }
}
