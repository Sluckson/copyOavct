package com.iaai.android.bdt.injection.module;

import androidx.fragment.app.Fragment;
import com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.FastSearchFilterFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {FastSearchFilterFragmentSubcomponent.class})
/* renamed from: com.iaai.android.bdt.injection.module.FragmentModule_ContributeFastSearchFilterFragment$app_productionRelease */
public abstract class C2875x7d0d59c8 {

    @Subcomponent
    /* renamed from: com.iaai.android.bdt.injection.module.FragmentModule_ContributeFastSearchFilterFragment$app_productionRelease$FastSearchFilterFragmentSubcomponent */
    /* compiled from: FragmentModule_ContributeFastSearchFilterFragment$app_productionRelease */
    public interface FastSearchFilterFragmentSubcomponent extends AndroidInjector<FastSearchFilterFragment> {

        @Subcomponent.Builder
        /* renamed from: com.iaai.android.bdt.injection.module.FragmentModule_ContributeFastSearchFilterFragment$app_productionRelease$FastSearchFilterFragmentSubcomponent$Builder */
        /* compiled from: FragmentModule_ContributeFastSearchFilterFragment$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<FastSearchFilterFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @FragmentKey(FastSearchFilterFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<? extends Fragment> bindAndroidInjectorFactory(FastSearchFilterFragmentSubcomponent.Builder builder);

    private C2875x7d0d59c8() {
    }
}
