package com.iaai.android.bdt.feature.productDetail;

import androidx.lifecycle.ViewModelProvider;
import com.iaai.android.bdt.feature.login.SessionManager;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class ProductDetailFragment_MembersInjector implements MembersInjector<ProductDetailFragment> {
    private final Provider<SessionManager> sessionManagerProvider;
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public ProductDetailFragment_MembersInjector(Provider<ViewModelProvider.Factory> provider, Provider<SessionManager> provider2) {
        this.viewModelFactoryProvider = provider;
        this.sessionManagerProvider = provider2;
    }

    public static MembersInjector<ProductDetailFragment> create(Provider<ViewModelProvider.Factory> provider, Provider<SessionManager> provider2) {
        return new ProductDetailFragment_MembersInjector(provider, provider2);
    }

    public void injectMembers(ProductDetailFragment productDetailFragment) {
        injectViewModelFactory(productDetailFragment, this.viewModelFactoryProvider.get());
        injectSessionManager(productDetailFragment, this.sessionManagerProvider.get());
    }

    public static void injectViewModelFactory(ProductDetailFragment productDetailFragment, ViewModelProvider.Factory factory) {
        productDetailFragment.viewModelFactory = factory;
    }

    public static void injectSessionManager(ProductDetailFragment productDetailFragment, SessionManager sessionManager) {
        productDetailFragment.sessionManager = sessionManager;
    }
}
