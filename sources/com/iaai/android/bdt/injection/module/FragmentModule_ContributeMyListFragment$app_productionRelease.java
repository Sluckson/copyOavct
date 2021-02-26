package com.iaai.android.bdt.injection.module;

import androidx.fragment.app.Fragment;
import com.iaai.android.bdt.feature.account.MyListFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {MyListFragmentSubcomponent.class})
public abstract class FragmentModule_ContributeMyListFragment$app_productionRelease {

    @Subcomponent
    /* compiled from: FragmentModule_ContributeMyListFragment$app_productionRelease */
    public interface MyListFragmentSubcomponent extends AndroidInjector<MyListFragment> {

        @Subcomponent.Builder
        /* compiled from: FragmentModule_ContributeMyListFragment$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<MyListFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @FragmentKey(MyListFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<? extends Fragment> bindAndroidInjectorFactory(MyListFragmentSubcomponent.Builder builder);

    private FragmentModule_ContributeMyListFragment$app_productionRelease() {
    }
}
