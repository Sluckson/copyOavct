package com.iaai.android.bdt.injection.module;

import androidx.fragment.app.Fragment;
import com.iaai.android.bdt.feature.myAccount.toBePaid.reviewPayment.ToBePaidReviewFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {ToBePaidReviewFragmentSubcomponent.class})
/* renamed from: com.iaai.android.bdt.injection.module.FragmentModule_ContributeToBePaidReviewFragment$app_productionRelease */
public abstract class C2886xfdee3d8e {

    @Subcomponent
    /* renamed from: com.iaai.android.bdt.injection.module.FragmentModule_ContributeToBePaidReviewFragment$app_productionRelease$ToBePaidReviewFragmentSubcomponent */
    /* compiled from: FragmentModule_ContributeToBePaidReviewFragment$app_productionRelease */
    public interface ToBePaidReviewFragmentSubcomponent extends AndroidInjector<ToBePaidReviewFragment> {

        @Subcomponent.Builder
        /* renamed from: com.iaai.android.bdt.injection.module.FragmentModule_ContributeToBePaidReviewFragment$app_productionRelease$ToBePaidReviewFragmentSubcomponent$Builder */
        /* compiled from: FragmentModule_ContributeToBePaidReviewFragment$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<ToBePaidReviewFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @FragmentKey(ToBePaidReviewFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<? extends Fragment> bindAndroidInjectorFactory(ToBePaidReviewFragmentSubcomponent.Builder builder);

    private C2886xfdee3d8e() {
    }
}
