package com.iaai.android.bdt.injection.module;

import androidx.fragment.app.Fragment;
import com.iaai.android.bdt.feature.myAccount.toBePaid.ToBePaidConfirmationFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {ToBePaidConfirmationFragmentSubcomponent.class})
/* renamed from: com.iaai.android.bdt.injection.module.FragmentModule_ContributeToBePaidConfirmationFragment$app_productionRelease */
public abstract class C2885x2d128e2b {

    @Subcomponent
    /* renamed from: com.iaai.android.bdt.injection.module.FragmentModule_ContributeToBePaidConfirmationFragment$app_productionRelease$ToBePaidConfirmationFragmentSubcomponent */
    /* compiled from: FragmentModule_ContributeToBePaidConfirmationFragment$app_productionRelease */
    public interface ToBePaidConfirmationFragmentSubcomponent extends AndroidInjector<ToBePaidConfirmationFragment> {

        @Subcomponent.Builder
        /* renamed from: com.iaai.android.bdt.injection.module.FragmentModule_ContributeToBePaidConfirmationFragment$app_productionRelease$ToBePaidConfirmationFragmentSubcomponent$Builder */
        /* compiled from: FragmentModule_ContributeToBePaidConfirmationFragment$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<ToBePaidConfirmationFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @FragmentKey(ToBePaidConfirmationFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<? extends Fragment> bindAndroidInjectorFactory(ToBePaidConfirmationFragmentSubcomponent.Builder builder);

    private C2885x2d128e2b() {
    }
}
