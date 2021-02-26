package com.iaai.android.bdt.injection.module;

import androidx.fragment.app.Fragment;
import com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList.InsertRepOrAddFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {InsertRepOrAddFragmentSubcomponent.class})
/* renamed from: com.iaai.android.bdt.injection.module.FragmentModule_ContributeInsertRepOrAddFragment$app_productionRelease */
public abstract class C2876xa481e86 {

    @Subcomponent
    /* renamed from: com.iaai.android.bdt.injection.module.FragmentModule_ContributeInsertRepOrAddFragment$app_productionRelease$InsertRepOrAddFragmentSubcomponent */
    /* compiled from: FragmentModule_ContributeInsertRepOrAddFragment$app_productionRelease */
    public interface InsertRepOrAddFragmentSubcomponent extends AndroidInjector<InsertRepOrAddFragment> {

        @Subcomponent.Builder
        /* renamed from: com.iaai.android.bdt.injection.module.FragmentModule_ContributeInsertRepOrAddFragment$app_productionRelease$InsertRepOrAddFragmentSubcomponent$Builder */
        /* compiled from: FragmentModule_ContributeInsertRepOrAddFragment$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<InsertRepOrAddFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @FragmentKey(InsertRepOrAddFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<? extends Fragment> bindAndroidInjectorFactory(InsertRepOrAddFragmentSubcomponent.Builder builder);

    private C2876xa481e86() {
    }
}
