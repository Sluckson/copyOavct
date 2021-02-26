package com.iaai.android.bdt.feature.productDetail.costCalculator;

import androidx.lifecycle.ViewModelProvider;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class CostCalculatorFragment_MembersInjector implements MembersInjector<CostCalculatorFragment> {
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public CostCalculatorFragment_MembersInjector(Provider<ViewModelProvider.Factory> provider) {
        this.viewModelFactoryProvider = provider;
    }

    public static MembersInjector<CostCalculatorFragment> create(Provider<ViewModelProvider.Factory> provider) {
        return new CostCalculatorFragment_MembersInjector(provider);
    }

    public void injectMembers(CostCalculatorFragment costCalculatorFragment) {
        injectViewModelFactory(costCalculatorFragment, this.viewModelFactoryProvider.get());
    }

    public static void injectViewModelFactory(CostCalculatorFragment costCalculatorFragment, ViewModelProvider.Factory factory) {
        costCalculatorFragment.viewModelFactory = factory;
    }
}
