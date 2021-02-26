package com.iaai.android.bdt.injection.module;

import com.iaai.android.bdt.network.Service;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import retrofit2.Retrofit;

public final class NetworkModule_ProvideServiceFactory implements Factory<Service> {
    private final NetworkModule module;
    private final Provider<Retrofit> retrofitProvider;

    public NetworkModule_ProvideServiceFactory(NetworkModule networkModule, Provider<Retrofit> provider) {
        this.module = networkModule;
        this.retrofitProvider = provider;
    }

    public Service get() {
        return provideInstance(this.module, this.retrofitProvider);
    }

    public static Service provideInstance(NetworkModule networkModule, Provider<Retrofit> provider) {
        return proxyProvideService(networkModule, provider.get());
    }

    public static NetworkModule_ProvideServiceFactory create(NetworkModule networkModule, Provider<Retrofit> provider) {
        return new NetworkModule_ProvideServiceFactory(networkModule, provider);
    }

    public static Service proxyProvideService(NetworkModule networkModule, Retrofit retrofit) {
        return (Service) Preconditions.checkNotNull(networkModule.provideService(retrofit), "Cannot return null from a non-@Nullable @Provides method");
    }
}
