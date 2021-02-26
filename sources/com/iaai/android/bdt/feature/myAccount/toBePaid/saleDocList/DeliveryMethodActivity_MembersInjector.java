package com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList;

import androidx.lifecycle.ViewModelProvider;
import com.iaai.android.bdt.feature.login.SessionManager;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class DeliveryMethodActivity_MembersInjector implements MembersInjector<DeliveryMethodActivity> {
    private final Provider<SessionManager> sessionManagerProvider;
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public DeliveryMethodActivity_MembersInjector(Provider<ViewModelProvider.Factory> provider, Provider<SessionManager> provider2) {
        this.viewModelFactoryProvider = provider;
        this.sessionManagerProvider = provider2;
    }

    public static MembersInjector<DeliveryMethodActivity> create(Provider<ViewModelProvider.Factory> provider, Provider<SessionManager> provider2) {
        return new DeliveryMethodActivity_MembersInjector(provider, provider2);
    }

    public void injectMembers(DeliveryMethodActivity deliveryMethodActivity) {
        injectViewModelFactory(deliveryMethodActivity, this.viewModelFactoryProvider.get());
        injectSessionManager(deliveryMethodActivity, this.sessionManagerProvider.get());
    }

    public static void injectViewModelFactory(DeliveryMethodActivity deliveryMethodActivity, ViewModelProvider.Factory factory) {
        deliveryMethodActivity.viewModelFactory = factory;
    }

    public static void injectSessionManager(DeliveryMethodActivity deliveryMethodActivity, SessionManager sessionManager) {
        deliveryMethodActivity.sessionManager = sessionManager;
    }
}
