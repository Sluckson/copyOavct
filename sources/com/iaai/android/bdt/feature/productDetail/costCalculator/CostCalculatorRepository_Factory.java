package com.iaai.android.bdt.feature.productDetail.costCalculator;

import com.iaai.android.bdt.network.Service;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class CostCalculatorRepository_Factory implements Factory<CostCalculatorRepository> {
    private final Provider<Service> serviceProvider;

    public CostCalculatorRepository_Factory(Provider<Service> provider) {
        this.serviceProvider = provider;
    }

    public CostCalculatorRepository get() {
        return provideInstance(this.serviceProvider);
    }

    public static CostCalculatorRepository provideInstance(Provider<Service> provider) {
        return new CostCalculatorRepository(provider.get());
    }

    public static CostCalculatorRepository_Factory create(Provider<Service> provider) {
        return new CostCalculatorRepository_Factory(provider);
    }

    public static CostCalculatorRepository newCostCalculatorRepository(Service service) {
        return new CostCalculatorRepository(service);
    }
}
