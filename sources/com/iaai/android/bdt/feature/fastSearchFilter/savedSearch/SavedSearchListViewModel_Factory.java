package com.iaai.android.bdt.feature.fastSearchFilter.savedSearch;

import dagger.internal.Factory;
import javax.inject.Provider;

public final class SavedSearchListViewModel_Factory implements Factory<SavedSearchListViewModel> {
    private final Provider<SavedSearchListRepository> repositoryProvider;

    public SavedSearchListViewModel_Factory(Provider<SavedSearchListRepository> provider) {
        this.repositoryProvider = provider;
    }

    public SavedSearchListViewModel get() {
        return provideInstance(this.repositoryProvider);
    }

    public static SavedSearchListViewModel provideInstance(Provider<SavedSearchListRepository> provider) {
        return new SavedSearchListViewModel(provider.get());
    }

    public static SavedSearchListViewModel_Factory create(Provider<SavedSearchListRepository> provider) {
        return new SavedSearchListViewModel_Factory(provider);
    }

    public static SavedSearchListViewModel newSavedSearchListViewModel(SavedSearchListRepository savedSearchListRepository) {
        return new SavedSearchListViewModel(savedSearchListRepository);
    }
}
