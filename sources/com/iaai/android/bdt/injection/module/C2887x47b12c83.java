package com.iaai.android.bdt.injection.module;

import androidx.fragment.app.Fragment;
import com.iaai.android.bdt.feature.account.tobepickedup.ToBePickedUpListFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {ToBePickedUpListFragmentSubcomponent.class})
/* renamed from: com.iaai.android.bdt.injection.module.FragmentModule_ContributeToBePickedUpListFragment$app_productionRelease */
public abstract class C2887x47b12c83 {

    @Subcomponent
    /* renamed from: com.iaai.android.bdt.injection.module.FragmentModule_ContributeToBePickedUpListFragment$app_productionRelease$ToBePickedUpListFragmentSubcomponent */
    /* compiled from: FragmentModule_ContributeToBePickedUpListFragment$app_productionRelease */
    public interface ToBePickedUpListFragmentSubcomponent extends AndroidInjector<ToBePickedUpListFragment> {

        @Subcomponent.Builder
        /* renamed from: com.iaai.android.bdt.injection.module.FragmentModule_ContributeToBePickedUpListFragment$app_productionRelease$ToBePickedUpListFragmentSubcomponent$Builder */
        /* compiled from: FragmentModule_ContributeToBePickedUpListFragment$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<ToBePickedUpListFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @FragmentKey(ToBePickedUpListFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<? extends Fragment> bindAndroidInjectorFactory(ToBePickedUpListFragmentSubcomponent.Builder builder);

    private C2887x47b12c83() {
    }
}
