package com.iaai.android.bdt.injection.module;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class ApplicationModule_ProvideContext$app_productionReleaseFactory implements Factory<Context> {
    private final ApplicationModule module;

    public ApplicationModule_ProvideContext$app_productionReleaseFactory(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public Context get() {
        return provideInstance(this.module);
    }

    public static Context provideInstance(ApplicationModule applicationModule) {
        return proxyProvideContext$app_productionRelease(applicationModule);
    }

    public static ApplicationModule_ProvideContext$app_productionReleaseFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvideContext$app_productionReleaseFactory(applicationModule);
    }

    public static Context proxyProvideContext$app_productionRelease(ApplicationModule applicationModule) {
        return (Context) Preconditions.checkNotNull(applicationModule.provideContext$app_productionRelease(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
