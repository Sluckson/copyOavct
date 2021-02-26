package com.iaai.android.bdt.feature.productDetail;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.iaai.android.bdt.base.BaseActivity_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

public final class ProductDetailActivity_MembersInjector implements MembersInjector<ProductDetailActivity> {
    private final Provider<DispatchingAndroidInjector<Fragment>> dispatchingAndroidInjectorProvider;
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public ProductDetailActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<ViewModelProvider.Factory> provider2) {
        this.dispatchingAndroidInjectorProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public static MembersInjector<ProductDetailActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<ViewModelProvider.Factory> provider2) {
        return new ProductDetailActivity_MembersInjector(provider, provider2);
    }

    public void injectMembers(ProductDetailActivity productDetailActivity) {
        BaseActivity_MembersInjector.injectDispatchingAndroidInjector(productDetailActivity, this.dispatchingAndroidInjectorProvider.get());
        injectViewModelFactory(productDetailActivity, this.viewModelFactoryProvider.get());
    }

    public static void injectViewModelFactory(ProductDetailActivity productDetailActivity, ViewModelProvider.Factory factory) {
        productDetailActivity.viewModelFactory = factory;
    }
}
