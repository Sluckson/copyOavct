package com.iaai.android.bdt.injection.module;

import androidx.fragment.app.Fragment;
import com.iaai.android.bdt.feature.account.AccountSettingFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {AccountSettingFragmentSubcomponent.class})
/* renamed from: com.iaai.android.bdt.injection.module.FragmentModule_ContributeAccountSettingFragment$app_productionRelease */
public abstract class C2872x8eb16d2f {

    @Subcomponent
    /* renamed from: com.iaai.android.bdt.injection.module.FragmentModule_ContributeAccountSettingFragment$app_productionRelease$AccountSettingFragmentSubcomponent */
    /* compiled from: FragmentModule_ContributeAccountSettingFragment$app_productionRelease */
    public interface AccountSettingFragmentSubcomponent extends AndroidInjector<AccountSettingFragment> {

        @Subcomponent.Builder
        /* renamed from: com.iaai.android.bdt.injection.module.FragmentModule_ContributeAccountSettingFragment$app_productionRelease$AccountSettingFragmentSubcomponent$Builder */
        /* compiled from: FragmentModule_ContributeAccountSettingFragment$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<AccountSettingFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @FragmentKey(AccountSettingFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<? extends Fragment> bindAndroidInjectorFactory(AccountSettingFragmentSubcomponent.Builder builder);

    private C2872x8eb16d2f() {
    }
}
