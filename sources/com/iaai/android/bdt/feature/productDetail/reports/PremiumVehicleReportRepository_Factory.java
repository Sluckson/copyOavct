package com.iaai.android.bdt.feature.productDetail.reports;

import com.iaai.android.bdt.network.Service;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class PremiumVehicleReportRepository_Factory implements Factory<PremiumVehicleReportRepository> {
    private final Provider<Service> serviceProvider;

    public PremiumVehicleReportRepository_Factory(Provider<Service> provider) {
        this.serviceProvider = provider;
    }

    public PremiumVehicleReportRepository get() {
        return provideInstance(this.serviceProvider);
    }

    public static PremiumVehicleReportRepository provideInstance(Provider<Service> provider) {
        return new PremiumVehicleReportRepository(provider.get());
    }

    public static PremiumVehicleReportRepository_Factory create(Provider<Service> provider) {
        return new PremiumVehicleReportRepository_Factory(provider);
    }

    public static PremiumVehicleReportRepository newPremiumVehicleReportRepository(Service service) {
        return new PremiumVehicleReportRepository(service);
    }
}
