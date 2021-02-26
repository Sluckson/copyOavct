package com.iaai.android.bdt.injection.module;

import androidx.fragment.app.Fragment;
import com.iaai.android.bdt.feature.productDetail.ProductDetailFragment;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {ProductDetailFragmentSubcomponent.class})
public abstract class FragmentModule_ContributeProductDetail$app_productionRelease {

    @Subcomponent
    /* compiled from: FragmentModule_ContributeProductDetail$app_productionRelease */
    public interface ProductDetailFragmentSubcomponent extends AndroidInjector<ProductDetailFragment> {

        @Subcomponent.Builder
        /* compiled from: FragmentModule_ContributeProductDetail$app_productionRelease */
        public static abstract class Builder extends AndroidInjector.Builder<ProductDetailFragment> {
        }
    }

    /* access modifiers changed from: package-private */
    @Binds
    @FragmentKey(ProductDetailFragment.class)
    @IntoMap
    public abstract AndroidInjector.Factory<? extends Fragment> bindAndroidInjectorFactory(ProductDetailFragmentSubcomponent.Builder builder);

    private FragmentModule_ContributeProductDetail$app_productionRelease() {
    }
}
