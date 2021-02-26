package com.iaai.android.bdt.feature.applaunch;

import androidx.lifecycle.ViewModelProvider;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class SplashActivity_MembersInjector implements MembersInjector<SplashActivity> {
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public SplashActivity_MembersInjector(Provider<ViewModelProvider.Factory> provider) {
        this.viewModelFactoryProvider = provider;
    }

    public static MembersInjector<SplashActivity> create(Provider<ViewModelProvider.Factory> provider) {
        return new SplashActivity_MembersInjector(provider);
    }

    public void injectMembers(SplashActivity splashActivity) {
        injectViewModelFactory(splashActivity, this.viewModelFactoryProvider.get());
    }

    public static void injectViewModelFactory(SplashActivity splashActivity, ViewModelProvider.Factory factory) {
        splashActivity.viewModelFactory = factory;
    }
}
