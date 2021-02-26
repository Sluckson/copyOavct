package com.iaai.android.bdt.injection.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

public final class NetworkModule_ProvideHttpClientFactory implements Factory<OkHttpClient> {
    private final Provider<CustomInterceptor> customInterceptorProvider;
    private final NetworkModule module;

    public NetworkModule_ProvideHttpClientFactory(NetworkModule networkModule, Provider<CustomInterceptor> provider) {
        this.module = networkModule;
        this.customInterceptorProvider = provider;
    }

    public OkHttpClient get() {
        return provideInstance(this.module, this.customInterceptorProvider);
    }

    public static OkHttpClient provideInstance(NetworkModule networkModule, Provider<CustomInterceptor> provider) {
        return proxyProvideHttpClient(networkModule, provider.get());
    }

    public static NetworkModule_ProvideHttpClientFactory create(NetworkModule networkModule, Provider<CustomInterceptor> provider) {
        return new NetworkModule_ProvideHttpClientFactory(networkModule, provider);
    }

    public static OkHttpClient proxyProvideHttpClient(NetworkModule networkModule, CustomInterceptor customInterceptor) {
        return (OkHttpClient) Preconditions.checkNotNull(networkModule.provideHttpClient(customInterceptor), "Cannot return null from a non-@Nullable @Provides method");
    }
}
