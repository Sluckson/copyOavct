package com.iaai.android.bdt.feature.landing.quickFilter;

import androidx.lifecycle.ViewModelProvider;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class QuickLinksFragment_MembersInjector implements MembersInjector<QuickLinksFragment> {
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public QuickLinksFragment_MembersInjector(Provider<ViewModelProvider.Factory> provider) {
        this.viewModelFactoryProvider = provider;
    }

    public static MembersInjector<QuickLinksFragment> create(Provider<ViewModelProvider.Factory> provider) {
        return new QuickLinksFragment_MembersInjector(provider);
    }

    public void injectMembers(QuickLinksFragment quickLinksFragment) {
        injectViewModelFactory(quickLinksFragment, this.viewModelFactoryProvider.get());
    }

    public static void injectViewModelFactory(QuickLinksFragment quickLinksFragment, ViewModelProvider.Factory factory) {
        quickLinksFragment.viewModelFactory = factory;
    }
}
