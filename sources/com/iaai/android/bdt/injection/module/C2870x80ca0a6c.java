package com.iaai.android.bdt.injection.module;

import android.app.Application;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* renamed from: com.iaai.android.bdt.injection.module.ApplicationModule_ProvideApplication$app_productionReleaseFactory */
public final class C2870x80ca0a6c implements Factory<Application> {
    private final ApplicationModule module;

    public C2870x80ca0a6c(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public Application get() {
        return provideInstance(this.module);
    }

    public static Application provideInstance(ApplicationModule applicationModule) {
        return proxyProvideApplication$app_productionRelease(applicationModule);
    }

    public static C2870x80ca0a6c create(ApplicationModule applicationModule) {
        return new C2870x80ca0a6c(applicationModule);
    }

    public static Application proxyProvideApplication$app_productionRelease(ApplicationModule applicationModule) {
        return (Application) Preconditions.checkNotNull(applicationModule.provideApplication$app_productionRelease(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
