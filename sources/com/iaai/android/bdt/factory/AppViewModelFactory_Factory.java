package com.iaai.android.bdt.factory;

import androidx.lifecycle.ViewModel;
import dagger.internal.Factory;
import java.util.Map;
import javax.inject.Provider;

public final class AppViewModelFactory_Factory implements Factory<AppViewModelFactory> {
    private final Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> viewModelsProvider;

    public AppViewModelFactory_Factory(Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> provider) {
        this.viewModelsProvider = provider;
    }

    public AppViewModelFactory get() {
        return provideInstance(this.viewModelsProvider);
    }

    public static AppViewModelFactory provideInstance(Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> provider) {
        return new AppViewModelFactory(provider.get());
    }

    public static AppViewModelFactory_Factory create(Provider<Map<Class<? extends ViewModel>, Provider<ViewModel>>> provider) {
        return new AppViewModelFactory_Factory(provider);
    }

    public static AppViewModelFactory newAppViewModelFactory(Map<Class<? extends ViewModel>, Provider<ViewModel>> map) {
        return new AppViewModelFactory(map);
    }
}
