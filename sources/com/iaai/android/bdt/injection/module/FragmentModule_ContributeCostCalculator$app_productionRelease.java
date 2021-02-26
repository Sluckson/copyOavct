package com.iaai.android.bdt.injection.module;

import androidx.fragment.app.Fragment;
import com.iaai.android.bdt.feature.productDetail.costCalculator.CostCalculatorFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {CostCalculatorFragmentSubcomponent.class})
public abstract class FragmentModule_ContributeCostCalculator$app_productionRelease {

    @Subcomponent
    /* compiled from: FragmentModule_ContributeCostCalculator$app_productionRelease */
    public interface CostCalculatorFragmentSubcomponent extends AndroidInjector<CostCalculatorFragment> {

        @Subcomponent.Builder
        /* compiled from: FragmentModule_ContributeCostCalculator$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<CostCalculatorFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @FragmentKey(CostCalculatorFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<? extends Fragment> bindAndroidInjectorFactory(CostCalculatorFragmentSubcomponent.Builder builder);

    private FragmentModule_ContributeCostCalculator$app_productionRelease() {
    }
}
