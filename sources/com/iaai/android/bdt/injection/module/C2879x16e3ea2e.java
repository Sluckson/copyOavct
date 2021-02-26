package com.iaai.android.bdt.injection.module;

import androidx.fragment.app.Fragment;
import com.iaai.android.bdt.feature.landing.recommendedVehicles.RecommendedVehiclesFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {RecommendedVehiclesFragmentSubcomponent.class})
/* renamed from: com.iaai.android.bdt.injection.module.FragmentModule_ContributeRecommendedVehiclesFragment$app_productionRelease */
public abstract class C2879x16e3ea2e {

    @Subcomponent
    /* renamed from: com.iaai.android.bdt.injection.module.FragmentModule_ContributeRecommendedVehiclesFragment$app_productionRelease$RecommendedVehiclesFragmentSubcomponent */
    /* compiled from: FragmentModule_ContributeRecommendedVehiclesFragment$app_productionRelease */
    public interface RecommendedVehiclesFragmentSubcomponent extends AndroidInjector<RecommendedVehiclesFragment> {

        @Subcomponent.Builder
        /* renamed from: com.iaai.android.bdt.injection.module.FragmentModule_ContributeRecommendedVehiclesFragment$app_productionRelease$RecommendedVehiclesFragmentSubcomponent$Builder */
        /* compiled from: FragmentModule_ContributeRecommendedVehiclesFragment$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<RecommendedVehiclesFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @FragmentKey(RecommendedVehiclesFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<? extends Fragment> bindAndroidInjectorFactory(RecommendedVehiclesFragmentSubcomponent.Builder builder);

    private C2879x16e3ea2e() {
    }
}
