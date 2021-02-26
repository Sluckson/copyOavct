package com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList;

import androidx.lifecycle.ViewModelProvider;
import com.iaai.android.bdt.feature.login.SessionManager;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class DeliveryInstructionFragment_MembersInjector implements MembersInjector<DeliveryInstructionFragment> {
    private final Provider<SessionManager> sessionManagerProvider;
    private final Provider<ViewModelProvider.Factory> viewModelFactoryProvider;

    public DeliveryInstructionFragment_MembersInjector(Provider<SessionManager> provider, Provider<ViewModelProvider.Factory> provider2) {
        this.sessionManagerProvider = provider;
        this.viewModelFactoryProvider = provider2;
    }

    public static MembersInjector<DeliveryInstructionFragment> create(Provider<SessionManager> provider, Provider<ViewModelProvider.Factory> provider2) {
        return new DeliveryInstructionFragment_MembersInjector(provider, provider2);
    }

    public void injectMembers(DeliveryInstructionFragment deliveryInstructionFragment) {
        injectSessionManager(deliveryInstructionFragment, this.sessionManagerProvider.get());
        injectViewModelFactory(deliveryInstructionFragment, this.viewModelFactoryProvider.get());
    }

    public static void injectSessionManager(DeliveryInstructionFragment deliveryInstructionFragment, SessionManager sessionManager) {
        deliveryInstructionFragment.sessionManager = sessionManager;
    }

    public static void injectViewModelFactory(DeliveryInstructionFragment deliveryInstructionFragment, ViewModelProvider.Factory factory) {
        deliveryInstructionFragment.viewModelFactory = factory;
    }
}
