package com.google.firebase.inappmessaging.display.internal;

import android.app.Application;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class BindingWrapperFactory_Factory implements Factory<BindingWrapperFactory> {
    private final Provider<Application> applicationProvider;

    public BindingWrapperFactory_Factory(Provider<Application> provider) {
        this.applicationProvider = provider;
    }

    public BindingWrapperFactory get() {
        return new BindingWrapperFactory(this.applicationProvider.get());
    }

    public static BindingWrapperFactory_Factory create(Provider<Application> provider) {
        return new BindingWrapperFactory_Factory(provider);
    }

    public static BindingWrapperFactory newInstance(Application application) {
        return new BindingWrapperFactory(application);
    }
}
