package com.iaai.android.bdt.injection.module;

import androidx.fragment.app.Fragment;
import com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {RefinerResultFragmentSubcomponent.class})
/* renamed from: com.iaai.android.bdt.injection.module.FragmentModule_ContributeRefinerResultFragment$app_productionRelease */
public abstract class C2880xc39d780e {

    @Subcomponent
    /* renamed from: com.iaai.android.bdt.injection.module.FragmentModule_ContributeRefinerResultFragment$app_productionRelease$RefinerResultFragmentSubcomponent */
    /* compiled from: FragmentModule_ContributeRefinerResultFragment$app_productionRelease */
    public interface RefinerResultFragmentSubcomponent extends AndroidInjector<RefinerResultFragment> {

        @Subcomponent.Builder
        /* renamed from: com.iaai.android.bdt.injection.module.FragmentModule_ContributeRefinerResultFragment$app_productionRelease$RefinerResultFragmentSubcomponent$Builder */
        /* compiled from: FragmentModule_ContributeRefinerResultFragment$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<RefinerResultFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @FragmentKey(RefinerResultFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<? extends Fragment> bindAndroidInjectorFactory(RefinerResultFragmentSubcomponent.Builder builder);

    private C2880xc39d780e() {
    }
}
