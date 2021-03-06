package com.google.firebase.inappmessaging.display.internal.injection.modules;

import android.app.Application;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class ApplicationModule_ProvidesApplicationFactory implements Factory<Application> {
    private final ApplicationModule module;

    public ApplicationModule_ProvidesApplicationFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public Application get() {
        return providesApplication(this.module);
    }

    public static ApplicationModule_ProvidesApplicationFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvidesApplicationFactory(applicationModule);
    }

    public static Application providesApplication(ApplicationModule applicationModule) {
        return (Application) Preconditions.checkNotNull(applicationModule.providesApplication(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
