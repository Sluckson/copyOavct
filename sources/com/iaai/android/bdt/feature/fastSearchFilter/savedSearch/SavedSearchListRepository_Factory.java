package com.iaai.android.bdt.feature.fastSearchFilter.savedSearch;

import com.iaai.android.bdt.network.Service;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class SavedSearchListRepository_Factory implements Factory<SavedSearchListRepository> {
    private final Provider<Service> serviceProvider;

    public SavedSearchListRepository_Factory(Provider<Service> provider) {
        this.serviceProvider = provider;
    }

    public SavedSearchListRepository get() {
        return provideInstance(this.serviceProvider);
    }

    public static SavedSearchListRepository provideInstance(Provider<Service> provider) {
        return new SavedSearchListRepository(provider.get());
    }

    public static SavedSearchListRepository_Factory create(Provider<Service> provider) {
        return new SavedSearchListRepository_Factory(provider);
    }

    public static SavedSearchListRepository newSavedSearchListRepository(Service service) {
        return new SavedSearchListRepository(service);
    }
}
