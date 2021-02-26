package com.iaai.android.bdt.injection.module;

import androidx.fragment.app.Fragment;
import com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList.DeliveryInstructionFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {DeliveryInstructionFragmentSubcomponent.class})
/* renamed from: com.iaai.android.bdt.injection.module.FragmentModule_ContributeDeliveryInstructionFragment$app_productionRelease */
public abstract class C2874x9a4341e6 {

    @Subcomponent
    /* renamed from: com.iaai.android.bdt.injection.module.FragmentModule_ContributeDeliveryInstructionFragment$app_productionRelease$DeliveryInstructionFragmentSubcomponent */
    /* compiled from: FragmentModule_ContributeDeliveryInstructionFragment$app_productionRelease */
    public interface DeliveryInstructionFragmentSubcomponent extends AndroidInjector<DeliveryInstructionFragment> {

        @Subcomponent.Builder
        /* renamed from: com.iaai.android.bdt.injection.module.FragmentModule_ContributeDeliveryInstructionFragment$app_productionRelease$DeliveryInstructionFragmentSubcomponent$Builder */
        /* compiled from: FragmentModule_ContributeDeliveryInstructionFragment$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<DeliveryInstructionFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @FragmentKey(DeliveryInstructionFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<? extends Fragment> bindAndroidInjectorFactory(DeliveryInstructionFragmentSubcomponent.Builder builder);

    private C2874x9a4341e6() {
    }
}
