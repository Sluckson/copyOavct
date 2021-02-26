package com.iaai.android.bdt.feature.productDetail.costCalculator;

import dagger.internal.Factory;
import javax.inject.Provider;

public final class CostCalculatorViewModel_Factory implements Factory<CostCalculatorViewModel> {
    private final Provider<CostCalculatorRepository> repositoryProvider;

    public CostCalculatorViewModel_Factory(Provider<CostCalculatorRepository> provider) {
        this.repositoryProvider = provider;
    }

    public CostCalculatorViewModel get() {
        return provideInstance(this.repositoryProvider);
    }

    public static CostCalculatorViewModel provideInstance(Provider<CostCalculatorRepository> provider) {
        return new CostCalculatorViewModel(provider.get());
    }

    public static CostCalculatorViewModel_Factory create(Provider<CostCalculatorRepository> provider) {
        return new CostCalculatorViewModel_Factory(provider);
    }

    public static CostCalculatorViewModel newCostCalculatorViewModel(CostCalculatorRepository costCalculatorRepository) {
        return new CostCalculatorViewModel(costCalculatorRepository);
    }
}
