package com.iaai.android.bdt.feature.logIAAError;

import com.iaai.android.bdt.network.Service;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class LogIAAErrorRepository_Factory implements Factory<LogIAAErrorRepository> {
    private final Provider<Service> serviceProvider;

    public LogIAAErrorRepository_Factory(Provider<Service> provider) {
        this.serviceProvider = provider;
    }

    public LogIAAErrorRepository get() {
        return provideInstance(this.serviceProvider);
    }

    public static LogIAAErrorRepository provideInstance(Provider<Service> provider) {
        return new LogIAAErrorRepository(provider.get());
    }

    public static LogIAAErrorRepository_Factory create(Provider<Service> provider) {
        return new LogIAAErrorRepository_Factory(provider);
    }

    public static LogIAAErrorRepository newLogIAAErrorRepository(Service service) {
        return new LogIAAErrorRepository(service);
    }
}
