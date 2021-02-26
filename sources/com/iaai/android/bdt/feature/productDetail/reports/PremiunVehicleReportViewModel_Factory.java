package com.iaai.android.bdt.feature.productDetail.reports;

import dagger.internal.Factory;
import javax.inject.Provider;

public final class PremiunVehicleReportViewModel_Factory implements Factory<PremiunVehicleReportViewModel> {
    private final Provider<PremiumVehicleReportRepository> repositoryProvider;

    public PremiunVehicleReportViewModel_Factory(Provider<PremiumVehicleReportRepository> provider) {
        this.repositoryProvider = provider;
    }

    public PremiunVehicleReportViewModel get() {
        return provideInstance(this.repositoryProvider);
    }

    public static PremiunVehicleReportViewModel provideInstance(Provider<PremiumVehicleReportRepository> provider) {
        return new PremiunVehicleReportViewModel(provider.get());
    }

    public static PremiunVehicleReportViewModel_Factory create(Provider<PremiumVehicleReportRepository> provider) {
        return new PremiunVehicleReportViewModel_Factory(provider);
    }

    public static PremiunVehicleReportViewModel newPremiunVehicleReportViewModel(PremiumVehicleReportRepository premiumVehicleReportRepository) {
        return new PremiunVehicleReportViewModel(premiumVehicleReportRepository);
    }
}
