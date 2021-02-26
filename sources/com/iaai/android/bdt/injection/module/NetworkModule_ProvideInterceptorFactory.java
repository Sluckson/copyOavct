package com.iaai.android.bdt.injection.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class NetworkModule_ProvideInterceptorFactory implements Factory<CustomInterceptor> {
    private final NetworkModule module;

    public NetworkModule_ProvideInterceptorFactory(NetworkModule networkModule) {
        this.module = networkModule;
    }

    public CustomInterceptor get() {
        return provideInstance(this.module);
    }

    public static CustomInterceptor provideInstance(NetworkModule networkModule) {
        return proxyProvideInterceptor(networkModule);
    }

    public static NetworkModule_ProvideInterceptorFactory create(NetworkModule networkModule) {
        return new NetworkModule_ProvideInterceptorFactory(networkModule);
    }

    public static CustomInterceptor proxyProvideInterceptor(NetworkModule networkModule) {
        return (CustomInterceptor) Preconditions.checkNotNull(networkModule.provideInterceptor(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
