package com.iaai.android.bdt.injection.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public final class NetworkModule_ProvideRetrofitFactory implements Factory<Retrofit> {
    private final NetworkModule module;
    private final Provider<OkHttpClient> okHttpClientProvider;

    public NetworkModule_ProvideRetrofitFactory(NetworkModule networkModule, Provider<OkHttpClient> provider) {
        this.module = networkModule;
        this.okHttpClientProvider = provider;
    }

    public Retrofit get() {
        return provideInstance(this.module, this.okHttpClientProvider);
    }

    public static Retrofit provideInstance(NetworkModule networkModule, Provider<OkHttpClient> provider) {
        return proxyProvideRetrofit(networkModule, provider.get());
    }

    public static NetworkModule_ProvideRetrofitFactory create(NetworkModule networkModule, Provider<OkHttpClient> provider) {
        return new NetworkModule_ProvideRetrofitFactory(networkModule, provider);
    }

    public static Retrofit proxyProvideRetrofit(NetworkModule networkModule, OkHttpClient okHttpClient) {
        return (Retrofit) Preconditions.checkNotNull(networkModule.provideRetrofit(okHttpClient), "Cannot return null from a non-@Nullable @Provides method");
    }
}
