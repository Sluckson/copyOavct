package com.iaai.android.bdt.feature.applaunch;

import com.iaai.android.bdt.network.Service;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class MakeModelMasterRepository_Factory implements Factory<MakeModelMasterRepository> {
    private final Provider<Service> serviceProvider;

    public MakeModelMasterRepository_Factory(Provider<Service> provider) {
        this.serviceProvider = provider;
    }

    public MakeModelMasterRepository get() {
        return provideInstance(this.serviceProvider);
    }

    public static MakeModelMasterRepository provideInstance(Provider<Service> provider) {
        return new MakeModelMasterRepository(provider.get());
    }

    public static MakeModelMasterRepository_Factory create(Provider<Service> provider) {
        return new MakeModelMasterRepository_Factory(provider);
    }

    public static MakeModelMasterRepository newMakeModelMasterRepository(Service service) {
        return new MakeModelMasterRepository(service);
    }
}
