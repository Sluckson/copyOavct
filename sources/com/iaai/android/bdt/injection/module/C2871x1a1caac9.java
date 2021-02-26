package com.iaai.android.bdt.injection.module;

import android.content.SharedPreferences;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* renamed from: com.iaai.android.bdt.injection.module.ApplicationModule_ProvideSharedPreferences$app_productionReleaseFactory */
public final class C2871x1a1caac9 implements Factory<SharedPreferences> {
    private final ApplicationModule module;

    public C2871x1a1caac9(ApplicationModule applicationModule) {
        this.module = applicationModule;
    }

    public SharedPreferences get() {
        return provideInstance(this.module);
    }

    public static SharedPreferences provideInstance(ApplicationModule applicationModule) {
        return proxyProvideSharedPreferences$app_productionRelease(applicationModule);
    }

    public static C2871x1a1caac9 create(ApplicationModule applicationModule) {
        return new C2871x1a1caac9(applicationModule);
    }

    public static SharedPreferences proxyProvideSharedPreferences$app_productionRelease(ApplicationModule applicationModule) {
        return (SharedPreferences) Preconditions.checkNotNull(applicationModule.provideSharedPreferences$app_productionRelease(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
